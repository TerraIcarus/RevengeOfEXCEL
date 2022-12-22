package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HelloController {
    @FXML
    private ComboBox<String> CarBox;
    @FXML
    private TextField CityField;
    @FXML
    private TextField ItogField;
    @FXML
    private TextField NormalField;
    @FXML
    private TextField StoKmField;
    @FXML
    private Button SumButton;

    @FXML
    private TextField pathF;

    @FXML
    void initialize() {
        String q1 = "SELECT name FROM public.\"ExcelCars\"";

        try (Connection con = Connect.Connect()) {
            PreparedStatement statement = con.prepareStatement(q1);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                CarBox.getItems().addAll(rs.getString("name"));
            }
            con.close();
            statement.close();
        } catch (SQLException e) {

        }
    }
    @FXML
    void Click(ActionEvent event) {
        String q4= "SELECT value FROM public.\"ExcelCars\" WHERE name = ?";

        try (Connection con = Connect.Connect()) {
            PreparedStatement pstmt = con.prepareStatement(q4);

            pstmt.setString(1, CarBox.getSelectionModel().getSelectedItem());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                StoKmField.setText(rs.getString("value"));
            }

            System.out.println(pstmt);
            con.close();
            pstmt.close();
        } catch (SQLException ex) {

        }
    }

    @FXML
    void CityAction(ActionEvent event) {
        Double a = (Double.parseDouble(StoKmField.getText()) /100);
        Double b = (Double.parseDouble(CityField.getText()) * a);
        Double c = (b * 0.2);
        System.out.println(a);
        Double result = (b+c);
        ItogField.setText(String.valueOf(result));
    }

    @FXML
    void NormalAction(ActionEvent event) {
        Double a = (Double.parseDouble(StoKmField.getText()) /100);
        System.out.println(a);
        Double result = (a * Integer.parseInt(NormalField.getText()));
        ItogField.setText(String.valueOf(result));
    }

    @FXML
    void SumClick(ActionEvent event) {
        if(StoKmField ==  null) {
            System.out.println("null");
        }
        else{
            double a = (Double.parseDouble(StoKmField.getText()) / 100);
            double b = (Double.parseDouble(CityField.getText()) * a);
            double c = (b * 0.2);
            double d = (a * Integer.parseInt(NormalField.getText()));
            Double result = (b + c + d);
            ItogField.setText(String.valueOf(result));
        }
    }
}