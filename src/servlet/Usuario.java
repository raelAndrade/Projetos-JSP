package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansJsp.BeanJsp;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public Usuario() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");
			if(acao.equalsIgnoreCase("delete")) {
				daoUsuario.delete(user);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}
			else if(acao.equalsIgnoreCase("editar")) {
				BeanJsp usuario = daoUsuario.consultar(user);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", usuario);
				view.forward(request, response);
			}else if(acao.equalsIgnoreCase("Listartodos")) {
				
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {		
			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			
			BeanJsp usuario = new BeanJsp();
			usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			
			if(id == null || id.isEmpty()) {
				daoUsuario.salvar(usuario);
			}else {
				daoUsuario.atualizar(usuario);
			}
			
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
