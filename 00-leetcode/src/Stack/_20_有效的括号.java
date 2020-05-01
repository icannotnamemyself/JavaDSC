package Stack;

import java.util.HashMap;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * 使用栈和map 来实现左右括号的匹配
 * @author 叶伟伟
 *
 */
public class _20_有效的括号 {
	
	public static HashMap<Character, Character> hashMap= new HashMap<>();
	
	static {
		hashMap.put('(', ')');
		hashMap.put('[', ']');
		hashMap.put('{', '}');
	}
	
	
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	char c = s.charAt(i);
        	
        	if(hashMap.containsKey(c)) {
        		stack.push(c);
        	}else {
        		if (stack.size() == 0 ) 
					return false;
        		char left = stack.pop();
        		//括号不匹配
        		if(hashMap.get(left) != c) 
        			return false;
        	}
        			
		}
        
        if(stack.size() == 0)
        	return true;
        else
        	return false;
    }
}
