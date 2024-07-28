package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
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
import java.util.Collection;
import java.util.Locale;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.f36175a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Long f36175a;

    public int describeContents() {
        return 0;
    }

    public final void a(long j) {
        this.f36175a = Long.valueOf(j);
    }

    public final boolean b() {
        return this.f36175a != null;
    }

    public final Collection<d<Long, Long>> d() {
        return new ArrayList();
    }

    public final Collection<Long> c() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f36175a;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, k<Long> kVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (c.b()) {
            editText.setInputType(17);
        }
        SimpleDateFormat c2 = o.c();
        String a2 = o.a(inflate.getResources(), c2);
        Long l = this.f36175a;
        if (l != null) {
            editText.setText(c2.format(l));
        }
        final k<Long> kVar2 = kVar;
        editText.addTextChangedListener(new c(a2, c2, textInputLayout, calendarConstraints) {
            /* access modifiers changed from: package-private */
            public final void a(Long l) {
                if (l == null) {
                    SingleDateSelector.this.f36175a = null;
                } else {
                    SingleDateSelector.this.a(l.longValue());
                }
                kVar2.a(SingleDateSelector.this.f36175a);
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                kVar2.a();
            }
        });
        q.b(editText);
        return inflate;
    }

    public final int b(Context context) {
        return b.a(context, R.attr.materialCalendarTheme, g.class.getCanonicalName());
    }

    public final String a(Context context) {
        Resources resources = context.getResources();
        Long l = this.f36175a;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        String a2 = d.a(l.longValue(), Locale.getDefault());
        return resources.getString(R.string.mtrl_picker_date_header_selected, new Object[]{a2});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f36175a);
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return this.f36175a;
    }
}
