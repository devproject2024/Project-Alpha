package net.one97.paytm.transport.iocl.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.iocl.R;

public final class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final a f14235a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private View f14236b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f14237c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f14236b = layoutInflater.inflate(R.layout.iocl_know_more, viewGroup, false);
        net.one97.paytm.transport.iocl.a.c().sendOpenScreenEvent(getActivity(), "/iocl-xtrarewards-know-more");
        return this.f14236b;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f14237c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final d a() {
        return new d();
    }
}
