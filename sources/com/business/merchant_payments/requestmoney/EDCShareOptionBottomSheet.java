package com.business.merchant_payments.requestmoney;

import android.os.Bundle;
import android.view.View;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;

public final class EDCShareOptionBottomSheet extends CustomBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public HashMap _$_findViewCache;

    public static final EDCShareOptionBottomSheet newInstance() {
        return Companion.newInstance$default(Companion, (Bundle) null, 1, (Object) null);
    }

    public static final EDCShareOptionBottomSheet newInstance(Bundle bundle) {
        return Companion.newInstance(bundle);
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
        public final EDCShareOptionBottomSheet newInstance() {
            return newInstance$default(this, (Bundle) null, 1, (Object) null);
        }

        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ EDCShareOptionBottomSheet newInstance$default(Companion companion, Bundle bundle, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bundle = null;
            }
            return companion.newInstance(bundle);
        }

        public final EDCShareOptionBottomSheet newInstance(Bundle bundle) {
            EDCShareOptionBottomSheet eDCShareOptionBottomSheet = new EDCShareOptionBottomSheet();
            if (bundle != null) {
                eDCShareOptionBottomSheet.setArguments(bundle);
            }
            return eDCShareOptionBottomSheet;
        }
    }
}
