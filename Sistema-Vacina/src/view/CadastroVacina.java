package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;

import javax.swing.JRadioButton;
import com.github.lgooddatepicker.components.DatePicker;

public class CadastroVacina extends JFrame {

	private JPanel contentPane;
	private JTextField textPaisOrigem;
	private JTextField textPesquisador;
	private JFormattedTextField textDataInicio;
	
	
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
		
		textPaisOrigem = new JTextField();
		textPaisOrigem.setBounds(105, 25, 140, 20);
		contentPane.add(textPaisOrigem);
		textPaisOrigem.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataInicio.setBounds(285, 25, 75, 20);
		contentPane.add(lblDataInicio);
		
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textDataInicio = new  JFormattedTextField(mascaraData);
			textDataInicio.setBounds(360, 25, 140, 20);
			  contentPane.add(textDataInicio);
			 
			
		}catch (ParseException e1) {

			e1.printStackTrace();
		}
		

		
		JLabel lblPesquisador = new JLabel("Nome  do Pesquisador:");
		lblPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPesquisador.setBounds(10, 60, 140, 20);
		contentPane.add(lblPesquisador);
		
		textPesquisador = new JTextField();
		textPesquisador.setBounds(149, 60, 266, 20);
		contentPane.add(textPesquisador);
		textPesquisador.setColumns(10);
		
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
			}
		});
		btnSalvar.setBounds(275, 225, 85, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblEstagio = new JLabel("Estagio Pesquisa:");
		lblEstagio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstagio.setBounds(10, 100, 100, 20);
		contentPane.add(lblEstagio);
		
		JRadioButton rdbtInicial = new JRadioButton("Inicial");
		rdbtInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtInicial.setBounds(125, 100, 80, 20);
		contentPane.add(rdbtInicial);
		
		JRadioButton rdbtTestes = new JRadioButton("Testes");
		rdbtTestes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtTestes.setBounds(125, 125, 80, 20);
		contentPane.add(rdbtTestes);
		
		JRadioButton rdbtPublico = new JRadioButton("Publico Geral");
		rdbtPublico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtPublico.setBounds(125, 150, 105, 20);
		contentPane.add(rdbtPublico);
		
		  ButtonGroup group = new ButtonGroup();
		  group.add(rdbtInicial);
		  group.add(rdbtTestes);
		  group.add(rdbtPublico);
		  
		  group.clearSelection();
		  
		 
			 
		 }
	}

