package shopping_list;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.service.CustomerService;
import shopping.service.ProductService;
import shopping.service.SalesService;
import shopping_list.panel.DetailPanel;
import shopping_list.panel.bottompanel.DetailBottom;

@SuppressWarnings("serial")
public class DetailList extends JPanel implements ActionListener {

	private JPanel pTop;
	private JPanel pRight2;
	private JButton btnReset;
	private JButton btnC;
	
	private SalesService service;
	private CustomerService cService;
	private ProductService pService;
	
	private JComboBox<Product> cbPsearch;
	private JComboBox<Customer> cbCsearch;
	
	private Product proSelect;
	private Customer cuSelect;
	private DetailPanel pList;	
	private DetailBottom pBottom;
	
	private List<Sales> list;

	private DecimalFormat df = new DecimalFormat("#,###원");


	public DetailList() {
		service = new SalesService();
		cService = new CustomerService();
		pService = new ProductService();

		
		initialize();
		List<Customer> cusList = cService.selectByName();
		List<Product> proList = pService.selectByPname();

		cbPsearch.setModel(new DefaultComboBoxModel<Product>(new Vector<>(proList)));
		cbPsearch.setSelectedIndex(-1);
				
		cbCsearch.setModel(new DefaultComboBoxModel<Customer>(new Vector<>(cusList)));
		cbCsearch.setSelectedIndex(-1);
				
						
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pLeft1 = new JPanel();
		pTop.add(pLeft1);

		JLabel lblPsearch = new JLabel("제품별 검색");
		lblPsearch.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft1.add(lblPsearch);

		cbPsearch = new JComboBox<>();
		pLeft1.add(cbPsearch);

		JPanel pRight1 = new JPanel();
		pTop.add(pRight1);
		
		JPanel pLeft2 = new JPanel();
		pTop.add(pLeft2);
		
		JLabel lblCsearch = new JLabel("회원별 검색");
		lblCsearch.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft2.add(lblCsearch);
				
		cbCsearch = new JComboBox<>();
		pLeft2.add(cbCsearch);
						
		pRight2 = new JPanel();
		pTop.add(pRight2);
						
		btnReset = new JButton("초기화");
		pRight2.add(btnReset);
		btnReset.addActionListener(this);
				
		btnC = new JButton("검색");
		pRight1.add(btnC);
		btnC.addActionListener(this);

		pBottom = new DetailBottom();
		add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(1, 0, 0, 0));

		pList = new DetailPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}
	


	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnC) {
				if (cbPsearch.getSelectedIndex() == -1) {
					actionPerformedBtnC(e);
				}else if(cbCsearch.getSelectedIndex() == -1) {
					actionPerformedBtnP(e);
				}else {
					actionPerformedBtnPandC(e);
				}
			}
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "해당 결과가 없습니다.", "주문여부", JOptionPane.WARNING_MESSAGE);
		}
		if (e.getSource() == btnReset) {
			actionPerformedBtnReset(e);
		}
	}

	private void actionPerformedBtnPandC(ActionEvent e) {
		proSelect = (Product) cbPsearch.getSelectedItem();
		cuSelect = (Customer) cbCsearch.getSelectedItem();
		
		list = service.selectByPnameAndCname(proSelect.getpName(), cuSelect.getCuName());
		pList.selectList(list);
		pBottom.setBottomDetail(list);
	}

	protected void actionPerformedBtnP(ActionEvent e) {
		// 제품전용
		proSelect = (Product) cbPsearch.getSelectedItem();
		list = service.selectByPname(proSelect.getpName());
		pList.selectList(list);
		pBottom.setBottomDetail(list);
	}

	protected void actionPerformedBtnC(ActionEvent e) {
		// 고객전용
		cuSelect = (Customer) cbCsearch.getSelectedItem();
		list = service.selectByCname(cuSelect.getCuName());
		pList.selectList(list);
		pBottom.setBottomDetail(list);
	}

	protected void actionPerformedBtnReset(ActionEvent e) {
		// 모두 리셋
		cbPsearch.setSelectedIndex(-1);
		cbCsearch.setSelectedIndex(-1);
		pList.loadData();
		list = service.showDetailList();
		pBottom.setBottomDetail(list);
	}

}
