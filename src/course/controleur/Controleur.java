package course.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import course.modele.Metier;
import course.vue.FrameCourse;

import javax.swing.Timer;

public class Controleur 
{
	private Metier metier;
	private FrameCourse vue;

	private Timer timer;

	
	public Controleur ()
	{
		this.metier = new Metier(10);
		this.vue    = new FrameCourse(this);

		ActionListener action = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Controleur.this.majIhm();
			}
		};

		this.timer  = new Timer(10, action );
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

	public int getRang(int numero)
	{
		return this.metier.getRang(numero);
	}

	/* ----------------------------------------- */
	/*              Gestion Course               */
	/* ----------------------------------------- */

	public void lancerCourse()
	{
		this.timer.start();
		this.metier.lancerCourse();
	}

	public void recommencerCourse()
	{
		this.metier.recommencer();
		this.majIhm();
	}

	public boolean estTerminer()
	{
		return this.metier.courseTerminer();
	}

	public void majIhm()
	{
		this.vue.majIhm();

		if(this.metier.courseTerminer() && this.timer.isRunning())
		{
			this.timer.stop();
		}

	}

	public static void main(String[] args) 
	{
		new Controleur();
	}
}
