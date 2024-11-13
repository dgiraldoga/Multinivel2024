package co.banco.mio.bancomio.utils;

public class Fare {

    public static Integer fareValue (int year) {
        return switch (year) {
            case 2024 -> 2900;
            case 2023 -> 2700;
            case 2022 -> 2500;
            default -> 0;
        };
    }
}
