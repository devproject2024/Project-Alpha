package com.paytm.android.chat.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final C0695a f42036a = new C0695a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f42037b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f42038c;

    private View a(int i2) {
        if (this.f42038c == null) {
            this.f42038c = new HashMap();
        }
        View view = (View) this.f42038c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f42038c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: com.paytm.android.chat.fragment.a$a  reason: collision with other inner class name */
    public static final class C0695a {
        private C0695a() {
        }

        public /* synthetic */ C0695a(byte b2) {
            this();
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
        return layoutInflater.inflate(R.layout.chat_dialog_fragment_contact_permission_user_consent, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
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
        final /* synthetic */ a f42039a;

        b(a aVar) {
            this.f42039a = aVar;
        }

        public final void onClick(View view) {
            this.f42039a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42040a;

        c(a aVar) {
            this.f42040a = aVar;
        }

        public final void onClick(View view) {
            this.f42040a.dismiss();
            b a2 = this.f42040a.f42037b;
            if (a2 != null) {
                a2.b();
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
        HashMap hashMap = this.f42038c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
