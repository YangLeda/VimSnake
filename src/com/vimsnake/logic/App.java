package com.vimsnake.logic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.vimsnake.entities.Grid;
import com.vimsnake.util.Properties;

// 窗体
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.init();

	}

	private void init() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame window = new JFrame("VimSnake");
				window.setResizable(false);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Grid grid = new Grid(Properties.HEIGTH, Properties.WIDTH);

				GameView gameView = new GameView(grid);
				gameView.init();
				gameView.getCanvas().setPreferredSize(
						new Dimension(Properties.WIDTH * Properties.UNIT, Properties.HEIGTH * Properties.UNIT));

				window.getContentPane().add(gameView.getCanvas(), BorderLayout.CENTER);
				window.pack();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
	}

}
