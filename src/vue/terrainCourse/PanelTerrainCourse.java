import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelTerrainCourse extends JPanel
{
	private Candidat[] tabCandidats;
	private Controleur ctrl;

	public PanelTerrainCourse(Controleur ctrl, Candidat[] tabCandidats)
	{
		this.setLayout(new BorderLayout());
		this.ctrl = ctrl;
		this.tabCandidats = tabCandidats;

		this.setPreferredSize(new Dimension(800, 800));
	}

	public void majPositions()
	{
		for (int i = 0; i < tabCandidats.length; i++)
		{
			int compteur = ctrl.getValeurCompteur(i + 1);
			tabCandidats[i].setX(compteur * 5);
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;

		for(Candidat c : this.tabCandidats)
		{
			g2.setColor(c.getCouleur());
			g2.fillRect(c.getX(), c.getY(), 100, 100 );
		}
	}

	public void majIhm()
	{
		this.majPositions();
		this.repaint();
	}
}
