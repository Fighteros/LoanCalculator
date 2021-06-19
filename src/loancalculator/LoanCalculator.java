/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loancalculator;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahemd M. Abd El-Ghany
 */
public class LoanCalculator extends Application {

    private TextField tfAnnualInterst, tfNumberOfYears, tfLoanAmount, tfMonthlyPayment, tfTotalPayment;
    private final Button btCalc = new Button("Calculate");
    private GridPane rootView;

    @Override
    public void start(Stage primaryStage) {
        rootView = createRoot();
        addUi(rootView);
        Scene scene = new Scene(rootView, 400, 250);

        primaryStage.setTitle("Load Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // create gridPane and add Ui
    private GridPane createRoot() {
        GridPane root = new GridPane();
        // add UI

        return root;
    }

    // add Ui
    private void addUi(GridPane grd) {
        tfAnnualInterst = new TextField();
        tfNumberOfYears = new TextField();
        tfLoanAmount = new TextField();
        tfMonthlyPayment = new TextField();
        tfTotalPayment = new TextField();
        
        grd.setHgap(5);
        grd.setVgap(5);

        grd.addRow(0, new Label("Annual Interset Rate"), tfAnnualInterst);
        grd.addRow(1, new Label("Number of Years"), tfNumberOfYears);
        grd.addRow(2, new Label("Load Amount"), tfLoanAmount);
        grd.addRow(3, new Label("Monthly Payment"), tfMonthlyPayment);
        grd.addRow(4, new Label("Total Payment"), tfTotalPayment);
        
        grd.add(btCalc, 1, 5, 1, 2);
        

        grd.setAlignment(Pos.CENTER);
        tfAnnualInterst.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane.setHalignment(btCalc, HPos.RIGHT);

        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);

        btCalc.setOnAction(e -> {
            calcLoanPayemnt();
        });

    }

    private void calcLoanPayemnt() {
        double interset = Double.parseDouble(tfAnnualInterst.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());
        Loan loan = new Loan(interset, year, loanAmount);

        tfMonthlyPayment.setText(String.format("$ %.2f", loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$ %.2f", loan.getTotalPayment()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
