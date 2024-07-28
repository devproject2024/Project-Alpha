package net.one97.paytm.wallet.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.c.c;
import net.one97.paytm.wallet.f.a;

public class e extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f69995a;

    /* renamed from: b  reason: collision with root package name */
    private View f69996b;

    /* renamed from: c  reason: collision with root package name */
    private Button f69997c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f69998d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f69999e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f70000f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f70001g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f70002h;

    public static e a(a aVar) {
        e eVar = new e();
        eVar.f69995a = aVar;
        return eVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        this.f69996b = layoutInflater.inflate(R.layout.d_cvv_help, viewGroup, false);
        this.f69997c = (Button) this.f69996b.findViewById(R.id.btn_proceed);
        this.f69997c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.this.f69995a != null) {
                    e.this.f69995a.a();
                }
            }
        });
        this.f69998d = (TextView) this.f69996b.findViewById(R.id.tv_cvv_desc);
        this.f69999e = (ImageView) this.f69996b.findViewById(R.id.iv_card_image);
        this.f70000f = (ImageView) this.f69996b.findViewById(R.id.iv_close_icon);
        this.f70000f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.this.f69995a != null) {
                    e.this.f69995a.a();
                }
            }
        });
        this.f70001g = getArguments().getBoolean(c.a.AMEX.name(), false);
        if (getArguments().getBoolean(c.a.NON_AMEX.name(), false) || getArguments().getBoolean(c.a.ALL.name(), false)) {
            z = true;
        }
        this.f70002h = z;
        if (this.f70001g) {
            this.f69998d.setText(getString(R.string.cvv_desc_amex));
            this.f69999e.setImageDrawable(b.a(getContext(), R.drawable.cvv_help_amex));
        } else {
            this.f69998d.setText(getString(R.string.cvv_desc));
            this.f69999e.setImageDrawable(b.a(getContext(), R.drawable.cvv_help));
        }
        return this.f69996b;
    }
}
