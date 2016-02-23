

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ResultsWindow extends JDialog {
	public ResultsWindow(String[] results) {
		setTitle("Results");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		this.setModal(true);
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk);
		
		JList list = new JList(results);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list, BorderLayout.CENTER);
	}

}
