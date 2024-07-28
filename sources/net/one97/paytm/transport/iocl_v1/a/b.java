package net.one97.paytm.transport.iocl_v1.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import kotlin.u;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl_v1.b.c;
import net.one97.paytm.transport.iocl_v1.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;
import net.one97.paytm.transport.iocl_v1.data.Rewards;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends Fragment implements View.OnClickListener, com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f14330a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private NestedScrollView f14331b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f14332c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f14333d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f14334e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f14335f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f14336g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f14337h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f14338i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private IOCLCommonResponse s;
    private ImageView t;
    private ImageView u;
    private View v;
    /* access modifiers changed from: private */
    public c w;
    private HashMap x;

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.transport.iocl_v1.c.b b2;
        if (iJRPaytmDataModel != null) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof AJRIOCLHomeActivity)) {
                activity = null;
            }
            AJRIOCLHomeActivity aJRIOCLHomeActivity = (AJRIOCLHomeActivity) activity;
            if (!(aJRIOCLHomeActivity == null || (b2 = aJRIOCLHomeActivity.b()) == null)) {
                b2.a(false);
            }
            IOCLBaseModel iOCLBaseModel = (IOCLBaseModel) iJRPaytmDataModel;
            IOCLCommonResponse response = iOCLBaseModel.getResponse();
            if (response != null) {
                IOCLCommonResponse iOCLCommonResponse = this.s;
                response.setRewards(iOCLCommonResponse != null ? iOCLCommonResponse.getRewards() : null);
            }
            if (k.a((Object) iOCLBaseModel.getStatus(), (Object) "SUCCESS")) {
                FragmentActivity activity2 = getActivity();
                if (!(activity2 instanceof AJRIOCLHomeActivity)) {
                    activity2 = null;
                }
                AJRIOCLHomeActivity aJRIOCLHomeActivity2 = (AJRIOCLHomeActivity) activity2;
                if (aJRIOCLHomeActivity2 != null) {
                    aJRIOCLHomeActivity2.a(iOCLBaseModel.getResponse());
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(iOCLBaseModel.getStatusCode()) || !iOCLBaseModel.getStatusCode().equals("TR_3000")) {
                FragmentActivity activity3 = getActivity();
                if (!(activity3 instanceof AJRIOCLHomeActivity)) {
                    activity3 = null;
                }
                AJRIOCLHomeActivity aJRIOCLHomeActivity3 = (AJRIOCLHomeActivity) activity3;
                if (aJRIOCLHomeActivity3 != null) {
                    aJRIOCLHomeActivity3.a(iOCLBaseModel.getStatusMessage());
                }
            } else {
                net.one97.paytm.transport.iocl_v1.b.b.a((Activity) getActivity(), iOCLBaseModel.getStatusMessage());
            }
            if (iOCLBaseModel.getStatusMessage() != null) {
                c.a aVar = c.f14416a;
                FragmentActivity activity4 = getActivity();
                if (activity4 == null) {
                    k.a();
                }
                k.a((Object) activity4, "activity!!");
                String statusMessage = iOCLBaseModel.getStatusMessage();
                k.a((Object) statusMessage, "ioclResponse.statusMessage");
                c.a.a(activity4, "iocl_xtrarewards", "redeem_points_clicked", "/iocl-xtrarewards", statusMessage);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Object obj = null;
        if ((networkCustomError == null || networkCustomError.getStatusCode() != 401) && (networkCustomError == null || networkCustomError.getStatusCode() != 410)) {
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
                c.a aVar = c.f14416a;
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
            aJRIOCLHomeActivity2.f();
        }
    }

    public final void onClick(View view) {
        Rewards rewards;
        net.one97.paytm.transport.iocl_v1.c.b b2;
        Long l2 = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.iocl_redeem_points_btn;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.iocl_wallet_btn;
            if (valueOf != null && valueOf.intValue() == i3) {
                c.a aVar = c.f14416a;
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
                    iOCLBaseActivity.c();
                    return;
                }
                return;
            }
            int i5 = R.id.iocl_pay_btn;
            if (valueOf != null && valueOf.intValue() == i5) {
                c.a aVar2 = c.f14416a;
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                c.a.a(activity2, "iocl_xtrarewards", "pay_now_clicked", "/iocl-xtrarewards", "");
                try {
                    net.one97.paytm.transport.iocl.b b3 = net.one97.paytm.transport.iocl.a.b();
                    k.a((Object) b3, "IOCLController.getInstan…().getIoclEventListener()");
                    Intent intent = new Intent(getActivity(), b3.getPaySendActivity().getClass());
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
                    c.a aVar3 = c.f14416a;
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
                        iOCLBaseActivity2.d();
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
                        iOCLBaseActivity3.c();
                    }
                }
            }
        } else if (com.paytm.utility.b.c((Context) getActivity())) {
            FragmentActivity activity4 = getActivity();
            if (!(activity4 instanceof AJRIOCLHomeActivity)) {
                activity4 = null;
            }
            AJRIOCLHomeActivity aJRIOCLHomeActivity = (AJRIOCLHomeActivity) activity4;
            if (!(aJRIOCLHomeActivity == null || (b2 = aJRIOCLHomeActivity.b()) == null)) {
                b2.a(true);
            }
            c.a aVar4 = c.f14416a;
            FragmentActivity activity5 = getActivity();
            if (activity5 == null) {
                k.a();
            }
            k.a((Object) activity5, "activity!!");
            c.a.a(activity5, "iocl_xtrarewards", "points_redeemed_clicked", "/iocl-xtrarewards", "");
            if (com.paytm.utility.b.r((Context) getActivity())) {
                Context context4 = view.getContext();
                com.paytm.network.listener.b bVar = this;
                IOCLCommonResponse iOCLCommonResponse = this.s;
                if (!(iOCLCommonResponse == null || (rewards = iOCLCommonResponse.getRewards()) == null)) {
                    l2 = rewards.getPoints();
                }
                net.one97.paytm.transport.iocl_v1.b.b.a(context4, bVar, l2);
                return;
            }
            FragmentActivity activity6 = getActivity();
            if (activity6 != null) {
                ((IOCLBaseActivity) activity6).f();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity");
        } else {
            FragmentActivity activity7 = getActivity();
            if (activity7 != null) {
                getString(R.string.iocl_no_connection);
                ((IOCLBaseActivity) activity7).a(getString(R.string.iocl_no_internet));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:200:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0589  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x059a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12) {
        /*
            r9 = this;
            java.lang.String r12 = "inflater"
            kotlin.g.b.k.c(r10, r12)
            int r12 = net.one97.paytm.iocl.R.layout.iocl_view_balance_v1
            r0 = 0
            android.view.View r10 = r10.inflate(r12, r11, r0)
            r9.v = r10
            android.view.View r10 = r9.v
            android.os.Bundle r11 = r9.getArguments()
            r12 = 0
            if (r11 == 0) goto L_0x001e
            java.lang.String r1 = "IOCL_DATA"
            java.io.Serializable r11 = r11.getSerializable(r1)
            goto L_0x001f
        L_0x001e:
            r11 = r12
        L_0x001f:
            boolean r1 = r11 instanceof net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse
            if (r1 != 0) goto L_0x0024
            r11 = r12
        L_0x0024:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r11 = (net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse) r11
            r9.s = r11
            if (r10 == 0) goto L_0x0033
            int r11 = net.one97.paytm.iocl.R.id.nested_root_view
            android.view.View r11 = r10.findViewById(r11)
            androidx.core.widget.NestedScrollView r11 = (androidx.core.widget.NestedScrollView) r11
            goto L_0x0034
        L_0x0033:
            r11 = r12
        L_0x0034:
            r9.f14331b = r11
            if (r10 == 0) goto L_0x0041
            int r11 = net.one97.paytm.iocl.R.id.iocl_redeem_points_text
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x0042
        L_0x0041:
            r11 = r12
        L_0x0042:
            r9.f14332c = r11
            if (r10 == 0) goto L_0x004f
            int r11 = net.one97.paytm.iocl.R.id.primary_message
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x0050
        L_0x004f:
            r11 = r12
        L_0x0050:
            r9.f14333d = r11
            if (r10 == 0) goto L_0x005d
            int r11 = net.one97.paytm.iocl.R.id.secondary_message
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x005e
        L_0x005d:
            r11 = r12
        L_0x005e:
            r9.f14334e = r11
            if (r10 == 0) goto L_0x006b
            int r11 = net.one97.paytm.iocl.R.id.other_message
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x006c
        L_0x006b:
            r11 = r12
        L_0x006c:
            r9.f14336g = r11
            if (r10 == 0) goto L_0x0079
            int r11 = net.one97.paytm.iocl.R.id.iocl_logo
            android.view.View r11 = r10.findViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            goto L_0x007a
        L_0x0079:
            r11 = r12
        L_0x007a:
            r9.t = r11
            if (r10 == 0) goto L_0x0087
            int r11 = net.one97.paytm.iocl.R.id.iocl_profile_image
            android.view.View r11 = r10.findViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            goto L_0x0088
        L_0x0087:
            r11 = r12
        L_0x0088:
            r9.u = r11
            if (r10 == 0) goto L_0x0095
            int r11 = net.one97.paytm.iocl.R.id.iocl_wallet_btn
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x0096
        L_0x0095:
            r11 = r12
        L_0x0096:
            r9.f14337h = r11
            if (r10 == 0) goto L_0x00a3
            int r11 = net.one97.paytm.iocl.R.id.iocl_enroll_btn
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x00a4
        L_0x00a3:
            r11 = r12
        L_0x00a4:
            r9.f14338i = r11
            if (r10 == 0) goto L_0x00b1
            int r11 = net.one97.paytm.iocl.R.id.iocl_pay_btn
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x00b2
        L_0x00b1:
            r11 = r12
        L_0x00b2:
            r9.j = r11
            if (r10 == 0) goto L_0x00bf
            int r11 = net.one97.paytm.iocl.R.id.iocl_know_more_btn
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x00c0
        L_0x00bf:
            r11 = r12
        L_0x00c0:
            r9.k = r11
            if (r10 == 0) goto L_0x00cd
            int r11 = net.one97.paytm.iocl.R.id.updated_date
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x00ce
        L_0x00cd:
            r11 = r12
        L_0x00ce:
            r9.l = r11
            if (r10 == 0) goto L_0x00db
            int r11 = net.one97.paytm.iocl.R.id.minimum_redeem_message
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x00dc
        L_0x00db:
            r11 = r12
        L_0x00dc:
            r9.f14335f = r11
            if (r10 == 0) goto L_0x00e7
            int r11 = net.one97.paytm.iocl.R.id.non_registered_container
            android.view.View r11 = r10.findViewById(r11)
            goto L_0x00e8
        L_0x00e7:
            r11 = r12
        L_0x00e8:
            r9.m = r11
            if (r10 == 0) goto L_0x00f3
            int r11 = net.one97.paytm.iocl.R.id.reward_points_container
            android.view.View r11 = r10.findViewById(r11)
            goto L_0x00f4
        L_0x00f3:
            r11 = r12
        L_0x00f4:
            r9.r = r11
            if (r10 == 0) goto L_0x00ff
            int r11 = net.one97.paytm.iocl.R.id.requested_container
            android.view.View r11 = r10.findViewById(r11)
            goto L_0x0100
        L_0x00ff:
            r11 = r12
        L_0x0100:
            r9.n = r11
            if (r10 == 0) goto L_0x010b
            int r11 = net.one97.paytm.iocl.R.id.profile_failed_container
            android.view.View r11 = r10.findViewById(r11)
            goto L_0x010c
        L_0x010b:
            r11 = r12
        L_0x010c:
            r9.o = r11
            if (r10 == 0) goto L_0x0117
            int r11 = net.one97.paytm.iocl.R.id.registered_container
            android.view.View r11 = r10.findViewById(r11)
            goto L_0x0118
        L_0x0117:
            r11 = r12
        L_0x0118:
            r9.p = r11
            if (r10 == 0) goto L_0x0123
            int r11 = net.one97.paytm.iocl.R.id.primary_message_container
            android.view.View r11 = r10.findViewById(r11)
            goto L_0x0124
        L_0x0123:
            r11 = r12
        L_0x0124:
            r9.q = r11
            if (r10 == 0) goto L_0x0131
            int r11 = net.one97.paytm.iocl.R.id.iocl_redeem_points_btn
            android.view.View r10 = r10.findViewById(r11)
            android.widget.TextView r10 = (android.widget.TextView) r10
            goto L_0x0132
        L_0x0131:
            r10 = r12
        L_0x0132:
            if (r10 == 0) goto L_0x013a
            r11 = r9
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
        L_0x013a:
            android.widget.TextView r10 = r9.f14337h
            if (r10 == 0) goto L_0x0144
            r11 = r9
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
        L_0x0144:
            android.widget.TextView r10 = r9.f14338i
            if (r10 == 0) goto L_0x014e
            r11 = r9
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
        L_0x014e:
            android.widget.TextView r10 = r9.j
            if (r10 == 0) goto L_0x0158
            r11 = r9
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
        L_0x0158:
            android.widget.TextView r10 = r9.k
            if (r10 == 0) goto L_0x0162
            r11 = r9
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
        L_0x0162:
            android.view.View r10 = r9.o
            if (r10 == 0) goto L_0x016c
            r11 = r9
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
        L_0x016c:
            android.widget.TextView r10 = r9.f14332c
            java.lang.String r11 = "java.lang.String.format(format, *args)"
            r1 = 1
            if (r10 == 0) goto L_0x019b
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r3 = r9.s
            if (r3 == 0) goto L_0x0186
            net.one97.paytm.transport.iocl_v1.data.Rewards r3 = r3.getRewards()
            if (r3 == 0) goto L_0x0186
            java.lang.Long r3 = r3.getPoints()
            goto L_0x0187
        L_0x0186:
            r3 = r12
        L_0x0187:
            r2[r0] = r3
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r3 = "%d"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r10.setText(r2)
        L_0x019b:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x01aa
            net.one97.paytm.transport.iocl_v1.data.Rewards r10 = r10.getRewards()
            if (r10 == 0) goto L_0x01aa
            java.lang.Long r10 = r10.getUpdatedTime()
            goto L_0x01ab
        L_0x01aa:
            r10 = r12
        L_0x01ab:
            if (r10 == 0) goto L_0x021f
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x01bc
            net.one97.paytm.transport.iocl_v1.data.Rewards r10 = r10.getRewards()
            if (r10 == 0) goto L_0x01bc
            java.lang.Long r10 = r10.getUpdatedTime()
            goto L_0x01bd
        L_0x01bc:
            r10 = r12
        L_0x01bd:
            if (r10 != 0) goto L_0x01c2
            kotlin.g.b.k.a()
        L_0x01c2:
            long r2 = r10.longValue()
            r4 = 0
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x021f
            android.widget.TextView r10 = r9.l
            if (r10 == 0) goto L_0x021f
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.iocl.R.string.iocl_updated_balance
            java.lang.String r2 = r9.getString(r2)
            java.lang.String r3 = "getString(R.string.iocl_updated_balance)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r4 = r9.s
            if (r4 == 0) goto L_0x01ee
            net.one97.paytm.transport.iocl_v1.data.Rewards r4 = r4.getRewards()
            if (r4 == 0) goto L_0x01ee
            java.lang.Long r4 = r4.getUpdatedTime()
            goto L_0x01ef
        L_0x01ee:
            r4 = r12
        L_0x01ef:
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            java.lang.String r6 = "dd-MM-yyyy HH:mm"
            r5.<init>(r6)
            java.util.Date r6 = new java.util.Date
            if (r4 != 0) goto L_0x01fd
            kotlin.g.b.k.a()
        L_0x01fd:
            long r7 = r4.longValue()
            r6.<init>(r7)
            java.lang.String r4 = r5.format(r6)
            java.lang.String r5 = "sdf.format(date)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r3[r0] = r4
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r10.setText(r2)
        L_0x021f:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x0230
            androidx.fragment.app.j r10 = r10.getSupportFragmentManager()
            if (r10 == 0) goto L_0x0230
            androidx.fragment.app.q r10 = r10.a()
            goto L_0x0231
        L_0x0230:
            r10 = r12
        L_0x0231:
            net.one97.paytm.transport.iocl_v1.a.c r2 = new net.one97.paytm.transport.iocl_v1.a.c
            r2.<init>()
            r9.w = r2
            if (r10 == 0) goto L_0x024e
            int r2 = net.one97.paytm.iocl.R.id.video_container
            net.one97.paytm.transport.iocl_v1.a.c r3 = r9.w
            if (r3 != 0) goto L_0x0243
            kotlin.g.b.k.a()
        L_0x0243:
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            androidx.fragment.app.q r10 = r10.b(r2, r3)
            if (r10 == 0) goto L_0x024e
            r10.c()
        L_0x024e:
            android.widget.ImageView r10 = r9.u
            r2 = 8
            if (r10 == 0) goto L_0x0257
            r10.setVisibility(r2)
        L_0x0257:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0260
            java.lang.String r10 = r10.getPrimaryMessage()
            goto L_0x0261
        L_0x0260:
            r10 = r12
        L_0x0261:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0284
            android.view.View r10 = r9.q
            if (r10 == 0) goto L_0x0270
            r10.setVisibility(r0)
        L_0x0270:
            android.widget.TextView r10 = r9.f14333d
            if (r10 == 0) goto L_0x028b
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r3 = r9.s
            if (r3 == 0) goto L_0x027d
            java.lang.String r3 = r3.getPrimaryMessage()
            goto L_0x027e
        L_0x027d:
            r3 = r12
        L_0x027e:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r10.setText(r3)
            goto L_0x028b
        L_0x0284:
            android.view.View r10 = r9.q
            if (r10 == 0) goto L_0x028b
            r10.setVisibility(r2)
        L_0x028b:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0294
            net.one97.paytm.transport.iocl_v1.data.Rewards r10 = r10.getRewards()
            goto L_0x0295
        L_0x0294:
            r10 = r12
        L_0x0295:
            if (r10 == 0) goto L_0x02b1
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x02a6
            net.one97.paytm.transport.iocl_v1.data.Rewards r10 = r10.getRewards()
            if (r10 == 0) goto L_0x02a6
            java.lang.Long r10 = r10.getPoints()
            goto L_0x02a7
        L_0x02a6:
            r10 = r12
        L_0x02a7:
            if (r10 == 0) goto L_0x02b1
            android.view.View r10 = r9.r
            if (r10 == 0) goto L_0x02b8
            r10.setVisibility(r0)
            goto L_0x02b8
        L_0x02b1:
            android.view.View r10 = r9.r
            if (r10 == 0) goto L_0x02b8
            r10.setVisibility(r2)
        L_0x02b8:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x02c7
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x02c7
            java.lang.String r10 = r10.getStatus()
            goto L_0x02c8
        L_0x02c7:
            r10 = r12
        L_0x02c8:
            java.lang.String r3 = "NON_REGISTERED"
            boolean r10 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r10, (boolean) r1)
            if (r10 == 0) goto L_0x02ee
            android.view.View r10 = r9.m
            if (r10 == 0) goto L_0x02d7
            r10.setVisibility(r0)
        L_0x02d7:
            android.view.View r10 = r9.n
            if (r10 == 0) goto L_0x02de
            r10.setVisibility(r2)
        L_0x02de:
            android.view.View r10 = r9.o
            if (r10 == 0) goto L_0x02e5
            r10.setVisibility(r2)
        L_0x02e5:
            android.view.View r10 = r9.p
            if (r10 == 0) goto L_0x0585
            r10.setVisibility(r2)
            goto L_0x0585
        L_0x02ee:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x02fd
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x02fd
            java.lang.String r10 = r10.getStatus()
            goto L_0x02fe
        L_0x02fd:
            r10 = r12
        L_0x02fe:
            java.lang.String r3 = "REGISTERED"
            boolean r10 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r10, (boolean) r1)
            if (r10 == 0) goto L_0x046d
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0319
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x0319
            boolean r10 = r10.isHasTransaction()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x031a
        L_0x0319:
            r10 = r12
        L_0x031a:
            if (r10 != 0) goto L_0x031f
            kotlin.g.b.k.a()
        L_0x031f:
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x040a
            android.view.View r10 = r9.m
            if (r10 == 0) goto L_0x032c
            r10.setVisibility(r2)
        L_0x032c:
            android.view.View r10 = r9.n
            if (r10 == 0) goto L_0x0333
            r10.setVisibility(r2)
        L_0x0333:
            android.view.View r10 = r9.o
            if (r10 == 0) goto L_0x033a
            r10.setVisibility(r2)
        L_0x033a:
            android.view.View r10 = r9.p
            if (r10 == 0) goto L_0x0341
            r10.setVisibility(r0)
        L_0x0341:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0350
            net.one97.paytm.transport.iocl_v1.data.Rewards r10 = r10.getRewards()
            if (r10 == 0) goto L_0x0350
            java.lang.Long r10 = r10.getPoints()
            goto L_0x0351
        L_0x0350:
            r10 = r12
        L_0x0351:
            if (r10 != 0) goto L_0x0356
            kotlin.g.b.k.a()
        L_0x0356:
            long r3 = r10.longValue()
            double r3 = (double) r3
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0364
            java.lang.Double r10 = r10.getMinimumRedemptionPoints()
            goto L_0x0365
        L_0x0364:
            r10 = r12
        L_0x0365:
            if (r10 != 0) goto L_0x036a
            kotlin.g.b.k.a()
        L_0x036a:
            double r5 = r10.doubleValue()
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x03c1
            android.widget.TextView r10 = r9.f14335f
            if (r10 == 0) goto L_0x0379
            r10.setVisibility(r0)
        L_0x0379:
            android.widget.TextView r10 = r9.f14335f
            if (r10 == 0) goto L_0x03c8
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a
            int r3 = net.one97.paytm.iocl.R.string.iocl_minimum_redeem_points
            java.lang.String r3 = r9.getString(r3)
            java.lang.String r4 = "getString(R.string.iocl_minimum_redeem_points)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.Object[] r4 = new java.lang.Object[r1]
            kotlin.g.b.aa r5 = kotlin.g.b.aa.f47921a
            java.lang.Object[] r5 = new java.lang.Object[r1]
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r6 = r9.s
            if (r6 == 0) goto L_0x0399
            java.lang.Double r6 = r6.getMinimumRedemptionPoints()
            goto L_0x039a
        L_0x0399:
            r6 = r12
        L_0x039a:
            if (r6 != 0) goto L_0x039f
            kotlin.g.b.k.a()
        L_0x039f:
            r5[r0] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)
            java.lang.String r6 = "%.0f"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            r4[r0] = r5
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r0 = java.lang.String.format(r3, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.setText(r0)
            goto L_0x03c8
        L_0x03c1:
            android.widget.TextView r10 = r9.f14335f
            if (r10 == 0) goto L_0x03c8
            r10.setVisibility(r2)
        L_0x03c8:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x03db
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x03db
            boolean r10 = r10.isHaveFuelWallet()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x03dc
        L_0x03db:
            r10 = r12
        L_0x03dc:
            if (r10 != 0) goto L_0x03e1
            kotlin.g.b.k.a()
        L_0x03e1:
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x03f0
            android.view.View r10 = r9.q
            if (r10 == 0) goto L_0x0585
            r10.setVisibility(r2)
            goto L_0x0585
        L_0x03f0:
            android.widget.TextView r10 = r9.f14337h
            if (r10 == 0) goto L_0x03f7
            r10.setVisibility(r2)
        L_0x03f7:
            android.view.View r10 = r9.v
            if (r10 == 0) goto L_0x0402
            int r11 = net.one97.paytm.iocl.R.id.wallet_sep_line
            android.view.View r10 = r10.findViewById(r11)
            goto L_0x0403
        L_0x0402:
            r10 = r12
        L_0x0403:
            if (r10 == 0) goto L_0x0585
            r10.setVisibility(r2)
            goto L_0x0585
        L_0x040a:
            android.view.View r10 = r9.m
            if (r10 == 0) goto L_0x0411
            r10.setVisibility(r2)
        L_0x0411:
            android.view.View r10 = r9.n
            if (r10 == 0) goto L_0x0418
            r10.setVisibility(r0)
        L_0x0418:
            android.view.View r10 = r9.o
            if (r10 == 0) goto L_0x041f
            r10.setVisibility(r2)
        L_0x041f:
            android.view.View r10 = r9.p
            if (r10 == 0) goto L_0x0426
            r10.setVisibility(r2)
        L_0x0426:
            android.view.View r10 = r9.q
            if (r10 == 0) goto L_0x042d
            r10.setVisibility(r2)
        L_0x042d:
            android.widget.TextView r10 = r9.f14336g
            if (r10 == 0) goto L_0x0434
            r10.setVisibility(r0)
        L_0x0434:
            android.widget.TextView r10 = r9.f14336g
            if (r10 == 0) goto L_0x0447
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r11 = r9.s
            if (r11 == 0) goto L_0x0441
            java.lang.String r11 = r11.getPrimaryMessage()
            goto L_0x0442
        L_0x0441:
            r11 = r12
        L_0x0442:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r10.setText(r11)
        L_0x0447:
            android.view.View r10 = r9.r
            if (r10 == 0) goto L_0x044e
            r10.setVisibility(r2)
        L_0x044e:
            android.widget.ImageView r10 = r9.u
            if (r10 == 0) goto L_0x0464
            android.content.Context r11 = r9.getContext()
            if (r11 != 0) goto L_0x045b
            kotlin.g.b.k.a()
        L_0x045b:
            int r1 = net.one97.paytm.iocl.R.drawable.iocl_rewards_image
            android.graphics.drawable.Drawable r11 = androidx.core.content.b.a((android.content.Context) r11, (int) r1)
            r10.setImageDrawable(r11)
        L_0x0464:
            android.widget.ImageView r10 = r9.u
            if (r10 == 0) goto L_0x0585
            r10.setVisibility(r0)
            goto L_0x0585
        L_0x046d:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x047c
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x047c
            java.lang.String r10 = r10.getStatus()
            goto L_0x047d
        L_0x047c:
            r10 = r12
        L_0x047d:
            java.lang.String r11 = "USER_REQUESTED"
            boolean r10 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r10, (boolean) r1)
            if (r10 != 0) goto L_0x0513
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0494
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x0494
            java.lang.String r10 = r10.getStatus()
            goto L_0x0495
        L_0x0494:
            r10 = r12
        L_0x0495:
            java.lang.String r11 = "REQUEST_INITIATED"
            boolean r10 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r10, (boolean) r1)
            if (r10 == 0) goto L_0x049f
            goto L_0x0513
        L_0x049f:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x04ae
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x04ae
            java.lang.String r10 = r10.getStatus()
            goto L_0x04af
        L_0x04ae:
            r10 = r12
        L_0x04af:
            java.lang.String r11 = "FAILED"
            boolean r10 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r10, (boolean) r1)
            if (r10 == 0) goto L_0x0585
            android.view.View r10 = r9.m
            if (r10 == 0) goto L_0x04be
            r10.setVisibility(r2)
        L_0x04be:
            android.view.View r10 = r9.n
            if (r10 == 0) goto L_0x04c5
            r10.setVisibility(r2)
        L_0x04c5:
            android.view.View r10 = r9.o
            if (r10 == 0) goto L_0x04cc
            r10.setVisibility(r0)
        L_0x04cc:
            android.view.View r10 = r9.p
            if (r10 == 0) goto L_0x04d3
            r10.setVisibility(r2)
        L_0x04d3:
            android.widget.TextView r10 = r9.f14336g
            if (r10 == 0) goto L_0x04da
            r10.setVisibility(r0)
        L_0x04da:
            android.widget.TextView r10 = r9.f14336g
            if (r10 == 0) goto L_0x04ed
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r11 = r9.s
            if (r11 == 0) goto L_0x04e7
            java.lang.String r11 = r11.getSecondaryMessage()
            goto L_0x04e8
        L_0x04e7:
            r11 = r12
        L_0x04e8:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r10.setText(r11)
        L_0x04ed:
            android.widget.ImageView r10 = r9.u
            if (r10 == 0) goto L_0x0503
            android.content.Context r11 = r9.getContext()
            if (r11 != 0) goto L_0x04fa
            kotlin.g.b.k.a()
        L_0x04fa:
            int r1 = net.one97.paytm.iocl.R.drawable.iocl_profile_failed
            android.graphics.drawable.Drawable r11 = androidx.core.content.b.a((android.content.Context) r11, (int) r1)
            r10.setImageDrawable(r11)
        L_0x0503:
            android.widget.ImageView r10 = r9.u
            if (r10 == 0) goto L_0x050a
            r10.setVisibility(r0)
        L_0x050a:
            android.view.View r10 = r9.r
            if (r10 == 0) goto L_0x0585
            r10.setVisibility(r2)
            goto L_0x0585
        L_0x0513:
            android.view.View r10 = r9.m
            if (r10 == 0) goto L_0x051a
            r10.setVisibility(r2)
        L_0x051a:
            android.view.View r10 = r9.n
            if (r10 == 0) goto L_0x0521
            r10.setVisibility(r0)
        L_0x0521:
            android.view.View r10 = r9.o
            if (r10 == 0) goto L_0x0528
            r10.setVisibility(r2)
        L_0x0528:
            android.view.View r10 = r9.p
            if (r10 == 0) goto L_0x052f
            r10.setVisibility(r2)
        L_0x052f:
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r10 = r9.s
            if (r10 == 0) goto L_0x0542
            net.one97.paytm.transport.iocl_v1.data.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x0542
            boolean r10 = r10.isHasTransaction()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x0543
        L_0x0542:
            r10 = r12
        L_0x0543:
            if (r10 != 0) goto L_0x0548
            kotlin.g.b.k.a()
        L_0x0548:
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0585
            android.widget.TextView r10 = r9.f14336g
            if (r10 == 0) goto L_0x0555
            r10.setVisibility(r0)
        L_0x0555:
            android.widget.TextView r10 = r9.f14336g
            if (r10 == 0) goto L_0x0568
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r11 = r9.s
            if (r11 == 0) goto L_0x0562
            java.lang.String r11 = r11.getSecondaryMessage()
            goto L_0x0563
        L_0x0562:
            r11 = r12
        L_0x0563:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r10.setText(r11)
        L_0x0568:
            android.widget.ImageView r10 = r9.u
            if (r10 == 0) goto L_0x057e
            android.content.Context r11 = r9.getContext()
            if (r11 != 0) goto L_0x0575
            kotlin.g.b.k.a()
        L_0x0575:
            int r1 = net.one97.paytm.iocl.R.drawable.iocl_creating_profile
            android.graphics.drawable.Drawable r11 = androidx.core.content.b.a((android.content.Context) r11, (int) r1)
            r10.setImageDrawable(r11)
        L_0x057e:
            android.widget.ImageView r10 = r9.u
            if (r10 == 0) goto L_0x0585
            r10.setVisibility(r0)
        L_0x0585:
            android.widget.TextView r10 = r9.f14334e
            if (r10 == 0) goto L_0x0596
            net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse r11 = r9.s
            if (r11 == 0) goto L_0x0591
            java.lang.String r12 = r11.getSecondaryMessage()
        L_0x0591:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r10.setText(r12)
        L_0x0596:
            androidx.core.widget.NestedScrollView r10 = r9.f14331b
            if (r10 == 0) goto L_0x05a4
            net.one97.paytm.transport.iocl_v1.a.b$b r11 = new net.one97.paytm.transport.iocl_v1.a.b$b
            r11.<init>(r9)
            androidx.core.widget.NestedScrollView$b r11 = (androidx.core.widget.NestedScrollView.b) r11
            r10.setOnScrollChangeListener(r11)
        L_0x05a4:
            net.one97.paytm.transport.iocl.c r10 = net.one97.paytm.transport.iocl.a.c()
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            android.content.Context r11 = (android.content.Context) r11
            java.lang.String r12 = "/iocl-xtrarewards"
            r10.sendOpenScreenEvent(r11, r12)
            android.view.View r10 = r9.v
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.transport.iocl_v1.a.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
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

    /* renamed from: net.one97.paytm.transport.iocl_v1.a.b$b  reason: collision with other inner class name */
    public static final class C0196b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14339a;

        C0196b(b bVar) {
            this.f14339a = bVar;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            c a2;
            if ((nestedScrollView != null ? nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) : null) != null) {
                View childAt = nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                k.a((Object) childAt, "v.getChildAt(v.childCount - 1)");
                if (i3 >= childAt.getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && i3 > i5 && (a2 = this.f14339a.w) != null) {
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
