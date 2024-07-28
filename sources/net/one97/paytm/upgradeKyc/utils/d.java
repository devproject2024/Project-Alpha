package net.one97.paytm.upgradeKyc.utils;

import android.app.Activity;
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
import net.one97.paytm.common.widgets.R;
import net.one97.paytm.i.g;

public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    Activity f66318a;

    /* renamed from: b  reason: collision with root package name */
    DatePicker f66319b;

    /* renamed from: c  reason: collision with root package name */
    TextView f66320c;

    /* renamed from: d  reason: collision with root package name */
    TextView f66321d;

    /* renamed from: e  reason: collision with root package name */
    TextView f66322e;

    /* renamed from: f  reason: collision with root package name */
    public a f66323f;

    /* renamed from: g  reason: collision with root package name */
    int f66324g;

    /* renamed from: h  reason: collision with root package name */
    int f66325h;

    /* renamed from: i  reason: collision with root package name */
    int f66326i;
    String j;

    public interface a {
        void a(int i2, int i3, int i4);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f66318a = getActivity();
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f66324g = getArguments().getInt("day_of_month");
            this.f66325h = getArguments().getInt("year");
            this.f66326i = getArguments().getInt(MPConstants.PaymentSummaryRange.MONTH);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.custom_date_picker_layout, viewGroup, false);
        getDialog().requestWindowFeature(1);
        this.f66322e = (TextView) inflate.findViewById(R.id.custom_date_picker_date_tv);
        this.f66319b = (DatePicker) inflate.findViewById(R.id.custom_date_picker_dp);
        this.f66320c = (TextView) inflate.findViewById(R.id.custom_date_picker_done_tv);
        this.f66321d = (TextView) inflate.findViewById(R.id.custom_date_picker_cancel_tv);
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        if (getArguments() == null) {
            int i5 = i3 + 1;
            this.j = a(i5);
            this.f66326i = i5;
            this.f66325h = i2;
            this.f66324g = i4;
        } else {
            this.j = a(this.f66326i);
        }
        TextView textView = this.f66322e;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f66324g);
        sb.append(" ");
        sb.append(this.j);
        sb.append(", ");
        sb.append(this.f66325h);
        textView.setText(sb);
        DatePicker datePicker = this.f66319b;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("day", "id", "android");
        int identifier2 = system.getIdentifier(MPConstants.PaymentSummaryRange.MONTH, "id", "android");
        int identifier3 = system.getIdentifier("year", "id", "android");
        a((NumberPicker) datePicker.findViewById(identifier));
        a((NumberPicker) datePicker.findViewById(identifier2));
        a((NumberPicker) datePicker.findViewById(identifier3));
        datePicker.setDescendantFocusability(393216);
        this.f66320c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
        this.f66321d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        this.f66319b.init(this.f66325h, this.f66326i - 1, this.f66324g, new DatePicker.OnDateChangedListener() {
            public final void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
                d.this.a(datePicker, i2, i3, i4);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a aVar = this.f66323f;
        if (aVar != null) {
            aVar.a(this.f66324g, this.f66326i, this.f66325h);
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.f66323f != null) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DatePicker datePicker, int i2, int i3, int i4) {
        this.f66324g = i4;
        this.f66325h = i2;
        int i5 = i3 + 1;
        this.j = a(i5);
        this.f66326i = i5;
        TextView textView = this.f66322e;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append(" ");
        sb.append(a(i5));
        sb.append(", ");
        sb.append(i2);
        textView.setText(sb);
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

    private String a(int i2) {
        return getResources().getStringArray(R.array.months_in_calender)[i2 - 1];
    }

    public final void a(a aVar) {
        this.f66323f = aVar;
    }
}
