package entity;

public class Comentario {
	
	private Long id_comentario;
	private String comentario;
	private Usuario usuario;
	private Topico topico;
	
	public Comentario() {
		
	}
	
	public Comentario(Long id_comentario, String comentario, Usuario usuario, Topico topico) {
		this.id_comentario = id_comentario;
		this.comentario = comentario;
		this.usuario = usuario;
		this.topico = topico;
	}

	public Comentario(Topico topico, String comentario, Usuario usuario) {
		this.comentario = comentario;
		this.usuario = usuario;
		this.topico = topico;

	}

	public Long getId_comentario() {
		return id_comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	@Override
	public String toString() {
		return "Comentario [id_comentario=" + id_comentario + ", comentario=" + comentario + ", usuario=" + usuario
				+ ", topico=" + topico + "]";
	}
}
