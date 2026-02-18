package course.vue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.*;

import course.controleur.Controleur;
import course.vue.terrainCourse.Candidat;
import course.vue.terrainCourse.PanelTerrainCourse;

public class PanelCourse extends JPanel implements ActionListener
{
	private Controleur ctrl;

	private JButton btnCommencer;
	private JButton btnRecommencer;

	private Candidat[] tabCandidats;
	private PanelTerrainCourse panelTerrain;
	
	
	public PanelCourse(Controleur ctrl)
	{
		JPanel panelBas, panelHaut, panelCentre;

		this.setLayout(new BorderLayout(5,5));

		/* --------------------------------------- */
		/*          Création des composants        */
		/* --------------------------------------- */

		this.ctrl = ctrl;

		/* Pour le panel du haut  */
		panelHaut = new JPanel();
		panelHaut.add(new JLabel("Bienvenue dans la course des Threads"));

		/* Pour le panel du milieu */
		this.tabCandidats = new Candidat[this.ctrl.getNombreCandidat()];
		
		for(int cpt = 0; cpt < this.tabCandidats.length; cpt++)
		{
			this.tabCandidats[cpt] = new Candidat();
		}

		panelCentre = new JPanel(new BorderLayout(10,10));
		panelCentre.setBorder(BorderFactory.createTitledBorder("Terrain de course"));
		
		this.panelTerrain = new PanelTerrainCourse(this.ctrl , this.tabCandidats);
		panelCentre.add(this.panelTerrain,BorderLayout.CENTER);


		/* pour le panel du bas */
		this.btnCommencer   = new JButton("commencer la course"  );
		this.btnRecommencer = new JButton("recommencer la course");
		this.btnRecommencer.setEnabled(false);

		panelBas = new JPanel();
		panelBas.add(this.btnCommencer  );
		panelBas.add(this.btnRecommencer);

		panelBas.setBorder(BorderFactory.createTitledBorder("contrôle"));

		/* --------------------------------------- */
		/*      Positionnement des composants      */
		/* --------------------------------------- */

		this.add(panelHaut  , BorderLayout.NORTH );
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelBas   , BorderLayout.SOUTH );
		this.add(new Label(" "), BorderLayout.EAST);
		this.add(new Label(" "), BorderLayout.WEST);

		/* --------------------------------------- */
		/*        Activations des composants       */
		/* --------------------------------------- */

		this.btnCommencer  .addActionListener(this);
		this.btnRecommencer.addActionListener(this);

	}

	public void majIhm()
	{
		this.panelTerrain.majIhm();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btnCommencer)
		{
			this.ctrl.lancerCourse();
			System.out.println("Commencer");
			this.btnRecommencer.setEnabled(!this.btnRecommencer.isEnabled());
			this.btnCommencer  .setEnabled(!this.btnCommencer.isEnabled());
		}

		if(e.getSource() == this.btnRecommencer)
		{
			this.ctrl.recommencerCourse();
			System.out.println("recommencer");
			this.btnCommencer  .setEnabled(!this.btnCommencer  .isEnabled());
			this.btnRecommencer.setEnabled(!this.btnRecommencer.isEnabled());
		}
	}
}
