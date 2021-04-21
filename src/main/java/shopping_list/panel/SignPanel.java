package shopping_list.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class SignPanel extends JPanel {
	private JTextField tfID;
	private JPasswordField pf1;
	private JPasswordField pf2;
	private JTextField tfName;
	private JTextField tfPhone;
	private JRadioButton rbtFemale;
	private JRadioButton rdtMale;

	public SignPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uD68C\uC6D0\uAC00\uC785", TitledBorder.CENTER, TitledBorder.TOP, null, null));
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
		
		JLabel lblPhone = new JLabel("연락처");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPhone);
		
		tfPhone = new JTextField();
		tfPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfPhone);
		tfPhone.setColumns(10);
		
		JLabel lblSex = new JLabel("성별");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSex);
		
		JPanel pSex = new JPanel();
		add(pSex);
		pSex.setLayout(new GridLayout(0, 2, 0, 0));
		
		rbtFemale = new JRadioButton("여성");
		rbtFemale.setSelected(true);
		rbtFemale.setHorizontalAlignment(SwingConstants.CENTER);
		pSex.add(rbtFemale);
		
		rdtMale = new JRadioButton("남성");
		rdtMale.setHorizontalAlignment(SwingConstants.CENTER);
		pSex.add(rdtMale);
	}

}
