package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Topico;
import entity.Usuario;
import service.ForumService;

/**
 * Servlet implementation class CriarTopico
 */
@WebServlet("/criarTopico")
public class CriarTopicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ForumService forumService = new ForumService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarTopicoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ( request.getSession().getAttribute("usuario") == null ) {
			request.setAttribute( "mensagem", "Usuário não autenticado." );
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("criarTopico.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Topico topico = new Topico();
		topico.setTitulo( request.getParameter("titulo") );
		topico.setConteudo( request.getParameter("conteudo") );
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		topico.setCriador(usuario);

		System.out.println( topico );
		
		this.forumService.criarTopico(topico);
		
		request.getRequestDispatcher("listTopicos").forward(request, response);
	}

}
