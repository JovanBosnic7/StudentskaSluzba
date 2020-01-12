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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import kontroler.PredmetiKontroler;
import kontroler.ProfesoriKontroler;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;

public class PredmetniProfesorDijalog extends JDialog {

	private static final long serialVersionUID = 417628955706767342L;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private int vrsta;
	private JComboBox<Profesor> profesorComboBox;

	private JButton obrisi;
	private JButton nazad;
	private Profesor profesor;

	public PredmetniProfesorDijalog(int row, Point position) {

		profesor = null;

		vrsta = TabelaPredmeta.getInstance().convertRowIndexToModel(row);

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setSize(480, 270);
		this.setLocation(position);
		this.setTitle("Predmetni profesor");

		bottomPanel = new JPanel();
		bottomPanel.setMinimumSize(new Dimension(480, 30));
		bottomPanel.setBackground(new Color(240, 240, 240));
		this.add(bottomPanel, BorderLayout.SOUTH);

		Predmet p = BazaPredmeta.getInstance().getPredmeti().get(vrsta);

		profesor = p.getPredmetniProfesor();

		profesorComboBox = new JComboBox<Profesor>();

		profesorComboBox.setPreferredSize(new Dimension(200, 30));

		profesorComboBox.addItem(null);

		if (profesor != null) {
			profesorComboBox.addItem(profesor);
		}

		profesorComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				profesor = (Profesor) profesorComboBox.getSelectedItem();
			}
		});

		centerPanel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(30, 30, 30, 30);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(profesorComboBox, gbc);

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

		obrisi = new JButton("Obri\u0161i");
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiKontroler.getInstance().izbrisiProfesora(vrsta);

				ProfesoriKontroler.getInstance().izbrisiPredmet(profesor, p);
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
