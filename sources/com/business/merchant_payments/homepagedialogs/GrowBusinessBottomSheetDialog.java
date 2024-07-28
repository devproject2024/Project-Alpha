package com.business.merchant_payments.homepagedialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.view.BaseBottomSheetDialogFragment;
import com.business.merchant_payments.databinding.MpDialogDownloadBusinessAppBinding;
import com.business.merchant_payments.databinding.MpDialogOrderQrCodeNowBinding;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.k;

public final class GrowBusinessBottomSheetDialog extends BaseBottomSheetDialogFragment {
    public HashMap _$_findViewCache;
    public HomeDialogsManager homeDialogsManager;
    public MpDialogDownloadBusinessAppBinding mDialogDownloadAppBinding;
    public MpDialogOrderQrCodeNowBinding mDialogOrderQRCodeBinding;
    public int purpose = -1;

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

    public final void initUI() {
        int i2 = this.purpose;
        if (i2 == 1) {
            MpDialogOrderQrCodeNowBinding mpDialogOrderQrCodeNowBinding = this.mDialogOrderQRCodeBinding;
            k.a((Object) mpDialogOrderQrCodeNowBinding);
            handleBottomSheetBehavior(mpDialogOrderQrCodeNowBinding.rootView);
        } else if (i2 == 2) {
            MpDialogDownloadBusinessAppBinding mpDialogDownloadBusinessAppBinding = this.mDialogDownloadAppBinding;
            k.a((Object) mpDialogDownloadBusinessAppBinding);
            handleBottomSheetBehavior(mpDialogDownloadBusinessAppBinding.rootView);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        HomeDialogsManager homeDialogsManager2 = new HomeDialogsManager(getLifecycle(), new WeakReference(getActivity()));
        this.homeDialogsManager = homeDialogsManager2;
        MpDialogOrderQrCodeNowBinding mpDialogOrderQrCodeNowBinding = this.mDialogOrderQRCodeBinding;
        if (mpDialogOrderQrCodeNowBinding != null) {
            mpDialogOrderQrCodeNowBinding.setParentViewModel(homeDialogsManager2);
        }
        MpDialogDownloadBusinessAppBinding mpDialogDownloadBusinessAppBinding = this.mDialogDownloadAppBinding;
        if (mpDialogDownloadBusinessAppBinding != null) {
            mpDialogDownloadBusinessAppBinding.setParentViewModel(this.homeDialogsManager);
        }
        if (getActivity() == null) {
            return;
        }
        if (this.purpose == 1) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher().a(getActivity(), "accept_payments_home", "Order QR Dialog Shown", "", "");
            return;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        instance2.getEventPublisher().a(getActivity(), "accept_payments_home", "Download P4B Dialog Shown", "", "");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        int i2 = arguments != null ? arguments.getInt("DIALOG_PURPOSE") : -1;
        this.purpose = i2;
        if (i2 == 1) {
            MpDialogOrderQrCodeNowBinding mpDialogOrderQrCodeNowBinding = (MpDialogOrderQrCodeNowBinding) f.a(layoutInflater, R.layout.mp_dialog_order_qr_code_now, viewGroup, false);
            this.mDialogOrderQRCodeBinding = mpDialogOrderQrCodeNowBinding;
            k.a((Object) mpDialogOrderQrCodeNowBinding);
            mpDialogOrderQrCodeNowBinding.setLifecycleOwner(this);
            MpDialogOrderQrCodeNowBinding mpDialogOrderQrCodeNowBinding2 = this.mDialogOrderQRCodeBinding;
            k.a((Object) mpDialogOrderQrCodeNowBinding2);
            mpDialogOrderQrCodeNowBinding2.btnOrderNow.setOnClickListener(new GrowBusinessBottomSheetDialog$onCreateView$1(this));
            MpDialogOrderQrCodeNowBinding mpDialogOrderQrCodeNowBinding3 = this.mDialogOrderQRCodeBinding;
            k.a((Object) mpDialogOrderQrCodeNowBinding3);
            mpDialogOrderQrCodeNowBinding3.btnDoItLater.setOnClickListener(new GrowBusinessBottomSheetDialog$onCreateView$2(this));
            MpDialogOrderQrCodeNowBinding mpDialogOrderQrCodeNowBinding4 = this.mDialogOrderQRCodeBinding;
            if (mpDialogOrderQrCodeNowBinding4 != null) {
                return mpDialogOrderQrCodeNowBinding4.rootView;
            }
            return null;
        } else if (i2 != 2) {
            return null;
        } else {
            MpDialogDownloadBusinessAppBinding mpDialogDownloadBusinessAppBinding = (MpDialogDownloadBusinessAppBinding) f.a(layoutInflater, R.layout.mp_dialog_download_business_app, viewGroup, false);
            this.mDialogDownloadAppBinding = mpDialogDownloadBusinessAppBinding;
            k.a((Object) mpDialogDownloadBusinessAppBinding);
            mpDialogDownloadBusinessAppBinding.setLifecycleOwner(this);
            MpDialogDownloadBusinessAppBinding mpDialogDownloadBusinessAppBinding2 = this.mDialogDownloadAppBinding;
            k.a((Object) mpDialogDownloadBusinessAppBinding2);
            mpDialogDownloadBusinessAppBinding2.btnDoItLater.setOnClickListener(new GrowBusinessBottomSheetDialog$onCreateView$3(this));
            MpDialogDownloadBusinessAppBinding mpDialogDownloadBusinessAppBinding3 = this.mDialogDownloadAppBinding;
            k.a((Object) mpDialogDownloadBusinessAppBinding3);
            mpDialogDownloadBusinessAppBinding3.btnDownloadAppNow.setOnClickListener(new GrowBusinessBottomSheetDialog$onCreateView$4(this));
            MpDialogDownloadBusinessAppBinding mpDialogDownloadBusinessAppBinding4 = this.mDialogDownloadAppBinding;
            if (mpDialogDownloadBusinessAppBinding4 != null) {
                return mpDialogDownloadBusinessAppBinding4.rootView;
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void downloadP4BApp() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher().a(getActivity(), "accept_payments_home", "Download P4B Dialog Order Clicked", "", "");
        HomeDialogsManager homeDialogsManager2 = this.homeDialogsManager;
        if (homeDialogsManager2 != null) {
            homeDialogsManager2.doNotShowThisDialogAgain(2);
        }
        Util.startPaytmBusinessApp(getActivity());
        dismiss();
    }

    /* access modifiers changed from: private */
    public final void orderQRNow() {
        if (getActivity() != null) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher().a(getActivity(), "accept_payments_home", "Order QR Dialog Order Clicked", "", "");
        }
        HomeDialogsManager homeDialogsManager2 = this.homeDialogsManager;
        if (homeDialogsManager2 != null) {
            homeDialogsManager2.doNotShowThisDialogAgain(1);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            instance2.getDeepLinkUtils().a(activity, "paytmba://business-app/h/my-account/manage-qr/order-qr");
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.homeDialogsManager = null;
        this.mDialogDownloadAppBinding = null;
        this.mDialogOrderQRCodeBinding = null;
    }
}
