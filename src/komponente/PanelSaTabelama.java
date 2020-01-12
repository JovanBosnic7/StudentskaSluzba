package komponente;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
 
import javax.swing.JPanel;
 
public class PanelSaTabelama extends JPanel {
 
    private static final long serialVersionUID = -3777718742688152316L;
 
    private JPanel leviPanel = new JPanel();
    private JPanel desniPanel = new JPanel();
    private JPanel gornjiPanel = new JPanel();
    private JPanel donjiPanel = new JPanel();
   
    public PanelSaTabelama() {
        setLayout(new BorderLayout());
        add(leviPanel, BorderLayout.WEST);
        leviPanel.setBackground(Color.LIGHT_GRAY);
        add(desniPanel, BorderLayout.EAST);
        desniPanel.setBackground(Color.LIGHT_GRAY);
        add(gornjiPanel, BorderLayout.NORTH);
        gornjiPanel.setBackground(Color.LIGHT_GRAY);
        add(donjiPanel, BorderLayout.SOUTH);
        donjiPanel.setBackground(Color.LIGHT_GRAY);
    }
   
    public PanelSaTabelama(Component c, int pomeraj) {
        this();
        leviPanel.setPreferredSize(new Dimension(0,0));
        desniPanel.setPreferredSize(new Dimension(0,0));
        gornjiPanel.setPreferredSize(new Dimension(pomeraj, pomeraj));
        donjiPanel.setPreferredSize(new Dimension(pomeraj, pomeraj));
        add(c, BorderLayout.CENTER);
       
       
    }
 
    @Override
    public void setBackground(Color bg) {
        // TODO Auto-generated method stub
        super.setBackground(bg);
        if (leviPanel == null || desniPanel == null || donjiPanel == null || gornjiPanel == null)
            return;
        leviPanel.setBackground(bg);
        desniPanel.setBackground(bg);
        gornjiPanel.setBackground(bg);
        donjiPanel.setBackground(bg);
    }
   
   
   
}