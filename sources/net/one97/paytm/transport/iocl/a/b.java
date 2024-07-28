package net.one97.paytm.transport.iocl.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl.b.c;
import net.one97.paytm.transport.iocl.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends Fragment implements View.OnClickListener, com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f14214a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private NestedScrollView f14215b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f14216c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f14217d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f14218e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f14219f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f14220g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f14221h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f14222i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private View s;
    private IOCLCommonResponse t;
    private ImageView u;
    private View v;
    /* access modifiers changed from: private */
    public c w;
    private HashMap x;

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.transport.iocl.c.a a2;
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AJRIOCLHomeActivity)) {
            activity = null;
        }
        AJRIOCLHomeActivity aJRIOCLHomeActivity = (AJRIOCLHomeActivity) activity;
        if (!(aJRIOCLHomeActivity == null || (a2 = aJRIOCLHomeActivity.a()) == null)) {
            a2.a(false);
        }
        if (iJRPaytmDataModel != null) {
            IOCLBaseModel iOCLBaseModel = (IOCLBaseModel) iJRPaytmDataModel;
            if (p.a("FAILURE", iOCLBaseModel.getStatus(), true)) {
                if (iOCLBaseModel.getStatusMessage() != null && p.a(iOCLBaseModel.getStatusMessage(), "AUTH FAILED", true)) {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        ((IOCLBaseActivity) activity2).d();
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl.activity.IOCLBaseActivity");
                } else if (iOCLBaseModel.getStatusMessage() == null) {
                } else {
                    if (iOCLBaseModel.getStatusCode().equals("TR_3000")) {
                        net.one97.paytm.transport.iocl.b.b.a((Activity) getActivity(), iOCLBaseModel.getStatusMessage());
                        return;
                    }
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        ((IOCLBaseActivity) activity3).a(iOCLBaseModel.getStatusMessage());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl.activity.IOCLBaseActivity");
                }
            } else if (getActivity() != null) {
                FragmentActivity activity4 = getActivity();
                if (!(activity4 instanceof IOCLBaseActivity)) {
                    activity4 = null;
                }
                IOCLBaseActivity iOCLBaseActivity = (IOCLBaseActivity) activity4;
                if (iOCLBaseActivity != null) {
                    iOCLBaseActivity.a((Object) iJRPaytmDataModel);
                }
                FragmentActivity activity5 = getActivity();
                if (activity5 != null) {
                    activity5.finish();
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl.data.IOCLBaseModel");
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Object obj = null;
        if ((networkCustomError == null || networkCustomError.getStatusCode() != 401) && ((networkCustomError == null || networkCustomError.getStatusCode() != 410) && (networkCustomError == null || networkCustomError.getStatusCode() != 403))) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof AJRIOCLHomeActivity)) {
                activity = null;
            }
            AJRIOCLHomeActivity aJRIOCLHomeActivity = (AJRIOCLHomeActivity) activity;
            if (aJRIOCLHomeActivity != null) {
                aJRIOCLHomeActivity.a(networkCustomError != null ? networkCustomError.getMessage() : null);
            }
            if (networkCustomError != null) {
                obj = networkCustomError.getMessage();
            }
            if (obj != null) {
                c.a aVar = net.one97.paytm.transport.iocl.b.c.f14280a;
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                Context context = activity2;
                String message = networkCustomError.getMessage();
                if (message == null) {
                    k.a();
                }
                c.a.a(context, "iocl_xtrarewards", "redeem_points_clicked", "/iocl-xtrarewards", message);
                return;
            }
            return;
        }
        Object activity3 = getActivity();
        if (activity3 instanceof AJRIOCLHomeActivity) {
            obj = activity3;
        }
        AJRIOCLHomeActivity aJRIOCLHomeActivity2 = (AJRIOCLHomeActivity) obj;
        if (aJRIOCLHomeActivity2 != null) {
            aJRIOCLHomeActivity2.a(net.one97.paytm.transport.iocl.b.b.f14272d, networkCustomError);
        }
    }

    public final void onClick(View view) {
        net.one97.paytm.transport.iocl.c.a a2;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.iocl_redeem_points_btn;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.iocl_wallet_btn;
            if (valueOf != null && valueOf.intValue() == i3) {
                c.a aVar = net.one97.paytm.transport.iocl.b.c.f14280a;
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                c.a.a(activity, "iocl_xtrarewards", CJRGTMConstants.MT_V4_VIEW_PASSBOOK_CLICKED, "/iocl-xtrarewards", "landing_screen");
                net.one97.paytm.transport.iocl.a.b().launchDeeplink("paytmmp://cash_wallet?featuretype=cash_ledger", getActivity(), "");
                return;
            }
            int i4 = R.id.iocl_enroll_btn;
            if (valueOf != null && valueOf.intValue() == i4) {
                Context context = view.getContext();
                if (!(context instanceof IOCLBaseActivity)) {
                    context = null;
                }
                IOCLBaseActivity iOCLBaseActivity = (IOCLBaseActivity) context;
                if (iOCLBaseActivity != null) {
                    iOCLBaseActivity.b();
                    return;
                }
                return;
            }
            int i5 = R.id.iocl_pay_btn;
            if (valueOf != null && valueOf.intValue() == i5) {
                c.a aVar2 = net.one97.paytm.transport.iocl.b.c.f14280a;
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                c.a.a(activity2, "iocl_xtrarewards", "pay_now_clicked", "/iocl-xtrarewards", "");
                try {
                    net.one97.paytm.transport.iocl.b b2 = net.one97.paytm.transport.iocl.a.b();
                    k.a((Object) b2, "IOCLController.getInstan…().getIoclEventListener()");
                    Intent intent = new Intent(getActivity(), b2.getPaySendActivity().getClass());
                    intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
                    startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent(getActivity(), Class.forName("net.one97.paytm.wallet.newdesign.activity.PaySendActivity"));
                    intent2.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
                    startActivity(intent2);
                }
            } else {
                int i6 = R.id.iocl_know_more_btn;
                if (valueOf != null && valueOf.intValue() == i6) {
                    c.a aVar3 = net.one97.paytm.transport.iocl.b.c.f14280a;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 == null) {
                        k.a();
                    }
                    k.a((Object) activity3, "activity!!");
                    c.a.a(activity3, "iocl_xtrarewards", "know_more_clicked", "/iocl-xtrarewards", "");
                    Context context2 = view.getContext();
                    if (!(context2 instanceof IOCLBaseActivity)) {
                        context2 = null;
                    }
                    IOCLBaseActivity iOCLBaseActivity2 = (IOCLBaseActivity) context2;
                    if (iOCLBaseActivity2 != null) {
                        iOCLBaseActivity2.c();
                        return;
                    }
                    return;
                }
                int i7 = R.id.profile_failed_container;
                if (valueOf != null && valueOf.intValue() == i7) {
                    Context context3 = view.getContext();
                    if (!(context3 instanceof IOCLBaseActivity)) {
                        context3 = null;
                    }
                    IOCLBaseActivity iOCLBaseActivity3 = (IOCLBaseActivity) context3;
                    if (iOCLBaseActivity3 != null) {
                        iOCLBaseActivity3.b();
                    }
                }
            }
        } else if (com.paytm.utility.b.c((Context) getActivity())) {
            FragmentActivity activity4 = getActivity();
            if (!(activity4 instanceof AJRIOCLHomeActivity)) {
                activity4 = null;
            }
            AJRIOCLHomeActivity aJRIOCLHomeActivity = (AJRIOCLHomeActivity) activity4;
            if (!(aJRIOCLHomeActivity == null || (a2 = aJRIOCLHomeActivity.a()) == null)) {
                a2.a(true);
            }
            c.a aVar4 = net.one97.paytm.transport.iocl.b.c.f14280a;
            FragmentActivity activity5 = getActivity();
            if (activity5 == null) {
                k.a();
            }
            k.a((Object) activity5, "activity!!");
            c.a.a(activity5, "iocl_xtrarewards", "points_redeemed_clicked", "/iocl-xtrarewards", "");
            if (com.paytm.utility.b.r((Context) getActivity())) {
                net.one97.paytm.transport.iocl.b.b.a(view.getContext(), (com.paytm.network.listener.b) new c(this), this.t);
                return;
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(403);
            FragmentActivity activity6 = getActivity();
            if (activity6 != null) {
                ((IOCLBaseActivity) activity6).a(net.one97.paytm.transport.iocl.b.b.f14275g, networkCustomError);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl.activity.IOCLBaseActivity");
        } else {
            FragmentActivity activity7 = getActivity();
            if (activity7 != null) {
                getString(R.string.iocl_no_connection);
                ((IOCLBaseActivity) activity7).a(getString(R.string.iocl_no_internet));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl.activity.IOCLBaseActivity");
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14224a;

        c(b bVar) {
            this.f14224a = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f14224a.onApiSuccess(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if ((networkCustomError == null || networkCustomError.getStatusCode() != 401) && ((networkCustomError == null || networkCustomError.getStatusCode() != 410) && (networkCustomError == null || networkCustomError.getStatusCode() != 403))) {
                this.f14224a.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                return;
            }
            FragmentActivity activity = this.f14224a.getActivity();
            if (activity != null) {
                ((IOCLBaseActivity) activity).a(net.one97.paytm.transport.iocl.b.b.f14275g, networkCustomError);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl.activity.IOCLBaseActivity");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:223:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x05c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r12, android.view.ViewGroup r13, android.os.Bundle r14) {
        /*
            r11 = this;
            java.lang.String r14 = "inflater"
            kotlin.g.b.k.c(r12, r14)
            int r14 = net.one97.paytm.iocl.R.layout.iocl_view_balance
            r0 = 0
            android.view.View r12 = r12.inflate(r14, r13, r0)
            r11.v = r12
            android.view.View r12 = r11.v
            android.os.Bundle r13 = r11.getArguments()
            r14 = 0
            if (r13 == 0) goto L_0x001e
            java.lang.String r1 = "IOCL_DATA"
            java.io.Serializable r13 = r13.getSerializable(r1)
            goto L_0x001f
        L_0x001e:
            r13 = r14
        L_0x001f:
            boolean r1 = r13 instanceof net.one97.paytm.transport.iocl.data.IOCLCommonResponse
            if (r1 != 0) goto L_0x0024
            r13 = r14
        L_0x0024:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r13 = (net.one97.paytm.transport.iocl.data.IOCLCommonResponse) r13
            r11.t = r13
            if (r12 == 0) goto L_0x0033
            int r13 = net.one97.paytm.iocl.R.id.nested_root_view
            android.view.View r13 = r12.findViewById(r13)
            androidx.core.widget.NestedScrollView r13 = (androidx.core.widget.NestedScrollView) r13
            goto L_0x0034
        L_0x0033:
            r13 = r14
        L_0x0034:
            r11.f14215b = r13
            if (r12 == 0) goto L_0x0041
            int r13 = net.one97.paytm.iocl.R.id.tv_member_id
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x0042
        L_0x0041:
            r13 = r14
        L_0x0042:
            r11.f14216c = r13
            if (r12 == 0) goto L_0x004f
            int r13 = net.one97.paytm.iocl.R.id.iocl_redeem_points_text
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x0050
        L_0x004f:
            r13 = r14
        L_0x0050:
            r11.f14217d = r13
            if (r12 == 0) goto L_0x005d
            int r13 = net.one97.paytm.iocl.R.id.primary_message
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x005e
        L_0x005d:
            r13 = r14
        L_0x005e:
            r11.f14218e = r13
            if (r12 == 0) goto L_0x006b
            int r13 = net.one97.paytm.iocl.R.id.secondary_message
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x006c
        L_0x006b:
            r13 = r14
        L_0x006c:
            r11.f14219f = r13
            if (r12 == 0) goto L_0x0079
            int r13 = net.one97.paytm.iocl.R.id.other_message
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x007a
        L_0x0079:
            r13 = r14
        L_0x007a:
            r11.f14221h = r13
            if (r12 == 0) goto L_0x0087
            int r13 = net.one97.paytm.iocl.R.id.iocl_profile_image
            android.view.View r13 = r12.findViewById(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            goto L_0x0088
        L_0x0087:
            r13 = r14
        L_0x0088:
            r11.u = r13
            if (r12 == 0) goto L_0x0095
            int r13 = net.one97.paytm.iocl.R.id.iocl_wallet_btn
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x0096
        L_0x0095:
            r13 = r14
        L_0x0096:
            r11.f14222i = r13
            if (r12 == 0) goto L_0x00a3
            int r13 = net.one97.paytm.iocl.R.id.iocl_enroll_btn
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x00a4
        L_0x00a3:
            r13 = r14
        L_0x00a4:
            r11.j = r13
            if (r12 == 0) goto L_0x00b1
            int r13 = net.one97.paytm.iocl.R.id.iocl_pay_btn
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x00b2
        L_0x00b1:
            r13 = r14
        L_0x00b2:
            r11.k = r13
            if (r12 == 0) goto L_0x00bf
            int r13 = net.one97.paytm.iocl.R.id.iocl_know_more_btn
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x00c0
        L_0x00bf:
            r13 = r14
        L_0x00c0:
            r11.l = r13
            if (r12 == 0) goto L_0x00cd
            int r13 = net.one97.paytm.iocl.R.id.updated_date
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x00ce
        L_0x00cd:
            r13 = r14
        L_0x00ce:
            r11.m = r13
            if (r12 == 0) goto L_0x00db
            int r13 = net.one97.paytm.iocl.R.id.minimum_redeem_message
            android.view.View r13 = r12.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            goto L_0x00dc
        L_0x00db:
            r13 = r14
        L_0x00dc:
            r11.f14220g = r13
            if (r12 == 0) goto L_0x00e7
            int r13 = net.one97.paytm.iocl.R.id.non_registered_container
            android.view.View r13 = r12.findViewById(r13)
            goto L_0x00e8
        L_0x00e7:
            r13 = r14
        L_0x00e8:
            r11.n = r13
            if (r12 == 0) goto L_0x00f3
            int r13 = net.one97.paytm.iocl.R.id.reward_points_container
            android.view.View r13 = r12.findViewById(r13)
            goto L_0x00f4
        L_0x00f3:
            r13 = r14
        L_0x00f4:
            r11.s = r13
            if (r12 == 0) goto L_0x00ff
            int r13 = net.one97.paytm.iocl.R.id.requested_container
            android.view.View r13 = r12.findViewById(r13)
            goto L_0x0100
        L_0x00ff:
            r13 = r14
        L_0x0100:
            r11.o = r13
            if (r12 == 0) goto L_0x010b
            int r13 = net.one97.paytm.iocl.R.id.profile_failed_container
            android.view.View r13 = r12.findViewById(r13)
            goto L_0x010c
        L_0x010b:
            r13 = r14
        L_0x010c:
            r11.p = r13
            if (r12 == 0) goto L_0x0117
            int r13 = net.one97.paytm.iocl.R.id.registered_container
            android.view.View r13 = r12.findViewById(r13)
            goto L_0x0118
        L_0x0117:
            r13 = r14
        L_0x0118:
            r11.q = r13
            if (r12 == 0) goto L_0x0123
            int r13 = net.one97.paytm.iocl.R.id.primary_message_container
            android.view.View r13 = r12.findViewById(r13)
            goto L_0x0124
        L_0x0123:
            r13 = r14
        L_0x0124:
            r11.r = r13
            if (r12 == 0) goto L_0x0131
            int r13 = net.one97.paytm.iocl.R.id.iocl_redeem_points_btn
            android.view.View r12 = r12.findViewById(r13)
            android.widget.TextView r12 = (android.widget.TextView) r12
            goto L_0x0132
        L_0x0131:
            r12 = r14
        L_0x0132:
            if (r12 == 0) goto L_0x013a
            r13 = r11
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
        L_0x013a:
            android.widget.TextView r12 = r11.f14222i
            if (r12 == 0) goto L_0x0144
            r13 = r11
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
        L_0x0144:
            android.widget.TextView r12 = r11.j
            if (r12 == 0) goto L_0x014e
            r13 = r11
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
        L_0x014e:
            android.widget.TextView r12 = r11.k
            if (r12 == 0) goto L_0x0158
            r13 = r11
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
        L_0x0158:
            android.widget.TextView r12 = r11.l
            if (r12 == 0) goto L_0x0162
            r13 = r11
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
        L_0x0162:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x016c
            r13 = r11
            android.view.View$OnClickListener r13 = (android.view.View.OnClickListener) r13
            r12.setOnClickListener(r13)
        L_0x016c:
            android.widget.TextView r12 = r11.f14217d
            java.lang.String r13 = "java.lang.String.format(format, *args)"
            r1 = 1
            if (r12 == 0) goto L_0x019b
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r3 = r11.t
            if (r3 == 0) goto L_0x0186
            net.one97.paytm.transport.iocl.data.Rewards r3 = r3.getRewards()
            if (r3 == 0) goto L_0x0186
            java.lang.Long r3 = r3.getPoints()
            goto L_0x0187
        L_0x0186:
            r3 = r14
        L_0x0187:
            r2[r0] = r3
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r3 = "%d"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
        L_0x019b:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x01aa
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x01aa
            java.lang.String r12 = r12.getMemberNumber()
            goto L_0x01ab
        L_0x01aa:
            r12 = r14
        L_0x01ab:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x01b8
            int r12 = r12.length()
            if (r12 != 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r12 = 0
            goto L_0x01b9
        L_0x01b8:
            r12 = 1
        L_0x01b9:
            if (r12 != 0) goto L_0x01fb
            android.widget.TextView r12 = r11.f14216c
            if (r12 == 0) goto L_0x01c2
            r12.setVisibility(r0)
        L_0x01c2:
            android.widget.TextView r12 = r11.f14216c
            if (r12 == 0) goto L_0x01fb
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.iocl.R.string.iocl_member_id
            java.lang.String r2 = r11.getString(r2)
            java.lang.String r3 = "getString(R.string.iocl_member_id)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r4 = r11.t
            if (r4 != 0) goto L_0x01dc
            kotlin.g.b.k.a()
        L_0x01dc:
            net.one97.paytm.transport.iocl.data.User r4 = r4.getUser()
            java.lang.String r5 = "mResponse!!.user"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getMemberNumber()
            r3[r0] = r4
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
        L_0x01fb:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x020a
            net.one97.paytm.transport.iocl.data.Rewards r12 = r12.getRewards()
            if (r12 == 0) goto L_0x020a
            java.lang.Long r12 = r12.getUpdatedTime()
            goto L_0x020b
        L_0x020a:
            r12 = r14
        L_0x020b:
            r2 = 0
            if (r12 == 0) goto L_0x027f
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x021e
            net.one97.paytm.transport.iocl.data.Rewards r12 = r12.getRewards()
            if (r12 == 0) goto L_0x021e
            java.lang.Long r12 = r12.getUpdatedTime()
            goto L_0x021f
        L_0x021e:
            r12 = r14
        L_0x021f:
            if (r12 != 0) goto L_0x0224
            kotlin.g.b.k.a()
        L_0x0224:
            long r4 = r12.longValue()
            int r12 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x027f
            android.widget.TextView r12 = r11.m
            if (r12 == 0) goto L_0x027f
            kotlin.g.b.aa r4 = kotlin.g.b.aa.f47921a
            int r4 = net.one97.paytm.iocl.R.string.iocl_updated_balance
            java.lang.String r4 = r11.getString(r4)
            java.lang.String r5 = "getString(R.string.iocl_updated_balance)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r6 = r11.t
            if (r6 == 0) goto L_0x024e
            net.one97.paytm.transport.iocl.data.Rewards r6 = r6.getRewards()
            if (r6 == 0) goto L_0x024e
            java.lang.Long r6 = r6.getUpdatedTime()
            goto L_0x024f
        L_0x024e:
            r6 = r14
        L_0x024f:
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            java.lang.String r8 = "dd-MM-yyyy HH:mm"
            r7.<init>(r8)
            java.util.Date r8 = new java.util.Date
            if (r6 != 0) goto L_0x025d
            kotlin.g.b.k.a()
        L_0x025d:
            long r9 = r6.longValue()
            r8.<init>(r9)
            java.lang.String r6 = r7.format(r8)
            java.lang.String r7 = "sdf.format(date)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r5[r0] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)
            java.lang.String r4 = java.lang.String.format(r4, r5)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r13)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r12.setText(r4)
        L_0x027f:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x0290
            androidx.fragment.app.j r12 = r12.getSupportFragmentManager()
            if (r12 == 0) goto L_0x0290
            androidx.fragment.app.q r12 = r12.a()
            goto L_0x0291
        L_0x0290:
            r12 = r14
        L_0x0291:
            net.one97.paytm.transport.iocl.a.c r4 = new net.one97.paytm.transport.iocl.a.c
            r4.<init>()
            r11.w = r4
            if (r12 == 0) goto L_0x02ae
            int r4 = net.one97.paytm.iocl.R.id.video_container
            net.one97.paytm.transport.iocl.a.c r5 = r11.w
            if (r5 != 0) goto L_0x02a3
            kotlin.g.b.k.a()
        L_0x02a3:
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            androidx.fragment.app.q r12 = r12.b(r4, r5)
            if (r12 == 0) goto L_0x02ae
            r12.c()
        L_0x02ae:
            android.widget.ImageView r12 = r11.u
            r4 = 8
            if (r12 == 0) goto L_0x02b7
            r12.setVisibility(r4)
        L_0x02b7:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x02c0
            java.lang.String r12 = r12.getPrimaryMessage()
            goto L_0x02c1
        L_0x02c0:
            r12 = r14
        L_0x02c1:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x02e4
            android.view.View r12 = r11.r
            if (r12 == 0) goto L_0x02d0
            r12.setVisibility(r0)
        L_0x02d0:
            android.widget.TextView r12 = r11.f14218e
            if (r12 == 0) goto L_0x02eb
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r5 = r11.t
            if (r5 == 0) goto L_0x02dd
            java.lang.String r5 = r5.getPrimaryMessage()
            goto L_0x02de
        L_0x02dd:
            r5 = r14
        L_0x02de:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            goto L_0x02eb
        L_0x02e4:
            android.view.View r12 = r11.r
            if (r12 == 0) goto L_0x02eb
            r12.setVisibility(r4)
        L_0x02eb:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x02f4
            net.one97.paytm.transport.iocl.data.Rewards r12 = r12.getRewards()
            goto L_0x02f5
        L_0x02f4:
            r12 = r14
        L_0x02f5:
            if (r12 == 0) goto L_0x0311
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x0306
            net.one97.paytm.transport.iocl.data.Rewards r12 = r12.getRewards()
            if (r12 == 0) goto L_0x0306
            java.lang.Long r12 = r12.getPoints()
            goto L_0x0307
        L_0x0306:
            r12 = r14
        L_0x0307:
            if (r12 == 0) goto L_0x0311
            android.view.View r12 = r11.s
            if (r12 == 0) goto L_0x0318
            r12.setVisibility(r0)
            goto L_0x0318
        L_0x0311:
            android.view.View r12 = r11.s
            if (r12 == 0) goto L_0x0318
            r12.setVisibility(r4)
        L_0x0318:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x0327
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x0327
            java.lang.String r12 = r12.getStatus()
            goto L_0x0328
        L_0x0327:
            r12 = r14
        L_0x0328:
            java.lang.String r5 = "NON_REGISTERED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x034e
            android.view.View r12 = r11.n
            if (r12 == 0) goto L_0x0337
            r12.setVisibility(r0)
        L_0x0337:
            android.view.View r12 = r11.o
            if (r12 == 0) goto L_0x033e
            r12.setVisibility(r4)
        L_0x033e:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x0345
            r12.setVisibility(r4)
        L_0x0345:
            android.view.View r12 = r11.q
            if (r12 == 0) goto L_0x05b0
            r12.setVisibility(r4)
            goto L_0x05b0
        L_0x034e:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x035d
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x035d
            java.lang.String r12 = r12.getStatus()
            goto L_0x035e
        L_0x035d:
            r12 = r14
        L_0x035e:
            java.lang.String r5 = "REGISTERED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x04a8
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x0445
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x0445
            boolean r12 = r12.isHasTransaction()
            if (r12 != r1) goto L_0x0445
            android.view.View r12 = r11.n
            if (r12 == 0) goto L_0x037d
            r12.setVisibility(r4)
        L_0x037d:
            android.view.View r12 = r11.o
            if (r12 == 0) goto L_0x0384
            r12.setVisibility(r4)
        L_0x0384:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x038b
            r12.setVisibility(r4)
        L_0x038b:
            android.view.View r12 = r11.q
            if (r12 == 0) goto L_0x0392
            r12.setVisibility(r0)
        L_0x0392:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x03a6
            net.one97.paytm.transport.iocl.data.Rewards r12 = r12.getRewards()
            if (r12 == 0) goto L_0x03a6
            java.lang.Long r12 = r12.getPoints()
            if (r12 == 0) goto L_0x03a6
            long r2 = r12.longValue()
        L_0x03a6:
            double r2 = (double) r2
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x03b6
            java.lang.Double r12 = r12.getMinimumRedemptionPoints()
            if (r12 == 0) goto L_0x03b6
            double r5 = r12.doubleValue()
            goto L_0x03b8
        L_0x03b6:
            r5 = 0
        L_0x03b8:
            int r12 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x040b
            android.widget.TextView r12 = r11.f14220g
            if (r12 == 0) goto L_0x03c3
            r12.setVisibility(r0)
        L_0x03c3:
            android.widget.TextView r12 = r11.f14220g
            if (r12 == 0) goto L_0x0412
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.iocl.R.string.iocl_minimum_redeem_points
            java.lang.String r2 = r11.getString(r2)
            java.lang.String r3 = "getString(R.string.iocl_minimum_redeem_points)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            kotlin.g.b.aa r5 = kotlin.g.b.aa.f47921a
            java.lang.Object[] r5 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r6 = r11.t
            if (r6 == 0) goto L_0x03e3
            java.lang.Double r6 = r6.getMinimumRedemptionPoints()
            goto L_0x03e4
        L_0x03e3:
            r6 = r14
        L_0x03e4:
            if (r6 != 0) goto L_0x03e9
            kotlin.g.b.k.a()
        L_0x03e9:
            r5[r0] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)
            java.lang.String r6 = "%.0f"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
            r3[r0] = r5
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r1)
            java.lang.String r0 = java.lang.String.format(r2, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            goto L_0x0412
        L_0x040b:
            android.widget.TextView r12 = r11.f14220g
            if (r12 == 0) goto L_0x0412
            r12.setVisibility(r4)
        L_0x0412:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x042b
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x042b
            boolean r12 = r12.isHaveFuelWallet()
            if (r12 != r1) goto L_0x042b
            android.view.View r12 = r11.r
            if (r12 == 0) goto L_0x05b0
            r12.setVisibility(r4)
            goto L_0x05b0
        L_0x042b:
            android.widget.TextView r12 = r11.f14222i
            if (r12 == 0) goto L_0x0432
            r12.setVisibility(r4)
        L_0x0432:
            android.view.View r12 = r11.v
            if (r12 == 0) goto L_0x043d
            int r13 = net.one97.paytm.iocl.R.id.wallet_sep_line
            android.view.View r12 = r12.findViewById(r13)
            goto L_0x043e
        L_0x043d:
            r12 = r14
        L_0x043e:
            if (r12 == 0) goto L_0x05b0
            r12.setVisibility(r4)
            goto L_0x05b0
        L_0x0445:
            android.view.View r12 = r11.n
            if (r12 == 0) goto L_0x044c
            r12.setVisibility(r4)
        L_0x044c:
            android.view.View r12 = r11.o
            if (r12 == 0) goto L_0x0453
            r12.setVisibility(r0)
        L_0x0453:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x045a
            r12.setVisibility(r4)
        L_0x045a:
            android.view.View r12 = r11.q
            if (r12 == 0) goto L_0x0461
            r12.setVisibility(r4)
        L_0x0461:
            android.view.View r12 = r11.r
            if (r12 == 0) goto L_0x0468
            r12.setVisibility(r4)
        L_0x0468:
            android.widget.TextView r12 = r11.f14221h
            if (r12 == 0) goto L_0x046f
            r12.setVisibility(r0)
        L_0x046f:
            android.widget.TextView r12 = r11.f14221h
            if (r12 == 0) goto L_0x0482
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r13 = r11.t
            if (r13 == 0) goto L_0x047c
            java.lang.String r13 = r13.getPrimaryMessage()
            goto L_0x047d
        L_0x047c:
            r13 = r14
        L_0x047d:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
        L_0x0482:
            android.view.View r12 = r11.s
            if (r12 == 0) goto L_0x0489
            r12.setVisibility(r4)
        L_0x0489:
            android.widget.ImageView r12 = r11.u
            if (r12 == 0) goto L_0x049f
            android.content.Context r13 = r11.getContext()
            if (r13 != 0) goto L_0x0496
            kotlin.g.b.k.a()
        L_0x0496:
            int r1 = net.one97.paytm.iocl.R.drawable.iocl_rewards_image
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r13, (int) r1)
            r12.setImageDrawable(r13)
        L_0x049f:
            android.widget.ImageView r12 = r11.u
            if (r12 == 0) goto L_0x05b0
            r12.setVisibility(r0)
            goto L_0x05b0
        L_0x04a8:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x04b7
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x04b7
            java.lang.String r12 = r12.getStatus()
            goto L_0x04b8
        L_0x04b7:
            r12 = r14
        L_0x04b8:
            java.lang.String r13 = "USER_REQUESTED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r12, (boolean) r1)
            if (r12 != 0) goto L_0x054d
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x04cf
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x04cf
            java.lang.String r12 = r12.getStatus()
            goto L_0x04d0
        L_0x04cf:
            r12 = r14
        L_0x04d0:
            java.lang.String r13 = "REQUEST_INITIATED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x04da
            goto L_0x054d
        L_0x04da:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x04e9
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x04e9
            java.lang.String r12 = r12.getStatus()
            goto L_0x04ea
        L_0x04e9:
            r12 = r14
        L_0x04ea:
            java.lang.String r13 = "FAILED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x05b0
            android.view.View r12 = r11.n
            if (r12 == 0) goto L_0x04f9
            r12.setVisibility(r4)
        L_0x04f9:
            android.view.View r12 = r11.o
            if (r12 == 0) goto L_0x0500
            r12.setVisibility(r4)
        L_0x0500:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x0507
            r12.setVisibility(r0)
        L_0x0507:
            android.view.View r12 = r11.q
            if (r12 == 0) goto L_0x050e
            r12.setVisibility(r4)
        L_0x050e:
            android.widget.TextView r12 = r11.f14221h
            if (r12 == 0) goto L_0x0515
            r12.setVisibility(r0)
        L_0x0515:
            android.widget.TextView r12 = r11.f14221h
            if (r12 == 0) goto L_0x0528
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r13 = r11.t
            if (r13 == 0) goto L_0x0522
            java.lang.String r13 = r13.getSecondaryMessage()
            goto L_0x0523
        L_0x0522:
            r13 = r14
        L_0x0523:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
        L_0x0528:
            android.widget.ImageView r12 = r11.u
            if (r12 == 0) goto L_0x053e
            android.content.Context r13 = r11.getContext()
            if (r13 != 0) goto L_0x0535
            kotlin.g.b.k.a()
        L_0x0535:
            int r1 = net.one97.paytm.iocl.R.drawable.iocl_profile_failed
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r13, (int) r1)
            r12.setImageDrawable(r13)
        L_0x053e:
            android.widget.ImageView r12 = r11.u
            if (r12 == 0) goto L_0x0545
            r12.setVisibility(r0)
        L_0x0545:
            android.view.View r12 = r11.s
            if (r12 == 0) goto L_0x05b0
            r12.setVisibility(r4)
            goto L_0x05b0
        L_0x054d:
            android.view.View r12 = r11.n
            if (r12 == 0) goto L_0x0554
            r12.setVisibility(r4)
        L_0x0554:
            android.view.View r12 = r11.o
            if (r12 == 0) goto L_0x055b
            r12.setVisibility(r0)
        L_0x055b:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x0562
            r12.setVisibility(r4)
        L_0x0562:
            android.view.View r12 = r11.q
            if (r12 == 0) goto L_0x0569
            r12.setVisibility(r4)
        L_0x0569:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r12 = r11.t
            if (r12 == 0) goto L_0x05b0
            net.one97.paytm.transport.iocl.data.User r12 = r12.getUser()
            if (r12 == 0) goto L_0x05b0
            boolean r12 = r12.isHasTransaction()
            if (r12 != 0) goto L_0x05b0
            android.widget.TextView r12 = r11.f14221h
            if (r12 == 0) goto L_0x0580
            r12.setVisibility(r0)
        L_0x0580:
            android.widget.TextView r12 = r11.f14221h
            if (r12 == 0) goto L_0x0593
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r13 = r11.t
            if (r13 == 0) goto L_0x058d
            java.lang.String r13 = r13.getSecondaryMessage()
            goto L_0x058e
        L_0x058d:
            r13 = r14
        L_0x058e:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
        L_0x0593:
            android.widget.ImageView r12 = r11.u
            if (r12 == 0) goto L_0x05a9
            android.content.Context r13 = r11.getContext()
            if (r13 != 0) goto L_0x05a0
            kotlin.g.b.k.a()
        L_0x05a0:
            int r1 = net.one97.paytm.iocl.R.drawable.iocl_creating_profile
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r13, (int) r1)
            r12.setImageDrawable(r13)
        L_0x05a9:
            android.widget.ImageView r12 = r11.u
            if (r12 == 0) goto L_0x05b0
            r12.setVisibility(r0)
        L_0x05b0:
            android.widget.TextView r12 = r11.f14219f
            if (r12 == 0) goto L_0x05c1
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r13 = r11.t
            if (r13 == 0) goto L_0x05bc
            java.lang.String r14 = r13.getSecondaryMessage()
        L_0x05bc:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r12.setText(r14)
        L_0x05c1:
            androidx.core.widget.NestedScrollView r12 = r11.f14215b
            if (r12 == 0) goto L_0x05cf
            net.one97.paytm.transport.iocl.a.b$b r13 = new net.one97.paytm.transport.iocl.a.b$b
            r13.<init>(r11)
            androidx.core.widget.NestedScrollView$b r13 = (androidx.core.widget.NestedScrollView.b) r13
            r12.setOnScrollChangeListener(r13)
        L_0x05cf:
            net.one97.paytm.transport.iocl.c r12 = net.one97.paytm.transport.iocl.a.c()
            androidx.fragment.app.FragmentActivity r13 = r11.getActivity()
            android.content.Context r13 = (android.content.Context) r13
            java.lang.String r14 = "/iocl-xtrarewards"
            r12.sendOpenScreenEvent(r13, r14)
            android.view.View r12 = r11.v
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.transport.iocl.a.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        j supportFragmentManager = activity.getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "activity!!.supportFragmentManager");
        int f2 = supportFragmentManager.f();
        for (int i2 = 0; i2 < f2; i2++) {
            supportFragmentManager.d();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        c cVar;
        View view;
        super.onActivityResult(i2, i3, intent);
        if (i2 == net.one97.paytm.transport.iocl.b.b.f14275g) {
            if (i3 == -1) {
                int i4 = R.id.iocl_redeem_points_btn;
                if (this.x == null) {
                    this.x = new HashMap();
                }
                View view2 = (View) this.x.get(Integer.valueOf(i4));
                if (view2 == null) {
                    View view3 = getView();
                    if (view3 == null) {
                        view = null;
                        ((TextView) view).performClick();
                    }
                    view2 = view3.findViewById(i4);
                    this.x.put(Integer.valueOf(i4), view2);
                }
                view = view2;
                ((TextView) view).performClick();
            }
        } else if (i2 == net.one97.paytm.transport.iocl.b.b.f14272d && (cVar = this.w) != null) {
            cVar.onActivityResult(i2, i3, intent);
        }
    }

    /* renamed from: net.one97.paytm.transport.iocl.a.b$b  reason: collision with other inner class name */
    static final class C0195b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14223a;

        C0195b(b bVar) {
            this.f14223a = bVar;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            c a2;
            if ((nestedScrollView != null ? nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) : null) != null) {
                View childAt = nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                k.a((Object) childAt, "v.getChildAt(v.childCount - 1)");
                if (i3 >= childAt.getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && i3 > i5 && (a2 = this.f14223a.w) != null) {
                    a2.a();
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.x;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final b a(Bundle bundle) {
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }
}
