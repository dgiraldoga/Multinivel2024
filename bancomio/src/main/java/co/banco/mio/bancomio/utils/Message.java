package co.banco.mio.bancomio.utils;
import lombok.Getter;

@Getter
public enum Message {

    OBJECT_NULL ("El objeto requerido no puede ser nulo"),
    SIZE_ID("El identificador no cumple con el tamaño de %d digitos"),
    SIZE_DESCRIPTION("El texto no cumple con la cantidad %d caracteres"),
    PROYECT_ID("Identificador de la tarjeta no se reconoce"),
    DEPENDENT_ID("El %d no es un identificador valido"),
    TARJETA_EN_ESTADO("La tarjeta %d - %s se encuentra en estado %s - %s"),
    NO_EXISTE_TARJETA_X_ID("No se encontró la Tarjeta con Id: %d"),
    USUARIO_EN_ESTADO("El usuario %d - %s se encuentra en estado %s - %s"),
    NO_EXISTE_USUARIO_X_ID("No se encontró el usuario con Id: %d");



    private final String message;

    Message(String message) {
        this.message = message;
    }

}
