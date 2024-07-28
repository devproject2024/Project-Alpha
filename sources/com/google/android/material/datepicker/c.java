package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class c implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final String f36192a;

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f36193b;

    /* renamed from: c  reason: collision with root package name */
    private final TextInputLayout f36194c;

    /* renamed from: d  reason: collision with root package name */
    private final CalendarConstraints f36195d;

    /* renamed from: e  reason: collision with root package name */
    private final String f36196e;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Long l);

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    c(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f36192a = str;
        this.f36193b = dateFormat;
        this.f36194c = textInputLayout;
        this.f36195d = calendarConstraints;
        this.f36196e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f36194c.setError((CharSequence) null);
            a((Long) null);
            return;
        }
        try {
            Date parse = this.f36193b.parse(charSequence.toString());
            this.f36194c.setError((CharSequence) null);
            long time = parse.getTime();
            if (this.f36195d.f36140d.a(time)) {
                CalendarConstraints calendarConstraints = this.f36195d;
                if (calendarConstraints.f36137a.a(1) <= time && time <= calendarConstraints.f36138b.a(calendarConstraints.f36138b.f36159f)) {
                    a(Long.valueOf(parse.getTime()));
                    return;
                }
            }
            this.f36194c.setError(String.format(this.f36196e, new Object[]{d.a(time)}));
            a();
        } catch (ParseException unused) {
            String string = this.f36194c.getContext().getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(this.f36194c.getContext().getString(R.string.mtrl_picker_invalid_format_use), new Object[]{this.f36192a});
            String format2 = String.format(this.f36194c.getContext().getString(R.string.mtrl_picker_invalid_format_example), new Object[]{this.f36193b.format(new Date(o.a().getTimeInMillis()))});
            TextInputLayout textInputLayout = this.f36194c;
            textInputLayout.setError(string + StringUtility.NEW_LINE + format + StringUtility.NEW_LINE + format2);
            a();
        }
    }
}
