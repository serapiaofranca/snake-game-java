package br.com.rogerio.snake.util;

import java.awt.Color;
import java.awt.Point;

public class Constants {
	
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGTH = 500;
	public static final String WINDOW_TITLE = "Snake Game";
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	
	public static final Color SNAKE_COLOR = Color.WHITE;
	public static final int SNAKE_START_X = 200;
	public static final int SNAKE_START_Y = 200;
	public static final int SNAKE_PEACE_SIZE = 5;
	public static final int SNAKE_INITIAL_SIZE = 40;
	
	public static final int FOOD_SIZE = 5;
	
	public static final int SLEEP_TIME = 30;
	
	public static final String GAMEOVER_TEXT = "Game Over!  %d Ponto(s)";
	public static final Color GAMEOVER_COLOR = Color.RED;
	public static final Point GAMEOVER_LOCATION = new Point(WINDOW_WIDTH /2 -90, WINDOW_HEIGTH / 2); 
	public static final int SLEEP_GAMEOVERTIME = 5000;

}
