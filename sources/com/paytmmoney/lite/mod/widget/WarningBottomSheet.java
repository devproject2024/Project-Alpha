package com.paytmmoney.lite.mod.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.b;
import com.paytmmoney.lite.mod.R;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class WarningBottomSheet extends b {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Listener listener;
    private Button no_btn;
    private Button yes_btn;

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

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (getParentFragment() instanceof Listener) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.listener = (Listener) parentFragment;
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytmmoney.lite.mod.widget.WarningBottomSheet.Listener");
        } else if (context instanceof Listener) {
            this.listener = (Listener) context;
        }
    }

    public final void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        View inflate = View.inflate(getContext(), R.layout.pm_warning_sheet_layout, (ViewGroup) null);
        dialog.setContentView(inflate);
        k.a((Object) inflate, "contentView");
        initViews(inflate);
        ViewParent parent = inflate.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            viewGroup.setBackgroundColor(androidx.core.content.b.c(context, R.color.transparent));
        }
    }

    private final void initViews(View view) {
        View findViewById = view.findViewById(R.id.yes_btn);
        k.a((Object) findViewById, "rootView.findViewById(R.id.yes_btn)");
        this.yes_btn = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.no_btn);
        k.a((Object) findViewById2, "rootView.findViewById(R.id.no_btn)");
        this.no_btn = (Button) findViewById2;
        Button button = this.yes_btn;
        if (button == null) {
            k.a("yes_btn");
        }
        button.setOnClickListener(new WarningBottomSheet$initViews$1(this));
        Button button2 = this.no_btn;
        if (button2 == null) {
            k.a("no_btn");
        }
        button2.setOnClickListener(new WarningBottomSheet$initViews$2(this));
    }

    public interface Listener {
        void okClick(Integer num);

        public static final class DefaultImpls {
            public static /* synthetic */ void okClick$default(Listener listener, Integer num, int i2, Object obj) {
                if (obj == null) {
                    if ((i2 & 1) != 0) {
                        num = null;
                    }
                    listener.okClick(num);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: okClick");
            }
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WarningBottomSheet newInstance() {
            WarningBottomSheet warningBottomSheet = new WarningBottomSheet();
            warningBottomSheet.setArguments(new Bundle());
            return warningBottomSheet;
        }
    }
}
