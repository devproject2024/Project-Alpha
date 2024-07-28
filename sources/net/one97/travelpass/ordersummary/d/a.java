package net.one97.travelpass.ordersummary.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.TPOrderSummaryContactUs;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.travelpass.d;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f30510a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f30511b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public int f30512c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f30513d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TPOrderSummaryContactUs> f30514e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final OrderSummaryBodyItem f30515f;

    /* renamed from: g  reason: collision with root package name */
    private String f30516g = "";

    public a(Context context, OrderSummaryBodyItem orderSummaryBodyItem, String str) {
        this.f30510a = context;
        this.f30515f = orderSummaryBodyItem;
        List<TPOrderSummaryContactUs> tPOrderSummaryCSTData = orderSummaryBodyItem != null ? orderSummaryBodyItem.getTPOrderSummaryCSTData() : null;
        if (tPOrderSummaryCSTData != null) {
            this.f30514e = (ArrayList) tPOrderSummaryCSTData;
            this.f30511b = a(orderSummaryBodyItem);
            ArrayList<String> arrayList = this.f30511b;
            if (arrayList == null) {
                k.a();
            }
            if (arrayList.size() > 1) {
                ArrayList<String> arrayList2 = this.f30511b;
                if (arrayList2 == null) {
                    k.a();
                }
                arrayList2.add(0, "Select All");
            }
            this.f30516g = str;
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.TPOrderSummaryContactUs>");
    }

    /* renamed from: net.one97.travelpass.ordersummary.d.a$a  reason: collision with other inner class name */
    public static final class C0517a implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30517a;

        public C0517a(a aVar) {
            this.f30517a = aVar;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (this.f30517a.f30513d != null) {
                Dialog dialog = this.f30517a.f30513d;
                if (dialog == null) {
                    k.a();
                }
                if (dialog.isShowing()) {
                    this.f30517a.f30512c = i2;
                }
            }
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30518a;

        public b(a aVar) {
            this.f30518a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            a aVar = this.f30518a;
            aVar.a(aVar.f30512c);
            this.f30518a.a();
        }
    }

    private static ArrayList<String> a(OrderSummaryBodyItem orderSummaryBodyItem) {
        ArrayList<String> arrayList = null;
        List<TPOrderSummaryContactUs> tPOrderSummaryCSTData = orderSummaryBodyItem != null ? orderSummaryBodyItem.getTPOrderSummaryCSTData() : null;
        Collection collection = tPOrderSummaryCSTData;
        if (!(collection == null || collection.isEmpty())) {
            arrayList = new ArrayList<>();
            for (TPOrderSummaryContactUs next : tPOrderSummaryCSTData) {
                k.a((Object) next, "contactUsData");
                CharSequence promoCode = next.getPromoCode();
                if (!(promoCode == null || promoCode.length() == 0)) {
                    arrayList.add(next.getPromoCode());
                }
            }
        }
        return arrayList;
    }

    public final void a(int i2) {
        boolean z = i2 == 0;
        if (i2 > 0) {
            i2--;
        }
        ArrayList<TPOrderSummaryContactUs> arrayList = this.f30514e;
        if (arrayList != null) {
            TPOrderSummaryContactUs tPOrderSummaryContactUs = arrayList != null ? arrayList.get(i2) : null;
            if (tPOrderSummaryContactUs != null) {
                tPOrderSummaryContactUs.setAllItemsSelected(z);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, tPOrderSummaryContactUs);
            bundle.putString("featuretype", "travelpass");
            k.a((Object) d.a(), "TravelPassController.getInstance()");
            d.b().a(this.f30510a, bundle);
        }
    }

    public final void a() {
        Dialog dialog;
        Dialog dialog2 = this.f30513d;
        if (dialog2 != null) {
            if (dialog2 == null) {
                k.a();
            }
            if (dialog2.isShowing() && (dialog = this.f30513d) != null) {
                dialog.dismiss();
            }
        }
    }
}
