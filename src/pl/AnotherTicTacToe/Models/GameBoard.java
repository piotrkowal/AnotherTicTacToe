package pl.AnotherTicTacToe.Models;

import java.util.List;
import java.util.stream.Collectors;

public class GameBoard implements IGameBoard {
	private int size;
	private String[][] gameBoard;
	private List<Integer> availableNums;

	public GameBoard() {
		this.size = 3;
		this.gameBoard = new String[size][size];

	}

	public void addAvaiableNum(int newNumber) {
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

}
