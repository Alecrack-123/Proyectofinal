package co.edu.uniquindio.poo.proyectofinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class Controller {
    // Elementos de Administrador
    @FXML private TextField idAdminField, nombreAdminField, correoAdminField;
    @FXML private TableView<Administrador> tableViewAdmin;
    @FXML private TableColumn<Administrador, String> idAdminColumn, nombreAdminColumn, correoAdminColumn;
    @FXML private Button btnCrearAdmin, btnEliminarAdmin, btnActualizarAdmin;

    // Elementos de Categoría
    @FXML private TextField idCategoriaField, nombreCategoriaField, descripcionField;
    @FXML private TableView<Categoria> tableViewCategoria;
    @FXML private TableColumn<Categoria, String> idCategoriaColumn, nombreCategoriaColumn, descripcionColumn;
    @FXML private Button btnCrearCategoria, btnEliminarCategoria, btnActualizarCategoria;

    // Elementos de Usuario
    @FXML private TextField idUsuarioField, nombreUsuarioField, correoUsuarioField, telefonoField, direccionField, saldoField;
    @FXML private TableView<Usuario> tableViewUsuario;
    @FXML private TableColumn<Usuario, String> idUsuarioColumn, nombreUsuarioColumn, correoUsuarioColumn, telefonoColumn, direccionColumn;
    @FXML private TableColumn<Usuario, Double> saldoColumn;
    @FXML private Button btnCrearUsuario, btnEliminarUsuario, btnActualizarUsuario;

    // Elementos de Transacciones
    @FXML private TextField idTransaccionField, tipoField, montoField, descripcioField;
    @FXML private DatePicker fechaPicker;
    @FXML private ChoiceBox<Cuenta> cuentaOrigenBox, cuentaDestinoBox;
    @FXML private ChoiceBox<Categoria> categoriaBox;
    @FXML private TableView<Transaccion> tableViewTransaccion;
    @FXML private TableColumn<Transaccion, String> idTransaccionColumn, tipoColumn, descripcioColumn;
    @FXML private TableColumn<Transaccion, LocalDate> fechaColumn;
    @FXML private TableColumn<Transaccion, Double> montoColumn;
    @FXML private TableColumn<Transaccion, Cuenta> cuentaOrigenColumn, cuentaDestinoColumn;
    @FXML private TableColumn<Transaccion, Categoria> categoriaColumn;
    @FXML private Button btnCrearTransaccion, btnEliminarTransaccion;

    // Elementos de Presupuestos
    @FXML private TextField idPresupuestoField, nombrePresupuestoField, montoTotalField, montoGastadoField;
    @FXML private ChoiceBox<Categoria> presupuestoCategoriaBox;
    @FXML private TableView<Presupuesto> tableViewPresupuesto;
    @FXML private TableColumn<Presupuesto, String> idPresupuestoColumn, nombrePresupuestoColumn;
    @FXML private TableColumn<Presupuesto, Double> montoTotalColumn, montoGastadoColumn;
    @FXML private TableColumn<Presupuesto, Categoria> categoriaPresupuestoColumn;
    @FXML private Button btnCrearPresupuesto, btnEliminarPresupuesto, btnActualizarPresupuesto;

    // Elementos de Cuentas
    @FXML private TextField idCuentaField, bancoField, numeroCuentaField, tipoCuentaField, saldoCuentaField;
    @FXML private ChoiceBox<Usuario> cuentaUsuarioBox;
    @FXML private TableView<Cuenta> tableViewCuenta;
    @FXML private TableColumn<Cuenta, String> idCuentaColumn, bancoColumn, numeroCuentaColumn, tipoCuentaColumn;
    @FXML private TableColumn<Cuenta, Double> saldoCuentaColumn;
    @FXML private TableColumn<Cuenta, Usuario> usuarioCuentaColumn;
    @FXML private Button btnCrearCuenta, btnEliminarCuenta, btnActualizarCuenta;

    private ObservableList<Administrador> listaAdministradores;
    private ObservableList<Categoria> listaCategorias;
    private ObservableList<Usuario> listaUsuarios;
    private ObservableList<Transaccion> listaTransacciones;
    private ObservableList<Presupuesto> listaPresupuestos;
    private ObservableList<Cuenta> listaCuentas;

    @FXML
    public void initialize() {
        // Inicializar listas
        listaAdministradores = FXCollections.observableArrayList(Administrador.obtenerAdministradores());
        listaCategorias = FXCollections.observableArrayList(Categoria.obtenerCategorias());
        listaUsuarios = FXCollections.observableArrayList(Usuario.obtenerUsuarios());
        listaTransacciones = FXCollections.observableArrayList(Transaccion.obtenerTransacciones());
        listaPresupuestos = FXCollections.observableArrayList(Presupuesto.obtenerPresupuestos());
        listaCuentas = FXCollections.observableArrayList(Cuenta.obtenerCuentas());

        // Configurar tablas
        tableViewAdmin.setItems(listaAdministradores);
        tableViewCategoria.setItems(listaCategorias);
        tableViewUsuario.setItems(listaUsuarios);
        tableViewTransaccion.setItems(listaTransacciones);
        tableViewPresupuesto.setItems(listaPresupuestos);
        tableViewCuenta.setItems(listaCuentas);

        // Configurar columnas
        idAdminColumn.setCellValueFactory(new PropertyValueFactory<>("idAdmin"));
        nombreAdminColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correoAdminColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));

        idCategoriaColumn.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        nombreCategoriaColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        idUsuarioColumn.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        nombreUsuarioColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correoUsuarioColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        direccionColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        saldoColumn.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        idTransaccionColumn.setCellValueFactory(new PropertyValueFactory<>("idTransaccion"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cuentaOrigenColumn.setCellValueFactory(new PropertyValueFactory<>("cuentaOrigen"));
        cuentaDestinoColumn.setCellValueFactory(new PropertyValueFactory<>("cuentaDestino"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        idPresupuestoColumn.setCellValueFactory(new PropertyValueFactory<>("idPresupuesto"));
        nombrePresupuestoColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        montoTotalColumn.setCellValueFactory(new PropertyValueFactory<>("montoTotal"));
        montoGastadoColumn.setCellValueFactory(new PropertyValueFactory<>("montoGastado"));
        categoriaPresupuestoColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        idCuentaColumn.setCellValueFactory(new PropertyValueFactory<>("idCuenta"));
        bancoColumn.setCellValueFactory(new PropertyValueFactory<>("banco"));
        numeroCuentaColumn.setCellValueFactory(new PropertyValueFactory<>("numeroCuenta"));
        tipoCuentaColumn.setCellValueFactory(new PropertyValueFactory<>("tipoCuenta"));
        saldoCuentaColumn.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        usuarioCuentaColumn.setCellValueFactory(new PropertyValueFactory<>("usuario"));
    }
    //METODOS DE USUARIO
    @FXML
    private void crearUsuario() {
        Usuario usuario = new Usuario(
                idUsuarioField.getText(),
                nombreUsuarioField.getText(),
                correoUsuarioField.getText(),
                telefonoField.getText(),
                direccionField.getText(),
                Double.parseDouble(saldoField.getText())
        );
        listaUsuarios.add(usuario);
        Usuario.guardarUsuario(usuario);
        limpiarCamposUsuario();
    }

    @FXML
    private void actualizarUsuario() {
        Usuario seleccionado = tableViewUsuario.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(nombreUsuarioField.getText());
            seleccionado.setCorreo(correoUsuarioField.getText());
            seleccionado.setTelefono(telefonoField.getText());
            seleccionado.setDireccion(direccionField.getText());
            seleccionado.setSaldo(Double.parseDouble(saldoField.getText()));
            tableViewUsuario.refresh();
            Usuario.actualizarUsuario(seleccionado);
            limpiarCamposUsuario();
        }
    }

    @FXML
    private void eliminarUsuario() {
        Usuario seleccionado = tableViewUsuario.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaUsuarios.remove(seleccionado);
            Usuario.eliminarUsuario(String.valueOf(seleccionado));
            limpiarCamposUsuario();
        }
    }

    private void limpiarCamposUsuario() {
        idUsuarioField.clear();
        nombreUsuarioField.clear();
        correoUsuarioField.clear();
        telefonoField.clear();
        direccionField.clear();
        saldoField.clear();
    }

    //METODOS CATEGORIA
    @FXML
    private void crearCategoria() {
        Categoria categoria = new Categoria(
                idCategoriaField.getText(),
                nombreCategoriaField.getText(),
                descripcionField.getText()
        );
        listaCategorias.add(categoria);
        Categoria.guardarCategoria(categoria);
        limpiarCamposCategoria();
    }

    @FXML
    private void actualizarCategoria() {
        Categoria seleccionada = tableViewCategoria.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setNombre(nombreCategoriaField.getText());
            seleccionada.setDescripcion(descripcionField.getText());
            tableViewCategoria.refresh();
            Categoria.actualizarCategoria(seleccionada);
            limpiarCamposCategoria();
        }
    }

    @FXML
    private void eliminarCategoria() {
        Categoria seleccionada = tableViewCategoria.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaCategorias.remove(seleccionada);
            Categoria.eliminarCategoria(String.valueOf(seleccionada));
            limpiarCamposCategoria();
        }
    }

    private void limpiarCamposCategoria() {
        idCategoriaField.clear();
        nombreCategoriaField.clear();
        descripcionField.clear();
    }

    //METODOS ADMINISTRADOR
    @FXML
    private void crearAdministrador() {
        Administrador admin = new Administrador(
                idAdminField.getText(),
                nombreAdminField.getText(),
                correoAdminField.getText()
        );
        listaAdministradores.add(admin);
        Administrador.guardarAdministrador(admin);
        limpiarCamposAdministrador();
    }

    @FXML
    private void actualizarAdministrador() {
        Administrador seleccionado = tableViewAdmin.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(nombreAdminField.getText());
            seleccionado.setCorreo(correoAdminField.getText());
            tableViewAdmin.refresh();
            Administrador.actualizarAdministrador(seleccionado);
            limpiarCamposAdministrador();
        }
    }

    @FXML
    private void eliminarAdministrador() {
        Administrador seleccionado = tableViewAdmin.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaAdministradores.remove(seleccionado);
            Administrador.eliminarAdministrador(String.valueOf(seleccionado));
            limpiarCamposAdministrador();
        }
    }

    private void limpiarCamposAdministrador() {
        idAdminField.clear();
        nombreAdminField.clear();
        correoAdminField.clear();
    }

    //METODOS DE CUENTA
    @FXML
    private void crearCuenta() {
        Cuenta cuenta = new Cuenta(
                        idCuentaField.getText(),
                        bancoField.getText(),
                        numeroCuentaField.getText(),
                        tipoCuentaField.getText(),
                cuentaUsuarioBox.getValue(),
                Double.parseDouble(saldoCuentaField.getText())
                );
        listaCuentas.add(cuenta);
        Cuenta.guardarCuenta(cuenta);
        limpiarCamposCuenta();
    }

    @FXML
    private void actualizarCuenta() {
        Cuenta seleccionada = tableViewCuenta.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setBanco(bancoField.getText());
            seleccionada.setNumeroCuenta(numeroCuentaField.getText());
            seleccionada.setTipoCuenta(tipoCuentaField.getText());
            seleccionada.setSaldo(Double.parseDouble(saldoCuentaField.getText()));
            seleccionada.setUsuario(cuentaUsuarioBox.getValue());
            tableViewCuenta.refresh();
            Cuenta.actualizarCuenta(seleccionada);
            limpiarCamposCuenta();
        }
    }

    @FXML
    private void eliminarCuenta() {
        Cuenta seleccionada = tableViewCuenta.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaCuentas.remove(seleccionada);
            Cuenta.eliminarCuenta(String.valueOf(seleccionada));
            limpiarCamposCuenta();
        }
    }

    private void limpiarCamposCuenta() {
        idCuentaField.clear();
        bancoField.clear();
        numeroCuentaField.clear();
        tipoCuentaField.clear();
        saldoCuentaField.clear();
        cuentaUsuarioBox.setValue(null);
    }

    //METODOS PARA TRANSACCION
    @FXML
    private void crearTransaccion() {
        Transaccion transaccion = new Transaccion(
                idTransaccionField.getText(),
                fechaPicker.getValue(),
                tipoField.getText(),
                Double.parseDouble(montoField.getText()),
                descripcionField.getText(),
                cuentaOrigenBox.getValue(),
                cuentaDestinoBox.getValue(),
                categoriaBox.getValue()
        );
        listaTransacciones.add(transaccion);
        Transaccion.guardarTransaccion(transaccion);
        limpiarCamposTransaccion();
    }

    @FXML
    private void eliminarTransaccion() {
        Transaccion seleccionada = tableViewTransaccion.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaTransacciones.remove(seleccionada);
            Transaccion.eliminarTransaccion(String.valueOf(seleccionada));
            limpiarCamposTransaccion();
        }
    }

    private void limpiarCamposTransaccion() {
        idTransaccionField.clear();
        tipoField.clear();
        montoField.clear();
        descripcionField.clear();
        fechaPicker.setValue(null);
        cuentaOrigenBox.setValue(null);
        cuentaDestinoBox.setValue(null);
        categoriaBox.setValue(null);
    }

    //METODOS DE PRESUPUESTO
    @FXML
    private void crearPresupuesto() {
        Presupuesto presupuesto = new Presupuesto(
                idPresupuestoField.getText(),
                nombrePresupuestoField.getText(),
                Double.parseDouble(montoTotalField.getText()),
                Double.parseDouble(montoGastadoField.getText()),
                presupuestoCategoriaBox.getValue()
        );
        listaPresupuestos.add(presupuesto);
        Presupuesto.guardarPresupuesto(presupuesto);
        limpiarCamposPresupuesto();
    }

    @FXML
    private void actualizarPresupuesto() {
        Presupuesto seleccionado = tableViewPresupuesto.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(nombrePresupuestoField.getText());
            seleccionado.setMontoTotal(Double.parseDouble(montoTotalField.getText()));
            seleccionado.setMontoGastado(Double.parseDouble(montoGastadoField.getText()));
            seleccionado.setCategoria(presupuestoCategoriaBox.getValue());
            tableViewPresupuesto.refresh();
            Presupuesto.actualizarPresupuesto(seleccionado);
            limpiarCamposPresupuesto();
        }
    }

    @FXML
    private void eliminarPresupuesto() {
        Presupuesto seleccionado = tableViewPresupuesto.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaPresupuestos.remove(seleccionado);
            Presupuesto.eliminarPresupuesto(String.valueOf(seleccionado));
            limpiarCamposPresupuesto();
        }
    }

    private void limpiarCamposPresupuesto() {
        idPresupuestoField.clear();
        nombrePresupuestoField.clear();
        montoTotalField.clear();
        montoGastadoField.clear();
        presupuestoCategoriaBox.setValue(null);
    }



}