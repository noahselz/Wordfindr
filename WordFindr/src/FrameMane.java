

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class FrameMane extends JFrame {

	private JPanel contentPane;
	private JTextField txtNxN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMane frame = new FrameMane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameMane() {
		setMinimumSize(new Dimension(300, 250));
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panelN = new JPanel();
		panelN.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panelN);
		panelN.setLayout(new BoxLayout(panelN, BoxLayout.Y_AXIS));
		
		JLabel lblInsertSizeOf = new JLabel("Insert Size of Grid");
		lblInsertSizeOf.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelN.add(lblInsertSizeOf);
		
		JSlider nSlider = new JSlider();
		nSlider.setMajorTickSpacing(1);
		nSlider.setMinimum(2);
		nSlider.setMaximum(4);
		nSlider.setSnapToTicks(true);
		nSlider.setPaintLabels(true);
		panelN.add(nSlider);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		contentPane.add(verticalGlue_1);
		
		JPanel panelNxN = new JPanel();
		panelNxN.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panelNxN);
		panelNxN.setLayout(new BoxLayout(panelNxN, BoxLayout.Y_AXIS));
		
		JLabel lblNxN = new JLabel("Input N x N length String");
		lblNxN.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelNxN.add(lblNxN);
		
		txtNxN = new JTextField();
		txtNxN.setHorizontalAlignment(SwingConstants.CENTER);
		txtNxN.setMaximumSize(new Dimension(1000, 26));
		panelNxN.add(txtNxN);
		txtNxN.setColumns(10);
		
		Component verticalGlue = Box.createVerticalGlue();
		contentPane.add(verticalGlue);
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panelM);
		panelM.setLayout(new BoxLayout(panelM, BoxLayout.Y_AXIS));
		
		JLabel lblPickWordLength = new JLabel("Pick Word Length");
		lblPickWordLength.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelM.add(lblPickWordLength);
		
		JSlider mSlider = new JSlider();
		mSlider.setSnapToTicks(true);
		mSlider.setPaintLabels(true);
		mSlider.setPaintTicks(true);
		mSlider.setMinimum(2);
		mSlider.setMaximum(8);
		mSlider.setMajorTickSpacing(1);
		panelM.add(mSlider);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		panelM.add(verticalGlue_2);
		
		JPanel panelGo = new JPanel();
		panelGo.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panelGo);
		panelGo.setLayout(new BoxLayout(panelGo, BoxLayout.X_AXIS));
		
		JButton btnGo = new JButton("Go");
		panelGo.add(btnGo);
		
	}

}