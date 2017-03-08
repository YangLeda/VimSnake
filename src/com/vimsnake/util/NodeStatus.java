package com.vimsnake.util;

public enum NodeStatus {
	EMPTY(0), FOOD(1), SNAKE(2);

	private final int nodeStatusCode;

	NodeStatus(int nodeStatusCode) {
		this.nodeStatusCode = nodeStatusCode;
	}

	public int getNodeStatusCode() {
		return nodeStatusCode;
	}
}
