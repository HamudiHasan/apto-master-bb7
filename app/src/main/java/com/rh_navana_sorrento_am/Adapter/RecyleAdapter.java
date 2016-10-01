package com.rh_navana_sorrento_am.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rh_navana_sorrento_am.ModelClass.Person;
import com.rh_navana_sorrento_am.R;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.ViewHolder> {

    private List<Person> persons;
    private Context context;

    public RecyleAdapter(List<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_contact, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       Person person = persons.get(position);
        holder.personName.setText(person.fullName);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.layout.getBackground().setTint(Color.rgb(randInt(),randInt(),randInt()));
        }

        if(person.fullName.toString().length() > 0)
        holder.header.setText(person.fullName.toString().toUpperCase().charAt(0) + "");

    }
    public  int randInt() {


        Random rn = new Random();
        int answer = rn.nextInt(255) ;

        return answer;
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView personName;
        public TextView header;

        View layout;

        public ViewHolder(View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.name_layout);
            personName = (TextView) itemView.findViewById(R.id.view_person_name);
            header = (TextView) itemView.findViewById(R.id.view_header);

        }
    }
}
