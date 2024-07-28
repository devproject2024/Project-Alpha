package com.paytm.paymentsettings.paytmassist.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.e.a.j;
import com.bumptech.glide.e.g;
import com.bumptech.glide.h;
import com.bumptech.glide.load.b.q;
import com.paytm.paymentsettings.R;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final C0743a f43581a = new C0743a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static com.paytm.paymentsettings.paytmassist.model.a f43582c;

    /* renamed from: b  reason: collision with root package name */
    private String f43583b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f43584d;

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomActiveSubscriptionsBottomSheetTheme);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.f43583b = arguments != null ? arguments.getString("tag") : null;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.layout_confirm_delete_nb_username, viewGroup, false);
        View inflate2 = layoutInflater.inflate(R.layout.layout_assist_nb_how_it_works, viewGroup, false);
        if (p.a(getTag(), "delete_nb_username", false)) {
            ((Button) inflate.findViewById(R.id.btn_cancel_delete)).setOnClickListener(b.f43585a);
            ((TextView) inflate.findViewById(R.id.tv_yes_delete)).setOnClickListener(c.f43586a);
            return inflate;
        }
        if (p.a(getTag(), "how_it_works", false)) {
            ((ImageView) inflate2.findViewById(R.id.iv_dismiss_assist_bottomsheet)).setOnClickListener(d.f43587a);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.iv_how_it_works);
            ProgressBar progressBar = (ProgressBar) inflate2.findViewById(R.id.pb_loading_gif);
            if (getContext() != null) {
                k.a((Object) progressBar, "mProgressBar");
                progressBar.setVisibility(0);
                k.a((Object) imageView, "mGifImageView");
                imageView.setVisibility(4);
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                h<com.bumptech.glide.load.d.e.c> a2 = com.bumptech.glide.b.b(context).e().a(new e(progressBar, imageView));
                Context context2 = getContext();
                a2.a(context2 != null ? context2.getString(R.string.how_it_works_url) : null).a(imageView);
            }
        }
        return inflate2;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f43585a = new b();

        b() {
        }

        public final void onClick(View view) {
            com.paytm.paymentsettings.paytmassist.model.a a2 = a.f43582c;
            if (a2 == null) {
                k.a("bottomSheetListener");
            }
            if (a2 != null) {
                a2.onNegative();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f43586a = new c();

        c() {
        }

        public final void onClick(View view) {
            com.paytm.paymentsettings.paytmassist.model.a a2 = a.f43582c;
            if (a2 == null) {
                k.a("bottomSheetListener");
            }
            if (a2 != null) {
                a2.onPositive();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f43587a = new d();

        d() {
        }

        public final void onClick(View view) {
            com.paytm.paymentsettings.paytmassist.model.a a2 = a.f43582c;
            if (a2 == null) {
                k.a("bottomSheetListener");
            }
            if (a2 != null) {
                a2.onDismiss();
            }
        }
    }

    public static final class e implements g<com.bumptech.glide.load.d.e.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f43588a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageView f43589b;

        public final boolean onLoadFailed(q qVar, Object obj, j<com.bumptech.glide.load.d.e.c> jVar, boolean z) {
            return false;
        }

        e(ProgressBar progressBar, ImageView imageView) {
            this.f43588a = progressBar;
            this.f43589b = imageView;
        }

        public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, j jVar, com.bumptech.glide.load.a aVar, boolean z) {
            ProgressBar progressBar = this.f43588a;
            k.a((Object) progressBar, "mProgressBar");
            progressBar.setVisibility(8);
            ImageView imageView = this.f43589b;
            k.a((Object) imageView, "mGifImageView");
            imageView.setVisibility(0);
            return false;
        }
    }

    /* renamed from: com.paytm.paymentsettings.paytmassist.view.ui.a$a  reason: collision with other inner class name */
    public static final class C0743a {
        private C0743a() {
        }

        public /* synthetic */ C0743a(byte b2) {
            this();
        }

        public static a a(String str, com.paytm.paymentsettings.paytmassist.model.a aVar) {
            k.c(aVar, "listner");
            a.f43582c = aVar;
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            aVar2.setArguments(bundle);
            return aVar2;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f43584d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
