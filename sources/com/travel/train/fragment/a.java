package com.travel.train.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import net.one97.paytm.i.g;

public class a extends g implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    private EditText f26711a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f26712b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f26713c;

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public a(EditText editText, EditText editText2, EditText editText3) {
        this.f26711a = editText;
        this.f26712b = editText2;
        this.f26713c = editText3;
    }

    public a() {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), 16973941, this, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
        datePickerDialog.updateDate(1990, 0, 1);
        return datePickerDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append("/");
        int i5 = i3 + 1;
        sb.append(i5);
        sb.append("/");
        sb.append(i2);
        if (sb.toString() != null) {
            this.f26711a.setText(Integer.toString(i4));
            this.f26712b.setText(Integer.toString(i5));
            this.f26713c.setText(Integer.toString(i2));
        }
    }
}
