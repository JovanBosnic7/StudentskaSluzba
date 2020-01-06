package komponente;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumnStudenti extends AbstractCellEditor
		implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = -7872655180510450596L;
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;
	private Point position;

	public ButtonColumnStudenti(JTable table, int column) {
		this.position = new Point();
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		this.renderButton = new JButton("Predmeti");
		this.editorButton = new JButton("Predmeti");

		this.editorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				int row = TabelaStudenata.getInstance().getSelectedRow();
				SpisakPredmetaStudent spisak = new SpisakPredmetaStudent(row, position);
				if (row >= 0)
					spisak.setVisible(true);
			}
		});

		this.isEditorActive = false;

	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return new PanelSaTabelama(this.renderButton, 0);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		return new PanelSaTabelama(this.editorButton, 0);
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			position.setLocation(e.getLocationOnScreen());
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
