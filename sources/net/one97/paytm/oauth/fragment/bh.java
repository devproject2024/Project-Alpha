package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.R;

public final class bh extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56434a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f56435b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f56436c;

    public bh() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bh(View.OnClickListener onClickListener) {
        this();
        k.c(onClickListener, "listener");
        this.f56435b = onClickListener;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.DialogFragmentStyle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return layoutInflater.inflate(R.layout.fragment_dialog_session_expired, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onActivityCreated(r3)
            int r3 = net.one97.paytm.oauth.R.id.btnOk
            java.util.HashMap r0 = r2.f56436c
            if (r0 != 0) goto L_0x0010
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2.f56436c = r0
        L_0x0010:
            java.util.HashMap r0 = r2.f56436c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.Object r0 = r0.get(r1)
            android.view.View r0 = (android.view.View) r0
            if (r0 != 0) goto L_0x0033
            android.view.View r0 = r2.getView()
            if (r0 != 0) goto L_0x0026
            r3 = 0
            goto L_0x0034
        L_0x0026:
            android.view.View r0 = r0.findViewById(r3)
            java.util.HashMap r1 = r2.f56436c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.put(r3, r0)
        L_0x0033:
            r3 = r0
        L_0x0034:
            net.one97.paytm.oauth.view.ProgressViewButton r3 = (net.one97.paytm.oauth.view.ProgressViewButton) r3
            if (r3 == 0) goto L_0x003e
            r0 = r2
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r3.setOnClickListener(r0)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.bh.onActivityCreated(android.os.Bundle):void");
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnOk;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (this.f56435b != null) {
                View.OnClickListener onClickListener = this.f56435b;
                if (onClickListener == null) {
                    k.a("clickListener");
                }
                onClickListener.onClick(view);
            }
            dismissAllowingStateLoss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56436c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
