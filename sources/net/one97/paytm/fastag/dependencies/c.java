package net.one97.paytm.fastag.dependencies;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.CJRSecureSharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.d.a;
import net.one97.paytm.fastag.d.d;
import net.one97.paytm.fastag.d.g;
import net.one97.paytm.fastag.f.f;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJRContact;
import net.one97.paytm.fastag.model.CJRCourierContacts;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRStatusFlow;
import net.one97.paytm.fastag.model.CJRUrlParams;

public final class c implements g.a<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    float f13637a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f13638b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRStatusFlow> f13639c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRVerticalStateProgressView f13640d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJRVerticalStateProgressView f13641e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJROrderSummary f13642f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJROrderedCart f13643g;

    /* renamed from: h  reason: collision with root package name */
    private float f13644h;

    /* renamed from: i  reason: collision with root package name */
    private float f13645i;
    private float j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    private boolean m;
    /* access modifiers changed from: private */
    public i n;
    /* access modifiers changed from: private */
    public Point o;
    /* access modifiers changed from: private */
    public Point p;
    private View q;
    private TextView r;
    private TextView s;
    private TextView t;
    /* access modifiers changed from: private */
    public LinearLayout u;
    private LinearLayout v;
    private boolean w;
    private View.OnClickListener x = new View.OnClickListener() {
        public final void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof CJRAction) {
                CJRAction cJRAction = (CJRAction) tag;
                String type = cJRAction.getType();
                char c2 = 65535;
                if (type.hashCode() == -1822952217 && type.equals("extendtime")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    c.this.n.a(c.this.f13642f, cJRAction, new HashMap(), "");
                } else if (c.this.f13642f != null && c.this.f13643g != null) {
                    String c3 = c.c(c.this);
                    if (!TextUtils.isEmpty(c3)) {
                        Activity d2 = c.this.f13638b;
                        CJROrderSummary a2 = c.this.f13642f;
                        i e2 = c.this.n;
                        String id = c.this.f13642f.getId();
                        StringBuilder sb = new StringBuilder();
                        sb.append(c.this.f13643g.getId());
                        new d(d2, a2, cJRAction, e2, id, sb.toString(), c3, c.this.f13643g.getMaxExtSLA()).show(c.this.f13638b.getFragmentManager(), d.class.getName());
                    }
                }
            }
        }
    };
    private View.OnClickListener y = new View.OnClickListener() {
        public final void onClick(View view) {
            if (!c.this.l) {
                view.animate().rotation((view.getRotation() + 180.0f) % 360.0f).setDuration(400).setListener(new Animator.AnimatorListener() {
                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationStart(Animator animator) {
                        boolean unused = c.this.l = true;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        boolean unused = c.this.l = false;
                    }
                });
                if (c.this.k) {
                    c.this.f13640d.setVisibility(8);
                    c.this.f13641e.setVisibility(0);
                    c.a(c.this.u, c.this.p, true);
                } else {
                    c.this.f13640d.setVisibility(0);
                    c.this.f13641e.setVisibility(8);
                    c.a(c.this.u, c.this.o, true);
                }
                c cVar = c.this;
                boolean unused = cVar.k = !cVar.k;
            }
        }
    };

    public final /* synthetic */ void onResponse(Object obj) {
        CJRCourierContacts cJRCourierContacts;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if ((iJRPaytmDataModel instanceof CJRCourierContacts) && (cJRCourierContacts = (CJRCourierContacts) iJRPaytmDataModel) != null && cJRCourierContacts.getContacts() != null) {
            ArrayList<CJRContact> contacts = cJRCourierContacts.getContacts();
            if (contacts.size() > 0 && contacts.get(0) != null && !TextUtils.isEmpty(contacts.get(0).getPhone())) {
                this.t.setVisibility(0);
            }
        }
    }

    public c(Activity activity, CJROrderSummary cJROrderSummary, i iVar, ArrayList<CJRStatusFlow> arrayList) {
        this.f13638b = activity;
        this.f13639c = arrayList;
        this.n = iVar;
        this.f13642f = cJROrderSummary;
        boolean z = false;
        if (!(cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || cJROrderSummary.getOrderedCartList().size() <= 0)) {
            this.f13643g = cJROrderSummary.getOrderedCartList().get(0);
        }
        this.j = this.f13638b.getResources().getDimension(R.dimen.item_status_progress_big_circle_radius);
        this.f13644h = this.f13638b.getResources().getDimension(R.dimen.vert_tl_detail_gap_to_arrow_x);
        this.f13645i = this.f13638b.getResources().getDimension(R.dimen.vert_tl_detail_gap_to_arrow_y);
        this.f13637a = this.f13638b.getResources().getDimension(R.dimen.exp_coll_arrow_top_margin);
        this.m = !this.w ? f.a.ITEM_STATUS_DELIVERED.getStatusId().equals(this.f13643g.getItemStatus()) : z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0188 A[Catch:{ Exception -> 0x0233 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01e1 A[Catch:{ Exception -> 0x0233 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0202 A[Catch:{ Exception -> 0x0233 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0219 A[Catch:{ Exception -> 0x0233 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a() {
        /*
            r11 = this;
            java.util.ArrayList<net.one97.paytm.fastag.model.CJRStatusFlow> r0 = r11.f13639c
            r1 = 0
            if (r0 == 0) goto L_0x0247
            int r0 = r0.size()
            if (r0 > 0) goto L_0x000d
            goto L_0x0247
        L_0x000d:
            android.app.Activity r0 = r11.f13638b     // Catch:{ Exception -> 0x0233 }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.layout.lyt_vertical_timeline_card_ft     // Catch:{ Exception -> 0x0233 }
            android.view.View r0 = r0.inflate(r2, r1)     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.vertical_tl_details     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0233 }
            r11.s = r2     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.title     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0233 }
            r11.r = r2     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.status_details_container     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0233 }
            r11.u = r2     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.action_buttons_container     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0233 }
            r11.v = r2     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.arrow_exp_coll     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            r11.q = r2     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.vertical_tl_view_expanded     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r2 = (net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView) r2     // Catch:{ Exception -> 0x0233 }
            r11.f13640d = r2     // Catch:{ Exception -> 0x0233 }
            int r2 = net.one97.paytm.fastag.R.id.vertical_tl_view_collapsed     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r2 = (net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView) r2     // Catch:{ Exception -> 0x0233 }
            r11.f13641e = r2     // Catch:{ Exception -> 0x0233 }
            java.util.ArrayList<net.one97.paytm.fastag.model.CJRStatusFlow> r2 = r11.f13639c     // Catch:{ Exception -> 0x0233 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0233 }
            r3 = r1
        L_0x0064:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0233 }
            if (r4 == 0) goto L_0x007a
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.model.CJRStatusFlow r4 = (net.one97.paytm.fastag.model.CJRStatusFlow) r4     // Catch:{ Exception -> 0x0233 }
            if (r4 == 0) goto L_0x0064
            net.one97.paytm.fastag.model.CJRStatusDetails r5 = r4.getmStatusDetails()     // Catch:{ Exception -> 0x0233 }
            if (r5 == 0) goto L_0x0064
            r3 = r4
            goto L_0x0064
        L_0x007a:
            r2 = 0
            if (r3 == 0) goto L_0x0163
            net.one97.paytm.fastag.model.CJRStatusDetails r4 = r3.getmStatusDetails()     // Catch:{ Exception -> 0x0233 }
            if (r4 != 0) goto L_0x0085
            goto L_0x0163
        L_0x0085:
            net.one97.paytm.fastag.model.CJRStatusDetails r4 = r3.getmStatusDetails()     // Catch:{ Exception -> 0x0233 }
            java.lang.String r5 = r4.getmStatusText()     // Catch:{ Exception -> 0x0233 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0233 }
            if (r5 != 0) goto L_0x00b3
            android.widget.LinearLayout r5 = r11.u     // Catch:{ Exception -> 0x0233 }
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r5 = r11.s     // Catch:{ Exception -> 0x0233 }
            android.text.method.MovementMethod r6 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x0233 }
            r5.setMovementMethod(r6)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r5 = r11.s     // Catch:{ Exception -> 0x0233 }
            java.lang.String r6 = r4.getmStatusText()     // Catch:{ Exception -> 0x0233 }
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)     // Catch:{ Exception -> 0x0233 }
            r5.setText(r6)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r5 = r11.s     // Catch:{ Exception -> 0x0233 }
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x0233 }
        L_0x00b3:
            java.lang.String r5 = r3.getText()     // Catch:{ Exception -> 0x0233 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0233 }
            if (r5 != 0) goto L_0x00cb
            android.widget.LinearLayout r5 = r11.u     // Catch:{ Exception -> 0x0233 }
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r5 = r11.r     // Catch:{ Exception -> 0x0233 }
            java.lang.String r6 = r3.getText()     // Catch:{ Exception -> 0x0233 }
            r5.setText(r6)     // Catch:{ Exception -> 0x0233 }
        L_0x00cb:
            java.util.ArrayList r4 = r4.getmActions()     // Catch:{ Exception -> 0x0233 }
            if (r4 == 0) goto L_0x0164
            int r5 = r4.size()     // Catch:{ Exception -> 0x0233 }
            if (r5 > 0) goto L_0x00d9
            goto L_0x0164
        L_0x00d9:
            r5 = 0
        L_0x00da:
            int r6 = r4.size()     // Catch:{ Exception -> 0x0233 }
            if (r5 >= r6) goto L_0x0164
            java.lang.Object r6 = r4.get(r5)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.model.CJRAction r6 = (net.one97.paytm.fastag.model.CJRAction) r6     // Catch:{ Exception -> 0x0233 }
            android.app.Activity r7 = r11.f13638b     // Catch:{ Exception -> 0x0233 }
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)     // Catch:{ Exception -> 0x0233 }
            int r8 = net.one97.paytm.fastag.R.layout.action_button_container_ft     // Catch:{ Exception -> 0x0233 }
            android.view.View r7 = r7.inflate(r8, r1)     // Catch:{ Exception -> 0x0233 }
            int r8 = net.one97.paytm.fastag.R.id.action_buttons_view_container     // Catch:{ Exception -> 0x0233 }
            android.view.View r7 = r7.findViewById(r8)     // Catch:{ Exception -> 0x0233 }
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7     // Catch:{ Exception -> 0x0233 }
            android.app.Activity r8 = r11.f13638b     // Catch:{ Exception -> 0x0233 }
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)     // Catch:{ Exception -> 0x0233 }
            int r9 = net.one97.paytm.fastag.R.layout.item_action_button_for_vertical_ft     // Catch:{ Exception -> 0x0233 }
            android.view.View r8 = r8.inflate(r9, r1)     // Catch:{ Exception -> 0x0233 }
            int r9 = net.one97.paytm.fastag.R.id.item_action_button     // Catch:{ Exception -> 0x0233 }
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x0233 }
            java.lang.String r10 = r6.getLabel()     // Catch:{ Exception -> 0x0233 }
            r9.setText(r10)     // Catch:{ Exception -> 0x0233 }
            r9.setTag(r6)     // Catch:{ Exception -> 0x0233 }
            r7.addView(r8)     // Catch:{ Exception -> 0x0233 }
            android.view.View$OnClickListener r8 = r11.x     // Catch:{ Exception -> 0x0233 }
            r9.setOnClickListener(r8)     // Catch:{ Exception -> 0x0233 }
            r11.a((net.one97.paytm.fastag.model.CJRAction) r6, (android.widget.TextView) r9)     // Catch:{ Exception -> 0x0233 }
            int r6 = r5 + 1
            int r8 = r4.size()     // Catch:{ Exception -> 0x0233 }
            if (r6 >= r8) goto L_0x015a
            java.lang.Object r6 = r4.get(r6)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.model.CJRAction r6 = (net.one97.paytm.fastag.model.CJRAction) r6     // Catch:{ Exception -> 0x0233 }
            android.app.Activity r8 = r11.f13638b     // Catch:{ Exception -> 0x0233 }
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)     // Catch:{ Exception -> 0x0233 }
            int r9 = net.one97.paytm.fastag.R.layout.item_action_button_for_vertical_ft     // Catch:{ Exception -> 0x0233 }
            android.view.View r8 = r8.inflate(r9, r1)     // Catch:{ Exception -> 0x0233 }
            int r9 = net.one97.paytm.fastag.R.id.item_action_button     // Catch:{ Exception -> 0x0233 }
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ Exception -> 0x0233 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x0233 }
            java.lang.String r10 = r6.getLabel()     // Catch:{ Exception -> 0x0233 }
            r9.setText(r10)     // Catch:{ Exception -> 0x0233 }
            r9.setTag(r6)     // Catch:{ Exception -> 0x0233 }
            r7.addView(r8)     // Catch:{ Exception -> 0x0233 }
            r11.a((net.one97.paytm.fastag.model.CJRAction) r6, (android.widget.TextView) r9)     // Catch:{ Exception -> 0x0233 }
            android.view.View$OnClickListener r6 = r11.x     // Catch:{ Exception -> 0x0233 }
            r9.setOnClickListener(r6)     // Catch:{ Exception -> 0x0233 }
        L_0x015a:
            android.widget.LinearLayout r6 = r11.v     // Catch:{ Exception -> 0x0233 }
            r6.addView(r7)     // Catch:{ Exception -> 0x0233 }
            int r5 = r5 + 2
            goto L_0x00da
        L_0x0163:
            r3 = r1
        L_0x0164:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0233 }
            r4.<init>()     // Catch:{ Exception -> 0x0233 }
            android.app.Activity r5 = r11.f13638b     // Catch:{ Exception -> 0x0233 }
            android.view.WindowManager r5 = r5.getWindowManager()     // Catch:{ Exception -> 0x0233 }
            android.view.Display r5 = r5.getDefaultDisplay()     // Catch:{ Exception -> 0x0233 }
            android.widget.LinearLayout r6 = r11.u     // Catch:{ Exception -> 0x0233 }
            int r7 = r5.getWidth()     // Catch:{ Exception -> 0x0233 }
            int r5 = r5.getHeight()     // Catch:{ Exception -> 0x0233 }
            r6.measure(r7, r5)     // Catch:{ Exception -> 0x0233 }
            android.widget.LinearLayout r5 = r11.u     // Catch:{ Exception -> 0x0233 }
            int r5 = r5.getMeasuredHeight()     // Catch:{ Exception -> 0x0233 }
            if (r3 == 0) goto L_0x018b
            r4.add(r3)     // Catch:{ Exception -> 0x0233 }
        L_0x018b:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r3 = r11.f13640d     // Catch:{ Exception -> 0x0233 }
            java.util.ArrayList<net.one97.paytm.fastag.model.CJRStatusFlow> r6 = r11.f13639c     // Catch:{ Exception -> 0x0233 }
            boolean r7 = r11.m     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r3 = r3.a(r6, r5, r7)     // Catch:{ Exception -> 0x0233 }
            r11.o = r3     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r3 = r11.f13641e     // Catch:{ Exception -> 0x0233 }
            boolean r6 = r11.m     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r3 = r3.a(r4, r5, r6)     // Catch:{ Exception -> 0x0233 }
            r11.p = r3     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.o     // Catch:{ Exception -> 0x0233 }
            int r4 = r4.x     // Catch:{ Exception -> 0x0233 }
            float r5 = r11.j     // Catch:{ Exception -> 0x0233 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x0233 }
            int r4 = r4 - r5
            float r5 = r11.f13637a     // Catch:{ Exception -> 0x0233 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x0233 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.o     // Catch:{ Exception -> 0x0233 }
            int r5 = r4.x     // Catch:{ Exception -> 0x0233 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0233 }
            float r6 = r11.f13644h     // Catch:{ Exception -> 0x0233 }
            float r5 = r5 + r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x0233 }
            r4.x = r5     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.p     // Catch:{ Exception -> 0x0233 }
            int r5 = r4.x     // Catch:{ Exception -> 0x0233 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0233 }
            float r6 = r11.f13644h     // Catch:{ Exception -> 0x0233 }
            float r5 = r5 + r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x0233 }
            r4.x = r5     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.o     // Catch:{ Exception -> 0x0233 }
            int r5 = r4.y     // Catch:{ Exception -> 0x0233 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0233 }
            float r6 = r11.f13645i     // Catch:{ Exception -> 0x0233 }
            float r5 = r5 - r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x0233 }
            r4.y = r5     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.p     // Catch:{ Exception -> 0x0233 }
            int r5 = r4.y     // Catch:{ Exception -> 0x0233 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0233 }
            float r6 = r11.f13645i     // Catch:{ Exception -> 0x0233 }
            float r5 = r5 - r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x0233 }
            r4.y = r5     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.o     // Catch:{ Exception -> 0x0233 }
            if (r4 == 0) goto L_0x01f5
            android.widget.LinearLayout r4 = r11.u     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r5 = r11.o     // Catch:{ Exception -> 0x0233 }
            int r5 = r5.x     // Catch:{ Exception -> 0x0233 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0233 }
            r4.setX(r5)     // Catch:{ Exception -> 0x0233 }
            android.widget.LinearLayout r4 = r11.u     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r5 = r11.o     // Catch:{ Exception -> 0x0233 }
            int r5 = r5.y     // Catch:{ Exception -> 0x0233 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0233 }
            r4.setY(r5)     // Catch:{ Exception -> 0x0233 }
        L_0x01f5:
            android.view.View r4 = r11.q     // Catch:{ Exception -> 0x0233 }
            android.view.View$OnClickListener r5 = r11.y     // Catch:{ Exception -> 0x0233 }
            r4.setOnClickListener(r5)     // Catch:{ Exception -> 0x0233 }
            boolean r4 = r11.m     // Catch:{ Exception -> 0x0233 }
            r5 = 8
            if (r4 == 0) goto L_0x0219
            android.widget.LinearLayout r4 = r11.u     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r6 = r11.p     // Catch:{ Exception -> 0x0233 }
            a(r4, r6, r2)     // Catch:{ Exception -> 0x0233 }
            android.view.View r4 = r11.q     // Catch:{ Exception -> 0x0233 }
            a(r4, r3, r2)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r3 = r11.f13640d     // Catch:{ Exception -> 0x0233 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r3 = r11.f13641e     // Catch:{ Exception -> 0x0233 }
            r3.setVisibility(r2)     // Catch:{ Exception -> 0x0233 }
            goto L_0x0232
        L_0x0219:
            android.widget.LinearLayout r3 = r11.u     // Catch:{ Exception -> 0x0233 }
            android.graphics.Point r4 = r11.o     // Catch:{ Exception -> 0x0233 }
            a(r3, r4, r2)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r3 = r11.f13640d     // Catch:{ Exception -> 0x0233 }
            r3.setVisibility(r2)     // Catch:{ Exception -> 0x0233 }
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView r2 = r11.f13641e     // Catch:{ Exception -> 0x0233 }
            r2.setVisibility(r5)     // Catch:{ Exception -> 0x0233 }
            android.view.View r2 = r11.q     // Catch:{ Exception -> 0x0233 }
            r2.setVisibility(r5)     // Catch:{ Exception -> 0x0233 }
            r2 = 1
            r11.k = r2     // Catch:{ Exception -> 0x0233 }
        L_0x0232:
            return r0
        L_0x0233:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.paytm.utility.q.b(r0)
        L_0x0247:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.dependencies.c.a():android.view.View");
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

    private void a(CJRAction cJRAction, TextView textView) {
        if (cJRAction != null && "contactcourier".equalsIgnoreCase(cJRAction.getType())) {
            this.t = textView;
            this.t.setVisibility(8);
            CJRUrlParams urlParams = cJRAction.getUrlParams();
            if (urlParams != null) {
                String replace = a(urlParams.getUrl()).replace(" ", "%20");
                net.one97.paytm.fastag.d.c.a();
                net.one97.paytm.fastag.d.c.a(new a(replace, this, new d() {
                    public final void onError(Throwable th) {
                    }
                }, new CJRCourierContacts(), (Map<String, String>) null));
            }
        }
    }

    private String a(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + CJRSecureSharedPreferences.getInstance(this.f13638b.getApplicationContext()).getString("sso_token=", "");
    }

    static /* synthetic */ String c(c cVar) {
        ArrayList<CJRStatusFlow> arrayList = cVar.f13639c;
        String str = "";
        if (arrayList != null) {
            Iterator<CJRStatusFlow> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRStatusFlow next = it2.next();
                if ("15".equals(next.getId())) {
                    str = next.getmCreatedAt();
                }
            }
        }
        return str;
    }
}
