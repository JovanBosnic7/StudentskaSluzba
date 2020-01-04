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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import kontroler.PredmetiKontroler;
import kontroler.StudentiKontroler;
import model.BazaPredmeta;
import model.GodinaStudija;
import model.Predmet;
import model.Student;

public class DodavanjeStudentaNaPredmetDijalog extends JDialog{
	
		private static final long serialVersionUID = 7649273326601717531L;
		private JLabel labelaIndeks;
		private JButton odustanak;
		private JButton potvrda;
		private JPanel bottomPanel;
		private JPanel centerPanel;
		private JTextField unosIndeks;
		private String brojIndeksa;
		private int vrsta;
		private Boolean uslov;
		private GodinaStudija godinaStudija;
		
		public DodavanjeStudentaNaPredmetDijalog(int row) {
			
			if(row < 0) {
				JOptionPane.showMessageDialog(null, "Prvo odaberite predmet na kog zelite da dodate studenta!", "Greska", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			vrsta = TabelaPredmeta.getInstance().convertRowIndexToModel(row);
			Predmet predmet = BazaPredmeta.getInstance().getPredmeti().get(vrsta);
			godinaStudija = predmet.getGodinaUKojojSePredmetIzvodi();
			Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setSize(1 * screenDimension.width / 4, screenDimension.height / 5);
			this.setTitle("Predmet - dodavanje studenta");
			this.setModal(true);
			this.setLocationRelativeTo(MainFrame.getInstance());
			
			bottomPanel = new JPanel();
			bottomPanel.setPreferredSize(new Dimension(screenDimension.width/5, 30));
			bottomPanel.setBackground(new Color(240,240,240));
			this.add(bottomPanel, BorderLayout.SOUTH);
			
			centerPanel = new JPanel(new GridBagLayout());
			centerPanel.setBackground(Color.WHITE);
			

			labelaIndeks = new JLabel("Indeks studenta*");
			
			GridBagConstraints gbcUnos = new GridBagConstraints();
			gbcUnos.gridx = 0;
			gbcUnos.gridy = 0;
			gbcUnos.fill = GridBagConstraints.BOTH;
			gbcUnos.insets = new Insets(10,30,30,10);
			centerPanel.add(labelaIndeks, gbcUnos);
			
			unosIndeks = new JTextField();
			unosIndeks.setPreferredSize(new Dimension(250, 30));
			unosIndeks.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					potvrda.setEnabled(proveriUnos());
					if(uslov)
						unosIndeks.setBackground(Color.WHITE);
					else
						unosIndeks.setBackground(new Color(255, 166, 166));
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			gbcUnos.gridx = 1;
			gbcUnos.gridy = 0;
			gbcUnos.gridwidth = 2;
			gbcUnos.insets = new Insets(10,30,30,30);
			centerPanel.add(unosIndeks, gbcUnos);
			
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
			gbcOdustanak.weightx = 1;
			gbcOdustanak.anchor = GridBagConstraints.EAST;
			gbcOdustanak.insets = new Insets(30, 10, 10, 10);
			centerPanel.add(odustanak, gbcOdustanak);
			
			potvrda = new JButton("Potvrda");
			potvrda.setPreferredSize(new Dimension(100, 25));
			potvrda.setEnabled(false);
			potvrda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
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
		
		private Boolean proveriUnos() {
			brojIndeksa = unosIndeks.getText();
			Boolean povratnaVrednost = false;
			if(brojIndeksa.matches("[a-z][a-z]\\-([00]?[1-9]|0?[1-9][0-9]|[1-9][0-9][0-9])\\-20[0-9][0-9]")) {
				uslov = true;
				Student s = StudentiKontroler.getInstance().pronadjiPoIndeksu(brojIndeksa);
				if(s != null && s.getTrenutnaGodinaStudija() == godinaStudija)
					povratnaVrednost = true;
			}		
			else
				uslov = false;
			
			return povratnaVrednost;
		}
		
	}

