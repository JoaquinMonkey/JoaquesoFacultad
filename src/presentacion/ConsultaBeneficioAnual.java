package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import excepciones.UsuarioNoExisteException;
import logica.DataUsuario;
import logica.IControladorBeneficioAnual;
import logica.IControladorUsuario;
import logica.ManejadorUsuario;

@SuppressWarnings("serial")
public class ConsultaBeneficioAnual extends JInternalFrame {
	private IControladorBeneficioAnual icba;
	private IControladorUsuario icu;
	private JLabel lblIngresePaciente;
	private JComboBox<String> comboBoxPacientes;
	private JLabel lblIngreseAnio;
	private JComboBox<Integer> comboBoxBeneficioAnual;

	public ConsultaBeneficioAnual(IControladorBeneficioAnual icba, IControladorUsuario icu) {
		this.icba = icba;
		this.icu = icu;

		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Beneficio Anual");
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
		comboBoxPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname = (String) comboBoxPacientes.getSelectedItem();
				if (nickname != null) { // <--- ESTA VALIDACIÓN EVITA CRASHES AL RECARGAR
					System.out.println("El usuario eligió: " + nickname);
					cargarBeneficiosAnuales(nickname);
				}
			}
		});
		GridBagConstraints gbc_comboBoxUsuarios = new GridBagConstraints();
		gbc_comboBoxUsuarios.gridwidth = 2;
		gbc_comboBoxUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxUsuarios.fill = GridBagConstraints.BOTH;
		gbc_comboBoxUsuarios.gridx = 1;
		gbc_comboBoxUsuarios.gridy = 0;
		getContentPane().add(comboBoxPacientes, gbc_comboBoxUsuarios);

		lblIngreseAnio = new JLabel("Año:");
		lblIngreseAnio.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIngreseAnio = new GridBagConstraints();
		gbc_lblIngreseAnio.anchor = GridBagConstraints.EAST;
		gbc_lblIngreseAnio.fill = GridBagConstraints.VERTICAL;
		gbc_lblIngreseAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseAnio.gridx = 0;
		gbc_lblIngreseAnio.gridy = 1;
		getContentPane().add(lblIngreseAnio, gbc_lblIngreseAnio);

		comboBoxBeneficioAnual = new JComboBox<Integer>();
		comboBoxBeneficioAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer anio = (Integer) comboBoxBeneficioAnual.getSelectedItem();
				if (anio != null) { // <--- ESTA VALIDACIÓN EVITA CRASHES AL RECARGAR
					System.out.println("El usuario eligió: " + anio);
				}
			}
		});
		GridBagConstraints gbc_comboBoxBeneficioAnual = new GridBagConstraints();
		gbc_comboBoxBeneficioAnual.gridwidth = 2;
		gbc_comboBoxBeneficioAnual.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxBeneficioAnual.fill = GridBagConstraints.BOTH;
		gbc_comboBoxBeneficioAnual.gridx = 1;
		gbc_comboBoxBeneficioAnual.gridy = 1;
		getContentPane().add(comboBoxBeneficioAnual, gbc_comboBoxBeneficioAnual);

	}

	public void cargarPacientes() {
		DefaultComboBoxModel<String> model;
		try {
			model = new DefaultComboBoxModel<String>(
					ManejadorUsuario.getinstance().getPacientes().keySet().toArray(new String[0]));
		} catch (NullPointerException e) {
			model = new DefaultComboBoxModel<String>();
		}

		comboBoxPacientes.setModel(model);
	}

	private void cargarBeneficiosAnuales(String nickname) {
		DefaultComboBoxModel<Integer> model;
		Set<Integer> beneficiosAnuales = icba.listarBeneficiosAnuales(nickname);
		model = new DefaultComboBoxModel<Integer>(beneficiosAnuales.toArray(new Integer[0]));
		comboBoxBeneficioAnual.setModel(model);
	}
}
