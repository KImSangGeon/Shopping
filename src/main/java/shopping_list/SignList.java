package shopping_list;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shopping.Main;
import shopping.dto.Sign;
import shopping.exception.InvaildCheckException;
import shopping.service.SignService;

import javax.swing.JButton;
import shopping_list.panel.SignPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignList extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnReset;
	private SignPanel pMain;
	private JButton btnAdd;
	

	public SignList() {
		
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 330, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pMain = new SignPanel();
		pMain.setSigntab(this);
		contentPane.add(pMain, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("가입하기");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnReset = new JButton("초기화");
		btnReset.addActionListener(this);
		pBtns.add(btnReset);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd(e);
			}
		} catch (InvaildCheckException e1) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.", "빈칸", JOptionPane.WARNING_MESSAGE);
		} 
		if (e.getSource() == btnReset) {
			actionPerformedBtnReset(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}

	public void goMain() {
		Main frame = new Main();
		frame.setVisible(true);
		dispose();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		goMain();
	}

	protected void actionPerformedBtnReset(ActionEvent e) {
		pMain.setAllClear();
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {		
		pMain.getResult();
		
	}
}
