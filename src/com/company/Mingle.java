package com.company;

public class Mingle extends Room{

    public Mingle(Integer id) {
        super(id);

        Type = 2;
        Name = "Mingle" + getNewNr(id);
    }

    private String getNewNr(Integer id) {
        return Integer.toString(id);
    }
}
