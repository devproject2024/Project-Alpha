package net.one97.paytm.paymentsBank.accntfreeze;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.utils.o;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17341a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Button f17342b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f17343c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17344d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17345e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BottomSheetBehavior<?> f17346f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f17347g;

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new d(this));
            Window window = aVar.getWindow();
            if (window == null) {
                k.a();
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17351a;

        d(b bVar) {
            this.f17351a = bVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                frameLayout.setBackgroundDrawable(new ColorDrawable(0));
                this.f17351a.f17346f = BottomSheetBehavior.from(frameLayout);
                b.b(this.f17351a);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(net.one97.paytm.paymentsBank.R.layout.pb_freeze_confirm_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "rootView");
        this.f17342b = (Button) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.proceed);
        this.f17345e = (TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.title);
        this.f17343c = (ImageView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_cross_iv);
        this.f17344d = (TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.tv_desc);
        Bundle arguments = getArguments();
        TextView textView = this.f17345e;
        if (textView == null) {
            k.a();
        }
        if (arguments == null) {
            k.a();
        }
        textView.setText(arguments.getString("title"));
        TextView textView2 = this.f17344d;
        if (textView2 == null) {
            k.a();
        }
        textView2.setText(arguments.getString("arg_subtitle"));
        Button button = this.f17342b;
        if (button == null) {
            k.a();
        }
        button.setText(arguments.getString("arg_action_txt"));
        String string = arguments.getString("arg_action");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Button button2 = this.f17342b;
        if (button2 == null) {
            k.a();
        }
        button2.setOnClickListener(new C0262b(this, string));
        ImageView imageView = this.f17343c;
        if (imageView == null) {
            k.a();
        }
        imageView.setOnClickListener(new c(this));
        return inflate;
    }

    public static final class e extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17352a;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        e(b bVar) {
            this.f17352a = bVar;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (i2 == 1) {
                BottomSheetBehavior a2 = this.f17352a.f17346f;
                if (a2 == null) {
                    k.a();
                }
                a2.setState(3);
            }
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.accntfreeze.b$b  reason: collision with other inner class name */
    static final class C0262b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17348a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17349b;

        C0262b(b bVar, String str) {
            this.f17348a = bVar;
            this.f17349b = str;
        }

        public final void onClick(View view) {
            String str = this.f17349b;
            if (str != null) {
                if (p.b(str, "http", false)) {
                    o.a().openWebViewActivity(this.f17348a.getActivity(), this.f17349b, this.f17348a.getString(net.one97.paytm.paymentsBank.R.string.pb_dormant_info_web_title));
                } else {
                    o.a().checkDeepLink(this.f17348a.getActivity(), this.f17349b);
                }
            }
            this.f17348a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17350a;

        c(b bVar) {
            this.f17350a = bVar;
        }

        public final void onClick(View view) {
            this.f17350a.dismissAllowingStateLoss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(b bVar) {
        e eVar = new e(bVar);
        BottomSheetBehavior<?> bottomSheetBehavior = bVar.f17346f;
        if (bottomSheetBehavior == null) {
            k.a();
        }
        bottomSheetBehavior.setBottomSheetCallback(eVar);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17347g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
