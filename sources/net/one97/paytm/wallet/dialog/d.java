package net.one97.paytm.wallet.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.wallet.R;

public final class d extends net.one97.paytm.p2mNewDesign.c.a {

    /* renamed from: b  reason: collision with root package name */
    private Button f70311b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70312c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70313d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70314e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f70315f;

    /* renamed from: g  reason: collision with root package name */
    private Context f70316g;

    /* renamed from: h  reason: collision with root package name */
    private a f70317h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f70318i = true;
    private String j;
    private String k;

    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    public d(Context context, String str, String str2, boolean z, a aVar) {
        super(context);
        this.f70316g = context;
        this.f70318i = z;
        this.f70317h = aVar;
        this.j = str2;
        this.k = str;
        setContentView(R.layout.lyt_mlv_promo_error_dialog);
        this.f70311b = (Button) findViewById(R.id.btn_continue);
        this.f70315f = (ImageView) findViewById(R.id.iv_cancel);
        this.f70312c = (TextView) findViewById(R.id.tv_cancel_payment);
        this.f70313d = (TextView) findViewById(R.id.tv_title);
        this.f70314e = (TextView) findViewById(R.id.tv_description);
        String str3 = "mLoyal".contentEquals(this.k) ? "Points" : "Cashback";
        this.f70313d.setText(this.f70316g.getString(R.string.mlv_promo_error_title, new Object[]{str3}));
        this.f70314e.setText(this.f70316g.getString(R.string.mlv_promo_error_description, new Object[]{str3}));
        if (!this.f70318i) {
            this.f70312c.setText(String.format(this.f70316g.getString(R.string.mlv_pay_without_using_cashback), new Object[]{this.j, str3}));
            this.f70311b.setText(this.f70316g.getString(R.string.mlv_retry));
            this.f70313d.setText(String.format(this.f70316g.getString(R.string.mlv_cashback_could_not_be_used), new Object[]{this.j, str3}));
            this.f70314e.setText(String.format(this.f70316g.getString(R.string.mlv_cashback_failure), new Object[]{str3, this.j, str3}));
        }
        this.f70312c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.c(view);
            }
        });
        this.f70311b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
        this.f70315f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (!this.f70318i) {
            this.f70317h.d(this);
        } else {
            this.f70317h.a(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (!this.f70318i) {
            this.f70317h.c(this);
        } else {
            this.f70317h.b(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }
}
