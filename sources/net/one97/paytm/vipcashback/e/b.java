package net.one97.paytm.vipcashback.e;

import android.os.Handler;
import android.view.View;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.v;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseNewOffersListModal;
import net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal;
import net.one97.paytm.common.entity.vipcashback.CashBackNewOffersListModal;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CashBackNewOfferModal> f20836a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f20837b;

    /* renamed from: c  reason: collision with root package name */
    public int f20838c = 1;

    /* renamed from: d  reason: collision with root package name */
    final net.one97.paytm.vipcashback.d.a f20839d;

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.vipcashback.view.a f20840e;

    /* renamed from: f  reason: collision with root package name */
    final String f20841f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f20842g = true;

    /* renamed from: h  reason: collision with root package name */
    private final String f20843h;

    public b(net.one97.paytm.vipcashback.d.a aVar, net.one97.paytm.vipcashback.view.a aVar2, String str) {
        k.c(aVar, "mModel");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f20839d = aVar;
        this.f20840e = aVar2;
        this.f20841f = str;
        String name = b.class.getName();
        k.a((Object) name, "VIPCashBackPresenter::class.java.name");
        this.f20843h = name;
    }

    public final void a(String str, boolean z) {
        net.one97.paytm.vipcashback.view.a aVar;
        com.paytm.network.a a2 = this.f20839d.a(this, str, this.f20837b, this.f20838c, this.f20841f);
        if (com.paytm.utility.b.c(this.f20839d.f20759a)) {
            if (z && (aVar = this.f20840e) != null) {
                aVar.a();
            }
            a2.a();
            return;
        }
        net.one97.paytm.vipcashback.view.a aVar2 = this.f20840e;
        if (aVar2 != null) {
            this.f20836a.size();
            aVar2.a(a2);
        }
        net.one97.paytm.vipcashback.view.a aVar3 = this.f20840e;
        if (aVar3 != null) {
            aVar3.b();
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20844a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.vipcashback.view.b f20845b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CashBackNewOfferModal f20846c;

        a(b bVar, net.one97.paytm.vipcashback.view.b bVar2, CashBackNewOfferModal cashBackNewOfferModal) {
            this.f20844a = bVar;
            this.f20845b = bVar2;
            this.f20846c = cashBackNewOfferModal;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20845b.b();
            if (iJRPaytmDataModel instanceof CashBackBaseModal) {
                CashBackBaseModal cashBackBaseModal = (CashBackBaseModal) iJRPaytmDataModel;
                if (cashBackBaseModal.getStatus() == 1) {
                    this.f20845b.c();
                    a.d dVar = net.one97.paytm.vipcashback.d.a.l;
                    net.one97.paytm.vipcashback.d.a.q = true;
                    new Handler().postDelayed(new C0395a(this, iJRPaytmDataModel), 1450);
                } else if (cashBackBaseModal.getErrors() != null && cashBackBaseModal.getErrors().size() > 0) {
                    net.one97.paytm.vipcashback.view.b bVar = this.f20845b;
                    d.a aVar = d.f20859a;
                    GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackBaseModal.getErrors().get(0);
                    k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                    bVar.a(d.a.a(getVIPCashBackErrorModal));
                }
            }
        }

        /* renamed from: net.one97.paytm.vipcashback.e.b$a$a  reason: collision with other inner class name */
        static final class C0395a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f20847a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ IJRPaytmDataModel f20848b;

            C0395a(a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
                this.f20847a = aVar;
                this.f20848b = iJRPaytmDataModel;
            }

            public final void run() {
                int indexOf = this.f20847a.f20844a.f20836a.indexOf(this.f20847a.f20846c);
                if (indexOf != -1) {
                    this.f20847a.f20844a.f20836a.remove(indexOf);
                    net.one97.paytm.vipcashback.view.a a2 = this.f20847a.f20844a.f20840e;
                    if (a2 != null) {
                        a2.a(indexOf);
                    }
                    net.one97.paytm.vipcashback.view.a a3 = this.f20847a.f20844a.f20840e;
                    if (a3 != null) {
                        a3.a((CashBackBaseModal) this.f20848b, this.f20847a.f20845b.e());
                    }
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "error");
            this.f20845b.b();
            this.f20845b.a(networkCustomError);
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.e.b$b  reason: collision with other inner class name */
    public static final class C0396b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20849a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CashBackNewOfferModal f20850b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.vipcashback.view.b f20851c;

        public C0396b(b bVar, CashBackNewOfferModal cashBackNewOfferModal, net.one97.paytm.vipcashback.view.b bVar2) {
            this.f20849a = bVar;
            this.f20850b = cashBackNewOfferModal;
            this.f20851c = bVar2;
        }

        public final void onClick(View view) {
            net.one97.paytm.vipcashback.view.a a2 = this.f20849a.f20840e;
            if (a2 != null) {
                a2.a(this.f20850b, this.f20851c.e());
            }
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20852a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CashBackNewOfferModal f20853b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.vipcashback.view.b f20854c;

        public c(b bVar, CashBackNewOfferModal cashBackNewOfferModal, net.one97.paytm.vipcashback.view.b bVar2) {
            this.f20852a = bVar;
            this.f20853b = cashBackNewOfferModal;
            this.f20854c = bVar2;
        }

        public final void onClick(View view) {
            b.a(this.f20852a, "ACCEPT_OFFER", String.valueOf(this.f20853b.getOfferTypeId()), String.valueOf(this.f20853b.getId()));
            b bVar = this.f20852a;
            CashBackNewOfferModal cashBackNewOfferModal = this.f20853b;
            net.one97.paytm.vipcashback.view.b bVar2 = this.f20854c;
            k.c(cashBackNewOfferModal, "offer");
            k.c("ACCEPT_OFFER", "action");
            k.c(bVar2, "view");
            d.a aVar = d.f20859a;
            com.paytm.network.a a2 = d.a.a(bVar.f20839d.f20759a, (com.paytm.network.listener.b) new a(bVar, bVar2, cashBackNewOfferModal), cashBackNewOfferModal.getId(), "ACCEPT_OFFER", bVar.f20841f, bVar.f20842g);
            if (com.paytm.utility.b.c(bVar.f20839d.f20759a)) {
                bVar2.a();
                a2.a();
                return;
            }
            net.one97.paytm.vipcashback.view.a aVar2 = bVar.f20840e;
            if (aVar2 != null) {
                aVar2.a(a2);
            }
        }
    }

    public static void a(CashBackNewOfferModal cashBackNewOfferModal, net.one97.paytm.vipcashback.view.b bVar) {
        String str;
        String offerTextOverride = cashBackNewOfferModal.getOfferTextOverride();
        if (offerTextOverride == null) {
            offerTextOverride = "";
        }
        if (v.a(offerTextOverride)) {
            str = cashBackNewOfferModal.getOfferTypeText();
            k.a((Object) str, "offer.offerTypeText");
        } else {
            str = cashBackNewOfferModal.getOfferTextOverride();
            k.a((Object) str, "offer.offerTextOverride");
        }
        bVar.a(str);
    }

    public static void b(CashBackNewOfferModal cashBackNewOfferModal, net.one97.paytm.vipcashback.view.b bVar) {
        String newOffersImageUrl = cashBackNewOfferModal.getNewOffersImageUrl();
        Boolean backgroundOverlay = cashBackNewOfferModal.getBackgroundOverlay();
        k.a((Object) backgroundOverlay, "offer.backgroundOverlay");
        bVar.a(newOffersImageUrl, backgroundOverlay.booleanValue());
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.vipcashback.view.a aVar;
        net.one97.paytm.vipcashback.view.a aVar2 = this.f20840e;
        if (aVar2 != null) {
            if (aVar2 != null) {
                aVar2.b();
            }
            if (iJRPaytmDataModel instanceof CashBackBaseNewOffersListModal) {
                CashBackBaseNewOffersListModal cashBackBaseNewOffersListModal = (CashBackBaseNewOffersListModal) iJRPaytmDataModel;
                if (cashBackBaseNewOffersListModal.getStatus() == 1 && cashBackBaseNewOffersListModal.getData() != null) {
                    CashBackNewOffersListModal data = cashBackBaseNewOffersListModal.getData();
                    k.a((Object) data, "offersListResponse");
                    if (data.getOffersList() != null && data.getOffersList().size() > 0) {
                        net.one97.paytm.vipcashback.view.a aVar3 = this.f20840e;
                        if (aVar3 != null) {
                            aVar3.e();
                        }
                        this.f20838c = data.getPageOffset();
                        ArrayList<CashBackNewOfferModal> offersList = data.getOffersList();
                        k.a((Object) offersList, "offersListResponse.offersList");
                        if (this.f20840e != null) {
                            int size = this.f20836a.size();
                            if (this.f20839d.j == 1) {
                                this.f20836a.clear();
                                ArrayList<CashBackNewOfferModal> arrayList = this.f20836a;
                                if (arrayList != null) {
                                    arrayList.addAll(offersList);
                                }
                            } else {
                                ArrayList<CashBackNewOfferModal> arrayList2 = this.f20836a;
                                if (arrayList2 != null) {
                                    arrayList2.addAll(offersList);
                                }
                            }
                            ArrayList<CashBackNewOfferModal> arrayList3 = this.f20836a;
                            CashBackNewOfferModal cashBackNewOfferModal = arrayList3.get(arrayList3.size() - 1);
                            k.a((Object) cashBackNewOfferModal, "newOffersList.get(newOffersList.size - 1)");
                            this.f20837b = cashBackNewOfferModal.getId();
                            if (this.f20842g) {
                                net.one97.paytm.vipcashback.view.a aVar4 = this.f20840e;
                                if (aVar4 != null) {
                                    aVar4.a(size, offersList.size());
                                }
                            } else {
                                net.one97.paytm.vipcashback.view.a aVar5 = this.f20840e;
                                if (aVar5 != null) {
                                    aVar5.f();
                                }
                            }
                        }
                        this.f20839d.j++;
                    }
                    if (this.f20836a.size() == 0 && (aVar = this.f20840e) != null) {
                        aVar.g();
                    }
                    if (!data.isNext()) {
                        net.one97.paytm.vipcashback.view.a aVar6 = this.f20840e;
                        if (aVar6 != null) {
                            aVar6.c();
                            return;
                        }
                        return;
                    }
                    net.one97.paytm.vipcashback.view.a aVar7 = this.f20840e;
                    if (aVar7 != null) {
                        aVar7.d();
                    }
                } else if (cashBackBaseNewOffersListModal.getErrors() == null || cashBackBaseNewOffersListModal.getErrors().size() <= 0) {
                    net.one97.paytm.vipcashback.view.a aVar8 = this.f20840e;
                    if (aVar8 != null) {
                        aVar8.g();
                    }
                } else {
                    net.one97.paytm.vipcashback.view.a aVar9 = this.f20840e;
                    if (aVar9 != null) {
                        d.a aVar10 = d.f20859a;
                        GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackBaseNewOffersListModal.getErrors().get(0);
                        k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                        aVar9.a(d.a.a(getVIPCashBackErrorModal));
                    }
                }
            } else {
                net.one97.paytm.vipcashback.view.a aVar11 = this.f20840e;
                if (aVar11 != null) {
                    aVar11.g();
                }
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        net.one97.paytm.vipcashback.view.a aVar = this.f20840e;
        if (aVar != null) {
            aVar.b();
        }
        if (networkCustomError != null) {
            q.b("NetworkCustomError");
            net.one97.paytm.vipcashback.view.a aVar2 = this.f20840e;
            if (aVar2 != null) {
                aVar2.a(networkCustomError);
            }
        }
    }

    public final void a() {
        if (this.f20836a.size() == 0) {
            net.one97.paytm.vipcashback.view.a aVar = this.f20840e;
            if (aVar != null) {
                aVar.g();
                return;
            }
            return;
        }
        net.one97.paytm.vipcashback.view.a aVar2 = this.f20840e;
        if (aVar2 != null) {
            aVar2.e();
        }
    }

    public static final /* synthetic */ void a(b bVar, String str, String str2, String str3) {
        if (bVar.f20842g) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str3);
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(bVar.f20839d.f20759a, "cashback_offers_merchant", "activate_offers_clicked", arrayList, (String) null, "/cashback-offers/merchant", "cashback");
        } else if (p.a(str, "ACCEPT_OFFER", true)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str3);
            arrayList2.add(str2);
            arrayList2.add("new offers");
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(bVar.f20839d.f20759a, "cashback_offers", "activate_offers_clicked", arrayList2, (String) null, "/cashback-offers/newoffers", "cashback");
        }
    }
}
