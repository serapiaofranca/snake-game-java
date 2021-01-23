package br.com.rogerio.snake.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public class Rect extends Drawable {
	
//	private Point location;
//	private Dimension dimension;
	// substituindo pela Classe do Java Rectangle
	private Rectangle rectangle;
	
	public Rect() {
		this.rectangle = new Rectangle(0, 0);
	}
		
	public Rect(Point location, Dimension dimension) {	
//		this.location = location;
//		this.dimension = dimension;
		this.rectangle = new Rectangle(location, dimension);
	}
	
	public Rect(int x, int y, int width, int height) {
//		this.location = new Point(x, y);
//		this.dimension = new Dimension(width, height);
		this.rectangle = new Rectangle(x, y, width, height);
	}
				
	public Point getLocation() {
//		return location;
		return rectangle.getLocation();
	}
	
	public void setLocation(Point location) {
		rectangle.setLocation(location);
	}


	public Dimension getDimension() {
//		return dimension;
		return rectangle.getSize();
	}
	
	public void setDimension(Dimension dimension) {
		rectangle.setSize(dimension);
	}
	
	// metodo intersects para tratar colisao de rectangles
	public boolean intersects (Rect rect) {
		return rectangle.intersects(rect.rectangle);
	}
	
	@Override
	public void draw(Graphics g) {		
		g.fillRect(
//				(int) location.getX(),
				(int) rectangle.getLocation().getX(),
				(int) rectangle.getLocation().getY(),
				(int) rectangle.getSize().getHeight(), 
				(int) rectangle.getSize().getWidth()
		);
	}
}
