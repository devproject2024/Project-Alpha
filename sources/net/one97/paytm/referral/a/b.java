package net.one97.paytm.referral.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.referral.model.AdditionProperty;
import net.one97.paytm.referral.model.BonusDetail;
import net.one97.paytm.referral.model.CampaignInnerReferralData;
import net.one97.paytm.referral.model.CampaignReferral;
import net.one97.paytm.referral.model.ReferralData;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ReferralData f19903a;

    /* renamed from: b  reason: collision with root package name */
    kotlin.g.a.m<? super Integer, ? super String, x> f19904b;

    /* renamed from: c  reason: collision with root package name */
    final q<Integer, CampaignReferral, String, Object> f19905c;

    /* renamed from: d  reason: collision with root package name */
    kotlin.g.a.b<? super BonusDetail, ? extends Object> f19906d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19907e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19908f = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f19909g = 2;

    /* renamed from: h  reason: collision with root package name */
    private Context f19910h;

    public b(Context context, ReferralData referralData, kotlin.g.a.m<? super Integer, ? super String, x> mVar, q<? super Integer, ? super CampaignReferral, ? super String, ? extends Object> qVar, kotlin.g.a.b<? super BonusDetail, ? extends Object> bVar) {
        ArrayList<CampaignReferral> campaigns;
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(mVar, "getEvent");
        kotlin.g.b.k.c(qVar, "campainDetailFlow");
        kotlin.g.b.k.c(bVar, "bottomSheetEvent");
        this.f19910h = context;
        this.f19903a = referralData;
        this.f19904b = mVar;
        this.f19905c = qVar;
        this.f19906d = bVar;
        ReferralData referralData2 = this.f19903a;
        if (referralData2 != null && (campaigns = referralData2.getCampaigns()) != null && campaigns.size() > 1) {
            campaigns.add(1, new CampaignReferral("", (CampaignInnerReferralData) null, 2, (kotlin.g.b.g) null));
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        kotlin.g.b.k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == this.f19907e) {
            View inflate = from.inflate(R.layout.item_referral_top, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate, "inflater.inflate(R.layou…erral_top, parent, false)");
            return new c(this, inflate);
        } else if (i2 == this.f19909g) {
            View inflate2 = from.inflate(R.layout.item_referral_offers, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate2, "inflater.inflate(R.layou…al_offers, parent, false)");
            return new C0351b(this, inflate2);
        } else {
            View inflate3 = from.inflate(R.layout.item_referral_heading, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate3, "inflater.inflate(R.layou…l_heading, parent, false)");
            return new a(this, inflate3);
        }
    }

    public final int getItemCount() {
        ArrayList<CampaignReferral> campaigns;
        ReferralData referralData = this.f19903a;
        if (referralData == null || (campaigns = referralData.getCampaigns()) == null) {
            return 0;
        }
        return campaigns.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ArrayList<CampaignReferral> campaigns;
        ArrayList<CampaignReferral> campaigns2;
        HashMap<String, AdditionProperty> referral_links;
        ArrayList<BonusDetail> bonus_detail;
        kotlin.g.b.k.c(vVar, "holder");
        if (i2 == this.f19907e) {
            if (vVar != null) {
                c cVar = (c) vVar;
                ImageView imageView = cVar.f19927i;
                net.one97.paytm.referral.c.c cVar2 = net.one97.paytm.referral.c.c.f20029a;
                int i3 = 8;
                imageView.setVisibility(net.one97.paytm.referral.c.c.b("com.twitter.android", this.f19910h) ? 0 : 8);
                ImageView imageView2 = cVar.f19925g;
                net.one97.paytm.referral.c.c cVar3 = net.one97.paytm.referral.c.c.f20029a;
                imageView2.setVisibility(net.one97.paytm.referral.c.c.b(AppConstants.WHATS_APP, this.f19910h) ? 0 : 8);
                ReferralData referralData = this.f19903a;
                boolean z = true;
                if (referralData == null || (bonus_detail = referralData.getBonus_detail()) == null) {
                    RelativeLayout relativeLayout = cVar.f19922d;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                } else if (!bonus_detail.isEmpty()) {
                    BonusDetail bonusDetail = bonus_detail.get(0);
                    kotlin.g.b.k.a((Object) bonusDetail, "it[0]");
                    BonusDetail bonusDetail2 = bonusDetail;
                    Integer total_bonus = bonusDetail2.getTotal_bonus();
                    if (total_bonus != null && total_bonus.intValue() == 0) {
                        RelativeLayout relativeLayout2 = cVar.f19922d;
                        if (relativeLayout2 != null) {
                            relativeLayout2.setVisibility(8);
                        }
                    } else {
                        CharSequence bonus_tile_icon = bonusDetail2.getBonus_tile_icon();
                        if (!(bonus_tile_icon == null || bonus_tile_icon.length() == 0)) {
                            w.a().a(bonusDetail2.getBonus_tile_icon()).a(cVar.f19921c);
                        }
                        TextView textView = cVar.f19924f;
                        if (textView != null) {
                            textView.setText(bonusDetail2.getBonus_tile_title());
                        }
                        RelativeLayout relativeLayout3 = cVar.f19922d;
                        if (relativeLayout3 != null) {
                            relativeLayout3.setVisibility(0);
                        }
                        cVar.f19923e.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + bonusDetail2.getTotal_bonus());
                        cVar.m.setOnClickListener(new e(bonusDetail2, this, cVar));
                        cVar.f19922d.setOnClickListener(new g(bonusDetail2, this, cVar));
                    }
                } else {
                    RelativeLayout relativeLayout4 = cVar.f19922d;
                    if (relativeLayout4 != null) {
                        relativeLayout4.setVisibility(8);
                    }
                }
                ReferralData referralData2 = this.f19903a;
                if (referralData2 != null && (campaigns2 = referralData2.getCampaigns()) != null) {
                    CampaignReferral campaignReferral = campaigns2.get(i2);
                    kotlin.g.b.k.a((Object) campaignReferral, "it[position]");
                    CampaignReferral campaignReferral2 = campaignReferral;
                    if (campaigns2.size() > 1) {
                        cVar.p.setBackgroundColor(androidx.core.content.b.c(this.f19910h, R.color.color_0f00aced));
                    }
                    kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
                    CharSequence T = net.one97.paytm.vipcashback.f.f.T();
                    if (!(T == null || p.a(T))) {
                        w a2 = w.a();
                        kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
                        a2.a(net.one97.paytm.vipcashback.f.f.T()).a(cVar.o);
                    }
                    String generatedUrl = campaignReferral2.getGeneratedUrl();
                    String str = null;
                    if (generatedUrl != null) {
                        RelativeLayout relativeLayout5 = cVar.n;
                        CharSequence charSequence = generatedUrl;
                        if (charSequence.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            i3 = 0;
                        }
                        relativeLayout5.setVisibility(i3);
                        cVar.k.setText(charSequence);
                    } else {
                        String campaign = campaignReferral2.getCampaign();
                        if (campaign != null) {
                            ReferralData referralData3 = this.f19903a;
                            AdditionProperty additionProperty = (referralData3 == null || (referral_links = referralData3.getReferral_links()) == null) ? null : referral_links.get(campaign);
                            if (additionProperty != null) {
                                CharSequence link = additionProperty.getLink();
                                if (!(link == null || link.length() == 0)) {
                                    z = false;
                                }
                                if (!z) {
                                    kotlin.g.a.m<? super Integer, ? super String, x> mVar = this.f19904b;
                                    String link2 = additionProperty.getLink();
                                    if (link2 == null) {
                                        link2 = "";
                                    }
                                    mVar.invoke(1000, link2);
                                }
                            }
                            cVar.n.setVisibility(8);
                        }
                    }
                    String offerTextOverride = campaignReferral2.getOfferTextOverride();
                    if (offerTextOverride != null) {
                        cVar.f19920b.setText(offerTextOverride);
                    }
                    String string = this.f19910h.getString(R.string.know_more);
                    String shortDescription = campaignReferral2.getShortDescription();
                    if (shortDescription != null) {
                        str = shortDescription + " ";
                    }
                    SpannableString spannableString = new SpannableString(kotlin.g.b.k.a(str, (Object) string));
                    int i4 = i2;
                    RecyclerView.v vVar2 = vVar;
                    c cVar4 = cVar;
                    spannableString.setSpan(new h(campaignReferral2, this, i4, vVar2, cVar4), spannableString.length() - string.length(), spannableString.length(), 33);
                    cVar.f19919a.setText(spannableString);
                    cVar.f19919a.setMovementMethod(LinkMovementMethod.getInstance());
                    CampaignReferral campaignReferral3 = campaignReferral2;
                    cVar.j.setOnClickListener(new i(campaignReferral3, this, i4, vVar2, cVar4));
                    cVar.f19927i.setOnClickListener(new j(campaignReferral3, this, i4, vVar2, cVar4));
                    cVar.f19926h.setOnClickListener(new k(campaignReferral3, this, i4, vVar2, cVar4));
                    cVar.f19925g.setOnClickListener(new l(campaignReferral3, this, i4, vVar2, cVar4));
                    cVar.l.setOnClickListener(new m(campaignReferral3, this, i4, vVar2, cVar4));
                    cVar.n.setOnClickListener(new n(campaignReferral3, this, i4, vVar2, cVar4));
                    cVar.q.setOnClickListener(new f(campaignReferral3, this, i4, vVar2, cVar4));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.referral.adapter.ReferralAdapter.TopViewHolder");
        } else if (i2 != this.f19908f) {
            ReferralData referralData4 = this.f19903a;
            if (referralData4 != null && (campaigns = referralData4.getCampaigns()) != null) {
                CampaignReferral campaignReferral4 = campaigns.get(i2);
                kotlin.g.b.k.a((Object) campaignReferral4, "it[position]");
                CampaignReferral campaignReferral5 = campaignReferral4;
                if (vVar != null) {
                    C0351b bVar = (C0351b) vVar;
                    if (campaignReferral5.getNewOffersImageUrl() != null) {
                        w.a().a(campaignReferral5.getNewOffersImageUrl()).a(bVar.f19915c);
                    }
                    if (campaignReferral5.getBackgroundImageUrl() != null) {
                        w.a().a(campaignReferral5.getBackgroundImageUrl()).a(bVar.f19917e);
                    }
                    bVar.f19914b.setText(campaignReferral5.getShortDescription());
                    bVar.f19913a.setText(campaignReferral5.getOfferTextOverride());
                    bVar.f19916d.setOnClickListener(new d(this, i2, vVar));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.referral.adapter.ReferralAdapter.OfferViewHolder");
            }
        } else if (vVar == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.referral.adapter.ReferralAdapter.HeaderViewHolder");
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BonusDetail f19931a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19932b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f19933c;

        e(BonusDetail bonusDetail, b bVar, c cVar) {
            this.f19931a = bonusDetail;
            this.f19932b = bVar;
            this.f19933c = cVar;
        }

        public final void onClick(View view) {
            this.f19932b.f19906d.invoke(this.f19931a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BonusDetail f19939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19940b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f19941c;

        g(BonusDetail bonusDetail, b bVar, c cVar) {
            this.f19939a = bonusDetail;
            this.f19940b = bVar;
            this.f19941c = cVar;
        }

        public final void onClick(View view) {
            this.f19940b.f19906d.invoke(this.f19939a);
        }
    }

    public static final class h extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19942a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19943b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19944c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19945d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19946e;

        h(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19942a = campaignReferral;
            this.f19943b = bVar;
            this.f19944c = i2;
            this.f19945d = vVar;
            this.f19946e = cVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "textView");
            String tnc = this.f19942a.getTnc();
            if (tnc != null) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a(view);
                this.f19943b.f19904b.invoke(6, tnc);
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19947a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19948b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19949c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19950d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19951e;

        i(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19947a = campaignReferral;
            this.f19948b = bVar;
            this.f19949c = i2;
            this.f19950d = vVar;
            this.f19951e = cVar;
        }

        public final void onClick(View view) {
            HashMap<String, AdditionProperty> referral_links;
            CharSequence generatedUrl = this.f19947a.getGeneratedUrl();
            if (generatedUrl == null || p.a(generatedUrl)) {
                String campaign = this.f19947a.getCampaign();
                if (campaign != null) {
                    ReferralData referralData = this.f19948b.f19903a;
                    AdditionProperty additionProperty = (referralData == null || (referral_links = referralData.getReferral_links()) == null) ? null : referral_links.get(campaign);
                    if (additionProperty != null && additionProperty.getLink() != null) {
                        kotlin.g.a.m<? super Integer, ? super String, x> mVar = this.f19948b.f19904b;
                        String link = additionProperty.getLink();
                        if (link == null) {
                            link = "";
                        }
                        mVar.invoke(1000, link);
                        return;
                    }
                    return;
                }
                return;
            }
            String generatedUrl2 = this.f19947a.getGeneratedUrl();
            if (generatedUrl2 != null) {
                this.f19948b.f19904b.invoke(4, generatedUrl2);
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19952a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19953b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19954c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19955d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19956e;

        j(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19952a = campaignReferral;
            this.f19953b = bVar;
            this.f19954c = i2;
            this.f19955d = vVar;
            this.f19956e = cVar;
        }

        public final void onClick(View view) {
            HashMap<String, AdditionProperty> referral_links;
            CharSequence generatedUrl = this.f19952a.getGeneratedUrl();
            if (generatedUrl == null || p.a(generatedUrl)) {
                String campaign = this.f19952a.getCampaign();
                if (campaign != null) {
                    ReferralData referralData = this.f19953b.f19903a;
                    AdditionProperty additionProperty = (referralData == null || (referral_links = referralData.getReferral_links()) == null) ? null : referral_links.get(campaign);
                    if (additionProperty != null && additionProperty.getLink() != null) {
                        kotlin.g.a.m<? super Integer, ? super String, x> mVar = this.f19953b.f19904b;
                        String link = additionProperty.getLink();
                        if (link == null) {
                            link = "";
                        }
                        mVar.invoke(1000, link);
                        return;
                    }
                    return;
                }
                return;
            }
            String generatedUrl2 = this.f19952a.getGeneratedUrl();
            if (generatedUrl2 != null) {
                this.f19953b.f19904b.invoke(1, generatedUrl2);
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19957a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19958b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19959c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19960d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19961e;

        k(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19957a = campaignReferral;
            this.f19958b = bVar;
            this.f19959c = i2;
            this.f19960d = vVar;
            this.f19961e = cVar;
        }

        public final void onClick(View view) {
            HashMap<String, AdditionProperty> referral_links;
            CharSequence generatedUrl = this.f19957a.getGeneratedUrl();
            if (generatedUrl == null || p.a(generatedUrl)) {
                String campaign = this.f19957a.getCampaign();
                if (campaign != null) {
                    ReferralData referralData = this.f19958b.f19903a;
                    AdditionProperty additionProperty = (referralData == null || (referral_links = referralData.getReferral_links()) == null) ? null : referral_links.get(campaign);
                    if (additionProperty != null && additionProperty.getLink() != null) {
                        kotlin.g.a.m<? super Integer, ? super String, x> mVar = this.f19958b.f19904b;
                        String link = additionProperty.getLink();
                        if (link == null) {
                            link = "";
                        }
                        mVar.invoke(1000, link);
                        return;
                    }
                    return;
                }
                return;
            }
            String generatedUrl2 = this.f19957a.getGeneratedUrl();
            if (generatedUrl2 != null) {
                this.f19958b.f19904b.invoke(2, generatedUrl2);
            }
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19962a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19963b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19964c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19965d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19966e;

        l(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19962a = campaignReferral;
            this.f19963b = bVar;
            this.f19964c = i2;
            this.f19965d = vVar;
            this.f19966e = cVar;
        }

        public final void onClick(View view) {
            HashMap<String, AdditionProperty> referral_links;
            CharSequence generatedUrl = this.f19962a.getGeneratedUrl();
            if (generatedUrl == null || p.a(generatedUrl)) {
                String campaign = this.f19962a.getCampaign();
                if (campaign != null) {
                    ReferralData referralData = this.f19963b.f19903a;
                    AdditionProperty additionProperty = (referralData == null || (referral_links = referralData.getReferral_links()) == null) ? null : referral_links.get(campaign);
                    if (additionProperty != null && additionProperty.getLink() != null) {
                        kotlin.g.a.m<? super Integer, ? super String, x> mVar = this.f19963b.f19904b;
                        String link = additionProperty.getLink();
                        if (link == null) {
                            link = "";
                        }
                        mVar.invoke(1000, link);
                        return;
                    }
                    return;
                }
                return;
            }
            String generatedUrl2 = this.f19962a.getGeneratedUrl();
            if (generatedUrl2 != null) {
                this.f19963b.f19904b.invoke(3, generatedUrl2);
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19968b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19969c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19970d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19971e;

        m(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19967a = campaignReferral;
            this.f19968b = bVar;
            this.f19969c = i2;
            this.f19970d = vVar;
            this.f19971e = cVar;
        }

        public final void onClick(View view) {
            String generatedUrl = this.f19967a.getGeneratedUrl();
            if (generatedUrl != null) {
                this.f19968b.f19904b.invoke(5, generatedUrl);
            }
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19973b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19974c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19975d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19976e;

        n(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19972a = campaignReferral;
            this.f19973b = bVar;
            this.f19974c = i2;
            this.f19975d = vVar;
            this.f19976e = cVar;
        }

        public final void onClick(View view) {
            String generatedUrl = this.f19972a.getGeneratedUrl();
            if (generatedUrl != null) {
                this.f19973b.f19904b.invoke(5, generatedUrl);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CampaignReferral f19934a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f19935b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19936c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19937d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f19938e;

        f(CampaignReferral campaignReferral, b bVar, int i2, RecyclerView.v vVar, c cVar) {
            this.f19934a = campaignReferral;
            this.f19935b = bVar;
            this.f19936c = i2;
            this.f19937d = vVar;
            this.f19938e = cVar;
        }

        public final void onClick(View view) {
            String generatedUrl = this.f19934a.getGeneratedUrl();
            if (generatedUrl != null) {
                this.f19935b.f19904b.invoke(5, generatedUrl);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19928a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19929b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f19930c;

        d(b bVar, int i2, RecyclerView.v vVar) {
            this.f19928a = bVar;
            this.f19929b = i2;
            this.f19930c = vVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
            r1 = r1.getReferral_links();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r5) {
            /*
                r4 = this;
                net.one97.paytm.referral.a.b r5 = r4.f19928a
                net.one97.paytm.referral.model.ReferralData r5 = r5.f19903a
                if (r5 == 0) goto L_0x0047
                java.util.ArrayList r5 = r5.getCampaigns()
                if (r5 == 0) goto L_0x0047
                int r0 = r4.f19929b
                java.lang.Object r5 = r5.get(r0)
                java.lang.String r0 = "it[position]"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
                net.one97.paytm.referral.model.CampaignReferral r5 = (net.one97.paytm.referral.model.CampaignReferral) r5
                java.lang.String r0 = r5.getCampaign()
                if (r0 == 0) goto L_0x0047
                net.one97.paytm.referral.a.b r1 = r4.f19928a
                net.one97.paytm.referral.model.ReferralData r1 = r1.f19903a
                r2 = 0
                if (r1 == 0) goto L_0x0033
                java.util.HashMap r1 = r1.getReferral_links()
                if (r1 == 0) goto L_0x0033
                java.lang.Object r0 = r1.get(r0)
                net.one97.paytm.referral.model.AdditionProperty r0 = (net.one97.paytm.referral.model.AdditionProperty) r0
                goto L_0x0034
            L_0x0033:
                r0 = r2
            L_0x0034:
                net.one97.paytm.referral.a.b r1 = r4.f19928a
                kotlin.g.a.q<java.lang.Integer, net.one97.paytm.referral.model.CampaignReferral, java.lang.String, java.lang.Object> r1 = r1.f19905c
                int r3 = r4.f19929b
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                if (r0 == 0) goto L_0x0044
                java.lang.String r2 = r0.getLink()
            L_0x0044:
                r1.invoke(r3, r5, r2)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.a.b.d.onClick(android.view.View):void");
        }
    }

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return this.f19907e;
        }
        if (i2 != 1) {
            return this.f19909g;
        }
        return this.f19908f;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19911a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f19912b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.f19911a = bVar;
            View view2 = this.itemView;
            kotlin.g.b.k.a((Object) view2, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) view2.findViewById(R.id.tv_referral_sub_heading);
            kotlin.g.b.k.a((Object) appCompatTextView, "itemView.tv_referral_sub_heading");
            this.f19912b = appCompatTextView;
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f19919a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f19920b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f19921c;

        /* renamed from: d  reason: collision with root package name */
        final RelativeLayout f19922d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f19923e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f19924f;

        /* renamed from: g  reason: collision with root package name */
        final ImageView f19925g;

        /* renamed from: h  reason: collision with root package name */
        final ImageView f19926h;

        /* renamed from: i  reason: collision with root package name */
        final ImageView f19927i;
        final ImageView j;
        final TextView k;
        final ImageView l;
        final ImageView m;
        final RelativeLayout n;
        ImageView o;
        ImageView p;
        TextView q;
        final /* synthetic */ b r;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.r = bVar;
            View view2 = this.itemView;
            kotlin.g.b.k.a((Object) view2, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) view2.findViewById(R.id.tv_description);
            kotlin.g.b.k.a((Object) appCompatTextView, "itemView.tv_description");
            this.f19919a = appCompatTextView;
            View view3 = this.itemView;
            kotlin.g.b.k.a((Object) view3, "itemView");
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view3.findViewById(R.id.tv_top_heading);
            kotlin.g.b.k.a((Object) appCompatTextView2, "itemView.tv_top_heading");
            this.f19920b = appCompatTextView2;
            View view4 = this.itemView;
            kotlin.g.b.k.a((Object) view4, "itemView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view4.findViewById(R.id.cashback_image);
            kotlin.g.b.k.a((Object) appCompatImageView, "itemView.cashback_image");
            this.f19921c = appCompatImageView;
            View view5 = this.itemView;
            kotlin.g.b.k.a((Object) view5, "itemView");
            RelativeLayout relativeLayout = (RelativeLayout) view5.findViewById(R.id.cashback_layout);
            kotlin.g.b.k.a((Object) relativeLayout, "itemView.cashback_layout");
            this.f19922d = relativeLayout;
            View view6 = this.itemView;
            kotlin.g.b.k.a((Object) view6, "itemView");
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) view6.findViewById(R.id.cashback_amount);
            kotlin.g.b.k.a((Object) appCompatTextView3, "itemView.cashback_amount");
            this.f19923e = appCompatTextView3;
            View view7 = this.itemView;
            kotlin.g.b.k.a((Object) view7, "itemView");
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) view7.findViewById(R.id.cashback_text);
            kotlin.g.b.k.a((Object) appCompatTextView4, "itemView.cashback_text");
            this.f19924f = appCompatTextView4;
            View view8 = this.itemView;
            kotlin.g.b.k.a((Object) view8, "itemView");
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view8.findViewById(R.id.whatsapp_button);
            kotlin.g.b.k.a((Object) appCompatImageButton, "itemView.whatsapp_button");
            this.f19925g = appCompatImageButton;
            View view9 = this.itemView;
            kotlin.g.b.k.a((Object) view9, "itemView");
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) view9.findViewById(R.id.sms_button);
            kotlin.g.b.k.a((Object) appCompatImageButton2, "itemView.sms_button");
            this.f19926h = appCompatImageButton2;
            View view10 = this.itemView;
            kotlin.g.b.k.a((Object) view10, "itemView");
            AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) view10.findViewById(R.id.twitter_button);
            kotlin.g.b.k.a((Object) appCompatImageButton3, "itemView.twitter_button");
            this.f19927i = appCompatImageButton3;
            View view11 = this.itemView;
            kotlin.g.b.k.a((Object) view11, "itemView");
            AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) view11.findViewById(R.id.more_button);
            kotlin.g.b.k.a((Object) appCompatImageButton4, "itemView.more_button");
            this.j = appCompatImageButton4;
            View view12 = this.itemView;
            kotlin.g.b.k.a((Object) view12, "itemView");
            AppCompatTextView appCompatTextView5 = (AppCompatTextView) view12.findViewById(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView5, "itemView.invite_text");
            this.k = appCompatTextView5;
            View view13 = this.itemView;
            kotlin.g.b.k.a((Object) view13, "itemView");
            AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) view13.findViewById(R.id.copy_to_clipboard);
            kotlin.g.b.k.a((Object) appCompatImageButton5, "itemView.copy_to_clipboard");
            this.l = appCompatImageButton5;
            View view14 = this.itemView;
            kotlin.g.b.k.a((Object) view14, "itemView");
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view14.findViewById(R.id.iv_proceed_cashback);
            kotlin.g.b.k.a((Object) appCompatImageView2, "itemView.iv_proceed_cashback");
            this.m = appCompatImageView2;
            View view15 = this.itemView;
            kotlin.g.b.k.a((Object) view15, "itemView");
            RelativeLayout relativeLayout2 = (RelativeLayout) view15.findViewById(R.id.relativeLayout);
            kotlin.g.b.k.a((Object) relativeLayout2, "itemView.relativeLayout");
            this.n = relativeLayout2;
            View view16 = this.itemView;
            kotlin.g.b.k.a((Object) view16, "itemView");
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) view16.findViewById(R.id.iv_top_banner);
            kotlin.g.b.k.a((Object) appCompatImageView3, "itemView.iv_top_banner");
            this.o = appCompatImageView3;
            View view17 = this.itemView;
            kotlin.g.b.k.a((Object) view17, "itemView");
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) view17.findViewById(R.id.iv_top_background_color);
            kotlin.g.b.k.a((Object) appCompatImageView4, "itemView.iv_top_background_color");
            this.p = appCompatImageView4;
            View view18 = this.itemView;
            kotlin.g.b.k.a((Object) view18, "itemView");
            AppCompatTextView appCompatTextView6 = (AppCompatTextView) view18.findViewById(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView6, "itemView.invite_text");
            this.q = appCompatTextView6;
        }
    }

    /* renamed from: net.one97.paytm.referral.a.b$b  reason: collision with other inner class name */
    public final class C0351b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f19913a;

        /* renamed from: b  reason: collision with root package name */
        TextView f19914b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f19915c;

        /* renamed from: d  reason: collision with root package name */
        Button f19916d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f19917e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ b f19918f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0351b(b bVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            this.f19918f = bVar;
            View view2 = this.itemView;
            kotlin.g.b.k.a((Object) view2, "itemView");
            TextView textView = (TextView) view2.findViewById(R.id.title);
            kotlin.g.b.k.a((Object) textView, "itemView.title");
            this.f19913a = textView;
            View view3 = this.itemView;
            kotlin.g.b.k.a((Object) view3, "itemView");
            TextView textView2 = (TextView) view3.findViewById(R.id.description);
            kotlin.g.b.k.a((Object) textView2, "itemView.description");
            this.f19914b = textView2;
            View view4 = this.itemView;
            kotlin.g.b.k.a((Object) view4, "itemView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view4.findViewById(R.id.image);
            kotlin.g.b.k.a((Object) appCompatImageView, "itemView.image");
            this.f19915c = appCompatImageView;
            View view5 = this.itemView;
            kotlin.g.b.k.a((Object) view5, "itemView");
            AppCompatButton appCompatButton = (AppCompatButton) view5.findViewById(R.id.invite_button);
            kotlin.g.b.k.a((Object) appCompatButton, "itemView.invite_button");
            this.f19916d = appCompatButton;
            View view6 = this.itemView;
            kotlin.g.b.k.a((Object) view6, "itemView");
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view6.findViewById(R.id.background_image);
            kotlin.g.b.k.a((Object) appCompatImageView2, "itemView.background_image");
            this.f19917e = appCompatImageView2;
        }
    }
}
