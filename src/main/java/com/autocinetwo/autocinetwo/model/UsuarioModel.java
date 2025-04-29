package com.autocinetwo.autocinetwo.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(nullable = false, length = 255)
    private String contraseña;

    @Column(length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Rol rol = Rol.CLIENTE;

    @Column(name = "fecha_registro", columnDefinition = "DATETIME")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public UsuarioModel() {}

    public UsuarioModel(String nombre, String correo, String contraseña, String telefono, Rol rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.rol = rol;
        this.fechaRegistro = LocalDateTime.now();
    }

    public Integer getIdUsuario() {
        return id;
    }
    public void setIdUsuario(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public enum Rol {
        CLIENTE, ADMIN
    }
}

