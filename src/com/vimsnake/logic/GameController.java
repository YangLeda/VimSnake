package com.vimsnake.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.vimsnake.entities.Grid;
import com.vimsnake.util.Direction;
import com.vimsnake.util.Properties;

public class GameController implements KeyListener, Runnable {
	private Grid grid;
	private GameView gameView;

	public GameController(Grid grid, GameView gameView) {
		this.grid = grid;
		this.gameView = gameView;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(Properties.SLEEPTIME);
			} catch (InterruptedException e) {
				break;
			}
			
			grid.nextRound();
			gameView.draw();
			System.out.println("1");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			grid.setDirection(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			grid.setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			grid.setDirection(Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			grid.setDirection(Direction.RIGHT);
			break;
		}
		
//		grid.nextRound();
//		gameView.draw();
//		System.out.println("draw on keypress");
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
