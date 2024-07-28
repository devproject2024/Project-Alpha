package net.one97.paytm.nativesdk.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;

public final class RetryBottomSheet extends BaseBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public static final String MESSAGE = "message";
    public static final String TAG = "RetryBottomSheet";
    private HashMap _$_findViewCache;
    private String message;

    public static final RetryBottomSheet getInstance(String str) {
        return Companion.getInstance(str);
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

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final RetryBottomSheet getInstance(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("message", str);
            RetryBottomSheet retryBottomSheet = new RetryBottomSheet();
            retryBottomSheet.setArguments(bundle);
            return retryBottomSheet;
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager?.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    public final int getLayoutId() {
        return R.layout.native_retry_layout;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle == null || (str = bundle.getString("message")) == null) {
            str = "";
        }
        this.message = str;
    }

    public final void initView() {
        ExtensionsKt.isNotNullNotBlank(this.message, new RetryBottomSheet$initView$1(this));
        ((Button) _$_findCachedViewById(R.id.btn_proceed)).setOnClickListener(new RetryBottomSheet$initView$2(this));
    }
}
