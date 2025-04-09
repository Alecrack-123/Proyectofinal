package co.edu.uniquindio.poo.proyectofinal;

public class AdministradorSistema {
        private static AdministradorSistema instancia;

        private AdministradorSistema() {
            // Constructor privado
        }

        public static AdministradorSistema getInstancia() {
            if (instancia == null) {
                instancia = new AdministradorSistema();
            }
            return instancia;
        }

        public void mostrarResumenSistema() {
            System.out.println("Mostrando resumen del sistema...");
        }
    }


