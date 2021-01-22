package pl.AnotherTicTacToe;

import pl.AnotherTicTacToe.Controllers.GameController;

public class TicTacToeStartingPoint {

	public static void main(String[] args) {
		GameController newGame = new GameController();
		newGame.GameLoop();
	}

}
