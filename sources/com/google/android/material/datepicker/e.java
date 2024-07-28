package com.google.android.material.datepicker;

import android.os.Build;
import android.widget.BaseAdapter;
import java.util.Calendar;

final class e extends BaseAdapter {

    /* renamed from: d  reason: collision with root package name */
    private static final int f36197d = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f36198a = o.b();

    /* renamed from: b  reason: collision with root package name */
    private final int f36199b = this.f36198a.getMaximum(7);

    /* renamed from: c  reason: collision with root package name */
    private final int f36200c = this.f36198a.getFirstDayOfWeek();

    public final long getItemId(int i2) {
        return 0;
    }

    public final int getCount() {
        return this.f36199b;
    }

    /* JADX WARNING: type inference failed for: r7v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x0017
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day_of_week
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0017:
            java.util.Calendar r7 = r5.f36198a
            int r6 = r5.a(r6)
            r2 = 7
            r7.set(r2, r6)
            java.util.Calendar r6 = r5.f36198a
            int r7 = f36197d
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getDisplayName(r2, r7, r3)
            r0.setText(r6)
            android.content.Context r6 = r8.getContext()
            int r7 = com.google.android.material.R.string.mtrl_picker_day_of_week_column_header
            java.lang.String r6 = r6.getString(r7)
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.util.Calendar r8 = r5.f36198a
            r3 = 2
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r8 = r8.getDisplayName(r2, r3, r4)
            r7[r1] = r8
            java.lang.String r6 = java.lang.String.format(r6, r7)
            r0.setContentDescription(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.e.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private int a(int i2) {
        int i3 = i2 + this.f36200c;
        int i4 = this.f36199b;
        return i3 > i4 ? i3 - i4 : i3;
    }

    public final /* synthetic */ Object getItem(int i2) {
        if (i2 >= this.f36199b) {
            return null;
        }
        return Integer.valueOf(a(i2));
    }
}
