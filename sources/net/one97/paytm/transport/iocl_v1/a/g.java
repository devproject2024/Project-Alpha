package net.one97.paytm.transport.iocl_v1.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.a.c;
import net.one97.paytm.transport.iocl_v1.c.e;

public class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private e f14367a;

    /* renamed from: b  reason: collision with root package name */
    private c f14368b;

    public static g a(Bundle bundle) {
        g gVar = new g();
        gVar.setArguments(bundle);
        return gVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14368b = (c) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.fragment_iocl_landing_page_v1, viewGroup, false);
        this.f14367a = new e(getActivity().getApplication());
        this.f14368b.a(this.f14367a);
        this.f14367a.f14446a.set(Long.valueOf(getArguments() == null ? 0 : getArguments().getLong("reward_point")));
        return this.f14368b.getRoot();
    }
}
