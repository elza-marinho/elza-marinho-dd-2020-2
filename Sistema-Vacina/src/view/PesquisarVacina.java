package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.PesquisadorController;
import controller.VacinaController;
import model.vo.Pesquisador;
import model.vo.Vacina;
import seletor.VacinaSeletor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PesquisarVacina extends JFrame {

	protected static final int TAMANHO_PAGINA = 0;
	private JPanel contentPane;
	private JTextField textPais;
	private JTextField textNome;
	private int paginaAtual = 1;
	private List<Vacina> vacinasConsultadas;
	private JLabel lblPaginaAtual;
	private JTable tabelaVacinas;
	private List<Pesquisador> pesquisadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarVacina frame = new PesquisarVacina();
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
	public PesquisarVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paginaAtual > 1) {
					paginaAtual--;
				}
				consultarVacinas();
			}

		});
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnterior.setBounds(130, 220, 85, 25);
		contentPane.add(btnAnterior);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(20, 70, 50, 20);
		contentPane.add(lblNome);

		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(20, 30, 90, 20);
		contentPane.add(lblPais);

		textPais = new JTextField();
		textPais.setBounds(70, 32, 170, 19);
		contentPane.add(textPais);
		textPais.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(70, 72, 170, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnProximo = new JButton("Pr\u00F3ximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual++;
				consultarVacinas();
			}

		});
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnProximo.setBounds(255, 220, 85, 25);
		contentPane.add(btnProximo);

		JLabel lblpaginaAtual = new JLabel("P\u00E1gina Atual");
		lblpaginaAtual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblpaginaAtual.setBounds(20, 285, 90, 20);
		contentPane.add(lblpaginaAtual);

		JButton btnPesquisar = new JButton("Consultar Vacinas");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(155, 320, 185, 25);
		contentPane.add(btnPesquisar);

		JLabel lblEstagioPesquisa = new JLabel("Estagio Pesquisa:");
		lblEstagioPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstagioPesquisa.setBounds(20, 110, 100, 20);
		contentPane.add(lblEstagioPesquisa);

		JLabel lblPesquisador = new JLabel("Pesquisador");
		lblPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPesquisador.setBounds(20, 155, 80, 20);
		contentPane.add(lblPesquisador);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 156, 170, 21);
		contentPane.add(comboBox);
	}

	protected void consultarVacinas() {
		lblPaginaAtual.setText(paginaAtual + "");

		VacinaController controller = new VacinaController();
		VacinaSeletor seletor = new VacinaSeletor();

		seletor.setPagina(paginaAtual);
		seletor.setLimite(TAMANHO_PAGINA);

		seletor.setNome(textNome.getText());
		seletor.setPais(textPais.getText());
		seletor.getEstagioPesquisa();
		seletor.getPesquisador();

		List<Vacina> vacinas = controller.listarComSeletor(seletor);
		atualizarTabelaVacinas(vacinas);

	}

	private void atualizarTabelaVacinas(List<Vacina> vacinas) {
		vacinasConsultadas = vacinas;

		this.limparTabela();

		DefaultTableModel modelo = (DefaultTableModel) tabelaVacinas.getModel();

		for (Vacina vacina : vacinas) {
			String[] novaLinha = new String[] { vacina.getNome(), vacina.getPaisOrigem() };
			modelo.addRow(novaLinha);
		}

	}

	private void limparTabela() {
		tabelaVacinas.setModel(
				new DefaultTableModel(new String[][] { { "#", "Nome", "País", "Estágio Pesquisa", "Pesquisador" } },
						new String[] { "#", "Nome", "País", "Estágio Pesquisa", "Pesquisador" }));

	}

	private List<Pesquisador> consultarPesquisadores() {
		PesquisadorController controller = new PesquisadorController();
		return pesquisadores = controller.listarTodosOsPesquisadores();
	}
}
