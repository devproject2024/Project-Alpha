package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.h.u;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.f;

final class j extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final f.b f36249a;

    /* renamed from: b  reason: collision with root package name */
    private final CalendarConstraints f36250b;

    /* renamed from: c  reason: collision with root package name */
    private final DateSelector<?> f36251c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36252d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        Month b2 = this.f36250b.f36137a.b(i2);
        aVar.f36255a.setText(b2.f36155b);
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.f36256b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !b2.equals(materialCalendarGridView.a().f36245b)) {
            i iVar = new i(b2, this.f36251c, this.f36250b);
            materialCalendarGridView.setNumColumns(b2.f36158e);
            materialCalendarGridView.setAdapter((ListAdapter) iVar);
        } else {
            materialCalendarGridView.a().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                i a2 = materialCalendarGridView.a();
                if (i2 >= a2.f36245b.b() && i2 <= a2.a()) {
                    j.this.f36249a.a(materialCalendarGridView.a().getItem(i2).longValue());
                }
            }
        });
    }

    j(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, f.b bVar) {
        Month month = calendarConstraints.f36137a;
        Month month2 = calendarConstraints.f36138b;
        Month month3 = calendarConstraints.f36139c;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (month3.compareTo(month2) <= 0) {
            this.f36252d = (i.f36244a * f.a(context)) + (g.a(context) ? f.a(context) : 0);
            this.f36250b = calendarConstraints;
            this.f36251c = dateSelector;
            this.f36249a = bVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f36255a;

        /* renamed from: b  reason: collision with root package name */
        final MaterialCalendarGridView f36256b;

        a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            this.f36255a = (TextView) linearLayout.findViewById(R.id.month_title);
            u.S(this.f36255a);
            this.f36256b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z) {
                this.f36255a.setVisibility(8);
            }
        }
    }

    public final long getItemId(int i2) {
        return this.f36250b.f36137a.b(i2).f36154a.getTimeInMillis();
    }

    public final int getItemCount() {
        return this.f36250b.f36142f;
    }

    /* access modifiers changed from: package-private */
    public final Month a(int i2) {
        return this.f36250b.f36137a.b(i2);
    }

    /* access modifiers changed from: package-private */
    public final int a(Month month) {
        return this.f36250b.f36137a.b(month);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!g.a(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f36252d));
        return new a(linearLayout, true);
    }
}
