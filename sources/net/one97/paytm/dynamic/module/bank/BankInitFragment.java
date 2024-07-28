package net.one97.paytm.dynamic.module.bank;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.paytm_finance.R;

public final class BankInitFragment extends Fragment {
    private final int LAUNCH_SET_PASSCODE = 9856;
    private final int REQUEST_CODE_FOR_BANK_LOGIN = 5123;
    private final String TAG = "BankInitFragment";
    private HashMap _$_findViewCache;
    private final String classpath = "net.one97.paytm.paymentsBank.fragment.BankTabPasscodeFragment";
    private Fragment fragment;
    private boolean mOnReumeCalled;

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

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (getActivity() != null) {
            PaymentsBankImplProvider.init();
            new ModuleManager().init();
        }
        a.a(context);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bank_dd_init_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
    }

    public final void onResume() {
        super.onResume();
        if (!this.mOnReumeCalled) {
            switchFragment(R.id.container);
            this.mOnReumeCalled = true;
        }
    }

    private final void switchFragment(int i2) {
        q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        Fragment passCodeFragment = getPassCodeFragment();
        if (passCodeFragment != null) {
            a2.b(i2, passCodeFragment, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
            a2.b();
        }
    }

    private final Fragment getPassCodeFragment() {
        try {
            Object newInstance = Class.forName(this.classpath).newInstance();
            if (newInstance != null) {
                this.fragment = (Fragment) newInstance;
                ae aeVar = ae.f50307a;
                if (ae.b() != null) {
                    ModuleManager moduleManager = new ModuleManager();
                    ae aeVar2 = ae.f50307a;
                    moduleManager.getBundleValues(ae.b());
                    ae aeVar3 = ae.f50307a;
                    ae.a(new Bundle());
                }
                Fragment fragment2 = this.fragment;
                if (fragment2 != null) {
                    fragment2.setArguments(getArguments());
                }
                return this.fragment;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        } catch (IllegalAccessException e2) {
            com.paytm.utility.q.b(e2.getMessage());
        } catch (InstantiationException e3) {
            com.paytm.utility.q.b(e3.getMessage());
        } catch (ClassNotFoundException e4) {
            com.paytm.utility.q.b(e4.getMessage());
        }
    }
}
