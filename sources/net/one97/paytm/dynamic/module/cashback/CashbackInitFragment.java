package net.one97.paytm.dynamic.module.cashback;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.cashback.posttxn.d;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2;

public class CashbackInitFragment extends Fragment {
    private static String TAG = "InitFragment";
    private final String CASHBACK_FRAGMENT_V2 = "net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2";

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            CashbackDataProvider.initCashbackModule(context);
        }
        a.a(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.cashback_dd_init_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        switchFragment(R.id.container);
    }

    private void switchFragment(int i2) {
        new Bundle().putBoolean("expanded", true);
        Fragment cashbackFragment = getCashbackFragment();
        CashbackDataProvider.getInstance().registerCashbackListener((d) cashbackFragment);
        if (cashbackFragment != null) {
            getChildFragmentManager().a().b(i2, cashbackFragment, "feed").b();
        }
    }

    private Fragment getCashbackFragment() {
        FJRCashbackFragmentV2.a aVar = FJRCashbackFragmentV2.f20902c;
        FJRCashbackFragmentV2 a2 = FJRCashbackFragmentV2.a.a(false, (String) null);
        new StringBuilder("Fragment :: ").append(a2);
        return a2;
    }
}
