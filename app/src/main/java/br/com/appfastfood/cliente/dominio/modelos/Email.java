package br.com.appfastfood.cliente.dominio.modelos;

import br.com.appfastfood.cliente.exceptions.FormatoEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;
    public String getEmail() {
        return email;
    }
    public Email(String email) {
        validarEmail(email);
        this.email = email;
    }

    private void validarEmail(String email) {
        Matcher matcher = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matcher(email);
        if(!matcher.matches()) {
            throw new FormatoEmailException();
        }
    }



}