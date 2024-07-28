package net.one97.paytm.upi.mandate.p2p;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.e.m;

public final class f extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67333a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f67334b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f67335c = -1;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f67336d;

    public final void b() {
        HashMap hashMap = this.f67336d;
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
        if (context instanceof b) {
            this.f67334b = (b) context;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f67335c = arguments.getInt("current selected index", -1);
    }

    public final int a() {
        return R.layout.bottom_sheet_payment_schedule;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        m a2 = m.a(view);
        k.a((Object) a2, "BottomSheetPaymentScheduleBinding.bind(view)");
        a2.f66851a.setOnClickListener(new b(this));
        a2.f66852b.setOnCheckedChangeListener(new c(a2, this));
        RadioGroup radioGroup = a2.f66852b;
        k.a((Object) radioGroup, "typeRadioGroup");
        RadioButton a3 = net.one97.paytm.upi.f.a(radioGroup, this.f67335c);
        if (a3 != null) {
            a3.setTypeface(Typeface.SANS_SERIF, 1);
        }
        RadioGroup radioGroup2 = a2.f66852b;
        k.a((Object) radioGroup2, "typeRadioGroup");
        RadioButton a4 = net.one97.paytm.upi.f.a(radioGroup2, this.f67335c);
        if (a4 != null) {
            a4.setChecked(true);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f67337a;

        b(f fVar) {
            this.f67337a = fVar;
        }

        public final void onClick(View view) {
            this.f67337a.dismiss();
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f67338a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f67339b;

        c(m mVar, f fVar) {
            this.f67338a = mVar;
            this.f67339b = fVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            RadioGroup radioGroup2 = this.f67338a.f66852b;
            k.a((Object) radioGroup2, "typeRadioGroup");
            int a2 = net.one97.paytm.upi.f.a(radioGroup2);
            if (a2 != this.f67339b.f67335c) {
                b b2 = this.f67339b.f67334b;
                if (b2 != null) {
                    b2.b(a2);
                }
                this.f67339b.dismiss();
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
