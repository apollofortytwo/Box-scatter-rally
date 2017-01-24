import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	EntityManager em;

	MouseInput(EntityManager em) {
		this.em = em;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Entity en : em.getList()) {
			if (e.getButton() == 1) {
				en.moveTo(e.getX(), e.getY());
			} else if (e.getButton() == 3) {
				int x = (int) (Math.random() * 799);
				int y = (int) (Math.random() * 799);
				en.moveTo(x, y);
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
