package 栈;

import java.util.HashMap;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * @author 叶伟伟
 *
 */
public class _20_validBracket{
	
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
