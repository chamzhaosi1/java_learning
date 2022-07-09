package exercise_8;

import java.util.Arrays;

public interface Analysis {
    public double getAverage(double scores[]);

    public double getHighest(double scores[]);

    public double getLowest(double scores[]);

    public static void main(String[] args) {
        TestAnalysis ts = new TestAnalysis();

        double[] scores = { 2, 3, 51, 5, 42, 6, 99 };
        System.out.println(ts.getAverage(scores));
        System.out.println(ts.getHighest(scores));
        System.out.println(ts.getLowest(scores));
    }
}

class TestAnalysis implements Analysis {
    public double getAverage(double scores[]) {
        double total = 0;
        for (double d : scores) {
            total += d;
        }
        return total / scores.length;
    }

    public double getHighest(double scores[]) {
        Arrays.sort(scores);
        return scores[scores.length - 1];
    }

    public double getLowest(double scores[]) {
        Arrays.sort(scores);
        return scores[0];
    }
}