package net.one97.paytm.passbook.transactionDetail.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.transactionsTag.AllTagsResponse;
import net.one97.paytm.passbook.beans.transactionsTag.Response;
import net.one97.paytm.passbook.beans.transactionsTag.UpdateTagsResponse;
import net.one97.paytm.passbook.customview.ToggleStatusButton;
import net.one97.paytm.passbook.subWallet.widget.FlowLayout;
import net.one97.paytm.passbook.transactionDetail.d.a;
import org.json.JSONObject;

public final class a extends net.one97.paytm.i.f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f59029a;

    /* renamed from: b  reason: collision with root package name */
    private CJRTransaction f59030b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f59031c;

    /* renamed from: d  reason: collision with root package name */
    private View f59032d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<View> f59033e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.passbook.transactionDetail.d.a f59034f;

    /* renamed from: g  reason: collision with root package name */
    private String f59035g;

    /* renamed from: h  reason: collision with root package name */
    private final m f59036h = new m(this);

    /* renamed from: i  reason: collision with root package name */
    private HashMap f59037i;

    /* renamed from: net.one97.paytm.passbook.transactionDetail.b.a$a  reason: collision with other inner class name */
    public interface C1138a {
        void a(ToggleStatusButton toggleStatusButton);
    }

    static final class b<T> implements z<AllTagsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59038a;

        b(a aVar) {
            this.f59038a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AllTagsResponse allTagsResponse = (AllTagsResponse) obj;
            ArrayList<String> arrayList = null;
            if (kotlin.m.p.a("SUCCESS", allTagsResponse != null ? allTagsResponse.getStatusCode() : null, true)) {
                if (allTagsResponse != null) {
                    arrayList = allTagsResponse.getTagList();
                }
                a aVar = this.f59038a;
                if (arrayList == null) {
                    kotlin.g.b.k.a();
                }
                a.a(aVar, arrayList);
                return;
            }
            Toast.makeText(this.f59038a.getContext(), this.f59038a.getString(R.string.some_went_wrong), 0).show();
            this.f59038a.dismiss();
        }
    }

    static final class c<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59039a;

        c(a aVar) {
            this.f59039a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            if (!net.one97.paytm.passbook.utility.j.a((Context) this.f59039a.getActivity(), networkCustomError)) {
                this.f59039a.getClass().getSimpleName();
                net.one97.paytm.passbook.utility.j.a((Activity) this.f59039a.getActivity(), (Throwable) networkCustomError);
            }
            this.f59039a.dismiss();
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59041a;

        e(a aVar) {
            this.f59041a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                net.one97.paytm.common.widgets.a.a(this.f59041a.a());
            } else {
                net.one97.paytm.common.widgets.a.b(this.f59041a.a());
            }
        }
    }

    static final class f<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59042a;

        f(a aVar) {
            this.f59042a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            final net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            TextView textView = (TextView) a.c(this.f59042a).findViewById(R.id.saveTv);
            kotlin.g.b.k.a((Object) textView, "contentView.saveTv");
            textView.setEnabled(true);
            FlowLayout flowLayout = (FlowLayout) a.c(this.f59042a).findViewById(R.id.tagsFlowLayout);
            kotlin.g.b.k.a((Object) flowLayout, "contentView.tagsFlowLayout");
            if (flowLayout.getChildCount() == 0) {
                net.one97.paytm.passbook.mapping.c.g(this.f59042a.getActivity());
                this.f59042a.dismiss();
                return;
            }
            net.one97.paytm.passbook.mapping.c.a(this.f59042a.getActivity(), new DialogInterface.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ f f59043a;

                {
                    this.f59043a = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    a.d(this.f59043a.f59042a).a(eVar);
                }
            });
        }
    }

    static final class p<T> implements z<UpdateTagsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f59055b;

        p(a aVar, String str) {
            this.f59054a = aVar;
            this.f59055b = str;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            UpdateTagsResponse updateTagsResponse = (UpdateTagsResponse) obj;
            String str = null;
            if (!kotlin.m.p.a("SUCCESS", updateTagsResponse != null ? updateTagsResponse.getStatusCode() : null, true)) {
                if (updateTagsResponse != null) {
                    str = updateTagsResponse.getStatusMessage();
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.f59054a.getString(R.string.some_went_wrong);
                }
                net.one97.paytm.passbook.mapping.c.b(this.f59054a.getContext(), this.f59054a.getString(R.string.error), str);
                ((TextView) a.c(this.f59054a).findViewById(R.id.saveTv)).setText(this.f59054a.getString(R.string.save));
                TextView textView = (TextView) a.c(this.f59054a).findViewById(R.id.saveTv);
                kotlin.g.b.k.a((Object) textView, "contentView.saveTv");
                textView.setEnabled(true);
            } else if (updateTagsResponse != null && updateTagsResponse.getResponse() != null) {
                a.g(this.f59054a).getTagInfo().tag = this.f59055b;
                a.g(this.f59054a).getTagInfo().count++;
                b h2 = this.f59054a.f59029a;
                if (h2 != null) {
                    h2.a();
                }
                this.f59054a.dismiss();
            }
        }
    }

    static final class q<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59056a;

        q(a aVar) {
            this.f59056a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            TextView textView = (TextView) a.c(this.f59056a).findViewById(R.id.saveTv);
            kotlin.g.b.k.a((Object) textView, "contentView.saveTv");
            textView.setEnabled(true);
            if (!net.one97.paytm.passbook.utility.j.a((Context) this.f59056a.getActivity(), networkCustomError)) {
                this.f59056a.getClass().getSimpleName();
                net.one97.paytm.passbook.utility.j.a((Activity) this.f59056a.getActivity(), (Throwable) networkCustomError);
            }
            this.f59056a.dismiss();
        }
    }

    public static final /* synthetic */ View c(a aVar) {
        View view = aVar.f59032d;
        if (view == null) {
            kotlin.g.b.k.a("contentView");
        }
        return view;
    }

    public static final /* synthetic */ net.one97.paytm.passbook.transactionDetail.d.a d(a aVar) {
        net.one97.paytm.passbook.transactionDetail.d.a aVar2 = aVar.f59034f;
        if (aVar2 == null) {
            kotlin.g.b.k.a("tagsViewModel");
        }
        return aVar2;
    }

    public static final /* synthetic */ CJRTransaction g(a aVar) {
        CJRTransaction cJRTransaction = aVar.f59030b;
        if (cJRTransaction == null) {
            kotlin.g.b.k.a("transaction");
        }
        return cJRTransaction;
    }

    public static final class m extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59051a;

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "bottomSheet");
        }

        m(a aVar) {
            this.f59051a = aVar;
        }

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "bottomSheet");
            if (i2 == 5) {
                this.f59051a.dismiss();
            }
        }
    }

    public a(String str, CJRTransaction cJRTransaction) {
        kotlin.g.b.k.c(str, "title");
        kotlin.g.b.k.c(cJRTransaction, "transaction");
        this.f59035g = str;
        this.f59030b = cJRTransaction;
    }

    public a() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.transactionDetail.d.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…agsViewModel::class.java)");
        this.f59034f = (net.one97.paytm.passbook.transactionDetail.d.a) a2;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setCancelable(false);
            aVar.setOnShowListener(n.f59052a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class n implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final n f59052a = new n();

        n() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    kotlin.g.b.k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void setupDialog(Dialog dialog, int i2) {
        Dialog dialog2 = dialog;
        kotlin.g.b.k.c(dialog2, "dialog");
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.pass_add_edit_tag_dialog, (ViewGroup) null);
        kotlin.g.b.k.a((Object) inflate, "View.inflate(context, R.…dd_edit_tag_dialog, null)");
        this.f59032d = inflate;
        View view = this.f59032d;
        if (view == null) {
            kotlin.g.b.k.a("contentView");
        }
        dialog2.setContentView(view);
        View view2 = this.f59032d;
        if (view2 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((ImageView) view2.findViewById(R.id.iv_close)).setOnClickListener(new d(this));
        View view3 = this.f59032d;
        if (view3 == null) {
            kotlin.g.b.k.a("contentView");
        }
        RoboTextView roboTextView = (RoboTextView) view3.findViewById(R.id.title_tv);
        String str = this.f59035g;
        if (str == null) {
            kotlin.g.b.k.a("title");
        }
        roboTextView.setText(str);
        View view4 = this.f59032d;
        if (view4 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((FlowLayout) view4.findViewById(R.id.tagsFlowLayout)).a();
        net.one97.paytm.passbook.transactionDetail.d.a aVar = this.f59034f;
        if (aVar == null) {
            kotlin.g.b.k.a("tagsViewModel");
        }
        androidx.lifecycle.q qVar = this;
        aVar.f59141a.observe(qVar, new e(this));
        net.one97.paytm.passbook.transactionDetail.d.a aVar2 = this.f59034f;
        if (aVar2 == null) {
            kotlin.g.b.k.a("tagsViewModel");
        }
        x.e eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = new y();
        kotlin.o oVar = new kotlin.o((y) eVar.element, (y) eVar2.element);
        kotlin.g.b.k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        String s = com.paytm.utility.b.s(aVar2.getApplication(), net.one97.paytm.passbook.mapping.e.y());
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(aVar2.getApplication());
        kotlin.g.b.k.a((Object) a2, "CJRServerUtility.getSSOToken(getApplication())");
        hashMap.put("ssotoken", a2);
        hashMap.put("Content-Type", "application/json");
        aVar2.a((net.one97.paytm.passbook.mapping.a.e) new net.one97.paytm.passbook.mapping.a.a(s, new a.C1139a(aVar2, eVar), new a.b(aVar2, eVar2), new AllTagsResponse((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 63, (kotlin.g.b.g) null), hashMap, a.c.PASSBOOK, a.b.USER_FACING, net.one97.paytm.passbook.transactionDetail.d.a.class.getSimpleName()));
        ((y) oVar.getFirst()).observe(qVar, new b(this));
        ((y) oVar.getSecond()).observe(qVar, new c(this));
        net.one97.paytm.passbook.transactionDetail.d.a aVar3 = this.f59034f;
        if (aVar3 == null) {
            kotlin.g.b.k.a("tagsViewModel");
        }
        aVar3.f59142b.observe(qVar, new f(this));
        View view5 = this.f59032d;
        if (view5 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((AppCompatEditText) view5.findViewById(R.id.enterTagEdt)).setOnFocusChangeListener(new g(this));
        View view6 = this.f59032d;
        if (view6 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((AppCompatEditText) view6.findViewById(R.id.enterTagEdt)).addTextChangedListener(new h(this));
        View view7 = this.f59032d;
        if (view7 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((ImageView) view7.findViewById(R.id.clearTextImv)).setOnClickListener(new i(this));
        View view8 = this.f59032d;
        if (view8 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((FlowLayout) view8.findViewById(R.id.tagsFlowLayout)).setOnSelectListener(new j(this));
        View view9 = this.f59032d;
        if (view9 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((TextView) view9.findViewById(R.id.saveTv)).setOnClickListener(new k(this));
        View view10 = this.f59032d;
        if (view10 == null) {
            kotlin.g.b.k.a("contentView");
        }
        ((AppCompatEditText) view10.findViewById(R.id.enterTagEdt)).setOnEditorActionListener(new l(this));
        try {
            View view11 = this.f59032d;
            if (view11 == null) {
                kotlin.g.b.k.a("contentView");
            }
            ViewParent parent = view11.getParent();
            if (parent != null) {
                ((View) parent).setBackgroundColor(getResources().getColor(17170445));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        } catch (Exception unused) {
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59040a;

        d(a aVar) {
            this.f59040a = aVar;
        }

        public final void onClick(View view) {
            this.f59040a.dismiss();
        }
    }

    static final class g implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59045a;

        g(a aVar) {
            this.f59045a = aVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                ((FlowLayout) a.c(this.f59045a).findViewById(R.id.tagsFlowLayout)).b();
            }
        }
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59046a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(a aVar) {
            this.f59046a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
            r4 = r4.getText();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r4) {
            /*
                r3 = this;
                net.one97.paytm.passbook.transactionDetail.b.a r4 = r3.f59046a
                android.view.View r4 = net.one97.paytm.passbook.transactionDetail.b.a.c(r4)
                int r0 = net.one97.paytm.passbook.R.id.enterTagEdt
                android.view.View r4 = r4.findViewById(r0)
                androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
                r0 = 0
                if (r4 == 0) goto L_0x001c
                android.text.Editable r4 = r4.getText()
                if (r4 == 0) goto L_0x001c
                int r4 = r4.length()
                goto L_0x001d
            L_0x001c:
                r4 = 0
            L_0x001d:
                java.lang.String r1 = "contentView.clearTextImv"
                if (r4 <= 0) goto L_0x0036
                net.one97.paytm.passbook.transactionDetail.b.a r4 = r3.f59046a
                android.view.View r4 = net.one97.paytm.passbook.transactionDetail.b.a.c(r4)
                int r2 = net.one97.paytm.passbook.R.id.clearTextImv
                android.view.View r4 = r4.findViewById(r2)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                r4.setVisibility(r0)
                return
            L_0x0036:
                net.one97.paytm.passbook.transactionDetail.b.a r4 = r3.f59046a
                android.view.View r4 = net.one97.paytm.passbook.transactionDetail.b.a.c(r4)
                int r0 = net.one97.paytm.passbook.R.id.clearTextImv
                android.view.View r4 = r4.findViewById(r0)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                r0 = 8
                r4.setVisibility(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.b.a.h.afterTextChanged(android.text.Editable):void");
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59047a;

        i(a aVar) {
            this.f59047a = aVar;
        }

        public final void onClick(View view) {
            ((AppCompatEditText) a.c(this.f59047a).findViewById(R.id.enterTagEdt)).setText("");
            ((FlowLayout) a.c(this.f59047a).findViewById(R.id.tagsFlowLayout)).b();
        }
    }

    public static final class j implements C1138a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59048a;

        j(a aVar) {
            this.f59048a = aVar;
        }

        public final void a(ToggleStatusButton toggleStatusButton) {
            kotlin.g.b.k.c(toggleStatusButton, "btn");
            AppCompatEditText appCompatEditText = (AppCompatEditText) a.c(this.f59048a).findViewById(R.id.enterTagEdt);
            kotlin.g.b.k.a((Object) appCompatEditText, "contentView.enterTagEdt");
            a.a((View) appCompatEditText);
            ToggleButton toggleBtn = toggleStatusButton.getToggleBtn();
            kotlin.g.b.k.a((Object) toggleBtn, "btn.toggleBtn");
            ((AppCompatEditText) a.c(this.f59048a).findViewById(R.id.enterTagEdt)).setText(toggleBtn.getText());
            ((AppCompatEditText) a.c(this.f59048a).findViewById(R.id.enterTagEdt)).clearFocus();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59049a;

        k(a aVar) {
            this.f59049a = aVar;
        }

        public final void onClick(View view) {
            a.e(this.f59049a);
        }
    }

    public static final class l implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59050a;

        l(a aVar) {
            this.f59050a = aVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            AppCompatEditText appCompatEditText = (AppCompatEditText) a.c(this.f59050a).findViewById(R.id.enterTagEdt);
            kotlin.g.b.k.a((Object) appCompatEditText, "contentView.enterTagEdt");
            a.a((View) appCompatEditText);
            return true;
        }
    }

    public static final class o implements g.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59053a;

        o(a aVar) {
            this.f59053a = aVar;
        }

        public final void a() {
            this.f59053a.a((String) null);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        String str2 = str;
        View view = this.f59032d;
        if (view == null) {
            kotlin.g.b.k.a("contentView");
        }
        TextView textView = (TextView) view.findViewById(R.id.saveTv);
        kotlin.g.b.k.a((Object) textView, "contentView.saveTv");
        textView.setEnabled(false);
        View view2 = this.f59032d;
        if (view2 == null) {
            kotlin.g.b.k.a("contentView");
        }
        TextView textView2 = (TextView) view2.findViewById(R.id.saveTv);
        kotlin.g.b.k.a((Object) textView2, "contentView.saveTv");
        textView2.setText("");
        CJRTransaction cJRTransaction = this.f59030b;
        if (cJRTransaction == null) {
            kotlin.g.b.k.a("transaction");
        }
        String walletOrderId = cJRTransaction.getWalletOrderId();
        net.one97.paytm.passbook.transactionDetail.d.a aVar = this.f59034f;
        if (aVar == null) {
            kotlin.g.b.k.a("tagsViewModel");
        }
        kotlin.g.b.k.a((Object) walletOrderId, "txnId");
        kotlin.g.b.k.c(walletOrderId, "txnId");
        x.e eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = new y();
        kotlin.o oVar = new kotlin.o((y) eVar.element, (y) eVar2.element);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("txnId", walletOrderId);
        if (str2 != null) {
            jSONObject2.put("tag", str2);
        }
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2P_TRANSFER");
        jSONObject.put("channel", "");
        jSONObject.put("version", "");
        jSONObject.put("request", jSONObject2);
        kotlin.g.b.k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        String s = com.paytm.utility.b.s(aVar.getApplication(), net.one97.paytm.passbook.mapping.e.z());
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(aVar.getApplication());
        kotlin.g.b.k.a((Object) a2, "CJRServerUtility.getSSOToken(getApplication())");
        hashMap.put("ssotoken", a2);
        hashMap.put("Content-Type", "application/json");
        aVar.a((net.one97.paytm.passbook.mapping.a.e) new net.one97.paytm.passbook.mapping.a.b(s, new a.c(aVar, eVar), new a.d(aVar, eVar2), new UpdateTagsResponse((String) null, (String) null, (String) null, (String) null, (String) null, (Response) null, 63, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, net.one97.paytm.passbook.transactionDetail.d.a.class.getSimpleName()));
        androidx.lifecycle.q qVar = this;
        ((y) oVar.getFirst()).observe(qVar, new p(this, str2));
        ((y) oVar.getSecond()).observe(qVar, new q(this));
    }

    public static void a(View view) {
        kotlin.g.b.k.c(view, "view");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final LottieAnimationView a() {
        View view = this.f59032d;
        if (view == null) {
            kotlin.g.b.k.a("contentView");
        }
        FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.tagsFlowLayout);
        kotlin.g.b.k.a((Object) flowLayout, "contentView.tagsFlowLayout");
        if (flowLayout.getChildCount() != 0) {
            View view2 = this.f59032d;
            if (view2 == null) {
                kotlin.g.b.k.a("contentView");
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.dialogLoader);
            kotlin.g.b.k.a((Object) lottieAnimationView, "contentView.dialogLoader");
            return lottieAnimationView;
        }
        View view3 = this.f59032d;
        if (view3 == null) {
            kotlin.g.b.k.a("contentView");
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view3.findViewById(R.id.tags_loader);
        kotlin.g.b.k.a((Object) lottieAnimationView2, "contentView.tags_loader");
        return lottieAnimationView2;
    }

    public final void a(b bVar) {
        kotlin.g.b.k.c(bVar, "addEditTagUpdateListener");
        this.f59029a = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void e(net.one97.paytm.passbook.transactionDetail.b.a r4) {
        /*
            android.view.View r0 = r4.f59032d
            java.lang.String r1 = "contentView"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            int r2 = net.one97.paytm.passbook.R.id.enterTagEdt
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x0052
            android.view.View r0 = r4.f59032d
            if (r0 != 0) goto L_0x001e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001e:
            int r2 = net.one97.paytm.passbook.R.id.enterTagEdt
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            java.lang.String r2 = "contentView.enterTagEdt"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.text.Editable r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0052
            android.view.View r0 = r4.f59032d
            if (r0 != 0) goto L_0x003e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x003e:
            int r1 = net.one97.paytm.passbook.R.id.enterTagEdt
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0094
        L_0x0052:
            android.view.View r0 = r4.f59032d
            if (r0 != 0) goto L_0x0059
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0059:
            int r2 = net.one97.paytm.passbook.R.id.tagsFlowLayout
            android.view.View r0 = r0.findViewById(r2)
            net.one97.paytm.passbook.subWallet.widget.FlowLayout r0 = (net.one97.paytm.passbook.subWallet.widget.FlowLayout) r0
            java.lang.String r2 = "contentView.tagsFlowLayout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r0 = r0.getSelectedViewIndex()
            r3 = -1
            if (r0 == r3) goto L_0x0093
            java.util.ArrayList<java.lang.String> r0 = r4.f59031c
            if (r0 != 0) goto L_0x0076
            java.lang.String r3 = "mToggleBtnTxt"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0076:
            android.view.View r3 = r4.f59032d
            if (r3 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007d:
            int r1 = net.one97.paytm.passbook.R.id.tagsFlowLayout
            android.view.View r1 = r3.findViewById(r1)
            net.one97.paytm.passbook.subWallet.widget.FlowLayout r1 = (net.one97.paytm.passbook.subWallet.widget.FlowLayout) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r1 = r1.getSelectedViewIndex()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00f3
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r4.f59030b
            java.lang.String r1 = "transaction"
            if (r0 != 0) goto L_0x00a7
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00a7:
            net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r0 = r0.getTagInfo()
            if (r0 == 0) goto L_0x00de
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r4.f59030b
            if (r0 != 0) goto L_0x00b4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b4:
            net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r0 = r0.getTagInfo()
            java.lang.String r0 = r0.tag
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00c3
            goto L_0x00de
        L_0x00c3:
            android.content.Context r0 = r4.getContext()
            int r1 = net.one97.paytm.passbook.R.string.remove_tag
            java.lang.String r1 = r4.getString(r1)
            int r2 = net.one97.paytm.passbook.R.string.confirm_deletion_of_tag
            java.lang.String r2 = r4.getString(r2)
            net.one97.paytm.passbook.transactionDetail.b.a$o r3 = new net.one97.paytm.passbook.transactionDetail.b.a$o
            r3.<init>(r4)
            com.paytm.utility.g$b r3 = (com.paytm.utility.g.b) r3
            com.paytm.utility.g.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (com.paytm.utility.g.b) r3)
            return
        L_0x00de:
            android.content.Context r0 = r4.getContext()
            int r1 = net.one97.paytm.passbook.R.string.please_enter_or_select_tag_first
            java.lang.String r4 = r4.getString(r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r0, r4, r1)
            r4.show()
            return
        L_0x00f3:
            r4.a((java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.b.a.e(net.one97.paytm.passbook.transactionDetail.b.a):void");
    }

    public static final /* synthetic */ void a(a aVar, ArrayList arrayList) {
        aVar.f59031c = arrayList;
        aVar.f59033e = new ArrayList<>();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            ArrayList<View> arrayList2 = aVar.f59033e;
            if (arrayList2 == null) {
                kotlin.g.b.k.a("toggleBtns");
            }
            arrayList2.add(new ToggleStatusButton(aVar.getContext(), str));
        }
        View view = aVar.f59032d;
        if (view == null) {
            kotlin.g.b.k.a("contentView");
        }
        FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.tagsFlowLayout);
        ArrayList<View> arrayList3 = aVar.f59033e;
        if (arrayList3 == null) {
            kotlin.g.b.k.a("toggleBtns");
        }
        flowLayout.a((List<View>) arrayList3);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59037i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
