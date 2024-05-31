package com.example.fragmentsnavigation.BD.userLocalBD;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
// Класс сущности пользователя для базы данных Room

@Entity(tableName = "user_table")
public class UserLocalBD {
    // Поле ID пользователя (генерируется автоматически)
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    private int id;
    // Поле имени пользователя
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "q_of_tryings")
    private int n_of_tryings;
    @ColumnInfo(name = "ball")
    private int ball;

    @ColumnInfo(name = "result")
    private String result;

    public void setN_of_tryings(int n_of_tryings) {
        this.n_of_tryings = n_of_tryings;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getN_of_tryings() {
        return n_of_tryings;
    }

    public int getBall() {
        return ball;
    }

    public String getResult() {
        return result;
    }

    // Конструктор класса
    public UserLocalBD(String name) {

        this.name = name;
        this.id = 0;
    }

    // Метод для получения ID пользователя
    public int getId() {
        return id;
    }

    // Метод для получения имени пользователя
    public String getName() {
        return name;
    }

    // Метод для установки ID пользователя
    public void setId(int id) {
        this.id = id;
    }

    // Метод для установки имени пользователя
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", n_of_tryings=" + n_of_tryings +
                ", ball=" + ball +
                ", result='" + result + '\'' +
                '}';
    }
}