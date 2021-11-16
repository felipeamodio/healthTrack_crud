package com.br.fiap.dao;

import com.br.fiap.healthTrack.dao.UsuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.fiap.Usuario;
import com.br.fiap.connection.ConnectionManager;
import com.br.fiap.exception.DBException;

public class OracleProdutoDAO implements UsuarioDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(Usuario usuario) throws DBException{
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO USUARIO ((CD_CADASTRO, ID_USUARIO, NM_USUARIO, VL_PESO, VL_ALTURA, TP_ATV_FISICA, QT_DIAS_SEMANA, QT_CAL_ELIMINAR) VALUES (SQ_USUARIO.NEXTVAL, ?,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getCodUsuario());
			stmt.setInt(2, usuario.getIdUsuario());
			stmt.setString(3, usuario.getNomeUsuario());
			stmt.setString(4, usuario.getPeso());
			stmt.setString(5, usuario.getAltura());
			stmt.setString(6, usuario.getTipoAtividade());
			stmt.setInt(7, usuario.getQtdDiasSemana());
			stmt.setInt(8, usuario.getCalorias());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Eroo ao cadastrar");
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void atualizar(Usuario usuario) throws DBException{
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE USUARIO SET CD_USUARIO = ?, ID_USUARIO = ?, NM_USUARIO = ?, VL_PESO = ?, VL_ALTURA = ?, TP_ATV_FISICA = ?, QT_DIAS_SEMANA = ?, QT_CAL_ELIMINAR =?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getCodUsuario());
			stmt.setInt(2, usuario.getIdUsuario());
			stmt.setString(3, usuario.getNomeUsuario());
			stmt.setString(4, usuario.getPeso());
			stmt.setString(5, usuario.getAltura());
			stmt.setString(6, usuario.getTipoAtividade());
			stmt.setInt(7, usuario.getQtdDiasSemana());
			stmt.executeUpdate();
			stmt.setInt(8, usuario.getCalorias());
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar");
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void remover(int idUsuario) throws DBException{
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM USUARIO WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover");
		}
	}
	
	@Override
	public Usuario buscar(int idUsuario) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM USUARIO WHERE CD_USUARIO = ?");
			stmt.setInt(1, idUsuario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String codUsuario = rs.getString("CD_USUARIO");
				int id_Usuario = rs.getInt("ID_USUARIO");
				String nomeUsuario = rs.getString("NM_USUARIO");
				String peso = rs.getString("VL_PESO");
				String altura = rs.getString("VL_ALTURA");
				String tipoAtividade = rs.getString("TP_ATV_FISICA");
				int qtdDiasSemana = rs.getInt("QT_DIAS_SEMANA");
				int calorias = rs.getInt("QT_CAL_ELIMINAR");
				
				usuario = new Usuario(codUsuario, id_Usuario, nomeUsuario, peso, altura, tipoAtividade, qtdDiasSemana, calorias);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
	
	@Override
	public List<Usuario> listar(){
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM USUARIO");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String codUsuario = rs.getString("CD_USUARIO");
				int id_Usuario = rs.getInt("ID_USUARIO");
				String nomeUsuario = rs.getString("NM_USUARIO");
				String peso = rs.getString("VL_PESO");
				String altura = rs.getString("VL_ALTURA");
				String tipoAtividade = rs.getString("TP_ATV_FISICA");
				int qtdDiasSemana = rs.getInt("QT_DIAS_SEMANA");
				int calorias = rs.getInt("QT_CAL_ELIMINAR");
				
				Usuario usuario = new Usuario(codUsuario, id_Usuario, nomeUsuario, peso, altura, tipoAtividade, qtdDiasSemana, calorias);
				lista.add(usuario);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}
