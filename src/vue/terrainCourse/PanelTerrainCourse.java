package terrainCourse;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelTerrainCourse extends JPanel
{
	private Candidat[] tabCandidats;

	public PanelTerrainCourse(Candidat[] tabCandidats)
	{
		this.setLayout(new BorderLayout());
		this.tabCandidats = tabCandidats;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;

		for(Candidat c : this.tabCandidats)
		{
			g2.setColor(c.getCouleur());
			g2.drawRect(c.getX(), c.getY(), 100, 100);
		}
	}

	public void majIhm()
	{
		this.repaint();
	}
}
