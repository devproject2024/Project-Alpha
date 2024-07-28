package net.one97.paytm.paymentsBank.createfd.prefrence.a;

import android.content.Context;
import android.os.Bundle;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout;

public final class a extends f {

    /* renamed from: d  reason: collision with root package name */
    public static final C0302a f18158d = new C0302a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static String f18159e = "amt";

    /* renamed from: a  reason: collision with root package name */
    String f18160a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.createfd.prefrence.b.a f18161b;

    /* renamed from: c  reason: collision with root package name */
    public CreateFdPrefrenceLayout f18162c;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f18163f;

    private View a(int i2) {
        if (this.f18163f == null) {
            this.f18163f = new HashMap();
        }
        View view = (View) this.f18163f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18163f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.prefrence.a.a$a  reason: collision with other inner class name */
    public static final class C0302a {
        private C0302a() {
        }

        public /* synthetic */ C0302a(byte b2) {
            this();
        }
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public static final class e extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18167a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f18168b;

        e(a aVar, x.e eVar) {
            this.f18167a = aVar;
            this.f18168b = eVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            Selection.setSelection((SpannableString) this.f18168b.element, 0);
            net.one97.paytm.paymentsBank.createfd.prefrence.b.a aVar = this.f18167a.f18161b;
            if (aVar != null) {
                aVar.a(this.f18167a.f18160a);
            }
            net.one97.paytm.paymentsBank.createfd.prefrence.b.a aVar2 = this.f18167a.f18161b;
            if (aVar2 != null) {
                aVar2.b();
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            Context context = this.f18167a.getContext();
            if (context == null) {
                k.a();
            }
            textPaint.setColor(androidx.core.content.b.c(context, R.color.paytm_blue));
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        String str = null;
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.containsKey(f18159e)) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString(f18159e);
            }
            this.f18160a = str;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fd_user_prefrence_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        String string = getString(R.string.pdc_proceed_agree);
        k.a((Object) string, "getString(R.string.pdc_proceed_agree)");
        String string2 = getString(R.string.pdc_tnc);
        k.a((Object) string2, "getString(R.string.pdc_tnc)");
        x.e eVar = new x.e();
        CharSequence charSequence = string + " " + string2;
        eVar.element = new SpannableString(charSequence);
        ((SpannableString) eVar.element).setSpan(new e(this, eVar), p.a(charSequence, string2, 0, false, 6), p.a(charSequence, string2, 0, false, 6) + string2.length(), 33);
        ((TextView) a(R.id.tv_fd_terms_and_condition)).setText((SpannableString) eVar.element);
        ((TextView) a(R.id.tv_fd_terms_and_condition)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) a(R.id.tv_fd_terms_and_condition)).setText((SpannableString) eVar.element);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_cross_view);
        TextView textView = (TextView) view.findViewById(R.id.tv_amt);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_cancel);
        Button button = (Button) view.findViewById(R.id.btn_create_fd_prefrence);
        if (textView != null) {
            textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.bankCommon.mapping.a.ad(this.f18160a));
        }
        TextView textView3 = (TextView) a(R.id.tv_subheading);
        if (textView3 != null) {
            textView3.setText(getString(R.string.pb_fd_sweep_confirm_msg, net.one97.paytm.bankCommon.mapping.a.ad(this.f18160a)));
        }
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new c(this));
        }
        if (button != null) {
            button.setOnClickListener(new d(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18164a;

        b(a aVar) {
            this.f18164a = aVar;
        }

        public final void onClick(View view) {
            CreateFdPrefrenceLayout createFdPrefrenceLayout = this.f18164a.f18162c;
            if (createFdPrefrenceLayout != null) {
                createFdPrefrenceLayout.setPogress(this.f18164a.f18160a);
            }
            this.f18164a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18165a;

        c(a aVar) {
            this.f18165a = aVar;
        }

        public final void onClick(View view) {
            CreateFdPrefrenceLayout createFdPrefrenceLayout = this.f18165a.f18162c;
            if (createFdPrefrenceLayout != null) {
                createFdPrefrenceLayout.setPogress(this.f18165a.f18160a);
            }
            this.f18165a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18166a;

        d(a aVar) {
            this.f18166a = aVar;
        }

        public final void onClick(View view) {
            this.f18166a.dismiss();
            net.one97.paytm.paymentsBank.createfd.prefrence.b.a aVar = this.f18166a.f18161b;
            if (aVar != null) {
                aVar.a(this.f18166a.f18160a);
            }
            net.one97.paytm.paymentsBank.createfd.prefrence.b.a aVar2 = this.f18166a.f18161b;
            if (aVar2 != null) {
                if (this.f18166a.f18160a == null) {
                    k.a();
                }
                aVar2.a();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18163f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
