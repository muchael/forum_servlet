import static org.junit.Assert.*;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import entity.Comentario;
import entity.Topico;
import entity.Usuario;
import service.ForumService;

public class TesteForumService {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/forum-test";
	private static final String DB_USER = "forum";
	private static final String DB_PASSWORD = "forum";
	
	JdbcDatabaseTester jdt;
	ForumService forumService;
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
		
		this.forumService = new ForumService();
	}
	
	@Test
	public void inserirUsuarioTest() {
		Usuario usuario = new Usuario("Maria", "maria@mail.com", "Maria Silva", "456789", 57);
		this.forumService.inserirUsuario(usuario);
		
		IDataSet currentDataSet;
		try {
			currentDataSet = jdt.getConnection().createDataSet();
			ITable currentTable = currentDataSet.getTable("usuario");
			
			FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
			IDataSet expectedDataSet = loader.load("/testInsert.xml");
			
			ITable expectedTable = expectedDataSet.getTable("usuario");
			
			Assertion.assertEquals(expectedTable, currentTable);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void loginTest() throws Exception {
		Usuario usuario = new Usuario( "Marcos", "asdf" );
		this.forumService.login(usuario);
	}
	
	@Test
	public void rankingTest() {
		List<Usuario> ranking = this.forumService.ranking();
		assertEquals(2, ranking.size());
		assertEquals("Marcos", ranking.get(0).getLogin());
	}
	
	@Test
	public void criarTopicoTest() {
		Usuario usuario = new Usuario();
		usuario.setLogin("Pedro");
		
		Topico topico = new Topico(null, "Titulo teste", "Conteúdo teste", usuario);
		this.forumService.criarTopico(topico);
		
		IDataSet currentDataSet;
		try {
			currentDataSet = jdt.getConnection().createDataSet();
			ITable currentTable = currentDataSet.getTable("topico");
			
			FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
			IDataSet expectedDataSet = loader.load("/testCriarTopico.xml");
			
			ITable expectedTable = expectedDataSet.getTable("topico");
			
			Assertion.assertEqualsIgnoreCols(expectedTable, currentTable, new String[] { "id_topico" } );
			
			currentTable = currentDataSet.getTable("usuario");
			expectedTable = expectedDataSet.getTable("usuario");
			
			Assertion.assertEquals(expectedTable, currentTable);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void inserirComentarioTest() {
		Usuario usuario = new Usuario();
		usuario.setLogin("Pedro");
		
		Topico topico = new Topico(1L);
		
		Comentario comentario = new Comentario(topico, "Comentario teste", usuario);
		
		this.forumService.inserirComentario(comentario);
		
		IDataSet currentDataSet;
		try {
			currentDataSet = jdt.getConnection().createDataSet();
			ITable currentTable = currentDataSet.getTable("comentario");
			
			FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
			IDataSet expectedDataSet = loader.load("/testInserirComentario.xml");
			
			ITable expectedTable = expectedDataSet.getTable("comentario");
			
			Assertion.assertEqualsIgnoreCols(expectedTable, currentTable, new String[] { "id_comentario" } );
			
			currentTable = currentDataSet.getTable("usuario");
			expectedTable = expectedDataSet.getTable("usuario");
			
			Assertion.assertEquals(expectedTable, currentTable);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listarTopicosTest() {
		List<Topico> topicos = this.forumService.listarTopicos();
		
		assertFalse( topicos.isEmpty() );
		assertEquals(1L, topicos.get(0).getId_topico().longValue());
	}
	
	@Test
	public void buscaTopicoTest() {
		Topico topico = this.forumService.buscaTopico(1L);
		
		assertNotNull( topico );
		assertEquals(1L, topico.getId_topico().longValue());
	}
}
