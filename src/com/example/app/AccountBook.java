package com.example.app;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.example.design.RoundBtn;
import com.example.domain.AccountBookData;
import com.example.repository.AccountBookDAO;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class AccountBook extends JFrame {
	
	AccountBookDAO accountBookDAO = new AccountBookDAO();
	
	private Vector<String> columnNames = new Vector<>();
	
	private JTabbedPane tabbedPane;
	private JPanel panelMain;
	private JPanel panelList;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblTime;
	private JLabel lblIncome;
	private JLabel lblExpenses;
	private JLabel lblTotal;
	private JSeparator separator;
	private JSeparator separator_1;
	private JRadioButton rdbtnIncome;
	private JRadioButton rdbtnExpenses;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBox;
	private JLabel lbl4;
	private JLabel lbl5;
	private JTextField tfAmount;
	private JLabel lbl6;
	private JTextField tfMemo;
	private RoundBtn btnWrite;
	private JPanel panelTop1;
	private RoundBtn btnIncome;
	private RoundBtn btnexpenses;
	private JPanel panelEast;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lbl_1;
	private JProgressBar progressBar1;
	private JPanel panel_6;
	private JLabel lbl_2;
	private JProgressBar progressBar2;
	private JLabel lbl_3;
	private JProgressBar progressBar3;
	private JLabel lbl_4;
	private JProgressBar progressBar4;
	private JLabel lbl_5;
	private JProgressBar progressBar5;
	private JLabel lbl_6;
	private JLabel lblTotal2;
	private JPanel panelMonth;
	private JScrollPane scrollPane;
	private JPanel panelTop2;
	private JComboBox comboBox1;
	private JLabel lblNewLabel;
	private JComboBox comboBox2;
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private DefaultTableModel tableModel1 = new DefaultTableModel();
	private DefaultTableModel tableModel2 = new DefaultTableModel();
	private JPanel panel;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblIncome2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblExpenses2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private RoundBtn btnSearch;
	private JPanel panelModify;
	private JPanel panelEast2;
	private JPanel panel_10;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JLabel lblNum;
	private JTextField tfNum;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField tfAmount1;
	private JLabel lblNewLabel_8;
	private JTextField tfMemo1;
	private RoundBtn btnSelect;
	private RoundBtn btnModify;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	private JRadioButton rdbtnIncome1;
	private JRadioButton rdbtnExpenses1;
	private JComboBox cbCategory;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private RoundBtn btnRemove;
	public AccountBook() {
		super("가계부");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(680,450);
		setLocationByPlatform(true);
		getContentPane().add(getTabbedPane(), BorderLayout.CENTER);
		
		columnNames.add("입력순서");
		columnNames.add("날짜");
		columnNames.add("수입/지출");
		columnNames.add("카테고리");
		columnNames.add("금액");
		columnNames.add("내용");
		
		
		setLabel();
		getdatas();
		setResizable(false);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new AccountBook();
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.addTab("메인", null, getPanelMain(), null);
			tabbedPane.addTab("수입 지출내역", null, getPanelList(), null);
			tabbedPane.addTab("월보고서", null, getPanelMonth(), null);
			tabbedPane.addTab("수정하기", null, getPanelModify(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelMain() {
		if (panelMain == null) {
			panelMain = new JPanel();
			panelMain.setBackground(Color.WHITE);
			panelMain.setLayout(null);
			panelMain.add(getLbl1());
			panelMain.add(getLbl2());
			panelMain.add(getLbl3());
			panelMain.add(getLblTime());
			panelMain.add(getLblIncome());
			panelMain.add(getLblExpenses());
			panelMain.add(getLblTotal());
			panelMain.add(getSeparator());
			panelMain.add(getSeparator_1());
			panelMain.add(getRdbtnIncome());
			panelMain.add(getRdbtnExpenses());
			panelMain.add(getComboBox());
			panelMain.add(getLbl4());
			panelMain.add(getLbl5());
			panelMain.add(getTfAmount());
			panelMain.add(getLbl6());
			panelMain.add(getTfMemo());
			panelMain.add(getBtnWrite());
			
		}
		return panelMain;
	}
	private JPanel getPanelList() {
		if (panelList == null) {
			panelList = new JPanel();
			panelList.setBackground(Color.WHITE);
			panelList.setLayout(new BorderLayout(0, 0));
			panelList.add(getPanel_2(), BorderLayout.NORTH);
			panelList.add(getPanelEast(), BorderLayout.EAST);
			panelList.add(getScrollPane(), BorderLayout.CENTER);
			
			
		}
		return panelList;
	}
	private JLabel getLbl1() {
		if (lbl1 == null) {
			lbl1 = new JLabel("수입");
			lbl1.setForeground(new Color(0, 153, 255));
			lbl1.setBounds(46, 58, 32, 18);
		}
		return lbl1;
	}
	private JLabel getLbl2() {
		if (lbl2 == null) {
			lbl2 = new JLabel("지출");
			lbl2.setForeground(new Color(255, 0, 51));
			lbl2.setBounds(318, 58, 32, 18);
		}
		return lbl2;
	}
	private JLabel getLbl3() {
		if (lbl3 == null) {
			lbl3 = new JLabel("합계");
			lbl3.setBounds(603, 58, 32, 18);
		}
		return lbl3;
	}
	private JLabel getLblTime() {
		if (lblTime == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월");
			String str = sdf.format(new Timestamp(System.currentTimeMillis()))+"";
			lblTime = new JLabel(str);
			lblTime.setBounds(292, 12, 74, 18);
		}
		return lblTime;
	}
	private JLabel getLblIncome() {
		if (lblIncome == null) {
			lblIncome = new JLabel("New label");
			lblIncome.setForeground(new Color(0, 153, 255));
			lblIncome.setHorizontalAlignment(SwingConstants.CENTER);
			lblIncome.setBounds(12, 88, 98, 18);
		}
		return lblIncome;
	}
	private JLabel getLblExpenses() {
		if (lblExpenses == null) {
			lblExpenses = new JLabel("New label");
			lblExpenses.setForeground(new Color(255, 0, 51));
			lblExpenses.setHorizontalAlignment(SwingConstants.CENTER);
			lblExpenses.setBounds(281, 88, 98, 18);
		}
		return lblExpenses;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("New label");
			lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotal.setBounds(559, 88, 98, 18);
		}
		return lblTotal;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.LIGHT_GRAY);
			separator.setBounds(0, 42, 669, 4);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.LIGHT_GRAY);
			separator_1.setBounds(0, 118, 669, 2);
		}
		return separator_1;
	}
	private JRadioButton getRdbtnIncome() {
		if (rdbtnIncome == null) {
			rdbtnIncome = new JRadioButton("수입");
			rdbtnIncome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if (rdbtnIncome.isSelected()) {
						comboBox.setModel(
								new DefaultComboBoxModel(new String[] { "카테고리..", "월급", "용돈", "부수입", "상여", "기타" }));
					}
				}
			});
			rdbtnIncome.setHorizontalAlignment(SwingConstants.CENTER);
			buttonGroup.add(rdbtnIncome);
			rdbtnIncome.setBounds(106, 141, 121, 26);
		}
		return rdbtnIncome;
	}
	private JRadioButton getRdbtnExpenses() {
		if (rdbtnExpenses == null) {
			rdbtnExpenses = new JRadioButton("지출");
			rdbtnExpenses.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnExpenses.isSelected()) {
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"카테고리..", "식비", "교통/차량",
											"여가", "쇼핑", "기타"}));
					}
				}
			});
			rdbtnExpenses.setHorizontalAlignment(SwingConstants.CENTER);
			buttonGroup.add(rdbtnExpenses);
			rdbtnExpenses.setBounds(403, 141, 121, 26);
		}
		return rdbtnExpenses;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"카테고리..."}));
			
			comboBox.setBounds(143, 191, 121, 27);
		}
		return comboBox;
	}
	private JLabel getLbl4() {
		if (lbl4 == null) {
			lbl4 = new JLabel("분류");
			lbl4.setBounds(55, 195, 32, 18);
		}
		return lbl4;
	}
	private JLabel getLbl5() {
		if (lbl5 == null) {
			lbl5 = new JLabel("금액");
			lbl5.setBounds(55, 249, 32, 18);
		}
		return lbl5;
	}
	private JTextField getTfAmount() {
		if (tfAmount == null) {
			tfAmount = new JTextField();
			tfAmount.setBounds(143, 247, 173, 22);
			tfAmount.setColumns(10);
		}
		return tfAmount;
	}
	private JLabel getLbl6() {
		if (lbl6 == null) {
			lbl6 = new JLabel("내용");
			lbl6.setBounds(55, 300, 32, 18);
		}
		return lbl6;
	}
	private JTextField getTfMemo() {
		if (tfMemo == null) {
			tfMemo = new JTextField();
			tfMemo.setColumns(10);
			tfMemo.setBounds(143, 298, 311, 48);
		}
		return tfMemo;
	}
	private RoundBtn getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new RoundBtn("작성");
			btnWrite.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AccountBookData abData = new AccountBookData();
					if(!(rdbtnIncome.isSelected() || rdbtnExpenses.isSelected())) {
						JOptionPane.showMessageDialog(AccountBook.this, "수입, 지출 버튼을 눌러주세요", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					int selectedIndex  = comboBox.getSelectedIndex();
					if(selectedIndex == 0) {
						JOptionPane.showMessageDialog(AccountBook.this, "검색항목을 선택하세요.", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(tfAmount.getText().length() == 0) {
						JOptionPane.showMessageDialog(AccountBook.this, "금액을 입력하세요.", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					for(int i=0;i<tfAmount.getText().length();i++) {
						if(!(tfAmount.getText().charAt(i)>='0'&&tfAmount.getText().charAt(i)<='9')) {
							JOptionPane.showMessageDialog(AccountBook.this, "금액은 숫자만 입력하세요.", "에러", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					abData.setTime(new Timestamp(System.currentTimeMillis()));
					abData.setInout(rdbtnIncome.isSelected() ? "income" : "expenses");
					String field = "";
					if(rdbtnExpenses.isSelected()) {
						switch(selectedIndex) {
						case 1: field = "food"; break;
						case 2: field = "traffic"; break;
						case 3: field = "culture"; break;
						case 4: field = "shopping"; break;
						case 5: field = "etc"; break;
						}
					}else {
						switch(selectedIndex) {
						case 1: field = "salary"; break;
						case 2: field = "pocketmoney"; break;
						case 3: field = "addincome"; break;
						case 4: field = "bonus"; break;
						case 5: field = "etc"; break;
						}
					}
					abData.setCategories(field);
					abData.setAmount(Integer.parseInt(tfAmount.getText()));
					abData.setMemo(tfMemo.getText());
					accountBookDAO.insertData(abData);
					
					setLabel();
					buttonGroup.clearSelection();
					comboBox.setSelectedIndex(0);
					tfAmount.setText("");
					tfMemo.setText("");
					getdatas();
					JOptionPane.showMessageDialog(AccountBook.this, "작성 되었습니다..", "작성성공", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnWrite.setForeground(Color.WHITE);
			btnWrite.setBackground(new Color(255, 102, 102));
			btnWrite.setBounds(520, 308, 98, 28);
		}
		return btnWrite;
	}
	
	private void setLabel() {
		
		lblIncome.setText(accountBookDAO.income()+"원");
		lblExpenses.setText(accountBookDAO.expenses()+"원");
		lblTotal.setText((accountBookDAO.income()-accountBookDAO.expenses())+"원");
		
		
	}
	private JPanel getPanel_2() {
		if (panelTop1 == null) {
			panelTop1 = new JPanel();
			panelTop1.setBackground(Color.WHITE);
			panelTop1.add(getBtnIncome());
			panelTop1.add(getBtnexpenses());
		}
		return panelTop1;
	}
	private RoundBtn getBtnIncome() {
		if (btnIncome == null) {
			btnIncome = new RoundBtn("수입");
			btnIncome.setForeground(Color.WHITE);
			btnIncome.setBackground(new Color(0, 153, 255));
			btnIncome.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					income();
				}
			});
		}
		return btnIncome;
	}
	private RoundBtn getBtnexpenses() {
		if (btnexpenses == null) {
			btnexpenses = new RoundBtn("지출");
			btnexpenses.setForeground(Color.WHITE);
			btnexpenses.setBackground(new Color(255, 102, 102));
			btnexpenses.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					expenses();
				}
			});
		}
		return btnexpenses;
	}
	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setBackground(Color.WHITE);
			panelEast.setLayout(new GridLayout(0, 1, 0, 0));
			panelEast.add(getPanel_1());
			panelEast.add(getPanel_2_1());
			panelEast.add(getPanel_3());
			panelEast.add(getPanel_4());
			panelEast.add(getPanel_5());
			panelEast.add(getPanel_6());
		}
		return panelEast;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.add(getLbl_1());
			panel_1.add(getProgressBar_1());
		}
		return panel_1;
	}
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.add(getLbl_2());
			panel_2.add(getProgressBar_1_1());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.add(getLbl_3());
			panel_3.add(getProgressBar3());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.WHITE);
			panel_4.add(getLbl_4());
			panel_4.add(getProgressBar4());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.WHITE);
			panel_5.add(getLbl_5());
			panel_5.add(getProgressBar5());
		}
		return panel_5;
	}
	private JLabel getLbl_1() {
		if (lbl_1 == null) {
			lbl_1 = new JLabel("New label");
		}
		return lbl_1;
	}
	private JProgressBar getProgressBar_1() {
		if (progressBar1 == null) {
			progressBar1 = new JProgressBar();
			progressBar1.setStringPainted(true);
		}
		return progressBar1;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.WHITE);
			panel_6.setLayout(null);
			panel_6.add(getLbl_6());
			panel_6.add(getLblTotal2());
		}
		return panel_6;
	}
	private JLabel getLbl_2() {
		if (lbl_2 == null) {
			lbl_2 = new JLabel("New label");
		}
		return lbl_2;
	}
	private JProgressBar getProgressBar_1_1() {
		if (progressBar2 == null) {
			progressBar2 = new JProgressBar();
			progressBar2.setStringPainted(true);
		}
		return progressBar2;
	}
	private JLabel getLbl_3() {
		if (lbl_3 == null) {
			lbl_3 = new JLabel("New label");
		}
		return lbl_3;
	}
	private JProgressBar getProgressBar3() {
		if (progressBar3 == null) {
			progressBar3 = new JProgressBar();
			progressBar3.setStringPainted(true);
		}
		return progressBar3;
	}
	private JLabel getLbl_4() {
		if (lbl_4 == null) {
			lbl_4 = new JLabel("New label");
		}
		return lbl_4;
	}
	private JProgressBar getProgressBar4() {
		if (progressBar4 == null) {
			progressBar4 = new JProgressBar();
			progressBar4.setStringPainted(true);
		}
		return progressBar4;
	}
	private JLabel getLbl_5() {
		if (lbl_5 == null) {
			lbl_5 = new JLabel("New label");
		}
		return lbl_5;
	}
	private JProgressBar getProgressBar5() {
		if (progressBar5 == null) {
			progressBar5 = new JProgressBar();
			progressBar5.setStringPainted(true);
		}
		return progressBar5;
	}
	private JLabel getLbl_6() {
		if (lbl_6 == null) {
			lbl_6 = new JLabel("총합");
			lbl_6.setBounds(77, 12, 55, 18);
			lbl_6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl_6;
	}
	private JLabel getLblTotal2() {
		if (lblTotal2 == null) {
			lblTotal2 = new JLabel("New label");
			lblTotal2.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotal2.setBounds(65, 42, 88, 18);
		}
		return lblTotal2;
	}
	private void setIncome() {
		
		// 일반스레드
		Thread thread = new Thread(new Runnable() {
			
			int ssum = 0, psum = 0, asum = 0, bsum = 0, esum = 0;
			
			@Override
			public void run() {
				List<AccountBookData> list = accountBookDAO.getIncomeDatas();
				//int ssum = 0, psum = 0, asum = 0, bsum = 0, esum = 0;
				String category;
				
				int income = accountBookDAO.income();
				
				for (AccountBookData abBook : list) {
					category = abBook.getCategories();
					switch (category) {
					case "salary": ssum += abBook.getAmount(); break;
					case "pocketmoney": psum += abBook.getAmount(); break;
					case "addincome": asum += abBook.getAmount(); break;
					case "bonus": bsum += abBook.getAmount(); break;
					case "etc": esum += abBook.getAmount(); break;
					}
				}
				
				// UI 스레드
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						lbl_6.setForeground(new Color(0, 153, 255));
						lblTotal2.setForeground(new Color(0, 153, 255));
						lblTotal2.setText(income+"원");
						
						lbl_1.setForeground(new Color(0, 153, 255));
						lbl_2.setForeground(new Color(0, 153, 255));
						lbl_3.setForeground(new Color(0, 153, 255));
						lbl_4.setForeground(new Color(0, 153, 255));
						lbl_5.setForeground(new Color(0, 153, 255));
						progressBar1.setForeground(new Color(0, 153, 255));
						progressBar2.setForeground(new Color(0, 153, 255));
						progressBar3.setForeground(new Color(0, 153, 255));
						progressBar4.setForeground(new Color(0, 153, 255));
						progressBar5.setForeground(new Color(0, 153, 255));
						
						lbl_1.setText("월급");
						float value = (float)ssum/income*100;
						int value1 = Math.round(value);
						progressBar1.setValue(value1);
						lbl_2.setText("용돈");
						value = (float)psum/income*100;
						value1 = Math.round(value);
						progressBar2.setValue(value1);
						lbl_3.setText("부수입");
						value = (float)asum/income*100;
						value1 = Math.round(value);
						progressBar3.setValue(value1);
						lbl_4.setText("상여");
						value = (float)bsum/income*100;
						value1 = Math.round(value);
						progressBar4.setValue(value1);
						lbl_5.setText("기타");
						value = (float)esum/income*100;
						value1 = Math.round(value);
						progressBar5.setValue(value1);
						
						AccountBook.this.setVisible(true);
					} // run
				});
				
			} // run
		});
		
		thread.start();

	}
	
	
	
	
	
	private void setExpenses() {
		// 일반스레드
		new Thread(new Runnable() {
			int fsum = 0, tsum = 0, csum = 0, ssum = 0, esum = 0;
			@Override
			public void run() {
				List<AccountBookData> list = accountBookDAO.getExpensesDatas();
				String category;
				
				int expenses = accountBookDAO.expenses();
				
				for(AccountBookData abBook : list) {
					category = abBook.getCategories();
					switch(category) {
					case "food": ; fsum+= abBook.getAmount();   break;
					case "traffic": tsum+= abBook.getAmount(); break;
					case "culture": csum+= abBook.getAmount(); break;
					case "shopping": ssum+= abBook.getAmount(); break;
					case "etc": esum+= abBook.getAmount(); break;
					}
				}
				
				// UI 스레드
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						lbl_6.setForeground(new Color(255, 0, 51));
						lblTotal2.setForeground(new Color(255, 0, 51));
						lblTotal2.setText(expenses+"원");
						
						lbl_1.setForeground(new Color(255, 0, 51));
						progressBar1.setForeground(new Color(255, 0, 51));
						lbl_2.setForeground(new Color(255, 0, 51));
						progressBar2.setForeground(new Color(255, 0, 51));
						lbl_3.setForeground(new Color(255, 0, 51));
						progressBar3.setForeground(new Color(255, 0, 51));
						lbl_4.setForeground(new Color(255, 0, 51));
						progressBar4.setForeground(new Color(255, 0, 51));
						lbl_5.setForeground(new Color(255, 0, 51));
						progressBar5.setForeground(new Color(255, 0, 51));
						
						lbl_1.setText("식비");
						float value = (float)fsum/expenses*100;
						int value1 = Math.round(value);
						progressBar1.setValue(value1);
						lbl_2.setText("교통");
						value = (float)tsum/expenses*100;
						value1 = Math.round(value);
						progressBar2.setValue(value1);
						lbl_3.setText("여가");
						value = (float)csum/expenses*100;
						value1 = Math.round(value);
						progressBar3.setValue(value1);
						lbl_4.setText("쇼핑");
						value = (float)ssum/expenses*100;
						value1 = Math.round(value);
						progressBar4.setValue(value1);
						lbl_5.setText("기타");
						value = (float)esum/expenses*100;
						value1 = Math.round(value);
						progressBar5.setValue(value1);
						AccountBook.this.setVisible(true);
					}
				});
				
				
				
			}
		}).start();

	}
	private void income() {
		setIncome();
		
		List<AccountBookData> list = accountBookDAO.getIncomeDatas();
		 
		Vector<Vector<Object>> vector = getVectorFromList(list);
		 
		// JTable의 첫번째 매개변수는 Vecter 데이터, 두번째 매개변수는 1차원배열 열이름
		tableModel.setDataVector(vector, columnNames);
		table.setModel(tableModel);
		
		//panelList.add(new JScrollPane(table),BorderLayout.CENTER);
		//화면갱신
		this.setVisible(true);
	} 
	
	private void expenses() {
		setExpenses();
		List<AccountBookData> list = accountBookDAO.getExpensesDatas();
		 
		Vector<Vector<Object>> vector = getVectorFromList(list);
		 
		 
		 
		// JTable의 첫번째 매개변수는 Vecter 데이터, 두번째 매개변수는 1차원배열 열이름
		tableModel.setDataVector(vector, columnNames);
		table.setModel(tableModel);
		
		//panelList.add(new JScrollPane(table),BorderLayout.CENTER);
		//화면갱신
		this.setVisible(true);
	} 
	private void monthdatas(int a, int b) {
		List<AccountBookData> list = accountBookDAO.getMonthDatas(a,b);
		 
		Vector<Vector<Object>> vector = getVectorFromList(list);
		 
		 
		// JTable의 첫번째 매개변수는 Vecter 데이터, 두번째 매개변수는 1차원배열 열이름
		tableModel1.setDataVector(vector, columnNames);
		table_1.setModel(tableModel1);
		 
		//panelMonth.add(new JScrollPane(table),BorderLayout.CENTER);
		//화면갱신
		this.setVisible(true);
	} 
	private void getdatas() {
		List<AccountBookData> list = accountBookDAO.getdatas();
		 
		Vector<Vector<Object>> vector = getVectorFromList(list);
		 
		 
		// JTable의 첫번째 매개변수는 Vecter 데이터, 두번째 매개변수는 1차원배열 열이름
		tableModel2.setDataVector(vector, columnNames);
		table_2.setModel(tableModel2);
		 
		//panelMonth.add(new JScrollPane(table),BorderLayout.CENTER);
		//화면갱신
		this.setVisible(true);
	} 
	private Vector<Vector<Object>> getVectorFromList(List<AccountBookData> list) {
		// List<MemberVO> -> Vector<Vector<Object>>로 변환하기
				 Vector<Vector<Object>> vector = new Vector<>();
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일");
				 
				 for(AccountBookData abdata : list) {
					 Vector<Object> rowVector = new Vector<>();
					 rowVector.add(abdata.getNum());
					 rowVector.add(sdf.format(abdata.getTime()));
					 rowVector.add(abdata.getInout());
					 rowVector.add(abdata.getCategories());
					 rowVector.add(abdata.getAmount());
					 rowVector.add(abdata.getMemo());
					 
					 vector.add(rowVector);
				 }
		
		return vector;
	}
	private JPanel getPanelMonth() {
		if (panelMonth == null) {
			panelMonth = new JPanel();
			panelMonth.setBackground(Color.WHITE);
			panelMonth.setLayout(new BorderLayout(0, 0));
			panelMonth.add(getPanel_7(), BorderLayout.NORTH);
			panelMonth.add(getPanel(), BorderLayout.EAST);
			panelMonth.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panelMonth;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_2());
		}
		return scrollPane;
	}
	private JPanel getPanel_7() {
		if (panelTop2 == null) {
			panelTop2 = new JPanel();
			panelTop2.setBackground(Color.WHITE);
			panelTop2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelTop2.add(getComboBox1());
			panelTop2.add(getLblNewLabel());
			panelTop2.add(getComboBox2());
			panelTop2.add(getBtnSearch());
		}
		return panelTop2;
	}
	private JComboBox getComboBox1() {
		if (comboBox1 == null) {
			comboBox1 = new JComboBox();
			comboBox1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comboBox1.getSelectedIndex()>comboBox2.getSelectedIndex()) {
						int a=comboBox1.getSelectedIndex();
						comboBox2.setSelectedIndex(a);;
					}
				}
			});
			comboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		}
		return comboBox1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("~");
			lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 27));
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox2() {
		if (comboBox2 == null) {
			comboBox2 = new JComboBox();
			comboBox2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comboBox2.getSelectedIndex()<comboBox1.getSelectedIndex()) {
						int a=comboBox2.getSelectedIndex();
						comboBox1.setSelectedIndex(a);;
					}

				}
			});
			comboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		}
		return comboBox2;
	}
	private JTable getTable_2() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getPanel_7_1());
			panel.add(getPanel_8());
		}
		return panel;
	}
	private JPanel getPanel_7_1() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.WHITE);
			panel_7.setLayout(new GridLayout(0, 1, 0, 0));
			panel_7.add(getLblNewLabel_3());
			panel_7.add(getLblIncome2());
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBackground(Color.WHITE);
			panel_8.setLayout(new GridLayout(0, 1, 0, 0));
			panel_8.add(getLblNewLabel_2());
			panel_8.add(getLblExpenses2());
		}
		return panel_8;
	}
	private JLabel getLblIncome2() {
		if (lblIncome2 == null) {
			lblIncome2 = new JLabel("New label");
			lblIncome2.setVerticalAlignment(SwingConstants.TOP);
			lblIncome2.setForeground(new Color(0, 153, 255));
			lblIncome2.setBackground(Color.WHITE);
			lblIncome2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIncome2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("지출");
			lblNewLabel_2.setForeground(new Color(255, 0, 51));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("수입");
			lblNewLabel_3.setForeground(new Color(0, 153, 255));
			lblNewLabel_3.setBackground(Color.WHITE);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblExpenses2() {
		if (lblExpenses2 == null) {
			lblExpenses2 = new JLabel("New label");
			lblExpenses2.setVerticalAlignment(SwingConstants.TOP);
			lblExpenses2.setForeground(new Color(255, 0, 51));
			lblExpenses2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblExpenses2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
		}
		return table_1;
	}
	private RoundBtn getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new RoundBtn("검색");
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setBackground(new Color(255, 102, 102));
			btnSearch.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int a,b;
					a=comboBox1.getSelectedIndex()+1;
					b=comboBox2.getSelectedIndex()+1;
					String str1 =accountBookDAO.monthincome(a, b)+"원";
					String str2 =accountBookDAO.monthexpenses(a, b)+"원";
					lblIncome2.setText(str1);
					lblExpenses2.setText(str2);
					
					
					monthdatas(a, b);
				}
			});
		}
		return btnSearch;
	}
	private JPanel getPanelModify() {
		if (panelModify == null) {
			panelModify = new JPanel();
			panelModify.setLayout(new BorderLayout(0, 0));
			panelModify.add(getPanel_9_1(), BorderLayout.EAST);
			panelModify.add(getScrollPane_2(), BorderLayout.CENTER);
		}
		return panelModify;
	}
	private JPanel getPanel_9_1() {
		if (panelEast2 == null) {
			panelEast2 = new JPanel();
			panelEast2.setLayout(new GridLayout(0, 1, 0, 0));
			panelEast2.add(getPanel_10());
			panelEast2.add(getPanel_12());
			panelEast2.add(getPanel_13());
			panelEast2.add(getPanel_14());
			panelEast2.add(getPanel_15());
			panelEast2.add(getPanel_16());
		}
		return panelEast2;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setBackground(Color.WHITE);
			panel_10.add(getLblNum());
			panel_10.add(getTfNum());
		}
		return panel_10;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setBackground(Color.WHITE);
			panel_12.add(getLblNewLabel_5());
			panel_12.add(getRdbtnIncome1());
			panel_12.add(getRdbtnExpenses1());
		}
		return panel_12;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setBackground(Color.WHITE);
			panel_13.add(getLblNewLabel_6());
			panel_13.add(getCbCategory());
		}
		return panel_13;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setBackground(Color.WHITE);
			panel_14.add(getLblNewLabel_7());
			panel_14.add(getTfAmount1());
		}
		return panel_14;
	}
	private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.setBackground(Color.WHITE);
			panel_15.add(getLblNewLabel_8());
			panel_15.add(getTfMemo1());
		}
		return panel_15;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			panel_16.add(getBtnSelect());
			panel_16.add(getBtnModify());
			panel_16.add(getBtnRemove());
		}
		return panel_16;
	}
	private JLabel getLblNum() {
		if (lblNum == null) {
			lblNum = new JLabel("입력순서");
		}
		return lblNum;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setEnabled(false);
			tfNum.setColumns(10);
		}
		return tfNum;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("수입/지출");
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("카테고리");
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("금액");
		}
		return lblNewLabel_7;
	}
	private JTextField getTfAmount1() {
		if (tfAmount1 == null) {
			tfAmount1 = new JTextField();
			tfAmount1.setColumns(10);
		}
		return tfAmount1;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("내용");
		}
		return lblNewLabel_8;
	}
	private JTextField getTfMemo1() {
		if (tfMemo1 == null) {
			tfMemo1 = new JTextField();
			tfMemo1.setColumns(10);
		}
		return tfMemo1;
	}
	private RoundBtn getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new RoundBtn("선택");
			btnSelect.setForeground(Color.WHITE);
			btnSelect.setBackground(new Color(255, 102, 102));
			btnSelect.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table_2.getSelectedRow();
					if(row == -1) {
						JOptionPane.showMessageDialog(AccountBook.this, "데이터를 선택해 주세요.", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}

					int num = (int) table_2.getModel().getValueAt(row, 0);
					
					List<AccountBookData> list  = accountBookDAO.getdatasByNum(num);
					for(AccountBookData abData : list ) {
						tfNum.setText(abData.getNum()+"");
						if(abData.getInout().equals("income")){
							rdbtnIncome1.setSelected(true);
								cbCategory.setModel(
										new DefaultComboBoxModel(new String[] { "카테고리..", "월급", "용돈", "부수입", "상여", "기타" }));
							switch(abData.getCategories()) {
							case "salary": cbCategory.setSelectedIndex(1); break;
							case "pocketmoney": cbCategory.setSelectedIndex(2); break;
							case "addincome": cbCategory.setSelectedIndex(3); break;
							case "bonus": cbCategory.setSelectedIndex(4); break;
							case "etc": cbCategory.setSelectedIndex(5); break;
							}
							
						}else {
							rdbtnExpenses1.setSelected(true);
							cbCategory.setModel(new DefaultComboBoxModel(new String[] {"카테고리..", "식비", "교통/차량",
									"여가", "쇼핑", "기타"}));
							switch(abData.getCategories()) {
							case "food": cbCategory.setSelectedIndex(1); break;
							case "traffic": cbCategory.setSelectedIndex(2); break;
							case "culture": cbCategory.setSelectedIndex(3); break;
							case "shopping": cbCategory.setSelectedIndex(4); break;
							case "etc": cbCategory.setSelectedIndex(5); break;
							}
						}
						tfAmount1.setText(abData.getAmount()+"");
						tfMemo1.setText(abData.getMemo());
					}
				
					
					
					
				}
			});
		}
		return btnSelect;
	}
	private RoundBtn getBtnModify() {
		if (btnModify == null) {
			btnModify = new RoundBtn("수정");
			btnModify.setForeground(Color.WHITE);
			btnModify.setBackground(new Color(255, 102, 102));
			btnModify.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AccountBookData abData = new AccountBookData();
					if(!(rdbtnIncome1.isSelected() || rdbtnExpenses1.isSelected())) {
						JOptionPane.showMessageDialog(AccountBook.this, "수입, 지출 버튼을 눌러주세요", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					int selectedIndex  = cbCategory.getSelectedIndex();
					if(selectedIndex == 0) {
						JOptionPane.showMessageDialog(AccountBook.this, "검색항목을 선택하세요.", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(tfAmount1.getText().length() == 0) {
						JOptionPane.showMessageDialog(AccountBook.this, "금액을 입력하세요.", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					for(int i=0;i<tfAmount1.getText().length();i++) {
						if(!(tfAmount1.getText().charAt(i)>='0'&&tfAmount1.getText().charAt(i)<='9')) {
							JOptionPane.showMessageDialog(AccountBook.this, "금액은 숫자만 입력하세요.", "에러", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					abData.setNum(Integer.parseInt(tfNum.getText()));
					abData.setTime(new Timestamp(System.currentTimeMillis()));
					abData.setInout(rdbtnIncome1.isSelected() ? "income" : "expenses");
					String field = "";
					if(rdbtnExpenses1.isSelected()) {
						switch(selectedIndex) {
						case 1: field = "food"; break;
						case 2: field = "traffic"; break;
						case 3: field = "culture"; break;
						case 4: field = "shopping"; break;
						case 5: field = "etc"; break;
						}
					}else {
						switch(selectedIndex) {
						case 1: field = "salary"; break;
						case 2: field = "pocketmoney"; break;
						case 3: field = "addincome"; break;
						case 4: field = "bonus"; break;
						case 5: field = "etc"; break;
						}
					}
					abData.setCategories(field);
					abData.setAmount(Integer.parseInt(tfAmount1.getText()));
					abData.setMemo(tfMemo1.getText());
					accountBookDAO.updateData(abData);
					
					getdatas();
					tfNum.setText("");
					buttonGroup.clearSelection();
					cbCategory.setSelectedIndex(0);
					tfAmount1.setText("");
					tfMemo1.setText("");
					JOptionPane.showMessageDialog(AccountBook.this, "수정 되었습니다..", "수정성공", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return btnModify;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTable_2_1());
		}
		return scrollPane_2;
	}
	private JTable getTable_2_1() {
		if (table_2 == null) {
			table_2 = new JTable();
		}
		return table_2;
	}
	private JRadioButton getRdbtnIncome1() {
		if (rdbtnIncome1 == null) {
			rdbtnIncome1 = new JRadioButton("수입");
			buttonGroup_1.add(rdbtnIncome1);
			
		}
		return rdbtnIncome1;
	}
	private JRadioButton getRdbtnExpenses1() {
		if (rdbtnExpenses1 == null) {
			rdbtnExpenses1 = new JRadioButton("지출");
			buttonGroup_1.add(rdbtnExpenses1);
		}
		return rdbtnExpenses1;
	}
	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"카테고리..."}));
		}
		return cbCategory;
	}
	private RoundBtn getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new RoundBtn("삭제");
			btnRemove.setForeground(Color.WHITE);
			btnRemove.setBackground(new Color(255, 102, 102));
			btnRemove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(tfNum.getText().length() == 0) {
						JOptionPane.showMessageDialog(AccountBook.this, "삭제할 데이터를 선택하세요", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					int num = Integer.parseInt(tfNum.getText());
					accountBookDAO.removeByNum(num);
					
					getdatas();
				}
			});
		}
		return btnRemove;
	}
}
