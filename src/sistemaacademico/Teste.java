package sistemaacademico;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException; //Importe para a mascara
import javax.swing.JFormattedTextField;


public class Teste {

	private JFrame frame;
	private JTable table;
	private JFormattedTextField textField_Curso;
	private JFormattedTextField textField_Codigo;
	private JTextField textField_Nome;
	private JTextField textField_Abreviacao;
	private JFormattedTextField textField_Capacidade;
	private JFormattedTextField textField_Ano;
	private JFormattedTextField textField_Semestre;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnPesquisar;

	private static  ArrayList<Turmas>  turmasCad;
	
	private Turmas t;

	
	
	public void LoadTable() {
		Object colunas[] = {"Curso","Código","Nome","Abreviação","Capacidade","Ano","Semestre"};
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		for(int i=0; i<turmasCad.size();i++) {
			modelo.addRow(new Object[] {turmasCad.get(i).getCurso(),turmasCad.get(i).getCodigo(),turmasCad.get(i).getNomeCompleto(),turmasCad.get(i).getNomeAbreviado(),turmasCad.get(i).getCapacidade(),turmasCad.get(i).getAno(),turmasCad.get(i).getSemestre()});
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
		turmasCad = new ArrayList<Turmas>();
        //Turmas t = new Turmas(turmasCad);

	}

	/**
	 * Create the application.
	 */
		
		
	public Teste() {
		initialize();
		turmasCad = new ArrayList();
		
		btnSalvar.setEnabled(false);
		btnCancelar.setEnabled(false);
		textField_Curso.setEditable(false);
		textField_Semestre.setEditable(false);
		textField_Codigo.setEditable(false);
		textField_Nome.setEditable(false);
		textField_Abreviacao.setEditable(false);
		textField_Ano.setEditable(false);
		textField_Capacidade.setEditable(false);
		btnNovo.setEnabled(true);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnPesquisar.setEnabled(false);
	}
	
	
	public void ManipulaInterface(String modo) {
		switch(modo) {
		case "Navegar":
			btnSalvar.setEnabled(false);
			btnCancelar.setEnabled(false);
			textField_Curso.setEditable(false);
			textField_Semestre.setEditable(false);
			textField_Codigo.setEditable(false);
			textField_Nome.setEditable(false);
			textField_Abreviacao.setEditable(false);
			textField_Ano.setEditable(false);
			textField_Capacidade.setEditable(false);
			btnNovo.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(false);
			break;
			
		case "Novo":
			btnSalvar.setEnabled(true);
			btnCancelar.setEnabled(true);
			textField_Curso.setEditable(true);
			textField_Semestre.setEditable(true);
			textField_Codigo.setEditable(true);
			textField_Nome.setEditable(true);
			textField_Abreviacao.setEditable(true);
			textField_Ano.setEditable(true);
			textField_Capacidade.setEditable(true);
			btnNovo.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(false);
			
			break;
			
		case "Alterar":
			btnSalvar.setEnabled(true);
			btnCancelar.setEnabled(true);
			textField_Curso.setEditable(true);
			textField_Semestre.setEditable(true);
			textField_Codigo.setEditable(true);
			textField_Nome.setEditable(true);
			textField_Abreviacao.setEditable(true);
			textField_Ano.setEditable(true);
			textField_Capacidade.setEditable(true);
			btnNovo.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(false);
			
			break;
			
		case "Pesquisar":
			btnSalvar.setEnabled(false);
			btnCancelar.setEnabled(false);
			textField_Curso.setEditable(false);
			textField_Semestre.setEditable(false);
			textField_Codigo.setEditable(false);
			textField_Nome.setEditable(false);
			textField_Abreviacao.setEditable(false);
			textField_Ano.setEditable(false);
			textField_Capacidade.setEditable(false);
			btnNovo.setEnabled(true);
			btnAlterar.setEnabled(true);
			btnExcluir.setEnabled(true);
			btnPesquisar.setEnabled(true);
			
			break;
			
		case "Excluir":
			btnSalvar.setEnabled(false);
			btnCancelar.setEnabled(false);
			textField_Curso.setEditable(false);
			textField_Semestre.setEditable(false);
			textField_Codigo.setEditable(false);
			textField_Nome.setEditable(false);
			textField_Abreviacao.setEditable(false);
			textField_Ano.setEditable(false);
			textField_Capacidade.setEditable(false);
			btnNovo.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(false);
			
			break;
			
		case "Selecao":
			btnSalvar.setEnabled(false);
			btnCancelar.setEnabled(false);
			textField_Curso.setEditable(false);
			textField_Semestre.setEditable(false);
			textField_Codigo.setEditable(false);
			textField_Nome.setEditable(false);
			textField_Abreviacao.setEditable(false);
			textField_Ano.setEditable(false);
			textField_Capacidade.setEditable(false);
			btnNovo.setEnabled(true);
			btnAlterar.setEnabled(true);
			btnExcluir.setEnabled(true);
			btnPesquisar.setEnabled(true);
			
			break;
			
			
		default: System.out.println("Modo inváldo");
		}
	}

	/**
	 * Inicializa os frames.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 788, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Inicializa as máscaras que irão ser utilizadas nos textfield's.
		 */
		MaskFormatter maskCurso = null;
		MaskFormatter maskAno = null;
		MaskFormatter maskSemestre = null;
		MaskFormatter maskCodigo = null;
		MaskFormatter maskCapacidade = null;
		
		try {
			maskCurso = new MaskFormatter("####"); //4 digitos numéricos são obrigatórios
			maskAno = new MaskFormatter("####"); //4 digitos numéricos são obrigatórios
			maskSemestre = new MaskFormatter("##"); //2 digitos numéricos são obrigatórios
			maskCodigo = new MaskFormatter("####"); //4 digitos numéricos são obrigatórios
			maskCapacidade = new MaskFormatter("###"); //3 digitos numéricos são obrigatórios
			
		} catch (ParseException e) {
			System.err.println("Erro na formatação: " + e.getMessage());
			System.exit(-1);
			
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 740, 164);
		frame.getContentPane().add(scrollPane);
	
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				if(index >= 0 && index < turmasCad.size()) //Isso tudo serve para quando clicar em alguma linha da tabela, ela ativa a funcao manipula. Sem isso, pode ser que o valor do index se torna -1
					//Em 10:10 do video 2 tem a criação de um objeto de turma instaciado no arraylist, mas da erro. Precisa ver isso ae
				//Ta dando erro essa merda
					
					ManipulaInterface("Selecao");
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Semestre", "C\u00F3digo", "Nome", "Abrevia\u00E7\u00E3o", "Ano", "Capacidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Object.class, Object.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(10, 271, 740, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(10, 28, 46, 14);
		panel.add(lblCurso);
		
		textField_Curso = new JFormattedTextField(maskCurso);
		textField_Curso.setBounds(52, 25, 46, 20);
		panel.add(textField_Curso);
		textField_Curso.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigo.setBounds(10, 54, 46, 14);
		panel.add(lblCdigo);
		
		textField_Codigo = new JFormattedTextField(maskCodigo);
		textField_Codigo.setBounds(52, 51, 46, 20);
		panel.add(textField_Codigo);
		textField_Codigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 79, 46, 14);
		panel.add(lblNome);
		
		JLabel lblAbreviao = new JLabel("Abrevia\u00E7\u00E3o:");
		lblAbreviao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbreviao.setBounds(10, 108, 73, 14);
		panel.add(lblAbreviao);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(51, 79, 264, 20);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Abreviacao = new JTextField();
		textField_Abreviacao.setBounds(80, 106, 63, 20);
		panel.add(textField_Abreviacao);
		textField_Abreviacao.setColumns(10);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapacidade.setBounds(338, 29, 73, 14);
		panel.add(lblCapacidade);
		
		textField_Capacidade = new JFormattedTextField(maskCapacidade);
		textField_Capacidade.setBounds(406, 26, 43, 20);
		panel.add(textField_Capacidade);
		textField_Capacidade.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAno.setBounds(376, 53, 46, 14);
		panel.add(lblAno);
		
		textField_Ano = new JFormattedTextField(maskAno);
		textField_Ano.setBounds(406, 51, 43, 20);
		panel.add(textField_Ano);
		textField_Ano.setColumns(10);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSemestre.setBounds(349, 79, 58, 14);
		panel.add(lblSemestre);
		
		textField_Semestre = new JFormattedTextField(maskSemestre);
		textField_Semestre.setBounds(406, 77, 43, 20);
		panel.add(textField_Semestre);
		textField_Semestre.setColumns(10);
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Turmas turma = new Turmas(Integer.parseInt(textField_Curso.getText()), Integer.parseInt(textField_Semestre.getText()), Integer.parseInt(textField_Codigo.getText()), textField_Nome.getText(), textField_Abreviacao.getText(), Integer.parseInt(textField_Ano.getText()), Integer.parseInt(textField_Capacidade.getText()));
					turmasCad.add(turma);
				} catch(NumberFormatException e) {//Como os textfield's são inicializados com "", ao tentar converter um campo que tem "" para inteiro, dá uma exceção do tipo NumberFormatException
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar", "Erro", 1);
				}
				LoadTable();
				
