package shopping_list.panel.bottompanel;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.service.SalesService;

public class DetailBottom extends JPanel {
	
	private SalesService service;
	private JLabel lblROrderNum;
	private JLabel lblRSales;
	private JLabel lblRProfit;
	
	private DecimalFormat df = new DecimalFormat("#,###원");
	private List<Sales> saleList;


	public DetailBottom() {
		service = new SalesService();
		saleList = service.showDetailList();

		initialize();
		setBottomDetail(saleList);
	}
	private void initialize() {
		setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblOrderNum = new JLabel("총 주문 수량");
		lblOrderNum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblOrderNum);
		
		lblROrderNum = new JLabel();
		lblROrderNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblROrderNum);
		
		JLabel lblSales = new JLabel("총 판매액");
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSales);
		
		lblRSales = new JLabel();
		lblRSales.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRSales);
		
		JLabel lblProfit = new JLabel("총 이익금액");
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblProfit);
		
		lblRProfit = new JLabel();
		lblRProfit.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRProfit);
	}
	
	
	public void setBottomDetail(List<Sales> list) {
		int totalOrderNum = list.parallelStream().mapToInt(Sales::getOrderNum).sum();
		lblROrderNum.setText(totalOrderNum + "건");
		
		int totalSales = list.parallelStream().mapToInt(Sales::getSaleAmount).sum();
		lblRSales.setText(df.format(totalSales));	
		
		int totalProfit = list.parallelStream().mapToInt(Sales::getProfit).sum();
		lblRProfit.setText(df.format(totalProfit));
	}
}
