/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.bo;

import org.apache.log4j.Logger;

import br.unifor.ads.pinii.arquiteturapin.dao.UsuarioDAO;
import br.unifor.ads.pinii.arquiteturapin.entity.Usuarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;
import br.unifor.ads.pinii.arquiteturapin.seguranca.SegurancaTO;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de out de 2015
 */
public class UsuarioBO {

	private Logger logger = Logger.getLogger(UsuarioBO.class);
	private UsuarioDAO usuarioDAO;
	
	public UsuarioBO() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	public void salvar(Usuarios usuario) throws DAOException{
		try {
			//TODO criptografar a senha
			this.usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public boolean loggar(Usuarios usuario) throws DAOException{
		Usuarios user;
		try {
			user = this.usuarioDAO.buscarUsuarioPorLoginSenha(usuario);
			if(user != null){
				SegurancaTO.setUsuario(user);
			}
		} catch (DAOException e) {
			logger.error(e.getMessage(), e);
			System.out.println(e.getCause().getMessage());
			throw e;
		}
		return user != null;
	}
	
	
}
