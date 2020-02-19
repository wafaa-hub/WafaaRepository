package com.example.androidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CompanyListAdapter extends ArrayAdapter<Company> {

    private Context context;
    private int resource;
    private ArrayList<Company> list;

    public CompanyListAdapter(@NonNull Context context, int resource, ArrayList<Company> list) {
        super(context,resource);

        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.listadapterview, parent, false);
        Company company = list.get(position);

        TextView Value = convertView.findViewById(R.id.value);
        TextView Symbol = convertView.findViewById(R.id.symbol);
        TextView Close = convertView.findViewById(R.id.close);

        double value = Double.parseDouble(company.lastvalue);
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        Value.setText(formatter.format(value));
        Close.setText(company.pclose);
        Symbol.setText(company.topic.substring(3,7));

        return convertView;
    }
}
