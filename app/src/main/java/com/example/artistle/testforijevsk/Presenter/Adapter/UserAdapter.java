package com.example.artistle.testforijevsk.Presenter.Adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.artistle.testforijevsk.Model.UserModel;
import com.example.artistle.testforijevsk.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<UserModel.Response> userListModels;

    public UserAdapter(List<UserModel.Response> userListModels) {
        this.userListModels = userListModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_model, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModel.Response user = userListModels.get(position);
        UserModel.Specialty specialty = user.getSpecialty().get(0);

        //specialty
        holder.info_special.setText(specialty.getName());

        //name
        holder.name.setText(firstUpperCase(user.getFName()) + " " + firstUpperCase(user.getLName()));

        //birthday
        if(user.getBirthday() == null || user.getBirthday() == ""){
            holder.age.setText("Дата рождения:__");
        }else{
            holder.age.setText("Дата рождения: " + user.getBirthday());
        }

        //load avatar
        String url = user.getAvatrUrl();
        if (url == null || url == ""){
            Glide
                    .with(holder.context)
                    .load(R.mipmap.ic_person)
                    .into(holder.avatar);
        }else {
            Glide
                    .with(holder.context)
                    .load(url)
                    .into(holder.avatar);
        }
    }

    @Override
    public int getItemCount() {
        return userListModels.size();
    }

    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView age;
        private ImageView avatar;
        private Context context;
        private TextView info_special;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            name = (TextView) view.findViewById(R.id.name);
            age = (TextView) view.findViewById(R.id.age);
            avatar = (ImageView) view.findViewById(R.id.avatar);
            info_special = (TextView) view.findViewById(R.id.text_specialty);
        }
    }
}