package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.utility.b;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class a extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AppCompatActivity f70587a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f70588b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70589c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70590d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70591e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70592f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70593g;

    /* renamed from: h  reason: collision with root package name */
    private Button f70594h;

    /* renamed from: i  reason: collision with root package name */
    private WalletPaymentCallbackListener f70595i;
    private String j;
    private String k;
    private String l;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static a a() {
        return new a();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, String str2, String str3, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        this.f70587a = appCompatActivity;
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.f70595i = walletPaymentCallbackListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_bottom_sheet_fragment, viewGroup, false);
        AppCompatActivity appCompatActivity = this.f70587a;
        if (appCompatActivity != null && !appCompatActivity.isFinishing()) {
            this.f70588b = (ImageView) inflate.findViewById(R.id.iv_cancel);
            this.f70591e = (TextView) inflate.findViewById(R.id.tv_mobile_number);
            this.f70589c = (TextView) inflate.findViewById(R.id.tv_beneficiary_name);
            this.f70594h = (Button) inflate.findViewById(R.id.btn_add_as_beneficiary);
            this.f70590d = (TextView) inflate.findViewById(R.id.tv_title);
            this.f70592f = (TextView) inflate.findViewById(R.id.tv_know_more);
            this.f70593g = (TextView) inflate.findViewById(R.id.tv_message_level_1);
            if (this.l != null) {
                this.f70593g.setText(this.f70587a.getString(R.string.add_beneficiary_message_level1, new Object[]{this.l}));
            } else {
                this.f70593g.setText(this.f70587a.getString(R.string.add_beneficiary_message_level1_alter));
            }
            this.f70589c.setText(this.j);
            this.f70591e.setText(this.k);
            if (!TextUtils.isEmpty(this.j)) {
                TextView textView = this.f70590d;
                textView.setText("Please add " + this.j + " as a beneficiary to complete this payment");
            } else {
                TextView textView2 = this.f70590d;
                textView2.setText("Please add " + this.k + " as a beneficiary to complete this payment");
            }
            this.f70588b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.dismiss();
                }
            });
            this.f70594h.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (b.c((Context) a.this.f70587a)) {
                        a.b(a.this);
                        a.this.dismiss();
                        return;
                    }
                    net.one97.paytm.wallet.utility.a.a((Activity) a.this.f70587a, a.this.f70587a.getString(R.string.error), a.this.f70587a.getString(R.string.no_internet));
                }
            });
            this.f70592f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.c(a.this);
                    a.this.dismiss();
                }
            });
        }
        return inflate;
    }

    static /* synthetic */ void b(a aVar) {
        f a2 = f.a();
        AppCompatActivity appCompatActivity = aVar.f70587a;
        String str = aVar.j;
        String str2 = aVar.k;
        String str3 = aVar.l;
        WalletPaymentCallbackListener walletPaymentCallbackListener = aVar.f70595i;
        a2.f70630a = appCompatActivity;
        a2.f70632c = str;
        a2.f70633d = str2;
        a2.f70634e = str3;
        a2.f70631b = walletPaymentCallbackListener;
        if (aVar.getActivity() != null) {
            a2.show(aVar.getActivity().getSupportFragmentManager(), "progress_sheet");
        }
    }

    static /* synthetic */ void c(a aVar) {
        c a2 = c.a();
        a2.f70609a = aVar.f70587a;
        if (aVar.getActivity() != null) {
            a2.show(aVar.getActivity().getSupportFragmentManager(), "know_more");
        }
    }
}
