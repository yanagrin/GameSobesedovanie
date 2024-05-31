
package com.example.fragmentsnavigation.BD.userLocalBD;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// Интерфейс для доступа к данным пользователей в базе данных
@Dao
public interface UserDao {
    // Метод для вставки пользователя в базу данных
    @Insert
    void insert(UserLocalBD user);



    // Метод для удаления пользователя по ID
    @Query("DELETE FROM user_table WHERE id = :userId")
    void deleteById(int userId);
    /*@Query("DELETE FROM user_table")
    void clearTable();*/

    // Метод для получения всех пользователей из базы данных
    @Query("SELECT * FROM user_table")
    LiveData<List<UserLocalBD>> getAllUsers();

    // Метод для поиска пользователя по ID
    @Query("SELECT * FROM user_table WHERE id = :userId")
    LiveData<UserLocalBD> findUserById(int userId);

}
