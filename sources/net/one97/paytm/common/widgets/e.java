package net.one97.paytm.common.widgets;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.one97.paytm.common.widgets.a.d;

public class e extends b implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public d f49899a;

    /* renamed from: b  reason: collision with root package name */
    Date f49900b = null;

    /* renamed from: c  reason: collision with root package name */
    Date f49901c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f49902d;

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        SimpleDateFormat simpleDateFormat;
        Fragment parentFragment = getParentFragment();
        try {
            if (parentFragment instanceof d) {
                this.f49899a = (d) parentFragment;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        String string = getArguments().getString("default_dob");
        String str2 = null;
        this.f49902d = null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String str3 = arguments.containsKey("max_date") ? (String) arguments.get("max_date") : null;
            if (arguments.containsKey("min_date")) {
                str2 = (String) arguments.get("min_date");
            }
            if (arguments.containsKey("date_format")) {
                this.f49902d = (String) arguments.get("date_format");
            }
            str = str2;
            str2 = str3;
        } else {
            str = null;
        }
        String str4 = this.f49902d;
        if (str4 != null) {
            simpleDateFormat = new SimpleDateFormat(str4);
        } else {
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }
        if (str2 != null) {
            try {
                this.f49900b = simpleDateFormat.parse(str2);
            } catch (ParseException e3) {
                q.b(e3.getMessage());
            }
        }
        if (str != null) {
            this.f49901c = simpleDateFormat.parse(str);
        }
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(simpleDateFormat.parse(string));
        } catch (Exception e4) {
            q.b(e4.getMessage());
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM");
        int i2 = instance.get(1);
        int parseInt = Integer.parseInt(simpleDateFormat2.format(instance.getTime()));
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.PaytmCommonDatePickerTheme, this, i2, parseInt == 0 ? 0 : parseInt - 1, instance.get(5));
        if (com.paytm.utility.b.d() >= 11) {
            Calendar instance2 = Calendar.getInstance();
            if (this.f49900b != null) {
                datePickerDialog.getDatePicker().setMaxDate(this.f49900b.getTime());
            } else {
                datePickerDialog.getDatePicker().setMaxDate(instance2.getTimeInMillis());
            }
            if (this.f49901c != null) {
                datePickerDialog.getDatePicker().setMinDate(this.f49901c.getTime());
            }
        }
        return datePickerDialog;
    }

    public final void a(d dVar) {
        this.f49899a = dVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            if (activity instanceof d) {
                this.f49899a = (d) activity;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        d dVar;
        if (datePicker.isShown() && (dVar = this.f49899a) != null) {
            if (this.f49902d != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append("/");
                int i5 = i3 + 1;
                sb.append(i5);
                sb.append("/");
                sb.append(i2);
                try {
                    this.f49899a.setSelectedDate(new SimpleDateFormat(this.f49902d).format(new SimpleDateFormat("dd/MM/yyyy").parse(sb.toString())));
                } catch (ParseException unused) {
                    d dVar2 = this.f49899a;
                    dVar2.setSelectedDate(i4 + "/" + i5 + "/" + i2);
                }
            } else {
                dVar.setSelectedDate(i4 + "/" + (i3 + 1) + "/" + i2);
            }
        }
    }
}
