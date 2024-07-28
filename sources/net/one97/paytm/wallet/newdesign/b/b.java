package net.one97.paytm.wallet.newdesign.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import com.paytm.utility.q;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.y;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.l;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f70724a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f70725b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70726c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70727d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f70728e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f70729f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f70730g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f70731h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f70732i;
    private TextView j;
    private TextView k;
    private View l;
    private HashMap m;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f70724a = layoutInflater.inflate(R.layout.lyt_non_paytm_user_invite_bottom_sheet, viewGroup, false);
        Bundle arguments = getArguments();
        View view = null;
        this.f70725b = arguments != null ? arguments.getString("uni_p2p_btm_sheet_mobile_number", "") : null;
        View view2 = this.f70724a;
        this.f70726c = view2 != null ? (TextView) view2.findViewById(R.id.tv_no_paytm_wallet_linked_txt) : null;
        TextView textView = this.f70726c;
        if (textView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.no_paytm_wallet_linked_txt, l.a(this.f70725b));
            k.a((Object) string, "getString(R.string.no_pa…atMobileNumber(mobileNo))");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
        View view3 = this.f70724a;
        this.f70728e = view3 != null ? (RelativeLayout) view3.findViewById(R.id.rl_invite_number_to_paytm) : null;
        RelativeLayout relativeLayout = this.f70728e;
        this.f70727d = relativeLayout != null ? (TextView) relativeLayout.findViewById(R.id.tv_invite_number_to_paytm) : null;
        TextView textView2 = this.f70727d;
        if (textView2 != null) {
            aa aaVar2 = aa.f47921a;
            String string2 = getString(R.string.invite_number_to_paytm, l.a(this.f70725b));
            k.a((Object) string2, "getString(R.string.invit…atMobileNumber(mobileNo))");
            String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
            k.a((Object) format2, "java.lang.String.format(format, *args)");
            textView2.setText(format2);
        }
        View view4 = this.f70724a;
        this.f70729f = view4 != null ? (RelativeLayout) view4.findViewById(R.id.rl_send_money_other_mobile_no) : null;
        View view5 = this.f70724a;
        this.f70730g = view5 != null ? (ImageView) view5.findViewById(R.id.iv_close_icon) : null;
        View view6 = this.f70724a;
        this.f70732i = view6 != null ? (RelativeLayout) view6.findViewById(R.id.rl_call_number) : null;
        RelativeLayout relativeLayout2 = this.f70732i;
        this.k = relativeLayout2 != null ? (TextView) relativeLayout2.findViewById(R.id.tv_call_number) : null;
        View view7 = this.f70724a;
        this.j = view7 != null ? (TextView) view7.findViewById(R.id.tv_check_paytm_account_different_number) : null;
        View view8 = this.f70724a;
        if (view8 != null) {
            view = view8.findViewById(R.id.separator2);
        }
        this.l = view;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.getBoolean("uni_p2p_btm_sheet_from_contacts", false)) {
            RelativeLayout relativeLayout3 = this.f70732i;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            }
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.k;
            if (textView4 != null) {
                aa aaVar3 = aa.f47921a;
                String string3 = getString(R.string.call_number);
                k.a((Object) string3, "getString(R.string.call_number)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{l.a(this.f70725b)}, 1));
                k.a((Object) format3, "java.lang.String.format(format, *args)");
                textView4.setText(format3);
            }
            View view9 = this.l;
            if (view9 != null) {
                view9.setVisibility(0);
            }
        }
        RelativeLayout relativeLayout4 = this.f70728e;
        if (relativeLayout4 != null) {
            relativeLayout4.setOnClickListener(new a(this));
        }
        RelativeLayout relativeLayout5 = this.f70729f;
        if (relativeLayout5 != null) {
            relativeLayout5.setOnClickListener(new C1429b(this));
        }
        ImageView imageView = this.f70730g;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        RelativeLayout relativeLayout6 = this.f70732i;
        if (relativeLayout6 != null) {
            relativeLayout6.setOnClickListener(new d(this));
        }
        return this.f70724a;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f70731h = context;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70733a;

        a(b bVar) {
            this.f70733a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f70733a);
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.b.b$b  reason: collision with other inner class name */
    static final class C1429b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70734a;

        C1429b(b bVar) {
            this.f70734a = bVar;
        }

        public final void onClick(View view) {
            Context b2 = this.f70734a.f70731h;
            if (b2 != null) {
                k.a((Object) androidx.localbroadcastmanager.a.a.a(b2), "LocalBroadcastManager.getInstance(it)");
                Intent intent = new Intent("CLOSE_P2P_SCREEN");
                FragmentActivity activity = this.f70734a.getActivity();
                if (activity != null) {
                    activity.sendBroadcast(intent);
                }
                FragmentActivity activity2 = this.f70734a.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70735a;

        c(b bVar) {
            this.f70735a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity;
            if (this.f70735a.isAdded() && (activity = this.f70735a.getActivity()) != null && !activity.isFinishing()) {
                this.f70735a.dismissAllowingStateLoss();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70736a;

        d(b bVar) {
            this.f70736a = bVar;
        }

        public final void onClick(View view) {
            String c2 = this.f70736a.f70725b;
            if (c2 != null) {
                b.a(this.f70736a, c2);
            }
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final /* synthetic */ void a(b bVar) {
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
                net.one97.paytm.wallet.communicator.b.a().sendGTMOpenScreenWithDeviceInfo(bVar.getActivity(), "/Invite", "profile");
                bVar.startActivity(createChooser);
                return;
            }
            Toast.makeText(bVar.getActivity(), bVar.getString(R.string.no_app_found), 1).show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                y.b(b.class).b();
                q.d(e2.getMessage());
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:".concat(String.valueOf(str))));
        bVar.startActivity(intent);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
