package com.business.merchant_payments.newhome;

import android.content.Context;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.business.merchant_payments.BaseViewHolder;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.databinding.MpSmartGridBinding;
import com.business.merchant_payments.payment.model.GridItem;
import com.business.merchant_payments.payment.model.QRGridModel;
import com.squareup.picasso.w;
import kotlin.g.b.k;

public final class P4BSmartGridViewHolder extends BaseViewHolder {
    public final MpSmartGridBinding binding;
    public final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P4BSmartGridViewHolder(MpSmartGridBinding mpSmartGridBinding) {
        super(mpSmartGridBinding.getRoot());
        k.d(mpSmartGridBinding, "binding");
        this.binding = mpSmartGridBinding;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        this.context = instance.getAppContext();
    }

    public final MpSmartGridBinding getBinding() {
        return this.binding;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void bindData(Object obj, int i2) {
        GridItem gridItem;
        GridItem gridItem2;
        GridItem gridItem3;
        GridItem gridItem4;
        if (obj instanceof QRGridModel) {
            QRGridModel qRGridModel = (QRGridModel) obj;
            if (qRGridModel.getItems().isEmpty()) {
                ConstraintLayout constraintLayout = this.binding.grid;
                k.b(constraintLayout, "binding.grid");
                constraintLayout.setVisibility(8);
                return;
            }
            boolean z = true;
            if (qRGridModel.getItems().size() > 0 && (gridItem4 = qRGridModel.getItems().get(0)) != null) {
                if (this.binding.item0Icon != null && URLUtil.isValidUrl(gridItem4.getIconSrc())) {
                    w.a().a(gridItem4.getIconSrc()).a((ImageView) this.binding.item0Icon);
                    this.binding.item0Icon.setOnClickListener(new P4BSmartGridViewHolder$bindData$1(obj, gridItem4));
                    AppCompatImageView appCompatImageView = this.binding.item0Icon;
                    k.b(appCompatImageView, "binding.item0Icon");
                    appCompatImageView.setVisibility(0);
                }
                if (this.binding.item0Text != null) {
                    String content = gridItem4.getContent();
                    if (!(content == null || content.length() == 0)) {
                        this.binding.item0Text.setText(gridItem4.getContent());
                        this.binding.item0Text.setOnClickListener(new P4BSmartGridViewHolder$bindData$2(obj, gridItem4));
                        AppCompatTextView appCompatTextView = this.binding.item0Text;
                        k.b(appCompatTextView, "binding.item0Text");
                        appCompatTextView.setVisibility(0);
                    }
                }
            }
            if (qRGridModel.getItems().size() > 1 && (gridItem3 = qRGridModel.getItems().get(1)) != null) {
                if (this.binding.item1Icon != null && URLUtil.isValidUrl(gridItem3.getIconSrc())) {
                    w.a().a(gridItem3.getIconSrc()).a((ImageView) this.binding.item1Icon);
                    this.binding.item1Icon.setOnClickListener(new P4BSmartGridViewHolder$bindData$3(obj, gridItem3));
                    AppCompatImageView appCompatImageView2 = this.binding.item1Icon;
                    k.b(appCompatImageView2, "binding.item1Icon");
                    appCompatImageView2.setVisibility(0);
                }
                if (this.binding.item1Text != null) {
                    String content2 = gridItem3.getContent();
                    if (!(content2 == null || content2.length() == 0)) {
                        this.binding.item1Text.setText(gridItem3.getContent());
                        this.binding.item1Text.setOnClickListener(new P4BSmartGridViewHolder$bindData$4(obj, gridItem3));
                        AppCompatTextView appCompatTextView2 = this.binding.item1Text;
                        k.b(appCompatTextView2, "binding.item1Text");
                        appCompatTextView2.setVisibility(0);
                    }
                }
            }
            if (qRGridModel.getItems().size() > 2 && (gridItem2 = qRGridModel.getItems().get(2)) != null) {
                if (this.binding.item2Icon != null && URLUtil.isValidUrl(gridItem2.getIconSrc())) {
                    w.a().a(gridItem2.getIconSrc()).a((ImageView) this.binding.item2Icon);
                    this.binding.item2Icon.setOnClickListener(new P4BSmartGridViewHolder$bindData$5(obj, gridItem2));
                    AppCompatImageView appCompatImageView3 = this.binding.item2Icon;
                    k.b(appCompatImageView3, "binding.item2Icon");
                    appCompatImageView3.setVisibility(0);
                }
                if (this.binding.item2Text != null) {
                    String content3 = gridItem2.getContent();
                    if (!(content3 == null || content3.length() == 0)) {
                        this.binding.item2Text.setText(gridItem2.getContent());
                        this.binding.item2Text.setOnClickListener(new P4BSmartGridViewHolder$bindData$6(obj, gridItem2));
                        AppCompatTextView appCompatTextView3 = this.binding.item2Text;
                        k.b(appCompatTextView3, "binding.item2Text");
                        appCompatTextView3.setVisibility(0);
                    }
                }
            }
            if (qRGridModel.getItems().size() > 3 && (gridItem = qRGridModel.getItems().get(3)) != null) {
                if (this.binding.item3Icon != null && URLUtil.isValidUrl(gridItem.getIconSrc())) {
                    w.a().a(gridItem.getIconSrc()).a((ImageView) this.binding.item3Icon);
                    this.binding.item3Icon.setOnClickListener(new P4BSmartGridViewHolder$bindData$7(obj, gridItem));
                    AppCompatImageView appCompatImageView4 = this.binding.item3Icon;
                    k.b(appCompatImageView4, "binding.item3Icon");
                    appCompatImageView4.setVisibility(0);
                }
                if (this.binding.item3Text != null) {
                    String content4 = gridItem.getContent();
                    if (!(content4 == null || content4.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        this.binding.item3Text.setText(gridItem.getContent());
                        this.binding.item3Text.setOnClickListener(new P4BSmartGridViewHolder$bindData$8(obj, gridItem));
                        AppCompatTextView appCompatTextView4 = this.binding.item3Text;
                        k.b(appCompatTextView4, "binding.item3Text");
                        appCompatTextView4.setVisibility(0);
                    }
                }
            }
        }
    }
}
