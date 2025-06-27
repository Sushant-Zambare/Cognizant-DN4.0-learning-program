//EXERCISE - 01
public class LoanCalculator {

    public double calculateEMI(double principal, double annualRate, int years) {
        double r = annualRate / (12 * 100); // monthly rate
        int n = years * 12; // months

        return (principal * r * Math.pow(1 + r, n)) /
                (Math.pow(1 + r, n) - 1);
    }

    public double calculateTotalPayment(double emi, int years) {
        return emi * years * 12;
    }
}
