package net.one97.paytm.paymentsBank.utils;

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
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    Activity f19499a;

    /* renamed from: b  reason: collision with root package name */
    DatePicker f19500b;

    /* renamed from: c  reason: collision with root package name */
    TextView f19501c;

    /* renamed from: d  reason: collision with root package name */
    TextView f19502d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19503e;

    /* renamed from: f  reason: collision with root package name */
    a f19504f;

    /* renamed from: g  reason: collision with root package name */
    int f19505g;

    /* renamed from: h  reason: collision with root package name */
    int f19506h;

    /* renamed from: i  reason: collision with root package name */
    int f19507i;
    String j;

    public interface a {
    }

    private static void a(DatePicker datePicker) {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("day", "id", "android");
        int identifier2 = system.getIdentifier(MPConstants.PaymentSummaryRange.MONTH, "id", "android");
        int identifier3 = system.getIdentifier("year", "id", "android");
        a((NumberPicker) datePicker.findViewById(identifier));
        a((NumberPicker) datePicker.findViewById(identifier2));
        a((NumberPicker) datePicker.findViewById(identifier3));
        datePicker.setDescendantFocusability(393216);
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

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f19499a = getActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f19505g = getArguments().getInt("day_of_month");
            this.f19506h = getArguments().getInt("year");
            this.f19507i = getArguments().getInt(MPConstants.PaymentSummaryRange.MONTH);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_custom_date_picker_layout, viewGroup, false);
        getDialog().requestWindowFeature(1);
        this.f19503e = (TextView) inflate.findViewById(R.id.custom_date_picker_date_tv);
        this.f19500b = (DatePicker) inflate.findViewById(R.id.custom_date_picker_dp);
        this.f19501c = (TextView) inflate.findViewById(R.id.custom_date_picker_done_tv);
        this.f19502d = (TextView) inflate.findViewById(R.id.custom_date_picker_cancel_tv);
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        if (getArguments() == null) {
            int i5 = i3 + 1;
            this.j = a(i5);
            this.f19507i = i5;
            this.f19506h = i2;
            this.f19505g = i4;
        } else {
            this.j = a(this.f19507i);
        }
        TextView textView = this.f19503e;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19505g);
        sb.append(" ");
        sb.append(this.j);
        sb.append(", ");
        sb.append(this.f19506h);
        textView.setText(sb);
        a(this.f19500b);
        this.f19501c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
        this.f19502d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        this.f19500b.init(this.f19506h, this.f19507i - 1, this.f19505g, new DatePicker.OnDateChangedListener() {
            public final void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
                d.this.a(datePicker, i2, i3, i4);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f19504f != null) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.f19504f != null) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DatePicker datePicker, int i2, int i3, int i4) {
        this.f19505g = i4;
        this.f19506h = i2;
        int i5 = i3 + 1;
        this.j = a(i5);
        this.f19507i = i5;
        TextView textView = this.f19503e;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append(" ");
        sb.append(a(i5));
        sb.append(", ");
        sb.append(i2);
        textView.setText(sb);
    }

    private String a(int i2) {
        return getResources().getStringArray(R.array.pb_months_in_calender)[i2 - 1];
    }
}
