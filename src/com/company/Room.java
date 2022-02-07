package com.company;

public class Room {

    public int Id;
    public String Name;
    protected int Type;

    public Room(Integer id)
    {
        Id =  id; //NewRoomId();? Eller blir det laget i new room evt oppretting av spesifikt rom?
    }


}
