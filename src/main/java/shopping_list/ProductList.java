package shopping_list;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shopping.dto.Product;
import shopping.service.ProductService;
import shopping.service.SalesService;
import shopping_list.panel.ProductPanel;
import shopping_list.panel.bottompanel.ProductBottom;

public class ProductList extends JPanel {
	private JTextField tFOption;
	private ProductPanel pList;
	private SalesService service;
	private JComboBox cbProduct;
	private ProductService	pService;

	public ProductList() {
		service = new SalesService();
		pService = new ProductService();
		
		List<Product> prodList = pService.selectByPcode();
		initialize();
		
		cbProduct.setModel(new DefaultComboBoxModel<Product>(new Vector<>(prodList)));		
		cbProduct.setSelectedIndex(3);
				
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
		
		cbProduct = new JComboBox<>();
		ptLeft.add(cbProduct);
		
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
		
		ProductBottom pBottom = new ProductBottom();
		add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(1, 0, 0, 0));
		
		pList = new ProductPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}
	
	

}
