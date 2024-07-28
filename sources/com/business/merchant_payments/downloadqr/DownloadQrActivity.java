package com.business.merchant_payments.downloadqr;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.databinding.MpQrViewBinding;
import com.business.merchant_payments.event.DownloadQREVent;
import com.business.merchant_payments.newhome.ManageQrViewHandler;
import com.business.merchant_payments.newhome.QrViewModel;
import java.util.HashMap;
import kotlin.g.b.k;
import org.greenrobot.eventbus.j;

public final class DownloadQrActivity extends BaseActivity {
    public HashMap _$_findViewCache;
    public MpQrViewBinding mBinding;
    public ManageQrViewHandler manageQrViewHandler;
    public QrViewModel qrViewModel;

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
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ ManageQrViewHandler access$getManageQrViewHandler$p(DownloadQrActivity downloadQrActivity) {
        ManageQrViewHandler manageQrViewHandler2 = downloadQrActivity.manageQrViewHandler;
        if (manageQrViewHandler2 == null) {
            k.a("manageQrViewHandler");
        }
        return manageQrViewHandler2;
    }

    public static final /* synthetic */ QrViewModel access$getQrViewModel$p(DownloadQrActivity downloadQrActivity) {
        QrViewModel qrViewModel2 = downloadQrActivity.qrViewModel;
        if (qrViewModel2 == null) {
            k.a("qrViewModel");
        }
        return qrViewModel2;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(512);
            getWindow().addFlags(134217728);
        }
        c provideViewModel = provideViewModel(QrViewModel.class, (Fragment) null);
        k.b(provideViewModel, "provideViewModel(QrViewModel::class.java, null)");
        this.qrViewModel = (QrViewModel) provideViewModel;
        ViewDataBinding a2 = f.a(this, R.layout.mp_qr_view);
        k.b(a2, "DataBindingUtil.setConte…his, R.layout.mp_qr_view)");
        MpQrViewBinding mpQrViewBinding = (MpQrViewBinding) a2;
        this.mBinding = mpQrViewBinding;
        if (mpQrViewBinding == null) {
            k.a("mBinding");
        }
        View root = mpQrViewBinding.getRoot();
        k.b(root, "mBinding.root");
        root.setVisibility(4);
        QrViewModel qrViewModel2 = this.qrViewModel;
        if (qrViewModel2 == null) {
            k.a("qrViewModel");
        }
        MpQrViewBinding mpQrViewBinding2 = this.mBinding;
        if (mpQrViewBinding2 == null) {
            k.a("mBinding");
        }
        this.manageQrViewHandler = new ManageQrViewHandler(qrViewModel2, mpQrViewBinding2, this);
        observeQrSummaryApi();
    }

    private final void observeQrSummaryApi() {
        QrViewModel qrViewModel2 = this.qrViewModel;
        if (qrViewModel2 == null) {
            k.a("qrViewModel");
        }
        qrViewModel2.getmObservableQrSummary().observe(this, new DownloadQrActivity$observeQrSummaryApi$1(this));
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        ManageQrViewHandler.QrPageItemViewModelNew viewModel;
        k.d(strArr, "permissions");
        k.d(iArr, "grantResults");
        if (!(!(iArr.length == 0)) || iArr[0] != 0) {
            if (i2 == 201) {
                DialogUtility.showAlert(this, "", getString(R.string.mp_go_to_settings_storage));
            }
        } else if (i2 == 201) {
            ManageQrViewHandler manageQrViewHandler2 = this.manageQrViewHandler;
            if (manageQrViewHandler2 == null) {
                k.a("manageQrViewHandler");
            }
            if (!(manageQrViewHandler2 == null || (viewModel = manageQrViewHandler2.getViewModel()) == null)) {
                viewModel.onShareBtnClicked(true);
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void onStart() {
        super.onStart();
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    public final void onStop() {
        super.onStop();
        org.greenrobot.eventbus.c.a().b(this);
    }

    @j
    public final void onEvent(DownloadQREVent downloadQREVent) {
        k.d(downloadQREVent, "downloadQREVent");
        finish();
    }
}
