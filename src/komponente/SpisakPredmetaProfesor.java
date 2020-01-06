package komponente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaProfesora;
import model.Predmet;

public class SpisakPredmetaProfesor extends JDialog {

	private static final long serialVersionUID = -1883696510588121601L;
	private JPanel bottomPanel;
	private JScrollPane centerPanel;
	private int vrsta;

	public SpisakPredmetaProfesor(int row, Point position) {

		vrsta = TabelaProfesora.getInstance().convertRowIndexToModel(row);

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setSize(screenDimension.width / 6, screenDimension.height / 6);
		this.setLocation(position);
		this.setTitle("Predmeti");

		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(screenDimension.width / 5, 30));
		bottomPanel.setBackground(new Color(240, 240, 240));
		this.add(bottomPanel, BorderLayout.SOUTH);

		ArrayList<Predmet> p = BazaProfesora.getInstance().getProfesori().get(vrsta).getPredmeti();
		
		Predmet[] predmeti = new Predmet[p.size()];

		for(int i = 0; i < p.size(); i++) {
			predmeti[i] = p.get(i);
		}
		
		JList<Predmet> lista = new JList<Predmet>(predmeti);
		
		centerPanel = new JScrollPane(lista);
		centerPanel.setBackground(Color.WHITE);

		this.add(centerPanel, BorderLayout.CENTER);
	}

}
