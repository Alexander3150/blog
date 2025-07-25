package com.umg.blog.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Comentario")
    private Long idComentario;

    @Lob
    @Column(nullable = false)
    private String texto;

    @Column(name = "Fecha_de_comentario", nullable = false)
    private LocalDateTime fechaComentario;

    // Muchos-a-uno con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario autor;

    // Muchos-a-uno con Publicacion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Post", nullable = false)
    private Publicacion publicacion;
    // Constructores
    public Comentario() {}

    public Comentario(String texto, LocalDateTime fechaComentario, Usuario autor, Publicacion publicacion) {
        this.texto = texto;
        this.fechaComentario = fechaComentario;
        this.autor = autor;
        this.publicacion = publicacion;
    }

    // Getters y setters
    public Long getIdComentario() { return idComentario; }
    public void setIdComentario(Long idComentario) { this.idComentario = idComentario; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public LocalDateTime getFechaComentario() { return fechaComentario; }
    public void setFechaComentario(LocalDateTime fechaComentario) { this.fechaComentario = fechaComentario; }

    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }

    public Publicacion getPublicacion() { return publicacion; }
    public void setPublicacion(Publicacion publicacion) { this.publicacion = publicacion; }
}
