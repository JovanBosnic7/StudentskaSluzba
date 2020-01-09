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

import javax.swing.*;

import kontroler.StudentiKontroler;

public class BrisanjeStudentaDijalog extends JDialog {

	private static final long serialVersionUID = 7649273326601717531L;

	private JLabel brisanje;
	private JButton odustanak;
	private JButton potvrda;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private int vrsta;
	public BrisanjeStudentaDijalog(int row) {
		
		if(row < 0) {
			JOptionPane.showMessageDialog(null, "Prvo odaberite studenta kog zelite da obrisete!", "Greska", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		vrsta = TabelaStudenata.getInstance().convertRowIndexToModel(row);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setSize(1 * screenDimension.width / 4, screenDimension.height / 5);
		this.setTitle("Brisanje studenta");
		this.setModal(false);
		this.setLocationRelativeTo(MainFrame.getInstance());
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(screenDimension.width/5, 30));
		bottomPanel.setBackground(new Color(240,240,240));
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.WHITE);
		

		brisanje = new JLabel("Da li ste sigurni da zelite da obrisete studenta?");
		brisanje.setIcon(new ImageIcon("slike/brisanje.png") );
		
		GridBagConstraints gbcLabela = new GridBagConstraints();
		gbcLabela.gridx = 0;
		gbcLabela.gridy = 0;
		gbcLabela.gridwidth = 3;
		centerPanel.add(brisanje, gbcLabela);
		
		odustanak = new JButton("Odustanak");
		odustanak.setPreferredSize(new Dimension(100, 25));
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		GridBagConstraints gbcOdustanak = new GridBagConstraints();
		gbcOdustanak.gridx = 1;
		gbcOdustanak.gridy = 1;
		gbcOdustanak.weightx = 100;
		gbcOdustanak.anchor = GridBagConstraints.EAST;
		gbcOdustanak.insets = new Insets(30, 10, 10, 10);
		centerPanel.add(odustanak, gbcOdustanak);
		
		potvrda = new JButton("Potvrda");
		potvrda.setPreferredSize(new Dimension(100, 25));
		
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!StudentiKontroler.getInstance().izbrisiStudenta(vrsta))
					JOptionPane.showMessageDialog(null, "Pre brisanja, uklonite studenta sa svih predmeta!", "Greska", JOptionPane.ERROR_MESSAGE);
					
				setVisible(false);
			}
		});
		
		GridBagConstraints gbcPotvrda = new GridBagConstraints();
		gbcPotvrda.gridx = 2;
		gbcPotvrda.gridy = 1;
		gbcPotvrda.weightx = 1;
		gbcPotvrda.insets = new Insets(30, 10, 10, 30);
		gbcPotvrda.anchor = GridBagConstraints.EAST;
		centerPanel.add(potvrda, gbcPotvrda);
		this.add(centerPanel, BorderLayout.CENTER);

	}
	
}
