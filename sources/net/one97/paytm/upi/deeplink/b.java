package net.one97.paytm.upi.deeplink;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.deeplink.a;
import net.one97.paytm.upi.deeplink.c;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends f implements View.OnClickListener, a.C1344a, c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f66686a = "UPIDeeplinkBottomSheetFragment";

    /* renamed from: b  reason: collision with root package name */
    public Uri f66687b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66688c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f66689d;

    /* renamed from: e  reason: collision with root package name */
    int f66690e;

    /* renamed from: f  reason: collision with root package name */
    a f66691f;

    /* renamed from: g  reason: collision with root package name */
    private d f66692g;

    /* renamed from: h  reason: collision with root package name */
    private LottieAnimationView f66693h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f66694i;
    private HashMap j;

    public interface a {
        void a();

        void a(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse);
    }

    private View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.b bVar = this;
        FragmentActivity activity = getActivity();
        Context context = null;
        if ((activity != null ? activity.getApplicationContext() : null) == null) {
            k.a();
        }
        net.one97.paytm.upi.profile.b.b a2 = g.a();
        k.a((Object) a2, "Injection.provideUpiProf…ty?.applicationContext!!)");
        FragmentActivity activity2 = getActivity();
        if ((activity2 != null ? activity2.getApplicationContext() : null) == null) {
            k.a();
        }
        FragmentActivity activity3 = getActivity();
        if ((activity3 != null ? activity3.getApplicationContext() : null) == null) {
            k.a();
        }
        net.one97.paytm.upi.registration.b.a.b a3 = g.a(g.a((a.C1347a) null));
        k.a((Object) a3, "Injection.provideUpiRegi…xt!!, null)\n            )");
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            context = activity4.getApplicationContext();
        }
        if (context == null) {
            k.a();
        }
        net.one97.paytm.upi.requestmoney.b.a.b c2 = g.c();
        k.a((Object) c2, "Injection.provideUpiRequ…ty?.applicationContext!!)");
        this.f66692g = new d(bVar, a2, a3, c2);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_deeplink_bottomsheet, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…msheet, container, false)");
        this.f66693h = (LottieAnimationView) inflate.findViewById(R.id.upi_loader);
        View findViewById = inflate.findViewById(R.id.ok);
        if (findViewById != null) {
            View.OnClickListener onClickListener = this;
            ((Button) findViewById).setOnClickListener(onClickListener);
            View findViewById2 = inflate.findViewById(R.id.crossIcon);
            if (findViewById2 != null) {
                ((ImageView) findViewById2).setOnClickListener(onClickListener);
                return inflate;
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new u("null cannot be cast to non-null type android.widget.Button");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0137, code lost:
        r1 = r1.getQueryParameter("pa");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r26) {
        /*
            r25 = this;
            r0 = r25
            super.onActivityCreated(r26)
            boolean r1 = r0.f66688c
            if (r1 != 0) goto L_0x002b
            net.one97.paytm.upi.deeplink.d r1 = r0.f66692g
            if (r1 == 0) goto L_0x012d
            net.one97.paytm.upi.deeplink.c$b r2 = r1.f66699a
            if (r2 == 0) goto L_0x0014
            r2.a()
        L_0x0014:
            net.one97.paytm.upi.registration.b.a.b r2 = r1.f66700b
            if (r2 != 0) goto L_0x001b
            kotlin.g.b.k.a()
        L_0x001b:
            net.one97.paytm.upi.deeplink.d$a r3 = new net.one97.paytm.upi.deeplink.d$a
            r3.<init>(r1)
            net.one97.paytm.upi.registration.b.a.a$a r3 = (net.one97.paytm.upi.registration.b.a.a.C1389a) r3
            java.lang.String r4 = r1.f66701c
            java.lang.String r1 = r1.f66702d
            r2.c(r3, r4, r1)
            goto L_0x012d
        L_0x002b:
            android.os.Bundle r1 = r0.f66689d
            if (r1 == 0) goto L_0x011c
            java.lang.String r3 = "extra_key_ref_id"
            java.lang.String r4 = r1.getString(r3)
            r0.f66694i = r4
            net.one97.paytm.upi.deeplink.a r4 = new net.one97.paytm.upi.deeplink.a
            r5 = r0
            net.one97.paytm.upi.deeplink.a$a r5 = (net.one97.paytm.upi.deeplink.a.C1344a) r5
            r4.<init>(r1, r5)
            androidx.fragment.app.FragmentActivity r1 = r25.getActivity()
            if (r1 != 0) goto L_0x0048
            kotlin.g.b.k.a()
        L_0x0048:
            java.lang.String r5 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r15 = ""
            java.lang.String r5 = "context"
            kotlin.g.b.k.c(r1, r5)
            java.lang.String r5 = "screenName"
            kotlin.g.b.k.c(r15, r5)
            net.one97.paytm.upi.deeplink.a$a r5 = r4.f66681c
            r6 = 1
            r5.a((boolean) r6)
            android.os.Bundle r5 = r4.f66680b
            java.lang.String r6 = "user_upi_details"
            java.io.Serializable r5 = r5.getSerializable(r6)
            if (r5 == 0) goto L_0x0114
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r5
            java.lang.String r5 = r5.getVirtualAddress()
            java.lang.String r7 = "(bundle.getSerializable(…Bank).getVirtualAddress()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            if (r5 == 0) goto L_0x010c
            java.lang.String r11 = r5.toLowerCase()
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            net.one97.paytm.upi.profile.b.b.a r5 = net.one97.paytm.upi.profile.b.b.a.a((android.content.Context) r1)
            net.one97.paytm.upi.deeplink.a$b r7 = new net.one97.paytm.upi.deeplink.a$b
            r7.<init>(r4, r1)
            r1 = r7
            net.one97.paytm.upi.profile.b.a$a r1 = (net.one97.paytm.upi.profile.b.a.C1382a) r1
            android.os.Bundle r7 = r4.f66680b
            java.lang.String r8 = "extra_key_deeplink_txn_id"
            java.lang.String r7 = r7.getString(r8)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r9 = "extra_key_mpin"
            java.lang.String r9 = r8.getString(r9)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r10 = "payee_vpa"
            java.lang.String r10 = r8.getString(r10)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r12 = "amount"
            java.lang.String r12 = r8.getString(r12)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r13 = "extra_key_comments"
            java.lang.String r13 = r8.getString(r13)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r14 = "payee_name"
            java.lang.String r14 = r8.getString(r14)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r2 = "extra_key_mcc"
            java.lang.String r2 = r8.getString(r2)
            android.os.Bundle r8 = r4.f66680b
            java.lang.String r16 = r8.getString(r3)
            android.os.Bundle r3 = r4.f66680b
            java.lang.String r8 = "extra_key_ref_url"
            java.lang.String r17 = r3.getString(r8)
            android.os.Bundle r3 = r4.f66680b
            java.io.Serializable r3 = r3.getSerializable(r6)
            boolean r6 = r3 instanceof net.one97.paytm.upi.common.upi.UpiProfileDefaultBank
            if (r6 != 0) goto L_0x00de
            r3 = 0
        L_0x00de:
            r18 = r3
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r18 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r18
            android.os.Bundle r3 = r4.f66680b
            java.lang.String r6 = "extra_key_upi_min_amount"
            java.lang.String r19 = r3.getString(r6)
            r20 = 1
            android.os.Bundle r3 = r4.f66680b
            java.lang.String r4 = "key_intent_params"
            java.io.Serializable r3 = r3.getSerializable(r4)
            boolean r4 = r3 instanceof net.one97.paytm.upi.common.upi.CommonPayParams
            if (r4 != 0) goto L_0x00f9
            r3 = 0
        L_0x00f9:
            r22 = r3
            net.one97.paytm.upi.common.upi.CommonPayParams r22 = (net.one97.paytm.upi.common.upi.CommonPayParams) r22
            java.lang.String r8 = "UPICommonPayHelper"
            java.lang.String r23 = ""
            java.lang.String r24 = ""
            r6 = r1
            r1 = r15
            r15 = r2
            r21 = r1
            r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x012d
        L_0x010c:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r2)
            throw r1
        L_0x0114:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiProfileDefaultBank"
            r1.<init>(r2)
            throw r1
        L_0x011c:
            r25.f()
            r1 = 0
            r2 = 0
            r0.a(r2, r1)
            androidx.fragment.app.FragmentActivity r1 = r25.getActivity()
            if (r1 == 0) goto L_0x012d
            r1.finish()
        L_0x012d:
            android.content.Context r2 = r25.requireContext()
            android.net.Uri r1 = r0.f66687b
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0142
            java.lang.String r4 = "pa"
            java.lang.String r1 = r1.getQueryParameter(r4)
            if (r1 != 0) goto L_0x0140
            goto L_0x0142
        L_0x0140:
            r8 = r1
            goto L_0x0143
        L_0x0142:
            r8 = r3
        L_0x0143:
            android.net.Uri r1 = r0.f66687b
            if (r1 == 0) goto L_0x0152
            java.lang.String r4 = "am"
            java.lang.String r1 = r1.getQueryParameter(r4)
            if (r1 != 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r9 = r1
            goto L_0x0153
        L_0x0152:
            r9 = r3
        L_0x0153:
            java.lang.String r3 = "upi_intent_pay_v1"
            java.lang.String r4 = "screen_open"
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r10 = "/mt_post-transaction_bottom_sheet"
            java.lang.String r11 = ""
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.deeplink.b.onActivityCreated(android.os.Bundle):void");
    }

    public final void a() {
        AnimationFactory.startWalletLoader(this.f66693h);
    }

    public final void b() {
        if (isAdded()) {
            View a2 = a(R.id.loader);
            if (a2 != null) {
                a2.setVisibility(8);
            }
            TextView textView = (TextView) a(R.id.tv_processing);
            if (textView != null) {
                textView.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.upi_loader);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
            AnimationFactory.stopWalletLoader(this.f66693h);
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        k.c(upiCustomVolleyError, "error");
        if (isAdded()) {
            View a2 = a(R.id.loader);
            if (a2 != null) {
                a2.setVisibility(8);
            }
            TextView textView = (TextView) a(R.id.tv_processing);
            if (textView != null) {
                textView.setVisibility(8);
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.errorLayout);
            k.a((Object) relativeLayout, "errorLayout");
            relativeLayout.setVisibility(8);
            e();
        }
    }

    public final void a(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
        k.c(upiAvailabilityResponse, "upiResponse");
        if (isAdded()) {
            String string = getString(R.string.upi_error_not_upi_user_title);
            k.a((Object) string, "getString(R.string.upi_error_not_upi_user_title)");
            String string2 = getString(R.string.upi_error_not_upi_user_message);
            k.a((Object) string2, "getString(R.string.upi_error_not_upi_user_message)");
            String string3 = getString(R.string.upi_error_not_upi_user_tip);
            k.a((Object) string3, "getString(R.string.upi_error_not_upi_user_tip)");
            a(upiAvailabilityResponse, string, string2, string3);
        }
    }

    public final void b(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
        k.c(upiAvailabilityResponse, "upiResponse");
        if (isAdded()) {
            String string = getString(R.string.upi_error_no_bank_title);
            k.a((Object) string, "getString(R.string.upi_error_no_bank_title)");
            String string2 = getString(R.string.upi_error_no_bank_message);
            k.a((Object) string2, "getString(R.string.upi_error_no_bank_message)");
            String string3 = getString(R.string.upi_error_not_upi_user_tip);
            k.a((Object) string3, "getString(R.string.upi_error_not_upi_user_tip)");
            a(upiAvailabilityResponse, string, string2, string3);
        }
    }

    public final void c(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
        k.c(upiAvailabilityResponse, "upiResponse");
        if (isAdded()) {
            String string = getString(R.string.upi_error_no_mpin_title);
            k.a((Object) string, "getString(R.string.upi_error_no_mpin_title)");
            String string2 = getString(R.string.upi_error_no_mpin_message);
            k.a((Object) string2, "getString(R.string.upi_error_no_mpin_message)");
            String string3 = getString(R.string.upi_error_no_mpin_tip);
            k.a((Object) string3, "getString(R.string.upi_error_no_mpin_tip)");
            a(upiAvailabilityResponse, string, string2, string3);
        }
    }

    public final void onClick(View view) {
        FragmentActivity activity;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ok;
        if (valueOf != null && valueOf.intValue() == i2) {
            a((BaseUpiResponse) null, false);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        int i3 = R.id.crossIcon;
        if (valueOf != null && valueOf.intValue() == i3 && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    private final void a(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse, String str, String str2, String str3) {
        a aVar = this.f66691f;
        if (aVar != null) {
            aVar.a(upiAvailabilityResponse);
        }
        AnimationFactory.stopWalletLoader(this.f66693h);
        TextView textView = (TextView) a(R.id.title);
        k.a((Object) textView, "title");
        textView.setText(str);
        TextView textView2 = (TextView) a(R.id.message);
        k.a((Object) textView2, "message");
        textView2.setText(str2);
        TextView textView3 = (TextView) a(R.id.tip);
        k.a((Object) textView3, "tip");
        textView3.setText(str3);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.networkErrorLayout);
        k.a((Object) relativeLayout, "networkErrorLayout");
        relativeLayout.setVisibility(8);
        ImageView imageView = (ImageView) a(R.id.crossIcon);
        k.a((Object) imageView, "crossIcon");
        imageView.setVisibility(8);
        View a2 = a(R.id.loader);
        k.a((Object) a2, "loader");
        a2.setVisibility(8);
        TextView textView4 = (TextView) a(R.id.tv_processing);
        k.a((Object) textView4, "tv_processing");
        textView4.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.errorLayout);
        k.a((Object) relativeLayout2, "errorLayout");
        relativeLayout2.setVisibility(0);
    }

    public final void c() {
        if (isAdded()) {
            AnimationFactory.stopWalletLoader(this.f66693h);
            a aVar = this.f66691f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void d() {
        if (isAdded()) {
            TextView textView = (TextView) a(R.id.nwErrorTitle);
            if (textView != null) {
                textView.setText(getString(R.string.no_connection));
            }
            TextView textView2 = (TextView) a(R.id.nwErrorMessage);
            if (textView2 != null) {
                textView2.setText(getString(R.string.no_internet_message));
            }
            ImageView imageView = (ImageView) a(R.id.nwErrorImage);
            if (imageView != null) {
                Context context = getContext();
                imageView.setImageDrawable(context != null ? androidx.core.content.b.a(context, R.drawable.ill_no_internet) : null);
            }
            ImageView imageView2 = (ImageView) a(R.id.crossIcon);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.networkErrorLayout);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public final void e() {
        if (isAdded()) {
            TextView textView = (TextView) a(R.id.nwErrorTitle);
            if (textView != null) {
                textView.setText(getString(R.string.something_went_wrong));
            }
            TextView textView2 = (TextView) a(R.id.nwErrorMessage);
            if (textView2 != null) {
                textView2.setText(getString(R.string.server_down_error_message));
            }
            ImageView imageView = (ImageView) a(R.id.nwErrorImage);
            if (imageView != null) {
                Context context = getContext();
                imageView.setImageDrawable(context != null ? androidx.core.content.b.a(context, R.drawable.upi_something_wrong) : null);
            }
            ImageView imageView2 = (ImageView) a(R.id.crossIcon);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.networkErrorLayout);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public final void d(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
        k.c(upiAvailabilityResponse, "upiResponse");
        if (isAdded()) {
            a aVar = this.f66691f;
            if (aVar != null) {
                aVar.a(upiAvailabilityResponse);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(UpiConstants.EXTRA_VPA_DATA, this.f66687b);
            Intent intent = new Intent(getContext(), DummyDeepLinkActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            a2.c().a((Fragment) this, bundle);
            f();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            setCancelable(false);
            View a2 = a(R.id.loader);
            if (a2 != null) {
                a2.setVisibility(0);
            }
            TextView textView = (TextView) a(R.id.tv_processing);
            if (textView != null) {
                textView.setVisibility(0);
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.upi_loader);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
            }
            AnimationFactory.startWalletLoader(this.f66693h);
            TextView textView2 = (TextView) a(R.id.tv_processing);
            k.a((Object) textView2, "tv_processing");
            textView2.setText(getString(R.string.upi_intent_merchant_polling_msg));
            return;
        }
        AnimationFactory.stopWalletLoader(this.f66693h);
        View a3 = a(R.id.loader);
        if (a3 != null) {
            a3.setVisibility(8);
        }
        TextView textView3 = (TextView) a(R.id.tv_processing);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a(R.id.upi_loader);
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
    }

    public final void a(BaseUpiResponse baseUpiResponse) {
        String str;
        String str2;
        String string;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue() && isResumed()) {
                setCancelable(false);
                a(false);
                TextView textView = (TextView) a(R.id.title);
                k.a((Object) textView, "title");
                textView.setText(getString(R.string.upi_paid_successfully));
                ((TextView) a(R.id.title)).setTextSize(0, getResources().getDimension(R.dimen.dimen_21sp));
                TextView textView2 = (TextView) a(R.id.title);
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                textView2.setTextColor(androidx.core.content.b.c(activity2, R.color.upi_pin_green));
                TextView textView3 = (TextView) a(R.id.message);
                k.a((Object) textView3, "message");
                textView3.setTypeface(Typeface.DEFAULT_BOLD);
                TextView textView4 = (TextView) a(R.id.message);
                k.a((Object) textView4, "message");
                int i2 = R.string.upi_for_your_order;
                Object[] objArr = new Object[1];
                Uri uri = this.f66687b;
                if (uri == null || (str = uri.getQueryParameter("am")) == null) {
                    str = "";
                }
                objArr[0] = UpiAppUtils.priceToString(str);
                textView4.setText(getString(i2, objArr));
                TextView textView5 = (TextView) a(R.id.tip);
                k.a((Object) textView5, "tip");
                textView5.setVisibility(8);
                Button button = (Button) a(R.id.ok);
                k.a((Object) button, "ok");
                button.setVisibility(8);
                ImageView imageView = (ImageView) a(R.id.status_image);
                k.a((Object) imageView, "status_image");
                imageView.setVisibility(0);
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.networkErrorLayout);
                k.a((Object) relativeLayout, "networkErrorLayout");
                relativeLayout.setVisibility(8);
                ImageView imageView2 = (ImageView) a(R.id.crossIcon);
                k.a((Object) imageView2, "crossIcon");
                imageView2.setVisibility(8);
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.errorLayout);
                k.a((Object) relativeLayout2, "errorLayout");
                relativeLayout2.setVisibility(0);
                a(baseUpiResponse, true);
                a("success");
                Context requireContext = requireContext();
                Bundle bundle = this.f66689d;
                if (bundle == null || (string = bundle.getString("payee_vpa")) == null) {
                    str2 = "";
                } else {
                    str2 = string;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, "transaction_intent_success", "", "", "", str2, "", "mt_transactionstatus", "upi");
            }
        }
    }

    public final void b(BaseUpiResponse baseUpiResponse) {
        String str;
        String str2;
        String str3;
        String string;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Serializable serializable = null;
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue() && isResumed()) {
                setCancelable(false);
                a(false);
                TextView textView = (TextView) a(R.id.title);
                k.a((Object) textView, "title");
                textView.setText(getString(R.string.upi_payment_failed));
                ((TextView) a(R.id.title)).setTextSize(0, getResources().getDimension(R.dimen.dimen_21sp));
                TextView textView2 = (TextView) a(R.id.title);
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                textView2.setTextColor(androidx.core.content.b.c(activity2, R.color.color_fd5c5c));
                TextView textView3 = (TextView) a(R.id.message);
                k.a((Object) textView3, "message");
                if (baseUpiResponse == null || (str = baseUpiResponse.getMessage()) == null) {
                    str = getString(R.string.upi_some_went_wrong);
                }
                textView3.setText(str);
                TextView textView4 = (TextView) a(R.id.tip);
                k.a((Object) textView4, "tip");
                textView4.setVisibility(8);
                ImageView imageView = (ImageView) a(R.id.status_image);
                k.a((Object) imageView, "status_image");
                imageView.setVisibility(0);
                ((ImageView) a(R.id.status_image)).setImageResource(R.drawable.upi_txn_failed);
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.networkErrorLayout);
                k.a((Object) relativeLayout, "networkErrorLayout");
                relativeLayout.setVisibility(8);
                ImageView imageView2 = (ImageView) a(R.id.crossIcon);
                k.a((Object) imageView2, "crossIcon");
                imageView2.setVisibility(8);
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.errorLayout);
                k.a((Object) relativeLayout2, "errorLayout");
                relativeLayout2.setVisibility(0);
                a(baseUpiResponse, true);
                a(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                if (baseUpiResponse != null) {
                    str2 = baseUpiResponse.getResponse();
                } else {
                    str2 = null;
                }
                Bundle bundle = this.f66689d;
                if (bundle != null) {
                    serializable = bundle.getSerializable("user_upi_details");
                }
                if (serializable != null) {
                    BankAccountDetails.BankAccount debitBank = ((UpiProfileDefaultBank) serializable).getDebitBank();
                    k.a((Object) debitBank, "(mPaymentBundle?.getSeri…ileDefaultBank).debitBank");
                    String bankName = debitBank.getBankName();
                    Context requireContext = requireContext();
                    String str4 = str2 == null ? "" : str2;
                    String str5 = bankName == null ? "" : bankName;
                    Bundle bundle2 = this.f66689d;
                    if (bundle2 == null || (string = bundle2.getString("payee_vpa")) == null) {
                        str3 = "";
                    } else {
                        str3 = string;
                    }
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, Events.Category.INTENT, "transaction_intent_failure", str4, str5, "", str3, "", "mt_transactionstatus", "upi");
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiProfileDefaultBank");
            }
        }
    }

    public final void c(BaseUpiResponse baseUpiResponse) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue() && isResumed()) {
                setCancelable(false);
                a(false);
                TextView textView = (TextView) a(R.id.title);
                k.a((Object) textView, "title");
                textView.setText(getString(R.string.upi_payment_pending));
                ((TextView) a(R.id.title)).setTextSize(0, getResources().getDimension(R.dimen.dimen_21sp));
                TextView textView2 = (TextView) a(R.id.title);
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                textView2.setTextColor(androidx.core.content.b.c(activity2, R.color.color_ffa400));
                TextView textView3 = (TextView) a(R.id.message);
                k.a((Object) textView3, "message");
                textView3.setText(getString(R.string.upi_not_able_to_verify_details));
                TextView textView4 = (TextView) a(R.id.tip);
                k.a((Object) textView4, "tip");
                textView4.setText(getString(R.string.upi_payment_pending_tip));
                ImageView imageView = (ImageView) a(R.id.status_image);
                k.a((Object) imageView, "status_image");
                imageView.setVisibility(0);
                ImageView imageView2 = (ImageView) a(R.id.status_image);
                FragmentActivity activity3 = getActivity();
                if (activity3 == null) {
                    k.a();
                }
                imageView2.setImageDrawable(androidx.core.content.b.a((Context) activity3, R.drawable.ic_pending_copy));
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.networkErrorLayout);
                k.a((Object) relativeLayout, "networkErrorLayout");
                relativeLayout.setVisibility(8);
                ImageView imageView3 = (ImageView) a(R.id.crossIcon);
                k.a((Object) imageView3, "crossIcon");
                imageView3.setVisibility(8);
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.errorLayout);
                k.a((Object) relativeLayout2, "errorLayout");
                relativeLayout2.setVisibility(0);
                a(baseUpiResponse, true);
                a(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
            }
        }
    }

    private final void a(BaseUpiResponse baseUpiResponse, boolean z) {
        String str;
        String str2;
        String str3;
        Handler handler = new Handler();
        StringBuilder sb = new StringBuilder("");
        String str4 = baseUpiResponse != null ? baseUpiResponse.isSuccess() : false ? "SUCCESS" : "FAILURE";
        StringBuilder sb2 = new StringBuilder("txnId=");
        String str5 = null;
        sb2.append(baseUpiResponse != null ? baseUpiResponse.getSeqNo() : null);
        sb.append(sb2.toString());
        if (!TextUtils.isEmpty(baseUpiResponse != null ? baseUpiResponse.getResponse() : null)) {
            StringBuilder sb3 = new StringBuilder("&responseCode=");
            sb3.append(baseUpiResponse != null ? baseUpiResponse.getResponse() : null);
            sb.append(sb3.toString());
        }
        if (!TextUtils.isEmpty(baseUpiResponse != null ? baseUpiResponse.getBankRRN() : null)) {
            StringBuilder sb4 = new StringBuilder("&ApprovalRefNo=");
            if (baseUpiResponse != null) {
                str5 = baseUpiResponse.getBankRRN();
            }
            sb4.append(str5);
            sb.append(sb4.toString());
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&Status=".concat(str4));
        }
        if (!TextUtils.isEmpty(this.f66694i)) {
            sb.append("&txnRef=" + this.f66694i);
        }
        String sb5 = sb.toString();
        k.a((Object) sb5, "result.toString()");
        if (z) {
            handler.postDelayed(new C1345b(this, str4, baseUpiResponse, sb5), 3000);
            return;
        }
        if (baseUpiResponse == null || (str = baseUpiResponse.getResponse()) == null) {
            str = "";
        }
        String str6 = this.f66694i;
        if (str6 == null) {
            str6 = "";
        }
        if (baseUpiResponse == null || (str2 = baseUpiResponse.getBankRRN()) == null) {
            str2 = "";
        }
        if (baseUpiResponse == null || (str3 = baseUpiResponse.getSeqNo()) == null) {
            str3 = "";
        }
        Intent b2 = b(str4, str, str6, str2, str3);
        b2.putExtra(Payload.RESPONSE, sb5);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, b2);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finishAndRemoveTask();
                return;
            }
            return;
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
    }

    /* renamed from: net.one97.paytm.upi.deeplink.b$b  reason: collision with other inner class name */
    static final class C1345b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f66696b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseUpiResponse f66697c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f66698d;

        C1345b(b bVar, String str, BaseUpiResponse baseUpiResponse, String str2) {
            this.f66695a = bVar;
            this.f66696b = str;
            this.f66697c = baseUpiResponse;
            this.f66698d = str2;
        }

        public final void run() {
            String str;
            String str2;
            String seqNo;
            this.f66695a.f();
            String str3 = this.f66696b;
            BaseUpiResponse baseUpiResponse = this.f66697c;
            String str4 = "";
            if (baseUpiResponse == null || (str = baseUpiResponse.getResponse()) == null) {
                str = str4;
            }
            String b2 = this.f66695a.f66694i;
            if (b2 == null) {
                b2 = str4;
            }
            BaseUpiResponse baseUpiResponse2 = this.f66697c;
            if (baseUpiResponse2 == null || (str2 = baseUpiResponse2.getBankRRN()) == null) {
                str2 = str4;
            }
            BaseUpiResponse baseUpiResponse3 = this.f66697c;
            if (!(baseUpiResponse3 == null || (seqNo = baseUpiResponse3.getSeqNo()) == null)) {
                str4 = seqNo;
            }
            Intent a2 = b.b(str3, str, b2, str2, str4);
            a2.putExtra(Payload.RESPONSE, this.f66698d);
            FragmentActivity activity = this.f66695a.getActivity();
            if (activity != null) {
                activity.setResult(-1, a2);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                FragmentActivity activity2 = this.f66695a.getActivity();
                if (activity2 != null) {
                    activity2.finishAndRemoveTask();
                    return;
                }
                return;
            }
            FragmentActivity activity3 = this.f66695a.getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue()) {
                dismissAllowingStateLoss();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.getQueryParameter("pa");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.requireContext()
            android.net.Uri r1 = r10.f66687b
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0015
            java.lang.String r3 = "pa"
            java.lang.String r1 = r1.getQueryParameter(r3)
            if (r1 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r6 = r1
            goto L_0x0016
        L_0x0015:
            r6 = r2
        L_0x0016:
            android.net.Uri r1 = r10.f66687b
            if (r1 == 0) goto L_0x0025
            java.lang.String r3 = "am"
            java.lang.String r1 = r1.getQueryParameter(r3)
            if (r1 != 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r7 = r1
            goto L_0x0026
        L_0x0025:
            r7 = r2
        L_0x0026:
            java.lang.String r1 = "upi_intent_pay_v1"
            java.lang.String r2 = "screen_open"
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r8 = "/mt_post-transaction_bottom_sheet"
            java.lang.String r9 = ""
            r3 = r11
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.deeplink.b.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static Intent b(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.putExtra("Status", str);
        intent.putExtra("responseCode", str2);
        intent.putExtra("txnRef", str3);
        intent.putExtra("ApprovalRefNo", str4);
        intent.putExtra("txnId", str5);
        return intent;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
