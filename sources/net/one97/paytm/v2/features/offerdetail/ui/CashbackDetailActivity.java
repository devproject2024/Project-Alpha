package net.one97.paytm.v2.features.offerdetail.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class CashbackDetailActivity extends AJRCashBackBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.v2.features.offerdetail.c.a f20466a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f20467d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f20468e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f20469f;

    /* renamed from: g  reason: collision with root package name */
    private final z<String> f20470g = new a(this);

    /* renamed from: h  reason: collision with root package name */
    private HashMap f20471h;

    public final View a(int i2) {
        if (this.f20471h == null) {
            this.f20471h = new HashMap();
        }
        View view = (View) this.f20471h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20471h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20472a;

        a(CashbackDetailActivity cashbackDetailActivity) {
            this.f20472a = cashbackDetailActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            a.i.C0390a aVar = a.i.f20808a;
            if (k.a((Object) str, (Object) a.i.f20811d)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f20472a.a(R.id.activateLoader));
                if (((TextView) this.f20472a.a(R.id.ctaBtn)) != null) {
                    TextView textView = (TextView) this.f20472a.a(R.id.ctaBtn);
                    k.a((Object) textView, "ctaBtn");
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            a.i.C0390a aVar2 = a.i.f20808a;
            if (k.a((Object) str, (Object) a.i.f20812e)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20472a.a(R.id.activateLoader));
                this.f20472a.f20469f = true;
                return;
            }
            a.i.C0390a aVar3 = a.i.f20808a;
            if (k.a((Object) str, (Object) a.i.f20813f)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20472a.a(R.id.activateLoader));
                TextView textView2 = (TextView) this.f20472a.a(R.id.ctaBtn);
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
        }
    }

    static final class b<T> implements z<GameOfferDetailModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20473a;

        b(CashbackDetailActivity cashbackDetailActivity) {
            this.f20473a = cashbackDetailActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            GameOfferDetailModel gameOfferDetailModel = (GameOfferDetailModel) obj;
            if (gameOfferDetailModel != null) {
                net.one97.paytm.v2.features.offerdetail.c.a a2 = this.f20473a.f20466a;
                if (a2 != null) {
                    String str = gameOfferDetailModel.tnc;
                    k.a((Object) str, "it.tnc");
                    k.c(str, "tncUrl");
                    net.one97.paytm.v2.features.offerdetail.b.b bVar = a2.f20450a;
                    if (bVar == null) {
                        k.a("repository");
                    }
                    bVar.b(a2.f20453d, str);
                }
                CashbackDetailActivity.a(this.f20473a, gameOfferDetailModel);
            }
        }
    }

    static final class c<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20474a;

        c(CashbackDetailActivity cashbackDetailActivity) {
            this.f20474a = cashbackDetailActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            ((ShimmerFrameLayout) this.f20474a.a(R.id.tncShimmerLayout)).b();
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f20474a.a(R.id.tncShimmerLayout);
            k.a((Object) shimmerFrameLayout, "tncShimmerLayout");
            shimmerFrameLayout.setVisibility(8);
            if (Build.VERSION.SDK_INT >= 24) {
                TextView textView = (TextView) this.f20474a.a(R.id.tncText);
                k.a((Object) textView, "tncText");
                textView.setText(Html.fromHtml(str, 63));
            } else {
                TextView textView2 = (TextView) this.f20474a.a(R.id.tncText);
                k.a((Object) textView2, "tncText");
                textView2.setText(Html.fromHtml(str));
            }
            TextView textView3 = (TextView) this.f20474a.a(R.id.tncText);
            if (textView3 != null) {
                textView3.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    static final class d<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20475a;

        d(CashbackDetailActivity cashbackDetailActivity) {
            this.f20475a = cashbackDetailActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            ((ShimmerFrameLayout) this.f20475a.a(R.id.tncShimmerLayout)).b();
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f20475a.a(R.id.tncShimmerLayout);
            k.a((Object) shimmerFrameLayout, "tncShimmerLayout");
            shimmerFrameLayout.setVisibility(8);
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            k.a((Object) networkCustomError, "it");
            d.a.a(networkCustomError, (FragmentActivity) this.f20475a, Boolean.FALSE, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                final /* synthetic */ d this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.f20475a.finish();
                }
            });
        }
    }

    public final void onCreate(Bundle bundle) {
        net.one97.paytm.v2.features.offerdetail.c.a aVar;
        LiveData liveData;
        y<String> yVar;
        y<GameOfferDetailModel> yVar2;
        y<String> yVar3;
        super.onCreate(bundle);
        setContentView(R.layout.activity_cashback_offer_detail);
        ((ShimmerFrameLayout) a(R.id.tncShimmerLayout)).a();
        net.one97.paytm.v2.features.offerdetail.a.b a2 = net.one97.paytm.v2.features.offerdetail.a.a.a().a(new j(this)).a(new net.one97.paytm.v2.features.offerdetail.a.a.a(this)).a();
        this.f20466a = a2.b();
        net.one97.paytm.v2.features.offerdetail.c.a aVar2 = this.f20466a;
        if (aVar2 == null) {
            k.a();
        }
        a2.a(aVar2);
        net.one97.paytm.v2.features.offerdetail.c.a aVar3 = this.f20466a;
        if (!(aVar3 == null || (yVar3 = aVar3.f20458i) == null)) {
            yVar3.observe(this, this.f20470g);
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar4 = this.f20466a;
        if (!(aVar4 == null || (yVar2 = aVar4.f20454e) == null)) {
            yVar2.observe(this, new b(this));
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar5 = this.f20466a;
        if (!(aVar5 == null || (yVar = aVar5.f20456g) == null)) {
            yVar.observe(this, new c(this));
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar6 = this.f20466a;
        if (!(aVar6 == null || (liveData = aVar6.f20451b) == null)) {
            liveData.observe(this, new d(this));
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            Serializable serializable = null;
            if ((intent != null ? intent.getSerializableExtra("campaign") : null) != null) {
                net.one97.paytm.v2.features.offerdetail.c.a aVar7 = this.f20466a;
                if (aVar7 != null) {
                    Intent intent2 = getIntent();
                    if (intent2 != null) {
                        serializable = intent2.getSerializableExtra("campaign");
                    }
                    if (serializable != null) {
                        aVar7.a((Campaign) serializable);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.Campaign");
                }
                return;
            }
            Intent intent3 = getIntent();
            if ((intent3 != null ? intent3.getSerializableExtra("supercashGame") : null) != null && (aVar = this.f20466a) != null) {
                Intent intent4 = getIntent();
                if (intent4 != null) {
                    serializable = intent4.getSerializableExtra("supercashGame");
                }
                if (serializable != null) {
                    aVar.a((VIPCashBackOfferV4) serializable);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4");
            }
        }
    }

    public final void onBackPressed() {
        if (this.f20469f) {
            net.one97.paytm.v2.features.offerdetail.c.a aVar = this.f20466a;
            LiveData<Object> b2 = aVar != null ? aVar.b() : null;
            if (b2 != null) {
                b2.observe(this, new e(this, b2));
                return;
            }
            return;
        }
        super.onBackPressed();
        finish();
    }

    public static final class e implements z<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20476a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LiveData f20477b;

        e(CashbackDetailActivity cashbackDetailActivity, LiveData liveData) {
            this.f20476a = cashbackDetailActivity;
            this.f20477b = liveData;
        }

        public final void onChanged(Object obj) {
            Intent intent = new Intent();
            intent.putExtra("isActivated", true);
            if (obj instanceof VIPCashBackOfferV4) {
                intent.putExtra("supercashGame", (Serializable) obj);
            } else if (obj instanceof Campaign) {
                intent.putExtra("campaign", (Serializable) obj);
            }
            LiveData liveData = this.f20477b;
            if (liveData != null) {
                liveData.removeObserver(this);
            }
            this.f20476a.setResult(-1, intent);
            this.f20476a.finish();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20481a;

        g(CashbackDetailActivity cashbackDetailActivity) {
            this.f20481a = cashbackDetailActivity;
        }

        public final void onClick(View view) {
            this.f20481a.onBackPressed();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20478a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20479b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f20480c;

        f(CashbackDetailActivity cashbackDetailActivity, GameOfferDetailModel gameOfferDetailModel, x.e eVar) {
            this.f20478a = cashbackDetailActivity;
            this.f20479b = gameOfferDetailModel;
            this.f20480c = eVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20478a, "cashback_offers", "transaction_cta_clicked", (ArrayList) this.f20480c.element, (String) null, "/cashback-landing", "cashback");
            net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20478a, this.f20479b.ctaLink);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackDetailActivity f20482a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f20483b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20484c;

        h(CashbackDetailActivity cashbackDetailActivity, x.e eVar, GameOfferDetailModel gameOfferDetailModel) {
            this.f20482a = cashbackDetailActivity;
            this.f20483b = eVar;
            this.f20484c = gameOfferDetailModel;
        }

        public final void onClick(View view) {
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20482a, "cashback_offers", "activate_offers_clicked", (ArrayList) this.f20483b.element, (String) null, "/cashback-landing", "cashback");
            String str = this.f20484c.mGameId;
            boolean z = false;
            if (str != null) {
                if (str.length() > 0) {
                    CashbackDetailActivity cashbackDetailActivity = this.f20482a;
                    String str2 = this.f20484c.mGameId;
                    k.a((Object) str2, "detailData.mGameId");
                    cashbackDetailActivity.f20467d = str2;
                }
            }
            String str3 = this.f20484c.mGameId;
            if (str3 != null) {
                if (str3.length() > 0) {
                    z = true;
                }
                if (z) {
                    CashbackDetailActivity cashbackDetailActivity2 = this.f20482a;
                    String str4 = this.f20484c.mCampaignId;
                    k.a((Object) str4, "detailData.mCampaignId");
                    cashbackDetailActivity2.f20468e = str4;
                }
            }
            net.one97.paytm.v2.features.offerdetail.c.a a2 = this.f20482a.f20466a;
            if (a2 != null) {
                a2.a();
            }
        }
    }

    public static final /* synthetic */ void a(CashbackDetailActivity cashbackDetailActivity, GameOfferDetailModel gameOfferDetailModel) {
        TextView textView = (TextView) cashbackDetailActivity.a(R.id.cahsbacktext);
        k.a((Object) textView, "cahsbacktext");
        textView.setText(gameOfferDetailModel.cashbackText);
        TextView textView2 = (TextView) cashbackDetailActivity.a(R.id.cashbackdescription);
        k.a((Object) textView2, "cashbackdescription");
        textView2.setText(gameOfferDetailModel.cashbackDescription);
        String str = gameOfferDetailModel.validityText;
        boolean z = true;
        boolean z2 = false;
        if (str != null) {
            if (str.length() > 0) {
                if (gameOfferDetailModel.isExpiredGame) {
                    TextView textView3 = (TextView) cashbackDetailActivity.a(R.id.datetext);
                    k.a((Object) textView3, "datetext");
                    int i2 = R.string.cb_expired_on;
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    String str2 = gameOfferDetailModel.validityText;
                    k.a((Object) str2, "detailData.validityText");
                    textView3.setText(cashbackDetailActivity.getString(i2, new Object[]{d.a.c("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "dd MMM yyyy", str2)}));
                } else {
                    TextView textView4 = (TextView) cashbackDetailActivity.a(R.id.datetext);
                    k.a((Object) textView4, "datetext");
                    int i3 = R.string.valid_upto;
                    d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                    String str3 = gameOfferDetailModel.validityText;
                    k.a((Object) str3, "detailData.validityText");
                    textView4.setText(cashbackDetailActivity.getString(i3, new Object[]{d.a.c("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "dd MMM yyyy", str3)}));
                }
            }
        }
        ((ImageView) cashbackDetailActivity.a(R.id.back_arrow)).setOnClickListener(new g(cashbackDetailActivity));
        if (gameOfferDetailModel.showCTA) {
            String str4 = null;
            if (gameOfferDetailModel.autoActivate) {
                x.e eVar = new x.e();
                CharSequence charSequence = gameOfferDetailModel.mCampaignId;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    eVar.element = new ArrayList();
                    ((ArrayList) eVar.element).add(gameOfferDetailModel.mCampaignId);
                } else {
                    eVar.element = null;
                }
                if (gameOfferDetailModel.ctaLink != null) {
                    TextView textView5 = (TextView) cashbackDetailActivity.a(R.id.ctaBtn);
                    k.a((Object) textView5, "ctaBtn");
                    textView5.setVisibility(0);
                    String str5 = gameOfferDetailModel.ctaText;
                    if (str5 != null) {
                        if (str5.length() > 0) {
                            z2 = true;
                        }
                        if (z2) {
                            ((TextView) cashbackDetailActivity.a(R.id.ctaBtn)).setText(gameOfferDetailModel.ctaText);
                            ((TextView) cashbackDetailActivity.a(R.id.ctaBtn)).setOnClickListener(new f(cashbackDetailActivity, gameOfferDetailModel, eVar));
                            return;
                        }
                    }
                    TextView textView6 = (TextView) cashbackDetailActivity.a(R.id.ctaBtn);
                    k.a((Object) textView6, "ctaBtn");
                    textView6.setVisibility(8);
                    ((TextView) cashbackDetailActivity.a(R.id.ctaBtn)).setOnClickListener(new f(cashbackDetailActivity, gameOfferDetailModel, eVar));
                    return;
                }
                return;
            }
            x.e eVar2 = new x.e();
            CharSequence charSequence2 = gameOfferDetailModel.mCampaignId;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                eVar2.element = new ArrayList();
                ((ArrayList) eVar2.element).add(gameOfferDetailModel.mCampaignId);
            } else {
                eVar2.element = null;
            }
            TextView textView7 = (TextView) cashbackDetailActivity.a(R.id.ctaBtn);
            k.a((Object) textView7, "ctaBtn");
            textView7.setVisibility(0);
            TextView textView8 = (TextView) cashbackDetailActivity.a(R.id.ctaBtn);
            Resources resources = cashbackDetailActivity.getResources();
            if (resources != null) {
                str4 = resources.getString(R.string.activate_offer);
            }
            textView8.setText(str4);
            ((TextView) cashbackDetailActivity.a(R.id.ctaBtn)).setOnClickListener(new h(cashbackDetailActivity, eVar2, gameOfferDetailModel));
            return;
        }
        TextView textView9 = (TextView) cashbackDetailActivity.a(R.id.ctaBtn);
        k.a((Object) textView9, "ctaBtn");
        textView9.setVisibility(8);
    }
}
