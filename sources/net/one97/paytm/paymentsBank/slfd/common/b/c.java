package net.one97.paytm.paymentsBank.slfd.common.b;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CJROrderList;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.model.slfd.SlfdListModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.common.a.c;
import net.one97.paytm.paymentsBank.slfd.common.view.f;
import net.one97.paytm.upi.util.UpiUtils;

public final class c implements g.a, g.b<IJRPaytmDataModel>, c.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<SlfdTransactionItem> f18970a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18971b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18972c;

    /* renamed from: d  reason: collision with root package name */
    private int f18973d;

    /* renamed from: e  reason: collision with root package name */
    private String f18974e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Double> f18975f;

    /* renamed from: g  reason: collision with root package name */
    private final b f18976g;

    /* renamed from: h  reason: collision with root package name */
    private final c.b f18977h;

    /* renamed from: i  reason: collision with root package name */
    private final String f18978i;
    private ArrayList<SlfdModel> j;
    private final ArrayList<CJROrderList> k;

    private c(b bVar, c.b bVar2, String str, ArrayList<SlfdModel> arrayList, ArrayList<CJROrderList> arrayList2) {
        k.c(bVar, "slfdRepository");
        k.c(bVar2, "slfdListView");
        k.c(str, "type");
        k.c(arrayList, "slfdList");
        k.c(arrayList2, "orderList");
        this.f18976g = bVar;
        this.f18977h = bVar2;
        this.f18978i = str;
        this.j = arrayList;
        this.k = arrayList2;
        this.f18970a = new ArrayList();
        this.f18973d = 1;
        this.f18974e = "";
        this.f18975f = new HashMap<>();
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        int i2 = 0;
        this.f18977h.a(false);
        this.f18971b = false;
        if (iJRPaytmDataModel instanceof SlfdListModel) {
            SlfdListModel slfdListModel = (SlfdListModel) iJRPaytmDataModel;
            if (ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equals(slfdListModel.getStatus())) {
                this.f18977h.a(slfdListModel.getMessage());
                return;
            }
            if (slfdListModel.getResponseCode() == 200) {
                int size = this.j.size();
                ArrayList<SlfdModel> fdList = slfdListModel.getFdList();
                if (fdList != null) {
                    i2 = fdList.size();
                }
                ArrayList<SlfdModel> fdList2 = slfdListModel.getFdList();
                if (i2 == 0) {
                    this.f18972c = true;
                    if (size == 0) {
                        this.f18977h.d();
                    }
                } else if (i2 < 20) {
                    this.f18972c = true;
                    ArrayList<SlfdModel> arrayList = this.j;
                    if (fdList2 == null) {
                        k.a();
                    }
                    arrayList.addAll(fdList2);
                    if (size == 0) {
                        this.f18977h.c();
                    } else {
                        this.f18977h.a(size, i2);
                    }
                } else if (i2 != 0) {
                    this.f18973d++;
                    ArrayList<SlfdModel> arrayList2 = this.j;
                    if (fdList2 == null) {
                        k.a();
                    }
                    arrayList2.addAll(fdList2);
                    if (size == 0) {
                        this.f18977h.c();
                    } else {
                        this.f18977h.a(size, i2);
                    }
                }
            } else {
                this.f18977h.a(slfdListModel.getMessage());
            }
            c.b bVar = this.f18977h;
            this.j.size();
            bVar.e();
        } else if (iJRPaytmDataModel instanceof SlfdTransactionModel) {
            SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) iJRPaytmDataModel;
            if (ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equals(slfdTransactionModel.getStatus())) {
                this.f18977h.a(slfdTransactionModel.getMessage());
                return;
            }
            int size2 = this.f18970a.size();
            ArrayList<SlfdTransactionItem> transactionList = slfdTransactionModel.getTransactionList();
            if (transactionList != null) {
                i2 = transactionList.size();
            }
            if (slfdTransactionModel.getTransactionList() != null) {
                this.f18970a.addAll(slfdTransactionModel.getTransactionList());
                this.f18977h.a(size2, i2);
                this.f18972c = slfdTransactionModel.isLastPage();
                if (this.f18970a.size() > 0) {
                    String orderId = ((SlfdTransactionItem) kotlin.a.k.f(this.f18970a)).getOrderId();
                    if (orderId == null) {
                        orderId = "";
                    }
                    this.f18974e = orderId;
                }
                if (TextUtils.isEmpty(this.f18974e) && this.f18972c && this.f18970a.size() == 0) {
                    this.f18977h.a();
                }
            }
        }
    }

    public /* synthetic */ c(b bVar, c.b bVar2, String str) {
        this(bVar, bVar2, str, new ArrayList(), new ArrayList());
    }

    public final void a() {
        if (this.f18978i.equals("active,pending")) {
            f();
        } else {
            g();
        }
    }

    public final void b() {
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final int c() {
        if (this.f18978i.equals("active,pending")) {
            return this.j.size();
        }
        if (this.f18978i.equals("A") || this.f18978i.equals(AppConstants.FEED_COMMUNITY) || this.f18978i.equals("R")) {
            return this.f18970a.size();
        }
        return 0;
    }

    public final void a(f.a aVar, int i2) {
        String str;
        if (this.f18978i.equals("active,pending")) {
            SlfdModel slfdModel = this.j.get(i2);
            k.a((Object) slfdModel, "slfdList.get(position)");
            SlfdModel slfdModel2 = slfdModel;
            if (aVar != null) {
                aVar.a(String.valueOf(slfdModel2.getBookingDate()));
            }
            if (aVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(slfdModel2.getNetInvestedAmount());
                aVar.b(sb.toString());
            }
        } else if (this.f18978i.equals("A") || this.f18978i.equals(AppConstants.FEED_COMMUNITY) || this.f18978i.equals("R")) {
            SlfdTransactionItem slfdTransactionItem = this.f18970a.get(i2);
            if (aVar != null) {
                String txnType = slfdTransactionItem.getTxnType();
                if (txnType == null) {
                    txnType = "";
                }
                aVar.a(txnType);
            }
            if (aVar != null) {
                Double amount = slfdTransactionItem.getAmount();
                if (amount == null || (str = String.valueOf(amount.doubleValue())) == null) {
                    str = "0.0";
                }
                aVar.b(str);
            }
        }
        ArrayList<SlfdModel> arrayList = this.j;
        if (arrayList != null && arrayList.size() > 0 && this.j.get(i2) != null) {
            if (aVar != null) {
                SlfdModel slfdModel3 = this.j.get(i2);
                k.a((Object) slfdModel3, "slfdList.get(position)");
                aVar.a(slfdModel3);
            }
            if (aVar != null) {
                aVar.itemView.setOnClickListener(new f.a.C0332a(aVar, i2));
            }
        }
    }

    private static boolean a(SlfdModel slfdModel) {
        for (String equals : slfdModel.getFdCategory()) {
            if (equals.equals("2000")) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(SlfdModel slfdModel) {
        for (String equals : slfdModel.getFdCategory()) {
            if (equals.equals("2001")) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i2) {
        String str;
        String str2;
        String str3;
        String valueOf;
        String str4;
        if (this.f18978i.equals("active,pending")) {
            if (this.j.size() != 0) {
                SlfdModel slfdModel = this.j.get(i2);
                k.a((Object) slfdModel, "slfdList[position]");
                SlfdModel slfdModel2 = slfdModel;
                String fdId = slfdModel2.getFdId();
                double lockedAmount = slfdModel2.getLockedAmount();
                slfdModel2.getBookingAmount();
                if (!TextUtils.isEmpty(fdId) && Double.compare(lockedAmount, 0.0d) == 0) {
                    c.b bVar = this.f18977h;
                    if (fdId == null) {
                        str4 = "";
                    } else {
                        str4 = fdId;
                    }
                    double netInvestedAmount = slfdModel2.getNetInvestedAmount();
                    SlfdModel slfdModel3 = this.j.get(i2);
                    k.a((Object) slfdModel3, "slfdList.get(position)");
                    boolean a2 = a(slfdModel3);
                    SlfdModel slfdModel4 = this.j.get(i2);
                    k.a((Object) slfdModel4, "slfdList.get(position)");
                    boolean b2 = b(slfdModel4);
                    SlfdModel slfdModel5 = this.j.get(i2);
                    k.a((Object) slfdModel5, "slfdList.get(position)");
                    bVar.a(str4, netInvestedAmount, a2, b2, slfdModel5);
                }
            }
        } else if (this.f18978i.equals("A") || this.f18978i.equals(AppConstants.FEED_COMMUNITY) || this.f18978i.equals("R")) {
            SlfdTransactionItem slfdTransactionItem = this.f18970a.get(i2);
            String orderId = slfdTransactionItem.getOrderId();
            if (orderId == null) {
                str = "";
            } else {
                str = orderId;
            }
            Long txnDate = slfdTransactionItem.getTxnDate();
            long longValue = txnDate != null ? txnDate.longValue() : 0;
            Double amount = slfdTransactionItem.getAmount();
            if (amount == null || (valueOf = String.valueOf(amount.doubleValue())) == null) {
                str2 = "";
            } else {
                str2 = valueOf;
            }
            String txnType = slfdTransactionItem.getTxnType();
            if (txnType == null) {
                str3 = "";
            } else {
                str3 = txnType;
            }
            if (!TextUtils.isEmpty(str)) {
                c.b bVar2 = this.f18977h;
                SlfdModel slfdModel6 = this.j.get(i2);
                k.a((Object) slfdModel6, "slfdList.get(position)");
                boolean a3 = a(slfdModel6);
                SlfdModel slfdModel7 = this.j.get(i2);
                k.a((Object) slfdModel7, "slfdList.get(position)");
                boolean b3 = b(slfdModel7);
                SlfdModel slfdModel8 = this.j.get(i2);
                k.a((Object) slfdModel8, "slfdList.get(position)");
                bVar2.a(str, longValue, str2, str3, a3, b3, slfdModel8);
            }
        }
    }

    private final void f() {
        if (!this.f18972c) {
            this.f18977h.a(true);
            this.f18971b = true;
            this.f18976g.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f18978i, this.f18973d);
        }
    }

    public final void e() {
        this.f18971b = true;
        this.f18973d = 1;
        this.f18972c = false;
        this.j.clear();
        this.f18976g.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f18978i, this.f18973d);
    }

    private final void g() {
        if (!this.f18972c) {
            this.f18977h.a(true);
            this.f18971b = true;
            this.f18976g.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f18978i, this.f18974e);
        }
    }

    public final void d() {
        if (!this.f18972c && !this.f18971b) {
            if (!this.f18978i.equals("active,pending")) {
                g();
            } else if (!this.f18972c && !this.f18971b) {
                f();
            }
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f18971b = false;
        this.f18977h.a(false);
        if (networkCustomError == null) {
            return;
        }
        if ((networkCustomError.getMessage() != null && (p.a(networkCustomError.getMessage(), UpiUtils.AUTHENTICATION_FAILURE_401, true) || p.a(networkCustomError.getMessage(), "410", true))) || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401) {
            this.f18977h.b();
        } else {
            this.f18977h.a(networkCustomError.getAlertMessage());
        }
    }

    public final void a(HashMap<String, Double> hashMap) {
        k.c(hashMap, "hashMap");
        this.f18975f = hashMap;
        this.f18977h.c();
    }
}
