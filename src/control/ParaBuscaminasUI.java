package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vista.Botonera;
import vista.BuscaminasUI;

public class ParaBuscaminasUI extends BuscaminasUI {
	Iniciador iniciador = new Iniciador();
	Marcador marcador = new Marcador();
	private Botonera botonera;
	private Tablero tablero;
	MyActionListener listener = new MyActionListener(this);
	private Casilla[][] casillas;
	Desvelador desvelador;

	// imagenes
	protected ImageIcon bandera = new ImageIcon(getClass().getResource("/assets/bandera.jpg"));
	private ImageIcon imagenGana = new ImageIcon(getClass().getResource("/assets/gana.png"));
	private ImageIcon imagenPierde = new ImageIcon(getClass().getResource("/assets/pierde.jpg"));
	private ImageIcon bosque = new ImageIcon(getClass().getResource("/assets/bosque.jpg"));
	private ImageIcon saposFinal = new ImageIcon(getClass().getResource("/assets/saposFinal.jpg"));

	public ParaBuscaminasUI(String img) {
		super(img);
		// boton de "start game"
		btnIniciarGame.addActionListener(listener);

	}

	/**
	 * crea el tablero de juego, inserta la botonera en el panel
	 */
	public void crearTablero() {
		ponerValoresPredefODados();
		this.casillas = tablero.getCasillas();
		this.desvelador = new Desvelador(tablero, casillas);
		cambiarFrame();
		ponerListener();
	}

