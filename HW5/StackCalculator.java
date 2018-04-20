import java.util.Iterator;
import java.util.LinkedList;

/**
 * Homework 5-4: Implement a stack calculator
 * @author Kuei-Lin Yang
 * Feb 27, 2018
 */

public class StackCalculator {
	private LinkedList<Double> linkedList;

	public StackCalculator() {
		linkedList = new LinkedList<>();
	}
	
	protected void push(double x) {
		linkedList.push(x);
	}
	
	protected double pop() {
		if(size()!=0) {
			return linkedList.pop();
		}else
			return -1;
	}
	
	protected void add() {
		if(size()>=2) {
			double operand2 = pop();
			double operand1 = pop();
			push(operand1+operand2);
		}
	}
	
	protected void subtract() {
		if(size()>=2) {
			double operand2 = pop();
			double operand1 = pop();
			push(operand1-operand2);
		}
	}
	
	protected void multiply() {
		if(size()>=2) {
			double operand2 = pop();
			double operand1 = pop();
			push(operand1*operand2);	
		}
	}
	
	protected void divide() {
		if(size()>=2) {
			double operand2 = pop();
			double operand1 = pop();
			push(operand1/operand2);			
		}
	}

	protected void sqrt() {
		if(size()>=1) {
			push(Math.sqrt(pop()));
		}
	}
	
	protected void pow() {
		if(size()>=2) {
			double operand2 = pop();
			double operand1 = pop();
			push(Math.pow(operand1, operand2));			
		}
	}
	
	protected void clear() {
		linkedList.clear();
	}
	
	protected double[] getValues() {
		double[] doubleArray = new double[size()];
		if(!linkedList.isEmpty()) {
			Iterator iterator = linkedList.iterator();
			int i = 0;
			while(iterator.hasNext()) {
				doubleArray[i] = (double) iterator.next();
				i++;
			}
		}
		return doubleArray;
	}
	
	protected int size() {
		return linkedList.size();
	}
	
}
