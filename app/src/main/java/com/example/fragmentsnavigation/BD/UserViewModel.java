package com.example.fragmentsnavigation.BD;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fragmentsnavigation.BD.userLocalBD.UserLocalBD;
import com.example.fragmentsnavigation.BD.AppDatabase;
import com.example.fragmentsnavigation.BD.userLocalBD.UserDao;
import com.example.fragmentsnavigation.BD.userLocalBD.UserRepository;


import java.util.List;

public class UserViewModel extends AndroidViewModel {
    // Репозиторий и LiveData для пользователей
    private UserRepository repository;
    private LiveData<List<UserLocalBD>> allUsers;

    // Конструктор класса
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    // Метод для добавления пользователя
    public void insert(UserLocalBD user) {
        Log.d("BBBB", "BDerror3????");
        repository.insert(user);
        Log.d("BBBB", "BDerror3?????????????");
    }

    // Метод для удаления пользователя по ID
    public void deleteById(int userId) {
        repository.deleteById(userId);

    }

  /*  public void clearTable(){
        repository.clearTable();
    }*/
    // Метод для получения всех пользователей

    public LiveData<List<UserLocalBD>> getAllUsers() {
        return allUsers;
    }


    // Метод для поиска пользователя по ID
    public LiveData<UserLocalBD> findUserById(int userId) {
        return repository.findUserById(userId);
    }
}
