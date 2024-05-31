package com.example.fragmentsnavigation.test_frag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentsnavigation.BD.UserListAdapter;
import com.example.fragmentsnavigation.BD.UserViewModel;
import com.example.fragmentsnavigation.BD.userLocalBD.UserLocalBD;
import com.example.fragmentsnavigation.R;
import com.example.fragmentsnavigation.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link test11#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test11 extends Fragment {

    private static final String ARG_PARAM1 = "player";
    private static final String ARG_PARAM2 = "profession";
    private static final String ARG_PARAM3 = "hr";
    private static final String ARG_PARAM4 = "q1";
    private static final String ARG_PARAM5 = "q2";
    private static final String ARG_PARAM6 = "q3";
    private static final String ARG_PARAM7 = "q4";
    private static final String ARG_PARAM8 = "q5";
    public UserViewModel userViewModel;
    private UserListAdapter adapter;
    private RecyclerView recyclerView;

    private String player, profession, hr, q1, q2, q3, q4, q5;

    public test11() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test11.
     */
    // TODO: Rename and change types and number of parameters
    public static test11 newInstance(String param1, String param2) {
        test11 fragment = new test11();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            player = getArguments().getString(ARG_PARAM1);
            profession = getArguments().getString(ARG_PARAM2);
            hr = getArguments().getString(ARG_PARAM3);
            q1 = getArguments().getString(ARG_PARAM4);
            q2 = getArguments().getString(ARG_PARAM5);
            q3 = getArguments().getString(ARG_PARAM6);
            q4 = getArguments().getString(ARG_PARAM7);
            q5 = getArguments().getString(ARG_PARAM8);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test11, container, false);

        /*if(User.q_of_tests==1){
            userViewModel.clearTable();
        }*/

        TextView tv = view.findViewById(R.id.TV);
        EndTest end = new EndTest();
        end.doo(q1,q2,q3,q4,q5);
        end.bd();



        //Controller controller = new Controller();
        UserLocalBD userLocalBD = new UserLocalBD(User.profession_on_last_try);
        int idd= 1+User.q_of_tests;
        userLocalBD.setId(idd);
        int sum=Integer.parseInt(q1)+Integer.parseInt(q2)+Integer.parseInt(q3)+Integer.parseInt(q4)+Integer.parseInt(q5);
        userLocalBD.setBall(sum);
        if (sum>25){
            userLocalBD.setResult("Принят(а)");
        }
        else {
            userLocalBD.setResult("Отказано");
        }
        userLocalBD.setN_of_tryings(User.q_of_tests);


        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.insert(userLocalBD);


        User.list_of_tryings_results.add(userLocalBD.getId());




       // UserLocalBD res = userViewModel.getAllUsers().getValue().get(0);
       // Log.d("BBBBb", " "+userViewModel.getAllUsers().getValue());

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new UserListAdapter(new UserListAdapter.UserDiff());
        recyclerView.setAdapter(adapter);*/
        // Наблюдение за LiveData из ViewModel для обновления RecyclerView
        /*userViewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<UserLocalBD>>() {
            @Overrid
            public void onChanged(List<UserLocalBD> users) {
                // Обновление кэша пользователей в адаптере.
                adapter.submitList(users);
            }
        });*/


        Log.d("BBBBfind", "id "+userLocalBD.toString());

        Log.d("BBBBfind", "id "+userViewModel.findUserById(idd).toString());
        //Log.d("BBBBfind", "id "+userLocalBD2.toString());


        int id;
        for (int i=0; i<User.list_of_tryings_results.size()-1;i++) {
            id = User.list_of_tryings_results.get(i);
            userViewModel.findUserById(id).observe(getViewLifecycleOwner(), user -> {
                if (user != null) {
                    Log.d("BBBBfind", "Пользователь найден: " + user.getName());
                } else {
                    Log.d("BBBBfind", "Пользователь НЕ найден: ");
                }
            });
        }



        // Получение LiveData объекта пользователя по ID
        LiveData<UserLocalBD> userLiveData = userViewModel.findUserById(idd);

        // Наблюдение за изменениями в LiveData
        userLiveData.observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                // Вывод всех полей пользователя на экран
                User.list_of_tryings_results2+=user.getN_of_tryings()+" "+user.getName()+" "+user.getBall()+" "+user.getResult()+"\n";
                Log.d("BBBB","ID: " + user.getId()+"Name: " + user.getName()+"Number of tryings: " + user.getN_of_tryings());
                /*System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Number of tryings: " + user.getN_of_tryings());
                System.out.println("Ball: " + user.getBall());
                System.out.println("Result: " + user.getResult());*/
            } else {
                System.out.println("Пользователь не найден");
            }
        });






        Log.d("END1", " "+q1+q2+q3+q4+q5);
        if (end.doo(q1,q2,q3,q4,q5)==1){
            tv.setText("Поздравляем, вы приняты!");
        }
        else {
            tv.setText("Мы вам перезвоним ...");
        }
        Button next = view.findViewById(R.id.NEXT);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Navigation.findNavController(view).navigate(R.id.action_test11_to_test12, bundle);
            }
        });


        return view;
    }



}