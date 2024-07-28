package net.one97.paytm.p2mNewDesign.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.j;
import androidx.lifecycle.z;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.d.b;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchBinDetailsV2;
import net.one97.paytm.p2mNewDesign.entity.CardDetailsV2;
import net.one97.paytm.p2mNewDesign.entity.HasLowSuccessRate;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.a;
import net.one97.paytm.wallet.entity.CardExpiryEditText;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements View.OnClickListener {
    private static String V = "offline_PG";
    private static String W = "home/pay-send/post-scan";
    private RadioButton A;
    private RelativeLayout B;
    private RelativeLayout C;
    private EditText D;
    /* access modifiers changed from: private */
    public EditText E;
    /* access modifiers changed from: private */
    public String F;
    private InstrumentInfo G;
    /* access modifiers changed from: private */
    public LinearLayout H;
    private LinearLayout I;
    private LinearLayout J;
    /* access modifiers changed from: private */
    public int K;
    private TextView L;
    /* access modifiers changed from: private */
    public String M;
    private CheckBox N;
    private CheckBox O;
    private boolean P;
    /* access modifiers changed from: private */
    public TextView Q;
    private j R;
    private List<InstrumentInfo> S;
    private List<InstrumentInfo> T;
    private TextView U;
    /* access modifiers changed from: private */
    public boolean X;
    /* access modifiers changed from: private */
    public boolean Y;
    /* access modifiers changed from: private */
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public g f13210a;
    private LinearLayout aA;
    private String aa = getClass().getName();
    private boolean ab;
    private boolean ac = false;
    private boolean ad;
    private RelativeLayout ae;
    private String af;
    private net.one97.paytm.p2mNewDesign.models.a ag;
    private boolean ah;
    private HashMap<String, CardDetailsV2> ai;
    private HashMap<String, CardDetailsV2> aj;
    /* access modifiers changed from: private */
    public LinearLayout ak;
    private double al = 0.0d;
    private List<View> am = new ArrayList();
    private List<View> an = new ArrayList();
    /* access modifiers changed from: private */
    public boolean ao;
    private boolean ap;
    private b aq;
    /* access modifiers changed from: private */
    public LinearLayout ar;
    /* access modifiers changed from: private */
    public boolean as;
    /* access modifiers changed from: private */
    public RelativeLayout at;
    private String au;
    /* access modifiers changed from: private */
    public String av;
    /* access modifiers changed from: private */
    public String aw;
    private String ax;
    private boolean ay;
    /* access modifiers changed from: private */
    public boolean az;

    /* renamed from: b  reason: collision with root package name */
    int[] f13211b = new int[2];

    /* renamed from: c  reason: collision with root package name */
    View f13212c;

    /* renamed from: d  reason: collision with root package name */
    View f13213d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f13214e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f13215f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f13216g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CardExpiryEditText f13217h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ImageView f13218i;
    /* access modifiers changed from: private */
    public ImageView j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public int o;
    private RadioButton p;
    private LinearLayout q;
    private String r;
    private TextView s;
    /* access modifiers changed from: private */
    public TextView t;
    private RelativeLayout u;
    private boolean v;
    private List<View> w;
    private List<View> x;
    private LinearLayout y;
    private LinearLayout z;

    /* access modifiers changed from: private */
    public boolean j() {
        return !TextUtils.isEmpty(this.f13210a.d()) && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().D()) && Double.valueOf(this.f13210a.d()).doubleValue() >= 0.0d && Double.valueOf(this.f13210a.d()).doubleValue() <= Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().D()).doubleValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0426  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04f6 A[Catch:{ Exception -> 0x0513 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x050b A[Catch:{ Exception -> 0x0513 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x050d A[Catch:{ Exception -> 0x0513 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0186 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getId()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r0.r
            boolean r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r3)
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0050
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r2 = r2.A
            java.lang.String r3 = "0"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0032
            android.content.Context r2 = r0.f13215f
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r2 = r2.getString(r3)
            goto L_0x004c
        L_0x0032:
            android.content.Context r2 = r0.f13215f
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg_with_amount_new
            java.lang.String r2 = r2.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r4]
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.A
            r3[r5] = r4
            java.lang.String r2 = java.lang.String.format(r2, r3)
        L_0x004c:
            r1.a(r2, r5, r5)
            return
        L_0x0050:
            int r3 = net.one97.paytm.wallet.R.id.iv_clear
            if (r2 != r3) goto L_0x0075
            android.widget.EditText r1 = r0.f13216g
            android.text.Editable r1 = r1.getText()
            r1.clear()
            net.one97.paytm.wallet.entity.CardExpiryEditText r1 = r0.f13217h
            android.text.Editable r1 = r1.getText()
            r1.clear()
            android.widget.EditText r1 = r0.E
            android.text.Editable r1 = r1.getText()
            r1.clear()
            android.widget.EditText r1 = r0.f13216g
            r1.requestFocus()
            return
        L_0x0075:
            int r3 = net.one97.paytm.wallet.R.id.tv_cvv_help
            r6 = 0
            if (r2 != r3) goto L_0x00cc
            android.widget.EditText r1 = r0.E
            r1.clearFocus()
            android.widget.EditText r1 = r0.f13216g
            r1.clearFocus()
            net.one97.paytm.wallet.entity.CardExpiryEditText r1 = r0.f13217h
            r1.clearFocus()
            android.widget.LinearLayout r1 = r0.f13214e
            r0.b((android.view.View) r1)
            net.one97.paytm.p2mNewDesign.d.b r1 = r0.aq
            if (r1 == 0) goto L_0x0098
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x00cb
        L_0x0098:
            java.lang.String r1 = r0.F
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00a9
            net.one97.paytm.p2mNewDesign.d.b$a r1 = net.one97.paytm.p2mNewDesign.d.b.a.ALL
            net.one97.paytm.p2mNewDesign.d.b r1 = net.one97.paytm.p2mNewDesign.d.b.a((net.one97.paytm.p2mNewDesign.d.b.a) r1)
            r0.aq = r1
            goto L_0x00c4
        L_0x00a9:
            java.lang.String r1 = r0.F
            java.lang.String r2 = "AMEX"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x00bc
            net.one97.paytm.p2mNewDesign.d.b$a r1 = net.one97.paytm.p2mNewDesign.d.b.a.NON_AMEX
            net.one97.paytm.p2mNewDesign.d.b r1 = net.one97.paytm.p2mNewDesign.d.b.a((net.one97.paytm.p2mNewDesign.d.b.a) r1)
            r0.aq = r1
            goto L_0x00c4
        L_0x00bc:
            net.one97.paytm.p2mNewDesign.d.b$a r1 = net.one97.paytm.p2mNewDesign.d.b.a.AMEX
            net.one97.paytm.p2mNewDesign.d.b r1 = net.one97.paytm.p2mNewDesign.d.b.a((net.one97.paytm.p2mNewDesign.d.b.a) r1)
            r0.aq = r1
        L_0x00c4:
            net.one97.paytm.p2mNewDesign.d.b r1 = r0.aq
            androidx.fragment.app.j r2 = r0.R
            r1.show((androidx.fragment.app.j) r2, (java.lang.String) r6)
        L_0x00cb:
            return
        L_0x00cc:
            int r3 = net.one97.paytm.wallet.R.id.rb_instrumentInfo
            java.lang.String r7 = "updateSelection"
            java.lang.String r8 = "sectionClose"
            java.lang.String r9 = "flow_through_scan_icon"
            java.lang.String r10 = "flow_through_pay_icon"
            java.lang.String r11 = "uncheck"
            java.lang.String r12 = "offline_payments"
            if (r2 == r3) goto L_0x0562
            int r3 = net.one97.paytm.wallet.R.id.rl_pay_mode_pg
            if (r2 != r3) goto L_0x00e2
            goto L_0x0562
        L_0x00e2:
            int r3 = net.one97.paytm.wallet.R.id.rl_card
            if (r2 != r3) goto L_0x053b
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r2 = r2.J
            if (r2 == 0) goto L_0x00ff
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r2 = r2.H
            if (r2 == 0) goto L_0x00ff
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r2 = r2.L
            if (r2 == 0) goto L_0x00ff
            return
        L_0x00ff:
            java.lang.Object r2 = r17.getTag()
            java.lang.String r2 = (java.lang.String) r2
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            if (r3 == 0) goto L_0x0187
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPaymentDetails()
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0187
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            boolean r3 = r3.isCardFromEMITab()
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r13 = r0.S
            if (r13 == 0) goto L_0x0156
            java.util.Iterator r13 = r13.iterator()
        L_0x012f:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0156
            java.lang.Object r14 = r13.next()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r14
            java.lang.String r15 = r14.getPaymentDetails()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            java.lang.String r4 = r4.getPaymentDetails()
            boolean r4 = r15.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0154
            boolean r4 = r14.isCardFromEMITab()
            goto L_0x0184
        L_0x0154:
            r4 = 1
            goto L_0x012f
        L_0x0156:
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r4 = r0.T
            if (r4 == 0) goto L_0x0183
            java.util.Iterator r4 = r4.iterator()
        L_0x015e:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x0183
            java.lang.Object r13 = r4.next()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r13
            java.lang.String r14 = r13.getPaymentDetails()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r15 = r15.n
            java.lang.String r15 = r15.getPaymentDetails()
            boolean r14 = r14.equalsIgnoreCase(r15)
            if (r14 == 0) goto L_0x015e
            boolean r4 = r13.isCardFromEMITab()
            goto L_0x0184
        L_0x0183:
            r4 = 0
        L_0x0184:
            if (r3 != r4) goto L_0x0187
            return
        L_0x0187:
            android.widget.LinearLayout r3 = r0.f13214e
            if (r3 == 0) goto L_0x019e
            java.lang.Object r3 = r3.getTag()
            if (r3 == 0) goto L_0x019e
            android.widget.LinearLayout r3 = r0.f13214e
            java.lang.Object r3 = r3.getTag()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L_0x019f
        L_0x019e:
            r3 = 0
        L_0x019f:
            r0.i((java.lang.String) r2)
            boolean r4 = r0.ap
            if (r4 != 0) goto L_0x0218
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            if (r4 == 0) goto L_0x0218
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            java.lang.String r4 = r4.getPaymentDetails()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0218
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            java.lang.String r4 = r4.getPaymentDetails()
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r13 = r0.T
            if (r13 == 0) goto L_0x01f0
            java.util.Iterator r13 = r13.iterator()
        L_0x01d0:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x01f0
            java.lang.Object r14 = r13.next()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r14
            java.lang.String r15 = r14.getPaymentDetails()
            boolean r15 = r15.equalsIgnoreCase(r4)
            if (r15 == 0) goto L_0x01d0
            r14.setSelectedEMIPlan(r6)
            r14.setSelectedEMIPlanId(r6)
            r14.setEmiClicked(r5)
            goto L_0x01d0
        L_0x01f0:
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r13 = r0.S
            if (r13 == 0) goto L_0x0218
            java.util.Iterator r13 = r13.iterator()
        L_0x01f8:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0218
            java.lang.Object r14 = r13.next()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r14
            java.lang.String r15 = r14.getPaymentDetails()
            boolean r15 = r15.equalsIgnoreCase(r4)
            if (r15 == 0) goto L_0x01f8
            r14.setSelectedEMIPlan(r6)
            r14.setSelectedEMIPlanId(r6)
            r14.setEmiClicked(r5)
            goto L_0x01f8
        L_0x0218:
            java.util.List<android.view.View> r4 = r0.w
            if (r4 == 0) goto L_0x0261
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0261
            java.util.List<android.view.View> r4 = r0.w
            java.util.Iterator r4 = r4.iterator()
        L_0x0228:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x0261
            java.lang.Object r13 = r4.next()
            android.view.View r13 = (android.view.View) r13
            java.lang.Object r14 = r13.getTag()
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x0228
            boolean r14 = r14.equalsIgnoreCase(r2)
            if (r14 == 0) goto L_0x0228
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r4 = r4.f13092h
            java.lang.String r14 = "post_scan_saveddc_selected"
            if (r4 == 0) goto L_0x0258
            android.content.Context r4 = r0.f13215f
            java.lang.String r15 = W
            a((java.lang.String) r12, (java.lang.String) r14, (java.lang.String) r9, (android.content.Context) r4, (java.lang.String) r15)
            goto L_0x025f
        L_0x0258:
            android.content.Context r4 = r0.f13215f
            java.lang.String r15 = W
            a((java.lang.String) r12, (java.lang.String) r14, (java.lang.String) r10, (android.content.Context) r4, (java.lang.String) r15)
        L_0x025f:
            r0.f13212c = r13
        L_0x0261:
            java.util.List<android.view.View> r4 = r0.x
            if (r4 == 0) goto L_0x02aa
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x02aa
            java.util.List<android.view.View> r4 = r0.x
            java.util.Iterator r4 = r4.iterator()
        L_0x0271:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x02aa
            java.lang.Object r13 = r4.next()
            android.view.View r13 = (android.view.View) r13
            java.lang.Object r14 = r13.getTag()
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x0271
            boolean r14 = r14.equalsIgnoreCase(r2)
            if (r14 == 0) goto L_0x0271
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r4 = r4.f13092h
            java.lang.String r14 = "post_pay_savedcc_selected"
            if (r4 == 0) goto L_0x02a1
            android.content.Context r4 = r0.f13215f
            java.lang.String r10 = W
            a((java.lang.String) r12, (java.lang.String) r14, (java.lang.String) r9, (android.content.Context) r4, (java.lang.String) r10)
            goto L_0x02a8
        L_0x02a1:
            android.content.Context r4 = r0.f13215f
            java.lang.String r9 = W
            a((java.lang.String) r12, (java.lang.String) r14, (java.lang.String) r10, (android.content.Context) r4, (java.lang.String) r9)
        L_0x02a8:
            r0.f13212c = r13
        L_0x02aa:
            boolean r4 = r0.P
            java.lang.String r9 = "DEBIT_CARD"
            if (r4 != 0) goto L_0x02cb
            java.lang.String r4 = r0.r
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x02c2
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r4.f(r2)
            goto L_0x032e
        L_0x02c2:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r4.g(r2)
            goto L_0x032e
        L_0x02cb:
            java.lang.String r4 = r0.r
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0302
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r9 = 0
        L_0x02d8:
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r10 = r4.q
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x02ff
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r10 = r4.q
            java.lang.Object r10 = r10.get(r9)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r10 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r10
            java.lang.String r10 = r10.getPaymentDetails()
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x02fc
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r4 = r4.q
            java.lang.Object r4 = r4.get(r9)
            r6 = r4
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r6
            goto L_0x02ff
        L_0x02fc:
            int r9 = r9 + 1
            goto L_0x02d8
        L_0x02ff:
            r0.G = r6
            goto L_0x0330
        L_0x0302:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r9 = 0
        L_0x0307:
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r10 = r4.r
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x032e
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r10 = r4.r
            java.lang.Object r10 = r10.get(r9)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r10 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r10
            java.lang.String r10 = r10.getPaymentDetails()
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x032b
            java.util.List<net.one97.paytm.p2mNewDesign.entity.InstrumentInfo> r4 = r4.r
            java.lang.Object r4 = r4.get(r9)
            r6 = r4
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r6
            goto L_0x032e
        L_0x032b:
            int r9 = r9 + 1
            goto L_0x0307
        L_0x032e:
            r0.G = r6
        L_0x0330:
            android.widget.RadioButton r4 = r0.A
            if (r4 == 0) goto L_0x033f
            android.content.Context r6 = r0.f13215f
            int r9 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r6 = androidx.core.content.b.a((android.content.Context) r6, (int) r9)
            r4.setButtonDrawable(r6)
        L_0x033f:
            android.widget.RelativeLayout r4 = r0.B
            r6 = 8
            if (r4 == 0) goto L_0x0348
            r4.setVisibility(r6)
        L_0x0348:
            android.widget.LinearLayout r4 = r0.ar
            if (r4 == 0) goto L_0x0354
            r4.clearAnimation()
            android.widget.LinearLayout r4 = r0.ar
            r4.setVisibility(r6)
        L_0x0354:
            android.widget.RelativeLayout r4 = r0.ae
            if (r4 == 0) goto L_0x035b
            r4.setVisibility(r6)
        L_0x035b:
            android.widget.TextView r4 = r0.U
            if (r4 == 0) goto L_0x0368
            android.graphics.Typeface r9 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r9 = android.graphics.Typeface.create(r9, r5)
            r4.setTypeface(r9)
        L_0x0368:
            android.widget.TextView r4 = r0.s
            if (r4 == 0) goto L_0x0375
            android.graphics.Typeface r9 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r9 = android.graphics.Typeface.create(r9, r5)
            r4.setTypeface(r9)
        L_0x0375:
            android.widget.LinearLayout r4 = r0.z
            if (r4 == 0) goto L_0x0397
            r4.setVisibility(r6)
            android.widget.EditText r4 = r0.E
            android.text.Editable r4 = r4.getText()
            r4.clear()
            net.one97.paytm.wallet.entity.CardExpiryEditText r4 = r0.f13217h
            android.text.Editable r4 = r4.getText()
            r4.clear()
            android.widget.EditText r4 = r0.E
            android.text.Editable r4 = r4.getText()
            r4.clear()
        L_0x0397:
            android.widget.RelativeLayout r4 = r0.C
            if (r4 == 0) goto L_0x039e
            r4.setVisibility(r6)
        L_0x039e:
            int r4 = net.one97.paytm.wallet.R.id.rl_cvv_layout
            android.view.View r4 = r1.findViewById(r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r0.B = r4
            int r4 = net.one97.paytm.wallet.R.id.ll_visa_one_click
            android.view.View r4 = r1.findViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r0.ar = r4
            int r4 = net.one97.paytm.wallet.R.id.lyt_scp_enabled
            android.view.View r4 = r1.findViewById(r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r0.at = r4
            r4 = 1
            r0.ay = r4
            r16.c((android.view.View) r17)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r0.G
            boolean r4 = r4.isOneClickSupported()
            if (r4 == 0) goto L_0x0426
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r4 = r4.G
            if (r4 == 0) goto L_0x0426
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r0.G
            boolean r4 = r4.isEnrollmentPossible()
            if (r4 == 0) goto L_0x0426
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r4 = r4.G
            if (r4 == 0) goto L_0x0426
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r0.G
            boolean r4 = r4.isScpEnrolled()
            if (r4 == 0) goto L_0x040b
            boolean r9 = r16.j()
            if (r9 == 0) goto L_0x0402
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r9 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r10 = 1
            r9.F = r10
            android.widget.LinearLayout r9 = r0.ar
            r9.clearAnimation()
            android.widget.LinearLayout r9 = r0.ar
            r9.setVisibility(r6)
            goto L_0x0422
        L_0x0402:
            android.widget.RelativeLayout r9 = r0.B
            r9.setVisibility(r5)
            r16.r()
            goto L_0x0422
        L_0x040b:
            android.widget.RelativeLayout r9 = r0.B
            r9.setVisibility(r5)
            android.widget.LinearLayout r9 = r0.ar
            r9.setVisibility(r5)
            android.widget.LinearLayout r9 = r0.ar
            android.content.Context r10 = r0.f13215f
            int r12 = net.one97.paytm.wallet.R.anim.wallet_vscp_shake
            android.view.animation.Animation r10 = android.view.animation.AnimationUtils.loadAnimation(r10, r12)
            r9.startAnimation(r10)
        L_0x0422:
            r16.k()
            goto L_0x042f
        L_0x0426:
            android.widget.RelativeLayout r4 = r0.B
            r4.setVisibility(r5)
            r16.r()
            r4 = 0
        L_0x042f:
            int r9 = net.one97.paytm.wallet.R.id.cvv_container
            android.view.View r9 = r1.findViewById(r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r0.ak = r9
            int r9 = net.one97.paytm.wallet.R.id.lyt_emi_plan
            android.view.View r9 = r1.findViewById(r9)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            r0.ae = r9
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.g((java.lang.String) r2)
            r0.G = r2
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.G
            if (r2 != 0) goto L_0x044f
            r2 = 0
            goto L_0x0453
        L_0x044f:
            boolean r2 = r2.isEmiClicked()
        L_0x0453:
            r0.ad = r2
            android.widget.RelativeLayout r2 = r0.ae
            boolean r9 = r0.ad
            if (r9 == 0) goto L_0x045d
            r9 = 0
            goto L_0x045f
        L_0x045d:
            r9 = 8
        L_0x045f:
            r2.setVisibility(r9)
            boolean r2 = r0.ah
            if (r2 == 0) goto L_0x046b
            android.widget.RelativeLayout r2 = r0.ae
            r2.setVisibility(r6)
        L_0x046b:
            android.widget.RelativeLayout r2 = r0.B
            int r9 = net.one97.paytm.wallet.R.id.et_cvv
            android.view.View r2 = r2.findViewById(r9)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r0.D = r2
            r16.q()
            android.widget.EditText r2 = r0.D
            android.text.Editable r2 = r2.getText()
            r2.clear()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.G
            java.lang.String r2 = r2.getCardType()
            r0.F = r2
            r16.p()
            android.widget.RelativeLayout r2 = r0.B
            int r9 = net.one97.paytm.wallet.R.id.tv_cvv_help
            android.view.View r2 = r2.findViewById(r9)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.k = r2
            android.widget.TextView r2 = r0.k
            r2.setVisibility(r6)
            r16.m()
            int r2 = net.one97.paytm.wallet.R.id.tv_instrument_primary_info
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.U = r2
            android.widget.TextView r2 = r0.U
            android.graphics.Typeface r9 = android.graphics.Typeface.SANS_SERIF
            r10 = 1
            android.graphics.Typeface r9 = android.graphics.Typeface.create(r9, r10)
            r2.setTypeface(r9)
            android.widget.RelativeLayout r2 = r0.B
            int r9 = net.one97.paytm.wallet.R.id.rl_proceed_to_pay
            android.view.View r2 = r2.findViewById(r9)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r0.C = r2
            android.widget.RelativeLayout r2 = r0.C
            r2.setVisibility(r6)
            android.widget.RelativeLayout r2 = r0.C
            java.lang.String r6 = "saved"
            r2.setTag(r6)
            android.widget.RelativeLayout r2 = r0.C
            r2.setOnClickListener(r0)
            int r2 = net.one97.paytm.wallet.R.id.rb_instrumentInfo
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RadioButton r1 = (android.widget.RadioButton) r1
            r0.A = r1
            android.widget.RadioButton r1 = r0.A
            android.content.Context r2 = r0.f13215f
            int r6 = net.one97.paytm.wallet.R.drawable.ic_radio_active
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r6)
            r1.setButtonDrawable(r2)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r0.G     // Catch:{ Exception -> 0x0513 }
            java.lang.Object r1 = r1.clone()     // Catch:{ Exception -> 0x0513 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1     // Catch:{ Exception -> 0x0513 }
            if (r3 == 0) goto L_0x04f7
            r5 = 1
        L_0x04f7:
            r1.setEmiClicked(r5)     // Catch:{ Exception -> 0x0513 }
            net.one97.paytm.p2mNewDesign.f.g r2 = r0.f13210a     // Catch:{ Exception -> 0x0513 }
            r2.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (java.lang.String) r11)     // Catch:{ Exception -> 0x0513 }
            net.one97.paytm.p2mNewDesign.f.g r2 = r0.f13210a     // Catch:{ Exception -> 0x0513 }
            r2.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (java.lang.String) r8)     // Catch:{ Exception -> 0x0513 }
            net.one97.paytm.p2mNewDesign.f.g r2 = r0.f13210a     // Catch:{ Exception -> 0x0513 }
            r2.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x0513 }
            if (r3 == 0) goto L_0x050d
            r2 = 1
            goto L_0x050f
        L_0x050d:
            boolean r2 = r0.ad     // Catch:{ Exception -> 0x0513 }
        L_0x050f:
            r1.setEmiClicked(r2)     // Catch:{ Exception -> 0x0513 }
            goto L_0x0528
        L_0x0513:
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.G
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r2, (java.lang.String) r11)
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.G
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r2, (java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.G
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r2, (java.lang.String) r7)
        L_0x0528:
            android.widget.EditText r1 = r0.D
            r1.requestFocus()
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            boolean r1 = r1.j()
            if (r1 != 0) goto L_0x053a
            if (r4 != 0) goto L_0x053a
            r16.l()
        L_0x053a:
            return
        L_0x053b:
            int r1 = net.one97.paytm.wallet.R.id.tv_pay_with_new_debit_card
            if (r2 != r1) goto L_0x0559
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r0.G
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r2, (java.lang.String) r11)
            android.widget.TextView r1 = r0.L
            android.content.Context r2 = r0.f13215f
            int r3 = net.one97.paytm.wallet.R.color.color_222222
            int r2 = androidx.core.content.b.c(r2, r3)
            r1.setTextColor(r2)
            android.widget.LinearLayout r1 = r0.y
            r0.a((android.view.View) r1)
            return
        L_0x0559:
            int r1 = net.one97.paytm.wallet.R.id.rl_proceed_to_pay
            if (r2 != r1) goto L_0x062f
            r16.b()
            goto L_0x062f
        L_0x0562:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r1 = r1.J
            if (r1 == 0) goto L_0x057b
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r1 = r1.H
            if (r1 == 0) goto L_0x057b
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.L
            if (r1 == 0) goto L_0x057b
            return
        L_0x057b:
            boolean r1 = r0.v
            if (r1 != 0) goto L_0x062f
            java.lang.String r1 = ""
            r0.i((java.lang.String) r1)
            android.widget.RadioButton r2 = r0.p
            android.content.Context r3 = r0.f13215f
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_active
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r2 = r2.f13092h
            if (r2 == 0) goto L_0x05a3
            android.content.Context r2 = r0.f13215f
            java.lang.String r3 = W
            java.lang.String r4 = "post_scan_card_selected"
            a((java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r9, (android.content.Context) r2, (java.lang.String) r3)
            goto L_0x05ac
        L_0x05a3:
            android.content.Context r2 = r0.f13215f
            java.lang.String r3 = W
            java.lang.String r4 = "post_pay_card_selected"
            a((java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r10, (android.content.Context) r2, (java.lang.String) r3)
        L_0x05ac:
            android.widget.LinearLayout r2 = r0.f13214e
            if (r2 == 0) goto L_0x05c3
            java.lang.Object r2 = r2.getTag()
            if (r2 == 0) goto L_0x05c3
            android.widget.LinearLayout r2 = r0.f13214e
            java.lang.Object r2 = r2.getTag()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x05c4
        L_0x05c3:
            r2 = 0
        L_0x05c4:
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = new net.one97.paytm.p2mNewDesign.entity.InstrumentInfo
            r3.<init>()
            java.lang.String r4 = r0.r
            r3.setPayMode(r4)
            if (r2 != 0) goto L_0x05d2
            r4 = 0
            goto L_0x05d4
        L_0x05d2:
            boolean r4 = r0.ad
        L_0x05d4:
            r3.setEmiTypeCard(r4)
            if (r2 != 0) goto L_0x05db
            r2 = 0
            goto L_0x05dd
        L_0x05db:
            boolean r2 = r0.ad
        L_0x05dd:
            r3.setEmiClicked(r2)
            r3.setDisplayPrimaryInfo(r1)
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r3, (java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r3, (java.lang.String) r7)
            net.one97.paytm.p2mNewDesign.f.g r1 = r0.f13210a
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r3, (java.lang.String) r11)
            android.widget.LinearLayout r1 = r0.J
            r1.setVisibility(r5)
            android.content.Context r1 = r0.f13215f
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = net.one97.paytm.wallet.R.layout.lyt_pay_with_new_card
            android.view.View r1 = r1.inflate(r2, r6)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.y = r1
            android.widget.TextView r1 = r0.L
            if (r1 == 0) goto L_0x0616
            android.content.Context r2 = r0.f13215f
            int r3 = net.one97.paytm.wallet.R.color.color_00b9f5
            int r2 = androidx.core.content.b.c(r2, r3)
            r1.setTextColor(r2)
        L_0x0616:
            android.widget.LinearLayout r1 = r0.J
            android.widget.LinearLayout r2 = r0.y
            r1.addView(r2)
            android.widget.LinearLayout r1 = r0.y
            r0.a((android.view.View) r1)
            android.widget.LinearLayout r1 = r0.J
            r1.setVisibility(r5)
            android.widget.EditText r1 = r0.f13216g
            r1.requestFocus()
            r1 = 1
            r0.v = r1
        L_0x062f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.b.a.onClick(android.view.View):void");
    }

    private void k() {
        if (this.ay) {
            net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
            net.one97.paytm.wallet.i.b.a(this.f13215f, this.G.getCardFirstSixDigit(), this.G.getCardLastFourDigit(), "");
            return;
        }
        o();
        if (!TextUtils.isEmpty(this.av) && !TextUtils.isEmpty(this.aw)) {
            net.one97.paytm.wallet.i.b bVar2 = net.one97.paytm.wallet.i.b.f70414a;
            net.one97.paytm.wallet.i.b.a(this.f13215f, this.av, this.aw, "");
        }
    }

    private static String c(String str) {
        String valueOf = String.valueOf(Calendar.getInstance().get(1) / 100);
        StringBuilder sb = new StringBuilder(str);
        sb.insert(0, valueOf);
        return sb.toString();
    }

    private void a(View view) {
        this.X = false;
        this.ay = false;
        this.Z = false;
        this.Y = false;
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.ar;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.ar.setVisibility(8);
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        }
        RadioButton radioButton = this.A;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.ic_radio_inactive));
        }
        this.z = (LinearLayout) view.findViewById(R.id.lyt_new_card);
        this.z.setVisibility(0);
        n();
        this.C = (RelativeLayout) view.findViewById(R.id.rl_proceed_to_pay);
        this.C.setTag("new card");
        this.C.setVisibility(8);
        this.C.setOnClickListener(this);
    }

    public static boolean a(String str) {
        int i2 = 0;
        boolean z2 = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (z2 && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i2 += parseInt;
            z2 = !z2;
        }
        return i2 % 10 == 0;
    }

    private void d(String str) {
        Toast.makeText(this.f13215f, str, 0).show();
    }

    private void l() {
        if (!this.f13210a.k()) {
            ((InputMethodManager) this.f13215f.getSystemService("input_method")).toggleSoftInput(2, 1);
        }
    }

    private void m() {
        if (!TextUtils.isEmpty(this.F)) {
            if (this.F.equalsIgnoreCase(SDKConstants.MAESTRO) || this.F.equalsIgnoreCase("BAJAJ FINSERV EMI CARD") || this.F.equalsIgnoreCase("bajaj") || this.F.equalsIgnoreCase("bajajfn")) {
                this.D.setVisibility(8);
            } else {
                this.D.setVisibility(0);
            }
        }
    }

    private void n() {
        this.f13216g = (EditText) this.z.findViewById(R.id.editText);
        this.f13218i = (ImageView) this.z.findViewById(R.id.iv_clear);
        this.j = (ImageView) this.z.findViewById(R.id.iv_card_logo);
        this.k = (TextView) this.z.findViewById(R.id.tv_cvv_help);
        this.f13217h = (CardExpiryEditText) this.z.findViewById(R.id.et_expiry_validity);
        this.f13217h.setFocusableInTouchMode(true);
        this.m = (TextView) this.z.findViewById(R.id.tv_expiry_validity);
        this.l = (TextView) this.z.findViewById(R.id.tv_enter_card_number);
        this.E = (EditText) this.z.findViewById(R.id.et_new_card_cvv);
        this.t = (TextView) this.z.findViewById(R.id.tv_enter_cvv);
        this.H = (LinearLayout) this.z.findViewById(R.id.ll_new_card_cvv);
        this.aA = (LinearLayout) this.z.findViewById(R.id.lyt_card_auto_saved);
        this.I = (LinearLayout) this.z.findViewById(R.id.ll_save_card_for_future);
        this.N = (CheckBox) this.I.findViewById(R.id.cb_save_card);
        this.Q = (TextView) this.z.findViewById(R.id.tv_low_success);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = false;
        c((View) this.z);
        this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
        this.f13217h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        this.aA.setVisibility(0);
        this.f13216g.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                a aVar = a.this;
                aVar.b((View) aVar.f13216g);
                return false;
            }
        });
        this.E.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                a aVar = a.this;
                aVar.b((View) aVar.E);
                return false;
            }
        });
        this.f13217h.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                a aVar = a.this;
                aVar.b((View) aVar.f13217h);
                return false;
            }
        });
        this.k.setOnClickListener(this);
        this.f13218i.setOnClickListener(this);
        this.f13216g.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.f13218i.setVisibility(0);
                } else {
                    a.this.f13218i.setVisibility(8);
                }
                if (charSequence.length() <= 6) {
                    String unused = a.this.F = "";
                    a.this.H.setAlpha(1.0f);
                    a.this.E.setEnabled(true);
                    a.this.f13217h.setEnabled(true);
                    a.this.f13217h.setAlpha(1.0f);
                    a.this.k.setOnClickListener(a.this);
                    a.this.m.setEnabled(true);
                    a.this.m.setAlpha(1.0f);
                    a.this.j.setImageDrawable((Drawable) null);
                    a.this.Q.setVisibility(8);
                    boolean unused2 = a.this.az = false;
                    boolean unused3 = a.this.as = false;
                    a.this.r();
                } else if (a.this.o < 7) {
                    a.a(a.this, charSequence.toString().replace(" ", ""));
                }
                int unused4 = a.this.o = charSequence.length();
            }

            public final void afterTextChanged(Editable editable) {
                String unused = a.this.M = editable.toString().replace(" ", "");
                if (a.this.n > 0 && a.this.M.length() > a.this.n - (a.this.n / 5) && editable.toString().replace(" ", "").length() >= 6) {
                    editable.delete(a.this.n - (a.this.n / 5), editable.length());
                }
                int i2 = 0;
                while (i2 < editable.length()) {
                    if (' ' == editable.charAt(i2)) {
                        int i3 = i2 + 1;
                        if (i3 % 5 != 0 || i3 == editable.length()) {
                            editable.delete(i2, i3);
                        }
                    }
                    i2++;
                }
                for (int i4 = 4; i4 < editable.length(); i4 += 5) {
                    if ("0123456789".indexOf(editable.charAt(i4)) >= 0) {
                        editable.insert(i4, " ");
                    }
                }
                if (a.this.f13216g.getSelectionStart() > 0 && editable.charAt(a.this.f13216g.getSelectionStart() - 1) == ' ') {
                    a.this.f13216g.setSelection(a.this.f13216g.getSelectionStart() - 1);
                }
                if (editable.toString().length() != a.this.n || TextUtils.isEmpty(a.this.M)) {
                    if (a.this.ao || editable.length() < 6) {
                        a.this.f13216g.setBackground(androidx.core.content.b.a(a.this.f13215f, R.drawable.white_background_with_border));
                        a.this.l.setText(a.this.f13215f.getString(R.string.enter_card_number));
                        a.this.l.setTextColor(androidx.core.content.b.c(a.this.f13215f, R.color.color_444444));
                        boolean unused2 = a.this.X = false;
                    }
                } else if (!a.a(a.this.M)) {
                    a.this.l.setText(a.this.f13215f.getString(R.string.enter_valid_card_number));
                    a.this.l.setTextColor(androidx.core.content.b.c(a.this.f13215f, R.color.color_fd5c5c));
                    a.this.f13216g.setBackground(androidx.core.content.b.a(a.this.f13215f, R.drawable.red_background_with_border));
                    boolean unused3 = a.this.X = false;
                } else {
                    if (!a.this.X) {
                        boolean unused4 = a.this.X = true;
                        a.this.a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", a.this.f13215f);
                    }
                    if (a.this.az && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().G && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().G) {
                        a.this.o();
                        net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
                        net.one97.paytm.wallet.i.b.a(a.this.f13215f, a.this.av, a.this.aw, "", new a.b() {
                            public final void a(boolean z, boolean z2, String str) {
                                if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().P) {
                                    boolean unused = a.this.as = z;
                                    if (!z2) {
                                        a.this.r();
                                    } else if (!z) {
                                        a.this.at.setVisibility(8);
                                        a.this.ar.setVisibility(0);
                                        a.this.ar.startAnimation(AnimationUtils.loadAnimation(a.this.f13215f, R.anim.wallet_vscp_shake));
                                    } else if (a.this.j()) {
                                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = true;
                                        a.this.ar.clearAnimation();
                                        a.this.ar.setVisibility(8);
                                        a.this.at.setVisibility(0);
                                    }
                                }
                            }

                            public final void a(String str, String str2) {
                                a(false, false, (String) null);
                            }
                        });
                    }
                    a.this.f13217h.requestFocus();
                }
            }
        });
        this.E.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                a.this.E.setBackground(androidx.core.content.b.a(a.this.f13215f, R.drawable.white_background_with_border));
                a.this.t.setText(a.this.f13215f.getString(R.string.cvv));
                a.this.t.setTextColor(androidx.core.content.b.c(a.this.f13215f, R.color.color_444444));
                if (charSequence.length() == a.this.K) {
                    a aVar = a.this;
                    aVar.b((View) aVar.E);
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() != a.this.K) {
                    boolean unused = a.this.Z = false;
                } else if (!a.this.Z) {
                    boolean unused2 = a.this.Z = true;
                    a.this.a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", a.this.f13215f);
                }
            }
        });
        this.f13217h.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                StringBuilder sb = new StringBuilder(charSequence);
                if (sb.length() > 0 && sb.length() == 3 && '/' == sb.charAt(sb.length() - 1)) {
                    sb.delete(sb.length() - 1, sb.length());
                }
                if (sb.length() > 0 && sb.length() == 3 && Character.isDigit(sb.charAt(sb.length() - 1))) {
                    sb.insert(sb.length() - 1, "/");
                }
                if (charSequence.length() < 5) {
                    a.this.m.setText(a.this.f13215f.getString(R.string.expiry_validity_date));
                    a.this.m.setTextColor(androidx.core.content.b.c(a.this.f13215f, R.color.color_444444));
                    a.this.f13217h.setBackground(androidx.core.content.b.a(a.this.f13215f, R.drawable.white_background_with_border));
                }
                a.this.f13217h.removeTextChangedListener(this);
                a.this.f13217h.setText(sb);
                a.this.f13217h.addTextChangedListener(this);
                if (sb.length() == 5 && a.this.H.isEnabled()) {
                    a.this.E.requestFocus();
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null) {
                    return;
                }
                if (editable.toString().length() != 5 || !a.this.H.isEnabled()) {
                    boolean unused = a.this.Y = false;
                } else if (!a.this.Y) {
                    boolean unused2 = a.this.Y = true;
                    a.this.a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", a.this.f13215f);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void o() {
        this.au = this.f13216g.getText().toString().replace(" ", "");
        this.ax = this.f13217h.getText().toString().replace("/", "");
        if (!TextUtils.isEmpty(this.au)) {
            this.av = this.au.substring(0, 6);
            String str = this.au;
            this.aw = str.substring(str.length() - 4);
        }
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        Context context = this.f13215f;
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    private void p() {
        if (TextUtils.isEmpty(this.F) || this.F.equalsIgnoreCase("AMEX")) {
            this.D.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            this.K = 4;
        } else if (this.F.equalsIgnoreCase("MASTER") || this.F.equalsIgnoreCase(SDKConstants.VISA) || this.F.equalsIgnoreCase("DINERS") || this.F.equalsIgnoreCase("RUPAY")) {
            this.D.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            this.K = 3;
        }
    }

    private static boolean e(String str) {
        String[] split = str.split("/");
        if (split.length > 2) {
            return false;
        }
        split[1] = c(split[1]);
        Calendar instance = Calendar.getInstance();
        return Integer.valueOf(split[0]).intValue() <= 12 && (Integer.valueOf(split[1]).intValue() > instance.get(1) || (Integer.valueOf(split[1]).intValue() == instance.get(1) && Integer.valueOf(split[0]).intValue() > instance.get(2)));
    }

    public final void a() {
        RadioButton radioButton = this.p;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.ic_radio_inactive));
        }
        this.v = false;
        b((View) this.f13214e);
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.J.setVisibility(8);
        }
    }

    public final void b(String str) {
        RadioButton radioButton = this.A;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.ic_radio_inactive));
        }
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        EditText editText = this.D;
        if (editText != null) {
            editText.setVisibility(8);
        }
        TextView textView = this.U;
        if (textView != null) {
            textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        RelativeLayout relativeLayout2 = this.B;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        LinearLayout linearLayout = this.ar;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.ar.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.ae;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        i(str == null ? "" : str);
        if (!this.ap && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPaymentDetails())) {
            List<InstrumentInfo> list = this.T;
            if (list != null) {
                for (InstrumentInfo next : list) {
                    if (!next.getPaymentDetails().equalsIgnoreCase(str)) {
                        next.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                        next.setSelectedEMIPlanId((String) null);
                        next.setEmiClicked(false);
                    }
                }
            }
            List<InstrumentInfo> list2 = this.S;
            if (list2 != null) {
                for (InstrumentInfo next2 : list2) {
                    if (!next2.getPaymentDetails().equalsIgnoreCase(str)) {
                        next2.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                        next2.setSelectedEMIPlanId((String) null);
                        next2.setEmiClicked(false);
                    }
                }
            }
        }
    }

    private static void a(String str, String str2, String str3, Context context, String str4) {
        try {
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvents(str, str2, str3, (String) null, context, str4, V);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void b() {
        String str;
        String str2 = "EMI";
        if (this.C.getTag().equals("saved")) {
            this.G.setSavedCard(true);
            String obj = this.D.getText().toString();
            boolean isScpEnrolled = this.G.isScpEnrolled();
            if (this.G.isOneClickSupported() && isScpEnrolled) {
                InstrumentInfo instrumentInfo = this.G;
                if (instrumentInfo != null) {
                    this.F = instrumentInfo.getCardType();
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.G);
                }
                StringBuilder sb = new StringBuilder(this.G.getPaymentDetails().replace("|", ""));
                sb.append("||" + obj + "|");
                this.G.setPaymentDetails(sb.toString());
                if (this.P) {
                    JSONObject jSONObject = this.G.getmAdditionalParams();
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        jSONObject.put("addMoney", "1");
                    } catch (JSONException e2) {
                        this.f13210a.c(false);
                        q.d(String.valueOf(e2));
                    }
                    this.G.setmAdditionalParams(jSONObject);
                }
                this.G = g(this.G.getPaymentDetails());
                this.ad = this.G.isEmiClicked();
                InstrumentInfo instrumentInfo2 = this.G;
                if (!this.ad) {
                    str2 = this.r;
                }
                instrumentInfo2.setPayMode(str2);
                if (this.ad) {
                    InstrumentInfo instrumentInfo3 = this.G;
                    instrumentInfo3.setPlanId(h(instrumentInfo3.getPaymentDetails()));
                    this.G.setEmiType(this.r);
                }
                this.f13210a.a(this.G, "proceedtoPay");
            } else if (f(obj)) {
                d(this.f13215f.getString(R.string.please_enter_cvv));
                this.f13210a.c(false);
                this.D.requestFocus();
                l();
            } else {
                InstrumentInfo instrumentInfo4 = this.G;
                if (instrumentInfo4 != null) {
                    this.F = instrumentInfo4.getCardType();
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.G);
                }
                StringBuilder sb2 = new StringBuilder(this.G.getPaymentDetails());
                sb2.append("||" + obj + "|");
                this.G.setPaymentDetails(sb2.toString());
                if (this.P) {
                    JSONObject jSONObject2 = this.G.getmAdditionalParams();
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    try {
                        jSONObject2.put("addMoney", "1");
                    } catch (JSONException unused) {
                        this.f13210a.c(false);
                    }
                    this.G.setmAdditionalParams(jSONObject2);
                }
                this.G = g(this.G.getPaymentDetails());
                this.ad = this.G.isEmiClicked();
                InstrumentInfo instrumentInfo5 = this.G;
                if (!this.ad) {
                    str2 = this.r;
                }
                instrumentInfo5.setPayMode(str2);
                if (this.ad) {
                    InstrumentInfo instrumentInfo6 = this.G;
                    instrumentInfo6.setPlanId(h(instrumentInfo6.getPaymentDetails()));
                    this.G.setEmiType(this.r);
                }
                this.f13210a.a(this.G, "proceedtoPay");
            }
        } else {
            int length = this.f13216g.getText().length();
            if (TextUtils.isEmpty(this.f13216g.getText()) || length < 17 || length > 23) {
                this.l.setText(this.f13215f.getString(R.string.enter_valid_card_number));
                this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                this.f13210a.c(false);
            } else if (!this.ao) {
                d(this.f13215f.getString(R.string.please_enter_correct_card));
                this.f13210a.c(false);
            } else {
                String str3 = this.F;
                if (str3 == null) {
                    this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.white_background_with_border));
                    this.l.setText(this.f13215f.getString(R.string.enter_card_number));
                    this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_444444));
                } else if ((!str3.equalsIgnoreCase("DINERS") || length == 17) && ((!this.F.equalsIgnoreCase("AMEX") || length == 18) && (((!this.F.equalsIgnoreCase("DISCOVER") && !this.F.equalsIgnoreCase(SDKConstants.VISA) && !this.F.equalsIgnoreCase("MASTER") && !this.F.equalsIgnoreCase("RUPAY")) || length == 19) && (!this.F.equalsIgnoreCase(SDKConstants.MAESTRO) || length == 23)))) {
                    this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.white_background_with_border));
                    this.l.setText(this.f13215f.getString(R.string.enter_card_number));
                    this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_444444));
                    if (!this.f13217h.isEnabled() || (!TextUtils.isEmpty(this.f13217h.getText().toString()) && this.f13217h.getText().length() >= 5 && e(this.f13217h.getText().toString()))) {
                        this.m.setText(this.f13215f.getString(R.string.expiry_validity_date));
                        this.m.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_444444));
                        if (!this.E.isEnabled() || this.E.getText().length() >= this.K) {
                            this.G = new InstrumentInfo();
                            InstrumentInfo instrumentInfo7 = this.G;
                            if (!this.ad) {
                                str2 = this.r;
                            }
                            instrumentInfo7.setPayMode(str2);
                            if (this.ad) {
                                this.G.setPlanId(this.ag.f56918a);
                                this.G.setEmiType(this.r);
                                this.G.setSelectedEMIPlan(this.ag);
                            }
                            String[] split = this.f13217h.getText().toString().split("/");
                            if (split == null || split.length <= 1) {
                                InstrumentInfo instrumentInfo8 = this.G;
                                instrumentInfo8.setPaymentDetails("|" + this.M + "|" + this.E.getText() + "|");
                            } else {
                                InstrumentInfo instrumentInfo9 = this.G;
                                instrumentInfo9.setPaymentDetails("|" + this.M + "|" + this.E.getText() + "|" + split[0] + c(split[1]));
                            }
                            this.G.setPaymentTypeId(this.r.equalsIgnoreCase(SDKConstants.CREDIT) ? Constants.EASYPAY_PAYTYPE_CREDIT_CARD : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
                            JSONObject jSONObject3 = this.G.getmAdditionalParams();
                            if (jSONObject3 == null) {
                                jSONObject3 = new JSONObject();
                            }
                            try {
                                if (this.N.isChecked()) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                jSONObject3.put(CJRPGTransactionRequestUtils.STORE_CARD, str);
                                if (this.P) {
                                    jSONObject3.put("addMoney", "1");
                                }
                            } catch (JSONException e3) {
                                this.f13210a.c(false);
                                q.d(String.valueOf(e3));
                            }
                            this.G.setmAdditionalParams(jSONObject3);
                            this.G.setCardFirstSixDigit(this.av);
                            this.G.setCardLastFourDigit(this.aw);
                            this.G.setExpiryDate(this.ax);
                            this.G.setIsScpEnrolled(this.as);
                            this.G.setOneClickSupported(this.az);
                            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.G);
                            this.f13210a.a(this.G, "proceedToPay");
                            return;
                        }
                        this.E.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                        this.t.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                        this.t.setText(this.f13215f.getString(R.string.enter_valid_cvv));
                        this.f13210a.c(false);
                        return;
                    }
                    this.m.setText(this.f13215f.getString(R.string.invalid_expiry_date));
                    this.m.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                    this.f13217h.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                    this.f13210a.c(false);
                } else {
                    this.l.setText(this.f13215f.getString(R.string.enter_valid_card_number));
                    this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                    this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                    this.f13210a.c(false);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, String str3, Context context) {
        if (this.Y && this.Z && this.X) {
            try {
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvents(str, str2, str3, (String) null, context, "home/pay-send/post-scan/card-details-entered", V);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    private void q() {
        EditText editText = this.D;
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    Resources resources;
                    int i2;
                    if (a.this.ak != null) {
                        LinearLayout D = a.this.ak;
                        if (z) {
                            resources = a.this.f13215f.getResources();
                            i2 = R.drawable.blue_stroke;
                        } else {
                            resources = a.this.f13215f.getResources();
                            i2 = R.drawable.gray_stroke;
                        }
                        D.setBackground(resources.getDrawable(i2));
                    }
                }
            });
        }
    }

    private boolean f(String str) {
        if ("BAJAJ FINSERV EMI CARD".equalsIgnoreCase(this.F)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || str.length() < this.K) {
            return true;
        }
        return false;
    }

    public final LinearLayout a(Context context, String str, String str2, net.one97.paytm.p2mNewDesign.models.a aVar, boolean z2) {
        this.f13215f = context;
        this.r = str;
        this.ad = true;
        this.af = str2;
        this.ag = aVar;
        this.ah = true;
        this.v = false;
        this.ap = true;
        this.f13214e = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card, (ViewGroup) null);
        this.f13214e.setTag(Boolean.TRUE);
        LinearLayout linearLayout = this.f13214e;
        this.q = linearLayout;
        this.u = (RelativeLayout) linearLayout.findViewById(R.id.rl_pay_mode_pg);
        this.u.setOnClickListener(this);
        this.J = (LinearLayout) this.f13214e.findViewById(R.id.ll_card_expand);
        this.p = (RadioButton) this.f13214e.findViewById(R.id.rb_instrumentInfo);
        this.p.setOnClickListener(this);
        this.s = (TextView) this.f13214e.findViewById(R.id.tv_pay_mode);
        this.s.setText(z2 ? String.format(context.getString(R.string.emi_new_card_title), new Object[]{(SDKConstants.DEBIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType()) || SDKConstants.DEBIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) ? "Debit" : (SDKConstants.CREDIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType()) || SDKConstants.CREDIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) ? "Credit" : ""}) : context.getString(R.string.p2m_enter_card_details));
        this.G = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
        this.R = this.f13210a.getFragmentManager();
        return this.f13214e;
    }

    public final void c() {
        this.f13214e.findViewById(R.id.rb_instrumentInfo).performClick();
    }

    private InstrumentInfo g(String str) {
        List<InstrumentInfo> list = this.T;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (next.getPaymentDetails().equalsIgnoreCase(str)) {
                    return next;
                }
            }
        }
        List<InstrumentInfo> list2 = this.S;
        if (list2 != null) {
            for (InstrumentInfo next2 : list2) {
                if (next2.getPaymentDetails().equalsIgnoreCase(str)) {
                    return next2;
                }
            }
        }
        return this.G;
    }

    private String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<InstrumentInfo> list = this.T;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (str.contains(next.getPaymentDetails())) {
                    return next.getSelectedEMIPlanId();
                }
            }
        }
        List<InstrumentInfo> list2 = this.S;
        if (list2 != null) {
            for (InstrumentInfo next2 : list2) {
                if (str.contains(next2.getPaymentDetails())) {
                    return next2.getSelectedEMIPlanId();
                }
            }
        }
        return null;
    }

    private static List<InstrumentInfo> a(List<InstrumentInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            try {
                for (InstrumentInfo clone : list) {
                    arrayList.add((InstrumentInfo) clone.clone());
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private void i(String str) {
        if (str == null) {
            str = "";
        }
        HashMap<String, CardDetailsV2> hashMap = this.ai;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, CardDetailsV2> value : this.ai.entrySet()) {
                CardDetailsV2 cardDetailsV2 = (CardDetailsV2) value.getValue();
                View view = cardDetailsV2.getView();
                InstrumentInfo instrumentInfo = cardDetailsV2.getInstrumentInfo();
                if (!str.equalsIgnoreCase(instrumentInfo.getPaymentDetails())) {
                    instrumentInfo.setEmiClicked(false);
                    instrumentInfo.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                    instrumentInfo.setSelectedEMIPlanId((String) null);
                    if (instrumentInfo.isEMIavailable()) {
                        view.findViewById(R.id.tv_instrument_secondary_info_2).setVisibility(0);
                    }
                }
            }
        }
        HashMap<String, CardDetailsV2> hashMap2 = this.aj;
        if (hashMap2 != null && hashMap2.size() > 0) {
            for (Map.Entry<String, CardDetailsV2> value2 : this.aj.entrySet()) {
                CardDetailsV2 cardDetailsV22 = (CardDetailsV2) value2.getValue();
                View view2 = cardDetailsV22.getView();
                InstrumentInfo instrumentInfo2 = cardDetailsV22.getInstrumentInfo();
                if (!str.equalsIgnoreCase(instrumentInfo2.getPaymentDetails())) {
                    instrumentInfo2.setEmiClicked(false);
                    instrumentInfo2.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                    instrumentInfo2.setSelectedEMIPlanId((String) null);
                    if (instrumentInfo2.isEMIavailable()) {
                        view2.findViewById(R.id.tv_instrument_secondary_info_2).setVisibility(0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = false;
        CheckBox checkBox = this.O;
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        LinearLayout linearLayout = this.ar;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.ar.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.at;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void c(View view) {
        this.at = (RelativeLayout) view.findViewById(R.id.lyt_scp_enabled);
        this.at.findViewById(R.id.scp_enabled_info_cta).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f(view);
            }
        });
        TextView textView = (TextView) this.at.findViewById(R.id.scp_enabled_tv);
        if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13215f, SDKConstants.KEY_SCP_ENABLED_TEXT))) {
            textView.setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13215f, SDKConstants.KEY_SCP_ENABLED_TEXT));
        }
        this.ar = (LinearLayout) view.findViewById(R.id.ll_visa_one_click);
        this.ar.findViewById(R.id.visa_one_click_info_cta).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.e(view);
            }
        });
        this.O = (CheckBox) this.ar.findViewById(R.id.cb_visa_one_click);
        this.ar.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.d(view);
            }
        });
        ((TextView) view.findViewById(R.id.tv_enable_visa_one_click)).setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13215f, SDKConstants.KEY_ENABLE_SCP_TEXT));
        this.O.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.a(compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        this.f13210a.p();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.f13210a.o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        CheckBox checkBox = this.O;
        checkBox.setChecked(!checkBox.isChecked());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isChecked()) {
            k();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = true;
            return;
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = false;
    }

    private static void b(List<InstrumentInfo> list) {
        if (list != null) {
            for (InstrumentInfo next : list) {
                next.setEMIavailable(true);
                next.setEmiClicked(true);
            }
        }
    }

    public final void d() {
        this.f13214e.setAlpha(0.4f);
    }

    public final void e() {
        this.f13214e.setAlpha(1.0f);
    }

    public final void f() {
        List<View> list = this.an;
        if (list != null && list.size() > 0) {
            for (View next : this.an) {
                next.findViewById(R.id.et_cvv).setEnabled(false);
                next.setAlpha(0.4f);
            }
        }
        this.f13214e.setAlpha(0.4f);
    }

    public final void g() {
        List<View> list = this.am;
        if (list != null && list.size() > 0) {
            for (View next : this.am) {
                next.findViewById(R.id.et_cvv).setEnabled(false);
                next.setAlpha(0.4f);
            }
        }
        this.f13214e.setAlpha(0.4f);
    }

    public final void h() {
        List<View> list = this.an;
        if (list != null && list.size() > 0) {
            for (View next : this.an) {
                next.findViewById(R.id.et_cvv).setEnabled(true);
                next.setAlpha(1.0f);
            }
        }
        this.f13214e.setAlpha(1.0f);
    }

    public final void i() {
        List<View> list = this.am;
        if (list != null && list.size() > 0) {
            for (View next : this.am) {
                next.findViewById(R.id.et_cvv).setEnabled(true);
                next.setAlpha(1.0f);
            }
        }
        this.f13214e.setAlpha(1.0f);
    }

    public final List<View> a(Context context, String str, String str2, net.one97.paytm.p2mNewDesign.models.a aVar) {
        int i2;
        Context context2;
        List<InstrumentInfo> list;
        ListIterator<InstrumentInfo> listIterator;
        InstrumentInfo instrumentInfo;
        ArrayList arrayList;
        Context context3 = context;
        String str3 = str;
        net.one97.paytm.p2mNewDesign.models.a aVar2 = aVar;
        this.f13215f = context3;
        ViewGroup viewGroup = null;
        this.f13214e = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card, (ViewGroup) null);
        LinearLayout linearLayout = this.f13214e;
        this.q = linearLayout;
        this.r = str3;
        boolean z2 = true;
        this.ah = true;
        linearLayout.setTag(Boolean.TRUE);
        this.u = (RelativeLayout) this.f13214e.findViewById(R.id.rl_pay_mode_pg);
        this.u.setOnClickListener(this);
        this.J = (LinearLayout) this.f13214e.findViewById(R.id.ll_card_expand);
        this.p = (RadioButton) this.f13214e.findViewById(R.id.rb_instrumentInfo);
        this.p.setOnClickListener(this);
        this.s = (TextView) this.f13214e.findViewById(R.id.tv_pay_mode);
        TextView textView = this.s;
        if (SDKConstants.DEBIT.equalsIgnoreCase(str3)) {
            context2 = this.f13215f;
            i2 = R.string.debit_card_pay_mode;
        } else {
            context2 = this.f13215f;
            i2 = R.string.credit_card;
        }
        textView.setText(context2.getString(i2));
        this.G = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
        this.R = this.f13210a.getFragmentManager();
        this.ad = true;
        this.af = str2;
        this.ag = aVar2;
        this.ap = true;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        InstrumentInfo instrumentInfo2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
        if (instrumentInfo2 == null) {
            return null;
        }
        this.f13215f = context3;
        boolean equalsIgnoreCase = str3.equalsIgnoreCase(SDKConstants.DEBIT);
        this.f13213d = this.f13213d;
        if (str3.equalsIgnoreCase(SDKConstants.DEBIT)) {
            this.S = a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT));
            b(this.S);
            list = this.S;
            if (this.w == null) {
                this.w = new ArrayList();
            }
        } else {
            this.T = a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT));
            b(this.T);
            list = this.T;
            if (this.x == null) {
                this.x = new ArrayList();
            }
        }
        if (list != null && list.size() > 0) {
            ListIterator<InstrumentInfo> listIterator2 = list.listIterator();
            while (listIterator2.hasNext()) {
                InstrumentInfo next = listIterator2.next();
                if (!(next.getChannelCode() == null || instrumentInfo2.getBankCode() == null || !next.getChannelCode().equalsIgnoreCase(instrumentInfo2.getBankCode()))) {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(next, this.f13210a.d())) {
                        next.setEmiTypeCard(z2);
                        next.setEmiClicked(z2);
                        next.setCardFromEMITab(z2);
                        if (aVar2 != null) {
                            next.setSelectedEMIPlanId(aVar2.f56918a);
                            next.setSelectedEMIPlan(aVar2);
                        }
                        this.ad = z2;
                        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card_expand_v2, viewGroup);
                        RelativeLayout relativeLayout = (RelativeLayout) linearLayout2.findViewById(R.id.rl_cvv_layout);
                        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_proceed_to_pay);
                        relativeLayout2.setTag("saved");
                        RadioButton radioButton = (RadioButton) linearLayout2.findViewById(R.id.rb_instrumentInfo);
                        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.tv_instrument_primary_info);
                        EditText editText = (EditText) relativeLayout.findViewById(R.id.et_cvv);
                        ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.iv_card_type);
                        listIterator = listIterator2;
                        ((TextView) linearLayout2.findViewById(R.id.tv_cvv_help)).setVisibility(8);
                        LinearLayout linearLayout3 = (LinearLayout) linearLayout2.findViewById(R.id.cvv_container);
                        RelativeLayout relativeLayout3 = (RelativeLayout) linearLayout2.findViewById(R.id.lyt_emi_plan);
                        instrumentInfo = instrumentInfo2;
                        relativeLayout3.setTag(Boolean.FALSE);
                        linearLayout2.findViewById(R.id.iv_cancel);
                        linearLayout2.findViewById(R.id.tv_emi_plan_detail);
                        linearLayout2.findViewById(R.id.tv_total_emi_value);
                        linearLayout2.findViewById(R.id.tv_change_plan);
                        TextView textView3 = (TextView) linearLayout2.findViewById(R.id.tv_instrument_secondary_info_2);
                        TextView textView4 = (TextView) linearLayout2.findViewById(R.id.tv_instrument_secondary_info);
                        textView3.setText("EMI Available");
                        ArrayList arrayList4 = arrayList3;
                        textView3.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_00b9f5));
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPaymentDetails()) && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPaymentDetails().equalsIgnoreCase(next.getPaymentDetails())) {
                            textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                            this.U = textView2;
                            this.D = editText;
                            q();
                            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.ic_radio_active));
                            this.A = radioButton;
                            this.F = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType();
                            p();
                            m();
                            this.C = relativeLayout2;
                            this.C.setOnClickListener(this);
                            relativeLayout.setVisibility(0);
                            this.B = relativeLayout;
                            this.ae = relativeLayout3;
                            this.ak = linearLayout3;
                            this.D.requestFocus();
                            l();
                        }
                        Drawable g2 = net.one97.paytm.wallet.utility.a.g(this.f13215f, next.getCardType());
                        if (g2 != null) {
                            imageView.setImageDrawable(g2);
                        } else {
                            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(this.f13215f, imageView, next.getIconUrl(), next.getPayMode());
                        }
                        linearLayout2.setTag(next.getPaymentDetails());
                        linearLayout2.setOnClickListener(this);
                        if (equalsIgnoreCase) {
                            this.w.add(linearLayout2);
                            arrayList2.add(linearLayout2);
                            arrayList = arrayList4;
                        } else {
                            this.x.add(linearLayout2);
                            arrayList = arrayList4;
                            arrayList.add(linearLayout2);
                        }
                        textView2.setText(next.getDisplayPrimaryInfo());
                        textView4.setText(next.getDisplaySecondaryInfo());
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(str)) {
                            linearLayout2.setAlpha(0.4f);
                        }
                        String str4 = str;
                        listIterator2 = listIterator;
                        aVar2 = aVar;
                        arrayList3 = arrayList;
                        instrumentInfo2 = instrumentInfo;
                        z2 = true;
                        viewGroup = null;
                        Context context4 = context;
                    }
                }
                listIterator = listIterator2;
                arrayList = arrayList3;
                instrumentInfo = instrumentInfo2;
                String str42 = str;
                listIterator2 = listIterator;
                aVar2 = aVar;
                arrayList3 = arrayList;
                instrumentInfo2 = instrumentInfo;
                z2 = true;
                viewGroup = null;
                Context context42 = context;
            }
        }
        return equalsIgnoreCase ? arrayList2 : arrayList3;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        String str;
        String str2;
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof CJRFetchBinDetailsV2) {
                CJRFetchBinDetailsV2 cJRFetchBinDetailsV2 = (CJRFetchBinDetailsV2) fVar.f55797b;
                if (cJRFetchBinDetailsV2.getBody() != null) {
                    if (!(cJRFetchBinDetailsV2.getBody() == null || cJRFetchBinDetailsV2.getBody().getBinDetail() == null)) {
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().M = cJRFetchBinDetailsV2.getBody().getBinDetail().getIssuingBankCode();
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().N = cJRFetchBinDetailsV2.getBody().getBinDetail().getChannelCode();
                    }
                    this.az = cJRFetchBinDetailsV2.getBody().isOneClickSupported();
                    if (cJRFetchBinDetailsV2.getBody().getResultInfo() != null && AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRFetchBinDetailsV2.getBody().getResultInfo().getResultStatus())) {
                        this.l.setText(TextUtils.isEmpty(cJRFetchBinDetailsV2.getBody().getResultInfo().getResultMsg()) ? String.format(this.f13215f.getResources().getString(R.string.emi_valid_card_details), new Object[]{this.r.equalsIgnoreCase(SDKConstants.CREDIT) ? "Credit" : "Debit"}) : cJRFetchBinDetailsV2.getBody().getResultInfo().getResultMsg());
                        this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                        this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                        this.X = false;
                        this.ao = false;
                    } else if (this.ad && cJRFetchBinDetailsV2.getBody().getBinDetail() != null && (str2 = this.af) != null && !str2.equalsIgnoreCase(cJRFetchBinDetailsV2.getBody().getBinDetail().getIssuingBankCode())) {
                        this.l.setText(String.format(this.f13215f.getResources().getString(R.string.emi_choose_valid_bank), new Object[]{this.af}));
                        this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                        this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                        this.X = false;
                        this.ao = false;
                    } else if (cJRFetchBinDetailsV2.getBody().getBinDetail() == null || (str = this.r) == null || str.equalsIgnoreCase(cJRFetchBinDetailsV2.getBody().getBinDetail().getPaymentMode())) {
                        this.ao = true;
                        HasLowSuccessRate hasLowSuccessRate = cJRFetchBinDetailsV2.getBody().getHasLowSuccessRate();
                        if (hasLowSuccessRate != null && hasLowSuccessRate.getStatus()) {
                            this.Q.setVisibility(0);
                            this.Q.setText(hasLowSuccessRate.getMsg());
                        }
                        if (cJRFetchBinDetailsV2.getBody().getBinDetail() != null) {
                            this.F = cJRFetchBinDetailsV2.getBody().getBinDetail().getChannelName().toLowerCase();
                            this.ab = cJRFetchBinDetailsV2.getBody().isEmiAvailable();
                            String channelCode = cJRFetchBinDetailsV2.getBody().getBinDetail().getChannelCode();
                            String iconUrl = cJRFetchBinDetailsV2.getBody().getEmiChannel() == null ? "" : cJRFetchBinDetailsV2.getBody().getEmiChannel().getIconUrl();
                            String str3 = this.r;
                            if (this.F.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                                this.H.setAlpha(0.4f);
                                this.H.setEnabled(false);
                                this.E.setEnabled(false);
                                this.f13217h.setEnabled(false);
                                this.f13217h.setAlpha(0.4f);
                                this.k.setOnClickListener((View.OnClickListener) null);
                                this.m.setEnabled(false);
                                this.m.setAlpha(0.4f);
                            } else {
                                this.f13217h.setEnabled(true);
                                this.f13217h.setAlpha(1.0f);
                                this.m.setEnabled(true);
                                this.m.setAlpha(1.0f);
                                this.H.setAlpha(1.0f);
                                this.H.setEnabled(true);
                                this.E.setEnabled(true);
                            }
                            if (this.F.equalsIgnoreCase(SDKConstants.VISA)) {
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.saved_cards_visa));
                                this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.n = 19;
                                this.K = 3;
                            } else if (this.F.equalsIgnoreCase("MASTER")) {
                                this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.saved_cards_master_card));
                                this.n = 19;
                                this.K = 3;
                            } else if (this.F.equalsIgnoreCase("DINERS")) {
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.diners));
                                this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(17)});
                                this.n = 17;
                                this.K = 3;
                            } else if (this.F.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                                this.H.setEnabled(false);
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.saved_cards_maestro));
                                this.n = 23;
                            } else if (this.F.equalsIgnoreCase("AMEX")) {
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
                                this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.saved_cards_ae));
                                this.n = 23;
                                this.K = 4;
                            } else if (this.F.equalsIgnoreCase("JCB")) {
                                this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.jcb));
                                this.n = 19;
                                this.K = 3;
                            } else if (this.F.equalsIgnoreCase("RUPAY")) {
                                this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13215f, R.drawable.saved_cards_rupay));
                                this.n = 19;
                                this.K = 3;
                            } else {
                                this.n = 23;
                                this.f13216g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
                                this.K = 3;
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(this.f13215f, this.j, iconUrl, str3);
                            }
                            if (channelCode.equalsIgnoreCase("bajaj")) {
                                this.H.setVisibility(8);
                                this.E.setEnabled(false);
                            }
                            this.j.setVisibility(0);
                        }
                    } else {
                        this.l.setText(String.format(this.f13215f.getResources().getString(R.string.emi_valid_credit_card), new Object[]{this.r.equalsIgnoreCase(SDKConstants.CREDIT) ? "credit card" : "debit card"}));
                        this.l.setTextColor(androidx.core.content.b.c(this.f13215f, R.color.color_fd5c5c));
                        this.f13216g.setBackground(androidx.core.content.b.a(this.f13215f, R.drawable.red_background_with_border));
                        this.X = false;
                        this.ao = false;
                    }
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            a.class.getSimpleName();
            q.d(fVar.f55798c.f55801c.getMessage());
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            this.f13210a.a("bin_detail", bundle, fVar.f55798c.f55801c);
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(aVar.f13215f));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
            jSONObject2.put("channelId", "WEB");
            jSONObject3.put("mid", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e);
            jSONObject3.put("isEMIDetail", true);
            jSONObject3.put("bin", str);
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        String jSONObject4 = jSONObject.toString();
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(aVar.f13215f, "offlinePGFetchBinDetails") + "?mid=" + net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e, new CJRFetchBinDetailsV2(), (Map<String, String>) null, hashMap2, jSONObject4);
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(aVar.f13215f, "p2mGenericAPITimeOut")));
        bVar.c().observeForever(new z() {
            public final void onChanged(Object obj) {
                a.this.a((f) obj);
            }
        });
    }
}
