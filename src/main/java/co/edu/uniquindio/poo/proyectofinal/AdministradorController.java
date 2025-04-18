package co.edu.uniquindio.poo.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class AdministradorController {
    @FXML private StackPane contenedorPrincipal;
    @FXML private Label labelTotalUsuarios;
    @FXML private Label labelTotalCuentas;
    @FXML private Label labelTotalTransacciones;
    @FXML private Label labelTotalPresupuestos;
    @FXML private Label labelTotalCategorias;
    @FXML private Label labelEstado;
    @FXML private Label labelFechaHora;

    private Timeline reloj;

    @FXML
    public void initialize() {
        iniciarReloj();
        actualizarEstadisticas();
    }

    private void iniciarReloj() {
        reloj = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime ahora = LocalDateTime.now();
            labelFechaHora.setText(ahora.format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        }), new KeyFrame(Duration.seconds(1)));
        reloj.setCycleCount(Timeline.INDEFINITE);
        reloj.play();
    }

    private void actualizarEstadisticas() {
        labelTotalUsuarios.setText(String.valueOf(Usuario.getUsuarios().size()));
        labelTotalCuentas.setText(String.valueOf(Cuenta.getCuentas().size()));
        labelTotalTransacciones.setText(String.valueOf(Transaccion.getTransacciones().size()));
        labelTotalPresupuestos.setText(String.valueOf(Presupuesto.getPresupuestos().size()));
        labelTotalCategorias.setText(String.valueOf(Categoria.getCategorias().size()));
    }

    @FXML
    private void mostrarGestionUsuarios() {
        cargarVista("usuario-view.fxml", "Gestión de Usuarios");
    }

    @FXML
    private void mostrarGestionCuentas() {
        cargarVista("cuenta-view.fxml", "Gestión de Cuentas");
    }

    @FXML
    private void mostrarGestionCategorias() {
        cargarVista("categoria-view.fxml", "Gestión de Categorías");
    }

    @FXML
    private void mostrarGestionPresupuestos() {
        cargarVista("presupuesto-view.fxml", "Gestión de Presupuestos");
    }

    @FXML
    private void mostrarGestionTransacciones() {
        cargarVista("transaccion-view.fxml", "Gestión de Transacciones");
    }

    @FXML
    private void mostrarReportes() {
        cargarVista("reporte-view.fxml", "Reportes");
    }

    @FXML
    private void cerrarSesion() {
        // Implementar lógica de cierre de sesión
    }

    private void cargarVista(String fxml, String estado) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent vista = loader.load();
            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(vista);
            labelEstado.setText("Mostrando: " + estado);
        } catch (IOException e) {
            mostrarError("Error al cargar la vista: " + e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        labelEstado.setText("Error: " + mensaje);
        // Implementar lógica adicional de manejo de errores si es necesario
    }

    public void detener() {
        if (reloj != null) {
            reloj.stop();
        }
    }
}
