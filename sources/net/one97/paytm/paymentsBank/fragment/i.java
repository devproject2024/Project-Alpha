package net.one97.paytm.paymentsBank.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;

public final class i extends n {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18520a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f18521c;

    private View a(int i2) {
        if (this.f18521c == null) {
            this.f18521c = new HashMap();
        }
        View view = (View) this.f18521c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18521c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int a() {
        return 2;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.header_view);
        k.a((Object) textView, "header_view");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.header_view);
        k.a((Object) textView2, "header_view");
        textView2.setText(getString(R.string.pb_guardian_details));
        TextView textView3 = (TextView) a(R.id.tv_nominee_relationship_heading);
        k.a((Object) textView3, "tv_nominee_relationship_heading");
        textView3.setText(getString(R.string.bank_relationship_with_nominee));
        ((TextView) a(R.id.tv_nominee_name_heading)).setText(R.string.pb_guardian_name);
        ((LinearLayout) a(R.id.ll_parent)).setPadding(0, 0, 0, 0);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18521c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
