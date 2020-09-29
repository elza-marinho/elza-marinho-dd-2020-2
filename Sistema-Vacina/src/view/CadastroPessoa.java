package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.PessoaController;
import model.vo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class CadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JFormattedTextField TextCpf;
	private JRadioButton rdbFeminino;
	private JRadioButton rdbMasculino;
	private JLabel lblVoluntario;
	private JCheckBox chcVoluntario;
	private JFormattedTextField textDataN;
	private DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoa frame = new CadastroPessoa();
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
	public CadastroPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 25, 45, 20);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(55, 25, 160, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 60, 40, 20);
		contentPane.add(lblCpf);

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			TextCpf = new JFormattedTextField(mascaraCpf);
			TextCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
			TextCpf.setBounds(55, 55, 150, 20);
			getContentPane().add(TextCpf);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataNascimento.setBounds(265, 25, 115, 20);
		contentPane.add(lblDataNascimento);
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textDataN = new JFormattedTextField(mascaraData);
			
			textDataN.setBounds(390, 25, 120, 20);
			contentPane.add(textDataN);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(10, 100, 45, 20);
		contentPane.add(lblSexo);

		JRadioButton rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbFeminino.setBounds(55, 100, 85, 21);
		contentPane.add(rdbFeminino);

		JRadioButton rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbMasculino.setBounds(145, 100, 85, 21);
		contentPane.add(rdbMasculino);

		JLabel lblVoluntario = new JLabel("Voluntario:");
		lblVoluntario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVoluntario.setBounds(10, 130, 65, 20);
		contentPane.add(lblVoluntario);

		JCheckBox chcVoluntario = new JCheckBox("Sim");
		chcVoluntario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chcVoluntario.isSelected()) {
					lblVoluntario.setVisible(true);
				} else {
					lblVoluntario.setVisible(false);
				}
			}
		});
		chcVoluntario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chcVoluntario.setBounds(85, 130, 50, 20);
		contentPane.add(chcVoluntario);

		JButton btnSalvar = new JButton("Voltar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(135, 215, 85, 25);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Salvar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaController controller = new PessoaController();
				String nome = textNome.getText();
				String Cpf = TextCpf.getText();
				controller.salvarPessoa();
				JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso");
			}
			
			
		});
		btnVoltar.setBounds(280, 215, 85, 25);
		contentPane.add(btnVoltar);

		ButtonGroup sexo = new ButtonGroup();
		sexo.add(rdbMasculino);
		sexo.add(rdbFeminino);

	}
}
