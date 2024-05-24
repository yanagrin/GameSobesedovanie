package com.example.fragmentsnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

        TextView tv = view.findViewById(R.id.TV);
        EndTest end = new EndTest();
        end.doo(q1,q2,q3,q4,q5);
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