import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double resultAmount = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(resultAmount, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        double resultAmount = amount + amount * yearRate * period;
        return round(resultAmount, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void run() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = userInput.nextInt();
        double resultAmount = 0;
        if (depositType == 1) {
            resultAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().run();
    }
}
