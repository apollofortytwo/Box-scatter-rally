import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
	EntityManager em;
	
	KeyInput(EntityManager em){
		this.em = em;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		for(Entity en: em.getList()){
			en.velocity.x = 5; 
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
