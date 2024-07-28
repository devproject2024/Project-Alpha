package net.one97.paytm.vipcashback.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.common.entity.vipcashback.MerchantStage;
import net.one97.paytm.common.entity.vipcashback.MerchantTransactions;
import net.one97.paytm.common.entity.vipcashback.TransactionsItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.a.f;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class e extends a implements com.paytm.network.listener.b {
    public static final a m = new a((byte) 0);

    /* renamed from: h  reason: collision with root package name */
    public String f20972h;

    /* renamed from: i  reason: collision with root package name */
    public MerchantStage f20973i;
    public f j;
    public ArrayList<TransactionsItem> k;
    public net.one97.paytm.vipcashback.d.a l;
    private HashMap n;

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = null;
        String string = arguments != null ? arguments.getString("gameid") : null;
        if (string == null) {
            k.a();
        }
        this.f20972h = string;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            serializable = arguments2.getSerializable("stageItem");
        }
        if (serializable != null) {
            this.f20973i = (MerchantStage) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.MerchantStage");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_merchant_transactions, (ViewGroup) null);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.k = new ArrayList<>();
        this.l = new net.one97.paytm.vipcashback.d.a(true);
        RecyclerView recyclerView = (RecyclerView) a(R.id.recycler_view);
        Context context = this.f20915b;
        if (context == null) {
            k.a();
        }
        Drawable a2 = androidx.core.content.b.a(context, net.one97.paytm.common.widgets.R.drawable.divider);
        if (a2 == null) {
            k.a();
        }
        k.a((Object) a2, "ContextCompat.getDrawabl…ets.R.drawable.divider)!!");
        recyclerView.addItemDecoration(new net.one97.paytm.vipcashback.widget.a(a2));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.recycler_view);
        k.a((Object) recyclerView2, "recycler_view");
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.f20915b));
        Context context2 = this.f20915b;
        if (context2 == null) {
            k.a();
        }
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.recycler_view);
        k.a((Object) recyclerView3, "recycler_view");
        ArrayList<TransactionsItem> arrayList = this.k;
        if (arrayList == null) {
            k.a("mArrayList");
        }
        this.j = new f(context2, recyclerView3, arrayList);
        RecyclerView recyclerView4 = (RecyclerView) a(R.id.recycler_view);
        k.a((Object) recyclerView4, "recycler_view");
        f fVar = this.j;
        if (fVar == null) {
            k.a("mTransactionsAdapter");
        }
        recyclerView4.setAdapter(fVar);
        b();
    }

    public final void b() {
        MerchantStage merchantStage = this.f20973i;
        if (merchantStage == null) {
            k.a("mStage");
        }
        ArrayList<Integer> stage = merchantStage.getStage();
        String str = "";
        if ((stage != null ? stage.size() : 0) > 0) {
            MerchantStage merchantStage2 = this.f20973i;
            if (merchantStage2 == null) {
                k.a("mStage");
            }
            int size = merchantStage2.getStage().size() - 1;
            if (size >= 0) {
                int i2 = 0;
                while (true) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    MerchantStage merchantStage3 = this.f20973i;
                    if (merchantStage3 == null) {
                        k.a("mStage");
                    }
                    sb.append(merchantStage3.getStage().get(i2));
                    sb.append(AppConstants.COMMA);
                    str = sb.toString();
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            int length = str.length() - 1;
            if (str != null) {
                str = str.substring(0, length);
                k.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        net.one97.paytm.vipcashback.d.a aVar = this.l;
        if (aVar == null) {
            k.a("mVipCashbackDataModel");
        }
        com.paytm.network.listener.b bVar = this;
        String str2 = this.f20972h;
        if (str2 == null) {
            k.a("mGameId");
        }
        String str3 = this.f20914a;
        k.a((Object) str3, "TAG");
        k.c(bVar, "apiListener");
        k.c(str2, "gameId");
        k.c(str, "stages");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        String j2 = net.one97.paytm.vipcashback.f.f.j();
        if (j2 != null) {
            if (j2.length() == 0) {
                j2 = "https://gateway.paytm.com/api/v1/mpromocard/supercash/{id}/transactions";
            }
        }
        k.a((Object) j2, "url");
        a.l.C0393a aVar2 = a.l.f20828a;
        String a2 = p.a(j2, a.l.f20829b, str2, false);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a2);
        sb2.append("?game_id=");
        sb2.append(str2);
        sb2.append(AppConstants.AND_SIGN);
        sb2.append(aVar.f20761c);
        sb2.append("=");
        sb2.append(str);
        sb2.append(AppConstants.AND_SIGN);
        sb2.append(aVar.f20763e);
        sb2.append("=20&");
        sb2.append(aVar.f20765g);
        sb2.append("=");
        String encode = URLEncoder.encode(aVar.k, AppConstants.UTF_8);
        k.a((Object) encode, "URLEncoder.encode(oldestTxnTime, \"UTF-8\")");
        sb2.append(p.a(encode, " ", "%20", false));
        String sb3 = sb2.toString();
        d.a aVar3 = d.f20859a;
        com.paytm.network.a l2 = d.a.c().a(a.C0715a.GET).a(sb3).a((Map<String, String>) net.one97.paytm.vipcashback.d.a.a()).a((IJRPaytmDataModel) new MerchantTransactions()).c(str3).a(bVar).l();
        k.a((Object) l2, "networkCall");
        if (com.paytm.utility.b.c(this.f20915b)) {
            f fVar = this.j;
            if (fVar == null) {
                k.a("mTransactionsAdapter");
            }
            fVar.b();
            l2.a();
            return;
        }
        a(l2);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        MerchantTransactions.Data data;
        ArrayList<TransactionsItem> transactions;
        if (isAdded()) {
            e();
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof MerchantTransactions)) {
                f();
                return;
            }
            MerchantTransactions merchantTransactions = (MerchantTransactions) iJRPaytmDataModel;
            if (merchantTransactions.getStatus() == 1 && merchantTransactions.getData() != null) {
                MerchantTransactions.Data data2 = merchantTransactions.getData();
                if ((data2 != null ? data2.getTransactions() : null) == null || (data = merchantTransactions.getData()) == null || (transactions = data.getTransactions()) == null || transactions.isEmpty()) {
                    f();
                } else {
                    f fVar = this.j;
                    if (fVar == null) {
                        k.a("mTransactionsAdapter");
                    }
                    MerchantTransactions.Data data3 = merchantTransactions.getData();
                    k.a((Object) data3, "response.data");
                    ArrayList<TransactionsItem> transactions2 = data3.getTransactions();
                    k.a((Object) transactions2, "response.data.transactions");
                    k.c(transactions2, "newData");
                    fVar.f20634a.addAll(transactions2);
                    fVar.notifyDataSetChanged();
                    net.one97.paytm.vipcashback.d.a aVar = this.l;
                    if (aVar == null) {
                        k.a("mVipCashbackDataModel");
                    }
                    MerchantTransactions.Data data4 = merchantTransactions.getData();
                    k.a((Object) data4, "response.data");
                    String oldestTxnTime = data4.getOldestTxnTime();
                    k.a((Object) oldestTxnTime, "response.data.oldestTxnTime");
                    k.c(oldestTxnTime, "<set-?>");
                    aVar.k = oldestTxnTime;
                }
                net.one97.paytm.vipcashback.d.a aVar2 = this.l;
                if (aVar2 == null) {
                    k.a("mVipCashbackDataModel");
                }
                aVar2.f20766h++;
                MerchantTransactions.Data data5 = merchantTransactions.getData();
                k.a((Object) data5, "response.data");
                if (data5.isNext()) {
                    f fVar2 = this.j;
                    if (fVar2 == null) {
                        k.a("mTransactionsAdapter");
                    }
                    fVar2.a((kotlin.g.a.a<x>) new b(this));
                    return;
                }
                f fVar3 = this.j;
                if (fVar3 == null) {
                    k.a("mTransactionsAdapter");
                }
                fVar3.a((kotlin.g.a.a<x>) null);
            } else if (merchantTransactions.getErrors() != null && merchantTransactions.getErrors().size() > 0) {
                d.a aVar3 = d.f20859a;
                GetVIPCashBackErrorModal getVIPCashBackErrorModal = merchantTransactions.getErrors().get(0);
                k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                a(d.a.a(getVIPCashBackErrorModal));
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "p2");
        e();
        a(networkCustomError);
    }

    static final class b extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.this$0 = eVar;
        }

        public final void invoke() {
            this.this$0.b();
        }
    }

    private void e() {
        f fVar = this.j;
        if (fVar == null) {
            k.a("mTransactionsAdapter");
        }
        net.one97.paytm.vipcashback.a.b.a((net.one97.paytm.vipcashback.a.b) fVar);
    }

    private void f() {
        net.one97.paytm.vipcashback.d.a aVar = this.l;
        if (aVar == null) {
            k.a("mVipCashbackDataModel");
        }
        if (aVar.f20766h == 1) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.noOffersView);
            k.a((Object) linearLayout, "noOffersView");
            linearLayout.setVisibility(0);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
