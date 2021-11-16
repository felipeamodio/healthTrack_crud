package com.br.fiap.factory;

import com.br.fiap.dao.OracleProdutoDAO;
import com.br.fiap.healthTrack.dao.UsuarioDAO;

public class DAOFactory {
	public static UsuarioDAO getProdutoDAO() {
		return new OracleProdutoDAO();
	}
}
