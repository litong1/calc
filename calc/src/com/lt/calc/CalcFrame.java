package com.lt.calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.peer.LabelPeer;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class CalcFrame extends JFrame implements CalcCallback,Observer {

	private JLabel labelShowInput;
	private JLabel labelResult;
	/**
	 * 按钮上的标签
	 */
	String[] titles = { "Del", "%", "C", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/", "()", "0",
			".", "=", };
	/**
	 * 按钮本身
	 */
	private JButton[] buttons = new JButton[titles.length];

	/**
	 * 按钮的监听器
	 */
	private Controller controller;

	private CalcModel calcModel;

//	/**
//	 * 设置方法【注入】视图所需的控制器
//	 * @param controller
//	 */
//	public void setController(Controller controller) {
//		this.controller = controller;		
//	}
	
	/**
	 * 构造方法
	 */
	public CalcFrame(Controller controller) {
	
		this.controller = controller;
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
		labelShowInput = new JLabel("");
		labelShowInput.setBorder(new EmptyBorder(10, 10, 0, 10));
		labelShowInput.setHorizontalAlignment(SwingConstants.RIGHT);
		labelShowInput.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		labelShowInput.setOpaque(true);
		labelShowInput.setBackground(Color.BLACK);
		labelShowInput.setForeground(Color.WHITE);
		
		labelResult = new JLabel("");
		labelResult.setBorder(new EmptyBorder(20, 10, 20, 10));
		labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResult.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		labelResult.setOpaque(true);
		labelResult.setBackground(Color.black);
		labelResult.setForeground(Color.WHITE);
		
        JPanel labelPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        labelPanel.add(labelResult);
        labelPanel.add(labelShowInput);
		
		add(labelPanel, BorderLayout.NORTH);
		labelPanel.setOpaque(true);
		labelPanel.setBackground(Color.black);
		// 按钮面板
		JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
		// 按钮面板添加到窗口的中间
		add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(Color.black);
		for (int i = 0; i < titles.length; i++) {
			buttons[i] = new JButton(titles[i]);
			buttons[i].setOpaque(true);
			buttons[i].setBackground(Color.black);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setFont(new Font("微软雅黑", Font.PLAIN, 16));
			buttons[i].setActionCommand(titles[i]);
			buttons[i].addActionListener(controller);
			buttonPanel.add(buttons[i]);
            if(i == titles.length-1){
            	buttons[i].setBackground(Color.RED);
            }
		}
	}

	@Override
	public void showInput() {
		// TODO Auto-generated method stub
		//labelShowInput.setText(calcModel.getResult());

	}

	@Override
	public void showResult(String str) {

		//labelResult.setText(str);
	}
	
	@Override
	public void error() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "被除数不能为0！");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o  instanceof CalcModel){
		String result = (String) arg;
		labelShowInput.setText(result);
		}
		
	}
	
}
