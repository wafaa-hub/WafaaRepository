package com.example.androidapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CompanyListAdapter extends ArrayAdapter<Company> {

    private Context context;
    private int resource;
    private List<Company> list;
    TextView Value, Symbol, Close;

    public CompanyListAdapter(@NonNull Context context, int resource, List<Company> list) {
        super(context, resource, list);

        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Company company = list.get(position);

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listadapterview, parent, false);
            Value = convertView.findViewById(R.id.value);
            Symbol = convertView.findViewById(R.id.symbol);
            Close = convertView.findViewById(R.id.close);
        }

        Animation animFadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        Close.startAnimation(animFadeIn);

        if (company.getLastvalue().equals("#")) {
            Value.setText(company.getLastvalue());
        } else {
            String pattern = "###,###.###";
            DecimalFormat formatter = new DecimalFormat(pattern);
            double value = Double.parseDouble(company.getLastvalue());
            Value.setText(formatter.format(value));
        }
        Symbol.setText(company.getTopic().substring(3, 7));
        Close.setText(company.getPclose());

        return convertView;
    }
}
