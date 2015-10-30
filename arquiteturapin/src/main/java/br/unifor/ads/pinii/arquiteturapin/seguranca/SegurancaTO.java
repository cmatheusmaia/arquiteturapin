/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.seguranca;

import br.unifor.ads.pinii.arquiteturapin.entity.Usuarios;

/**
 * @author adrianopatrick@gmail.com
 * @since 30 de out de 2015
 */
public class SegurancaTO {

	private static Usuarios usuario;

	/**
	 * @return the usuario
	 */
	public static Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public static void setUsuario(Usuarios usuario) {
		SegurancaTO.usuario = usuario;
	}
	
	
}
