package net.one97.paytm.passbook.other;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.MerchantWiseDetail;
import net.one97.paytm.passbook.beans.TxnLevelDetail;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.toll_kotlin.model.TollTagListModel;

public final class a extends RecyclerView.a<C1114a> {

    /* renamed from: a  reason: collision with root package name */
    Context f58134a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<MerchantWiseDetail> f58135b;

    /* renamed from: c  reason: collision with root package name */
    private String f58136c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f58137d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f58138e = "";

    /* renamed from: f  reason: collision with root package name */
    private int f58139f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final String str;
        C1114a aVar = (C1114a) vVar;
        if (i2 >= 0) {
            TxnLevelDetail txnLevelDetail = null;
            Iterator<MerchantWiseDetail> it2 = this.f58135b.iterator();
            int i3 = i2;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                MerchantWiseDetail next = it2.next();
                if (i3 < next.getTxnLevelDetails().size()) {
                    txnLevelDetail = next.getTxnLevelDetails().get(i3);
                    break;
                }
                i3 -= next.getTxnLevelDetails().size();
            }
            aVar.f58142a.setText(this.f58136c);
            Iterator<MerchantWiseDetail> it3 = this.f58135b.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    str = "";
                    break;
                }
                MerchantWiseDetail next2 = it3.next();
                if (i2 < next2.getTxnLevelDetails().size()) {
                    str = next2.getMerchantDisplayName();
                    break;
                }
                i2 -= next2.getTxnLevelDetails().size();
            }
            if (txnLevelDetail != null) {
                aVar.f58143b.setText(String.format(this.f58138e, new Object[]{str, txnLevelDetail.getOrderId()}));
                aVar.f58144c.setText(c.k("yyyy-MM-dd hh:mm:SS", "MMMM dd , hh:mm a", txnLevelDetail.getExpectedReleaseDate()));
                aVar.f58144c.setText(String.format(this.f58134a.getString(R.string.expt_release), new Object[]{c.k("yyyy-MM-dd hh:mm:SS", "MMMM dd , hh:mm a", txnLevelDetail.getExpectedReleaseDate())}));
                String str2 = this.f58137d;
                StringBuilder sb = new StringBuilder();
                sb.append(txnLevelDetail.getBlockedAmount());
                c.a(String.format(str2, new Object[]{sb.toString()}), aVar.f58145d);
            }
            aVar.f58146e.setText(this.f58136c);
            aVar.f58146e.setTextColor(this.f58139f);
            aVar.f58147f.setImageResource(R.drawable.pass_ic_on_hold_txn);
            TextView textView = (TextView) aVar.f58148g.findViewById(R.id.passbook_extrainfo_btn_need_help_tv);
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains("uber")) {
                textView.setVisibility(8);
                textView.setText(this.f58134a.getResources().getString(R.string.passbook_send_receive_need_help));
            } else {
                textView.setVisibility(0);
                textView.setText(this.f58134a.getResources().getString(R.string.passbook_on_hold_txn_text));
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/net/one97/paytm/passbook");
                    hashMap.put("contact_us_current_screen_type", "passbook-On Hold");
                    d.b().a((Map<String, Object>) hashMap);
                    try {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                        hashMap2.put("new_wallet_passbook_tab_name", "On Hold");
                        d.b().a((Map<String, Object>) hashMap2);
                    } catch (Exception unused) {
                    }
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("uber")) {
                        d.b().a(view.getContext(), "https://paytm.com/offer/uber-introduces-a-new-feature-on-paytm/", a.this.f58134a.getString(R.string.passbook_on_hold_txn_text));
                    }
                }
            });
            try {
                Bitmap circularBitmapWithWhiteBorder = TollTagListModel.Companion.getCircularBitmapWithWhiteBorder(((BitmapDrawable) aVar.f58147f.getDrawable()).getBitmap(), 5);
                if (circularBitmapWithWhiteBorder != null) {
                    aVar.f58147f.setImageBitmap(circularBitmapWithWhiteBorder);
                }
            } catch (Exception unused) {
            }
        }
    }

    public a(ArrayList<MerchantWiseDetail> arrayList, Context context) {
        this.f58135b = arrayList;
        this.f58136c = context.getResources().getString(R.string.auth);
        this.f58139f = context.getResources().getColor(R.color.status_pending);
        this.f58137d = context.getResources().getString(R.string.wallet_rs);
        this.f58138e = context.getResources().getString(R.string.preauth_order);
        this.f58134a = context;
    }

    public final int getItemCount() {
        ArrayList<MerchantWiseDetail> arrayList = this.f58135b;
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<MerchantWiseDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 += it2.next().getTxnLevelDetails().size();
        }
        return i2;
    }

    /* renamed from: net.one97.paytm.passbook.other.a$a  reason: collision with other inner class name */
    public class C1114a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f58142a;

        /* renamed from: b  reason: collision with root package name */
        TextView f58143b;

        /* renamed from: c  reason: collision with root package name */
        TextView f58144c;

        /* renamed from: d  reason: collision with root package name */
        TextView f58145d;

        /* renamed from: e  reason: collision with root package name */
        TextView f58146e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f58147f;

        /* renamed from: g  reason: collision with root package name */
        RelativeLayout f58148g;

        public C1114a(View view) {
            super(view);
            this.f58142a = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
            this.f58143b = (TextView) view.findViewById(R.id.passbook_send_receive_name);
            this.f58144c = (TextView) view.findViewById(R.id.passbook_send_receive_time);
            this.f58145d = (TextView) view.findViewById(R.id.passbook_sender_receiver_amount_tv);
            this.f58147f = (ImageView) view.findViewById(R.id.passbook_payer_or_payee_icons_iv);
            this.f58148g = (RelativeLayout) view.findViewById(R.id.passbook_entry_row_rl);
            this.f58146e = (TextView) view.findViewById(R.id.passbook_sender_receiver_txn_status_tv);
            this.f58146e.setAllCaps(false);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C1114a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_preauth_passbook_entry_row, viewGroup, false));
    }
}
