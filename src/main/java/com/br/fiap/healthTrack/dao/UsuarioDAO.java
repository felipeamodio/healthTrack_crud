package com.br.fiap.healthTrack.dao;

import java.util.List;
import com.br.fiap.Usuario;
import com.br.fiap.exception.DBException;


public interface UsuarioDAO {
	
	void cadastrar(Usuario usuario) throws DBException;
	void atualizar(Usuario usuario) throws DBException;
	void remover(int idUsuario) throws DBException;
	Usuario buscar(int idUsuario);
	List<Usuario> listar();
}
