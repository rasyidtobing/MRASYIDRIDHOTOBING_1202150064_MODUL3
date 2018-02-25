package com.example.android.mrasyidridhotobing_1202150064_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AirAdapter extends RecyclerView.Adapter<AirAdapter.MyViewHolder> {
    private LayoutInflater mInflater;
    private List<Air> menuList;
    CardView cv;

    AirAdapter(Context context, List<Air> menuList) {
        mInflater = LayoutInflater.from(context); //inisiasi inflater
        this.menuList = menuList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        //method untuk menginflate dengan class lainnya
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Air Air = menuList.get(position);
        holder.details.setText(Air.getDetails());            //get value ke textView
        holder.nama.setText(Air.getNama());
        holder.layout.setBackgroundResource(Air.getGambar());


    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // class MyCiewHolder
        public TextView nama, details;
        ImageView gambar;
        ConstraintLayout layout;


        public MyViewHolder(View view) {
            super(view); //menginisiasi variable2 attribute
            nama = (TextView) view.findViewById(R.id.nama); //menginisiasi variable2 attribute
            details = (TextView) view.findViewById(R.id.details);//menginisiasi variable2 attribute
            layout = (ConstraintLayout) view.findViewById(R.id.layout_background);//menginisiasi variable2 attribute

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String element = menuList.get(mPosition).toString();
            Toast.makeText(view.getContext(), nama.getText(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), DetailActivity.class);
            int gambar = menuList.get(mPosition).getGambar();
            String komposisi = menuList.get(mPosition).getKomposisi();
            i.putExtra("gambar", gambar);
            i.putExtra("komposisi", komposisi);
            view.getContext().startActivity(i); //menjalankan activity selanjutnya

        }
    }


}
