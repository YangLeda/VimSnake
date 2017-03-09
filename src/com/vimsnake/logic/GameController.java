package com.vimsnake.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.vimsnake.entities.Grid;
import com.vimsnake.util.Direction;
import com.vimsnake.util.Properties;

// 线程控制每隔一段时间步进；键盘按键监听器
public class GameController implements KeyListener, Runnable {
	private Grid grid;
	private GameView gameView;
	private boolean isSurviving = true;

	public GameController(Grid grid, GameView gameView) {
		this.grid = grid;
		this.gameView = gameView;
	}

	@Override
	public void run() {
		while (isSurviving) {
			try {
				Thread.sleep(Properties.SLEEPTIME);
			} catch (InterruptedException e) {
			}
			// 无限循环步进并刷新屏幕
			if (grid.nextRound() == true) {
				gameView.draw();
			} else {
				// 游戏结束
				System.out.println("Game over！");
				isSurviving = false;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (isSurviving == false) {
			return;
		}

		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (grid.getDirection() == Direction.LEFT || grid.getDirection() == Direction.RIGHT) {
				grid.setDirection(Direction.UP);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (grid.getDirection() == Direction.LEFT || grid.getDirection() == Direction.RIGHT) {
				grid.setDirection(Direction.DOWN);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (grid.getDirection() == Direction.UP || grid.getDirection() == Direction.DOWN) {
				grid.setDirection(Direction.LEFT);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (grid.getDirection() == Direction.UP || grid.getDirection() == Direction.DOWN) {
				grid.setDirection(Direction.RIGHT);
			}
			break;
		}

		// 按键则步进并刷新屏幕
		if (grid.nextRound() == true) {
			gameView.draw();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
