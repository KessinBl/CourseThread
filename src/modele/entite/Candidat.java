package entite;

public class Candidat implements Runnable
{
	private volatile int     compteur;
	private volatile boolean  enCours;
	private Integer   numero;
	private Integer     rang;

	public Candidat (int numero)
	{
		this.numero   = numero;
		this.compteur =      0;
		this.rang     =   null;
		this.compteur =      0;
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
			while(this.enCours && this.compteur < 100)
			{
				this.compteur++;
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println(this.numero + " est arrêté ");
		}
		
	}


}
