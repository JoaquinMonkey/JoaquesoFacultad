package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;
import logica.IControladorUsuario;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {

	private JFrame frmGestionDeUsuarios;
	private IControladorUsuario ICU;
	private AltaUsuario creUsrInternalFrame;
	private ConsultarUsuario conUsrInternalFrame;
	private ListaUsuarios lisUsrInternalFrame;
	private AltaEspecialidad altaEspInternalFrame;
	private AltaBeneficioAnual altaBenAnInternalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmGestionDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();

		// Inicialización
		Fabrica fabrica = Fabrica.getInstance();
		ICU = fabrica.getIControladorUsuario();

		// Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
		// De esta forma, no es necesario crear y destruir objetos lo que enlentece la
		// ejecución.
		// Cada InternalFrame usa un layout diferente, simplemente para mostrar
		// distintas opciones.
		creUsrInternalFrame = new AltaUsuario();
		creUsrInternalFrame.setVisible(false);

		conUsrInternalFrame = new ConsultarUsuario(ICU);
		conUsrInternalFrame.setVisible(false);

		lisUsrInternalFrame = new ListaUsuarios(ICU);
		lisUsrInternalFrame.setVisible(false);
		frmGestionDeUsuarios.getContentPane().setLayout(null);

		altaEspInternalFrame = new AltaEspecialidad();
		altaEspInternalFrame.setVisible(false);

		altaBenAnInternalFrame = new AltaBeneficioAnual(ICU);
		altaBenAnInternalFrame.setVisible(false);

		frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame);
		frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
		frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
		frmGestionDeUsuarios.getContentPane().add(altaEspInternalFrame);
		frmGestionDeUsuarios.getContentPane().add(altaBenAnInternalFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Se crea el Frame con las dimensiones indicadas.
		frmGestionDeUsuarios = new JFrame();
		frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
		frmGestionDeUsuarios.setBounds(100, 100, 450, 400);
		frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
		// Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un
		// evento asociado que permite realizar una acción una vez se seleccionan.
		JMenuBar menuBar = new JMenuBar();
		frmGestionDeUsuarios.setJMenuBar(menuBar);

		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);

		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Salgo de la aplicación
				frmGestionDeUsuarios.setVisible(false);
				frmGestionDeUsuarios.dispose();
			}
		});
		menuSistema.add(menuSalir);

		JMenu menuUsuarios = new JMenu("Usuarios");
		menuBar.add(menuUsuarios);

		JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
		menuItemRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para registrar un usuario
				creUsrInternalFrame.setVisible(true);
			}
		});
		menuUsuarios.add(menuItemRegistrar);

		JMenuItem menuItemVerInfo = new JMenuItem("Consultar Usuario");
		menuItemVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para ver información de un usuario
				conUsrInternalFrame.setVisible(true);
			}
		});
		menuUsuarios.add(menuItemVerInfo);

		JMenuItem menuItemListaUsuarios = new JMenuItem("ListarUsuarios");
		menuItemVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conUsrInternalFrame.cargarUsuarios();
				conUsrInternalFrame.setVisible(true);
			}
		});
		menuUsuarios.add(menuItemListaUsuarios);

		JMenu menuEspecialidades = new JMenu("Especialidades");
		menuBar.add(menuEspecialidades);

		JMenuItem menuItemAltaDeEspecialidad = new JMenuItem("Alta de Especialidad");
		menuItemAltaDeEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEspInternalFrame.setVisible(true);
			}
		});
		menuEspecialidades.add(menuItemAltaDeEspecialidad);

		JMenu menuBeneficiosAnuales = new JMenu("Beneficios Anuales");
		menuBar.add(menuBeneficiosAnuales);

		JMenuItem menuItemAltaDeBeneficio = new JMenuItem("Alta de Beneficio Anual");
		menuItemAltaDeBeneficio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaBenAnInternalFrame.cargarPacientes();
				altaBenAnInternalFrame.setVisible(true);
			}
		});
		menuBeneficiosAnuales.add(menuItemAltaDeBeneficio);

		JMenuItem menuItemConsultaDeBeneficio = new JMenuItem("Consulta de Beneficio Anual");
		menuBeneficiosAnuales.add(menuItemConsultaDeBeneficio);
	}
}
