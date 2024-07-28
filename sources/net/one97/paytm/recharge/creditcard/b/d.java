package net.one97.paytm.recharge.creditcard.b;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.creditcard.a.a;
import net.one97.paytm.recharge.creditcard.c.a;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.a;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRDeleteCard;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class d extends Fragment implements AdapterView.OnItemClickListener, z<CJRTaggedObservable<?>>, a.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62443a = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String n;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.recharge.creditcard.c.a f62444b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.recharge.creditcard.a.a f62445c;

    /* renamed from: d  reason: collision with root package name */
    private b f62446d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.LayoutManager f62447e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f62448f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressDialog f62449g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f62450h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.h.d f62451i;
    private final String j = "credit_card";
    private ListPopupWindow k;
    private CJRCreditCardModelV8 l;
    private List<CJRCreditCardModelV8> m;
    private HashMap o;

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r4.isFinishing() != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onChanged(java.lang.Object r7) {
        /*
            r6 = this;
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r7 = (net.one97.paytm.recharge.widgets.model.CJRTaggedObservable) r7
            r0 = 0
            if (r7 == 0) goto L_0x000a
            java.lang.String r1 = r7.getTag()
            goto L_0x000b
        L_0x000a:
            r1 = r0
        L_0x000b:
            if (r1 != 0) goto L_0x000e
            return
        L_0x000e:
            int r2 = r1.hashCode()
            r3 = 1204986086(0x47d2a0e6, float:107841.8)
            if (r2 == r3) goto L_0x0019
            goto L_0x0159
        L_0x0019:
            java.lang.String r2 = "tag.delete.saved.card"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0159
            java.lang.Object r7 = r7.getData()
            boolean r1 = r7 instanceof net.one97.paytm.recharge.model.v4.Data
            if (r1 != 0) goto L_0x002a
            r7 = r0
        L_0x002a:
            net.one97.paytm.recharge.model.v4.Data r7 = (net.one97.paytm.recharge.model.v4.Data) r7
            if (r7 == 0) goto L_0x0033
            net.one97.paytm.recharge.model.v4.DataState r1 = r7.getDataState()
            goto L_0x0034
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x00e3
            net.one97.paytm.recharge.model.v4.DataState r1 = r7.getDataState()
            int[] r2 = net.one97.paytm.recharge.creditcard.b.e.f62457a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0057
            r2 = 2
            if (r1 == r2) goto L_0x0052
            r2 = 3
            if (r1 == r2) goto L_0x004d
            goto L_0x00e3
        L_0x004d:
            r6.b()
            goto L_0x00e3
        L_0x0052:
            r6.b()
            goto L_0x00e3
        L_0x0057:
            android.content.Context r1 = r6.getContext()
            java.lang.String r3 = "Processing"
            java.lang.String r4 = "message"
            kotlin.g.b.k.c(r3, r4)
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()
            if (r4 == 0) goto L_0x00e3
            boolean r4 = r6.isAdded()
            if (r4 != 0) goto L_0x0070
            goto L_0x00e3
        L_0x0070:
            if (r1 != 0) goto L_0x0086
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()
            if (r4 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            java.lang.String r5 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            boolean r4 = r4.isFinishing()
            if (r4 == 0) goto L_0x00e3
        L_0x0086:
            android.app.ProgressDialog r4 = r6.f62449g
            if (r4 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x0095
            boolean r4 = r4.isShowing()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x0096
        L_0x0095:
            r4 = r0
        L_0x0096:
            if (r4 != 0) goto L_0x009b
            kotlin.g.b.k.a()
        L_0x009b:
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00ab
            android.app.ProgressDialog r1 = r6.f62449g
            if (r1 == 0) goto L_0x00e3
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setMessage(r3)
            goto L_0x00e3
        L_0x00ab:
            android.app.ProgressDialog r4 = new android.app.ProgressDialog
            r4.<init>(r1)
            r6.f62449g = r4
            android.app.ProgressDialog r1 = r6.f62449g     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00ba
            r4 = 0
            r1.setProgressStyle(r4)     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
        L_0x00ba:
            android.app.ProgressDialog r1 = r6.f62449g     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00c3
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            r1.setMessage(r3)     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
        L_0x00c3:
            android.app.ProgressDialog r1 = r6.f62449g     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00ca
            r1.setCancelable(r2)     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
        L_0x00ca:
            android.app.ProgressDialog r1 = r6.f62449g     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00d1
            r1.setCanceledOnTouchOutside(r2)     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
        L_0x00d1:
            android.app.ProgressDialog r1 = r6.f62449g     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00e3
            r1.show()     // Catch:{ IllegalArgumentException -> 0x00db, Exception -> 0x00d9 }
            goto L_0x00e3
        L_0x00d9:
            goto L_0x00e3
        L_0x00db:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.d(r1)
        L_0x00e3:
            if (r7 == 0) goto L_0x00ec
            java.lang.Object r1 = r7.getData()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r1
            goto L_0x00ed
        L_0x00ec:
            r1 = r0
        L_0x00ed:
            if (r1 == 0) goto L_0x0159
            java.lang.Object r7 = r7.getData()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r7 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r7
            net.one97.paytm.recharge.creditcard.a.a r1 = r6.f62445c
            java.lang.String r2 = "mCJRSavedCardRvAdapter"
            if (r1 != 0) goto L_0x00fe
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00fe:
            net.one97.paytm.recharge.creditcard.a.a r1 = r6.f62445c
            if (r1 != 0) goto L_0x0105
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0105:
            if (r7 != 0) goto L_0x010a
            kotlin.g.b.k.a()
        L_0x010a:
            java.lang.String r2 = "card"
            kotlin.g.b.k.c(r7, r2)
            java.util.List<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8> r2 = r1.f62353b
            r2.remove(r7)
            r1.notifyDataSetChanged()
            java.util.List<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8> r2 = r1.f62353b
            int r2 = r2.size()
            if (r2 != 0) goto L_0x012f
            net.one97.paytm.recharge.creditcard.a.a$d r1 = r1.f62352a
            if (r1 == 0) goto L_0x012f
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = new net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8
            r1.<init>()
            int r2 = r1.getFreshCardId()
            r1.setCardTypeId(r2)
        L_0x012f:
            int r1 = r7.getCardTypeId()
            int r7 = r7.getRecentCardId()
            if (r1 != r7) goto L_0x0159
            android.content.Context r7 = r6.getContext()
            boolean r7 = r7 instanceof net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity
            if (r7 == 0) goto L_0x0159
            androidx.fragment.app.Fragment r7 = r6.getParentFragment()
            boolean r7 = r7 instanceof net.one97.paytm.recharge.creditcard.b.a
            if (r7 == 0) goto L_0x0159
            androidx.fragment.app.Fragment r7 = r6.getParentFragment()
            boolean r1 = r7 instanceof net.one97.paytm.recharge.creditcard.b.a
            if (r1 != 0) goto L_0x0152
            r7 = r0
        L_0x0152:
            net.one97.paytm.recharge.creditcard.b.a r7 = (net.one97.paytm.recharge.creditcard.b.a) r7
            if (r7 == 0) goto L_0x0159
            r7.c()
        L_0x0159:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.d.onChanged(java.lang.Object):void");
    }

    private void b() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                if (this.f62449g != null) {
                    ProgressDialog progressDialog = this.f62449g;
                    Boolean valueOf = progressDialog != null ? Boolean.valueOf(progressDialog.isShowing()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (valueOf.booleanValue()) {
                        FragmentActivity activity = getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        k.a((Object) activity, "activity!!");
                        if (!activity.isFinishing()) {
                            ProgressDialog progressDialog2 = this.f62449g;
                            if (progressDialog2 != null) {
                                progressDialog2.dismiss();
                            }
                            this.f62449g = null;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public final void a(View view, CJRCreditCardModelV8 cJRCreditCardModelV8) {
        k.c(view, "view");
        k.c(cJRCreditCardModelV8, BaseViewModel.PaymentType.CARD);
        if (getContext() != null) {
            this.l = cJRCreditCardModelV8;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            this.k = new ListPopupWindow(context);
            List arrayList = new ArrayList();
            Context context2 = getContext();
            String string = context2 != null ? context2.getString(R.string.visa_delete_card) : null;
            if (string == null) {
                k.a();
            }
            k.a((Object) string, "context?.getString(R.string.visa_delete_card)!!");
            arrayList.add(string);
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.f62451i;
            if (dVar != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.j, "saved_card_kebab_menu_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
            }
            ListPopupWindow listPopupWindow = this.k;
            if (listPopupWindow == null) {
                k.a();
            }
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            listPopupWindow.setAdapter(new ArrayAdapter(context3, R.layout.visa_popupwindow_listitem, arrayList));
            ListPopupWindow listPopupWindow2 = this.k;
            if (listPopupWindow2 == null) {
                k.a();
            }
            listPopupWindow2.setAnchorView(view);
            ListPopupWindow listPopupWindow3 = this.k;
            if (listPopupWindow3 == null) {
                k.a();
            }
            listPopupWindow3.setOnItemClickListener(this);
            ListPopupWindow listPopupWindow4 = this.k;
            if (listPopupWindow4 == null) {
                k.a();
            }
            listPopupWindow4.show();
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        ListPopupWindow listPopupWindow = this.k;
        if (listPopupWindow != null) {
            listPopupWindow.dismiss();
        }
        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.l;
        if (cJRCreditCardModelV8 != null) {
            if (cJRCreditCardModelV8 == null) {
                k.a();
            }
            int cardTypeId = cJRCreditCardModelV8.getCardTypeId();
            CJRCreditCardModelV8 cJRCreditCardModelV82 = this.l;
            if (cJRCreditCardModelV82 == null) {
                k.a();
            }
            boolean z = false;
            if (cardTypeId == cJRCreditCardModelV82.getSavedCardId()) {
                net.one97.paytm.recharge.ordersummary.h.d dVar = this.f62451i;
                if (dVar != null) {
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.j, "saved_card_delete_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
                }
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62444b;
                if (aVar == null) {
                    k.a("mViewModel");
                }
                CJRCreditCardModelV8 cJRCreditCardModelV83 = this.l;
                if (cJRCreditCardModelV83 == null) {
                    k.a();
                }
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                k.c("delete_saved_card_api", "tag");
                k.c(cJRCreditCardModelV83, BaseViewModel.PaymentType.CARD);
                k.c(context, "context");
                CharSequence cardId = cJRCreditCardModelV83.getCardId();
                if (cardId == null || cardId.length() == 0) {
                    z = true;
                }
                if (!z) {
                    aVar.U = cJRCreditCardModelV83;
                    String cardId2 = cJRCreditCardModelV83.getCardId();
                    if (cardId2 == null) {
                        k.a();
                    }
                    String a3 = net.one97.paytm.recharge.creditcard.c.a.a(cardId2, context);
                    CJRRechargeUtilities.INSTANCE.getSSOToken(context);
                    HashMap hashMap = new HashMap();
                    if (com.paytm.utility.b.c(context)) {
                        aVar.P.postValue(new CJRTaggedObservable("tag.delete.saved.card", new Data(DataState.LOADING, null, (String) null)));
                        context.getApplicationContext();
                        net.one97.paytm.recharge.common.f.d.a();
                        net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("delete_saved_card_api", a3, (ai) new a.e(aVar), (IJRPaytmDataModel) new CJRDeleteCard(), (Map<String, String>) hashMap, (Map<String, String>) null, (String) null, (Object) a2));
                        return;
                    }
                    aVar.a((net.one97.paytm.recharge.common.f.a) new net.one97.paytm.recharge.common.f.c("delete_saved_card_api", a3, (ai) new a.f(aVar), (IJRPaytmDataModel) new CJRDeleteCard(), (Map<String, String>) hashMap, (Map<String, String>) null, (String) null, (Object) a2), context);
                    return;
                }
                return;
            }
            CJRCreditCardModelV8 cJRCreditCardModelV84 = this.l;
            if (cJRCreditCardModelV84 == null) {
                k.a();
            }
            int cardTypeId2 = cJRCreditCardModelV84.getCardTypeId();
            CJRCreditCardModelV8 cJRCreditCardModelV85 = this.l;
            if (cJRCreditCardModelV85 == null) {
                k.a();
            }
            if (cardTypeId2 == cJRCreditCardModelV85.getRecentCardId()) {
                net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62444b;
                if (aVar2 == null) {
                    k.a("mViewModel");
                }
                CJRCreditCardModelV8 cJRCreditCardModelV86 = this.l;
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                k.a((Object) context2, "context!!");
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                k.c("delete_recent_card_api", "tag");
                k.c(context2, "context");
                if (cJRCreditCardModelV86 != null) {
                    CharSequence favOrderId = cJRCreditCardModelV86.getFavOrderId();
                    if (favOrderId == null || favOrderId.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        aVar2.U = cJRCreditCardModelV86;
                        String favOrderId2 = cJRCreditCardModelV86.getFavOrderId();
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        String u = net.one97.paytm.recharge.di.helper.c.u();
                        String a5 = com.paytm.utility.c.a(context2, true);
                        CJRFrequentOrderList cJRFrequentOrderList = new CJRFrequentOrderList();
                        if (com.paytm.utility.b.c(context2)) {
                            Map hashMap2 = new HashMap();
                            hashMap2.put("Content-Type", "application/json");
                            String d2 = net.one97.paytm.recharge.creditcard.c.a.d(favOrderId2);
                            if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(u)) {
                                aVar2.P.postValue(new CJRTaggedObservable("tag.delete.saved.card", new Data(DataState.LOADING, null, (String) null)));
                                net.one97.paytm.recharge.common.f.d.a();
                                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("delete_recent_card_api", k.a(u, (Object) a5), (ai) new a.c(aVar2), (IJRPaytmDataModel) cJRFrequentOrderList, (Map<String, String>) null, (Map<String, String>) hashMap2, d2, (Object) a4));
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String name = d.class.getName();
        k.a((Object) name, "FJRSavedCardsFragmentV3::class.java.name");
        n = name;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.f62451i = new net.one97.paytm.recharge.ordersummary.h.d(context);
        }
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            String lowerCase = "/credit_card/recents".toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), lowerCase);
        } catch (Throwable unused) {
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("saved_cards_list");
            if (serializable != null) {
                this.m = ab.c(serializable);
                this.f62450h = arguments.getBoolean("is_recharge_tabs_flow", false);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>");
            }
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.lifecycle.ai a2 = am.a(activity).a(net.one97.paytm.recharge.creditcard.c.a.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…dViewModelV2::class.java)");
        this.f62444b = (net.one97.paytm.recharge.creditcard.c.a) a2;
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62444b;
        if (aVar == null) {
            k.a("mViewModel");
        }
        aVar.P.observe(this, this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.lyt_fragment_savedcardsv3, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r10.m.containsKey("cardId") != false) goto L_0x0077;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r10, r0)
            super.onViewCreated(r10, r11)
            int r11 = net.one97.paytm.recharge.R.id.savedcard_listView
            android.view.View r10 = r10.findViewById(r11)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            r9.f62448f = r10
            androidx.recyclerview.widget.RecyclerView r10 = r9.f62448f
            if (r10 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            r11 = 0
            r10.setNestedScrollingEnabled(r11)
            androidx.recyclerview.widget.RecyclerView r10 = r9.f62448f
            r0 = 1
            if (r10 == 0) goto L_0x0026
            r10.setHasFixedSize(r0)
        L_0x0026:
            androidx.recyclerview.widget.LinearLayoutManager r10 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            r10.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r10 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r10
            r9.f62447e = r10
            androidx.recyclerview.widget.RecyclerView r10 = r9.f62448f
            if (r10 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r9.f62447e
            r10.setLayoutManager(r1)
            net.one97.paytm.recharge.creditcard.c.a r10 = r9.f62444b
            java.lang.String r1 = "mViewModel"
            if (r10 != 0) goto L_0x004a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x004a:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r10.m
            java.util.Map r10 = (java.util.Map) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r0
            if (r10 == 0) goto L_0x015f
            net.one97.paytm.recharge.creditcard.c.a r10 = r9.f62444b
            if (r10 != 0) goto L_0x005c
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x005c:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r10.m
            java.lang.String r2 = "recharge_number"
            boolean r10 = r10.containsKey(r2)
            java.lang.String r3 = "cardId"
            if (r10 != 0) goto L_0x0077
            net.one97.paytm.recharge.creditcard.c.a r10 = r9.f62444b
            if (r10 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006f:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r10.m
            boolean r10 = r10.containsKey(r3)
            if (r10 == 0) goto L_0x015f
        L_0x0077:
            net.one97.paytm.recharge.creditcard.c.a r10 = r9.f62444b
            if (r10 != 0) goto L_0x007e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007e:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r10.m
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r10 = (java.lang.String) r10
            net.one97.paytm.recharge.creditcard.c.a r2 = r9.f62444b
            if (r2 != 0) goto L_0x008d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x008d:
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r2.m
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = ""
            r4 = 0
            if (r10 == 0) goto L_0x00a1
            java.lang.String r5 = " "
            java.lang.String r10 = kotlin.m.p.a(r10, r5, r3, r11)
            goto L_0x00a2
        L_0x00a1:
            r10 = r4
        L_0x00a2:
            r5 = r10
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x00d3
            if (r10 != 0) goto L_0x00b0
            kotlin.g.b.k.a()
        L_0x00b0:
            int r6 = r10.length()
            r7 = 5
            if (r6 <= r7) goto L_0x00d3
            r3 = 6
            java.lang.CharSequence r3 = r10.subSequence(r11, r3)
            java.lang.String r3 = r3.toString()
            int r6 = r10.length()
            int r6 = r6 + -4
            int r7 = r10.length()
            java.lang.CharSequence r10 = r10.subSequence(r6, r7)
            java.lang.String r10 = r10.toString()
            goto L_0x00d4
        L_0x00d3:
            r10 = r3
        L_0x00d4:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00e8
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00e4
            goto L_0x00e8
        L_0x00e4:
            r9.c()
            return
        L_0x00e8:
            java.util.List<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8> r5 = r9.m
            if (r5 != 0) goto L_0x00f1
            java.lang.String r6 = "mSavedCardList"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00f1:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00f7:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0136
            java.lang.Object r6 = r5.next()
            r7 = r6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r7 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r7
            java.lang.String r8 = r7.getFirstSixDigits()
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0118
            java.lang.String r8 = r7.getLastFourDigits()
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x0130
        L_0x0118:
            if (r2 == 0) goto L_0x0124
            java.lang.String r8 = r7.getCardId()
            boolean r8 = r2.equals(r8)
            if (r8 == r0) goto L_0x0130
        L_0x0124:
            if (r2 == 0) goto L_0x0132
            java.lang.String r7 = r7.getCardId2()
            boolean r7 = r2.equals(r7)
            if (r7 != r0) goto L_0x0132
        L_0x0130:
            r7 = 1
            goto L_0x0133
        L_0x0132:
            r7 = 0
        L_0x0133:
            if (r7 == 0) goto L_0x00f7
            goto L_0x0137
        L_0x0136:
            r6 = r4
        L_0x0137:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r6
            if (r6 == 0) goto L_0x015b
            r9.a((net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r6, (boolean) r11, (java.util.HashMap<java.lang.String, android.view.View>) r4, (boolean) r0)
            androidx.recyclerview.widget.RecyclerView r10 = r9.f62448f
            if (r10 == 0) goto L_0x014e
            net.one97.paytm.recharge.creditcard.b.d$c r11 = new net.one97.paytm.recharge.creditcard.b.d$c
            r11.<init>(r9)
            java.lang.Runnable r11 = (java.lang.Runnable) r11
            r2 = 300(0x12c, double:1.48E-321)
            r10.postDelayed(r11, r2)
        L_0x014e:
            net.one97.paytm.recharge.creditcard.c.a r10 = r9.f62444b
            if (r10 != 0) goto L_0x0155
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0155:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r10.m
            r10.clear()
            return
        L_0x015b:
            r9.c()
            return
        L_0x015f:
            r9.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f62456a;

        c(d dVar) {
            this.f62456a = dVar;
        }

        public final void run() {
            this.f62456a.c();
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        String str;
        if (getContext() == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        List<CJRCreditCardModelV8> list = this.m;
        if (list == null) {
            k.a("mSavedCardList");
        }
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62444b;
        if (aVar == null) {
            k.a("mViewModel");
        }
        CJRCategoryData cJRCategoryData = aVar.R;
        String str2 = null;
        if (cJRCategoryData != null) {
            str = cJRCategoryData.getCategoryHeader();
        } else {
            str = null;
        }
        net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62444b;
        if (aVar2 == null) {
            k.a("mViewModel");
        }
        CJRCategoryData cJRCategoryData2 = aVar2.R;
        if (cJRCategoryData2 != null) {
            str2 = cJRCategoryData2.getDisclaimer();
        }
        this.f62445c = new net.one97.paytm.recharge.creditcard.a.a(context, list, str, str2);
        net.one97.paytm.recharge.creditcard.a.a aVar3 = this.f62445c;
        if (aVar3 == null) {
            k.a("mCJRSavedCardRvAdapter");
        }
        aVar3.a(this);
        RecyclerView recyclerView = this.f62448f;
        if (recyclerView == null) {
            k.a();
        }
        net.one97.paytm.recharge.creditcard.a.a aVar4 = this.f62445c;
        if (aVar4 == null) {
            k.a("mCJRSavedCardRvAdapter");
        }
        recyclerView.setAdapter(aVar4);
    }

    public final void a(CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, HashMap<String, View> hashMap) {
        k.c(cJRCreditCardModelV8, "cardModel");
        a(cJRCreditCardModelV8, z, hashMap, false);
    }

    /* access modifiers changed from: private */
    public void a(CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, HashMap<String, View> hashMap, boolean z2) {
        k.c(cJRCreditCardModelV8, "cardModel");
        RecyclerView recyclerView = this.f62448f;
        if (!(recyclerView == null || this.f62446d == null)) {
            if (recyclerView == null) {
                k.a();
            }
            b bVar = this.f62446d;
            if (bVar == null) {
                k.a();
            }
            recyclerView.removeOnScrollListener(bVar);
        }
        if (cJRCreditCardModelV8.getCardTypeId() == cJRCreditCardModelV8.getRecentCardId() || cJRCreditCardModelV8.getCardTypeId() == cJRCreditCardModelV8.getSavedCardId()) {
            cJRCreditCardModelV8.setEditable(false);
        }
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.f62451i;
        if (dVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.j, "saved_card_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
        }
        if (getParentFragment() instanceof a) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                a.C1204a.a((a) parentFragment, cJRCreditCardModelV8, z, hashMap, false, z2, 8);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
        }
    }

    public final class b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f62452a;

        /* renamed from: b  reason: collision with root package name */
        private CJRCreditCardModelV8 f62453b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62454c;

        /* renamed from: d  reason: collision with root package name */
        private HashMap<String, View> f62455d;

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            if (i2 == 0) {
                CJRRechargeUtilities.INSTANCE.debugLog("Saved Card Recycler scroll state idle");
                this.f62452a.a(this.f62453b, this.f62454c, this.f62455d, false);
            }
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        RecyclerView recyclerView = this.f62448f;
        if (recyclerView != null) {
            if (recyclerView == null) {
                k.a();
            }
            recyclerView.setAdapter((RecyclerView.a) null);
            this.f62448f = null;
        }
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
