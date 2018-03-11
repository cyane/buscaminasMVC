package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Densidad;
import control.ParaBuscaminasUI;
import control.Tamanio;
import utiles.ImageFondo;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class BuscaminasUI extends JFrame {
	protected Densidad densidad;
	protected Tamanio tamanio;
	protected JPanel contentPane;
	protected JLabel lblCantidadMinas;
	protected JButton btnIniciarGame;
	protected JPanel contenedorBotonera;
	protected JPanel panel;
	protected JPanel panelPostGame;
	protected JPanel panelIngame;
	protected JPanel panelInicial;
	protected JButton btnGana;
	protected JRadioButton rdbtnfacil;
	protected JRadioButton rdbtnmedio;
	protected JRadioButton rdbtndificil;
	protected JComboBox<?> comboBox;
	protected JRadioButton rdbtnExperimental;
	protected JTextField txtMinas;
	protected JTextField txtColumnas;
	private JLabel lblNewLabel_1;
	protected JTextField txtFilas;
	private JLabel lblFilas;
	private JPanel panelExperi;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Create the frame.
	 */
	public BuscaminasUI(String img) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimensiones = tk.getScreenSize();
		setBounds((int) dimensiones.getWidth() / 4, (int) dimensiones.getHeight() / 4, (int) dimensiones.getWidth() / 2,
				(int) dimensiones.getHeight() / 2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		panelInicial = new ImageFondo(img);
		contentPane.add(panelInicial, "name_panelInicial");
		GridBagLayout gbl_panelInicial = new GridBagLayout();
		gbl_panelInicial.columnWidths = new int[] { 160, 146, 133, 71, 0 };
		gbl_panelInicial.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 40 };
		gbl_panelInicial.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelInicial.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		panelInicial.setLayout(gbl_panelInicial);
		ButtonGroup grupoDificultad = new ButtonGroup();

		panelIngame = new JPanel();
		contentPane.add(panelIngame, "name_panelIngame");
		GridBagLayout gbl_panelIngame = new GridBagLayout();
		gbl_panelIngame.columnWidths = new int[] { 0, 344, 344, 344, 344, 0, 0 };
		gbl_panelIngame.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelIngame.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelIngame.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelIngame.setLayout(gbl_panelIngame);

		JLabel lblNewLabel = new JLabel("TITULO");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panelIngame.add(lblNewLabel, gbc_lblNewLabel);

		contenedorBotonera = new JPanel();
		contenedorBotonera.setLayout(null);
		GridBagConstraints gbc_contenedorBotonera = new GridBagConstraints();
		gbc_contenedorBotonera.gridwidth = 4;
		gbc_contenedorBotonera.insets = new Insets(0, 0, 5, 5);
		gbc_contenedorBotonera.fill = GridBagConstraints.BOTH;
		gbc_contenedorBotonera.gridx = 1;
		gbc_contenedorBotonera.gridy = 1;
		panelIngame.add(contenedorBotonera, gbc_contenedorBotonera);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(50, 50, 1300, 600);
		contenedorBotonera.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblMinas = new JLabel("Minas: ");
		GridBagConstraints gbc_lblMinas = new GridBagConstraints();
		gbc_lblMinas.anchor = GridBagConstraints.EAST;
		gbc_lblMinas.insets = new Insets(0, 0, 0, 5);
		gbc_lblMinas.gridx = 2;
		gbc_lblMinas.gridy = 2;
		panelIngame.add(lblMinas, gbc_lblMinas);

		lblCantidadMinas = new JLabel("");
		GridBagConstraints gbc_lblCantidadMinas = new GridBagConstraints();
		gbc_lblCantidadMinas.anchor = GridBagConstraints.WEST;
		gbc_lblCantidadMinas.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidadMinas.gridx = 3;
		gbc_lblCantidadMinas.gridy = 2;
		panelIngame.add(lblCantidadMinas, gbc_lblCantidadMinas);

		button = new JButton("REINICIAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ParaBuscaminasUI frame = new ParaBuscaminasUI(img);
				frame.setVisible(true);
			}
		});
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 2;
		panelIngame.add(button, gbc_button);

		panelPostGame = new JPanel();
		contentPane.add(panelPostGame, "name_panelPostGame");
		GridBagLayout gbl_panelPostGame = new GridBagLayout();
		gbl_panelPostGame.columnWidths = new int[] { 213, 217, 0 };
		gbl_panelPostGame.rowHeights = new int[] { 203, 42, 0 };
		gbl_panelPostGame.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelPostGame.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panelPostGame.setLayout(gbl_panelPostGame);

		btnNewButton = new JButton("REINICIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ParaBuscaminasUI frame = new ParaBuscaminasUI(img);
				frame.setVisible(true);
			}
		});

		btnGana = new JButton("");
		btnGana.setName("btnGana");
		GridBagConstraints gbc_btnGana = new GridBagConstraints();
		gbc_btnGana.gridwidth = 2;
		gbc_btnGana.insets = new Insets(0, 0, 5, 5);
		gbc_btnGana.fill = GridBagConstraints.BOTH;
		gbc_btnGana.gridx = 0;
		gbc_btnGana.gridy = 0;
		panelPostGame.add(btnGana, gbc_btnGana);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panelPostGame.add(btnNewButton, gbc_btnNewButton);

		btnIniciarGame = new JButton("Start Game");
		btnIniciarGame.setContentAreaFilled(false);
		btnIniciarGame.setBorderPainted(false);
		btnIniciarGame.setBorder(null);
		btnIniciarGame.setForeground(Color.BLACK);
		btnIniciarGame.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		btnIniciarGame.setOpaque(false);
		btnIniciarGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCurrentPanel("name_panelIngame");

			}
		});

		btnIniciarGame.setName("btnIniciarGame");
		btnIniciarGame.setVisible(false);

		rdbtndificil = new JRadioButton("dificil");
		rdbtndificil.setForeground(Color.ORANGE);
		rdbtndificil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtndificil.setOpaque(false);
		rdbtndificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setDensidad(Densidad.dificil);
				panelInicial.setBackground(Color.yellow);
				btnIniciarGame.setVisible(true);
				panelExperi.setVisible(false);
				comboBox.setVisible(true);
			}
		});

		rdbtnmedio = new JRadioButton("medio");
		rdbtnmedio.setForeground(Color.ORANGE);
		rdbtnmedio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtnmedio.setOpaque(false);
		rdbtnmedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setDensidad(Densidad.medio);
				panelInicial.setBackground(Color.green);
				btnIniciarGame.setVisible(true);
				panelExperi.setVisible(false);
				comboBox.setVisible(true);
			}
		});

		rdbtnfacil = new JRadioButton("facil");
		rdbtnfacil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtnfacil.setForeground(Color.ORANGE);
		rdbtnfacil.setOpaque(false);
		rdbtnfacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setDensidad(Densidad.facil);
				panelInicial.setBackground(Color.BLACK);
				btnIniciarGame.setVisible(true);
				panelExperi.setVisible(false);
				comboBox.setVisible(true);
			}
		});
		GridBagConstraints gbc_rdbtnfacil = new GridBagConstraints();
		gbc_rdbtnfacil.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnfacil.gridx = 0;
		gbc_rdbtnfacil.gridy = 2;
		panelInicial.add(rdbtnfacil, gbc_rdbtnfacil);
		grupoDificultad.add(rdbtnfacil);
		GridBagConstraints gbc_rdbtnmedio = new GridBagConstraints();
		gbc_rdbtnmedio.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnmedio.gridx = 1;
		gbc_rdbtnmedio.gridy = 2;
		panelInicial.add(rdbtnmedio, gbc_rdbtnmedio);
		grupoDificultad.add(rdbtnmedio);
		GridBagConstraints gbc_rdbtndificil = new GridBagConstraints();
		gbc_rdbtndificil.gridwidth = 2;
		gbc_rdbtndificil.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtndificil.gridx = 2;
		gbc_rdbtndificil.gridy = 2;
		panelInicial.add(rdbtndificil, gbc_rdbtndificil);
		grupoDificultad.add(rdbtndificil);

		rdbtnExperimental = new JRadioButton("experimental");
		rdbtnExperimental.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtnExperimental.setForeground(Color.ORANGE);
		rdbtnExperimental.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelInicial.setBackground(Color.RED);
				panelExperi.setVisible(true);
				comboBox.setVisible(false);
				btnIniciarGame.setVisible(true);

			}
		});
		rdbtnExperimental.setOpaque(false);
		GridBagConstraints gbc_rdbtnExperimental = new GridBagConstraints();
		gbc_rdbtnExperimental.gridheight = 3;
		gbc_rdbtnExperimental.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnExperimental.gridx = 0;
		gbc_rdbtnExperimental.gridy = 3;
		panelInicial.add(rdbtnExperimental, gbc_rdbtnExperimental);
		grupoDificultad.add(rdbtnExperimental);

		comboBox = new JComboBox<Object>(Tamanio.values());
		comboBox.setBorder(null);
		comboBox.setOpaque(false);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem() == Tamanio.pequenio) {
					rdbtndificil.setVisible(false);
				} else {
					rdbtndificil.setVisible(true);
				}
			}
		});
		comboBox.setVisible(false);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridheight = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panelInicial.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnTest = new GridBagConstraints();
		gbc_btnTest.insets = new Insets(0, 0, 0, 5);
		gbc_btnTest.gridx = 1;
		gbc_btnTest.gridy = 6;
		panelInicial.add(btnIniciarGame, gbc_btnTest);

		panelExperi = new JPanel();
		panelExperi.setVisible(false);
		panelExperi.setOpaque(false);
		GridBagConstraints gbc_panelExperi = new GridBagConstraints();
		gbc_panelExperi.gridwidth = 2;
		gbc_panelExperi.gridheight = 3;
		gbc_panelExperi.fill = GridBagConstraints.BOTH;
		gbc_panelExperi.gridx = 2;
		gbc_panelExperi.gridy = 3;
		panelInicial.add(panelExperi, gbc_panelExperi);
		panelExperi.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblMinasPerso = new JLabel("Minas:");
		lblMinasPerso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMinasPerso.setHorizontalAlignment(SwingConstants.RIGHT);
		panelExperi.add(lblMinasPerso);

		txtMinas = new JTextField();
		txtMinas.setBorder(null);
		txtMinas.setOpaque(false);
		txtMinas.setText("20");
		txtMinas.setForeground(new Color(0, 0, 0));
		txtMinas.setHorizontalAlignment(SwingConstants.CENTER);
		panelExperi.add(txtMinas);
		txtMinas.setColumns(10);

		lblNewLabel_1 = new JLabel("Columnas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelExperi.add(lblNewLabel_1);

		txtColumnas = new JTextField();
		txtColumnas.setBorder(null);
		txtColumnas.setOpaque(false);
		txtColumnas.setText("10");
		txtColumnas.setHorizontalAlignment(SwingConstants.CENTER);
		panelExperi.add(txtColumnas);
		txtColumnas.setColumns(10);

		lblFilas = new JLabel("Filas:");
		lblFilas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFilas.setHorizontalAlignment(SwingConstants.RIGHT);
		panelExperi.add(lblFilas);

		txtFilas = new JTextField();
		txtFilas.setBorder(null);
		txtFilas.setOpaque(false);
		txtFilas.setText("10");
		txtFilas.setHorizontalAlignment(SwingConstants.CENTER);
		panelExperi.add(txtFilas);
		txtFilas.setColumns(10);
	}

	public void getCurrentPanel(String name) {
		((CardLayout) contentPane.getLayout()).show(contentPane, name);
	}

	public void setDensidad(Densidad densidad) {
		assert densidad != null;
		this.densidad = densidad;
	}

}
