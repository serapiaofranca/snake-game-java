package br.com.rogerio.snake.scene;

import java.awt.Color;
import java.awt.Point;

import br.com.rogerio.snake.graphics.Text;
import br.com.rogerio.snake.util.Constants;

public class GameOverText extends Text{
	
	public GameOverText(int score	) {
		super(Constants.GAMEOVER_COLOR, String.format(Constants.GAMEOVER_TEXT, score), Constants.GAMEOVER_LOCATION);
	}
	
	

}


//Se quiser omitir a repetição dos  "Contants.BLAblaBLA" podemos utilizar um Static Import
// import static br.com.rogerio.snake.util.Constants.BLAblaBla
// depois é só usar o proprio argumento... "BLAblaBLA" ... sem ficar repetindo o "Constants"