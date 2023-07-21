package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
 
    //Se declara un método para obtener un ArrayList de Objetos Producto
    //Los objetos vienen de la tabla producto...
    //Son todos los registros o sólo los activos.
    public List<Producto> getProductos(boolean activos);
    
    //Abajo se colocarán los métodos para un CRUD de productos... pero en semana 6...
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

//Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);


}
