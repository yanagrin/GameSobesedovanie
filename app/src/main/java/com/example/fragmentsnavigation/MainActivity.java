package com.example.fragmentsnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Boolean f = true;

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText passwordEditText = findViewById(R.id.password);
        EditText usernameEditText = findViewById(R.id.username);
        // сделать кнопку видимой после ввода пароля
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bt.setEnabled(true);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bt=findViewById(R.id.LOGIN);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Authentication authentication = new Authentication();
                if (authentication.sign_in_or_register(usernameEditText.getText(),passwordEditText.getText())==1){
                    Intent intent = new Intent(MainActivity.this, Game.class);
                    intent.putExtra("key1", "0");
                    startActivityForResult(intent, 134);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Какая-то ошибка", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.my_nav_host_frag).navigateUp();
    }





}