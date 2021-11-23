package main.java.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity(name = "concursante")
@Table(name = "concursante")
public class Concursante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_concursante")
	private int id_concursante;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "concursante_concurso", joinColumns = {@JoinColumn(name = "id_concursante")}, 
    inverseJoinColumns = {@JoinColumn(name = "id_concurso")}
    )
    private Set<Concurso> concursos;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "puntuacion_total")
	private int puntuacion_total;

	public Concursante() {
		super();
	}

	public Concursante(String nickname, int puntuacion_total) {
		super();
		this.nickname = nickname;
		this.puntuacion_total = puntuacion_total;
	}

	public int getId_concursante() {
		return id_concursante;
	}

	public void setId_concursante(int id_concursante) {
		this.id_concursante = id_concursante;
	}

	public Set<Concurso> getConcursos() {
		return concursos;
	}

	public void setConcursos(Set<Concurso> concursos) {
		this.concursos = concursos;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPuntuacion_total() {
		return puntuacion_total;
	}

	public void setPuntuacion_total(int puntuacion_total) {
		this.puntuacion_total = puntuacion_total;
	}


}
