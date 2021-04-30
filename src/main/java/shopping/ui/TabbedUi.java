package shopping.ui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import shopping_list.DetailList;
import shopping_list.Mainlist;
import shopping_list.ProductList;
import javax.swing.border.TitledBorder;

public class TabbedUi extends JFrame {

	private JPanel contentPane;
	private Mainlist pMain;
	private ProductList pProduct;
	private DetailList pDetail;
	

	public TabbedUi() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(520, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTabbedPane tPane = new JTabbedPane(JTabbedPane.TOP);
		tPane.setBorder(new TitledBorder(null, "관리자페이지", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(tPane);
		
		pMain = new Mainlist();
		pMain.setTab(this);
		tPane.addTab("Main", null, pMain, "메인화면");
		
		pProduct = new ProductList();
		pProduct.setTab(this);
		tPane.addTab("Product", null, pProduct, "제품별관리");
		
		pDetail = new DetailList();
		tPane.addTab("Detail", null, pDetail, "상세관리");
	}

	

}
