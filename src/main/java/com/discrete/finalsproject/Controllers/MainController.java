package com.discrete.finalsproject.Controllers;

import com.discrete.finalsproject.Models.Calculator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // TODO: Table [Columns: Data, Data - Mean, (Data - Mean)^2] - Johann
    // TODO: Histogram/Graph - Leo
    @FXML
    private TextField inputField;

    @FXML
    private ImageView populationBtn;

    @FXML
    private ImageView sampleBtn;

    @FXML
    private AnchorPane scroll;

    @FXML
    private ImageView meanInfo, standardDevInfo, varianceInfo;

    @FXML
    private AnchorPane learnPane, resultsPane, creditsPane;

    @FXML
    private Label meanResult, standardResult, varianceResult, alertLabel;

    @FXML
    private VBox contentBox;

    public static Double pageStart = 0.0, pageEnd = (-1840.0 + 720);

    // Buttons
    Image sampleBtnImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/SampleBtn.png")));
    Image sampleBtnImgClicked = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/SampleBtn_P.png")));

    Image populationBtnImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/PopulationBtn.png")));
    Image populationBtnImgClicked = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/PopulationBtn_P.png")));

    // ImageInfos
    Image meanInfoImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/MeanDef.png")));
    Image standardDevInfoImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/StandardDevDef.png")));
    Image varianceInfoImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/VarianceDef.png")));
    Image meanInfoSelectedImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/MeanDefSelected.png")));
    Image standardDevInfoSelectedImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/StandardDevDefSelected.png")));
    Image varianceInfoSelectedImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/VarianceDefSelected.png")));

    String clickedButton = "None";
    private ArrayList<Double> getInputData(){
        // Convert commas to spaces and split by spaces. If there is more than one space, convert it to one space.
        String[] inputString = inputField.getText().replaceAll(",", " ").replaceAll("\\s+", " ").split(" ");
        ArrayList<Double> inputData = new ArrayList<>();

        // Convert the string array to double array
        for (String s : inputString) {
            inputData.add(Double.parseDouble(s));
        }
        return inputData;
    }

    @FXML
    private void onSampleButtonClicked(){
        alertLabel.setVisible(false);
        // check if text field has non-numeric characters
        if (!inputField.getText().matches("[-0-9, ]+")) {
            System.out.println("Invalid input");
            inputField.clear();
            alertLabel.setVisible(true);
            return;
        }

        // Set the data
        Calculator.setData(getInputData());
        Calculator.calculateAllForSample();

        setResults();

        // Change the buttons and content box
        buttonChange("Sample");
        rearrangeContentBox("Answer");
    }

    @FXML
    private void onPopulationButtonClicked(){
        alertLabel.setVisible(false);
        // check if text field has non-numeric characters
        if (!inputField.getText().matches("[-0-9, ]+")) {
            System.out.println("Invalid input");
            inputField.clear();
            alertLabel.setVisible(true);
            return;
        }

        // Set the data
        Calculator.setData(getInputData());
        Calculator.calculateAllForPopulation();

        setResults();

        // Change the buttons and content box
        buttonChange("Population");
        rearrangeContentBox("Answer");
    }

    private void setResults(){
        // Set the results and 2 decimal places
        meanResult.setText("%.2f".formatted(Calculator.getMean()));
        standardResult.setText("%.2f".formatted(Calculator.getStandardDeviation()));
        varianceResult.setText("%.2f".formatted(Calculator.getVariance()));
    }
    private void rearrangeContentBox(String mode){
        // Remove all the children of the content box
        contentBox.getChildren().clear();
        if (mode.equals("Answer")){
            // Add the answer pane
            contentBox.getChildren().add(resultsPane);
            // Add the learn pane
            contentBox.getChildren().add(learnPane);
            // Add the credits pane
            contentBox.getChildren().add(creditsPane);
        } else {
            // Add the learn pane
            contentBox.getChildren().add(learnPane);
            // Add the credits pane
            contentBox.getChildren().add(creditsPane);
        }
    }

    private void buttonChange(String button){
        if (Objects.equals(button, clickedButton)) return;

        if (button.equals("Population")){
            // change button images
            populationBtn.setImage(populationBtnImgClicked);
            sampleBtn.setImage(sampleBtnImg);

            // Move the population down by 10 and right by 10
            populationBtn.setLayoutX(populationBtn.getLayoutX() + 10);
            populationBtn.setLayoutY(populationBtn.getLayoutY() + 10);

            if (clickedButton.equals("Sample")) {
                // Move the sample down back to 0 and right back to 0
                sampleBtn.setLayoutX(sampleBtn.getLayoutX() - 10);
                sampleBtn.setLayoutY(sampleBtn.getLayoutY() - 10);
            }

            clickedButton = "Population";
        } else if (button.equals("Sample")){
            // change button images
            populationBtn.setImage(populationBtnImg);
            sampleBtn.setImage(sampleBtnImgClicked);

            // Move the sample down by 10 and right by 10
            sampleBtn.setLayoutX(sampleBtn.getLayoutX() + 10);
            sampleBtn.setLayoutY(sampleBtn.getLayoutY() + 10);

            if (clickedButton.equals("Population")) {
                // Move the population down back to 0 and right back to 0
                populationBtn.setLayoutX(populationBtn.getLayoutX() - 10);
                populationBtn.setLayoutY(populationBtn.getLayoutY() - 10);
            }

            clickedButton = "Sample";
        } else {
            // change button images
            populationBtn.setImage(populationBtnImg);
            sampleBtn.setImage(sampleBtnImg);

            if (clickedButton.equals("Population")) {
                // Move the population down back to 0 and right back to 0
                populationBtn.setLayoutX(populationBtn.getLayoutX() - 10);
                populationBtn.setLayoutY(populationBtn.getLayoutY() - 10);
            } else if (clickedButton.equals("Sample")) {
                // Move the sample down back to 0 and right back to 0
                sampleBtn.setLayoutX(sampleBtn.getLayoutX() - 10);
                sampleBtn.setLayoutY(sampleBtn.getLayoutY() - 10);
            }
            clickedButton = "None";
        }
    }

    @FXML
    private void onXButtonClicked(){
        alertLabel.setVisible(false);

        // Clear the input field
        inputField.clear();

        // Clear the data
        Calculator.setData(new ArrayList<>());

        // Reset the buttons
        buttonChange("None");

        // Reset the content box
        rearrangeContentBox("None");
    }

    private void goToLink(ImageView imageView, String link) {
        imageView.setOnMousePressed(mouseEvent -> {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(link));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void onHover(ImageView imageView, Image selected, Image normal) {
        imageView.setOnMouseEntered(mouseEvent -> {
            imageView.setImage(selected);

            // scale x and y to expand the image
            imageView.setScaleX(1.025);
            imageView.setScaleY(1.025);

            // Set opacity to 1
            imageView.setOpacity(1);

            // change the cursor to a hand
            imageView.getScene().setCursor(javafx.scene.Cursor.HAND);

        });
        imageView.setOnMouseExited(mouseEvent -> {
            imageView.setImage(normal);

            // scale x and y to shrink the image
            imageView.setScaleX(1);
            imageView.setScaleY(1);

            // Set opacity to 0.75
            imageView.setOpacity(0.75);

            // change the cursor to a hand
            imageView.getScene().setCursor(javafx.scene.Cursor.DEFAULT);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Make the scroll pane scrollable
        scroll.setOnScroll(scrollEvent -> {
            if (scroll.getLayoutY() + scrollEvent.getDeltaY() > pageStart) return;
            scroll.setLayoutY(scroll.getLayoutY() + scrollEvent.getDeltaY());
        });

        // Set onhover listeners for ImageView infos
        onHover(meanInfo, meanInfoSelectedImg, meanInfoImg);
        onHover(standardDevInfo, standardDevInfoSelectedImg, standardDevInfoImg);
        onHover(varianceInfo, varianceInfoSelectedImg, varianceInfoImg);

        // Set onCLick listeners for ImageView infos
        goToLink(meanInfo, "https://byjus.com/maths/mean/");
        goToLink(standardDevInfo, "https://byjus.com/maths/standard-deviation/#:~:text=Standard%20Deviation%20is,statistical%20problems.");
        goToLink(varianceInfo, "https://byjus.com/maths/variance/");
    }
}
