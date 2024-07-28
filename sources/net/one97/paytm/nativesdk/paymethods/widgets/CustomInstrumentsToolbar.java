package net.one97.paytm.nativesdk.paymethods.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.c;
import com.bumptech.glide.b;
import com.bumptech.glide.h;
import java.util.HashMap;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.widget.CharacterWrapTextView;

public final class CustomInstrumentsToolbar extends ConstraintLayout {
    private HashMap _$_findViewCache;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomInstrumentsToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(R.layout.native_instruments_toolbar, this, true);
        TextView textView = (TextView) _$_findCachedViewById(R.id.total_amount);
        k.a((Object) textView, "total_amount");
        int i2 = R.string.nativesdk_amount_pay;
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        textView.setText(Html.fromHtml(context.getString(i2, new Object[]{SDKUtility.priceWithoutDecimal(merchantInstance.getWithoutDoubleAmount())})));
        CharacterWrapTextView characterWrapTextView = (CharacterWrapTextView) _$_findCachedViewById(R.id.order_id);
        k.a((Object) characterWrapTextView, "order_id");
        int i3 = R.string.native_order_id;
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        characterWrapTextView.setText(Html.fromHtml(context.getString(i3, new Object[]{merchantInstance2.getOrderId()})));
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_view);
        k.a((Object) shimmerFrameLayout, "shimmer_view");
        ExtensionsKt.startAnimation(shimmerFrameLayout);
        ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_logo_view);
        k.a((Object) shimmerFrameLayout2, "shimmer_logo_view");
        ExtensionsKt.startAnimation(shimmerFrameLayout2);
    }

    public final CharSequence getTotalAmount() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.total_amount);
        k.a((Object) textView, "total_amount");
        CharSequence text = textView.getText();
        k.a((Object) text, "total_amount.text");
        return text;
    }

    public final void setTotalAmount(CharSequence charSequence) {
        k.c(charSequence, "value");
        TextView textView = (TextView) _$_findCachedViewById(R.id.total_amount);
        k.a((Object) textView, "total_amount");
        textView.setText(charSequence);
    }

    public final CharSequence getOrderId() {
        CharacterWrapTextView characterWrapTextView = (CharacterWrapTextView) _$_findCachedViewById(R.id.order_id);
        k.a((Object) characterWrapTextView, "order_id");
        CharSequence text = characterWrapTextView.getText();
        k.a((Object) text, "order_id.text");
        return text;
    }

    public final void setOrderId(CharSequence charSequence) {
        k.c(charSequence, "value");
        CharacterWrapTextView characterWrapTextView = (CharacterWrapTextView) _$_findCachedViewById(R.id.order_id);
        k.a((Object) characterWrapTextView, "order_id");
        characterWrapTextView.setText(charSequence);
    }

    public final CharSequence getMerchantName() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.merchant_name);
        k.a((Object) textView, "merchant_name");
        CharSequence text = textView.getText();
        k.a((Object) text, "merchant_name.text");
        return text;
    }

    public final void setMerchantName(CharSequence charSequence) {
        k.c(charSequence, "value");
        TextView textView = (TextView) _$_findCachedViewById(R.id.merchant_name);
        k.a((Object) textView, "merchant_name");
        textView.setText(charSequence);
    }

    public final void setBackOnClickListener(a<x> aVar) {
        k.c(aVar, "function");
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.back);
        if (imageView != null) {
            imageView.setOnClickListener(new CustomInstrumentsToolbar$setBackOnClickListener$1(aVar));
        }
    }

    public final void setBackButtonVisibility(boolean z) {
        if (z) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.back);
            if (imageView != null) {
                ExtensionsKt.visible(imageView);
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.back);
        if (imageView2 != null) {
            ExtensionsKt.gone(imageView2);
        }
    }

    public final void setToolbarValues() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.merchant_name);
        k.a((Object) textView, "merchant_name");
        ExtensionsKt.visible(textView);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.merchant_name);
        k.a((Object) textView2, "merchant_name");
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        textView2.setText(merchantInstance.getMerchantName());
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String stringIfNotBlank = ExtensionsKt.getStringIfNotBlank(merchantInstance2.getMerchantLogoUrl());
        if (stringIfNotBlank != null) {
            Context context = getContext();
            k.a((Object) context, "context");
            h<Drawable> a2 = b.b(context.getApplicationContext()).a(stringIfNotBlank);
            com.bumptech.glide.e.h hVar = new com.bumptech.glide.e.h();
            hVar.e();
            a2.b((com.bumptech.glide.e.a<?>) hVar).b(new CustomInstrumentsToolbar$setToolbarValues$$inlined$let$lambda$1(this)).a((ImageView) _$_findCachedViewById(R.id.logo));
            Group group = (Group) _$_findCachedViewById(R.id.logo_group);
            k.a((Object) group, "logo_group");
            ExtensionsKt.visible(group);
        } else {
            CustomInstrumentsToolbar customInstrumentsToolbar = this;
            Group group2 = (Group) customInstrumentsToolbar._$_findCachedViewById(R.id.logo_group);
            if (group2 != null) {
                ExtensionsKt.gone(group2);
            }
            c cVar = new c();
            ConstraintLayout constraintLayout = customInstrumentsToolbar;
            cVar.b(constraintLayout);
            c cVar2 = cVar;
            cVar2.a(R.id.merchant_name, 3, R.id.back, 4, 0);
            cVar2.a(R.id.total_amount, 3, R.id.merchant_name, 3, 0);
            cVar2.a(R.id.total_amount, 4, R.id.merchant_name, 4, 0);
            cVar.c(constraintLayout);
            if (Build.VERSION.SDK_INT < 23) {
                TextView textView3 = (TextView) customInstrumentsToolbar._$_findCachedViewById(R.id.merchant_name);
                if (textView3 != null) {
                    textView3.setTextAppearance(customInstrumentsToolbar.getContext(), R.style.TitleTextStyle);
                }
            } else {
                TextView textView4 = (TextView) customInstrumentsToolbar._$_findCachedViewById(R.id.merchant_name);
                if (textView4 != null) {
                    textView4.setTextAppearance(R.style.TitleTextStyle);
                }
            }
        }
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isSubsCriptionFlow()) {
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            if (!TextUtils.isEmpty(merchantInstance3.getMerchantLogoUrl())) {
                CharacterWrapTextView characterWrapTextView = (CharacterWrapTextView) _$_findCachedViewById(R.id.order_id);
                k.a((Object) characterWrapTextView, "order_id");
                characterWrapTextView.setVisibility(8);
            } else {
                CharacterWrapTextView characterWrapTextView2 = (CharacterWrapTextView) _$_findCachedViewById(R.id.order_id);
                k.a((Object) characterWrapTextView2, "order_id");
                characterWrapTextView2.setVisibility(4);
            }
            if (PaytmSDK.isSubsDetailAvailable()) {
                TextView textView5 = (TextView) _$_findCachedViewById(R.id.sub_detail);
                k.a((Object) textView5, "sub_detail");
                textView5.setVisibility(0);
            } else {
                TextView textView6 = (TextView) _$_findCachedViewById(R.id.sub_detail);
                k.a((Object) textView6, "sub_detail");
                textView6.setVisibility(8);
            }
            if (SDKUtility.isSubscriptionAmountZero()) {
                TextView textView7 = (TextView) _$_findCachedViewById(R.id.tv_subs_zero_amount_label);
                k.a((Object) textView7, "tv_subs_zero_amount_label");
                textView7.setVisibility(0);
            }
            if (getContext() != null) {
                TextView textView8 = (TextView) _$_findCachedViewById(R.id.sub_detail);
                k.a((Object) textView8, "sub_detail");
                textView8.setText(getContext().getString(R.string.subscription_details));
            }
        } else {
            CharacterWrapTextView characterWrapTextView3 = (CharacterWrapTextView) _$_findCachedViewById(R.id.order_id);
            k.a((Object) characterWrapTextView3, "order_id");
            characterWrapTextView3.setVisibility(0);
        }
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_view);
        k.a((Object) shimmerFrameLayout, "shimmer_view");
        ExtensionsKt.stopAnimation(shimmerFrameLayout);
        Group group3 = (Group) _$_findCachedViewById(R.id.logo_group);
        k.a((Object) group3, "logo_group");
        if (group3.getVisibility() != 0) {
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_logo_view);
            k.a((Object) shimmerFrameLayout2, "shimmer_logo_view");
            ExtensionsKt.stopAnimation(shimmerFrameLayout2);
        }
    }

    public final void setAppInvokeStatusAmount(String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.total_amount);
        k.a((Object) textView, "total_amount");
        textView.setText(str);
    }
}
