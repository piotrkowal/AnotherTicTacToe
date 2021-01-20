package pl.AnotherTicTacToe.Models;

import java.util.Map;

public interface IGameBoard {

	int getSize();

	void setBoardCell(int i, int j, String valueOf);

	void addNumCoord(int number, Map<String, Integer> coordsToAdd);

	void addAvailableNum(int newNumber);

	String[][] getBoard();

	boolean isNumAvailable(int num);

	void filterOutAvailableNums(int numToFilterOut);

	 Map<String, Integer> getCoords(int num);
}
