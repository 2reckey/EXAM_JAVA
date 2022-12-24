package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Реализовать консольный терминал кассира и администратора кинотеатра
//Пользователь может выбрать фильм, выбрать сеанс фильма, выбрать одно или несколько свободных мест для покупки.
// Также пользователь может вывести денежную сумму проданных билетов на все сеансы фильма или на конкретный сеанс
public class Manager {
    ArrayList<Film> films = new ArrayList<>() {
        {
            add(new Film(1, "Аватар 2.Путь воды", 700));
            add(new Film(2, "Человеческая многоножка", 700));
            add(new Film(3, "Бивень", 500));
            add(new Film(4, "Алеша Попович", 1000));
        }
    };

    public Manager() {
        while (true) Interface();
    }

    public void Interface() {
        System.out.println("1)  Выбрать фильм");
        System.out.println("2)  Сумма билетов");
        int main_chose = ScanInt();
        if (main_chose == 1) {
            System.out.println("---------------------");
            ShowFilms();
            System.out.println("Выберите Фильм:");
            int chose = ScanInt();
            Film film = films.get(chose - 1);
            film.ShowSessions();
            System.out.println("Выберите Сеанс:");
            int chose_s = ScanInt();
            Session session = film.sessions.get(chose_s - 1);
            session.ShowHall();
            int chose_h = ScanInt();
            while (session.hall[chose_h - 1] != 0) {
                System.out.println("Место занято! Попробуйте другое!");
                chose_h = ScanInt();
            }
            session.hall[chose_h - 1] += film.cost;
            System.out.println("Успешно!");
        }
        else{
            System.out.println("Выберите Фильм:");
            System.out.println("---------------------");
            ShowFilms();
            int chose = ScanInt();
            Film film = films.get(chose - 1);
            film.ShowSessions();
            System.out.println((film.sessions.size()+1)+")  ВСЕ!");
            System.out.println("Выберите Сеанс:");
            int chose_s = ScanInt();
            int sum;
            if(chose_s==film.sessions.size()+1){
                sum=0;
                for(Session session: film.sessions) sum+=session.SumHall();
            }
            else{
                sum=film.sessions.get(chose_s-1).SumHall();
            }
            System.out.println("Сумма:  "+sum);
        }
    }

    public void ShowFilms() {
        films.forEach(Film::ShowFilm);
    }


    public int ScanInt() {  //Ввод целых чисел
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (Exception exception) {
            System.out.println("Неверный ввод данных, попробуйте еще раз!");
            return ScanInt();
        }
    }
}
