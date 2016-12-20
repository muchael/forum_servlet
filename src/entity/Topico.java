package entity;

import java.util.ArrayList;
import java.util.List;

public class Topico {
	
	private Long id_topico;
	private String titulo;
	private String conteudo;
	private Usuario criador;
	
	private List<Comentario> comentarios = new ArrayList<>();

	public Topico() {
		super();
	}
	
	public Topico(Long id_topico, String titulo, String conteudo, Usuario criador) {
		super();
		this.id_topico = id_topico;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.criador = criador;
	}

	public Topico(Long id) {
		this.id_topico = id;
	}

	public Long getId_topico() {
		return id_topico;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public Usuario getCriador() {
		return criador;
	}
	public void setId_topico(Long id_topico) {
		this.id_topico = id_topico;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Topico [id_topico=" + id_topico + ", titulo=" + titulo + ", conteudo=" + conteudo + ", criador="
				+ criador + "]";
	}
}
