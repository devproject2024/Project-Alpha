package net.one97.paytm.paymentsBank.chequebook.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public abstract class ChequeBookBaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f17941a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f17942b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f17943c;

    public abstract int a();

    public View a(int i2) {
        if (this.f17943c == null) {
            this.f17943c = new HashMap();
        }
        View view = (View) this.f17943c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17943c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a());
        View findViewById = findViewById(R.id.iv_header_back);
        k.a((Object) findViewById, "findViewById<ImageView>(R.id.iv_header_back)");
        this.f17941a = (ImageView) findViewById;
        ImageView imageView = this.f17941a;
        if (imageView == null) {
            k.a("mBackButton");
        }
        if (imageView != null) {
            ImageView imageView2 = this.f17941a;
            if (imageView2 == null) {
                k.a("mBackButton");
            }
            imageView2.setOnClickListener(new a(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookBaseActivity f17944a;

        a(ChequeBookBaseActivity chequeBookBaseActivity) {
            this.f17944a = chequeBookBaseActivity;
        }

        public final void onClick(View view) {
            this.f17944a.onBackPressed();
        }
    }

    public final void a(Context context, String str) {
        k.c(str, "message");
        ProgressDialog progressDialog = this.f17942b;
        if (progressDialog != null) {
            if (progressDialog == null) {
                k.a();
            }
            if (progressDialog.isShowing()) {
                return;
            }
        }
        this.f17942b = new ProgressDialog(context);
        try {
            ProgressDialog progressDialog2 = this.f17942b;
            if (progressDialog2 == null) {
                k.a();
            }
            progressDialog2.setProgressStyle(0);
            ProgressDialog progressDialog3 = this.f17942b;
            if (progressDialog3 == null) {
                k.a();
            }
            progressDialog3.setMessage(str);
            ProgressDialog progressDialog4 = this.f17942b;
            if (progressDialog4 == null) {
                k.a();
            }
            progressDialog4.setCancelable(false);
            ProgressDialog progressDialog5 = this.f17942b;
            if (progressDialog5 == null) {
                k.a();
            }
            progressDialog5.setCanceledOnTouchOutside(false);
            ProgressDialog progressDialog6 = this.f17942b;
            if (progressDialog6 == null) {
                k.a();
            }
            progressDialog6.show();
        } catch (Exception unused) {
        }
    }

    public final void h() {
        try {
            if (this.f17942b != null) {
                ProgressDialog progressDialog = this.f17942b;
                if (progressDialog == null) {
                    k.a();
                }
                if (progressDialog.isShowing() && !isFinishing()) {
                    ProgressDialog progressDialog2 = this.f17942b;
                    if (progressDialog2 == null) {
                        k.a();
                    }
                    progressDialog2.dismiss();
                    this.f17942b = null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
