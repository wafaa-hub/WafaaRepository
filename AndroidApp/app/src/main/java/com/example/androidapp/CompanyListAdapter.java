package com.example.androidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CompanyListAdapter extends ArrayAdapter<String> {

    private Context context;
    private int resource;
    private ArrayList<String> marketWatchData;

    public CompanyListAdapter(@NonNull Context context, int resource, ArrayList<String> marketWatchData) {
        super(context, resource, marketWatchData);
        this.context = context;
        this.resource = resource;
        this.marketWatchData = marketWatchData;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.listadapterview, parent, false);
        String m = marketWatchData.get(position);

        TextView Symbol = convertView.findViewById(R.id.symbol);
        TextView Close = convertView.findViewById(R.id.close);
        TextView Value = convertView.findViewById(R.id.value);

        Symbol.setText(marketWatchData.get(0));
        Close.setText(marketWatchData.get(1));
        Value.setText(marketWatchData.get(2));

        return convertView;
    }
}
