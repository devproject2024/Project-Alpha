package net.one97.paytm.common.widgets;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.business.merchant_payments.utility.MPConstants;
import java.lang.reflect.Field;
import java.util.Calendar;

public final class d extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    Activity f49887a;

    /* renamed from: b  reason: collision with root package name */
    DatePicker f49888b;

    /* renamed from: c  reason: collision with root package name */
    TextView f49889c;

    /* renamed from: d  reason: collision with root package name */
    TextView f49890d;

    /* renamed from: e  reason: collision with root package name */
    TextView f49891e;

    /* renamed from: f  reason: collision with root package name */
    public a f49892f;

    /* renamed from: g  reason: collision with root package name */
    int f49893g;

    /* renamed from: h  reason: collision with root package name */
    int f49894h;

    /* renamed from: i  reason: collision with root package name */
    int f49895i;
    String j;

    public interface a {
        void a(int i2, int i3, int i4);
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.f49887a = getActivity();
    }

    public static d a() {
        return new d();
    }

    public static d a(int i2, int i3, int i4) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putInt("day_of_month", i2);
        bundle.putInt(MPConstants.PaymentSummaryRange.MONTH, i3);
        bundle.putInt("year", i4);
        dVar.setArguments(bundle);
        return dVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f49893g = getArguments().getInt("day_of_month");
            this.f49894h = getArguments().getInt("year");
            this.f49895i = getArguments().getInt(MPConstants.PaymentSummaryRange.MONTH);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.custom_date_picker_layout, viewGroup, false);
        this.f49891e = (TextView) inflate.findViewById(R.id.custom_date_picker_date_tv);
        this.f49888b = (DatePicker) inflate.findViewById(R.id.custom_date_picker_dp);
        this.f49889c = (TextView) inflate.findViewById(R.id.custom_date_picker_done_tv);
        this.f49890d = (TextView) inflate.findViewById(R.id.custom_date_picker_cancel_tv);
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        if (getArguments() == null) {
            int i5 = i3 + 1;
            this.j = a(i5);
            this.f49895i = i5;
            this.f49894h = i2;
            this.f49893g = i4;
        } else {
            this.j = a(this.f49895i);
        }
        TextView textView = this.f49891e;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f49893g);
        sb.append(" ");
        sb.append(this.j);
        sb.append(", ");
        sb.append(this.f49894h);
        textView.setText(sb);
        DatePicker datePicker = this.f49888b;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("day", "id", "android");
        int identifier2 = system.getIdentifier(MPConstants.PaymentSummaryRange.MONTH, "id", "android");
        int identifier3 = system.getIdentifier("year", "id", "android");
        a((NumberPicker) datePicker.findViewById(identifier));
        a((NumberPicker) datePicker.findViewById(identifier2));
        a((NumberPicker) datePicker.findViewById(identifier3));
        datePicker.setDescendantFocusability(393216);
        this.f49889c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (d.this.f49892f != null) {
                    d.this.f49892f.a(d.this.f49893g, d.this.f49895i, d.this.f49894h);
                    d.this.dismiss();
                }
            }
        });
        this.f49890d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (d.this.f49892f != null) {
                    d.this.dismiss();
                }
            }
        });
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        this.f49888b.init(this.f49894h, this.f49895i - 1, this.f49893g, new DatePicker.OnDateChangedListener() {
            public final void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
                d dVar = d.this;
                dVar.f49893g = i4;
                dVar.f49894h = i2;
                int i5 = i3 + 1;
                dVar.j = dVar.a(i5);
                d dVar2 = d.this;
                dVar2.f49895i = i5;
                TextView textView = dVar2.f49891e;
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append(" ");
                sb.append(d.this.a(i5));
                sb.append(", ");
                sb.append(i2);
                textView.setText(sb);
            }
        });
        return inflate;
    }

    private static void a(NumberPicker numberPicker) {
        if (numberPicker != null) {
            int childCount = numberPicker.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                try {
                    Field declaredField = numberPicker.getClass().getDeclaredField("mSelectionDivider");
                    declaredField.setAccessible(true);
                    declaredField.set(numberPicker, new ColorDrawable(numberPicker.getResources().getColor(R.color.paytm_blue)));
                    numberPicker.invalidate();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String a(int i2) {
        return getResources().getStringArray(R.array.months_in_calender)[i2 - 1];
    }
}
