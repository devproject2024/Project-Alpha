package com.business.common_module.a.a;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.business.common_module.R;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.common.utility.AppConstants;
import com.squareup.timessquare.CalendarPickerView;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    Date f7285a;

    /* renamed from: b  reason: collision with root package name */
    Date f7286b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7287c = "dd MMM yy";

    /* renamed from: d  reason: collision with root package name */
    int f7288d = -6;

    /* renamed from: e  reason: collision with root package name */
    int f7289e = 31;

    /* renamed from: f  reason: collision with root package name */
    public final a f7290f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakReference<AppCompatActivity> f7291g;

    /* renamed from: h  reason: collision with root package name */
    private final CalendarPickerView.h f7292h = new c(this);

    /* renamed from: i  reason: collision with root package name */
    private final CalendarPickerView.h f7293i = new C0103b(this);

    public interface a {
        void onCustomDateSelected(String str);

        void onCustomDateSelected(String str, String str2, String str3);
    }

    public b(AppCompatActivity appCompatActivity, a aVar) {
        k.d(appCompatActivity, "context");
        k.d(aVar, "mListener");
        this.f7290f = aVar;
        this.f7291g = new WeakReference<>(appCompatActivity);
    }

    public static final class c implements CalendarPickerView.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f7295a;

        public final void b(Date date) {
        }

        c(b bVar) {
            this.f7295a = bVar;
        }

        public final void a(Date date) {
            k.d(date, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            Calendar instance = Calendar.getInstance();
            k.b(instance, "Calendar.getInstance()");
            instance.setTime(date);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            this.f7295a.f7285a = instance.getTime();
            b bVar = this.f7295a;
            bVar.a(1, bVar.f7288d, this.f7295a.f7289e);
        }
    }

    /* renamed from: com.business.common_module.a.a.b$b  reason: collision with other inner class name */
    public static final class C0103b implements CalendarPickerView.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f7294a;

        public final void b(Date date) {
        }

        C0103b(b bVar) {
            this.f7294a = bVar;
        }

        public final void a(Date date) {
            k.d(date, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            this.f7294a.f7286b = date;
            LogUtility.d(getClass().getSimpleName(), "endDateListener: ".concat(String.valueOf(date)));
            if (this.f7294a.f7285a == null || this.f7294a.f7286b == null) {
                this.f7294a.f7290f.onCustomDateSelected("", "", "");
                return;
            }
            this.f7294a.f7290f.onCustomDateSelected(b.a(this.f7294a.f7285a, this.f7294a.f7287c), b.a(this.f7294a.f7286b, this.f7294a.f7287c), "");
            b bVar = this.f7294a;
            bVar.f7285a = null;
            bVar.f7286b = null;
        }
    }

    public final void a(int i2, int i3) {
        this.f7289e = i3;
        this.f7288d = i2;
        a(0, i2, i3);
    }

    public final void a(String str) {
        k.d(str, "identifier");
        this.f7290f.onCustomDateSelected(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4) {
        Resources resources;
        Resources resources2;
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.f7291g.get();
        if (appCompatActivity != null) {
            com.business.common_module.a.b.a a2 = com.business.common_module.a.b.a.a();
            k.b(a2, "CommonCalendarBottomSheetFragment.getInstance()");
            Bundle bundle = new Bundle();
            bundle.putInt(AppConstants.CALENDAR_TYPE, i2);
            bundle.putInt("FEATURE_CALENDAR_TYPE", i3);
            bundle.putInt("RANGE_CALENDAR_TYPE", i4);
            String str = null;
            if (i2 == 0) {
                AppCompatActivity appCompatActivity2 = (AppCompatActivity) this.f7291g.get();
                if (!(appCompatActivity2 == null || (resources2 = appCompatActivity2.getResources()) == null)) {
                    str = resources2.getString(R.string.cm_si_calendar_start_title);
                }
                bundle.putString(AppConstants.EXTRA_FIRST_TITLE, str);
                a2.a(this.f7292h);
            } else {
                AppCompatActivity appCompatActivity3 = (AppCompatActivity) this.f7291g.get();
                if (!(appCompatActivity3 == null || (resources = appCompatActivity3.getResources()) == null)) {
                    str = resources.getString(R.string.cm_si_calendar_end_title);
                }
                bundle.putString(AppConstants.EXTRA_FIRST_TITLE, str);
                Date date = this.f7285a;
                bundle.putLong(AppConstants.EXTRA_SELECTED_START_DATE, date != null ? date.getTime() : 0);
                a2.a(this.f7293i);
            }
            a2.setArguments(bundle);
            k.b(appCompatActivity, "it");
            a2.show(appCompatActivity.getSupportFragmentManager(), "calendar_show");
        }
    }

    public static String a(Date date, String str) {
        try {
            String format = new SimpleDateFormat(str, new Locale(CLConstants.DEFAULT_LANGUAGE_PREFERENCE)).format(date);
            k.b(format, "targetFormat.format(inputDate)");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }
}
