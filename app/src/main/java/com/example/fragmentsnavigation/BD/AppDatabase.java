package com.example.fragmentsnavigation.BD;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.fragmentsnavigation.BD.userLocalBD.UserLocalBD;

import com.example.fragmentsnavigation.BD.AppDatabase;
import com.example.fragmentsnavigation.BD.userLocalBD.UserDao;


// Абстрактный класс базы данных Room
@Database(entities = {UserLocalBD.class}, version = 13, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    // Метод для получения объекта доступа к данным для сущности User
    public abstract UserDao userDao();
}


