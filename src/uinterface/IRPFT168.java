package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IRPFT168 extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textIdade;
	private JTextField textTotalRendimentos;
	private JTextField textResultado;
	private JTextField textContribuicao;

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
	 */
	public IRPFT168() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 399);
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
		lblNewLabel.setBounds(12, 46, 114, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 77, 114, 15);
		contentPane.add(lblCpf);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 108, 114, 15);
		contentPane.add(lblIdade);
		
		JLabel lblNDependentes = new JLabel("N.º Dependentes:");
		lblNDependentes.setBounds(12, 139, 141, 15);
		contentPane.add(lblNDependentes);
		
		textTotalRendimentos = new JTextField();
		textTotalRendimentos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				double contribuicao;
				contribuicao = Double.valueOf(textTotalRendimentos.getText());
				textTotalRendimentos.setText(new DecimalFormat("R$ #,##0.00").format(contribuicao));
			}
			@Override
			public void focusGained(FocusEvent e) {
				textTotalRendimentos.selectAll();
			}
		});
		textTotalRendimentos.setColumns(10);
		textTotalRendimentos.setBounds(234, 198, 114, 19);
		contentPane.add(textTotalRendimentos);
		textTotalRendimentos.setText("0");
		double contribuicao;
		contribuicao = Double.valueOf(textTotalRendimentos.getText());
		textTotalRendimentos.setText(new DecimalFormat("R$ #,##0.00").format(contribuicao));
				
		JLabel lblContribuioAssis = new JLabel("Total dos Rendimentos:");
		lblContribuioAssis.setBounds(12, 200, 220, 15);
		contentPane.add(lblContribuioAssis);
		
		JLabel lblImpostoPagar = new JLabel("Imposto À Pagar:");
		lblImpostoPagar.setBounds(12, 302, 141, 15);
		contentPane.add(lblImpostoPagar);
		
		textResultado = new JTextField();
		textResultado.setColumns(10);
		textResultado.setBounds(163, 300, 185, 19);
		contentPane.add(textResultado);
		
		JRadioButton rdbtnSim = new JRadioButton("Simplificada");
		rdbtnSim.setSelected(true);
		rdbtnSim.setBounds(50, 225, 114, 23);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnCom = new JRadioButton("Completa");
		rdbtnCom.setBounds(201, 225, 114, 23);
		contentPane.add(rdbtnCom);
		
		//Agrupando os controles Radio
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSim);
		group.add(rdbtnCom);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(163, 269, 117, 25);
		contentPane.add(btnCalcular);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(231, 331, 117, 25);
		contentPane.add(btnSair);
		
		JLabel label = new JLabel("Contribuição Assis:");
		label.setBounds(12, 171, 141, 15);
		contentPane.add(label);
		
		textContribuicao = new JTextField();
		textContribuicao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//double valor;
				//valor = Double.valueOf(textContribuicao.getText());
				//Mexer aki esta gerando erro no lostFocus
				textContribuicao.setText(new DecimalFormat("R$ #,##0.00").format(textContribuicao.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {
				textContribuicao.selectAll();
			}
		});
		textContribuicao.setText("0");
		textContribuicao.setColumns(10);
		textContribuicao.setBounds(234, 167, 114, 19);
		double valor;
		valor = Double.valueOf(textContribuicao.getText());
		textContribuicao.setText(new DecimalFormat("R$ #,##0.00").format(valor));
		contentPane.add(textContribuicao);
	}
}
