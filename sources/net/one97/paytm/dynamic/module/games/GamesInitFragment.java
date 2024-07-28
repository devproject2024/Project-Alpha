package net.one97.paytm.dynamic.module.games;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.fragment.pf.a;
import net.one97.paytm.games.fragment.pfg.PFGHomeFragment;
import net.one97.paytm.paytm_finance.R;

public final class GamesInitFragment extends Fragment {
    private HashMap _$_findViewCache;
    private boolean mOnResumeCalled;
    private boolean mRooterTabFragmentInstance;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        a.a(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            g.a().a(activity.getApplicationContext(), GamepindMapperJarvisImpl.getInstance());
        }
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null) {
            z = arguments.getBoolean("rooterTabFragmentInstance", false);
        }
        this.mRooterTabFragmentInstance = z;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pfg_init_fragment_layout, viewGroup, false);
    }

    public final void onResume() {
        String str;
        Fragment fragment;
        super.onResume();
        if (!this.mOnResumeCalled) {
            this.mOnResumeCalled = true;
            if (this.mRooterTabFragmentInstance) {
                a.c cVar = net.one97.paytm.games.fragment.pf.a.f35661a;
                fragment = a.c.a(new Bundle());
                str = "PFGameWebFragment";
            } else {
                fragment = Fragment.instantiate(requireContext(), PFGHomeFragment.class.getName());
                k.a((Object) fragment, "instantiate(requireConte…ragment::class.java.name)");
                str = "PFGHomeFragment";
            }
            q a2 = getChildFragmentManager().a();
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(net.one97.paytm.dynamic.module.feed.R.id.pfg_container);
            k.a((Object) frameLayout, "pfg_container");
            a2.b(frameLayout.getId(), fragment, str).c();
        }
    }
}
