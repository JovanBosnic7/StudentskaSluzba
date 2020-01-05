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

import model.BazaStudenata;
import model.Predmet;

public class SpisakPredmetaStudent extends JDialog{

	private static final long serialVersionUID = -536062069312838627L;

	private JPanel bottomPanel;
	private JScrollPane centerPanel;
	private int vrsta;
	
	public SpisakPredmetaStudent(int row, Point position) {
		
		vrsta = TabelaStudenata.getInstance().convertRowIndexToModel(row);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setSize(screenDimension.width / 6, screenDimension.height / 6);
		this.setLocation(position);
		this.setTitle("Predmeti");
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(screenDimension.width/5, 30));
		bottomPanel.setBackground(new Color(240,240,240));
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		ArrayList<Predmet> p = BazaStudenata.getInstance().getStudenti().get(vrsta).getSpisakPredmeta();
		
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
