package com.business.merchant_payments.homepagedialogs;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpSuccessPopupBinding;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class HomePageSuccessPopup extends Fragment {
    public static final String ARG_MESSAGE = "message";
    public static final Companion Companion = new Companion((g) null);
    public HashMap _$_findViewCache;
    public MpSuccessPopupBinding mBinding;
    public HomePageNotificationPopupListener mListener;

    public interface HomePageNotificationPopupListener {
    }

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

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void onAttach(Activity activity) {
        k.d(activity, "activity");
        super.onAttach(activity);
        if (activity instanceof HomePageNotificationPopupListener) {
            this.mListener = (HomePageNotificationPopupListener) activity;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.mp_success_popup, viewGroup, false);
        k.b(a2, "DataBindingUtil.inflate(…_popup, container, false)");
        MpSuccessPopupBinding mpSuccessPopupBinding = (MpSuccessPopupBinding) a2;
        this.mBinding = mpSuccessPopupBinding;
        if (mpSuccessPopupBinding == null) {
            k.a("mBinding");
        }
        mpSuccessPopupBinding.setListener(this.mListener);
        MpSuccessPopupBinding mpSuccessPopupBinding2 = this.mBinding;
        if (mpSuccessPopupBinding2 == null) {
            k.a("mBinding");
        }
        Bundle arguments = getArguments();
        mpSuccessPopupBinding2.setMessage(arguments != null ? arguments.getString("message") : null);
        MpSuccessPopupBinding mpSuccessPopupBinding3 = this.mBinding;
        if (mpSuccessPopupBinding3 == null) {
            k.a("mBinding");
        }
        mpSuccessPopupBinding3.setLifecycleOwner(getViewLifecycleOwner());
        MpSuccessPopupBinding mpSuccessPopupBinding4 = this.mBinding;
        if (mpSuccessPopupBinding4 == null) {
            k.a("mBinding");
        }
        return mpSuccessPopupBinding4.getRoot();
    }
}
