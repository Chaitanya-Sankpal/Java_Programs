package math;

import java.util.Arrays;

public class StatisticalOperations {

    public static double mean(int[] data) {
        double sum = 0;
        for (int num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public static double median(int[] data) {
        Arrays.sort(data);
        int length = data.length;
        if (length % 2 == 0) {
            return (data[length / 2 - 1] + data[length / 2]) / 2.0;
        } else {
            return data[length / 2];
        }
    }

    public static double standardDeviation(int[] data) {
        double mean = mean(data);
        double sumSquaredDifferences = 0;
        for (int num : data) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumSquaredDifferences / data.length);
    }
}
