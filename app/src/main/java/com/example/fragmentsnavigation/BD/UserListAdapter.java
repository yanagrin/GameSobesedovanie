package com.example.fragmentsnavigation.BD;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsnavigation.BD.userLocalBD.UserLocalBD;
import com.example.fragmentsnavigation.R;
import com.example.fragmentsnavigation.User;



public class UserListAdapter extends ListAdapter<UserLocalBD, UserListAdapter.UserViewHolder> {
    private UserListAdapter adapter;
    private RecyclerView recyclerView;

    // Конструктор класса
    public UserListAdapter(@NonNull DiffUtil.ItemCallback<UserLocalBD> diffCallback) {
        super(diffCallback);
    }

    // Создание ViewHolder
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UserViewHolder.create(parent);
    }

    // Привязка данных к ViewHolder
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserLocalBD current = getItem(position);
        if (current.getName().equals("programmer")){
            holder.bind("Программист, "+ current.getBall()+", "+current.getResult());
        }
        else {
            holder.bind("Менеджер, "+ current.getBall()+", "+current.getResult());

        }
        }


    // ViewHolder для отображения пользовательских данных
    static class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView userNameItemView;

        private UserViewHolder(View itemView) {
            super(itemView);
            userNameItemView = itemView.findViewById(R.id.textView); //???
        }

        // Привязка данных к элементам пользовательского интерфейса
        public void bind(String text) {
            userNameItemView.setText(text);
        }

        // Создание ViewHolder
        static UserViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false); //???
            return new UserViewHolder(view);
        }
    }

    // Класс для определения изменений между объектами User
    public static class UserDiff extends DiffUtil.ItemCallback<UserLocalBD> {

        // Проверка, являются ли элементы одинаковыми
        @Override
        public boolean areItemsTheSame(@NonNull UserLocalBD oldItem, @NonNull UserLocalBD newItem) {
            return oldItem == newItem;
        }

        // Проверка, имеют ли элементы одинаковое содержимое
        @Override
        public boolean areContentsTheSame(@NonNull UserLocalBD oldItem, @NonNull UserLocalBD newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
