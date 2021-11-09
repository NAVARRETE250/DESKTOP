package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_respuesta")
	private int id_respuesta;
	
	@Column(name = "solucion")
	private String solucion;
	
	@ManyToOne()
    @JoinColumn(name = "id_pregunta")
    private Pregunta id_pregunta;
	
	@Column(name = "correcto")
	private boolean correcto;

	public Respuesta() {
		super();
	}

	public Respuesta(String solucion, Pregunta id_pregunta, boolean correcto) {
		super();
		this.solucion = solucion;
		this.id_pregunta = id_pregunta;
		this.correcto = correcto;
	}

	public int getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(int id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public Pregunta getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Pregunta id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}


}
