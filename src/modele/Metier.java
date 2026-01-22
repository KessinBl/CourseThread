

import java.util.ArrayList;
import java.util.List;

public class Metier 
{
	private List<Candidat> lstCandidat;

	public Metier()
	{
		this.lstCandidat = new ArrayList<Candidat>();
		this.initLstCandidat(10);
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
	}

	private void initLstCandidat(int nombre_candidat)
	{
		for(int cpt = 0; cpt < nombre_candidat; cpt++)
		{
			this.lstCandidat.add(new Candidat(cpt + 1));
		}
	}

}
