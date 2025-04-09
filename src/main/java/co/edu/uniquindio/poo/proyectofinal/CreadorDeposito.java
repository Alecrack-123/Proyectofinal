package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;

public class CreadorDeposito extends CreadorTransaccion{
    @Override
    public Transaccion crearTransaccion(String id, LocalDate fecha, double monto, String descripcion, Cuenta origen, Cuenta destino, Categoria categoria) {
        return new Transaccion(id, fecha, "deposito", monto, descripcion, origen, destino, categoria);
    }
}
