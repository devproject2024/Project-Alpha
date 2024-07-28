package net.one97.paytm.vipcashback.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.g;
import com.paytm.utility.q;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.g.b.k;
import kotlin.t;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModal;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseTNCModal;
import net.one97.paytm.common.entity.vipcashback.CashBackTnCModal;
import net.one97.paytm.common.entity.vipcashback.CashbackVoucher;
import net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.common.entity.vipcashback.VoucherTermsResponse;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.v2.features.cashbacklanding.model.CardOfferData;
import net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity;
import net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;
import net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity;
import net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.view.CircularImageViewCashback;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20859a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f20860b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static View f20861c;

    public static final class a {

        static final class i implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public static final i f20879a = new i();

            i() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(String str) {
            kotlin.g.b.k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            String format = new SimpleDateFormat("dd MMM yy, hh:mm aa").format(simpleDateFormat.parse(str));
            kotlin.g.b.k.a((Object) format, "SimpleDateFormat(CJRPara…     expiry\n            )");
            return format;
        }

        public static String a(long j2, String str) {
            kotlin.g.b.k.c(str, "outputFormat");
            String format = new SimpleDateFormat(str, Locale.getDefault()).format(Long.valueOf(j2));
            kotlin.g.b.k.a((Object) format, "apiFormator.format(\n    …       date\n            )");
            return format;
        }

        public static String a(String str, String str2, String str3) {
            kotlin.g.b.k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            kotlin.g.b.k.c(str2, "inputFormat");
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String format = new SimpleDateFormat(str3).format(simpleDateFormat.parse(str));
                kotlin.g.b.k.a((Object) format, "SimpleDateFormat(if (out… expiry\n                )");
                return format;
            } catch (Exception unused) {
                return "";
            }
        }

        public static String b(String str, String str2, String str3) {
            kotlin.g.b.k.c(str, "inputDate");
            kotlin.g.b.k.c(str2, "inputFormat");
            kotlin.g.b.k.c(str3, "outputFormat");
            try {
                Locale locale = new Locale(com.paytm.utility.n.a());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str3, locale);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String format = simpleDateFormat2.format(simpleDateFormat.parse(str));
                kotlin.g.b.k.a((Object) format, "targetFormat.format(dateObject)");
                return format;
            } catch (Exception | ParseException unused) {
                return "";
            }
        }

        public static String a(String str, String str2) {
            String str3;
            kotlin.g.b.k.c(str, "inputDate");
            kotlin.g.b.k.c(str2, "inputFormat");
            try {
                Locale locale = new Locale(com.paytm.utility.n.a());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd", locale);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                Date parse = simpleDateFormat.parse(str);
                String format = simpleDateFormat2.format(parse);
                kotlin.g.b.k.a((Object) format, "targetFormat.format(dateObject)");
                int parseInt = Integer.parseInt(format);
                int i2 = parseInt % 10;
                int i3 = parseInt % 100;
                if (i2 == 1 && i3 != 11) {
                    str3 = String.valueOf(parseInt) + H5Param.SHOW_TITLEBAR;
                } else if (i2 == 2 && i3 != 12) {
                    str3 = String.valueOf(parseInt) + "nd";
                } else if (i2 != 3 || i3 == 13) {
                    str3 = String.valueOf(parseInt) + "th";
                } else {
                    str3 = String.valueOf(parseInt) + "rd";
                }
                return str3 + " " + new SimpleDateFormat("MMM yyyy", locale).format(parse);
            } catch (Exception | ParseException unused) {
                return "";
            }
        }

        public static String c(String str, String str2, String str3) {
            kotlin.g.b.k.c(str, "fromFormat");
            kotlin.g.b.k.c(str2, "toFormat");
            kotlin.g.b.k.c(str3, "time");
            try {
                String format = new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
                kotlin.g.b.k.a((Object) format, "targetFormat.format(date)");
                return format;
            } catch (Exception unused) {
                String unused2 = d.f20860b;
                q.b("Exception caused in dateFormatter");
                return "";
            }
        }

        public static final class c implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AJRCashBackBaseActivity f20864a;

            c(AJRCashBackBaseActivity aJRCashBackBaseActivity) {
                this.f20864a = aJRCashBackBaseActivity;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof VoucherTermsResponse) {
                    AJRCashBackBaseActivity aJRCashBackBaseActivity = this.f20864a;
                    if (!(aJRCashBackBaseActivity != null ? Boolean.valueOf(aJRCashBackBaseActivity.isFinishing()) : null).booleanValue()) {
                        VoucherTermsResponse voucherTermsResponse = (VoucherTermsResponse) iJRPaytmDataModel;
                        if (voucherTermsResponse.getStatus() == 0 && voucherTermsResponse.getTerms() != null) {
                            a aVar = d.f20859a;
                            a.a();
                            a aVar2 = d.f20859a;
                            a.a(voucherTermsResponse.getTerms(), "", this.f20864a);
                        } else if (voucherTermsResponse.getErrors() != null && voucherTermsResponse.getErrors().size() > 0) {
                            a aVar3 = d.f20859a;
                            a.a();
                            AJRCashBackBaseActivity aJRCashBackBaseActivity2 = this.f20864a;
                            a aVar4 = d.f20859a;
                            GetVIPCashBackErrorModal getVIPCashBackErrorModal = voucherTermsResponse.getErrors().get(0);
                            kotlin.g.b.k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                            aJRCashBackBaseActivity2.a(a.a(getVIPCashBackErrorModal));
                        }
                    }
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                kotlin.g.b.k.c(iJRPaytmDataModel, "p1");
                kotlin.g.b.k.c(networkCustomError, "p2");
                a aVar = d.f20859a;
                a.a();
                a aVar2 = d.f20859a;
                String unused = d.f20860b;
                q.b("NetworkCustomError");
                this.f20864a.a(networkCustomError);
            }
        }

        public static void a(AJRCashBackBaseActivity aJRCashBackBaseActivity, String str, String str2) {
            kotlin.g.b.k.c(aJRCashBackBaseActivity, "activity");
            kotlin.g.b.k.c(str, "url");
            kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            if (!TextUtils.isEmpty(str)) {
                Context context = aJRCashBackBaseActivity;
                com.paytm.network.a a2 = a(context, (com.paytm.network.listener.b) new c(aJRCashBackBaseActivity), str, str2);
                if (com.paytm.utility.b.c(context)) {
                    d();
                    a2.a();
                    return;
                }
                a();
                a aVar = d.f20859a;
                a(context, a2, true);
            }
        }

        public static final class b implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AJRCashBackBaseActivity f20863a;

            b(AJRCashBackBaseActivity aJRCashBackBaseActivity) {
                this.f20863a = aJRCashBackBaseActivity;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CashBackBaseTNCModal) {
                    AJRCashBackBaseActivity aJRCashBackBaseActivity = this.f20863a;
                    if (!(aJRCashBackBaseActivity != null ? Boolean.valueOf(aJRCashBackBaseActivity.isFinishing()) : null).booleanValue()) {
                        CashBackBaseTNCModal cashBackBaseTNCModal = (CashBackBaseTNCModal) iJRPaytmDataModel;
                        if (cashBackBaseTNCModal.getStatus() == 1 && cashBackBaseTNCModal.getData() != null) {
                            a aVar = d.f20859a;
                            a.a();
                            a aVar2 = d.f20859a;
                            CashBackTnCModal data = cashBackBaseTNCModal.getData();
                            kotlin.g.b.k.a((Object) data, "response.data");
                            a.a(data.getTerms(), "", this.f20863a);
                        } else if (cashBackBaseTNCModal.getErrors() != null && cashBackBaseTNCModal.getErrors().size() > 0) {
                            a aVar3 = d.f20859a;
                            a.a();
                            AJRCashBackBaseActivity aJRCashBackBaseActivity2 = this.f20863a;
                            a aVar4 = d.f20859a;
                            GetVIPCashBackErrorModal getVIPCashBackErrorModal = cashBackBaseTNCModal.getErrors().get(0);
                            kotlin.g.b.k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                            aJRCashBackBaseActivity2.a(a.a(getVIPCashBackErrorModal));
                        }
                    }
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                kotlin.g.b.k.c(iJRPaytmDataModel, "p1");
                kotlin.g.b.k.c(networkCustomError, "p2");
                a aVar = d.f20859a;
                a.a();
                a aVar2 = d.f20859a;
                String unused = d.f20860b;
                q.b("NetworkCustomError");
                this.f20863a.a(networkCustomError);
            }
        }

        private static void c(AJRCashBackBaseActivity aJRCashBackBaseActivity, String str, String str2) {
            kotlin.g.b.k.c(aJRCashBackBaseActivity, "activity");
            kotlin.g.b.k.c(str, "url");
            kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            if (!TextUtils.isEmpty(str)) {
                Context context = aJRCashBackBaseActivity;
                com.paytm.network.listener.b bVar = new b(aJRCashBackBaseActivity);
                kotlin.g.b.k.c(context, "context");
                kotlin.g.b.k.c(bVar, "apiListener");
                kotlin.g.b.k.c(str, "url");
                kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
                new net.one97.paytm.vipcashback.d.a(false);
                kotlin.g.b.k.c(bVar, "apiListener");
                kotlin.g.b.k.c(str, "url");
                kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
                a aVar = d.f20859a;
                com.paytm.network.a l2 = c().a(a.C0715a.GET).a(str).a((Map<String, String>) net.one97.paytm.vipcashback.d.a.a()).a((IJRPaytmDataModel) new CashBackBaseTNCModal()).c(str2).a(bVar).l();
                kotlin.g.b.k.a((Object) l2, "networkCall");
                if (com.paytm.utility.b.c(context)) {
                    d();
                    l2.a();
                    return;
                }
                a();
                a aVar2 = d.f20859a;
                a(context, l2, true);
            }
        }

        public static void a() {
            if (d.f20861c != null) {
                View b2 = d.f20861c;
                if (b2 == null) {
                    kotlin.g.b.k.a();
                }
                View findViewById = b2.findViewById(R.id.loader);
                if (findViewById != null) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) findViewById);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            }
        }

        public static void a(String str, String str2, AJRCashBackBaseActivity aJRCashBackBaseActivity) {
            kotlin.g.b.k.c(aJRCashBackBaseActivity, "activity");
            if (d.f20861c != null) {
                View b2 = d.f20861c;
                LottieAnimationView lottieAnimationView = null;
                TextView textView = b2 != null ? (TextView) b2.findViewById(R.id.tnc_text) : null;
                if (textView != null) {
                    View b3 = d.f20861c;
                    TextView textView2 = b3 != null ? (TextView) b3.findViewById(R.id.tv_how_to_redeem) : null;
                    if (textView2 != null) {
                        View b4 = d.f20861c;
                        TextView textView3 = b4 != null ? (TextView) b4.findViewById(R.id.tv_terms_text) : null;
                        if (textView3 != null) {
                            View b5 = d.f20861c;
                            if (b5 != null) {
                                lottieAnimationView = (LottieAnimationView) b5.findViewById(R.id.loader);
                            }
                            if (lottieAnimationView != null) {
                                net.one97.paytm.common.widgets.a.b(lottieAnimationView);
                                textView.setText(a(str, textView));
                                if (str2 != null) {
                                    if (str2.length() > 0) {
                                        textView2.setVisibility(0);
                                        textView3.setVisibility(0);
                                        textView3.setText(a(str2, textView3));
                                        return;
                                    }
                                }
                                textView2.setVisibility(8);
                                textView3.setVisibility(8);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
        }

        private static void d() {
            if (d.f20861c != null) {
                View b2 = d.f20861c;
                LottieAnimationView lottieAnimationView = b2 != null ? (LottieAnimationView) b2.findViewById(R.id.loader) : null;
                if (lottieAnimationView != null) {
                    net.one97.paytm.common.widgets.a.a(lottieAnimationView);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            }
        }

        public static void a(AJRCashBackBaseActivity aJRCashBackBaseActivity, String str, String str2, String str3, String str4, int i2) {
            kotlin.g.b.k.c(aJRCashBackBaseActivity, "activity");
            kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            LayoutInflater layoutInflater = aJRCashBackBaseActivity.getLayoutInflater();
            View view = null;
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.cb_offer_details_bottomsheet_lyt, (ViewGroup) null);
            }
            d.f20861c = view;
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(aJRCashBackBaseActivity);
            aVar.setContentView(d.f20861c);
            View b2 = d.f20861c;
            if (b2 == null) {
                kotlin.g.b.k.a();
            }
            TextView textView = (TextView) b2.findViewById(R.id.title);
            if (!(str3 == null || textView == null)) {
                textView.setText(str3);
            }
            aVar.show();
            if (d.f20861c != null) {
                View b3 = d.f20861c;
                if (b3 == null) {
                    kotlin.g.b.k.a();
                }
                ((ImageView) b3.findViewById(R.id.close)).setOnClickListener(new n(aVar));
                boolean z = false;
                if (str4 != null) {
                    if ((!(str4.length() == 0)) && i2 == 0) {
                        a(str4, "", aJRCashBackBaseActivity);
                        return;
                    }
                }
                if (i2 == 1 && str != null) {
                    if (!(str.length() == 0)) {
                        c(aJRCashBackBaseActivity, str, str2);
                        return;
                    }
                }
                if (i2 == 0 && str != null) {
                    if (str.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        a(aJRCashBackBaseActivity, str, str2);
                    }
                }
            }
        }

        static final class n implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.android.material.bottomsheet.a f20886a;

            n(com.google.android.material.bottomsheet.a aVar) {
                this.f20886a = aVar;
            }

            public final void onClick(View view) {
                this.f20886a.dismiss();
                d.f20861c = null;
            }
        }

        public static final class g implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.android.material.bottomsheet.a f20875a;

            public g(com.google.android.material.bottomsheet.a aVar) {
                this.f20875a = aVar;
            }

            public final void onClick(View view) {
                this.f20875a.dismiss();
                d.f20861c = null;
            }
        }

        public static final class o implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.android.material.bottomsheet.a f20887a;

            public o(com.google.android.material.bottomsheet.a aVar) {
                this.f20887a = aVar;
            }

            public final void onClick(View view) {
                this.f20887a.dismiss();
            }
        }

        public static final class p implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.android.material.bottomsheet.a f20888a;

            public p(com.google.android.material.bottomsheet.a aVar) {
                this.f20888a = aVar;
            }

            public final void onClick(View view) {
                this.f20888a.dismiss();
            }
        }

        private static com.paytm.network.a a(Context context, com.paytm.network.listener.b bVar, String str, String str2) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(bVar, "apiListener");
            kotlin.g.b.k.c(str, "url");
            kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            new net.one97.paytm.vipcashback.d.a(false);
            return net.one97.paytm.vipcashback.d.a.a(bVar, str, str2);
        }

        public static HashMap<String, String> a(Context context) {
            kotlin.g.b.k.c(context, "context");
            HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
            if (appCommonHeaders == null) {
                appCommonHeaders = new HashMap<>();
            }
            appCommonHeaders.put("Content-Type", "application/json");
            appCommonHeaders.put("Accept", "application/json");
            net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
            kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
            appCommonHeaders.put(AppConstants.SSO_TOKEN, b2.getSSOToken());
            appCommonHeaders.put("mktplace-apikey", "7S4h-4jl4-115D");
            appCommonHeaders.put("x-client-id", "APP_CLIENT");
            appCommonHeaders.put("api_role", "detailed");
            return appCommonHeaders;
        }

        public static HashMap<String, String> b() {
            HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
            if (appCommonHeaders == null) {
                appCommonHeaders = new HashMap<>();
            }
            appCommonHeaders.put("Content-Type", "application/json");
            appCommonHeaders.put("Accept", "application/json");
            net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
            kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
            appCommonHeaders.put(AppConstants.SSO_TOKEN, b2.getSSOToken());
            appCommonHeaders.put("mktplace-apikey", "7S4h-4jl4-115D");
            appCommonHeaders.put("x-client-id", "APP_CLIENT");
            appCommonHeaders.put("api_role", "detailed");
            return appCommonHeaders;
        }

        public static com.paytm.network.a a(Context context, com.paytm.network.listener.b bVar, int i2, String str, String str2, boolean z) {
            IJRPaytmDataModel iJRPaytmDataModel;
            String str3;
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(bVar, "apiListener");
            kotlin.g.b.k.c(str, "action");
            kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            if (z) {
                StringBuilder sb = new StringBuilder();
                kotlin.g.b.k.a((Object) f.a(), "GTMHelper.getInstance()");
                sb.append(f.k());
                sb.append("/");
                sb.append(String.valueOf(i2));
                str3 = sb.toString();
                iJRPaytmDataModel = new MerchantCashBackMyOfferModel();
            } else {
                kotlin.g.b.k.a((Object) f.a(), "GTMHelper.getInstance()");
                String f2 = f.f();
                kotlin.g.b.k.a((Object) f2, "GTMHelper.getInstance().selectOfferUrl");
                jSONObject.put("campaign_id", i2);
                jSONObject.put("campaignId", String.valueOf(i2));
                str3 = f2;
                iJRPaytmDataModel = new CashBackBaseMyOfferModal();
            }
            com.paytm.network.a l2 = c().a(a.C0715a.POST).a(str3).b(jSONObject.toString()).a((Map<String, String>) a(context)).a(iJRPaytmDataModel).c(str2).a(bVar).l();
            kotlin.g.b.k.a((Object) l2, "networkCall");
            return l2;
        }

        public static com.paytm.network.a a(Context context, com.paytm.network.listener.b bVar, int i2, String str) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(bVar, "apiListener");
            kotlin.g.b.k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.k.a((Object) f.a(), "GTMHelper.getInstance()");
            sb.append(f.l());
            sb.append("/");
            sb.append(String.valueOf(i2));
            String sb2 = sb.toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "ACCEPT_OFFER");
            com.paytm.network.a l2 = c().a(a.C0715a.POST).a(sb2).b(jSONObject.toString()).a((Map<String, String>) a(context)).a((IJRPaytmDataModel) new MerchantCashBackMyOfferModel()).c(str).a(bVar).l();
            kotlin.g.b.k.a((Object) l2, "networkCall");
            return l2;
        }

        public static String b(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String format = new SimpleDateFormat(str2).format(simpleDateFormat.parse(str));
                kotlin.g.b.k.a((Object) format, "SimpleDateFormat(format).format(expiry)");
                return format;
            } catch (Exception unused) {
                if (str == null) {
                    return "";
                }
                return str;
            }
        }

        public static void a(Context context, String str, View view, boolean z, int i2, boolean z2) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(view, "view");
            view.setBackground(androidx.core.content.b.a(context, R.drawable.cashback_default_background));
            view.invalidate();
            if (!TextUtils.isEmpty(str)) {
                int width = view.getWidth();
                if ((context instanceof Activity) && width <= 0) {
                    width = !z2 ? com.paytm.utility.b.a((Activity) context) : ((Activity) context).getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_320dp);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
                f fVar = new f(view, context, z);
                view.setTag(fVar);
                if (dimensionPixelSize > 0 && width > 0) {
                    w.a().a(str).a(width, dimensionPixelSize).a((af) fVar);
                }
            }
        }

        public static final class f implements af {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f20870a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f20871b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f20872c;

            public final void onPrepareLoad(Drawable drawable) {
            }

            f(View view, Context context, boolean z) {
                this.f20870a = view;
                this.f20871b = context;
                this.f20872c = z;
            }

            public final void onBitmapFailed(Exception exc, Drawable drawable) {
                this.f20870a.setTag((Object) null);
            }

            public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                try {
                    this.f20870a.post(new C0400a(this, bitmap));
                } catch (OutOfMemoryError unused) {
                    a aVar = d.f20859a;
                    String unused2 = d.f20860b;
                    q.b("java.lang.OutOfMemoryError caused while loading bitmap");
                }
            }

            /* renamed from: net.one97.paytm.vipcashback.f.d$a$f$a  reason: collision with other inner class name */
            static final class C0400a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ f f20873a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Bitmap f20874b;

                C0400a(f fVar, Bitmap bitmap) {
                    this.f20873a = fVar;
                    this.f20874b = bitmap;
                }

                public final void run() {
                    Drawable background = this.f20873a.f20870a.getBackground();
                    if (background != null) {
                        LayerDrawable layerDrawable = (LayerDrawable) background;
                        layerDrawable.setDrawableByLayerId(R.id.image, new BitmapDrawable(this.f20873a.f20871b.getResources(), this.f20874b));
                        if (this.f20873a.f20872c) {
                            layerDrawable.setDrawableByLayerId(R.id.overlay, androidx.core.content.b.a(this.f20873a.f20871b, net.one97.paytm.common.assets.R.color.color_66000000));
                        } else {
                            layerDrawable.setDrawableByLayerId(R.id.overlay, androidx.core.content.b.a(this.f20873a.f20871b, net.one97.paytm.common.assets.R.color.transparent_bg));
                        }
                        this.f20873a.f20870a.setBackground(layerDrawable);
                        if (this.f20873a.f20870a.getWidth() <= 0 || this.f20873a.f20870a.getHeight() <= 0) {
                            this.f20873a.f20870a.invalidate();
                        } else {
                            this.f20873a.f20870a.invalidate(0, 0, this.f20873a.f20870a.getWidth(), this.f20873a.f20870a.getHeight());
                        }
                        this.f20873a.f20870a.setTag((Object) null);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
                }
            }
        }

        public static void a(Context context, String str, View view, boolean z, int i2) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(view, "view");
            a(context, str, view, z, i2, false);
        }

        public static void a(Context context, CircularImageView circularImageView, boolean z, String str) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(circularImageView, "ivIcon");
            ViewGroup.LayoutParams layoutParams = circularImageView.getLayoutParams();
            if (!z) {
                layoutParams.width = context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_96dp);
                layoutParams.height = context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_96dp);
            } else {
                layoutParams.width = context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_72dp);
                layoutParams.height = context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_72dp);
            }
            circularImageView.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(str)) {
                w.a().a(str).a(R.drawable.cashback_icon_holder).a((ImageView) circularImageView);
            } else {
                circularImageView.setImageResource(R.drawable.cashback_icon_holder);
            }
        }

        public static void a(Context context, CircularImageViewCashback circularImageViewCashback, String str) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(circularImageViewCashback, "ivIcon");
            ViewGroup.LayoutParams layoutParams = circularImageViewCashback.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_96dp);
            layoutParams.height = context.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_96dp);
            circularImageViewCashback.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(str)) {
                w.a().a(str).a(R.drawable.cashback_icon_holder).a((ImageView) circularImageViewCashback);
            } else {
                circularImageViewCashback.setImageResource(R.drawable.cashback_icon_holder);
            }
        }

        public static void a(LottieAnimationView lottieAnimationView) {
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setVisibility(8);
            }
        }

        public static /* synthetic */ void a(NetworkCustomError networkCustomError, FragmentActivity fragmentActivity, Boolean bool, int i2) {
            if ((i2 & 4) != 0) {
                bool = Boolean.FALSE;
            }
            a(networkCustomError, fragmentActivity, bool, (kotlin.g.a.a<x>) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x012b, code lost:
            r6 = r7.getResources();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(com.paytm.network.model.NetworkCustomError r6, androidx.fragment.app.FragmentActivity r7, java.lang.Boolean r8, kotlin.g.a.a<kotlin.x> r9) {
            /*
                java.lang.String r0 = "error"
                kotlin.g.b.k.c(r6, r0)
                com.paytm.network.model.NetworkResponse r0 = r6.networkResponse
                if (r0 == 0) goto L_0x001c
                byte[] r0 = r0.data
                if (r0 == 0) goto L_0x001c
                java.nio.charset.Charset r1 = java.nio.charset.Charset.defaultCharset()
                java.lang.String r2 = "Charset.defaultCharset()"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.String r2 = new java.lang.String
                r2.<init>(r0, r1)
                goto L_0x001e
            L_0x001c:
                java.lang.String r2 = ""
            L_0x001e:
                com.paytm.network.model.NetworkCustomError$ErrorType r0 = r6.getErrorType()
                com.paytm.network.model.NetworkCustomError$ErrorType r1 = com.paytm.network.model.NetworkCustomError.ErrorType.NoConnectionError
                r3 = 0
                r4 = 1
                if (r0 != r1) goto L_0x0030
                if (r7 == 0) goto L_0x0030
                android.content.Context r7 = (android.content.Context) r7
                a((android.content.Context) r7, (com.paytm.network.a) r3, (boolean) r4)
                return
            L_0x0030:
                int r0 = r6.getStatusCode()
                r1 = 401(0x191, float:5.62E-43)
                if (r0 == r1) goto L_0x014e
                int r0 = r6.getStatusCode()
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 != r1) goto L_0x0042
                goto L_0x014e
            L_0x0042:
                net.one97.paytm.vipcashback.c.a r0 = net.one97.paytm.vipcashback.c.a.a()
                java.lang.String r1 = "CashbackHelper.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.String r0 = r0.c()
                java.lang.String r1 = "p4b"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0081
                int r0 = r6.getStatusCode()
                r1 = 400(0x190, float:5.6E-43)
                if (r0 != r1) goto L_0x0081
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.String r0 = "INVALID_TOKEN"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r2, (java.lang.CharSequence) r0)
                if (r0 == 0) goto L_0x0081
                java.lang.Class<net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity> r8 = net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity.class
                java.lang.String r3 = r8.getName()
                net.one97.paytm.vipcashback.c.b r0 = net.one97.paytm.vipcashback.c.a.b()
                r1 = r7
                android.app.Activity r1 = (android.app.Activity) r1
                r2 = r6
                java.lang.Exception r2 = (java.lang.Exception) r2
                r4 = 0
                r5 = 0
                r0.handleError(r1, r2, r3, r4, r5)
                return
            L_0x0081:
                java.lang.String r0 = r6.getUniqueReference()
                if (r0 == 0) goto L_0x0093
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r1 = "PROMO_SUPERCASH_4045"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r0, (java.lang.CharSequence) r1)
                if (r0 == r4) goto L_0x00db
            L_0x0093:
                java.lang.String r0 = r6.getUniqueReference()
                if (r0 == 0) goto L_0x00a5
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r1 = "PROMO_SUPERCASH_4046"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r0, (java.lang.CharSequence) r1)
                if (r0 == r4) goto L_0x00db
            L_0x00a5:
                java.lang.String r0 = r6.getUniqueReference()
                if (r0 == 0) goto L_0x00b7
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r1 = "PROMO_SUPERCASH_4002"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r0, (java.lang.CharSequence) r1)
                if (r0 == r4) goto L_0x00db
            L_0x00b7:
                java.lang.String r0 = r6.getUniqueReference()
                if (r0 == 0) goto L_0x00c9
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r1 = "PROMO_SUPERCASH_4001"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r0, (java.lang.CharSequence) r1)
                if (r0 == r4) goto L_0x00db
            L_0x00c9:
                java.lang.String r0 = r6.getUniqueReference()
                if (r0 == 0) goto L_0x00f1
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r1 = "PROMO_SUPERCASH_5000"
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r0, (java.lang.CharSequence) r1)
                if (r0 != r4) goto L_0x00f1
            L_0x00db:
                r9 = r7
                android.content.Context r9 = (android.content.Context) r9
                java.lang.String r0 = r6.getAlertTitle()
                java.lang.String r1 = r6.getAlertMessage()
                net.one97.paytm.vipcashback.f.d$a$d r2 = new net.one97.paytm.vipcashback.f.d$a$d
                r2.<init>(r6, r8, r7)
                com.paytm.utility.g$c r2 = (com.paytm.utility.g.c) r2
                com.paytm.utility.g.b(r9, r0, r1, r2)
                return
            L_0x00f1:
                com.paytm.network.model.NetworkCustomError$ErrorType r8 = r6.getErrorType()
                com.paytm.network.model.NetworkCustomError$ErrorType r0 = com.paytm.network.model.NetworkCustomError.ErrorType.ParsingError
                if (r8 != r0) goto L_0x0107
                android.content.Context r7 = (android.content.Context) r7
                java.lang.String r8 = r6.getUrl()
                java.lang.String r6 = r6.getUniqueReference()
                com.paytm.utility.b.d((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r6)
                return
            L_0x0107:
                java.lang.String r8 = r6.getAlertMessage()
                if (r8 == 0) goto L_0x0129
                java.lang.String r8 = r6.getAlertTitle()
                if (r8 == 0) goto L_0x0129
                r8 = r7
                android.content.Context r8 = (android.content.Context) r8
                java.lang.String r0 = r6.getAlertTitle()
                java.lang.String r6 = r6.getAlertMessage()
                net.one97.paytm.vipcashback.f.d$a$e r1 = new net.one97.paytm.vipcashback.f.d$a$e
                r1.<init>(r9, r7)
                com.paytm.utility.g$c r1 = (com.paytm.utility.g.c) r1
                com.paytm.utility.g.b(r8, r0, r6, r1)
                return
            L_0x0129:
                if (r7 == 0) goto L_0x0138
                android.content.res.Resources r6 = r7.getResources()
                if (r6 == 0) goto L_0x0138
                int r8 = com.paytm.networkmodule.R.string.network_error_message
                java.lang.String r6 = r6.getString(r8)
                goto L_0x0139
            L_0x0138:
                r6 = r3
            L_0x0139:
                r8 = r7
                android.content.Context r8 = (android.content.Context) r8
                if (r7 == 0) goto L_0x014a
                android.content.res.Resources r7 = r7.getResources()
                if (r7 == 0) goto L_0x014a
                int r9 = com.paytm.networkmodule.R.string.network_error_heading
                java.lang.String r3 = r7.getString(r9)
            L_0x014a:
                com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r3, (java.lang.String) r6)
                return
            L_0x014e:
                java.lang.Class<net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity> r9 = net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity.class
                java.lang.String r9 = r9.getName()
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)
                if (r8 == 0) goto L_0x0169
                net.one97.paytm.vipcashback.c.b r8 = net.one97.paytm.vipcashback.c.a.b()
                java.lang.String r9 = "CashbackHelper.getImplListener()"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
                java.lang.String r9 = r8.getLandingActivityClassName()
            L_0x0169:
                r3 = r9
                net.one97.paytm.vipcashback.c.b r0 = net.one97.paytm.vipcashback.c.a.b()
                r1 = r7
                android.app.Activity r1 = (android.app.Activity) r1
                r2 = r6
                java.lang.Exception r2 = (java.lang.Exception) r2
                r4 = 0
                r5 = 0
                r0.handleError(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.f.d.a.a(com.paytm.network.model.NetworkCustomError, androidx.fragment.app.FragmentActivity, java.lang.Boolean, kotlin.g.a.a):void");
        }

        /* renamed from: net.one97.paytm.vipcashback.f.d$a$d  reason: collision with other inner class name */
        static final class C0399d implements g.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NetworkCustomError f20865a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Boolean f20866b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f20867c;

            C0399d(NetworkCustomError networkCustomError, Boolean bool, FragmentActivity fragmentActivity) {
                this.f20865a = networkCustomError;
                this.f20866b = bool;
                this.f20867c = fragmentActivity;
            }

            public final void onDialogDismissed() {
                Intent intent;
                String uniqueReference = this.f20865a.getUniqueReference();
                String str = (uniqueReference == null || !kotlin.m.p.a((CharSequence) uniqueReference, (CharSequence) "PROMO_SUPERCASH_5000", false)) ? "homescreen" : "homescreenMerchant";
                if (kotlin.g.b.k.a((Object) this.f20866b, (Object) Boolean.TRUE)) {
                    net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
                    kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
                    intent = new Intent(this.f20867c, Class.forName(b2.getLandingActivityClassName()));
                    net.one97.paytm.vipcashback.c.b b3 = net.one97.paytm.vipcashback.c.a.b();
                    kotlin.g.b.k.a((Object) b3, "CashbackHelper.getImplListener()");
                    intent.putExtra(b3.get_EXTRA_INTENT_IS_FROM_MESSAGE_TO_HOME_key(), true);
                } else {
                    Intent intent2 = new Intent(this.f20867c, AJRVIPCashBackActivity.class);
                    intent2.putExtra("screen", str);
                    intent2.putExtra("show_home_on_back", true);
                    intent = intent2;
                }
                FragmentActivity fragmentActivity = this.f20867c;
                if (fragmentActivity != null) {
                    fragmentActivity.startActivity(intent);
                }
                FragmentActivity fragmentActivity2 = this.f20867c;
                if (fragmentActivity2 != null) {
                    String name = fragmentActivity2.getClass().getName();
                    net.one97.paytm.vipcashback.c.b b4 = net.one97.paytm.vipcashback.c.a.b();
                    kotlin.g.b.k.a((Object) b4, "CashbackHelper.getImplListener()");
                    if (!name.equals(b4.getLandingActivityClassName())) {
                        this.f20867c.finish();
                    }
                }
            }
        }

        static final class e implements g.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ kotlin.g.a.a f20868a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f20869b;

            e(kotlin.g.a.a aVar, FragmentActivity fragmentActivity) {
                this.f20868a = aVar;
                this.f20869b = fragmentActivity;
            }

            public final void onDialogDismissed() {
                kotlin.g.a.a aVar = this.f20868a;
                if (aVar == null) {
                    FragmentActivity fragmentActivity = this.f20869b;
                    if (fragmentActivity != null) {
                        fragmentActivity.finish();
                    }
                } else if (aVar != null) {
                    aVar.invoke();
                }
            }
        }

        public static NetworkCustomError a(GetVIPCashBackErrorModal getVIPCashBackErrorModal) {
            kotlin.g.b.k.c(getVIPCashBackErrorModal, "errorStatus");
            NetworkCustomError networkCustomError = new NetworkCustomError();
            if (getVIPCashBackErrorModal.getMessage() != null) {
                networkCustomError.setAlertMessage(getVIPCashBackErrorModal.getMessage());
                networkCustomError.setmAlertTitle(getVIPCashBackErrorModal.getTitle());
                networkCustomError.setUniqueReference(getVIPCashBackErrorModal.getCode());
            }
            return networkCustomError;
        }

        public static void a(Context context, String str, boolean z) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(str, "code");
            Object systemService = context.getSystemService("clipboard");
            if (systemService != null) {
                try {
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("voucher_code", str));
                    if (z) {
                        Toast.makeText(context, "Code copied!", 0).show();
                    }
                } catch (Exception unused) {
                    String unused2 = d.f20860b;
                    q.b("java.lang.Exception while copy voucher code");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.content.ClipboardManager");
            }
        }

        public static com.paytm.network.b c() {
            com.paytm.network.b bVar = new com.paytm.network.b();
            net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
            kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
            com.paytm.network.b c2 = bVar.a(b2.getApplicationContext()).a(a.c.CASHBACK).a(a.b.USER_FACING).c("cashback");
            kotlin.g.b.k.a((Object) c2, "networkCallBuilder");
            return c2;
        }

        public static String d(String str, String str2, String str3) {
            kotlin.g.b.k.c(str, "url");
            kotlin.g.b.k.c(str2, "key");
            kotlin.g.b.k.c(str3, "value");
            if (!kotlin.m.p.a((CharSequence) str, (CharSequence) "?", false)) {
                return str + '?' + str2 + '=' + str3;
            }
            return str + '&' + str2 + '=' + str3;
        }

        public static CharSequence c(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned fromHtml = Html.fromHtml(str, 0);
                kotlin.g.b.k.a((Object) fromHtml, "Html.fromHtml(strArg, Html.FROM_HTML_MODE_LEGACY)");
                return fromHtml;
            }
            Spanned fromHtml2 = Html.fromHtml(str);
            kotlin.g.b.k.a((Object) fromHtml2, "Html.fromHtml(strArg)");
            return fromHtml2;
        }

        public static CharSequence a(String str, TextView textView) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned fromHtml = Html.fromHtml(str, 0);
                kotlin.g.b.k.a((Object) fromHtml, "Html.fromHtml(strArg, Html.FROM_HTML_MODE_LEGACY)");
                return fromHtml;
            }
            Spanned fromHtml2 = Html.fromHtml(str);
            kotlin.g.b.k.a((Object) fromHtml2, "Html.fromHtml(strArg)");
            return fromHtml2;
        }

        public static int a(BitmapFactory.Options options, int i2, int i3) {
            int i4;
            kotlin.g.b.k.c(options, "options");
            kotlin.o a2 = t.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
            int intValue = ((Number) a2.component1()).intValue();
            int intValue2 = ((Number) a2.component2()).intValue();
            if (intValue > i3 || intValue2 > i2) {
                int i5 = intValue / 2;
                int i6 = intValue2 / 2;
                i4 = 1;
                while (i4 > 0 && i5 / i4 >= i3 && i6 / i4 >= i2) {
                    i4 *= 2;
                }
            } else {
                i4 = 1;
            }
            if (i4 == 0) {
                return 1;
            }
            return i4;
        }

        public static AlertDialog a(Context context, com.paytm.network.a aVar, boolean z) {
            kotlin.g.b.k.c(context, "context");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(z);
            builder.setTitle(context.getResources().getString(net.one97.paytm.common.assets.R.string.no_connection));
            builder.setMessage(context.getResources().getString(net.one97.paytm.common.assets.R.string.no_internet));
            if (aVar != null) {
                builder.setPositiveButton(context.getResources().getString(net.one97.paytm.common.assets.R.string.network_retry_yes), new h(context, aVar, z));
            } else {
                builder.setPositiveButton(context.getResources().getString(com.paytm.networkmodule.R.string.ok), i.f20879a);
            }
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return null;
            }
            return builder.show();
        }

        static final class h implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20876a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.paytm.network.a f20877b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f20878c;

            h(Context context, com.paytm.network.a aVar, boolean z) {
                this.f20876a = context;
                this.f20877b = aVar;
                this.f20878c = z;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (com.paytm.utility.b.c(this.f20876a)) {
                    this.f20877b.a();
                    return;
                }
                a aVar = d.f20859a;
                a.a(this.f20876a, this.f20877b, this.f20878c);
            }
        }

        public static AlertDialog a(Context context, kotlin.g.a.a<x> aVar) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(aVar, "listner");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(false);
            builder.setTitle(context.getResources().getString(net.one97.paytm.common.assets.R.string.no_connection));
            builder.setMessage(context.getResources().getString(net.one97.paytm.common.assets.R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(com.paytm.networkmodule.R.string.ok), new j(aVar));
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return null;
            }
            return builder.show();
        }

        static final class j implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ kotlin.g.a.a f20880a;

            j(kotlin.g.a.a aVar) {
                this.f20880a = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f20880a.invoke();
            }
        }

        public static AlertDialog a(Context context, boolean z, net.one97.paytm.coins.b.a aVar) {
            kotlin.g.b.k.c(context, "context");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(z);
            builder.setTitle(context.getResources().getString(net.one97.paytm.common.assets.R.string.no_connection));
            builder.setMessage(context.getResources().getString(net.one97.paytm.common.assets.R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(net.one97.paytm.common.assets.R.string.network_retry_yes), new k(aVar));
            builder.setNegativeButton(context.getResources().getString(com.paytm.networkmodule.R.string.ok), new l(aVar));
            if (!((Activity) context).isFinishing()) {
                return builder.show();
            }
            return null;
        }

        static final class k implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.coins.b.a f20881a;

            k(net.one97.paytm.coins.b.a aVar) {
                this.f20881a = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                net.one97.paytm.coins.b.a aVar = this.f20881a;
                if (aVar != null) {
                    aVar.b();
                }
                dialogInterface.dismiss();
            }
        }

        static final class l implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.coins.b.a f20882a;

            l(net.one97.paytm.coins.b.a aVar) {
                this.f20882a = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                net.one97.paytm.coins.b.a aVar = this.f20882a;
                if (aVar != null) {
                    aVar.a();
                }
                dialogInterface.dismiss();
            }
        }

        public static String d(String str) {
            kotlin.g.b.k.c(str, "voucher");
            ArrayList arrayList = new ArrayList(4);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                try {
                    if (i4 >= str.length()) {
                        break;
                    }
                    String substring = str.substring(i3, i4);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    i3 = i4;
                } catch (Exception unused) {
                    return str;
                }
            }
            if (i3 < str.length()) {
                String substring2 = str.substring(i3, str.length());
                kotlin.g.b.k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(substring2);
            }
            int size = arrayList.size() - 1;
            String str2 = "";
            if (size >= 0) {
                while (true) {
                    str2 = str2 + ((String) arrayList.get(i2)) + " ";
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            return str2;
        }

        public static void a(Context context, ViewGroup viewGroup, com.paytm.network.a aVar) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(viewGroup, "rootViewGroup");
            View view = viewGroup;
            if (((ConstraintLayout) view.findViewById(R.id.layoutNoNetwork)) == null) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.layout_cashback_no_network, (ViewGroup) null);
                viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
                kotlin.g.b.k.a((Object) inflate, "mNetworkView");
                RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.lblRetry);
                if (roboTextView != null) {
                    roboTextView.setOnClickListener(new m(viewGroup, inflate, aVar));
                }
            } else {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.layoutNoNetwork);
                kotlin.g.b.k.a((Object) constraintLayout, "rootViewGroup.layoutNoNetwork");
                constraintLayout.setVisibility(0);
            }
            View findViewById = viewGroup.findViewById(R.id.swipeRefresh);
            if (findViewById != null) {
                findViewById.bringToFront();
            }
        }

        static final class m implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewGroup f20883a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f20884b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ com.paytm.network.a f20885c;

            m(ViewGroup viewGroup, View view, com.paytm.network.a aVar) {
                this.f20883a = viewGroup;
                this.f20884b = view;
                this.f20885c = aVar;
            }

            public final void onClick(View view) {
                this.f20883a.removeView(this.f20884b);
                com.paytm.network.a aVar = this.f20885c;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        public static void a(ViewGroup viewGroup) {
            kotlin.g.b.k.c(viewGroup, "rootViewGroup");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup.findViewById(R.id.layoutNoNetwork);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        }

        public static void a(View view) {
            kotlin.g.b.k.c(view, "view");
            view.setEnabled(false);
            new Handler().postDelayed(new C0398a(view), 400);
        }

        /* renamed from: net.one97.paytm.vipcashback.f.d$a$a  reason: collision with other inner class name */
        static final class C0398a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f20862a;

            C0398a(View view) {
                this.f20862a = view;
            }

            public final void run() {
                this.f20862a.setEnabled(true);
            }
        }

        public static String e(String str) {
            new Locale("en", "IN");
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return "";
            }
            String format = new DecimalFormat("#,##,###.##").format((str != null ? Double.valueOf(Double.parseDouble(str)) : null).doubleValue());
            kotlin.g.b.k.a((Object) format, "DecimalFormat(\"#,##,###.##\").format(d?.toDouble())");
            return format;
        }

        public static void a(Activity activity) {
            kotlin.g.b.k.c(activity, "context");
            Intent intent = new Intent(activity, AJRVIPCashBackActivity.class);
            intent.putExtra("show_home_on_back", true);
            intent.putExtra("screen", "homescreen");
            activity.startActivity(intent);
        }

        public static boolean a(ScratchCard scratchCard) {
            String redemptionType;
            String redemptionType2;
            String redemptionType3;
            String redemptionType4;
            String redemptionType5;
            String redemptionType6;
            String redemptionType7;
            String redemptionType8;
            String redemptionType9;
            kotlin.g.b.k.c(scratchCard, BaseViewModel.PaymentType.CARD);
            String redemptionType10 = scratchCard.getRedemptionType();
            if (redemptionType10 != null) {
                a.f.C0387a aVar = a.f.f20792a;
                if (!redemptionType10.equals(a.f.f20795d) && (redemptionType = scratchCard.getRedemptionType()) != null) {
                    a.f.C0387a aVar2 = a.f.f20792a;
                    if (!redemptionType.equals(a.f.f20796e) && (redemptionType2 = scratchCard.getRedemptionType()) != null) {
                        a.f.C0387a aVar3 = a.f.f20792a;
                        if (!redemptionType2.equals(a.f.f20794c) && (redemptionType3 = scratchCard.getRedemptionType()) != null) {
                            a.f.C0387a aVar4 = a.f.f20792a;
                            if (!redemptionType3.equals(a.f.f20793b) && (redemptionType4 = scratchCard.getRedemptionType()) != null && !redemptionType4.equals("COINS") && (redemptionType5 = scratchCard.getRedemptionType()) != null && !redemptionType5.equals("UPI") && (redemptionType6 = scratchCard.getRedemptionType()) != null && !redemptionType6.equals(SDKConstants.AI_KEY_PPBL) && (redemptionType7 = scratchCard.getRedemptionType()) != null && !redemptionType7.equals("GV_CASHBACK") && (redemptionType8 = scratchCard.getRedemptionType()) != null && !redemptionType8.equals("PG_CASHBACK") && (redemptionType9 = scratchCard.getRedemptionType()) != null && !redemptionType9.equals("COLLECTIBLE")) {
                                return false;
                            }
                        }
                    }
                }
            }
            String displayType = scratchCard.getDisplayType();
            if (displayType != null) {
                a.e.C0386a aVar5 = a.e.f20790a;
                if (kotlin.m.p.a(displayType, a.e.f20791b, true)) {
                    return true;
                }
            }
            return false;
        }

        public static void a(String str, Activity activity, Object obj, kotlin.g.a.m<? super Intent, ? super Boolean, x> mVar) {
            kotlin.g.b.k.c(str, "activityName");
            kotlin.g.b.k.c(activity, "context");
            kotlin.g.b.k.c(mVar, "listner");
            Intent intent = null;
            if (obj instanceof CardOfferData) {
                CardOfferData cardOfferData = (CardOfferData) obj;
                if (cardOfferData.getNewOfferData() != null) {
                    intent = new Intent(activity, CashbackCompaignGameDetail.class);
                    intent.putExtra("campaign", cardOfferData.getNewOfferData());
                } else if (cardOfferData.getActiveOfferData() != null) {
                    intent = new Intent(activity, CashbackCompaignGameDetail.class);
                    intent.putExtra("supercashGame", cardOfferData.getActiveOfferData());
                }
            } else if (obj instanceof CashbackVoucher) {
                intent = new Intent(activity, CashbackVoucherDetailsActivity.class);
                CashbackVoucher cashbackVoucher = (CashbackVoucher) obj;
                intent.putExtra(Utility.EVENT_CATEGORY_PROMOCODE, cashbackVoucher.getPromocode());
                intent.putExtra("siteid", cashbackVoucher.getSiteId());
                intent.putExtra("voucherid", cashbackVoucher.getTitle());
                intent.putExtra("redemptionType", cashbackVoucher.getRedemptionType());
                intent.putExtra("client", cashbackVoucher.getClient());
            } else if (obj instanceof Campaign) {
                intent = new Intent(activity, CashBackOfferDetailActivity.class);
                intent.putExtra("campaign", (Serializable) obj);
            } else if (obj instanceof VIPCashBackOfferV4) {
                intent = new Intent(activity, CashbackCompaignGameDetail.class);
                intent.putExtra("supercashGame", (Serializable) obj);
            }
            if ((str.length() > 0) && intent != null) {
                intent.putExtra("activityName", str);
            }
            mVar.invoke(intent, Boolean.FALSE);
        }

        public static void a(String str, Context context) {
            kotlin.g.b.k.c(str, "className");
            kotlin.g.b.k.c(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.addFlags(603979776);
            context.startActivity(intent);
        }

        public static j a(String str, boolean z) {
            Long l2;
            Long l3 = null;
            if (str != null) {
                try {
                    l2 = Long.valueOf(Long.parseLong(str));
                } catch (ParseException unused) {
                    return j.LANDING_VICTORY_THEME;
                }
            } else {
                l2 = null;
            }
            if (!z) {
                if (l2 != null) {
                    l3 = Long.valueOf(l2.longValue() % 4);
                }
                if (l3 != null) {
                    if (l3.longValue() == 0) {
                        return j.SCRATCH_CARD_VICTORY_THEME;
                    }
                }
                if (l3 != null) {
                    if (l3.longValue() == 1) {
                        return j.SCRATCH_CARD_TRUMP_THEME;
                    }
                }
                if (l3 != null) {
                    if (l3.longValue() == 2) {
                        return j.SCRATCH_CARD_DIAMOND_THEME;
                    }
                }
                return j.SCRATCH_CARD_SUNGLASSES_THEME;
            }
            if (l2 != null) {
                l3 = Long.valueOf(l2.longValue() % 4);
            }
            if (l3 != null) {
                if (l3.longValue() == 0) {
                    return j.LANDING_VICTORY_THEME;
                }
            }
            if (l3 != null) {
                if (l3.longValue() == 1) {
                    return j.LANDING_TRUMP_THEME;
                }
            }
            if (l3 != null) {
                if (l3.longValue() == 2) {
                    return j.LANDING_DIAMOND_THEME;
                }
            }
            return j.LANDING_SUNGLASSES_THEME;
        }

        public static String a(int i2, String str) {
            String str2 = null;
            if (i2 > 1) {
                if (str != null) {
                    str2 = kotlin.m.p.a(str, "%s", "s", false);
                }
            } else if (str != null) {
                str2 = kotlin.m.p.a(str, "%s", "", false);
            }
            if (str2 == null) {
                return "";
            }
            return str2;
        }
    }

    static {
        String name = d.class.getName();
        k.a((Object) name, "CommonMethods::class.java.name");
        f20860b = name;
    }
}
