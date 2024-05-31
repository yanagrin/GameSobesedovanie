package com.example.fragmentsnavigation;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentsnavigation.BD.UserListAdapter;
import com.example.fragmentsnavigation.BD.UserViewModel;
import com.example.fragmentsnavigation.BD.userLocalBD.UserLocalBD;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link results#newInstance} factory method to
 * create an instance of this fragment.
 */
public class results extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private UserListAdapter adapter;
    private RecyclerView recyclerView;
    public results() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment results.
     */
    // TODO: Rename and change types and number of parameters
    public static results newInstance(String param1, String param2) {
        results fragment = new results();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        /*RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] data = {"Item 1", "Item 2", "Item 3"}; // Пример данных
        adapter = new RecyclerView.Adapter(data) {
        };
        recyclerView.setAdapter(adapter);*/



        if (User.q_of_tests>0){

        }
        recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new UserListAdapter(new UserListAdapter.UserDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel .class);


        userViewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<UserLocalBD>>() {
            @Override
            public void onChanged(List<UserLocalBD> users) {
                // Обновление кэша пользователей в адаптере.
                adapter.submitList(users);
            }
        });

        return view;


    }


}