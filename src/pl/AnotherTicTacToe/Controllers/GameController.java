package pl.AnotherTicTacToe.Controllers;

import pl.AnotherTicTacToe.Views.DefaultView;
import pl.AnotherTicTacToe.Views.IView;
import pl.AnotherTicTacToe.Models.IGameBoard;
import pl.AnotherTicTacToe.Models.IPlayerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import pl.AnotherTicTacToe.Models.DefaultPlayerStatus;
import pl.AnotherTicTacToe.Models.GameBoard;

public class GameController {
	private IView GameView;
	private IGameBoard Board;
	private ArrayList<IPlayerStatus> Players;
	private boolean isEndgame;
	private Scanner playerChoiceReader;
	private String WinnersName;

	public GameController() {
		this.GameView = new DefaultView();
		this.Players = new ArrayList<IPlayerStatus>();
		this.Board = new GameBoard();
		this.playerChoiceReader = new Scanner(System.in);
		this.isEndgame = false;
		this.WinnersName = "";
		this.Players.add(new DefaultPlayerStatus("First", "X"));
		this.Players.add(new DefaultPlayerStatus("Sec", "O"));
	}

	public void GameLoop() {

		this.setUpBoard();
		this.chooseWhoStarts();

		while (!this.isEndGame()) {
			this.GameView.showNextPlayer(this.Players);
			this.GameView.showBoard(this.Board.getBoard());

			int playerChoice = this.playerChoiceReader.nextInt();
			if (!this.Board.isNumAvailable(playerChoice)) {
				do {
					System.out.println("Choose cell that was't already marked!");
					playerChoice = this.playerChoiceReader.nextInt();
				} while (!this.Board.isNumAvailable(playerChoice));
			}

			this.Board.filterOutAvailableNums(playerChoice);

			String playerSign = this.Players.stream().filter(status -> status.getCurrentPlayer())
					.map(status -> status.GetPlayerSymbol()).collect(Collectors.joining());
			this.updateBoard(playerChoice, playerSign);

			this.checkIfGameEnded();
			this.changePlayer();
		}

		this.GameView.showTheWinner(this.WinnersName);
		this.GameView.showBoard(this.Board.getBoard());
	}

	private void changePlayer() {
		this.Players.forEach(player -> player.setCurrentPlayer(!player.getCurrentPlayer()));
	}

	private void checkIfGameEnded() {
		boolean hasMatch = false;

		for (int j = 0; j < this.Board.getSize(); j++) {
			hasMatch = hasMatch || (this.Board.getBoardCell(0, j).equals(this.Board.getBoardCell(1, j))
					&& this.Board.getBoardCell(1, j).equals(this.Board.getBoardCell(2, j)));
		}

		for (int i = 0; i < this.Board.getSize(); i++) {
			hasMatch = hasMatch || (this.Board.getBoardCell(i, 0).equals(this.Board.getBoardCell(i, 1))
					&& this.Board.getBoardCell(i, 1).equals(this.Board.getBoardCell(i, 2)));
		}

		hasMatch = hasMatch || (this.Board.getBoardCell(0, 0).equals(this.Board.getBoardCell(1, 1))
				&& this.Board.getBoardCell(1, 1).equals(this.Board.getBoardCell(2, 2)));
		hasMatch = hasMatch || (this.Board.getBoardCell(0, 2).equals(this.Board.getBoardCell(1, 1))
				&& this.Board.getBoardCell(1, 1).equals(this.Board.getBoardCell(2, 0)));

		if (hasMatch || !this.Board.isAnyNumAvailable()) {
			this.isEndgame = true;
		}

		if (hasMatch && this.Board.isAnyNumAvailable()) {
			this.WinnersName = this.Players.stream().filter(status -> status.getCurrentPlayer())
					.map(status -> status.GetPlayerName()).collect(Collectors.joining());
		}
	}

	private void chooseWhoStarts() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

		for (int i = 0; i < this.Players.size(); i++) {
			IPlayerStatus tmpPlayer = this.Players.get(i);
			if (randomNum == i) {
				tmpPlayer.setCurrentPlayer(true);
			} else {
				tmpPlayer.setCurrentPlayer(false);
			}

			this.Players.set(i, tmpPlayer);
		}
	}

	private void updateBoard(int playerChoice, String playerSign) {
		Map<String, Integer> cellCoordsToUpdate = this.Board.getCoords(playerChoice);
		int xCoord = cellCoordsToUpdate.get("x");
		int yCoord = cellCoordsToUpdate.get("y");
		this.Board.setBoardCell(xCoord, yCoord, playerSign);
	}

	private void setUpBoard() {
		int counter = 1;
		for (int j = 0; j < this.Board.getSize(); j++) {
			for (int i = 0; i < this.Board.getSize(); i++) {
				this.Board.setBoardCell(i, j, String.valueOf(counter));

				HashMap<String, Integer> mapToPutIntoCoords = new HashMap<String, Integer>();
				mapToPutIntoCoords.put("x", i);
				mapToPutIntoCoords.put("y", j);
				this.Board.addNumCoord(counter, mapToPutIntoCoords);

				this.Board.addAvailableNum(counter);
				counter++;
			}
		}
	}

	private boolean isEndGame() {
		return this.isEndgame;
	}
}
