package net.one97.paytm.paymentsBank.createfd.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.b.c;
import net.one97.paytm.paymentsBank.createfd.b.d;
import net.one97.paytm.paymentsBank.createfd.b.e;
import net.one97.paytm.paymentsBank.createfd.b.f;
import net.one97.paytm.paymentsBank.createfd.c.e;
import net.one97.paytm.paymentsBank.createfd.model.OptionsModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse;

public final class FdPostTransactionActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private b.a.c f18079a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_transaction_act_layout);
        a(b.a.c.PROCESSING, (TransactionDetailResponse) null);
    }

    public final void a(b.a.c cVar, TransactionDetailResponse transactionDetailResponse) {
        String str;
        Bundle extras;
        Bundle extras2;
        String str2;
        Bundle extras3;
        Bundle extras4;
        Window window;
        String str3;
        Bundle extras5;
        Bundle extras6;
        String str4;
        String str5;
        Bundle extras7;
        Bundle extras8;
        Bundle extras9;
        k.c(cVar, "orderStatus");
        this.f18079a = cVar;
        int i2 = a.f18080a[cVar.ordinal()];
        String str6 = null;
        if (i2 == 1) {
            Bundle bundle = new Bundle();
            b.a aVar = b.f18186a;
            bundle.putSerializable(b.u, transactionDetailResponse);
            b.a aVar2 = b.f18186a;
            String d2 = b.f18191f;
            Intent intent = getIntent();
            if (intent == null || (extras2 = intent.getExtras()) == null) {
                str = null;
            } else {
                b.a aVar3 = b.f18186a;
                str = extras2.getString(b.f18191f);
            }
            bundle.putString(d2, str);
            b.a aVar4 = b.f18186a;
            String e2 = b.f18192g;
            Intent intent2 = getIntent();
            if (!(intent2 == null || (extras = intent2.getExtras()) == null)) {
                b.a aVar5 = b.f18186a;
                str6 = extras.getString(b.f18192g);
            }
            bundle.putString(e2, str6);
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                supportFragmentManager.a().b(R.id.parent_lyt, Fragment.instantiate(this, f.class.getName(), bundle), "post_txn").c();
            }
        } else if (i2 == 2) {
            Bundle bundle2 = new Bundle();
            b.a aVar6 = b.f18186a;
            bundle2.putSerializable(b.u, transactionDetailResponse);
            b.a aVar7 = b.f18186a;
            String d3 = b.f18191f;
            Intent intent3 = getIntent();
            if (intent3 == null || (extras4 = intent3.getExtras()) == null) {
                str2 = null;
            } else {
                b.a aVar8 = b.f18186a;
                str2 = extras4.getString(b.f18191f);
            }
            bundle2.putString(d3, str2);
            b.a aVar9 = b.f18186a;
            String e3 = b.f18192g;
            Intent intent4 = getIntent();
            if (!(intent4 == null || (extras3 = intent4.getExtras()) == null)) {
                b.a aVar10 = b.f18186a;
                str6 = extras3.getString(b.f18192g);
            }
            bundle2.putString(e3, str6);
            j supportFragmentManager2 = getSupportFragmentManager();
            if (supportFragmentManager2 != null) {
                supportFragmentManager2.a().b(R.id.parent_lyt, Fragment.instantiate(this, c.class.getName(), bundle2), "post_txn").c();
            }
        } else if (i2 == 3) {
            j supportFragmentManager3 = getSupportFragmentManager();
            Fragment c2 = supportFragmentManager3 != null ? supportFragmentManager3.c("post_txn") : null;
            if (c2 instanceof d) {
                d dVar = (d) c2;
                View view = dVar.getView();
                ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(R.id.middleLayout) : null;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                LayoutInflater layoutInflater = dVar.getLayoutInflater();
                View inflate = layoutInflater != null ? layoutInflater.inflate(R.layout.fd_post_transaction_pending_bottom_layout, (ViewGroup) null) : null;
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                if (viewGroup != null) {
                    viewGroup.addView(inflate, layoutParams);
                }
                Context context = dVar.getContext();
                if (!(context instanceof Activity)) {
                    context = null;
                }
                Activity activity = (Activity) context;
                if (!(activity == null || (window = activity.getWindow()) == null)) {
                    Context context2 = dVar.getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    window.setStatusBarColor(androidx.core.content.b.c(context2, R.color.color_ffa400));
                }
                dVar.a(Integer.valueOf(R.string.fd_pending_heading), dVar.f18116c, Integer.valueOf(R.drawable.pb_fd_create_ic_failed));
                dVar.b(0);
                dVar.a((TextView) dVar.a(R.id.tv_message));
                dVar.b((TextView) dVar.a(R.id.tv_datetime));
                List arrayList = new ArrayList();
                String string = dVar.getString(R.string.option_help);
                int i3 = R.drawable.pb_contact_us_icon_new;
                b.a aVar11 = b.f18186a;
                arrayList.add(new OptionsModel(string, i3, Integer.valueOf(b.x), (String) null, 8, (g) null));
                dVar.a((List<OptionsModel>) arrayList);
                dVar.a(Boolean.TRUE);
            }
        } else if (i2 == 4) {
            Bundle bundle3 = new Bundle();
            b.a aVar12 = b.f18186a;
            bundle3.putSerializable(b.u, transactionDetailResponse);
            b.a aVar13 = b.f18186a;
            String d4 = b.f18191f;
            Intent intent5 = getIntent();
            if (intent5 == null || (extras6 = intent5.getExtras()) == null) {
                str3 = null;
            } else {
                b.a aVar14 = b.f18186a;
                str3 = extras6.getString(b.f18191f);
            }
            bundle3.putString(d4, str3);
            b.a aVar15 = b.f18186a;
            String e4 = b.f18192g;
            Intent intent6 = getIntent();
            if (!(intent6 == null || (extras5 = intent6.getExtras()) == null)) {
                b.a aVar16 = b.f18186a;
                str6 = extras5.getString(b.f18192g);
            }
            bundle3.putString(e4, str6);
            j supportFragmentManager4 = getSupportFragmentManager();
            if (supportFragmentManager4 != null) {
                supportFragmentManager4.a().b(R.id.parent_lyt, Fragment.instantiate(this, e.class.getName(), bundle3), "post_txn").c();
            }
        } else if (i2 == 5) {
            Bundle bundle4 = new Bundle();
            b.a aVar17 = b.f18186a;
            String c3 = b.f18190e;
            Intent intent7 = getIntent();
            if (intent7 == null || (extras9 = intent7.getExtras()) == null) {
                str4 = null;
            } else {
                b.a aVar18 = b.f18186a;
                str4 = extras9.getString(b.f18190e);
            }
            bundle4.putString(c3, str4);
            b.a aVar19 = b.f18186a;
            String d5 = b.f18191f;
            Intent intent8 = getIntent();
            if (intent8 == null || (extras8 = intent8.getExtras()) == null) {
                str5 = null;
            } else {
                b.a aVar20 = b.f18186a;
                str5 = extras8.getString(b.f18191f);
            }
            bundle4.putString(d5, str5);
            b.a aVar21 = b.f18186a;
            String e5 = b.f18192g;
            Intent intent9 = getIntent();
            if (!(intent9 == null || (extras7 = intent9.getExtras()) == null)) {
                b.a aVar22 = b.f18186a;
                str6 = extras7.getString(b.f18192g);
            }
            bundle4.putString(e5, str6);
            j supportFragmentManager5 = getSupportFragmentManager();
            if (supportFragmentManager5 != null) {
                supportFragmentManager5.a().b(R.id.parent_lyt, Fragment.instantiate(this, d.class.getName(), bundle4), "post_txn").c();
            }
        }
    }

    public final void finish() {
        b.a.c cVar = this.f18079a;
        if (cVar != null && a.f18081b[cVar.ordinal()] == 1) {
            setResult(-1);
        }
        super.finish();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            j supportFragmentManager = getSupportFragmentManager();
            Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c("post_txn") : null;
            if (!(c2 instanceof net.one97.paytm.paymentsBank.createfd.b.g)) {
                c2 = null;
            }
            net.one97.paytm.paymentsBank.createfd.b.g gVar = (net.one97.paytm.paymentsBank.createfd.b.g) c2;
            if (gVar != null && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                e.a aVar = gVar.f18117d;
                if (aVar == null) {
                    k.a("presenter");
                }
                String stringExtra = intent.getStringExtra("passcode");
                k.a((Object) stringExtra, "data.getStringExtra(PBConstants.EXTRA_PASSCODE)");
                String ab = a.ab(gVar.f18116c);
                k.a((Object) ab, "CJRAppUtility.getCleanString(amount)");
                aVar.a(stringExtra, ab);
            }
        }
    }
}
