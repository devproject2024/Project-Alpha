package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.paytm.utility.w;
import java.util.Date;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.q;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.utils.SwipeLayoutHelperV8;
import net.one97.paytm.recharge.common.utils.bj;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.mobile_v3.c.f;

public final class p extends RecyclerView.a<d> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60648a;

    /* renamed from: b  reason: collision with root package name */
    public CJRRecentOrderV8.a f60649b;

    /* renamed from: c  reason: collision with root package name */
    private int f60650c = 101;

    /* renamed from: d  reason: collision with root package name */
    private int f60651d = 102;

    public interface a {
        void a(CJRFrequentOrder cJRFrequentOrder, int i2);

        void a(CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2);

        void b(CJRFrequentOrder cJRFrequentOrder, int i2);

        void c(CJRFrequentOrder cJRFrequentOrder, int i2);

        void d(CJRFrequentOrder cJRFrequentOrder, int i2);

        void f();
    }

    public interface b {
        void g();

        void h();
    }

    public interface c {
        void a(String str, NetworkCustomError networkCustomError);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        d dVar = (d) vVar;
        k.c(dVar, "holder");
        List<CJRFrequentOrder> list = this.f60649b.f61931i;
        if (list == null) {
            k.a();
        }
        dVar.a(i2, list.get(i2));
    }

    public p(CJRRecentOrderV8.a aVar) {
        k.c(aVar, "options");
        this.f60649b = aVar;
        if (CJRRecentOrderV8.a.a(this.f60649b.m).ordinal() == CJRRecentOrderV8.b.MOBILE_V3.ordinal()) {
            this.f60649b.f61924b = 3;
        }
    }

    public final int getItemViewType(int i2) {
        List<CJRFrequentOrder> list;
        if (CJRRecentOrderV8.b.DTH.ordinal() == CJRRecentOrderV8.a.a(this.f60649b.m).ordinal() && (list = this.f60649b.f61931i) != null && (!list.isEmpty())) {
            if (kotlin.m.p.a("shimmer", list.get(i2).viewType, true)) {
                return this.f60650c;
            }
            if (this.f60649b.q && list.get(i2).getDisplayValue() != null && list.get(i2).getDisplayValue().length() > 0) {
                return this.f60651d;
            }
        }
        return CJRRecentOrderV8.a.a(this.f60649b.m).ordinal();
    }

    /* renamed from: a */
    public final d onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        int i3 = q.f60656a[CJRRecentOrderV8.a.a(this.f60649b.m).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_contact_non_swipe_item_view, viewGroup, false);
                    k.a((Object) inflate, "LayoutInflater.from(pare…item_view, parent, false)");
                    return new net.one97.paytm.recharge.mobile.b.a(inflate, this.f60649b);
                } else if (i2 == this.f60650c) {
                    View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dth_recent_shimmer_item, viewGroup, false);
                    k.a((Object) inflate2, "LayoutInflater.from(pare…mmer_item, parent, false)");
                    return new net.one97.paytm.recharge.dth.b.a(inflate2, this.f60649b);
                } else if (i2 == this.f60651d) {
                    View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dth_recent_list_item_new, viewGroup, false);
                    k.a((Object) inflate3, "LayoutInflater.from(pare…_item_new, parent, false)");
                    return new net.one97.paytm.recharge.dth.b.a(inflate3, this.f60649b);
                } else {
                    View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dth_recent_list_item, viewGroup, false);
                    k.a((Object) inflate4, "LayoutInflater.from(pare…list_item, parent, false)");
                    return new net.one97.paytm.recharge.dth.b.a(inflate4, this.f60649b);
                }
            } else if (!this.f60649b.f61930h) {
                View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_contact_non_swipe_item_view, viewGroup, false);
                k.a((Object) inflate5, "LayoutInflater.from(pare…item_view, parent, false)");
                return new net.one97.paytm.recharge.mobile_v3.c.d(inflate5, this.f60649b);
            } else {
                View inflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_contact_item_view, viewGroup, false);
                k.a((Object) inflate6, "LayoutInflater.from(pare…item_view, parent, false)");
                return new f(inflate6, this.f60649b);
            }
        } else if (!this.f60649b.f61930h) {
            View inflate7 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_contact_non_swipe_item_view, viewGroup, false);
            k.a((Object) inflate7, "LayoutInflater.from(pare…item_view, parent, false)");
            return new net.one97.paytm.recharge.mobile.b.a(inflate7, this.f60649b);
        } else {
            View inflate8 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_contact_item_view, viewGroup, false);
            k.a((Object) inflate8, "LayoutInflater.from(pare…item_view, parent, false)");
            return new net.one97.paytm.recharge.mobile.b.b(inflate8, this.f60649b);
        }
    }

    public final int getItemCount() {
        int i2 = 0;
        if (!this.f60648a) {
            int i3 = this.f60649b.f61924b;
            List<CJRFrequentOrder> list = this.f60649b.f61931i;
            if (list != null) {
                i2 = list.size();
            }
            return Math.min(i3, i2);
        }
        if (CJRRecentOrderV8.a.a(this.f60649b.m).ordinal() == CJRRecentOrderV8.b.MOBILE_V3.ordinal()) {
            int i4 = this.f60649b.f61925c;
            List<CJRFrequentOrder> list2 = this.f60649b.f61931i;
            Math.min(i4, list2 != null ? list2.size() : 0);
        }
        List<CJRFrequentOrder> list3 = this.f60649b.f61931i;
        if (list3 != null) {
            return list3.size();
        }
        return 0;
    }

    public final void a() {
        if (this.f60649b.k != null) {
            bj bjVar = this.f60649b.k;
            if (bjVar != null) {
                bjVar.a("0");
            }
            new Handler().postDelayed(new e(this), 1200);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f60655a;

        e(p pVar) {
            this.f60655a = pVar;
        }

        public final void run() {
            bj bjVar = this.f60655a.f60649b.k;
            if (bjVar != null) {
                bjVar.b("0");
            }
        }
    }

    public final void b() {
        this.f60648a = true;
        List<CJRFrequentOrder> list = this.f60649b.f61931i;
        notifyItemRangeChanged(2, list != null ? list.size() : 0);
    }

    public final void c() {
        int i2 = 0;
        this.f60648a = false;
        List<CJRFrequentOrder> list = this.f60649b.f61931i;
        if (list != null) {
            i2 = list.size();
        }
        notifyItemRangeChanged(2, i2);
    }

    public static abstract class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        protected String f60652a = "";

        /* renamed from: b  reason: collision with root package name */
        public final CJRRecentOrderV8.a f60653b;

        public void a() {
        }

        public abstract void a(int i2, CJRFrequentOrder cJRFrequentOrder);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view, CJRRecentOrderV8.a aVar) {
            super(view);
            k.c(view, "itemView");
            k.c(aVar, "options");
            this.f60653b = aVar;
        }

        public static final class a extends SwipeLayoutHelperV8.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f60654a;

            a(d dVar) {
                this.f60654a = dVar;
            }

            public final void a() {
                b bVar = this.f60654a.f60653b.f61929g;
                if (bVar != null) {
                    bVar.h();
                }
            }

            public final void b() {
                b bVar = this.f60654a.f60653b.f61929g;
                if (bVar != null) {
                    bVar.g();
                }
            }

            public final void c() {
                b bVar = this.f60654a.f60653b.f61929g;
                if (bVar != null) {
                    bVar.g();
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void a(SwipeLayoutHelperV8 swipeLayoutHelperV8) {
            k.c(swipeLayoutHelperV8, "swipeLayout");
            swipeLayoutHelperV8.setSwipeListener(new a(this));
        }

        public final String a(CJRFrequentOrder cJRFrequentOrder) {
            k.c(cJRFrequentOrder, "recentOrder");
            String payTypeDisplayLabel = cJRFrequentOrder.getPayTypeDisplayLabel();
            View view = this.itemView;
            k.a((Object) view, "itemView");
            String string = view.getContext().getString(R.string.recharge);
            k.a((Object) string, "itemView.context.getString(R.string.recharge)");
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            String string2 = view2.getContext().getString(R.string.v8_os_bill_payment);
            k.a((Object) string2, "itemView.context.getStri…tring.v8_os_bill_payment)");
            String payType = cJRFrequentOrder.getPayType();
            if (kotlin.m.p.a(BaseViewModel.PaymentType.POSTPAID, payType, true) && TextUtils.isEmpty(payTypeDisplayLabel)) {
                View view3 = this.itemView;
                k.a((Object) view3, "itemView");
                payTypeDisplayLabel = view3.getContext().getString(R.string.bill_payment);
            } else if (kotlin.m.p.a("prepaid", payType, true)) {
                CJRBillDetails cjrBillDetails = cJRFrequentOrder.getCjrBillDetails();
                if (!TextUtils.isEmpty(cjrBillDetails != null ? cjrBillDetails.getPlan() : null)) {
                    CJRBillDetails cjrBillDetails2 = cJRFrequentOrder.getCjrBillDetails();
                    if (cjrBillDetails2 == null) {
                        k.a();
                    }
                    payTypeDisplayLabel = cjrBillDetails2.getPlan();
                }
            }
            if (kotlin.m.p.a("recharge", payTypeDisplayLabel, true)) {
                payTypeDisplayLabel = string;
            } else if (kotlin.m.p.a("bill payment", payTypeDisplayLabel, true)) {
                payTypeDisplayLabel = string2;
            }
            if (TextUtils.isEmpty(payTypeDisplayLabel)) {
                View view4 = this.itemView;
                k.a((Object) view4, "itemView");
                String string3 = view4.getContext().getString(R.string.bill_payment);
                k.a((Object) string3, "itemView.context.getString(R.string.bill_payment)");
                return string3;
            }
            if (payTypeDisplayLabel == null) {
                k.a();
            }
            return payTypeDisplayLabel;
        }

        public final SpannableString b(CJRFrequentOrder cJRFrequentOrder) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            k.c(cJRFrequentOrder, "recentOrder");
            try {
                if (!TextUtils.isEmpty(cJRFrequentOrder.getAutomaticScheduledText())) {
                    String automaticScheduledText = cJRFrequentOrder.getAutomaticScheduledText();
                    if (automaticScheduledText != null) {
                        return new SpannableString(automaticScheduledText);
                    }
                    return null;
                } else if (cJRFrequentOrder.getCjrBillDetails() == null) {
                    return null;
                } else {
                    String payType = cJRFrequentOrder.getPayType();
                    CJRBillDetails cjrBillDetails = cJRFrequentOrder.getCjrBillDetails();
                    k.a((Object) cjrBillDetails, "recentOrder.cjrBillDetails");
                    String a2 = a(cJRFrequentOrder);
                    int daysDiff = cjrBillDetails.getDaysDiff();
                    if (daysDiff < 0) {
                        if (payType == null) {
                            str = null;
                        } else if (payType != null) {
                            str = payType.toLowerCase();
                            k.a((Object) str, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                        if (str == null) {
                            return null;
                        }
                        int hashCode = str.hashCode();
                        if (hashCode != -318370833) {
                            if (hashCode != 757836652) {
                                return null;
                            }
                            if (!str.equals(BaseViewModel.PaymentType.POSTPAID)) {
                                return null;
                            }
                            View view = this.itemView;
                            k.a((Object) view, "itemView");
                            Context context = view.getContext();
                            int i2 = R.string.v8_recent_bill_reminder_date_expired;
                            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            return new SpannableString(context.getString(i2, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10)}));
                        } else if (!str.equals("prepaid")) {
                            return null;
                        } else {
                            View view2 = this.itemView;
                            k.a((Object) view2, "itemView");
                            Context context2 = view2.getContext();
                            int i3 = R.string.v8_recent_recharge_remainder_date_expired;
                            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            return new SpannableString(context2.getString(i3, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10)}));
                        }
                    } else if (daysDiff == 0) {
                        View view3 = this.itemView;
                        k.a((Object) view3, "itemView");
                        String string = view3.getContext().getString(R.string.today_re);
                        k.a((Object) string, "itemView.context.getString(R.string.today_re)");
                        if (payType == null) {
                            str8 = null;
                        } else if (payType != null) {
                            str8 = payType.toLowerCase();
                            k.a((Object) str8, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                        if (str8 != null) {
                            int hashCode2 = str8.hashCode();
                            if (hashCode2 != -318370833) {
                                if (hashCode2 == 757836652) {
                                    if (str8.equals(BaseViewModel.PaymentType.POSTPAID)) {
                                        View view4 = this.itemView;
                                        k.a((Object) view4, "itemView");
                                        Context context3 = view4.getContext();
                                        int i4 = R.string.v8_recent_bill_reminder_today_tomorrow;
                                        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                        str9 = context3.getString(i4, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10), string});
                                        k.a((Object) str9, "itemView.context.getStri…                   today)");
                                        return a(str9, string);
                                    }
                                }
                            } else if (str8.equals("prepaid")) {
                                View view5 = this.itemView;
                                k.a((Object) view5, "itemView");
                                Context context4 = view5.getContext();
                                int i5 = R.string.v8_recent_recharge_remainder_today_tomorrow;
                                net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                str9 = context4.getString(i5, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10), string});
                                k.a((Object) str9, "itemView.context.getStri…                   today)");
                                return a(str9, string);
                            }
                        }
                        str9 = "";
                        return a(str9, string);
                    } else if (daysDiff == 1) {
                        View view6 = this.itemView;
                        k.a((Object) view6, "itemView");
                        String string2 = view6.getContext().getString(R.string.tomorrow);
                        k.a((Object) string2, "itemView.context.getString(R.string.tomorrow)");
                        if (payType == null) {
                            str6 = null;
                        } else if (payType != null) {
                            str6 = payType.toLowerCase();
                            k.a((Object) str6, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                        if (str6 != null) {
                            int hashCode3 = str6.hashCode();
                            if (hashCode3 != -318370833) {
                                if (hashCode3 == 757836652) {
                                    if (str6.equals(BaseViewModel.PaymentType.POSTPAID)) {
                                        View view7 = this.itemView;
                                        k.a((Object) view7, "itemView");
                                        Context context5 = view7.getContext();
                                        int i6 = R.string.v8_recent_bill_reminder_today_tomorrow;
                                        net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                        str7 = context5.getString(i6, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10), string2});
                                        k.a((Object) str7, "itemView.context.getStri…                tomorrow)");
                                        return a(str7, string2);
                                    }
                                }
                            } else if (str6.equals("prepaid")) {
                                View view8 = this.itemView;
                                k.a((Object) view8, "itemView");
                                Context context6 = view8.getContext();
                                int i7 = R.string.v8_recent_recharge_remainder_today_tomorrow;
                                net.one97.paytm.recharge.widgets.c.d dVar6 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                str7 = context6.getString(i7, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10), string2});
                                k.a((Object) str7, "itemView.context.getStri…                tomorrow)");
                                return a(str7, string2);
                            }
                        }
                        str7 = "";
                        return a(str7, string2);
                    } else {
                        if (payType == null) {
                            str2 = null;
                        } else if (payType != null) {
                            str2 = payType.toLowerCase();
                            k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                        if (str2 != null) {
                            int hashCode4 = str2.hashCode();
                            if (hashCode4 != -318370833) {
                                if (hashCode4 == 757836652) {
                                    if (str2.equals(BaseViewModel.PaymentType.POSTPAID)) {
                                        String dueDate = cjrBillDetails.getDueDate();
                                        k.a((Object) dueDate, "cjrBillDetails.dueDate");
                                        str5 = a(dueDate);
                                        View view9 = this.itemView;
                                        k.a((Object) view9, "itemView");
                                        Context context7 = view9.getContext();
                                        int i8 = R.string.v3_recent_bill_reminder_due_on;
                                        net.one97.paytm.recharge.widgets.c.d dVar7 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                        str4 = context7.getString(i8, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10), str5});
                                        k.a((Object) str4, "itemView.context.getStri…           formattedDate)");
                                    }
                                }
                            } else if (str2.equals("prepaid")) {
                                String expiry = cjrBillDetails.getExpiry();
                                k.a((Object) expiry, "cjrBillDetails.expiry");
                                str5 = a(expiry);
                                View view10 = this.itemView;
                                k.a((Object) view10, "itemView");
                                Context context8 = view10.getContext();
                                int i9 = R.string.v8_recent_recharge_remainder_expires_on;
                                net.one97.paytm.recharge.widgets.c.d dVar8 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                str4 = context8.getString(i9, new Object[]{a2, net.one97.paytm.recharge.widgets.c.d.a(String.valueOf(cjrBillDetails.getAmount().doubleValue()), false, 2, false, 10), str5});
                                k.a((Object) str4, "itemView.context.getStri…           formattedDate)");
                            }
                            str3 = str5;
                            return a(str4, str3);
                        }
                        str4 = "";
                        str3 = str4;
                        return a(str4, str3);
                    }
                }
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                return null;
            }
        }

        private static String a(String str) {
            Date i2 = com.paytm.utility.b.i(str, "yyyy-MM-dd", (String) null);
            int a2 = com.paytm.utility.b.a(i2);
            String a3 = v.a(String.valueOf(a2), com.paytm.utility.b.b(a2), " ", com.paytm.utility.b.a(i2, 2));
            k.a((Object) a3, "StringUtils.concat(dateI…                   month)");
            return a3;
        }

        private final SpannableString a(String str, String str2) {
            CharSequence charSequence = str;
            int a2 = kotlin.m.p.a(charSequence, str2, 0, false, 6);
            if (a2 == -1) {
                return new SpannableString(charSequence);
            }
            int length = str2.length() + a2;
            SpannableString spannableString = new SpannableString(charSequence);
            try {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffa400")), a2, length, 33);
                View view = this.itemView;
                k.a((Object) view, "itemView");
                spannableString.setSpan(w.a(view.getContext(), "Roboto-Medium.ttf"), a2, length, 33);
            } catch (Exception unused) {
            }
            return spannableString;
        }

        public final void a(CJRFrequentOrder cJRFrequentOrder, List<CJRAutomaticSubscriptionItemModel> list, q qVar) {
            r rVar;
            k.c(cJRFrequentOrder, "recent");
            k.c(list, "paymentAutomaticSubscriptionList");
            k.c(qVar, "statusListener");
            String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
            CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
            if (frequentOrderProduct != null && frequentOrderProduct.isSchedulable() && !TextUtils.isEmpty(rechargeNumber) && (rVar = this.f60653b.p) != null) {
                k.a((Object) rechargeNumber, "rechargeNumber");
                rVar.a(list, qVar, rechargeNumber, cJRFrequentOrder);
            }
        }
    }
}
