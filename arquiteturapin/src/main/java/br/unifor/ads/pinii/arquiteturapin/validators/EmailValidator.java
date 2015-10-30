package br.unifor.ads.pinii.arquiteturapin.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.unifor.ads.pinii.arquiteturapin.exception.ValidatorException;


/**
 * @author adrianopatrick@gmail.com
 * @since 30 de out de 2015
 */
public class EmailValidator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
	
	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	public void validate(Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			throw new ValidatorException("Email inválido!");
		}
	}
}
