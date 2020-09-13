package com.teste.hackasafra.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.hackasafra.R;
import com.teste.hackasafra.model.Debits;

import java.util.List;

import static android.graphics.Color.RED;

public class AdapterDebits extends RecyclerView.Adapter <AdapterDebits.DebitsViewHolder> {

    private List<Debits> listDebits;
    public AdapterDebits ( List<Debits> list){
        this.listDebits = list;
    }

    @NonNull
    @Override
    public DebitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Create all user visualizations
        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_debits, parent, false); // Used to convert .xml in visualization

        return new DebitsViewHolder( itemList );
    }

    @Override
    public void onBindViewHolder(@NonNull final DebitsViewHolder holder, int position) { // Each of the elements exhibition

        final Debits debits = listDebits.get( position );

        holder.description.setText( debits.getDescription() );
        holder.value.setText( debits.getValue() );
        holder.status.setText ( debits.getStatus() );
        holder.autorize.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
          }
        });
    }

    @Override
    public int getItemCount() {
        return listDebits.size();
    }

    public class DebitsViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        TextView value;
        TextView status;
        Button autorize;

        public DebitsViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.textDescription);
            value = itemView.findViewById(R.id.textValue);
            status = itemView.findViewById(R.id.textStatus);
            autorize = itemView.findViewById(R.id.buttonAutorizar);

        }
    }
}
