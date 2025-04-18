package co.edu.uniquindio.poo.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private String nombre;
    private String correo;

    private static List<Administrador> administradores = new ArrayList<>();

    public Administrador(String idAdmin, String nombre) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public static void guardarAdministrador(Administrador admin) {
        
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

    public static List<Administrador> getAdministradores() {
        return administradores;
    }

    public static void setAdministradores(List<Administrador> administradores) {
        Administrador.administradores = administradores;
    }

    // CRUD: Crear administrador
    public static void crearAdministrador(Administrador administrador) {
        if (administrador == null || buscarAdministradorPorId(administrador.getCorreo()) != null) {
            throw new IllegalArgumentException("El administrador ya existe o es inválido.");
        }
        administradores.add(administrador);
    }

    // CRUD: Buscar administrador por ID
    public static Administrador buscarAdministradorPorId(String correo) {
        for (Administrador administrador : administradores) {
            if (administrador.getCorreo().equals(correo)) {
                return administrador;
            }
        }
        return null;
    }

    // CRUD: Actualizar administrador
    public static void actualizarAdministrador(Administrador administradorActualizado) {
        Administrador administradorExistente = buscarAdministradorPorId(administradorActualizado.getCorreo());
        if (administradorExistente == null) {
            throw new IllegalArgumentException("El administrador no existe.");
        }
        administradorExistente.setNombre(administradorActualizado.getNombre());
        administradorExistente.setCorreo(administradorActualizado.getCorreo());
    }

    // CRUD: Eliminar administrador
    public static void eliminarAdministrador(String idAdmin) {
        Administrador administrador = buscarAdministradorPorId(idAdmin);
        if (administrador == null) {
            throw new IllegalArgumentException("El administrador no existe.");
        }
        administradores.remove(administrador);
    }

    // CRUD: Obtener todos los administradores
    public static List<Administrador> obtenerAdministradores() {
        return new ArrayList<>(administradores);
    }

    public void gestionarUsuarios() {
        // Lógica de administración
    }

    public void gestionarCuentas() {
        // Lógica de administración
    }

    public void verEstadisticas() {
        // Mostrar estadísticas
    }


}
