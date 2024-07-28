package net.one97.paytm.moneytransfer.view.activities;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.t;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.e;
import net.one97.paytm.moneytransfer.presenter.c;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.registration.view.v;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class MoneyTransferLinkAccountActivity extends MoneyTransferBaseActivity implements View.OnClickListener, e.b {

    /* renamed from: a  reason: collision with root package name */
    private String f54294a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f54295b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f54296c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f54297d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public e.a f54298e;

    /* renamed from: f  reason: collision with root package name */
    private CustomWalletLoaderDialog f54299f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f54300g;

    /* renamed from: h  reason: collision with root package name */
    private v f54301h;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f54298e = (e.a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int color = getResources().getColor(R.color.color_ffffff);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(color);
            }
        }
        setContentView(R.layout.activity_money_transfer_link_account);
        this.f54298e = new c(this, g.a());
        this.f54295b = (ImageView) findViewById(R.id.iv_back_button);
        this.f54296c = (ImageView) findViewById(R.id.menu_iv);
        this.f54295b.setOnClickListener(this);
        this.f54296c.setOnClickListener(this);
        this.f54297d = getIntent().getBooleanExtra("select_account", false);
        if (this.f54297d) {
            this.f54294a = UpiConstants.FEATURE_TYPE_LINK_BANK_LIST;
        }
        if (getIntent() != null && getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            this.f54297d = true;
            this.f54294a = Uri.parse(getIntent().getStringExtra("EXTRA_DEEP_LINK_DATA")).getQueryParameter("featuretype");
        }
        this.f54301h = (v) getSupportFragmentManager().c(v.class.getSimpleName());
        if (this.f54301h == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_deeplink", this.f54297d);
            bundle2.putString("feature_type", this.f54294a);
            this.f54301h = v.a("MoneyTransfer", true);
            this.f54301h.setArguments(bundle2);
            UpiUtils.addFragmentToActivity(getSupportFragmentManager(), this.f54301h, R.id.fl_container);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.menu_iv) {
            final t tVar = new t(this, this.f54296c);
            tVar.b().inflate(R.menu.mt_linked_account_menu, tVar.f1796a);
            tVar.f1797b.a();
            tVar.f1798c = new t.b() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.deregister) {
                        MoneyTransferLinkAccountActivity.a(MoneyTransferLinkAccountActivity.this);
                    }
                    tVar.f1797b.d();
                    return true;
                }
            };
        } else if (id == R.id.iv_back_button) {
            if (this.f54300g) {
                setResult(-1);
            }
            finish();
        }
    }

    private void a(boolean z, String str) {
        try {
            if (this.f54299f == null) {
                this.f54299f = new CustomWalletLoaderDialog(this);
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    this.f54299f.setTitle(str);
                }
                this.f54299f.showLoader();
                return;
            }
            this.f54299f.dismissLoader();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        a(true, getString(R.string.upi_deleting_profile));
    }

    public final void a(String str) {
        a(false, "");
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, R.string.some_went_wrong, 1).show();
        } else {
            Toast.makeText(this, str, 1).show();
        }
    }

    public final void b() {
        a(false, "");
        c.a aVar = new c.a(this);
        aVar.a(false);
        aVar.b(R.string.upi_post_deregister_msg);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                MoneyTransferLinkAccountActivity.this.setResult(-1);
                MoneyTransferLinkAccountActivity.this.finish();
            }
        });
        aVar.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f54298e.f();
    }

    public void onBackPressed() {
        if (this.f54300g) {
            setResult(-1);
        }
        finish();
    }

    static /* synthetic */ void a(MoneyTransferLinkAccountActivity moneyTransferLinkAccountActivity) {
        c.a aVar = new c.a(moneyTransferLinkAccountActivity);
        aVar.a(true);
        aVar.b(R.string.upi_deregister_msg);
        aVar.a(R.string.upi_deregister_profile);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MoneyTransferLinkAccountActivity.this.f54298e.a();
                dialogInterface.dismiss();
            }
        });
        aVar.b(R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        aVar.b();
    }
}
