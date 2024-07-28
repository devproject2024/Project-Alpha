package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class EditVpaActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f68680a = {y.a((v) new w(y.b(EditVpaActivity.class), "lottieDialog", "getLottieDialog()Lnet/one97/paytm/upi/util/CustomWalletLoaderDialog;"))};

    /* renamed from: b  reason: collision with root package name */
    public static final a f68681b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private Group f68682c;

    /* renamed from: d  reason: collision with root package name */
    private Group f68683d;

    /* renamed from: e  reason: collision with root package name */
    private Group f68684e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68685f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f68686g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f68687h;

    /* renamed from: i  reason: collision with root package name */
    private Toolbar f68688i;
    private TextView j;
    private net.one97.paytm.upi.registration.c.a k;
    private EditText l;
    /* access modifiers changed from: private */
    public z m;
    private ImageView n;
    private Button o;
    private FrameLayout p;
    private LottieAnimationView q;
    private final kotlin.g r = kotlin.h.a(new b(this));
    private String s;
    private final int t = 17;

    static final class s implements CustomDialog.OnDialogDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public static final s f68704a = new s();

        s() {
        }

        public final void onDialogDismissed() {
        }
    }

    private final CustomWalletLoaderDialog a() {
        return (CustomWalletLoaderDialog) this.r.getValue();
    }

    static final class g extends kotlin.g.b.l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ EditVpaActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(EditVpaActivity editVpaActivity) {
            super(1);
            this.this$0 = editVpaActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            kotlin.g.b.k.c(str, "selectedVpa");
            this.this$0.a(str);
        }
    }

    static final class i<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68694a;

        i(EditVpaActivity editVpaActivity) {
            this.f68694a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            EditVpaActivity editVpaActivity = this.f68694a;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            EditVpaActivity.a(editVpaActivity, bool.booleanValue());
        }
    }

    static final class j<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68695a;

        j(EditVpaActivity editVpaActivity) {
            this.f68695a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            EditVpaActivity.d(this.f68695a).setVisibility(0);
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                EditVpaActivity.e(this.f68695a).setVisibility(0);
                EditVpaActivity.f(this.f68695a).setVisibility(8);
                EditVpaActivity.g(this.f68695a).setVisibility(8);
                EditVpaActivity.h(this.f68695a).setVisibility(0);
                EditVpaActivity.i(this.f68695a);
                return;
            }
            EditVpaActivity.e(this.f68695a).setVisibility(8);
            EditVpaActivity.f(this.f68695a).setVisibility(0);
            EditVpaActivity.g(this.f68695a).setVisibility(0);
            EditVpaActivity.h(this.f68695a).setVisibility(8);
        }
    }

    static final class k<T> implements z<List<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68696a;

        k(EditVpaActivity editVpaActivity) {
            this.f68696a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            EditVpaActivity editVpaActivity = this.f68696a;
            if (list == null) {
                kotlin.g.b.k.a();
            }
            EditVpaActivity.a(editVpaActivity, kotlin.a.k.c(list));
        }
    }

    static final class l<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68697a;

        l(EditVpaActivity editVpaActivity) {
            this.f68697a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            EditText a2 = EditVpaActivity.a(this.f68697a);
            EditVpaActivity editVpaActivity = this.f68697a;
            if (num == null) {
                kotlin.g.b.k.a();
            }
            a2.setError(editVpaActivity.getString(num.intValue()));
            a2.requestFocus();
        }
    }

    static final class m<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68698a;

        m(EditVpaActivity editVpaActivity) {
            this.f68698a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                this.f68698a.setResult(-1);
                this.f68698a.finish();
            }
        }
    }

    static final class n<T> implements z<kotlin.o<? extends String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68699a;

        n(EditVpaActivity editVpaActivity) {
            this.f68699a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            kotlin.o oVar = (kotlin.o) obj;
            EditVpaActivity editVpaActivity = this.f68699a;
            if (oVar == null) {
                kotlin.g.b.k.a();
            }
            CustomDialog.showAlert(editVpaActivity, (String) oVar.getFirst(), (String) oVar.getSecond(), true, editVpaActivity.getString(R.string.ok), new r(editVpaActivity));
        }
    }

    static final class o<T> implements z<kotlin.o<? extends String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68700a;

        o(EditVpaActivity editVpaActivity) {
            this.f68700a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            kotlin.o oVar = (kotlin.o) obj;
            EditVpaActivity editVpaActivity = this.f68700a;
            if (oVar == null) {
                kotlin.g.b.k.a();
            }
            CustomDialog.showAlert(editVpaActivity, (String) oVar.getFirst(), (String) oVar.getSecond(), true, editVpaActivity.getString(R.string.ok), s.f68704a);
        }
    }

    static final class p<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68701a;

        p(EditVpaActivity editVpaActivity) {
            this.f68701a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            EditVpaActivity editVpaActivity = this.f68701a;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            EditVpaActivity.b(editVpaActivity, bool.booleanValue());
        }
    }

    static final class q<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68702a;

        q(EditVpaActivity editVpaActivity) {
            this.f68702a = editVpaActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                EditVpaActivity.j(this.f68702a);
            }
        }
    }

    public static final /* synthetic */ EditText a(EditVpaActivity editVpaActivity) {
        EditText editText = editVpaActivity.l;
        if (editText == null) {
            kotlin.g.b.k.a("vpaEditText");
        }
        return editText;
    }

    public static final /* synthetic */ z b(EditVpaActivity editVpaActivity) {
        z zVar = editVpaActivity.m;
        if (zVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        return zVar;
    }

    public static final /* synthetic */ Button d(EditVpaActivity editVpaActivity) {
        Button button = editVpaActivity.o;
        if (button == null) {
            kotlin.g.b.k.a("saveVpaButton");
        }
        return button;
    }

    public static final /* synthetic */ Group e(EditVpaActivity editVpaActivity) {
        Group group = editVpaActivity.f68682c;
        if (group == null) {
            kotlin.g.b.k.a("enterVpaGroup");
        }
        return group;
    }

    public static final /* synthetic */ Group f(EditVpaActivity editVpaActivity) {
        Group group = editVpaActivity.f68683d;
        if (group == null) {
            kotlin.g.b.k.a("selectVpaGroup");
        }
        return group;
    }

    public static final /* synthetic */ Group g(EditVpaActivity editVpaActivity) {
        Group group = editVpaActivity.f68684e;
        if (group == null) {
            kotlin.g.b.k.a("snackbarGroup");
        }
        return group;
    }

    public static final /* synthetic */ Toolbar h(EditVpaActivity editVpaActivity) {
        Toolbar toolbar = editVpaActivity.f68688i;
        if (toolbar == null) {
            kotlin.g.b.k.a("toolbar");
        }
        return toolbar;
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<CustomWalletLoaderDialog> {
        final /* synthetic */ EditVpaActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(EditVpaActivity editVpaActivity) {
            super(0);
            this.this$0 = editVpaActivity;
        }

        public final CustomWalletLoaderDialog invoke() {
            return new CustomWalletLoaderDialog(this.this$0);
        }
    }

    public final void attachBaseContext(Context context) {
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c() == null) {
            super.attachBaseContext(context);
            return;
        }
        net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        ContextWrapper d2 = a3.c().d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_vpa);
        View findViewById = findViewById(R.id.grpEnterVpa);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.grpEnterVpa)");
        this.f68682c = (Group) findViewById;
        View findViewById2 = findViewById(R.id.grpSelectVpa);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.grpSelectVpa)");
        this.f68683d = (Group) findViewById2;
        View findViewById3 = findViewById(R.id.grpSnackbar);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.grpSnackbar)");
        this.f68684e = (Group) findViewById3;
        View findViewById4 = findViewById(R.id.btnSnackBarOkay);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.btnSnackBarOkay)");
        this.f68685f = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.suggestionsRecyclerView);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById(R.id.suggestionsRecyclerView)");
        this.f68686g = (RecyclerView) findViewById5;
        View findViewById6 = findViewById(R.id.ivBackArrow);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById(R.id.ivBackArrow)");
        this.f68687h = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.toolbar);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById(R.id.toolbar)");
        this.f68688i = (Toolbar) findViewById7;
        View findViewById8 = findViewById(R.id.txtChooseFromSuggestion);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById(R.id.txtChooseFromSuggestion)");
        this.j = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.etVpaInput);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById(R.id.etVpaInput)");
        this.l = (EditText) findViewById9;
        View findViewById10 = findViewById(R.id.ivClearVpa);
        kotlin.g.b.k.a((Object) findViewById10, "findViewById(R.id.ivClearVpa)");
        this.n = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.btnSaveVpa);
        kotlin.g.b.k.a((Object) findViewById11, "findViewById(R.id.btnSaveVpa)");
        this.o = (Button) findViewById11;
        View findViewById12 = findViewById(R.id.saveVpaLoaderContainer);
        kotlin.g.b.k.a((Object) findViewById12, "findViewById(R.id.saveVpaLoaderContainer)");
        this.p = (FrameLayout) findViewById12;
        View findViewById13 = findViewById(R.id.saveVpaLoader);
        kotlin.g.b.k.a((Object) findViewById13, "findViewById(R.id.saveVpaLoader)");
        this.q = (LottieAnimationView) findViewById13;
        String stringExtra = getIntent().getStringExtra("current vpa");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.s = stringExtra;
        TextView textView = this.f68685f;
        if (textView == null) {
            kotlin.g.b.k.a("snackBarOkayButton");
        }
        textView.setOnClickListener(new c(this));
        ImageView imageView = this.n;
        if (imageView == null) {
            kotlin.g.b.k.a("clearVpaButton");
        }
        imageView.setOnClickListener(new d(this));
        Button button = this.o;
        if (button == null) {
            kotlin.g.b.k.a("saveVpaButton");
        }
        button.setOnClickListener(new e(this));
        ImageView imageView2 = this.f68687h;
        if (imageView2 == null) {
            kotlin.g.b.k.a("backButton");
        }
        imageView2.setOnClickListener(new f(this));
        String str = this.s;
        if (str == null) {
            kotlin.g.b.k.a("originalVpa");
        }
        net.one97.paytm.upi.profile.b.b a2 = net.one97.paytm.upi.g.a();
        kotlin.g.b.k.a((Object) a2, "Injection.provideUpiProfileRepository(this)");
        ai a3 = am.a((FragmentActivity) this, (al.b) new net.one97.paytm.upi.registration.c.a.a(a2)).a(net.one97.paytm.upi.registration.c.a.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(\n …VpaViewModel::class.java]");
        this.k = (net.one97.paytm.upi.registration.c.a) a3;
        net.one97.paytm.upi.registration.c.a aVar = this.k;
        if (aVar == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar.a(str);
        net.one97.paytm.upi.registration.c.a aVar2 = this.k;
        if (aVar2 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        androidx.lifecycle.q qVar = this;
        aVar2.f68519b.observe(qVar, new i(this));
        net.one97.paytm.upi.registration.c.a aVar3 = this.k;
        if (aVar3 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar3.f68520c.observe(qVar, new j(this));
        net.one97.paytm.upi.registration.c.a aVar4 = this.k;
        if (aVar4 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar4.f68518a.observe(qVar, new k(this));
        net.one97.paytm.upi.registration.c.a aVar5 = this.k;
        if (aVar5 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar5.f68521d.observe(qVar, new l(this));
        net.one97.paytm.upi.registration.c.a aVar6 = this.k;
        if (aVar6 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar6.f68522e.observe(qVar, new m(this));
        net.one97.paytm.upi.registration.c.a aVar7 = this.k;
        if (aVar7 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar7.f68523f.observe(qVar, new n(this));
        net.one97.paytm.upi.registration.c.a aVar8 = this.k;
        if (aVar8 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar8.f68524g.observe(qVar, new o(this));
        net.one97.paytm.upi.registration.c.a aVar9 = this.k;
        if (aVar9 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar9.f68526i.observe(qVar, new p(this));
        net.one97.paytm.upi.registration.c.a aVar10 = this.k;
        if (aVar10 == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        aVar10.j.observe(qVar, new q(this));
        EditText editText = this.l;
        if (editText == null) {
            kotlin.g.b.k.a("vpaEditText");
        }
        editText.addTextChangedListener(new h(this));
        CJRSendGTMTag.sendOpenScreenWithDeviceInfo(CJRGTMConstants.MT_V4_EDIT_VPA_SCREEN_NAME, "wallet", this);
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68693a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(EditVpaActivity editVpaActivity) {
            this.f68693a = editVpaActivity;
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
            if (EditVpaActivity.a(this.f68693a).getSelectionEnd() != EditVpaActivity.a(this.f68693a).length()) {
                EditVpaActivity.a(this.f68693a).setSelection(EditVpaActivity.a(this.f68693a).length());
            }
            if (this.f68693a.m != null) {
                z b2 = EditVpaActivity.b(this.f68693a);
                String obj = editable.toString();
                if (obj != null) {
                    String obj2 = kotlin.m.p.b(obj).toString();
                    kotlin.g.b.k.c(obj2, "currentSelectedVpa");
                    int indexOf = b2.f69098b.indexOf(UpiUtils.buildVpa(obj2));
                    int i2 = b2.f69097a;
                    b2.f69097a = indexOf;
                    b2.notifyItemChanged(i2, new Object());
                    b2.notifyItemChanged(b2.f69097a, new Object());
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (this.k == null) {
            kotlin.g.b.k.a("editVpaViewModel");
        }
        String c2 = net.one97.paytm.upi.registration.c.a.c(str);
        EditText editText = this.l;
        if (editText == null) {
            kotlin.g.b.k.a("vpaEditText");
        }
        editText.setText(c2);
    }

    static final class r implements CustomDialog.OnDialogDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68703a;

        r(EditVpaActivity editVpaActivity) {
            this.f68703a = editVpaActivity;
        }

        public final void onDialogDismissed() {
            this.f68703a.finish();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68689a;

        c(EditVpaActivity editVpaActivity) {
            this.f68689a = editVpaActivity;
        }

        public final void onClick(View view) {
            EditVpaActivity.g(this.f68689a).setVisibility(8);
            EditVpaActivity.h(this.f68689a).setVisibility(0);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68690a;

        d(EditVpaActivity editVpaActivity) {
            this.f68690a = editVpaActivity;
        }

        public final void onClick(View view) {
            EditVpaActivity.a(this.f68690a).getText().clear();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68691a;

        e(EditVpaActivity editVpaActivity) {
            this.f68691a = editVpaActivity;
        }

        public final void onClick(View view) {
            EditVpaActivity.k(this.f68691a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditVpaActivity f68692a;

        f(EditVpaActivity editVpaActivity) {
            this.f68692a = editVpaActivity;
        }

        public final void onClick(View view) {
            this.f68692a.finish();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.t && i3 == -1) {
            net.one97.paytm.upi.registration.c.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("editVpaViewModel");
            }
            String str = this.s;
            if (str == null) {
                kotlin.g.b.k.a("originalVpa");
            }
            aVar.a(str);
            return;
        }
        finish();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(EditVpaActivity editVpaActivity, boolean z) {
        if (z) {
            editVpaActivity.a().showLoader();
        } else {
            editVpaActivity.a().dismissLoader();
        }
    }

    public static final /* synthetic */ void i(EditVpaActivity editVpaActivity) {
        RecyclerView recyclerView = editVpaActivity.f68686g;
        if (recyclerView == null) {
            kotlin.g.b.k.a("vpaSuggestionRecylerView");
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.f2491i = R.id.txtChooseFromSuggestion;
            layoutParams2.topMargin = com.paytm.utility.a.a(8);
            RecyclerView recyclerView2 = editVpaActivity.f68686g;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a("vpaSuggestionRecylerView");
            }
            recyclerView2.requestLayout();
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public static final /* synthetic */ void a(EditVpaActivity editVpaActivity, List list) {
        editVpaActivity.m = new z(list, new g(editVpaActivity));
        RecyclerView recyclerView = editVpaActivity.f68686g;
        if (recyclerView == null) {
            kotlin.g.b.k.a("vpaSuggestionRecylerView");
        }
        z zVar = editVpaActivity.m;
        if (zVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        recyclerView.setAdapter(zVar);
        editVpaActivity.a((String) list.get(0));
    }

    public static final /* synthetic */ void b(EditVpaActivity editVpaActivity, boolean z) {
        if (z) {
            FrameLayout frameLayout = editVpaActivity.p;
            if (frameLayout == null) {
                kotlin.g.b.k.a("saveVpaLoaderContainer");
            }
            frameLayout.setVisibility(0);
            LottieAnimationView lottieAnimationView = editVpaActivity.q;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("saveVpaAnimation");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
            Button button = editVpaActivity.o;
            if (button == null) {
                kotlin.g.b.k.a("saveVpaButton");
            }
            button.setVisibility(8);
            return;
        }
        FrameLayout frameLayout2 = editVpaActivity.p;
        if (frameLayout2 == null) {
            kotlin.g.b.k.a("saveVpaLoaderContainer");
        }
        frameLayout2.setVisibility(8);
        LottieAnimationView lottieAnimationView2 = editVpaActivity.q;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("saveVpaAnimation");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView2);
        Button button2 = editVpaActivity.o;
        if (button2 == null) {
            kotlin.g.b.k.a("saveVpaButton");
        }
        button2.setVisibility(0);
    }

    public static final /* synthetic */ void j(EditVpaActivity editVpaActivity) {
        Intent intent = new Intent(editVpaActivity, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        editVpaActivity.startActivityForResult(intent, editVpaActivity.t);
    }

    public static final /* synthetic */ void k(EditVpaActivity editVpaActivity) {
        EditVpaActivity editVpaActivity2 = editVpaActivity;
        EditText editText = editVpaActivity2.l;
        if (editText == null) {
            kotlin.g.b.k.a("vpaEditText");
        }
        String obj = editText.getText().toString();
        if (obj != null) {
            String obj2 = kotlin.m.p.b(obj).toString();
            if (editVpaActivity2.k == null) {
                kotlin.g.b.k.a("editVpaViewModel");
            }
            String str = editVpaActivity2.s;
            if (str == null) {
                kotlin.g.b.k.a("originalVpa");
            }
            String c2 = net.one97.paytm.upi.registration.c.a.c(str);
            if (editVpaActivity2.k == null) {
                kotlin.g.b.k.a("editVpaViewModel");
            }
            if (kotlin.m.p.a(c2, net.one97.paytm.upi.registration.c.a.c(obj2), true)) {
                editVpaActivity.finish();
            } else {
                net.one97.paytm.upi.registration.c.a aVar = editVpaActivity2.k;
                if (aVar == null) {
                    kotlin.g.b.k.a("editVpaViewModel");
                }
                kotlin.g.b.k.c(obj2, "currentSelectedVpa");
                UpiConstants.UpiVpaValidationError isValidVpa = UpiUtils.isValidVpa(obj2);
                if (isValidVpa == null) {
                    String buildVpa = UpiUtils.buildVpa(obj2);
                    kotlin.g.b.k.a((Object) buildVpa, "UpiUtils.buildVpa(currentSelectedVpa)");
                    aVar.b(buildVpa);
                } else if (isValidVpa != UpiConstants.UpiVpaValidationError.ALPHANUMERIC_ERROR) {
                    aVar.a(isValidVpa);
                } else if (aVar.f68525h.containsKey(UpiUtils.buildVpa(obj2))) {
                    String buildVpa2 = UpiUtils.buildVpa(obj2);
                    kotlin.g.b.k.a((Object) buildVpa2, "UpiUtils.buildVpa(currentSelectedVpa)");
                    aVar.b(buildVpa2);
                } else {
                    aVar.a(isValidVpa);
                }
            }
            z zVar = editVpaActivity2.m;
            if (zVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            if (zVar.f69097a != -1) {
                CJRSendGTMTag.sendNewCustomGTMEvents(editVpaActivity2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SAVE_UPI_ID, "suggested", "", "", CJRGTMConstants.MT_V4_EDIT_VPA_SCREEN_NAME, "upi");
            } else {
                CJRSendGTMTag.sendNewCustomGTMEvents(editVpaActivity2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SAVE_UPI_ID, "user_typed", "", "", CJRGTMConstants.MT_V4_EDIT_VPA_SCREEN_NAME, "upi");
            }
        } else {
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }
}
