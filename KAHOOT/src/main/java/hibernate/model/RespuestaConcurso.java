package main.java.hibernate.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity(name = "respuesta_concurso")
@Table(name = "respuesta_concurso")
public class RespuestaConcurso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_respuesta_concurso")
	private int id_respuesta_concurso;
	
	@ManyToOne()
    @JoinColumn(name = "id_respuesta")
    private Respuesta id_respuesta;
	
	@ManyToOne()
    @JoinColumn(name = "id_concursante")
    private Concursante id_concursante;
	

	public RespuestaConcurso(Respuesta id_respuesta, Concursante id_concursante) {
		super();
		this.id_concursante = id_concursante;
		this.id_respuesta = id_respuesta;
	}

	public int getId_respuesta_concurso() {
		return id_respuesta_concurso;
	}

	public void setId_respuesta_concurso(int id_respuesta_concurso) {
		this.id_respuesta_concurso = id_respuesta_concurso;
	}

	public Concursante getConcursanteId() {
		return id_concursante;
	}
	
	public Respuesta getRespuestaId() {
		return id_respuesta;
	}

}
