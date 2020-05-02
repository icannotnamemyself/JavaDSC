package ջ;

import java.util.Stack;


/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * @author Ҷΰΰ
 *
 */
public class _224_���������� {
	
	/**
	 *  ��׺���ʽת��׺���ʽ(�沨��)
	 * ��1����ȡ�����ַ��ǲ�����������������������������ò�����ֱ������S2ջ
	 * ��2����ȡ�����ַ�����������򽫸��������S1ջջ��Ԫ�رȽ�
			�������������ȼ�(���������������)����S1ջջ����������ȼ����򽫸��������S1ջ
			���򣬽�S1ջ��ջ�����������������S2ջ�У�ֱ��S1ջջ����������ڣ����������ڣ�����������ȼ�����󽫸����������S1ջ��
	 * ��3����ȡ�����ַ��ǡ���������ֱ������S1ջ����
	 * ��4����ȡ�����ַ��ǡ��������򽫾���S1ջջ������ġ�����֮���������������ջ����������S2ջ����ʱ������������
	 * ��5���ظ������1~4����ֱ�����������е������ַ�
	 * ��6����ȡ�����ַ��ǡ�#������S1ջ���������������������#�����������ջ����������S2ջ��
	 * ������ϲ��裬S2ջ��Ϊ�沨��ʽ������������S2Ӧ��һ������������԰����沨��ʽ�ļ��㷽��������
	 * 
	 * @param s
	 * @return
	 */
    public int calculate(String s) {
    	int len = s.length();
    	Stack<Character> s1 = new Stack<>();
    	Stack<Integer> s2 = new Stack<>();
    	
    	
    	
    	for(int i = 0 ; i < len; i ++)
    	{
    		char c = s.charAt(i);
    		switch (c) {
    		case '+':
    			
    			break;
    		case '-':
    			
    			break;
    		case '*':
    			
    			break;
    		case '/':
    			
    			break;
			case '(':
				break;
			case ')':
				break;
			default:
				s2.push(Integer.valueOf(s.charAt(i)));
				break;
			}
    		
    		
    	}
    	
    	
    	
		return 0;
    }
    
    /**
     * 
     * ʵ��һ�������ļ�����������һ���򵥵��ַ������ʽ��ֵ��
	 * �ַ������ʽ���԰��������� ( �������� )���Ӻ� + ������ -���Ǹ������Ϳո�  ��
     */
    
    
    public int evaluateExpr(Stack<Object> stack) {

        int res = 0;

        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        // Evaluate the expression till we get corresponding ')'
        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    /**
     * �ٷ����һ: ջ�ͷ�ת�ַ���
     * @param s
     * @return
     */
    public int calculate1(String s) {

        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                // Forming the operand - in reverse order.
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {

                    // Save the operand on the stack
                    // As we encounter some non-digit.
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {

                    int res = evaluateExpr(stack);
                    stack.pop();

                    // Append the evaluated result to the stack.
                    // This result could be of a sub-expression within the parenthesis.
                    stack.push(res);

                } else {
                    // For other non-digits just push onto the stack.
                    stack.push(ch);
                }
            }
        }

        //Push the last operand to stack, if any.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }
}
