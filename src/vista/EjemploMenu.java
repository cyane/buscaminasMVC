package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class EjemploMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploMenu frame = new EjemploMenu();
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
	public EjemploMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
				
						JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pulsame");
						menuBar_1.add(mntmNewMenuItem_5);
						mntmNewMenuItem_5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								getCurrentPanel("panelIngame");
							}
						});
		
				JMenuItem mntmNewMenuItem_1 = new JMenuItem("Pulsame");
				menuBar_1.add(mntmNewMenuItem_1);
				mntmNewMenuItem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						getCurrentPanel("panelPregame");
					}

				});
		// creando la barra de menus

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, "panelPregame");

		JLabel lblUno = new JLabel("uno");
		panel.add(lblUno);
		
		JButton btnAlPanel = new JButton("al panel 2");
		panel.add(btnAlPanel);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "panelIngame");

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnAlPanel_1 = new JButton("al panel 1");
		panel_2.add(btnAlPanel_1);
	}

	public void getCurrentPanel(String name) {
		((CardLayout) contentPane.getLayout()).show(contentPane, name);
	}

}

