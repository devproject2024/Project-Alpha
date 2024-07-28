package net.one97.paytm.moneytransferv4.home.presentation.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import easypay.manager.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.u;
import net.one97.paytm.common.entity.InstrumentMeta;
import net.one97.paytm.common.entity.MTBeneficiaryNetworkResponse;
import net.one97.paytm.common.entity.MTBeneficiaryViewAll;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.contacts.entities.beans.VPADetails;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.a.a.a;
import net.one97.paytm.moneytransferv4.accounts.k;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.moneytransferv4.invite.b;
import net.one97.paytm.moneytransferv4.invite.d;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.PaymentInstrumentationType;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.registration.view.q;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UserActionEvent;
import net.one97.paytm.utils.ae;

public final class a extends net.one97.paytm.moneytransferv4.b.a implements PaymentManager.a {

    /* renamed from: c  reason: collision with root package name */
    public static final C1027a f55526c = new C1027a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d f55527a;

    /* renamed from: b  reason: collision with root package name */
    public q f55528b;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f55529e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.moneytransferv4.b.a.a.c f55530f;

    /* renamed from: g  reason: collision with root package name */
    private View f55531g;

    /* renamed from: h  reason: collision with root package name */
    private View f55532h;

    /* renamed from: i  reason: collision with root package name */
    private View f55533i;
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a j;
    private ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> k;
    /* access modifiers changed from: private */
    public final int l = 1000;
    /* access modifiers changed from: private */
    public final int m = IuserActions.SCROLL_MAIN_RV;
    private net.one97.paytm.moneytransfer.contacts.b.a n;
    private net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v> o;
    private net.one97.paytm.moneytransferv4.b.a.a.a.c.a p = new net.one97.paytm.moneytransferv4.b.a.a.a.c.a();
    /* access modifiers changed from: private */
    public final int q = 1003;
    private boolean r;
    private boolean s;
    /* access modifiers changed from: private */
    public int t = 3;
    private final z<UserActionEvent.Action> u = new n(this);
    /* access modifiers changed from: private */
    public final b v = new b(this);
    private HashMap w;

    public final void c() {
        HashMap hashMap = this.w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    static final class c<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55537a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f55538b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f55539c;

        c(a aVar, Activity activity, boolean z) {
            this.f55537a = aVar;
            this.f55538b = activity;
            this.f55539c = z;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                if (fVar.f55797b != null && (fVar.f55797b instanceof PaymentCombinationAPIResponse)) {
                    IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                    if (iJRPaytmDataModel != null) {
                        PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) iJRPaytmDataModel;
                        if (paymentCombinationAPIResponse.getCategory() != null && kotlin.m.p.a(paymentCombinationAPIResponse.getCategory(), "P2P", true)) {
                            PaymentManager paymentManager = PaymentManager.f54783a;
                            PaymentManager.a(paymentCombinationAPIResponse, (PaymentManager.a) this.f55537a);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse");
                    }
                }
            } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR && fVar.f55798c != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_is_from_fragment", true);
                ae aeVar = ae.f69602a;
                net.one97.paytm.network.g gVar = fVar.f55798c;
                if (gVar == null) {
                    kotlin.g.b.k.a();
                }
                if (ae.a(gVar.f55799a)) {
                    ae aeVar2 = ae.f69602a;
                    Activity activity = this.f55538b;
                    net.one97.paytm.network.g gVar2 = fVar.f55798c;
                    if (gVar2 == null) {
                        kotlin.g.b.k.a();
                    }
                    ae.a(activity, gVar2.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                }
            }
            if (this.f55539c) {
                a.f(this.f55537a).a(-1);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.moneytransfer.model.c<ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55540a;

        d(a aVar) {
            this.f55540a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = b.f55555a[dVar.ordinal()];
                if (i2 == 1) {
                    a.a(this.f55540a, (ArrayList) cVar.f54033b);
                } else if (i2 == 2) {
                    throw new kotlin.n((String) null, 1, (kotlin.g.b.g) null);
                } else if (i2 == 3) {
                    throw new kotlin.n((String) null, 1, (kotlin.g.b.g) null);
                } else if (i2 == 4) {
                    throw new kotlin.n((String) null, 1, (kotlin.g.b.g) null);
                } else if (i2 == 5) {
                    throw new kotlin.n((String) null, 1, (kotlin.g.b.g) null);
                }
            } else {
                throw new kotlin.n((String) null, 1, (kotlin.g.b.g) null);
            }
        }
    }

    static final class e<T> implements z<ArrayList<ContactsResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55541a;

