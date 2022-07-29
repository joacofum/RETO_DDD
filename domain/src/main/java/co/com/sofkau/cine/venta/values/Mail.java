package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail implements ValueObject<String> {
    private final String valor;

    public Mail(String valor) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        this.valor = Objects.requireNonNull(valor);

        if(this.valor.isBlank()){
            throw new IllegalArgumentException("El mail no puede estar en blanco");
        }

        if(this.valor.length() > 200){
            throw new IllegalArgumentException("El nombre no permite mas de 200 caracteres");
        }

        Matcher matcher = pattern.matcher(valor);
        if(!matcher.matches()){
            throw new IllegalArgumentException("El mail ingresado es incorrecto");
        }

    }

    @Override
    public String value() {
        return this.valor;
    }
}
