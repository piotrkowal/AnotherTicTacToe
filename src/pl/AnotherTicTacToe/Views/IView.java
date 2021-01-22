package pl.AnotherTicTacToe.Views;

import java.util.List;

import pl.AnotherTicTacToe.Models.IPlayerStatus;

public interface IView {

	void showBoard(String[][] gameBoard);

	void showNextPlayer(List<IPlayerStatus> players);

	void showTheWinner(String winnersName);
}
