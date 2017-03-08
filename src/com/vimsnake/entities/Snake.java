package com.vimsnake.entities;

import java.util.LinkedList;

import com.vimsnake.util.Direction;

// 整条蛇
public class Snake {
	private Direction direction;
	private LinkedList<EntityNode> body;

	public Snake() {
		direction = Direction.RIGHT;
		body = new LinkedList<EntityNode>();

	}

	public void addTail(int x, int y) {
		body.add(new EntityNode(x, y));
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public LinkedList<EntityNode> getBody() {
		return body;
	}

}
