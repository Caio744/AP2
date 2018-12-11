package sistemaacademico;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teste {

	private JFrame frame;
	private JTable table;
	private JTextField textField_Curso;
	private JTextField textField_Codigo;
	private JTextField textField_Nome;
	private JTextField textField_Abreviacao;
	private JTextField textField_Capacidade;
	private JTextField textField_Ano;
	private JTextField textField_Semestre;
	ArrayList<Turmas> ListaTurma;
	private Component btnSalvar;
	private Component btnCancelar;
	
	
	public void LoadTable() {
		Object colunas[] = {"Curso","Código","Nome","Abreviação","Capacidade","Ano","Semestre"};
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		for(int i=0; i<ListaTurma.size();i++) {
			modelo.addRow(new Object[] {ListaTurma.get(i).getCurso(),ListaTurma.get(i).getCodigo(),ListaTurma.get(i).getNomeCompleto(),ListaTurma.get(i).getNomeAbreviado(),ListaTurma.get(i).getCapacidade(),ListaTurma.get(i).getAno(),ListaTurma.get(i).getSemestre()});
		}
		table.setModel(modelo);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste window = new Teste();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teste() {
		initialize();
		ListaTurma = new ArrayList();
		//btnSalvar.setEnabled(false);
		//btnCancelar.setEnabled(false);
	
	
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 618, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 582, 164);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Semestre", "C\u00F3digo", "Nome", "Abrevia\u00E7\u00E3o", "Ano", "Capacidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Byte.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(22, 271, 557, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(10, 28, 46, 14);
		panel.add(lblCurso);
		
		textField_Curso = new JTextField();
		textField_Curso.setBounds(52, 25, 152, 20);
		panel.add(textField_Curso);
		textField_Curso.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 54, 46, 14);
		panel.add(lblCdigo);
		
		textField_Codigo = new JTextField();
		textField_Codigo.setBounds(52, 51, 58, 20);
		panel.add(textField_Codigo);
		textField_Codigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 79, 46, 14);
		panel.add(lblNome);
		
		JLabel lblAbreviao = new JLabel("Abrevia\u00E7\u00E3o:");
		lblAbreviao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbreviao.setBounds(10, 104, 73, 14);
		panel.add(lblAbreviao);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(52, 76, 152, 20);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Abreviacao = new JTextField();
		textField_Abreviacao.setBounds(81, 102, 63, 20);
		panel.add(textField_Abreviacao);
		textField_Abreviacao.setColumns(10);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapacidade.setBounds(338, 29, 73, 14);
		panel.add(lblCapacidade);
		
		textField_Capacidade = new JTextField();
		textField_Capacidade.setBounds(408, 26, 46, 20);
		panel.add(textField_Capacidade);
		textField_Capacidade.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAno.setBounds(338, 53, 46, 14);
		panel.add(lblAno);
		
		textField_Ano = new JTextField();
		textField_Ano.setBounds(368, 51, 43, 20);
		panel.add(textField_Ano);
		textField_Ano.setColumns(10);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSemestre.setBounds(338, 80, 58, 14);
		panel.add(lblSemestre);
		
		textField_Semestre = new JTextField();
		textField_Semestre.setBounds(398, 77, 51, 20);
		panel.add(textField_Semestre);
		textField_Semestre.setColumns(10);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Turmas turma = new Turmas()
				LoadTable();
				
			}
		});
		btnSalvar.setBounds(322, 117, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(421, 117, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_Curso.setText("");
				textField_Semestre.setText("");
				textField_Ano.setText("");
				textField_Capacidade.setText("");
				textField_Nome.setText("");
				textField_Abreviacao.setText("");
				textField_Codigo.setText("");
				
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(true);
				
				
			}
		});
		btnNovo.setBounds(33, 208, 89, 23);
		frame.getContentPane().add(btnNovo);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(169, 208, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(304, 208, 89, 23);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(435, 208, 89, 23);
		frame.getContentPane().add(btnExcluir);
	}
}
