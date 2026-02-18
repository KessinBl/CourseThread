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
	private CandidatGraphique[] tabCandidats;
	private Controleur ctrl;

	public PanelTerrainCourse(Controleur ctrl, CandidatGraphique[] tabCandidats)
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

		for(CandidatGraphique c : this.tabCandidats)
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

	public void majIhm()
	{
		this.majPositions();
		this.repaint();
	}
}
