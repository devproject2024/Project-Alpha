package net.one97.paytm.quickpay.d;

import android.text.TextUtils;
import com.google.firebase.crashlytics.c;
import com.google.gson.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.quickpay.utilities.h;
import net.one97.paytm.quickpay.utilities.i;
import net.one97.paytm.t;
import net.one97.paytm.utils.ag;

public final class a implements t {

    /* renamed from: e  reason: collision with root package name */
    private static a f60093e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Integer, Object> f60094a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public CJRHomePageV2 f60095b = new CJRHomePageV2();

    /* renamed from: c  reason: collision with root package name */
    public boolean f60096c;

    /* renamed from: d  reason: collision with root package name */
    boolean f60097d;

    /* renamed from: f  reason: collision with root package name */
    private List<IJRDataModel> f60098f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f60099g;

    public final void onFileWriteComplete(String str) {
    }

    enum b {
        DUE(0),
        NONE(1001),
        MARKED_AS_PAID(1002),
        OVER_DUE(1000);
        
        int status;

        private b(int i2) {
            this.status = i2;
        }

        public final int getValue() {
            return this.status;
        }
    }

    public static a a() {
        if (f60093e == null) {
            f60093e = new a();
        }
        return f60093e;
    }

    public final void a(ArrayList<StandingInstructionList> arrayList) {
        this.f60094a.put(0, arrayList);
        c();
    }

