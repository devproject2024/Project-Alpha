package com.business.merchant_payments.requestmoney;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CreateLinkBottomSheetFragment extends CustomBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public static final CreateLinkBottomSheetFragment INSTANCE = new CreateLinkBottomSheetFragment();
    public HashMap _$_findViewCache;
    public CustomTextView mOkButton;

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

        public final CreateLinkBottomSheetFragment getINSTANCE() {
            return CreateLinkBottomSheetFragment.INSTANCE;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mp_create_link_bottom_sheet_message, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
        setOnClickListeners();
    }

    private final void initUI() {
        CustomTextView customTextView = (CustomTextView) _$_findCachedViewById(R.id.ok_got_it_button);
        k.b(customTextView, "ok_got_it_button");
        this.mOkButton = customTextView;
    }

    private final void setOnClickListeners() {
        CustomTextView customTextView = this.mOkButton;
        if (customTextView == null) {
            k.a("mOkButton");
        }
        if (customTextView != null) {
            customTextView.setOnClickListener(new CreateLinkBottomSheetFragment$setOnClickListeners$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void closeFragment() {
        q a2;
        j fragmentManager = getFragmentManager();
        if (fragmentManager != null && (a2 = fragmentManager.a().a((Fragment) this)) != null) {
            a2.b();
        }
    }
}
