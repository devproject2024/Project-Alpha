package net.one97.paytm.upi.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.j;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;

public final class IncorrectUpiPinBottomSheet extends f {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public final String SHOW_WITHOUT_RE_ENTER = "show_without_re_enter";
    private HashMap _$_findViewCache;
    private Group groupReEnterPin;
    /* access modifiers changed from: private */
    public OnItemClick onItemClick;
    private TextView title;
    private TextView tvCreateNewMpin;
    private TextView tvReEnterMpin;

    public interface OnItemClick {
        void onCreateNewPinClicked();

        void onReEnterClicked();
    }

    public static final void show(OnItemClick onItemClick2, j jVar, boolean z) {
        Companion.show(onItemClick2, jVar, z);
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

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_incorrect_upi_pin, (ViewGroup) null);
        dialog.setContentView(inflate);
        k.a((Object) inflate, "view");
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            View view = (View) parent;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            view.setBackgroundColor(androidx.core.content.b.c(context, 17170445));
            View findViewById = inflate.findViewById(R.id.reEnterUpiPin);
            k.a((Object) findViewById, "findViewById(R.id.reEnterUpiPin)");
            this.tvReEnterMpin = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.createNewPin);
            k.a((Object) findViewById2, "findViewById(R.id.createNewPin)");
            this.tvCreateNewMpin = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.tvTitle);
            k.a((Object) findViewById3, "findViewById(R.id.tvTitle)");
            this.title = (TextView) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.reEnterUpiPinGroup);
            k.a((Object) findViewById4, "findViewById(R.id.reEnterUpiPinGroup)");
            this.groupReEnterPin = (Group) findViewById4;
            TextView textView = this.tvReEnterMpin;
            if (textView == null) {
                k.a("tvReEnterMpin");
            }
            textView.setOnClickListener(new a(this));
            TextView textView2 = this.tvCreateNewMpin;
            if (textView2 == null) {
                k.a("tvCreateNewMpin");
            }
            textView2.setOnClickListener(new b(this));
            handleIntent();
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IncorrectUpiPinBottomSheet f69534a;

        a(IncorrectUpiPinBottomSheet incorrectUpiPinBottomSheet) {
            this.f69534a = incorrectUpiPinBottomSheet;
        }

        public final void onClick(View view) {
            OnItemClick access$getOnItemClick$p = this.f69534a.onItemClick;
            if (access$getOnItemClick$p != null) {
                access$getOnItemClick$p.onReEnterClicked();
            }
            this.f69534a.dismiss();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IncorrectUpiPinBottomSheet f69535a;

        b(IncorrectUpiPinBottomSheet incorrectUpiPinBottomSheet) {
            this.f69535a = incorrectUpiPinBottomSheet;
        }

        public final void onClick(View view) {
            OnItemClick access$getOnItemClick$p = this.f69535a.onItemClick;
            if (access$getOnItemClick$p != null) {
                access$getOnItemClick$p.onCreateNewPinClicked();
            }
            this.f69535a.dismiss();
        }
    }

    private final void handleIntent() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean(this.SHOW_WITHOUT_RE_ENTER)) {
            Group group = this.groupReEnterPin;
            if (group == null) {
                k.a("groupReEnterPin");
            }
            group.setVisibility(8);
            TextView textView = this.title;
            if (textView == null) {
                k.a("title");
            }
            textView.setText(getString(R.string.upi_incorrect_mpin_added_many_times));
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        if (!jVar.h() && !jVar.i()) {
            super.show(jVar, str);
        }
    }

    public final void onDestroy() {
        this.onItemClick = null;
        super.onDestroy();
    }

    public final void setOnItemClick(OnItemClick onItemClick2) {
        k.c(onItemClick2, "onItemClick");
        this.onItemClick = onItemClick2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void show(OnItemClick onItemClick, j jVar, boolean z) {
            k.c(onItemClick, "onItemClick");
            k.c(jVar, "fragmentManager");
            IncorrectUpiPinBottomSheet incorrectUpiPinBottomSheet = new IncorrectUpiPinBottomSheet();
            incorrectUpiPinBottomSheet.setOnItemClick(onItemClick);
            Bundle bundle = new Bundle();
            bundle.putBoolean(incorrectUpiPinBottomSheet.SHOW_WITHOUT_RE_ENTER, z);
            incorrectUpiPinBottomSheet.setArguments(bundle);
            incorrectUpiPinBottomSheet.show(jVar, "tag");
        }
    }
}
