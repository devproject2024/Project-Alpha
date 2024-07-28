package net.one97.paytm.wallet.splitbill.e;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.appsflyer.internal.referrer.Payload;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.b.e;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    e f72231a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f72232b;

    /* renamed from: c  reason: collision with root package name */
    private String f72233c;

    /* renamed from: d  reason: collision with root package name */
    private String f72234d;

    /* renamed from: e  reason: collision with root package name */
    private Context f72235e;

    /* renamed from: f  reason: collision with root package name */
    private View f72236f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f72237g = false;

    public c(Context context, e eVar) {
        this.f72235e = context;
        this.f72231a = eVar;
    }

    public final View a(boolean z) {
        this.f72236f = ((LayoutInflater) this.f72235e.getSystemService("layout_inflater")).inflate(R.layout.sb_top_ticker_layout, (ViewGroup) null, false);
        this.f72237g = z;
        a();
        b();
        return this.f72236f;
    }

    private void a() {
        int i2;
        Resources resources;
        int i3;
        Resources resources2;
        int i4;
        Resources resources3;
        int i5;
        Resources resources4;
        int i6;
        Resources resources5;
        View findViewById = this.f72236f.findViewById(R.id.top_ticker_view);
        if (this.f72232b) {
            resources = this.f72235e.getResources();
            i2 = R.color.bg_success_ticker;
        } else {
            resources = this.f72235e.getResources();
            i2 = R.color.bg_ticker_error;
        }
        findViewById.setBackgroundColor(resources.getColor(i2));
        View findViewById2 = this.f72236f.findViewById(R.id.ticker_btn);
        if (this.f72232b) {
            resources2 = this.f72235e.getResources();
            i3 = R.drawable.sb_ticker_success_bg;
        } else {
            resources2 = this.f72235e.getResources();
            i3 = R.drawable.sb_ticker_error_bg;
        }
        findViewById2.setBackground(resources2.getDrawable(i3));
        if (!this.f72237g || this.f72232b) {
            ((TextView) this.f72236f.findViewById(R.id.ticker_btn)).setText(Payload.RESPONSE_OK);
        } else {
            ((TextView) this.f72236f.findViewById(R.id.ticker_btn)).setText("Retry");
        }
        TextView textView = (TextView) this.f72236f.findViewById(R.id.ticker_btn);
        if (this.f72232b) {
            resources3 = this.f72235e.getResources();
            i4 = R.color.white;
        } else {
            resources3 = this.f72235e.getResources();
            i4 = R.color.black;
        }
        textView.setTextColor(resources3.getColor(i4));
        TextView textView2 = (TextView) this.f72236f.findViewById(R.id.title);
        if (this.f72232b) {
            resources4 = this.f72235e.getResources();
            i5 = R.color.white;
        } else {
            resources4 = this.f72235e.getResources();
            i5 = R.color.black;
        }
        textView2.setTextColor(resources4.getColor(i5));
        TextView textView3 = (TextView) this.f72236f.findViewById(R.id.subtitle);
        if (this.f72232b) {
            resources5 = this.f72235e.getResources();
            i6 = R.color.white;
        } else {
            resources5 = this.f72235e.getResources();
            i6 = R.color.black;
        }
        textView3.setTextColor(resources5.getColor(i6));
        ((TextView) this.f72236f.findViewById(R.id.title)).setText(this.f72233c);
        if (TextUtils.isEmpty(this.f72234d)) {
            ((TextView) this.f72236f.findViewById(R.id.subtitle)).setVisibility(8);
            return;
        }
        ((TextView) this.f72236f.findViewById(R.id.subtitle)).setVisibility(0);
        ((TextView) this.f72236f.findViewById(R.id.subtitle)).setText(this.f72234d);
    }

    private void b() {
        this.f72236f.findViewById(R.id.ticker_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.f72231a != null) {
                    c.this.f72231a.b();
                }
            }
        });
    }

    public final void a(String str, String str2, boolean z) {
        this.f72233c = str;
        this.f72234d = str2;
        this.f72232b = z;
        a();
    }
}
