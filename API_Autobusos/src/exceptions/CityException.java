package exceptions;

import java.util.Arrays;
import java.util.List;

public class CityException extends Exception{
private int code;
	
    // Exception codes
    public static final int BARRIO_NOMBRE_INCOR = 0;
    public static final int TIPO_INQ_INCOR = 1;
    public static final int PROF_INQ_INCOR = 2;
    public static final int NUM_INQ_INCOR = 3;
    public static final int PRECIO_ALQ_INCOR = 4;
    public static final int CASA_NOT_FOUND = 5;
    public static final int INQ_NOT_FOUND = 6;
    public static final int INQ_NO_ADMIT = 7;
    public static final int NO_MORE_INQ = 8;
    public static final int PROF_NO_ADMIT = 9;
    public static final int CASA_HABITADA = 10;
    public static final int NOT_FOUND_ERROR = 11;
    
    // Exception messages
    private final List<String> messages = Arrays.asList(
    		"< Nombre de Barrio incorrecto >",
    		"< Tipo de Inquilino incorrecto >",
    		"< Profesión de Inquilino incorrecta >",
    		"< Número de inquilinos incorrecto >",
    		"< Precio de alquiler incorrecto >",
    		"< Casa no encontrado >",
    		"< Inquilino no encontrado >",
    		"< Inquilino no admitido en el Barrio>",
    		"< No caben más inquilinos >",
    		"< Profesión no admitida en el Barrio >",
    		"< Casa habitada, no se puede destruir >",
    		"< Error no encontrado >");
    
    public CityException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return messages.get(this.code);
    }
}
