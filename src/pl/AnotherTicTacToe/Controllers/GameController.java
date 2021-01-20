package pl.AnotherTicTacToe.Controllers;

import pl.AnotherTicTacToe.Views.DefaultView;
import pl.AnotherTicTacToe.Views.IView;
import pl.AnotherTicTacToe.Models.IGameBoard;
import pl.AnotherTicTacToe.Models.IPlayerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pl.AnotherTicTacToe.Models.DefaultPlayerStatus;
import pl.AnotherTicTacToe.Models.GameBoard;

public class GameController {
	private IView GameView;
	private IGameBoard Board;
	private ArrayList<IPlayerStatus> Players;
	private boolean isEndgame;
	private Scanner playerChoiceReader;

	public GameController() {
		this.GameView = new DefaultView();
		this.Players = new ArrayList<IPlayerStatus>();
		this.Board = new GameBoard();
		this.playerChoiceReader = new Scanner(System.in);
		this.isEndgame = false;

		this.Players.add(new DefaultPlayerStatus("First"));
		this.Players.add(new DefaultPlayerStatus("Sec", "O"));
	}

	public void GameLoop() {

		this.setUpBoard();

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
			this.isEndgame = true;
		}

		this.GameView.showBoard(this.Board.getBoard());

	}

	private void updateBoard(int playerChoice, IPlayerStatus playerStatus) {
		Map<String, Integer> cellCoordsToUpdate = this.Board.getCoords(playerChoice);
		int xCoord = cellCoordsToUpdate.get("x");
		int yCoord = cellCoordsToUpdate.get("y");
		this.Board.setBoardCell(xCoord, yCoord, playerStatus.GetPlayerSymbol());
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
