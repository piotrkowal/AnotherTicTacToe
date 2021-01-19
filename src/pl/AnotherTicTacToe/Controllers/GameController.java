package pl.AnotherTicTacToe.Controllers;

import pl.AnotherTicTacToe.Models.IGameBoard;
import pl.AnotherTicTacToe.Models.GameBoard;

public class GameController {
	private IGameBoard Board;
	
	public GameController(){
		this.Board = new GameBoard();
	}
}
