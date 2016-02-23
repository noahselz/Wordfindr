

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setSize(255, 350);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Closes on OK
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnOk);
		
		JList list = new JList(results);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list, BorderLayout.CENTER);
	}

}
