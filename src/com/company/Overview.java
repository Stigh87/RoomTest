package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Overview {
    private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    public static Integer command = null;

    Building building1 = new Building("MyBuilding");

    public void overview() throws IOException {

        var menu = true;

        //console.readLine(); kan nå brukes i en ny variabel eller direkte i metoder.

        while(menu)
        {
            printMenuOvweview();
            command = Integer.parseInt(console.readLine());
            var menu2Int = command;
            if(menu2Int > 0 && menu2Int < 3) printRoomOverview(menu2Int);
            else printMenuOvweview();
            command = Integer.parseInt(console.readLine());
            System.out.println("command:  " +command);
            var menu3Int = command;
            System.out.println("menu3Int:  " +menu3Int);
            if(menu3Int > 0 && menu3Int < 4) printRoomEdit(menu3Int, menu2Int);
            else printMenuOvweview();
        }

    }

    private void printRoomEdit(int choice, int roomType) throws IOException {
        // 1 rename - 2 remove - 3 add new:
        if(choice == 3){
            if(roomType == 1) {building1.Rooms.add(new Office(getNewId(1))); System.out.println("New office has been added");}
            if(roomType == 2) {building1.Rooms.add(new Mingle(getNewId(2))); System.out.println("New mingle area has been added");}
        }
        else if(choice == 2) {
            System.out.println("Type the ID of the room you wish to remove");
            command = Integer.parseInt(console.readLine());
            for (var i = 0; i < building1.Rooms.size(); i++)
            {
                var roomI = building1.Rooms.get(i).Id;
                if(roomI == command) {
                    System.out.println(building1.Rooms.get(i).Id + " - " + building1.Rooms.get(i).Name +" Has been removed");
                    building1.Rooms.remove(i);
                }
            }
        }
        else if (choice == 1) {
            System.out.println("Type the ID of the room you wish to rename");
            command = Integer.parseInt(console.readLine());
            System.out.println("valgt rom: " +command);
            for (var i = 0; i < building1.Rooms.size(); i++)
            {
                var roomI = building1.Rooms.get(i).Id;
                if(roomI == command) {
                    System.out.println(building1.Rooms.get(i).Name + " Write a new name for this room: ");
                    var newRoomName = console.readLine();
                    building1.Rooms.get(i).Name = newRoomName;
                    System.out.println("The room has been renamed to: " +building1.Rooms.get(i).Name);
                }
            }
        }
    }

    private Integer getNewId(int type) {
        var newId = building1.Rooms.size();
        return newId;
    }

    private void printRoomOverview(int menu2Int) {

        for (var room: building1.Rooms)
        {
            if(room.Type == menu2Int) {System.out.println(room.Id + " - " + room.Name);}
        }
        System.out.println("1.Change name - 2.Remove - 3.Add new - 0. Go back");
    }

    private void printMenuOvweview()
    {
        var OfficeCount = 0;
        var MingleCount = 0;

        for (var room:building1.Rooms)
        {
            if (room.Type == 1) OfficeCount++;
            if (room.Type == 2) MingleCount++;
        }
        System.out.println("Overview of " + building1.Name);
        System.out.println("Offices: " + OfficeCount);
        System.out.println("Mingle Areas: " +MingleCount);
        System.out.println("1.Look at offices - 2.Look at mingle areas");
    }





}
