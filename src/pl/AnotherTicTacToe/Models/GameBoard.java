package pl.AnotherTicTacToe.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameBoard implements IGameBoard {
	private int size;
	private String[][] gameBoard;
	private List<Integer> availableNums;
	private Map<Integer, Map<String, Integer>> coordsOfNum;

	public GameBoard() {
		this.size = 3;
		this.gameBoard = new String[size][size];
		this.coordsOfNum = new HashMap<Integer, Map<String, Integer>>();
	}

	public int getSize() {
		return this.size;
	}

	public void addAvailableNum(int newNumber) {
		this.availableNums.add(newNumber);
	}

	public List<Integer> getAvailableNums() {
		return this.availableNums;
	}

	public boolean isNumAvailable(int num) {
		return this.availableNums.indexOf(num) == -1;
	}

	public boolean isAnyNumAvailable() {
		return !this.availableNums.isEmpty();
	}

	public void filterOutAvailableNums(int numToFilterOut) {
		this.availableNums = this.availableNums.stream().filter(num -> num != numToFilterOut)
				.collect(Collectors.toList());
	}

	public void setBoardCell(int x, int y, String value) {
		this.gameBoard[x][y] = value;
	}

	public void addNumCoord(int number, Map<String, Integer> coordsToAdd) {
		this.coordsOfNum.put(number, coordsToAdd);
	}

}
