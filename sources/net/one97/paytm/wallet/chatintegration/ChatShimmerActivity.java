package net.one97.paytm.wallet.chatintegration;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import d.a.a.c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.GlobalError;
import net.one97.paytm.common.entity.p2p.MerchantInfo;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SenderInfo;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.network.f;
import net.one97.paytm.utils.ae;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.chatintegration.a;
import net.one97.paytm.wallet.chatintegration.b;
import net.one97.paytm.wallet.newdesign.universalp2p.a;

public final class ChatShimmerActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f70127a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f70128b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatShimmerActivity$mChatPayBroadcastReceiver$1 f70129c = new ChatShimmerActivity$mChatPayBroadcastReceiver$1(this);

    /* renamed from: d  reason: collision with root package name */
    private HashMap f70130d;

    public final void onCreate(Bundle bundle) {
        LiveData<f> a2;
        super.onCreate(bundle);
        setContentView(R.layout.chat_shimmer_activity);
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null) {
                Intent intent2 = getIntent();
                k.a((Object) intent2, "intent");
                Bundle extras = intent2.getExtras();
                if (extras != null) {
                    a.a((Context) this).a(this.f70129c, new IntentFilter("chat-pay-broadcast-receiver-callback"));
                    int i2 = R.id.chat_mt_button_loader;
                    if (this.f70130d == null) {
                        this.f70130d = new HashMap();
                    }
                    View view = (View) this.f70130d.get(Integer.valueOf(i2));
                    if (view == null) {
                        view = findViewById(i2);
                        this.f70130d.put(Integer.valueOf(i2), view);
                    }
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) view);
                    a aVar = a.f70137f;
                    Activity activity = this;
                    String string = extras.getString("payeePhoneNo");
                    k.a((Object) string, "bundle.getString(\"payeePhoneNo\")");
                    String string2 = extras.getString("mode");
                    k.a((Object) string2, "bundle.getString(\"mode\")");
                    String string3 = extras.getString("contactName", (String) null);
                    String string4 = extras.getString("amount", (String) null);
                    String string5 = extras.getString(CJRQRScanResultModel.KEY_COMMENT_SMALL, "");
                    Integer valueOf = Integer.valueOf(extras.getInt("amountStatus", b.a.NONE.getType()));
                    k.c(activity, "context");
                    k.c(string, "payeePhoneNo");
                    k.c(string2, "mode");
                    a.f70134c = string;
                    a.f70135d = string4;
                    a.f70136e = string5;
                    x.a aVar2 = new x.a();
                    aVar2.element = true;
                    if (valueOf == null || valueOf.intValue() == b.a.NONE.getType() || valueOf.intValue() == b.a.NOT_FIXED.getType()) {
                        aVar2.element = true;
                    } else {
                        if (valueOf.intValue() == b.a.FIXED.getType()) {
                            aVar2.element = false;
                        }
                    }
                    Context context = activity;
                    if (com.paytm.utility.b.r(context)) {
                        Map hashMap = new HashMap();
                        String simpleName = aVar.getClass().getSimpleName();
                        k.a((Object) simpleName, "this.javaClass.simpleName");
                        hashMap.put("screen_name", simpleName);
                        net.one97.paytm.wallet.newdesign.universalp2p.a aVar3 = new net.one97.paytm.wallet.newdesign.universalp2p.a(context);
                        String b2 = aVar3.b(a.C1448a.CONSOLIDATE_PAYMENT_INST, new Object[0]);
                        k.a((Object) b2, "universalP2PRequestCompo…CONSOLIDATE_PAYMENT_INST)");
                        String a3 = p.a(b2, "v2", "v3", false);
                        Map<String, String> a4 = aVar3.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, string);
                        k.a((Object) a4, "universalP2PRequestCompo…YMENT_INST, payeePhoneNo)");
                        net.one97.paytm.network.a aVar4 = new net.one97.paytm.network.a(a3, new PaymentCombinationAPIResponse((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (g) null), hashMap, a4);
                        a.f70132a = aVar4;
                        aVar4.e();
                        net.one97.paytm.network.a aVar5 = a.f70132a;
                        if (aVar5 != null) {
                            aVar5.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "payment_combination_api_timeout")));
                        }
                        net.one97.paytm.network.a aVar6 = a.f70132a;
                        if (aVar6 != null && (a2 = aVar6.a()) != null) {
                            a2.observeForever(new a.C1414a(string3, activity, string, string4, string5, aVar2));
                            return;
                        }
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_from_fragment", false);
                    ae aeVar = ae.f69602a;
                    ae.a(activity, 401, new NetworkCustomError(), bundle2, "generic_api_call_fail");
                    return;
                }
                return;
            }
        }
        finish();
    }

    public final void onStart() {
        super.onStart();
        if (!c.a().a((Object) this)) {
            c.a().a((Object) this, true);
        }
    }

    public final void onStop() {
        super.onStop();
    }

    public final void onEvent(Bundle bundle) {
        k.c(bundle, "data");
        this.f70127a = bundle;
        Object obj = bundle.getSerializable("postpaymentscreendata") == null ? null : bundle.get("postpaymentscreendata");
        if (obj != null) {
            new Intent().putExtras(bundle);
            this.f70128b = true;
            c.a().e(bundle);
            a aVar = a.f70137f;
            a.a(this, (IJRDataModel) obj);
            return;
        }
        finish();
    }

    public final void onDestroy() {
        super.onDestroy();
        c.a().b(this);
        androidx.localbroadcastmanager.a.a.a((Context) this).a((BroadcastReceiver) this.f70129c);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Serializable serializable;
        super.onActivityResult(i2, i3, intent);
        if (!this.f70128b && ((i3 == -1 && i2 == 2001) || i2 == 2002)) {
            if (intent != null) {
                a aVar = a.f70137f;
                if (a.c()) {
                    a aVar2 = a.f70137f;
                    ChatPaymentIntegrationListener b2 = a.b();
                    if (b2 != null) {
                        Serializable serializableExtra = intent.getSerializableExtra("chat_txn_response");
                        if (serializableExtra != null) {
                            b2.onTransactionResponse((ChatPaymentIntegrationResponseModel) serializableExtra);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel");
                        }
                    }
                }
            }
            finish();
        } else if (i3 == -1 && i2 == 1) {
            if (intent != null) {
                serializable = intent.getSerializableExtra("chat_txn_response");
            } else {
                serializable = null;
            }
            if (serializable != null) {
                ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel = (ChatPaymentIntegrationResponseModel) serializable;
                a aVar3 = a.f70137f;
                if (a.c()) {
                    a aVar4 = a.f70137f;
                    ChatPaymentIntegrationListener b3 = a.b();
                    if (b3 != null) {
                        b3.onTransactionResponse(chatPaymentIntegrationResponseModel);
                    }
                }
                finish();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel");
            }
        }
        if (i3 == 0) {
            finish();
        }
    }
}
