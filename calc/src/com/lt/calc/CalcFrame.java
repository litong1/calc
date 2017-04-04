package com.lt.calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * 计算器窗口(view)
 * 
 * @author litong
 *
 */
public class CalcFrame extends JFrame implements CalcCallback {

	private JLabel labelResult;
	/**
	 * 按钮上的标签
	 */
	String[] titles = { "Del", "%", "C", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/", "00", "0",
			".", "=", };
	/**
	 * 按钮本身
	 */
	private JButton[] buttons = new JButton[titles.length];

	/**
	 * 按钮的监听器
	 */
	private ButtonListener buttonListener;

	private Calc calc;

	/**
	 * 构造方法
	 */
	public CalcFrame(Calc calc) {
		this.calc = calc;
		buttonListener = new ButtonListener(calc, this);
		initUi();

		setVisible(true);

	}

	private void initUi() {
		setTitle("计算器--LT作品");
		setSize(320, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 添加结果标签
		labelResult = new JLabel("0.0");
		labelResult.setBorder(new EmptyBorder(20, 10, 30, 10));
		labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResult.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		labelResult.setBackground(Color.BLUE);
		add(labelResult, BorderLayout.NORTH);

		// 按钮面板
		JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
		// 按钮面板添加到窗口的中间
		add(buttonPanel, BorderLayout.CENTER);

		for (int i = 0; i < titles.length; i++) {

			buttons[i] = new JButton(titles[i]);
			buttons[i].setBackground(Color.ORANGE);
			buttons[i].setActionCommand(titles[i]);
			buttons[i].addActionListener(buttonListener);
			buttonPanel.add(buttons[i]);

		}
	}

	@Override
	public void showInput() {
		// TODO Auto-generated method stub
		labelResult.setText(calc.getResult());

	}

	@Override
	public void showResult(String str) {

		labelResult.setText(str);
	}
}
