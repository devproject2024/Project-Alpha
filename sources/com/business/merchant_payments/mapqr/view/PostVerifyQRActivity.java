package com.business.merchant_payments.mapqr.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.b;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.databinding.MpActivityPostQrScanBinding;
import com.business.merchant_payments.mapqr.utility.ScanQRHandler;
import com.business.merchant_payments.utility.MPConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class PostVerifyQRActivity extends BaseActivity {
    public HashMap _$_findViewCache;
    public MpActivityPostQrScanBinding mBinding;

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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = f.a(this, R.layout.mp_activity_post_qr_scan);
        k.b(a2, "DataBindingUtil.setConte…mp_activity_post_qr_scan)");
        this.mBinding = (MpActivityPostQrScanBinding) a2;
        if (MPConstants.isP4BClient()) {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding = this.mBinding;
            if (mpActivityPostQrScanBinding == null) {
                k.a("mBinding");
            }
            ConstraintLayout constraintLayout = mpActivityPostQrScanBinding.clWatchAd;
            k.b(constraintLayout, "mBinding.clWatchAd");
            constraintLayout.setVisibility(0);
        } else {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding2 = this.mBinding;
            if (mpActivityPostQrScanBinding2 == null) {
                k.a("mBinding");
            }
            ConstraintLayout constraintLayout2 = mpActivityPostQrScanBinding2.clWatchAd;
            k.b(constraintLayout2, "mBinding.clWatchAd");
            constraintLayout2.setVisibility(8);
        }
        setListeners();
        getExtras();
        if (GTMDataProviderImpl.Companion.getMInstance().isShowOrderQr()) {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding3 = this.mBinding;
            if (mpActivityPostQrScanBinding3 == null) {
                k.a("mBinding");
            }
            ConstraintLayout constraintLayout3 = mpActivityPostQrScanBinding3.clOrderQrAccessories;
            k.b(constraintLayout3, "mBinding.clOrderQrAccessories");
            constraintLayout3.setVisibility(0);
        } else {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding4 = this.mBinding;
            if (mpActivityPostQrScanBinding4 == null) {
                k.a("mBinding");
            }
            ConstraintLayout constraintLayout4 = mpActivityPostQrScanBinding4.clOrderQrAccessories;
            k.b(constraintLayout4, "mBinding.clOrderQrAccessories");
            constraintLayout4.setVisibility(8);
        }
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher();
    }

    public final void getExtras() {
        Intent intent = getIntent();
        k.b(intent, "intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString(ScanActivityVision.INTENT_EXTRA) : null;
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -2060130305) {
                if (hashCode != -419749397) {
                    if (hashCode != -345531113) {
                        if (hashCode == 1389370879 && string.equals(UpiConstants.UPI_SOURCE_MAPPING.PAYTM_QR_SCAN_SOURCE)) {
                            MpActivityPostQrScanBinding mpActivityPostQrScanBinding = this.mBinding;
                            if (mpActivityPostQrScanBinding == null) {
                                k.a("mBinding");
                            }
                            mpActivityPostQrScanBinding.tvBtnScanAgain.setText(getString(R.string.mp_back_to_home_screen));
                            MpActivityPostQrScanBinding mpActivityPostQrScanBinding2 = this.mBinding;
                            if (mpActivityPostQrScanBinding2 == null) {
                                k.a("mBinding");
                            }
                            mpActivityPostQrScanBinding2.tvBtnScanAgain.setOnClickListener(new PostVerifyQRActivity$getExtras$2(this));
                            MpActivityPostQrScanBinding mpActivityPostQrScanBinding3 = this.mBinding;
                            if (mpActivityPostQrScanBinding3 == null) {
                                k.a("mBinding");
                            }
                            CustomTextView customTextView = mpActivityPostQrScanBinding3.tvScanStatusText;
                            String string2 = getString(R.string.mp_qr_successfully_verified);
                            k.b(string2, "getString(R.string.mp_qr_successfully_verified)");
                            customTextView.setText(setTextFormattingWithImage(string2, R.drawable.mqr_ic_circle_green_success), TextView.BufferType.SPANNABLE);
                        }
                    } else if (string.equals("old_paytm_qr")) {
                        MpActivityPostQrScanBinding mpActivityPostQrScanBinding4 = this.mBinding;
                        if (mpActivityPostQrScanBinding4 == null) {
                            k.a("mBinding");
                        }
                        ConstraintLayout constraintLayout = mpActivityPostQrScanBinding4.clEarnCashback;
                        k.b(constraintLayout, "mBinding.clEarnCashback");
                        constraintLayout.setVisibility(8);
                        ((CustomTextView) _$_findCachedViewById(R.id.tv_sub_title)).setText(getString(R.string.mp_old_qr_subtext));
                        MpActivityPostQrScanBinding mpActivityPostQrScanBinding5 = this.mBinding;
                        if (mpActivityPostQrScanBinding5 == null) {
                            k.a("mBinding");
                        }
                        CustomTextView customTextView2 = mpActivityPostQrScanBinding5.tvScanStatusText;
                        String string3 = getString(R.string.mp_old_paytm_qr);
                        k.b(string3, "getString(R.string.mp_old_paytm_qr)");
                        customTextView2.setText(setTextFormattingWithImage(string3, R.drawable.mp_ic_error_new), TextView.BufferType.SPANNABLE);
                    }
                } else if (string.equals("not_paytm_qr")) {
                    MpActivityPostQrScanBinding mpActivityPostQrScanBinding6 = this.mBinding;
                    if (mpActivityPostQrScanBinding6 == null) {
                        k.a("mBinding");
                    }
                    ConstraintLayout constraintLayout2 = mpActivityPostQrScanBinding6.clEarnCashback;
                    k.b(constraintLayout2, "mBinding.clEarnCashback");
                    constraintLayout2.setVisibility(8);
                    ((CustomTextView) _$_findCachedViewById(R.id.tv_sub_title)).setText(getString(R.string.mp_not_paytm_qr_subtext));
                    MpActivityPostQrScanBinding mpActivityPostQrScanBinding7 = this.mBinding;
                    if (mpActivityPostQrScanBinding7 == null) {
                        k.a("mBinding");
                    }
                    CustomTextView customTextView3 = mpActivityPostQrScanBinding7.tvScanStatusText;
                    String string4 = getString(R.string.mp_not_original_paytm_qr);
                    k.b(string4, "getString(R.string.mp_not_original_paytm_qr)");
                    customTextView3.setText(setTextFormattingWithImage(string4, R.drawable.mp_ic_error_new), TextView.BufferType.SPANNABLE);
                }
            } else if (string.equals("not_scannable")) {
                if (this.mBinding == null) {
                    k.a("mBinding");
                }
                ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_earn_cashback);
                k.b(constraintLayout3, "cl_earn_cashback");
                constraintLayout3.setVisibility(8);
                ConstraintLayout constraintLayout4 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_watch_ad);
                k.b(constraintLayout4, "cl_watch_ad");
                constraintLayout4.setVisibility(8);
                ((CustomTextView) _$_findCachedViewById(R.id.tv_sub_title)).setText(getString(R.string.mp_not_scannable_subtext));
                String string5 = getString(R.string.mp_unable_to_scan);
                k.b(string5, "getString(R.string.mp_unable_to_scan)");
                ((CustomTextView) _$_findCachedViewById(R.id.tv_scan_status_text)).setText(setTextFormattingWithImage(string5, R.drawable.mp_ic_error_new), TextView.BufferType.SPANNABLE);
            }
        }
    }

    public final void setListeners() {
        MpActivityPostQrScanBinding mpActivityPostQrScanBinding = this.mBinding;
        if (mpActivityPostQrScanBinding == null) {
            k.a("mBinding");
        }
        mpActivityPostQrScanBinding.tvBtnScanAgain.setOnClickListener(new PostVerifyQRActivity$setListeners$1(this));
        MpActivityPostQrScanBinding mpActivityPostQrScanBinding2 = this.mBinding;
        if (mpActivityPostQrScanBinding2 == null) {
            k.a("mBinding");
        }
        mpActivityPostQrScanBinding2.ivClose.setOnClickListener(new PostVerifyQRActivity$setListeners$2(this));
        MpActivityPostQrScanBinding mpActivityPostQrScanBinding3 = this.mBinding;
        if (mpActivityPostQrScanBinding3 == null) {
            k.a("mBinding");
        }
        mpActivityPostQrScanBinding3.clWatchAd.setOnClickListener(new PostVerifyQRActivity$setListeners$3(this));
        MpActivityPostQrScanBinding mpActivityPostQrScanBinding4 = this.mBinding;
        if (mpActivityPostQrScanBinding4 == null) {
            k.a("mBinding");
        }
        mpActivityPostQrScanBinding4.clPrintQr.setOnClickListener(new PostVerifyQRActivity$setListeners$4(this));
        MpActivityPostQrScanBinding mpActivityPostQrScanBinding5 = this.mBinding;
        if (mpActivityPostQrScanBinding5 == null) {
            k.a("mBinding");
        }
        mpActivityPostQrScanBinding5.clOrderQrAccessories.setOnClickListener(new PostVerifyQRActivity$setListeners$5(this));
        MpActivityPostQrScanBinding mpActivityPostQrScanBinding6 = this.mBinding;
        if (mpActivityPostQrScanBinding6 == null) {
            k.a("mBinding");
        }
        mpActivityPostQrScanBinding6.clEarnCashback.setOnClickListener(new PostVerifyQRActivity$setListeners$6(this));
        String string = getString(R.string.mp_bold_order_accessories_txt);
        boolean z = true;
        if (!(string == null || string.length() == 0) && getString(R.string.mp_bold_order_accessories_txt).length() >= 45) {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding7 = this.mBinding;
            if (mpActivityPostQrScanBinding7 == null) {
                k.a("mBinding");
            }
            CustomTextView customTextView = mpActivityPostQrScanBinding7.tvOrderQrAccessories;
            String string2 = getString(R.string.mp_bold_order_accessories_txt);
            k.b(string2, "getString(R.string.mp_bold_order_accessories_txt)");
            customTextView.setText(getSpannableFormattedString(string2, 6, 37));
        }
        String string3 = getString(R.string.mp_earn_Cashback_txt);
        if (!(string3 == null || string3.length() == 0) && getString(R.string.mp_earn_Cashback_txt).length() >= 13) {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding8 = this.mBinding;
            if (mpActivityPostQrScanBinding8 == null) {
                k.a("mBinding");
            }
            CustomTextView customTextView2 = mpActivityPostQrScanBinding8.tvEarnCashback;
            String string4 = getString(R.string.mp_earn_Cashback_txt);
            k.b(string4, "getString(R.string.mp_earn_Cashback_txt)");
            customTextView2.setText(getSpannableFormattedString(string4, 0, 13));
        }
        String string5 = getString(R.string.mp_print_all_in_one_qr_txt);
        if (!(string5 == null || string5.length() == 0) && getString(R.string.mp_print_all_in_one_qr_txt).length() >= 6) {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding9 = this.mBinding;
            if (mpActivityPostQrScanBinding9 == null) {
                k.a("mBinding");
            }
            CustomTextView customTextView3 = mpActivityPostQrScanBinding9.tvPrintQr;
            String string6 = getString(R.string.mp_print_all_in_one_qr_txt);
            k.b(string6, "getString(R.string.mp_print_all_in_one_qr_txt)");
            customTextView3.setText(getSpannableFormattedString(string6, 0, 6));
        }
        String string7 = getString(R.string.mp_watch_ad_text);
        if (!(string7 == null || string7.length() == 0)) {
            z = false;
        }
        if (!z && getString(R.string.mp_watch_ad_text).length() >= 30) {
            MpActivityPostQrScanBinding mpActivityPostQrScanBinding10 = this.mBinding;
            if (mpActivityPostQrScanBinding10 == null) {
                k.a("mBinding");
            }
            CustomTextView customTextView4 = mpActivityPostQrScanBinding10.tvWatchAd;
            String string8 = getString(R.string.mp_watch_ad_text);
            k.b(string8, "getString(R.string.mp_watch_ad_text)");
            customTextView4.setText(getSpannableFormattedString(string8, 14, 30));
        }
    }

    public final SpannableString getSpannableFormattedString(String str, int i2, int i3) {
        k.d(str, "stringToBeSet");
        SpannableString spannedText = AppUtility.getSpannedText(str);
        Typeface typeface = Typeface.DEFAULT_BOLD;
        if (i3 > spannedText.length()) {
            k.b(typeface, "tf");
            spannedText.setSpan(new StyleSpan(typeface.getStyle()), i2, spannedText.length(), 17);
        } else {
            k.b(typeface, "tf");
            spannedText.setSpan(new StyleSpan(typeface.getStyle()), i2, i3, 17);
        }
        k.b(spannedText, "spannableString");
        return spannedText;
    }

    public final SpannableString setTextFormattingWithImage(String str, int i2) {
        k.d(str, "textToBeFormatted");
        SpannableString spannableString = new SpannableString(str);
        if (spannableString.length() > 0) {
            spannableString.setSpan(new b(this, i2), spannableString.length() - 1, spannableString.length(), 17);
        }
        return spannableString;
    }

    public final void openLinkNewQR(Context context) {
        k.d(context, "context");
        new ScanQRHandler().scanQR(this, true);
        finish();
    }
}
