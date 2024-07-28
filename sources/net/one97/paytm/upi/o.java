package net.one97.paytm.upi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.view.activity.SFBrowseCategoryActivity;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.auth.b.b;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.view.fragments.MoneyTransferInviteFragment;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.payments.d.a;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.h;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.bf;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;

public final class o implements h, k, CJRSendGTMTag.OnCustomNewGTMEvent {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f67612a;

    public final String b() {
        return "paytmmp://mobile-prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17";
    }

    public final void a(Context context, Bundle bundle) {
        if (context != null) {
            Intent intent = new Intent(context, MoneyTransferV3Activity.class);
            intent.setData((Uri) bundle.getParcelable(UpiConstants.EXTRA_VPA_DATA));
            intent.setFlags(33554432);
            intent.putExtra("amount", bundle.getString("amount"));
            intent.putExtra(UpiConstants.IS_FROM_SCAN, bundle.getBoolean(UpiConstants.IS_FROM_SCAN));
            intent.putExtra("payee_name", bundle.getString("payee_name"));
            intent.putExtra("payee_vpa", bundle.getString("payee_vpa"));
            intent.putExtra(UpiConstants.EXTRA_PAYER_VPA, bundle.getString(UpiConstants.EXTRA_PAYER_VPA));
            intent.putExtra(UpiConstants.EXTRA_COLLECT_REQUEST_BANK_LIST_SIZE, bundle.getInt(UpiConstants.EXTRA_COLLECT_REQUEST_BANK_LIST_SIZE, 0));
            intent.putExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, bundle.getBoolean(UpiConstants.EXTRA_IS_COLLECT_REQUEST));
            intent.putExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, bundle.getString(UpiConstants.EXTRA_UPI_TRAN_LOG_ID));
            intent.putExtra("user_upi_details", bundle.getSerializable("user_upi_details"));
            intent.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, bundle.getString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID));
            intent.putExtra(UpiConstants.IS_GALLERY_SCAN, bundle.getBoolean(UpiConstants.IS_GALLERY_SCAN, false));
            intent.putExtra(UpiConstants.EVENT_START_TIME, bundle.getLong(UpiConstants.EVENT_START_TIME, -1));
            intent.putExtra(UpiConstants.EVENT_SCAN_TIME, bundle.getLong(UpiConstants.EVENT_SCAN_TIME, -1));
            intent.putExtra(UpiConstants.IS_MID_SCAN, bundle.getBoolean(UpiConstants.IS_MID_SCAN, false));
            intent.putExtra(UpiConstants.UPI_IS_VERIFIED_MERCHANT, bundle.getBoolean(UpiConstants.UPI_IS_VERIFIED_MERCHANT, false));
            context.startActivity(intent);
        }
    }

    public final void a(Fragment fragment, Bundle bundle) {
        Intent intent = new Intent(fragment.getContext(), MoneyTransferV3Activity.class);
        intent.setFlags(268468224);
        intent.setFlags(33554432);
        intent.setData((Uri) bundle.getParcelable(UpiConstants.EXTRA_VPA_DATA));
        fragment.startActivity(intent);
    }

    public final void a(Activity activity) {
        a.a(activity, "paytmmp://payment_bank?featuretype=fgt_passcode");
    }

    public final void a(Context context, String str) {
        Intent intent = new Intent(context, AJRWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("finish_activity", true);
        context.startActivity(intent);
    }

    public final void a(Activity activity, String str) {
        a.a(activity, str);
    }

    public final void a(Activity activity, Object obj, CJRReplacementReason cJRReplacementReason) {
        if (!activity.isFinishing()) {
            this.f67612a = ProgressDialog.show(activity, "", "Please wait...", true);
            Bundle bundle = new Bundle();
            net.one97.paytm.common.entity.replacement.CJRReplacementReason cJRReplacementReason2 = new net.one97.paytm.common.entity.replacement.CJRReplacementReason();
            cJRReplacementReason2.setIssueText(cJRReplacementReason.getIssueText());
            cJRReplacementReason2.setId(cJRReplacementReason.getId());
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason2);
            bundle.putString("upiItem", new f().b(obj));
            d.a((Context) activity, bundle, (m) new m() {
                public final void show() {
                }

                public final void dismiss() {
                    o.this.f67612a.dismiss();
                }
            });
        }
    }

    public final void a(Context context) {
        if (context instanceof PaySendActivityV2) {
            ((PaySendActivityV2) context).c();
        }
    }

    public final void b(Context context, Bundle bundle) {
        Intent intent = new Intent(context, MoneyTransferUserHistoryActivity.class);
        intent.putExtra("account_holder_name", bundle.getString(UpiConstants.EXTRA_ACCOUNT_NAME, ""));
        intent.putExtra(PayUtility.BANK_NAME, bundle.getString(UpiConstants.EXTRA_BANK_NAME, ""));
        intent.putExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, bundle.getString(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, ""));
        intent.putExtra("ifsc_code", bundle.getString(UpiConstants.EXTRA_IFSC, ""));
        context.startActivity(intent);
    }

    public final ContextWrapper d(Context context) {
        return e.a(context);
    }

    public final void a(LinearLayout linearLayout) {
        net.one97.paytm.landingpage.hometabs.a.a();
        net.one97.paytm.landingpage.hometabs.a.b();
        l.a((ViewGroup) linearLayout);
    }

    public final void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public final void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6);
    }

    public final void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public final void e(Activity activity) {
        new NetworkCustomError();
        r.a(activity, (String) null, (Bundle) null, false, true);
    }

    public final String c(Context context) {
        return com.paytm.utility.a.f(context);
    }

    public final void b(Context context) {
        new NetworkCustomError();
        r.a((Activity) context, (String) null, (Bundle) null, false, true);
    }

    public final void a(int i2, Context context) {
        Intent intent = new Intent(context, AJRAuthActivity.class);
        intent.putExtra("launchSignUp", false);
        intent.putExtra("set_result_required", true);
        intent.putExtra("VERTICAL_NAME", "Wallet");
        ((Activity) context).startActivityForResult(intent, i2);
    }

    public final void a(String str, String str2) {
        r.a(str, str2);
    }

    public final void a(String str, String str2, Throwable th) {
        r.a(str, str2, th);
    }

    public final void e(Context context) {
        context.startActivity(new Intent(context, PaySendActivityV2.class));
    }

    public final Fragment d() {
        MoneyTransferInviteFragment.a aVar = MoneyTransferInviteFragment.f54386a;
        return MoneyTransferInviteFragment.a.a(false, false, "");
    }

    public final Context c() {
        return CJRJarvisApplication.getAppContext();
    }

    public final void a(h.a aVar) {
        aVar.a();
    }

    public final String b(String str, String str2) {
        c.a();
        return c.a(str, str2);
    }

    public final String c(String str, String str2) {
        c.a();
        return c.a(str, str2);
    }

    public final boolean a(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public final int a(String str, int i2) {
        c.a();
        return c.a(str, i2);
    }

    public final int a(String str) {
        c.a();
        return c.a(str, 0);
    }

    public final String a() {
        return a.a() + "cash_wallet?featuretype=money_transfer";
    }

    public final void f(Context context) {
        context.startActivity(new Intent(context, SFBrowseCategoryActivity.class));
    }

    public final void a(Activity activity, Uri uri) {
        try {
            net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
            net.one97.paytm.wallet.utility.d.a(uri.toString(), (Context) activity);
        } catch (IOException e2) {
            q.b(e2.getMessage());
        }
    }

    public final Class<?> e() {
        return AJROrderSummaryActivity.class;
    }

    public final void c(Activity activity) {
        bf.a(activity);
    }

    public final void d(Activity activity) {
        CropImage.a((Uri) null).a(CropImageView.c.ON).a(activity, true, true);
    }

    public final void a(Activity activity, NetworkCustomError networkCustomError, String str) {
        r.a(activity, (Exception) networkCustomError, str, (Bundle) null);
    }

    public final void a(View view, RecyclerView recyclerView, String str, FragmentActivity fragmentActivity) {
        HashMap hashMap = new HashMap();
        hashMap.put("", "");
        SFInterface.INSTANCE.getStoreFrontReponse(str, hashMap, a.c.MONEYTRANSFER, new SFCallbackListener(view, fragmentActivity, recyclerView) {
            private final /* synthetic */ View f$1;
            private final /* synthetic */ FragmentActivity f$2;
            private final /* synthetic */ RecyclerView f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
            }

            public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
                o.this.a(this.f$1, this.f$2, this.f$3, sanitizedResponseModel);
            }
        }, GAConstants.SCREEN_NAME.UPI_BENEFITS, 1004, (IGAEnableListener) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, FragmentActivity fragmentActivity, RecyclerView recyclerView, SanitizedResponseModel sanitizedResponseModel) {
        if (sanitizedResponseModel != null) {
            LinkedHashMap<Integer, IWidgetProvider> sfWidgets = sanitizedResponseModel.getSfWidgets();
            List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
            if (view != null) {
                StoreFrontGAHandler gaListener = sanitizedResponseModel.getGaListener();
                IWidgetProvider iWidgetProvider = sfWidgets.get(104);
                if (iWidgetProvider != null) {
                    SFWidget widget = iWidgetProvider.getWidget(fragmentActivity, gaListener);
                    if (widget instanceof IStaticWidget) {
                        ((FrameLayout) view).addView(((IStaticWidget) widget).getView());
                    }
                }
            }
            if (recyclerView != null) {
                recyclerView.setAdapter(new p(rvWidgets, fragmentActivity.getSupportFragmentManager(), sanitizedResponseModel.getGaListener()));
            }
        }
    }

    public final void b(Activity activity) {
        if (activity != null) {
            b.a(CJRJarvisApplication.getAppContext());
            b.a(activity, false);
            Intent intent = new Intent(activity, AJRMainActivity.class);
            intent.putExtra("intent_extra_start_login", true);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            activity.startActivity(intent);
        }
    }

    public final int g(Context context) {
        int b2 = ag.a(context.getApplicationContext()).b("acc_status", 0, true);
        if (b2 == net.one97.paytm.utils.a.NOT_APPLIED.getNumVal()) {
            return net.one97.paytm.utils.a.NOT_APPLIED.getNumVal();
        }
        if (b2 == net.one97.paytm.utils.a.PROCESSING.getNumVal()) {
            return net.one97.paytm.utils.a.PROCESSING.getNumVal();
        }
        return b2 == net.one97.paytm.utils.a.ISSUED.getNumVal() ? net.one97.paytm.utils.a.ISSUED.getNumVal() : net.one97.paytm.utils.a.DEFAULT.getNumVal();
    }
}
