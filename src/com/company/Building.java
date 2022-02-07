package com.company;

import java.util.ArrayList;

public class Building {

    public String Name;
    public ArrayList<Room> Rooms;

    public Building(String name) {
        Name = name;
        Rooms = new ArrayList<>();
        createBuilding();
    }

    private void createBuilding() {

        for (var i = 0; i < 5; i++)
        {
             Rooms.add(new Mingle(i+1));
        }
        for (var i = 0; i < 20; i++)
        {
            Rooms.add(new Office(i+5));
        }


    }
}
