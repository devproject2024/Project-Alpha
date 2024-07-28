package net.one97.paytm.paymentsBank.si.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.squareup.timessquare.CalendarPickerView;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import net.one97.paytm.i.f;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    int f18876a;

    /* renamed from: b  reason: collision with root package name */
    Calendar f18877b;

    /* renamed from: c  reason: collision with root package name */
    Calendar f18878c;

    /* renamed from: d  reason: collision with root package name */
    public CalendarPickerView.h f18879d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18880e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BottomSheetBehavior f18881f;

    /* renamed from: g  reason: collision with root package name */
    private CalendarPickerView f18882g;

    public static d a() {
        d dVar = new d();
        dVar.setArguments(new Bundle());
        return dVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                d.this.a(dialogInterface);
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        if (frameLayout != null) {
            this.f18881f = BottomSheetBehavior.from(frameLayout);
        }
        this.f18881f.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    d.this.f18881f.setState(3);
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(net.one97.paytm.paymentsBank.R.layout.si_fragment_calendar_bottomsheet, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_cross_iv);
        this.f18880e = (TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.calendar_title_tv);
        this.f18882g = (CalendarPickerView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.calendar_view);
        Locale locale = new Locale(n.a());
        Bundle arguments = getArguments();
        this.f18880e.setText(arguments.getString("firstTitle"));
        long j = arguments.getLong("extra_selected_date", 0);
        long j2 = arguments.getLong("extra_selected_start_date", 0);
        this.f18876a = arguments.getInt("calendar_type");
        int i2 = this.f18876a;
        if (i2 == 0) {
            this.f18877b = Calendar.getInstance();
            this.f18878c = Calendar.getInstance();
            this.f18877b.add(5, 1);
            this.f18878c.add(2, 6);
        } else if (i2 == 1) {
            this.f18877b = Calendar.getInstance();
            this.f18878c = Calendar.getInstance();
            if (j2 != 0) {
                this.f18877b.setTimeInMillis(j2);
                this.f18877b.add(5, 1);
                this.f18878c.setTimeInMillis(j2);
                this.f18878c.add(2, 12);
            }
        }
        if (j != 0) {
            Date date = new Date();
            date.setTime(j);
            this.f18882g.a(this.f18877b.getTime(), this.f18878c.getTime(), locale).a(CalendarPickerView.j.SINGLE).a(date);
        } else {
            this.f18882g.a(this.f18877b.getTime(), this.f18878c.getTime(), locale).a(CalendarPickerView.j.SINGLE);
        }
        if (this.f18879d != null) {
            this.f18882g.setOnDateSelectedListener(new CalendarPickerView.h() {
                public final void a(Date date) {
                    d.this.f18879d.a(date);
                    d.this.dismiss();
                }

                public final void b(Date date) {
                    d.this.f18879d.b(date);
                    d.this.dismiss();
                }
            });
            this.f18882g.setOnInvalidDateSelectedListener(new CalendarPickerView.i() {
                public final void onInvalidDateSelected(Date date) {
                    d.this.a(date);
                }
            });
        }
        getDialog().setCanceledOnTouchOutside(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Date date) {
        b.a((Context) getActivity(), getString(net.one97.paytm.paymentsBank.R.string.si_invalid_date));
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }
}
