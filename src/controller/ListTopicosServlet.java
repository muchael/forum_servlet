package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Topico;
import service.ForumService;

/**
 * Servlet implementation class ListTopicos
 */
@WebServlet("/listTopicos")
public class ListTopicosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ForumService forumService = new ForumService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTopicosServlet() {
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
		
		List<Topico> topicos = this.forumService.listarTopicos();
		
		request.setAttribute( "topicos", topicos );
		request.getRequestDispatcher("listTopicos.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
