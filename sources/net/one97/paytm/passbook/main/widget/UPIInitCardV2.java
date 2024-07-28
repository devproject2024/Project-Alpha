package net.one97.paytm.passbook.main.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.main.b.a;
import net.one97.paytm.passbook.main.b.b;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;

public class UPIInitCardV2 extends LinearLayout implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a f57850a;

    /* renamed from: b  reason: collision with root package name */
    private b f57851b;

    /* renamed from: c  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f57852c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f57853d;

    /* renamed from: e  reason: collision with root package name */
    private String f57854e;

    public interface a {
        Fragment a();
    }

    public void setFavoriteBanks(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4) {
    }

    public UPIInitCardV2(Context context) {
        this(context, (AttributeSet) null);
    }

    public UPIInitCardV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public UPIInitCardV2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f57853d = false;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_init_cards_layout, this, false);
        removeAllViews();
        addView(inflate);
        this.f57851b = new b(this);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UPIInitCardV2.this.a(view);
            }
        });
        if (com.paytm.utility.b.c(getContext())) {
            this.f57851b.a();
        } else if (getContext() != null && (getContext() instanceof Activity)) {
            getVisibility();
        }
    }

    public void setListener(a aVar) {
        this.f57850a = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f57851b.b();
    }

    public final void a(String str) {
        Toast.makeText(getContext(), str, 0).show();
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.f57852c = accountProvider;
        if (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a(getContext(), "android.permission.READ_PHONE_STATE") != 0) {
            ((Activity) getContext()).requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 16);
        } else if (getContext() == null) {
        } else {
            if (!this.f57853d) {
                Intent a2 = d.b().a(getContext(), this.f57852c);
                a aVar = this.f57850a;
                if (aVar != null) {
                    aVar.a().startActivityForResult(a2, 0);
                }
            } else if (this.f57850a != null) {
                d.b().a(this.f57850a.a(), this.f57852c, this.f57854e);
            }
        }
    }

    public final void a() {
        if (this.f57850a != null) {
            this.f57850a.a().startActivityForResult(new Intent(getContext(), d.b().t()), 2304);
        }
    }

    public final void a(int i2, int i3, Intent intent) {
        b bVar = this.f57851b;
        if (i3 == -1 && i2 == 2304) {
            bVar.a((AccountProviderBody.AccountProvider) q.a((Object) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), AccountProviderBody.AccountProvider.class));
        }
    }
}
