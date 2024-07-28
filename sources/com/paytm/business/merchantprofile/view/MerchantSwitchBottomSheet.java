package com.paytm.business.merchantprofile.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.business.common_module.e.a;
import com.business.common_module.e.b;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.business.merchantprofile.databinding.PrMerchantSwitchBottomSheetBinding;
import com.paytm.business.merchantprofile.listener.MerchantSwitchListener;
import com.paytm.business.merchantprofile.widget.BaseCustomRadioButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class MerchantSwitchBottomSheet extends CustomBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public HashMap _$_findViewCache;
    public PrMerchantSwitchBottomSheetBinding mBinding;
    public int mCurrentSelection = -1;
    public List<b> merchantList = new ArrayList();
    public MerchantSwitchListener merchantSwitchListener;

    public static final MerchantSwitchBottomSheet newInstance() {
        return Companion.newInstance();
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

        public final MerchantSwitchBottomSheet newInstance() {
            MerchantSwitchBottomSheet merchantSwitchBottomSheet = new MerchantSwitchBottomSheet();
            merchantSwitchBottomSheet.setArguments(new Bundle());
            return merchantSwitchBottomSheet;
        }
    }

    public final void onAttach(Context context) {
        k.d(context, "context");
        super.onAttach(context);
        if (!(context instanceof MerchantSwitchListener)) {
            context = null;
        }
        this.merchantSwitchListener = (MerchantSwitchListener) context;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        prepareMerchantSwitchList();
    }

    private final void prepareMerchantSwitchList() {
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        String D = instance.getMerchantDataProvider().D();
        ProfileConfig instance2 = ProfileConfig.getInstance();
        k.b(instance2, "ProfileConfig.getInstance()");
        a b2 = instance2.getMerchantDataProvider().b();
        ArrayList<b> merchants = b2 != null ? b2.getMerchants() : null;
        if (D != null && merchants != null) {
            ProfileConfig instance3 = ProfileConfig.getInstance();
            k.b(instance3, "ProfileConfig.getInstance()");
            this.merchantList.addAll(instance3.getMerchantDataProvider().a(D, merchants));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        PrMerchantSwitchBottomSheetBinding inflate = PrMerchantSwitchBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "PrMerchantSwitchBottomSh…flater, container, false)");
        this.mBinding = inflate;
        int i2 = 0;
        for (b bVar : this.merchantList) {
            ProfileSharedPreferences instance = ProfileSharedPreferences.getInstance();
            k.b(instance, "ProfileSharedPreferences.getInstance()");
            boolean z = true;
            boolean a2 = p.a(instance.getMerchantMid(), bVar.getMid(), true);
            bVar.setSelected(a2);
            if (a2) {
                this.mCurrentSelection = i2;
            }
            if (this.merchantList.size() - 1 == i2) {
                z = false;
            }
            addOption(bVar, z);
            i2++;
        }
        PrMerchantSwitchBottomSheetBinding prMerchantSwitchBottomSheetBinding = this.mBinding;
        if (prMerchantSwitchBottomSheetBinding == null) {
            k.a("mBinding");
        }
        prMerchantSwitchBottomSheetBinding.options.checkAtIndex(this.mCurrentSelection);
        PrMerchantSwitchBottomSheetBinding prMerchantSwitchBottomSheetBinding2 = this.mBinding;
        if (prMerchantSwitchBottomSheetBinding2 == null) {
            k.a("mBinding");
        }
        prMerchantSwitchBottomSheetBinding2.options.setOnCheckedChangeListener(new MerchantSwitchBottomSheet$onCreateView$1(this));
        PrMerchantSwitchBottomSheetBinding prMerchantSwitchBottomSheetBinding3 = this.mBinding;
        if (prMerchantSwitchBottomSheetBinding3 == null) {
            k.a("mBinding");
        }
        return prMerchantSwitchBottomSheetBinding3.getRoot();
    }

    private final void addOption(b bVar, boolean z) {
        BaseCustomRadioButton baseCustomRadioButton = new BaseCustomRadioButton(getActivity());
        baseCustomRadioButton.setData(bVar);
        baseCustomRadioButton.showDivider(z);
        PrMerchantSwitchBottomSheetBinding prMerchantSwitchBottomSheetBinding = this.mBinding;
        if (prMerchantSwitchBottomSheetBinding == null) {
            k.a("mBinding");
        }
        prMerchantSwitchBottomSheetBinding.options.addView(baseCustomRadioButton);
    }
}
