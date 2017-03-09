package com.vimsnake.util;

public enum Direction {
	UP(1), DOWN(3), LEFT(4), RIGHT(2);

	private final int directionCode;

	Direction(int directionCode) {
		this.directionCode = directionCode;
	}

	public int geDirectionCode() {
		return directionCode;
	}
}
