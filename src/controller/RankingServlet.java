package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import service.ForumService;

/**
 * Servlet implementation class RankingServlet
 */
@WebServlet("/ranking")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ForumService forumService = new ForumService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingServlet() {
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
		
		List<Usuario> ranking = this.forumService.ranking();
		
		request.setAttribute( "ranking", ranking );
		request.getRequestDispatcher("ranking.jsp").forward(request, response);
	}

}
