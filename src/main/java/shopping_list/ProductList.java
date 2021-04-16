package shopping_list;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shopping.service.SalesService;
import shopping_list.panel.ProductPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class ProductList extends JPanel {
	private JTextField tFOption;
	private JTextField tfAmount;
	private JTextField tfProfit;
	private ProductPanel pList;
	private SalesService service;

	public ProductList() {
		service = new SalesService();
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel ptLeft = new JPanel();
		pTop.add(ptLeft);
		
		JLabel lblOption = new JLabel("검색조건");
		ptLeft.add(lblOption);
		
		JComboBox cbOption = new JComboBox();
		ptLeft.add(cbOption);
		
		tFOption = new JTextField();
		ptLeft.add(tFOption);
		tFOption.setColumns(10);
		
		JPanel ptRight = new JPanel();
		pTop.add(ptRight);
		ptRight.setLayout(new BoxLayout(ptRight, BoxLayout.X_AXIS));
		
		JButton btnSearch = new JButton("검색");
		ptRight.add(btnSearch);
		
		JButton btnNew = new JButton("초기화");
		ptRight.add(btnNew);
		
		JButton btnAdd = new JButton("제품추가");
		ptRight.add(btnAdd);
		
		JPanel pBottom = new JPanel();
		add(pBottom, BorderLayout.SOUTH);
		
		JLabel lblAmount = new JLabel("총 주문수량");
		pBottom.add(lblAmount);
		
		tfAmount = new JTextField();
		pBottom.add(tfAmount);
		tfAmount.setColumns(10);
		
		JLabel lblProfit = new JLabel("총 이익금액");
		pBottom.add(lblProfit);
		
		tfProfit = new JTextField();
		tfProfit.setColumns(10);
		pBottom.add(tfProfit);
		
		pList = new ProductPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}

}
