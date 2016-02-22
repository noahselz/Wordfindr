

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ResultsWindow extends JDialog {
	public ResultsWindow() {
		setTitle("Results");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list, BorderLayout.CENTER);
	}

}
