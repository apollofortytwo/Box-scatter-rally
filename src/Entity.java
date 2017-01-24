import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Entity {
	Point pos, size, velocity, des;
	int speed = 5;
	Color clr;

	public Entity(int x, int y, int width, int height) {

		clr = generateColor();
		this.pos = new Point(x, y);
		this.size = new Point(width, height);
		velocity = new Point(0, 0);
	}

	private Color generateColor() {
		Random rnd = new Random();
		int r = rnd.nextInt(128) + 128; // 128 ... 255
		int g = rnd.nextInt(128) + 128; // 128 ... 255
		int b = rnd.nextInt(128) + 128; // 128 ... 255

		Color c = Color.getHSBColor(r, g, b);
		return c;
	}

	public Entity(Point pos, Point size) {
		this.pos = pos;
		this.size = size;
		velocity = new Point(0, 0);

	}

	public void tick() {

	}

	public void update() {
		double distance;
		if (des != null) {
			distance = Math.sqrt(Math.pow(des.x - pos.x, 2) + Math.pow(des.y - pos.y, 2));
			double amountToMoveX = ((des.x - pos.x) / distance) * speed;
			double amountToMoveY = ((des.y - pos.y) / distance) * speed;
			this.velocity.setLocation(amountToMoveX, amountToMoveY);
			System.out.println(distance);
			if (distance <= speed) {
				velocity.setLocation(0, 0);
				des = null;
			}
		}

		this.pos.x += velocity.getX();
		this.pos.y += velocity.getY();
		
		if(des == null){
			checkCollision();
		}
	}
	
	private void checkCollision(){
		
	}

	public void moveTo(int Xpos, int Ypos) {
		des = new Point(Xpos, Ypos);
	}

	public void render(Graphics g) {
		g.setColor(clr);
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(getBounds());
		
	}

	protected Rectangle getBounds() {
		return new Rectangle(pos.x , pos.y, size.x, size.y);
	}

	protected Rectangle getTopBounds() {
		return new Rectangle(pos.x + (size.x / 4), pos.y, size.x / 2, size.y / 2);
	}

	protected Rectangle getBottomBounds() {
		return new Rectangle(pos.x + (size.x / 4), pos.y + (size.y / 2), size.x / 2, size.y / 2);
	}

	protected Rectangle getLeftBounds() {
		return new Rectangle(pos.x, pos.y + (size.y * 1 / 8), size.x / 4, size.y * 3 / 4);
	}

	protected Rectangle getRightBounds() {
		return new Rectangle(pos.x + (size.x) - (size.x / 4), pos.y + (size.y * 1 / 8), size.x / 4, size.y * 3 / 4);
	}

}
