package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.g.d;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.internal.c;
import com.google.android.material.internal.q;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

public class RangeDateSelector implements DateSelector<d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Long unused = rangeDateSelector.f36163c = (Long) parcel.readValue(Long.class.getClassLoader());
            Long unused2 = rangeDateSelector.f36164d = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f36161a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36162b = " ";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Long f36163c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f36164d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Long f36165e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Long f36166f = null;

    private static boolean a(long j, long j2) {
        return j <= j2;
    }

    public int describeContents() {
        return 0;
    }

    public final void a(long j) {
        Long l = this.f36163c;
        if (l == null) {
            this.f36163c = Long.valueOf(j);
        } else if (this.f36164d != null || !a(l.longValue(), j)) {
            this.f36164d = null;
            this.f36163c = Long.valueOf(j);
        } else {
            this.f36164d = Long.valueOf(j);
        }
    }

    public final boolean b() {
        Long l = this.f36163c;
        return (l == null || this.f36164d == null || !a(l.longValue(), this.f36164d.longValue())) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public d<Long, Long> a() {
        return new d<>(this.f36163c, this.f36164d);
    }

    public final Collection<d<Long, Long>> d() {
        if (this.f36163c == null || this.f36164d == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(this.f36163c, this.f36164d));
        return arrayList;
    }

    public final Collection<Long> c() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f36163c;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.f36164d;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public final int b(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return b.a(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, g.class.getCanonicalName());
    }

    public final String a(Context context) {
        d dVar;
        Resources resources = context.getResources();
        if (this.f36163c == null && this.f36164d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l = this.f36164d;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{d.a(this.f36163c.longValue())});
        }
        Long l2 = this.f36163c;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{d.a(this.f36164d.longValue())});
        }
        if (l2 == null && l == null) {
            dVar = d.a(null, null);
        } else if (l2 == null) {
            dVar = d.a(null, d.a(l.longValue()));
        } else if (l == null) {
            dVar = d.a(d.a(l2.longValue()), null);
        } else {
            Calendar a2 = o.a();
            Calendar b2 = o.b();
            b2.setTimeInMillis(l2.longValue());
            Calendar b3 = o.b();
            b3.setTimeInMillis(l.longValue());
            if (b2.get(1) != b3.get(1)) {
                dVar = d.a(d.a(l2.longValue(), Locale.getDefault()), d.a(l.longValue(), Locale.getDefault()));
            } else if (b2.get(1) == a2.get(1)) {
                dVar = d.a(d.b(l2.longValue(), Locale.getDefault()), d.b(l.longValue(), Locale.getDefault()));
            } else {
                dVar = d.a(d.b(l2.longValue(), Locale.getDefault()), d.a(l.longValue(), Locale.getDefault()));
            }
        }
        return resources.getString(R.string.mtrl_picker_range_header_selected, new Object[]{dVar.f2964a, dVar.f2965b});
    }

    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, k<d<Long, Long>> kVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (c.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f36161a = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat c2 = o.c();
        Long l = this.f36163c;
        if (l != null) {
            editText.setText(c2.format(l));
            this.f36165e = this.f36163c;
        }
        Long l2 = this.f36164d;
        if (l2 != null) {
            editText2.setText(c2.format(l2));
            this.f36166f = this.f36164d;
        }
        String a2 = o.a(inflate.getResources(), c2);
        SimpleDateFormat simpleDateFormat = c2;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        final TextInputLayout textInputLayout3 = textInputLayout;
        final TextInputLayout textInputLayout4 = textInputLayout2;
        AnonymousClass1 r9 = r0;
        final k<d<Long, Long>> kVar2 = kVar;
        AnonymousClass1 r0 = new c(a2, simpleDateFormat, textInputLayout, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public final void a(Long l) {
                Long unused = RangeDateSelector.this.f36165e = l;
                RangeDateSelector.a(RangeDateSelector.this, textInputLayout3, textInputLayout4, kVar2);
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                Long unused = RangeDateSelector.this.f36165e = null;
                RangeDateSelector.a(RangeDateSelector.this, textInputLayout3, textInputLayout4, kVar2);
            }
        };
        editText.addTextChangedListener(r9);
        editText2.addTextChangedListener(new c(a2, simpleDateFormat, textInputLayout2, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public final void a(Long l) {
                Long unused = RangeDateSelector.this.f36166f = l;
                RangeDateSelector.a(RangeDateSelector.this, textInputLayout3, textInputLayout4, kVar2);
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                Long unused = RangeDateSelector.this.f36166f = null;
                RangeDateSelector.a(RangeDateSelector.this, textInputLayout3, textInputLayout4, kVar2);
            }
        });
        q.b(editText);
        return inflate;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f36163c);
        parcel.writeValue(this.f36164d);
    }

    static /* synthetic */ void a(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, k kVar) {
        Long l = rangeDateSelector.f36165e;
        if (l == null || rangeDateSelector.f36166f == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.f36161a.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError((CharSequence) null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError((CharSequence) null);
            }
            kVar.a();
        } else if (a(l.longValue(), rangeDateSelector.f36166f.longValue())) {
            rangeDateSelector.f36163c = rangeDateSelector.f36165e;
            rangeDateSelector.f36164d = rangeDateSelector.f36166f;
            kVar.a(rangeDateSelector.a());
        } else {
            textInputLayout.setError(rangeDateSelector.f36161a);
            textInputLayout2.setError(" ");
            kVar.a();
        }
    }
}
