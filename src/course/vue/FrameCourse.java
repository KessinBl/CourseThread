package course.vue;

import javax.swing.JFrame;

import course.controleur.Controleur;

public class FrameCourse extends JFrame
{
	private Controleur ctrl;
	private PanelCourse panelCourse;

	public FrameCourse(Controleur ctrl)
	{
		this.setTitle("course de thread");
		
		/* --------------------------------------- */
		/*          Création des composants        */
		/* --------------------------------------- */

		this.ctrl = ctrl;
		this.panelCourse = new PanelCourse(this.ctrl);

		/* --------------------------------------- */
		/*      Positionnement des composants      */
		/* --------------------------------------- */

		this.add(this.panelCourse);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();

		this.setLocationRelativeTo(null);
		this.pleinEcran();
	}

	public void pleinEcran()
	{
		this.dispose();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	public void majIhm()
	{
		this.panelCourse.majIhm();
	}
}
