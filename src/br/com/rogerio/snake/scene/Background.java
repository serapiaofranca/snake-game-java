package br.com.rogerio.snake.scene;

import br.com.rogerio.snake.graphics.Rect;
import br.com.rogerio.snake.util.Constants;

public class Background extends Rect {

	public Background() {
		super(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH);
		setColor(Constants.BACKGROUND_COLOR);
	}

}
