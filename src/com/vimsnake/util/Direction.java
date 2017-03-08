package com.vimsnake.util;

public enum Direction {
	UP(1), DOWN(2), LEFT(3), RIGHT(4);

	private final int directionCode;

	Direction(int directionCode) {
		this.directionCode = directionCode;
	}

	public int geDirectionCode() {
		return directionCode;
	}
}
