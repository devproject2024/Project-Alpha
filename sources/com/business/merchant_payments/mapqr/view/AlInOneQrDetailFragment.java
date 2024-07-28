package com.business.merchant_payments.mapqr.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseFragment;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.databinding.MpQrDetailBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class AlInOneQrDetailFragment extends BaseFragment {
    public static final Companion Companion = new Companion((g) null);
    public HashMap _$_findViewCache;
    public MpQrDetailBinding mBinding;

    public static final AlInOneQrDetailFragment newInstance() {
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.mp_qr_detail, (ViewGroup) null, false);
        k.b(a2, "DataBindingUtil.inflate(…p_qr_detail, null, false)");
        this.mBinding = (MpQrDetailBinding) a2;
        if (p.a(GTMDataProviderImpl.Companion.getMInstance().mdrChargesFlag(), "true", true)) {
            String walletTransactionCharges = GTMDataProviderImpl.Companion.getMInstance().getWalletTransactionCharges();
            String taxInclusionFlag = GTMDataProviderImpl.Companion.getMInstance().taxInclusionFlag();
            if (!(walletTransactionCharges == null || walletTransactionCharges.length() == 0)) {
                if (p.a(taxInclusionFlag, "true", true)) {
                    MpQrDetailBinding mpQrDetailBinding = this.mBinding;
                    if (mpQrDetailBinding == null) {
                        k.a("mBinding");
                    }
                    CustomTextView customTextView = mpQrDetailBinding.tvZeroCostSubheading;
                    k.b(customTextView, "mBinding.tvZeroCostSubheading");
                    customTextView.setText(walletTransactionCharges + ' ' + getString(R.string.mp_transaction_charges, getString(R.string.mp_tax_included)));
                } else {
                    MpQrDetailBinding mpQrDetailBinding2 = this.mBinding;
                    if (mpQrDetailBinding2 == null) {
                        k.a("mBinding");
                    }
                    CustomTextView customTextView2 = mpQrDetailBinding2.tvZeroCostSubheading;
                    k.b(customTextView2, "mBinding.tvZeroCostSubheading");
                    customTextView2.setText(walletTransactionCharges + ' ' + getString(R.string.mp_transaction_charges, getString(R.string.mp_tax_excluded)));
                }
            }
        }
        if (GTMDataProviderImpl.Companion.getMInstance().isShowOrderQr()) {
            MpQrDetailBinding mpQrDetailBinding3 = this.mBinding;
            if (mpQrDetailBinding3 == null) {
                k.a("mBinding");
            }
            CustomTextView customTextView3 = mpQrDetailBinding3.tvOrderAllInOneQr;
            k.b(customTextView3, "mBinding.tvOrderAllInOneQr");
            customTextView3.setVisibility(0);
        } else {
            MpQrDetailBinding mpQrDetailBinding4 = this.mBinding;
            if (mpQrDetailBinding4 == null) {
                k.a("mBinding");
            }
            CustomTextView customTextView4 = mpQrDetailBinding4.tvOrderAllInOneQr;
            k.b(customTextView4, "mBinding.tvOrderAllInOneQr");
            customTextView4.setVisibility(8);
        }
        MpQrDetailBinding mpQrDetailBinding5 = this.mBinding;
        if (mpQrDetailBinding5 == null) {
            k.a("mBinding");
        }
        return mpQrDetailBinding5.getRoot();
    }

    public final void initUI() {
        setListeners();
    }

    public final void openDownloadQR() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this.mContext, "paytmba://business-app/business-app/h/accept-payments/download-qr");
        GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "verify_QR_QR_Shown", "Download QR clicked", "", "");
    }

    public final void setListeners() {
        MpQrDetailBinding mpQrDetailBinding = this.mBinding;
        if (mpQrDetailBinding == null) {
            k.a("mBinding");
        }
        mpQrDetailBinding.tvDownloadPrintQr.setOnClickListener(new AlInOneQrDetailFragment$setListeners$1(this));
        MpQrDetailBinding mpQrDetailBinding2 = this.mBinding;
        if (mpQrDetailBinding2 == null) {
            k.a("mBinding");
        }
        mpQrDetailBinding2.tvOrderAllInOneQr.setOnClickListener(new AlInOneQrDetailFragment$setListeners$2(this));
        MpQrDetailBinding mpQrDetailBinding3 = this.mBinding;
        if (mpQrDetailBinding3 == null) {
            k.a("mBinding");
        }
        mpQrDetailBinding3.ivCloseIcon.setOnClickListener(new AlInOneQrDetailFragment$setListeners$3(this));
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AlInOneQrDetailFragment newInstance() {
            return new AlInOneQrDetailFragment();
        }
    }
}
