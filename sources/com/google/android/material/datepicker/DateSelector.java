package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.d;
import java.util.Collection;

public interface DateSelector<S> extends Parcelable {
    View a(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, k<S> kVar);

    S a();

    String a(Context context);

    void a(long j);

    int b(Context context);

    boolean b();

    Collection<Long> c();

    Collection<d<Long, Long>> d();
}
