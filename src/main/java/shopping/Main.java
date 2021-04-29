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

import shopping.customerbuy.CustomerList;
import shopping.dto.Sign;
import shopping.exception.InvaildCheckException;
import shopping.service.SignService;
import shopping.ui.TabbedUi;
import shopping_list.SignList;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tFId;
	private JPasswordField JPasswd;
	private JButton btnIn;
	private JButton btnNew;
	private SignService service;
	private JPanel pLogin;

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
		service = new SignService();
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(720, 350, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Login", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pLogin = new JPanel();
		contentPane.add(pLogin);
		pLogin.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		pLogin.add(lblId);

		tFId = new JTextField();
		tFId.setFont(new Font("굴림", Font.PLAIN, 30));
		tFId.setHorizontalAlignment(SwingConstants.RIGHT);
		pLogin.add(tFId);
		tFId.setColumns(10);

		JLabel lblpasswd = new JLabel("비밀번호");
		lblpasswd.setHorizontalAlignment(SwingConstants.CENTER);
		pLogin.add(lblpasswd);

		JPasswd = new JPasswordField();
		JPasswd.setFont(new Font("굴림", Font.PLAIN, 30));
		JPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
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
	private void validCheck() {
		if(tFId.getText().equals("") || JPasswd.getPassword().equals("")) {
			throw new InvaildCheckException();
		}
	}
	
	
	public Sign loginItemS() {
		validCheck();
		String id = tFId.getText().trim();
		String passwd = String.valueOf(JPasswd.getPassword()).trim();
		return new Sign(id, passwd);
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
		if(tFId.getText().trim().equals("tkdrjs7")&&passwd.equals("1234")) {
		setVisible(false);
		
		TabbedUi frame = new TabbedUi();
		frame.setVisible(true);				
		JOptionPane.showMessageDialog(null, "헬게이트 오픈", "ㅠ.ㅠ", JOptionPane.WARNING_MESSAGE);		
		
		}else {
		Sign login = loginItemS();
		Sign loginCustomer = service.loginCustomer(login);
		
		if(loginCustomer != null) {
		setVisible(false);
		
		CustomerList frame = new CustomerList();		
		frame.setId(tFId.getText());
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "환영합니다 고객님", "^.^", JOptionPane.INFORMATION_MESSAGE);
		
		}else {
			JOptionPane.showMessageDialog(null, "아이디, 비밀번호가 틀렸습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		}
		}								
	
	}
	protected void actionPerformedBtnNew(ActionEvent e) {
		SignList frame = new SignList();
		frame.setVisible(true);
		setVisible(false);
	}
}
