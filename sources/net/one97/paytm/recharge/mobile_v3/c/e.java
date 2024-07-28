package net.one97.paytm.recharge.mobile_v3.c;

import android.content.DialogInterface;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.e.q;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.ordersummary.c.c;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class e extends c implements q {
    private final TextView k;
    private final TextView l;
    private final CJRRechargeLottieAnimationView m;
    private final View n;
    private final ImageView o;

    static final class d<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f63918a = new d();

        d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.c.e$e  reason: collision with other inner class name */
    static final class C1252e implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final C1252e f63919a = new C1252e();

        C1252e() {
        }

        public final void run() {
        }
    }

    public final void a() {
    }

    public final void a(boolean z) {
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<List<? extends CJRAutomaticSubscriptionItemModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63915a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f63916b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRFrequentOrder f63917c;

        c(e eVar, int i2, CJRFrequentOrder cJRFrequentOrder) {
            this.f63915a = eVar;
            this.f63916b = i2;
            this.f63917c = cJRFrequentOrder;
        }

        public final /* synthetic */ void accept(Object obj) {
            List list = (List) obj;
            e eVar = this.f63915a;
            CJRFrequentOrder cJRFrequentOrder = this.f63917c;
            k.a((Object) list, "it");
            eVar.a(cJRFrequentOrder, list, this.f63915a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63912a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f63913b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRFrequentOrder f63914c;

        b(e eVar, int i2, CJRFrequentOrder cJRFrequentOrder) {
            this.f63912a = eVar;
            this.f63913b = i2;
            this.f63914c = cJRFrequentOrder;
        }

        public final void onClick(View view) {
            e eVar = this.f63912a;
            k.a((Object) view, "it");
            int i2 = this.f63913b;
            CJRFrequentOrder cJRFrequentOrder = this.f63914c;
            View view2 = eVar.itemView;
            k.a((Object) view2, "itemView");
            Object tag = view2.getTag();
            if (!(tag instanceof HashMap)) {
                tag = null;
            }
            HashMap hashMap = (HashMap) tag;
            Object obj = hashMap != null ? hashMap.get("tagShowSetupAutomatic") : null;
            if (!(obj instanceof Boolean)) {
                obj = null;
            }
            Boolean bool = (Boolean) obj;
            Object obj2 = hashMap != null ? hashMap.get("tagShowManageAutomatic") : null;
            if (!(obj2 instanceof Boolean)) {
                obj2 = null;
            }
            Boolean bool2 = (Boolean) obj2;
            Object obj3 = hashMap != null ? hashMap.get("subscription_item_model") : null;
            if (!(obj3 instanceof CJRAutomaticSubscriptionItemModel)) {
                obj3 = null;
            }
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) obj3;
            View view3 = eVar.itemView;
            k.a((Object) view3, "itemView");
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view3.getContext(), R.style.recentPopUpMenuAppStyle), view);
            if (Build.VERSION.SDK_INT >= 28) {
                popupMenu.getMenu().setGroupDividerEnabled(true);
            }
            popupMenu.getMenuInflater().inflate(R.menu.v3_mobile_recent_item_menu, popupMenu.getMenu());
            if (Build.VERSION.SDK_INT >= 23) {
                popupMenu.setGravity(8388613);
            }
            MenuItem findItem = popupMenu.getMenu().findItem(R.id.delete);
            if (k.a((Object) bool2, (Object) Boolean.TRUE)) {
                popupMenu.getMenu().removeGroup(R.id.setup_automatic_bill_payment_group);
            } else if (k.a((Object) bool, (Object) Boolean.TRUE)) {
                popupMenu.getMenu().removeGroup(R.id.manage_automatic_bill_payment_group);
            } else {
                popupMenu.getMenu().removeGroup(R.id.setup_automatic_bill_payment_group);
                popupMenu.getMenu().removeGroup(R.id.manage_automatic_bill_payment_group);
            }
            popupMenu.getMenu().removeGroup(R.id.view_past_bills_and_payments_group);
            k.a((Object) findItem, "deleteItem");
            View view4 = eVar.itemView;
            k.a((Object) view4, "itemView");
            net.one97.paytm.recharge.common.utils.g.a(findItem, androidx.core.content.b.c(view4.getContext(), R.color.color_ff585d));
            popupMenu.setOnMenuItemClickListener(new f(eVar, cJRFrequentOrder, i2, cJRAutomaticSubscriptionItemModel));
            popupMenu.show();
            net.one97.paytm.recharge.mobile_v3.d.c cVar = eVar.f60653b.s;
            if (cVar != null) {
                cVar.a(true);
            }
            popupMenu.setOnDismissListener(new g(eVar));
        }
    }

    static final class f implements PopupMenu.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63920a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRFrequentOrder f63921b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f63922c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRAutomaticSubscriptionItemModel f63923d;

        f(e eVar, CJRFrequentOrder cJRFrequentOrder, int i2, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
            this.f63920a = eVar;
            this.f63921b = cJRFrequentOrder;
            this.f63922c = i2;
            this.f63923d = cJRAutomaticSubscriptionItemModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            p.a aVar;
            k.a((Object) menuItem, "item");
            int itemId = menuItem.getItemId();
            if (itemId == R.id.setup_automatic_bill_payment) {
                p.a aVar2 = this.f63920a.f60653b.f61927e;
                if (aVar2 != null) {
                    aVar2.b(this.f63921b, this.f63922c);
                }
            } else if (itemId == R.id.delete) {
                e eVar = this.f63920a;
                CJRFrequentOrder cJRFrequentOrder = this.f63921b;
                View view = eVar.itemView;
                k.a((Object) view, "itemView");
                j jVar = null;
                if (com.paytm.utility.b.c(view.getContext())) {
                    CJRRecentOrderV8.a aVar3 = eVar.f60653b;
                    if (aVar3 != null) {
                        jVar = aVar3.r;
                    }
                    if (jVar != null) {
                        c.a aVar4 = net.one97.paytm.recharge.ordersummary.c.c.f64038b;
                        View view2 = eVar.itemView;
                        k.a((Object) view2, "itemView");
                        String string = view2.getContext().getString(R.string.delete_recent_bottom_sheet_title);
                        k.a((Object) string, "itemView.context.getStri…ecent_bottom_sheet_title)");
                        View view3 = eVar.itemView;
                        k.a((Object) view3, "itemView");
                        String string2 = view3.getContext().getString(R.string.v8_os_cancel_insurence_pst_btn_txt);
                        k.a((Object) string2, "itemView.context.getStri…el_insurence_pst_btn_txt)");
                        View view4 = eVar.itemView;
                        k.a((Object) view4, "itemView");
                        String string3 = view4.getContext().getString(R.string.v8_os_cancel_insurence_ngtv_btn_txt);
                        View view5 = eVar.itemView;
                        k.a((Object) view5, "itemView");
                        String string4 = view5.getContext().getString(R.string.delete_recent_bottom_sheet_message);
                        k.a((Object) string4, "itemView.context.getStri…ent_bottom_sheet_message)");
                        View view6 = eVar.itemView;
                        k.a((Object) view6, "itemView");
                        String string5 = view6.getContext().getString(R.string.delete_recent_bottom_sheet_confirmation_message);
                        k.a((Object) string5, "itemView.context.getStri…eet_confirmation_message)");
                        net.one97.paytm.recharge.ordersummary.c.c a2 = c.a.a(string, string2, string3, string4, string5, "");
                        a2.f64228c = new a(eVar, cJRFrequentOrder);
                        j jVar2 = eVar.f60653b.r;
                        if (jVar2 != null) {
                            a2.show(jVar2, net.one97.paytm.recharge.ordersummary.c.c.class.getSimpleName());
                        }
                    } else {
                        p.a aVar5 = eVar.f60653b.f61927e;
                        if (aVar5 != null) {
                            aVar5.a(cJRFrequentOrder, eVar.getAdapterPosition());
                        }
                    }
                } else {
                    p.c cVar = eVar.f60653b.f61928f;
                    if (cVar != null) {
                        cVar.a("", new as(false, 1, (kotlin.g.b.g) null));
                    }
                }
            } else if (!(itemId != R.id.manage_automatic_bill_payment || this.f63923d == null || (aVar = this.f63920a.f60653b.f61927e) == null)) {
                aVar.a(this.f63921b, this.f63923d, this.f63922c);
            }
            return true;
        }
    }

    static final class g implements PopupMenu.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63924a;

        g(e eVar) {
            this.f63924a = eVar;
        }

        public final void onDismiss(PopupMenu popupMenu) {
            net.one97.paytm.recharge.mobile_v3.d.c cVar = this.f63924a.f60653b.s;
            if (cVar != null) {
                cVar.a(false);
            }
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63910a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRFrequentOrder f63911b;

        a(e eVar, CJRFrequentOrder cJRFrequentOrder) {
            this.f63910a = eVar;
            this.f63911b = cJRFrequentOrder;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                dialogInterface.dismiss();
                return;
            }
            p.a aVar = this.f63910a.f60653b.f61927e;
            if (aVar != null) {
                aVar.a(this.f63911b, this.f63910a.getAdapterPosition());
            }
        }
    }

    public final void b() {
        View view = this.itemView;
        k.a((Object) view, "itemView");
        Object tag = view.getTag();
        if (!(tag instanceof HashMap)) {
            tag = null;
        }
        HashMap hashMap = (HashMap) tag;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Map map = hashMap;
        map.put("tagShowSetupAutomatic", Boolean.TRUE);
        map.put("tagShowManageAutomatic", Boolean.FALSE);
        View view2 = this.itemView;
        k.a((Object) view2, "itemView");
        view2.setTag(hashMap);
    }

    public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        View view = this.itemView;
        k.a((Object) view, "itemView");
        Object tag = view.getTag();
        if (!(tag instanceof HashMap)) {
            tag = null;
        }
        HashMap hashMap = (HashMap) tag;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Map map = hashMap;
        map.put("tagShowManageAutomatic", Boolean.TRUE);
        map.put("tagShowSetupAutomatic", Boolean.FALSE);
        map.put("subscription_item_model", cJRAutomaticSubscriptionItemModel);
        View view2 = this.itemView;
        k.a((Object) view2, "itemView");
        view2.setTag(hashMap);
    }

    public final void d() {
        a((LottieAnimationView) this.m);
        TextView textView = this.l;
        if (textView != null) {
            View view = this.itemView;
            k.a((Object) view, "itemView");
            textView.setTextColor(androidx.core.content.b.c(view.getContext(), R.color.color_00B9F5));
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02a6, code lost:
        if (r1 == null) goto L_0x02a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r14, net.one97.paytm.common.entity.recharge.CJRFrequentOrder r15) {
        /*
            r13 = this;
            java.lang.String r0 = "recentOrder"
            kotlin.g.b.k.c(r15, r0)
            r13.j = r15
            java.lang.String r1 = r15.getRechargeNumber()
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r2 = r15.getRechargeAmount()
            java.lang.String r3 = "recentOrder.rechargeAmount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 10
            r4 = 2
            r5 = 0
            java.lang.String r2 = net.one97.paytm.recharge.widgets.c.d.a(r2, r5, r4, r5, r3)
            java.util.List r6 = r15.getmBillDetails()
            int r6 = r6.size()
            r7 = 0
            if (r6 <= 0) goto L_0x0075
            java.util.List r6 = r15.getmBillDetails()
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r8 = "recentOrder.getmBillDetails()[0]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r6 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r6
            java.lang.Double r6 = r6.getAmount()
            double r9 = r6.doubleValue()
            r11 = 0
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x0075
            java.util.List r6 = r15.getmBillDetails()
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r6 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r6
            net.one97.paytm.common.entity.recharge.CJRBillDetails r6 = net.one97.paytm.recharge.common.utils.ba.a((net.one97.paytm.common.entity.recharge.CJRBillDetails) r6, (android.content.Context) r7)
            if (r6 == 0) goto L_0x0075
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.util.List r2 = r15.getmBillDetails()
            java.lang.Object r2 = r2.get(r5)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r2
            java.lang.Double r2 = r2.getAmount()
            double r8 = r2.doubleValue()
            java.lang.String r2 = java.lang.String.valueOf(r8)
            java.lang.String r2 = net.one97.paytm.recharge.widgets.c.d.a(r2, r5, r4, r5, r3)
        L_0x0075:
            android.view.View r3 = r13.itemView
            java.lang.String r6 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.content.Context r3 = r3.getContext()
            int r8 = net.one97.paytm.recharge.R.string.v3_recent_rupees_amount
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]
            r10[r5] = r2
            java.lang.String r2 = r3.getString(r8, r10)
            java.lang.String r3 = "itemView.context.getStri…nt_rupees_amount, amount)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.text.SpannableString r3 = new android.text.SpannableString
            r8 = r2
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.<init>(r8)
            android.text.style.StyleSpan r8 = new android.text.style.StyleSpan
            r8.<init>(r9)
            int r2 = r2.length()
            r10 = 33
            r3.setSpan(r8, r9, r2, r10)
            android.widget.TextView r2 = r13.k
            if (r2 == 0) goto L_0x00af
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x00af:
            android.widget.TextView r2 = r13.l
            java.lang.String r3 = "postpaid"
            if (r2 == 0) goto L_0x00f1
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r8 = r13.j
            if (r8 == 0) goto L_0x00bd
            java.lang.String r7 = r8.getPayType()
        L_0x00bd:
            boolean r7 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r9)
            if (r7 == 0) goto L_0x00d8
            android.view.View r7 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            android.content.Context r7 = r7.getContext()
            int r8 = net.one97.paytm.recharge.R.string.pay_bill
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r8 = "itemView.context.getString(R.string.pay_bill)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            goto L_0x00ec
        L_0x00d8:
            android.view.View r7 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            android.content.Context r7 = r7.getContext()
            int r8 = net.one97.paytm.recharge.R.string.recharge
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r8 = "itemView.context.getString(R.string.recharge)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
        L_0x00ec:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
        L_0x00f1:
            net.one97.paytm.recharge.common.utils.n r2 = net.one97.paytm.recharge.common.utils.n.f61679a
            java.lang.String r2 = "rechargeNumber"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.recharge.model.ContactItemModel r2 = net.one97.paytm.recharge.common.utils.n.a((java.lang.String) r1)
            r7 = 32
            java.lang.String r8 = "prepaid"
            r10 = 8
            java.lang.String r11 = ""
            if (r2 == 0) goto L_0x01a2
            java.lang.String r0 = r15.getPayType()
            boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x0139
            android.widget.TextView r0 = r13.f63895e
            if (r0 == 0) goto L_0x019d
            android.view.View r3 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.content.Context r3 = r3.getContext()
            int r7 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_postpaid
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r1
            java.lang.String r1 = r15.getOperatorDisplayLabel()
            r4[r9] = r1
            java.lang.String r1 = r3.getString(r7, r4)
            if (r1 == 0) goto L_0x0132
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0135
        L_0x0132:
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0135:
            r0.setText(r1)
            goto L_0x019d
        L_0x0139:
            java.lang.String r0 = r15.getPayType()
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x016c
            android.widget.TextView r0 = r13.f63895e
            if (r0 == 0) goto L_0x019d
            android.view.View r3 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.content.Context r3 = r3.getContext()
            int r7 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_prepaid
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r1
            java.lang.String r1 = r15.getOperatorDisplayLabel()
            r4[r9] = r1
            java.lang.String r1 = r3.getString(r7, r4)
            if (r1 == 0) goto L_0x0165
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0168
        L_0x0165:
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0168:
            r0.setText(r1)
            goto L_0x019d
        L_0x016c:
            android.widget.TextView r0 = r13.f63895e
            if (r0 == 0) goto L_0x019d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = ", "
            r3.append(r1)
            java.lang.String r1 = r15.getOperatorDisplayLabel()
            r3.append(r1)
            r3.append(r7)
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r1 = r15.getPayType()
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.b(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x019d:
            r13.a((net.one97.paytm.recharge.model.ContactItemModel) r2, (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r15)
            goto L_0x0275
        L_0x01a2:
            r2 = r13
            net.one97.paytm.recharge.mobile_v3.c.e r2 = (net.one97.paytm.recharge.mobile_v3.c.e) r2
            android.widget.TextView r4 = r2.f63893c
            if (r4 == 0) goto L_0x01ae
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
        L_0x01ae:
            java.lang.String r1 = r15.getPayType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r9)
            if (r1 == 0) goto L_0x01df
            android.widget.TextView r1 = r2.f63895e
            if (r1 == 0) goto L_0x0239
            android.view.View r3 = r2.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.content.Context r3 = r3.getContext()
            int r4 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_postpaid_wo_number
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r8 = r15.getOperatorDisplayLabel()
            r7[r5] = r8
            java.lang.String r3 = r3.getString(r4, r7)
            if (r3 == 0) goto L_0x01d8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x01db
        L_0x01d8:
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x01db:
            r1.setText(r3)
            goto L_0x0239
        L_0x01df:
            java.lang.String r1 = r15.getPayType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r9)
            if (r1 == 0) goto L_0x0210
            android.widget.TextView r1 = r2.f63895e
            if (r1 == 0) goto L_0x0239
            android.view.View r3 = r2.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.content.Context r3 = r3.getContext()
            int r4 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_prepaid_wo_number
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r8 = r15.getOperatorDisplayLabel()
            r7[r5] = r8
            java.lang.String r3 = r3.getString(r4, r7)
            if (r3 == 0) goto L_0x0209
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x020c
        L_0x0209:
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x020c:
            r1.setText(r3)
            goto L_0x0239
        L_0x0210:
            android.widget.TextView r1 = r2.f63895e
            if (r1 == 0) goto L_0x0239
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r15.getOperatorDisplayLabel()
            r3.append(r4)
            r3.append(r7)
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r4 = r15.getPayType()
            java.lang.String r4 = net.one97.paytm.recharge.widgets.c.d.b(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x0239:
            kotlin.g.b.k.c(r15, r0)
            android.widget.ImageView r0 = r2.f63896f
            if (r0 == 0) goto L_0x0243
            r0.setVisibility(r5)
        L_0x0243:
            android.widget.TextView r0 = r2.f63894d
            if (r0 == 0) goto L_0x024a
            r0.setVisibility(r10)
        L_0x024a:
            java.lang.String r0 = r15.getOperatorLogoURL()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x026c
            android.widget.ImageView r1 = r2.f63896f
            if (r1 == 0) goto L_0x025e
            r1.setVisibility(r5)
        L_0x025e:
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r0 = r1.a((java.lang.String) r0)
            android.widget.ImageView r1 = r2.f63896f
            r0.a((android.widget.ImageView) r1)
            goto L_0x0275
        L_0x026c:
            android.widget.ImageView r0 = r2.f63896f
            if (r0 == 0) goto L_0x0275
            int r1 = net.one97.paytm.recharge.R.drawable.v3_default_logo_contact
            r0.setImageResource(r1)
        L_0x0275:
            android.widget.TextView r0 = r13.f63895e
            if (r0 == 0) goto L_0x028b
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.color.v3_text_color_black
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
        L_0x028b:
            java.util.List r0 = r15.getmBillDetails()
            if (r0 == 0) goto L_0x0297
            boolean r1 = r0.isEmpty()
            if (r1 == r9) goto L_0x02a8
        L_0x0297:
            java.lang.Object r1 = r0.get(r5)
            java.lang.String r2 = "billsList[0]"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r1 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r1
            java.lang.String r1 = r1.getLabel()
            if (r1 != 0) goto L_0x02a9
        L_0x02a8:
            r1 = r11
        L_0x02a9:
            if (r0 == 0) goto L_0x02b1
            boolean r2 = r0.isEmpty()
            if (r2 == r9) goto L_0x02bf
        L_0x02b1:
            java.lang.Object r2 = r0.get(r5)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r2
            if (r2 == 0) goto L_0x02bf
            java.lang.String r2 = r2.getBillsLabelColor()
            if (r2 != 0) goto L_0x02c1
        L_0x02bf:
            java.lang.String r2 = r13.f63899i
        L_0x02c1:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x02f8
            java.lang.Object r0 = r0.get(r5)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r0
            boolean r0 = net.one97.paytm.recharge.common.utils.ba.c((net.one97.paytm.common.entity.recharge.CJRBillDetails) r0)
            if (r0 == 0) goto L_0x02f8
            android.widget.TextView r0 = r13.f63897g
            if (r0 == 0) goto L_0x02dc
            r0.setVisibility(r10)
        L_0x02dc:
            android.widget.TextView r0 = r13.f63898h
            if (r0 == 0) goto L_0x02e3
            r0.setText(r1)
        L_0x02e3:
            android.widget.TextView r0 = r13.f63898h
            if (r0 == 0) goto L_0x02f0
            java.lang.String r1 = r13.f63899i
            int r1 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r2, (java.lang.String) r1)
            r0.setTextColor(r1)
        L_0x02f0:
            android.widget.TextView r0 = r13.f63898h
            if (r0 == 0) goto L_0x0329
            r0.setVisibility(r5)
            goto L_0x0329
        L_0x02f8:
            android.widget.TextView r0 = r13.f63897g
            if (r0 == 0) goto L_0x02ff
            r0.setVisibility(r10)
        L_0x02ff:
            android.widget.TextView r0 = r13.f63898h
            if (r0 == 0) goto L_0x030c
            java.lang.String r1 = r15.getmCreatedAt()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x030c:
            android.widget.TextView r0 = r13.f63898h
            if (r0 == 0) goto L_0x0322
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.color.v3_text_2
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
        L_0x0322:
            android.widget.TextView r0 = r13.f63898h
            if (r0 == 0) goto L_0x0329
            r0.setVisibility(r5)
        L_0x0329:
            android.widget.ImageView r0 = r13.o
            if (r0 == 0) goto L_0x0330
            r0.setVisibility(r5)
        L_0x0330:
            android.widget.ImageView r0 = r13.o
            if (r0 == 0) goto L_0x0339
            int r1 = net.one97.paytm.recharge.R.drawable.v3_ic_elipses_menu
            r0.setImageResource(r1)
        L_0x0339:
            android.view.View r0 = r13.n
            if (r0 == 0) goto L_0x0347
            net.one97.paytm.recharge.mobile_v3.c.e$b r1 = new net.one97.paytm.recharge.mobile_v3.c.e$b
            r1.<init>(r13, r14, r15)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x0347:
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r0 = r13.f60653b
            net.one97.paytm.recharge.common.e.r r0 = r0.p
            if (r0 == 0) goto L_0x0365
            io.reactivex.rxjava3.j.c r0 = r0.f()
            if (r0 == 0) goto L_0x0365
            net.one97.paytm.recharge.mobile_v3.c.e$c r1 = new net.one97.paytm.recharge.mobile_v3.c.e$c
            r1.<init>(r13, r14, r15)
            io.reactivex.rxjava3.d.g r1 = (io.reactivex.rxjava3.d.g) r1
            net.one97.paytm.recharge.mobile_v3.c.e$d r14 = net.one97.paytm.recharge.mobile_v3.c.e.d.f63918a
            io.reactivex.rxjava3.d.g r14 = (io.reactivex.rxjava3.d.g) r14
            net.one97.paytm.recharge.mobile_v3.c.e$e r15 = net.one97.paytm.recharge.mobile_v3.c.e.C1252e.f63919a
            io.reactivex.rxjava3.d.a r15 = (io.reactivex.rxjava3.d.a) r15
            r0.subscribe(r1, r14, r15)
        L_0x0365:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.c.e.a(int, net.one97.paytm.common.entity.recharge.CJRFrequentOrder):void");
    }
}
