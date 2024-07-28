package com.paytm.business.merchantprofile.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class PfbSpinnerAdapter extends ArrayAdapter<String> {
    public PfbSpinnerAdapter(Context context, int i2, List<String> list) {
        super(context, i2, list);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        return (TextView) super.getView(i2, view, viewGroup);
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return (TextView) super.getDropDownView(i2, view, viewGroup);
    }
}
