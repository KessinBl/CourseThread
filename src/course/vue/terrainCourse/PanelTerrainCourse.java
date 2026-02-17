package course.vue.terrainCourse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import course.controleur.Controleur;

public class PanelTerrainCourse extends JPanel
{
	private Candidat[] tabCandidats;
	private Controleur ctrl;

	public PanelTerrainCourse(Controleur ctrl, Candidat[] tabCandidats)
	{
		this.setLayout(new BorderLayout());
		this.ctrl = ctrl;
		this.tabCandidats = tabCandidats;

		this.setPreferredSize(new Dimension(1200, 600));
	}

	public void majPositions()
	{
		for (int cpt = 0; cpt < tabCandidats.length; cpt++)
		{
			int compteur = ctrl.getValeurCompteur(cpt + 1);
			tabCandidats[cpt].setX(compteur * 5);
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for(Candidat c : this.tabCandidats)
		{
			g2.setColor(c.getCouleur());
			g2.fillRect(c.getX(), c.getY(), 40, 40);

			if(this.ctrl.estTerminer())
			{
				Integer rang = this.ctrl.getRang(c.getNumero());

				if(rang != null && rang != -1)
				{
					String texte = "" + rang;

					g2.setColor(Color.WHITE);

					FontMetrics fm = g2.getFontMetrics();
					int textWidth = fm.stringWidth(texte);
					int textHeight = fm.getAscent();

					int x = c.getX() + (40 - textWidth) / 2;
					int y = c.getY() + (40 + textHeight) / 2 - 5;

					g2.drawString(texte, x, y);
				}
			}
		}
	}

	/*
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int nombreCandidats = tabCandidats.length;
		int hauteurTotale = this.getHeight();
		int largeurTotale = this.getWidth();

		int margeVerticale = 20;  // espace au-dessus et en dessous
		int margeHorizontale = 20; // marge à gauche et droite

		// calcul de la hauteur du carré dynamique
		int espaceDisponibleVertical = hauteurTotale - 2 * margeVerticale;
		int hauteurCarre = Math.max(30, espaceDisponibleVertical / nombreCandidats); 
		int largeurCarre = hauteurCarre; // carré parfait

		// pour centrer verticalement
		int espaceUtilise = hauteurCarre * nombreCandidats;
		int decalageY = (hauteurTotale - espaceUtilise) / 2;

		// X max pour rester dans le champ de vision
		int xMax = largeurTotale - margeHorizontale - largeurCarre;

		for (int i = 0; i < tabCandidats.length; i++)
		{
			Candidat c = tabCandidats[i];
			Integer rang = this.ctrl.getRang((i + 1));

			// position Y centrée
			int y = decalageY + (i + 1) * hauteurCarre;

			// position X limitée à l'intérieur du panel
			int x = Math.min(c.getX(), xMax);

			// carré
			g2.setColor(c.getCouleur());
			g2.fillRect(x, y, largeurCarre, hauteurCarre);

			// bord du carré
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, largeurCarre, hauteurCarre);

			// affichage du rang centré
			if (ctrl.estTerminer() || rang != null)
			{
				String text = "Place: " + (rang != null ? rang : "-");
				int textWidth = g2.getFontMetrics().stringWidth(text);
				int textX = x + (largeurCarre - textWidth) / 2;
				int textY = y + hauteurCarre / 2 + g2.getFontMetrics().getAscent()/2;
				g2.setColor(Color.BLACK);
				g2.drawString(text, textX, textY);
			}
		}
	} 
	*/



	public void majIhm()
	{
		this.majPositions();
		this.repaint();
	}
}
