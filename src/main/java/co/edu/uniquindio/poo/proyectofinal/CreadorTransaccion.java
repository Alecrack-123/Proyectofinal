package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;

public abstract class CreadorTransaccion {
    public abstract Transaccion crearTransaccion(String id, LocalDate fecha, double monto, String descripcion, Cuenta origen, Cuenta destino, Categoria categoria);
}


