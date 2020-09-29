package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import java.util.Calendar;
import javax.swing.ButtonGroup;

public class CadastroPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textInstituicao;
	private JLabel lblCpf;
	private JFormattedTextField TextCpf;
	private JLabel lblSexo;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private JFormattedTextField textDataNascimento;
	

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
		setBounds(100, 100, 530, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNome = new JTextField();
		textNome.setBounds(65, 25, 200, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 25, 45, 20);
		contentPane.add(lblNome);

		JLabel lblInstituicao = new JLabel("Instituicao:");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInstituicao.setBounds(10, 60, 65, 20);
		contentPane.add(lblInstituicao);

		textInstituicao = new JTextField();
		textInstituicao.setBounds(90, 62, 190, 19);
		contentPane.add(textInstituicao);
		textInstituicao.setColumns(10);

		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(290, 25, 35, 20);
		contentPane.add(lblCpf);
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			TextCpf = new JFormattedTextField(mascaraCpf);
			TextCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
			TextCpf.setBounds(330, 23, 150, 20);
			getContentPane().add(TextCpf);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(10, 100, 40, 20);
		contentPane.add(lblSexo);

	

		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataNascimento.setBounds(10, 145, 115, 20);
		contentPane.add(lblDataNascimento);
		
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textDataNascimento = new JFormattedTextField(mascaraData);
			
			textDataNascimento.setBounds(145, 145, 120, 20);
			contentPane.add(textDataNascimento);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(90, 255, 85, 25);
		contentPane.add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(240, 255, 85, 25);
		contentPane.add(btnSalvar);
		
		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbMasculino.setBounds(50, 100, 85, 20);
		contentPane.add(rdbMasculino);
		
		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbFeminino.setBounds(155, 100, 95, 20);
		contentPane.add(rdbFeminino);
		
		ButtonGroup sexo = new ButtonGroup();
		sexo.add(rdbMasculino);
		sexo.add(rdbFeminino);
	}
}
