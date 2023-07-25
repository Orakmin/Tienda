package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private long idUsuario;
    private String username; 
    private String password; 
    private String nombre ;
    private String apellidos; 
    private String correo;
    private String telefono; 
    private boolean ruta_Imagen; 

    @OneToMany
    @JoinColumn(name ="id_usuario")
    private List<Rol> roles;
    
    
}
