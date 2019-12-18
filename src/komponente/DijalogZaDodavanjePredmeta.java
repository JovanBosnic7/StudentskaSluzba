package komponente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

public class DijalogZaDodavanjePredmeta extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7545776025882740463L;
	private JLabel labelSifraPredmeta;
	private JLabel labelNazivPredmeta;
	private JLabel labelSemestar;
	private JLabel labelGodinaUKojojeSePredmetIzvodi;
	private JLabel labelProfesor;
	
	private JTextField unosPretrage;
	private JTextField unosPretrage1;
	private JTextField unosPretrage2;
	private JTextField unosPretrage3;
	private JTextField unosPretrage4;
	
	private JButton odustanak;
	private JButton potvrda;
	private JPanel panelBottom;
	private JPanel panelCenter;

	private GridBagConstraints c;
	private GridBagConstraints b;
	
	
	public  DijalogZaDodavanjePredmeta() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(2 * screenDimension.width / 7, screenDimension.height / 2);
		setLocation(screenDimension.width / 2 - getWidth() / 2, screenDimension.height / 2 - getHeight() / 2);
		setTitle("Dodavanje predmeta");
		setModal(true);
		setLocationRelativeTo(null);
//		setLayout(new GridBagLayout());
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		b=new GridBagConstraints();
		b.fill=GridBagConstraints.VERTICAL;
		b.insets=new Insets(10,10 ,10, 100);
		
		labelNazivPredmeta = new JLabel("Naziv predmeta:");
		c.gridx = 0;
		c.gridy = 0;
		c.weightx=100;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets=new Insets(20,20,20,20);
		panelCenter.add(labelNazivPredmeta, c);
		
		labelSifraPredmeta =new JLabel("Sifra predmeta:");
		c.gridx=0;
		c.gridy=1;
		panelCenter.add(labelSifraPredmeta,c);
		
		labelSemestar =new JLabel("Semestar:");
		c.gridx=0;
		c.gridy=2;
		panelCenter.add(labelSemestar,c);
		
		labelGodinaUKojojeSePredmetIzvodi =new JLabel("Godina u kojoj se izvodi:");
		c.gridx=0;
		c.gridy=3;
		panelCenter.add(labelGodinaUKojojeSePredmetIzvodi,c);
		
		
		labelProfesor =new JLabel("Profesor:");
		c.gridx=0;
		c.gridy=4;
		panelCenter.add(labelProfesor,c);
		
		this.add(panelCenter, BorderLayout.CENTER);
		
		
		
		unosPretrage = new JTextField();
		unosPretrage.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 0;
		panelCenter.add(unosPretrage, b);

		unosPretrage1 = new JTextField();
		unosPretrage1.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 1;
		panelCenter.add(unosPretrage1, b);

		unosPretrage2 = new JTextField();
		unosPretrage2.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 2;
		panelCenter.add(unosPretrage2, b);

		unosPretrage3 = new JTextField();
		unosPretrage3.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 3;
		panelCenter.add(unosPretrage3, b);

		unosPretrage4 = new JTextField();
		unosPretrage4.setPreferredSize(new Dimension(200, 20));
		b.gridx = 1;
		b.gridy = 4;
		panelCenter.add(unosPretrage4, b);
		
		odustanak = new JButton("Odustanak");
		odustanak.addActionListener(this);
		
		potvrda = new JButton("Potrvda");
		potvrda.setBackground(new Color(131,237,253));
		potvrda.addActionListener(this);
		
		GridBagConstraints a=new GridBagConstraints();
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridBagLayout());
		a.gridx=0;
		a.gridy=0;
		a.insets=new Insets(40,40,40,40);
		panelBottom.add(odustanak,a);
		a.gridx=1;
		a.gridy=0;
		panelBottom.add(potvrda,a);
		this.add(panelBottom, BorderLayout.SOUTH);
		
		
		
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		if(clicked == odustanak) {
			setVisible(false);
		
		}  if(clicked == potvrda) {
			setVisible(false);
		}
	}

}
