package net.one97.paytm.p2mNewDesign.j;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.wallet.R;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f13398a;

    /* renamed from: b  reason: collision with root package name */
    public View f13399b;

    /* renamed from: c  reason: collision with root package name */
    private String f13400c;

    public d(Context context) {
        this.f13398a = context;
    }

    private void a() {
        if (this.f13400c != null) {
            ((TextView) this.f13399b.findViewById(R.id.tv_title)).setText(this.f13400c);
        }
    }

    public final void a(String str) {
        this.f13400c = str;
        a();
    }
}
