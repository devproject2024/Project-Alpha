package net.one97.paytm.moneytransfer.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.a;
import net.one97.paytm.moneytransfer.d.b;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class h extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public b f54481a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f54482b;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.money_transfer_bottom_fragment, viewGroup, false);
        View.OnClickListener onClickListener = this;
        inflate.findViewById(R.id.paymentHistory).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.transferToMobile).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.upiOffers).setOnClickListener(onClickListener);
        return inflate;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.paymentHistory) {
            b bVar = this.f54481a;
            if (bVar != null) {
                bVar.m();
            }
        } else if (view != null && view.getId() == R.id.transferToMobile) {
            b bVar2 = this.f54481a;
            if (bVar2 != null) {
                bVar2.n();
            }
        } else if (view != null && view.getId() == R.id.upiOffers) {
            f.a(getContext(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "offer_strip_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
            d.a aVar = d.f53996a;
            a b2 = d.b(d.a.a());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            b2.a((Context) activity, "paytmmp://cash_wallet?featuretype=vip&screen=categoryNewOffers&offertag=Paytm%20UPI%20Offers&is_from_category=true");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54482b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
