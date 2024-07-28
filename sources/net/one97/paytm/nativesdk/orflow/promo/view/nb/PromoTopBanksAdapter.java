package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoTopBanksAdapter extends RecyclerView.a<RecyclerView.v> {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final ArrayList<PromoPayOptionAdapterParam> mPayOptionItemList;
    /* access modifiers changed from: private */
    public final View.OnClickListener onClickListener;

    public PromoTopBanksAdapter(Context context, ArrayList<PromoPayOptionAdapterParam> arrayList, View.OnClickListener onClickListener2) {
        k.c(context, "mContext");
        k.c(arrayList, "mPayOptionItemList");
        k.c(onClickListener2, "onClickListener");
        this.mContext = context;
        this.mPayOptionItemList = arrayList;
        this.onClickListener = onClickListener2;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.vh_nb_top_bank, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…_top_bank, parent, false)");
        return new TopBankItemViewHolder(this, inflate);
    }

    public final int getItemCount() {
        return this.mPayOptionItemList.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        ((TopBankItemViewHolder) vVar).bindView();
    }

    public final class TopBankItemViewHolder extends RecyclerView.v {
        private final View mView;
        final /* synthetic */ PromoTopBanksAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TopBankItemViewHolder(PromoTopBanksAdapter promoTopBanksAdapter, View view) {
            super(view);
            k.c(view, "mView");
            this.this$0 = promoTopBanksAdapter;
            this.mView = view;
        }

        public final void bindView() {
            Object obj = this.this$0.mPayOptionItemList.get(getAdapterPosition());
            k.a(obj, "mPayOptionItemList.get(adapterPosition)");
            PromoPayOptionAdapterParam promoPayOptionAdapterParam = (PromoPayOptionAdapterParam) obj;
            if (promoPayOptionAdapterParam.getData() == null || !(promoPayOptionAdapterParam.getData() instanceof PayChannelOptions)) {
                ((FrameLayout) this.mView.findViewById(R.id.fl_bgView)).setBackgroundResource(R.drawable.circle_grey);
                View findViewById = this.mView.findViewById(R.id.emptyName);
                k.a((Object) findViewById, "mView.emptyName");
                findViewById.setVisibility(0);
                ImageView imageView = (ImageView) this.mView.findViewById(R.id.iv_selected);
                k.a((Object) imageView, "mView.iv_selected");
                imageView.setVisibility(8);
                TextView textView = (TextView) this.mView.findViewById(R.id.tv_appName);
                k.a((Object) textView, "mView.tv_appName");
                textView.setVisibility(8);
                ImageView imageView2 = (ImageView) this.mView.findViewById(R.id.iv_appIcon);
                k.a((Object) imageView2, "mView.iv_appIcon");
                imageView2.setVisibility(8);
            } else {
                BaseDataModel data = promoPayOptionAdapterParam.getData();
                if (data != null) {
                    PayChannelOptions payChannelOptions = (PayChannelOptions) data;
                    TextView textView2 = (TextView) this.mView.findViewById(R.id.tv_appName);
                    k.a((Object) textView2, "mView.tv_appName");
                    textView2.setText(payChannelOptions.getChannelCode());
                    String iconUrl = payChannelOptions.getIconUrl();
                    if (iconUrl != null) {
                        i b2 = b.b(this.this$0.mContext);
                        StringBuilder sb = new StringBuilder();
                        DirectPaymentBL instance = DirectPaymentBL.getInstance();
                        k.a((Object) instance, "DirectPaymentBL.getInstance()");
                        CJPayMethodResponse cjPayMethodResponse = instance.getCjPayMethodResponse();
                        k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                        Body body = cjPayMethodResponse.getBody();
                        k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                        sb.append(body.getIconBaseUrl());
                        sb.append(iconUrl);
                        b2.a(sb.toString()).a((ImageView) this.mView.findViewById(R.id.iv_appIcon));
                    }
                    View findViewById2 = this.mView.findViewById(R.id.emptyName);
                    k.a((Object) findViewById2, "mView.emptyName");
                    findViewById2.setVisibility(8);
                    ImageView imageView3 = (ImageView) this.mView.findViewById(R.id.iv_appIcon);
                    k.a((Object) imageView3, "mView.iv_appIcon");
                    imageView3.setVisibility(0);
                    TextView textView3 = (TextView) this.mView.findViewById(R.id.tv_appName);
                    k.a((Object) textView3, "mView.tv_appName");
                    textView3.setVisibility(0);
                    if (promoPayOptionAdapterParam.isSelected()) {
                        ImageView imageView4 = (ImageView) this.mView.findViewById(R.id.iv_selected);
                        k.a((Object) imageView4, "mView.iv_selected");
                        imageView4.setVisibility(0);
                        ((FrameLayout) this.mView.findViewById(R.id.fl_bgView)).setBackgroundResource(R.drawable.native_circle_shadow);
                        ((TextView) this.mView.findViewById(R.id.tv_appName)).setTypeface((Typeface) null, 1);
                    } else {
                        ImageView imageView5 = (ImageView) this.mView.findViewById(R.id.iv_selected);
                        k.a((Object) imageView5, "mView.iv_selected");
                        imageView5.setVisibility(8);
                        ((FrameLayout) this.mView.findViewById(R.id.fl_bgView)).setBackgroundResource(R.drawable.native_circle_bg);
                        ((TextView) this.mView.findViewById(R.id.tv_appName)).setTypeface((Typeface) null, 0);
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) this.mView.findViewById(R.id.topBanksContainer);
                    k.a((Object) relativeLayout, "mView.topBanksContainer");
                    relativeLayout.setTag(Integer.valueOf(getAdapterPosition()));
                    ((RelativeLayout) this.mView.findViewById(R.id.topBanksContainer)).setOnClickListener(this.this$0.onClickListener);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PayChannelOptions");
                }
            }
            Context access$getMContext$p = this.this$0.mContext;
            if (access$getMContext$p != null) {
                int screenWidth = (SDKUtility.getScreenWidth((Activity) access$getMContext$p) - ((int) (SDKUtility.getDensity((Activity) this.this$0.mContext) * 120.0f))) / 5;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenWidth, screenWidth);
                layoutParams.bottomMargin = (int) (SDKUtility.getDensity((Activity) this.this$0.mContext) * 8.0f);
                layoutParams.topMargin = (int) (SDKUtility.getDensity((Activity) this.this$0.mContext) * 10.0f);
                FrameLayout frameLayout = (FrameLayout) this.mView.findViewById(R.id.fl_bgView);
                k.a((Object) frameLayout, "mView.fl_bgView");
                frameLayout.setLayoutParams(layoutParams);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }
}
