package 栈;

import java.util.Stack;


/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * @author 叶伟伟
 *
 */
public class _224_基本计算器 {
	
	/**
	 *  中缀表达式转后缀表达式(逆波兰)
	 * （1）若取出的字符是操作数，则分析出完整的运算数，该操作数直接送入S2栈
	 * （2）若取出的字符是运算符，则将该运算符与S1栈栈顶元素比较
			如果该运算符优先级(不包括括号运算符)大于S1栈栈顶运算符优先级，则将该运算符进S1栈
			否则，将S1栈的栈顶运算符弹出，送入S2栈中，直至S1栈栈顶运算符低于（不包括等于）该运算符优先级，最后将该运算符送入S1栈。
	 * （3）若取出的字符是“（”，则直接送入S1栈顶。
	 * （4）若取出的字符是“）”，则将距离S1栈栈顶最近的“（”之间的运算符，逐个出栈，依次送入S2栈，此时抛弃“（”。
	 * （5）重复上面的1~4步，直至处理完所有的输入字符
	 * （6）若取出的字符是“#”，则将S1栈内所有运算符（不包括“#”），逐个出栈，依次送入S2栈。
	 * 完成以上步骤，S2栈便为逆波兰式输出结果。不过S2应做一下逆序处理。便可以按照逆波兰式的计算方法计算了
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
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
	 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
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
     * 官方题解一: 栈和反转字符串
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