	/**
	 * pone los listener en los botones de la botonera
	 */
	private void ponerListener() {
		btnGana.addActionListener(listener);
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
				this.botonera.botones[i][j].addMouseListener(listener);
			}
		}
	}

	/**
	 * si el boton personalizado esta activado, pone esos datos, si no pone los
	 * predeterminados
	 */
	private void ponerValoresPredefODados() {
		int[] valores = { Integer.valueOf(txtMinas.getText()), Integer.valueOf(txtFilas.getText()),
				Integer.valueOf(txtColumnas.getText()) };
		if (rdbtnExperimental.isSelected()) {
			this.tablero = this.iniciador.iniciarJuego(densidad, (Tamanio) comboBox.getSelectedItem(), true, valores);
		} else {
			this.tablero = this.iniciador.iniciarJuego(densidad, (Tamanio) comboBox.getSelectedItem(), false, valores);
		}
	}

	/**
	 * actualiza el tablero despues de cada jugada para que las casillas cambien
	 * segun lo ocurrido
	 * 
	 * @param vendra
	 *            en true si han dado en una mina
	 * @return booleano que dice si has ganado o no
	 */
	protected boolean actualizar(boolean perdida) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimensiones = tk.getScreenSize();// dimensiones de la pantalla
		int contador = 0; // contador de casillas desveladas para comprobar win
		lblCantidadMinas.setText(String.valueOf(iniciador.getMinas()));
		// for que recorre todos los botones y casillas
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				JButton boton = this.botonera.botones[i][j];
				Casilla casilla = casillas[i][j];
				if (!casilla.isVelada()) {// si la casilla esa desvelada
					contador++; // aumenta por cada casilla desvelada para
								// comprobar win
					if (!perdida) {
						pintarDesveladas(boton, casilla);
					}
				} else if (perdida) {// viene en true si has dado en una minia
					cambiarADerrota(dimensiones, boton, casilla);
				} else {// si la casilla no esta desvelada
					marcarDesmarcarIcono(boton, casilla);
				}
			}
		}
		return comprobarGanador(dimensiones, contador);
	}

	/**
	 * pinta las casillas desveladas segun su numeracion
	 * 
	 * @param boton
	 *            el boton a cambiar graficamente
	 * @param casilla
	 *            la casilla que contiene los datos
	 */
	private void pintarDesveladas(JButton boton, Casilla casilla) {
		boton.setIcon(null);
		if (casilla.getAlrededor() == 0) {
			boton.setBackground(new Color(162, 141, 94));
		} else {
			boton.setBackground(new Color(83, 160, 57));
			boton.setText(String.valueOf(casilla.getAlrededor()));
		}
	}

	/**
	 * pone y quita la bandera del boton si la casilla esta marcada o no
	 * 
	 * @param boton
	 *            boton en el que se pone/quita la bandera
	 * @param para
	 *            comprobar marcada o no
	 */
	private void marcarDesmarcarIcono(JButton boton, Casilla casilla) {
		if (casilla.isMarcada()) {
			boton.setIcon(Utiles.createScaledIcon(bandera, boton.getHeight()));
		} else {
			boton.setIcon(bosque);
		}
	}

	/**
	 * este metodo cambia el tablero al modo de derrota, entra aqui al dar con
	 * una mina
	 * 
	 * @param dimensiones
	 *            las dimensiones de la pantalla
	 * @param boton
	 *            boton a cambiar
	 * @param para
	 *            pintar las minas despues de la derrota
	 */
	private void cambiarADerrota(Dimension dimensiones, JButton boton, Casilla casilla) {
		if (casilla.isMina()) {
			boton.setBackground(new Color(83, 160, 57));
			boton.setIcon(Utiles.createScaledIcon(saposFinal, boton.getHeight())); // img de las bombas
		}
		boton.setName("s");
		btnGana.setIcon(Utiles.createScaledIcon(imagenPierde, btnGana.getHeight()));
		setBounds((int) (dimensiones.getWidth() / 3), (int) (dimensiones.getHeight() / 5), 666, 559);
		getCurrentPanel("name_panelPostGame");
	}

	/**
	 * el metodo comprueba la victoria y cambia la pantalla al modo de victoria
	 * si es asi
	 * 
	 * @param dimensiones
	 *            dimensiones de la pantalla
	 * @param contador
	 *            contador de las casillas desveladas, para comprobar victoria
	 * @return si has ganado o no
	 */
	private boolean comprobarGanador(Dimension dimensiones, int contador) {
		if (contador == iniciador.getColumnas() * iniciador.getFilas() - iniciador.getMinas()) {
			setBounds((int) (dimensiones.getWidth() / 3), (int) (dimensiones.getHeight() / 8), 666, 738);
			btnGana.setIcon(Utiles.createScaledIcon(imagenGana, btnGana.getHeight()));
			getCurrentPanel("name_panelPostGame");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * cambia mediante el cardlayout el panel activo al panel de juego
	 */
	void ponerTableroGame() {
		medidaTablero();
		getCurrentPanel("name_panelIngame");
	}

	/**
	 * crea la botonera con la que se va ajugar
	 */
	private void cambiarFrame() {
		botonera = new Botonera(iniciador.getFilas(), iniciador.getColumnas());
		medidaTablero();
		panel.add(botonera);
	}

	/**
	 * pone las medidas del tablero
	 */
	private void medidaTablero() {
		setBounds(100, 50, 1400, 750);
	}

	/**
	 * devuelve si la casilla es una mina
	 * 
	 * @param lugar
	 *            coordenadas de la casilla
	 * @return booleano
	 */
	public boolean isMina(Coordenada lugar) {
		return this.casillas[lugar.getPosX()][lugar.getPosY()].isMina();
	}

	/**
	 * devuelve si la casilla esta marcada
	 * 
	 * @param lugar
	 *            coordenadas de la casilla
	 * @return booleano
	 */
	public boolean isMarcada(Coordenada lugar) {
		return this.casillas[lugar.getPosX()][lugar.getPosY()].isMarcada();
	}

	/**
	 * devuelve si la casilla esta velada
	 * 
	 * @param lugar
	 *            coordenadas de la casilla
	 * @return booleano
	 */
	public boolean isVelada(Coordenada lugar) {
		return this.casillas[lugar.getPosX()][lugar.getPosY()].isVelada();
	}

	/**
	 * marca la casilla
	 * 
	 * @param lugar
	 *            coordenadas de la casilla
	 */
	public void marcar(Coordenada lugar) {
		marcador.marcarCasilla(this.casillas[lugar.getPosX()][lugar.getPosY()]);
	}

}
