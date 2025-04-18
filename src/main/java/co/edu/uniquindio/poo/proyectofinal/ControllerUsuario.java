package co.edu.uniquindio.poo.proyectofinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.regex.Pattern;


public class ControllerUsuario {
    @FXML private TextField campoNombreUsuario;
    @FXML private TextField campoEmailUsuario;
    @FXML private TextField campoAliasUsuario;
    @FXML private TextField campoDireccionUsuario;
    @FXML private TextField campoTelefonoUsuario;
    @FXML private TextField campoSaldoUsuario;
    @FXML private TableView<Usuario> tablaUsuarios;

    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarTabla();
        configurarListeners();
    }

    @FXML
    private void agregarUsuario() {
        try {
            validarCampos();

            double saldo = validarYConvertirSaldo(campoSaldoUsuario.getText());

            Usuario usuario = new Usuario(
                    campoNombreUsuario.getText().trim(),
                    campoEmailUsuario.getText().trim(),
                    campoAliasUsuario.getText().trim(),
                    campoDireccionUsuario.getText().trim(),
                    campoTelefonoUsuario.getText().trim(),
                    saldo
            );

            if (usuarioExiste(usuario)) {
                mostrarAlerta("Error", "Ya existe un usuario con este email o alias");
                return;
            }

            listaUsuarios.add(usuario);
            limpiarCampos();
            mostrarAlerta("Éxito", "Usuario agregado correctamente");
        } catch (IllegalArgumentException e) {
            mostrarAlerta("Error", e.getMessage());
        } catch (Exception e) {
            mostrarAlerta("Error", "Error inesperado: " + e.getMessage());
        }
    }

    private void validarCampos() {
        if (camposVacios()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }

        if (!validarEmail(campoEmailUsuario.getText())) {
            throw new IllegalArgumentException("El email no es válido");
        }

        if (!validarTelefono(campoTelefonoUsuario.getText())) {
            throw new IllegalArgumentException("El teléfono debe tener 10 dígitos");
        }

        if (!validarNombre(campoNombreUsuario.getText())) {
            throw new IllegalArgumentException("El nombre no puede contener números o caracteres especiales");
        }
    }

    private boolean camposVacios() {
        return campoNombreUsuario.getText().trim().isEmpty() ||
                campoEmailUsuario.getText().trim().isEmpty() ||
                campoAliasUsuario.getText().trim().isEmpty() ||
                campoDireccionUsuario.getText().trim().isEmpty() ||
                campoTelefonoUsuario.getText().trim().isEmpty() ||
                campoSaldoUsuario.getText().trim().isEmpty();
    }

    private boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    private boolean validarNombre(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
    }

    private double validarYConvertirSaldo(String saldo) {
        try {
            double valor = Double.parseDouble(saldo);
            if (valor < 0) {
                throw new IllegalArgumentException("El saldo no puede ser negativo");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El saldo debe ser un número válido");
        }
    }

    private boolean usuarioExiste(Usuario nuevoUsuario) {
        return listaUsuarios.stream()
                .anyMatch(u -> u.getCorreo().equals(nuevoUsuario.getCorreo()) ||
                        u.getIdUsuario().equals(nuevoUsuario.getIdUsuario()));
    }

    private void limpiarCampos() {
        campoNombreUsuario.clear();
        campoEmailUsuario.clear();
        campoAliasUsuario.clear();
        campoDireccionUsuario.clear();
        campoTelefonoUsuario.clear();
        campoSaldoUsuario.clear();
        tablaUsuarios.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void configurarTabla() {
        // Configurar las columnas de la tabla
        TableColumn<Usuario, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Usuario, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Usuario, String> colAlias = new TableColumn<>("Alias");
        colAlias.setCellValueFactory(new PropertyValueFactory<>("alias"));

        TableColumn<Usuario, String> colDireccion = new TableColumn<>("Dirección");
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<Usuario, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<Usuario, Double> colSaldo = new TableColumn<>("Saldo");
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        tablaUsuarios.getColumns().addAll(colNombre, colEmail, colAlias, colDireccion, colTelefono, colSaldo);
        tablaUsuarios.setItems(listaUsuarios);
    }

    private void configurarListeners() {
        // Listener para la selección de usuarios en la tabla
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mostrarDatosUsuario(newSelection);
            }
        });

        // Validación en tiempo real del email
        campoEmailUsuario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && !validarEmail(newValue)) {
                campoEmailUsuario.setStyle("-fx-border-color: red;");
            } else {
                campoEmailUsuario.setStyle("");
            }
        });

        // Validación en tiempo real del teléfono
        campoTelefonoUsuario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && !validarTelefono(newValue)) {
                campoTelefonoUsuario.setStyle("-fx-border-color: red;");
            } else {
                campoTelefonoUsuario.setStyle("");
            }
        });
    }

    private void mostrarDatosUsuario(Usuario usuario) {
        campoNombreUsuario.setText(usuario.getNombre());
        campoEmailUsuario.setText(usuario.getCorreo());
        campoAliasUsuario.setText(usuario.getIdUsuario());
        campoDireccionUsuario.setText(usuario.getDireccion());
        campoTelefonoUsuario.setText(usuario.getTelefono());
        campoSaldoUsuario.setText(String.valueOf(usuario.getSaldo()));
    }

    @FXML
    private void editarUsuario() {
        try {
            Usuario usuarioSeleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
            if (usuarioSeleccionado == null) {
                mostrarAlerta("Error", "Debe seleccionar un usuario para editar");
                return;
            }

            validarCampos();
            double saldo = validarYConvertirSaldo(campoSaldoUsuario.getText());

            usuarioSeleccionado.setNombre(campoNombreUsuario.getText().trim());
            usuarioSeleccionado.setCorreo(campoEmailUsuario.getText().trim());
            usuarioSeleccionado.setIdUsuario(campoAliasUsuario.getText().trim());
            usuarioSeleccionado.setDireccion(campoDireccionUsuario.getText().trim());
            usuarioSeleccionado.setTelefono(campoTelefonoUsuario.getText().trim());
            usuarioSeleccionado.setSaldo(saldo);

            tablaUsuarios.refresh();
            limpiarCampos();
            mostrarAlerta("Éxito", "Usuario actualizado correctamente");
        } catch (IllegalArgumentException e) {
            mostrarAlerta("Error", e.getMessage());
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al actualizar el usuario: " + e.getMessage());
        }
    }

    @FXML
    private void eliminarUsuario() {
        Usuario usuarioSeleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado == null) {
            mostrarAlerta("Error", "Debe seleccionar un usuario para eliminar");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Está seguro que desea eliminar este usuario?");

        if (confirmacion.showAndWait().get() == ButtonType.OK) {
            listaUsuarios.remove(usuarioSeleccionado);
            limpiarCampos();
            mostrarAlerta("Éxito", "Usuario eliminado correctamente");
        }
    }
}
