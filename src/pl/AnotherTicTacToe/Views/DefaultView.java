package pl.AnotherTicTacToe.Views;

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

	
}
