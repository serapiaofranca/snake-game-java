package br.com.rogerio.snake.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import br.com.rogerio.snake.graphics.Renderer;
import br.com.rogerio.snake.scene.Snake;
import br.com.rogerio.snake.util.Constants;

public class GameWindow extends JFrame implements KeyListener{
	
	private Renderer renderer;
//	private Rect background;
	private Snake snake;

	//corrigir o efeito "flicker" piscar a tela
	private Image buffer;
	private Graphics gImage;
	// resolvendo problema da barra de título
	private Rectangle drawingArea;
	
	private long lastKeyboardEventTime; // para tratar evento de pressionar tecla ("debounce")
	
	public GameWindow(Snake snake){
		this.snake = snake;
						
		// background game
//		background = new Rect(Color.black, 0, 0, Constants.WINDOW_WIDTH,
//							Constants.WINDOW_HEIGTH);
		
		// toda renderizacao foi implementada pela classe "Game"
		
//		Rect background = new Rect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH);
//		Background background = new Background();
//		renderer.add(background);
//		
//		Snake snake = new Snake();
//		renderer.add(snake);
//				
				
		// renderização da tela do jogo - class JFrame
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH);
		setResizable(false);
		setTitle(Constants.WINDOW_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// funcao para nao aparecer o minimize
		setLocationRelativeTo(null); // deixar a janela centralizada
		addKeyListener(this);  // a propria janela vai monitorar o pressionamento de tecla
		setVisible(true);
		
		// primeiro crio a imgem de "bufer" depois chamo a caneta de desenho desta no renderer
		buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH);
		gImage = buffer.getGraphics();
				
		renderer = new Renderer(gImage);
		
		defineDrawingArea(); 			
			
	}
	
	@Override
	public void paint(Graphics gScreen) {
		
		// tratamento para não ocorrer problemas de "threads"
		if(gImage == null || renderer == null) {
			return;
		}
		renderer.render();  // o render já tem a caneta, não preciso mais passá-la como parâmetro
//		background.draw(g);
//		snake.draw(g);
		//rect2.paint(g);
		
		gScreen.drawImage(buffer, 0, 0, null);
	}
	
	public Renderer getRenderer() {
		return renderer;
	}
	
	private void defineDrawingArea() {
		int upperY = (int) (Constants.WINDOW_HEIGTH - getContentPane().getSize().getHeight());
		drawingArea = new Rectangle(0, upperY, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH - upperY);
	}
	
	public Rectangle getDrawingArea() {
		return drawingArea;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//erro de movimentar muito rapido pressiona teclas muito rapido
		long now = System.currentTimeMillis();
		
		
		if (now - lastKeyboardEventTime < 40) {
			return;
		}
		
		// varredura das teclas
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			snake.up();
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			snake.down();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			snake.left();
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			snake.right();
		}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
		lastKeyboardEventTime = now;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
