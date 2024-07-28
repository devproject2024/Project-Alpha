package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.utility.b.b;
import com.travel.train.R;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.i.f;

public final class z extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27245a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f27246b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f27247c;

    public final View a(int i2) {
        if (this.f27247c == null) {
            this.f27247c = new HashMap();
        }
        View view = (View) this.f27247c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f27247c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme_train);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments != null && arguments.containsKey("qr_code_url")) {
                this.f27246b = arguments.getString("qr_code_url");
                return;
            }
            return;
        }
        throw new RuntimeException("Arguments required");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_qr_code_dialog_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) a(R.id.cross_button)).setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_layout);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.a();
        }
        ((ImageView) a(R.id.cross_button)).setOnClickListener(new c(this));
        if (this.f27246b != null) {
            Context context = getContext();
            if (context != null) {
                b.a aVar = com.paytm.utility.b.b.f43744a;
                k.a((Object) context, "it");
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = this.f27246b;
                a2.a((ImageView) a(R.id.qr_code_view), (com.paytm.utility.b.b.b<?>) new b(this));
                return;
            }
            return;
        }
        ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmer_layout);
        if (shimmerFrameLayout2 != null) {
            shimmerFrameLayout2.b();
        }
        ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) a(R.id.shimmer_layout);
        if (shimmerFrameLayout3 != null) {
            shimmerFrameLayout3.setVisibility(8);
        }
        ImageView imageView = (ImageView) a(R.id.qr_code_view);
        k.a((Object) imageView, "qr_code_view");
        imageView.setVisibility(8);
        TextView textView = (TextView) a(R.id.error_text);
        k.a((Object) textView, "error_text");
        textView.setVisibility(0);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f27249a;

        c(z zVar) {
            this.f27249a = zVar;
        }

        public final void onClick(View view) {
            this.f27249a.dismiss();
        }
    }

    public static final class b implements com.paytm.utility.b.b.b<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f27248a;

        b(z zVar) {
            this.f27248a = zVar;
        }

        public final void onError(Exception exc) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f27248a.a(R.id.shimmer_layout);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.f27248a.a(R.id.shimmer_layout);
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.f27248a.a(R.id.qr_code_view);
            k.a((Object) imageView, "qr_code_view");
            imageView.setVisibility(8);
            TextView textView = (TextView) this.f27248a.a(R.id.error_text);
            k.a((Object) textView, "error_text");
            textView.setVisibility(0);
        }

        public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f27248a.a(R.id.shimmer_layout);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            ImageView imageView = (ImageView) this.f27248a.a(R.id.qr_code_view);
            k.a((Object) imageView, "qr_code_view");
            imageView.setVisibility(0);
            TextView textView = (TextView) this.f27248a.a(R.id.error_text);
            k.a((Object) textView, "error_text");
            textView.setVisibility(8);
        }
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f27247c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final z a(Bundle bundle) {
        k.c(bundle, "args");
        z zVar = new z();
        zVar.setArguments(bundle);
        return zVar;
    }
}
