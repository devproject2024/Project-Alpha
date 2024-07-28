package net.one97.paytm.paymentsBank.pdc.view;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.List;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.b;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse;

public final class c implements g.a, g.b {

    /* renamed from: a  reason: collision with root package name */
    float f18741a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f18742b;

    /* renamed from: c  reason: collision with root package name */
    private List<PDCTrackOrderResponse.StatusFlow> f18743c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public PDCVerticalStateProgressView f18744d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public PDCVerticalStateProgressView f18745e;

    /* renamed from: f  reason: collision with root package name */
    private PDCTrackOrderResponse f18746f;

    /* renamed from: g  reason: collision with root package name */
    private float f18747g;

    /* renamed from: h  reason: collision with root package name */
    private float f18748h;

    /* renamed from: i  reason: collision with root package name */
    private float f18749i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    private boolean l;
    /* access modifiers changed from: private */
    public d m;
    /* access modifiers changed from: private */
    public Point n;
    /* access modifiers changed from: private */
    public Point o;
    private TextView p;
    private TextView q;
    /* access modifiers changed from: private */
    public LinearLayout r;
    private LinearLayout s;
    private boolean t;
    private View.OnClickListener u = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof PDCTrackOrderResponse.Action) {
                c.this.m.onFragmentAction(107, (Object) null);
            }
        }
    };
    private View.OnClickListener v = new View.OnClickListener() {
        public final void onClick(View view) {
            if (!c.this.k) {
                view.animate().rotation((view.getRotation() + 180.0f) % 360.0f).setDuration(400).setListener(new Animator.AnimatorListener() {
                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationStart(Animator animator) {
                        boolean unused = c.this.k = true;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        boolean unused = c.this.k = false;
                    }
                });
                if (c.this.j) {
                    c.this.f18744d.setVisibility(8);
                    c.this.f18745e.setVisibility(0);
                    c.a(c.this.r, c.this.o, true);
                } else {
                    c.this.f18744d.setVisibility(0);
                    c.this.f18745e.setVisibility(8);
                    c.a(c.this.r, c.this.n, true);
                }
                c cVar = c.this;
                boolean unused = cVar.j = !cVar.j;
            }
        }
    };

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void onResponse(Object obj) {
    }

    public c(Activity activity, PDCTrackOrderResponse pDCTrackOrderResponse, d dVar) {
        boolean z;
        this.f18742b = activity;
        this.f18743c = pDCTrackOrderResponse.getPayload().getStatusFlow();
        this.m = dVar;
        this.f18746f = pDCTrackOrderResponse;
        this.t = true;
        this.f18749i = this.f18742b.getResources().getDimension(R.dimen.item_status_progress_big_circle_radius);
        this.f18747g = this.f18742b.getResources().getDimension(R.dimen.vert_tl_detail_gap_to_arrow_x);
        this.f18748h = this.f18742b.getResources().getDimension(R.dimen.vert_tl_detail_gap_to_arrow_y);
        this.f18741a = this.f18742b.getResources().getDimension(R.dimen.exp_coll_arrow_top_margin);
        if (this.t) {
            z = false;
        } else {
            z = b.a.ITEM_STATUS_DELIVERED.getStatusId().equals(this.f18746f.getPayload().getCurrentStatus());
        }
        this.l = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0171 A[Catch:{ Exception -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01e0 A[Catch:{ Exception -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01ff A[Catch:{ Exception -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0214 A[Catch:{ Exception -> 0x022c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a() {
        /*
            r12 = this;
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r0 = r12.f18743c
            r1 = 0
            if (r0 == 0) goto L_0x022c
            int r0 = r0.size()
            if (r0 > 0) goto L_0x000d
            goto L_0x022c
        L_0x000d:
            android.app.Activity r0 = r12.f18742b     // Catch:{ Exception -> 0x022c }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ Exception -> 0x022c }
            int r2 = net.one97.paytm.paymentsBank.R.layout.pdc_lyt_vertical_timeline_card     // Catch:{ Exception -> 0x022c }
            android.view.View r0 = r0.inflate(r2, r1)     // Catch:{ Exception -> 0x022c }
            int r2 = net.one97.paytm.paymentsBank.R.id.vertical_tl_details     // Catch:{ Exception -> 0x022c }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x022c }
            r12.q = r2     // Catch:{ Exception -> 0x022c }
            int r2 = net.one97.paytm.paymentsBank.R.id.title     // Catch:{ Exception -> 0x022c }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x022c }
            r12.p = r2     // Catch:{ Exception -> 0x022c }
            int r2 = net.one97.paytm.paymentsBank.R.id.status_details_container     // Catch:{ Exception -> 0x022c }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x022c }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x022c }
            r12.r = r2     // Catch:{ Exception -> 0x022c }
            int r2 = net.one97.paytm.paymentsBank.R.id.action_buttons_container     // Catch:{ Exception -> 0x022c }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x022c }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x022c }
            r12.s = r2     // Catch:{ Exception -> 0x022c }
            int r2 = net.one97.paytm.paymentsBank.R.id.arrow_exp_coll     // Catch:{ Exception -> 0x022c }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x022c }
            int r3 = net.one97.paytm.paymentsBank.R.id.vertical_tl_view_expanded     // Catch:{ Exception -> 0x022c }
            android.view.View r3 = r0.findViewById(r3)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r3 = (net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView) r3     // Catch:{ Exception -> 0x022c }
            r12.f18744d = r3     // Catch:{ Exception -> 0x022c }
            int r3 = net.one97.paytm.paymentsBank.R.id.vertical_tl_view_collapsed     // Catch:{ Exception -> 0x022c }
            android.view.View r3 = r0.findViewById(r3)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r3 = (net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView) r3     // Catch:{ Exception -> 0x022c }
            r12.f18745e = r3     // Catch:{ Exception -> 0x022c }
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r3 = r12.f18743c     // Catch:{ Exception -> 0x022c }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x022c }
            r4 = r1
        L_0x0062:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x022c }
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow r5 = (net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse.StatusFlow) r5     // Catch:{ Exception -> 0x022c }
            if (r5 == 0) goto L_0x0062
            java.lang.String r6 = r5.getLabel()     // Catch:{ Exception -> 0x022c }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x022c }
            if (r6 != 0) goto L_0x0062
            r4 = r5
            goto L_0x0062
        L_0x007c:
            r3 = 0
            if (r4 == 0) goto L_0x014c
            java.lang.String r5 = r4.getLabel()     // Catch:{ Exception -> 0x022c }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x022c }
            if (r5 == 0) goto L_0x008b
            goto L_0x014c
        L_0x008b:
            java.lang.String r5 = r4.getStatusDetailTxt()     // Catch:{ Exception -> 0x022c }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x022c }
            if (r5 != 0) goto L_0x00ba
            android.widget.LinearLayout r5 = r12.r     // Catch:{ Exception -> 0x022c }
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r5 = r12.p     // Catch:{ Exception -> 0x022c }
            java.lang.String r6 = r4.getLabel()     // Catch:{ Exception -> 0x022c }
            r5.setText(r6)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r5 = r12.q     // Catch:{ Exception -> 0x022c }
            java.lang.String r6 = r4.getStatusDetailTxt()     // Catch:{ Exception -> 0x022c }
            r5.setText(r6)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r5 = r12.q     // Catch:{ Exception -> 0x022c }
            android.text.method.MovementMethod r6 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x022c }
            r5.setMovementMethod(r6)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r5 = r12.q     // Catch:{ Exception -> 0x022c }
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x022c }
        L_0x00ba:
            java.util.List r5 = r4.getActions()     // Catch:{ Exception -> 0x022c }
            if (r5 == 0) goto L_0x014d
            int r6 = r5.size()     // Catch:{ Exception -> 0x022c }
            if (r6 > 0) goto L_0x00c8
            goto L_0x014d
        L_0x00c8:
            r6 = 0
        L_0x00c9:
            int r7 = r5.size()     // Catch:{ Exception -> 0x022c }
            if (r6 >= r7) goto L_0x014d
            java.lang.Object r7 = r5.get(r6)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$Action r7 = (net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse.Action) r7     // Catch:{ Exception -> 0x022c }
            android.app.Activity r8 = r12.f18742b     // Catch:{ Exception -> 0x022c }
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)     // Catch:{ Exception -> 0x022c }
            int r9 = net.one97.paytm.paymentsBank.R.layout.pdc_action_button_container     // Catch:{ Exception -> 0x022c }
            android.view.View r8 = r8.inflate(r9, r1)     // Catch:{ Exception -> 0x022c }
            int r9 = net.one97.paytm.paymentsBank.R.id.action_buttons_view_container     // Catch:{ Exception -> 0x022c }
            android.view.View r8 = r8.findViewById(r9)     // Catch:{ Exception -> 0x022c }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x022c }
            android.app.Activity r9 = r12.f18742b     // Catch:{ Exception -> 0x022c }
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)     // Catch:{ Exception -> 0x022c }
            int r10 = net.one97.paytm.paymentsBank.R.layout.pdc_item_action_button_for_vertical     // Catch:{ Exception -> 0x022c }
            android.view.View r9 = r9.inflate(r10, r1)     // Catch:{ Exception -> 0x022c }
            int r10 = net.one97.paytm.paymentsBank.R.id.item_action_button     // Catch:{ Exception -> 0x022c }
            android.view.View r10 = r9.findViewById(r10)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x022c }
            java.lang.String r11 = r7.getLabel()     // Catch:{ Exception -> 0x022c }
            r10.setText(r11)     // Catch:{ Exception -> 0x022c }
            r10.setTag(r7)     // Catch:{ Exception -> 0x022c }
            r8.addView(r9)     // Catch:{ Exception -> 0x022c }
            android.view.View$OnClickListener r7 = r12.u     // Catch:{ Exception -> 0x022c }
            r10.setOnClickListener(r7)     // Catch:{ Exception -> 0x022c }
            int r7 = r6 + 1
            int r9 = r5.size()     // Catch:{ Exception -> 0x022c }
            if (r7 >= r9) goto L_0x0143
            java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$Action r7 = (net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse.Action) r7     // Catch:{ Exception -> 0x022c }
            android.app.Activity r9 = r12.f18742b     // Catch:{ Exception -> 0x022c }
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)     // Catch:{ Exception -> 0x022c }
            int r10 = net.one97.paytm.paymentsBank.R.layout.pdc_item_action_button_for_vertical     // Catch:{ Exception -> 0x022c }
            android.view.View r9 = r9.inflate(r10, r1)     // Catch:{ Exception -> 0x022c }
            int r10 = net.one97.paytm.paymentsBank.R.id.item_action_button     // Catch:{ Exception -> 0x022c }
            android.view.View r10 = r9.findViewById(r10)     // Catch:{ Exception -> 0x022c }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x022c }
            java.lang.String r11 = r7.getLabel()     // Catch:{ Exception -> 0x022c }
            r10.setText(r11)     // Catch:{ Exception -> 0x022c }
            r10.setTag(r7)     // Catch:{ Exception -> 0x022c }
            r8.addView(r9)     // Catch:{ Exception -> 0x022c }
            android.view.View$OnClickListener r7 = r12.u     // Catch:{ Exception -> 0x022c }
            r10.setOnClickListener(r7)     // Catch:{ Exception -> 0x022c }
        L_0x0143:
            android.widget.LinearLayout r7 = r12.s     // Catch:{ Exception -> 0x022c }
            r7.addView(r8)     // Catch:{ Exception -> 0x022c }
            int r6 = r6 + 2
            goto L_0x00c9
        L_0x014c:
            r4 = r1
        L_0x014d:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x022c }
            r5.<init>()     // Catch:{ Exception -> 0x022c }
            android.app.Activity r6 = r12.f18742b     // Catch:{ Exception -> 0x022c }
            android.view.WindowManager r6 = r6.getWindowManager()     // Catch:{ Exception -> 0x022c }
            android.view.Display r6 = r6.getDefaultDisplay()     // Catch:{ Exception -> 0x022c }
            android.widget.LinearLayout r7 = r12.r     // Catch:{ Exception -> 0x022c }
            int r8 = r6.getWidth()     // Catch:{ Exception -> 0x022c }
            int r6 = r6.getHeight()     // Catch:{ Exception -> 0x022c }
            r7.measure(r8, r6)     // Catch:{ Exception -> 0x022c }
            android.widget.LinearLayout r6 = r12.r     // Catch:{ Exception -> 0x022c }
            int r6 = r6.getMeasuredHeight()     // Catch:{ Exception -> 0x022c }
            if (r4 == 0) goto L_0x0174
            r5.add(r4)     // Catch:{ Exception -> 0x022c }
        L_0x0174:
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r4 = r12.f18744d     // Catch:{ Exception -> 0x022c }
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r5 = r12.f18743c     // Catch:{ Exception -> 0x022c }
            boolean r7 = r12.l     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse r8 = r12.f18746f     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$Payload r8 = r8.getPayload()     // Catch:{ Exception -> 0x022c }
            java.lang.String r8 = r8.getCurrentStatus()     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r4 = r4.a(r5, r6, r7, r8)     // Catch:{ Exception -> 0x022c }
            r12.n = r4     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r4 = r12.f18745e     // Catch:{ Exception -> 0x022c }
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r5 = r12.f18743c     // Catch:{ Exception -> 0x022c }
            boolean r7 = r12.l     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse r8 = r12.f18746f     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$Payload r8 = r8.getPayload()     // Catch:{ Exception -> 0x022c }
            java.lang.String r8 = r8.getCurrentStatus()     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r4 = r4.a(r5, r6, r7, r8)     // Catch:{ Exception -> 0x022c }
            r12.o = r4     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r4 = new android.graphics.Point     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.n     // Catch:{ Exception -> 0x022c }
            int r5 = r5.x     // Catch:{ Exception -> 0x022c }
            float r6 = r12.f18749i     // Catch:{ Exception -> 0x022c }
            int r6 = (int) r6     // Catch:{ Exception -> 0x022c }
            int r5 = r5 - r6
            float r6 = r12.f18741a     // Catch:{ Exception -> 0x022c }
            int r6 = (int) r6     // Catch:{ Exception -> 0x022c }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.n     // Catch:{ Exception -> 0x022c }
            int r6 = r5.x     // Catch:{ Exception -> 0x022c }
            float r6 = (float) r6     // Catch:{ Exception -> 0x022c }
            float r7 = r12.f18747g     // Catch:{ Exception -> 0x022c }
            float r6 = r6 + r7
            int r6 = (int) r6     // Catch:{ Exception -> 0x022c }
            r5.x = r6     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.o     // Catch:{ Exception -> 0x022c }
            int r6 = r5.x     // Catch:{ Exception -> 0x022c }
            float r6 = (float) r6     // Catch:{ Exception -> 0x022c }
            float r7 = r12.f18747g     // Catch:{ Exception -> 0x022c }
            float r6 = r6 + r7
            int r6 = (int) r6     // Catch:{ Exception -> 0x022c }
            r5.x = r6     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.n     // Catch:{ Exception -> 0x022c }
            int r6 = r5.y     // Catch:{ Exception -> 0x022c }
            float r6 = (float) r6     // Catch:{ Exception -> 0x022c }
            float r7 = r12.f18748h     // Catch:{ Exception -> 0x022c }
            float r6 = r6 - r7
            int r6 = (int) r6     // Catch:{ Exception -> 0x022c }
            r5.y = r6     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.o     // Catch:{ Exception -> 0x022c }
            int r6 = r5.y     // Catch:{ Exception -> 0x022c }
            float r6 = (float) r6     // Catch:{ Exception -> 0x022c }
            float r7 = r12.f18748h     // Catch:{ Exception -> 0x022c }
            float r6 = r6 - r7
            int r6 = (int) r6     // Catch:{ Exception -> 0x022c }
            r5.y = r6     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.n     // Catch:{ Exception -> 0x022c }
            if (r5 == 0) goto L_0x01f4
            android.widget.LinearLayout r5 = r12.r     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r6 = r12.n     // Catch:{ Exception -> 0x022c }
            int r6 = r6.x     // Catch:{ Exception -> 0x022c }
            float r6 = (float) r6     // Catch:{ Exception -> 0x022c }
            r5.setX(r6)     // Catch:{ Exception -> 0x022c }
            android.widget.LinearLayout r5 = r12.r     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r6 = r12.n     // Catch:{ Exception -> 0x022c }
            int r6 = r6.y     // Catch:{ Exception -> 0x022c }
            float r6 = (float) r6     // Catch:{ Exception -> 0x022c }
            r5.setY(r6)     // Catch:{ Exception -> 0x022c }
        L_0x01f4:
            android.view.View$OnClickListener r5 = r12.v     // Catch:{ Exception -> 0x022c }
            r2.setOnClickListener(r5)     // Catch:{ Exception -> 0x022c }
            boolean r5 = r12.l     // Catch:{ Exception -> 0x022c }
            r6 = 8
            if (r5 == 0) goto L_0x0214
            android.widget.LinearLayout r5 = r12.r     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r7 = r12.o     // Catch:{ Exception -> 0x022c }
            a(r5, r7, r3)     // Catch:{ Exception -> 0x022c }
            a(r2, r4, r3)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r2 = r12.f18744d     // Catch:{ Exception -> 0x022c }
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r2 = r12.f18745e     // Catch:{ Exception -> 0x022c }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x022c }
            goto L_0x022b
        L_0x0214:
            android.widget.LinearLayout r4 = r12.r     // Catch:{ Exception -> 0x022c }
            android.graphics.Point r5 = r12.n     // Catch:{ Exception -> 0x022c }
            a(r4, r5, r3)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r4 = r12.f18744d     // Catch:{ Exception -> 0x022c }
            r4.setVisibility(r3)     // Catch:{ Exception -> 0x022c }
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView r3 = r12.f18745e     // Catch:{ Exception -> 0x022c }
            r3.setVisibility(r6)     // Catch:{ Exception -> 0x022c }
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x022c }
            r2 = 1
            r12.j = r2     // Catch:{ Exception -> 0x022c }
        L_0x022b:
            return r0
        L_0x022c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.pdc.view.c.a():android.view.View");
    }

    /* access modifiers changed from: private */
    public static void a(View view, Point point, boolean z) {
        if (point != null) {
            if (z) {
                view.animate().translationX((float) point.x).translationY((float) point.y).setDuration(400).start();
                return;
            }
            view.setX((float) point.x);
            view.setY((float) point.y);
        }
    }
}
