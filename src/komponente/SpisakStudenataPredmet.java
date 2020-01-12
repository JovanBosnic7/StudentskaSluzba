package komponente;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import kontroler.PredmetiKontroler;
import kontroler.StudentiKontroler;
import model.BazaPredmeta;
import model.Predmet;
import model.Student;

public class SpisakStudenataPredmet extends JDialog {

	private static final long serialVersionUID = -2688263043637520599L;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private int vrsta;
	private JComboBox<Student> studentiComboBox;

	private JButton obrisi;
	private JButton nazad;
	private int idx;
	private Student student;
	
	public SpisakStudenataPredmet(int row, Point position) {
		
		idx = -1;
		student = null;
		
		vrsta = TabelaPredmeta.getInstance().convertRowIndexToModel(row);

		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setSize(480, 270);
		this.setLocation(position);
		this.setTitle("Studenti");

		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(480, 20));
		bottomPanel.setBackground(new Color(240, 240, 240));
		this.add(bottomPanel, BorderLayout.SOUTH);

		Predmet p = BazaPredmeta.getInstance().getPredmeti().get(vrsta);
		
		ArrayList<Student> s = p.getSpisakStudenataKojiSlusajuPredmet();
		
		ComparatorStudenti comp = new ComparatorStudenti();
		
		Collections.sort(s, comp);
		
		studentiComboBox = new JComboBox<Student>();

		studentiComboBox.setPreferredSize(new Dimension(200,30));
		
		studentiComboBox.addItem(null);
		
		for (int i = 0; i < s.size(); i++) {
			studentiComboBox.addItem(s.get(i));
		}
		
		studentiComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				idx = studentiComboBox.getSelectedIndex();
				student = (Student) studentiComboBox.getSelectedItem();
			}
		});
		
		centerPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(30, 30, 30, 30);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(studentiComboBox, gbc);
		
		nazad = new JButton("Nazad");
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		GridBagConstraints gbcNazad = new GridBagConstraints();
		gbcNazad.gridx = 1;
		gbcNazad.gridy = 1;
		gbcNazad.weightx = 1;
		gbcNazad.anchor = GridBagConstraints.EAST;
		gbcNazad.insets = new Insets(30, 10, 10, 10);
		centerPanel.add(nazad, gbcNazad);
	
		obrisi = new JButton("Obrisi");
		obrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiKontroler.getInstance().izbrisiStudenta(vrsta, idx);
				StudentiKontroler.getInstance().izbrisiPredmet(student, p);
				setVisible(false);
			}
		});
		
		GridBagConstraints gbcObrisi = new GridBagConstraints();
		gbcObrisi.gridx = 2;
		gbcObrisi.gridy = 1;
		gbcObrisi.weightx = 1;
		gbcObrisi.insets = new Insets(30, 10, 10, 30);
		gbcObrisi.anchor = GridBagConstraints.EAST;
		centerPanel.add(obrisi, gbcObrisi);
		
		this.add(centerPanel, BorderLayout.CENTER);
	}

}
