package com.vimsnake.entities;

// 组成蛇身体的节点或食物
public class EntityNode {
	private int x;
	private int y;

	public EntityNode(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
