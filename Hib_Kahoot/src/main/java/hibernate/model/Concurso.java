package hibernate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concurso")
public class Concurso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_concurso")
	private int id_concurso;
	
	@ManyToOne()
	@JoinColumn(name = "id_kahoot")
	private Kahoot id_kahoot;
	
	@ManyToMany(mappedBy = "concursos")
    private Set<Concursante> concursantes;
	
	@Column(name = "ganador")
	private int ganador;
	
	@Column(name = "segundo")
	private int segundo;
	
	@Column(name = "tercero")
	private int tercero;

	public Concurso() {
		super();
	}

	public Concurso(Kahoot id_kahoot, Set<Concursante> concursantes, int ganador, int segundo,
			int tercero) {
		super();
		this.id_kahoot = id_kahoot;
		this.concursantes = concursantes;
		this.ganador = ganador;
		this.segundo = segundo;
		this.tercero = tercero;
	}

	public int getId_concurso() {
		return id_concurso;
	}

	public void setId_concurso(int id_concurso) {
		this.id_concurso = id_concurso;
	}

	public Kahoot getId_kahoot() {
		return id_kahoot;
	}

	public void setId_kahoot(Kahoot id_kahoot) {
		this.id_kahoot = id_kahoot;
	}

	public Set<Concursante> getConcursantes() {
		return concursantes;
	}

	public void setConcursantes(Set<Concursante> concursantes) {
		this.concursantes = concursantes;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public int getTercero() {
		return tercero;
	}

	public void setTercero(int tercero) {
		this.tercero = tercero;
	}
	
	

}
