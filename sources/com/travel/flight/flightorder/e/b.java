package com.travel.flight.flightorder.e;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.travel.flight.R;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryProductDetail;
import net.one97.paytm.m;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    Dialog f24403a;

    /* renamed from: b  reason: collision with root package name */
    Dialog f24404b;

    /* renamed from: c  reason: collision with root package name */
    int f24405c;

    /* renamed from: d  reason: collision with root package name */
    CJRFlightOrderSummaryResponse f24406d;

    /* renamed from: e  reason: collision with root package name */
    Context f24407e;

    /* renamed from: f  reason: collision with root package name */
    b.C0467b f24408f;

    /* renamed from: g  reason: collision with root package name */
    m f24409g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f24410h;

    public b(Context context, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, b.C0467b bVar, m mVar) {
        this.f24407e = context;
        this.f24406d = cJRFlightOrderSummaryResponse;
        this.f24408f = bVar;
        this.f24409g = mVar;
    }

    public final void a() {
        if (this.f24406d != null) {
            this.f24410h = new ArrayList<>();
            for (int i2 = 0; i2 < this.f24406d.getBody().getItems().size(); i2++) {
                this.f24410h.add(this.f24406d.getBody().getItems().get(i2).getName());
            }
            c();
        }
    }

    private void c() {
        if (this.f24406d.getBody().getItems().size() >= 2) {
            this.f24410h.add(0, "Select All");
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f24407e);
            TextView textView = new TextView(this.f24407e);
            textView.setText(this.f24407e.getString(R.string.contact_us_title_query_regarding));
            textView.setPadding(10, 10, 10, 10);
            textView.setGravity(17);
            textView.setTextSize(20.0f);
            textView.setTextColor(androidx.core.content.b.c(this.f24407e, R.color.color_33b5e5));
            final ListView listView = new ListView(this.f24407e);
            listView.setChoiceMode(1);
            listView.setAdapter(new com.travel.flight.flightorder.a.b(this.f24407e, this.f24410h));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    if (b.this.f24403a.isShowing()) {
                        b.this.f24405c = i2;
                    }
                }
            });
            builder.setCustomTitle(textView);
            builder.setInverseBackgroundForced(true);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    int i3;
                    Resources resources = b.this.f24407e.getResources();
                    ListView listView = listView;
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(b.this.f24407e);
                        TextView textView = new TextView(b.this.f24407e);
                        textView.setText(b.this.f24407e.getResources().getString(R.string.error));
                        textView.setPadding(10, 10, 10, 10);
                        textView.setGravity(17);
                        textView.setTextSize(20.0f);
                        textView.setTextColor(androidx.core.content.b.c(b.this.f24407e, R.color.color_33b5e5));
                        builder.setCustomTitle(textView);
                        builder.setMessage(b.this.f24407e.getResources().getString(R.string.contact_us_select_item_message));
                        builder.setPositiveButton(resources.getString(R.string.ok), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                b.this.f24404b.dismiss();
                                b.this.f24403a.show();
                            }
                        });
                        b.this.f24404b = builder.create();
                        b.this.f24404b.show();
                        return;
                    }
                    b.this.f24403a.dismiss();
                    if (b.this.f24405c == 0) {
                        b bVar = b.this;
                        bVar.f24405c = bVar.b();
                        z = true;
                    } else {
                        b.this.f24405c--;
                    }
                    CJROrderSummaryItems cJROrderSummaryItems = b.this.f24406d.getBody().getItems().get(b.this.f24405c);
                    cJROrderSummaryItems.setOrderId(b.this.f24406d.getBody().getOrder_id());
                    cJROrderSummaryItems.setAllItemsSelected(z);
                    Bundle bundle = new Bundle();
                    bundle.putString(UpiConstants.FROM, b.this.a(cJROrderSummaryItems));
                    bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderSummaryItems);
                    bundle.putInt("ordinal", b.this.f24408f.ordinal());
                    bundle.putString("cst-order-id", b.this.f24406d.getBody().getOrder_id());
                    bundle.putString("downLoadFileName", b.a((List<CJROrderSummaryItems>) b.this.f24406d.getBody().getItems()));
                    b.this.f24409g.show();
                    com.travel.flight.b.a();
                    com.travel.flight.b.b().a(b.this.f24407e, bundle, b.this.f24409g);
                }
            });
            builder.setView(listView);
            this.f24403a = builder.create();
            this.f24405c = 0;
            this.f24403a.show();
            return;
        }
        CJROrderSummaryItems cJROrderSummaryItems = this.f24406d.getBody().getItems().get(0);
        cJROrderSummaryItems.setOrderId(this.f24406d.getBody().getOrder_id());
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.FROM, a(cJROrderSummaryItems));
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderSummaryItems);
        bundle.putInt("ordinal", this.f24408f.ordinal());
        bundle.putString("cst-order-id", this.f24406d.getBody().getOrder_id());
        bundle.putString("downLoadFileName", a((List<CJROrderSummaryItems>) this.f24406d.getBody().getItems()));
        this.f24409g.show();
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(this.f24407e, bundle, this.f24409g);
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        for (int i2 = 0; i2 < this.f24406d.getBody().getItems().size(); i2++) {
            CJROrderSummaryItems cJROrderSummaryItems = this.f24406d.getBody().getItems().get(i2);
            if (cJROrderSummaryItems.getProduct().getVerticalId() == 64 || cJROrderSummaryItems.getProduct().getVerticalId() == 26 || cJROrderSummaryItems.getProduct().getVerticalId() == 72) {
                return i2;
            }
        }
        return 0;
    }

    public final String a(CJROrderSummaryItems cJROrderSummaryItems) {
        CJROrderSummaryProductDetail product;
        if (!(cJROrderSummaryItems == null || (product = cJROrderSummaryItems.getProduct()) == null || product.getVertical() == null)) {
            if (!product.getVertical().equalsIgnoreCase("Insurance")) {
                return product.getVertical();
            }
            Iterator<CJROrderSummaryItems> it2 = this.f24406d.getBody().getItems().iterator();
            while (it2.hasNext()) {
                CJROrderSummaryItems next = it2.next();
                if (!next.getProduct().getVertical().equalsIgnoreCase("Insurance")) {
                    if (!next.getProduct().getVertical().equalsIgnoreCase("Flights")) {
                        return next.getProduct().getVertical();
                    }
                    return next.getProduct().getVertical() + "_Insurance";
                }
            }
        }
        return "";
    }

    public static String a(List<CJROrderSummaryItems> list) {
        String str = "";
        for (CJROrderSummaryItems next : list) {
            String source = next.getSource();
            String destination = next.getDestination();
            String g2 = com.paytm.utility.b.g(next.getTravel_date(), "yyyy-MM-dd", "dd MMM");
            String travel_date = next.getTravel_date();
            if ("R".equalsIgnoreCase(next.getF_Dir())) {
                str = source + "-" + destination + "-" + source + "_" + g2 + "_" + com.paytm.utility.b.g(travel_date, "yyyy-MM-dd", "dd MMM");
            } else {
                str = source + "-" + destination + "_" + g2;
            }
        }
        return str;
    }
}
