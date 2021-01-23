package br.com.rogerio.snake.core;

import java.awt.Rectangle;

import br.com.rogerio.snake.graphics.Food;
import br.com.rogerio.snake.graphics.Rect;
import br.com.rogerio.snake.graphics.Renderer;
import br.com.rogerio.snake.scene.Background;
import br.com.rogerio.snake.scene.GameOverText;
import br.com.rogerio.snake.scene.Snake;
import br.com.rogerio.snake.util.Constants;
import br.com.rogerio.snake.util.GameUtils;


public class Game implements Runnable {
	private GameWindow gameWindow;
	private Renderer renderer;
	private Snake snake;
	private Food food;
	
	public void start() {
		
		snake = new Snake();
		gameWindow = new GameWindow(snake);
		renderer = gameWindow.getRenderer();
		food = new Food(snake, gameWindow.getDrawingArea());
				
		addElementToScreen();
		
		// separando a "thread" de execução do loop do jogo, da que cuida dos graficos
//		Thread t = new Thread(this);
//		t.start();
		new Thread(this).start();;
	}
	
	public void addElementToScreen() {		
		renderer.add(new Background());
		renderer.add(snake);
		renderer.add(food);
	}
	
	@Override
	public void run() {
		do {
			
			gameWindow.repaint(); // repaint: fica desenhando, renderiza a tela, força o redesenho
			
			snake.move();  // movimentar na tela
			
			food.checkIfEaten(snake, gameWindow.getDrawingArea()); // detecta se snake alimentou-se 
			
			GameUtils.sleep(Constants.SLEEP_TIME);  // metodo static da classe GameUtils
			
		}while(!isGameOver());		
		
//		System.exit(0);
//		gameWindow.dispose();  // fecha a janela ao encerrar 
		
		processGameOver();
		
	}
	
	private boolean isGameOver() {
		return snake.collideWithItself() || isSnakeHitBounds();
	}
	
	public void processGameOver() {
		
		// primeiro remover os intens snake e food
		renderer.remove(snake);
		renderer.remove(food);
		
		//chama o render para criar a imagem do gameOver
		renderer.add(new GameOverText(food.getEatenTimes()));
		
		// apos criada a imagem, desenha na tela
		gameWindow.repaint();
		
		// aguarda e fecha a janela
		GameUtils.sleep(Constants.SLEEP_GAMEOVERTIME);
		
		gameWindow.dispose();  // fecha a janela ao encerrar
	}
	
	private boolean isSnakeHitBounds() {
		Rect head = snake.getFirstRect();
		Rectangle drawingArea = gameWindow.getDrawingArea();

		// implementação para colisão nos limites da tela
		int headX= (int) head.getLocation().getX();
		int headY= (int) head.getLocation().getY();
		
		int areaX1 = (int) drawingArea.getMinX();
		int areaY1 = (int) drawingArea.getMinY() - Constants.SNAKE_PEACE_SIZE * 2;
		
		int areaX2 = (int) drawingArea.getMaxX();
		int areaY2 = (int) drawingArea.getMaxY(); 
		
		if(headX <= areaX1 || headX + Constants.SNAKE_PEACE_SIZE >= areaX2) {
			return true;
		}
		

		if(headY <= areaY1 || headY + Constants.SNAKE_PEACE_SIZE >= areaY2) {
			return true;
		}
		
		
		return false;
	}

}
