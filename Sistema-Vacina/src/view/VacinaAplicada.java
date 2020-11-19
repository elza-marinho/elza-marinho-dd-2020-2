package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class VacinaAplicada extends JFrame {
	private static final String SELECIONE = "-- Selecione --";

	private JPanel contentPane;
	private JFormattedTextField textDataAplicacao;
	private DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VacinaAplicada frame = new VacinaAplicada();
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
	public VacinaAplicada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbVacina = new JComboBox();
		cbVacina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbVacina.setBounds(70, 25, 125, 20);
		contentPane.add(cbVacina);

		JLabel lblVacina = new JLabel("Vacina");
		lblVacina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVacina.setBounds(10, 25, 50, 20);
		contentPane.add(lblVacina);

		JLabel lblPessoa = new JLabel("Paciente");
		lblPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPessoa.setBounds(260, 25, 50, 20);
		contentPane.add(lblPessoa);

		JComboBox cbPaciente = new JComboBox();
		cbPaciente.setBounds(320, 26, 175, 20);
		contentPane.add(cbPaciente);

		JLabel lblPais = new JLabel("Pa\u00EDs de Origem:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(10, 70, 90, 20);
		contentPane.add(lblPais);

		JComboBox cbPais = new JComboBox();
		cbPais.setModel(new DefaultComboBoxModel(new String[] { "--Selecione--", "Alemanha", "Belgica", "China",
				"Estados Unidos", "Franca", "Inglaterra", "R\u00FAssia" }));
		cbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbPais.setBounds(110, 70, 140, 20);
		contentPane.add(cbPais);

		JLabel lblDose = new JLabel("Dose:");
		lblDose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDose.setBounds(10, 145, 45, 20);
		contentPane.add(lblDose);

		JRadioButton rdbtPrimeira = new JRadioButton("Primeira");
		rdbtPrimeira.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtPrimeira.setBounds(60, 145, 80, 20);
		contentPane.add(rdbtPrimeira);

		JRadioButton rdbtnSegunda = new JRadioButton("Segunda");
		rdbtnSegunda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSegunda.setBounds(230, 145, 80, 20);
		contentPane.add(rdbtnSegunda);

		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota.setBounds(10, 181, 40, 20);
		contentPane.add(lblNota);

		JCheckBox chckPessima = new JCheckBox("1 Pessima");
		chckPessima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckPessima.setBounds(60, 180, 90, 20);
		contentPane.add(chckPessima);

		JCheckBox chckbxRuim = new JCheckBox(" 2 Ruim");
		chckbxRuim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxRuim.setBounds(230, 181, 80, 20);
		contentPane.add(chckbxRuim);

		JCheckBox chckBoa = new JCheckBox("3 Boa");
		chckBoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckBoa.setBounds(60, 220, 80, 20);
		contentPane.add(chckBoa);

		JCheckBox chckOtima = new JCheckBox("4  \u00D3tima");
		chckOtima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckOtima.setBounds(230, 220, 80, 20);
		contentPane.add(chckOtima);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(110, 315, 85, 25);
		contentPane.add(btnLimpar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(260, 315, 85, 25);
		contentPane.add(btnSalvar);

		JLabel lblData = new JLabel("Data da Aplica\u00E7\u00E3o:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(10, 110, 110, 20);
		contentPane.add(lblData);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textDataAplicacao = new JFormattedTextField(mascaraData);
			
			textDataAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textDataAplicacao.setBounds(130, 110, 120, 20);
			contentPane.add(textDataAplicacao);
			
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

	}
}
