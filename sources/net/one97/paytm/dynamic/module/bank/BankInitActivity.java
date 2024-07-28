package net.one97.paytm.dynamic.module.bank;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.paymentsBank.activity.BankFlowActivity;

public final class BankInitActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaymentsBankImplProvider.init();
        new ModuleManager().init();
        ae aeVar = ae.f50307a;
        if (ae.b() != null) {
            ModuleManager moduleManager = new ModuleManager();
            ae aeVar2 = ae.f50307a;
            moduleManager.getBundleValues(ae.b());
            ae aeVar3 = ae.f50307a;
            ae.a(new Bundle());
        }
        Intent intent = new Intent(this, BankFlowActivity.class);
        if (getIntent() != null) {
            Intent intent2 = getIntent();
            k.a((Object) intent2, "getIntent()");
            if (intent2.getExtras() != null) {
                Intent intent3 = getIntent();
                k.a((Object) intent3, "getIntent()");
                Bundle extras = intent3.getExtras();
                if (extras == null) {
                    k.a();
                }
                intent.putExtras(extras);
            }
        }
        if (getIntent() != null) {
            Intent intent4 = getIntent();
            k.a((Object) intent4, "getIntent()");
            if (!TextUtils.isEmpty(intent4.getAction())) {
                Intent intent5 = getIntent();
                k.a((Object) intent5, "getIntent()");
                intent.setAction(intent5.getAction());
            }
        }
        intent.setFlags(33554432);
        startActivity(intent);
        finish();
    }
}
