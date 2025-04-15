package co.edu.uniquindio.poo.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
    private String idPresupuesto;
    private String nombre;
    private double montoTotal;
    private double montoGastado;
    private Categoria categoria;

    private static List<Presupuesto> presupuestos = new ArrayList<>();

    public Presupuesto(String idPresupuesto, String nombre, double montoTotal, double montoGastado, Categoria categoria) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.montoGastado = montoGastado;
        this.categoria = categoria;
    }

    public static void guardarPresupuesto(Presupuesto presupuesto) {
        
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(double montoGastado) {
        this.montoGastado = montoGastado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // CRUD: Crear presupuesto
    public static void crearPresupuesto(Presupuesto presupuesto) {
        if (presupuesto == null || buscarPresupuestoPorId(presupuesto.getIdPresupuesto()) != null) {
            throw new IllegalArgumentException("El presupuesto ya existe o es inválido.");
        }
        presupuestos.add(presupuesto);
    }

    // CRUD: Buscar presupuesto por ID
    public static Presupuesto buscarPresupuestoPorId(String idPresupuesto) {
        for (Presupuesto presupuesto : presupuestos) {
            if (presupuesto.getIdPresupuesto().equals(idPresupuesto)) {
                return presupuesto;
            }
        }
        return null;
    }

    // CRUD: Actualizar presupuesto
    public static void actualizarPresupuesto(Presupuesto presupuestoActualizado) {
        Presupuesto presupuestoExistente = buscarPresupuestoPorId(presupuestoActualizado.getIdPresupuesto());
        if (presupuestoExistente == null) {
            throw new IllegalArgumentException("El presupuesto no existe.");
        }
        presupuestoExistente.setNombre(presupuestoActualizado.getNombre());
        presupuestoExistente.setMontoTotal(presupuestoActualizado.getMontoTotal());
        presupuestoExistente.setMontoGastado(presupuestoActualizado.getMontoGastado());
    }

    // CRUD: Eliminar presupuesto
    public static void eliminarPresupuesto(String idPresupuesto) {
        Presupuesto presupuesto = buscarPresupuestoPorId(idPresupuesto);
        if (presupuesto == null) {
            throw new IllegalArgumentException("El presupuesto no existe.");
        }
        presupuestos.remove(presupuesto);
    }

    // CRUD: Obtener todos los presupuestos
    public static List<Presupuesto> obtenerPresupuestos() {
        return new ArrayList<>(presupuestos);
    }

}
