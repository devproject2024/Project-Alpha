package com.google.android.material.datepicker;

import android.widget.BaseAdapter;

class i extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    static final int f36244a = o.b().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    final Month f36245b;

    /* renamed from: c  reason: collision with root package name */
    final DateSelector<?> f36246c;

    /* renamed from: d  reason: collision with root package name */
    b f36247d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f36248e;

    public boolean hasStableIds() {
        return true;
    }

    i(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f36245b = month;
        this.f36246c = dateSelector;
        this.f36248e = calendarConstraints;
    }

    /* renamed from: a */
    public final Long getItem(int i2) {
        if (i2 < this.f36245b.b() || i2 > a()) {
            return null;
        }
        return Long.valueOf(this.f36245b.a(c(i2)));
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.f36245b.f36158e);
    }

    public int getCount() {
        return this.f36245b.f36159f + this.f36245b.b();
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return (this.f36245b.b() + this.f36245b.f36159f) - 1;
    }

    private int c(int i2) {
        return (i2 - this.f36245b.b()) + 1;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        return this.f36245b.b() + (i2 - 1);
    }

    /* JADX WARNING: type inference failed for: r8v30, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            r6 = this;
            android.content.Context r0 = r9.getContext()
            com.google.android.material.datepicker.b r1 = r6.f36247d
            if (r1 != 0) goto L_0x000f
            com.google.android.material.datepicker.b r1 = new com.google.android.material.datepicker.b
            r1.<init>(r0)
            r6.f36247d = r1
        L_0x000f:
            r0 = r8
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r8 != 0) goto L_0x0026
            android.content.Context r8 = r9.getContext()
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r8 = r8.inflate(r0, r9, r1)
            r0 = r8
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0026:
            com.google.android.material.datepicker.Month r8 = r6.f36245b
            int r8 = r8.b()
            int r8 = r7 - r8
            r9 = 1
            if (r8 < 0) goto L_0x00ae
            com.google.android.material.datepicker.Month r2 = r6.f36245b
            int r2 = r2.f36159f
            if (r8 < r2) goto L_0x0039
            goto L_0x00ae
        L_0x0039:
            int r8 = r8 + r9
            com.google.android.material.datepicker.Month r2 = r6.f36245b
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r8)
            r0.setText(r2)
            com.google.android.material.datepicker.Month r2 = r6.f36245b
            long r2 = r2.a((int) r8)
            com.google.android.material.datepicker.Month r8 = r6.f36245b
            int r8 = r8.f36157d
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.a()
            int r4 = r4.f36157d
            r5 = 24
            if (r8 != r4) goto L_0x0081
            java.util.Locale r8 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x0070
            android.icu.text.DateFormat r8 = com.google.android.material.datepicker.o.c(r8)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r8 = r8.format(r4)
            goto L_0x007d
        L_0x0070:
            java.text.DateFormat r8 = com.google.android.material.datepicker.o.g(r8)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r8 = r8.format(r4)
        L_0x007d:
            r0.setContentDescription(r8)
            goto L_0x00a7
        L_0x0081:
            java.util.Locale r8 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x0097
            android.icu.text.DateFormat r8 = com.google.android.material.datepicker.o.d(r8)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r8 = r8.format(r4)
            goto L_0x00a4
        L_0x0097:
            java.text.DateFormat r8 = com.google.android.material.datepicker.o.g(r8)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r8 = r8.format(r4)
        L_0x00a4:
            r0.setContentDescription(r8)
        L_0x00a7:
            r0.setVisibility(r1)
            r0.setEnabled(r9)
            goto L_0x00b6
        L_0x00ae:
            r8 = 8
            r0.setVisibility(r8)
            r0.setEnabled(r1)
        L_0x00b6:
            java.lang.Long r7 = r6.getItem(r7)
            if (r7 != 0) goto L_0x00bd
            return r0
        L_0x00bd:
            com.google.android.material.datepicker.CalendarConstraints r8 = r6.f36248e
            com.google.android.material.datepicker.CalendarConstraints$DateValidator r8 = r8.f36140d
            long r2 = r7.longValue()
            boolean r8 = r8.a(r2)
            if (r8 == 0) goto L_0x0120
            r0.setEnabled(r9)
            com.google.android.material.datepicker.DateSelector<?> r8 = r6.f36246c
            java.util.Collection r8 = r8.c()
            java.util.Iterator r8 = r8.iterator()
        L_0x00d8:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0100
            java.lang.Object r9 = r8.next()
            java.lang.Long r9 = (java.lang.Long) r9
            long r1 = r9.longValue()
            long r3 = r7.longValue()
            long r3 = com.google.android.material.datepicker.o.a((long) r3)
            long r1 = com.google.android.material.datepicker.o.a((long) r1)
            int r9 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r9 != 0) goto L_0x00d8
            com.google.android.material.datepicker.b r7 = r6.f36247d
            com.google.android.material.datepicker.a r7 = r7.f36185b
            r7.a(r0)
            return r0
        L_0x0100:
            java.util.Calendar r8 = com.google.android.material.datepicker.o.a()
            long r8 = r8.getTimeInMillis()
            long r1 = r7.longValue()
            int r7 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0118
            com.google.android.material.datepicker.b r7 = r6.f36247d
            com.google.android.material.datepicker.a r7 = r7.f36186c
            r7.a(r0)
            return r0
        L_0x0118:
            com.google.android.material.datepicker.b r7 = r6.f36247d
            com.google.android.material.datepicker.a r7 = r7.f36184a
            r7.a(r0)
            return r0
        L_0x0120:
            r0.setEnabled(r1)
            com.google.android.material.datepicker.b r7 = r6.f36247d
            com.google.android.material.datepicker.a r7 = r7.f36190g
            r7.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.i.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
