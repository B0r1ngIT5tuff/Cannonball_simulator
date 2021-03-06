package com.simulation.cannonball_simulator;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

import java.awt.Point;
import java.util.ArrayList;

public class Controller {

    // Attributes
    private CannonBall ball = new CannonBall(0);
    @FXML LineChart<Double, Double> graph;
    @FXML private TextField alpha_input;
    @FXML private TextField speed;
    @FXML private TextField interval;

    // Methods to handle events

    /**
     * This method handles the click event on the Shoot button.
     */
    @FXML
    public void onshootbtnClick() {

        double alpha = Double.parseDouble( alpha_input.getText() );
        double v = Double.parseDouble( speed.getText() );
        double dt = Double.parseDouble( interval.getText() );

        ArrayList<Point> points = ball.shoot(alpha,v,dt);
        XYChart.Series<Double, Double> result = this.fromPointsToSeries(points);

        graph.getData().add(result);
    }

    /**
     * This method handles the click event on the Reset button
     */
    @FXML
    public void onresetbtnClick() {
        // Clears the input from the textfields and the points from the graph.
        alpha_input.clear();
        speed.clear();
        interval.clear();
        graph.getData().clear();
        this.ball.setPosition(0,0);
    }

    // Utility methods

    /**
     * This method converts the result of the shoot method into an XYChart.Series
     * @param p An ArrayList of points generated by the shoot method of CannonBall
     * @return an XYChart.Series, which are the points on the Linechart
     */
    private XYChart.Series<Double, Double> fromPointsToSeries(ArrayList<Point> p) {

        XYChart.Series<Double, Double> res = new XYChart.Series<>();

        for (int i = 0; i < p.size()-1; i++) {
            res.getData().add(new XYChart.Data<>( p.get(i).getX(), p.get(i).getY()));
        }

        return res;
    }
}
