package pl.AnotherTicTacToe.Controllers;

import pl.AnotherTicTacToe.Views.DefaultView;
import pl.AnotherTicTacToe.Views.IView;
import pl.AnotherTicTacToe.Models.IGameBoard;
import pl.AnotherTicTacToe.Models.GameBoard;

public class GameController {
	private IView GameView;
	private IGameBoard Board;
	
	public GameController(){
		this.GameView = new DefaultView();
		this.Board = new GameBoard();
	}
}
