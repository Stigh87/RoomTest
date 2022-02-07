package com.company;

public class Office extends Room{
    private int Officenr = 0;


    public Office(Integer id) {
        super(id);

        Type = 1;
        Name = "Office" + getNewNr(id);
    }

    private String getNewNr(Integer id) {
        return Integer.toString(id);
    }
}
