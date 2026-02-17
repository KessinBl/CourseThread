package entite;

public class Candidat implements Runnable
{
	private int     compteur;
	private boolean  enCours;

	private Integer   numero;
	private Integer     rang;

	private final int MAX = 255;

	public Candidat (int numero)
	{
		this.numero   = numero;
		this.compteur =      0;
		this.rang     =   null;
		this.enCours  =   true;
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

	public void reinitialiserCompteur()
	{
		this.enCours = true;
		this.compteur = 0;
	}

	public void arreter()
	{
		this.enCours = false;
	}

	/*------------------------------------*/
	/*          Autres Methodes           */
	/*------------------------------------*/

	public void run()
	{
		try 
		{
			while(this.enCours && this.compteur < this.MAX)
			{
				this.compteur++;
				Thread.sleep(50);
			}

			this.enCours = false;
		}
		catch(InterruptedException ie)
		{
			System.out.println(this.numero + " est arrêté ");
		}
		
	}


}
