/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.exception;

import java.sql.SQLException;

/**
 * @author adrianopatrick@gmail.com
 * @since 28 de out de 2015
 */
public class DAOException extends SQLException {

	private static final long serialVersionUID = -2780353996182665471L;

	public DAOException(String msg, Throwable e) {
            super(msg, e);
    }

}
