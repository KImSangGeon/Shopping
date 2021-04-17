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


	public DetailBottom() {
		service = new SalesService();

		initialize();
		setOrderNum();
		setSales();
		setProfit();
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
	
	public void setOrderNum() {
		List<Sales> saleList = service.showDetailList();
		int totalOrderNum = saleList.parallelStream().mapToInt(Sales::getOrderNum).sum();
		lblROrderNum.setText(totalOrderNum + "건");
	}
	
	public void setSales() {
		List<Sales> saleList = service.showDetailList();
		int totalSales = saleList.parallelStream().mapToInt(Sales::getSaleAmount).sum();
		lblRSales.setText(df.format(totalSales));		
	}
	
	public void setProfit() {
		List<Sales> saleList = service.showDetailList();
		int totalProfit = saleList.parallelStream().mapToInt(Sales::getProfit).sum();
		lblRProfit.setText(df.format(totalProfit));
	}

}
