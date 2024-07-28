package net.one97.paytm.wallet.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import java.util.HashMap;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.p2mNewDesign.f.k;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.utils.P2MPostPaymentFragmentFactory;

public final class P2MPaymentSuccessActivityV2 extends AppCompatLockActivity implements k {

    /* renamed from: e  reason: collision with root package name */
    private boolean f69930e = true;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f69931f;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f69931f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this.f69931f == null) {
            this.f69931f = new HashMap();
        }
        View view = (View) this.f69931f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f69931f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_payment_success_latest);
        try {
            CJRSendGTMTag.sendOpenScreenWithDeviceInfo("/wallet/pay-send/success", "Wallet", this);
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_send_money_method_name", "success");
            b.a().sendCustomEventWithMap("wallet_send_money_method_selected", hashMap, getApplicationContext());
        } catch (Exception unused) {
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        if (bundle != null && bundle.containsKey("shouldPlaySound")) {
            this.f69930e = bundle.getBoolean("shouldPlaySound");
        }
        if (getIntent().getBooleanExtra("isMLVEnabledPayment", false)) {
            P2MPostPaymentFragmentFactory p2MPostPaymentFragmentFactory = P2MPostPaymentFragmentFactory.INSTANCE;
            Intent intent = getIntent();
            kotlin.g.b.k.a((Object) intent, "intent");
            getSupportFragmentManager().a((String) null);
            getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, p2MPostPaymentFragmentFactory.getMlvPostTxnFragment(intent), "mlv_enabled_payment").c();
            return;
        }
        P2MPostPaymentFragmentFactory p2MPostPaymentFragmentFactory2 = P2MPostPaymentFragmentFactory.INSTANCE;
        Intent intent2 = getIntent();
        kotlin.g.b.k.a((Object) intent2, "intent");
        getSupportFragmentManager().a((String) null);
        getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, p2MPostPaymentFragmentFactory2.getPostTxnFragment(intent2), (String) null).b();
    }

    public final void a() {
        this.f51786a = 102;
    }

    public final void c() {
        if (this.f69930e) {
            MediaPlayer create = MediaPlayer.create(this, R.raw.payment_success);
            this.f69930e = false;
            if (create != null) {
                if (!create.isPlaying()) {
                    create.start();
                }
                create.setOnCompletionListener(a.f69932a);
            }
        }
    }

    static final class a implements MediaPlayer.OnCompletionListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f69932a = new a();

        a() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            kotlin.g.b.k.c(mediaPlayer, "obj");
            mediaPlayer.release();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("shouldPlaySound", false);
    }
}
