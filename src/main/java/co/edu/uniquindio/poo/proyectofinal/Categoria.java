package co.edu.uniquindio.poo.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String idCategoria;
    private String nombre;
    private String descripcion;

    private static List<Categoria> categorias = new ArrayList<>();

    public Categoria(String idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public static void guardarCategoria(Categoria categoria) {
        
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // CRUD: Crear categoría
    public static void crearCategoria(Categoria categoria) {
        if (categoria == null || buscarCategoriaPorId(categoria.getIdCategoria()) != null) {
            throw new IllegalArgumentException("La categoría ya existe o es inválida.");
        }
        categorias.add(categoria);
    }

    // CRUD: Buscar categoría por ID
    public static Categoria buscarCategoriaPorId(String idCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getIdCategoria().equals(idCategoria)) {
                return categoria;
            }
        }
        return null;
    }

    // CRUD: Actualizar categoría
    public static void actualizarCategoria(Categoria categoriaActualizada) {
        Categoria categoriaExistente = buscarCategoriaPorId(categoriaActualizada.getIdCategoria());
        if (categoriaExistente == null) {
            throw new IllegalArgumentException("La categoría no existe.");
        }
        categoriaExistente.setNombre(categoriaActualizada.getNombre());
        categoriaExistente.setDescripcion(categoriaActualizada.getDescripcion());
    }

    // CRUD: Eliminar categoría
    public static void eliminarCategoria(String idCategoria) {
        Categoria categoria = buscarCategoriaPorId(idCategoria);
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no existe.");
        }
        categorias.remove(categoria);
    }

    // CRUD: Obtener todas las categorías
    public static List<Categoria> obtenerCategorias() {
        return new ArrayList<>(categorias);
    }
}
