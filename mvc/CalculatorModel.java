package mvc;

public class CalculatorModel {
	private int calculationValue;
	
	public void addTwoNumbers(int first, int second) {
		calculationValue = first + second;
	}
	
	public int getCalculationValue() {
		return calculationValue;
	}
}
