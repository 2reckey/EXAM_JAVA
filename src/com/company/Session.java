package com.company;

import java.util.ArrayList;

public class Session {
    int id;
    String time;
    Film film;
    int[] hall;

    public Session(int id, Film film, String time, int hall_size) {
        hall = new int[hall_size];
        this.time = time;
        this.film = film;
        this.id = id;
    }

    public void ShowHall() {
        System.out.println("Выберите Место:");
        for (int i = 0; i < hall.length; ++i)
            System.out.println((i + 1) + ")  " + (hall[i] == 0 ? "Свободно" : "Занято"));
    }

    public void ShowSession() {
        System.out.println(id + ")  " + time);
    }

    public int SumHall(){
        int sum=0;
        for(int money: hall) sum+=money;
        return sum;
    }

}
