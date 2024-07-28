package net.one97.paytm.nativesdk.common.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import java.util.ArrayList;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.PaymentOffer;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.view.PostPaidTCBottomSheet;

public class BankOffersBottomSheet extends f {
    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bank_offers, (ViewGroup) null, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_bank_offers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new BankOffersAdapter());
        inflate.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersBottomSheet.this.dismiss();
            }
        });
        dialog.setContentView(inflate);
        ((View) inflate.getParent()).setBackgroundResource(R.drawable.native_top_round_corner);
    }

    public static class BankOffersAdapter extends RecyclerView.a<BankOffersViewHolder> {
        private Context context;
        private boolean eventSentOnce = false;
        /* access modifiers changed from: private */
        public ArrayList<PaymentOffer> paymentOffers = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getPaymentOffers();

        public BankOffersViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            this.context = viewGroup.getContext();
            return new BankOffersViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bank_offer, viewGroup, false));
        }

        public void onBindViewHolder(BankOffersViewHolder bankOffersViewHolder, final int i2) {
            bankOffersViewHolder.tvOfferTitle.setText(this.paymentOffers.get(i2).getOffer().getTitle());
            bankOffersViewHolder.tvOfferInfo.setText(this.paymentOffers.get(i2).getOffer().getText());
            if (!TextUtils.isEmpty(this.paymentOffers.get(i2).getTermTitle())) {
                bankOffersViewHolder.tvOfferTerms.setText(this.paymentOffers.get(i2).getTermTitle());
            }
            if (SDKUtility.isAppInvokeFlow() && !this.eventSentOnce) {
                this.eventSentOnce = true;
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_ALL_OFFER_DISPLAY, ""));
            }
            if (!TextUtils.isEmpty(this.paymentOffers.get(i2).getTermsUrl())) {
                bankOffersViewHolder.tvOfferTerms.setVisibility(0);
            }
            bankOffersViewHolder.tvOfferTerms.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BankOffersAdapter bankOffersAdapter = BankOffersAdapter.this;
                    bankOffersAdapter.openTermsAndConditionBottomSheet(((PaymentOffer) bankOffersAdapter.paymentOffers.get(i2)).getTermsUrl());
                }
            });
            b.b(bankOffersViewHolder.ivBankLogo.getContext()).a(this.paymentOffers.get(i2).getOffer().getIcon()).a(bankOffersViewHolder.ivBankLogo);
        }

        public int getItemCount() {
            ArrayList<PaymentOffer> arrayList = this.paymentOffers;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        /* access modifiers changed from: private */
        public void openTermsAndConditionBottomSheet(String str) {
            try {
                PostPaidTCBottomSheet instance = PostPaidTCBottomSheet.getInstance(str, true);
                q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
                a2.a("tAndCSheet");
                instance.show(a2, (String) null);
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_TNC_LOADED, str));
                }
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_T_N_C, "true", ""));
            } catch (NullPointerException unused) {
            }
        }
    }

    public static class BankOffersViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public ImageView ivBankLogo;
        /* access modifiers changed from: private */
        public TextView tvOfferInfo;
        /* access modifiers changed from: private */
        public TextView tvOfferTerms;
        /* access modifiers changed from: private */
        public TextView tvOfferTitle;

        public BankOffersViewHolder(View view) {
            super(view);
            this.tvOfferTitle = (TextView) view.findViewById(R.id.tv_offerTitle);
            this.tvOfferInfo = (TextView) view.findViewById(R.id.tv_offerInfo);
            this.tvOfferTerms = (TextView) view.findViewById(R.id.tv_offerTerms);
            this.ivBankLogo = (ImageView) view.findViewById(R.id.iv_bankLogo);
        }
    }
}
