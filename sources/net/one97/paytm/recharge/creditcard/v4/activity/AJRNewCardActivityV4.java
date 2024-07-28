package net.one97.paytm.recharge.creditcard.v4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeBaseActivityV8;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity;
import net.one97.paytm.recharge.creditcard.v4.c.b;

public final class AJRNewCardActivityV4 extends AJRRechargeBaseActivityV8 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62553a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f62554c = f62554c;

    /* renamed from: b  reason: collision with root package name */
    private t f62555b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f62556d;

    public final View a(int i2) {
        if (this.f62556d == null) {
            this.f62556d = new HashMap();
        }
        View view = (View) this.f62556d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f62556d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v4_new_credit_card_activity);
        b.a aVar = b.f62581b;
        getSupportFragmentManager().a().b(R.id.lyt_container, new b(), b.w).c();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        j supportFragmentManager = getSupportFragmentManager();
        b.a aVar = b.f62581b;
        Fragment c2 = supportFragmentManager.c(b.w);
        AJRCreditCardEnterAmountActivity.b bVar = AJRCreditCardEnterAmountActivity.f62377b;
        if (i2 == AJRCreditCardEnterAmountActivity.P) {
            if (c2 instanceof b) {
                b bVar2 = (b) c2;
                if (bVar2.isAdded() && !bVar2.isDetached()) {
                    bVar2.a();
                }
            }
        } else if (c2 instanceof b) {
            b bVar3 = (b) c2;
            if (bVar3.isAdded() && !bVar3.isDetached()) {
                c2.onActivityResult(i2, i3, intent);
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final boolean onSupportNavigateUp() {
        this.f62555b = new t(this);
        t tVar = this.f62555b;
        if (tVar == null) {
            k.a("mKeyboardUtil");
        }
        tVar.a();
        return super.onSupportNavigateUp();
    }
}
