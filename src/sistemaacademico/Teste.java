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
import javax.swing.JList;
import javax.swing.AbstractListModel;


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
	private JFormattedTextField textField_Pesquisar; 
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnPesquisar;
	private JButton btnAtualizar;
	String modo;

	
	
	

	/**
	 * LoadTable
	 * -Carrega a tabela com os objetos do ArrayList
	 */
	
	public void LoadTable() {
		Object colunas[] = {"C�digo","Curso","Nome","Abrevia��o","Capacidade","Semestre","Ano"};
		DefaultTableModel modelo = new DefaultTableModel(colunas,0); //DefaultTableModel é uma classe utilizada para alimentar a lista
		
		for(int i=0; i<Turmas.turmasCad.size();i++) {
			modelo.addRow(new Object[] {Turmas.turmasCad.get(i).getCodigo(),Turmas.turmasCad.get(i).getCurso(),Turmas.turmasCad.get(i).getNomeCompleto(),Turmas.turmasCad.get(i).getNomeAbreviado(),Turmas.turmasCad.get(i).getCapacidade(),Turmas.turmasCad.get(i).getSemestre(),Turmas.turmasCad.get(i).getAno()});
		}
		table.setModel(modelo);
		if (table.getColumnModel().getColumnCount() > 0) {
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(30);
            table.getColumnModel().getColumn(6).setPreferredWidth(30);
        }
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
	
//	/**
//	 * ManipulaInterface
//	 * 
//	 * -Método responsável por habilitar e desabilitar os botões nos modos de interação com a interface. 
//	 * -Realiza também a troca de cores dos campos de texto para deixar claro que a textField não está disponível para interação
//	 */
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
			
			textField_Curso.setBackground(Color.LIGHT_GRAY);
			textField_Codigo.setBackground(Color.LIGHT_GRAY);
			textField_Nome.setBackground(Color.LIGHT_GRAY);
			textField_Abreviacao.setBackground(Color.LIGHT_GRAY);
			textField_Ano.setBackground(Color.LIGHT_GRAY);
			textField_Capacidade.setBackground(Color.LIGHT_GRAY);
			textField_Semestre.setBackground(Color.LIGHT_GRAY);
			
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
			
			textField_Curso.setBackground(Color.WHITE);
			textField_Codigo.setBackground(Color.WHITE);
			textField_Nome.setBackground(Color.WHITE);
			textField_Abreviacao.setBackground(Color.WHITE);
			textField_Ano.setBackground(Color.WHITE);
			textField_Capacidade.setBackground(Color.WHITE);
			textField_Semestre.setBackground(Color.WHITE);
			
			
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
			
			textField_Curso.setBackground(Color.WHITE);
			textField_Codigo.setBackground(Color.WHITE);
			textField_Nome.setBackground(Color.WHITE);
			textField_Abreviacao.setBackground(Color.WHITE);
			textField_Ano.setBackground(Color.WHITE);
			textField_Capacidade.setBackground(Color.WHITE);
			textField_Semestre.setBackground(Color.WHITE);
			
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
	 * INICIALIZA��O DOS COMPONENTES
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
		 * INICIALIZA��O DAS M�SCARAS QUE IR�O  SER UTILIZADAS NOS TEXTFIELD'S
		 * Mascaras s�o utilizadas para formatar o campo de texto da forma que quiser
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
			System.err.println("Erro na formata��o.: " + e.getMessage());
			System.exit(-1);
			
		}
		
		/**
		 * SCROLLPANE
		 */
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 11, 740, 164);
		frmTurmas.getContentPane().add(scrollPane);
	
		
		/**
		 * TABELA
		 */
		
		table = new JTable();
		table.setShowVerticalLines(true);
		table.setToolTipText("");
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
				"Codigo", "Curso", "Nome", "Abreviacao", "Capacidade", "Semestre", "Ano"
			}
		) {
			Class[] columnTypes = new Class[] {
				//Integer.class, String.class, Integer.class, Object.class, Object.class, Integer.class, Integer.class
				Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane.setViewportView(table);
		if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(30);
            table.getColumnModel().getColumn(6).setPreferredWidth(30);
        }
		
		
		/**
		 * PAINÉIS
		 */
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(10, 271, 740, 171);
		frmTurmas.getContentPane().add(panel);
		panel.setLayout(null);
		
		/**
		 * JLABEL'S
		 */
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(16, 54, 46, 14);
		panel.add(lblCurso);
		
		JLabel lblCodigo = new JLabel("C�digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 32, 46, 14);
		panel.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 106, 46, 14);
		panel.add(lblNome);
		
		JLabel lblAbreviao = new JLabel("Abrevia��o:");
		lblAbreviao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbreviao.setBounds(10, 138, 73, 14);
		panel.add(lblAbreviao);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapacidade.setBounds(232, 32, 73, 14);
		panel.add(lblCapacidade);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAno.setBounds(271, 54, 32, 14);
		panel.add(lblAno);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSemestre.setBounds(439, 32, 58, 14);
		panel.add(lblSemestre);
		
		JLabel lblEx = new JLabel("Ex.: 0035");
		lblEx.setBounds(108, 29, 63, 14);
		panel.add(lblEx);
		
		JLabel lblEx_1 = new JLabel("Ex.: 0115");
		lblEx_1.setBounds(108, 54, 63, 14);
		panel.add(lblEx_1);
		
		JLabel lblEx_2 = new JLabel("Ex.: 060");
		lblEx_2.setBounds(364, 32, 63, 14);
		panel.add(lblEx_2);
		
		JLabel lblEx_3 = new JLabel("Ex.: 05");
		lblEx_3.setBounds(557, 32, 63, 14);
		panel.add(lblEx_3);
		
		/**
		 * CAMPOS DE TEXTO (TEXTFIELD'S)
		 */
		
		textField_Curso = new JFormattedTextField(maskCurso);
		textField_Curso.setBounds(52, 51, 51, 25);
		textField_Curso.setBackground(Color.LIGHT_GRAY);
		textField_Curso.addFocusListener(new CaretPosicao());
		panel.add(textField_Curso);
		textField_Curso.setColumns(10);
		
		
		textField_Codigo = new JFormattedTextField(maskCodigo);
		textField_Codigo.setBounds(52, 25, 51, 25);
		textField_Codigo.setBackground(Color.LIGHT_GRAY);
		textField_Codigo.addFocusListener(new CaretPosicao());
		panel.add(textField_Codigo);
		textField_Codigo.setColumns(10);
		
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(52, 99, 264, 25);
		textField_Nome.setBackground(Color.LIGHT_GRAY);
		textField_Nome.addFocusListener(new CaretPosicao());
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Abreviacao = new JTextField();
		textField_Abreviacao.setBounds(75, 131, 63, 25);
		textField_Abreviacao.setBackground(Color.LIGHT_GRAY);
		textField_Abreviacao.addFocusListener(new CaretPosicao());
		panel.add(textField_Abreviacao);
		textField_Abreviacao.setColumns(10);
		
		
		textField_Capacidade = new JFormattedTextField(maskCapacidade);
		textField_Capacidade.setBounds(301, 25, 51, 25);
		textField_Capacidade.setBackground(Color.LIGHT_GRAY);
		textField_Capacidade.addFocusListener(new CaretPosicao());
		panel.add(textField_Capacidade);
		textField_Capacidade.setColumns(10);
		
		
		textField_Ano = new JFormattedTextField(maskAno);
		textField_Ano.setBounds(301, 51, 51, 25);
		textField_Ano.setBackground(Color.LIGHT_GRAY);
		textField_Ano.addFocusListener(new CaretPosicao());
		panel.add(textField_Ano);
		textField_Ano.setColumns(10);
		
		
		textField_Semestre = new JFormattedTextField(maskSemestre);
		textField_Semestre.setBounds(497, 25, 51, 25);
		textField_Semestre.setBackground(Color.LIGHT_GRAY);
		textField_Semestre.addFocusListener(new CaretPosicao());
		panel.add(textField_Semestre);
		textField_Semestre.setColumns(10);
		
		textField_Pesquisar = new JFormattedTextField(maskPesquisa);
		textField_Pesquisar.setBounds(690, 236, 60, 23);
		frmTurmas.getContentPane().add(textField_Pesquisar);
		textField_Pesquisar.setColumns(10);
		
		/**
		 * BOTÕES
		 */
		
		btnSalvar = new JButton("Salvar");
	    btnSalvar.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent arg0) {
	        int i = 0, j = 0;
	        if(modo.equals("Novo")) {
	          try {
	            Turmas turma = new Turmas(Integer.parseInt(textField_Curso.getText()), Integer.parseInt(textField_Semestre.getText()), Integer.parseInt(textField_Codigo.getText()), textField_Nome.getText().trim(), textField_Abreviacao.getText().trim(), Integer.parseInt(textField_Ano.getText()), Integer.parseInt(textField_Capacidade.getText()));
	            j = turma.retornar();
	            turma.cadastrar();
	            i = turma.retornar();
	          } catch(NumberFormatException e) {//Como os textfield's s�o inicializados com "", ao tentar converter um campo que tem "" para inteiro, d� uma exce��o do tipo NumberFormatException
	            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar", "Erro", 1);
	          }
	          // Se o codigo for repetido esta mensagem nao pode ser comunicada.
	          if (i == j) {
	            LoadTable();
	            JOptionPane.showMessageDialog(null, "Cadastro nao realizado.");
	          }
	          else {
	            LoadTable();
	            JOptionPane.showMessageDialog(null, "Cadastro feita com sucesso!");
	          }
	          
				} else if (modo.equals("Alterar")) {
					if((JOptionPane.showConfirmDialog(null, "Deseja alterar a turma selecionada?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == JOptionPane.YES_OPTION) {
						int index = table.getSelectedRow();
						Turmas.turmasCad.get(index).setCodigo(Integer.parseInt(textField_Codigo.getText()));
						Turmas.turmasCad.get(index).setAno(Integer.parseInt(textField_Ano.getText()));
						Turmas.turmasCad.get(index).setCapacidade(Integer.parseInt(textField_Capacidade.getText()));
						Turmas.turmasCad.get(index).setSemestre(Integer.parseInt(textField_Semestre.getText()));
						Turmas.turmasCad.get(index).setCurso(Integer.parseInt(textField_Curso.getText()));
						Turmas.turmasCad.get(index).setNomeCompleto(textField_Nome.getText());
						Turmas.turmasCad.get(index).setNomeAbreviado(textField_Abreviacao.getText());
						JOptionPane.showMessageDialog(null, "Altera��o feita com sucesso!");
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
		btnSalvar.setBounds(530, 117, 95, 35);
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
		btnCancelar.setBounds(629, 117, 95, 35);
		panel.add(btnCancelar);
		
		
		
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
		btnNovo.setBounds(44, 221, 98, 38);
		frmTurmas.getContentPane().add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modo = "Alterar";
				ManipulaInterface();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(154, 221, 98, 38);
		frmTurmas.getContentPane().add(btnAlterar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = 0;
				try{
					codigo = Integer.parseInt(textField_Pesquisar.getText());
					
				}catch(NumberFormatException x) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um c�digo.");
				}
				boolean x = false;
				for(int i=0; i<Turmas.turmasCad.size(); i++) {
					if(codigo == Turmas.turmasCad.get(i).getCodigo()) {
						ArrayList <Turmas>  cad = new ArrayList<>();
						cad.add(Turmas.turmasCad.get(i));
						x = true;
						Object colunas[] = {"C�digo","Curso","Nome","Abrevia��o","Capacidade","Semestre","Ano"};
						DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
						modelo.addRow(new Object[] {Turmas.turmasCad.get(i).getCodigo(),Turmas.turmasCad.get(i).getCurso(),Turmas.turmasCad.get(i).getNomeCompleto(),Turmas.turmasCad.get(i).getNomeAbreviado(),Turmas.turmasCad.get(i).getCapacidade(),Turmas.turmasCad.get(i).getSemestre(),Turmas.turmasCad.get(i).getAno()});
						table.setModel(modelo);
					}
					modo = "Pesquisar";
					ManipulaInterface();
				}
				if(x == false){
					JOptionPane.showMessageDialog(null, "Turma n�o encontrada!");
				}
				textField_Pesquisar.setText("");
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
					JOptionPane.showMessageDialog(null, "Turma exclu�da com sucesso!");
				}
			}
				
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(264, 221, 98, 38);
		frmTurmas.getContentPane().add(btnExcluir);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadTable();
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
		btnAtualizar.setBounds(500, 236, 89, 23);
		frmTurmas.getContentPane().add(btnAtualizar);
	}
}
