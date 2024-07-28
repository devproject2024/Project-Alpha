package net.one97.paytm.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.base.a;
import net.one97.paytm.base.c;
import net.one97.paytm.base.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;

public class BaseActivity extends PaytmActivity implements a, d {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
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

    public void onReLogin(String str, Bundle bundle) {
    }

    public boolean checkForSessionTimeOut(Activity activity, int i2, NetworkCustomError networkCustomError, Bundle bundle, String str) {
        k.c(activity, "activity");
        k.c(networkCustomError, "networkCustomError");
        return a.C0880a.a(activity, i2, networkCustomError, bundle, str);
    }

    public void hideProgressDialog(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "loader");
        d.b.b(lottieAnimationView);
    }

    public void runIfTextNotNullAndEmpty(String str, b<? super String, x> bVar) {
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        d.b.a(str, bVar);
    }

    public void sendGATags(String str, String str2, String str3, String str4, Context context, String str5) {
        k.c(str, "eventCategory");
        k.c(str2, "event_action");
        k.c(str3, "event_label");
        k.c(str4, "event_value");
        k.c(context, "context");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        a.C0880a.a(str, str2, str3, str4, context, str5);
    }

    public void showDialog(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        k.c(context, "context");
        d.b.a(context, str, str2, str3, onClickListener);
    }

    public void showProgressDialog(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "loader");
        d.b.a(lottieAnimationView);
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.wallet.communicator.b.a().wrapContextByRestring(context));
    }

    public final y<f> showNetworkDialog(net.one97.paytm.network.d dVar) {
        k.c(dVar, "request");
        if (isFinishing()) {
            return null;
        }
        return d.f49504d.a(this, dVar);
    }

    public final LiveData<f> performRequestOrShowNetworkDialog(net.one97.paytm.network.d dVar) {
        k.c(dVar, "request");
        boolean c2 = com.paytm.utility.b.c((Context) this);
        if (c2) {
            return dVar.c();
        }
        if (!c2) {
            return showNetworkDialog(dVar);
        }
        throw new m();
    }

    public final boolean checkForSessionTimeOut(int i2, NetworkCustomError networkCustomError, Bundle bundle, String str) {
        k.c(networkCustomError, "networkCustomError");
        if (isFinishing()) {
            return false;
        }
        return checkForSessionTimeOut(this, i2, networkCustomError, bundle, str);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 3 && i3 == -1) {
            String str = null;
            Bundle extras = intent != null ? intent.getExtras() : null;
            if (extras != null) {
                str = extras.getString("key_relogin_tag_for_relogin");
            }
            if (extras != null ? extras.getBoolean("key_is_from_fragment") : false) {
                sendReLoginBroadcast(str, extras);
            } else {
                onReLogin(str, extras);
            }
            RecentDataNetworkManager.initializeRecentPaymentsDownload(this);
        }
        super.onActivityResult(i2, i3, intent);
    }

    private final void sendReLoginBroadcast(String str, Bundle bundle) {
        Intent intent = new Intent("action_relogin_broadcast");
        if (bundle != null) {
            intent.putExtra("extra_data", bundle);
        }
        if (str != null) {
            intent.putExtra("key_relogin_tag_for_relogin", str);
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) this);
        k.a((Object) a2, "LocalBroadcastManager.getInstance(this)");
        a2.a(intent);
    }

    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        c.a aVar = c.f49502a;
        if (i2 >= 10) {
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
            if (a2.getBooleanFromGTM(a3.getContext(), "isWalletGcEnabled", true)) {
                long currentTimeMillis = System.currentTimeMillis();
                long minutes = TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis - c.f49503b);
                if (c.f49503b == -1 || minutes >= 10) {
                    c.f49503b = currentTimeMillis;
                    System.gc();
                }
            }
        }
    }

    public com.paytm.b.a.a getPref(Context context) {
        if (context == null) {
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            context = a2.getContext();
        }
        be.a aVar = be.f69718a;
        k.a((Object) context, "cxt");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "cxt.applicationContext");
        return be.a.a(applicationContext);
    }
}
