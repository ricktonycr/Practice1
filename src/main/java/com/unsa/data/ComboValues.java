package com.unsa.data;

public enum ComboValues {
    SUMAR("A + B"),
    RESTAR("A - B"),
    PROMEDIAR("(A + B) / 2"),
    FACTOR("a*A + (1-a)*B"),
    MULTIPLICAR("A*B*a");
    private String label;
    private ComboValues(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
