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
import shopping.dto.Sales;
import shopping.service.SalesService;
import shopping.ui.TabbedUi;
import shopping_list.panel.MainPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import shopping_list.panel.bottompanel.MainBottom;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class Mainlist extends JPanel implements ActionListener {
	private MainPanel pList;
	private SalesService service;
	private JButton btnLogout;
	private TabbedUi tab;
	private JButton btnSearch;
	private List<Sales> list;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private DecimalFormat df = new DecimalFormat("#,###원");

	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	ImageIcon icon = new ImageIcon(imgPath + "Shin.jpg");
	private JDateChooser dateChooser;
	private JPanel pTop;
	private MainBottom pBottom;
	private JPanel pReset;
	private JButton btnReset;

	// 공부하기 태이블 샸다 내리기
	public void setTab(TabbedUi tab) {
		this.tab = tab;
	}

	public Mainlist() {
		service = new SalesService();
		initialize();

	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		pBottom = new MainBottom();
		add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(1, 0, 0, 0));

		pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pTleft = new JPanel();
		pTop.add(pTleft);
		pTleft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblDate = new JLabel("날짜별 조회");
		pTleft.add(lblDate);

		dateChooser = new JDateChooser();
		pTleft.add(dateChooser);

		JPanel pTRight = new JPanel();
		pTop.add(pTRight);

		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		pTRight.setLayout(new BoxLayout(pTRight, BoxLayout.X_AXIS));
		
		btnSearch = new JButton("검색");
		pTRight.add(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.setMinimumSize(new Dimension(57, 23));
		
		btnReset = new JButton("초기화");
		pTRight.add(btnReset);
		btnReset.addActionListener(this);
		pTRight.add(btnLogout);
		
		pReset = new JPanel();
		pTRight.add(pReset);

		pList = new MainPanel();
		pList.setService(service);
		pList.loadData();
		add(pList, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReset) {
			actionPerformedBtnReset(e);
		}
		try {
			if (e.getSource() == btnSearch) {
				actionPerformedBtnSearch(e);
			}
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "해당 날짜에 주문한 고객이 없습니다.", "구매내역없음", JOptionPane.WARNING_MESSAGE);
		}catch (Exception e1) {
			e1.printStackTrace();
		}

		if (e.getSource() == btnLogout) {
			actionPerformedBtnLogout(e);
		}
	}

	protected void actionPerformedBtnLogout(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(null, "", "맥주한잔?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				icon);

		if (res == JOptionPane.YES_OPTION) {
			tab.setVisible(false);
			Main frame = new Main();
			frame.setVisible(true);

		}
		if (res == JOptionPane.NO_OPTION) {

		}
	}

	private void setNew() {
		int totalOrder = list.parallelStream().mapToInt(Sales::getOrderNum).sum();
		pBottom.getlblOrderNum().setText(totalOrder + "건");
		
		int totalSales = list.parallelStream().mapToInt(Sales::getSaleAmount).sum();
		pBottom.getlblSales().setText(df.format(totalSales));
		
	}	

	protected void actionPerformedBtnSearch(ActionEvent e) {
		// 시간 포맷해서 리스트 불러내기.
		Sales saleList = new Sales(sdf.format(dateChooser.getDate()));
		list = service.selectByDate(saleList);
		pList.selectList(list);
		setNew();

//		pList.loadData2(list);
//		Sales saleList = new Sales();
//		List<Sales> list = service.selectByDate();

	}
	protected void actionPerformedBtnReset(ActionEvent e) {
		pList.loadData();
		pBottom.setBottomMain();
		
	}
}
