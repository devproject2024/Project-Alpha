package net.one97.paytm.transport.iocl.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.a.a;
import net.one97.paytm.transport.iocl.c.e;

public class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private e f14250a;

    /* renamed from: b  reason: collision with root package name */
    private a f14251b;

    public static g a(Bundle bundle) {
        g gVar = new g();
        gVar.setArguments(bundle);
        return gVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14251b = (a) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.fragment_iocl_landing_page, viewGroup, false);
        this.f14250a = new e(getActivity().getApplication());
        this.f14251b.a(this.f14250a);
        this.f14250a.f14314a.set(Long.valueOf(getArguments() == null ? 0 : getArguments().getLong("reward_point")));
        return this.f14251b.getRoot();
    }
}
