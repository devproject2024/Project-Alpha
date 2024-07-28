package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;

public abstract class BasePromoPayOptionSheet<T extends ai> extends BaseBottomSheetDialogFragment implements View.OnClickListener, VerifyPromoResultListener {
    private HashMap _$_findViewCache;
    private boolean isPromoApplied;
    public T mViewModel;
    private OnDismissListener onDismissListener;

    public interface OnDismissListener {
        void closeActivity();

        void onDismiss(boolean z);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
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

    public abstract T getViewModel();

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* access modifiers changed from: protected */
    public final OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    /* access modifiers changed from: protected */
    public final void setOnDismissListener(OnDismissListener onDismissListener2) {
        this.onDismissListener = onDismissListener2;
    }

    /* access modifiers changed from: protected */
    public final boolean isPromoApplied() {
        return this.isPromoApplied;
    }

    /* access modifiers changed from: protected */
    public final void setPromoApplied(boolean z) {
        this.isPromoApplied = z;
    }

    public final T getMViewModel() {
        T t = this.mViewModel;
        if (t == null) {
            k.a("mViewModel");
        }
        return t;
    }

    public final void setMViewModel(T t) {
        k.c(t, "<set-?>");
        this.mViewModel = t;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mViewModel = getViewModel();
        PromoHelper.Companion.getInstance().setServer();
    }

    public void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager?.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    public final void setDismissListener(OnDismissListener onDismissListener2) {
        k.c(onDismissListener2, "onDismissListener");
        this.onDismissListener = onDismissListener2;
    }

    public void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss(this.isPromoApplied);
        }
        PromoHelper.Companion.getInstance().removeVerifyPromoObserver(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss(this.isPromoApplied);
        }
        PromoHelper.Companion.getInstance().removeVerifyPromoObserver(this);
        if (this.onDismissListener == null) {
            PromoHelper.Companion.getInstance().onPromoSearchActivityDestroy(this.isPromoApplied);
            PromoHelper.Companion.getInstance().clearAllListeners();
        }
    }

    /* access modifiers changed from: protected */
    public final void applyOffer() {
        PromoHelper.Companion.getInstance().setBankOfferPromoCode(PromoHelper.Companion.getInstance().getSelectedPromoCode());
        PromoHelper.Companion.getInstance().setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntentBeforeApply());
        PromoHelper.Companion.getInstance().setSelectedPaymentInstrument(PromoHelper.Companion.getInstance().getPaymentInstrumentBeforeApply());
        this.isPromoApplied = true;
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 == null) {
            dismissAllowingStateLoss();
        } else if (onDismissListener2 != null) {
            onDismissListener2.closeActivity();
        }
    }
}
