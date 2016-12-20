package model;
import java.util.List;

import entity.Comentario;
import entity.Topico;

public interface TopicoDAO {
   
   //insere um novo tópico no banco de dados
   public void inserirTopico(Topico t);
   
   //recupera o tópico pelo seu id
   public Topico recuperar(Long id);
   
   //Lista os tópicos
   public List<Topico> listar();
   
   //insere um novo comentário no banco de dados
   public void inserirComentario(Comentario c);

}