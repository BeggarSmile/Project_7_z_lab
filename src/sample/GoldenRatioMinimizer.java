package sample;

import sample.SingleArgumentFunctionMinimizer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.function.DoubleFunction;


public class GoldenRatioMinimizer implements SingleArgumentFunctionMinimizer {
    private final double GOLDEN_RATIO = (Math.sqrt(5) + 1) / 2;

    @Override
    public double minimize(DoubleFunction<Double> f, double lowerBound, double higherBound, double precision) {
        int counter = 0;
        try {
            double finalLength = higherBound - lowerBound;
            PrintWriter writer = new PrintWriter("GoldenRatioMinimizerOut.txt");

            while (!(Math.abs(higherBound - lowerBound) < precision)) {
                double left = higherBound - ((higherBound - lowerBound) / GOLDEN_RATIO);
                double right = lowerBound + ((higherBound - lowerBound) / GOLDEN_RATIO);

                double intervalLength = higherBound - lowerBound;

                double fLeft = f.apply(left);
                counter++;
                double fRight = f.apply(right);
                counter++;
                if (fLeft >= fRight) {
                    lowerBound = left;
                } else {
                    higherBound = right;
                }

                finalLength = higherBound - lowerBound;
                writer.format("a= %.5f || b= %.5f || eps= %.5f\n", lowerBound, higherBound, finalLength);
            }
            writer.format("a= %.5f || b= %.5f || eps= %.5f ==> F= %.5f\n", lowerBound, higherBound, finalLength, f.apply((lowerBound + higherBound) / 2));
            writer.format("I calculated function for %d times", counter);
            writer.close();
            return f.apply((lowerBound + higherBound) / 2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double argmin(DoubleFunction<Double> f, double lowerBound, double higherBound, double precision) {
        while (!(Math.abs(higherBound - lowerBound) < precision)) {
            double left = higherBound - ((higherBound - lowerBound) / GOLDEN_RATIO);
            double right = lowerBound + ((higherBound - lowerBound) / GOLDEN_RATIO);

            double fLeft = f.apply(left);
            double fRight = f.apply(right);

            if (fLeft >= fRight) {
                lowerBound = left;
            } else {
                higherBound = right;
            }
        }
        return (lowerBound + higherBound) / 2;
    }

}