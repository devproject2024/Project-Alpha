package com.business.merchant_payments.newhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.databinding.MpQrViewNewBinding;
import com.business.merchant_payments.qr.ManageQrViewHandlerNew;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class QrBottomSheet extends CustomBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public static final String SHOW_VERIFY_QR = "show_verify_qr";
    public HashMap _$_findViewCache;
    public MpQrViewNewBinding binding;
    public ManageQrViewHandlerNew manageQrViewHandler;
    public final QrViewModel qrViewModel;

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

    public QrBottomSheet(QrViewModel qrViewModel2) {
        k.d(qrViewModel2, "qrViewModel");
        this.qrViewModel = qrViewModel2;
    }

    public static final /* synthetic */ ManageQrViewHandlerNew access$getManageQrViewHandler$p(QrBottomSheet qrBottomSheet) {
        ManageQrViewHandlerNew manageQrViewHandlerNew = qrBottomSheet.manageQrViewHandler;
        if (manageQrViewHandlerNew == null) {
            k.a("manageQrViewHandler");
        }
        return manageQrViewHandlerNew;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        MpQrViewNewBinding inflate = MpQrViewNewBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "MpQrViewNewBinding.infla…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            k.a("binding");
        }
        initializeQrHandler(inflate);
        MpQrViewNewBinding mpQrViewNewBinding = this.binding;
        if (mpQrViewNewBinding == null) {
            k.a("binding");
        }
        View root = mpQrViewNewBinding.getRoot();
        k.b(root, "binding.root");
        return root;
    }

    private final void initializeQrHandler(MpQrViewNewBinding mpQrViewNewBinding) {
        this.manageQrViewHandler = new ManageQrViewHandlerNew(this.qrViewModel, mpQrViewNewBinding, getActivity());
        observeQrSummaryApi();
    }

    private final void observeQrSummaryApi() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.qrViewModel.getmObservableQrSummary().observe(activity, new QrBottomSheet$observeQrSummaryApi$$inlined$let$lambda$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void chekForVerifyQrPopup() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean(SHOW_VERIFY_QR)) {
            ManageQrViewHandlerNew manageQrViewHandlerNew = this.manageQrViewHandler;
            if (manageQrViewHandlerNew == null) {
                k.a("manageQrViewHandler");
            }
            manageQrViewHandlerNew.showVerifyQrFlow();
        }
    }

    public final void showVerifyQrPopup() {
        ManageQrViewHandlerNew manageQrViewHandlerNew = this.manageQrViewHandler;
        if (manageQrViewHandlerNew == null) {
            k.a("manageQrViewHandler");
        }
        manageQrViewHandlerNew.showVerifyQrFlow();
    }

    public final void onQRPermissionGranted(boolean z) {
        ManageQrViewHandlerNew manageQrViewHandlerNew = this.manageQrViewHandler;
        if (manageQrViewHandlerNew == null) {
            k.a("manageQrViewHandler");
        }
        manageQrViewHandlerNew.permissionGranted(z);
    }
}
