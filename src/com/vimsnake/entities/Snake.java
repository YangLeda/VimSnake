package com.vimsnake.entities;

import java.util.LinkedList;

// 整条蛇
public class Snake {
	private LinkedList<EntityNode> body;

	public Snake() {
		body = new LinkedList<EntityNode>();

	}

	public void addTail(int x, int y) {
		body.add(new EntityNode(x, y));
	}

	public EntityNode getHead(){
		return body.getFirst();
	}
	
	public void addHead(int x, int y){
		body.addFirst(new EntityNode(x, y));
	}
	
	public LinkedList<EntityNode> getBody() {
		return body;
	}

}
