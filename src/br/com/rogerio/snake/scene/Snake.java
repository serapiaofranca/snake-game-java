package br.com.rogerio.snake.scene;

import java.awt.Dimension;
import java.awt.Point;

import br.com.rogerio.snake.core.Direction;
import br.com.rogerio.snake.graphics.Rect;
import br.com.rogerio.snake.graphics.Shape;
import br.com.rogerio.snake.util.Constants;
import br.com.rogerio.snake.util.GameUtils;

public class Snake extends Shape {
	
	private Direction direction;

	public Snake() {
		super(Constants.SNAKE_COLOR);
		direction = Direction.NONE;  // ao iniciar o jogo, não se movimenta, fica parada até ser acionada uma direção
		
		Point location = new Point(Constants.SNAKE_START_X, Constants.SNAKE_START_Y);
		Dimension dimension = new Dimension(Constants.SNAKE_PEACE_SIZE, Constants.SNAKE_PEACE_SIZE);
		Rect rect = new Rect(location, dimension);
		addRect(rect);
		
		for(int i=1; i<Constants.SNAKE_INITIAL_SIZE; i++) {
			rect = duplicateRect(rect, Direction.LEFT);
			addRect(rect);
		}
	}
	
	public void move() {
		if(direction != Direction.NONE) {
			
			Rect head = getFirstRect();
// 			Rect tail = getLastRect();
			
			GameUtils.moveRects(getRects());  // movimentação o atual passa a ser o anterior
			
			Rect newHead = duplicateRect(head, direction);
			getRects().set(0, newHead);
						
		}
		
	}
	
	// metodo para alongar a snake ao se alimentar 
	public void elongate(){
		
	}
	
	public synchronized void left() {
		if(direction.canChangeTo(Direction.LEFT)) {
			direction = Direction.LEFT;
		}
	}
	
	public synchronized void right() {
		if(direction.canChangeTo(Direction.RIGHT)) {
			direction = Direction.RIGHT;
		}
		
	}
	
	public synchronized void up() {
		if(direction.canChangeTo(Direction.UP)) {
			direction = Direction.UP;
		}
		
	}
	
	public synchronized void down() {
		if(direction.canChangeTo(Direction.DOWN)) {
			direction = Direction.DOWN;
		}
		
	}
	
	// verifica se head colide com outras partes menos ela
	public boolean collideWithItself() {
		Rect head = getFirstRect();
		
		for(int i=1; i < getRects().size(); i++ ) {
			if(head.intersects(getRects().get(i))) {
				return true;
			}
			
		}
		
		return false;
	}
	

}
