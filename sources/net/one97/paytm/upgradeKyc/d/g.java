package net.one97.paytm.upgradeKyc.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;

public final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65689a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f65690b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f65691c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.f65690b = arguments != null ? arguments.getString("vertical") : null;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_kyc_please_wait, viewGroup, false);
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
        HashMap hashMap = this.f65691c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
