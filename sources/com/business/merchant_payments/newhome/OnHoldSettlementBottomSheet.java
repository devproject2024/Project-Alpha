package com.business.merchant_payments.newhome;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpBottomsheetSettlementOnholdBinding;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class OnHoldSettlementBottomSheet extends CustomBottomSheetDialogFragment {
    public static final Companion Companion;
    public static final String TAG;
    public HashMap _$_findViewCache;
    public MpBottomsheetSettlementOnholdBinding mBinding;

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

        public final String getTAG() {
            return OnHoldSettlementBottomSheet.TAG;
        }
    }

    static {
        Companion companion = new Companion((g) null);
        Companion = companion;
        String simpleName = companion.getClass().getSimpleName();
        k.b(simpleName, "this::class.java.simpleName");
        TAG = simpleName;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        View decorView;
        k.d(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.mp_bottomsheet_settlement_onhold, viewGroup, false);
        k.b(a2, "DataBindingUtil.inflate(…onhold, container, false)");
        this.mBinding = (MpBottomsheetSettlementOnholdBinding) a2;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
            decorView.setBackgroundDrawable(new ColorDrawable(0));
        }
        setListeners();
        MpBottomsheetSettlementOnholdBinding mpBottomsheetSettlementOnholdBinding = this.mBinding;
        if (mpBottomsheetSettlementOnholdBinding == null) {
            k.a("mBinding");
        }
        return mpBottomsheetSettlementOnholdBinding.getRoot();
    }

    public final void setListeners() {
        MpBottomsheetSettlementOnholdBinding mpBottomsheetSettlementOnholdBinding = this.mBinding;
        if (mpBottomsheetSettlementOnholdBinding == null) {
            k.a("mBinding");
        }
        mpBottomsheetSettlementOnholdBinding.btnOk.setOnClickListener(new OnHoldSettlementBottomSheet$setListeners$1(this));
        MpBottomsheetSettlementOnholdBinding mpBottomsheetSettlementOnholdBinding2 = this.mBinding;
        if (mpBottomsheetSettlementOnholdBinding2 == null) {
            k.a("mBinding");
        }
        mpBottomsheetSettlementOnholdBinding2.ivClose.setOnClickListener(new OnHoldSettlementBottomSheet$setListeners$2(this));
    }
}
