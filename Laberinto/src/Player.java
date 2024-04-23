public class Player {

	int x, y, w, h;
	String Color;
	
	public Player(int x, int y, int w, int h, String Color) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Color = Color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
	
	public String colision(Player p) {
		 	boolean colisionX = (this.x <= p.getX() + p.getW()) && (this.x + this.w >= p.getX());
	     
	        boolean colisionY = (this.y <= p.getY() + p.getH()) && (this.y + this.h >= p.getY());

	        if (colisionX && colisionY) {
	            return "Colision";
	        } else {
	        	return "No";
	        }
	}
}