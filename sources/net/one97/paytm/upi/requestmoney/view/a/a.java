package net.one97.paytm.upi.requestmoney.view.a;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.business.merchant_payments.utility.MPConstants;
import java.lang.reflect.Field;
import java.util.Date;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.PaytmLogs;

public class a extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C1404a f69344a;

    /* renamed from: b  reason: collision with root package name */
    private DatePicker f69345b;

    /* renamed from: net.one97.paytm.upi.requestmoney.view.a.a$a  reason: collision with other inner class name */
    public interface C1404a {
        void a(int i2, int i3, int i4);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static final a a(int i2, int i3, int i4, int i5, Date date, Date date2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("theme", i2);
        bundle.putInt("year", i3);
        bundle.putInt(MPConstants.PaymentSummaryRange.MONTH, i4);
        bundle.putInt("day", i5);
        bundle.putSerializable("minDate", date);
        bundle.putSerializable("maxDate", date2);
        aVar.setArguments(bundle);
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = getArguments().getInt("theme");
        int i3 = getArguments().getInt("year");
        int i4 = getArguments().getInt(MPConstants.PaymentSummaryRange.MONTH);
        int i5 = getArguments().getInt("day");
        Date date = (Date) getArguments().getSerializable("minDate");
        Date date2 = (Date) getArguments().getSerializable("maxDate");
        this.f69344a = (C1404a) getParentFragment();
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i2 == 1 ? 16973931 : 16973934)).inflate(R.layout.upi_fragment_date, viewGroup, false);
        this.f69345b = (DatePicker) inflate.findViewById(R.id.datePicker);
        this.f69345b.setDescendantFocusability(393216);
        this.f69345b.init(i3, i4, i5, new DatePicker.OnDateChangedListener() {
            public final void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
                a.this.f69344a.a(i2, i3, i4);
            }
        });
        DatePicker datePicker = this.f69345b;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("day", "id", "android");
        int identifier2 = system.getIdentifier(MPConstants.PaymentSummaryRange.MONTH, "id", "android");
        int identifier3 = system.getIdentifier("year", "id", "android");
        a((NumberPicker) datePicker.findViewById(identifier));
        a((NumberPicker) datePicker.findViewById(identifier2));
        a((NumberPicker) datePicker.findViewById(identifier3));
        datePicker.setDescendantFocusability(393216);
        if (date != null) {
            this.f69345b.setMinDate(System.currentTimeMillis() - 1000);
        }
        if (date2 != null) {
            this.f69345b.setMaxDate(date2.getTime());
        }
        return inflate;
    }

    private static void a(NumberPicker numberPicker) {
        if (numberPicker != null) {
            int childCount = numberPicker.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                try {
                    Field declaredField = numberPicker.getClass().getDeclaredField("mSelectionDivider");
                    declaredField.setAccessible(true);
                    declaredField.set(numberPicker, new ColorDrawable(numberPicker.getResources().getColor(R.color.upi_paytm_blue)));
                    numberPicker.invalidate();
                } catch (Exception e2) {
                    PaytmLogs.w("setDividerColor", String.valueOf(e2));
                }
            }
        }
    }
}
