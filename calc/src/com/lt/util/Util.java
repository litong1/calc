package com.lt.util;

import java.math.BigInteger;
import java.util.Arrays;

public class Util {

	public static void main(String[] args) {
		String str1 = "11";
		String str2 = "12";

		// 加法
		// System.out.println("加法： " + sum(str1, str2));

		// 减法
		// System.out.println("减法： " + minus(str1, str2));

		// 乘法
		// System.out.println("乘法法： " + multiply(str1, str2));

		// 除法
		System.out.println("除法： " + divided(str1, str2));

	}

	public static String divided(String str1, String str2) {
		// 数值后面补0
		int index1 = str1.indexOf(".");
		int len1 = str1.length() - 1 - index1;
		int index2 = str2.indexOf(".");
		int len2 = str2.length() - 1 - index2;

		if (str1.contains(".") && str2.contains(".")) {
			if (len1 > len2) {
				str2 = compare2(str1, str2, len1, len2);
			} else if (len1 < len2) {
				str1 = compare2(str2, str1, len2, len1);
			}
		} else if (str1.contains(".") && !str2.contains(".")) {
			str1 = deleteZero(str1);
			str2 = str2 + ".";
			for (int i = 0; i < len1; i++) {
				str2 = str2 + "0";
			}
		} else if (!str1.contains(".") && str2.contains(".")) {
			str2 = deleteZero(str2);
			str1 = str1 + ".";
			for (int i = 0; i < len2; i++) {
				str1 = str1 + "0";
			}
		}
		str1 = deleteZero(str1);
		str2 = deleteZero(str2);
		String str11 = str1.replace(".", "");
		String str22 = str2.replace(".", "");
		
		System.out.println(str11 +" "+str22);
		int count = 0;
		int zero = 0;
		String temp = "-1";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str11.length(); i++) {
			sb.append("0");
		}
		boolean flag = false;
		StringBuilder result = new StringBuilder();

