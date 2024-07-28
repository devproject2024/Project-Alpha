package net.one97.paytm.upi.requestmoney.view.a;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import java.lang.reflect.Field;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.PaytmLogs;

public class d extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f69372a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TimePicker f69373b;

    public interface a {
        void a(int i2, int i3);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static final d a(int i2, int i3, int i4, boolean z) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putInt("theme", i2);
        bundle.putInt("hour", i3);
        bundle.putInt("minute", i4);
        bundle.putBoolean("is24HourTime", z);
        dVar.setArguments(bundle);
        return dVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = getArguments().getInt("theme");
        int i3 = getArguments().getInt("hour");
        int i4 = getArguments().getInt("minute");
        boolean z = getArguments().getBoolean("is24HourTime");
        this.f69372a = (a) getParentFragment();
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i2 == 1 ? 16973931 : 16973934)).inflate(R.layout.upi_fragment_time, viewGroup, false);
        this.f69373b = (TimePicker) inflate.findViewById(R.id.timePicker);
        this.f69373b.setDescendantFocusability(393216);
        this.f69373b.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public final void onTimeChanged(TimePicker timePicker, int i2, int i3) {
                d.this.f69372a.a(i2, i3);
            }
        });
        this.f69373b.setIs24HourView(Boolean.valueOf(z));
        this.f69373b.setCurrentHour(Integer.valueOf(i3));
        this.f69373b.setCurrentMinute(Integer.valueOf(i4));
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 15) {
            View childAt = ((ViewGroup) this.f69373b.getChildAt(0)).getChildAt(3);
            if (childAt instanceof NumberPicker) {
                ((NumberPicker) childAt).setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                        if (numberPicker.getValue() == 1) {
                            if (d.this.f69373b.getCurrentHour().intValue() < 12) {
                                d.this.f69373b.setCurrentHour(Integer.valueOf(d.this.f69373b.getCurrentHour().intValue() + 12));
                            }
                        } else if (d.this.f69373b.getCurrentHour().intValue() >= 12) {
                            d.this.f69373b.setCurrentHour(Integer.valueOf(d.this.f69373b.getCurrentHour().intValue() - 12));
                        }
                        d.this.f69372a.a(d.this.f69373b.getCurrentHour().intValue(), d.this.f69373b.getCurrentMinute().intValue());
                    }
                });
            }
        }
        TimePicker timePicker = this.f69373b;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("hour", "id", "android");
        int identifier2 = system.getIdentifier("minute", "id", "android");
        int identifier3 = system.getIdentifier("amPm", "id", "android");
        a((NumberPicker) timePicker.findViewById(identifier));
        a((NumberPicker) timePicker.findViewById(identifier2));
        a((NumberPicker) timePicker.findViewById(identifier3));
        timePicker.setDescendantFocusability(393216);
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
