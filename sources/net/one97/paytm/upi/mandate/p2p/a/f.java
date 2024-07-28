package net.one97.paytm.upi.mandate.p2p.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.e.o;

public final class f extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67307a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upi.mandate.p2p.b f67308b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f67309c = -1;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f67310d;

    public final void b() {
        HashMap hashMap = this.f67310d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.upi.mandate.p2p.b) {
            this.f67308b = (net.one97.paytm.upi.mandate.p2p.b) context;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f67309c = arguments.getInt("current selected index", -1);
    }

    public final int a() {
        return R.layout.bottom_sheet_weekly_payment_day;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        o a2 = o.a(view);
        k.a((Object) a2, "BottomSheetWeeklyPaymentDayBinding.bind(view)");
        a2.f66863a.setOnClickListener(new b(this));
        a2.f66864b.setOnCheckedChangeListener(new c(a2, this));
        RadioGroup radioGroup = a2.f66864b;
        k.a((Object) radioGroup, "typeRadioGroup");
        RadioButton a3 = net.one97.paytm.upi.f.a(radioGroup, this.f67309c);
        if (a3 != null) {
            a3.setTypeface(Typeface.SANS_SERIF, 1);
        }
        RadioGroup radioGroup2 = a2.f66864b;
        k.a((Object) radioGroup2, "typeRadioGroup");
        RadioButton a4 = net.one97.paytm.upi.f.a(radioGroup2, this.f67309c);
        if (a4 != null) {
            a4.setChecked(true);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f67311a;

        b(f fVar) {
            this.f67311a = fVar;
        }

        public final void onClick(View view) {
            this.f67311a.dismiss();
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f67312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f67313b;

        c(o oVar, f fVar) {
            this.f67312a = oVar;
            this.f67313b = fVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            RadioGroup radioGroup2 = this.f67312a.f66864b;
            k.a((Object) radioGroup2, "typeRadioGroup");
            int a2 = net.one97.paytm.upi.f.a(radioGroup2);
            if (a2 != this.f67313b.f67309c) {
                net.one97.paytm.upi.mandate.p2p.b b2 = this.f67313b.f67308b;
                if (b2 != null) {
                    b2.c(a2);
                }
                this.f67313b.dismiss();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
