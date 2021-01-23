package br.com.rogerio.snake.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import br.com.rogerio.snake.scene.Snake;
import br.com.rogerio.snake.util.Constants;
import br.com.rogerio.snake.util.GameUtils;

public class Food extends Rect{
	
	private int eatenTimes; // Score game
	
	// construtor na comida
	public Food(Snake snake, Rectangle drawingArea) {	
		setColor(Color.GREEN);
		setDimension(new Dimension(Constants.FOOD_SIZE, Constants.FOOD_SIZE));
		setRandomLocation(snake, drawingArea);
	}
	
	// gera posição randômica dentro da área do jogo, sem colidir com a snake e com um offset das margens
	public void setRandomLocation(Snake snake, Rectangle drawindArea) {
		int offset = 3;
		
		// o do..while verifica se há intersecção entre a comida gerada e os retângulos da snake
		do {
			int minX = (int) (drawindArea.getMinX() + offset);
			int minY = (int) (drawindArea.getMinY() + offset);
			
			int maxX = (int) (drawindArea.getMaxX() - Constants.FOOD_SIZE - offset);
			int maxY = (int) (drawindArea.getMaxY() - Constants.FOOD_SIZE -  offset);
			
			int randomX = GameUtils.random(minX, maxX);
			int randomY = GameUtils.random(minY, maxY);
			
			setLocation(new Point(randomX, randomY));
			
		}while(snake.intersects(this));		
	}
	
	// verifica se a snake alimentou, colide com a comida
	public void checkIfEaten(Snake snake, Rectangle drawingArea) {
		if (snake.intersects(this)) {
			eatenTimes++;
			setRandomLocation(snake, drawingArea);
			snake.elongate();
		}
	}
	
	//retorna o nosso Score
	public int getEatenTimes() {
		return eatenTimes;
	}

}
