package br.com.rogerio.snake.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
	
	private List<Drawable> drawables;
	private Graphics gImage;
	
	public Renderer(Graphics gImage) {
		drawables = new ArrayList<>();
		this.gImage = gImage;
	}
	
	
	// PARA resolver problemas de sincronismo de processo entre threads diferentes, usamos o synchronized 
	public synchronized void render() {
		for(Drawable d : drawables) {
			gImage.setColor(d.getColor());  // antes de desenhar vou definir a cor da caneta 
			d.draw(gImage);
		}
	}
	
	public synchronized void add(Drawable d) {
		drawables.add(d);
	}
	
	public synchronized void remove(Drawable d) {
		drawables.remove(d);
	}	

}
