package net.one97.paytm.nativesdk.orflow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

public abstract class BaseBottomSheetDialogFragment extends f {
    private HashMap _$_findViewCache;
    public View mView;
    private boolean saveActivityFromFinish;

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

    public void disableUiInteraction() {
    }

    public void enableUiInteraction() {
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public boolean isBottomSheetCancelable() {
        return true;
    }

    public boolean isHideable() {
        return true;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final View getMView() {
        View view = this.mView;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.mView = view;
    }

    public final boolean getSaveActivityFromFinish() {
        return this.saveActivityFromFinish;
    }

    public final void setSaveActivityFromFinish(boolean z) {
        this.saveActivityFromFinish = z;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogStyle);
        setCancelable(isBottomSheetCancelable());
    }

    public void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(getLayoutId(), container, false)");
        this.mView = inflate;
        View view = this.mView;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        addBottomSheetBehaviour();
        initView();
    }

    /* access modifiers changed from: protected */
    public void addBottomSheetBehaviour() {
        View view = this.mView;
        if (view == null) {
            k.a("mView");
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            View view2 = (View) parent;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                view2.setBackgroundColor(b.c(context, 17170445));
                CoordinatorLayout.Behavior a2 = dVar.a();
                if (a2 != null && (a2 instanceof BottomSheetBehavior)) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) a2;
                    bottomSheetBehavior.setHideable(isHideable());
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        bottomSheetBehavior.setPeekHeight(SDKUtility.getScreenHeight(activity));
                        bottomSheetBehavior.setState(3);
                        bottomSheetBehavior.setBottomSheetCallback(new BaseBottomSheetDialogFragment$addBottomSheetBehaviour$1(this));
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                }
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final void dismiss(boolean z) {
        this.saveActivityFromFinish = z;
        dismissAllowingStateLoss();
    }
}
