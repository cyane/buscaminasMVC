package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BuscaminasUI2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblCantidadMinas;
	private JLabel lblCantidadBanderas;
	CardLayout cardLayout;

	/**
	 * Create the frame.
	 */
	public BuscaminasUI2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		
		JPanel panelInicial = new JPanel();
		contentPane.add(panelInicial, "name_panelInicial");
		GridBagLayout gbl_panelInicial = new GridBagLayout();
		gbl_panelInicial.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelInicial.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelInicial.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInicial.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInicial.setLayout(gbl_panelInicial);
		
		JButton btnTestatm = new JButton("testAtm");
		btnTestatm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panelInicial.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnTestatm = new GridBagConstraints();
		gbc_btnTestatm.gridx = 5;
		gbc_btnTestatm.gridy = 2;
		panelInicial.add(btnTestatm, gbc_btnTestatm);
		
		JPanel panelIngame = new JPanel();
		contentPane.add(panelIngame, "name_panelIngame");
		GridBagLayout gbl_panelIngame = new GridBagLayout();
		gbl_panelIngame.columnWidths = new int[]{0, 344, 344, 344, 344, 0, 0};
		gbl_panelIngame.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelIngame.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelIngame.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelIngame.setLayout(gbl_panelIngame);
		
		JLabel lblNewLabel = new JLabel("TITULO");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panelIngame.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel botonera = new JPanel();
		GridBagConstraints gbc_botonera = new GridBagConstraints();
		gbc_botonera.gridwidth = 4;
		gbc_botonera.insets = new Insets(0, 0, 5, 5);
		gbc_botonera.fill = GridBagConstraints.BOTH;
		gbc_botonera.gridx = 1;
		gbc_botonera.gridy = 1;
		panelIngame.add(botonera, gbc_botonera);
		botonera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMinas = new JLabel("Minas: ");
		GridBagConstraints gbc_lblMinas = new GridBagConstraints();
		gbc_lblMinas.anchor = GridBagConstraints.EAST;
		gbc_lblMinas.insets = new Insets(0, 0, 0, 5);
		gbc_lblMinas.gridx = 1;
		gbc_lblMinas.gridy = 2;
		panelIngame.add(lblMinas, gbc_lblMinas);
		
		lblCantidadMinas = new JLabel("");
		GridBagConstraints gbc_lblCantidadMinas = new GridBagConstraints();
		gbc_lblCantidadMinas.anchor = GridBagConstraints.WEST;
		gbc_lblCantidadMinas.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidadMinas.gridx = 2;
		gbc_lblCantidadMinas.gridy = 2;
		panelIngame.add(lblCantidadMinas, gbc_lblCantidadMinas);
		
		JLabel lblBanderas = new JLabel("Banderas:");
		GridBagConstraints gbc_lblBanderas = new GridBagConstraints();
		gbc_lblBanderas.anchor = GridBagConstraints.EAST;
		gbc_lblBanderas.insets = new Insets(0, 0, 0, 5);
		gbc_lblBanderas.gridx = 3;
		gbc_lblBanderas.gridy = 2;
		panelIngame.add(lblBanderas, gbc_lblBanderas);
		
		lblCantidadBanderas = new JLabel("");
		GridBagConstraints gbc_lblCantidadBanderas = new GridBagConstraints();
		gbc_lblCantidadBanderas.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidadBanderas.gridx = 4;
		gbc_lblCantidadBanderas.gridy = 2;
		panelIngame.add(lblCantidadBanderas, gbc_lblCantidadBanderas);
		
		JPanel panelPostGame = new JPanel();
		contentPane.add(panelPostGame, "name_panelPostGame");
		GridBagLayout gbl_panelPostGame = new GridBagLayout();
		gbl_panelPostGame.columnWidths = new int[]{0};
		gbl_panelPostGame.rowHeights = new int[]{0};
		gbl_panelPostGame.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelPostGame.rowWeights = new double[]{Double.MIN_VALUE};
		panelPostGame.setLayout(gbl_panelPostGame);
		

	}

}