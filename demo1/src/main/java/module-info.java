module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires java.sql;
    // requires org.apache.poi.poi;
  //  requires org.apache.poi.ooxml;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}