				ManipulaInterface("Navegar");
				textField_Curso.setText("");    //Preenche de volta os textfields's com "null"
				textField_Semestre.setText("");
				textField_Ano.setText("");
				textField_Capacidade.setText("");
				textField_Nome.setText("");
				textField_Abreviacao.setText("");
				textField_Codigo.setText("");
			}
		});
		btnSalvar.setBounds(530, 117, 89, 23);
		panel.add(btnSalvar);
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_Curso.setText("");
				textField_Semestre.setText("");
				textField_Ano.setText("");
				textField_Capacidade.setText("");
				textField_Nome.setText("");
				textField_Abreviacao.setText("");
				textField_Codigo.setText("");
				
				ManipulaInterface("Navegar");
			}
		});
		btnCancelar.setBounds(629, 117, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblEx = new JLabel("Ex.: 0035");
		lblEx.setBounds(108, 29, 63, 14);
		panel.add(lblEx);
		
		JLabel lblEx_1 = new JLabel("Ex.: 0115");
		lblEx_1.setBounds(108, 54, 63, 14);
		panel.add(lblEx_1);
		
		JLabel lblEx_2 = new JLabel("Ex.: 060");
		lblEx_2.setBounds(459, 29, 63, 14);
		panel.add(lblEx_2);
		
		JLabel lblEx_3 = new JLabel("Ex.: 05");
		lblEx_3.setBounds(459, 80, 63, 14);
		panel.add(lblEx_3);
		
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_Curso.setText("");
				textField_Semestre.setText("");
				textField_Ano.setText("");
				textField_Capacidade.setText("");
				textField_Nome.setText("");
				textField_Abreviacao.setText("");
				textField_Codigo.setText("");
				
//				btnSalvar.setEnabled(true);
//				btnCancelar.setEnabled(true);
//				textField_Curso.setEditable(true);
//				textField_Semestre.setEditable(true);
//				textField_Codigo.setEditable(true);
//				textField_Nome.setEditable(true);
//				textField_Abreviacao.setEditable(true);
//				textField_Ano.setEditable(true);
//				textField_Capacidade.setEditable(true);
				ManipulaInterface("Novo");
				
			}
		});
		btnNovo.setBounds(67, 208, 89, 23);
		frame.getContentPane().add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(252, 208, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(422, 208, 89, 23);
		frame.getContentPane().add(btnPesquisar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(606, 208, 89, 23);
		frame.getContentPane().add(btnExcluir);
	}
}
