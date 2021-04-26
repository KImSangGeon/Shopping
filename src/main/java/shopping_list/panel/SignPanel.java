package shopping_list.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import shopping.Main;
import shopping.dto.Sign;
import shopping.exception.InvaildCheckException;
import shopping.service.SignService;
import shopping_list.SignList;

import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class SignPanel extends JPanel {
	private JTextField tfID;
	private JPasswordField pf1;
	private JPasswordField pf2;
	private JTextField tfName;
	private JTextField tfPhone;
	private JRadioButton rbtFemale;
	private JRadioButton rbtMale;
	private ButtonGroup btngroup = new ButtonGroup();
	private JLabel lblBirth;
	private JDateChooser dCbirth;
	private SignList signtab;

	private SignService service;

	public SignPanel() {

		initialize();
		service = new SignService();
	}

	public void setSigntab(SignList signtab) {
		this.signtab = signtab;
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "회원가입", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 5, 3));

		JLabel lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblID);

		tfID = new JTextField();
		tfID.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfID);
		tfID.setColumns(10);

		JLabel lblPw1 = new JLabel("비밀번호");
		lblPw1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPw1);

		pf1 = new JPasswordField();
		pf1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(pf1);

		JLabel lblPw2 = new JLabel("비밀번호 확인");
		lblPw2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPw2);

		pf2 = new JPasswordField();
		pf2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(pf2);

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);

		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfName);
		tfName.setColumns(10);

		lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBirth);

		dCbirth = new JDateChooser();
		add(dCbirth);

		JLabel lblSex = new JLabel("성별");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSex);

		JPanel pSex = new JPanel();
		add(pSex);
		pSex.setLayout(new GridLayout(0, 2, 0, 0));

		// 라디오 버튼 만들때 반드시 버튼그룹에 add해서 만들기
		rbtFemale = new JRadioButton("여성");
		btngroup.add(rbtFemale);
		rbtFemale.setSelected(true);
		rbtFemale.setHorizontalAlignment(SwingConstants.CENTER);
		pSex.add(rbtFemale);

		rbtMale = new JRadioButton("남성");
		btngroup.add(rbtMale);
		rbtMale.setHorizontalAlignment(SwingConstants.CENTER);
		pSex.add(rbtMale);

		JLabel lblPhone = new JLabel("연락처");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPhone);

		tfPhone = new JTextField();
		tfPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfPhone);
		tfPhone.setColumns(10);

	}

	public void getResult() {
		String pw1 = new String(pf1.getPassword());
		String pw2 = new String(pf2.getPassword());
		if (pw1.equals(pw2)) {
			Sign newSign = getJoin();
			service.insertCustomer(newSign);
			JOptionPane.showMessageDialog(null, "회원 가입 되었습니다.", "등록", JOptionPane.PLAIN_MESSAGE);
			signtab.setVisible(false);
			signtab.goMain();
			
			
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지않습니다.", "등록실패", JOptionPane.WARNING_MESSAGE);
			pf1.setText("");
			pf2.setText("");
		}
	}

	public Sign getJoin(){
		validCheck();
		String CuID = tfID.getText().trim();
		String pass = String.valueOf(pf1.getPassword());
		String name = tfName.getText().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birth = sdf.format(dCbirth.getDate());

		String sex = rbtFemale.isSelected() ? "여성" : "남성";
//		DecimalFormat df = new DecimalFormat("000-0000-0000");
//		System.out.println(df);
		String phone = tfPhone.getText().trim();

		return new Sign(CuID, pass, name, birth, sex, phone);
	}

	public void setAllClear() {
		tfID.setText("");
		pf1.setText("");
		pf2.setText("");
		tfName.setText("");
		tfPhone.setText("");
		dCbirth.setDate(null);
		rbtFemale.setSelected(false);
		rbtMale.setSelected(false);
	}

	private void validCheck(){
		if (tfID.getText().equals("") || pf1.getPassword().equals("") || pf2.getPassword().equals("")
				|| tfName.getText().equals("") || dCbirth.getDate() == null || tfPhone.getText().equals("")) {
			throw new InvaildCheckException();
		}

	}

}
