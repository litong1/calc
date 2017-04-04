package com.lt.calc;

import java.util.Stack;

/**
 * 计算器的模型
 * @author litong
 *
 */
public class Calc {

	//逆波兰表达式
	private Stack<String> stack;
	//操作数和运算符
	public Calc() {
		stack = new Stack<>();
	}
	
	public void push(String e){
		stack.push(e);		
	}
	public String getResult(){
		//System.out.println(stack.toString());
		String[] str = stack.toString().split("\\[|\\]|\\,| ");
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(s);
		}
		
		return sb.toString();
	}
	/**
	 * 清空栈
	 */
	public void clear(){
		stack.clear();
	}
	public String peek(){		
		return stack.peek();	
	}
	public String pop(){
		return stack.pop();
	}

	public int getStackSize() {
		return stack.size();
	}
	public String get(int index){
		return stack.get(index);
	}
		
}
