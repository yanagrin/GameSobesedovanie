package com.example.fragmentsnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link test2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "player";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public test2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test2.
     */
    // TODO: Rename and change types and number of parameters
    public static test2 newInstance(String param1, String param2) {
        test2 fragment = new test2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test2, container, false);
        Button b1 = view.findViewById(R.id.BT1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("player", mParam1);
                bundle.putString("profession", "seller");
                Navigation.findNavController(view).navigate(R.id.action_test2_to_test3, bundle);
            }
        });
        Button b2 = view.findViewById(R.id.BT2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("player", mParam1);
                bundle.putString("profession", "programmer");
                Navigation.findNavController(view).navigate(R.id.action_test2_to_test3, bundle);
            }
        });
        return view;
    }
}