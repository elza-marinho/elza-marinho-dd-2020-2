package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CadastroPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textInstituicao;
	private JFormattedTextField TextCpf;
	private JFormattedTextField formattedTextDtNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPesquisador frame = new CadastroPesquisador();
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
	public CadastroPesquisador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 25, 46, 20);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(55, 25, 200, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 55, 45, 20);
		contentPane.add(lblCpf);

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			JFormattedTextField formattedTextCpf = new JFormattedTextField();
			formattedTextCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
			formattedTextCpf.setBounds(55, 56, 200, 20);
			contentPane.add(formattedTextCpf);
		} catch (ParseException e) {
		}

		JLabel lblInstituicao = new JLabel("Instituicao:");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInstituicao.setBounds(310, 55, 60, 20);
		contentPane.add(lblInstituicao);

		textInstituicao = new JTextField();
		textInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textInstituicao.setBounds(380, 57, 220, 20);
		contentPane.add(textInstituicao);
		textInstituicao.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataNascimento.setBounds(310, 25, 115, 20);
		contentPane.add(lblDataNascimento);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(10, 85, 50, 20);
		contentPane.add(lblSexo);

		JRadioButton rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbFeminino.setBounds(55, 85, 90, 20);
		contentPane.add(rdbFeminino);

		JRadioButton rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbMasculino.setBounds(165, 85, 90, 20);
		contentPane.add(rdbMasculino);

		JButton btnSalvar = new JButton("Voltar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(170, 195, 85, 25);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Salvar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(340, 195, 85, 25);
		contentPane.add(btnVoltar);
	}
}
