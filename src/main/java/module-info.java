module com.discrete.finalsproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.discrete.finalsproject to javafx.fxml;
    exports com.discrete.finalsproject;
    exports com.discrete.finalsproject.Controllers;
    opens com.discrete.finalsproject.Controllers to javafx.fxml;
}