package net.one97.paytm.p2mNewDesign.g;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.Arrays;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.dialog.tooltip.b;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public a f51268a;

    /* renamed from: b  reason: collision with root package name */
    public View f51269b;

    /* renamed from: c  reason: collision with root package name */
    public c f51270c;

    /* renamed from: d  reason: collision with root package name */
    public String f51271d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f51272e;

    /* renamed from: f  reason: collision with root package name */
    public Context f51273f;

    public interface a {
        void a();

        void a(boolean z);
    }

    public b(Context context) {
        k.c(context, "context");
        this.f51273f = context;
    }

    public static final /* synthetic */ View a(b bVar) {
        View view = bVar.f51269b;
        if (view == null) {
            k.a("rootView");
        }
        return view;
    }

    /* renamed from: net.one97.paytm.p2mNewDesign.g.b$b  reason: collision with other inner class name */
    public static final class C0926b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f51274a;

        public C0926b(b bVar) {
            this.f51274a = bVar;
        }

        public final void onClick(View view) {
            this.f51274a.a();
        }
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f51275a;

        public c(b bVar) {
            this.f51275a = bVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z && this.f51275a.f51272e) {
                CheckBox checkBox = (CheckBox) b.a(this.f51275a).findViewById(R.id.iv_mlv_check_uncheck);
                k.a((Object) checkBox, "rootView.iv_mlv_check_uncheck");
                checkBox.setChecked(false);
            }
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f51276a;

        public d(b bVar) {
            this.f51276a = bVar;
        }

        public final void onClick(View view) {
            if (!this.f51276a.f51272e) {
                a aVar = this.f51276a.f51268a;
                if (aVar == null) {
                    k.a("mlvSelectedListener2");
                }
                aVar.a();
            }
        }
    }

    public static final class e extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f51277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f51278b;

        public e(b bVar, c cVar) {
            this.f51277a = bVar;
            this.f51278b = cVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            b.a a2 = new b.a(this.f51277a.f51273f).a((View) (TextView) b.a(this.f51277a).findViewById(R.id.tv_merchant_name));
            aa aaVar = aa.f47921a;
            String string = this.f51277a.f51273f.getString(R.string.mlv_enrollment_text, new Object[]{this.f51278b.getMerchantName()});
            k.a((Object) string, "context.getString(R.stri…xt, mlvItem.merchantName)");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            a2.a((CharSequence) format).b().c().d().a().a();
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
            textPaint.linkColor = 0;
            textPaint.setColor(this.f51277a.f51273f.getResources().getColor(R.color.metalic_blue));
        }
    }

    public final void a(String str) {
        TextView textView;
        k.c(str, "calculatedBalance");
        View view = this.f51269b;
        if (view == null) {
            k.a("rootView");
        }
        if (view != null && (textView = (TextView) view.findViewById(R.id.tv_mlv_amount)) != null) {
            textView.setText(this.f51273f.getString(R.string.mlv_rupee) + str);
        }
    }

    public final void a() {
        if (!this.f51272e) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f2, "DirectPaymentBl.getInstance()");
            if (f2.G().isChecked()) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f3, "DirectPaymentBl.getInstance()");
                f3.G().setChecked(false);
                View view = this.f51269b;
                if (view == null) {
                    k.a("rootView");
                }
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.iv_mlv_check_uncheck);
                k.a((Object) checkBox, "rootView.iv_mlv_check_uncheck");
                checkBox.setChecked(false);
            } else {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f4, "DirectPaymentBl.getInstance()");
                f4.G().setChecked(true);
                View view2 = this.f51269b;
                if (view2 == null) {
                    k.a("rootView");
                }
                CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.iv_mlv_check_uncheck);
                k.a((Object) checkBox2, "rootView.iv_mlv_check_uncheck");
                checkBox2.setChecked(true);
            }
            a aVar = this.f51268a;
            if (aVar == null) {
                k.a("mlvSelectedListener2");
            }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f5, "DirectPaymentBl.getInstance()");
            aVar.a(f5.G().isChecked());
        }
    }
}
