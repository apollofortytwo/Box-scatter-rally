import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	private ArrayList<Entity> eList = new ArrayList<Entity>();

	public void render(Graphics g) {
		for (Entity en : eList) {
			en.render(g);
		}
	}

	public void tick() {
		for (Entity en : eList) {
			en.tick();
		}
	}

	public void update() {
		for (Entity en : eList) {
			en.update();
		}
	}
	
	public ArrayList<Entity> getList(){
		return eList;
	}

	public void add(Entity en) {
		eList.add(en);
	}

	public void remove(Entity en) {
		eList.remove(en);
	}
}
