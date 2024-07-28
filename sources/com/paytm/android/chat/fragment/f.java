package com.paytm.android.chat.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public final class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42082a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public g f42083b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f42084c;

    public final View a(int i2) {
        if (this.f42084c == null) {
            this.f42084c = new HashMap();
        }
        View view = (View) this.f42084c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f42084c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f a(g gVar) {
            k.c(gVar, "listener");
            f fVar = new f();
            fVar.f42083b = gVar;
            return fVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Window window2;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
            window.requestFeature(1);
        }
        return layoutInflater.inflate(R.layout.chat_dialog_mark_as_read, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((CheckBox) a(R.id.dialogCheckBox)).setTypeface(Typeface.create("sans-serif-medium", 0));
        RoboTextView roboTextView = (RoboTextView) a(R.id.btnNonNow);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(new b(this));
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.btnContinue);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(new c(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f42085a;

        b(f fVar) {
            this.f42085a = fVar;
        }

        public final void onClick(View view) {
            this.f42085a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f42086a;

        c(f fVar) {
            this.f42086a = fVar;
        }

        public final void onClick(View view) {
            this.f42086a.dismiss();
            g a2 = this.f42086a.f42083b;
            if (a2 != null) {
                CheckBox checkBox = (CheckBox) this.f42086a.a(R.id.dialogCheckBox);
                k.a((Object) checkBox, "dialogCheckBox");
                a2.onMarkAsReadConfirmationContinueClicked(checkBox.isChecked());
            }
        }
    }

    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            Resources system = Resources.getSystem();
            k.a((Object) system, "Resources.getSystem()");
            int i2 = system.getDisplayMetrics().widthPixels - 100;
            if (i2 <= 0) {
                i2 = DensityUtil.dp2px(350.0f);
            }
            window.setLayout(i2, -2);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f42084c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
