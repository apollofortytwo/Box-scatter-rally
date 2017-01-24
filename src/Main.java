import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends JFrame {
	int WIDTH, HEIGHT;
	EntityManager em;

	Main(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		setup();
		loop();
	}

	private void setup() {
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		em = new EntityManager();
		for(int i = 0; i <= 50; i++){
			int x = (int) (Math.random() * 799);
			int y = (int) (Math.random() * 799);
			em.add(new Entity(x, y, 50, 50));
		}
	


		KeyInput keyInput = new KeyInput(em);
		this.addKeyListener(keyInput);
		MouseInput mouseInput = new MouseInput(em);
		this.addMouseListener(mouseInput);
	}

	private void loop() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			update();
			render();
			
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
			try {
				Thread.sleep((long) ((1000 / 60) - delta));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.white);
		g.clearRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.blue);
		em.render(g);

		g.dispose();
		//
		bs.show();

	}

	private void tick() {
		em.tick();
	}

	private void update() {
		em.update();
	}

	public static void main(String args[]) {
		new Main(800, 800);
	}
}
