package co.edu.uniquindio.poo.proyectofinal;

public class PDFBoxAdapter implements Exportador {
    private ExportadorPDFBox pdfBox = new ExportadorPDFBox();

    public void exportar(String contenido) {
        pdfBox.crearPDF(contenido);
    }
}
