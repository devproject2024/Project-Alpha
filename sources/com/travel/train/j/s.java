package com.travel.train.j;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import java.util.Calendar;
import net.one97.paytm.i.g;

public final class s extends g implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    private String f27604a;

    /* renamed from: b  reason: collision with root package name */
    private a f27605b;

    public interface a {
        void b(String str);
    }

    public s(String str, a aVar) {
        this.f27604a = str;
        this.f27605b = aVar;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), 16973941, this, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
        datePickerDialog.updateDate(1990, 0, 1);
        if (!TextUtils.isEmpty(this.f27604a)) {
            String[] split = this.f27604a.split("/");
            datePickerDialog.updateDate(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
        }
        return datePickerDialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        this.f27605b.b(i4 + "/" + (i3 + 1) + "/" + i2);
    }
}
