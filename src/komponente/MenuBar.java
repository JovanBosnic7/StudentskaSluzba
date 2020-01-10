package komponente;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = -5149647733879041189L;

	private JMenu menuFile;
	private JMenuItem itemNew;
	private JMenuItem itemClose;
	
	private JMenu menuEdit;
	private JMenuItem itemEdit;
	private JMenuItem itemDelete;
	
	private JMenu menuHelp;
	private JMenuItem itemHelp;
	private JMenuItem itemAbout;
	
	public MenuBar() {
		menuFile = new JMenu("File");
		itemNew = new JMenuItem("New");
		itemClose = new JMenuItem("Close");
		
		itemNew.setPreferredSize(new Dimension(200, 25));
		itemNew.setIcon(new ImageIcon("slike/plus.png"));
		itemNew.setMnemonic(KeyEvent.VK_N);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		itemNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tip tip = Tip.getTip(TabbedPane.getInstance().getSelectedIndex());
				if(tip == Tip.STUDENT) {
					DodavanjeStudentaDijalog dijalogStudent = new DodavanjeStudentaDijalog();
					dijalogStudent.setLocationRelativeTo(MainFrame.getInstance());
					dijalogStudent.setVisible(true);
				}
				if(tip == Tip.PROFESOR) {
					DijalogZaDodavanjeProfesora dijalogProfesor = new DijalogZaDodavanjeProfesora();
					dijalogProfesor.setLocationRelativeTo(MainFrame.getInstance());
					dijalogProfesor.setVisible(true);
				}
				if(tip == Tip.PREDMET) {
					DijalogZaDodavanjePredmeta dijalogPredmet=new DijalogZaDodavanjePredmeta();
					dijalogPredmet.setLocationRelativeTo(MainFrame.getInstance());
					dijalogPredmet.setVisible(true);
				}
				
			}
		});
		
		itemClose.setIcon(new ImageIcon("slike/x.png"));
		itemClose.setPreferredSize(new Dimension(200, 25));
		itemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		itemClose.setMnemonic(KeyEvent.VK_C);
		itemClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowEvent winEvent = new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING);
				MainFrame.getInstance().dispatchEvent(winEvent);
				
			}
		});
		
		menuFile.setMnemonic(KeyEvent.VK_F);
		
		menuFile.add(itemNew);
		menuFile.addSeparator();
		menuFile.add(itemClose);
		
		menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic(KeyEvent.VK_E);
		itemEdit = new JMenuItem("Edit");
		itemDelete = new JMenuItem("Delete");
		
		itemEdit.setPreferredSize(new Dimension(200, 25));
		itemEdit.setIcon(new ImageIcon("slike/edit.png"));
		itemEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		itemEdit.setMnemonic(KeyEvent.VK_E);
		itemEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tip tip = Tip.getTip(TabbedPane.getInstance().getSelectedIndex());
				if(tip == Tip.STUDENT) {
					int row = TabelaStudenata.getInstance().getSelectedRow();
					DodavanjeStudentaDijalog dijalogStudent = new DodavanjeStudentaDijalog(row);
					dijalogStudent.setLocationRelativeTo(MainFrame.getInstance());
					if(row>=0)
						dijalogStudent.setVisible(true);
				}
				if(tip == Tip.PROFESOR) {
					int row = TabelaProfesora.getInstance().getSelectedRow();
					DijalogZaDodavanjeProfesora dijalogProfesor = new DijalogZaDodavanjeProfesora(row);
					dijalogProfesor.setLocationRelativeTo(MainFrame.getInstance());
					if(row >=0)
						dijalogProfesor.setVisible(true);
				}
				if(tip == Tip.PREDMET) {
					int row = TabelaPredmeta.getInstance().getSelectedRow();
					DijalogZaDodavanjePredmeta dijalogPredmet=new DijalogZaDodavanjePredmeta(row);
					dijalogPredmet.setLocationRelativeTo(MainFrame.getInstance());
					if(row >= 0)
						dijalogPredmet.setVisible(true);
				}
				
			}
		});
		
		itemDelete.setPreferredSize(new Dimension(200, 25));
		itemDelete.setIcon(new ImageIcon("slike/delete.png"));
		itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		itemDelete.setMnemonic(KeyEvent.VK_D);
		itemDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tip tip = Tip.getTip(TabbedPane.getInstance().getSelectedIndex());
				if(tip == Tip.STUDENT) {
					int row = TabelaStudenata.getInstance().getSelectedRow();
					BrisanjeStudentaDijalog dijalogBrisanjeStudenta = new BrisanjeStudentaDijalog(row);
					dijalogBrisanjeStudenta.setLocationRelativeTo(MainFrame.getInstance());
					if(row>=0)
						dijalogBrisanjeStudenta.setVisible(true);
				}
				if(tip == Tip.PROFESOR) {
					int row = TabelaProfesora.getInstance().getSelectedRow();
					DijalogZaBrisanjeProfesora dijalogBrisanjeProfesora = new DijalogZaBrisanjeProfesora(row);
					dijalogBrisanjeProfesora.setLocationRelativeTo(MainFrame.getInstance());
					if(row >=0)
						dijalogBrisanjeProfesora.setVisible(true);
				}
				if(tip == Tip.PREDMET) {
					int row = TabelaPredmeta.getInstance().getSelectedRow();
					DijalogZaBrisanjePredmeta dijalogBrisanjePredmet=new DijalogZaBrisanjePredmeta(row);
					dijalogBrisanjePredmet.setLocationRelativeTo(MainFrame.getInstance());
					if(row >= 0)
					dijalogBrisanjePredmet.setVisible(true);
				}
			}
		});
		
		menuEdit.add(itemEdit);
		menuEdit.addSeparator();
		menuEdit.add(itemDelete);
		
		menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		itemHelp = new JMenuItem("Help");
		itemAbout = new JMenuItem("About");
		
		itemHelp.setPreferredSize(new Dimension(200, 25));
		itemHelp.setIcon(new ImageIcon("slike/help.png"));
		itemHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
		itemHelp.setMnemonic(KeyEvent.VK_H);
		itemHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDijalog help = new HelpDijalog();
				
			}
		});
		
		itemAbout.setPreferredSize(new Dimension(200, 25));
		itemAbout.setIcon(new ImageIcon("slike/about.png"));
		itemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		itemAbout.setMnemonic(KeyEvent.VK_A);
		itemAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Studentska slu\u017Eba verzija 1.0\nAplikacija namenjena"
						+ " za vo\u0111enje "
						+ "evidencije o studentima, profesorima i predmetima\n"
						+ "RA176/2017, Aleksandar Stevanovi\u010B, \u0160abac, Srbija\n"
						+ "RA173/2017, Jovan Bosni\u010B, \u0160abac, Srbija\n", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		menuHelp.add(itemHelp);
		menuHelp.addSeparator();
		menuHelp.add(itemAbout);
		
		add(menuFile);
		add(menuEdit);
		add(menuHelp);
	}

}
