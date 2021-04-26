package shopping_list;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import shopping.Main;
import shopping.dto.Sales;
import shopping.service.SalesService;
import shopping.ui.TabbedUi;
import shopping_list.panel.MainPanel;
import shopping_list.panel.bottompanel.MainBottom;

@SuppressWarnings("serial")
public class Mainlist extends JPanel implements ActionListener {
	private MainPanel pList;
	private SalesService service;
	private JButton btnLogout;
	private TabbedUi tab;
	private JButton btnSearch;	
	private JDateChooser dateChooser;
	private JPanel pTop;
	private MainBottom pBottom;
	private JPanel pReset;
	private JButton btnReset;

	private List<Sales> list;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	ImageIcon icon = new ImageIcon(imgPath + "Shin.jpg");


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


	protected void actionPerformedBtnSearch(ActionEvent e) {
		// 시간 포맷해서 리스트 불러내기.
		Sales searchByDate = new Sales(sdf.format(dateChooser.getDate()));
		list = service.selectByDate(searchByDate);
				
		pList.selectList(list);
		pBottom.setBottomMain(list);

	}
	protected void actionPerformedBtnReset(ActionEvent e) {
		pList.loadData();
		list = service.showMainList();
		pBottom.setBottomMain(list);
		
	}
}
