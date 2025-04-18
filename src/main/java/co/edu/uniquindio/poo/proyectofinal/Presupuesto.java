package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Presupuesto {
    private String idPresupuesto;
    private String descripcion;
    private double montoInicial;
    private double montoActual;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Usuario usuario;
    private static List<Presupuesto> presupuestos = new ArrayList<>();
    private Categoria categoria;

    /**
     * Constructor para la clase Presupuesto
     * @param idPresupuesto Identificador único del presupuesto
     * @param descripcion Descripción del presupuesto
     * @param montoInicial Monto inicial del presupuesto
     * @param fechaInicio Fecha de inicio del presupuesto
     * @param fechaFin Fecha de fin del presupuesto
     * @param usuario Usuario al que pertenece el presupuesto
     * @throws IllegalArgumentException si algún parámetro es inválido
     */
    public Presupuesto(String idPresupuesto, String descripcion, double montoInicial,
                       LocalDate fechaInicio, LocalDate fechaFin, Usuario usuario, Categoria categoria) {
        validarParametros(idPresupuesto, descripcion, montoInicial, fechaInicio, fechaFin, usuario, categoria);

        this.idPresupuesto = idPresupuesto;
        this.descripcion = descripcion;
        this.montoInicial = montoInicial;
        this.montoActual = montoInicial;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.categoria = categoria;

    }

    /**
     * Guarda un nuevo presupuesto en la lista
     * @param presupuesto Presupuesto a guardar
     * @throws IllegalArgumentException si el presupuesto ya existe o es nulo
     */
    public static void guardarPresupuesto(Presupuesto presupuesto) {
        if (presupuesto == null) {
            throw new IllegalArgumentException("El presupuesto no puede ser nulo");
        }
        if (existePresupuesto(presupuesto.getIdPresupuesto())) {
            throw new IllegalArgumentException("Ya existe un presupuesto con el ID: " +
                    presupuesto.getIdPresupuesto());
        }
        presupuestos.add(presupuesto);
    }

    /**
     * Verifica si existe un presupuesto con el ID especificado
     * @param idPresupuesto ID del presupuesto a buscar
     * @return true si el presupuesto existe, false en caso contrario
     */
    public static boolean existePresupuesto(String idPresupuesto) {
        return presupuestos.stream()
                .anyMatch(p -> p.getIdPresupuesto().equals(idPresupuesto));
    }

    /**
     * Verifica si el presupuesto está dentro del período actual
     * @return true si el presupuesto está vigente
     */
    public boolean estaVigente() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin);
    }

    private void validarParametros(String idPresupuesto, String descripcion,
                                   double montoInicial, LocalDate fechaInicio,
                                   LocalDate fechaFin, Usuario usuario) {
        if (idPresupuesto == null || idPresupuesto.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del presupuesto no puede estar vacío");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (montoInicial <= 0) {
            throw new IllegalArgumentException("El monto inicial debe ser mayor que cero");
        }
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
    }

    // Getters
    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public static List<Presupuesto> getPresupuestos() {
        return new ArrayList<>(presupuestos);
    }

    // Setters con validaciones
    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        this.descripcion = descripcion;
    }

    public void setMontoInicial(double montoInicial) {
        if (montoInicial <= 0) {
            throw new IllegalArgumentException("El monto inicial debe ser mayor que cero");
        }
        this.montoInicial = montoInicial;
        this.montoActual = montoInicial;
    }

    public void setMontoActual(double montoActual) {
        if (montoActual < 0) {
            throw new IllegalArgumentException("El monto actual no puede ser negativo");
        }
        this.montoActual = montoActual;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula");
        }
        if (fechaFin != null && fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        if (fechaFin == null) {
            throw new IllegalArgumentException("La fecha de fin no puede ser nula");
        }
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }
        this.fechaFin = fechaFin;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        this.usuario = usuario;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public static void setPresupuestos(List<Presupuesto> presupuestos) {
        Presupuesto.presupuestos = presupuestos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "id='" + idPresupuesto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", montoInicial=" + montoInicial +
                ", montoActual=" + montoActual +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", usuario=" + usuario.getNombre() +
                '}';
    }
}
