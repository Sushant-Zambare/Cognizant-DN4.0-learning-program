public class SavingsPredictor {

    public static double predictSavings(double currentBalance, double monthlyGrowth, int months) {
        if (months <= 0) {
            return currentBalance;
        }
        double newBalance = currentBalance + (currentBalance * monthlyGrowth);
        return predictSavings(newBalance, monthlyGrowth, months - 1);
    }

    public static void main(String[] args) {
        try {
            double initialBalance = 25000.0;
            double monthlyGrowthRate = 0.015;
            int projectionPeriod = 12;

            double projectedBalance = predictSavings(initialBalance, monthlyGrowthRate, projectionPeriod);

            System.out.printf("Initial Balance: Rs.%.2f\n", initialBalance);
            System.out.printf("Monthly Growth Rate: %.2f%%\n", monthlyGrowthRate * 100);
            System.out.println("Projection Period: " + projectionPeriod + " months");
            System.out.printf("Projected Balance: Rs.%.2f\n", projectedBalance);
            System.out.printf("Total Growth: Rs.%.2f (%.2f%%)\n", (projectedBalance - initialBalance),
                    ((projectedBalance - initialBalance) / initialBalance) * 100);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
