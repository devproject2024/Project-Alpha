package net.one97.paytm.recharge.automatic.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.b.a.a;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;

public final class CJRRBIComplianceView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f60297a;

    /* renamed from: b  reason: collision with root package name */
    private final String f60298b;

    /* renamed from: c  reason: collision with root package name */
    private final a f60299c;

    /* renamed from: d  reason: collision with root package name */
    private final int f60300d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f60301e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CJRRBIComplianceView(Context context, boolean z, boolean z2) {
        super(context, (AttributeSet) null, 0);
        String str = null;
        boolean z3 = false;
        this.f60301e = z2;
        this.f60297a = "closedCount";
        this.f60298b = "clpClosedCount";
        setBackgroundColor(Color.parseColor("#fdfbd3"));
        ax.a aVar = ax.f61521a;
        Context context2 = getContext();
        k.a((Object) context2, "this.context");
        Context applicationContext = context2.getApplicationContext();
        k.a((Object) applicationContext, "this.context.applicationContext");
        this.f60299c = ax.a.a(applicationContext);
        this.f60300d = this.f60299c.b(this.f60301e ? this.f60298b : this.f60297a, 0, false);
        LayoutInflater.from(context).inflate(R.layout.rbi_compliance_view, this, true);
        ((ImageView) findViewById(R.id.close)).setOnClickListener(this);
        c cVar = c.f62654a;
        String f2 = c.f();
        c cVar2 = c.f62654a;
        Integer a2 = c.a(this.f60301e);
        CharSequence charSequence = f2;
        if (!TextUtils.isEmpty(charSequence)) {
            int i2 = this.f60300d;
            if (a2 == null || i2 != a2.intValue()) {
                View findViewById = findViewById(R.id.title);
                k.a((Object) findViewById, "findViewById<TextView>(R.id.title)");
                ((TextView) findViewById).setText(charSequence);
                TextView textView = (TextView) findViewById(R.id.description);
                TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes((AttributeSet) null, R.styleable.CJRRBIComplianceView, 0, 0) : null;
                if (((obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(R.styleable.CJRRBIComplianceView_showUpdateNow, false) : false) || z) ? true : z3) {
                    k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    str = context != null ? context.getString(R.string.update_now) : str;
                    c cVar3 = c.f62654a;
                    String g2 = c.g();
                    int length = g2.length() + 1;
                    SpannableString spannableString = new SpannableString(g2 + ' ' + str);
                    if (context == null) {
                        k.a();
                    }
                    spannableString.setSpan(new ForegroundColorSpan(b.c(context, R.color.tp_button_blue)), length, spannableString.length(), 33);
                    spannableString.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            k.c(view, "widget");
                            Context context = view.getContext();
                            if (context != null) {
                                context.startActivity(new Intent(view.getContext(), AJRAutomaticSubscriptionListActivity.class));
                            }
                        }
                    }, length, spannableString.length(), 33);
                    textView.setText(spannableString);
                    return;
                }
                k.a((Object) textView, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                c cVar4 = c.f62654a;
                textView.setText(c.g());
                return;
            }
        }
        setVisibility(8);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.close;
        if (valueOf != null && valueOf.intValue() == i2) {
            this.f60299c.a(this.f60301e ? this.f60298b : this.f60297a, this.f60300d + 1, false);
            setVisibility(8);
        }
    }

    public final String getCLOSED_COUNT() {
        return this.f60297a;
    }

    public final String getCLP_CLOSED_COUNT() {
        return this.f60298b;
    }

    public CJRRBIComplianceView(Context context) {
        this(context, (byte) 0);
    }

    private CJRRBIComplianceView(Context context, byte b2) {
        this(context, false, false, (byte) 0);
    }

    public CJRRBIComplianceView(Context context, boolean z, boolean z2, byte b2) {
        this(context, z, z2, 0);
    }

    private CJRRBIComplianceView(Context context, boolean z, boolean z2, char c2) {
        this(context, z, z2, 0);
    }

    private CJRRBIComplianceView(Context context, boolean z, boolean z2, short s) {
        this(context, z, z2);
    }
}
