package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class IRPFT168v1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IRPFT168v1 frame = new IRPFT168v1();
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
	public IRPFT168v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setBounds(37, 372, 345, -351);
		contentPane.add(list);
//		JScrollPane listScroller = new JScrollPane(list);
//		listScroller.setPreferredSize(new Dimension(250, 80));
//        listScroller.setAlignmentX(LEFT_ALIGNMENT);
	}
}
