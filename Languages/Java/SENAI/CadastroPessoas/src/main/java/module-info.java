module com.example.cadastropessoas {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.cadastropessoas to javafx.fxml;
    exports com.example.cadastropessoas;
}