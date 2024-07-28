package net.one97.paytm.upgradeKyc.videokyc.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upgradeKyc.R;

public final class f extends net.one97.paytm.i.f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f66383b = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private static String f66384d = "SlowInternetBottomSheetTag";

    /* renamed from: a  reason: collision with root package name */
    public b f66385a;

    /* renamed from: c  reason: collision with root package name */
    private BottomSheetBehavior<?> f66386c;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f66387e;

    public interface b {
    }

    private View a(int i2) {
        if (this.f66387e == null) {
            this.f66387e = new HashMap();
        }
        View view = (View) this.f66387e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f66387e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66385a = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement SlowInternetBottomSheet.InteractionListener");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context, getTheme());
        aVar.setOnShowListener(new c(this));
        Window window = aVar.getWindow();
        if (window == null) {
            k.a();
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f66388a;

        c(f fVar) {
            this.f66388a = fVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            f.a(this.f66388a, dialogInterface);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottomsheet_slow_internet, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((Button) a(R.id.btn_continue)).setOnClickListener(new d(this));
        ((TextView) a(R.id.tv_try_later)).setOnClickListener(new e(this));
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f66389a;

        d(f fVar) {
            this.f66389a = fVar;
        }

        public final void onClick(View view) {
            if (this.f66389a.f66385a == null) {
                k.a("mHost");
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f66390a;

        e(f fVar) {
            this.f66390a = fVar;
        }

        public final void onClick(View view) {
            this.f66390a.dismiss();
        }
    }

    public static final /* synthetic */ void a(f fVar, DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (frameLayout != null) {
                frameLayout.setBackground(new ColorDrawable(0));
            }
            fVar.f66386c = frameLayout != null ? BottomSheetBehavior.from(frameLayout) : null;
            return;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66387e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
