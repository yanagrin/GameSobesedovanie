package com.example.fragmentsnavigation.test_frag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.fragmentsnavigation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link test9_question4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test9_question4 extends Fragment {
    String question, ans1, ans2, ans3, chooseAns="-1", ball="-1";
    private static final String ARG_PARAM1 = "player";
    private static final String ARG_PARAM2 = "profession";
    private static final String ARG_PARAM3 = "hr";
    private static final String ARG_PARAM4 = "q1";
    private static final String ARG_PARAM5 = "q2";
    private static final String ARG_PARAM6 = "q3";
    private String mParam1, mParam2, mParam3, mParam4, mParam5, mParam6;
    public test9_question4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test9_question4.
     */
    // TODO: Rename and change types and number of parameters
    public static test9_question4 newInstance(String param1, String param2) {
        test9_question4 fragment = new test9_question4();
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
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getString(ARG_PARAM6);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test9_question4, container, false);

        TextView tv = view.findViewById(R.id.TV);
        RadioButton v1 =  view.findViewById(R.id.V1);
        RadioButton v2 =  view.findViewById(R.id.V2);
        RadioButton v3 =  view.findViewById(R.id.V3);
        set_text_fields();
        tv.setText(question);
        v1.setText(ans1);
        v2.setText(ans2);
        v3.setText(ans3);

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v1.isChecked()){
                    chooseAns="1";
                    ball="10";
                }
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v2.isChecked()){
                    chooseAns="2";
                    ball="5";
                }
            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v3.isChecked()){
                    chooseAns="3";
                    ball="0";
                }
            }
        });


        Button next = view.findViewById(R.id.NEXT);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (chooseAns.equals("-1")){
                    chooseAns="1";
                    ball="10";
                }
                Bundle bundle = new Bundle();
                bundle.putString("player", mParam1);
                bundle.putString("profession", mParam2);
                bundle.putString("hr", mParam3);
                bundle.putString("q1", mParam4);
                bundle.putString("q2", mParam5);
                bundle.putString("q3", mParam6);
                bundle.putString("q4", ball);
                Navigation.findNavController(view).navigate(R.id.action_test9_question4_to_test10_question5, bundle);
            }
        });
        return view;
    }

    protected void set_text_fields() {
        if (mParam2.equals("seller")){
            question="Как вы решаете конфликты в команде?";
            ans1="Провожу обсуждение и нахожу компромиссное решение";
            ans2="Принимаю решение самостоятельно";
            ans3="Игнорирую конфликты";
        }
        else {
            question="Какой из следующих языков программирования является объектно-ориентированным?";
            ans3="С";
            ans1="Python";
            ans2="PHP";
        }
    }
}