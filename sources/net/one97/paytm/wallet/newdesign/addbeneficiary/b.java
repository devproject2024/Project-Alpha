package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class b extends f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public AppCompatActivity f70599a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public String f70600b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public String f70601c;

    /* renamed from: d  reason: collision with root package name */
    String f70602d;

    /* renamed from: e  reason: collision with root package name */
    WalletPaymentCallbackListener f70603e;

    /* renamed from: f  reason: collision with root package name */
    private Button f70604f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70605g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70606h;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static b a() {
        return new b();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_failure_bottom_sheet, viewGroup, false);
        this.f70604f = (Button) inflate.findViewById(R.id.btn_retry);
        this.f70605g = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.f70604f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                b.a(bVar, bVar.f70599a, b.this.f70600b, b.this.f70601c);
            }
        });
        this.f70605g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.f70606h = (TextView) inflate.findViewById(R.id.tv_failure_message);
        if (!TextUtils.isEmpty(this.f70600b)) {
            TextView textView = this.f70606h;
            StringBuilder sb = new StringBuilder("Failed to add ");
            String str = this.f70600b;
            if (str.length() >= 20) {
                String[] split = str.split(" ");
                if (split.length != 1) {
                    if (split[0].length() + split[1].length() <= 20) {
                        str = split[0] + " " + split[1];
                    } else {
                        str = split[0];
                    }
                }
            }
            sb.append(str);
            sb.append(" as a beneficiary");
            textView.setText(sb.toString());
        } else {
            this.f70606h.setText("Failed to add " + this.f70601c + " as a beneficiary");
        }
        return inflate;
    }

    static /* synthetic */ void a(b bVar, AppCompatActivity appCompatActivity, String str, String str2) {
        a a2 = a.a();
        a2.a(appCompatActivity, str, str2, bVar.f70602d, bVar.f70603e);
        if (bVar.getActivity() != null) {
            a2.show(bVar.getActivity().getSupportFragmentManager(), "ab_widget_bottom_sheet_fragment");
        }
        bVar.dismiss();
    }
}