		while (Integer.parseInt(temp)!=0) {
			flag = compareValue(str11, str22);
			System.out.println(flag);
			if (flag) {
				if (count==0) {
					result.append(String.valueOf(count));
				}
				count = 0;
				str11 = str11 + "0";
				zero++;
				//保留小数点后面20位
				if(zero > 20){
					zero = zero-1;
					break;
				}
			} else {
				temp = minus(str11, str22);
				System.out.println("temp" + temp);
				str11 = temp;
				count++;
				if (compareValue(temp, str22)) {
					result.append(String.valueOf(count));
				}
			}
		}
        System.out.println(zero);
        System.out.println(result.length());
        if(zero > 0){        
        	int index = result.length() - zero;
        	result.insert(index, ".");
            String ss= new String(result);
            if(ss.indexOf(".") == 0){
            	result.insert(0, "0");
           }
        }
		return result.toString();
	}
    /**
     * 去掉小数点前面的0
     * @param str1
     * @return
     */
	private static String deleteZero(String str1) {
		if(str1.substring(0, 1).equals("0")){
			str1 = str1.substring(1);
		}
		return str1;
	}
    /**
     * 比较两个数字的大小
     * @param str1
     * @param str2
     * @return
     */
	private static boolean compareValue(String str1, String str2) {

		int index1 = str1.indexOf(".");
		int len1 = str1.length() - 1 - index1;
		int index2 = str2.indexOf(".");
		int len2 = str2.length() - 1 - index2;
		boolean flag = false;

		if (str1.contains(".") && str2.contains(".")) {
			if (len1 > len2) {
				str2 = compare2(str1, str2, len1, len2);
				System.out.println(111);
			} else if (len1 < len2) {
				str1 = compare2(str2, str1, len2, len1);
				System.out.println(111);
			}
		} else if (str1.contains(".") && !str2.contains(".")) {
			str2 = str2 + ".";
			for (int i = 0; i < len1; i++) {
				str2 = str2 + "0";
			}
		} else if (!str1.contains(".") && str2.contains(".")) {
			str1 = str1 + ".";
			for (int i = 0; i < len2; i++) {
				str1 = str1 + "0";
			}
		}
		// System.out.println(str1 + " " + str2);
		if (str1.length() > str2.length()) {
			flag = false;
		} else if (str1.length() == str2.length()) {
			int temp = 0;
			String str11 = str1.replace(".", "");
			String str22 = str2.replace(".", "");
			for (int i = 0; i < str11.length(); i++) {
				if (str11.charAt(i) == str22.charAt(i)) {
					temp++;
				} else {
					break;
				}
			}
			if (temp == str11.length()) {
				flag = false;
			} else {
				int a = Integer.parseInt(str11.substring(temp, temp + 1));
				int b = Integer.parseInt(str22.substring(temp, temp + 1));
				if (a >= b) {
					flag = false;
				} else {
					flag = true;
				}
			}
		} else {
			flag = true;
		}
		return flag;
	}

	public static int morePlus(int a, int b) {
		int temp = a;
		int result = 0;
		for (int i = 0; i < b; i++) {
			result += temp;
		}
		return result;

	}

	public static String multiply(String str11, String str22) {

		String result = "0";
		String str1 = str11.replace(".", "");
		String str2 = str22.replace(".", "");

		if (str1.length() > str2.length()) {
			str2 = compare1(str1, str2);
		} else if (str1.length() < str2.length()) {
			str1 = compare1(str2, str1);
		}
		char[] ch1 = new char[str1.length()];
		reverse(str1, ch1);

		char[] ch2 = new char[str2.length()];
		reverse(str2, ch2);

		String[] res = new String[ch1.length * ch1.length];
		int r = 0;
		for (int i = 0; i < ch1.length; i++) {
			for (int j = 0; j < ch2.length; j++) {
				res[r] = String.valueOf(morePlus(ch1[i] - '0', ch2[j] - '0'));

				for (int k = 0; k <= i + j; k++) {
					if (k > 0) {
						res[r] = res[r] + "0";
					}
				}
				if (r < res.length) {
					r++;
				}
			}
		}

		for (String s : res) {
			result = sum(result, s);
		}
		int index0 = -1;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(0) == '0')
				if (result.charAt(i) == '0' && result.charAt(i + 1) != '0') {
					index0 = i;
				}
		}
		if (index0 != -1) {
			result = result.substring(index0 + 1);
		}
		int index = 0;
		if (str11.contains(".") || str22.contains(".")) {
			int index1 = str11.indexOf(".");
			int len1 = str11.length() - 1 - index1;
			int index2 = str22.indexOf(".");
			int len2 = str22.length() - 1 - index2;
			index = result.length() - (len1 + len2);

			StringBuilder ss = new StringBuilder(result);
			ss.insert(index, ".");
			result = ss.toString();
		}

		return result;
	}

	public static String minus(String str1, String str2) {
		// 数值后面补0
		int index1 = str1.indexOf(".");
		int len1 = str1.length() - 1 - index1;
		int index2 = str2.indexOf(".");
		int len2 = str2.length() - 1 - index2;

		if (str1.contains(".") && str2.contains(".")) {
			if (len1 > len2) {
				str2 = compare2(str1, str2, len1, len2);
			} else if (len1 < len2) {
				str1 = compare2(str2, str1, len2, len1);
			}
		} else if (str1.contains(".") && !str2.contains(".")) {
			str2 = str2 + ".";
			for (int i = 0; i < len1; i++) {
				str2 = str2 + "0";
			}
		} else if (!str1.contains(".") && str2.contains(".")) {
			str1 = str1 + ".";
			for (int i = 0; i < len2; i++) {
				str1 = str1 + "0";
			}
		}

		// 数值前面补0
		if (str1.length() > str2.length()) {
			str2 = compare1(str1, str2);
		} else if (str1.length() < str2.length()) {
			str1 = compare1(str2, str1);
		}

		String result = "";
		if (str1.length() > str2.length()) {
			result = minusxx(str1, str2);
		} else if (str1.length() == str2.length()) {
			int count = 0;
			String str11 = str1.replace(".", "");
			String str22 = str2.replace(".", "");
			for (int i = 0; i < str11.length(); i++) {
				if (str11.charAt(i) == str22.charAt(i)) {
					count++;
				} else {
					break;
				}
			}
			if (count == str11.length()) {
				result = "0";
			} else {
				// System.out.println( count);
				// System.out.println(str11);
				int a = Integer.parseInt(str11.substring(count, count + 1));
				int b = Integer.parseInt(str22.substring(count, count + 1));

				if (a >= b) {
					result = minusxx(str1, str2);
				} else {
					result = "-" + minusxx(str2, str1);
				}
			}
		} else {
			result = "-" + minusxx(str2, str1);
		}
		return result;
	}

	private static String minusxx(String str11, String str22) {

		int index1 = str11.indexOf(".");
		int len1 = str11.length() - 1 - index1;
		int index2 = str22.indexOf(".");
		int len2 = str22.length() - 1 - index2;

		String str1 = str11.replace(".", "");
		String str2 = str22.replace(".", "");

		char[] ch1 = new char[str1.length()];
		reverse(str1, ch1);

		char[] ch2 = new char[str2.length()];
		reverse(str2, ch2);

		int[] res = new int[str1.length() > str2.length() ? str1.length() + 1 : str2.length() + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch1.length; i++) {
			res[i] = (ch1[i] - '0') - (ch2[i] - '0');
			if (res[i] < 0) {
				res[i] = res[i] + 10;
				ch1[i + 1] = (char) ((ch1[i + 1] - '0') - ('1' - '0') + 48);
			}

			sb.append(res[i]);
		}
		String result = sb.reverse().toString();
		int indexx = 0;
		if (str11.contains(".") || str22.contains(".")) {
			if (len1 >= len2) {
				indexx = result.length() - len1;
			} else {
				indexx = result.length() - len2;
			}
			StringBuilder ss = new StringBuilder(result);

			ss.insert(indexx, ".");
			result = ss.toString();
		}
		int index = -1;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(0) == '0') {
				if (result.charAt(i) == '0' && result.charAt(i + 1) != '0') {
					index = i;
					break;
				}
			}
		}

		if (index != -1) {
			result = result.substring(index + 1);
		}
		return result;

	}

	public static String sum(String str11, String str22) {
		int index1 = str11.indexOf(".");
		int len1 = str11.length() - 1 - index1;
		int index2 = str22.indexOf(".");
		int len2 = str22.length() - 1 - index2;
		if (str11.contains(".") && str22.contains(".")) {
			if (len1 > len2) {
				str22 = compare2(str11, str22, len1, len2);
			} else if (len1 < len2) {
				str11 = compare2(str22, str11, len2, len1);
			}
		} else if (str11.contains(".") && !str22.contains(".")) {
			str22 = str22 + ".";
			for (int i = 0; i < len1; i++) {
				str22 = str22 + "0";
			}
		} else if (!str11.contains(".") && str22.contains(".")) {
			str11 = str11 + ".";
			for (int i = 0; i < len2; i++) {
				str11 = str11 + "0";
			}
		}
		String str1 = str11.replace(".", "");
		String str2 = str22.replace(".", "");
		if (str1.length() > str2.length()) {
			str2 = compare1(str1, str2);
		} else if (str1.length() < str2.length()) {
			str1 = compare1(str2, str1);
		}

		char[] ch1 = new char[str1.length()];
		reverse(str1, ch1);

		char[] ch2 = new char[str2.length()];
		reverse(str2, ch2);

		String[] res = new String[str1.length() > str2.length() ? str1.length() + 1 : str2.length() + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ch1.length; i++) {
			res[i] = String.valueOf((ch1[i] - '0') + (ch2[i] - '0'));
			if (Integer.parseInt(res[i]) >= 10 && i < ch1.length - 1) {
				res[i] = String.valueOf(Integer.parseInt(res[i]) - 10);
				ch1[i + 1] = (char) (ch1[i + 1] - '0' + '1' - '0' + 48);
			} else {
				StringBuilder bui = new StringBuilder(String.valueOf(res[i]));
				res[i] = bui.reverse().toString();
			}
			sb.append(res[i]);
		}
		String result = sb.reverse().toString();
		int index = 0;
		if (str11.contains(".") || str22.contains(".")) {
			if (len1 >= len2) {
				index = result.length() - len1;
			} else {
				index = result.length() - len2;
			}
			StringBuilder ss = new StringBuilder(result);
			ss.insert(index, ".");
			result = ss.toString();
		}
		return result;
	}

	private static void reverse(String str1, char[] ch1) {
		for (int i = str1.length() - 1; i >= 0; i--) {
			ch1[i] = str1.charAt(str1.length() - 1 - i);
		}
	}

	private static String compare1(String str1, String str2) {
		int num = str1.length() - str2.length();
		for (int i = 0; i < num; i++) {
			str2 = "0" + str2;
		}
		return str2;
	}

	private static String compare2(String str1, String str2, int len1, int len2) {
		int cha = len1 - len2;
		for (int i = 0; i < cha; i++) {
			str2 = str2 + "0";
		}
		return str2;
	}
}
