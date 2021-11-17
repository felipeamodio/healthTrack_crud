package com.br.fiap.testeDao;

import java.util.List;

import com.br.fiap.Usuario;
import com.br.fiap.healthTrack.dao.UsuarioDAO;
import com.br.fiap.exception.DBException;
import com.br.fiap.factory.DAOFactory;


public class UsuarioDAOTeste {
	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getProdutoDAO();
		
		//cadastrar produto
		Usuario usuario = new Usuario("teste", 1, "teste","teste","teste","teste", 1, 1);
		try {
			dao.cadastrar(usuario);
			System.out.println("Usuário cadastrado");
		}catch(DBException e) {
			e.printStackTrace();
		}
		
		//buscar um produto pelo código e atualizar
		usuario = dao.buscar(1);
		usuario.setNomeUsuario("TESTE");
		try {
			dao.atualizar(usuario);
			System.out.println("Produto atualizado");
		}catch(DBException e2) {
			e2.printStackTrace();
		}
		
		//listar os produtos
		List<Usuario> lista = dao.listar();
		for(Usuario item : lista) {
			System.out.println(item.getCodUsuario() + " " + item.getIdUsuario() + " " + item.getNomeUsuario() + " " + item.getPeso() + " " + item.getAltura() + " " + item.getTipoAtividade() + " " + item.getQtdDiasSemana() + " " + item.getCalorias());
		}
		
		try {
			dao.remover(1);
			System.out.println("Produto removido");
		}catch(DBException e3) {
			e3.printStackTrace();
		}
	
	}
}