        e(a aVar) {
            this.f55541a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null) {
                this.f55541a.a((ArrayList<ContactsResponse>) arrayList);
                return;
            }
            net.one97.paytm.moneytransferv4.b.a.a.c f2 = a.f(this.f55541a);
            Iterator<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> it2 = f2.f55344b.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                net.one97.paytm.moneytransferv4.b.a.a.e next = it2.next();
                if (!(next instanceof net.one97.paytm.moneytransferv4.b.a.a.a.c.a)) {
                    next = null;
                }
                net.one97.paytm.moneytransferv4.b.a.a.a.c.a aVar = (net.one97.paytm.moneytransferv4.b.a.a.a.c.a) next;
                if (aVar != null) {
                    if (!aVar.f55189d) {
                        aVar.f55188c = true;
                        aVar.notifyItemChanged(0);
                    }
                    f2.notifyItemChanged(i2);
                    return;
                }
                i2++;
            }
        }
    }

    static final class f<T> implements z<List<? extends AccountProviderBody.AccountProvider>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55542a;

        f(a aVar) {
            this.f55542a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list.size() > 0) {
                a aVar = this.f55542a;
                kotlin.g.b.k.a((Object) list, "it");
                a.a(aVar, list);
            }
        }
    }

    static final class g<T> implements z<ArrayList<BankAccountDetails.BankAccount>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55543a;

        g(a aVar) {
            this.f55543a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null) {
                q.a aVar = net.one97.paytm.upi.registration.view.q.f69021a;
                q.b aVar2 = new C1029a(this, arrayList);
                kotlin.g.b.k.c(arrayList, "bankList");
                kotlin.g.b.k.c(aVar2, "listener");
                net.one97.paytm.upi.registration.view.q qVar = new net.one97.paytm.upi.registration.view.q();
                Bundle bundle = new Bundle();
                bundle.putSerializable(qVar.f69026f, arrayList);
                bundle.putBoolean(qVar.f69027g, true);
                qVar.f69023c = aVar2;
                qVar.setArguments(bundle);
                androidx.fragment.app.j childFragmentManager = this.f55543a.getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                qVar.show(childFragmentManager, a.class.getName());
                a.g(this.f55543a);
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.view.a$g$a  reason: collision with other inner class name */
        public static final class C1029a implements q.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f55544a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f55545b;

            public final void a() {
            }

            C1029a(g gVar, ArrayList arrayList) {
                this.f55544a = gVar;
                this.f55545b = arrayList;
            }

            public final void a(BankAccountDetails.BankAccount bankAccount) {
                kotlin.g.b.k.c(bankAccount, "bankAccountDetails");
                a aVar = this.f55544a.f55543a;
                kotlin.g.b.k.c(bankAccount, "bankAccount");
                Intent intent = new Intent(aVar.getActivity(), SetMPINActivity.class);
                ArrayList arrayList = new ArrayList();
                arrayList.add(bankAccount);
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = aVar.f55527a;
                if (dVar == null) {
                    kotlin.g.b.k.a("homeViewModel");
                }
                intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, dVar.f55631e).setBankAccountList(arrayList).build());
                aVar.startActivityForResult(intent, 10);
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.moneytransfer.model.c<a.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55546a;

        h(a aVar) {
            this.f55546a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar.f54032a != net.one97.paytm.moneytransfer.model.d.LOADING) {
                a.f(this.f55546a).a(-1);
            }
            int i2 = b.f55556b[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                a.a(this.f55546a, (a.b) cVar.f54033b);
            } else if (i2 == 2) {
                a.a(this.f55546a, cVar.f54034c);
            }
        }
    }

    static final class i<T> implements z<net.one97.paytm.moneytransfer.model.c<a.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55547a;

        i(a aVar) {
            this.f55547a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            String str2;
            a.d dVar;
            a.d dVar2;
            String str3;
            a.d dVar3;
            a.d dVar4;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            String str4 = null;
            if (cVar == null || (dVar4 = (a.d) cVar.f54033b) == null) {
                str = null;
            } else {
                str = dVar4.f53982a;
            }
            CharSequence charSequence = str;
            if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
                net.one97.paytm.moneytransfer.contacts.b.a h2 = a.h(this.f55547a);
                if (cVar == null || (dVar3 = (a.d) cVar.f54033b) == null) {
                    str3 = null;
                } else {
                    str3 = dVar3.f53982a;
                }
                h2.f53974f = net.one97.paytm.moneytransfer.utils.m.f(str3);
            }
            if (!(cVar == null || (dVar2 = (a.d) cVar.f54033b) == null)) {
                str4 = dVar2.f53983b;
            }
            if (!TextUtils.isEmpty(str4)) {
                net.one97.paytm.moneytransfer.contacts.b.a h3 = a.h(this.f55547a);
                if (cVar == null || (dVar = (a.d) cVar.f54033b) == null || (str2 = dVar.f53983b) == null) {
                    str2 = "";
                }
                h3.f53975g = str2;
            }
        }
    }

    static final class j<T> implements z<ArrayList<UpiPendingRequestModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55548a;

        j(a aVar) {
            this.f55548a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null) {
                net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar = new net.one97.paytm.moneytransferv4.b.a.a.a.d.b(arrayList);
                bVar.a((net.one97.paytm.moneytransferv4.b.a.a.d) this.f55548a.v);
                a.i(this.f55548a).add(this.f55548a.t, bVar);
            }
        }
    }

    static final class n<T> implements z<UserActionEvent.Action> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55552a;

        n(a aVar) {
            this.f55552a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            UserActionEvent.Action action = (UserActionEvent.Action) obj;
            String str = null;
            if ((action != null ? action.getData() : null) != null) {
                if (action != null) {
                    str = action.getType();
                }
                if (kotlin.g.b.k.a((Object) str, (Object) UserActionEvent.ActionType.DECLINE.name())) {
                    a.f(this.f55552a).a(action.getData(), this.f55552a.t);
                } else if (kotlin.g.b.k.a((Object) str, (Object) UserActionEvent.ActionType.SPAM.name())) {
                    a.f(this.f55552a).a(action.getData(), this.f55552a.t);
                } else {
                    kotlin.g.b.k.a((Object) str, (Object) UserActionEvent.ActionType.PAY.name());
                }
            }
        }
    }

    public static final /* synthetic */ View a(a aVar) {
        View view = aVar.f55531g;
        if (view == null) {
            kotlin.g.b.k.a("whiteBackground");
        }
        return view;
    }

    public static final /* synthetic */ View b(a aVar) {
        View view = aVar.f55533i;
        if (view == null) {
            kotlin.g.b.k.a("searchToolbar");
        }
        return view;
    }

    public static final /* synthetic */ View c(a aVar) {
        View view = aVar.f55532h;
        if (view == null) {
            kotlin.g.b.k.a("settings");
        }
        return view;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.b.a.a.c f(a aVar) {
        net.one97.paytm.moneytransferv4.b.a.a.c cVar = aVar.f55530f;
        if (cVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        return cVar;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.contacts.b.a h(a aVar) {
        net.one97.paytm.moneytransfer.contacts.b.a aVar2 = aVar.n;
        if (aVar2 == null) {
            kotlin.g.b.k.a("contactsViewModel");
        }
        return aVar2;
    }

    public static final /* synthetic */ ArrayList i(a aVar) {
        ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList = aVar.k;
        if (arrayList == null) {
            kotlin.g.b.k.a("widgetList");
        }
        return arrayList;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d o(a aVar) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = aVar.f55527a;
        if (dVar == null) {
            kotlin.g.b.k.a("homeViewModel");
        }
        return dVar;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a q(a aVar) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = aVar.j;
        if (aVar2 == null) {
            kotlin.g.b.k.a("activityViewModel");
        }
        return aVar2;
    }

    /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.view.a$a  reason: collision with other inner class name */
    public static final class C1027a {
        private C1027a() {
        }

        public /* synthetic */ C1027a(byte b2) {
            this();
        }

        public static a a() {
            a aVar = new a();
            aVar.setArguments((Bundle) null);
            return aVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mt_v4_fragment_home_layout, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02e5, code lost:
        if (java.util.concurrent.TimeUnit.DAYS.convert(r6 - r9.getTimeInMillis(), java.util.concurrent.TimeUnit.MILLISECONDS) >= ((long) r15)) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0308, code lost:
        if (r15 != false) goto L_0x030c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x029f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r14, android.os.Bundle r15) {
        /*
            r13 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r14, r0)
            super.onViewCreated(r14, r15)
            int r15 = net.one97.paytm.moneytransfer.R.id.whiteBackground
            android.view.View r15 = r14.findViewById(r15)
            java.lang.String r0 = "view.findViewById(R.id.whiteBackground)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r13.f55531g = r15
            r15 = r13
            androidx.fragment.app.Fragment r15 = (androidx.fragment.app.Fragment) r15
            net.one97.paytm.moneytransferv4.d.a.q r0 = r13.f55528b
            if (r0 != 0) goto L_0x0021
            java.lang.String r1 = "vieModelFactory"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0021:
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r15 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r15, (androidx.lifecycle.al.b) r0)
            java.lang.Class<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d> r0 = net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d.class
            androidx.lifecycle.ai r15 = r15.a(r0)
            java.lang.String r0 = "ViewModelProviders.of(th…del::class.java\n        )"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d) r15
            r13.f55527a = r15
            androidx.lifecycle.al r15 = new androidx.lifecycle.al
            r0 = r13
            androidx.lifecycle.ao r0 = (androidx.lifecycle.ao) r0
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            if (r1 != 0) goto L_0x0044
            kotlin.g.b.k.a()
        L_0x0044:
            java.lang.String r2 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.app.Application r1 = r1.getApplication()
            androidx.lifecycle.al$a r1 = androidx.lifecycle.al.a.a(r1)
            androidx.lifecycle.al$b r1 = (androidx.lifecycle.al.b) r1
            r15.<init>((androidx.lifecycle.ao) r0, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.moneytransfer.contacts.b.a> r0 = net.one97.paytm.moneytransfer.contacts.b.a.class
            androidx.lifecycle.ai r15 = r15.a(r0)
            java.lang.String r0 = "ViewModelProvider(\n     …ctsViewModel::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            net.one97.paytm.moneytransfer.contacts.b.a r15 = (net.one97.paytm.moneytransfer.contacts.b.a) r15
            r13.n = r15
            int r15 = net.one97.paytm.moneytransfer.R.id.parentRecyclerView
            android.view.View r15 = r14.findViewById(r15)
            java.lang.String r0 = "view.findViewById(R.id.parentRecyclerView)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            androidx.recyclerview.widget.RecyclerView r15 = (androidx.recyclerview.widget.RecyclerView) r15
            r13.f55529e = r15
            net.one97.paytm.moneytransfer.d.c$a r15 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r15 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.util.Map r15 = r15.d()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13.k = r0
            net.one97.paytm.moneytransferv4.b.a.a.a.f.a r0 = new net.one97.paytm.moneytransferv4.b.a.a.a.f.a
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r1 = r13.f55527a
            java.lang.String r2 = "homeViewModel"
            if (r1 != 0) goto L_0x0090
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0090:
            net.one97.paytm.moneytransfer.d.c$a r3 = net.one97.paytm.moneytransfer.d.c.C
            net.one97.paytm.moneytransfer.d.c r3 = net.one97.paytm.moneytransfer.d.c.a.a()
            java.lang.String r3 = r3.s
            r4 = 1
            boolean r3 = net.one97.paytm.moneytransfer.d.c.a((java.lang.String) r3, (boolean) r4)
            r5 = 0
            if (r3 == 0) goto L_0x00bb
            net.one97.paytm.moneytransfer.utils.l$a r3 = net.one97.paytm.moneytransfer.utils.l.f54175a
            android.content.Context r1 = r1.f55635i
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r3 = "context.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            com.paytm.b.a.a r1 = net.one97.paytm.moneytransfer.utils.l.a.a(r1)
            java.lang.String r3 = "show_all_in_one"
            boolean r1 = r1.b((java.lang.String) r3, (boolean) r4, (boolean) r5)
            if (r1 == 0) goto L_0x00bb
            r1 = 1
            goto L_0x00bc
        L_0x00bb:
            r1 = 0
        L_0x00bc:
            r0.<init>(r1)
            net.one97.paytm.moneytransferv4.b.a.a.a.h.a r1 = new net.one97.paytm.moneytransferv4.b.a.a.a.h.a
            r1.<init>()
            net.one97.paytm.moneytransferv4.b.a.a.a.g.f r3 = new net.one97.paytm.moneytransferv4.b.a.a.a.g.f
            r3.<init>()
            net.one97.paytm.moneytransferv4.b.a.a.e r0 = (net.one97.paytm.moneytransferv4.b.a.a.e) r0
            r13.a((net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView.v>) r0)
            net.one97.paytm.moneytransferv4.b.a.a.e r1 = (net.one97.paytm.moneytransferv4.b.a.a.e) r1
            r13.a((net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView.v>) r1)
            net.one97.paytm.moneytransferv4.b.a.a.e r3 = (net.one97.paytm.moneytransferv4.b.a.a.e) r3
            r13.a((net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView.v>) r3)
            int r0 = r15.size()
            r1 = -1
            java.lang.String r3 = "widgetList"
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.moneytransferv4.common.baserecycleradapter.core.WidgetItemManager<androidx.recyclerview.widget.RecyclerView.ViewHolder>"
            if (r0 <= 0) goto L_0x0191
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x00eb:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x019d
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r7 = r0.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 >= 0) goto L_0x0118
            net.one97.paytm.moneytransferv4.b.a.a.g r0 = net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_COLLECT_REQUEST
            java.lang.String r0 = r0.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x00eb
            r13.t = r1
            goto L_0x00eb
        L_0x0118:
            net.one97.paytm.moneytransferv4.b.a.a.g r0 = net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_BENEFICIARIES
            java.lang.String r0 = r0.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x0134
            net.one97.paytm.moneytransferv4.b.a.a.a.c.a r0 = r13.p
            if (r0 == 0) goto L_0x012e
            net.one97.paytm.moneytransferv4.b.a.a.e r0 = (net.one97.paytm.moneytransferv4.b.a.a.e) r0
            r13.a((net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView.v>) r0)
            goto L_0x00eb
        L_0x012e:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r6)
            throw r14
        L_0x0134:
            net.one97.paytm.moneytransferv4.b.a.a.g r0 = net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_UPI_REGISTRATION
            java.lang.String r0 = r0.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x0144
            r13.e()
            goto L_0x00eb
        L_0x0144:
            net.one97.paytm.moneytransferv4.b.a.a.g r0 = net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_ADD_BANK
            java.lang.String r0 = r0.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x0176
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r0 = r13.f55527a
            if (r0 != 0) goto L_0x0157
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0157:
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x00eb
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r0 = r13.f55527a
            if (r0 != 0) goto L_0x0164
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0164:
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x00eb
            net.one97.paytm.moneytransferv4.b.a.a.a.a.a r0 = new net.one97.paytm.moneytransferv4.b.a.a.a.a.a
            r0.<init>()
            net.one97.paytm.moneytransferv4.b.a.a.e r0 = (net.one97.paytm.moneytransferv4.b.a.a.e) r0
            r13.a((net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView.v>) r0)
            goto L_0x00eb
        L_0x0176:
            net.one97.paytm.moneytransferv4.b.a.a.g r0 = net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_COLLECT_REQUEST
            java.lang.String r0 = r0.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x00eb
            java.util.ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView$v>> r0 = r13.k
            if (r0 != 0) goto L_0x0189
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0189:
            int r0 = r0.size()
            r13.t = r0
            goto L_0x00eb
        L_0x0191:
            net.one97.paytm.moneytransferv4.b.a.a.a.c.a r15 = r13.p
            if (r15 == 0) goto L_0x0419
            net.one97.paytm.moneytransferv4.b.a.a.e r15 = (net.one97.paytm.moneytransferv4.b.a.a.e) r15
            r13.a((net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView.v>) r15)
            r13.e()
        L_0x019d:
            net.one97.paytm.moneytransferv4.b.a.a.c r15 = new net.one97.paytm.moneytransferv4.b.a.a.c
            java.util.ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView$v>> r0 = r13.k
            if (r0 != 0) goto L_0x01a6
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01a6:
            androidx.fragment.app.j r3 = r13.getChildFragmentManager()
            java.lang.String r6 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            r15.<init>(r0, r3)
            r13.f55530f = r15
            net.one97.paytm.moneytransferv4.b.a.a.c r15 = r13.f55530f
            java.lang.String r0 = "adapter"
            if (r15 != 0) goto L_0x01bd
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01bd:
            net.one97.paytm.moneytransferv4.home.presentation.view.a$b r3 = r13.v
            net.one97.paytm.moneytransferv4.b.a.a.d r3 = (net.one97.paytm.moneytransferv4.b.a.a.d) r3
            r15.a((net.one97.paytm.moneytransferv4.b.a.a.d) r3)
            androidx.recyclerview.widget.RecyclerView r15 = r13.f55529e
            java.lang.String r3 = "parentRecyclerView"
            if (r15 != 0) goto L_0x01cd
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01cd:
            net.one97.paytm.moneytransferv4.b.a.a.c r6 = r13.f55530f
            if (r6 != 0) goto L_0x01d4
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01d4:
            androidx.recyclerview.widget.RecyclerView$a r6 = (androidx.recyclerview.widget.RecyclerView.a) r6
            r15.setAdapter(r6)
            int r15 = net.one97.paytm.moneytransfer.R.id.backButton
            android.view.View r15 = r14.findViewById(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.moneytransferv4.home.presentation.view.a$k r0 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$k
            r0.<init>(r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            int r15 = net.one97.paytm.moneytransfer.R.id.settingsIcon
            android.view.View r15 = r14.findViewById(r15)
            java.lang.String r0 = "view.findViewById<ImageView>(R.id.settingsIcon)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r13.f55532h = r15
            int r15 = net.one97.paytm.moneytransfer.R.id.settingsIcon
            android.view.View r15 = r14.findViewById(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            net.one97.paytm.moneytransferv4.home.presentation.view.a$l r0 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$l
            r0.<init>(r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            int r15 = net.one97.paytm.moneytransfer.R.id.toolbar_search
            android.view.View r15 = r14.findViewById(r15)
            java.lang.String r0 = "view.findViewById<ImageView>(R.id.toolbar_search)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r13.f55533i = r15
            androidx.fragment.app.FragmentActivity r15 = r13.getActivity()
            if (r15 != 0) goto L_0x0220
            kotlin.g.b.k.a()
        L_0x0220:
            androidx.lifecycle.al r15 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r15)
            java.lang.Class<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a> r0 = net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a.class
            androidx.lifecycle.ai r15 = r15.a(r0)
            java.lang.String r0 = "ViewModelProviders.of(ac…ityViewModel::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a r15 = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a) r15
            r13.j = r15
            android.view.View r15 = r13.f55533i
            if (r15 != 0) goto L_0x023c
            java.lang.String r0 = "searchToolbar"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x023c:
            net.one97.paytm.moneytransferv4.home.presentation.view.a$m r0 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$m
            r0.<init>(r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            r13.a()
            r13.g()
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x0253
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0253:
            r15.b()
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x025d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x025d:
            boolean r15 = r15.c()
            if (r15 != 0) goto L_0x0285
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x026a
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x026a:
            boolean r15 = r15.d()
            if (r15 != 0) goto L_0x0285
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x0277
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0277:
            net.one97.paytm.upi.registration.b.a.a r0 = r15.f55633g
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d$b r6 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d$b
            r6.<init>(r15)
            net.one97.paytm.upi.registration.b.a.a$a r6 = (net.one97.paytm.upi.registration.b.a.a.C1389a) r6
            java.lang.String r15 = ""
            r0.a((net.one97.paytm.upi.registration.b.a.a.C1389a) r6, (java.lang.String) r15, (java.lang.String) r15)
        L_0x0285:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x028c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x028c:
            int r15 = net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d.g()
            android.content.Context r0 = r13.getContext()
            r6 = 0
            r8 = 0
            if (r0 == 0) goto L_0x02b0
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x02b0
            net.one97.paytm.moneytransfer.utils.l$a r9 = net.one97.paytm.moneytransfer.utils.l.f54175a
            com.paytm.b.a.a r0 = net.one97.paytm.moneytransfer.utils.l.a.a(r0)
            java.lang.String r9 = "set_pin_prev_time"
            long r9 = r0.b((java.lang.String) r9, (long) r6, (boolean) r5)
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            goto L_0x02b1
        L_0x02b0:
            r0 = r8
        L_0x02b1:
            if (r15 <= 0) goto L_0x02e9
            if (r0 == 0) goto L_0x02e9
            long r9 = r0.longValue()
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x02e7
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            long r6 = r6.getTimeInMillis()
            java.util.Calendar r9 = java.util.Calendar.getInstance()
            java.util.Date r10 = new java.util.Date
            long r11 = r0.longValue()
            r10.<init>(r11)
            r9.setTime(r10)
            long r9 = r9.getTimeInMillis()
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            long r6 = r6 - r9
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r6 = r0.convert(r6, r9)
            long r9 = (long) r15
            int r15 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r15 < 0) goto L_0x02e9
        L_0x02e7:
            r15 = 1
            goto L_0x02ea
        L_0x02e9:
            r15 = 0
        L_0x02ea:
            if (r15 == 0) goto L_0x030b
            android.content.Context r15 = r13.getContext()
            if (r15 == 0) goto L_0x02fe
            android.content.Context r15 = r15.getApplicationContext()
            if (r15 == 0) goto L_0x02fe
            net.one97.paytm.moneytransfer.utils.l$a r0 = net.one97.paytm.moneytransfer.utils.l.f54175a
            com.paytm.b.a.a r8 = net.one97.paytm.moneytransfer.utils.l.a.a(r15)
        L_0x02fe:
            if (r8 == 0) goto L_0x0307
            java.lang.String r15 = "setmpin_dialog_flag"
            boolean r15 = r8.b((java.lang.String) r15, (boolean) r4, (boolean) r4)
            goto L_0x0308
        L_0x0307:
            r15 = 1
        L_0x0308:
            if (r15 == 0) goto L_0x030b
            goto L_0x030c
        L_0x030b:
            r4 = 0
        L_0x030c:
            if (r4 == 0) goto L_0x0318
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x0315
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0315:
            r15.f()
        L_0x0318:
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x031f
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x031f:
            net.one97.paytm.upi.passbook.b.a.b.a r0 = r15.f55634h
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d$c r4 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d$c
            r4.<init>(r15)
            net.one97.paytm.upi.passbook.b.a.a$a r4 = (net.one97.paytm.upi.passbook.b.a.a.C1379a) r4
            java.lang.String r15 = "MT_HOME_PENDING_REQUEST"
            java.lang.String r6 = "MT_HOME"
            r0.a((net.one97.paytm.upi.passbook.b.a.a.C1379a) r4, (java.lang.String) r15, (int) r5, (java.lang.String) r6)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x0336
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0336:
            androidx.lifecycle.w<net.one97.paytm.moneytransfer.model.c<java.util.ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<androidx.recyclerview.widget.RecyclerView$v>>>> r15 = r15.f55627a
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            androidx.lifecycle.q r0 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$d r4 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$d
            r4.<init>(r13)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r15.observe(r0, r4)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x034f
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x034f:
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.contacts.entities.beans.ContactsResponse>> r15 = r15.f55628b
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            androidx.lifecycle.q r0 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$e r4 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$e
            r4.<init>(r13)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r15.observe(r0, r4)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x0368
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0368:
            androidx.lifecycle.y<java.util.List<net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProvider>> r15 = r15.f55629c
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            androidx.lifecycle.q r0 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$f r4 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$f
            r4.<init>(r13)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r15.observe(r0, r4)
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x0381
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0381:
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount>> r15 = r15.f55630d
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            androidx.lifecycle.q r0 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$g r4 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$g
            r4.<init>(r13)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r15.observe(r0, r4)
            net.one97.paytm.moneytransfer.contacts.b.a r15 = r13.n
            java.lang.String r0 = "contactsViewModel"
            if (r15 != 0) goto L_0x039c
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x039c:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.contacts.b.a$b>> r15 = r15.f53970b
            androidx.lifecycle.q r4 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$h r5 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$h
            r5.<init>(r13)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r15.observe(r4, r5)
            net.one97.paytm.moneytransfer.contacts.b.a r15 = r13.n
            if (r15 != 0) goto L_0x03b3
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x03b3:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.contacts.b.a$d>> r15 = r15.f53971c
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            androidx.lifecycle.q r0 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$i r4 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$i
            r4.<init>(r13)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r15.observe(r0, r4)
            int r15 = r13.t
            if (r15 == r1) goto L_0x03e2
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d r15 = r13.f55527a
            if (r15 != 0) goto L_0x03d0
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x03d0:
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiPendingRequestModel>> r15 = r15.f55632f
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            androidx.lifecycle.q r0 = r13.getViewLifecycleOwner()
            net.one97.paytm.moneytransferv4.home.presentation.view.a$j r1 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$j
            r1.<init>(r13)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r15.observe(r0, r1)
        L_0x03e2:
            net.one97.paytm.upi.util.UserActionEvent r15 = net.one97.paytm.upi.util.UserActionEvent.INSTANCE
            androidx.lifecycle.y r15 = r15.getActionLiveData()
            androidx.lifecycle.z<net.one97.paytm.upi.util.UserActionEvent$Action> r0 = r13.u
            r15.observeForever(r0)
            androidx.recyclerview.widget.RecyclerView r15 = r13.f55529e
            if (r15 != 0) goto L_0x03f4
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x03f4:
            net.one97.paytm.moneytransferv4.home.presentation.view.a$o r0 = new net.one97.paytm.moneytransferv4.home.presentation.view.a$o
            r0.<init>(r13)
            androidx.recyclerview.widget.RecyclerView$l r0 = (androidx.recyclerview.widget.RecyclerView.l) r0
            r15.addOnScrollListener(r0)
            r13.getActivity()
            androidx.lifecycle.k r15 = r13.getLifecycle()
            net.one97.paytm.contacts.sync.ContactSyncLifeObserver r0 = new net.one97.paytm.contacts.sync.ContactSyncLifeObserver
            r0.<init>()
            androidx.lifecycle.p r0 = (androidx.lifecycle.p) r0
            r15.a(r0)
            android.content.Context r14 = r14.getContext()
            java.lang.String r15 = "/mt_p2p_homepage"
            net.one97.paytm.moneytransfer.utils.f.a(r14, r15)
            return
        L_0x0419:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r6)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.view.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public static final class o extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55553a;

        o(a aVar) {
            this.f55553a = aVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() > 0) {
                    if (a.a(this.f55553a).getAlpha() < 1.0f) {
                        a.a(this.f55553a).setAlpha(1.0f);
                    }
                    RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    if (layoutManager2 == null) {
                        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    } else if (((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() > 1) {
                        a.b(this.f55553a).setVisibility(0);
                        View findViewById = a.b(this.f55553a).findViewById(R.id.search_icon);
                        kotlin.g.b.k.a((Object) findViewById, "searchToolbar.findViewBy…geView>(R.id.search_icon)");
                        net.one97.paytm.wallet.rateMerchant.utils.b.b(findViewById);
                        a.c(this.f55553a).setVisibility(8);
                        StringBuilder sb = new StringBuilder("return :: ");
                        RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
                        if (layoutManager3 != null) {
                            sb.append(((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition());
                            return;
                        }
                        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                }
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                recyclerView.getGlobalVisibleRect(rect);
                RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
                if (layoutManager4 != null) {
                    View findViewByPosition = ((LinearLayoutManager) layoutManager4).findViewByPosition(0);
                    Rect rect3 = new Rect();
                    Rect rect4 = new Rect();
                    recyclerView.getGlobalVisibleRect(rect3);
                    RecyclerView.LayoutManager layoutManager5 = recyclerView.getLayoutManager();
                    if (layoutManager5 != null) {
                        View findViewByPosition2 = ((LinearLayoutManager) layoutManager5).findViewByPosition(1);
                        if (findViewByPosition != null) {
                            findViewByPosition.getGlobalVisibleRect(rect2);
                            float min = 1.0f - Math.min(((float) (rect2.bottom - rect.top)) / ((float) findViewByPosition.getHeight()), 1.0f);
                            if (((double) min) > 0.8d) {
                                a.a(this.f55553a).setAlpha(1.0f);
                            } else {
                                a.a(this.f55553a).setAlpha(min);
                            }
                        }
                        if (findViewByPosition2 != null) {
                            findViewByPosition2.getGlobalVisibleRect(rect4);
                            if (((double) (1.0f - Math.min(((float) (rect4.bottom - rect3.top)) / ((float) findViewByPosition2.getHeight()), 1.0f))) > 0.1d) {
                                a.b(this.f55553a).setVisibility(0);
                                View findViewById2 = a.b(this.f55553a).findViewById(R.id.search_icon);
                                kotlin.g.b.k.a((Object) findViewById2, "searchToolbar.findViewBy…geView>(R.id.search_icon)");
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(findViewById2);
                                View findViewById3 = a.b(this.f55553a).findViewById(R.id.line);
                                kotlin.g.b.k.a((Object) findViewById3, "searchToolbar.findViewById<ImageView>(R.id.line)");
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(findViewById3);
                                a.c(this.f55553a).setVisibility(8);
                                return;
                            }
                            a.b(this.f55553a).setVisibility(8);
                            a.c(this.f55553a).setVisibility(0);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55549a;

        k(a aVar) {
            this.f55549a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f55549a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            net.one97.paytm.moneytransfer.utils.f.a(this.f55549a.getContext(), "mt_p2p_new_v1", "back_button_clicked", CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55550a;

        l(a aVar) {
            this.f55550a = aVar;
        }

        public final void onClick(View view) {
            a.d(this.f55550a);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55551a;

        m(a aVar) {
            this.f55551a = aVar;
        }

        public final void onClick(View view) {
            this.f55551a.v.c();
        }
    }

    private final void a() {
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        if (androidx.core.app.a.a(context, "android.permission.READ_CONTACTS") == 0) {
            ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList = this.k;
            if (arrayList == null) {
                kotlin.g.b.k.a("widgetList");
            }
            ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList2 = this.k;
            if (arrayList2 == null) {
                kotlin.g.b.k.a("widgetList");
            }
            if (arrayList.get(arrayList2.size() - 1).a() == net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_CONTACT_PERMISSION.getId()) {
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList3 = this.k;
                if (arrayList3 == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList4 = this.k;
                if (arrayList4 == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                arrayList3.remove(arrayList4.size() - 1);
                net.one97.paytm.moneytransferv4.b.a.a.c cVar = this.f55530f;
                if (cVar == null) {
                    kotlin.g.b.k.a("adapter");
                }
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList5 = this.k;
                if (arrayList5 == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                cVar.notifyItemRemoved(arrayList5.size());
                this.r = false;
            }
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = this.f55527a;
            if (dVar == null) {
                kotlin.g.b.k.a("homeViewModel");
            }
            dVar.a();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        a((net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>) new net.one97.paytm.moneytransferv4.b.a.a.a.e.b(a((Activity) activity)));
        this.r = true;
    }

    private final void b() {
        if (getActivity() != null) {
            c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
            if (!TextUtils.isEmpty(net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53989d))) {
                net.one97.paytm.moneytransfer.contacts.b.a aVar2 = this.n;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("contactsViewModel");
                }
                String str = aVar2.f53973e;
                net.one97.paytm.moneytransfer.contacts.b.a aVar3 = this.n;
                if (aVar3 == null) {
                    kotlin.g.b.k.a("contactsViewModel");
                }
                String a2 = aVar3.a();
                b.a aVar4 = net.one97.paytm.moneytransferv4.invite.b.f55654a;
                if (a2 != null) {
                    str = a2;
                } else if (str == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.moneytransfer.utils.m.a(R.id.container, (Fragment) b.a.a(str, a2), "InviteContactFragment", getFragmentManager());
                return;
            }
        }
        d();
    }

    private final void d() {
        net.one97.paytm.moneytransfer.contacts.b.a aVar = this.n;
        if (aVar == null) {
            kotlin.g.b.k.a("contactsViewModel");
        }
        String str = aVar.f53973e;
        net.one97.paytm.moneytransferv4.b bVar = new net.one97.paytm.moneytransferv4.b();
        Bundle bundle = new Bundle();
        bundle.putString(ContactColumn.PHONE_NUMBER, str);
        bVar.setArguments(bundle);
        net.one97.paytm.moneytransfer.utils.m.a(R.id.container, (Fragment) bVar, "MoneyTransferEnterBankAccountOrUPIFragment", getFragmentManager());
    }

    private final void e() {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = this.f55527a;
        if (dVar == null) {
            kotlin.g.b.k.a("homeViewModel");
        }
        if (!dVar.c()) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar2 = this.f55527a;
            if (dVar2 == null) {
                kotlin.g.b.k.a("homeViewModel");
            }
            if (!dVar2.d()) {
                this.o = new net.one97.paytm.moneytransferv4.b.a.a.a.j.b();
                net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v> eVar = this.o;
                if (eVar == null) {
                    kotlin.g.b.k.a("widget5");
                }
                a(eVar);
            }
        }
    }

    private final void a(net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v> eVar) {
        ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList = this.k;
        if (arrayList == null) {
            kotlin.g.b.k.a("widgetList");
        }
        arrayList.add(eVar);
    }

    public final void a(ArrayList<ContactsResponse> arrayList) {
        kotlin.g.b.k.c(arrayList, "it");
        net.one97.paytm.moneytransferv4.b.a.a.a.c.c cVar = new net.one97.paytm.moneytransferv4.b.a.a.a.c.c();
        cVar.f55216a = arrayList;
        net.one97.paytm.moneytransferv4.b.a.a.c cVar2 = this.f55530f;
        if (cVar2 == null) {
            kotlin.g.b.k.a("adapter");
        }
        cVar2.a((net.one97.paytm.moneytransferv4.b.a.a.a) cVar);
    }

    public static final class b implements net.one97.paytm.moneytransferv4.b.a.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55534a;

        b(a aVar) {
            this.f55534a = aVar;
        }

        public final void a(ContactDetail contactDetail, int i2) {
            kotlin.g.b.k.c(contactDetail, "contact");
            FragmentActivity activity = this.f55534a.getActivity();
            if (activity != null) {
                a aVar = this.f55534a;
                String primaryPhoneNumber = contactDetail.getPrimaryPhoneNumber();
                if (primaryPhoneNumber == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "it");
                aVar.a(primaryPhoneNumber, (Activity) activity, true, contactDetail.getContactName());
                if (a.f(this.f55534a).f55343a == -1) {
                    a.f(this.f55534a).a(i2);
                    net.one97.paytm.moneytransfer.utils.f.a(this.f55534a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CONTACT_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
                }
            }
        }

        public final void a(ContactsResponse contactsResponse, String str) {
            kotlin.g.b.k.c(contactsResponse, "contactsResponse");
            if (str == null) {
                a.a(this.f55534a, contactsResponse);
            } else {
                a aVar = this.f55534a;
                FragmentActivity activity = aVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                aVar.a(str, (Activity) activity, false, contactsResponse.getName());
            }
            net.one97.paytm.moneytransfer.utils.f.a(this.f55534a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_BENEFICIARY_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
        }

        public final void c() {
            net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
            FragmentActivity requireActivity = this.f55534a.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            Intent a2 = net.one97.paytm.wallet.utility.d.a(requireActivity);
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            a2.putExtra(net.one97.paytm.contacts.utils.e.h(), e.C0905e.MONEY_TRANSFER.getType());
            a aVar = this.f55534a;
            aVar.startActivityForResult(a2, aVar.q);
            net.one97.paytm.moneytransfer.utils.f.a(this.f55534a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SEARCH_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
        }

        public final void d() {
            a.l(this.f55534a);
            net.one97.paytm.moneytransfer.utils.f.a(this.f55534a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_BENEFICIARY_VIEW_ALL_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
        }

        public final void e() {
            com.paytm.b.a.a aVar;
            Context applicationContext;
            Context context = this.f55534a.getContext();
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar2 = net.one97.paytm.moneytransfer.utils.l.f54175a;
                aVar = l.a.a(applicationContext);
            }
            if (aVar != null) {
                aVar.a("isMtPermissionAskedOnce", true, false);
            }
            a aVar3 = this.f55534a;
            aVar3.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, aVar3.l);
            net.one97.paytm.moneytransfer.utils.f.a(this.f55534a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CONTACT_PERMISSION_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
        }

        public final void a(AccountProviderBody.AccountProvider accountProvider) {
            if (accountProvider != null) {
                this.f55534a.a(accountProvider);
            } else {
                AccountProviderActivity.a((Fragment) this.f55534a, 288);
            }
        }

        public final void f() {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d o = a.o(this.f55534a);
            l.a aVar = net.one97.paytm.moneytransfer.utils.l.f54175a;
            Context applicationContext = o.f55635i.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
            l.a.a(applicationContext).a("show_all_in_one", false, false);
        }

        public final void g() {
            q.a aVar = net.one97.paytm.upi.q.f68356a;
            Context context = this.f55534a.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            q.a.a(context, this.f55534a.m, (Fragment) this.f55534a);
        }

        public final void a(InstrumentMeta instrumentMeta) {
            if (instrumentMeta != null) {
                CharSequence vpa = instrumentMeta.getVpa();
                boolean z = false;
                if (!(vpa == null || vpa.length() == 0)) {
                    String str = "paytmmp://cash_wallet?featuretype=money_transfer_history&payeeAccNoOrVpa=" + instrumentMeta.getVpa() + "&payeeName=" + instrumentMeta.getName();
                    d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    Context context = this.f55534a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context, "context!!");
                    b2.a(context, str);
                    return;
                }
                CharSequence accountNo = instrumentMeta.getAccountNo();
                if (accountNo == null || accountNo.length() == 0) {
                    z = true;
                }
                if (!z) {
                    String str2 = "paytmmp://cash_wallet?featuretype=money_transfer_history&payeeAccNoOrVpa=" + instrumentMeta.getAccountNo() + "&payeeName=" + instrumentMeta.getName() + "&ifsc=" + instrumentMeta.getIfsc() + "&bankName=" + instrumentMeta.getBankName();
                    d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    Context context2 = this.f55534a.getContext();
                    if (context2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context2, "context!!");
                    b3.a(context2, str2);
                }
            }
        }

        public final void a(UpiPendingRequestModel upiPendingRequestModel) {
            kotlin.g.b.k.c(upiPendingRequestModel, "upiPendingRequestModel");
            if (com.paytm.utility.a.m(this.f55534a.getActivity())) {
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a q = a.q(this.f55534a);
                String payerVa = upiPendingRequestModel.getPayerVa();
                kotlin.g.b.k.a((Object) payerVa, "upiPendingRequestModel.payerVa");
                q.a(payerVa).observe(this.f55534a.getViewLifecycleOwner(), new C1028a(this, upiPendingRequestModel));
                return;
            }
            Context context = this.f55534a.getContext();
            if (context != null) {
                kotlin.g.b.k.a((Object) context, "it");
                String string = this.f55534a.getString(R.string.no_connection);
                kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = this.f55534a.getResources().getString(R.string.no_internet);
                kotlin.g.b.k.a((Object) string2, "resources.getString(R.string.no_internet)");
                String string3 = this.f55534a.getString(R.string.ok);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.ok)");
                a.a(context, string, string2, string3);
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.view.a$b$a  reason: collision with other inner class name */
        public static final class C1028a implements z<UpiProfileDefaultBank> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f55535a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ UpiPendingRequestModel f55536b;

            C1028a(b bVar, UpiPendingRequestModel upiPendingRequestModel) {
                this.f55535a = bVar;
                this.f55536b = upiPendingRequestModel;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                UpiProfileDefaultBank upiProfileDefaultBank = (UpiProfileDefaultBank) obj;
                if (upiProfileDefaultBank != null) {
                    net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a q = a.q(this.f55535a.f55534a);
                    String payerVa = this.f55536b.getPayerVa();
                    kotlin.g.b.k.a((Object) payerVa, "upiPendingRequestModel.payerVa");
                    q.a(payerVa).removeObserver(this);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                    bundle.putString("amount", this.f55536b.getAmount());
                    bundle.putString("payee_name", this.f55536b.getPayeeName());
                    bundle.putString("payee_vpa", this.f55536b.getPayeeVa());
                    bundle.putString(UpiConstants.EXTRA_PAYER_VPA, this.f55536b.getPayerVa());
                    bundle.putSerializable("user_upi_details", upiProfileDefaultBank);
                    bundle.putBoolean(UpiConstants.EXTRA_IS_COLLECT_REQUEST, true);
                    bundle.putString(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, this.f55536b.getTxnId());
                    bundle.putString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.f55536b.getTxnId());
                    net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                    kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                    a2.c().a(this.f55535a.f55534a.getContext(), bundle);
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f55535a.f55534a.requireContext(), Events.Category.COLLECT, "screen_open", CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "", this.f55536b.getPayeeVa(), this.f55536b.getAmount(), Events.Screen.ENTER_AMOUNT, "wallet");
                }
            }
        }

        public final void h() {
            Intent intent = new Intent(this.f55534a.getActivity(), UpiPassbookActivity.class);
            intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
            this.f55534a.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        UpiRegistrationActivity.a((Fragment) this, accountProvider, UpiConstants.UPI_ONBOARDING_SELF_DESTROY, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        FragmentActivity activity;
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int i3 = 0;
        if (i2 == this.l) {
            if ((!(iArr.length == 0)) && iArr.length > 0 && iArr[0] == 0) {
                a();
                return;
            }
        }
        if (i2 == this.l && (activity = getActivity()) != null && !androidx.core.app.a.a((Activity) activity, "android.permission.READ_CONTACTS")) {
            net.one97.paytm.moneytransferv4.b.a.a.c cVar = this.f55530f;
            if (cVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            Iterator<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> it2 = cVar.f55344b.iterator();
            while (it2.hasNext()) {
                net.one97.paytm.moneytransferv4.b.a.a.e next = it2.next();
                if (!(next instanceof net.one97.paytm.moneytransferv4.b.a.a.a.e.b)) {
                    next = null;
                }
                net.one97.paytm.moneytransferv4.b.a.a.a.e.b bVar = (net.one97.paytm.moneytransferv4.b.a.a.a.e.b) next;
                if (bVar != null) {
                    bVar.f55278b = true;
                    cVar.notifyItemChanged(i3);
                    return;
                }
                i3++;
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 288 && i3 == -1) {
            if (intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                if (!(serializableExtra instanceof AccountProviderBody.AccountProvider)) {
                    serializableExtra = null;
                }
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                if (accountProvider != null) {
                    a(accountProvider);
                    return;
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (i2 == 352 && i3 == -1) {
            f();
            net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v> eVar = this.o;
            if (eVar == null) {
                kotlin.g.b.k.a("widget5");
            }
            int i4 = eVar.f55347a;
            ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList = this.k;
            if (arrayList == null) {
                kotlin.g.b.k.a("widgetList");
            }
            arrayList.remove(i4);
            net.one97.paytm.moneytransferv4.b.a.a.c cVar = this.f55530f;
            if (cVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            cVar.notifyItemRemoved(i4);
        } else if (i2 == this.m && i3 == -1) {
            f();
            net.one97.paytm.moneytransferv4.b.a.a.c cVar2 = this.f55530f;
            if (cVar2 == null) {
                kotlin.g.b.k.a("adapter");
            }
            int i5 = -1;
            int i6 = 0;
            for (Object next : cVar2.f55344b) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    kotlin.a.k.a();
                }
                net.one97.paytm.moneytransferv4.b.a.a.e eVar2 = (net.one97.paytm.moneytransferv4.b.a.a.e) next;
                if (!(eVar2 instanceof net.one97.paytm.moneytransferv4.b.a.a.a.a.a)) {
                    eVar2 = null;
                }
                if (((net.one97.paytm.moneytransferv4.b.a.a.a.a.a) eVar2) != null) {
                    i5 = i6;
                }
                i6 = i7;
            }
            if (i5 != -1) {
                cVar2.f55344b.remove(i5);
                cVar2.notifyItemRemoved(i5);
            }
        } else if (i2 == this.q && i3 == -1) {
            if (intent != null) {
                net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
                if (intent.hasExtra(net.one97.paytm.contacts.utils.e.g())) {
                    net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
                    Serializable serializableExtra2 = intent.getSerializableExtra(net.one97.paytm.contacts.utils.e.g());
                    if (serializableExtra2 != null) {
                        PaymentManager paymentManager = PaymentManager.f54783a;
                        PaymentManager.a((PaymentCombinationAPIResponse) serializableExtra2, (PaymentManager.a) this);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse");
                }
                net.one97.paytm.contacts.utils.e eVar5 = net.one97.paytm.contacts.utils.e.f50261a;
                if (intent.hasExtra(net.one97.paytm.contacts.utils.e.i())) {
                    net.one97.paytm.contacts.utils.e eVar6 = net.one97.paytm.contacts.utils.e.f50261a;
                    Serializable serializableExtra3 = intent.getSerializableExtra(net.one97.paytm.contacts.utils.e.i());
                    if (serializableExtra3 != null) {
                        int i8 = R.id.container;
                        a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                        PaymentManager paymentManager2 = PaymentManager.f54783a;
                        net.one97.paytm.moneytransfer.utils.m.a(i8, (Fragment) a.C0982a.a(PaymentManager.a((ContactDetail) serializableExtra3), (Activity) null, 14), "BeneficiaryHistoryFragment", getFragmentManager());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
                }
                net.one97.paytm.contacts.utils.e eVar7 = net.one97.paytm.contacts.utils.e.f50261a;
                if (intent.hasExtra(net.one97.paytm.contacts.utils.e.j())) {
                    net.one97.paytm.contacts.utils.e eVar8 = net.one97.paytm.contacts.utils.e.f50261a;
                    Serializable serializableExtra4 = intent.getSerializableExtra(net.one97.paytm.contacts.utils.e.j());
                    if (serializableExtra4 != null) {
                        int i9 = R.id.container;
                        a.C0982a aVar2 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                        PaymentManager paymentManager3 = PaymentManager.f54783a;
                        net.one97.paytm.moneytransfer.utils.m.a(i9, (Fragment) a.C0982a.a(PaymentManager.a((VPADetails) serializableExtra4), (Activity) null, 14), "BeneficiaryHistoryFragment", getFragmentManager());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.VPADetails");
                }
            }
        } else if (i3 == -1 && intent != null) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = this.f55527a;
            if (dVar == null) {
                kotlin.g.b.k.a("homeViewModel");
            }
            dVar.f();
        }
    }

    private final void f() {
        int i2 = R.id.container;
        k.a aVar = net.one97.paytm.moneytransferv4.accounts.k.f54987b;
        net.one97.paytm.moneytransfer.utils.m.a(i2, (Fragment) new net.one97.paytm.moneytransferv4.accounts.k(), "SelfAccountFragment", getFragmentManager());
    }

    public final void a(PaymentFlow paymentFlow) {
        kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
        int i2 = R.id.container;
        a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
        net.one97.paytm.moneytransfer.utils.m.a(i2, (Fragment) a.C0982a.a(paymentFlow), "BeneficiaryHistoryFragment", getFragmentManager());
    }

    public final void b(PaymentFlow paymentFlow) {
        kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
        int i2 = R.id.container;
        d.a aVar = net.one97.paytm.moneytransferv4.invite.d.f55674a;
        Fragment a2 = d.a.a(paymentFlow);
        FragmentActivity activity = getActivity();
        net.one97.paytm.moneytransfer.utils.m.a(i2, a2, "BeneficiaryHistoryFragment", activity != null ? activity.getSupportFragmentManager() : null);
    }

    public final void a(String str, String str2) {
        Context context;
        if (isAdded() && (context = getContext()) != null) {
            net.one97.paytm.moneytransfer.utils.m.a(context, str, str2);
        }
    }

    public final void a(String str, Activity activity, boolean z, String str2) {
        kotlin.g.b.k.c(str, "phoneNo");
        kotlin.g.b.k.c(activity, "activity");
        String a2 = net.one97.paytm.moneytransfer.utils.p.a(activity, str);
        net.one97.paytm.wallet.utility.a.a aVar = net.one97.paytm.wallet.utility.a.a.f72261c;
        kotlin.g.b.k.a((Object) a2, "filterMobileNumberP2P");
        aVar.a(activity, a2, "MT_HOME_CONTACTS", str2).observe(this, new c(this, activity, z));
    }

    public final void onResume() {
        boolean z;
        super.onResume();
        if (this.r) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            if (androidx.core.app.a.a(context, "android.permission.READ_CONTACTS") == 0) {
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList = this.k;
                if (arrayList == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                Iterator<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (Integer.valueOf(it2.next().a()).equals(Integer.valueOf(net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_CONTACTS.getId()))) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList2 = this.k;
                    if (arrayList2 == null) {
                        kotlin.g.b.k.a("widgetList");
                    }
                    ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList3 = this.k;
                    if (arrayList3 == null) {
                        kotlin.g.b.k.a("widgetList");
                    }
                    if (arrayList2.get(arrayList3.size() - 1).a() == net.one97.paytm.moneytransferv4.b.a.a.g.WIDGET_TYPE_CONTACT_PERMISSION.getId()) {
                        ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList4 = this.k;
                        if (arrayList4 == null) {
                            kotlin.g.b.k.a("widgetList");
                        }
                        ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList5 = this.k;
                        if (arrayList5 == null) {
                            kotlin.g.b.k.a("widgetList");
                        }
                        arrayList4.remove(arrayList5.size() - 1);
                        net.one97.paytm.moneytransferv4.b.a.a.c cVar = this.f55530f;
                        if (cVar == null) {
                            kotlin.g.b.k.a("adapter");
                        }
                        ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList6 = this.k;
                        if (arrayList6 == null) {
                            kotlin.g.b.k.a("widgetList");
                        }
                        cVar.notifyItemRemoved(arrayList6.size());
                    }
                    net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = this.f55527a;
                    if (dVar == null) {
                        kotlin.g.b.k.a("homeViewModel");
                    }
                    dVar.a();
                    this.r = false;
                }
            }
        }
        l.a aVar = net.one97.paytm.moneytransfer.utils.l.f54175a;
        Context context2 = getContext();
        if (context2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context2, "context!!");
        Context applicationContext = context2.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
        if (l.a.a(applicationContext).b("isRefreshRequired", false, false)) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar2 = this.f55527a;
            if (dVar2 == null) {
                kotlin.g.b.k.a("homeViewModel");
            }
            dVar2.b();
        }
        UPISettingsActivity.a aVar2 = UPISettingsActivity.f68712d;
        if (UPISettingsActivity.v) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar3 = this.f55527a;
            if (dVar3 == null) {
                kotlin.g.b.k.a("homeViewModel");
            }
            dVar3.f();
            UPISettingsActivity.a aVar3 = UPISettingsActivity.f68712d;
            UPISettingsActivity.v = false;
        }
    }

    private final void g() {
        String str;
        Context applicationContext;
        Context context = getContext();
        boolean z = false;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            str = null;
        } else {
            l.a aVar = net.one97.paytm.moneytransfer.utils.l.f54175a;
            str = l.a.a(applicationContext).b("mt_beneficiary_cache", "", false);
        }
        if (str != null) {
            if (str.length() == 0) {
                z = true;
            }
            if (!z) {
                ArrayList arrayList = new ArrayList();
                try {
                    MTBeneficiaryNetworkResponse mTBeneficiaryNetworkResponse = (MTBeneficiaryNetworkResponse) new com.google.gson.f().a(str, MTBeneficiaryNetworkResponse.class);
                    List<ContactsResponse> contacts = mTBeneficiaryNetworkResponse.getResponse().getContacts();
                    if (contacts == null) {
                        kotlin.g.b.k.a();
                    }
                    if (contacts.size() != 0) {
                        List<ContactsResponse> contacts2 = mTBeneficiaryNetworkResponse.getResponse().getContacts();
                        if (contacts2 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (contacts2.size() > 3) {
                            for (ContactsResponse add : mTBeneficiaryNetworkResponse.getResponse().getContacts()) {
                                arrayList.add(add);
                                if (arrayList.size() >= 3) {
                                    break;
                                }
                            }
                            arrayList.add(new MTBeneficiaryViewAll());
                            a((ArrayList<ContactsResponse>) arrayList);
                            return;
                        }
                        List<ContactsResponse> contacts3 = mTBeneficiaryNetworkResponse.getResponse().getContacts();
                        if (contacts3 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (contacts3 != null) {
                            ArrayList arrayList2 = (ArrayList) contacts3;
                            arrayList2.add(new MTBeneficiaryViewAll());
                            a((ArrayList<ContactsResponse>) arrayList2);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.contacts.entities.beans.ContactsResponse>");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private final boolean a(Activity activity) {
        l.a aVar = net.one97.paytm.moneytransfer.utils.l.f54175a;
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        Context applicationContext = context.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
        if (!l.a.a(applicationContext).b("isMtPermissionAskedOnce", false, false) || androidx.core.content.b.a((Context) activity, "android.permission.READ_CONTACTS") == 0 || androidx.core.app.a.a(activity, "android.permission.READ_CONTACTS")) {
            return false;
        }
        return true;
    }

    public final void a(BaseUpiResponse baseUpiResponse, String str, boolean z) {
        kotlin.g.b.k.c(baseUpiResponse, "baseUpiResponse");
        kotlin.g.b.k.c(str, "txId");
        int i2 = 0;
        if (z) {
            net.one97.paytm.moneytransferv4.b.a.a.c cVar = this.f55530f;
            if (cVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            kotlin.g.b.k.c(str, "txId");
            Iterator<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> it2 = cVar.f55344b.iterator();
            while (it2.hasNext()) {
                net.one97.paytm.moneytransferv4.b.a.a.e next = it2.next();
                if (!(next instanceof net.one97.paytm.moneytransferv4.b.a.a.a.d.b)) {
                    next = null;
                }
                net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar = (net.one97.paytm.moneytransferv4.b.a.a.a.d.b) next;
                if (bVar != null) {
                    bVar.a(str);
                    cVar.notifyItemChanged(i2);
                    return;
                }
                i2++;
            }
            return;
        }
        net.one97.paytm.moneytransferv4.b.a.a.c cVar2 = this.f55530f;
        if (cVar2 == null) {
            kotlin.g.b.k.a("adapter");
        }
        int i3 = -1;
        for (Object next2 : cVar2.f55344b) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.k.a();
            }
            net.one97.paytm.moneytransferv4.b.a.a.e eVar = (net.one97.paytm.moneytransferv4.b.a.a.e) next2;
            if (!(eVar instanceof net.one97.paytm.moneytransferv4.b.a.a.a.d.b)) {
                eVar = null;
            }
            if (((net.one97.paytm.moneytransferv4.b.a.a.a.d.b) eVar) != null) {
                i3 = i2;
            }
            i2 = i4;
        }
        if (i3 != -1) {
            cVar2.f55344b.remove(i3);
            cVar2.notifyItemRemoved(i3);
        }
    }

    public final void onDetach() {
        super.onDetach();
        UserActionEvent.INSTANCE.getActionLiveData().setValue(null);
        UserActionEvent.INSTANCE.getActionLiveData().removeObserver(this.u);
    }

    public static void a(Context context, String str, String str2, String str3) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "title");
        kotlin.g.b.k.c(str2, "msg");
        kotlin.g.b.k.c(str3, "buttonText");
        CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
        customWalletAlertDialog.setTitle(str);
        customWalletAlertDialog.setCanceledOnTouchOutside(false);
        customWalletAlertDialog.setCancelable(false);
        customWalletAlertDialog.setMessage(str2);
        customWalletAlertDialog.setButton(-1, str3, new p(customWalletAlertDialog));
        customWalletAlertDialog.show();
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomWalletAlertDialog f55554a;

        p(CustomWalletAlertDialog customWalletAlertDialog) {
            this.f55554a = customWalletAlertDialog;
        }

        public final void onClick(View view) {
            this.f55554a.dismiss();
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        this.f55181d = false;
        super.onAttach(context);
        net.one97.paytm.moneytransfer.utils.o.a().a(this);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        UpiUtils.setStatusBarColor(17170443, activity);
    }

    public static final /* synthetic */ void d(a aVar) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar = aVar.f55527a;
        if (dVar == null) {
            kotlin.g.b.k.a("homeViewModel");
        }
        if (dVar.c()) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar2 = aVar.f55527a;
            if (dVar2 == null) {
                kotlin.g.b.k.a("homeViewModel");
            }
            if (!dVar2.e()) {
                q.a aVar2 = net.one97.paytm.upi.q.f68356a;
                FragmentActivity activity = aVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                q.a.a(activity);
            } else {
                Intent intent = new Intent(aVar.getContext(), UPISettingsActivity.class);
                intent.setFlags(67108864);
                aVar.startActivityForResult(intent, UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
            }
        } else if (UpiUtils.isInActiveProfileExist(aVar.getContext())) {
            aVar.startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(aVar.getContext()), UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
        } else {
            aVar.startActivity(new Intent(aVar.getContext(), UpiSelectBankActivity.class));
        }
        Context context = aVar.getContext();
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar3 = aVar.f55527a;
        if (dVar3 == null) {
            kotlin.g.b.k.a("homeViewModel");
        }
        String valueOf = String.valueOf(dVar3.c());
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d dVar4 = aVar.f55527a;
        if (dVar4 == null) {
            kotlin.g.b.k.a("homeViewModel");
        }
        net.one97.paytm.upi.registration.b.a.a aVar3 = dVar4.f55633g;
        net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SETTINGS_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, valueOf, aVar3 != null ? aVar3.n() : null);
    }

    public static final /* synthetic */ void a(a aVar, ArrayList arrayList) {
        int i2;
        if (!aVar.s) {
            aVar.s = true;
            aVar.a((net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>) new net.one97.paytm.moneytransferv4.b.a.a.a.i.a(aVar.getString(R.string.mt_money_transfer_contacts)));
        }
        if (arrayList != null) {
            ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList2 = aVar.k;
            if (arrayList2 == null) {
                kotlin.g.b.k.a("widgetList");
            }
            int size = arrayList2.size();
            int i3 = -1;
            ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList3 = aVar.k;
            if (arrayList3 == null) {
                kotlin.g.b.k.a("widgetList");
            }
            int i4 = 0;
            for (Object next : arrayList3) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    kotlin.a.k.a();
                }
                net.one97.paytm.moneytransferv4.b.a.a.e eVar = (net.one97.paytm.moneytransferv4.b.a.a.e) next;
                if (!(eVar instanceof net.one97.paytm.moneytransferv4.b.a.a.a.i.a)) {
                    eVar = null;
                }
                if (((net.one97.paytm.moneytransferv4.b.a.a.a.i.a) eVar) != null) {
                    i3 = i4;
                }
                i4 = i5;
            }
            if (i3 >= 0 && size > (i2 = i3 + 1)) {
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList4 = aVar.k;
                if (arrayList4 == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                List<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> subList = arrayList4.subList(i2, size);
                kotlin.g.b.k.a((Object) subList, "widgetList.subList(contactTitleIndex + 1, size)");
                RecyclerView recyclerView = aVar.f55529e;
                if (recyclerView == null) {
                    kotlin.g.b.k.a("parentRecyclerView");
                }
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemRangeRemoved(i2, subList.size());
                }
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList5 = aVar.k;
                if (arrayList5 == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                arrayList5.subList(i2, size).clear();
                ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList6 = aVar.k;
                if (arrayList6 == null) {
                    kotlin.g.b.k.a("widgetList");
                }
                size = arrayList6.size();
            }
            ArrayList<net.one97.paytm.moneytransferv4.b.a.a.e<RecyclerView.v>> arrayList7 = aVar.k;
            if (arrayList7 == null) {
                kotlin.g.b.k.a("widgetList");
            }
            arrayList7.addAll(arrayList);
            RecyclerView recyclerView2 = aVar.f55529e;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a("parentRecyclerView");
            }
            RecyclerView.a adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemRangeInserted(size, arrayList.size());
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        net.one97.paytm.moneytransferv4.b.a.a.a.j.a aVar2 = new net.one97.paytm.moneytransferv4.b.a.a.a.j.a();
        aVar2.f55320a = list;
        net.one97.paytm.moneytransferv4.b.a.a.c cVar = aVar.f55530f;
        if (cVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        cVar.a((net.one97.paytm.moneytransferv4.b.a.a.a) aVar2);
    }

    public static final /* synthetic */ void g(a aVar) {
        com.paytm.b.a.a aVar2;
        Context applicationContext;
        Context context = aVar.getContext();
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            aVar2 = null;
        } else {
            l.a aVar3 = net.one97.paytm.moneytransfer.utils.l.f54175a;
            aVar2 = l.a.a(applicationContext);
        }
        if (aVar2 != null) {
            aVar2.a("set_pin_prev_time", System.currentTimeMillis(), false);
        }
    }

    public static final /* synthetic */ void a(a aVar, a.b bVar) {
        if (bVar != null) {
            if (bVar.f53978b) {
                aVar.b();
            }
            ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = bVar.f53977a;
            if (paymentOptionList != null) {
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment = paymentOptionList.getDestinationPayment();
                kotlin.g.b.k.a((Object) destinationPayment, "paymentOptionListItem.destinationPayment");
                if (destinationPayment.getError() != null) {
                    aVar.b();
                    return;
                }
                ConsolidatePaymentInstrumentationRes.SourcePayment sourcePayment = paymentOptionList.getSourcePayment();
                kotlin.g.b.k.a((Object) sourcePayment, "paymentOptionListItem.sourcePayment");
                if (kotlin.m.p.a(sourcePayment.getPaymentType(), PaymentInstrumentationType.UPI_LEAD.name(), true)) {
                    aVar.d();
                    return;
                }
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment2 = paymentOptionList.getDestinationPayment();
                kotlin.g.b.k.a((Object) destinationPayment2, "paymentOptionListItem.destinationPayment");
                if (kotlin.m.p.a(destinationPayment2.getPaymentType(), PaymentInstrumentationType.UPI.name(), true)) {
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment3 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment3, "paymentOptionListItem.destinationPayment");
                    String vpaId = destinationPayment3.getVpaId();
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment4 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment4, "paymentOptionListItem.destinationPayment");
                    String displayName = destinationPayment4.getDisplayName();
                    net.one97.paytm.moneytransfer.utils.f.a(aVar.getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SELECTED_CONTACT_STATUS, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "linked_upi", "");
                    int i2 = R.id.container;
                    a.C0982a aVar2 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                    PaymentManager paymentManager = PaymentManager.f54783a;
                    net.one97.paytm.moneytransfer.utils.m.a(i2, (Fragment) a.C0982a.a(PaymentManager.a(vpaId, displayName, (String) null, (String) null, (String) null, (String) null, (String) null, 252), aVar.getActivity(), 12), "BeneficiaryHistoryFragment", aVar.getFragmentManager());
                    return;
                }
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment5 = paymentOptionList.getDestinationPayment();
                kotlin.g.b.k.a((Object) destinationPayment5, "paymentOptionListItem.destinationPayment");
                if (kotlin.m.p.a(destinationPayment5.getPaymentType(), PaymentInstrumentationType.BANK.name(), true)) {
                    net.one97.paytm.moneytransfer.utils.f.a(aVar.getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SELECTED_CONTACT_STATUS, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "linked_bank", "");
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment6 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment6, "paymentOptionListItem.destinationPayment");
                    String bankAccountNumber = destinationPayment6.getBankAccountNumber();
                    net.one97.paytm.moneytransfer.contacts.b.a aVar3 = aVar.n;
                    if (aVar3 == null) {
                        kotlin.g.b.k.a("contactsViewModel");
                    }
                    String a2 = aVar3.a();
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment7 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment7, "paymentOptionListItem.destinationPayment");
                    String ifscCode = destinationPayment7.getIfscCode();
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment8 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment8, "paymentOptionListItem.destinationPayment");
                    String bankName = destinationPayment8.getBankName();
                    int i3 = R.id.container;
                    a.C0982a aVar4 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                    PaymentManager paymentManager2 = PaymentManager.f54783a;
                    net.one97.paytm.moneytransfer.contacts.b.a aVar5 = aVar.n;
                    if (aVar5 == null) {
                        kotlin.g.b.k.a("contactsViewModel");
                    }
                    net.one97.paytm.moneytransfer.utils.m.a(i3, (Fragment) a.C0982a.a(PaymentManager.a(bankAccountNumber, a2, bankName, ifscCode, aVar5.f53975g, (String) null, (String) null, Constants.EASY_PAY_INVISIBLE_ASSIST), aVar.getActivity(), 12), "BeneficiaryHistoryFragment", aVar.getFragmentManager());
                }
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, UpiCustomVolleyError upiCustomVolleyError) {
        String str = null;
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equals(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
            net.one97.paytm.moneytransfer.utils.m.b((Activity) aVar.getActivity());
            return;
        }
        if (UpiConstants.NETWORK_ERROR_CODE.equals(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
            aVar.a(upiCustomVolleyError);
            return;
        }
        if (upiCustomVolleyError != null) {
            str = upiCustomVolleyError.getmErrorCode();
        }
        if ("1997".equals(str)) {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            Context context = aVar.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.moneytransfer.contacts.b.a aVar3 = aVar.n;
            if (aVar3 == null) {
                kotlin.g.b.k.a("contactsViewModel");
            }
            b2.a(context, aVar3.b());
            return;
        }
        aVar.b();
    }

    public static final /* synthetic */ void a(a aVar, ContactsResponse contactsResponse) {
        PaymentManager paymentManager = PaymentManager.f54783a;
        PaymentManager.PaymentUiModel a2 = PaymentManager.a(contactsResponse);
        int i2 = R.id.container;
        a.C0982a aVar2 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
        net.one97.paytm.moneytransfer.utils.m.a(i2, (Fragment) a.C0982a.a(a2, aVar.getActivity(), 12), "BeneficiaryHistoryFragment", aVar.getFragmentManager());
    }

    public static final /* synthetic */ void l(a aVar) {
        net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
        FragmentActivity requireActivity = aVar.requireActivity();
        kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
        Intent a2 = net.one97.paytm.wallet.utility.d.a(requireActivity);
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        a2.putExtra(net.one97.paytm.contacts.utils.e.h(), e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType());
        aVar.startActivityForResult(a2, aVar.q);
    }
}
