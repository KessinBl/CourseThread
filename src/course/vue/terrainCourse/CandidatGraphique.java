package course.vue.terrainCourse;

import java.awt.Color;

public class CandidatGraphique 
{
	private static int numero = 0;

	private Color couleurCandidat;
	private int numeroCandidat;
	private int posX;
	private int posY;

	public CandidatGraphique()
	{
		this.couleurCandidat = new Color( (int)(Math.random() * 256), 
		                                  (int)(Math.random() * 256), 
		                                  (int)(Math.random() * 256));

		this.numeroCandidat = ++ CandidatGraphique.numero;
		this.posX = 0;
		this.posY = 50 +  (this.numeroCandidat -1 ) * 65;
	}

	/*--------------------------------*/
	/*            Acesseurs           */
	/*--------------------------------*/

	public int   getNumero () { return this.numeroCandidat ; }
	public Color getCouleur() { return this.couleurCandidat; }
	public int   getX      () { return this.posX           ; }
	public int   getY      () { return this.posY           ; }

	/*--------------------------------*/
	/*          Modificateur          */
	/*--------------------------------*/

	public int setX(int x) { return this.posX = x + 10 ; }
	public int setY(int y) { return this.posY = y       ; }
}
