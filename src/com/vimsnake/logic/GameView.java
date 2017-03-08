package com.vimsnake.logic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.vimsnake.entities.EntityNode;
import com.vimsnake.entities.Grid;
import com.vimsnake.entities.Snake;
import com.vimsnake.util.Properties;

// 绘图
public class GameView {
	private Grid grid;
	// 画布
	private JPanel canvas;

	// 构造
	public GameView(Grid grid) {
		this.grid = grid;
	}

	public void init() {
		canvas = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics graphics) {
				drawGridBackground(graphics);
				drawSnake(graphics, grid.getSnake());
				drawFood(graphics, grid.getFood());
			}
		};
	}

	protected void drawGridBackground(Graphics graphics) {
		graphics.setColor(Color.GRAY);
		graphics.fillRect(0, 0, Properties.WIDTH * Properties.UNIT, Properties.HEIGTH * Properties.UNIT);
	}
	
	protected void drawFood(Graphics graphics, EntityNode food) {
		graphics.setColor(Color.RED);
		graphics.fillRect(food.getX() * Properties.UNIT, food.getY() * Properties.UNIT, Properties.UNIT, Properties.UNIT);
	}

	protected void drawSnake(Graphics graphics, Snake snake) {
		graphics.setColor(Color.BLACK);
		for(EntityNode n:snake.getBody()){
			graphics.fillRect(n.getX() * Properties.UNIT, n.getY() * Properties.UNIT, Properties.UNIT, Properties.UNIT);
		}		
	}



	public void draw() {
		canvas.repaint();
	}

	public JPanel getCanvas() {
		return canvas;
	}

}
