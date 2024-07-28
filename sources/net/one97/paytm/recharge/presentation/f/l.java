package net.one97.paytm.recharge.presentation.f;

import android.graphics.Typeface;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.presentation.d.e;

public final class l extends f {

    /* renamed from: a  reason: collision with root package name */
    public final View f64917a;

    /* renamed from: b  reason: collision with root package name */
    final e f64918b;

    public final <T> void a(T t) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(View view, e eVar) {
        super(view);
        k.c(view, "mItemView");
        k.c(eVar, "daySelectClickListener");
        this.f64917a = view;
        this.f64918b = eVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f64919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f64920b;

        public a(l lVar, Object obj) {
            this.f64919a = lVar;
            this.f64920b = obj;
        }

        public final void onClick(View view) {
            ((TextView) this.f64919a.f64917a.findViewById(R.id.txt_days)).setTypeface((Typeface) null, 1);
            View findViewById = this.f64919a.f64917a.findViewById(R.id.ic_radio_btn);
            k.a((Object) findViewById, "mItemView.findViewById<R…utton>(R.id.ic_radio_btn)");
            ((RadioButton) findViewById).setChecked(true);
            e eVar = this.f64919a.f64918b;
            int adapterPosition = this.f64919a.getAdapterPosition();
            Object obj = this.f64920b;
            if (obj != null) {
                eVar.a(adapterPosition, (String) obj);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.String");
        }
    }
}
