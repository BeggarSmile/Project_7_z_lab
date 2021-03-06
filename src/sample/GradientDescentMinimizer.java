package sample;

import sample.DoubleArgumentFunctionMinimizer;
import sample.Point2D;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.function.BiFunction;
import java.util.function.Predicate;


public class GradientDescentMinimizer implements DoubleArgumentFunctionMinimizer {
    private final double EPS = 0.0001;

    /*
        Метод градиентного спуска. Основан на утверждении, что градиент, взятый со знаком минус
        показывает направление скорейшего убывания функции. Соответственно, шагая из заданной начальной точки
        вдоль этого направления рано или поздно мы придем в точку минимума.
        Версия градиентного спуска, в которой длина шага считается на каждом этапе.
        Шагая вдоль направления антиградиента, мы хотим прийти в точку минимума на этом луче. В данном
        случае придется на каждом шаге решать задачу одномерной оптимизации. Мы воспользуемся методом золотого сечения
        Условия остановки алгоритма - либо разность значений функции меньше
        заданной точности, либо новая точка отстоит от старой точки на расстояние, меньшее той же точности, либо же
        новая точка вышла за пределы области, в которой мы ищем минимум.
     */

    @Override
    public Point2D minimize(BiFunction<Double, Double, Double> f,
                            Point2D startPoint,
                            Predicate<Double> domX,
                            Predicate<Double> domY,
                            double precision) {
        try {
            Point2D nextPoint = new Point2D();
            GoldenRatioMinimizer goldenRatioMinimizer = new GoldenRatioMinimizer();
            int gradientComputationsCounter = 0;
            int functionComputationsCounter = 0;
            PrintWriter writer = new PrintWriter("GradientDescentMinimizerOut.txt");
            for (;;) {
                Point2D grad = getGradient(f, startPoint);
                gradientComputationsCounter++;
                final Point2D finalStartPoint = startPoint;
                double stepSize = goldenRatioMinimizer.argmin(
                        (x) -> {
                            Point2D point = Point2D.sub(finalStartPoint, Point2D.mul(grad, x));
                            return f.apply(point.getX(), point.getY());
                        },
                        -2,
                        2,
                        0.0001);

                nextPoint = Point2D.sub(startPoint, Point2D.mul(grad, stepSize));
                writer.format("%s -> %.5f\n", startPoint.toString(), f.apply(startPoint.getX(), startPoint.getY()));

                Boolean stopCriteria1 = getNorm(Point2D.sub(nextPoint, startPoint)) < precision;
                Boolean stopCriteria2 = !domX.test(nextPoint.getX());
                Boolean stopCriteria3 = !domY.test(nextPoint.getY());
                Boolean stopCriteria4 = Math.abs(f.apply(nextPoint.getX(), nextPoint.getY()) - f.apply(startPoint.getX(), startPoint.getY())) < precision;
                functionComputationsCounter++;
                if (stopCriteria1 || stopCriteria2 || stopCriteria3 || stopCriteria4) {
                    writer.format("I calculated gradient for %d times, and function for %d times", gradientComputationsCounter, functionComputationsCounter);
                    writer.close();
                    return nextPoint;
                }
                startPoint = new Point2D(nextPoint.getX(), nextPoint.getY());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        Вспомогательная функция для подсчета градиента. Частные производные в заданной точке считаются численно.
        Например, частная производная по иксу считается следующим образом: берем точку (x,y), к иксу прибавляем
        маленькое эпсилон, получаем точку (x + eps, y). Считаем разность между значениями функции в этих двух
        точках и делим на эпсилон. Для игрека все то же самое, только фиксируем значение икса.
     */

    private Point2D getGradient(BiFunction<Double, Double, Double> f, Point2D point) {
        double x = (f.apply(point.getX() + EPS, point.getY()) - f.apply(point.getX(), point.getY())) / EPS;
        double y = (f.apply(point.getX(), point.getY() + EPS) - f.apply(point.getX(), point.getY())) / EPS;
        return new Point2D(x, y);
    }

    private double getNorm(Point2D point) {
        return Math.sqrt( ( point.getX() * point.getX() ) + ( point.getY() * point.getY() ) );
    }
}