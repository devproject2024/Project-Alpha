package net.one97.paytm.v2.features.offerdetail.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.cashback.posttxn.InfoV4;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseNewOfferDetailV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseTNCModal;
import net.one97.paytm.common.entity.vipcashback.CashBackGameDetailV4;
import net.one97.paytm.common.entity.vipcashback.CashBackTnCModal;
import net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.v2.features.offerdetail.b.b f20450a;

    /* renamed from: b  reason: collision with root package name */
    public y<NetworkCustomError> f20451b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<com.paytm.network.a> f20452c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<h<Object>> f20453d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<GameOfferDetailModel> f20454e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    y<Boolean> f20455f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<String> f20456g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<h<Object>> f20457h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<String> f20458i = ((y) ah.a(this.f20453d, new C0371a(this)));
    public y<GameOfferDetailModel> j = ((y) ah.a(this.f20457h, new b(this)));
    /* access modifiers changed from: private */
    public GameOfferDetailModel k = new GameOfferDetailModel();
    /* access modifiers changed from: private */
    public String l = new String();
    private y<Boolean> m = new y<>();
    private VIPCashBackOfferV4 n;
    private Campaign o;

    /* renamed from: net.one97.paytm.v2.features.offerdetail.c.a$a  reason: collision with other inner class name */
    static final class C0371a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20459a;

        C0371a(a aVar) {
            this.f20459a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            switch (hVar.f20893a) {
                case 101:
                    T t = hVar.f20894b;
                    if (t instanceof CashBackBaseMyOfferModalV4) {
                        a aVar = this.f20459a;
                        CashBackBaseMyOfferModalV4 cashBackBaseMyOfferModalV4 = (CashBackBaseMyOfferModalV4) t;
                        k.c(cashBackBaseMyOfferModalV4, Payload.RESPONSE);
                        String str = new String();
                        if (cashBackBaseMyOfferModalV4.getStatus() == 1 && cashBackBaseMyOfferModalV4.getData() != null) {
                            a.i.C0390a aVar2 = a.i.f20808a;
                            str = a.i.f20812e;
                            VIPCashBackOfferV4 data = cashBackBaseMyOfferModalV4.getData();
                            k.a((Object) data, "response.data");
                            aVar.a(data);
                        } else if (cashBackBaseMyOfferModalV4.getErrors() != null && cashBackBaseMyOfferModalV4.getErrors().size() > 0) {
                            a.i.C0390a aVar3 = a.i.f20808a;
                            str = a.i.f20813f;
                            y<NetworkCustomError> yVar = aVar.f20451b;
                            d.a aVar4 = d.f20859a;
                            GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackBaseMyOfferModalV4.getErrors().get(0);
                            k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                            yVar.setValue(d.a.a(getVIPCashBackErrorModal));
                        }
                        aVar.l = str;
                    }
                    if (t instanceof CashBackBaseTNCModal) {
                        y<String> yVar2 = this.f20459a.f20456g;
                        CashBackTnCModal data2 = ((CashBackBaseTNCModal) t).getData();
                        k.a((Object) data2, "response.data");
                        yVar2.setValue(data2.getTerms());
                        break;
                    }
                    break;
                case 102:
                    if (hVar.f20894b instanceof CashBackBaseTNCModal) {
                        y b2 = this.f20459a.f20451b;
                        Throwable th = hVar.f20895c;
                        if (th != null) {
                            b2.setValue((NetworkCustomError) th);
                        } else {
                            throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                        }
                    }
                    a aVar5 = this.f20459a;
                    a.i.C0390a aVar6 = a.i.f20808a;
                    aVar5.l = a.i.f20813f;
                    break;
                case 103:
                    a aVar7 = this.f20459a;
                    a.i.C0390a aVar8 = a.i.f20808a;
                    aVar7.l = a.i.f20811d;
                    break;
                case 104:
                    y c2 = this.f20459a.f20452c;
                    T t2 = hVar.f20894b;
                    if (t2 != null) {
                        c2.setValue((com.paytm.network.a) t2);
                        a aVar9 = this.f20459a;
                        a.i.C0390a aVar10 = a.i.f20808a;
                        aVar9.l = a.i.f20813f;
                        break;
                    } else {
                        throw new u("null cannot be cast to non-null type com.paytm.network.CJRCommonNetworkCall");
                    }
            }
            return this.f20459a.l;
        }
    }

    static final class b<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20460a;

        b(a aVar) {
            this.f20460a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            int i2 = hVar.f20893a;
            if (i2 == 101) {
                T t = hVar.f20894b;
                if (t instanceof CashBackBaseNewOfferDetailV4) {
                    CashBackBaseNewOfferDetailV4 cashBackBaseNewOfferDetailV4 = (CashBackBaseNewOfferDetailV4) t;
                    if (cashBackBaseNewOfferDetailV4.getData() != null) {
                        a aVar = this.f20460a;
                        k.c(cashBackBaseNewOfferDetailV4, Payload.RESPONSE);
                        if (cashBackBaseNewOfferDetailV4.getData() != null && cashBackBaseNewOfferDetailV4.getData().campaign != null) {
                            y<GameOfferDetailModel> yVar = aVar.f20454e;
                            Campaign campaign = cashBackBaseNewOfferDetailV4.getData().campaign;
                            k.a((Object) campaign, "response.data.campaign");
                            yVar.setValue(aVar.b(campaign));
                        } else if (!(cashBackBaseNewOfferDetailV4.getData() == null || cashBackBaseNewOfferDetailV4.getData().supercashGame == null)) {
                            y<GameOfferDetailModel> yVar2 = aVar.f20454e;
                            VIPCashBackOfferV4 vIPCashBackOfferV4 = cashBackBaseNewOfferDetailV4.getData().supercashGame;
                            k.a((Object) vIPCashBackOfferV4, "response.data.supercashGame");
                            yVar2.setValue(aVar.b(vIPCashBackOfferV4));
                        }
                    } else {
                        this.f20460a.f20455f.setValue(Boolean.TRUE);
                    }
                } else if (t instanceof CashBackGameDetailV4) {
                    CashBackGameDetailV4 cashBackGameDetailV4 = (CashBackGameDetailV4) t;
                    if (cashBackGameDetailV4.getData() != null) {
                        y<GameOfferDetailModel> yVar3 = this.f20460a.f20454e;
                        a aVar2 = this.f20460a;
                        VIPCashBackOfferV4 data = cashBackGameDetailV4.getData();
                        k.a((Object) data, "response.data");
                        yVar3.setValue(aVar2.b(data));
                    } else {
                        this.f20460a.f20455f.setValue(Boolean.TRUE);
                    }
                }
            } else if (i2 == 102) {
                y b2 = this.f20460a.f20451b;
                Throwable th = hVar.f20895c;
                if (th != null) {
                    b2.setValue((NetworkCustomError) th);
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            } else if (i2 == 104) {
                y c2 = this.f20460a.f20452c;
                T t2 = hVar.f20894b;
                if (t2 != null) {
                    c2.setValue((com.paytm.network.a) t2);
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.CJRCommonNetworkCall");
                }
            }
            return this.f20460a.k;
        }
    }

    public final void a(String str) {
        k.c(str, "gameCampaignId");
        net.one97.paytm.v2.features.offerdetail.b.b bVar = this.f20450a;
        if (bVar == null) {
            k.a("repository");
        }
        bVar.c(this.f20457h, str);
    }

    public final void a(Campaign campaign) {
        k.c(campaign, "data");
        this.f20454e.setValue(b(campaign));
    }

    public final void a(VIPCashBackOfferV4 vIPCashBackOfferV4) {
        k.c(vIPCashBackOfferV4, "data");
        this.f20454e.setValue(b(vIPCashBackOfferV4));
    }

    public final void a() {
        String str;
        String id;
        InfoV4 info;
        Campaign campaign;
        net.one97.paytm.v2.features.offerdetail.b.b bVar = this.f20450a;
        if (bVar == null) {
            k.a("repository");
        }
        y<h<Object>> yVar = this.f20453d;
        Campaign campaign2 = this.o;
        String str2 = null;
        if ((campaign2 != null ? Integer.valueOf(campaign2.getId()) : null) != null) {
            Campaign campaign3 = this.o;
            Integer valueOf = campaign3 != null ? Integer.valueOf(campaign3.getId()) : null;
            if (valueOf == null) {
                k.a();
            }
            str = String.valueOf(valueOf.intValue());
        } else {
            VIPCashBackOfferV4 vIPCashBackOfferV4 = this.n;
            if (vIPCashBackOfferV4 == null || (info = vIPCashBackOfferV4.getInfo()) == null || (campaign = info.getCampaign()) == null || (str = String.valueOf(campaign.getId())) == null) {
                str = "";
            }
        }
        VIPCashBackOfferV4 vIPCashBackOfferV42 = this.n;
        if (!(vIPCashBackOfferV42 == null || (id = vIPCashBackOfferV42.getId()) == null)) {
            str2 = id.toString();
        }
        bVar.a(yVar, str, str2, "ACCEPT_OFFER");
    }

    public final LiveData<Object> b() {
        y yVar;
        if (this.n != null) {
            yVar = new y();
            yVar.setValue(this.n);
        } else if (this.o != null) {
            yVar = new y();
            yVar.setValue(this.o);
        } else {
            yVar = null;
        }
        return yVar;
    }

    public final GameOfferDetailModel b(Campaign campaign) {
        k.c(campaign, Payload.RESPONSE);
        this.o = campaign;
        GameOfferDetailModel gameOfferDetailModel = new GameOfferDetailModel();
        gameOfferDetailModel.backgroundImageUrl = campaign.getBackgroundImageUrl();
        gameOfferDetailModel.thumbnail = campaign.getNewOffersImageUrl();
        String offerKeyword = campaign.getOfferKeyword();
        k.a((Object) offerKeyword, "response.offerKeyword");
        gameOfferDetailModel.title = p.f(p.a(offerKeyword, "%s", "", false));
        gameOfferDetailModel.cashbackText = campaign.getOfferTextOverride();
        gameOfferDetailModel.cashbackDescription = campaign.getShortDescription();
        gameOfferDetailModel.ctaLink = campaign.getDeeplinkUrl();
        gameOfferDetailModel.ctaText = campaign.getProgressScreenCta();
        gameOfferDetailModel.tnc = campaign.getTnc();
        gameOfferDetailModel.autoActivate = campaign.isAutoActivate();
        gameOfferDetailModel.validityText = campaign.getValidUpto();
        gameOfferDetailModel.isGameCampaign = false;
        Boolean deepLink = campaign.getDeepLink();
        k.a((Object) deepLink, "response.deepLink");
        gameOfferDetailModel.showCTA = deepLink.booleanValue();
        gameOfferDetailModel.mCampaignId = String.valueOf(campaign.getId());
        this.m.setValue(Boolean.TRUE);
        return gameOfferDetailModel;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a7, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) java.lang.Boolean.TRUE) != false) goto L_0x01ac;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x025d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel b(net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r14) {
        /*
            r13 = this;
            java.lang.String r0 = "response"
            kotlin.g.b.k.c(r14, r0)
            r13.n = r14
            net.one97.paytm.cashback.posttxn.InfoV4 r0 = r14.getInfo()
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.util.ArrayList r0 = r0.getTransactions()
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel r2 = new net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel
            r2.<init>()
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            java.lang.String r4 = "response.info"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            java.lang.String r5 = "response.info.campaign"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getBackgroundImageUrl()
            r2.backgroundImageUrl = r3
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getNewOffersImageUrl()
            r2.thumbnail = r3
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getOfferKeyword()
            java.lang.String r6 = "response.info.campaign.offerKeyword"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            r6 = 0
            java.lang.String r7 = "%s"
            java.lang.String r8 = ""
            java.lang.String r3 = kotlin.m.p.a(r3, r7, r8, r6)
            java.lang.String r3 = kotlin.m.p.f(r3)
            r2.title = r3
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getOfferTextOverride()
            r2.cashbackText = r3
            java.lang.String r3 = r14.getStatus()
            if (r3 == 0) goto L_0x0090
            net.one97.paytm.vipcashback.d.a$i$a r7 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r7 = net.one97.paytm.vipcashback.d.a.i.j
            boolean r3 = r3.equals(r7)
            goto L_0x0091
        L_0x0090:
            r3 = 0
        L_0x0091:
            r2.isExpiredGame = r3
            boolean r3 = r2.isExpiredGame
            r7 = 1
            if (r3 == 0) goto L_0x00a4
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getGameExpiryReason()
            goto L_0x0106
        L_0x00a4:
            if (r0 == 0) goto L_0x00e7
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r3 = r3.iterator()
        L_0x00b4:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x00e3
            java.lang.Object r9 = r3.next()
            r10 = r9
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r10 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r10
            java.lang.String r11 = "it"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.lang.String r11 = r10.getStage()
            java.lang.String r12 = r14.getCurrentStage()
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x00dc
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r10 = r10.getStages()
            if (r10 == 0) goto L_0x00dc
            r10 = 1
            goto L_0x00dd
        L_0x00dc:
            r10 = 0
        L_0x00dd:
            if (r10 == 0) goto L_0x00b4
            r8.add(r9)
            goto L_0x00b4
        L_0x00e3:
            r3 = r8
            java.util.List r3 = (java.util.List) r3
            goto L_0x00e8
        L_0x00e7:
            r3 = r1
        L_0x00e8:
            if (r3 == 0) goto L_0x00ef
            int r8 = r3.size()
            goto L_0x00f0
        L_0x00ef:
            r8 = 0
        L_0x00f0:
            if (r8 <= 0) goto L_0x0108
            java.lang.Object r3 = r3.get(r6)
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r3 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r3
            if (r3 == 0) goto L_0x0105
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r3 = r3.getStages()
            if (r3 == 0) goto L_0x0105
            java.lang.String r3 = r3.getStageProgressConstruct()
            goto L_0x0106
        L_0x0105:
            r3 = r1
        L_0x0106:
            r2.cashbackDescription = r3
        L_0x0108:
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getDeeplinkUrl()
            r2.ctaLink = r3
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getProgressScreenCta()
            r2.ctaText = r3
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r3.getTnc()
            r2.tnc = r3
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            if (r3 == 0) goto L_0x0159
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            if (r3 == 0) goto L_0x0159
            int r3 = r3.getId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x015a
        L_0x0159:
            r3 = r1
        L_0x015a:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.mCampaignId = r3
            java.lang.String r3 = r14.getStatus()
            net.one97.paytm.vipcashback.d.a$i$a r8 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.i.f20810c
            boolean r3 = r3.equals(r8)
            r3 = r3 ^ r7
            r2.autoActivate = r3
            java.lang.String r3 = r14.getStatus()
            net.one97.paytm.vipcashback.d.a$i$a r8 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.i.f20810c
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x01ac
            java.lang.String r3 = r14.getStatus()
            net.one97.paytm.vipcashback.d.a$i$a r8 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.i.f20809b
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x01aa
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r14.getInfo()
            if (r3 == 0) goto L_0x01a1
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            if (r3 == 0) goto L_0x01a1
            java.lang.Boolean r1 = r3.getDeepLink()
        L_0x01a1:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x01aa
            goto L_0x01ac
        L_0x01aa:
            r1 = 0
            goto L_0x01ad
        L_0x01ac:
            r1 = 1
        L_0x01ad:
            r2.showCTA = r1
            r2.isGameCampaign = r7
            net.one97.paytm.cashback.posttxn.InfoV4 r1 = r14.getInfo()
            if (r1 == 0) goto L_0x01c1
            net.one97.paytm.cashback.posttxn.Campaign r1 = r1.getCampaign()
            if (r1 == 0) goto L_0x01c1
            boolean r6 = r1.isShowGameProgress()
        L_0x01c1:
            r2.showTimeLine = r6
            int r1 = r14.getSuccessTxnCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.doneTxnCount = r1
            int r1 = r14.getTotalTxnCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.totalTxnCount = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r0 == 0) goto L_0x0237
            java.util.Iterator r0 = r0.iterator()
        L_0x01e2:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0237
            java.lang.Object r3 = r0.next()
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r3 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r3
            java.lang.String r6 = "txn"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.String r6 = r3.getStatus()
            net.one97.paytm.vipcashback.d.a$m$a r8 = net.one97.paytm.vipcashback.d.a.m.f20832a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.m.f20834c
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 != 0) goto L_0x01e2
            java.lang.String r6 = r3.getStatus()
            net.one97.paytm.vipcashback.d.a$m$a r8 = net.one97.paytm.vipcashback.d.a.m.f20832a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.m.f20833b
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x0225
            net.one97.paytm.common.entity.vipcashback.TransactionsInfo r6 = new net.one97.paytm.common.entity.vipcashback.TransactionsInfo
            r6.<init>()
            r6.setSuccessful(r7)
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r3 = r3.getStages()
            if (r3 == 0) goto L_0x0233
            r6.setStageCompleted(r7)
            goto L_0x0233
        L_0x0225:
            net.one97.paytm.common.entity.vipcashback.TransactionsInfo r6 = new net.one97.paytm.common.entity.vipcashback.TransactionsInfo
            r6.<init>()
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r3 = r3.getStages()
            if (r3 == 0) goto L_0x0233
            r6.setStageCompleted(r7)
        L_0x0233:
            r1.add(r6)
            goto L_0x01e2
        L_0x0237:
            r2.transactionsInfos = r1
            java.lang.String r0 = r14.getGameExpiry()
            r2.validityText = r0
            net.one97.paytm.cashback.posttxn.InfoV4 r0 = r14.getInfo()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.cashback.posttxn.Campaign r0 = r0.getCampaign()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            int r0 = r0.getId()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.mCampaignId = r0
            java.lang.String r14 = r14.getId()
            if (r14 == 0) goto L_0x0263
            java.lang.String r14 = r14.toString()
            r2.mGameId = r14
        L_0x0263:
            androidx.lifecycle.y<java.lang.Boolean> r14 = r13.m
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.setValue(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.offerdetail.c.a.b(net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4):net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel");
    }
}
