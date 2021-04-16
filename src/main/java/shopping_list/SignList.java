package shopping_list;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shopping.Main;

import javax.swing.JButton;
import shopping_list.panel.SignPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignList extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;

	
	public SignList() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SignPanel pMain = new SignPanel();
		contentPane.add(pMain, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("등록");
		pBtns.add(btnAdd);
		
		JButton btnReset = new JButton("초기화");
		pBtns.add(btnReset);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		Main frame = new Main();
		frame.setVisible(true);
		setVisible(false);
				
	}
}
