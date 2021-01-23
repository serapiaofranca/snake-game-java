package br.com.rogerio.snake.core;

public enum Direction {
	NONE(0,0),
	LEFT(-1,0),
	RIGHT(1,0),
	UP(0,-1),
	DOWN(0,1);  // plano cartesiano x, y da tela
	

	int sgnX;
	int sgnY;
	
	Direction(int x, int y){
		this.sgnX = x;
		this.sgnY = y;
	}
	
	public int getSgnX() {
		return sgnX;
	}
	
	public int getSgnY() {
		return sgnY;
	}
	
	// "head" nao pode mover em direção oposta
	public boolean canChangeTo(Direction other) {
		return !(sgnX + other.sgnX == 0 && sgnY + other.sgnY == 0);
	}
}

