package net.one97.paytm.recharge.creditcard.v4.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.a.a;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class a extends com.google.android.material.bottomsheet.b {

    /* renamed from: d  reason: collision with root package name */
    public static final C1207a f62558d = new C1207a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public b f62559a;

    /* renamed from: b  reason: collision with root package name */
    public a.h f62560b;

    /* renamed from: c  reason: collision with root package name */
    public CJRCreditCardModelV8 f62561c;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f62562e;

    public interface b {
        void a(a.h hVar, CJRCreditCardModelV8 cJRCreditCardModelV8);
    }

    private View a(int i2) {
        if (this.f62562e == null) {
            this.f62562e = new HashMap();
        }
        View view = (View) this.f62562e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f62562e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.b.a$a  reason: collision with other inner class name */
    public static final class C1207a {
        private C1207a() {
        }

        public /* synthetic */ C1207a(byte b2) {
            this();
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62564a;

        d(a aVar) {
            this.f62564a = aVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f62564a.getDialog();
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
        return layoutInflater.inflate(R.layout.v4_bill_details_bottom_sheet_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CJRCreditCardModelV8 cJRCreditCardModelV8;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        if (!(arguments == null || !arguments.containsKey(PayUtility.BANK_NAME) || (textView6 = (TextView) a(R.id.cardNameTV)) == null)) {
            Bundle arguments2 = getArguments();
            textView6.setText(arguments2 != null ? arguments2.getString(PayUtility.BANK_NAME) : null);
        }
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || !arguments3.containsKey(SDKConstants.AI_KEY_CARD_NUMBER) || (textView5 = (TextView) a(R.id.cardNumberTV)) == null)) {
            Bundle arguments4 = getArguments();
            textView5.setText(arguments4 != null ? arguments4.getString(SDKConstants.AI_KEY_CARD_NUMBER) : null);
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null && arguments5.containsKey("bank_logo_url")) {
            Bundle arguments6 = getArguments();
            if (arguments6 == null) {
                k.a();
            }
            Object obj = arguments6.get("bank_logo_url");
            String obj2 = obj != null ? obj.toString() : null;
            if (!TextUtils.isEmpty(obj2)) {
                w.a().a(obj2).a((ImageView) a(R.id.cardLogoIV));
                ImageView imageView = (ImageView) a(R.id.cardLogoIV);
                if (imageView != null) {
                    ai.a(imageView);
                }
            } else {
                ImageView imageView2 = (ImageView) a(R.id.cardLogoIV);
                if (imageView2 != null) {
                    ai.b(imageView2);
                }
            }
        }
        Bundle arguments7 = getArguments();
        if (arguments7 != null && arguments7.containsKey("bill_date")) {
            Bundle arguments8 = getArguments();
            CharSequence string = arguments8 != null ? arguments8.getString("bill_date") : null;
            if (!TextUtils.isEmpty(string) && (textView4 = (TextView) a(R.id.billDateTV)) != null) {
                textView4.setText(string);
            }
        }
        Bundle arguments9 = getArguments();
        if (arguments9 != null && arguments9.containsKey("due_date")) {
            Bundle arguments10 = getArguments();
            CharSequence string2 = arguments10 != null ? arguments10.getString("due_date") : null;
            if (!TextUtils.isEmpty(string2) && (textView3 = (TextView) a(R.id.dueDateTV)) != null) {
                textView3.setText(string2);
            }
        }
        Bundle arguments11 = getArguments();
        if (arguments11 != null && arguments11.containsKey("lbl_1")) {
            Bundle arguments12 = getArguments();
            CharSequence string3 = arguments12 != null ? arguments12.getString("lbl_1") : null;
            if (!TextUtils.isEmpty(string3) && (textView2 = (TextView) a(R.id.totalDueTitleTV)) != null) {
                textView2.setText(string3);
            }
        }
        Bundle arguments13 = getArguments();
        if (arguments13 != null && arguments13.containsKey("lbl_2")) {
            Bundle arguments14 = getArguments();
            CharSequence string4 = arguments14 != null ? arguments14.getString("lbl_2") : null;
            if (!TextUtils.isEmpty(string4) && (textView = (TextView) a(R.id.minDueTitleTV)) != null) {
                textView.setText(string4);
            }
        }
        Bundle arguments15 = getArguments();
        if (arguments15 != null && arguments15.containsKey("amount_1")) {
            Bundle arguments16 = getArguments();
            String string5 = arguments16 != null ? arguments16.getString("amount_1") : null;
            CharSequence charSequence = string5;
            if (!TextUtils.isEmpty(charSequence)) {
                TextView textView7 = (TextView) a(R.id.totalDueTV);
                if (textView7 != null) {
                    textView7.setText(charSequence);
                }
                CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62561c;
                if (cJRCreditCardModelV82 != null) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    cJRCreditCardModelV82.setTotalDue(Double.valueOf(net.one97.paytm.recharge.widgets.c.d.c(string5)));
                }
            }
        }
        Bundle arguments17 = getArguments();
        if (arguments17 != null && arguments17.containsKey("amount_2")) {
            Bundle arguments18 = getArguments();
            CharSequence string6 = arguments18 != null ? arguments18.getString("amount_2") : null;
            if (!TextUtils.isEmpty(string6)) {
                TextView textView8 = (TextView) a(R.id.minDueTV);
                if (textView8 != null) {
                    textView8.setText(string6);
                }
                Bundle arguments19 = getArguments();
                if (arguments19 != null && arguments19.containsKey("min_amount")) {
                    Bundle arguments20 = getArguments();
                    if (!TextUtils.isEmpty(arguments20 != null ? arguments20.getString("min_amount") : null) && (cJRCreditCardModelV8 = this.f62561c) != null) {
                        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        Bundle arguments21 = getArguments();
                        if (arguments21 != null) {
                            str = arguments21.getString("min_amount");
                        }
                        cJRCreditCardModelV8.setMinDue(Double.valueOf(net.one97.paytm.recharge.widgets.c.d.c(str)));
                    }
                }
            } else {
                TextView textView9 = (TextView) a(R.id.minDueTitleTV);
                if (textView9 != null) {
                    ai.b(textView9);
                }
                TextView textView10 = (TextView) a(R.id.minDueTV);
                if (textView10 != null) {
                    ai.b(textView10);
                }
            }
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.payBillBT);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setProceedBtnText(getString(R.string.pay_bill));
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.payBillBT);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.setOnClickListener(new e(this));
        }
        ImageView imageView3 = (ImageView) a(R.id.closeIV);
        if (imageView3 != null) {
            imageView3.setOnClickListener(new f(this));
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62565a;

        e(a aVar) {
            this.f62565a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                Context context = this.f62565a.getContext();
                if (context != null) {
                    k.a((Object) context, "it");
                    net.one97.paytm.recharge.ordersummary.h.d.a(new net.one97.paytm.recharge.ordersummary.h.d(context), "onus_credit_card", "pay_clicked_on_bills_bottom_sheet", "", "", (Object) null, (Object) null, (Object) null, 112);
                }
                if (this.f62565a.f62559a != null && this.f62565a.f62560b != null && this.f62565a.f62561c != null) {
                    this.f62565a.dismissAllowingStateLoss();
                    b a2 = this.f62565a.f62559a;
                    if (a2 == null) {
                        k.a();
                    }
                    a.h b2 = this.f62565a.f62560b;
                    if (b2 == null) {
                        k.a();
                    }
                    CJRCreditCardModelV8 c2 = this.f62565a.f62561c;
                    if (c2 == null) {
                        k.a();
                    }
                    a2.a(b2, c2);
                }
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62566a;

        f(a aVar) {
            this.f62566a = aVar;
        }

        public final void onClick(View view) {
            this.f62566a.dismissAllowingStateLoss();
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
            aVar.setOnShowListener(c.f62563a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f62563a = new c();

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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f62562e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
