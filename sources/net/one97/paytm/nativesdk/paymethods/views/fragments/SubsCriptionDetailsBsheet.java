package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.Details;
import net.one97.paytm.nativesdk.common.model.MerchantDetails;
import net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;

public final class SubsCriptionDetailsBsheet extends BaseBottomSheetDialogFragment {
    private HashMap _$_findViewCache;
    private ImageView imgCancelSubSheet;

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private final void setBottomSheetHeight() {
        BottomSheetBehavior from = BottomSheetBehavior.from((ConstraintLayout) _$_findCachedViewById(R.id.cl_subs_detail_sheet));
        k.a((Object) from, "BottomSheetBehavior.from(cl_subs_detail_sheet)");
        from.setState(3);
    }

    public final int getLayoutId() {
        return R.layout.bs_subscription_details;
    }

    public final void initView() {
        setValues();
        ((ImageView) _$_findCachedViewById(R.id.img_cancel)).setOnClickListener(new SubsCriptionDetailsBsheet$initView$1(this));
    }

    private final void setValues() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.getCjPayMethodResponse() != null) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance2.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            if (cjPayMethodResponse.getBody() != null) {
                DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                CJPayMethodResponse cjPayMethodResponse2 = instance3.getCjPayMethodResponse();
                k.a((Object) cjPayMethodResponse2, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                Body body = cjPayMethodResponse2.getBody();
                k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                if (body.getSubscriptionDetailsInfo() != null) {
                    DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                    k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                    CJPayMethodResponse cjPayMethodResponse3 = instance4.getCjPayMethodResponse();
                    k.a((Object) cjPayMethodResponse3, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                    Body body2 = cjPayMethodResponse3.getBody();
                    k.a((Object) body2, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                    SubscriptionDetailsInfo subscriptionDetailsInfo = body2.getSubscriptionDetailsInfo();
                    k.a((Object) subscriptionDetailsInfo, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                    if (subscriptionDetailsInfo.getDetails() != null) {
                        DirectPaymentBL instance5 = DirectPaymentBL.getInstance();
                        k.a((Object) instance5, "DirectPaymentBL.getInstance()");
                        if (instance5.getMerchantDetails() != null) {
                            DirectPaymentBL instance6 = DirectPaymentBL.getInstance();
                            k.a((Object) instance6, "DirectPaymentBL.getInstance()");
                            MerchantDetails merchantDetails = instance6.getMerchantDetails();
                            k.a((Object) merchantDetails, "DirectPaymentBL.getInstance().merchantDetails");
                            CharSequence merchantName = merchantDetails.getMerchantName();
                            if (!(merchantName == null || merchantName.length() == 0)) {
                                StringBuilder sb = new StringBuilder();
                                DirectPaymentBL instance7 = DirectPaymentBL.getInstance();
                                k.a((Object) instance7, "DirectPaymentBL.getInstance()");
                                MerchantDetails merchantDetails2 = instance7.getMerchantDetails();
                                k.a((Object) merchantDetails2, "DirectPaymentBL.getInstance().merchantDetails");
                                sb.append(merchantDetails2.getMerchantName());
                                sb.append(")");
                                String sb2 = sb.toString();
                                TextView textView = (TextView) _$_findCachedViewById(R.id.tv_subs_heading);
                                k.a((Object) textView, "tv_subs_heading");
                                textView.setText(getString(R.string.as_shared_by, sb2));
                            }
                        }
                        DirectPaymentBL instance8 = DirectPaymentBL.getInstance();
                        k.a((Object) instance8, "DirectPaymentBL.getInstance()");
                        CJPayMethodResponse cjPayMethodResponse4 = instance8.getCjPayMethodResponse();
                        k.a((Object) cjPayMethodResponse4, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                        Body body3 = cjPayMethodResponse4.getBody();
                        k.a((Object) body3, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                        SubscriptionDetailsInfo subscriptionDetailsInfo2 = body3.getSubscriptionDetailsInfo();
                        k.a((Object) subscriptionDetailsInfo2, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                        Details details = subscriptionDetailsInfo2.getDetails();
                        k.a((Object) details, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                        CharSequence frequencyValue = details.getFrequencyValue();
                        if (!(frequencyValue == null || frequencyValue.length() == 0)) {
                            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_subs_frequency);
                            k.a((Object) textView2, "tv_subs_frequency");
                            DirectPaymentBL instance9 = DirectPaymentBL.getInstance();
                            k.a((Object) instance9, "DirectPaymentBL.getInstance()");
                            CJPayMethodResponse cjPayMethodResponse5 = instance9.getCjPayMethodResponse();
                            k.a((Object) cjPayMethodResponse5, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                            Body body4 = cjPayMethodResponse5.getBody();
                            k.a((Object) body4, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                            SubscriptionDetailsInfo subscriptionDetailsInfo3 = body4.getSubscriptionDetailsInfo();
                            k.a((Object) subscriptionDetailsInfo3, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                            Details details2 = subscriptionDetailsInfo3.getDetails();
                            k.a((Object) details2, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                            textView2.setText(details2.getFrequencyKey());
                        }
                        DirectPaymentBL instance10 = DirectPaymentBL.getInstance();
                        k.a((Object) instance10, "DirectPaymentBL.getInstance()");
                        CJPayMethodResponse cjPayMethodResponse6 = instance10.getCjPayMethodResponse();
                        k.a((Object) cjPayMethodResponse6, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                        Body body5 = cjPayMethodResponse6.getBody();
                        k.a((Object) body5, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                        SubscriptionDetailsInfo subscriptionDetailsInfo4 = body5.getSubscriptionDetailsInfo();
                        k.a((Object) subscriptionDetailsInfo4, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                        Details details3 = subscriptionDetailsInfo4.getDetails();
                        k.a((Object) details3, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                        CharSequence frequencyValue2 = details3.getFrequencyValue();
                        if (!(frequencyValue2 == null || frequencyValue2.length() == 0)) {
                            StringBuilder sb3 = new StringBuilder("₹ ");
                            DirectPaymentBL instance11 = DirectPaymentBL.getInstance();
                            k.a((Object) instance11, "DirectPaymentBL.getInstance()");
                            CJPayMethodResponse cjPayMethodResponse7 = instance11.getCjPayMethodResponse();
                            k.a((Object) cjPayMethodResponse7, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                            Body body6 = cjPayMethodResponse7.getBody();
                            k.a((Object) body6, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                            SubscriptionDetailsInfo subscriptionDetailsInfo5 = body6.getSubscriptionDetailsInfo();
                            k.a((Object) subscriptionDetailsInfo5, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                            Details details4 = subscriptionDetailsInfo5.getDetails();
                            k.a((Object) details4, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                            sb3.append(details4.getFrequencyValue());
                            String sb4 = sb3.toString();
                            DirectPaymentBL instance12 = DirectPaymentBL.getInstance();
                            k.a((Object) instance12, "DirectPaymentBL.getInstance()");
                            CJPayMethodResponse cjPayMethodResponse8 = instance12.getCjPayMethodResponse();
                            k.a((Object) cjPayMethodResponse8, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                            Body body7 = cjPayMethodResponse8.getBody();
                            k.a((Object) body7, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                            SubscriptionDetailsInfo subscriptionDetailsInfo6 = body7.getSubscriptionDetailsInfo();
                            k.a((Object) subscriptionDetailsInfo6, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                            if (k.a((Object) subscriptionDetailsInfo6.getSubsType(), (Object) "VARIABLE")) {
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("upto ".concat(String.valueOf(sb4)));
                                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.7f), 0, 4, 33);
                                CharSequence charSequence = sb4;
                                spannableStringBuilder.setSpan(new StyleSpan(1), p.a(charSequence, FilterPriceSliderFragment.RUPEE_SYMBOL, 0, false, 6), spannableStringBuilder.length(), 33);
                                if (Build.VERSION.SDK_INT >= 28) {
                                    spannableStringBuilder.setSpan(new TypefaceSpan(Typeface.SANS_SERIF), p.a(charSequence, FilterPriceSliderFragment.RUPEE_SYMBOL, 0, false, 6), spannableStringBuilder.length(), 33);
                                } else {
                                    spannableStringBuilder.setSpan(new TypefaceSpan("sans-serif-medium"), p.a(charSequence, FilterPriceSliderFragment.RUPEE_SYMBOL, 0, false, 6), spannableStringBuilder.length(), 33);
                                }
                                TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_amount_subs_frequency);
                                k.a((Object) textView3, "tv_amount_subs_frequency");
                                textView3.setText(spannableStringBuilder);
                            } else {
                                TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_amount_subs_frequency);
                                k.a((Object) textView4, "tv_amount_subs_frequency");
                                textView4.setText(sb4);
                            }
                        }
                        DirectPaymentBL instance13 = DirectPaymentBL.getInstance();
                        k.a((Object) instance13, "DirectPaymentBL.getInstance()");
                        CJPayMethodResponse cjPayMethodResponse9 = instance13.getCjPayMethodResponse();
                        k.a((Object) cjPayMethodResponse9, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                        Body body8 = cjPayMethodResponse9.getBody();
                        k.a((Object) body8, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                        SubscriptionDetailsInfo subscriptionDetailsInfo7 = body8.getSubscriptionDetailsInfo();
                        k.a((Object) subscriptionDetailsInfo7, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                        Details details5 = subscriptionDetailsInfo7.getDetails();
                        k.a((Object) details5, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                        CharSequence nextPaymentKey = details5.getNextPaymentKey();
                        if (!(nextPaymentKey == null || nextPaymentKey.length() == 0)) {
                            TextView textView5 = (TextView) _$_findCachedViewById(R.id.tv_subs_next_payment);
                            k.a((Object) textView5, "tv_subs_next_payment");
                            StringBuilder sb5 = new StringBuilder();
                            DirectPaymentBL instance14 = DirectPaymentBL.getInstance();
                            k.a((Object) instance14, "DirectPaymentBL.getInstance()");
                            CJPayMethodResponse cjPayMethodResponse10 = instance14.getCjPayMethodResponse();
                            k.a((Object) cjPayMethodResponse10, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                            Body body9 = cjPayMethodResponse10.getBody();
                            k.a((Object) body9, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                            SubscriptionDetailsInfo subscriptionDetailsInfo8 = body9.getSubscriptionDetailsInfo();
                            k.a((Object) subscriptionDetailsInfo8, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                            Details details6 = subscriptionDetailsInfo8.getDetails();
                            k.a((Object) details6, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                            sb5.append(details6.getNextPaymentKey());
                            sb5.append(AppConstants.COLON);
                            textView5.setText(sb5.toString());
                        } else {
                            TextView textView6 = (TextView) _$_findCachedViewById(R.id.tv_subs_next_payment);
                            k.a((Object) textView6, "tv_subs_next_payment");
                            textView6.setVisibility(8);
                        }
                        DirectPaymentBL instance15 = DirectPaymentBL.getInstance();
                        k.a((Object) instance15, "DirectPaymentBL.getInstance()");
                        CJPayMethodResponse cjPayMethodResponse11 = instance15.getCjPayMethodResponse();
                        k.a((Object) cjPayMethodResponse11, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                        Body body10 = cjPayMethodResponse11.getBody();
                        k.a((Object) body10, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                        SubscriptionDetailsInfo subscriptionDetailsInfo9 = body10.getSubscriptionDetailsInfo();
                        k.a((Object) subscriptionDetailsInfo9, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                        Details details7 = subscriptionDetailsInfo9.getDetails();
                        k.a((Object) details7, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                        CharSequence nextPaymentValue = details7.getNextPaymentValue();
                        if (!(nextPaymentValue == null || nextPaymentValue.length() == 0)) {
                            TextView textView7 = (TextView) _$_findCachedViewById(R.id.tv_date_next_payment);
                            k.a((Object) textView7, "tv_date_next_payment");
                            DirectPaymentBL instance16 = DirectPaymentBL.getInstance();
                            k.a((Object) instance16, "DirectPaymentBL.getInstance()");
                            CJPayMethodResponse cjPayMethodResponse12 = instance16.getCjPayMethodResponse();
                            k.a((Object) cjPayMethodResponse12, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                            Body body11 = cjPayMethodResponse12.getBody();
                            k.a((Object) body11, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                            SubscriptionDetailsInfo subscriptionDetailsInfo10 = body11.getSubscriptionDetailsInfo();
                            k.a((Object) subscriptionDetailsInfo10, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
                            Details details8 = subscriptionDetailsInfo10.getDetails();
                            k.a((Object) details8, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
                            textView7.setText(details8.getNextPaymentValue());
                            return;
                        }
                        return;
                    }
                    TextView textView8 = (TextView) _$_findCachedViewById(R.id.tv_date_next_payment);
                    k.a((Object) textView8, "tv_date_next_payment");
                    textView8.setVisibility(8);
                    return;
                }
                return;
            }
            dismiss();
            return;
        }
        dismiss();
    }
}
