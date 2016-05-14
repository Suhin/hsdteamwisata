package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by SUHIN_22 on 08/12/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<DataItem> person;
    private Activity activity;

    public RecyclerAdapter(Activity activity, List<DataItem> person) {
        this.activity = activity;
        this.person = person;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //inflate your layout and pass it to view holder
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int position) {

        // Tambah Photo
        viewHolder.imageView.setImageResource(person.get(position).getPhoto());
        //setting data to view holder elements
        viewHolder.name.setText(person.get(position).getName());
        viewHolder.job.setText(person.get(position).getJob());
    //    viewHolder.container.setOnClickListener(onClickListener(position));
    }

    /*private void setDataToView(TextView name, TextView job, ImageView genderIcon, int position) {
        genderIcon.setImageResource(person.get(position).getPhoto());

        name.setText(person.get(position).getName());
        job.setText(person.get(position).getJob());
    }*/

    @Override
    public int getItemCount() {
        return (null != person ? person.size() : 0);
    }

/*    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.item_recycler);
                dialog.setTitle("Position " + position);
                dialog.setCancelable(true); // dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                TextView name = (TextView) dialog.findViewById(R.id.name);
                TextView job = (TextView) dialog.findViewById(R.id.job);
                ImageView icon = (ImageView) dialog.findViewById(R.id.image);

                setDataToView(name, job, icon, position);

                dialog.show();
            }
        };
    }*/

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView job;
        private View container;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            name = (TextView)itemView.findViewById(R.id.name);
            job = (TextView)itemView.findViewById(R.id.job);
            container = itemView.findViewById(R.id.card_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), name.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(), Theme.class);

                    if (name.getText()=="Pantai Indrayanti") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Pantai Parangtritis") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Pantai Siung") {
                        i.putExtra("name", name.getText());
                    }

                    else if (name.getText()=="Museum Keraton Yogyakarta") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Museum Sonobudoyo") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Museum Affandi") {
                        i.putExtra("name", name.getText());
                    }

                    else if (name.getText()=="Candi Prambanan") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Candi Borobudur") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Candi Sambisari") {
                        i.putExtra("name", name.getText());
                    }

                    else if (name.getText()=="The House of Raminten") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Gudeg Yu Djum") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="The Kalimilk") {
                        i.putExtra("name", name.getText());
                    }

                    else if (name.getText()=="Malioboro") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Beringharjo") {
                        i.putExtra("name", name.getText());
                    } else if (name.getText()=="Kasongan") {
                        i.putExtra("name", name.getText());
                    }

                    v.getContext().startActivity(i);
                }
            });
        }
    }
}