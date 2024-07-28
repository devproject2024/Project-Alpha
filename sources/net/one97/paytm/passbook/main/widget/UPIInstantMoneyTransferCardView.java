package net.one97.paytm.passbook.main.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.main.b.a;
import net.one97.paytm.passbook.main.b.b;
import net.one97.paytm.passbook.mapping.c;

public class UPIInstantMoneyTransferCardView extends LinearLayout implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a f57855a;

    /* renamed from: b  reason: collision with root package name */
    private b f57856b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f57857c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f57858d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f57859e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f57860f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f57861g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f57862h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f57863i;
    private TextView j;
    private AccountProviderBody.AccountProvider k;
    private AccountProviderBody.AccountProvider l;
    private AccountProviderBody.AccountProvider m;
    private AccountProviderBody.AccountProvider n;
    private AccountProviderBody.AccountProvider o;
    private boolean p;
    private String q;
    private View.OnClickListener r;

    public interface a {
        Fragment a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (view.getId() == R.id.item1_ll) {
            this.f57856b.a(this.k);
        } else if (view.getId() == R.id.item2_ll) {
            this.f57856b.a(this.l);
        } else if (view.getId() == R.id.item3_ll) {
            this.f57856b.a(this.m);
        } else if (view.getId() == R.id.item4_ll) {
            this.f57856b.a(this.n);
        } else if (view.getId() == R.id.other_bank_ll) {
            this.f57856b.b();
        }
    }

    public UPIInstantMoneyTransferCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public UPIInstantMoneyTransferCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public UPIInstantMoneyTransferCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = false;
        this.r = new View.OnClickListener() {
            public final void onClick(View view) {
                UPIInstantMoneyTransferCardView.this.a(view);
            }
        };
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_layout_upi_instant_money_transfer, this, false);
        removeAllViews();
        addView(inflate);
        this.f57856b = new b(this);
        inflate.findViewById(R.id.item1_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.item2_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.item3_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.item4_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.other_bank_ll).setOnClickListener(this.r);
        this.f57857c = (ImageView) inflate.findViewById(R.id.icon1);
        this.f57858d = (ImageView) inflate.findViewById(R.id.icon2);
        this.f57859e = (ImageView) inflate.findViewById(R.id.icon3);
        this.f57860f = (ImageView) inflate.findViewById(R.id.icon4);
        this.f57861g = (TextView) inflate.findViewById(R.id.item1_tv);
        this.f57862h = (TextView) inflate.findViewById(R.id.item2_tv);
        this.f57863i = (TextView) inflate.findViewById(R.id.item3_tv);
        this.j = (TextView) inflate.findViewById(R.id.item4_tv);
        setVisibility(8);
        if (com.paytm.utility.b.c(getContext())) {
            this.f57856b.a();
        } else if (getContext() != null && (getContext() instanceof Activity) && getVisibility() == 0) {
            c.g((Activity) getContext());
        }
    }

    public void setListener(a aVar) {
        this.f57855a = aVar;
    }

    public void setFavoriteBanks(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4) {
        this.k = accountProvider;
        this.l = accountProvider2;
        this.m = accountProvider3;
        this.n = accountProvider4;
        a(i2, accountProvider, this.f57857c, this.f57861g);
        a(i3, accountProvider2, this.f57858d, this.f57862h);
        a(i4, accountProvider3, this.f57859e, this.f57863i);
        a(i5, accountProvider4, this.f57860f, this.j);
    }

    private void a(int i2, AccountProviderBody.AccountProvider accountProvider, ImageView imageView, TextView textView) {
        if (i2 == -1) {
            a(imageView, accountProvider.getBankLogoUrl());
        } else {
            imageView.setImageDrawable(androidx.core.content.b.a(getContext(), i2));
        }
        textView.setText(accountProvider.getAccountProvider());
    }

    private static void a(ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            w.a().a(str).a(R.drawable.pass_ic_paytm_payments_bank).b(R.drawable.pass_ic_paytm_payments_bank).a(imageView, (e) null);
        } else {
            imageView.setImageResource(R.drawable.pass_ic_paytm_payments_bank);
        }
    }

    public final void a(String str) {
        Toast.makeText(getContext(), str, 0).show();
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.o = accountProvider;
        if (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a(getContext(), "android.permission.READ_PHONE_STATE") != 0) {
            ((Activity) getContext()).requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 16);
        } else if (getContext() == null) {
        } else {
            if (!this.p) {
                Intent a2 = d.b().a(getContext(), this.o);
                a aVar = this.f57855a;
                if (aVar != null) {
                    aVar.a().startActivityForResult(a2, 0);
                }
            } else if (this.f57855a != null) {
                d.b().a(this.f57855a.a(), this.o, this.q);
            }
        }
    }

    public final void a() {
        if (this.f57855a != null) {
            this.f57855a.a().startActivityForResult(new Intent(getContext(), d.b().t()), 2304);
        }
    }
}
