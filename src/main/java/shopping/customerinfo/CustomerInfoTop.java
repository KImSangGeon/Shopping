package shopping.customerinfo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import shopping.Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfoTop extends JPanel {
	private JButton btnMain;
	private JButton btnLogout;
	private JButton btnCancel;

	public CustomerInfoTop() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pPic = new JPanel();
		add(pPic);
		pPic.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPic = new JLabel("New Label");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		pPic.add(lblPic);
		
		JPanel pRight = new JPanel();
		pPic.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pRightT = new JPanel();
		pRight.add(pRightT);
		pRightT.setLayout(new BorderLayout(0, 0));
		
		btnMain = new JButton("메인");
		pRightT.add(btnMain, BorderLayout.NORTH);
		
		btnLogout = new JButton("로그아웃");
		
		pRightT.add(btnLogout, BorderLayout.SOUTH);
		
		JPanel pRightB = new JPanel();
		pRight.add(pRightB);
		pRightB.setLayout(new BorderLayout(0, 0));
		
		btnCancel = new JButton("주문취소");
		pRightB.add(btnCancel, BorderLayout.CENTER);
	}	

	public JButton getBtnMain() {
		return btnMain;
	}
	public void setBtnMain(JButton btnMain) {
		this.btnMain = btnMain;
	}	

	public JButton getBtnLogout() {
		return btnLogout;
	}
	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}
	
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
}
