package com.vimsnake.entities;

import java.util.Random;

import com.vimsnake.util.Direction;
import com.vimsnake.util.NodeStatus;
import com.vimsnake.util.Properties;

// 网格
public class Grid {
	private final int width;
	private final int height;
	private Snake snake;
	private Direction direction;
	private EntityNode food = null;
	private Node[][] status;

	// 构造
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.direction = Direction.RIGHT;
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

		status[x][y].setNodeStatus(NodeStatus.FOOD);
		// 将旧的食物节点状态设为EMPTY
		if (food != null) {
			status[food.getX()][food.getY()].setNodeStatus(NodeStatus.EMPTY);
		}

		food = new EntityNode(x, y);
	}

	// 下一步
	public boolean nextRound() {
		switch (direction) {
		case UP:
			if (snake.getHead().getY() - 1 >= Properties.HEIGTH || snake.getHead().getY() - 1 < 0) {
				// 超界
				return false;
			} else if (status[snake.getHead().getX()][snake.getHead().getY() - 1].getNodeStatus() == NodeStatus.SNAKE) {
				// 碰到蛇体
				return false;
			} else if (status[snake.getHead().getX()][snake.getHead().getY() - 1].getNodeStatus() == NodeStatus.EMPTY) {
				// 行进一格
				status[snake.getHead().getX()][snake.getHead().getY() - 1].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX(), snake.getHead().getY() - 1);
				status[snake.getTail().getX()][snake.getTail().getY()].setNodeStatus(NodeStatus.EMPTY);
				snake.removeTail();
			} else if (status[snake.getHead().getX()][snake.getHead().getY() - 1].getNodeStatus() == NodeStatus.FOOD) {
				// 行进并吃到食物
				status[snake.getHead().getX()][snake.getHead().getY() - 1].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX(), snake.getHead().getY() - 1);
				createFood();
			}
			break;
		case DOWN:
			if (snake.getHead().getY() + 1 >= Properties.HEIGTH || snake.getHead().getY() + 1 < 0) {
				return false;
			} else if (status[snake.getHead().getX()][snake.getHead().getY() + 1].getNodeStatus() == NodeStatus.SNAKE) {
				return false;
			} else if (status[snake.getHead().getX()][snake.getHead().getY() + 1].getNodeStatus() == NodeStatus.EMPTY) {
				status[snake.getHead().getX()][snake.getHead().getY() + 1].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX(), snake.getHead().getY() + 1);
				status[snake.getTail().getX()][snake.getTail().getY()].setNodeStatus(NodeStatus.EMPTY);
				snake.removeTail();
			} else if (status[snake.getHead().getX()][snake.getHead().getY() + 1].getNodeStatus() == NodeStatus.FOOD) {
				status[snake.getHead().getX()][snake.getHead().getY() + 1].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX(), snake.getHead().getY() + 1);
				createFood();
			}
			break;
		case LEFT:
			if (snake.getHead().getX() - 1 >= Properties.WIDTH || snake.getHead().getX() - 1 < 0) {
				return false;
			} else if (status[snake.getHead().getX() - 1][snake.getHead().getY()].getNodeStatus() == NodeStatus.SNAKE) {
				return false;
			} else if (status[snake.getHead().getX() - 1][snake.getHead().getY()].getNodeStatus() == NodeStatus.EMPTY) {
				status[snake.getHead().getX() - 1][snake.getHead().getY()].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX() - 1, snake.getHead().getY());
				status[snake.getTail().getX()][snake.getTail().getY()].setNodeStatus(NodeStatus.EMPTY);
				snake.removeTail();
			} else if (status[snake.getHead().getX() - 1][snake.getHead().getY()].getNodeStatus() == NodeStatus.FOOD) {
				status[snake.getHead().getX() - 1][snake.getHead().getY()].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX() - 1, snake.getHead().getY());
				createFood();
			}
			break;
		case RIGHT:
			if (snake.getHead().getX() + 1 >= Properties.HEIGTH || snake.getHead().getX() + 1 < 0) {
				return false;
			} else if (status[snake.getHead().getX() + 1][snake.getHead().getY()].getNodeStatus() == NodeStatus.SNAKE) {
				return false;
			} else if (status[snake.getHead().getX() + 1][snake.getHead().getY()].getNodeStatus() == NodeStatus.EMPTY) {
				status[snake.getHead().getX() + 1][snake.getHead().getY()].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX() + 1, snake.getHead().getY());
				status[snake.getTail().getX()][snake.getTail().getY()].setNodeStatus(NodeStatus.EMPTY);
				snake.removeTail();
			} else if (status[snake.getHead().getX() + 1][snake.getHead().getY()].getNodeStatus() == NodeStatus.FOOD) {
				status[snake.getHead().getX() + 1][snake.getHead().getY()].setNodeStatus(NodeStatus.SNAKE);
				snake.addHead(snake.getHead().getX() + 1, snake.getHead().getY());
				createFood();
			}
			break;
		}
		return true;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
