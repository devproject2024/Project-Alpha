package net.one97.paytm.paymentsBank.chequebook.trackingflow.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.bankCommon.mapping.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBTrackingOrderPayloadResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBTrackingOrderResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBTrackingOrderStatusFlow;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.PendingChequeBook;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.a.a;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.view.a;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.pdc.response.PDCStatusResponse;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public final class a implements b, a.C0290a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> f17913a;

    /* renamed from: b  reason: collision with root package name */
    private String f17914b = "";

    /* renamed from: c  reason: collision with root package name */
    private h f17915c;

    /* renamed from: d  reason: collision with root package name */
    private String f17916d;

    /* renamed from: e  reason: collision with root package name */
    private ChequeBookFinResponse f17917e;

    /* renamed from: f  reason: collision with root package name */
    private ChequeBookResponse f17918f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CBTrackingOrderStatusFlow> f17919g;

    /* renamed from: h  reason: collision with root package name */
    private String f17920h = "";

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f17921i = new ArrayList<>();
    private final String j;
    private final SharedPreferences k;
    private String l;
    private final g m;
    private final a.b n;
    private Context o;

    public final void a() {
    }

    public final void b() {
    }

    public a(g gVar, a.b bVar, Context context) {
        k.c(bVar, "cbtlandingView");
        k.c(context, "mContext");
        this.m = gVar;
        this.n = bVar;
        this.o = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.j = simpleName;
        SharedPreferences sharedPreferences = this.o.getApplicationContext().getSharedPreferences("CB_PREF_FIN_RESPONSE", 0);
        k.a((Object) sharedPreferences, "mContext.applicationCont….CB_PREF_FIN_RESPONSE, 0)");
        this.k = sharedPreferences;
    }

    public final void a(String str) {
        k.c(str, "orderId");
        this.f17914b = str;
    }

    public final int d() {
        ArrayList<CBTrackingOrderStatusFlow> arrayList = this.f17919g;
        if (arrayList != null) {
            if (arrayList == null) {
                k.a();
            }
            return arrayList.size();
        } else if (this.f17913a == null) {
            return 0;
        } else {
            ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList2 = this.f17913a;
            if (arrayList2 == null) {
                k.a("statusFlowList");
            }
            return arrayList2.size();
        }
    }

    public final void a(a.C0291a aVar, int i2) {
        ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList = this.f17913a;
        if (arrayList == null) {
            k.a("statusFlowList");
        }
        net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar2 = arrayList.get(i2);
        k.a((Object) aVar2, "statusFlowList[position]");
        net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar3 = aVar2;
        if (aVar != null) {
            if (!aVar3.j()) {
                aVar.f17937h.setBackgroundResource(0);
            } else {
                aVar.f17937h.setBackgroundResource(R.drawable.rectangle_nine_patch);
            }
        }
        if (aVar != null) {
            String b2 = aVar3.b();
            k.a((Object) b2, "cbStatusFlow.title");
            boolean l2 = aVar3.l();
            k.c(b2, "mTitle");
            CharSequence charSequence = b2;
            if (!TextUtils.isEmpty(charSequence)) {
                aVar.f17932c.setText(charSequence);
                aVar.f17932c.setVisibility(0);
                aVar.a(aVar.f17932c, l2);
            } else {
                aVar.f17932c.setVisibility(8);
            }
            x.a aVar4 = new x.a();
            aVar4.element = false;
            aVar.f17935f.getViewTreeObserver().addOnGlobalLayoutListener(new a.C0291a.C0292a(aVar, aVar4));
        }
        if (aVar != null) {
            CharSequence c2 = aVar3.c();
            if (TextUtils.isEmpty(c2)) {
                aVar.f17933d.setVisibility(8);
            } else {
                aVar.f17933d.setText(c2);
                aVar.f17933d.setVisibility(0);
            }
        }
        if (aVar != null) {
            String f2 = aVar3.f();
            k.a((Object) f2, "cbStatusFlow.date");
            boolean k2 = aVar3.k();
            k.c(f2, "mDate");
            CharSequence charSequence2 = f2;
            if (TextUtils.isEmpty(charSequence2)) {
                aVar.f17930a.setText("");
                aVar.f17930a.setVisibility(4);
            } else {
                aVar.f17930a.setText(charSequence2);
                aVar.a(aVar.f17930a, k2);
                aVar.f17930a.setVisibility(0);
            }
        }
        if (aVar != null) {
            String g2 = aVar3.g();
            k.a((Object) g2, "cbStatusFlow.actionTitle");
            int h2 = aVar3.h();
            k.c(g2, "action");
            CharSequence charSequence3 = g2;
            if (!TextUtils.isEmpty(charSequence3)) {
                aVar.f17931b.setText(charSequence3);
                aVar.f17931b.setTag(Integer.valueOf(h2));
                aVar.f17931b.setOnClickListener(aVar);
                aVar.f17931b.setVisibility(0);
            } else {
                aVar.f17931b.setVisibility(8);
            }
        }
        if (aVar != null) {
            int d2 = aVar3.d();
            int e2 = aVar3.e();
            int i3 = aVar3.i();
            a.C0291a.a(aVar.f17934e, d2);
            a.C0291a.a(aVar.f17935f, e2);
            if (i3 == 101) {
                aVar.f17936g.setImageDrawable(androidx.core.content.b.a(aVar.f17936g.getContext(), R.drawable.pb_ic_failed_small));
            } else if (i3 == 102) {
                aVar.f17936g.setImageDrawable(androidx.core.content.b.a(aVar.f17936g.getContext(), R.drawable.pb_ic_pending_small));
            } else if (i3 == 100) {
                aVar.f17936g.setImageDrawable(androidx.core.content.b.a(aVar.f17936g.getContext(), R.drawable.pb_cbt_green_oval_white_border));
            } else if (i3 == 103) {
                aVar.f17936g.setImageDrawable(androidx.core.content.b.a(aVar.f17936g.getContext(), R.drawable.pb_ic_marker_grey));
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f17920h = b(R.string.pb_cbt_refund_initiated);
        if (networkCustomError != null) {
            com.paytm.utility.b.b(this.o, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        com.paytm.network.a aVar;
        String str3;
        String str4;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        PendingChequeBook pendingChequeBook = null;
        String str5 = "";
        if (iJRPaytmDataModel2 instanceof CBTrackingOrderResponse) {
            CBTrackingOrderResponse cBTrackingOrderResponse = (CBTrackingOrderResponse) iJRPaytmDataModel2;
            CBTrackingOrderPayloadResponse cbTrackingOrderPayloadResponse = cBTrackingOrderResponse.getCbTrackingOrderPayloadResponse();
            k.a((Object) cbTrackingOrderPayloadResponse, "cbTrackingOrderResponse.…ckingOrderPayloadResponse");
            this.f17919g = cbTrackingOrderPayloadResponse.getStatusFlow();
            CBTrackingOrderPayloadResponse cbTrackingOrderPayloadResponse2 = cBTrackingOrderResponse.getCbTrackingOrderPayloadResponse();
            if (cbTrackingOrderPayloadResponse2 == null || (str3 = cbTrackingOrderPayloadResponse2.getCancellationReason()) == null) {
                str3 = b(R.string.pb_cbt_refund_initiated);
            }
            this.f17920h = str3;
            CBTrackingOrderPayloadResponse cbTrackingOrderPayloadResponse3 = cBTrackingOrderResponse.getCbTrackingOrderPayloadResponse();
            if (cbTrackingOrderPayloadResponse3 == null || (str4 = cbTrackingOrderPayloadResponse3.getReIssue()) == null) {
                str4 = str5;
            }
            this.l = str4;
            this.f17913a = new ArrayList<>();
            ArrayList<CBTrackingOrderStatusFlow> arrayList = this.f17919g;
            if (arrayList != null && (!arrayList.isEmpty())) {
                int i2 = 0;
                while (true) {
                    ArrayList<CBTrackingOrderStatusFlow> arrayList2 = this.f17919g;
                    Integer valueOf = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (i2 >= valueOf.intValue()) {
                        break;
                    }
                    ArrayList<CBTrackingOrderStatusFlow> arrayList3 = this.f17919g;
                    CBTrackingOrderStatusFlow cBTrackingOrderStatusFlow = arrayList3 != null ? arrayList3.get(i2) : null;
                    if (cBTrackingOrderStatusFlow == null) {
                        k.a();
                    }
                    ArrayList<CBTrackingOrderStatusFlow> arrayList4 = this.f17919g;
                    if (arrayList4 == null) {
                        k.a();
                    }
                    if (arrayList4.size() == 1) {
                        ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList5 = this.f17913a;
                        if (arrayList5 == null) {
                            k.a("statusFlowList");
                        }
                        net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar2 = r13;
                        net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar3 = new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(cBTrackingOrderStatusFlow.getText(), "", com.paytm.utility.b.h(cBTrackingOrderStatusFlow.getCreated_at(), "yyyy-MM-dd'T'HH:mm:ss.SSS", "dd MMM"), 104, 104, 105, 100, false);
                        arrayList5.add(aVar2);
                    } else {
                        ArrayList<CBTrackingOrderStatusFlow> arrayList6 = this.f17919g;
                        if (arrayList6 == null) {
                            k.a();
                        }
                        if (i2 != arrayList6.size() - 1) {
                            ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList7 = this.f17913a;
                            if (arrayList7 == null) {
                                k.a("statusFlowList");
                            }
                            net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar4 = r13;
                            net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar5 = new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(cBTrackingOrderStatusFlow.getText(), "", com.paytm.utility.b.h(cBTrackingOrderStatusFlow.getCreated_at(), "yyyy-MM-dd'T'HH:mm:ss.SSS", "dd MMM"), 104, 104, 105, 100, false);
                            arrayList7.add(aVar4);
                        } else if ("6".equals(cBTrackingOrderStatusFlow.getId()) || p.a(cBTrackingOrderStatusFlow.getText(), "Cancelled", true)) {
                            ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList8 = this.f17913a;
                            if (arrayList8 == null) {
                                k.a("statusFlowList");
                            }
                            net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar6 = r13;
                            net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar7 = new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(cBTrackingOrderStatusFlow.getText(), this.f17920h, com.paytm.utility.b.h(cBTrackingOrderStatusFlow.getCreated_at(), "yyyy-MM-dd'T'HH:mm:ss.SSS", "dd MMM"), 100, 104, 105, 101, true);
                            arrayList8.add(aVar6.a(this.o.getString(R.string.pb_cbt_request_again), 102));
                        } else {
                            ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList9 = this.f17913a;
                            if (arrayList9 == null) {
                                k.a("statusFlowList");
                            }
                            net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar8 = r13;
                            net.one97.paytm.paymentsBank.chequebook.trackingflow.a aVar9 = new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(cBTrackingOrderStatusFlow.getText(), "", com.paytm.utility.b.h(cBTrackingOrderStatusFlow.getCreated_at(), "yyyy-MM-dd'T'HH:mm:ss.SSS", "dd MMM"), 100, 104, 105, 100, false);
                            arrayList9.add(aVar8);
                        }
                    }
                    i2++;
                }
            }
            this.n.c();
            CBTrackingOrderPayloadResponse cbTrackingOrderPayloadResponse4 = cBTrackingOrderResponse.getCbTrackingOrderPayloadResponse();
            k.a((Object) cbTrackingOrderPayloadResponse4, "cbTrackingOrderResponse.…ckingOrderPayloadResponse");
            String expectedDateOfDelivery = cbTrackingOrderPayloadResponse4.getExpectedDateOfDelivery();
            if (expectedDateOfDelivery == null) {
                expectedDateOfDelivery = str5;
            }
            if (!TextUtils.isEmpty(expectedDateOfDelivery)) {
                str5 = com.paytm.utility.b.h(expectedDateOfDelivery, "yyyy-MM-dd'T'HH:mm:ss.SSS", "E, dd MMM");
            }
            a.b bVar = this.n;
            String str6 = this.f17914b;
            if (str5 == null) {
                k.a();
            }
            bVar.a(false, str6, str5);
        } else if (iJRPaytmDataModel2 instanceof PDCStatusResponse) {
            this.n.a(false);
            PDCStatusResponse pDCStatusResponse = (PDCStatusResponse) iJRPaytmDataModel2;
            Integer responseCode = pDCStatusResponse.getResponseCode();
            if (responseCode == null || responseCode.intValue() != 200) {
                return;
            }
            if (pDCStatusResponse.getPayload() != null) {
                PDCStatusResponse.Payload payload = pDCStatusResponse.getPayload();
                k.a((Object) payload, "response.payload");
                if (p.a(payload.getStatus(), "SUCCESS", true)) {
                    a.b bVar2 = this.n;
                    PDCStatusResponse.Payload payload2 = pDCStatusResponse.getPayload();
                    k.a((Object) payload2, "response.payload");
                    String productName = payload2.getProductName();
                    k.a((Object) productName, "response.payload.productName");
                    PDCStatusResponse.Payload payload3 = pDCStatusResponse.getPayload();
                    k.a((Object) payload3, "response.payload");
                    String orderId = payload3.getOrderId();
                    k.a((Object) orderId, "response.payload.orderId");
                    StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
                    PDCStatusResponse.Payload payload4 = pDCStatusResponse.getPayload();
                    k.a((Object) payload4, "response.payload");
                    sb.append(String.valueOf(payload4.getAmount()));
                    bVar2.a(productName, orderId, sb.toString());
                    if (f()) {
                        PDCStatusResponse.Payload payload5 = pDCStatusResponse.getPayload();
                        k.a((Object) payload5, "response.payload");
                        String productId = payload5.getProductId();
                        k.a((Object) productId, "response.payload.productId");
                        k.c(productId, "productId");
                        if (TextUtils.isEmpty(productId)) {
                            return;
                        }
                        if (p.a(productId, "1200139939", true) || p.a(productId, "1200139399", true)) {
                            this.n.c("10");
                        } else {
                            this.n.c("25");
                        }
                    }
                }
            } else {
                this.n.a(str5, str5, str5);
            }
        } else if (iJRPaytmDataModel2 instanceof ChequeBookFinResponse) {
            if (h.a(this.o) != null) {
                h.a("CB_KEY_FIN_RESPONSE", new f().a((Object) iJRPaytmDataModel2), this.o);
            }
            h a2 = h.a(this.o);
            k.a((Object) a2, "PPBCBCacheManager.getCBC…ManagerInstance(mContext)");
            this.f17915c = a2;
            if (this.f17915c == null) {
                k.a("cbCache");
            }
            String a3 = h.a("CB_KEY_FIN_RESPONSE");
            k.a((Object) a3, "cbCache.cbRetrieveData(C…EY_FIN_RESPONSE,mContext)");
            this.f17916d = a3;
            if (this.k.getString("CB_KEY_FIN_RESPONSE", SDKConstants.GA_KEY_DEFAULT) == null) {
                k.a();
            }
            f fVar = new f();
            String str7 = this.f17916d;
            if (str7 == null) {
                k.a("CB_FIN_RESPONSE");
            }
            Object a4 = fVar.a(str7, ChequeBookFinResponse.class);
            k.a(a4, "Gson().fromJson(CB_FIN_R…kFinResponse::class.java)");
            this.f17917e = (ChequeBookFinResponse) a4;
            ChequeBookFinResponse chequeBookFinResponse = this.f17917e;
            if (chequeBookFinResponse == null) {
                k.a("cbFinResponse");
            }
            ChequeBookResponse response = chequeBookFinResponse.getResponse();
            k.a((Object) response, "cbFinResponse.response");
            this.f17918f = response;
            this.n.a("Request Submitted for Cheque Book");
            this.n.b(str5);
            if (TextUtils.isEmpty(this.f17914b)) {
                ChequeBookFinResponse chequeBookFinResponse2 = this.f17917e;
                if (chequeBookFinResponse2 == null) {
                    k.a("cbFinResponse");
                }
                ChequeBookResponse response2 = chequeBookFinResponse2.getResponse();
                k.a((Object) response2, "cbFinResponse.response");
                if (response2.getPendingChequeBooks().size() > 0) {
                    ChequeBookFinResponse chequeBookFinResponse3 = this.f17917e;
                    if (chequeBookFinResponse3 == null) {
                        k.a("cbFinResponse");
                    }
                    ChequeBookResponse response3 = chequeBookFinResponse3.getResponse();
                    k.a((Object) response3, "cbFinResponse.response");
                    PendingChequeBook pendingChequeBook2 = response3.getPendingChequeBooks().get(0);
                    k.a((Object) pendingChequeBook2, "cbFinResponse.response.pendingChequeBooks[0]");
                    String orderId2 = pendingChequeBook2.getOrderId();
                    k.a((Object) orderId2, "cbFinResponse.response.p…ingChequeBooks[0].orderId");
                    this.f17914b = orderId2;
                }
            }
            if (!TextUtils.isEmpty(this.f17914b)) {
                g.a aVar10 = g.f17964b;
                g a5 = g.a.a(this.o);
                if (a5 != null) {
                    String simpleName = getClass().getSimpleName();
                    k.a((Object) simpleName, "this.javaClass.simpleName");
                    aVar = a5.b(this.o, this.f17914b, this, simpleName);
                } else {
                    aVar = null;
                }
                if (!com.paytm.utility.b.c(this.o)) {
                    com.paytm.utility.b.b(this.o, b(R.string.network_error_heading), b(R.string.network_error_message));
                } else if (aVar != null) {
                    this.n.a(true);
                    aVar.a();
                }
            }
            if (f()) {
                this.n.a(true, this.f17914b, str5);
                this.n.a(true);
                this.f17913a = new ArrayList<>();
                ChequeBookResponse chequeBookResponse = this.f17918f;
                if (chequeBookResponse == null) {
                    k.a("cbResponse");
                }
                List<PendingChequeBook> pendingChequeBooks = chequeBookResponse.getPendingChequeBooks();
                if (pendingChequeBooks != null && (!pendingChequeBooks.isEmpty())) {
                    ChequeBookResponse chequeBookResponse2 = this.f17918f;
                    if (chequeBookResponse2 == null) {
                        k.a("cbResponse");
                    }
                    pendingChequeBook = chequeBookResponse2.getPendingChequeBooks().get(0);
                }
                if (pendingChequeBook != null) {
                    str5 = b(String.valueOf(pendingChequeBook.getCreatedAt()));
                    str2 = b(String.valueOf(pendingChequeBook.getUpdatedAt()));
                } else {
                    str2 = str5;
                }
                ChequeBookFinResponse chequeBookFinResponse4 = this.f17917e;
                if (chequeBookFinResponse4 == null) {
                    k.a("cbFinResponse");
                }
                ChequeBookResponse response4 = chequeBookFinResponse4.getResponse();
                k.a((Object) response4, "cbFinResponse.response");
                if (p.a(response4.getSignature().getStatus(), "UPLOAD_PENDING", false)) {
                    ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList10 = this.f17913a;
                    if (arrayList10 == null) {
                        k.a("statusFlowList");
                    }
                    arrayList10.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_iss_char_paid), "", str5, 104, 100, 105, 100, false));
                    ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList11 = this.f17913a;
                    if (arrayList11 == null) {
                        k.a("statusFlowList");
                    }
                    arrayList11.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_sign_up_pending), b(R.string.pb_cbt_sign_up_des), str5, b(R.string.pb_cbt_sign_up_action)).a());
                    ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList12 = this.f17913a;
                    if (arrayList12 == null) {
                        k.a("statusFlowList");
                    }
                    arrayList12.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_verification_pending), "", "", 101, 104, 101, 103, false));
                } else {
                    ChequeBookFinResponse chequeBookFinResponse5 = this.f17917e;
                    if (chequeBookFinResponse5 == null) {
                        k.a("cbFinResponse");
                    }
                    ChequeBookResponse response5 = chequeBookFinResponse5.getResponse();
                    k.a((Object) response5, "cbFinResponse.response");
                    if (p.a(response5.getSignature().getStatus(), "REJECTED", false)) {
                        ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList13 = this.f17913a;
                        if (arrayList13 == null) {
                            k.a("statusFlowList");
                        }
                        arrayList13.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_iss_char_paid), "", str5, 104, 100, 105, 100, false));
                        ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList14 = this.f17913a;
                        if (arrayList14 == null) {
                            k.a("statusFlowList");
                        }
                        arrayList14.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_sign_uploaded), "", str5, 100, 100, 105, 100, false));
                        ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList15 = this.f17913a;
                        if (arrayList15 == null) {
                            k.a("statusFlowList");
                        }
                        String b2 = b(R.string.pb_cbt_sign_rejected);
                        ChequeBookResponse chequeBookResponse3 = this.f17918f;
                        if (chequeBookResponse3 == null) {
                            k.a("cbResponse");
                        }
                        arrayList15.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b2, chequeBookResponse3.getSignature().getRemark(), str2, 100, 104, 105, 101, true).a(b(R.string.pb_cbt_change_sign), 101).a());
                    } else {
                        ChequeBookFinResponse chequeBookFinResponse6 = this.f17917e;
                        if (chequeBookFinResponse6 == null) {
                            k.a("cbFinResponse");
                        }
                        ChequeBookResponse response6 = chequeBookFinResponse6.getResponse();
                        k.a((Object) response6, "cbFinResponse.response");
                        if (p.a(response6.getSignature().getStatus(), "UPLOADED", false)) {
                            ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList16 = this.f17913a;
                            if (arrayList16 == null) {
                                k.a("statusFlowList");
                            }
                            arrayList16.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_iss_char_paid), "", str5, 104, 100, 105, 100, false));
                            ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList17 = this.f17913a;
                            if (arrayList17 == null) {
                                k.a("statusFlowList");
                            }
                            String b3 = b(R.string.pb_cbt_sign_upload_pending);
                            ChequeBookResponse chequeBookResponse4 = this.f17918f;
                            if (chequeBookResponse4 == null) {
                                k.a("cbResponse");
                            }
                            arrayList17.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b3, chequeBookResponse4.getSignature().getRemark(), str2, 100, 104, 105, 102, true).a(b(R.string.pb_cbt_change_sign), 101).a());
                        } else {
                            ChequeBookFinResponse chequeBookFinResponse7 = this.f17917e;
                            if (chequeBookFinResponse7 == null) {
                                k.a("cbFinResponse");
                            }
                            ChequeBookResponse response7 = chequeBookFinResponse7.getResponse();
                            k.a((Object) response7, "cbFinResponse.response");
                            if (p.a(response7.getSignature().getStatus(), "APPROVAL_PENDING", false)) {
                                ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList18 = this.f17913a;
                                if (arrayList18 == null) {
                                    k.a("statusFlowList");
                                }
                                arrayList18.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_iss_char_paid), "", str5, 104, 100, 105, 100, false));
                                ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList19 = this.f17913a;
                                if (arrayList19 == null) {
                                    k.a("statusFlowList");
                                }
                                arrayList19.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_sign_uploaded), "", str2, 100, 100, 105, 100, false));
                                ArrayList<net.one97.paytm.paymentsBank.chequebook.trackingflow.a> arrayList20 = this.f17913a;
                                if (arrayList20 == null) {
                                    k.a("statusFlowList");
                                }
                                arrayList20.add(new net.one97.paytm.paymentsBank.chequebook.trackingflow.a(b(R.string.pb_cbt_sign_verify_pending), "", str2, 100, 104, 105, 102, false).a());
                            }
                        }
                    }
                }
                this.n.c();
                return;
            }
            ChequeBookFinResponse chequeBookFinResponse8 = this.f17917e;
            if (chequeBookFinResponse8 == null) {
                k.a("cbFinResponse");
            }
            ChequeBookResponse response8 = chequeBookFinResponse8.getResponse();
            k.a((Object) response8, "cbFinResponse.response");
            if (response8.getPendingChequeBooks() != null) {
                if (!(this.f17914b.length() == 0) && (str = this.f17914b) != null && com.paytm.utility.b.c(this.o.getApplicationContext())) {
                    this.n.a(true);
                    String stringFromGTM = o.a().getStringFromGTM("cb_tracking_url");
                    k.a((Object) stringFromGTM, "PaymentsBankHelper.getIm…t.CB_TRACKING_DETAIL_URL)");
                    String str8 = stringFromGTM + str;
                    Map hashMap = new HashMap();
                    String a6 = d.a(this.o.getApplicationContext());
                    k.a((Object) a6, "CJRServerUtility.getSSOT…ntext.applicationContext)");
                    hashMap.put("Authorization", a6);
                    hashMap.put("Accept", "application/json");
                    if (com.paytm.utility.b.c(this.o.getApplicationContext())) {
                        com.paytm.network.a l2 = new com.paytm.network.b().a(this.o.getApplicationContext()).a(a.c.PAYMENTSBANK).a(a.C0715a.GET).a(str8).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CBTrackingOrderResponse()).a((b) this).c("CBTLandingPresenter").a(a.b.USER_FACING).l();
                        l2.b(false);
                        l2.a();
                        return;
                    }
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setmAlertTitle(this.o.getResources().getString(R.string.pb_title_connection_problem));
                    networkCustomError.setAlertMessage(this.o.getResources().getString(R.string.pb_msg_connection_problem));
                }
            }
        }
    }

    private static String b(String str) {
        return DateFormat.format("dd MMM", new Date(Long.parseLong(str))).toString();
    }

    private String b(int i2) {
        Context context = this.o;
        if (context == null) {
            return "";
        }
        String string = context.getString(i2);
        k.a((Object) string, "mContext.getString(id)");
        return string;
    }

    private final boolean f() {
        ChequeBookFinResponse chequeBookFinResponse = this.f17917e;
        if (chequeBookFinResponse == null) {
            k.a("cbFinResponse");
        }
        ChequeBookResponse response = chequeBookFinResponse.getResponse();
        k.a((Object) response, "cbFinResponse.response");
        if (p.a(response.getSignature().getStatus(), "ACCEPTED", false)) {
            return false;
        }
        ChequeBookFinResponse chequeBookFinResponse2 = this.f17917e;
        if (chequeBookFinResponse2 == null) {
            k.a("cbFinResponse");
        }
        ChequeBookResponse response2 = chequeBookFinResponse2.getResponse();
        k.a((Object) response2, "cbFinResponse.response");
        if (response2.getPendingChequeBooks() == null) {
            return true;
        }
        ChequeBookFinResponse chequeBookFinResponse3 = this.f17917e;
        if (chequeBookFinResponse3 == null) {
            k.a("cbFinResponse");
        }
        ChequeBookResponse response3 = chequeBookFinResponse3.getResponse();
        k.a((Object) response3, "cbFinResponse.response");
        if (response3.getPendingChequeBooks().size() <= 0) {
            return true;
        }
        ChequeBookFinResponse chequeBookFinResponse4 = this.f17917e;
        if (chequeBookFinResponse4 == null) {
            k.a("cbFinResponse");
        }
        ChequeBookResponse response4 = chequeBookFinResponse4.getResponse();
        k.a((Object) response4, "cbFinResponse.response");
        PendingChequeBook pendingChequeBook = response4.getPendingChequeBooks().get(0);
        k.a((Object) pendingChequeBook, "cbFinResponse.response.pendingChequeBooks.get(0)");
        if (pendingChequeBook.getStatus().equals(TxNotifyData.UPI_STATUS_CANCELLED)) {
            return false;
        }
        return true;
    }

    public final void e() {
        o.a().checkDeepLinking(this.o, n.q());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r1 = (r1 = r1.getResponse()).getSignature();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4) {
        /*
            r3 = this;
            r0 = 101(0x65, float:1.42E-43)
            if (r4 != r0) goto L_0x004e
            android.content.Context r4 = r3.o     // Catch:{ Exception -> 0x0060 }
            if (r4 == 0) goto L_0x0060
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0060 }
            android.content.Context r0 = r3.o     // Catch:{ Exception -> 0x0060 }
            java.lang.Class<net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2> r1 = net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2.class
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r0 = "CHEQUEBOOK_SIGNATURE_STATUS"
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse r1 = r3.f17917e     // Catch:{ Exception -> 0x0060 }
            if (r1 != 0) goto L_0x001c
            java.lang.String r2 = "cbFinResponse"
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0060 }
        L_0x001c:
            r2 = 0
            if (r1 == 0) goto L_0x0030
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse r1 = r1.getResponse()     // Catch:{ Exception -> 0x0060 }
            if (r1 == 0) goto L_0x0030
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature r1 = r1.getSignature()     // Catch:{ Exception -> 0x0060 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.getStatus()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            r4.putExtra(r0, r1)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r0 = "is_first_time_user"
            r1 = 0
            r4.putExtra(r0, r1)     // Catch:{ Exception -> 0x0060 }
            android.content.Context r0 = r3.o     // Catch:{ Exception -> 0x0060 }
            r0.startActivity(r4)     // Catch:{ Exception -> 0x0060 }
            android.content.Context r4 = r3.o     // Catch:{ Exception -> 0x0060 }
            boolean r0 = r4 instanceof android.app.Activity     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x0046
            r4 = r2
        L_0x0046:
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ Exception -> 0x0060 }
            if (r4 == 0) goto L_0x0060
            r4.finish()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0060
        L_0x004e:
            r0 = 102(0x66, float:1.43E-43)
            if (r4 != r0) goto L_0x0060
            android.content.Intent r4 = new android.content.Intent
            android.content.Context r0 = r3.o
            java.lang.Class<net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.RequestCBActivity> r1 = net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.RequestCBActivity.class
            r4.<init>(r0, r1)
            android.content.Context r0 = r3.o
            r0.startActivity(r4)
        L_0x0060:
            net.one97.paytm.paymentsBank.chequebook.trackingflow.a.a$b r4 = r3.n
            r4.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.trackingflow.b.a.a(int):void");
    }

    public final void c() {
        com.paytm.network.a aVar;
        g.a aVar2 = g.f17964b;
        g a2 = g.a.a(this.o.getApplicationContext());
        if (a2 != null) {
            Context applicationContext = this.o.getApplicationContext();
            k.a((Object) applicationContext, "mContext.applicationContext");
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            aVar = a2.b(applicationContext, this, simpleName);
        } else {
            aVar = null;
        }
        if (!com.paytm.utility.b.c(this.o.getApplicationContext())) {
            com.paytm.utility.b.b(this.o, b(R.string.network_error_heading), b(R.string.network_error_message));
        } else if (aVar != null) {
            aVar.a();
        }
    }
}
