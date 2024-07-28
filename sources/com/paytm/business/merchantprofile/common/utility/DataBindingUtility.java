package com.paytm.business.merchantprofile.common.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.airbnb.lottie.LottieAnimationView;
import com.business.common_module.utilities.LogUtility;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.ActivationStatusCheckInProgress;
import com.paytm.business.merchantprofile.inactivemerchant.DeActivatedEligibleForInstantReactivation;
import com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess;
import com.paytm.business.merchantprofile.inactivemerchant.ReActivationFailed;
import com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.common.widgets.a;

public class DataBindingUtility {
    public static final String TAG = "DataBindingUtility";

    public static void loadImage(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            w.a().a(str).a(imageView, (e) null);
        }
    }

    public static void bitmapSrc(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void loadUrl(WebView webView, String str) {
        LogUtility.i(TAG, "loadUrl");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(str);
    }

    public static void movementMethod(TextView textView, MovementMethod movementMethod) {
        textView.setMovementMethod(movementMethod);
    }

    public static void errorText(TextInputLayout textInputLayout, String str) {
        if (TextUtils.isEmpty(str)) {
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setErrorEnabled(true);
        }
        textInputLayout.setError(str);
    }

    public static void bindSrcCompat(ImageView imageView, int i2) {
        imageView.setImageResource(i2);
    }

    public static void bindSrcCompat(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    public static void bindTextColor(TextView textView, int i2) {
        textView.setTextColor(b.c(textView.getContext(), i2));
    }

    public static void bindVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static void bindViewVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    public static void setMarginTop(View view, float f2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, Math.round(f2), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setLayoutParams(marginLayoutParams);
    }

    public static void setTextWithParamsAndImage(TextView textView, int i2, String[] strArr, boolean z, int i3) {
        try {
            String format = String.format(textView.getContext().getString(i2), strArr);
            if (z) {
                textView.setText(AppUtility.getFormattedTextWithImage(new StringBuilder(format), i3, textView.getContext()));
            } else {
                textView.setText(format);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setTextWithParams(TextView textView, int i2, String[] strArr) {
        try {
            textView.setText(String.format(textView.getContext().getString(i2), strArr));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void loadPayMethodImage(ImageView imageView, String str) {
        if (str != null && !str.isEmpty() && imageView != null && URLUtil.isValidUrl(str)) {
            w.a().a(str).a(imageView, (e) null);
        }
    }

    public static void inactivateMerchantState(View view, AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState, InactiveMerchantListener inactiveMerchantListener) {
        if (accountActivationState == null && merchantAccountActivationUIState == null) {
            inactiveMerchantListener.getAccountReActivationStatus();
        } else if (accountActivationState instanceof MerchantReactivationSuccess) {
            inactiveMerchantListener.onReactivationSuccessful();
        } else if (accountActivationState instanceof ReActivationFailed) {
            inactiveMerchantListener.onReactivationFailure();
        }
        if (accountActivationState != null) {
            inactiveMerchantListener.onInactiveMerchantDataChange(accountActivationState, merchantAccountActivationUIState);
        }
    }

    public static void textBold(TextView textView, boolean z) {
        Typeface defaultFromStyle = Typeface.defaultFromStyle(1);
        Typeface defaultFromStyle2 = Typeface.defaultFromStyle(0);
        if (z) {
            textView.setTypeface(defaultFromStyle);
        } else {
            textView.setTypeface(defaultFromStyle2);
        }
    }

    public static void deactivatedAccountTitle(TextView textView, AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState, boolean z) {
        String str;
        if (z) {
            if (accountActivationState instanceof ReActivationInProgress) {
                str = textView.getContext().getString(R.string.pr_instant_act_submit_title);
            } else if (merchantAccountActivationUIState instanceof ActivationStatusCheckInProgress) {
                str = textView.getContext().getString(R.string.pr_instant_act_processi_title);
            } else if (accountActivationState instanceof DeActivatedNotEligibleForInstantReactivation) {
                str = textView.getContext().getString(R.string.pr_in_active_merchant_tilte);
            } else {
                str = textView.getContext().getString(R.string.pr_instant_activation_title);
            }
            textView.setText(str);
        }
    }

    public static void deactivatedAccountMessage(TextView textView, AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState, boolean z, boolean z2) {
        String str;
        int i2;
        Context context;
        int i3;
        Context context2;
        int i4;
        Context context3;
        if (z) {
            if (merchantAccountActivationUIState instanceof ActivationStatusCheckInProgress) {
                str = textView.getContext().getString(R.string.pr_instant_act_process_message);
            } else if (accountActivationState instanceof ReActivationInProgress) {
                if (z2) {
                    context3 = textView.getContext();
                    i4 = R.string.pr_instant_act_submit_message_ap;
                } else {
                    context3 = textView.getContext();
                    i4 = R.string.pr_instant_act_submit_message;
                }
                str = context3.getString(i4);
            } else if (accountActivationState instanceof DeActivatedNotEligibleForInstantReactivation) {
                if (z2) {
                    context2 = textView.getContext();
                    i3 = R.string.pr_in_active_merchant_msessage_ap;
                } else {
                    context2 = textView.getContext();
                    i3 = R.string.pr_in_active_merchant_msessage;
                }
                str = context2.getString(i3);
            } else {
                if (z2) {
                    context = textView.getContext();
                    i2 = R.string.pr_instant_activation_message_ap;
                } else {
                    context = textView.getContext();
                    i2 = R.string.pr_instant_activation_message;
                }
                str = context.getString(i2);
            }
            textView.setText(Html.fromHtml(str));
        }
    }

    public static void deactivatedAccountCTA(TextView textView, boolean z, AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState, InactiveMerchantListener inactiveMerchantListener, boolean z2) {
        String str;
        View.OnClickListener onClickListener;
        int i2;
        Context context;
        if (z) {
            boolean z3 = accountActivationState instanceof ReActivationInProgress;
            if (z3) {
                onClickListener = new View.OnClickListener() {
                    public final void onClick(View view) {
                        InactiveMerchantListener.this.onViewPastPaymentsClick();
                    }
                };
                str = textView.getContext().getString(R.string.pr_view_past_payments);
            } else if (accountActivationState instanceof DeActivatedEligibleForInstantReactivation) {
                onClickListener = new View.OnClickListener() {
                    public final void onClick(View view) {
                        InactiveMerchantListener.this.reactivateMerchantAccount();
                    }
                };
                if (z2) {
                    context = textView.getContext();
                    i2 = R.string.pr_reactivate_account;
                } else {
                    context = textView.getContext();
                    i2 = R.string.pr_activate_now;
                }
                str = context.getString(i2);
                if (!z2) {
                    ProfileConfig.getInstance().getEventPublisher().a(textView.getContext(), "HomePage", "Account Deactivated - Reactivation CTA Shown", "", "");
                }
            } else if (!z2 || !z3) {
                onClickListener = new View.OnClickListener() {
                    public final void onClick(View view) {
                        InactiveMerchantListener.this.onContactUsClick(InactiveMerchantListener.this.getHelpLineNumber());
                    }
                };
                str = String.format(textView.getContext().getString(R.string.pr_contact_us), new Object[]{inactiveMerchantListener.getHelpLineNumber()});
                if (!z2) {
                    ProfileConfig.getInstance().getEventPublisher().a(textView.getContext(), "HomePage", "Account Deactivated -> Call MHD Shown", "", "");
                }
            } else {
                onClickListener = new View.OnClickListener() {
                    public final void onClick(View view) {
                        InactiveMerchantListener.this.onReactivationInProgress();
                    }
                };
                str = textView.getContext().getString(R.string.pr_ok);
            }
            textView.setText(str);
            textView.setOnClickListener(onClickListener);
        }
    }

    public static void dottetLoaderVisibility(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            lottieAnimationView.setVisibility(0);
            a.a(lottieAnimationView);
            return;
        }
        a.b(lottieAnimationView);
        lottieAnimationView.setVisibility(8);
    }

    public static void htmlText(TextView textView, String str) {
        textView.setText(Html.fromHtml(str));
    }

    public static void onTabClick(TabLayout tabLayout, TabLayout.c cVar) {
        tabLayout.a((TabLayout.b) cVar);
    }
}
