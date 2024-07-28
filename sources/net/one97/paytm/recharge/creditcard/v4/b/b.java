package net.one97.paytm.recharge.creditcard.v4.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.w;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class b extends com.google.android.material.bottomsheet.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62567a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C1208b f62568b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f62569c;

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.b.b$b  reason: collision with other inner class name */
    public interface C1208b {
        void b();
    }

    private View a(int i2) {
        if (this.f62569c == null) {
            this.f62569c = new HashMap();
        }
        View view = (View) this.f62569c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f62569c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(String str, String str2, String str3, String str4) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putString("CARD_NAME", str);
            bundle.putString("CARD_NUMBER", str2);
            bundle.putString("BANK_IMAGE_URL", str3);
            bundle.putString("AMOUNT", str4);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62571a;

        d(b bVar) {
            this.f62571a = bVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f62571a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.clearFlags(2);
        }
        new Handler().postDelayed(new d(this), 300);
        return layoutInflater.inflate(R.layout.v4_confirm_payment_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("CARD_NAME");
            if (!(string == null || (textView3 = (TextView) a(R.id.cardNameTV)) == null)) {
                textView3.setText(string);
            }
            String string2 = arguments.getString("CARD_NUMBER");
            if (!(string2 == null || (textView2 = (TextView) a(R.id.cardNumberTV)) == null)) {
                textView2.setText(string2);
            }
            String string3 = arguments.getString("AMOUNT");
            if (!(string3 == null || (textView = (TextView) a(R.id.amountTV)) == null)) {
                int i2 = R.string.v3_recharge_rs;
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                textView.setText(getString(i2, net.one97.paytm.recharge.widgets.c.d.d(string3)));
            }
            String string4 = arguments.getString("BANK_IMAGE_URL");
            if (string4 != null) {
                w.a().a(string4).a((ImageView) a(R.id.bankIV));
            }
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.proceedBT);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setProceedBtnText(getString(R.string.confirm_and_proceed));
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.proceedBT);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.setOnClickListener(new e(this));
        }
        ImageView imageView = (ImageView) a(R.id.closeIV);
        if (imageView != null) {
            imageView.setOnClickListener(new f(this));
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62572a;

        e(b bVar) {
            this.f62572a = bVar;
        }

        public final void onClick(View view) {
            this.f62572a.dismiss();
            C1208b a2 = this.f62572a.f62568b;
            if (a2 != null) {
                a2.b();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62573a;

        f(b bVar) {
            this.f62573a = bVar;
        }

        public final void onClick(View view) {
            this.f62573a.dismiss();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getArguments() == null) {
            throw new IllegalStateException();
        }
    }

    public final void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            View view = null;
            if ((dialog != null ? dialog.getWindow() : null) != null && Build.VERSION.SDK_INT >= 26) {
                Dialog dialog2 = getDialog();
                Window window = dialog2 != null ? dialog2.getWindow() : null;
                if (window != null) {
                    view = window.getDecorView();
                }
                if (view != null) {
                    view.setSystemUiVisibility(view.getSystemUiVisibility() | 16);
                }
            }
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(c.f62570a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f62570a = new c();

        c() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setState(3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void a(C1208b bVar) {
        k.c(bVar, "listener");
        this.f62568b = bVar;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f62569c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
