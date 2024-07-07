module com.example.telacadastrojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.telacadastrojavafx to javafx.fxml;
    exports com.example.telacadastrojavafx;
}