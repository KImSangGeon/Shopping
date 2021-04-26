package shopping_list;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.service.ProductService;
import shopping.service.SalesService;
import shopping.ui.TabbedUi;
import shopping_list.panel.ProductPanel;
import shopping_list.panel.bottompanel.ProductBottom;

@SuppressWarnings("serial")
public class ProductList extends JPanel implements ActionListener {
	private ProductPanel pList;
	private JComboBox<Product> cbProduct;
	private SalesService service;
	private ProductService	pService;
	private JButton btnAdd;
	private TabbedUi tab;
	private JButton btnNew;
	private JButton btnSearch;
	private ProductBottom pBottom;
	private List<Sales> list;	
	
	public void setTab(TabbedUi tab) {
		this.tab = tab;
	}
	
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
		
		JLabel lblOption = new JLabel("제품코드");
		ptLeft.add(lblOption);
		
		cbProduct = new JComboBox<>();
		ptLeft.add(cbProduct);
		
		JPanel ptRight = new JPanel();
		pTop.add(ptRight);
		ptRight.setLayout(new BoxLayout(ptRight, BoxLayout.X_AXIS));
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		ptRight.add(btnSearch);
		
		btnNew = new JButton("초기화");
		btnNew.addActionListener(this);
		ptRight.add(btnNew);
		
		btnAdd = new JButton("제품추가");
		btnAdd.addActionListener(this);
		ptRight.add(btnAdd);
		
		pBottom = new ProductBottom();
		add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(1, 0, 0, 0));
		
		pList = new ProductPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}	
	

	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		}catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "제품이 없습니다.", "재고없음" ,JOptionPane.WARNING_MESSAGE);
		}
		if (e.getSource() == btnNew) {
			actionPerformedBtnNew(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		tab.setVisible(false);
		ProductAdd frame = new ProductAdd();
		frame.setVisible(true);
	}
	
	protected void actionPerformedBtnNew(ActionEvent e) {
		cbProduct.setSelectedIndex(-1);
		pList.loadData();
		list = service.showProdcutList();
		pBottom.setBottomProduct(list);	
	
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Product SelectPro =  (Product) cbProduct.getSelectedItem();
		list = service.selectByPcode(SelectPro);
		pList.selectList(list);
		pBottom.setBottomProduct(list);	
	}
}
