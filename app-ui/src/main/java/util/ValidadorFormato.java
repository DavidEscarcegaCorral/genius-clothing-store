package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorFormato {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,15}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public ValidadorFormato(){

    }

    /**
     * Verifica si un string tiene el formato correcto de un correo electrónico.
     * * @param email El correo a validar.
     * @return true si tiene formato de email válido, false en caso contrario.
     */
    public static boolean esEmailValido(String email){
        if (email == null || email.trim().isEmpty()){
            return false;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return true;
    }

    public static boolean esContraseñaValido(String contraseña){
        return contraseña != null;
    }
}
