package entite;

public class Candidat extends Thread
{
	private Integer   numero;
	private Integer     rang;
	private int     compteur;

	public Candidat (int numero)
	{
		this.numero   = numero;
		this.compteur =      0;
		this.rang     =   null;
		this.compteur =      0;
	}

	/*--------------------------------*/
	/*            Acesseurs           */
	/*--------------------------------*/

	public Integer getNumero()
	{
		return this.numero;
	}

	public Integer getRang()
	{
		return this.rang;
	}

	public int getValeurCompteur()
	{
		return this.compteur;
	}

	/*------------------------------------*/
	/*             Modificateur           */
	/*------------------------------------*/

	public void setRang(Integer rang)
	{
		this.rang = rang;
	}

	/*------------------------------------*/
	/*          Autres Methodes           */
	/*------------------------------------*/

	public void lancer()
	{
		this.start();
	}

	public void run()
	{
		try 
		{
			for(int cpt = 0; cpt < 100; cpt++)
			{
				this.compteur++;
				Thread.sleep(1000);

				/*
					String chaine = "";

				for(int cptCompteur = 0; cptCompteur <this.compteur ; cptCompteur++)
				{
					chaine += " ";
				}

				System.out.println(chaine + numero);
				*/
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}


}
