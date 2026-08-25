package presentacion;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame {
	private JPanel contentPane;
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JTextField textFieldNumReg;
	private JTextField textFieldMesLic;
	private JTextField textFieldPorcentaje;
	private JTextField textFieldWeb;
	private JTextField textFieldCI;
	private JTextField textFieldFechaIng;
	private JTextField textFieldAntecedentes;

	public AltaUsuario() {
		setTitle("Alta Usuario");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 325);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 125, 150, 150, 0 };
		gbl_contentPane.rowHeights = new int[] { 20, 20, 20, 20, 23, 116, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblIngreseNick = new JLabel("Nick:");
		lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseNick = new GridBagConstraints();
		gbc_lblIngreseNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseNick.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseNick.gridx = 0;
		gbc_lblIngreseNick.gridy = 0;
		contentPane.add(lblIngreseNick, gbc_lblIngreseNick);

		textFieldNick = new JTextField();
		GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
		gbc_textFieldNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNick.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNick.gridwidth = 2;
		gbc_textFieldNick.gridx = 1;
		gbc_textFieldNick.gridy = 0;
		contentPane.add(textFieldNick, gbc_textFieldNick);
		textFieldNick.setColumns(10);

		JLabel lblIngreseNombre = new JLabel("Nombre:");
		lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
		gbc_lblIngreseNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseNombre.gridx = 0;
		gbc_lblIngreseNombre.gridy = 1;
		contentPane.add(lblIngreseNombre, gbc_lblIngreseNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblIngreseApellido = new JLabel("Apellido:");
		lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
		gbc_lblIngreseApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseApellido.gridx = 0;
		gbc_lblIngreseApellido.gridy = 2;
		contentPane.add(lblIngreseApellido, gbc_lblIngreseApellido);

		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.gridwidth = 2;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 2;
		contentPane.add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);

		JLabel lblIngreseCorreo = new JLabel("Correo:");
		lblIngreseCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseCorreo = new GridBagConstraints();
		gbc_lblIngreseCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseCorreo.gridx = 0;
		gbc_lblIngreseCorreo.gridy = 3;
		contentPane.add(lblIngreseCorreo, gbc_lblIngreseCorreo);

		textFieldCorreo = new JTextField();
		GridBagConstraints gbc_textFieldCorreo = new GridBagConstraints();
		gbc_textFieldCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCorreo.gridwidth = 2;
		gbc_textFieldCorreo.gridx = 1;
		gbc_textFieldCorreo.gridy = 3;
		contentPane.add(textFieldCorreo, gbc_textFieldCorreo);
		textFieldCorreo.setColumns(10);

		JLabel lblIngreseTipoUsuario = new JLabel("Tipo de Usuario:");
		lblIngreseTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseTipoUsuario = new GridBagConstraints();
		gbc_lblIngreseTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseTipoUsuario.gridx = 0;
		gbc_lblIngreseTipoUsuario.gridy = 4;
		contentPane.add(lblIngreseTipoUsuario, gbc_lblIngreseTipoUsuario);

		JPanel panelTipo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTipo.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		GridBagConstraints gbc_panelTipo = new GridBagConstraints();
		gbc_panelTipo.gridwidth = 2;
		gbc_panelTipo.insets = new Insets(0, 0, 5, 5);
		gbc_panelTipo.fill = GridBagConstraints.BOTH;
		gbc_panelTipo.gridx = 1;
		gbc_panelTipo.gridy = 4;
		contentPane.add(panelTipo, gbc_panelTipo);

		// --- Panel contenedor con CardLayout: se crea primero, con su layout ya
		// asignado ---
		JPanel panelContenedor = new JPanel();
		GridBagConstraints gbc_panelContenedor = new GridBagConstraints();
		gbc_panelContenedor.fill = GridBagConstraints.BOTH;
		gbc_panelContenedor.insets = new Insets(0, 0, 5, 5);
		gbc_panelContenedor.gridwidth = 3;
		gbc_panelContenedor.gridx = 0;
		gbc_panelContenedor.gridy = 5;
		contentPane.add(panelContenedor, gbc_panelContenedor);

		ButtonGroup grupoTipo = new ButtonGroup();

		// --- Radio buttons: se crean DESPUES de panelContenedor, para poder usarla en
		// sus listeners ---
		JRadioButton rdbtnPaciente = new JRadioButton("Paciente");
		panelTipo.add(rdbtnPaciente);
		rdbtnPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelContenedor.getLayout();
				cl.show(panelContenedor, "paciente");
			}
		});
		grupoTipo.add(rdbtnPaciente);

		JRadioButton rdbtnMedico = new JRadioButton("Médico");
		rdbtnMedico.setHorizontalAlignment(SwingConstants.CENTER);
		panelTipo.add(rdbtnMedico);
		rdbtnMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelContenedor.getLayout();
				cl.show(panelContenedor, "medico");
			}
		});
		grupoTipo.add(rdbtnMedico);

		// --- Paneles hijos: se crean, pero se agregan al contenedor UNA SOLA VEZ, ya
		// con su nombre de card ---
		JPanel panelMedico = new JPanel();

		JPanel panelPaciente = new JPanel();
		panelContenedor.setLayout(new CardLayout(0, 0));

		JPanel panelVacio = new JPanel();

		panelContenedor.add(panelVacio, "vacio");
		panelVacio.setLayout(null);
		panelContenedor.add(panelPaciente, "paciente");
		GridBagLayout gbl_panelPaciente = new GridBagLayout();
		gbl_panelPaciente.columnWidths = new int[] { 91, 134, 134 };
		gbl_panelPaciente.rowHeights = new int[] { 20, 20, 20, 20, 0 };
		gbl_panelPaciente.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelPaciente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelPaciente.setLayout(gbl_panelPaciente);

		JLabel lblIngreseFechaNac = new JLabel("Fecha nacimiento:");
		lblIngreseFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseFechaNac = new GridBagConstraints();
		gbc_lblIngreseFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseFechaNac.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseFechaNac.gridx = 0;
		gbc_lblIngreseFechaNac.gridy = 0;
		panelPaciente.add(lblIngreseFechaNac, gbc_lblIngreseFechaNac);

		JFormattedTextField textFieldFechaNac = new JFormattedTextField();
		GridBagConstraints gbc_textFieldFechaNac = new GridBagConstraints();
		gbc_textFieldFechaNac.gridwidth = 2;
		gbc_textFieldFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFechaNac.gridx = 1;
		gbc_textFieldFechaNac.gridy = 0;
		panelPaciente.add(textFieldFechaNac, gbc_textFieldFechaNac);

		JLabel lblIngreseFechaIng = new JLabel("Fecha de ingreso:");
		lblIngreseFechaIng.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseFechaIng = new GridBagConstraints();
		gbc_lblIngreseFechaIng.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseFechaIng.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseFechaIng.gridx = 0;
		gbc_lblIngreseFechaIng.gridy = 1;
		panelPaciente.add(lblIngreseFechaIng, gbc_lblIngreseFechaIng);

		textFieldFechaIng = new JTextField();
		GridBagConstraints gbc_textFieldFechaIng = new GridBagConstraints();
		gbc_textFieldFechaIng.gridwidth = 2;
		gbc_textFieldFechaIng.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaIng.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFechaIng.gridx = 1;
		gbc_textFieldFechaIng.gridy = 1;
		panelPaciente.add(textFieldFechaIng, gbc_textFieldFechaIng);
		textFieldFechaIng.setColumns(10);

		JLabel lblIngreseCI = new JLabel("Documento:");
		lblIngreseCI.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseCI = new GridBagConstraints();
		gbc_lblIngreseCI.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseCI.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseCI.gridx = 0;
		gbc_lblIngreseCI.gridy = 2;
		panelPaciente.add(lblIngreseCI, gbc_lblIngreseCI);

		textFieldCI = new JTextField();
		GridBagConstraints gbc_textFieldCI = new GridBagConstraints();
		gbc_textFieldCI.gridwidth = 2;
		gbc_textFieldCI.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCI.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCI.gridx = 1;
		gbc_textFieldCI.gridy = 2;
		panelPaciente.add(textFieldCI, gbc_textFieldCI);
		textFieldCI.setColumns(10);

		JLabel lblIngreseAntecedentes = new JLabel("Antecedentes:");
		lblIngreseAntecedentes.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseAntecedentes = new GridBagConstraints();
		gbc_lblIngreseAntecedentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseAntecedentes.insets = new Insets(0, 0, 0, 5);
		gbc_lblIngreseAntecedentes.gridx = 0;
		gbc_lblIngreseAntecedentes.gridy = 3;
		panelPaciente.add(lblIngreseAntecedentes, gbc_lblIngreseAntecedentes);

		textFieldAntecedentes = new JTextField();
		textFieldAntecedentes.setColumns(10);
		GridBagConstraints gbc_textFieldAntecedentes = new GridBagConstraints();
		gbc_textFieldAntecedentes.gridwidth = 2;
		gbc_textFieldAntecedentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAntecedentes.gridx = 1;
		gbc_textFieldAntecedentes.gridy = 3;
		panelPaciente.add(textFieldAntecedentes, gbc_textFieldAntecedentes);
		panelContenedor.add(panelMedico, "medico");
		GridBagLayout gbl_panelMedico = new GridBagLayout();
		gbl_panelMedico.columnWidths = new int[] { 91, 134, 134 };
		gbl_panelMedico.rowHeights = new int[] { 20, 20, 20, 20, 0 };
		gbl_panelMedico.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelMedico.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelMedico.setLayout(gbl_panelMedico);

		JLabel lblIngreseNumReg = new JLabel("Numero Registro: ");
		lblIngreseNumReg.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseNumReg = new GridBagConstraints();
		gbc_lblIngreseNumReg.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseNumReg.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseNumReg.gridx = 0;
		gbc_lblIngreseNumReg.gridy = 0;
		panelMedico.add(lblIngreseNumReg, gbc_lblIngreseNumReg);

		textFieldNumReg = new JTextField();
		GridBagConstraints gbc_textFieldNumReg = new GridBagConstraints();
		gbc_textFieldNumReg.gridwidth = 2;
		gbc_textFieldNumReg.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumReg.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNumReg.gridx = 1;
		gbc_textFieldNumReg.gridy = 0;
		panelMedico.add(textFieldNumReg, gbc_textFieldNumReg);
		textFieldNumReg.setColumns(10);

		JLabel lblIngreseMesLic = new JLabel("Mes Licencia:");
		lblIngreseMesLic.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseMesLic = new GridBagConstraints();
		gbc_lblIngreseMesLic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseMesLic.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseMesLic.gridx = 0;
		gbc_lblIngreseMesLic.gridy = 1;
		panelMedico.add(lblIngreseMesLic, gbc_lblIngreseMesLic);

		textFieldMesLic = new JTextField();
		GridBagConstraints gbc_textFieldMesLic = new GridBagConstraints();
		gbc_textFieldMesLic.gridwidth = 2;
		gbc_textFieldMesLic.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMesLic.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMesLic.gridx = 1;
		gbc_textFieldMesLic.gridy = 1;
		panelMedico.add(textFieldMesLic, gbc_textFieldMesLic);
		textFieldMesLic.setColumns(10);

		JLabel lblIngresePorcentaje = new JLabel("% adicional:");
		lblIngresePorcentaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngresePorcentaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblIngresePorcentaje = new GridBagConstraints();
		gbc_lblIngresePorcentaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngresePorcentaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresePorcentaje.gridx = 0;
		gbc_lblIngresePorcentaje.gridy = 2;
		panelMedico.add(lblIngresePorcentaje, gbc_lblIngresePorcentaje);

		textFieldPorcentaje = new JTextField();
		GridBagConstraints gbc_textFieldPorcentaje = new GridBagConstraints();
		gbc_textFieldPorcentaje.gridwidth = 2;
		gbc_textFieldPorcentaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPorcentaje.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPorcentaje.gridx = 1;
		gbc_textFieldPorcentaje.gridy = 2;
		panelMedico.add(textFieldPorcentaje, gbc_textFieldPorcentaje);
		textFieldPorcentaje.setColumns(10);

		JLabel lblIngreseWeb = new JLabel("Web:");
		lblIngreseWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseWeb = new GridBagConstraints();
		gbc_lblIngreseWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreseWeb.insets = new Insets(0, 0, 0, 5);
		gbc_lblIngreseWeb.gridx = 0;
		gbc_lblIngreseWeb.gridy = 3;
		panelMedico.add(lblIngreseWeb, gbc_lblIngreseWeb);

		textFieldWeb = new JTextField();
		GridBagConstraints gbc_textFieldWeb = new GridBagConstraints();
		gbc_textFieldWeb.gridwidth = 2;
		gbc_textFieldWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWeb.gridx = 1;
		gbc_textFieldWeb.gridy = 3;
		panelMedico.add(textFieldWeb, gbc_textFieldWeb);
		textFieldWeb.setColumns(10);

		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 2;
		gbc_panelBotones.gridy = 6;
		contentPane.add(panelBotones, gbc_panelBotones);

		JButton btnAceptar = new JButton("Aceptar");
		panelBotones.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
	}
}