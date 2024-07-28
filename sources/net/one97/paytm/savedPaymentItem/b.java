package net.one97.paytm.savedPaymentItem;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import easypay.manager.Constants;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.shopping.CJRSavedCard;
import net.one97.paytm.common.entity.shopping.CJRSavedCards;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.visascp.VisaSCP;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.savedPaymentItem.b;
import net.one97.paytm.u;
import net.one97.paytm.upi.registration.view.y;
import net.one97.paytm.upi.util.SwipeRevealLayout;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f64999a;

    /* renamed from: b  reason: collision with root package name */
    CJRSavedCards f65000b;

    /* renamed from: c  reason: collision with root package name */
    u f65001c;

    /* renamed from: d  reason: collision with root package name */
    final y f65002d = new y();

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f65003e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        y yVar = this.f65002d;
        SwipeRevealLayout swipeRevealLayout = aVar.f65008a;
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.getAdapterPosition());
        yVar.a(swipeRevealLayout, sb.toString());
        CJRSavedCard cJRSavedCard = this.f65000b.getSavedCardList().get(aVar.getAdapterPosition());
        String string = b.this.f64999a.getString(R.string.saved_payment_card_type_dc);
        if (Constants.EASYPAY_PAYTYPE_CREDIT_CARD.equalsIgnoreCase(cJRSavedCard.getPaymentmode())) {
            string = b.this.f64999a.getString(R.string.saved_payment_card_type_cc);
        }
        if (cJRSavedCard.getBankname() != null) {
            TextView textView = aVar.f65009b;
            textView.setText(cJRSavedCard.getBankname() + " " + string);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cJRSavedCard.getBankname());
            sb2.append(" ");
            sb2.append(string);
        } else {
            aVar.f65009b.setText(string);
        }
        if (TextUtils.isEmpty(cJRSavedCard.getCardBIN()) || cJRSavedCard.getCardBIN().length() < 4) {
            aVar.f65010c.setText("");
        } else {
            aVar.f65010c.setText(cJRSavedCard.getCardBIN().substring(0, 4));
        }
        if (!TextUtils.isEmpty(cJRSavedCard.getCardLastDigit())) {
            aVar.f65011d.setText(cJRSavedCard.getCardLastDigit());
        } else {
            aVar.f65011d.setText("");
        }
        TextView textView2 = aVar.f65014g;
        c.a();
        textView2.setText(c.a("disable_oc", b.this.f64999a.getString(R.string.disable_oc)));
        TextView textView3 = aVar.f65015h;
        c.a();
        textView3.setText(c.a("visa_oc_enabled", b.this.f64999a.getString(R.string.visa_oc_enabled)));
        if (!TextUtils.isEmpty(cJRSavedCard.getCardType())) {
            String trim = cJRSavedCard.getCardType().trim();
            if (trim.equalsIgnoreCase(SDKConstants.VISA)) {
                aVar.f65012e.setImageResource(R.drawable.saved_cards_visa);
            } else if (trim.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                aVar.f65012e.setImageResource(R.drawable.saved_cards_maestro);
            } else if (trim.equalsIgnoreCase("MASTERCARD") || trim.equalsIgnoreCase("MASTER")) {
                aVar.f65012e.setImageResource(R.drawable.saved_cards_master_card);
            } else if (trim.equalsIgnoreCase("AMEX")) {
                aVar.f65012e.setImageResource(R.drawable.saved_cards_ae);
            } else if (trim.equalsIgnoreCase("RUPAY")) {
                aVar.f65012e.setImageResource(R.drawable.saved_cards_rupay);
            } else {
                aVar.f65012e.setImageResource(R.drawable.ic_saved_card);
            }
            if (Build.VERSION.SDK_INT < 19) {
                aVar.f65014g.setVisibility(8);
                aVar.f65015h.setVisibility(8);
                return;
            }
            VisaSCP a2 = CJRJarvisApplication.a(b.this.f64999a);
            if (!trim.equalsIgnoreCase(SDKConstants.VISA) || a2 == null || !a2.isEnrollmentSuccess(cJRSavedCard.getCardBIN(), cJRSavedCard.getCardLastDigit(), "", com.paytm.utility.a.a(b.this.f64999a))) {
                aVar.f65015h.setVisibility(8);
                aVar.f65014g.setVisibility(8);
                return;
            }
            aVar.f65014g.setVisibility(0);
            aVar.f65015h.setVisibility(0);
            return;
        }
        aVar.f65012e.setImageResource(R.drawable.ic_saved_card);
    }

    b(Context context, CJRSavedCards cJRSavedCards, u uVar) {
        this.f64999a = context;
        this.f65001c = uVar;
        this.f65000b = cJRSavedCards;
        this.f65003e = LayoutInflater.from(this.f64999a);
        this.f65002d.f69090b = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, View view) {
        CJRSavedCard cJRSavedCard;
        if (aVar.getAdapterPosition() != -1) {
            int adapterPosition = aVar.getAdapterPosition();
            CJRSavedCards cJRSavedCards = this.f65000b;
            if (cJRSavedCards != null && (cJRSavedCard = cJRSavedCards.getSavedCardList().get(adapterPosition)) != null) {
                this.f65002d.b(String.valueOf(adapterPosition));
                this.f65001c.a(adapterPosition, cJRSavedCard.getCardBIN(), cJRSavedCard.getCardLastDigit(), "", com.paytm.utility.a.a(this.f64999a), cJRSavedCard.getCardType());
            }
        }
    }

    public final int getItemCount() {
        return this.f65000b.getSavedCardList().size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        SwipeRevealLayout f65008a;

        /* renamed from: b  reason: collision with root package name */
        TextView f65009b;

        /* renamed from: c  reason: collision with root package name */
        TextView f65010c;

        /* renamed from: d  reason: collision with root package name */
        TextView f65011d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f65012e;

        /* renamed from: f  reason: collision with root package name */
        TextView f65013f;

        /* renamed from: g  reason: collision with root package name */
        TextView f65014g;

        /* renamed from: h  reason: collision with root package name */
        TextView f65015h;
        private ImageView j;

        public a(View view) {
            super(view);
            this.f65008a = (SwipeRevealLayout) view.findViewById(R.id.saved_cards_swipe_reveal);
            this.f65010c = (TextView) view.findViewById(R.id.txt_card_first_4_num);
            this.f65009b = (TextView) view.findViewById(R.id.txt_card_name);
            this.f65011d = (TextView) view.findViewById(R.id.txt_card_last_4_num);
            this.f65012e = (ImageView) view.findViewById(R.id.iv_bank_icon);
            this.j = (ImageView) view.findViewById(R.id.saved_card_remove_menu);
            this.f65013f = (TextView) view.findViewById(R.id.deleteCard);
            this.f65014g = (TextView) view.findViewById(R.id.disableOneClick);
            this.f65015h = (TextView) view.findViewById(R.id.visa_enabled_msg);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        final a aVar = new a(this.f65003e.inflate(R.layout.layout_rv_saved_card, viewGroup, false));
        aVar.f65013f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRSavedCard cJRSavedCard;
                if (aVar.getAdapterPosition() != -1) {
                    int adapterPosition = aVar.getAdapterPosition();
                    if (b.this.f65000b != null && (cJRSavedCard = b.this.f65000b.getSavedCardList().get(adapterPosition)) != null) {
                        b.this.f65002d.b(String.valueOf(adapterPosition));
                        b.this.f65001c.a(cJRSavedCard.getCardID());
                        b.this.f65001c.a(cJRSavedCard.getCardBIN(), cJRSavedCard.getCardLastDigit(), "");
                    }
                }
            }
        });
        aVar.f65014g.setOnClickListener(new View.OnClickListener(aVar) {
            private final /* synthetic */ b.a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                b.this.a(this.f$1, view);
            }
        });
        return aVar;
    }
}
