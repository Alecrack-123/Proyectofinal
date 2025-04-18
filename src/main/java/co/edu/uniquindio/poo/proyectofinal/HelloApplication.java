package co.edu.uniquindio.poo.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el menú principal
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-principal.fxml"));
            Parent root = fxmlLoader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Configurar el Stage
            primaryStage.setTitle("Sistema de Gestión");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
