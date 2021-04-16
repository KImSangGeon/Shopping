package shopping;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import shopping.ui.TabbedUi;
import shopping_list.SignList;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tFId;
	private JPasswordField JPasswd;
	private JButton btnIn;
	private JButton btnNew;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Login", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel pLogin = new JPanel();
		contentPane.add(pLogin);
		pLogin.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		pLogin.add(lblId);

		tFId = new JTextField();
		pLogin.add(tFId);
		tFId.setColumns(10);

		JLabel lblpasswd = new JLabel("비밀번호");
		lblpasswd.setHorizontalAlignment(SwingConstants.CENTER);
		pLogin.add(lblpasswd);

		JPasswd = new JPasswordField();
		pLogin.add(JPasswd);
		JPasswd.setColumns(10);

		JPanel pIn = new JPanel();
		contentPane.add(pIn);
		pIn.setLayout(new BoxLayout(pIn, BoxLayout.Y_AXIS));

		
		btnIn = new JButton("로그인");
		btnIn.addActionListener(this);
		btnIn.setMinimumSize(new Dimension(81, 23));
		btnIn.setMaximumSize(new Dimension(81, 23));
		btnIn.setPreferredSize(new Dimension(81, 23));
		btnIn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pIn.add(btnIn);

		btnNew = new JButton("회원가입");
		btnNew.addActionListener(this);
		btnNew.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNew.setVerticalAlignment(SwingConstants.BOTTOM);
		pIn.add(btnNew);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNew) {
			actionPerformedBtnNew(e);
		}
		if (e.getSource() == btnIn) {
			actionPerformedBtnIn(e);
		}
	}

	protected void actionPerformedBtnIn(ActionEvent e) {
		String passwd= String.valueOf(JPasswd.getPassword());
		if (tFId.getText().trim().equals("tkdrjs7")&&passwd.equals("1234")) {
		TabbedUi frame = new TabbedUi();
		frame.setVisible(true);	
		JOptionPane.showMessageDialog(null, "헬게이트 오픈", "ㅠ.ㅠ", JOptionPane.WARNING_MESSAGE);
		setVisible(false);
		
		}else {
		JOptionPane.showMessageDialog(null, "너 누구야", "정지", JOptionPane.INFORMATION_MESSAGE);
		tFId.setText("");
		JPasswd.setText("");
		}				
						
	}
	protected void actionPerformedBtnNew(ActionEvent e) {
		SignList frame = new SignList();
		frame.setVisible(true);
		setVisible(false);
		
	}
}
