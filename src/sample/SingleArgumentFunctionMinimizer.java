package sample;

import java.util.function.DoubleFunction;


public interface SingleArgumentFunctionMinimizer {
    public double minimize(DoubleFunction<Double> f, double lowerBound, double higherBound, double precision);
}
