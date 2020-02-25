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

    private  Context        context;
    private  List<Company>  list;
    private  TextView       Value;
    private  TextView       Symbol;
    private  TextView       Close;
    private  int            resource;

    public CompanyListViewAdapter(@NonNull Context context, int resource, List<Company> companies) {
        super(context, resource, companies);

        this.context  =  context;
        this.resource =  resource;
        list          =  companies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Company company = list.get(position);

        if (convertView == null) {

            LayoutInflater inflater =  LayoutInflater.from(getContext());
            convertView             =  inflater.inflate(R.layout.listadapterview, parent, false);
        }

        Value  = convertView.findViewById(R.id.value);
        Symbol = convertView.findViewById(R.id.symbol);
        Close  = convertView.findViewById(R.id.close);

        if (position % 2 == 0) {

            Symbol.setBackgroundResource(R.drawable.greyrow);
            Close. setBackgroundResource(R.drawable.bluerowlight);
            Value. setBackgroundResource(R.drawable.greyrow);

        } else {

            Symbol.setBackgroundResource(R.drawable.blackrow);
            Close. setBackgroundResource(R.drawable.bluerowdark);
            Value. setBackgroundResource(R.drawable.blackrow);
        }

        if (company.getTopic().isEmpty()) {

            Symbol.setText(company.getTopic());

        } else {

            Symbol.setText(company.getTopic().substring(3, 7));
        }

        if (company.getLastvalue().equals("#")) {

            Value.setText(company.getLastvalue());

        } else {

            String pattern          = "###,###.###";
            DecimalFormat formatter = new DecimalFormat(pattern);
            double value            = Double.parseDouble(company.getLastvalue());

            Value.setText(formatter.format(value));

        }

            Close.setText(company.getPclose());

            Animation animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);

        if (company.isFlag()) {

            Close.  startAnimation(animFadeIn);
            company.setFlag(false);

        }

         return convertView;
    }


}
