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
 * Use the {@link test8_question3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test8_question3 extends Fragment {
    String question, ans1, ans2, ans3, chooseAns="-1", ball="-1";
    private static final String ARG_PARAM1 = "player";
    private static final String ARG_PARAM2 = "profession";
    private static final String ARG_PARAM3 = "hr";
    private static final String ARG_PARAM4 = "q1";
    private static final String ARG_PARAM5 = "q2";
    private String mParam1, mParam2, mParam3, mParam4, mParam5;

    public test8_question3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test8_question3.
     */
    // TODO: Rename and change types and number of parameters
    public static test8_question3 newInstance(String param1, String param2) {
        test8_question3 fragment = new test8_question3();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test8_question3, container, false);
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
                bundle.putString("q3", ball);
                Navigation.findNavController(view).navigate(R.id.action_test8_question3_to_test9_question4, bundle);
            }
        });
        return view;
    }
    protected void set_text_fields() {
        if (mParam2.equals("seller")){
            question="Продайте мне эту ручку";
            ans3="ну, ээээ";
            ans2="Каждое слово, написанное этой ручкой, становится частью истории и отзовется в вечности";
            ans1="Эта ручка - ваш личный переводчик мыслей в слова, который поможет вам выразить все, что у вас на сердце, даже если это звучит странно";
        }
        else {
            question="Как вы решаете проблемы с производительностью в мобильных приложениях?";
            ans1="Оптимизирую код";
            ans3="Оптимизирую работу с памятью";
            ans2="Провожу тестирование на разных устройствах";
        }
    }


}