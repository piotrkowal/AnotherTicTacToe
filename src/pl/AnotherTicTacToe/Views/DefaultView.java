package pl.AnotherTicTacToe.Views;

import java.util.List;
import java.util.stream.Collectors;

import pl.AnotherTicTacToe.Models.IPlayerStatus;

public class DefaultView implements IView{

	@Override
	public void showBoard(String[][] gameBoard) {
		int boardSize = gameBoard.length;
		for (int j = 0; j < boardSize; j++) {
			for (int i = 0; i < boardSize; i++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println("");
		}	
	}

	@Override
	public void showNextPlayer(List<IPlayerStatus> players) {
		String nextPlayer = players.stream().filter(status -> status.getCurrentPlayer()).map(status -> status.GetPlayerName())
				.collect(Collectors.joining());
		System.out.println(nextPlayer+"'s turn!");
	}

	@Override
	public void showTheWinner(String winnersName) {
		if(winnersName.length()<1) {
			System.out.println("All cells have been marked; No one wins!");
		} else {
			System.out.println("Player " + winnersName + " wins!");
		}
	}
}
