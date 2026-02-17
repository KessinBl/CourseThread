package terrainCourse;

import java.awt.Color;

public class Candidat 
{
	private static int numero = 0;

	private Color couleurCandidat;
	private int numeroCandidat;
	private int posX;
	private int posY;

	public Candidat()
	{
		this.couleurCandidat = new Color( (int)(Math.random() * 256), 
		                                  (int)(Math.random() * 256), 
		                                  (int)(Math.random() * 256));

		this.numeroCandidat = ++ Candidat.numero;
		this.posX = 0;
		this.posY = this.numeroCandidat + 40;
	}

	/*--------------------------------*/
	/*            Acesseurs           */
	/*--------------------------------*/

	public Color getCouleur() { return this.couleurCandidat; }
	public int   getX      () { return this.posX           ; }
	public int   getY      () { return this.posY           ; }

	/*--------------------------------*/
	/*          Modificateur          */
	/*--------------------------------*/

	public int setX(int x) { return this.posX = x; }
	public int setY(int y) { return this.posY = y; }
}
