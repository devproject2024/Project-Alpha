package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.adapter.FreebieCarousalAdapter;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoViewHolderMaker;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;

public class FreebieGratViewHolder extends CashbackViewHolder {
    private FreebieCarousalAdapter carousalAdapter;
    private ViewGroup freebieMainLayout;
    private ViewGroup freebieSingleLayout;
    private ImageView imgFb;
    private LinearLayout ll_gratifications;
    private RecyclerView rvFreebie;
    private TextView txvFbDescription;
    private TextView txvFreebieViewAll;

    public FreebieGratViewHolder(View view, IPromoViewHolderMaker iPromoViewHolderMaker) {
        super(view, iPromoViewHolderMaker);
        initUI(view);
    }

    private void initUI(View view) {
        this.ll_gratifications = (LinearLayout) view.findViewById(R.id.ll_gratifications);
        this.freebieMainLayout = (ViewGroup) view.findViewById(R.id.lyt_freebie);
        this.freebieSingleLayout = (ViewGroup) view.findViewById(R.id.ll_single_fb);
        this.imgFb = (ImageView) view.findViewById(R.id.img_freebie);
        this.txvFbDescription = (TextView) view.findViewById(R.id.txv_freebie_name);
        this.txvFreebieViewAll = (TextView) view.findViewById(R.id.txv_view_freebie);
        this.rvFreebie = (RecyclerView) view.findViewById(R.id.rv_fb_carousal);
    }

    /* access modifiers changed from: package-private */
    public void bindView(PromoListItem promoListItem) {
        super.bindView(promoListItem);
        handleGratification(promoListItem);
        handleFreebie(promoListItem);
    }

    private void handleGratification(PromoListItem promoListItem) {
        List<Gratification> gratifications = promoListItem.getGratifications();
        if (PromoUtils.isGratification(gratifications)) {
            this.ll_gratifications.setVisibility(0);
            this.ll_gratifications.removeAllViews();
            this.txvPromoDescription.setVisibility(8);
            addGratifications(gratifications, this.ll_gratifications, promoListItem);
            return;
        }
        this.ll_gratifications.removeAllViews();
        this.ll_gratifications.setVisibility(8);
        this.txvPromoDescription.setVisibility(0);
    }

    private void addGratifications(List<Gratification> list, LinearLayout linearLayout, PromoListItem promoListItem) {
        for (Gratification inflateGratification : list) {
            linearLayout.addView(inflateGratification(linearLayout, inflateGratification, promoListItem));
        }
    }

    private View inflateGratification(LinearLayout linearLayout, Gratification gratification, PromoListItem promoListItem) {
        View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(getGratificationLayout(gratification), linearLayout, false);
        setGratificationData(inflate, gratification, promoListItem);
        return inflate;
    }

    private int getGratificationLayout(Gratification gratification) {
        return isGratFreebieActive(gratification) ? R.layout.lyt_promo_grat_fb : R.layout.lyt_promo_gratification;
    }

    private boolean isGratFreebieActive(Gratification gratification) {
        return !TextUtils.isEmpty(gratification.getListUrl());
    }

    private void setGratificationData(View view, Gratification gratification, PromoListItem promoListItem) {
        ((TextView) view.findViewById(R.id.txv_grat_header)).setText(gratification.getTitle());
        ((TextView) view.findViewById(R.id.txv_grat_desc)).setText(gratification.getText());
        showImage((ImageView) view.findViewById(R.id.img_grat), gratification.getIcon());
        if (!isGratFreebieActive(gratification)) {
            return;
        }
        if (isGratFreebieDataAvailable(gratification)) {
            handleGratFreebie(view, gratification.getFreebieList());
        } else if (this.promoViewHolderMaker != null) {
            this.promoViewHolderMaker.getFreebieList(gratification, promoListItem);
        }
    }

    private void handleGratFreebie(View view, ArrayList<Freebie> arrayList) {
        View findViewById = view.findViewById(R.id.ll_grat_fb);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_grat_fb);
        TextView textView = (TextView) view.findViewById(R.id.txv_grat_fb);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_grat_fb);
        if (arrayList.size() == 1) {
            findViewById.setVisibility(0);
            handleSingleFreebie(arrayList.get(0), imageView, textView);
            return;
        }
        findViewById.setVisibility(8);
        recyclerView.setVisibility(0);
        FreebieCarousalAdapter freebieCarousalAdapter = new FreebieCarousalAdapter(view.getContext(), arrayList, true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        recyclerView.setAdapter(freebieCarousalAdapter);
    }

    private void handleSingleFreebie(Freebie freebie, ImageView imageView, TextView textView) {
        if (freebie != null) {
            if (!TextUtils.isEmpty(freebie.getImageUrl())) {
                showImage(imageView, freebie.getImageUrl());
            }
            if (!TextUtils.isEmpty(freebie.getName())) {
                textView.setText(freebie.getName());
            }
        }
    }

    private boolean isGratFreebieDataAvailable(Gratification gratification) {
        return gratification.getFreebieList() != null;
    }

    private void handleFreebie(PromoListItem promoListItem) {
        if (!PromoUtils.isFreebie(promoListItem)) {
            return;
        }
        if (isFreebieDataAvailable(promoListItem)) {
            handleFreebie(promoListItem.getFreebies());
        } else {
            getFreebieList(promoListItem);
        }
    }

    private void getFreebieList(PromoListItem promoListItem) {
        this.freebieMainLayout.setVisibility(8);
        if (this.promoViewHolderMaker != null) {
            this.promoViewHolderMaker.getFreebieList(promoListItem);
        }
    }

    private void handleFreebie(final List<Freebie> list) {
        this.freebieMainLayout.setVisibility(0);
        if (list.size() >= FreebieCarousalAdapter.MAX_SIZE) {
            this.txvFreebieViewAll.setVisibility(8);
        }
        this.txvFreebieViewAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FreebieGratViewHolder.this.openFreebieList(list, true);
            }
        });
        if (list.size() == 1) {
            freebieSingleItem(list.get(0));
        } else {
            freebieCarousal(list);
        }
    }

    /* access modifiers changed from: private */
    public void openFreebieList(List<Freebie> list, boolean z) {
        if (this.promoViewHolderMaker != null && this.promoViewHolderMaker.getContext() != null) {
            PromoUtils.startFreebieListActivity(this.promoViewHolderMaker.getContext(), list, z);
        }
    }

    private void freebieCarousal(List<Freebie> list) {
        this.rvFreebie.setVisibility(0);
        this.freebieSingleLayout.setVisibility(8);
        this.txvPromoDescription.setVisibility(8);
        FreebieCarousalAdapter freebieCarousalAdapter = this.carousalAdapter;
        if (freebieCarousalAdapter == null) {
            this.carousalAdapter = new FreebieCarousalAdapter(this.promoViewHolderMaker.getContext(), list);
            this.rvFreebie.setLayoutManager(new LinearLayoutManager(this.promoViewHolderMaker.getContext(), 0, false));
            this.rvFreebie.setAdapter(this.carousalAdapter);
            return;
        }
        freebieCarousalAdapter.updateList(list);
    }

    private void freebieSingleItem(Freebie freebie) {
        this.rvFreebie.setVisibility(8);
        this.freebieSingleLayout.setVisibility(0);
        this.txvPromoDescription.setVisibility(0);
        showImage(this.imgFb, freebie.getImageUrl());
        this.txvFbDescription.setText(freebie.getName());
    }

    private boolean isFreebieDataAvailable(PromoListItem promoListItem) {
        return promoListItem.getFreebies() != null;
    }
}
