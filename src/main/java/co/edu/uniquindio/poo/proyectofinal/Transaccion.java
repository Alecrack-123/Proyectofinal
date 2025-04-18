package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaccion {
    private String idTransaccion;
    private LocalDate fecha;
    private TipoTransaccion tipo;
    private double monto;
    private String descripcion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private Categoria categoria;
    private static List<Transaccion> transacciones = new ArrayList<>();

    public enum TipoTransaccion {
        DEPOSITO("Depósito"),
        RETIRO("Retiro"),
        TRANSFERENCIA("Transferencia");

        private final String descripcion;

        TipoTransaccion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    /**
     * Constructor para la clase Transaccion
     */
    public Transaccion(String idTransaccion, LocalDate fecha, TipoTransaccion tipo,
                       double monto, String descripcion, Cuenta cuentaOrigen,
                       Cuenta cuentaDestino, Categoria categoria) {
        validarParametros(idTransaccion, fecha, tipo, monto, descripcion,
                cuentaOrigen, cuentaDestino, categoria);

        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.categoria = categoria;
    }

    /**
     * Ejecuta la transacción según su tipo
     */
    public void ejecutarTransaccion() {
        switch (tipo) {
            case DEPOSITO:
                ejecutarDeposito();
                break;
            case RETIRO:
                ejecutarRetiro();
                break;
            case TRANSFERENCIA:
                ejecutarTransferencia();
                break;
        }
        transacciones.add(this);
    }

    private void ejecutarDeposito() {
        if (cuentaDestino == null) {
            throw new IllegalStateException("La cuenta destino es requerida para un depósito");
        }
        cuentaDestino.depositar(monto);
    }

    private void ejecutarRetiro() {
        if (cuentaOrigen == null) {
            throw new IllegalStateException("La cuenta origen es requerida para un retiro");
        }
        cuentaOrigen.retirar(monto);
    }

    private void ejecutarTransferencia() {
        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new IllegalStateException("Se requieren ambas cuentas para una transferencia");
        }
        cuentaOrigen.retirar(monto);
        cuentaDestino.depositar(monto);
    }

    /**
     * Busca una transacción por su ID
     */
    public static Transaccion buscarTransaccion(String idTransaccion) {
        return transacciones.stream()
                .filter(t -> t.getIdTransaccion().equals(idTransaccion))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene las transacciones de una cuenta específica
     */
    public static List<Transaccion> obtenerTransaccionesPorCuenta(Cuenta cuenta) {
        return transacciones.stream()
                .filter(t -> t.getCuentaOrigen() == cuenta || t.getCuentaDestino() == cuenta)
                .toList();
    }

    private void validarParametros(String idTransaccion, LocalDate fecha,
                                   TipoTransaccion tipo, double monto,
                                   String descripcion, Cuenta cuentaOrigen,
                                   Cuenta cuentaDestino, Categoria categoria) {
        if (idTransaccion == null || idTransaccion.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de transacción no puede estar vacío");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de transacción no puede ser nulo");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }

        switch (tipo) {
            case DEPOSITO:
                if (cuentaDestino == null) {
                    throw new IllegalArgumentException("Se requiere cuenta destino para un depósito");
                }
                break;
            case RETIRO:
                if (cuentaOrigen == null) {
                    throw new IllegalArgumentException("Se requiere cuenta origen para un retiro");
                }
                break;
            case TRANSFERENCIA:
                if (cuentaOrigen == null || cuentaDestino == null) {
                    throw new IllegalArgumentException("Se requieren ambas cuentas para una transferencia");
                }
                if (cuentaOrigen == cuentaDestino) {
                    throw new IllegalArgumentException("Las cuentas origen y destino no pueden ser la misma");
                }
                break;
        }

        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
    }

    // Getters
    public String getIdTransaccion() {
        return idTransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public static List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id='" + idTransaccion + '\'' +
                ", fecha=" + fecha +
                ", tipo=" + tipo.getDescripcion() +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", cuentaOrigen=" + (cuentaOrigen != null ? cuentaOrigen.getIdCuenta() : "N/A") +
                ", cuentaDestino=" + (cuentaDestino != null ? cuentaDestino.getIdCuenta() : "N/A") +
                ", categoria=" + categoria.getNombre() +
                '}';
    }
}
