module com.simulation.cannonball_simulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.simulation.cannonball_simulator to javafx.fxml;
    exports com.simulation.cannonball_simulator;
}