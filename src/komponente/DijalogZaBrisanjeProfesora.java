package komponente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kontroler.PredmetiKontroler;
import kontroler.ProfesoriKontroler;

public class DijalogZaBrisanjeProfesora extends JDialog implements ActionListener {
	private JLabel poruka;
	private JButton odustanak;
	private JButton potvrda;
	private JLabel slika;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private int red;
	public DijalogZaBrisanjeProfesora(int row) {

		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Prvo odaberite profesora kog zelite da obrisete!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// TODO Auto-generated constructor stub
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(2 * screenDimension.width / 8, screenDimension.height / 5);
		setLocation(screenDimension.width / 2 - getWidth() / 2, screenDimension.height / 2 - getHeight() / 2);
		setTitle("Brisanje profesora");
		setModal(true);
		setLocationRelativeTo(null);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints b = new GridBagConstraints();

		poruka = new JLabel("Da li ste sigurni da zelite da obrišete profesora?");
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(70, 10, 30, 30);
		centerPanel.add(poruka, c);
		slika = new JLabel(new ImageIcon("slike/brisanje.png"));
		b.gridx = 0;
		b.gridy = 0;
		b.insets = new Insets(40, 20, 10, 20);
		centerPanel.add(slika, b);

		this.add(centerPanel, BorderLayout.CENTER);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());
		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 0;
		a.insets = new Insets(40, 40, 40, 40);
		odustanak = new JButton("Odustanak");
		odustanak.addActionListener(this);
		bottomPanel.add(odustanak, a);

		potvrda = new JButton("Potvrda");
		potvrda.addActionListener(this);
		potvrda.setBackground(new Color(131, 237, 253));

		a.gridx = 1;
		a.gridy = 0;
		bottomPanel.add(potvrda, a);

		this.add(bottomPanel, BorderLayout.SOUTH);
		red=row;
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		if (clicked == odustanak) {
			setVisible(false);
		}
		if (clicked == potvrda) {
			ProfesoriKontroler.getInstance().izbrisiProfesora(red);
			setVisible(false);
		}

	}

}
