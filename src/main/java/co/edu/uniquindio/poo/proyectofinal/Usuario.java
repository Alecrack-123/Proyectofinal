package co.edu.uniquindio.poo.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

        private String idUsuario;
        private String nombre;
        private String correo;
        private String telefono;
        private String direccion;
        private double saldo;
        private List<Cuenta> cuentas;
        private List<Presupuesto> presupuestos;
        private List<Transaccion> transacciones;

    private static List<Usuario> usuarios = new ArrayList<>();

        public Usuario(String idUsuario, String nombre, String correo, String telefono, String direccion, double saldo) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.correo = correo;
            this.telefono = telefono;
            this.direccion = direccion;
            this.saldo = saldo;
            this.cuentas = new ArrayList<>();
            this.presupuestos = new ArrayList<>();
            this.transacciones = new ArrayList<>();
        }

    public static void guardarUsuario(Usuario usuario) {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }

    // CRUD: Crear usuario
    public static void crearUsuario(Usuario usuario) {
        if (usuario == null || buscarUsuarioPorId(usuario.getIdUsuario()) != null) {
            throw new IllegalArgumentException("El usuario ya existe o es inválido.");
        }
        usuarios.add(usuario);
    }

    // CRUD: Buscar usuario por ID
    public static Usuario buscarUsuarioPorId(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    // CRUD: Actualizar usuario
    public static void actualizarUsuario(Usuario usuarioActualizado) {
        Usuario usuarioExistente = buscarUsuarioPorId(usuarioActualizado.getIdUsuario());
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
        usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
        usuarioExistente.setSaldo(usuarioActualizado.getSaldo());
    }

    // CRUD: Eliminar usuario
    public static void eliminarUsuario(String idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        usuarios.remove(usuario);
    }

    // CRUD: Obtener todos los usuarios
    public static List<Usuario> obtenerUsuarios() {
        return new ArrayList<>(usuarios);
    }


}


