package main.java.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "kahoot")
@Table(name = "kahoot")
public class Kahoot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_kahoot")
	private int id_kahoot;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "categoria")
	private String categoria;
	
    @OneToMany(mappedBy = "id_kahoot", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pregunta> preguntas;
    
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    
    @OneToMany(mappedBy = "id_kahoot", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Concurso> concursos;

	public Kahoot() {
		super();
	}

	public Kahoot(String titulo, String categoria, Usuario id_usuario) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.id_usuario = id_usuario;
	}

	public int getId_kahoot() {
		return id_kahoot;
	}

	public void setId_kahoot(int id_kahoot) {
		this.id_kahoot = id_kahoot;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
    
	
}