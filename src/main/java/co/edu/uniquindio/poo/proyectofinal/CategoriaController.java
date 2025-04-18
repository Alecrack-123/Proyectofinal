package co.edu.uniquindio.poo.proyectofinal;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;




public class CategoriaController {
    @FXML
    private TextField campoIdCategoria;
    @FXML
    private TextField campoNombreCategoria;
    @FXML
    private TextField campoDescripcionCategoria;
    @FXML
    private TableView<Categoria> tablaCategorias;

    private ObservableList<Categoria> listaCategorias;

    @FXML
    private void agregarCategoria() {
        try {
            // Validaciones
            if (camposVacios()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios");
                return;
            }

            // Validar si el ID ya existe
            if (existeId(campoIdCategoria.getText())) {
                mostrarAlerta("Error", "El ID ya existe");
                return;
            }

            Categoria c = new Categoria(
                    campoIdCategoria.getText().trim(),
                    campoNombreCategoria.getText().trim(),
                    campoDescripcionCategoria.getText().trim()
            );

            listaCategorias.add(c);
            limpiarCampos();
            mostrarAlerta("Éxito", "Categoría agregada correctamente");
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al agregar la categoría: " + e.getMessage());
        }
    }

    @FXML
    private void editarCategoria() {
        try {
            Categoria categoriaSeleccionada = tablaCategorias.getSelectionModel().getSelectedItem();
            if (categoriaSeleccionada == null) {
                mostrarAlerta("Error", "Debe seleccionar una categoría");
                return;
            }

            if (camposVacios()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios");
                return;
            }

            categoriaSeleccionada.setNombre(campoNombreCategoria.getText().trim());
            categoriaSeleccionada.setDescripcion(campoDescripcionCategoria.getText().trim());
            tablaCategorias.refresh();
            limpiarCampos();
            mostrarAlerta("Éxito", "Categoría actualizada correctamente");
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al editar la categoría: " + e.getMessage());
        }
    }

    @FXML
    private void eliminarCategoria() {
        try {
            Categoria categoriaSeleccionada = tablaCategorias.getSelectionModel().getSelectedItem();
            if (categoriaSeleccionada == null) {
                mostrarAlerta("Error", "Debe seleccionar una categoría");
                return;
            }

            // Opcional: Confirmar eliminación
            if (confirmarEliminacion()) {
                listaCategorias.remove(categoriaSeleccionada);
                limpiarCampos();
                mostrarAlerta("Éxito", "Categoría eliminada correctamente");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al eliminar la categoría: " + e.getMessage());
        }
    }

    @FXML
    private void limpiarCampos() {
        campoIdCategoria.clear();
        campoNombreCategoria.clear();
        campoDescripcionCategoria.clear();
        tablaCategorias.getSelectionModel().clearSelection();
    }

    private boolean camposVacios() {
        return campoIdCategoria.getText().trim().isEmpty() ||
                campoNombreCategoria.getText().trim().isEmpty() ||
                campoDescripcionCategoria.getText().trim().isEmpty();
    }

    private boolean existeId(String id) {
        return listaCategorias.stream()
                .anyMatch(categoria -> categoria.getIdCategoria().equals(id));
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private boolean confirmarEliminacion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro que desea eliminar esta categoría?");
        return alert.showAndWait().get() == ButtonType.OK;
    }
}

