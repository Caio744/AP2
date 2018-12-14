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
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;


public class Teste {

	private JFrame frmTurmas;
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
	String modo;

	
	
	

	
	
	public void LoadTable() {
		Object colunas[] = {"Curso","Código","Nome","Abreviação","Capacidade","Ano","Semestre"};
		DefaultTableModel modelo = new DefaultTableModel(colunas,0); //DefaultTableModel é uma classe utilizada para alimentar a lista
		
		for(int i=0; i<Turmas.turmasCad.size();i++) {
			modelo.addRow(new Object[] {Turmas.turmasCad.get(i).getCurso(),Turmas.turmasCad.get(i).getCodigo(),Turmas.turmasCad.get(i).getNomeCompleto(),Turmas.turmasCad.get(i).getNomeAbreviado(),Turmas.turmasCad.get(i).getCapacidade(),Turmas.turmasCad.get(i).getAno(),Turmas.turmasCad.get(i).getSemestre()});
		}
		table.setModel(modelo);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste window = new Teste();
					window.frmTurmas.setVisible(true);
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
		
		modo = "Navegar";
		
		JFormattedTextField textField_Pesquisar = new JFormattedTextField();
		textField_Pesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Pesquisar.setBounds(690, 236, 60, 22);
		frmTurmas.getContentPane().add(textField_Pesquisar);
	}
	
	
	public void ManipulaInterface() {
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
			btnPesquisar.setEnabled(true);
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
		frmTurmas = new JFrame();
		frmTurmas.getContentPane().setForeground(Color.RED);
		frmTurmas.setForeground(Color.GREEN);
		frmTurmas.setTitle("TURMAS");
		frmTurmas.setBackground(Color.RED);
		frmTurmas.getContentPane().setBackground(new Color(102, 153, 204));
		frmTurmas.setBounds(100, 100, 788, 487);
		frmTurmas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTurmas.getContentPane().setLayout(null);
		
		/**
		 * Inicializa as máscaras que irão ser utilizadas nos textfield's.
		 */
		MaskFormatter maskCurso = null;
		MaskFormatter maskAno = null;
		MaskFormatter maskSemestre = null;
		MaskFormatter maskCodigo = null;
		MaskFormatter maskCapacidade = null;
		MaskFormatter maskPesquisa = null;
		
		try {
			maskCurso = new MaskFormatter("####"); //4 digitos numéricos são obrigatórios
			maskAno = new MaskFormatter("####"); //4 digitos numéricos são obrigatórios
			maskSemestre = new MaskFormatter("##"); //2 digitos numéricos são obrigatórios
			maskCodigo = new MaskFormatter("####"); //4 digitos numéricos são obrigatórios
			maskCapacidade = new MaskFormatter("###"); //3 digitos numéricos são obrigatórios
			maskPesquisa = new MaskFormatter("####");
			
		} catch (ParseException e) {
			System.err.println("Erro na formatação: " + e.getMessage());
			System.exit(-1);
			
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 11, 740, 164);
		frmTurmas.getContentPane().add(scrollPane);
	
		table = new JTable();
		table.setToolTipText("GF");
		table.setShowHorizontalLines(false);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				if(index >= 0 && index < Turmas.turmasCad.size()) {
					Turmas t = Turmas.turmasCad.get(index); //Isso tudo serve para quando clicar em alguma linha da tabela, ela ativa a funcao manipula. Sem isso, pode ser que o valor do index se torna -1
					textField_Nome.setText(t.getNomeCompleto());
					textField_Abreviacao.setText(t.getNomeAbreviado());
					textField_Capacidade.setText(String.valueOf(t.getCapacidade()));
					textField_Codigo.setText(String.valueOf(t.getCodigo()));
					textField_Ano.setText(String.valueOf(t.getAno()));
					textField_Semestre.setText(String.valueOf(t.getSemestre()));
					textField_Curso.setText(String.valueOf(t.getCurso())); 
					//String.valueOf pega o inteiro e retorna uma string para o setText
					modo = "Selecao";
					ManipulaInterface();
					
					
				
				}
			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Semestre", "Codigo", "Nome", "Abreviacao", "Ano", "Capacidade"
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
		frmTurmas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(10, 28, 46, 14);
		panel.add(lblCurso);
		
		textField_Curso = new JFormattedTextField(maskCurso);
		textField_Curso.setBounds(52, 25, 46, 20);
		panel.add(textField_Curso);
		textField_Curso.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		
		JLabel lblAbreviao = new JLabel("Abreviação:");
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
				if(modo.equals("Novo")) {
					try {
						Turmas turma = new Turmas(Integer.parseInt(textField_Curso.getText()), Integer.parseInt(textField_Semestre.getText()), Integer.parseInt(textField_Codigo.getText()), textField_Nome.getText().trim(), textField_Abreviacao.getText().trim(), Integer.parseInt(textField_Ano.getText()), Integer.parseInt(textField_Capacidade.getText()));
						turma.cadastrar();
					} catch(NumberFormatException e) {//Como os textfield's são inicializados com "", ao tentar converter um campo que tem "" para inteiro, dá uma exceção do tipo NumberFormatException
						JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar", "Erro", 1);
					}
					LoadTable();
					JOptionPane.showMessageDialog(null, "Cadastro feita com sucesso!");
				} else if (modo.equals("Alterar")) {
					if((JOptionPane.showConfirmDialog(null, "Deseja alterar a turma selecionada?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == JOptionPane.YES_OPTION) {
						int index = table.getSelectedRow();
						Turmas.turmasCad.get(index).setCodigo(Integer.parseInt(textField_Codigo.getText()));
						Turmas.turmasCad.get(index).setAno(Integer.parseInt(textField_Ano.getText()));
						Turmas.turmasCad.get(index).setCapacidade(Integer.parseInt(textField_Capacidade.getText()));
						Turmas.turmasCad.get(index).setSemestre(Integer.parseInt(textField_Semestre.getText()));
						Turmas.turmasCad.get(index).setCurso(Integer.parseInt(textField_Curso.getText()));
						Turmas.turmasCad.get(index).setNomeCompleto(textField_Nome.getText());
						Turmas.turmasCad.get(index).setNomeAbreviado(textField_Codigo.getText());
						JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!");
						LoadTable();
					}
					
				}
				modo = "Navegar";
				ManipulaInterface();
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
				
				modo = "Navegar";
				ManipulaInterface();
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
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_Curso.setText("");
				textField_Semestre.setText("");
				textField_Ano.setText("");
				textField_Capacidade.setText("");
				textField_Nome.setText("");
				textField_Abreviacao.setText("");
				textField_Codigo.setText("");
				
				modo = "Novo";
				ManipulaInterface();
				
			}
		});
		btnNovo.setBounds(44, 221, 114, 38);
		frmTurmas.getContentPane().add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modo = "Alterar";
				ManipulaInterface();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(170, 221, 98, 38);
		frmTurmas.getContentPane().add(btnAlterar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(603, 236, 89, 23);
		frmTurmas.getContentPane().add(btnPesquisar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((JOptionPane.showConfirmDialog(null, "Deseja excluir a turma selecionada?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == JOptionPane.YES_OPTION) {
					int index = table.getSelectedRow();
					if(index >= 0 && index < Turmas.turmasCad.size()) {
						Turmas.turmasCad.remove(index);
					}
					LoadTable();
					modo = "Navegar";
					ManipulaInterface();
					JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
				}
			}
				
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(280, 221, 98, 38);
		frmTurmas.getContentPane().add(btnExcluir);
	}
}
