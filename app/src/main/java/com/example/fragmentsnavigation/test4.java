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
 * Use the {@link test4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "player";
    private static final String ARG_PARAM2 = "profession";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public test4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test4.
     */
    // TODO: Rename and change types and number of parameters
    public static test4 newInstance(String param1, String param2) {
        test4 fragment = new test4();
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
        View view = inflater.inflate(R.layout.fragment_test4, container, false);
        Button b1 = view.findViewById(R.id.BT1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("player", mParam1);
                bundle.putString("profession", mParam2);
                bundle.putString("hr", "woman");
                Navigation.findNavController(view).navigate(R.id.action_test4_to_test5, bundle);
            }
        });
        Button b2 = view.findViewById(R.id.BT2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("player", mParam1);
                bundle.putString("profession", mParam2);
                bundle.putString("hr", "old_lady");
                Navigation.findNavController(view).navigate(R.id.action_test4_to_test5, bundle);
            }
        });
        return view;
    }
}