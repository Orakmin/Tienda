package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;
    
    public Producto() {

    }

    public Producto(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

}
