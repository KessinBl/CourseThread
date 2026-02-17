import java.util.ArrayList;
import java.util.List;

import entite.Candidat;

public class Metier 
{
	private List<Candidat> lstCandidat;
	private List< Thread >  lstThreads;
	private int        nombre_candidat;
	private int           rangCandidat;

	public Metier(int nombre_candidat)
	{
		this.lstCandidat = new ArrayList<Candidat>();
		this.lstThreads  = new ArrayList< Thread >();

		this.nombre_candidat = nombre_candidat;
		this.rangCandidat    = 1;
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
		return (this.lstCandidat.get(numero -1) != null) ? this.lstCandidat.get(numero -1).getValeurCompteur() : -1;
	}

	public Integer getRang(int numero)
	{
		return this.lstCandidat.get(numero - 1).getRang() != null ? this.lstCandidat.get(numero-1).getRang() : -1;
	}

	/* ---------------------------------- */
	/*            Gestion Course          */
	/* ---------------------------------- */

	public void lancerCourse()
	{
		this.lstThreads.clear();

		for(Candidat candidat : this.lstCandidat)
		{
			Runnable run = new Runnable() {

				public void run() 
				{
					candidat.run();
					
					if(candidat.getRang() == null)
					{
						candidat.setRang(Metier.this.attribuerRang());
					}
				}
				
			};

			Thread     t = new Thread(run);
			t.start();


			this.lstThreads.add(t);
		}
	}

	public void recommencer()
	{
		// Stopper les candidats
		for(Candidat c : this.lstCandidat)
		{
			c.arreter();
		}

		// Attendre la fin des threads
		for(Thread t : this.lstThreads)
		{
			try
			{
				t.join();
			}
			catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}

		// Réinitialisation
		this.rangCandidat = 1;
		this.lstCandidat.clear();
		this.lstThreads.clear();
		this.initLstCandidat(this.nombre_candidat);
	}

	public boolean courseTerminer()
	{
		for(Candidat candidat : this.lstCandidat)
		{
			if(candidat.getRang() == null )
			{
				return false;
			}
		}

		return true;
	}

	public List<Candidat> getLstCandidat()
	{
		return this.lstCandidat;
	}

	public synchronized int attribuerRang()
	{
		return this.rangCandidat++;
	}

	private void initLstCandidat(int nombre_candidat)
	{
		for(int cpt = 0; cpt < nombre_candidat; cpt++)
		{
			this.lstCandidat.add(new Candidat(cpt + 1));
		}
	}

}
