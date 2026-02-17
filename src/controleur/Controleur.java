import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controleur 
{
	private Metier metier;
	private FrameCourse vue;

	private Timer timer;

	
	public Controleur ()
	{
		this.metier = new Metier(5);
		this.vue    = new FrameCourse(this);

		ActionListener action = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Controleur.this.majIhm();
			}
		};

		this.timer  = new Timer(40, action );
		this.timer.start();
	}

	/* ----------------------------------------- */
	/*                  Accesseurs               */
	/* ----------------------------------------- */

	public int getNombreCandidat()
	{
		return this.metier.getLstNumeroCandidat().size();
	}

	public int getValeurCompteur(int candidat)
	{
		return this.metier.getCompteurCandidat(candidat);   
	}

	/* ----------------------------------------- */
	/*              Gestion Course               */
	/* ----------------------------------------- */

	public void lancerCourse()
	{
		this.metier.lancerCourse();
	}

	public void recommencerCourse()
	{
		this.metier.recommencer();
		this.majIhm();
	}

	public void majIhm()
	{
		this.vue.majIhm();
	}

	public static void main(String[] args) 
	{
		new Controleur();
	}
}
