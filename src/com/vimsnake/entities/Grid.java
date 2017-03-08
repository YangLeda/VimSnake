package com.vimsnake.entities;

import java.util.Random;

import com.vimsnake.util.NodeStatus;
import com.vimsnake.util.Properties;

// 网格
public class Grid {
	private final int width;
	private final int height;
	private Snake snake;
	private EntityNode food;
	private Node[][] status;

	// 构造
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		// 初始化所有网格节点
		status = new Node[width][height];
		for (int i = 0; i < Properties.WIDTH; ++i) {
			for (int j = 0; j < Properties.HEIGTH; ++j) {
				status[i][j] = new Node();
			}
		}

		initSnake();
		createFood();
	}

	private void initSnake() {
		snake = new Snake();
		for (int i = 0; i < width / 5; ++i) {
			snake.addTail(width / 3 - i, height / 2);
			status[width / 3 - i][height / 2].setNodeStatus(NodeStatus.SNAKE);
		}
	}

	// 待改进算法：当网格中空余节点少时，需要多次循环，影响效率
	public void createFood() {
		int x;
		int y;
		Random rand = new Random();
		do {
			x = rand.nextInt(Properties.WIDTH);
			y = rand.nextInt(Properties.HEIGTH);
		} while (status[x][y].getNodeStatus() != NodeStatus.EMPTY);

		food = new EntityNode(x, y);
		status[x][y].setNodeStatus(NodeStatus.FOOD);
	}

	public Snake getSnake() {
		return snake;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityNode getFood() {
		return food;
	}

	public NodeStatus checkNodeStatus(int x, int y) {
		return this.status[x][y].getNodeStatus();
	}

}
