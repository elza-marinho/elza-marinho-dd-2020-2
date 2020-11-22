package view;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;

import controller.VacinaController;
import model.vo.Pesquisador;
import model.vo.Vacina;
import javax.swing.DefaultComboBoxModel;

public class CadastroVacina extends JFrame {

	private static final String SELECIONE = "-- Selecione --";

	private JPanel contentPane;
	private JFormattedTextField textDataInicio;
	private DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JTextField textNome;
	private JTextField textPais;
	private JComboBox cbPesquisador;
	private JComboBox cbEstagioPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVacina frame = new CadastroVacina();
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
	public CadastroVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPais = new JLabel("Pais de Origem:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(10, 25, 90, 20);
		contentPane.add(lblPais);

		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataInicio.setBounds(285, 25, 75, 20);
		contentPane.add(lblDataInicio);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textDataInicio = new JFormattedTextField(mascaraData);
			textDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textDataInicio.setBounds(360, 25, 140, 20);
			contentPane.add(textDataInicio);

		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		JLabel lblPesquisador = new JLabel("Nome  do Pesquisador:");
		lblPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPesquisador.setBounds(10, 75, 140, 20);
		contentPane.add(lblPesquisador);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		btnVoltar.setBounds(125, 225, 85, 25);
		contentPane.add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VacinaController controller = new VacinaController();
				String paisOrigem = textPais.getText();
				Pesquisador pesquisadorSelecionado = ((Pesquisador) cbPesquisador.getSelectedItem());
				int estagioVacina = (int) ((cbEstagioPesquisa.getSelectedItem()));
				String DataInicio = textDataInicio.getText();
				String nome = textNome.getText();

				controller.validar(textPais, cbPesquisador, cbEstagioPesquisa, textDataInicio, textNome);

				JOptionPane.showMessageDialog(null, "Atenção!, Preencha todos os campos");

			}

		});
		btnSalvar.setBounds(275, 225, 85, 25);
		contentPane.add(btnSalvar);

		JLabel lblEstagio = new JLabel("Estagio Pesquisa:");
		lblEstagio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstagio.setBounds(10, 120, 100, 20);
		contentPane.add(lblEstagio);

		JComboBox cbPesquisador = new JComboBox();
		cbPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbPesquisador.setBounds(145, 75, 155, 20);
		contentPane.add(cbPesquisador);

		JComboBox cbEstagioPesquisa = new JComboBox();
		cbEstagioPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbEstagioPesquisa.setModel(new DefaultComboBoxModel(
				new String[] { "-- Selecione--", "1- Inicial", "2- Testes", "3 - P\u00FAblico" }));
		cbEstagioPesquisa.setBounds(125, 120, 155, 20);
		contentPane.add(cbEstagioPesquisa);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 175, 50, 20);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(65, 175, 215, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textPais = new JTextField();
		textPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPais.setBounds(110, 25, 140, 20);
		contentPane.add(textPais);
		textPais.setColumns(10);

	}
}
