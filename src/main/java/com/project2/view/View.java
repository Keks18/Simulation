package com.project2.view;

public enum View {
    H("H"),
    P("P"),
    G("G"),
    R("R"),
    T("T");

    private final String value;

    View(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
