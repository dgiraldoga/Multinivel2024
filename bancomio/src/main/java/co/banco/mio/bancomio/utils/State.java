package co.banco.mio.bancomio.utils;

import lombok.Getter;

@Getter
public enum State {

    ACTIVE('A'),
    INACTIVE('I');

    private final Character value;

    State(char value) {
        this.value = value;
    }

}
