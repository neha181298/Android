package com.example.dell.finddoc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentSearch extends Fragment {



    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view_list, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView icon;
        public TextView category;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            //icon = (ImageView) itemView.findViewById(R.id.icon_type);
            category = (TextView) itemView.findViewById(R.id.category_value);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);*/

                    Snackbar snackbar = Snackbar
                            .make(v,"snackbar", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }
            });
        }

    }


    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        private final String[] mPlaces={"Dentist","Opthalmologist","Gynaecologist","Orthopaedist","General Physician","Dietician","Nutritionist","Cardiologist","Psychologist","Neurologist","eleven","twelve","thirteen","fourteen","fifteen"};
        //private final String[] mPlaceDesc;


        public ContentAdapter(Context context) {

        }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.icon.setImageDrawable(mPlaceAvators[position % mPlaceAvators.length]);
        holder.category.setText(mPlaces[position % mPlaces.length]);
    }

    @Override
    public int getItemCount() {
        return LENGTH;
    }
}




}


