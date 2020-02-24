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

public class CompanyListAdapter extends ArrayAdapter<Company> {

    private Context context;
    private int resource;
    private List<Company> list;
    TextView Value, Symbol, Close;
    boolean flag;

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

        Symbol.setText(company.getTopic().substring(3, 7));

        if (company.getLastvalue().equals("#")) {
            Value.setText(company.getLastvalue());
        } else {
            String pattern = "###,###.###";
            DecimalFormat formatter = new DecimalFormat(pattern);
            double value = Double.parseDouble(company.getLastvalue());
            Value.setText(formatter.format(value));
        }

        String close = company.getPclose();
        Close.setText(close);

        Animation animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);

        if (flag) {
            Close.startAnimation(animFadeIn);
        }

        return convertView;
    }

    public void Flag(boolean flag) {

        this.flag = flag;

    }
}
