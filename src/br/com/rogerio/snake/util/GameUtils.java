package br.com.rogerio.snake.util;
import br.com.rogerio.snake.graphics.Rect;

import java.util.List;
import java.util.Random;

public class GameUtils {
	
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
			
		} catch (InterruptedException e) {
			
		}
	}
	
	// algoritmo para movimentar os "rects"
	// cria nova head, ela passa a ser a posicao 0 da lista e movimentamos da última posição até a posição 1
	// até o "1" pois a "0" será ocupada pela nova "head" criada na posição "x"
	public static void moveRects(List<Rect> rects) {
		
		for(int i = rects.size() -1; i>= 1; i--) {
			rects.set(i, rects.get(i -1));
		}
	}
	
	public static int random(int min, int max) {
//		Random r = new Random();
//		r.nextInt();
		return 	(int) (Math.random() * (max - min +1)+ min);
	}

}
