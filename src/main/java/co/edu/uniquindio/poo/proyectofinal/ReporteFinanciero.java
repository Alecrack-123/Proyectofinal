package co.edu.uniquindio.poo.proyectofinal;

import java.time.LocalDate;

public class ReporteFinanciero {
    private String tipo;
    private String formato;
    private LocalDate desde;
    private LocalDate hasta;

    public static class Builder {
        private String tipo;
        private String formato;
        private LocalDate desde;
        private LocalDate hasta;

        public Builder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder formato(String formato) {
            this.formato = formato;
            return this;
        }

        public Builder desde(LocalDate desde) {
            this.desde = desde;
            return this;
        }

        public Builder hasta(LocalDate hasta) {
            this.hasta = hasta;
            return this;
        }

        public ReporteFinanciero build() {
            return new ReporteFinanciero(this);
        }
    }

    private ReporteFinanciero(Builder builder) {
        this.tipo = builder.tipo;
        this.formato = builder.formato;
        this.desde = builder.desde;
        this.hasta = builder.hasta;
    }
}
