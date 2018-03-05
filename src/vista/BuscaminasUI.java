package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscaminasUI extends JFrame {

	protected JPanel contentPane;
	protected JButton btnNewButton;
	protected JPanel panel;

	/**
	 * Create the frame.
	 */
	public BuscaminasUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 23, 434, 438);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("btntest");
		btnNewButton.setName("btntest");
		btnNewButton.setBounds(165, 0, 89, 23);
		contentPane.add(btnNewButton);
	}
}
