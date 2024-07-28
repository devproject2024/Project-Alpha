package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoViewHolderMaker;
import net.one97.paytm.nativesdk.orflow.promo.model.Offer;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;
import net.one97.paytm.nativesdk.orflow.promo.view.OfferDetailBottomSheet;

public abstract class BasePromoViewHolder extends RecyclerView.v {
    private View bottomLine;
    private ImageView imgPromoImage;
    private TextView promoCount;
    private TextView promoError;
    IPromoViewHolderMaker promoViewHolderMaker;
    private RadioButton rbSelectOffer;
    /* access modifiers changed from: private */
    public View rootLayout;
    private TextView txvPromoCode;
    TextView txvPromoDescription;
    private TextView txvPromoHeading;
    /* access modifiers changed from: private */
    public TextView txvTnc;

    /* access modifiers changed from: package-private */
    public abstract void bindView(PromoListItem promoListItem);

    private BasePromoViewHolder(View view) {
        super(view);
    }

    BasePromoViewHolder(View view, IPromoViewHolderMaker iPromoViewHolderMaker) {
        this(view);
        this.promoViewHolderMaker = iPromoViewHolderMaker;
        initViews(view);
    }

    private void initViews(View view) {
        this.rbSelectOffer = (RadioButton) view.findViewById(R.id.rb_offer);
        this.imgPromoImage = (ImageView) view.findViewById(R.id.img_offer);
        this.txvPromoCode = (TextView) view.findViewById(R.id.txv_promo);
        this.txvPromoHeading = (TextView) view.findViewById(R.id.txv_promo_heading);
        this.txvPromoDescription = (TextView) view.findViewById(R.id.txv_comment);
        this.txvTnc = (TextView) view.findViewById(R.id.txv_tnc);
        this.bottomLine = view.findViewById(R.id.bottom_view);
        this.rootLayout = view.findViewById(R.id.ll_promo_root);
        this.promoError = (TextView) view.findViewById(R.id.promo_error);
        this.promoCount = (TextView) view.findViewById(R.id.txv_promo_count);
    }

    public final void bindView(int i2) {
        PromoListItem listItem = getListItem(this.promoViewHolderMaker, i2);
        if (listItem != null) {
            handleBaseLayout(listItem);
            bindView(listItem);
            hideLastView(i2);
            PromoUtils.log("PromoList refresh/create pos -> errorIndex" + i2 + "\t" + this.promoViewHolderMaker.getCurrentErrorIndex());
            handleError(i2 == this.promoViewHolderMaker.getCurrentErrorIndex());
            handlePromoCount(this.rbSelectOffer);
        }
    }

    private void handlePromoCount(RadioButton radioButton) {
        if (!radioButton.isChecked() || this.promoViewHolderMaker.getPromoCount() <= 1) {
            this.promoCount.setVisibility(8);
            return;
        }
        this.promoCount.setVisibility(0);
        this.promoCount.setText(this.promoViewHolderMaker.getContext().getString(R.string.offer_applied_on, new Object[]{String.valueOf(this.promoViewHolderMaker.getPromoCount())}));
    }

    private void handleError(boolean z) {
        String currentError = this.promoViewHolderMaker.getCurrentError();
        if (!z || TextUtils.isEmpty(currentError)) {
            this.promoError.setVisibility(8);
            return;
        }
        this.promoError.setVisibility(0);
        this.promoError.setText(currentError);
    }

    private void hideLastView(int i2) {
        if (isLastItem(this.promoViewHolderMaker, i2)) {
            this.bottomLine.setVisibility(4);
        } else {
            this.bottomLine.setVisibility(0);
        }
    }

    private void handleBaseLayout(PromoListItem promoListItem) {
        setOfferData(promoListItem);
        setPromoData(promoListItem);
        this.rbSelectOffer.setChecked(isRadioSelected(this.promoViewHolderMaker, promoListItem.getCode()));
        this.rootLayout.setTag(promoListItem);
        this.rootLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BasePromoViewHolder.this.promoViewHolderMaker.getClickListener().onClick(BasePromoViewHolder.this.rootLayout);
            }
        });
        this.rbSelectOffer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BasePromoViewHolder.this.promoViewHolderMaker.getClickListener().onClick(BasePromoViewHolder.this.rootLayout);
            }
        });
    }

    private void setPromoData(PromoListItem promoListItem) {
        if (TextUtils.isEmpty(promoListItem.getOfferText())) {
            this.txvPromoDescription.setVisibility(8);
        } else {
            this.txvPromoDescription.setText(promoListItem.getOfferText());
            this.txvPromoDescription.setVisibility(0);
        }
        setTncData(promoListItem);
    }

    private void setTncData(final PromoListItem promoListItem) {
        final String terms = promoListItem.getTerms();
        if (TextUtils.isEmpty(terms)) {
            this.txvTnc.setVisibility(4);
            return;
        }
        this.txvTnc.setVisibility(0);
        this.txvTnc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BasePromoViewHolder basePromoViewHolder = BasePromoViewHolder.this;
                basePromoViewHolder.openTnc(basePromoViewHolder.txvTnc.getContext(), terms, promoListItem.getCode());
            }
        });
        SpannableString spannableString = new SpannableString(this.txvTnc.getText().toString());
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        this.txvTnc.setText(spannableString);
    }

    /* access modifiers changed from: private */
    public void openTnc(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("promoCode", str2);
        bundle.putString("offerText", str);
        OfferDetailBottomSheet offerDetailBottomSheet = new OfferDetailBottomSheet();
        offerDetailBottomSheet.setArguments(bundle);
        offerDetailBottomSheet.show(((FragmentActivity) context).getSupportFragmentManager(), offerDetailBottomSheet.getClass().getName());
    }

    private void setOfferData(PromoListItem promoListItem) {
        Offer offer = promoListItem.getOffer();
        if (offer != null) {
            showImage(this.imgPromoImage, offer.getIcon());
            String title = offer.getTitle();
            if (!TextUtils.isEmpty(title)) {
                this.txvPromoHeading.setText(title);
                this.txvPromoCode.setText(Html.fromHtml(getPromoText(promoListItem.getCode())));
                this.txvPromoCode.setVisibility(0);
                return;
            }
        }
        this.txvPromoHeading.setText(promoListItem.getCode());
        this.txvPromoCode.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void showImage(ImageView imageView, String str) {
        b.b(imageView.getContext()).a(str).a(imageView);
    }

    private String getPromoText(String str) {
        return "Promocode : <b>" + str + "</b>";
    }

    private boolean isLastItem(IPromoViewHolderMaker iPromoViewHolderMaker, int i2) {
        return (iPromoViewHolderMaker == null || iPromoViewHolderMaker.getPromoList() == null || iPromoViewHolderMaker.getPromoList().size() - 1 != i2) ? false : true;
    }

    private boolean isRadioSelected(IPromoViewHolderMaker iPromoViewHolderMaker, String str) {
        return (iPromoViewHolderMaker == null || str == null || !str.equalsIgnoreCase(iPromoViewHolderMaker.getAppliedPromo())) ? false : true;
    }

    private PromoListItem getListItem(IPromoViewHolderMaker iPromoViewHolderMaker, int i2) {
        List<PromoListItem> promoList;
        if (iPromoViewHolderMaker == null || (promoList = iPromoViewHolderMaker.getPromoList()) == null || promoList.size() <= i2) {
            return null;
        }
        return promoList.get(i2);
    }
}
