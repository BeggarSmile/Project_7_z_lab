package sample;

import sample.DoubleArgumentFunctionMinimizer;
import sample.Point2D;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class CyclicCoordinateDescent implements DoubleArgumentFunctionMinimizer {

    @Override
    public Point2D minimize(BiFunction<Double, Double, Double> f,
                            Point2D startPoint,
                            Predicate<Double> domX,
                            Predicate<Double> domY,
                            double precision) {
        try {

            PrintWriter writer = new PrintWriter("CyclicCoordinatesDescent.txt");
            double startFunc = f.apply(startPoint.getX(), startPoint.getY());
            double left;
            double right;
            double x = startPoint.getX();
            double y = startPoint.getY();
            writer.format("x= %.5f || y= %.5f || f= %.5f || ", x, y, f.apply(x, y));
            boolean parity = true;
            double answer = 36729.67370;

            for(;;) {
                if (parity) {
                    left = x - precision;
                    right = x + precision;
                    double nLeft = f.apply(left, y);
                    double nRight = f.apply(right, y);
                    if (nLeft < nRight && nLeft < startFunc) {
                        for (;;) {
                            left -= precision;
                            if (nLeft <= f.apply(left, y) || !domX.test(left)) {
                                x = left;
                                writer.format("X LEFT\nx= %.5f || y= %.5f || f= %.5f || ", left, y, f.apply(x, y));
                                break;
                            }
                            nLeft = f.apply(left, y);
                        }
                    }
                    else if (nRight < startFunc) {
                        for (;;) {
                            right += precision;
                            if (nRight <= f.apply(right, y) || !domX.test(right)) {
                                x = right;
                                writer.format("X RIGHT\nx= %.5f || y= %.5f || f= %.5f || ", right, y, f.apply(x, y));
                                break;
                            }
                            nRight = f.apply(right, y);
                        }
                    }
                    parity = !parity;
                }
                else {
                    left = y - precision;
                    right = y + precision;
                    double nLeft = f.apply(x, left);
                    double nRight = f.apply(x, right);
                    if (nLeft < nRight && nLeft < startFunc) {
                        for (;;) {
                            left -= precision;
                            if (nLeft <= f.apply(x, left) || !domY.test(left)) {
                                y = left;
                                writer.format("Y LEFT\nx= %.5f || y= %.5f || f= %.5f || ", x, left, f.apply(x, y));
                                break;
                            }
                            nLeft = f.apply(x, left);
                        }
                    }
                    else if (nRight < startFunc) {
                        for (;;) {
                            right += precision;
                            if (nRight <= f.apply(x, right) || !domY.test(right)) {
                                y = right;
                                writer.format("Y RIGHT\nx= %.5f || y= %.5f || f= %.5f || ", x, right, f.apply(x, y));
                                break;
                            }
                            nRight = f.apply(x, right);
                        }
                    }
                    parity = !parity;
                }
                startFunc = f.apply(x, y);
                if (Math.abs(answer - startFunc) <= precision) {
                    writer.format("I calculated function");
                    writer.close();
                    return new Point2D(x, y);
                }
                answer = startFunc;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}