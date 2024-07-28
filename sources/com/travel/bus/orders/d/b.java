package com.travel.bus.orders.d;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gsonhtcfix.f;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.orders.c.c;
import com.travel.bus.pojo.CJRFlightSummaryMetadataResponse;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.m;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f22622a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f22623b;

    /* renamed from: c  reason: collision with root package name */
    private int f22624c;

    /* renamed from: d  reason: collision with root package name */
    private CJRBusOrderSummary f22625d;

    /* renamed from: e  reason: collision with root package name */
    private Context f22626e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f22627f;

    /* renamed from: g  reason: collision with root package name */
    private c.b f22628g;

    /* renamed from: h  reason: collision with root package name */
    private m f22629h;

    public b(Context context, CJRBusOrderSummary cJRBusOrderSummary, c.b bVar, m mVar) {
        this.f22626e = context;
        this.f22625d = cJRBusOrderSummary;
        this.f22628g = bVar;
        this.f22629h = mVar;
    }

    public final void a() {
        if (this.f22625d != null) {
            this.f22627f = new ArrayList<>();
            for (int i2 = 0; i2 < this.f22625d.getOrderedCartList().size(); i2++) {
                this.f22627f.add(this.f22625d.getOrderedCartList().get(i2).getName());
            }
            if (this.f22625d.getOrderedCartList().size() >= 2) {
                this.f22627f.add(0, "Select All");
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f22626e);
                TextView textView = new TextView(this.f22626e);
                textView.setText(this.f22626e.getString(R.string.contact_us_title_query_regarding));
                textView.setPadding(10, 10, 10, 10);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setTextColor(androidx.core.content.b.c(this.f22626e, R.color.color_33b5e5));
                ListView listView = new ListView(this.f22626e);
                listView.setChoiceMode(1);
                listView.setAdapter(new com.travel.bus.orders.a.c(this.f22626e, this.f22627f));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                        b.this.a(adapterView, view, i2, j);
                    }
                });
                builder.setCustomTitle(textView);
                builder.setInverseBackgroundForced(true);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(listView) {
                    private final /* synthetic */ ListView f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        b.this.a(this.f$1, dialogInterface, i2);
                    }
                });
                builder.setView(listView);
                this.f22622a = builder.create();
                this.f22624c = 0;
                this.f22622a.show();
                return;
            }
            CJRBusOrderedCart cJRBusOrderedCart = this.f22625d.getOrderedCartList().get(0);
            cJRBusOrderedCart.setOrderId(this.f22625d.getId());
            Bundle bundle = new Bundle();
            bundle.putString(UpiConstants.FROM, a(cJRBusOrderedCart));
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJRBusOrderedCart);
            bundle.putInt("ordinal", this.f22628g.ordinal());
            bundle.putString("cst-order-id", this.f22625d.getId());
            bundle.putString("downLoadFileName", a(this.f22625d.getOrderedCartList()));
            m mVar = this.f22629h;
            if (mVar != null) {
                mVar.show();
            }
            a.a();
            a.b().a(this.f22626e, bundle, this.f22629h);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AdapterView adapterView, View view, int i2, long j) {
        if (this.f22622a.isShowing()) {
            this.f22624c = i2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ListView listView, DialogInterface dialogInterface, int i2) {
        int i3;
        Resources resources = this.f22626e.getResources();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 11) {
            i3 = listView.getCheckedItemCount();
        } else {
            int i4 = 0;
            for (int count = listView.getCount() - 1; count >= 0; count--) {
                if (listView.isItemChecked(count)) {
                    i4++;
                }
            }
            i3 = i4;
        }
        if (i3 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f22626e);
            TextView textView = new TextView(this.f22626e);
            textView.setText(this.f22626e.getResources().getString(R.string.error));
            textView.setPadding(10, 10, 10, 10);
            textView.setGravity(17);
            textView.setTextSize(20.0f);
            textView.setTextColor(androidx.core.content.b.c(this.f22626e, R.color.color_33b5e5));
            builder.setCustomTitle(textView);
            builder.setMessage(this.f22626e.getResources().getString(R.string.contact_us_select_item_message));
            builder.setPositiveButton(resources.getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    b.this.a(dialogInterface, i2);
                }
            });
            this.f22623b = builder.create();
            this.f22623b.show();
            return;
        }
        this.f22622a.dismiss();
        int i5 = this.f22624c;
        if (i5 == 0) {
            this.f22624c = b();
            z = true;
        } else {
            this.f22624c = i5 - 1;
        }
        CJRBusOrderedCart cJRBusOrderedCart = this.f22625d.getOrderedCartList().get(this.f22624c);
        cJRBusOrderedCart.setOrderId(this.f22625d.getId());
        cJRBusOrderedCart.setAllItemsSelected(z);
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.FROM, a(cJRBusOrderedCart));
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJRBusOrderedCart);
        bundle.putInt("ordinal", this.f22628g.ordinal());
        bundle.putString("cst-order-id", this.f22625d.getId());
        bundle.putString("downLoadFileName", a(this.f22625d.getOrderedCartList()));
        m mVar = this.f22629h;
        if (mVar != null) {
            mVar.show();
        }
        a.a();
        a.b().a(this.f22626e, bundle, this.f22629h);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        this.f22623b.dismiss();
        this.f22622a.show();
    }

    private int b() {
        for (int i2 = 0; i2 < this.f22625d.getOrderedCartList().size(); i2++) {
            CJRBusOrderedCart cJRBusOrderedCart = this.f22625d.getOrderedCartList().get(i2);
            if (cJRBusOrderedCart.getProductDetail().getVerticalId() == 64 || cJRBusOrderedCart.getProductDetail().getVerticalId() == 26 || cJRBusOrderedCart.getProductDetail().getVerticalId() == 72) {
                return i2;
            }
        }
        return 0;
    }

    private String a(CJRBusOrderedCart cJRBusOrderedCart) {
        CJROrderSummaryProductDetail productDetail;
        if (!(cJRBusOrderedCart == null || (productDetail = cJRBusOrderedCart.getProductDetail()) == null || productDetail.getVertical() == null)) {
            if (!productDetail.getVertical().equalsIgnoreCase("Insurance")) {
                return productDetail.getVertical();
            }
            Iterator<CJRBusOrderedCart> it2 = this.f22625d.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (!next.getProductDetail().getVertical().equalsIgnoreCase("Insurance")) {
                    if (!next.getProductDetail().getVertical().equalsIgnoreCase("Flights")) {
                        return next.getProductDetail().getVertical();
                    }
                    return next.getProductDetail().getVertical() + "_Insurance";
                }
            }
        }
        return "";
    }

    private static String a(ArrayList<CJRBusOrderedCart> arrayList) {
        Iterator<CJRBusOrderedCart> it2 = arrayList.iterator();
        String str = "";
        while (it2.hasNext()) {
            Object metaDataResponse = it2.next().getMetaDataResponse();
            f fVar = new f();
            CJRFlightSummaryMetadataResponse cJRFlightSummaryMetadataResponse = (CJRFlightSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJRFlightSummaryMetadataResponse.class);
            String source = cJRFlightSummaryMetadataResponse.getSource();
            String destination = cJRFlightSummaryMetadataResponse.getDestination();
            String g2 = com.paytm.utility.b.g(cJRFlightSummaryMetadataResponse.getJourney_departure_date(), "yyyy-MM-dd", "d MMM");
            String journey_return_date = cJRFlightSummaryMetadataResponse.getJourney_return_date();
            if (TextUtils.isEmpty(journey_return_date)) {
                str = source + "-" + destination + "_" + g2;
            } else {
                str = source + "-" + destination + "-" + source + "_" + g2 + "_" + com.paytm.utility.b.g(journey_return_date, "yyyy-MM-dd", "d MMM");
            }
        }
        return str;
    }
}
