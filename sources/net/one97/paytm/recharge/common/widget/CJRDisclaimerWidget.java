package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.squareup.picasso.w;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.recharge.R;

public final class CJRDisclaimerWidget extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f61882a;

    /* renamed from: b  reason: collision with root package name */
    private String f61883b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f61884c;

    private View a(int i2) {
        if (this.f61884c == null) {
            this.f61884c = new HashMap();
        }
        View view = (View) this.f61884c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61884c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRDisclaimerWidget(Context context, String str, String str2) {
        super(context);
        k.c(context, "context");
        this.f61882a = str;
        this.f61883b = str2;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(b.c(20), b.c(10), b.c(20), 0);
            LayoutInflater.from(context).inflate(R.layout.layout_disclaimer, this, true);
            if (ExtensionsKt.isNotNullNotBlank(this.f61882a)) {
                TextView textView = (TextView) a(R.id.disclaimer_text);
                k.a((Object) textView, "disclaimer_text");
                textView.setText(this.f61882a);
                if (ExtensionsKt.isNotNullNotBlank(this.f61883b)) {
                    w a2 = w.a();
                    String str3 = this.f61883b;
                    if (str3 == null) {
                        k.a();
                    }
                    a2.a(p.a(str3, " ", "%20", false)).a(R.drawable.dth_setup_box_icon).b(R.drawable.dth_setup_box_icon).a((ImageView) a(R.id.disclaimer_icon));
                    return;
                }
                return;
            }
            setVisibility(8);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final String getDisclaimerImageUrl() {
        return this.f61883b;
    }

    public final String getDisclaimerText() {
        return this.f61882a;
    }

    public final void setDisclaimerImageUrl(String str) {
        this.f61883b = str;
    }

    public final void setDisclaimerText(String str) {
        this.f61882a = str;
    }
}
