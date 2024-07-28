package net.one97.paytm.hotel4.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import com.google.android.play.core.splitcompat.a;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.hotel4.view.ui.a.s;
import net.one97.paytm.hotel4.view.ui.a.z;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.cq;

public final class AJRHotelOrderSummaryActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private CancelOrderViewModel f29050a;

    /* renamed from: b  reason: collision with root package name */
    private s f29051b;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = f.a(this, R.layout.h4_order_summary_activity);
        k.a((Object) a2, "DataBindingUtil.setConte…4_order_summary_activity)");
        cq cqVar = (cq) a2;
        this.f29050a = (CancelOrderViewModel) am.a((FragmentActivity) this).a(CancelOrderViewModel.class);
        CancelOrderViewModel cancelOrderViewModel = this.f29050a;
        if (cancelOrderViewModel != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "this.intent");
            cancelOrderViewModel.getDataFromIntent(intent);
        }
        cqVar.setLifecycleOwner(this);
        this.f29051b = new s();
        s sVar = this.f29051b;
        if (sVar == null) {
            k.a();
        }
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        q a3 = supportFragmentManager.a();
        k.a((Object) a3, "manager.beginTransaction()");
        a3.b(R.id.fragment_continer, sVar, "cancel_booking");
        a3.c();
    }

    public final void onBackPressed(View view) {
        z zVar;
        k.c(view, "view");
        s sVar = this.f29051b;
        if (sVar != null && sVar != null && sVar.f28949d != null && (zVar = sVar.f28949d) != null) {
            zVar.dismiss();
        }
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        a.a(context);
        a.b(context);
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(context);
        Context context2 = this;
        a.a(context2);
        a.b(context2);
    }
}
