package co.edu.uniquindio.poo.proyectofinal;

public class ReportePDF extends ReporteDecorator{
    public ReportePDF(Reporte decorado) {
        super(decorado);
    }

    @Override
    public void generar() {
        super.generar();
        System.out.println("Exportando a PDF...");
    }
}

