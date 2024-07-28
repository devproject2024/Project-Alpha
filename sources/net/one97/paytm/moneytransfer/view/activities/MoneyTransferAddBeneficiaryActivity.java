package net.one97.paytm.moneytransfer.view.activities;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.core.content.b;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.view.fragments.b;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class MoneyTransferAddBeneficiaryActivity extends MoneyTransferBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f54291a;

    public final View a(int i2) {
        if (this.f54291a == null) {
            this.f54291a = new HashMap();
        }
        View view = (View) this.f54291a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f54291a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        d.a aVar = d.f53996a;
        super.attachBaseContext(d.b(d.a.a()).a(context));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_money_transfer_add_beneficiary);
        int c2 = b.c(this, R.color.white);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                k.a((Object) decorView, "window.decorView");
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(c2);
            }
        }
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            q a2 = supportFragmentManager.a();
            int i2 = R.id.fl_container;
            b.a aVar = net.one97.paytm.moneytransfer.view.fragments.b.u;
            a2.a(i2, new net.one97.paytm.moneytransfer.view.fragments.b(), new net.one97.paytm.moneytransfer.view.fragments.b().getClass().getSimpleName()).c();
        }
        ((ImageView) a(R.id.iv_back_button)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferAddBeneficiaryActivity f54292a;

        a(MoneyTransferAddBeneficiaryActivity moneyTransferAddBeneficiaryActivity) {
            this.f54292a = moneyTransferAddBeneficiaryActivity;
        }

        public final void onClick(View view) {
            this.f54292a.finish();
        }
    }
}
