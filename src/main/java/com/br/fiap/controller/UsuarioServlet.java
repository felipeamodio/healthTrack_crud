package com.br.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.fiap.Usuario;
import com.br.fiap.healthTrack.dao.UsuarioDAO;
import com.br.fiap.exception.DBException;
import com.br.fiap.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	
	@Override
	public void init() throws ServletException{
		super.init();
		dao = DAOFactory.getProdutoDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String acao = request.getParameter("acao");
		
//		switch(acao) {
//		case "listar":
//			List<Usuario> lista = dao.listar();
//			request.setAttribute("usuario", lista);
//			request.getRequestDispatcher("jspAqui.jsp").forward(request, response);
//			break;
//		case "edicao":
//			int id = Integer.parseInt(request.getParameter("codigo"));
//			Usuario usuario = dao.buscar(id);
//			request.setAttribute("usuario", usuario);
//			request.getRequestDispatcher("jsp.jsp").forward(request, response);
//		}
		
		switch(acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form":
			abrirForm(request, response);
			break;
		}
		
	}
	
	private void abrirForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id_Usuario"));
		Usuario usuario = dao.buscar(id);
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("jsp.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<Usuario> lista = dao.listar();
		request.setAttribute("usuario", lista);
		request.getRequestDispatcher("jsp.jsp").forward(request, response);
	}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			String codigo = request.getParameter("codigoUsuario");
			int id = Integer.parseInt(request.getParameter("id_Usuario"));
			String nomeUsuario = request.getParameter("nomeUsario");
			String peso = request.getParameter("peso");
			String altura = request.getParameter("altura");
			String tipoAtividade = request.getParameter("tipoAtividade");
			int qtdDiasSemana = Integer.parseInt(request.getParameter("qtdDiasSemana"));
			int calorias = Integer.parseInt(request.getParameter("calorias"));
			
			Usuario usuario = new Usuario("teste", 2, "teste", "teste", "teste", "teste", 4, 200);
			dao.cadastrar(usuario);
			
			request.setAttribute("msg", "Produto cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
	}

}
