package com.example.fragmentsnavigation.test_frag;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.fragmentsnavigation.BD.Authentication.BDuser;
import com.example.fragmentsnavigation.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class EndTest {
    int test_results=-1;
    int summa_ballov=0;
    public int doo(String ans_on_q1, String ans_on_q2, String ans_on_q3, String ans_on_q4, String ans_on_q5){
        int q1 = Integer.parseInt(ans_on_q1);
        int q2 = Integer.parseInt(ans_on_q2);
        int q3 = Integer.parseInt(ans_on_q3);
        int q4 = Integer.parseInt(ans_on_q4);
        int q5 = Integer.parseInt(ans_on_q5);

        summa_ballov = q1+q2+q3+q4+q5;
        if (summa_ballov>25){
            test_results=1;
        }
        else {test_results=0;}

        User.ball_on_last_try =summa_ballov;

        Log.d("END", " "+summa_ballov);
        return test_results;
    }

    public void bd(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Create a new user with a first and last name
        String email = User.email;
        int summa_ballov = User.ball_on_last_try;
        int number_of_test = User.q_of_tests;
        String profession = User.profession_on_last_try;

        Log.d("FFF",email+" __ " +summa_ballov +" __ "+ number_of_test+" __ "+profession);

        /*Map<String, Object> user = new HashMap<>();

        user.put("email", email);
        user.put("number_of_try", number_of_test);
        user.put("profession", profession);
        user.put("summa_ballov", summa_ballov);
        user.put("summa_ballov", 2);*/



        /*db.collection("users")
                .document("/users/OKlNa69ckLOPD2EVuYSC")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            // Если документ существует, обновляем значение поля number_of_test на 2
                            int currentNumberOfTest = documentSnapshot.getLong("number_of_test").intValue();
                            db.collection("users").document("HkuOvbzwegBBPAPCon3l").update("number_of_test", currentNumberOfTest + 2);
                            Log.d("FFF","есть");
                        } else {
                            // Если документ не существует, добавляем новый
                            db.collection("users").document("1").set(user);
                            Log.d("FFF","нет");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("BBBerror", "Error checking/updating document", e);
                    }
                });*/

        BDuser user = new BDuser(email, number_of_test, profession, summa_ballov);
        BDuser user1 = new BDuser(email, number_of_test, profession, summa_ballov);



        db.collection("users").document(email).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("BBBeeeeeeeeeee", "D");

            }
        });

        // Add a new document with a generated ID
        if (User.q_of_tests ==100000000) {
            db.collection("users")
                    .add(user)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("BBBok", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("BBBerror", "Error adding document", e);
                        }
                    });

        }
        else{
            //BDuser user1 = new BDuser(email, number_of_test, profession, summa_ballov);
            db.collection("users")
                    .add(user1)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            //documentReference.update("number_of_try", 9);
                            //User.id = documentReference.getId();
                            //Log.d("BBBok", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("BBBerror", "Error adding document", e);
                        }
                    });


        }
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String d = document.getData().toString();
                                //User.BD+=document.getData().substring(document.getData().lastIndexOf("=") + 1).replaceAll("[^a-zA-Z0-9@]", "");
                                Log.d("BBBread", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("BBBread", "Error getting documents.", task.getException());
                        }
                    }
                });

    }

}
