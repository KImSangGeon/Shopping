package shopping_list;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import shopping.service.SalesService;
import shopping_list.panel.DetailPanel;

@SuppressWarnings("serial")
public class DetailList extends JPanel {
	private JTextField tfPsearch;
	private JTextField tfCsearch;
	private JTextField tfTotalOrder;
	private JTextField tfTotalSales;
	private JTextField tfProfit;
	private DetailPanel pList;
	private SalesService service;

	public DetailList() {
		service = new SalesService();
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		
		
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft1 = new JPanel();
		pTop.add(pLeft1);
		
		JLabel lblPsearch = new JLabel("제품별 검색");
		lblPsearch.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft1.add(lblPsearch);
		
		JComboBox cbPsearch = new JComboBox();
		pLeft1.add(cbPsearch);
		
		tfPsearch = new JTextField();
		pLeft1.add(tfPsearch);
		tfPsearch.setColumns(10);
		
		JPanel pRight1 = new JPanel();
		pTop.add(pRight1);
		
		JButton btnP = new JButton("검색");
		pRight1.add(btnP);
		
		JPanel pLeft2 = new JPanel();
		pTop.add(pLeft2);
		
		JLabel lblCsearch = new JLabel("회원별 검색");
		lblCsearch.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft2.add(lblCsearch);
		
		JComboBox cbCsearch = new JComboBox();
		pLeft2.add(cbCsearch);
		
		tfCsearch = new JTextField();
		tfCsearch.setColumns(10);
		pLeft2.add(tfCsearch);
		
		JPanel pRight2 = new JPanel();
		pTop.add(pRight2);
		
		JButton btnC = new JButton("검색");
		pRight2.add(btnC);
		
		JPanel pBottom = new JPanel();
		add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel PTotalOrder = new JPanel();
		pBottom.add(PTotalOrder);
		PTotalOrder.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTotalOrder = new JLabel("총 주문 수량");
		lblTotalOrder.setHorizontalAlignment(SwingConstants.CENTER);
		PTotalOrder.add(lblTotalOrder);
		
		tfTotalOrder = new JTextField();
		PTotalOrder.add(tfTotalOrder);
		tfTotalOrder.setColumns(10);
		
		JPanel pTotalSales = new JPanel();
		pBottom.add(pTotalSales);
		pTotalSales.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTotalSales = new JLabel("총 판매액");
		lblTotalSales.setHorizontalAlignment(SwingConstants.CENTER);
		pTotalSales.add(lblTotalSales);
		
		tfTotalSales = new JTextField();
		tfTotalSales.setColumns(10);
		pTotalSales.add(tfTotalSales);
		
		JPanel pProfit = new JPanel();
		pBottom.add(pProfit);
		pProfit.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblProfit = new JLabel("총 이익금액");
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		pProfit.add(lblProfit);
		
		tfProfit = new JTextField();
		tfProfit.setColumns(10);
		pProfit.add(tfProfit);
		
		pList = new DetailPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}

}
