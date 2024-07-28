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
import net.one97.paytm.upi.e.l;
import net.one97.paytm.upi.f;

public final class e extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67326a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f67327b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f67328c = -1;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f67329d;

    public final void b() {
        HashMap hashMap = this.f67329d;
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
            this.f67327b = (b) context;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f67328c = arguments.getInt("current selected index", -1);
    }

    public final int a() {
        return R.layout.bottom_sheet_payment_frequency;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        l a2 = l.a(view);
        k.a((Object) a2, "BottomSheetPaymentFrequencyBinding.bind(view)");
        a2.f66848a.setOnClickListener(new b(this));
        a2.f66849b.setOnCheckedChangeListener(new c(a2, this));
        RadioGroup radioGroup = a2.f66849b;
        k.a((Object) radioGroup, "typeRadioGroup");
        RadioButton a3 = f.a(radioGroup, this.f67328c);
        if (a3 != null) {
            a3.setTypeface(Typeface.SANS_SERIF, 1);
        }
        RadioGroup radioGroup2 = a2.f66849b;
        k.a((Object) radioGroup2, "typeRadioGroup");
        RadioButton a4 = f.a(radioGroup2, this.f67328c);
        if (a4 != null) {
            a4.setChecked(true);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f67330a;

        b(e eVar) {
            this.f67330a = eVar;
        }

        public final void onClick(View view) {
            this.f67330a.dismiss();
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f67331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f67332b;

        c(l lVar, e eVar) {
            this.f67331a = lVar;
            this.f67332b = eVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            RadioGroup radioGroup2 = this.f67331a.f66849b;
            k.a((Object) radioGroup2, "typeRadioGroup");
            int a2 = f.a(radioGroup2);
            if (a2 != this.f67332b.f67328c) {
                b b2 = this.f67332b.f67327b;
                if (b2 != null) {
                    b2.a(a2);
                }
                this.f67332b.dismiss();
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
