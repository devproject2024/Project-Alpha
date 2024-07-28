package net.one97.paytm.wallet.newdesign.postcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.webkit.URLUtil;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.entity.CJRPostcardFetchEvent;
import net.one97.paytm.common.entity.CJRPostcardFetchInitiatorList;
import net.one97.paytm.common.entity.CJRPostcardFetchRecipientList;
import net.one97.paytm.common.entity.CJRPostcardSentFetchEvent;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.a;
import net.one97.paytm.wallet.newdesign.postcard.b.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MyPostcardsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f71144a;

    /* renamed from: b  reason: collision with root package name */
    private TabLayout f71145b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRPostcardFetchInitiatorList> f71146c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRPostcardFetchRecipientList> f71147e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private a f71148f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f71149g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f71150h = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.my_postcards_activity);
        setTitle(R.string.my_postcard);
        this.f71145b = (TabLayout) findViewById(R.id.tabs);
        TabLayout tabLayout = this.f71145b;
        tabLayout.a(tabLayout.a().a((CharSequence) "Received"));
        TabLayout tabLayout2 = this.f71145b;
        tabLayout2.a(tabLayout2.a().a((CharSequence) "Sent"));
        this.f71144a = (ViewPager) findViewById(R.id.mypostcards_pager);
        this.f71144a.setAdapter(this.f71148f);
        this.f71145b.setupWithViewPager(this.f71144a);
        a(true);
        a(false);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRPostcardFetchEvent) {
            CJRPostcardFetchEvent cJRPostcardFetchEvent = (CJRPostcardFetchEvent) iJRPaytmDataModel;
            if (!(cJRPostcardFetchEvent.getResponse() == null || cJRPostcardFetchEvent.getResponse().getRecipientList() == null)) {
                this.f71147e = cJRPostcardFetchEvent.getResponse().getRecipientList();
            }
            a aVar = this.f71148f;
            if (aVar != null && aVar.getItem(0) != null) {
                ((b) this.f71148f.getItem(0)).a(false);
                ((b) this.f71148f.getItem(0)).a(this.f71147e);
                ArrayList<CJRPostcardFetchRecipientList> arrayList = this.f71147e;
                if (arrayList == null || arrayList.size() == 0) {
                    ((b) this.f71148f.getItem(0)).b(true);
                } else {
                    ((b) this.f71148f.getItem(0)).b(false);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRPostcardSentFetchEvent) {
            CJRPostcardSentFetchEvent cJRPostcardSentFetchEvent = (CJRPostcardSentFetchEvent) iJRPaytmDataModel;
            if (!(cJRPostcardSentFetchEvent == null || cJRPostcardSentFetchEvent.getResponse() == null || cJRPostcardSentFetchEvent.getResponse().getInitiatorList() == null)) {
                this.f71146c = cJRPostcardSentFetchEvent.getResponse().getInitiatorList();
            }
            a aVar2 = this.f71148f;
            if (aVar2 != null && aVar2.getItem(1) != null) {
                ((a) this.f71148f.getItem(1)).b(false);
                ((a) this.f71148f.getItem(1)).a(this.f71146c);
                ArrayList<CJRPostcardFetchInitiatorList> arrayList2 = this.f71146c;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    ((a) this.f71148f.getItem(1)).a(true);
                } else {
                    ((a) this.f71148f.getItem(1)).a(false);
                }
            }
        }
    }

    private void a(boolean z) {
        net.one97.paytm.network.b bVar;
        try {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "postCardEventFetchURL");
            if (URLUtil.isValidUrl(stringFromGTM)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventType", "POSTCARD");
                if (z) {
                    jSONObject2.put(StringSet.role, "RECIPIENT");
                } else {
                    jSONObject2.put(StringSet.role, "INITIATOR");
                }
                jSONObject2.put("startOffset", 0);
                jSONObject2.put("limit", 100);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "192.168.40.11");
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this));
                hashMap.put("Content-Type", "application/json");
                if (z) {
                    bVar = new net.one97.paytm.network.b(stringFromGTM, new CJRPostcardFetchEvent(), (Map<String, String>) null, hashMap, jSONObject.toString());
                } else {
                    bVar = new net.one97.paytm.network.b(stringFromGTM, new CJRPostcardSentFetchEvent(), (Map<String, String>) null, hashMap, jSONObject.toString());
                }
                if (performRequestOrShowNetworkDialog(bVar) == null) {
                    return;
                }
                if (z) {
                    bVar.c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            MyPostcardsActivity.this.b((f) obj);
                        }
                    });
                } else {
                    bVar.c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            MyPostcardsActivity.this.a((f) obj);
                        }
                    });
                }
            }
        } catch (JSONException unused) {
        }
    }

    private void a(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && !isFinishing()) {
            if ((!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, networkCustomError, (String) null, (Bundle) null, false);
            } else if (networkCustomError.getMessage() != null && !net.one97.paytm.wallet.communicator.b.a().checkErrorCode(this, networkCustomError)) {
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getString(R.string.network_error_message));
                sb.append(" ");
                sb.append(networkCustomError.getUrl());
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    return;
                }
                String url = networkCustomError.getUrl();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(networkCustomError.getStatusCode());
                com.paytm.utility.b.d((Context) this, url, sb2.toString());
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1007) {
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }
}
