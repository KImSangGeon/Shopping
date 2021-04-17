package shopping_list.panel.bottompanel;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.service.SalesService;

public class ProductBottom extends JPanel {
	private SalesService service;	
	private JLabel lblROrderNum;
	private JLabel lblRProfit;
	
	private DecimalFormat df = new DecimalFormat("#,###원");
	public ProductBottom() {
		service = new SalesService();
		
		initialize();
		//메서드 소환
		setOrderNum();
		setProfit();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblOrderNum = new JLabel("총 주문수량");
		lblOrderNum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblOrderNum);
		
		lblROrderNum = new JLabel();
		lblROrderNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblROrderNum);
		
		JLabel lblProfit = new JLabel("총 이익금액");
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblProfit);
		
		lblRProfit = new JLabel();
		lblRProfit.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRProfit);
	}
	
	public void setProfit() {
		List<Sales> saleList = service.showProdcutList();
		int totalSales = saleList.parallelStream().mapToInt(Sales::getProfit).sum();
		lblRProfit.setText(df.format(totalSales));
	}
	
	public void setOrderNum() {
		List<Sales> saleList = service.showProdcutList();
		int totalOrder = saleList.parallelStream().mapToInt(Sales::getOrderNum).sum();
		lblROrderNum.setText(totalOrder +"건");
	}

}
