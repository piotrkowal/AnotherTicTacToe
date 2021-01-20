package pl.AnotherTicTacToe.Controllers;

import pl.AnotherTicTacToe.Views.DefaultView;
import pl.AnotherTicTacToe.Views.IView;
import pl.AnotherTicTacToe.Models.IGameBoard;
import pl.AnotherTicTacToe.Models.IPlayerStatus;

import java.util.ArrayList;
import java.util.HashMap;

import pl.AnotherTicTacToe.Models.GameBoard;

public class GameController {
	private IView GameView;
	private IGameBoard Board;
	private ArrayList<IPlayerStatus> Players;

	public GameController() {
		this.GameView = new DefaultView();
		this.Players = new ArrayList<IPlayerStatus>();
		this.Board = new GameBoard();
	}

	public void GameLoop() {
		System.out.println("Gameloop");

		while (!this.isEndGame()) {

		}
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
		return true;
	}
}
