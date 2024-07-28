package net.one97.paytm.recharge.metro.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;

public final class b extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public kotlin.g.a.b<? super Integer, x> f63268a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f63269b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f63270c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mumbai_metro_low_balance_bottom_sheet, (ViewGroup) null, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent != null) {
            View view2 = (View) parent;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            view2.setBackgroundColor(androidx.core.content.b.c(context, 17170445));
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.close);
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
        ((TextView) view.findViewById(R.id.rechargePass)).setOnClickListener(new C1222b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63271a;

        a(b bVar) {
            this.f63271a = bVar;
        }

        public final void onClick(View view) {
            this.f63271a.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.recharge.metro.b.b$b  reason: collision with other inner class name */
    static final class C1222b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63272a;

        C1222b(b bVar) {
            this.f63272a = bVar;
        }

        public final void onClick(View view) {
            kotlin.g.a.b a2 = this.f63272a.f63268a;
            if (a2 != null) {
                Integer b2 = this.f63272a.f63269b;
                if (b2 == null) {
                    k.a();
                }
                a2.invoke(b2);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63270c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
