package co.edu.uniquindio.poo.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String idCuenta;
    private String banco;
    private String numeroCuenta;
    private String tipoCuenta;
    private Usuario usuario;
    private double saldo;

    private static List<Cuenta> cuentas = new ArrayList<>();

    public Cuenta(String idCuenta, String banco, String numeroCuenta, String tipoCuenta, Usuario usuario,double saldo) {
        this.idCuenta = idCuenta;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.usuario = usuario;
    }

    public static void guardarCuenta(Cuenta cuenta) {
        
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // CRUD: Crear cuenta
    public static void crearCuenta(Cuenta cuenta) {
        if (cuenta == null || buscarCuentaPorId(cuenta.getIdCuenta()) != null) {
            throw new IllegalArgumentException("La cuenta ya existe o es inválida.");
        }
        cuentas.add(cuenta);
    }

    // CRUD: Buscar cuenta por ID
    public static Cuenta buscarCuentaPorId(String idCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    // CRUD: Actualizar cuenta
    public static void actualizarCuenta(Cuenta cuentaActualizada) {
        Cuenta cuentaExistente = buscarCuentaPorId(cuentaActualizada.getIdCuenta());
        if (cuentaExistente == null) {
            throw new IllegalArgumentException("La cuenta no existe.");
        }
        cuentaExistente.setBanco(cuentaActualizada.getBanco());
        cuentaExistente.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
        cuentaExistente.setTipoCuenta(cuentaActualizada.getTipoCuenta());
        cuentaExistente.setSaldo(cuentaActualizada.getSaldo());
    }

    // CRUD: Eliminar cuenta
    public static void eliminarCuenta(String idCuenta) {
        Cuenta cuenta = buscarCuentaPorId(idCuenta);
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no existe.");
        }
        cuentas.remove(cuenta);
    }

    // CRUD: Obtener todas las cuentas
    public static List<Cuenta> obtenerCuentas() {
        return new ArrayList<>(cuentas);
    }

}

