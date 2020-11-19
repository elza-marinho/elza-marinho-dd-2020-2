package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CadastroReacao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroReacao frame = new CadastroReacao();
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
	public CadastroReacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(10, 25, 55, 20);
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblPaciente);
		
		JComboBox cbPaciente = new JComboBox();
		cbPaciente.setBounds(75, 25, 180, 20);
		contentPane.add(cbPaciente);
		
		JLabel lblVacina = new JLabel("Vacina:");
		lblVacina.setBounds(10, 80, 50, 20);
		lblVacina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblVacina);
		
		JComboBox cbVacina = new JComboBox();
		cbVacina.setBounds(70, 81, 155, 21);
		contentPane.add(cbVacina);
		
		JLabel lblReacao = new JLabel("Rea\u00E7\u00E3o");
		lblReacao.setBounds(10, 140, 55, 20);
		lblReacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblReacao);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(75, 139, 200, 110);
		contentPane.add(textArea);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setBounds(75, 290, 85, 25);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(210, 290, 85, 25);
		contentPane.add(btnSalvar);
	}
}
