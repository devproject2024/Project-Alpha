package com.travel.flight.flightticket.j;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import kotlin.g.b.k;
import kotlin.m.p;

public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f25178a;

    /* renamed from: b  reason: collision with root package name */
    private ConstraintLayout f25179b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f25180c;

    /* renamed from: d  reason: collision with root package name */
    private View f25181d;

    /* renamed from: e  reason: collision with root package name */
    private Context f25182e;

    public final void a(b.C0467b bVar) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(View view, Context context, String str) {
        super(view);
        k.c(view, "view");
        k.c(context, "context");
        k.c(str, "type");
        this.f25181d = view;
        this.f25182e = context;
        this.f25178a = str;
        View findViewById = this.f25181d.findViewById(R.id.mainLyt);
        k.a((Object) findViewById, "view.findViewById(R.id.mainLyt)");
        this.f25179b = (ConstraintLayout) findViewById;
        View findViewById2 = this.f25181d.findViewById(R.id.htmlWebView);
        k.a((Object) findViewById2, "view.findViewById(R.id.htmlWebView)");
        this.f25180c = (WebView) findViewById2;
    }

    public final void a(String str) {
        boolean z = true;
        if (p.a(this.f25178a, "order_summary", true)) {
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-1);
            Context context = this.f25182e;
            if (context != null) {
                layoutParams.setMargins(0, (int) context.getResources().getDimension(R.dimen.dimen_12dp), 0, (int) this.f25182e.getResources().getDimension(R.dimen.dimen_12dp));
            }
            this.f25179b.setLayoutParams(layoutParams);
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            this.f25180c.loadDataWithBaseURL("", str, "text/html", AppConstants.UTF_8, "");
        }
    }
}
