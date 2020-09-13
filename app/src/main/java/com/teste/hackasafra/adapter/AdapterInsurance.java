package com.teste.hackasafra.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.hackasafra.R;
import com.teste.hackasafra.model.Insurance;

import java.util.List;

public class AdapterInsurance extends RecyclerView.Adapter <AdapterInsurance.InsuranceViewHolder> {

    private List<Insurance> listInsurance;

    public AdapterInsurance ( List<Insurance> list){
        this.listInsurance = list;
    }

    @NonNull
    @Override
    public InsuranceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Create all user visualizations
        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_insurance, parent, false); // Used to convert .xml in visualization

        return new InsuranceViewHolder( itemList );
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceViewHolder holder, int position) { // Each of the elements exhibition

        Insurance insurance = listInsurance.get( position );

        holder.description.setText( insurance.getDescription() );
        holder.value.setText( insurance.getValue() );

    }

    @Override
    public int getItemCount() {
        return listInsurance.size();
    }

    public class InsuranceViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        TextView value;

        public InsuranceViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.textDescription);
            value = itemView.findViewById(R.id.textValue);

        }
    }

}
