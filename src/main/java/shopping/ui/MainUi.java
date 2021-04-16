package shopping.ui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shopping.service.SalesService;
import shopping_list.panel.MainPanel;

public class MainUi extends JFrame {

	private JPanel contentPane;
	private SalesService service;
	private MainPanel pList;


	public MainUi() {
		service = new SalesService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop);
		
		JButton btnPro = new JButton("제품별 조회");
		btnPro.setVerticalAlignment(SwingConstants.TOP);
		btnPro.setHorizontalAlignment(SwingConstants.LEFT);
		pTop.add(btnPro);
		
		JButton btnDetail = new JButton("상세 조회");
		btnDetail.setVerticalAlignment(SwingConstants.TOP);
		btnDetail.setHorizontalAlignment(SwingConstants.LEFT);
		pTop.add(btnDetail);
		
		pList = new MainPanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList);
		
		JPanel pResult = new JPanel();
		contentPane.add(pResult);
	}

}
