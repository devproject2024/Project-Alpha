package net.one97.paytm.p2mNewDesign.g;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.paytm.network.model.NetworkCustomError;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.p2mNewDesign.d.d;
import net.one97.paytm.p2mNewDesign.d.e;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MyOrdersAPIResponse;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.wallet.R;

public final class e extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51282a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private f f51283b;

    /* renamed from: c  reason: collision with root package name */
    private String f51284c;

    /* renamed from: d  reason: collision with root package name */
    private String f51285d;

    /* renamed from: e  reason: collision with root package name */
    private String f51286e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f51287f;

    /* renamed from: g  reason: collision with root package name */
    private String f51288g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f51289h;

    static final class b<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51290a;

        b(e eVar) {
            this.f51290a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.h hVar;
            net.one97.paytm.network.h hVar2;
            String str;
            NetworkCustomError networkCustomError;
            NetworkCustomError networkCustomError2;
            RelativeLayout relativeLayout;
            RelativeLayout relativeLayout2;
            String str2;
            TextView textView;
            TextView textView2;
            RelativeLayout relativeLayout3;
            Handler handler;
            WalletCircularProgressBar walletCircularProgressBar;
            WalletCircularProgressBar walletCircularProgressBar2;
            RelativeLayout relativeLayout4;
            ImageView imageView;
            LottieAnimationView lottieAnimationView;
            ImageView imageView2;
            TextView textView3;
            TextView textView4;
            TextView textView5;
            TextView textView6;
            TextView textView7;
            TextView textView8;
            ImageView imageView3;
            LottieAnimationView lottieAnimationView2;
            ImageView imageView4;
            TextView textView9;
            TextView textView10;
            WalletCircularProgressBar walletCircularProgressBar3;
            TextView textView11;
            TextView textView12;
            RelativeLayout relativeLayout5;
            TextView textView13;
            RelativeLayout relativeLayout6;
            RelativeLayout relativeLayout7;
            f fVar = (f) obj;
            e.a(this.f51290a);
            String str3 = null;
            if (fVar != null) {
                hVar = fVar.f55796a;
            } else {
                hVar = null;
            }
            boolean z = true;
            if (hVar != net.one97.paytm.network.h.SUCCESS) {
                if (fVar != null) {
                    hVar2 = fVar.f55796a;
                } else {
                    hVar2 = null;
                }
                if (hVar2 != net.one97.paytm.network.h.ERROR) {
                    return;
                }
                if (this.f51290a.getParentFragment() instanceof d) {
                    Fragment parentFragment = this.f51290a.getParentFragment();
                    if (parentFragment == null) {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
                    } else if (((d) parentFragment).isAdded()) {
                        Fragment parentFragment2 = this.f51290a.getParentFragment();
                        if (parentFragment2 != null) {
                            ((d) parentFragment2).a(fVar.f55798c, this.f51290a.f51287f);
                            e.c(this.f51290a);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
                    }
                } else if (this.f51290a.getParentFragment() instanceof net.one97.paytm.p2mNewDesign.d.e) {
                    Fragment parentFragment3 = this.f51290a.getParentFragment();
                    if (parentFragment3 == null) {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
                    } else if (((net.one97.paytm.p2mNewDesign.d.e) parentFragment3).isAdded()) {
                        Fragment parentFragment4 = this.f51290a.getParentFragment();
                        if (parentFragment4 != null) {
                            net.one97.paytm.p2mNewDesign.d.e eVar = (net.one97.paytm.p2mNewDesign.d.e) parentFragment4;
                            g gVar = fVar.f55798c;
                            String b2 = this.f51290a.f51287f;
                            View view = eVar.getView();
                            if (!(view == null || (relativeLayout2 = (RelativeLayout) view.findViewById(R.id.main_summary_rl)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.a(relativeLayout2);
                            }
                            View view2 = eVar.getView();
                            if (!(view2 == null || (relativeLayout = (RelativeLayout) view2.findViewById(R.id.resend_confirmation_payment)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(relativeLayout);
                            }
                            if (!TextUtils.isEmpty(b2)) {
                                eVar.b(b2);
                            }
                            if (gVar == null || (networkCustomError2 = gVar.f55801c) == null) {
                                str = null;
                            } else {
                                str = networkCustomError2.getAlertMessage();
                            }
                            CharSequence charSequence = str;
                            if (!(charSequence == null || charSequence.length() == 0)) {
                                z = false;
                            }
                            if (z) {
                                str3 = "Network Error, Please try again.";
                            } else if (!(gVar == null || (networkCustomError = gVar.f55801c) == null)) {
                                str3 = networkCustomError.getAlertMessage();
                            }
                            eVar.a("MLV_ERROR", str3);
                            e.c(this.f51290a);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
                    }
                }
            } else if ((this.f51290a.getParentFragment() instanceof d) && (fVar.f55797b instanceof MyOrdersAPIResponse)) {
                Fragment parentFragment5 = this.f51290a.getParentFragment();
                if (parentFragment5 == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
                } else if (((d) parentFragment5).isAdded()) {
                    Fragment parentFragment6 = this.f51290a.getParentFragment();
                    if (parentFragment6 != null) {
                        ((d) parentFragment6).a((MyOrdersAPIResponse) fVar.f55797b);
                        e.a(this.f51290a, (MyOrdersAPIResponse) fVar.f55797b);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
                }
            } else if ((this.f51290a.getParentFragment() instanceof net.one97.paytm.p2mNewDesign.d.e) && (fVar.f55797b instanceof MyOrdersAPIResponse)) {
                Fragment parentFragment7 = this.f51290a.getParentFragment();
                if (parentFragment7 == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
                } else if (((net.one97.paytm.p2mNewDesign.d.e) parentFragment7).isAdded()) {
                    Fragment parentFragment8 = this.f51290a.getParentFragment();
                    if (parentFragment8 != null) {
                        net.one97.paytm.p2mNewDesign.d.e eVar2 = (net.one97.paytm.p2mNewDesign.d.e) parentFragment8;
                        MyOrdersAPIResponse myOrdersAPIResponse = (MyOrdersAPIResponse) fVar.f55797b;
                        k.c(myOrdersAPIResponse, "data");
                        View view3 = eVar2.getView();
                        if (!(view3 == null || (relativeLayout7 = (RelativeLayout) view3.findViewById(R.id.main_summary_rl)) == null)) {
                            net.one97.paytm.wallet.rateMerchant.utils.b.a(relativeLayout7);
                        }
                        List<Payment> payments = myOrdersAPIResponse.getPayments();
                        if (payments != null) {
                            String merchantLogoUrl = payments.get(0).getMerchantLogoUrl();
                            if (merchantLogoUrl != null) {
                                eVar2.f51100g = merchantLogoUrl;
                                eVar2.f();
                            }
                            if (payments.get(0).getTxnCount() != null) {
                                View view4 = eVar2.getView();
                                if (!(view4 == null || (relativeLayout6 = (RelativeLayout) view4.findViewById(R.id.rl_txn_count)) == null)) {
                                    net.one97.paytm.wallet.rateMerchant.utils.b.a(relativeLayout6);
                                }
                                View view5 = eVar2.getView();
                                if (!(view5 == null || (textView13 = (TextView) view5.findViewById(R.id.tv_txn_count)) == null)) {
                                    textView13.setText(String.valueOf(payments.get(0).getTxnCount()));
                                }
                            } else {
                                View view6 = eVar2.getView();
                                if (!(view6 == null || (relativeLayout5 = (RelativeLayout) view6.findViewById(R.id.rl_txn_count)) == null)) {
                                    net.one97.paytm.wallet.rateMerchant.utils.b.b(relativeLayout5);
                                }
                            }
                            if (!TextUtils.isEmpty(payments.get(0).getMerchantName())) {
                                View view7 = eVar2.getView();
                                if (!(view7 == null || (textView12 = (TextView) view7.findViewById(R.id.tv_merchant_name)) == null)) {
                                    textView12.setText(payments.get(0).getMerchantName());
                                }
                            } else {
                                View view8 = eVar2.getView();
                                if (!(view8 == null || (textView11 = (TextView) view8.findViewById(R.id.tv_merchant_name)) == null)) {
                                    textView11.setText(eVar2.k);
                                }
                            }
                        }
                        eVar2.b(String.valueOf(myOrdersAPIResponse.getSubtotal()));
                        if (p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "2", true)) {
                            List<Payment> payments2 = myOrdersAPIResponse.getPayments();
                            if (payments2 != null) {
                                eVar2.f51095a = payments2.get(0).getTransactionNumber();
                                eVar2.f51102i = payments2.get(0).getMid();
                            }
                            eVar2.f51098e = myOrdersAPIResponse.getId();
                            eVar2.e();
                            eVar2.l = false;
                            View view9 = eVar2.getView();
                            if (!(view9 == null || (walletCircularProgressBar3 = (WalletCircularProgressBar) view9.findViewById(R.id.pb_pending)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(walletCircularProgressBar3);
                            }
                            View view10 = eVar2.getView();
                            if (!(view10 == null || (textView10 = (TextView) view10.findViewById(R.id.tv_status_msg)) == null)) {
                                textView10.setText(eVar2.getString(R.string.paid_successfully_to));
                            }
                            View view11 = eVar2.getView();
                            if (!(view11 == null || (textView9 = (TextView) view11.findViewById(R.id.tv_status_msg)) == null)) {
                                Activity activity = eVar2.f51099f;
                                if (activity == null) {
                                    k.a("mActivity");
                                }
                                textView9.setTextColor(androidx.core.content.b.c(activity, R.color.black));
                            }
                            View view12 = eVar2.getView();
                            if (!(view12 == null || (imageView4 = (ImageView) view12.findViewById(R.id.ic_payment_status)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.a(imageView4);
                            }
                            View view13 = eVar2.getView();
                            if (!(view13 == null || (lottieAnimationView2 = (LottieAnimationView) view13.findViewById(R.id.success_animation)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(lottieAnimationView2);
                            }
                            net.one97.paytm.p2mNewDesign.f.k kVar = eVar2.f51101h;
                            if (kVar != null) {
                                kVar.c();
                            }
                            View view14 = eVar2.getView();
                            if (!(view14 == null || (imageView3 = (ImageView) view14.findViewById(R.id.ic_payment_status)) == null)) {
                                Activity activity2 = eVar2.f51099f;
                                if (activity2 == null) {
                                    k.a("mActivity");
                                }
                                imageView3.setBackground(androidx.core.content.b.a((Context) activity2, R.drawable.payment_done_00048));
                            }
                            eVar2.d();
                            View view15 = eVar2.getView();
                            if (!(view15 == null || (textView8 = (TextView) view15.findViewById(R.id.tv_status_desc)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(textView8);
                            }
                            eVar2.g();
                            eVar2.h();
                            net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                            net.one97.paytm.p2mNewDesign.h.a.a("success");
                        } else if (p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "4", true) || p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "8", true)) {
                            eVar2.l = false;
                            eVar2.a("MLV_ERROR", (String) null);
                            View view16 = eVar2.getView();
                            if (!(view16 == null || (relativeLayout3 = (RelativeLayout) view16.findViewById(R.id.resend_confirmation_payment)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(relativeLayout3);
                            }
                        } else if (p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "1", true) || p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "3", true) || p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "5", true) || p.a(String.valueOf(myOrdersAPIResponse.getOrderStatus()), "6", true)) {
                            eVar2.l = true;
                            View view17 = eVar2.getView();
                            if (!(view17 == null || (textView7 = (TextView) view17.findViewById(R.id.tv_status_msg)) == null)) {
                                textView7.setText(eVar2.getString(R.string.payment_pending));
                            }
                            View view18 = eVar2.getView();
                            if (!(view18 == null || (textView6 = (TextView) view18.findViewById(R.id.tv_status_msg)) == null)) {
                                Activity activity3 = eVar2.f51099f;
                                if (activity3 == null) {
                                    k.a("mActivity");
                                }
                                textView6.setTextColor(androidx.core.content.b.c(activity3, R.color.color_ffa400));
                            }
                            View view19 = eVar2.getView();
                            if (!(view19 == null || (textView5 = (TextView) view19.findViewById(R.id.tv_status_desc)) == null)) {
                                textView5.setText(eVar2.getString(R.string.payment_pending_desc_msg));
                            }
                            View view20 = eVar2.getView();
                            if (!(view20 == null || (textView4 = (TextView) view20.findViewById(R.id.tv_status_desc)) == null)) {
                                Activity activity4 = eVar2.f51099f;
                                if (activity4 == null) {
                                    k.a("mActivity");
                                }
                                textView4.setBackgroundColor(androidx.core.content.b.c(activity4, R.color.color_fdfbd3));
                            }
                            View view21 = eVar2.getView();
                            if (!(view21 == null || (textView3 = (TextView) view21.findViewById(R.id.tv_status_desc)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView3);
                            }
                            View view22 = eVar2.getView();
                            if (!(view22 == null || (imageView2 = (ImageView) view22.findViewById(R.id.ic_payment_status)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.a(imageView2);
                            }
                            View view23 = eVar2.getView();
                            if (!(view23 == null || (lottieAnimationView = (LottieAnimationView) view23.findViewById(R.id.success_animation)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(lottieAnimationView);
                            }
                            View view24 = eVar2.getView();
                            if (!(view24 == null || (imageView = (ImageView) view24.findViewById(R.id.ic_payment_status)) == null)) {
                                Activity activity5 = eVar2.f51099f;
                                if (activity5 == null) {
                                    k.a("mActivity");
                                }
                                imageView.setBackground(androidx.core.content.b.a((Context) activity5, R.drawable.ic_pending_copy));
                            }
                            View view25 = eVar2.getView();
                            if (!(view25 == null || (relativeLayout4 = (RelativeLayout) view25.findViewById(R.id.resend_confirmation_payment)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(relativeLayout4);
                            }
                            if (!eVar2.l || eVar2.m >= 3) {
                                View view26 = eVar2.getView();
                                if (!(view26 == null || (walletCircularProgressBar = (WalletCircularProgressBar) view26.findViewById(R.id.pb_pending)) == null)) {
                                    net.one97.paytm.wallet.rateMerchant.utils.b.b(walletCircularProgressBar);
                                }
                            } else {
                                View view27 = eVar2.getView();
                                if (!(view27 == null || (walletCircularProgressBar2 = (WalletCircularProgressBar) view27.findViewById(R.id.pb_pending)) == null)) {
                                    net.one97.paytm.wallet.rateMerchant.utils.b.a(walletCircularProgressBar2);
                                }
                            }
                            net.one97.paytm.p2mNewDesign.h.a aVar2 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                            net.one97.paytm.p2mNewDesign.h.a.a(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
                            if (!eVar2.l || eVar2.m >= 3) {
                                eVar2.l = false;
                            } else {
                                eVar2.m++;
                                int i2 = eVar2.m;
                                if (i2 == 1) {
                                    eVar2.n = 1000;
                                } else if (i2 == 2) {
                                    eVar2.n = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
                                } else if (i2 == 3) {
                                    eVar2.n = 4000;
                                }
                                eVar2.o = new Handler();
                                eVar2.p = new e.f(eVar2);
                                Runnable runnable = eVar2.p;
                                if (!(runnable == null || (handler = eVar2.o) == null)) {
                                    handler.postDelayed(runnable, (long) eVar2.n);
                                }
                            }
                        }
                        eVar2.c(myOrdersAPIResponse.getId());
                        View view28 = eVar2.getView();
                        if (!(view28 == null || (textView2 = (TextView) view28.findViewById(R.id.tv_date)) == null)) {
                            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView2);
                        }
                        String createdAt = myOrdersAPIResponse.getCreatedAt();
                        if (createdAt != null) {
                            try {
                                net.one97.paytm.p2mNewDesign.h.a aVar3 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                                long a2 = net.one97.paytm.p2mNewDesign.h.a.a(createdAt, "yyyy-MM-dd'T'HH:mm:ss");
                                net.one97.paytm.p2mNewDesign.h.a aVar4 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                                str2 = net.one97.paytm.p2mNewDesign.h.a.a(a2 + 19800000, "dd MMM yyyy, hh:mm a");
                            } catch (ParseException unused) {
                                str2 = com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy");
                            }
                            View view29 = eVar2.getView();
                            if (!(view29 == null || (textView = (TextView) view29.findViewById(R.id.tv_date)) == null)) {
                                textView.setText(str2);
                            }
                        }
                        e.a(this.f51290a, (MyOrdersAPIResponse) fVar.f55797b);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e a(String str, String str2, String str3, String str4, String str5) {
            k.c(str, "orderId");
            k.c(str2, "myOrdersAPIUrl");
            k.c(str3, "mlvMerchantName");
            k.c(str5, "provider");
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString("orderId", str);
            bundle.putString("myOrdersAPIUrl", str2);
            bundle.putString("mlvMerchantName", str3);
            bundle.putString("mlvAmount", str4);
            bundle.putString("provider", str5);
            eVar.setArguments(bundle);
            return eVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f51284c = arguments.getString("orderId");
            this.f51285d = arguments.getString("myOrdersAPIUrl");
            this.f51286e = arguments.getString("mlvMerchantName");
            this.f51287f = arguments.getString("mlvAmount");
            this.f51288g = arguments.getString("provider");
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            Application application = activity.getApplication();
            k.a((Object) application, "it.application");
            ai a2 = am.a(activity, (al.b) new g(application)).a(f.class);
            k.a((Object) a2, "ViewModelProviders.of((i…entViewModel::class.java]");
            this.f51283b = (f) a2;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mlv_post_payment_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View findViewById;
        RelativeLayout relativeLayout;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (getParentFragment() instanceof d) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
            } else if (((d) parentFragment).isAdded()) {
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null) {
                    ((d) parentFragment2).b();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
                }
            }
        } else if (getParentFragment() instanceof net.one97.paytm.p2mNewDesign.d.e) {
            Fragment parentFragment3 = getParentFragment();
            if (parentFragment3 == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
            } else if (((net.one97.paytm.p2mNewDesign.d.e) parentFragment3).isAdded()) {
                Fragment parentFragment4 = getParentFragment();
                if (parentFragment4 != null) {
                    net.one97.paytm.p2mNewDesign.d.e eVar = (net.one97.paytm.p2mNewDesign.d.e) parentFragment4;
                    View view2 = eVar.getView();
                    if (!(view2 == null || (relativeLayout = (RelativeLayout) view2.findViewById(R.id.main_layout)) == null)) {
                        net.one97.paytm.wallet.rateMerchant.utils.b.b(relativeLayout);
                    }
                    View view3 = eVar.getView();
                    if (!(view3 == null || (findViewById = view3.findViewById(R.id.mlv_post_payment_shimmer)) == null)) {
                        net.one97.paytm.wallet.rateMerchant.utils.b.a(findViewById);
                    }
                    View view4 = eVar.getView();
                    View findViewById2 = view4 != null ? view4.findViewById(R.id.mlv_post_payment_shimmer) : null;
                    if (findViewById2 != null) {
                        ((ShimmerFrameLayout) findViewById2).a();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.utils.ShimmerFrameLayout");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
                }
            }
        }
        a(false);
    }

    public final void a(boolean z) {
        f fVar = this.f51283b;
        if (fVar == null) {
            k.a("mlvPostPaymentFragmentViewModel");
        }
        fVar.a(this.f51284c, this.f51285d, z).observeForever(new b(this));
    }

    public static final /* synthetic */ void a(e eVar) {
        View view;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        View findViewById;
        if (eVar.getParentFragment() instanceof d) {
            Fragment parentFragment = eVar.getParentFragment();
            if (parentFragment == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
            } else if (((d) parentFragment).isAdded()) {
                Fragment parentFragment2 = eVar.getParentFragment();
                if (parentFragment2 != null) {
                    ((d) parentFragment2).c();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragment");
            }
        } else if (eVar.getParentFragment() instanceof net.one97.paytm.p2mNewDesign.d.e) {
            Fragment parentFragment3 = eVar.getParentFragment();
            if (parentFragment3 == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
            } else if (((net.one97.paytm.p2mNewDesign.d.e) parentFragment3).isAdded()) {
                Fragment parentFragment4 = eVar.getParentFragment();
                if (parentFragment4 != null) {
                    net.one97.paytm.p2mNewDesign.d.e eVar2 = (net.one97.paytm.p2mNewDesign.d.e) parentFragment4;
                    View view2 = eVar2.getView();
                    View view3 = null;
                    if ((view2 != null ? (RelativeLayout) view2.findViewById(R.id.main_layout) : null) != null && (view = eVar2.getView()) != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.main_layout)) != null && relativeLayout.getVisibility() == 8) {
                        View view4 = eVar2.getView();
                        if (view4 != null) {
                            view3 = view4.findViewById(R.id.mlv_post_payment_shimmer);
                        }
                        if (view3 != null) {
                            ((ShimmerFrameLayout) view3).b();
                            View view5 = eVar2.getView();
                            if (!(view5 == null || (findViewById = view5.findViewById(R.id.mlv_post_payment_shimmer)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.b(findViewById);
                            }
                            View view6 = eVar2.getView();
                            if (view6 != null && (relativeLayout2 = (RelativeLayout) view6.findViewById(R.id.main_layout)) != null) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.a(relativeLayout2);
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.utils.ShimmerFrameLayout");
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.fragment.FJRP2MPostPaymentFragmentV2");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:213:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x04c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.p2mNewDesign.g.e r14, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MyOrdersAPIResponse r15) {
        /*
            r0 = 0
            if (r15 == 0) goto L_0x0008
            java.lang.Integer r1 = r15.getOrderStatus()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            r2 = 8
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            int r1 = r1.intValue()
            r3 = 4
            if (r1 == r3) goto L_0x04d8
        L_0x0015:
            if (r15 == 0) goto L_0x001c
            java.lang.Integer r1 = r15.getOrderStatus()
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            if (r1 != 0) goto L_0x0020
            goto L_0x0028
        L_0x0020:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x0028
            goto L_0x04d8
        L_0x0028:
            r1 = 0
            if (r15 == 0) goto L_0x003e
            java.util.List r3 = r15.getPayments()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment r3 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment) r3
            if (r3 == 0) goto L_0x003e
            java.lang.String r3 = r3.getMerchantName()
            goto L_0x003f
        L_0x003e:
            r3 = r0
        L_0x003f:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0052
            int r5 = net.one97.paytm.wallet.R.id.lytMLVContainer
            android.view.View r4 = r4.findViewById(r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0052
            r4.setVisibility(r1)
        L_0x0052:
            if (r15 == 0) goto L_0x0067
            java.util.List r4 = r15.getPayments()
            if (r4 == 0) goto L_0x0067
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment r4 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment) r4
            if (r4 == 0) goto L_0x0067
            java.lang.Integer r4 = r4.getKind()
            goto L_0x0068
        L_0x0067:
            r4 = r0
        L_0x0068:
            java.lang.String r5 = "₹"
            r6 = 1
            java.lang.String r7 = "mLoyal"
            if (r4 != 0) goto L_0x0072
            goto L_0x0264
        L_0x0072:
            int r4 = r4.intValue()
            if (r4 != r6) goto L_0x0264
            java.lang.Double r4 = r15.getDiscountAmount()
            if (r4 != 0) goto L_0x0081
            kotlin.g.b.k.a()
        L_0x0081:
            double r8 = r4.doubleValue()
            r10 = 0
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0251
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x009e
            int r8 = net.one97.paytm.wallet.R.id.lyt_container1
            android.view.View r4 = r4.findViewById(r8)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x009e
            r4.setVisibility(r1)
        L_0x009e:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x00c7
            int r8 = net.one97.paytm.wallet.R.id.tvTotalOrderAmount
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00c7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.Double r9 = r15.getSubtotal()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
        L_0x00c7:
            if (r15 == 0) goto L_0x00dc
            java.util.List r4 = r15.getPayments()
            if (r4 == 0) goto L_0x00dc
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment r4 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment) r4
            if (r4 == 0) goto L_0x00dc
            java.lang.String r4 = r4.getPaymentMethod()
            goto L_0x00dd
        L_0x00dc:
            r4 = r0
        L_0x00dd:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x014c
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x011e
            int r8 = net.one97.paytm.wallet.R.id.tvPaidUsing
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x011e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Paid using "
            r8.<init>(r9)
            if (r15 == 0) goto L_0x0111
            java.util.List r9 = r15.getPayments()
            if (r9 == 0) goto L_0x0111
            java.lang.Object r9 = r9.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment r9 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment) r9
            if (r9 == 0) goto L_0x0111
            java.lang.String r9 = r9.getPaymentMethod()
            goto L_0x0112
        L_0x0111:
            r9 = r0
        L_0x0112:
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
        L_0x011e:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0172
            int r8 = net.one97.paytm.wallet.R.id.tvAmountPaidByOtherPaymode
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0172
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            if (r15 == 0) goto L_0x013a
            java.lang.Double r9 = r15.getGrandtotal()
            goto L_0x013b
        L_0x013a:
            r9 = r0
        L_0x013b:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            goto L_0x0172
        L_0x014c:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x015f
            int r8 = net.one97.paytm.wallet.R.id.tvPaidUsing
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x015f
            r4.setVisibility(r2)
        L_0x015f:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0172
            int r8 = net.one97.paytm.wallet.R.id.tvAmountPaidByOtherPaymode
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0172
            r4.setVisibility(r2)
        L_0x0172:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r8 = " Points Used"
            java.lang.String r9 = " Cashback Used"
            if (r4 != 0) goto L_0x01bc
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x01fc
            int r10 = net.one97.paytm.wallet.R.id.tvMerchantNameCashbackRedeemed
            android.view.View r4 = r4.findViewById(r10)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x01fc
            java.lang.String r10 = r14.f51288g
            boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r7, (boolean) r1)
            if (r10 == 0) goto L_0x01a7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            goto L_0x01b6
        L_0x01a7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L_0x01b6:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            goto L_0x01fc
        L_0x01bc:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x01fc
            int r10 = net.one97.paytm.wallet.R.id.tvMerchantNameCashbackRedeemed
            android.view.View r4 = r4.findViewById(r10)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x01fc
            java.lang.String r10 = r14.f51288g
            boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r7, (boolean) r1)
            if (r10 == 0) goto L_0x01e6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r14.f51286e
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            goto L_0x01f7
        L_0x01e6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r14.f51286e
            r8.append(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L_0x01f7:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
        L_0x01fc:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0223
            int r8 = net.one97.paytm.wallet.R.id.tvCashbackRedeemed
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0223
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "-₹"
            r8.<init>(r9)
            java.lang.Double r9 = r15.getDiscountAmount()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
        L_0x0223:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0264
            int r8 = net.one97.paytm.wallet.R.id.tvEffectiveOrderAmount
            android.view.View r4 = r4.findViewById(r8)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0264
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            if (r15 == 0) goto L_0x023f
            java.lang.Double r9 = r15.getGrandtotal()
            goto L_0x0240
        L_0x023f:
            r9 = r0
        L_0x0240:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            goto L_0x0264
        L_0x0251:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0264
            int r8 = net.one97.paytm.wallet.R.id.lyt_container1
            android.view.View r4 = r4.findViewById(r8)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0264
            r4.setVisibility(r2)
        L_0x0264:
            java.util.List r4 = r15.getItems()
            java.lang.String r8 = " Points Details"
            java.lang.String r9 = " Cashback Details"
            if (r4 == 0) goto L_0x03e8
            if (r15 == 0) goto L_0x027d
            java.util.List r4 = r15.getItems()
            if (r4 == 0) goto L_0x027d
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item r4 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item) r4
            goto L_0x027e
        L_0x027d:
            r4 = r0
        L_0x027e:
            if (r4 == 0) goto L_0x03e8
            if (r15 == 0) goto L_0x0295
            java.util.List r4 = r15.getItems()
            if (r4 == 0) goto L_0x0295
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item r4 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item) r4
            if (r4 == 0) goto L_0x0295
            java.util.List r4 = r4.getGratification()
            goto L_0x0296
        L_0x0295:
            r4 = r0
        L_0x0296:
            if (r4 == 0) goto L_0x03e8
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x02ab
            int r10 = net.one97.paytm.wallet.R.id.lyt_container2
            android.view.View r4 = r4.findViewById(r10)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x02ab
            r4.setVisibility(r1)
        L_0x02ab:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x02ed
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0329
            int r10 = net.one97.paytm.wallet.R.id.tvMerchantNameLoyaltyCash
            android.view.View r4 = r4.findViewById(r10)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0329
            java.lang.String r10 = r14.f51288g
            boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r7, (boolean) r1)
            if (r10 == 0) goto L_0x02d8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r3)
            r10.append(r8)
            goto L_0x02e3
        L_0x02d8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r3)
            r10.append(r9)
        L_0x02e3:
            java.lang.String r10 = r10.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r4.setText(r10)
            goto L_0x0329
        L_0x02ed:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x0329
            int r10 = net.one97.paytm.wallet.R.id.tvMerchantNameLoyaltyCash
            android.view.View r4 = r4.findViewById(r10)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0329
            java.lang.String r10 = r14.f51288g
            boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r7, (boolean) r1)
            if (r10 == 0) goto L_0x0313
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r14.f51286e
            r10.append(r11)
            r10.append(r8)
            goto L_0x0320
        L_0x0313:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r14.f51286e
            r10.append(r11)
            r10.append(r9)
        L_0x0320:
            java.lang.String r10 = r10.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r4.setText(r10)
        L_0x0329:
            java.lang.String r4 = r14.f51288g
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r7, (boolean) r1)
            java.lang.String r10 = "java.lang.String.format(format, *args)"
            java.lang.String r11 = "resources.getString(R.st…_earned_for_this_payment)"
            if (r4 == 0) goto L_0x036b
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x03a0
            int r12 = net.one97.paytm.wallet.R.id.tvCashbackEarnedDetail
            android.view.View r4 = r4.findViewById(r12)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x03a0
            kotlin.g.b.aa r12 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r12 = r14.getResources()
            int r13 = net.one97.paytm.wallet.R.string.mlv_cashback_earned_for_this_payment
            java.lang.String r12 = r12.getString(r13)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.String r13 = "Points"
            r11[r1] = r13
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = java.lang.String.format(r12, r6)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            goto L_0x03a0
        L_0x036b:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x03a0
            int r12 = net.one97.paytm.wallet.R.id.tvCashbackEarnedDetail
            android.view.View r4 = r4.findViewById(r12)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x03a0
            kotlin.g.b.aa r12 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r12 = r14.getResources()
            int r13 = net.one97.paytm.wallet.R.string.mlv_cashback_earned_for_this_payment
            java.lang.String r12 = r12.getString(r13)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.String r13 = "Cashback"
            r11[r1] = r13
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = java.lang.String.format(r12, r6)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
        L_0x03a0:
            android.view.View r4 = r14.getView()
            if (r4 == 0) goto L_0x03fb
            int r6 = net.one97.paytm.wallet.R.id.tvCashbackEarned
            android.view.View r4 = r4.findViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x03fb
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            if (r15 == 0) goto L_0x03d7
            java.util.List r5 = r15.getItems()
            if (r5 == 0) goto L_0x03d7
            java.lang.Object r5 = r5.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item r5 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item) r5
            if (r5 == 0) goto L_0x03d7
            java.util.List r5 = r5.getGratification()
            if (r5 == 0) goto L_0x03d7
            java.lang.Object r5 = r5.get(r1)
            net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Gratification r5 = (net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Gratification) r5
            if (r5 == 0) goto L_0x03d7
            java.lang.Double r0 = r5.getAmount()
        L_0x03d7:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            goto L_0x03fb
        L_0x03e8:
            android.view.View r0 = r14.getView()
            if (r0 == 0) goto L_0x03fb
            int r4 = net.one97.paytm.wallet.R.id.lyt_container2
            android.view.View r0 = r0.findViewById(r4)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x03fb
            r0.setVisibility(r2)
        L_0x03fb:
            java.lang.String r0 = r15.getPosTxnRequired()
            if (r0 == 0) goto L_0x04c4
            java.lang.String r0 = r15.getPosTxnRequired()
            java.lang.String r4 = "1"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x04c4
            java.lang.String r0 = r15.getPosTxnMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04c4
            android.view.View r0 = r14.getView()
            if (r0 == 0) goto L_0x042c
            int r2 = net.one97.paytm.wallet.R.id.lyt_container3
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x042c
            r0.setVisibility(r1)
        L_0x042c:
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x046e
            android.view.View r0 = r14.getView()
            if (r0 == 0) goto L_0x04aa
            int r2 = net.one97.paytm.wallet.R.id.tvMerchantNameMLoyal
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x04aa
            java.lang.String r2 = r14.f51288g
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r1)
            if (r1 == 0) goto L_0x0459
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r8)
            goto L_0x0464
        L_0x0459:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r9)
        L_0x0464:
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x04aa
        L_0x046e:
            android.view.View r0 = r14.getView()
            if (r0 == 0) goto L_0x04aa
            int r2 = net.one97.paytm.wallet.R.id.tvMerchantNameMLoyal
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x04aa
            java.lang.String r2 = r14.f51288g
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r1)
            if (r1 == 0) goto L_0x0494
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r14.f51286e
            r1.append(r2)
            r1.append(r8)
            goto L_0x04a1
        L_0x0494:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r14.f51286e
            r1.append(r2)
            r1.append(r9)
        L_0x04a1:
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x04aa:
            android.view.View r14 = r14.getView()
            if (r14 == 0) goto L_0x04c3
            int r0 = net.one97.paytm.wallet.R.id.posTransactionDetailMessage
            android.view.View r14 = r14.findViewById(r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x04c3
            java.lang.String r15 = r15.getPosTxnMessage()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r14.setText(r15)
        L_0x04c3:
            return
        L_0x04c4:
            android.view.View r14 = r14.getView()
            if (r14 == 0) goto L_0x04d7
            int r15 = net.one97.paytm.wallet.R.id.lyt_container3
            android.view.View r14 = r14.findViewById(r15)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x04d7
            r14.setVisibility(r2)
        L_0x04d7:
            return
        L_0x04d8:
            android.view.View r14 = r14.getView()
            if (r14 == 0) goto L_0x04eb
            int r15 = net.one97.paytm.wallet.R.id.lytMLVContainer
            android.view.View r14 = r14.findViewById(r15)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x04eb
            r14.setVisibility(r2)
        L_0x04eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.g.e.a(net.one97.paytm.p2mNewDesign.g.e, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MyOrdersAPIResponse):void");
    }

    public static final /* synthetic */ void c(e eVar) {
        LinearLayout linearLayout;
        View view = eVar.getView();
        if (view != null && (linearLayout = (LinearLayout) view.findViewById(R.id.lytMLVContainer)) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f51289h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
