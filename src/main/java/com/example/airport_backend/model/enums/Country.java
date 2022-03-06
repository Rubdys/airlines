package com.example.airport_backend.model.enums;


public enum Country {
    PL("Poland"),
    ES("Spain"),
    DE("Germany"),
    PT("Portugal");

    private String fullName;

    Country(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public static Country fromString(String text) {
        for (Country c : Country.values()) {
            if (c.getFullName().equals(text)) {
                return c;
            }
        }
        return null;
    }
}
