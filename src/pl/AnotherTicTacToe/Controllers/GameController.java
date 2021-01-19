package pl.AnotherTicTacToe.Controllers;

import pl.AnotherTicTacToe.Views.DefaultView;
import pl.AnotherTicTacToe.Views.IView;
import pl.AnotherTicTacToe.Models.IGameBoard;
import pl.AnotherTicTacToe.Models.IPlayerStatus;

import java.util.ArrayList;

import pl.AnotherTicTacToe.Models.GameBoard;

public class GameController {
	private IView GameView;
	private IGameBoard Board;
	private ArrayList<IPlayerStatus> Players;
	
	public GameController(){
		this.GameView = new DefaultView();
		this.Players = new ArrayList<IPlayerStatus>();
		this.Board = new GameBoard();
	}
}
