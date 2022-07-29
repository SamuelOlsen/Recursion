
public class formulaCalculation {
		

		public static int findOutsideParentheses(char sign, String expres) {
			
			
			int par = 0;
			
			for(int i = 0; i< expres.length(); i++) {
				char t = expres.charAt(i);
			
				if(t == sign && par == 0) return i;
			
				else if(t == '(') par++;
			
				else if(t == ')') par--;
		
			}
			
			return -1;
			
			
		}
		
		public static double calculate(String expres) {
			
			expres = expres.trim();
			for(int opNr = 0; opNr<4; opNr++) {
				
				char op = "+-*/".charAt(opNr);
				int pos = findOutsideParentheses(op, expres);
				if(pos>0)
				{
					String ls = expres.substring(0, pos);
					String rs = expres.substring(pos+1);
					double lsr = calculate(ls); // method "calculate(String expres)" is called 3 times
					System.out.println("calculate("+ls+") = "+lsr);
					
					double rsr = calculate(rs); // method "calculate(String expres)" is called 4 times
					System.out.println("calculate("+rs+") = "+rsr);
					
					if(op == '+') return lsr+rsr;
					if(op == '-') return lsr-rsr;
					if(op == '*') return lsr*rsr;
					return lsr/rsr;
				}
			}
			if(expres.startsWith("(") && expres.endsWith(")")) {  // if the expression has parentheses surrounding the formula - remove it
				
				expres = expres.substring(1, expres.length()-1);
				return calculate(expres);  // method "calculate(String expres)" is called 2 times
				
			}
			
			
			return Double.parseDouble(expres);
			
		}
	
	
	

	public static void main(String[] args) {
		
		String formula = "(1+2)";
		double value = calculate(formula); // method "calculate(String expres)" is called 1 time
		System.out.println("Formula "+formula+ " is calculated to "+value);
		
	
	

	}

}
