
import javax.swing.JFrame;

public class FrameCourse extends JFrame
{
	private Controleur ctrl;
	private PanelCourse panelCourse;

	public FrameCourse(Controleur ctrl)
	{
		this.setLocationRelativeTo(null);
		this.setTitle("course de thread");
		
		/* --------------------------------------- */
		/*          Création des composants        */
		/* --------------------------------------- */

		this.ctrl = ctrl;
		this.panelCourse = new PanelCourse(ctrl);

		/* --------------------------------------- */
		/*      Positionnement des composants      */
		/* --------------------------------------- */

		this.add(this.panelCourse);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
}
