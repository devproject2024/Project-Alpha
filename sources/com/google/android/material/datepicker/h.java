package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class h<S> extends l<S> {

    /* renamed from: a  reason: collision with root package name */
    private DateSelector<S> f36241a;

    /* renamed from: b  reason: collision with root package name */
    private CalendarConstraints f36242b;

    static <T> h<T> a(DateSelector<T> dateSelector, CalendarConstraints calendarConstraints) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        hVar.setArguments(bundle);
        return hVar;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f36241a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f36242b);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f36241a = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f36242b = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f36241a.a(layoutInflater, viewGroup, this.f36242b, new k<S>() {
            public final void a(S s) {
                Iterator it2 = h.this.j.iterator();
                while (it2.hasNext()) {
                    ((k) it2.next()).a(s);
                }
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                Iterator it2 = h.this.j.iterator();
                while (it2.hasNext()) {
                    ((k) it2.next()).a();
                }
            }
        });
    }
}
