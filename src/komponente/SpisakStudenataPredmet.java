package komponente;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import model.BazaPredmeta;
import model.Student;

public class SpisakStudenataPredmet extends JDialog {

	private static final long serialVersionUID = -2688263043637520599L;
	private JPanel bottomPanel;
	private PanelSaTabelama centerPanel;
	private int vrsta;
	private JComboBox<Student> studentiComboBox;

	public SpisakStudenataPredmet(int row, Point position) {

		vrsta = TabelaPredmeta.getInstance().convertRowIndexToModel(row);

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setSize(screenDimension.width / 6, screenDimension.height / 6);
		this.setLocation(position);
		this.setTitle("Studenti");

		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(screenDimension.width / 6, 30));
		bottomPanel.setBackground(new Color(240, 240, 240));
		this.add(bottomPanel, BorderLayout.SOUTH);

		ArrayList<Student> s = BazaPredmeta.getInstance().getPredmeti().get(vrsta)
				.getSpisakStudenataKojiSlusajuPredmet();
		
		studentiComboBox = new JComboBox<Student>();

		for (int i = 0; i < s.size(); i++) {
			studentiComboBox.addItem(s.get(i));

		}
		
		centerPanel = new PanelSaTabelama(studentiComboBox,30);
		
		this.add(centerPanel, BorderLayout.CENTER);
	}

}
