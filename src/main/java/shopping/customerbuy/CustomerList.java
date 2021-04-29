package shopping.customerbuy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shopping.Main;
import shopping.customerinfo.CustomerInfoList;
import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.dto.Sign;
import shopping.exception.InvaildCheckException;
import shopping.service.ProductService;
import shopping.service.SalesService;

public class CustomerList extends JFrame implements ActionListener {

	private JPanel contentPane;
	private CustomerTopPanel pTop;
	private CustomerBuyPanel pList;
	private JPanel pBtns;
	private ProductService service;
	private SalesService sService;
	private JPanel pChecks;
	private JButton btnCheck;
	private JButton btnBuy;
	private JPanel pInfo;
	private JButton btnInfo;
	private JButton btnLogout;
	private String id;
	private List<Sales> list;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public CustomerList() {
		service = new ProductService();
		sService = new SalesService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(720, 300, 450, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pTop = new CustomerTopPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		pList = new CustomerBuyPanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		pBtns.setLayout(new GridLayout(0, 2, 0, 0));
		
		pChecks = new JPanel();
		pBtns.add(pChecks);
		
		btnCheck = new JButton("확인");
		btnCheck.addActionListener(this);
		pChecks.add(btnCheck);
		
		btnBuy = new JButton("구매");
		btnBuy.addActionListener(this);
		pChecks.add(btnBuy);
		
		pInfo = new JPanel();
		pBtns.add(pInfo);
		
		btnInfo = new JButton("주문정보");
		btnInfo.addActionListener(this);
		pInfo.add(btnInfo);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		pInfo.add(btnLogout);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnBuy) {
				actionPerformedBtnBuy(e);
			}
		}catch (InvaildCheckException e1) {
			JOptionPane.showMessageDialog(null, "주문하시려는 정보가 부족합니다.", "빈칸있음", JOptionPane.ERROR_MESSAGE );
		}
		
		try {
			if (e.getSource() == btnCheck) {
				actionPerformedBtnCheck(e);
			}
		}catch (IndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "주문하실 제품을 선택해주세요", "선택바람", JOptionPane.ERROR_MESSAGE);
		}
		
		if (e.getSource() == btnLogout) {
			actionPerformedBtnLogout(e);
		}
		try {
		if (e.getSource() == btnInfo) {
			actionPerformedBtnInfo(e);
		}
		}catch(NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "주문한 제품이 없습니다", "주문없음", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	protected void actionPerformedBtnInfo(ActionEvent e) {
		list = sService.selectAddTotalPrice(id);		
		System.out.println(getId());
		System.out.println(list.get(0).getCuNo().getCuNo());
		CustomerInfoList frame = new CustomerInfoList();
		frame.initlist2(list);
//		id셋해주기
		frame.setId(getId());
		frame.setVisible(true);
		dispose();
	}
	protected void actionPerformedBtnLogout(ActionEvent e) {
	int res = JOptionPane.showConfirmDialog(null, "로그아웃", "감사합니다", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(res == JOptionPane.YES_OPTION) {
		Main frame = new Main();
		frame.setVisible(true);
		dispose();
		JOptionPane.showMessageDialog(null, "감사합니다", "Thanku", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	protected void actionPerformedBtnCheck(ActionEvent e) {
		Product checkItem = pList.getItem();
		pTop.setItem(checkItem);		
	}
	protected void actionPerformedBtnBuy(ActionEvent e) {
		pTop.vaildCheck();		
		list = sService.selectAddTotalPrice(id);
		int qty = pTop.getItem().getStock();		
		Customer cuno = new Customer(list.get(0).getCuNo().getCuNo());	
		Product code = new Product(pTop.getItem().getpCode());
		Sales sale = new Sales(qty,cuno,code);
		sService.insertOrder(sale);
		pTop.setClear();
		
	}
}
