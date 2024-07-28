package net.one97.paytm.paymentsBank.slfd.createfd.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.h.u;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.createfd.a.b;
import net.one97.paytm.paymentsBank.slfd.passbook.view.SlfdPassbookActivity;
import net.one97.paytm.paymentsBank.utils.o;

public final class SlfdInfoActivity extends SlfdBaseActivity implements b.C0334b {

    /* renamed from: b  reason: collision with root package name */
    public b.a f19086b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f19087c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f19088d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19089e;

    /* renamed from: f  reason: collision with root package name */
    private Button f19090f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f19091g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f19092h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f19093i;
    /* access modifiers changed from: private */
    public boolean j;
    private boolean k;
    private HashMap l;

    public final View a(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final b.a f() {
        b.a aVar = this.f19086b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_fd_info;
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = getIntent().getBooleanExtra("SLFD_IMPULSE_DO_ALLOW_BOOKING", false);
        this.k = getIntent().getBooleanExtra("show_slfd_transactions", false);
        View findViewById = findViewById(R.id.iv_back);
        ImageView imageView = (ImageView) findViewById;
        imageView.setOnClickListener(new a(this));
        k.a((Object) findViewById, "(findViewById<ImageView>…this.finish() }\n        }");
        this.f19087c = imageView;
        View findViewById2 = findViewById(R.id.tv_earn_on_fd_header);
        k.a((Object) findViewById2, "findViewById<TextView>(R.id.tv_earn_on_fd_header)");
        this.f19088d = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_fd_receive_money_header);
        k.a((Object) findViewById3, "findViewById<TextView>(R…_fd_receive_money_header)");
        this.f19089e = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.btn_create_fd);
        Button button = (Button) findViewById4;
        button.setOnClickListener(new b(this));
        k.a((Object) findViewById4, "(findViewById<Button>(R.…}\n            }\n        }");
        this.f19090f = button;
        Button button2 = this.f19090f;
        if (button2 == null) {
            k.a("btnCreateFd");
        }
        button2.setVisibility(8);
        View findViewById5 = findViewById(R.id.tv_know_more);
        TextView textView = (TextView) findViewById5;
        textView.setOnClickListener(new c(this));
        k.a((Object) findViewById5, "(findViewById<TextView>(…eToKnowMore() }\n        }");
        this.f19091g = textView;
        View findViewById6 = findViewById(R.id.tv_view_transaction);
        TextView textView2 = (TextView) findViewById6;
        textView2.setOnClickListener(new d(this));
        k.a((Object) findViewById6, "(findViewById<TextView>(…)\n            }\n        }");
        this.f19093i = textView2;
        if (this.k) {
            TextView textView3 = this.f19093i;
            if (textView3 == null) {
                k.a("tvViewTransaction");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(textView3);
        } else {
            TextView textView4 = this.f19093i;
            if (textView4 == null) {
                k.a("tvViewTransaction");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.b(textView4);
        }
        View findViewById7 = findViewById(R.id.pb_progress);
        k.a((Object) findViewById7, "findViewById<ProgressBar>(R.id.pb_progress)");
        this.f19092h = (ProgressBar) findViewById7;
        ProgressBar progressBar = this.f19092h;
        if (progressBar == null) {
            k.a("pbProgress");
        }
        u.g((View) progressBar, 10.0f);
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        b.a bVar = new net.one97.paytm.paymentsBank.slfd.createfd.b.b(net.one97.paytm.paymentsBank.slfd.c.a(applicationContext), this);
        k.c(bVar, "<set-?>");
        this.f19086b = bVar;
        f().a();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdInfoActivity f19094a;

        a(SlfdInfoActivity slfdInfoActivity) {
            this.f19094a = slfdInfoActivity;
        }

        public final void onClick(View view) {
            this.f19094a.finish();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdInfoActivity f19095a;

        b(SlfdInfoActivity slfdInfoActivity) {
            this.f19095a = slfdInfoActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19095a, "fixed_deposit", "fixed_deposit_button_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/landing", "fixed_deposit");
            if (this.f19095a.j) {
                this.f19095a.f().c();
                return;
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a((AppCompatActivity) this.f19095a, (CharSequence) "Please update your PAN to avail SLFD feature.");
            SlfdInfoActivity.b(this.f19095a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdInfoActivity f19096a;

        c(SlfdInfoActivity slfdInfoActivity) {
            this.f19096a = slfdInfoActivity;
        }

        public final void onClick(View view) {
            o.a().openWebViewActivity(this.f19096a, "https://paytm.com/offer/know-more-for-fixed-deposit/", "");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdInfoActivity f19097a;

        d(SlfdInfoActivity slfdInfoActivity) {
            this.f19097a = slfdInfoActivity;
        }

        public final void onClick(View view) {
            this.f19097a.startActivity(new Intent(this.f19097a, SlfdPassbookActivity.class));
        }
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        if (slfdMetaApiResponseModel != null) {
            Intent intent = getIntent();
            intent.setClass(this, CreateSlfdActivity.class);
            intent.putExtra("slfd_meta_response", slfdMetaApiResponseModel);
            startActivity(intent);
            finish();
            return;
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((AppCompatActivity) this, (CharSequence) "Some error occurred");
    }

    public final void onDestroy() {
        super.onDestroy();
        f().b();
    }

    public final void a(String str) {
        TextView textView = this.f19088d;
        if (textView == null) {
            k.a("tvEarnOnFd");
        }
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void b(String str) {
        TextView textView = this.f19089e;
        if (textView == null) {
            k.a("tvReceiveMoney");
        }
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void a(boolean z) {
        if (z) {
            ProgressBar progressBar = this.f19092h;
            if (progressBar == null) {
                k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
            return;
        }
        ProgressBar progressBar2 = this.f19092h;
        if (progressBar2 == null) {
            k.a("pbProgress");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar2);
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public static final /* synthetic */ void b(SlfdInfoActivity slfdInfoActivity) {
        try {
            o.a().openPanCardDeeplink(slfdInfoActivity, false);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }
}