    public final List<IJRDataModel> b() {
        ArrayList arrayList = new ArrayList();
        List<IJRDataModel> list = this.f60098f;
        if (list == null) {
            return arrayList;
        }
        for (IJRDataModel next : list) {
            if (next instanceof CJRFrequentOrder) {
                CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) next;
                if (cJRFrequentOrder != null && (cJRFrequentOrder.getBillReminder() == null || cJRFrequentOrder.getBillReminder().booleanValue())) {
                    arrayList.add(next);
                }
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private CJRHomePageV2 g() {
        try {
            if (this.f60095b == null || this.f60095b.getmPage() == null) {
                this.f60095b = (CJRHomePageV2) new f().a(ag.a(d.b().a()).b("default_quick_pay", "", true), CJRHomePageV2.class);
            }
        } catch (Exception unused) {
        }
        return this.f60095b;
    }

    /* renamed from: net.one97.paytm.quickpay.d.a$a  reason: collision with other inner class name */
    static class C1156a implements Comparator<IJRDataModel> {
        C1156a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((IJRDataModel) obj, (IJRDataModel) obj2);
        }

        private static int a(IJRDataModel iJRDataModel, IJRDataModel iJRDataModel2) {
            long j;
            long j2;
            int i2;
            long j3 = 0;
            if (iJRDataModel instanceof RecentScan) {
                j = ((RecentScan) iJRDataModel).getTimestamp();
            } else if (iJRDataModel instanceof RecentSendMoney) {
                j = ((RecentSendMoney) iJRDataModel).getTimestamp();
            } else if (iJRDataModel instanceof CJRFrequentOrder) {
                try {
                    if (!((CJRFrequentOrder) iJRDataModel).isBillDueToday() || ((CJRFrequentOrder) iJRDataModel).getCjrBillDetails() == null) {
                        i2 = a.a(((CJRFrequentOrder) iJRDataModel).getPaidOn());
                    } else if (((CJRFrequentOrder) iJRDataModel).getCjrBillDetails().getDueDate() != null) {
                        i2 = a.a(((CJRFrequentOrder) iJRDataModel).getCjrBillDetails().getDueDate());
                    } else if (((CJRFrequentOrder) iJRDataModel).getCjrBillDetails().getExpiry() != null) {
                        i2 = a.a(((CJRFrequentOrder) iJRDataModel).getCjrBillDetails().getExpiry());
                    } else {
                        i2 = a.a(((CJRFrequentOrder) iJRDataModel).getPaidOn());
                    }
                    j = (long) i2;
                    if (j == 0) {
                        try {
                            a.a().f60097d = true;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
            } else {
                if (iJRDataModel instanceof StandingInstructionList) {
                    j = (long) a((StandingInstructionList) iJRDataModel);
                    if (j == 0) {
                        a.a().f60097d = true;
                    }
                }
                j = 0;
            }
            if (iJRDataModel2 instanceof RecentScan) {
                j3 = ((RecentScan) iJRDataModel2).getTimestamp();
            } else if (iJRDataModel2 instanceof RecentSendMoney) {
                j3 = ((RecentSendMoney) iJRDataModel2).getTimestamp();
            } else {
                if (iJRDataModel2 instanceof CJRFrequentOrder) {
                    try {
                        if (!((CJRFrequentOrder) iJRDataModel2).isBillDueToday() || ((CJRFrequentOrder) iJRDataModel2).getCjrBillDetails() == null) {
                            j2 = (long) a.a(((CJRFrequentOrder) iJRDataModel2).getPaidOn());
                            if (j2 == 0) {
                                try {
                                    a.a().f60097d = true;
                                } catch (Exception unused3) {
                                }
                            }
                        } else if (((CJRFrequentOrder) iJRDataModel2).getCjrBillDetails().getDueDate() == null || !(iJRDataModel instanceof CJRFrequentOrder) || !((CJRFrequentOrder) iJRDataModel).isBillDueToday()) {
                            if (((CJRFrequentOrder) iJRDataModel2).getCjrBillDetails().getExpiry() == null || !(iJRDataModel instanceof CJRFrequentOrder) || !((CJRFrequentOrder) iJRDataModel).isBillDueToday() || j > ((long) a.a(((CJRFrequentOrder) iJRDataModel2).getCjrBillDetails().getExpiry()))) {
                                return 1;
                            }
                            return -1;
                        } else if (j > ((long) a.a(((CJRFrequentOrder) iJRDataModel2).getCjrBillDetails().getDueDate()))) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } catch (Exception unused4) {
                    }
                } else if (iJRDataModel2 instanceof StandingInstructionList) {
                    j2 = (long) a((StandingInstructionList) iJRDataModel2);
                    if (j2 == 0) {
                        a.a().f60097d = true;
                    }
                }
                j3 = j2;
            }
            if (j < j3) {
                return -1;
            }
            return 1;
        }

        private static int a(StandingInstructionList standingInstructionList) {
            if (standingInstructionList == null) {
                return -1;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if (TextUtils.isEmpty(standingInstructionList.getNextReminderDate())) {
                    return b.NONE.getValue();
                }
                Date parse = simpleDateFormat.parse(standingInstructionList.getNextReminderDate());
                Calendar instance = Calendar.getInstance(TimeZone.getDefault());
                instance.setTime(parse);
                Calendar instance2 = Calendar.getInstance(TimeZone.getDefault());
                instance2.get(1);
                if (standingInstructionList.isMarkedAsPaid()) {
                    return b.MARKED_AS_PAID.getValue();
                }
                if ("monthly".equalsIgnoreCase(standingInstructionList.getReminderFrequency())) {
                    if (instance.get(1) >= instance2.get(1) && instance.get(2) == instance2.get(2) + 1 && instance.get(5) == instance2.get(5)) {
                        return 0;
                    }
                    if (instance.get(1) >= instance2.get(1) && instance.get(2) == instance2.get(2)) {
                        return instance.get(5) - instance2.get(5);
                    }
                } else if ("weekly".equalsIgnoreCase(standingInstructionList.getReminderFrequency()) && instance.get(7) == instance2.get(7)) {
                    return 0;
                }
                return b.OVER_DUE.getValue();
            } catch (ParseException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public static int a(String str) {
        int f2 = d.a().f(str);
        return f2 < 0 ? b.OVER_DUE.getValue() : f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r4.f60098f = r0     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Object> r0 = r4.f60094a     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x0012:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r1 == 0) goto L_0x0012
            java.lang.Object r2 = r1.getValue()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r2 == 0) goto L_0x0012
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r1 == 0) goto L_0x0012
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x0032:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r2 == 0) goto L_0x0012
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            net.one97.paytm.common.entity.IJRDataModel r2 = (net.one97.paytm.common.entity.IJRDataModel) r2     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r3 = r4.f60098f     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r3.add(r2)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            goto L_0x0032
        L_0x0044:
            net.one97.paytm.quickpay.d.a r0 = a()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r1 = 0
            r0.f60097d = r1     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r0 = r4.f60098f     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            net.one97.paytm.quickpay.d.a$a r1 = new net.one97.paytm.quickpay.d.a$a     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r1.<init>()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.util.Collections.sort(r0, r1)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            monitor-exit(r4)
            return
        L_0x0057:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x005a:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.d.a.c():void");
    }

    public final ArrayList<CJRHomePageLayoutV2> d() {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        ArrayList<CJRHomePageLayoutV2> arrayList2 = new ArrayList<>();
        if (a(g())) {
            arrayList.addAll(a().g().getmPage());
            int size = arrayList.size();
            Iterator it2 = arrayList.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                CJRHomePageDetailV2 cJRHomePageDetailV2 = (CJRHomePageDetailV2) it2.next();
                ArrayList<CJRHomePageItem> homePageItemList = cJRHomePageDetailV2.getHomePageLayoutList().get(0).getHomePageItemList();
                if (homePageItemList == null) {
                    homePageItemList = new ArrayList<>();
                }
                Iterator<CJRHomePageItem> it3 = homePageItemList.iterator();
                while (true) {
                    z = true;
                    if (it3.hasNext()) {
                        if (it3.next().isOther()) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                    cJRHomePageItem.setName("null");
                    cJRHomePageItem.setOther(true);
                    homePageItemList.add(cJRHomePageItem);
                }
                CJRHomePageLayoutV2 cJRHomePageLayoutV2 = cJRHomePageDetailV2.getHomePageLayoutList().get(0);
                if (cJRHomePageLayoutV2 != null) {
                    if (i2 >= size - 1) {
                        z = false;
                    }
                    cJRHomePageLayoutV2.setLast(z);
                }
                i2++;
                arrayList2.add(cJRHomePageLayoutV2);
            }
        }
        return arrayList2;
    }

    private static boolean a(CJRHomePageV2 cJRHomePageV2) {
        if (cJRHomePageV2 == null || cJRHomePageV2.getmPage() == null || a().g().getmPage().size() <= 0 || a().g().getmPage().get(0).getHomePageLayoutList() == null || a().g().getmPage().get(0).getHomePageLayoutList().size() <= 0 || a().g().getmPage().get(0).getHomePageLayoutList().get(0).getHomePageItemList() == null || a().g().getmPage().get(0).getHomePageLayoutList().get(0).getHomePageItemList().size() <= 0) {
            return false;
        }
        return true;
    }

    public final void onFileReadComplete(final IJRPaytmDataModel iJRPaytmDataModel, String str) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    if (iJRPaytmDataModel != null) {
                        CJRFrequentOrderList cJRFrequentOrderList = (CJRFrequentOrderList) iJRPaytmDataModel;
                        if (cJRFrequentOrderList != null) {
                            List<CJRFrequentOrder> orderList = cJRFrequentOrderList.getOrderList();
                            ArrayList arrayList = new ArrayList();
                            if (orderList != null && orderList.size() > 0) {
                                int size = orderList.size();
                                if (size > 20) {
                                    size = 20;
                                }
                                for (int i2 = 0; i2 < size; i2++) {
                                    List<CJRBillDetails> list = orderList.get(i2).getmBillDetails();
                                    ArrayList arrayList2 = new ArrayList();
                                    if (list != null && list.size() > 0) {
                                        CJRBillDetails a2 = d.a().a(list.get(0));
                                        if (a2 != null) {
                                            try {
                                                orderList.get(i2).setCjrBillDetails(a2);
                                                orderList.get(i2).setBillDueToday(true);
                                                arrayList2.add(0, orderList.get(i2).clone());
                                            } catch (CloneNotSupportedException e2) {
                                                c.a().a(e2.getMessage());
                                            }
                                        }
                                        if (arrayList2.size() > 0) {
                                            Iterator it2 = arrayList2.iterator();
                                            while (it2.hasNext()) {
                                                CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) it2.next();
                                                if (!(cJRFrequentOrder == null || cJRFrequentOrder.getFrequentOrderProduct() == null || !h.a(cJRFrequentOrder.getFrequentOrderProduct().getCategory_id()))) {
                                                    arrayList.add(0, cJRFrequentOrder);
                                                }
                                            }
                                        } else if (!(orderList.get(i2) == null || orderList.get(i2).getFrequentOrderProduct() == null || !h.a(orderList.get(i2).getFrequentOrderProduct().getCategory_id()))) {
                                            arrayList.add(orderList.get(i2));
                                        }
                                    } else if (!(orderList.get(i2) == null || orderList.get(i2).getFrequentOrderProduct() == null || !h.a(orderList.get(i2).getFrequentOrderProduct().getCategory_id()))) {
                                        arrayList.add(orderList.get(i2));
                                    }
                                }
                            }
                            a.this.f60094a.put(2, arrayList);
                        } else {
                            a.this.f();
                        }
                    } else {
                        a.this.f();
                    }
                    a.this.c();
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public final void e() {
        this.f60094a = new ConcurrentHashMap<>();
        this.f60095b = new CJRHomePageV2();
        this.f60098f = new ArrayList();
        this.f60099g = false;
    }

    public final void a(StandingInstructionList standingInstructionList) {
        ArrayList arrayList = new ArrayList();
        List<IJRDataModel> list = this.f60098f;
        if (list != null && list.size() > 0) {
            for (IJRDataModel next : this.f60098f) {
                if (!(next instanceof StandingInstructionList)) {
                    arrayList.add(next);
                } else if (!standingInstructionList.getId().equalsIgnoreCase(((StandingInstructionList) next).getId())) {
                    arrayList.add(next);
                } else if (!standingInstructionList.getStatus().equalsIgnoreCase(i.DEACTIVATE.getStatus())) {
                    arrayList.add(standingInstructionList);
                }
            }
            this.f60098f = arrayList;
        }
    }

    public final void f() {
        CJRFrequentOrderList k = d.a().k();
        if (k != null) {
            List<CJRFrequentOrder> orderList = k.getOrderList();
            ArrayList arrayList = new ArrayList();
            if (orderList != null && orderList.size() > 0) {
                int size = orderList.size();
                if (size > 20) {
                    size = 20;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    List<CJRBillDetails> list = orderList.get(i2).getmBillDetails();
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        CJRBillDetails a2 = d.a().a(list.get(0));
                        if (a2 != null) {
                            try {
                                orderList.get(i2).setCjrBillDetails(a2);
                                orderList.get(i2).setBillDueToday(true);
                                arrayList2.add(0, orderList.get(i2).clone());
                            } catch (CloneNotSupportedException unused) {
                            }
                        }
                        if (arrayList2.size() > 0) {
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) it2.next();
                                if (!(cJRFrequentOrder == null || cJRFrequentOrder.getFrequentOrderProduct() == null || !h.a(cJRFrequentOrder.getFrequentOrderProduct().getCategory_id()))) {
                                    arrayList.add(0, cJRFrequentOrder);
                                }
                            }
                        } else if (!(orderList.get(i2) == null || orderList.get(i2).getFrequentOrderProduct() == null || !h.a(orderList.get(i2).getFrequentOrderProduct().getCategory_id()))) {
                            arrayList.add(orderList.get(i2));
                        }
                    } else if (!(orderList.get(i2) == null || orderList.get(i2).getFrequentOrderProduct() == null || !h.a(orderList.get(i2).getFrequentOrderProduct().getCategory_id()))) {
                        arrayList.add(orderList.get(i2));
                    }
                }
            }
            this.f60094a.put(2, arrayList);
        }
    }
}
