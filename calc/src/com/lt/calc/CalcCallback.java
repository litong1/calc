package com.lt.calc;

/**
 * 回调接口
 * @author litong
 *
 */
public interface CalcCallback {

	/**
	 * 显示按钮的输入
	 */
	void showInput();
	/**
	 * 显示计算结果
	 */
	void showResult(String str);
}
