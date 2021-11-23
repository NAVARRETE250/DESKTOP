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

@Entity(name = "pregunta")
@Table(name = "pregunta")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pregunta")
	private int id_pregunta;
	
	@Column(name = "enunciado")
	private String enunciado;
	
	@ManyToOne()
    @JoinColumn(name = "id_kahoot")
    private Kahoot id_kahoot;
	
	@OneToMany(mappedBy = "id_pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas;

	public Pregunta() {
		super();
	}

	public Pregunta(String enunciado, Kahoot id_kahoot) {
		super();
		this.enunciado = enunciado;
		this.id_kahoot = id_kahoot;
	}
	
	public Pregunta(String enunciado) {
		super();
		this.enunciado = enunciado;
	}

	public int getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Kahoot getId_kahoot() {
		return id_kahoot;
	}

	public void setId_kahoot(Kahoot id_kahoot) {
		this.id_kahoot = id_kahoot;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	

}
