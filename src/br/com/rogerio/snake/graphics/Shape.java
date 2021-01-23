package br.com.rogerio.snake.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.com.rogerio.snake.core.Direction;

public class Shape extends Drawable {
	
	private List<Rect> rects;
	
	public Shape(Color color) {
		setColor(color);
		rects = new ArrayList<>();
	}
	
	public List<Rect> getRects() {
		return rects;
	}
	
	// encontar posição de nossa "head"
	public Rect getFirstRect() {
		return rects.get(0);		
	}
	
	// encontrar posição de nossa "tail" ultimo elemento.
	public Rect getLastRect() {
		return rects.get(rects.size() -1);		
	}
	
	public void addRect(Rect rect) {
		rect.setColor(rect.getColor());
		rects.add(rect);
	}
	
	public Rect duplicateRect(Rect baseRect, Direction direction) {
		int baseX = (int) baseRect.getLocation().getX();
		int baseY = (int) baseRect.getLocation().getY();
		int baseWidth = (int) baseRect.getDimension().getWidth();
		int baseHeight = (int) baseRect.getDimension().getHeight();
		
//		Point location = new Point(baseX - baseWidth, baseY);
		// agora o "getSgnX" e 'Y' vai nos indicar a direção mudando o sinal
		Point location = new Point(baseX + baseWidth * direction.getSgnX(), 
									baseY + baseHeight * direction.getSgnY());
		
//		Dimension dimension = new Dimension(baseWidth, baseHeight);  // a dimensão não muda, pegamos da baseRect
		Rect newRect = new Rect(location, baseRect.getDimension());
		return newRect;
	}
	
	@Override
	public void draw(Graphics g) {
//		g.setColor(getColor());   --> foi para a classe Renderer
		for(Rect r : rects) {
			r.draw(g);
		}
	}	
	
	// interagindo no 'shape' de rects e verificando se existe colisão
	public boolean intersects(Rect rect) {
		for(Rect r : rects) {
			if (r.intersects(rect)){
				return true;
			}			
		}
		return false;
	}

}
