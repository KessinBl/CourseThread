
public class Controleur 
{
	private Metier metier;
	private FrameCourse vue;

	
	public Controleur ()
	{
		this.metier = new Metier(5);
		this.vue    = new FrameCourse(this);
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
	}

	public static void main(String[] args) 
	{
		new Controleur();
	}
}
