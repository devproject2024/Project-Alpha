package com.travel.flight.flightticket.j;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.travel.flight.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import net.one97.paytm.i.g;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;

public class w extends g implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    CJRDynamicValidation f25223a;

    /* renamed from: b  reason: collision with root package name */
    Context f25224b;

    /* renamed from: c  reason: collision with root package name */
    TextView f25225c;

    /* renamed from: d  reason: collision with root package name */
    String f25226d;

    public w() {
    }

    public w(TextView textView, Context context, String str) {
        this.f25223a = (CJRDynamicValidation) textView.getTag();
        this.f25224b = context;
        this.f25225c = textView;
        this.f25226d = str;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance(Locale.ENGLISH);
        if (!TextUtils.isEmpty(this.f25226d)) {
            getContext();
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(b.d(this.f25226d, "dd/MM/yyyy", "yyyy-MM-dd"));
            } catch (ParseException unused) {
            }
            instance.setTime(date);
        }
        int i2 = instance.get(2);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), 16973939, this, instance.get(1), i2, instance.get(5));
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        textView.setPadding(20, 20, 20, 20);
        textView.setTextSize(1, 20.0f);
        textView.setText("Choose Date");
        textView.setTextColor(Color.parseColor("#000000"));
        datePickerDialog.setCustomTitle(textView);
        datePickerDialog.setButton(-1, this.f25224b.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DatePicker datePicker = datePickerDialog.getDatePicker();
                w.this.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            }
        });
        datePickerDialog.setButton(-2, this.f25224b.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        CJRDynamicValidation cJRDynamicValidation = this.f25223a;
        if (cJRDynamicValidation != null) {
            if (cJRDynamicValidation.getAfter() != null) {
                datePickerDialog.getDatePicker().setMinDate(Long.parseLong(cJRDynamicValidation.getAfter()) * 1000);
            }
            if (cJRDynamicValidation.getBefore() != null) {
                datePickerDialog.getDatePicker().setMaxDate((Long.parseLong(cJRDynamicValidation.getBefore()) * 1000) - 1000);
            }
        }
        return datePickerDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        TextView textView;
        CJRDynamicValidation cJRDynamicValidation;
        String str = i4 + "/" + (i3 + 1) + "/" + i2;
        if (str != null && (textView = this.f25225c) != null && (cJRDynamicValidation = (CJRDynamicValidation) textView.getTag()) != null) {
            cJRDynamicValidation.setmValue(str);
            this.f25225c.setText(str);
            this.f25225c.setTag(cJRDynamicValidation);
            this.f25225c.performLongClick();
        }
    }
}
