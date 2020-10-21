package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.BiFunction;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    ObservableList<String> choices = FXCollections.observableArrayList("1. 7x^2 + 2xy + 5y^2 + x - 10y",
            "2. 3x^2 - 3xy + 4y^2 - 2x + y",
            "3. x^2 + 2y^2 + e^(x^2 + y^2) - x + y",
            "4. sqrt(x^2 + y^2 + 1) + x / 2 + y / 2",
            "6. 5x^2 - 4xy + 5y^2 - x - y",
            "7. x^4 + 2y^4 + x^2 * y^2 + 2x + y",
            "8. x^2 + 3y^2 + cos(x + y)",
            "9. sqrt(1 + 2x^2 + y^2) + e^(x^2 + 2y^2) - x - y",
            "10. x + 5y + e^(x^2 + y^2)",
            "11. 4x^2 + 4xy + 6y^2 - 17x",
            "12. 2x^2 - 2xy + 3y^2 + x - 3y",
            "15. x^4 + y^4 + sqrt(2 + x^2 + y^2) - 2x + 3y",
            "16. 2x^2 + 3y^2 - 2sin((x - y) / 2) + y",
            "18. x^2 + e^(x^2 + y^2) + 4x + 3y",
            "19. x + 2y + 4sqrt(1 + x^2 + y^2)",
            "20. 2x - 5y + e^(x^2 + y^2 / 2)");

    BiFunction<Double, Double, Double> g1 = (x, y) -> 7 * x * x + 2 * x * y + 5 * y * y + x - 10 * y;
    BiFunction<Double, Double, Double> g2 = (x, y) -> 3 * x * x - 3 * x * y + 4 * y * y - 2 * x + y;
    BiFunction<Double, Double, Double> g3 = (x, y) -> x * x + 2 * y * y + Math.pow(Math.E, (x * x + y * y)) - x + y;
    BiFunction<Double, Double, Double> g4 = (x, y) -> Math.sqrt(x * x + y * y + 1) + x / 2 - y / 2;
    BiFunction<Double, Double, Double> g6 = (x, y) -> 5 * x * x - 4 * x * y + 5 * y * y - x - y;
    BiFunction<Double, Double, Double> g7 = (x, y) -> x * x * x * x + 2 * y * y * y * y + x * x * y * y + 2 * x + y;
    BiFunction<Double, Double, Double> g8 = (x, y) -> x * x + 3 * y * y + Math.cos(x + y);
    BiFunction<Double, Double, Double> g9 = (x, y) -> Math.sqrt(1 + 2 * x * x + y * y) + Math.pow(Math.E, (x * x + 2 * y * y)) - x - y;
    BiFunction<Double, Double, Double> g10 = (x, y) -> x + 5 * y + Math.pow(Math.E, (x * x + y * y));
    BiFunction<Double, Double, Double> g11 = (x, y) -> 4 * x * x + 4 * x * y + 6 * y * y - 17 * x;
    BiFunction<Double, Double, Double> g12 = (x, y) -> 2 * x * x - 2 * x * y + 3 * y * y + x - 3 * y;
    BiFunction<Double, Double, Double> g15 = (x, y) -> x * x * x * x + y * y * y * y + Math.sqrt(2 + x * x + y * y) - 2 * x + 3 * y;
    BiFunction<Double, Double, Double> g16 = (x, y) -> 2 * x * x + 3 * y * y - 2 * Math.sin((x - y) / 2) + y;
    BiFunction<Double, Double, Double> g18 = (x, y) -> x * x + Math.pow(Math.E, (x * x + y * y)) + 4 * x + 3 * y;
    BiFunction<Double, Double, Double> g19 = (x, y) -> x + 2 * y + 4 * Math.sqrt(1 + x * x + y * y);
    BiFunction<Double, Double, Double> g20 = (x, y) -> 2 * x - 5 * y + Math.pow(Math.E, (x * x + (y * y) / 2));

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button gradientButton;

    @FXML
    private Button gradientAboutButton;

    @FXML
    private Button coordinateButton;

    @FXML
    private Button coordinateAboutButton;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField answerGradientText;

    @FXML
    private TextField answerCoordinateText;

    @FXML
    private TextField answerPatternText;

    @FXML
    private Button patternAboutButton;

    @FXML
    private Button patternButton;

    @FXML
    private TextField answerGradientText1;

    @FXML
    private TextField answerCoordinateText1;

    @FXML
    private TextField answerPatternText1;

    @FXML
    private Button FuckMyLifeButton;

    @FXML
    void loadAboutCoordinate(ActionEvent event) throws IOException {
        Parent about_grad_page = FXMLLoader.load(getClass().getResource("aboutCoordinate.fxml"));
        Scene about_grad_scene = new Scene(about_grad_page);
        Stage about_grad_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        about_grad_stage.setScene(about_grad_scene);
        about_grad_stage.show();
    }

    @FXML
    void loadAboutGradient(ActionEvent event) throws IOException {
        Parent about_grad_page = FXMLLoader.load(getClass().getResource("aboutGradient.fxml"));
        Scene about_grad_scene = new Scene(about_grad_page);
        Stage about_grad_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        about_grad_stage.setScene(about_grad_scene);
        about_grad_stage.show();
    }

    @FXML
    void loadAboutPattern(ActionEvent event) throws IOException {
        Parent about_grad_page = FXMLLoader.load(getClass().getResource("aboutPattern.fxml"));
        Scene about_grad_scene = new Scene(about_grad_page);
        Stage about_grad_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        about_grad_stage.setScene(about_grad_scene);
        about_grad_stage.show();
    }

    @FXML
    void loadSourceList(ActionEvent event) throws IOException {
        Parent about_grad_page = FXMLLoader.load(getClass().getResource("sourceList.fxml"));
        Scene about_grad_scene = new Scene(about_grad_page);
        Stage about_grad_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        about_grad_stage.setScene(about_grad_scene);
        about_grad_stage.show();
    }

    @FXML
    void initialize() {
        choiceBox.setItems(choices);
        choiceBox.setValue("1. 7x^2 + 2xy + 5y^2 + x - 10y");
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert gradientButton != null : "fx:id=\"gradientButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert gradientAboutButton != null : "fx:id=\"gradientAboutButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert coordinateButton != null : "fx:id=\"coordinateButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert coordinateAboutButton != null : "fx:id=\"coordinateAboutButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'sample.fxml'.";
        assert answerGradientText != null : "fx:id=\"answerGradientText\" was not injected: check your FXML file 'sample.fxml'.";
        assert answerCoordinateText != null : "fx:id=\"answerCoordinateText\" was not injected: check your FXML file 'sample.fxml'.";
        assert answerPatternText != null : "fx:id=\"answerPatternText\" was not injected: check your FXML file 'sample.fxml'.";
        assert patternAboutButton != null : "fx:id=\"patternAboutButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert patternButton != null : "fx:id=\"patternButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert answerGradientText1 != null : "fx:id=\"answerGradientText1\" was not injected: check your FXML file 'sample.fxml'.";
        assert answerCoordinateText1 != null : "fx:id=\"answerCoordinateText1\" was not injected: check your FXML file 'sample.fxml'.";
        assert answerPatternText1 != null : "fx:id=\"answerPatternText1\" was not injected: check your FXML file 'sample.fxml'.";
        assert FuckMyLifeButton != null : "fx:id=\"FuckMyLifeButton\" was not injected: check your FXML file 'sample.fxml'.";
        gradientButton.setOnAction(event -> {
            switch (choiceBox.getValue()) {
                case ("1. 7x^2 + 2xy + 5y^2 + x - 10y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g1,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g1.apply(res.getX(), res.getY()));
                    break;
                }
                case ("2. 3x^2 - 3xy + 4y^2 - 2x + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g2,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g2.apply(res.getX(), res.getY()));
                    break;
                }
                case ("3. x^2 + 2y^2 + e^(x^2 + y^2) - x + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g3,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g3.apply(res.getX(), res.getY()));
                    break;
                }
                case ("4. sqrt(x^2 + y^2 + 1) + x / 2 + y / 2") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g4,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g4.apply(res.getX(), res.getY()));
                    break;
                }
                case ("6. 5x^2 - 4xy + 5y^2 - x - y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g6,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g6.apply(res.getX(), res.getY()));
                    break;
                }
                case ("7. x^4 + 2y^4 + x^2 * y^2 + 2x + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g7,
                            new Point2D(-0.5, -0.5),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g7.apply(res.getX(), res.getY()));
                    break;
                }
                case ("8. x^2 + 3y^2 + cos(x + y)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g8,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g8.apply(res.getX(), res.getY()));
                    break;
                }
                case ("9. sqrt(1 + 2x^2 + y^2) + e^(x^2 + 2y^2) - x - y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g9,
                            new Point2D(-0.5, -0.5),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g9.apply(res.getX(), res.getY()));
                    break;
                }
                case ("10. x + 5y + e^(x^2 + y^2)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g10,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g10.apply(res.getX(), res.getY()));
                    break;
                }
                case ("11. 4x^2 + 4xy + 6y^2 - 17x") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g11,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g11.apply(res.getX(), res.getY()));
                    break;
                }
                case ("12. 2x^2 - 2xy + 3y^2 + x - 3y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g12,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g12.apply(res.getX(), res.getY()));
                    break;
                }
                case ("15. x^4 + y^4 + sqrt(2 + x^2 + y^2) - 2x + 3y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g15,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g15.apply(res.getX(), res.getY()));
                    break;
                }
                case ("16. 2x^2 + 3y^2 - 2sin((x - y) / 2) + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g16,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g16.apply(res.getX(), res.getY()));
                    break;
                }
                case ("18. x^2 + e^(x^2 + y^2) + 4x + 3y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g18,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g18.apply(res.getX(), res.getY()));
                    break;
                }
                case ("19. x + 2y + 4sqrt(1 + x^2 + y^2)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g19,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g19.apply(res.getX(), res.getY()));
                    break;
                }
                case ("20. 2x - 5y + e^(x^2 + y^2 / 2)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();
                    Point2D res = descentMinimizer.minimize(g20,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerGradientText.setText(res.toString());
                    answerGradientText1.setText(" F= " + g20.apply(res.getX(), res.getY()));
                    break;
                }
            }
        });
        coordinateButton.setOnAction(event -> {
            switch (choiceBox.getValue()) {
                case ("1. 7x^2 + 2xy + 5y^2 + x - 10y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g1,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g1.apply(res.getX(), res.getY()));
                    break;
                }
                case ("2. 3x^2 - 3xy + 4y^2 - 2x + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g2,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g2.apply(res.getX(), res.getY()));
                    break;
                }
                case ("3. x^2 + 2y^2 + e^(x^2 + y^2) - x + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g3,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g3.apply(res.getX(), res.getY()));
                    break;
                }
                case ("4. sqrt(x^2 + y^2 + 1) + x / 2 + y / 2") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g4,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g4.apply(res.getX(), res.getY()));
                    break;
                }
                case ("6. 5x^2 - 4xy + 5y^2 - x - y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g6,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g6.apply(res.getX(), res.getY()));
                    break;
                }
                case ("7. x^4 + 2y^4 + x^2 * y^2 + 2x + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g7,
                            new Point2D(-0.5, -0.5),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g7.apply(res.getX(), res.getY()));
                    break;
                }
                case ("8. x^2 + 3y^2 + cos(x + y)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g8,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g8.apply(res.getX(), res.getY()));
                    break;
                }
                case ("9. sqrt(1 + 2x^2 + y^2) + e^(x^2 + 2y^2) - x - y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g9,
                            new Point2D(-0.5, -0.5),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g9.apply(res.getX(), res.getY()));
                    break;
                }
                case ("10. x + 5y + e^(x^2 + y^2)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g10,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g10.apply(res.getX(), res.getY()));
                    break;
                }
                case ("11. 4x^2 + 4xy + 6y^2 - 17x") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g11,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g11.apply(res.getX(), res.getY()));
                    break;
                }
                case ("12. 2x^2 - 2xy + 3y^2 + x - 3y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g12,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g12.apply(res.getX(), res.getY()));
                    break;
                }
                case ("15. x^4 + y^4 + sqrt(2 + x^2 + y^2) - 2x + 3y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g15,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g15.apply(res.getX(), res.getY()));
                    break;
                }
                case ("16. 2x^2 + 3y^2 - 2sin((x - y) / 2) + y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g16,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g16.apply(res.getX(), res.getY()));
                    break;
                }
                case ("18. x^2 + e^(x^2 + y^2) + 4x + 3y") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g18,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g18.apply(res.getX(), res.getY()));
                    break;
                }
                case ("19. x + 2y + 4sqrt(1 + x^2 + y^2)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g19,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g19.apply(res.getX(), res.getY()));
                    break;
                }
                case ("20. 2x - 5y + e^(x^2 + y^2 / 2)") : {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new CyclicCoordinateDescent();
                    Point2D res = descentMinimizer.minimize(g20,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerCoordinateText.setText(res.toString());
                    answerCoordinateText1.setText(" F= " + g20.apply(res.getX(), res.getY()));
                    break;
                }
            }
        });
        patternButton.setOnAction(event -> {
            switch (choiceBox.getValue()) {
                case ("1. 7x^2 + 2xy + 5y^2 + x - 10y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g1,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g1.apply(res.getX(), res.getY()));
                    break;
                }
                case ("2. 3x^2 - 3xy + 4y^2 - 2x + y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g2,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g2.apply(res.getX(), res.getY()));
                    break;
                }
                case ("3. x^2 + 2y^2 + e^(x^2 + y^2) - x + y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g3,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g3.apply(res.getX(), res.getY()));
                    break;
                }
                case ("4. sqrt(x^2 + y^2 + 1) + x / 2 + y / 2"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g4,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g4.apply(res.getX(), res.getY()));
                    break;
                }
                case ("6. 5x^2 - 4xy + 5y^2 - x - y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g6,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g6.apply(res.getX(), res.getY()));
                    break;
                }
                case ("7. x^4 + 2y^4 + x^2 * y^2 + 2x + y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g7,
                            new Point2D(-0.5, -0.5),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g7.apply(res.getX(), res.getY()));
                    break;
                }
                case ("8. x^2 + 3y^2 + cos(x + y)"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g8,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g8.apply(res.getX(), res.getY()));
                    break;
                }
                case ("9. sqrt(1 + 2x^2 + y^2) + e^(x^2 + 2y^2) - x - y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g9,
                            new Point2D(-0.5, -0.5),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g9.apply(res.getX(), res.getY()));
                    break;
                }
                case ("10. x + 5y + e^(x^2 + y^2)"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g10,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g10.apply(res.getX(), res.getY()));
                    break;
                }
                case ("11. 4x^2 + 4xy + 6y^2 - 17x"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g11,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g11.apply(res.getX(), res.getY()));
                    break;
                }
                case ("12. 2x^2 - 2xy + 3y^2 + x - 3y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g12,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g12.apply(res.getX(), res.getY()));
                    break;
                }
                case ("15. x^4 + y^4 + sqrt(2 + x^2 + y^2) - 2x + 3y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g15,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g15.apply(res.getX(), res.getY()));
                    break;
                }
                case ("16. 2x^2 + 3y^2 - 2sin((x - y) / 2) + y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g16,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g16.apply(res.getX(), res.getY()));
                    break;
                }
                case ("18. x^2 + e^(x^2 + y^2) + 4x + 3y"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g18,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g18.apply(res.getX(), res.getY()));
                    break;
                }
                case ("19. x + 2y + 4sqrt(1 + x^2 + y^2)"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g19,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g19.apply(res.getX(), res.getY()));
                    break;
                }
                case ("20. 2x - 5y + e^(x^2 + y^2 / 2)"): {
                    DoubleArgumentFunctionMinimizer descentMinimizer = new PatternSearch();
                    Point2D res = descentMinimizer.minimize(g20,
                            new Point2D(-1, -1),
                            (Double x) -> x >= -2 && x <= 2,
                            (Double y) -> y >= -2 && y <= 2,
                            0.0001);
                    answerPatternText.setText(res.toString());
                    answerPatternText1.setText(" F= " + g20.apply(res.getX(), res.getY()));
                    break;
                }
            }
        });
    }
}
