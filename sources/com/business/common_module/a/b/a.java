package com.business.common_module.a.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.business.common_module.utilities.c;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.b;
import com.squareup.timessquare.CalendarPickerView;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    int f7296a;

    /* renamed from: b  reason: collision with root package name */
    Calendar f7297b;

    /* renamed from: c  reason: collision with root package name */
    Calendar f7298c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f7299d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f7300e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BottomSheetBehavior f7301f;

    /* renamed from: g  reason: collision with root package name */
    private CalendarPickerView f7302g;

    /* renamed from: h  reason: collision with root package name */
    private Locale f7303h;

    /* renamed from: i  reason: collision with root package name */
    private Date f7304i;
    private long j;
    /* access modifiers changed from: private */
    public CalendarPickerView.h k;
    /* access modifiers changed from: private */
    public boolean l = false;

    public static a a() {
        a aVar = new a();
        aVar.setArguments(new Bundle());
        return aVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                frameLayout.setBackgroundDrawable(new ColorDrawable(0));
                if (frameLayout != null) {
                    BottomSheetBehavior unused = a.this.f7301f = BottomSheetBehavior.from(frameLayout);
                }
                a.this.f7301f.setState(3);
                a.this.f7301f.setBottomSheetCallback(new BottomSheetBehavior.a() {
                    public final void onSlide(View view, float f2) {
                    }

                    public final void onStateChanged(View view, int i2) {
                        if (i2 == 1) {
                            a.this.f7301f.setState(3);
                        }
                    }
                });
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.business.common_module.R.layout.common_fragment_calendar_bottomsheet, viewGroup, false);
        this.f7299d = (ImageView) inflate.findViewById(com.business.common_module.R.id.full_kyc_cross_iv);
        this.f7300e = (TextView) inflate.findViewById(com.business.common_module.R.id.calendar_title_tv);
        this.f7302g = (CalendarPickerView) inflate.findViewById(com.business.common_module.R.id.calendar_view);
        this.f7303h = new Locale(CLConstants.DEFAULT_LANGUAGE_PREFERENCE);
        Bundle arguments = getArguments();
        this.f7300e.setText(arguments.getString(AppConstants.EXTRA_FIRST_TITLE));
        this.j = arguments.getLong(AppConstants.EXTRA_SELECTED_START_DATE, 0);
        this.f7296a = arguments.getInt(AppConstants.CALENDAR_TYPE);
        int i2 = this.f7296a;
        if (i2 == 0) {
            this.f7297b = Calendar.getInstance();
            this.f7297b.add(5, 1);
            this.f7297b.add(2, getArguments().getInt("FEATURE_CALENDAR_TYPE", -6));
            this.f7298c = Calendar.getInstance();
            this.f7298c.add(5, 1);
        } else if (i2 == 1) {
            this.f7297b = Calendar.getInstance();
            this.f7298c = Calendar.getInstance();
            long j2 = this.j;
            if (j2 != 0) {
                this.f7297b.setTimeInMillis(j2);
                this.f7298c.add(5, 1);
            }
        }
        if (this.j != 0) {
            this.f7304i = new Date();
            this.f7302g.a(this.f7297b.getTime(), this.f7298c.getTime(), this.f7303h).a(CalendarPickerView.j.SINGLE).a(this.f7304i);
            this.f7302g.a(this.f7297b.getTime());
        } else {
            this.f7302g.a(this.f7297b.getTime(), this.f7298c.getTime(), this.f7303h).a(CalendarPickerView.j.SINGLE).a(new Date());
            this.f7302g.a(this.f7298c.getTime());
        }
        if (this.k != null) {
            this.f7302g.setOnDateSelectedListener(new CalendarPickerView.h() {
                public final void a(Date date) {
                    a aVar = a.this;
                    if (aVar.l = a.a(aVar, date)) {
                        a.this.k.a(date);
                        a.this.dismiss();
                    }
                }

                public final void b(Date date) {
                    a.this.k.b(date);
                    if (a.this.l) {
                        a.this.dismiss();
                    }
                }
            });
            this.f7302g.setOnInvalidDateSelectedListener(new CalendarPickerView.i() {
                public final void onInvalidDateSelected(Date date) {
                    Toast.makeText(a.this.getContext(), a.this.getString(com.business.common_module.R.string.cm_si_invalid_date), 1).show();
                }
            });
        }
        getDialog().setCanceledOnTouchOutside(true);
        this.f7299d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.dismissAllowingStateLoss();
            }
        });
        return inflate;
    }

    public final void a(CalendarPickerView.h hVar) {
        this.k = hVar;
    }

    static /* synthetic */ boolean a(a aVar, Date date) {
        if (aVar.f7296a == 1) {
            int i2 = -1;
            if (aVar.getArguments().getInt("FEATURE_CALENDAR_TYPE") == com.business.common_module.a.a.a.f7279a) {
                c.a aVar2 = c.f7365a;
                Date time = aVar.f7297b.getTime();
                k.d(time, "from");
                k.d(date, "to");
                if (!date.before(time)) {
                    i2 = ((int) TimeUnit.DAYS.convert(date.getTime() - time.getTime(), TimeUnit.MILLISECONDS)) + 1;
                }
            } else {
                c.a aVar3 = c.f7365a;
                Date time2 = aVar.f7297b.getTime();
                k.d(date, "to");
                if (!date.before(time2)) {
                    Calendar instance = Calendar.getInstance();
                    k.b(instance, "cal");
                    instance.setTime(time2);
                    i2 = 0;
                    while (instance.getTime().before(date)) {
                        instance.add(2, 1);
                        i2++;
                    }
                }
            }
            long j2 = (long) i2;
            if (aVar.getArguments().getInt("RANGE_CALENDAR_TYPE", 31) == com.business.common_module.a.a.a.f7282d && j2 > ((long) com.business.common_module.a.a.a.f7282d)) {
                Toast.makeText(aVar.getContext(), aVar.getString(com.business.common_module.R.string.cm_custom_date_range_exceed, "1"), 1).show();
                return false;
            } else if (aVar.getArguments().getInt("RANGE_CALENDAR_TYPE", 31) == com.business.common_module.a.a.a.f7283e && j2 > ((long) com.business.common_module.a.a.a.f7283e)) {
                Toast.makeText(aVar.getContext(), aVar.getString(com.business.common_module.R.string.cm_custom_date_range_exceed, "12"), 1).show();
                return false;
            } else if (aVar.getArguments().getInt("RANGE_CALENDAR_TYPE", 31) == com.business.common_module.a.a.a.f7284f && j2 > ((long) com.business.common_module.a.a.a.f7284f)) {
                Toast.makeText(aVar.getContext(), aVar.getString(com.business.common_module.R.string.cm_custom_date_range_exceed, "6"), 1).show();
                return false;
            }
        }
        return true;
    }
}
