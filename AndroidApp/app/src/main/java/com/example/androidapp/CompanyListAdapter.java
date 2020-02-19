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

        Value.setText(String.format("{0:000,000,000}", company.lastvalue));
        Close.setText(company.pclose);
        Symbol.setText(company.topic.substring(3,7));

        return convertView;
    }
}
