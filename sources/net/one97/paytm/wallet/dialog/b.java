package net.one97.paytm.wallet.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.one97.paytm.p2mNewDesign.c.a;
import net.one97.paytm.wallet.R;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public int f70292b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f70293c;

    /* renamed from: d  reason: collision with root package name */
    private Button f70294d = ((Button) findViewById(R.id.btn_allow));

    /* renamed from: e  reason: collision with root package name */
    private TextView f70295e = ((TextView) findViewById(R.id.tv_deny));

    /* renamed from: f  reason: collision with root package name */
    private TextView f70296f = ((TextView) findViewById(R.id.description));

    /* renamed from: g  reason: collision with root package name */
    private TextView f70297g = ((TextView) findViewById(R.id.title));

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.p2mNewDesign.f.b f70298h;

    public b(Activity activity, int i2) {
        super(activity);
        setContentView(R.layout.lyt_location_capture_dialog);
        this.f70292b = i2;
        this.f70298h = (net.one97.paytm.p2mNewDesign.f.b) activity;
        this.f70293c = activity;
        this.f70294d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        this.f70295e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        int i3 = this.f70292b;
        if (i3 == 1) {
            this.f70297g.setText(this.f70293c.getString(R.string.turn_on_location_dialog_title));
            this.f70296f.setText(this.f70293c.getString(R.string.turn_on_location_dialog_desc));
        } else if (i3 == 2) {
            this.f70296f.setText(R.string.enable_location_to_make_payment_denied_desc);
        } else if (i3 == 3) {
            this.f70296f.setText(R.string.enable_location_to_make_payment_always_denied_desc);
            this.f70294d.setText(R.string.go_to_settings);
            this.f70295e.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f70298h.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f70298h.b();
    }
}
