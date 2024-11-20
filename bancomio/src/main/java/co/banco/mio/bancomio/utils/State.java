package co.banco.mio.bancomio.utils;

import lombok.Getter;

@Getter
public enum State {

    ACTIVE("A"),
    DEACTIVE("I");

    private final String value;

    State(String value) {
        this.value = value;
    }

}
