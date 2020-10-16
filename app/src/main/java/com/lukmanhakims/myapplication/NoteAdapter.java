package com.lukmanhakims.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteAdapterViewHolder> {

    private ArrayList<NoteDataPulsa> notedatapulsa;

    public NoteAdapter(ArrayList<NoteDataPulsa> list) {
        this.notedatapulsa = list;
    }

    @Override
    public NoteAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new NoteAdapterViewHolder(view);
    }
    @Override
    public void onBindViewHolder(NoteAdapterViewHolder holder, final int position) {
        holder.username.setText(notedatapulsa.get(position).getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahKeNoteDetail(position, v.getContext());
            }
        });
    }

    private void pindahKeNoteDetail(int position, Context l) {

        Context context = l;

        Intent i = new Intent(context, DetailDataPulsa.class);
        i.putExtra("nama", notedatapulsa.get(position).getNama());
        i.putExtra("jumlah", notedatapulsa.get(position).getJumlah());
        i.putExtra("deskripsi_status", notedatapulsa.get(position).getDeskripsi_status());
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return (notedatapulsa != null) ? notedatapulsa.size() : 0; }

    public class NoteAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView username;

        public NoteAdapterViewHolder(View view) {
            super(view);
            username = (TextView) itemView.findViewById(R.id.text_username4);
        }
    }
}
