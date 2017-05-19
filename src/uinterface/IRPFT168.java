package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import business.Irpf;
import business.Pessoa;
import business.facadeIrpf;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class IRPFT168 extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textIdade;
	private facadeIrpf facade;
	private Pessoa pessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IRPFT168 frame = new IRPFT168();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public IRPFT168() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 399);
		setLocationRelativeTo(null); //centralizando formulario...
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNome = new JTextField();
		textNome.setBounds(163, 44, 185, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textCPF = new JTextField();
		textCPF.setBounds(163, 75, 185, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		textIdade = new JTextField();
		textIdade.setBounds(163, 106, 114, 19);
		contentPane.add(textIdade);
		textIdade.setColumns(10);

		JSpinner spiDependentes = new JSpinner();
		spiDependentes.setBounds(163, 137, 41, 20);
		contentPane.add(spiDependentes);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(12, 46, 152, 15);
		contentPane.add(lblNewLabel);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 77, 152, 15);
		contentPane.add(lblCpf);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 108, 152, 15);
		contentPane.add(lblIdade);

		JLabel lblNDependentes = new JLabel("N.º Dependentes:");
		lblNDependentes.setBounds(12, 139, 152, 15);
		contentPane.add(lblNDependentes);
		double contribuicao;

		JLabel lblContribuicaoAssis = new JLabel("Contribuicao Assis:");
		lblContribuicaoAssis.setBounds(12, 171, 220, 15);
		contentPane.add(lblContribuicaoAssis);
		double valor;

		JLabel lblContribuioAssis = new JLabel("Total dos Rendimentos:");
		lblContribuioAssis.setBounds(12, 200, 220, 15);
		contentPane.add(lblContribuioAssis);

		JLabel lblImpostoPagar = new JLabel("Imposto A Pagar:");
		lblImpostoPagar.setBounds(12, 302, 152, 15);
		contentPane.add(lblImpostoPagar);

		JRadioButton rdbtnSim = new JRadioButton("Simplificada");
		rdbtnSim.setSelected(true);
		rdbtnSim.setBounds(50, 238, 114, 23);
		contentPane.add(rdbtnSim);

		JRadioButton rdbtnCom = new JRadioButton("Completa");
		rdbtnCom.setBounds(201, 238, 114, 23);
		contentPane.add(rdbtnCom);

		// Agrupando os controles Radio
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSim);
		group.add(rdbtnCom);
		
		// Controle de texto formatado usando classe de tratamento...
		JFormattedTextField txtContribuicao = new DecimalFormattedField(DecimalFormattedField.REAL);
		txtContribuicao.setBounds(234, 167, 114, 19);
		contentPane.add(txtContribuicao);

		JFormattedTextField txtTotalRendimentos = new DecimalFormattedField(DecimalFormattedField.REAL);
		txtTotalRendimentos.setBounds(234, 198, 114, 19);
		contentPane.add(txtTotalRendimentos);

		JFormattedTextField txtImpostoAPagar = new DecimalFormattedField(DecimalFormattedField.REAL);
		txtImpostoAPagar.setEditable(false);
		txtImpostoAPagar.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		txtImpostoAPagar.setBounds(163, 300, 185, 19);
		contentPane.add(txtImpostoAPagar);

		/**
		 * 
		 * 
		 * Botao para calcular os impostos ...
		 */
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNome.getText().equals("")){
					JOptionPane.showMessageDialog(IRPFT168.this,"Necessario informar o NOME do contribuinte.", "Nome", JOptionPane.INFORMATION_MESSAGE);
					textNome.requestFocus();
				} else if(textCPF.getText().equals("")){
					JOptionPane.showMessageDialog(IRPFT168.this,"Necessario informar o CPF do contribuinte.", "CPF", JOptionPane.INFORMATION_MESSAGE);
					textCPF.requestFocus();
				} else if(textIdade.getText().equals("")){
					JOptionPane.showMessageDialog(IRPFT168.this,"Necessario informar a IDADE do contribuinte.", "Idade", JOptionPane.INFORMATION_MESSAGE);
					textIdade.requestFocus();
				} else {
					//Carrega as variaveis...
					String nome = textNome.getText();
					String cpf = textCPF.getText();
					int idade = Integer.parseInt(textIdade.getText());
					int dependentes = (int) spiDependentes.getValue();
					double contribuicao = (double) txtContribuicao.getValue();
					double totalrendimentos = (double) txtTotalRendimentos.getValue();
					
					facade = new facadeIrpf();

					if (rdbtnSim.isSelected()) {
						facade.recebePessoa(nome, cpf, idade, dependentes, contribuicao, totalrendimentos);
						double retorno = facade.calculaImpostoSimplificado();	
						txtImpostoAPagar.setText(Double.toString(retorno));				
					}else{
						facade.recebePessoa(nome, cpf, idade, dependentes, contribuicao, totalrendimentos);
						double retorno = facade.calculaImpostoCompleto();
						txtImpostoAPagar.setText(Double.toString(retorno));
					}		
				}
			}
		});
		btnCalcular.setBounds(163, 269, 117, 25);
		contentPane.add(btnCalcular);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(231, 331, 117, 25);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel_1 = new JLabel("IRPFT168");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_1.setBounds(12, 12, 194, 15);
		contentPane.add(lblNewLabel_1);

	}
}
