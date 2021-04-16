package shopping_list;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import shopping.Main;
import shopping.service.SalesService;
import shopping.ui.TabbedUi;
import shopping_list.panel.MainPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class Mainlist extends JPanel implements ActionListener {
	private JTextField tFAmount;
	private JTextField tFSales;
	private MainPanel pList;
	private SalesService service;
	private JButton btnLogout;
	private TabbedUi tab;
	
	
	public void setTab(TabbedUi tab) {
		this.tab = tab;
	}
	
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	ImageIcon icon = new ImageIcon(imgPath + "Shin.jpg");

	public Mainlist() {
		service = new SalesService();
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pBottom = new JPanel();
		add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAmount = new JLabel("총 주문 수량");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		pBottom.add(lblAmount);
		
		tFAmount = new JTextField();
		pBottom.add(tFAmount);
		tFAmount.setColumns(10);
		
		JLabel lblSales = new JLabel("총 판매액 ");
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		pBottom.add(lblSales);
		
		tFSales = new JTextField();
		tFSales.setColumns(10);
		pBottom.add(tFSales);
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pTleft = new JPanel();
		pTop.add(pTleft);
		
		JLabel lblDate = new JLabel("날짜별 조회");
		pTleft.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		pTleft.add(dateChooser);
		
		JPanel pTRight = new JPanel();
		pTop.add(pTRight);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setPreferredSize(new Dimension(60, 23));
		btnSearch.setMinimumSize(new Dimension(57, 23));
		btnSearch.setMaximumSize(new Dimension(60, 60));
		pTRight.add(btnSearch);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		pTRight.add(btnLogout);
		
		pList = new MainPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogout) {
			actionPerformedBtnLogout(e);
		}
	}
	protected void actionPerformedBtnLogout(ActionEvent e) {	
		int res = JOptionPane.showConfirmDialog(
				null, 
				"", 
				"맥주한잔?", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, 
				icon);
		
		if(res == JOptionPane.YES_OPTION) {
			tab.setVisible(false);			
			Main frame = new Main();
			frame.setVisible(true);
			
		}
		if(res == JOptionPane.NO_OPTION) {
			
		}
	}
}
