package shopping.customerinfo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shopping.Main;
import shopping.customerbuy.CustomerList;
import shopping.dto.Sales;
import shopping.service.SalesService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustomerInfoList extends JFrame implements ActionListener {

	private JPanel contentPane;
	private SalesService service;
	private CustomerInfoPanelList pList;
	private CustomerInfoTop pBtns;
	private String id;
	private List<Sales> list;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void initlist2(List<Sales> list) {		
		pList.initList2(list);		
	}
	
	public CustomerInfoList() {		
		service = new SalesService();
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(720, 350, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pBtns = new CustomerInfoTop();
		pBtns.getBtnCancel().addActionListener(this);
		pBtns.getBtnLogout().addActionListener(this);
		pBtns.getBtnMain().addActionListener(this);
		contentPane.add(pBtns);
		
		pList = new CustomerInfoPanelList();
		contentPane.add(pList);
	}

	
	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getSource() == pBtns.getBtnCancel()) {
			actionPerformedPBtnsBtnCancel(e);
		}
		}catch (IndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "주문취소 할 제품을 선택해주세요", "선택된 제품이 없습니다", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == pBtns.getBtnLogout()) {
			actionPerformedPBtnsBtnLogout(e);
		}
		if (e.getSource() == pBtns.getBtnMain()) {
			actionPerformedPBtnsBtnMain(e);
		}
	}
	protected void actionPerformedPBtnsBtnMain(ActionEvent e) {
//		System.out.println("info >>" +getId()); id넘어오는지 확인
		list = service.selectAddTotalPrice(id);
		System.out.println(getId());
		CustomerList frame = new CustomerList();
		frame.setId(getId());
		frame.setVisible(true);
		dispose();
	}
	
	protected void actionPerformedPBtnsBtnLogout(ActionEvent e) {		
		int res = JOptionPane.showConfirmDialog(null, "로그아웃", "감사합니다", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(res == JOptionPane.YES_OPTION) {
		Main frame = new Main();
		frame.setVisible(true);
		dispose();
		JOptionPane.showMessageDialog(null, "감사합니다", "Thanku", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	protected void actionPerformedPBtnsBtnCancel(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(null, "주문취소를 하시겠습니까?", "최종확인 바랍니다.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(res == JOptionPane.YES_OPTION) {
		Sales sales = pList.getItem();
		service.deleteOrder(sales);
		list = service.selectAddTotalPrice(id);
		pList.initList2(list);
		JOptionPane.showMessageDialog(null, "주문이 취소되었습니다.", "주문취소", JOptionPane.INFORMATION_MESSAGE);
		}	
			
	}
}
