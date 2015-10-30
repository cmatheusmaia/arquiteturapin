/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.pinii.arquiteturapin.entity.Usuarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de out de 2015
 */
public class UsuarioDAO {

	private EntityManager em;

	public UsuarioDAO() {
		this.em = new EntityManager() {

			@Override
			public Usuarios trataResultSet(ResultSet rs) throws SQLException {
				Usuarios usuario = new Usuarios();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
		};
	}

	public void salvar(Usuarios usuario) throws DAOException {
		em.execute("insert into usuarios (nome, login, senha) values (?, ?, ?)",
				usuario.getNome(), usuario.getLogin(), usuario.getSenha());
	}

	public Usuarios buscarUsuarioPorLoginSenha(Usuarios usuario)
			throws DAOException {
		Usuarios user = null;
		try {
			user = (Usuarios) em.getSingleResult(
					"select * from usuarios where login = ? and senha = ?",
					usuario.getLogin(), usuario.getSenha());
		} catch (DAOException ex) {
			throw new DAOException("Login ou Senha inválidos!", ex.getCause());
		}
		return user;
	}

}
