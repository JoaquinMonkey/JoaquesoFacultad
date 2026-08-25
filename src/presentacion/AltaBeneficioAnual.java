package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import excepciones.UsuarioNoExisteException;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import logica.DataUsuario;
import logica.IControladorUsuario;

@SuppressWarnings("serial")
public class AltaBeneficioAnual extends JInternalFrame {
	private IControladorUsuario controlUsr;
	private JTextField textFieldCantMed;
	private JTextField textFieldAnio;
	private JTextField textFieldCantOrd;
	private JLabel lblIngreseCantMed;
	private JLabel lblIngreseAnio;
	private JLabel lblIngreseCantOrd;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblIngresePaciente;
	private JComboBox<String> comboBoxPacientes;

	public AltaBeneficioAnual(IControladorUsuario icu) {
		controlUsr = icu;

		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Alta de Beneficio Anual");
		setBounds(10, 40, 360, 190);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 120, 120, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gridBagLayout);

		lblIngresePaciente = new JLabel("Paciente:");
		lblIngresePaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngresePaciente = new GridBagConstraints();
		gbc_lblIngresePaciente.anchor = GridBagConstraints.EAST;
		gbc_lblIngresePaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblIngresePaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresePaciente.gridx = 0;
		gbc_lblIngresePaciente.gridy = 0;
		getContentPane().add(lblIngresePaciente, gbc_lblIngresePaciente);

		comboBoxPacientes = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxUsuarios = new GridBagConstraints();
		gbc_comboBoxUsuarios.gridwidth = 2;
		gbc_comboBoxUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxUsuarios.fill = GridBagConstraints.BOTH;
		gbc_comboBoxUsuarios.gridx = 1;
		gbc_comboBoxUsuarios.gridy = 0;
		getContentPane().add(comboBoxPacientes, gbc_comboBoxUsuarios);

		comboBoxPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionado = (String) comboBoxPacientes.getSelectedItem();
				if (seleccionado != null) { // <--- ESTA VALIDACIÓN EVITA CRASHES AL RECARGAR
					System.out.println("El usuario eligió: " + seleccionado);
				}
			}
		});

		lblIngreseAnio = new JLabel("Año:");
		lblIngreseAnio.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseAnio = new GridBagConstraints();
		gbc_lblIngreseAnio.fill = GridBagConstraints.BOTH;
		gbc_lblIngreseAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseAnio.gridx = 0;
		gbc_lblIngreseAnio.gridy = 1;
		getContentPane().add(lblIngreseAnio, gbc_lblIngreseAnio);

		textFieldAnio = new JTextField();
		GridBagConstraints gbc_textFieldAnio = new GridBagConstraints();
		gbc_textFieldAnio.gridwidth = 2;
		gbc_textFieldAnio.fill = GridBagConstraints.BOTH;
		gbc_textFieldAnio.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAnio.gridx = 1;
		gbc_textFieldAnio.gridy = 1;
		getContentPane().add(textFieldAnio, gbc_textFieldAnio);
		textFieldAnio.setColumns(10);

		lblIngreseCantOrd = new JLabel("Ordenes:");
		lblIngreseCantOrd.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseCantOrd = new GridBagConstraints();
		gbc_lblIngreseCantOrd.fill = GridBagConstraints.BOTH;
		gbc_lblIngreseCantOrd.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseCantOrd.gridx = 0;
		gbc_lblIngreseCantOrd.gridy = 2;
		getContentPane().add(lblIngreseCantOrd, gbc_lblIngreseCantOrd);

		textFieldCantOrd = new JTextField();
		GridBagConstraints gbc_textFieldCantOrd = new GridBagConstraints();
		gbc_textFieldCantOrd.gridwidth = 2;
		gbc_textFieldCantOrd.fill = GridBagConstraints.BOTH;
		gbc_textFieldCantOrd.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCantOrd.gridx = 1;
		gbc_textFieldCantOrd.gridy = 2;
		getContentPane().add(textFieldCantOrd, gbc_textFieldCantOrd);
		textFieldCantOrd.setColumns(10);

		lblIngreseCantMed = new JLabel("Tickets:");
		lblIngreseCantMed.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseCantMed = new GridBagConstraints();
		gbc_lblIngreseCantMed.fill = GridBagConstraints.BOTH;
		gbc_lblIngreseCantMed.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseCantMed.gridx = 0;
		gbc_lblIngreseCantMed.gridy = 3;
		getContentPane().add(lblIngreseCantMed, gbc_lblIngreseCantMed);

		textFieldCantMed = new JTextField();
		GridBagConstraints gbc_textFieldCantMed = new GridBagConstraints();
		gbc_textFieldCantMed.gridwidth = 2;
		gbc_textFieldCantMed.fill = GridBagConstraints.BOTH;
		gbc_textFieldCantMed.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCantMed.gridx = 1;
		gbc_textFieldCantMed.gridy = 3;
		getContentPane().add(textFieldCantMed, gbc_textFieldCantMed);
		textFieldCantMed.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 4;
		getContentPane().add(btnAceptar, gbc_btnAceptar);

		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 4;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}

	public void cargarPacientes() {
	        DefaultComboBoxModel<String> model;
	        try {
	        	DataUsuario[] pacientes = controlUsr.getUsuarios();
	        	List<String> nombres = new ArrayList<>();
	        	
	        	for (DataUsuario paciente: pacientes) {
	        		nombres.add(paciente.getNombre());
	        	}
	        	
	            model = new DefaultComboBoxModel<String>(nombres.toArray(new String[0]));
	            comboBoxPacientes.setModel(model);
	        } catch (UsuarioNoExisteException e) {
	            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
	        }
	    }

}