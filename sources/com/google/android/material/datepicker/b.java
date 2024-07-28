package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.h.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final a f36184a;

    /* renamed from: b  reason: collision with root package name */
    final a f36185b;

    /* renamed from: c  reason: collision with root package name */
    final a f36186c;

    /* renamed from: d  reason: collision with root package name */
    final a f36187d;

    /* renamed from: e  reason: collision with root package name */
    final a f36188e;

    /* renamed from: f  reason: collision with root package name */
    final a f36189f;

    /* renamed from: g  reason: collision with root package name */
    final a f36190g;

    /* renamed from: h  reason: collision with root package name */
    final Paint f36191h = new Paint();

    b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.h.b.a(context, R.attr.materialCalendarStyle, f.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f36184a = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f36190g = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f36185b = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f36186c = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a2 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f36187d = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f36188e = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f36189f = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        this.f36191h.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
