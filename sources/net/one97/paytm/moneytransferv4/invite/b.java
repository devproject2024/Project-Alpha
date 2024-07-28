package net.one97.paytm.moneytransferv4.invite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.y;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.o;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends net.one97.paytm.moneytransferv4.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55654a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.contacts.b.a f55655b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f55656c;

    public final void c() {
        HashMap hashMap = this.f55656c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    static final class g<T> implements z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55672a;

        g(b bVar) {
            this.f55672a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar.f54032a == net.one97.paytm.moneytransfer.model.d.LOADING) {
                CustomWalletLoaderDialog.getInstance(this.f55672a.getContext()).showLoader();
            } else {
                CustomWalletLoaderDialog.getInstance(this.f55672a.getContext()).dismissLoader();
            }
            int i2 = c.f55673a[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                b bVar = this.f55672a;
                ResultType resulttype = cVar.f54033b;
                if (resulttype == null) {
                    k.a();
                }
                b.b(bVar, (String) resulttype);
            } else if (i2 == 2) {
                b.a(this.f55672a, cVar.f54034c);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_contact_not_found, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this, (al.b) null).a(net.one97.paytm.moneytransfer.contacts.b.a.class);
        k.a((Object) a2, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f55655b = (net.one97.paytm.moneytransfer.contacts.b.a) a2;
        o a3 = o.a(view);
        k.a((Object) a3, "LayoutContactNotFoundBinding.bind(view)");
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        String string = arguments.getString(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            k.a();
        }
        String string2 = arguments2.getString("name");
        ImageView imageView = a3.f53802a;
        k.a((Object) imageView, "backArrow");
        net.one97.paytm.upi.f.a((View) imageView, getParentFragment() == null);
        net.one97.paytm.moneytransfer.contacts.b.a aVar = this.f55655b;
        if (aVar == null) {
            k.a("contactsViewModel");
        }
        net.one97.paytm.upi.registration.b.a.b bVar = aVar.f53969a;
        if (bVar != null ? bVar.e() : false) {
            TextView textView = a3.l;
            k.a((Object) textView, "transferUsingBankAcc");
            textView.setText(getString(R.string.mt_transfer_money_using_their_bank));
            a3.l.setOnClickListener(new C1034b(this, string2, string));
            TextView textView2 = a3.f53805d;
            k.a((Object) textView2, "contactNotFoundTextView");
            int i2 = R.string.invite_screen_title;
            Object[] objArr = new Object[1];
            objArr[0] = string2 == null ? string : string2;
            textView2.setText(getString(i2, objArr));
            a3.f53807f.setOnClickListener(new c(this, string2, string));
            TextView textView3 = a3.f53804c;
            k.a((Object) textView3, "cashBackTextView");
            textView3.setText(getString(R.string.mt_p2p_referral_desc));
        } else {
            TextView textView4 = a3.l;
            k.a((Object) textView4, "transferUsingBankAcc");
            textView4.setText(getString(R.string.mt_transfer_money_using_mobile_no));
            a3.l.setOnClickListener(new d(this, string2, string));
            TextView textView5 = a3.f53805d;
            k.a((Object) textView5, "contactNotFoundTextView");
            int i3 = R.string.invite_screen_title_non_paytm;
            Object[] objArr2 = new Object[1];
            objArr2[0] = string2 == null ? string : string2;
            textView5.setText(getString(i3, objArr2));
            a3.f53807f.setOnClickListener(new e(this, string2, string));
        }
        TextView textView6 = a3.f53810i;
        k.a((Object) textView6, "inviteMessage");
        int i4 = R.string.mt_invite_to_paytm;
        Object[] objArr3 = new Object[1];
        objArr3[0] = string2 == null ? string : string2;
        textView6.setText(getString(i4, objArr3));
        a3.f53802a.setOnClickListener(new f(this, string2, string));
        net.one97.paytm.moneytransfer.contacts.b.a aVar2 = this.f55655b;
        if (aVar2 == null) {
            k.a("contactsViewModel");
        }
        aVar2.f53972d.observe(getViewLifecycleOwner(), new g(this));
        net.one97.paytm.moneytransfer.utils.f.a(view.getContext(), CJRGTMConstants.MT_V4_INVITE_SCREEN_NAME);
    }

    /* renamed from: net.one97.paytm.moneytransferv4.invite.b$b  reason: collision with other inner class name */
    static final class C1034b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55657a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55658b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55659c;

        C1034b(b bVar, String str, String str2) {
            this.f55657a = bVar;
            this.f55658b = str;
            this.f55659c = str2;
        }

        public final void onClick(View view) {
            b.a(this.f55657a, "money_transfer_bankaccount");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55662c;

        c(b bVar, String str, String str2) {
            this.f55660a = bVar;
            this.f55661b = str;
            this.f55662c = str2;
        }

        public final void onClick(View view) {
            b.a(this.f55660a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55663a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55664b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55665c;

        d(b bVar, String str, String str2) {
            this.f55663a = bVar;
            this.f55664b = str;
            this.f55665c = str2;
        }

        public final void onClick(View view) {
            b.b(this.f55663a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55667b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55668c;

        e(b bVar, String str, String str2) {
            this.f55666a = bVar;
            this.f55667b = str;
            this.f55668c = str2;
        }

        public final void onClick(View view) {
            b.c(this.f55666a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55669a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55670b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55671c;

        f(b bVar, String str, String str2) {
            this.f55669a = bVar;
            this.f55670b = str;
            this.f55671c = str2;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f55669a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            net.one97.paytm.moneytransfer.utils.f.a(this.f55669a.getContext(), "mt_p2p_new_v1", "back_button_clicked", CJRGTMConstants.MT_V4_INVITE_SCREEN_NAME, "", "");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(String str, String str2) {
            k.c(str, "phoneNumber");
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putString(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("name", str2);
            } else {
                bundle.putString("name", str);
            }
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        Intent intent = new Intent(bVar.getContext(), MoneyTransferV4Activity.class);
        DeepLinkData deepLinkData = new DeepLinkData();
        deepLinkData.f50288f = str;
        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        bVar.startActivity(intent);
        net.one97.paytm.moneytransfer.utils.f.a(bVar.getContext(), "mt_p2p_new_v1", "to_bank_account_clicked", CJRGTMConstants.MT_V4_INVITE_SCREEN_NAME, "", "");
    }

    public static final /* synthetic */ void a(b bVar) {
        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
        String a2 = net.one97.paytm.moneytransfer.d.c.a(c.a.a().z, "paytmmp://referral?tag=REFERRAL");
        if (bVar.getContext() != null) {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            Context context = bVar.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b2.a(context, a2);
        }
    }

    public static final /* synthetic */ void b(b bVar) {
        net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
        FragmentActivity requireActivity = bVar.requireActivity();
        k.a((Object) requireActivity, "requireActivity()");
        Intent a2 = net.one97.paytm.wallet.utility.d.a(requireActivity);
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        a2.putExtra(net.one97.paytm.contacts.utils.e.h(), e.C0905e.PAY.getType());
        bVar.startActivity(a2);
    }

    public static final /* synthetic */ void c(b bVar) {
        try {
            String str = " " + net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(bVar.getActivity(), UpiConstantServiceApi.KEY_APP_INVITE_LINK);
            if (TextUtils.isEmpty(str)) {
                str = " " + net.one97.paytm.wallet.utility.a.b();
            }
            String string = bVar.getString(R.string.invite_body, str);
            k.a((Object) string, "getString(R.string.invite_body, link_val)");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", bVar.getString(R.string.invite_subject));
            intent.putExtra("android.intent.extra.TEXT", string);
            Intent createChooser = Intent.createChooser(intent, bVar.getString(R.string.invite_title));
            FragmentActivity activity = bVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                bVar.startActivity(createChooser);
            } else {
                Toast.makeText(bVar.getActivity(), bVar.getString(R.string.no_app_found), 1).show();
            }
            net.one97.paytm.moneytransfer.utils.f.a(bVar.getContext(), "mt_p2p_new_v1", "invite_now_clicked", CJRGTMConstants.MT_V4_INVITE_SCREEN_NAME, "", "");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                y.b(net.one97.paytm.wallet.newdesign.b.b.class).b();
                q.d(e2.getMessage());
            }
        }
    }

    public static final /* synthetic */ void b(b bVar, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        Intent createChooser = Intent.createChooser(intent, "Share via");
        FragmentActivity activity = bVar.getActivity();
        if (activity != null) {
            activity.startActivity(createChooser);
        }
    }

    public static final /* synthetic */ void a(b bVar, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null || !upiCustomVolleyError.getmErrorCode().equals(UpiConstants.NETWORK_ERROR_CODE)) {
            Toast.makeText(bVar.getActivity(), net.one97.paytm.upi.R.string.upi_some_went_wrong, 0).show();
        } else {
            CustomDialog.showAlert(bVar.getActivity(), bVar.getString(net.one97.paytm.upi.R.string.no_connection), bVar.getString(net.one97.paytm.upi.R.string.no_internet_new_message));
        }
    }
}
