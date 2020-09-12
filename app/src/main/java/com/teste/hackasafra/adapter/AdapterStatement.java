package com.teste.hackasafra.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.hackasafra.R;
import com.teste.hackasafra.model.Statement;

import java.util.List;

public class AdapterStatement extends RecyclerView.Adapter <AdapterStatement.StatementViewHolder> {

    private List<Statement> listStatement;

    public AdapterStatement ( List<Statement> list){
        this.listStatement = list;
    }

    @NonNull
    @Override
    public StatementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Create all user visualizations
        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_statements, parent, false); // Used to convert .xml in visualization

        return new StatementViewHolder( itemList );
    }

    @Override
    public void onBindViewHolder(@NonNull StatementViewHolder holder, int position) { // Each of the elements exhibition

        Statement statement = listStatement.get( position );

        holder.description.setText( statement.getDescription() );
        holder.date.setText( statement.getDate() );
        holder.value.setText( statement.getValue() );
        holder.stickers.setText( statement.getStickers() );

    }

    @Override
    public int getItemCount() {
        return listStatement.size();
    }

    public class StatementViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        TextView date;
        TextView value;
        TextView stickers;

        public StatementViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.textDescription);
            date = itemView.findViewById(R.id.textDate);
            value = itemView.findViewById(R.id.textValue);
            stickers = itemView.findViewById(R.id.textStickers);

        }
    }

}
