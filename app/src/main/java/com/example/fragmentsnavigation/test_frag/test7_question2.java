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
 * Use the {@link test7_question2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test7_question2 extends Fragment {
    String question, ans1, ans2, ans3, chooseAns="-1", ball="-1";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "player";
    private static final String ARG_PARAM2 = "profession";
    private static final String ARG_PARAM3 = "hr";
    private static final String ARG_PARAM4 = "q1";
    private String mParam1, mParam2, mParam3, mParam4;


    public test7_question2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test7_question2.
     */
    // TODO: Rename and change types and number of parameters
    public static test7_question2 newInstance(String param1, String param2) {
        test7_question2 fragment = new test7_question2();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test7_question2, container, false);

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
            @Override
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
                bundle.putString("q2", ball);
                Navigation.findNavController(view).navigate(R.id.action_test7_question2_to_test8_question3, bundle);
            }
        });
        return view;
    }

    protected void set_text_fields() {
        if (mParam2.equals("seller")){
            question="Как вы реагируете на отказ клиента?";
            ans3="Пытаюсь убедить его в покупке";
            ans1="Принимаю его решение и предлагаю альтернативу";
            ans2="Пытаюсь узнать причину отказа для улучшения сервиса";
        }
        else {
            question="Как вы решаете конфликты в команде разработчиков?";
            ans1="Ищу компромиссное решение";
            ans3="Обращаюсь к руководству за помощью";
            ans2="Проявляю терпение и пытаюсь разрешить ситуацию самостоятельно";
    }
    }
}