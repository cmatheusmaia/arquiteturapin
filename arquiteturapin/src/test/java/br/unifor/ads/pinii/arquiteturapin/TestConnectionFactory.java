/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import br.unifor.ads.pinii.arquiteturapin.dao.ConnectionFactory;

/**
 * @author adrianopatrick@gmail.com
 * @since 28 de out de 2015
 */
public class TestConnectionFactory {

	@Test
	public void testGetConnection() {
		try {
			for (int i = 0; i < 15; i++) {
				Connection conn = ConnectionFactory.getConnection();
				assertNotNull("veio null", conn);
				conn.close();
			}
			Thread.sleep(60000);
		} catch (SQLException e) {
			fail("Exceção lançada");
		} catch (InterruptedException e) {
			fail("Exceção lançada interrupted");
		}
		
	}

}
