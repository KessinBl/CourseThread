import java.util.ArrayList;
import java.util.List;

import entite.Candidat;

public class Metier 
{
	private List<Candidat> lstCandidat;
	private List< Thread >  lstThreads;   
	private int        nombre_candidat;

	public Metier(int nombre_candidat)
	{
		this.lstCandidat = new ArrayList<Candidat>();
		this.lstThreads  = new ArrayList< Thread >();

		this.nombre_candidat = nombre_candidat;
		this.initLstCandidat(nombre_candidat);
	}

	/* ------------------------------ */
	/*            Accesseurs          */
	/* ------------------------------ */

	public List<Integer> getLstNumeroCandidat()
	{
		List<Integer> lstNumeroCandidat = new ArrayList<Integer>();

		for(int cpt = 0; cpt < this.lstCandidat.size() ; cpt++)
		{
			lstNumeroCandidat.add(this.lstCandidat.get(cpt).getNumero());
		}

		return lstNumeroCandidat;
	}

	public int getCompteurCandidat(int numero)
	{
		return (this.lstCandidat.get(numero -1) != null) ? this.lstCandidat.get(numero -1).getValeurCompteur() : 0;
	}

	/* ---------------------------------- */
	/*            Gestion Course          */
	/* ---------------------------------- */

	public void lancerCourse()
	{
		this.lstThreads.clear();

		for(Candidat candidat : this.lstCandidat)
		{
			Thread t = new Thread(candidat);
			t.start();

			this.lstThreads.add(t);
		}
	}

	public void recommencer()
	{
		for(Candidat c : this.lstCandidat)
		{
			c.arreter();
			c.reinitialiserCompteur();
		}

		this.lstCandidat.clear();
		this.initLstCandidat(this.nombre_candidat);
	}

	public boolean courseTerminer()
	{
		boolean estTerminer = true;

		for(Candidat candidat : this.lstCandidat)
		{
			if(candidat.getValeurCompteur() <= 99 )
			{
				estTerminer = false;
			}
		}

		return estTerminer;
	}

	private void initLstCandidat(int nombre_candidat)
	{
		for(int cpt = 0; cpt < nombre_candidat; cpt++)
		{
			this.lstCandidat.add(new Candidat(cpt + 1));
		}
	}

	/*
		public static void main(String[] args) {
		Metier metier = new Metier(17);
		System.out.println(metier.getLstNumeroCandidat().toString());

		System.out.println("/*---------------------------");

		metier.lancerCourse();

		for(int cpt = 0; cpt < metier.getLstNumeroCandidat().size(); cpt++)
		{
			String chaine = "";

			for(int cptCompteur = 0; cptCompteur < metier.getCompteurCandidat((cpt+ 1)) ; cptCompteur++)
			{
				chaine += " ";
			}

			System.out.println(chaine + metier.getCompteurCandidat((cpt+ 1)));

		}

		System.out.println("/*---------------------------*");
	}
	*/

}
