package co.edu.uniquindio.poo.proyectofinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class PresupuestoController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtMontoLimite;
    @FXML private DatePicker dpFechaInicio;
    @FXML private DatePicker dpFechaFin;
    @FXML private ComboBox<Usuario> cbUsuario;
    @FXML private ComboBox<Categoria> cbCategoria;
    @FXML private TableView<Presupuesto> tablaPresupuestos;
    @FXML private TableColumn<Presupuesto, String> columnaId;
    @FXML private TableColumn<Presupuesto, String> columnaNombre;
    @FXML private TableColumn<Presupuesto, Double> columnaMontoLimite;
    @FXML private TableColumn<Presupuesto, String> columnaCategoria;
    @FXML private TableColumn<Presupuesto, LocalDate> columnaFechaInicio;
    @FXML private TableColumn<Presupuesto, LocalDate> columnaFechaFin;
    @FXML private TableColumn<Presupuesto, String> columnaUsuario;
    @FXML private TableColumn<Presupuesto, String> columnaEstado;
    @FXML private TableColumn<Presupuesto, String> columnaPorcentaje;

    private final ObservableList<Presupuesto> listaPresupuestos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar columnas
        columnaId.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getIdPresupuesto()));
        columnaNombre.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getDescripcion()));
        columnaMontoLimite.setCellValueFactory(p -> new javafx.beans.property.SimpleObjectProperty<>(p.getValue().getMontoInicial()));
        columnaCategoria.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getCategoria().getNombre()));
        columnaFechaInicio.setCellValueFactory(p -> new javafx.beans.property.SimpleObjectProperty<>(p.getValue().getFechaInicio()));
        columnaFechaFin.setCellValueFactory(p -> new javafx.beans.property.SimpleObjectProperty<>(p.getValue().getFechaFin()));
        columnaUsuario.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getUsuario().getNombre()));
        columnaEstado.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().estaVigente() ? "Vigente" : "Expirado"));

        columnaPorcentaje.setCellValueFactory(p -> {
            double porcentaje = ((p.getValue().getMontoInicial() - p.getValue().getMontoActual()) / p.getValue().getMontoInicial()) * 100;
            return new javafx.beans.property.SimpleStringProperty(String.format("%.2f%%", porcentaje));
        });

        tablaPresupuestos.setItems(listaPresupuestos);

        // Cargar datos en ComboBoxes (debes adaptar a tus datos reales)
        cbUsuario.setItems(FXCollections.observableArrayList(Usuario.getUsuarios()));
        cbCategoria.setItems(FXCollections.observableArrayList(Categoria.getCategorias()));
    }

    @FXML
    public void guardarPresupuesto() {
        try {
            String id = "P-" + System.currentTimeMillis(); // Generar ID automático
            String nombre = txtNombre.getText();
            double monto = Double.parseDouble(txtMontoLimite.getText());
            LocalDate inicio = dpFechaInicio.getValue();
            LocalDate fin = dpFechaFin.getValue();
            Usuario usuario = cbUsuario.getValue();
            Categoria categoria = cbCategoria.getValue();

            Presupuesto presupuesto = new Presupuesto(id, nombre, monto, inicio, fin, usuario, categoria);
            Presupuesto.guardarPresupuesto(presupuesto);
            listaPresupuestos.add(presupuesto);
            limpiarCampos();

        } catch (Exception e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void eliminarPresupuesto() {
        Presupuesto seleccionado = tablaPresupuestos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Presupuesto.getPresupuestos().remove(seleccionado);
            listaPresupuestos.remove(seleccionado);
        } else {
            mostrarAlerta("Advertencia", "Selecciona un presupuesto para eliminar", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void limpiarCampos() {
        txtNombre.clear();
        txtMontoLimite.clear();
        dpFechaInicio.setValue(null);
        dpFechaFin.setValue(null);
        cbUsuario.getSelectionModel().clearSelection();
        cbCategoria.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
