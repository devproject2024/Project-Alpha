package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.b;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.ReferralCodeResponse;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiConstants;

public final class i extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f54483a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f54484b;

    /* renamed from: c  reason: collision with root package name */
    private b f54485c;

    /* renamed from: d  reason: collision with root package name */
    private String f54486d = "";

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f54487e;

    /* renamed from: f  reason: collision with root package name */
    private final int f54488f = 4;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f54489g;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f54484b = String.valueOf(arguments != null ? arguments.get(ContactColumn.PHONE_NUMBER) : null);
    }

    public final void a(b bVar) {
        k.c(bVar, "moneyTransferActivityCallback");
        this.f54485c = bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.money_transfer_no_upi_user_fragment, viewGroup, false);
        k.a((Object) inflate, "view");
        k.c(inflate, "view");
        View.OnClickListener onClickListener = this;
        inflate.findViewById(R.id.friendsBankAccount).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.inviteFriends).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.iv_back_button).setOnClickListener(onClickListener);
        this.f54487e = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        k.a((Object) textView, "title");
        textView.setText(getString(R.string.invite_screen_title, this.f54484b));
        TextView textView2 = (TextView) inflate.findViewById(R.id.scratch_card_cashback);
        TextView textView3 = (TextView) inflate.findViewById(R.id.invite_cashback);
        String string = getString(R.string.upi_invite_cashback_text);
        k.a((Object) string, "getString(R.string.upi_invite_cashback_text)");
        CharSequence charSequence = string;
        if (!TextUtils.isEmpty(charSequence)) {
            if (textView3 != null) {
                textView3.setText(charSequence);
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else if (textView3 != null) {
            textView3.setVisibility(8);
        }
        c.a aVar = c.C;
        CharSequence a2 = c.a(c.a.a().f53994i);
        if (!TextUtils.isEmpty(a2)) {
            k.a((Object) textView2, "scratchCardCashbackTV");
            textView2.setText(a2);
            textView2.setVisibility(0);
        } else if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (m.b()) {
            View findViewById = inflate.findViewById(R.id.motif_iv);
            k.a((Object) findViewById, "view.findViewById<ImageView>(R.id.motif_iv)");
            ((ImageView) findViewById).setVisibility(8);
        }
        if (m.b()) {
            View findViewById2 = inflate.findViewById(R.id.rel_bottom);
            k.a((Object) findViewById2, "view.findViewById<RelativeLayout>(R.id.rel_bottom)");
            ((RelativeLayout) findViewById2).setVisibility(8);
        }
        return inflate;
    }

    public final void onClick(View view) {
        FragmentActivity activity;
        j supportFragmentManager;
        if (view != null && view.getId() == R.id.friendsBankAccount) {
            String str = this.f54484b;
            if (str != null) {
                f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "phonebook_proceed_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "bank_account_upiid", "");
                b bVar = this.f54485c;
                if (bVar != null) {
                    bVar.e(str);
                }
            }
        } else if (view != null && view.getId() == R.id.inviteFriends) {
            a();
        } else if (view != null && view.getId() == R.id.iv_back_button && (activity = getActivity()) != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.d();
        }
    }

    private final void a(Integer num) {
        a(true);
        FragmentActivity activity = getActivity();
        net.one97.paytm.upi.registration.b.a.b.a.a(activity != null ? activity.getApplicationContext() : null).d(new a(this, num), "");
    }

    public static final class a implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f54490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f54491b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f54492c = true;

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.moneytransfer.view.fragments.i, java.lang.Integer] */
        /* JADX WARNING: type inference failed for: r2v0, types: [boolean, java.lang.Integer] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        a(java.lang.Integer r1, boolean r2) {
            /*
                r0 = this;
                r0.f54490a = r1
                r0.f54491b = r2
                r1 = 1
                r0.f54492c = r1
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.i.a.<init>(net.one97.paytm.moneytransfer.view.fragments.i, java.lang.Integer):void");
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            this.f54490a.a(false);
            if (upiBaseDataModel instanceof ReferralCodeResponse) {
                ReferralCodeResponse referralCodeResponse = (ReferralCodeResponse) upiBaseDataModel;
                if (p.a(referralCodeResponse.getStatus(), "success", true)) {
                    i iVar = this.f54490a;
                    String str = referralCodeResponse.getReferralContent() + StringUtility.NEW_LINE + referralCodeResponse.getReferralUrl();
                    k.c(str, "<set-?>");
                    iVar.f54483a = str;
                    Integer num = this.f54491b;
                    if (num != null) {
                        num.intValue();
                        this.f54490a.a();
                    }
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            this.f54490a.a(false);
            if (upiCustomVolleyError == null) {
                k.a();
            }
            if (!upiCustomVolleyError.getmErrorCode().equals(UpiConstants.NETWORK_ERROR_CODE)) {
                Toast.makeText(this.f54490a.getActivity(), net.one97.paytm.upi.R.string.upi_some_went_wrong, 0).show();
            } else if (this.f54492c) {
                CustomDialog.showAlert(this.f54490a.getActivity(), this.f54490a.getString(net.one97.paytm.upi.R.string.no_connection), this.f54490a.getString(net.one97.paytm.upi.R.string.no_internet_new_message));
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a(this.f54487e);
        } else {
            net.one97.paytm.common.widgets.a.b(this.f54487e);
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        if (getActivity() != null) {
            if (!(this.f54483a.length() == 0)) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                a(activity, this.f54483a, this.f54486d);
                return;
            }
            a(Integer.valueOf(this.f54488f));
        }
    }

    private static void a(Activity activity, String str, String str2) {
        k.c(activity, "actvity");
        k.c(str, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54489g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
