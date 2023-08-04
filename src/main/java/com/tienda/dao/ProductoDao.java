package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author PC MASTER
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {

   
    //Ejemplo de método utilizando consultas ampliadas
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Ejemplo de método utilizando consultas JPQL
    @Query(value="SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
    
    //Ejemplo de método utilizando consultas SQL
    @Query(nativeQuery=true,value="SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaSQL(double precioInf, double precioSup);
    
}
