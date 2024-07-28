package net.one97.paytm.recharge.ordersummary.c;

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
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class e extends com.google.android.material.bottomsheet.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final b f64048b = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f64049c = "message_1";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static String f64050d = "message_2";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static String f64051e = "confirmation_msg";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static a f64052f = a.DELETE_ACTION;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f64053g = false;

    /* renamed from: a  reason: collision with root package name */
    public DialogInterface.OnClickListener f64054a;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64055h;

    public enum a {
        DELETE_ACTION,
        NOT_ABLE_TO_ADD_NAME
    }

    public final View a(int i2) {
        if (this.f64055h == null) {
            this.f64055h = new HashMap();
        }
        View view = (View) this.f64055h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64055h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        private static void a(a aVar) {
            k.c(aVar, "<set-?>");
            e.f64052f = aVar;
        }

        public static e a(String str, String str2, String str3, String str4, String str5, String str6, a aVar) {
            k.c(str, "title");
            k.c(str2, "positiveButtontext");
            k.c(str4, "messages1");
            k.c(str5, "messages2");
            k.c(str6, "confirmationMsg");
            k.c(aVar, "performedAction");
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("posbtntxt", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("negbtntxt", str3);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString(e.f64051e, str6);
            }
            bundle.putString(e.f64049c, str4);
            bundle.putString(e.f64050d, str5);
            a(aVar);
            eVar.setArguments(bundle);
            return eVar;
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f64057a;

        d(e eVar) {
            this.f64057a = eVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f64057a.getDialog();
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
        return layoutInflater.inflate(R.layout.v4_stop_bill_reminder_dialog, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String string;
        String string2;
        String string3;
        String string4;
        CharSequence charSequence4;
        String string5;
        String string6;
        CharSequence charSequence5;
        String string7;
        String string8;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (f64052f == a.NOT_ABLE_TO_ADD_NAME) {
            View a2 = a(R.id.dividerV);
            if (a2 != null) {
                ai.b(a2);
            }
            TextView textView = (TextView) a(R.id.message2TV);
            if (textView != null) {
                ai.b(textView);
            }
            ImageView imageView = (ImageView) a(R.id.message2DotIV);
            if (imageView != null) {
                ai.b(imageView);
            }
            ImageView imageView2 = (ImageView) a(R.id.message1DotIV);
            if (imageView2 != null) {
                ai.b(imageView2);
            }
            TextView textView2 = (TextView) a(R.id.confirmationMsgTV);
            if (textView2 != null) {
                ai.b(textView2);
            }
            LinearLayout linearLayout = (LinearLayout) a(R.id.btn_lyt);
            if (linearLayout != null) {
                ai.b(linearLayout);
            }
            TextView textView3 = (TextView) a(R.id.btn_proceed);
            if (textView3 != null) {
                Bundle arguments = getArguments();
                textView3.setText(arguments != null ? arguments.getString("posbtntxt") : null);
            }
            TextView textView4 = (TextView) a(R.id.btn_proceed);
            if (textView4 != null) {
                ai.a(textView4);
            }
            TextView textView5 = (TextView) a(R.id.btn_proceed);
            if (textView5 != null) {
                textView5.setOnClickListener(this);
            }
        } else {
            try {
                Context context = getContext();
                if (context != null) {
                    k.a((Object) context, "it");
                    net.one97.paytm.recharge.ordersummary.h.d.a(new net.one97.paytm.recharge.ordersummary.h.d(context), "onus_credit_card", "delete_card_confirmation_loaded", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                }
            } catch (Throwable unused) {
            }
        }
        View findViewById = view.findViewById(R.id.titleTV);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.titleTV)");
        TextView textView6 = (TextView) findViewById;
        Bundle arguments2 = getArguments();
        textView6.setText((arguments2 == null || (string8 = arguments2.getString("title")) == null) ? "" : string8);
        Bundle arguments3 = getArguments();
        boolean z = true;
        if (!(arguments3 == null || (string6 = arguments3.getString(f64049c)) == null)) {
            k.a((Object) string6, "it");
            if (string6.length() == 0) {
                View findViewById2 = view.findViewById(R.id.message1TV);
                k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.message1TV)");
                ((TextView) findViewById2).setVisibility(8);
                View findViewById3 = view.findViewById(R.id.message1DotIV);
                k.a((Object) findViewById3, "view.findViewById<ImageView>(R.id.message1DotIV)");
                ((ImageView) findViewById3).setVisibility(8);
            } else {
                View findViewById4 = view.findViewById(R.id.message1TV);
                k.a((Object) findViewById4, "view.findViewById<TextView>(R.id.message1TV)");
                TextView textView7 = (TextView) findViewById4;
                Bundle arguments4 = getArguments();
                if (arguments4 == null || (string7 = arguments4.getString(f64049c)) == null) {
                    charSequence5 = "";
                } else {
                    charSequence5 = string7;
                }
                textView7.setText(charSequence5);
                if (f64052f == a.NOT_ABLE_TO_ADD_NAME) {
                    ImageView imageView3 = (ImageView) a(R.id.message1DotIV);
                    if (imageView3 != null) {
                        ai.b(imageView3);
                    }
                } else {
                    ImageView imageView4 = (ImageView) a(R.id.message1DotIV);
                    if (imageView4 != null) {
                        ai.a(imageView4);
                    }
                }
            }
        }
        Bundle arguments5 = getArguments();
        if (!(arguments5 == null || (string4 = arguments5.getString(f64050d)) == null)) {
            k.a((Object) string4, "it");
            if (string4.length() != 0) {
                z = false;
            }
            if (z) {
                View findViewById5 = view.findViewById(R.id.message2TV);
                k.a((Object) findViewById5, "view.findViewById<TextView>(R.id.message2TV)");
                ((TextView) findViewById5).setVisibility(8);
                View findViewById6 = view.findViewById(R.id.message2DotIV);
                k.a((Object) findViewById6, "view.findViewById<ImageView>(R.id.message2DotIV)");
                ((ImageView) findViewById6).setVisibility(8);
            } else {
                View findViewById7 = view.findViewById(R.id.message2TV);
                k.a((Object) findViewById7, "view.findViewById<TextView>(R.id.message2TV)");
                TextView textView8 = (TextView) findViewById7;
                Bundle arguments6 = getArguments();
                if (arguments6 == null || (string5 = arguments6.getString(f64050d)) == null) {
                    charSequence4 = "";
                } else {
                    charSequence4 = string5;
                }
                textView8.setText(charSequence4);
                View findViewById8 = view.findViewById(R.id.message2DotIV);
                k.a((Object) findViewById8, "view.findViewById<ImageView>(R.id.message2DotIV)");
                ((ImageView) findViewById8).setVisibility(0);
            }
        }
        if (f64053g) {
            ImageView imageView5 = (ImageView) a(R.id.message1DotIV);
            if (imageView5 != null) {
                ai.a(imageView5);
            }
            TextView textView9 = (TextView) a(R.id.message1TV);
            if (textView9 != null) {
                ai.a(textView9);
            }
        } else {
            ImageView imageView6 = (ImageView) a(R.id.message1DotIV);
            if (imageView6 != null) {
                ai.b(imageView6);
            }
            ImageView imageView7 = (ImageView) a(R.id.message2DotIV);
            if (imageView7 != null) {
                ai.b(imageView7);
            }
            TextView textView10 = (TextView) a(R.id.message1TV);
            if (textView10 != null) {
                ai.b(textView10);
            }
            TextView textView11 = (TextView) a(R.id.message2TV);
            if (textView11 != null) {
                textView11.setPadding(com.paytm.utility.b.c(8), 0, 0, 0);
            }
        }
        TextView textView12 = (TextView) view.findViewById(R.id.positiveBtnTV);
        TextView textView13 = (TextView) view.findViewById(R.id.negativeBtnTV);
        View findViewById9 = view.findViewById(R.id.confirmationMsgTV);
        k.a((Object) findViewById9, "view.findViewById<TextVi…>(R.id.confirmationMsgTV)");
        TextView textView14 = (TextView) findViewById9;
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (string3 = arguments7.getString(f64051e)) == null) {
            charSequence = "";
        } else {
            charSequence = string3;
        }
        textView14.setText(charSequence);
        k.a((Object) textView12, "positiveBtnTV");
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (string2 = arguments8.getString("posbtntxt")) == null) {
            charSequence2 = "";
        } else {
            charSequence2 = string2;
        }
        textView12.setText(charSequence2);
        k.a((Object) textView13, "negativeButtonText");
        Bundle arguments9 = getArguments();
        if (arguments9 == null || (string = arguments9.getString("negbtntxt")) == null) {
            charSequence3 = "";
        } else {
            charSequence3 = string;
        }
        textView13.setText(charSequence3);
        View.OnClickListener onClickListener = this;
        textView12.setOnClickListener(onClickListener);
        textView13.setOnClickListener(onClickListener);
        ((ImageView) view.findViewById(R.id.closeIV)).setOnClickListener(onClickListener);
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
            aVar.setOnShowListener(c.f64056a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f64056a = new c();

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

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.positiveBtnTV;
        if (valueOf != null && valueOf.intValue() == i2) {
            DialogInterface.OnClickListener onClickListener = this.f64054a;
            if (onClickListener != null) {
                onClickListener.onClick(getDialog(), -1);
            }
            Context context = getContext();
            if (context != null) {
                k.a((Object) context, "it");
                net.one97.paytm.recharge.ordersummary.h.d.a(new net.one97.paytm.recharge.ordersummary.h.d(context), "onus_credit_card", "delete_card_action_clicked", "", H5AppHandler.CHECK_VALUE, (Object) null, (Object) null, (Object) null, 112);
                return;
            }
            return;
        }
        int i3 = R.id.negativeBtnTV;
        if (valueOf != null && valueOf.intValue() == i3) {
            DialogInterface.OnClickListener onClickListener2 = this.f64054a;
            if (onClickListener2 != null) {
                onClickListener2.onClick(getDialog(), -2);
            }
            try {
                Context context2 = getContext();
                if (context2 != null) {
                    k.a((Object) context2, "it");
                    net.one97.paytm.recharge.ordersummary.h.d.a(new net.one97.paytm.recharge.ordersummary.h.d(context2), "onus_credit_card", "delete_card_action_clicked", "", "no", (Object) null, (Object) null, (Object) null, 112);
                }
            } catch (Throwable unused) {
            }
        } else {
            int i4 = R.id.closeIV;
            if (valueOf == null || valueOf.intValue() != i4) {
                int i5 = R.id.btn_proceed;
                if (valueOf == null || valueOf.intValue() != i5) {
                    return;
                }
            }
            dismiss();
        }
    }

    public final void a() {
        TextView textView;
        Context context = getContext();
        if (!(context == null || (textView = (TextView) a(R.id.positiveBtnTV)) == null)) {
            textView.setTextColor(androidx.core.content.b.c(context, R.color.color_00ACED));
        }
        b((CJRRechargeLottieAnimationView) a(R.id.loading_three_dots_lav));
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public static void a(View view) {
        k.c(view, "v");
        view.clearAnimation();
        Animation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000);
        view.startAnimation(scaleAnimation);
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64055h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
