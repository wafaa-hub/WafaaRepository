package com.example.androidapp;

import android.content.Context;
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

public class CompanyListViewAdapter extends ArrayAdapter<Company> {

    private Context context;
    private List<Company> list;


    public CompanyListViewAdapter(@NonNull Context context, int resource, List<Company> companies) {
        super(context, resource, companies);

        this.context = context;
        list = companies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Company company = list.get(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listadapterview, parent, false);
        }

        TextView value = convertView.findViewById(R.id.value);
        TextView symbol = convertView.findViewById(R.id.symbol);
        TextView close = convertView.findViewById(R.id.close);

        if (position % 2 == 0) {
            symbol.setBackgroundResource(R.drawable.greyrow);
            close.setBackgroundResource(R.drawable.bluerowlight);
            value.setBackgroundResource(R.drawable.greyrow);

        } else {
            symbol.setBackgroundResource(R.drawable.blackrow);
            close.setBackgroundResource(R.drawable.bluerowdark);
            value.setBackgroundResource(R.drawable.blackrow);
        }

        symbol.setText(company.getTopic ());
        close.setText(company.getPclose());
        value.setText(company.getLastvalue());

        Animation animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);

        if (company.islastHasChanged()) {
            close.startAnimation(animFadeIn);
            company.setlastHasChanged(false);
        }

        return convertView;
    }


}
