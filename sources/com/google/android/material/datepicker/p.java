package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.f;
import java.util.Calendar;
import java.util.Locale;

final class p extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final f<?> f36262a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        final int i3 = this.f36262a.f36206f.f36137a.f36157d + i2;
        String string = aVar.f36265a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        aVar.f36265a.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i3)}));
        aVar.f36265a.setContentDescription(String.format(string, new Object[]{Integer.valueOf(i3)}));
        b bVar = this.f36262a.f36209i;
        Calendar a2 = o.a();
        a aVar2 = a2.get(1) == i3 ? bVar.f36189f : bVar.f36187d;
        for (Long longValue : this.f36262a.f36205e.c()) {
            a2.setTimeInMillis(longValue.longValue());
            if (a2.get(1) == i3) {
                aVar2 = bVar.f36188e;
            }
        }
        aVar2.a(aVar.f36265a);
        aVar.f36265a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Month a2 = Month.a(i3, p.this.f36262a.f36207g.f36156c);
                CalendarConstraints calendarConstraints = p.this.f36262a.f36206f;
                if (a2.compareTo(calendarConstraints.f36137a) < 0) {
                    a2 = calendarConstraints.f36137a;
                } else if (a2.compareTo(calendarConstraints.f36138b) > 0) {
                    a2 = calendarConstraints.f36138b;
                }
                p.this.f36262a.a(a2);
                p.this.f36262a.a(f.a.DAY);
            }
        });
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f36265a;

        a(TextView textView) {
            super(textView);
            this.f36265a = textView;
        }
    }

    p(f<?> fVar) {
        this.f36262a = fVar;
    }

    public final int getItemCount() {
        return this.f36262a.f36206f.f36141e;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2) {
        return i2 - this.f36262a.f36206f.f36137a.f36157d;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
