package com.example.fragmentsnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link test6_question1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class test6_question1 extends Fragment {
    String question, ans1, ans2, ans3, chooseAns="-1", ball="-1", value1, value2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "player";
    private static final String ARG_PARAM2 = "profession";
    private static final String ARG_PARAM3 = "hr";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public test6_question1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test6_question1.
     */
    // TODO: Rename and change types and number of parameters
    public static test6_question1 newInstance(String param1, String param2, String param3) {
        test6_question1 fragment = new test6_question1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test6_question1, container, false);

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
                    Log.d("KKK", "k");
                }
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v2.isChecked()){
                    chooseAns="2";
                    ball="5";
                    Log.d("KKK", "k");
                }
            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v3.isChecked()){
                    chooseAns="3";
                    ball="0";
                    Log.d("KKK", "k");
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
                bundle.putString("q1", ball);
                Navigation.findNavController(view).navigate(R.id.action_test6_question1_to_test7_question2, bundle);
            }
        });
        return view;
    }


    protected void set_text_fields() {
            if (mParam2.equals("seller")){
                question="Если бы вам пришлось выбрать между тем, чтобы все сотрудники вашего отдела носили пижамы на работу или все время говорили на обратном языке, что бы вы выбрали и почему?";
                ans1="Предпочел бы, чтобы все носили пижамы на работу – так мы могли бы проводить корпоративные собрания в уютной обстановке и делать пижамные вечеринки после рабочего дня.";
                ans2="Если все будут говорить на обратном языке, то это будет отличным способом защиты информации от посторонних. Никакие шпионы не смогут понять, что мы говорим! ";
                ans3="Говорить на обратном языке – это отличный способ улучшить коммуникацию в коллективе. Ведь когда ты не понимаешь друг друга, начинаешь ценить каждое слово!";
            }
            else {
                question="Если бы Java была бы едой, то какой бы она была и почему?";
                ans1="Java была бы как пельмени - универсальная и всегда готова к употреблению";
                ans2="Java была бы как многослойный торт - сложная, но вкусная, с разнообразными 'слоями' функциональности и возможностей";
                ans3="Java была бы как салат Цезарь - классическая, стабильная и всегда находится в центре внимания программистов!";

            }
    }

}