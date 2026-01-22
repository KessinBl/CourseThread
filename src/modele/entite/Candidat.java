package entite;

public class Candidat extends Thread
{
	private Integer   numero;
	private Integer     rang;

	public Candidat (int numero)
	{
		this.numero   = numero;
		this.rang     =   null;
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
				Thread.sleep(1000);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}


}
