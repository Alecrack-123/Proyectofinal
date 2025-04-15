package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaccion {
    private String idTransaccion;
    private LocalDate fecha;
    private String tipo; // deposito, retiro, transferencia
    private double monto;
    private String descripcion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private Categoria categoria;

    private static List<Transaccion> transacciones = new ArrayList<>();

    public Transaccion(String idTransaccion, LocalDate fecha, String tipo, double monto, String descripcion, Cuenta cuentaOrigen, Cuenta cuentaDestino, Categoria categoria) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.categoria = categoria;

    }

    public static void guardarTransaccion(Transaccion transaccion) {
        
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // CRUD: Crear transacción
    public static void crearTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula.");
        }
        transacciones.add(transaccion);
    }

    // CRUD: Buscar transacción por ID
    public static Transaccion buscarTransaccionPorId(String idTransaccion) {
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getIdTransaccion().equals(idTransaccion)) {
                return transaccion;
            }
        }
        return null;
    }

    // CRUD: Eliminar transacción
    public static void eliminarTransaccion(String idTransaccion) {
        Transaccion transaccion = buscarTransaccionPorId(idTransaccion);
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no existe.");
        }
        transacciones.remove(transaccion);
    }

    // CRUD: Obtener todas las transacciones
    public static List<Transaccion> obtenerTransacciones() {
        return new ArrayList<>(transacciones);
    }

}




