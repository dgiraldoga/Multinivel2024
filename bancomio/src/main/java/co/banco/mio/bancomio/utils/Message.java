package co.banco.mio.bancomio.utils;
import lombok.Getter;

@Getter
public enum Message {

    OBJECT_NULL ("El objeto requerido no puede ser nulo"),
    SIZE_ID("El identificador no cumple con el tamaño de %d digitos"),
    SIZE_DESCRIPTION("El texto no cumple con la cantidad %d caracteres"),
    PROYECT_ID("Identificador de la tarjeta no se reconoce"),
    DEPENDENT_ID("El %d no es un identificador valido"),
    TYPE_USAGE("El %d no es un tipo de uso valido [ 0 - Integracion, 1 - Uso Pago ]");



    private final String message;

    Message(String message) {
        this.message = message;
    }

}
