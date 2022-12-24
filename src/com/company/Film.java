package com.company;

import java.util.ArrayList;

public class Film {
    ArrayList<Session> sessions = new ArrayList<>();
    int id;
    String name;
    int cost;

    public Film(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        StandardSessions();
    }

    public void StandardSessions() {
        for (int i = 0; i < 10; ++i) {
            String time = Integer.toString(i + 10) + ":00";
            sessions.add(new Session(i + 1, this, time, 20));
        }
    }

    public void ShowFilm() {
        System.out.println(id + ")  " + name + "  Цена:  " + cost);
    }

    public void ShowSessions() {
        sessions.forEach(Session::ShowSession);
    }
}
