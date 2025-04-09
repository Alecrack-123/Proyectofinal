package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;

public class CreadorRetiro extends CreadorTransaccion{
    @Override
    public Transaccion crearTransaccion(String id, LocalDate fecha, double monto, String descripcion, Cuenta origen, Cuenta destino, Categoria categoria) {
        return new Transaccion(id, fecha, "retiro", monto, descripcion, origen, destino, categoria);
    }
}
