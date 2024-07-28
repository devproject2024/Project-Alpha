package net.one97.paytm.recharge.presentation.b;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.domain.entities.SectionWrapper;
import net.one97.paytm.recharge.presentation.a.j;

public final class i extends f implements TextWatcher, j.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64781a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static net.one97.paytm.recharge.presentation.d.c f64782f;

    /* renamed from: b  reason: collision with root package name */
    private CJRPaymentModes f64783b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRPayChannelOptions> f64784c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<SectionWrapper> f64785d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private j f64786e;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64787g;

    public final View a(int i2) {
        if (this.f64787g == null) {
            this.f64787g = new HashMap();
        }
        View view = (View) this.f64787g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64787g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CurvedCornerWithKeyboardBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("pay_channel") : null;
        if (!(serializable instanceof CJRPaymentModes)) {
            serializable = null;
        }
        this.f64783b = (CJRPaymentModes) serializable;
        CJRPaymentModes cJRPaymentModes = this.f64783b;
        if (cJRPaymentModes != null) {
            if (cJRPaymentModes == null) {
                k.a();
            }
            this.f64784c = cJRPaymentModes.getPayChannelOptions();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(3);
        }
        return onCreateDialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_choose_bank, (ViewGroup) null, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r8, r0)
            super.onViewCreated(r8, r9)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            r9 = 1
            r0 = 0
            if (r8 == 0) goto L_0x0180
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions> r8 = r7.f64784c
            java.util.Collection r8 = (java.util.Collection) r8
            if (r8 == 0) goto L_0x001f
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r8 = 0
            goto L_0x0020
        L_0x001f:
            r8 = 1
        L_0x0020:
            if (r8 != 0) goto L_0x0180
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions> r8 = r7.f64784c
            java.util.List r8 = (java.util.List) r8
            net.one97.paytm.recharge.automatic.b.a.i r1 = new net.one97.paytm.recharge.automatic.b.a.i
            r1.<init>()
            java.util.Comparator r1 = (java.util.Comparator) r1
            java.util.Collections.sort(r8, r1)
            java.util.TreeMap r8 = new java.util.TreeMap
            r8.<init>()
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions> r1 = r7.f64784c
            if (r1 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            java.util.Iterator r1 = r1.iterator()
        L_0x0040:
            boolean r2 = r1.hasNext()
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x00eb
            java.lang.Object r2 = r1.next()
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r2 = (net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions) r2
            java.lang.String r4 = r2.getChannelName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0040
            java.lang.String r4 = r2.getChannelName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00bb
            java.lang.String r4 = r2.getChannelName()
            if (r4 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            char r4 = r4.charAt(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
            boolean r4 = r8.containsKey(r4)
            if (r4 == 0) goto L_0x00bb
            java.lang.String r4 = r2.getChannelName()
            if (r4 != 0) goto L_0x0095
            kotlin.g.b.k.a()
        L_0x0095:
            char r4 = r4.charAt(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Object r3 = r8.get(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            if (r3 != 0) goto L_0x00b7
            kotlin.g.b.k.a()
        L_0x00b7:
            r3.add(r2)
            goto L_0x0040
        L_0x00bb:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r2)
            r5 = r8
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r2 = r2.getChannelName()
            if (r2 != 0) goto L_0x00cf
            kotlin.g.b.k.a()
        L_0x00cf:
            char r2 = r2.charAt(r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.append(r2)
            r6.append(r3)
            java.lang.String r2 = r6.toString()
            r5.put(r2, r4)
            goto L_0x0040
        L_0x00eb:
            java.util.Map r8 = (java.util.Map) r8
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00f5:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0125
            java.lang.Object r1 = r8.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x010e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00f5
            java.lang.Object r2 = r1.next()
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r2 = (net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions) r2
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.SectionWrapper> r4 = r7.f64785d
            net.one97.paytm.recharge.domain.entities.SectionWrapper r5 = new net.one97.paytm.recharge.domain.entities.SectionWrapper
            r5.<init>(r0, r2, r3)
            r4.add(r5)
            goto L_0x010e
        L_0x0125:
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            if (r8 == 0) goto L_0x0132
            r8.setHasFixedSize(r9)
        L_0x0132:
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            if (r8 == 0) goto L_0x014c
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            r1.<init>(r2, r9, r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r8.setLayoutManager(r1)
        L_0x014c:
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            if (r8 == 0) goto L_0x0160
            androidx.recyclerview.widget.g r1 = new androidx.recyclerview.widget.g
            r1.<init>()
            androidx.recyclerview.widget.RecyclerView$f r1 = (androidx.recyclerview.widget.RecyclerView.f) r1
            r8.setItemAnimator(r1)
        L_0x0160:
            net.one97.paytm.recharge.presentation.a.j r8 = new net.one97.paytm.recharge.presentation.a.j
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.SectionWrapper> r1 = r7.f64785d
            r2 = r7
            net.one97.paytm.recharge.presentation.a.j$a r2 = (net.one97.paytm.recharge.presentation.a.j.a) r2
            net.one97.paytm.recharge.presentation.d.c r3 = f64782f
            r8.<init>(r1, r2, r3)
            r7.f64786e = r8
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            if (r8 == 0) goto L_0x0195
            net.one97.paytm.recharge.presentation.a.j r1 = r7.f64786e
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r8.setAdapter(r1)
            goto L_0x0195
        L_0x0180:
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions> r8 = r7.f64784c
            java.util.Collection r8 = (java.util.Collection) r8
            if (r8 == 0) goto L_0x018f
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x018d
            goto L_0x018f
        L_0x018d:
            r8 = 0
            goto L_0x0190
        L_0x018f:
            r8 = 1
        L_0x0190:
            if (r8 == 0) goto L_0x0195
            r7.a()
        L_0x0195:
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r1 = 10
            r8.setIndexTextSize(r1)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            java.lang.String r1 = "#FFFFFF"
            r8.setIndexBarColor(r1)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r8.setIndexBarCornerRadius(r0)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            android.graphics.Typeface r1 = android.graphics.Typeface.SANS_SERIF
            r8.setTypeface(r1)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r1 = 0
            r8.setIndexbarMargin(r1)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r1 = 1109393408(0x42200000, float:40.0)
            r8.setIndexbarWidth(r1)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r8.setPreviewPadding(r0)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            java.lang.String r0 = "#999999"
            r8.setIndexBarTextColor(r0)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r8.setIndexBarVisibility(r9)
            int r8 = net.one97.paytm.recharge.automatic.R.id.rv_bank_list
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r8 = (net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView) r8
            r8.setIndexBarHighLateTextVisibility(r9)
            int r8 = net.one97.paytm.recharge.automatic.R.id.searchView
            android.view.View r8 = r7.a((int) r8)
            android.widget.EditText r8 = (android.widget.EditText) r8
            if (r8 == 0) goto L_0x021e
            r9 = r7
            android.text.TextWatcher r9 = (android.text.TextWatcher) r9
            r8.addTextChangedListener(r9)
        L_0x021e:
            int r8 = net.one97.paytm.recharge.automatic.R.id.searchView
            android.view.View r8 = r7.a((int) r8)
            android.widget.EditText r8 = (android.widget.EditText) r8
            if (r8 == 0) goto L_0x0232
            net.one97.paytm.recharge.presentation.b.i$b r9 = new net.one97.paytm.recharge.presentation.b.i$b
            r9.<init>(r7)
            android.view.View$OnFocusChangeListener r9 = (android.view.View.OnFocusChangeListener) r9
            r8.setOnFocusChangeListener(r9)
        L_0x0232:
            int r8 = net.one97.paytm.recharge.automatic.R.id.iv_back_arrow
            android.view.View r8 = r7.a((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0246
            net.one97.paytm.recharge.presentation.b.i$c r9 = new net.one97.paytm.recharge.presentation.b.i$c
            r9.<init>(r7)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x0246:
            int r8 = net.one97.paytm.recharge.automatic.R.id.img_edt_cross
            android.view.View r8 = r7.a((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x025a
            net.one97.paytm.recharge.presentation.b.i$d r9 = new net.one97.paytm.recharge.presentation.b.i$d
            r9.<init>(r7)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x025a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.i.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f64788a;

        b(i iVar) {
            this.f64788a = iVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                IndexFastScrollRecyclerView indexFastScrollRecyclerView = (IndexFastScrollRecyclerView) this.f64788a.a(R.id.rv_bank_list);
                if (indexFastScrollRecyclerView != null) {
                    indexFastScrollRecyclerView.setIndexBarVisibility(false);
                    return;
                }
                return;
            }
            IndexFastScrollRecyclerView indexFastScrollRecyclerView2 = (IndexFastScrollRecyclerView) this.f64788a.a(R.id.rv_bank_list);
            if (indexFastScrollRecyclerView2 != null) {
                indexFastScrollRecyclerView2.setIndexBarVisibility(true);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f64789a;

        c(i iVar) {
            this.f64789a = iVar;
        }

        public final void onClick(View view) {
            this.f64789a.dismissAllowingStateLoss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f64790a;

        d(i iVar) {
            this.f64790a = iVar;
        }

        public final void onClick(View view) {
            EditText editText = (EditText) this.f64790a.a(R.id.searchView);
            if (editText != null) {
                editText.setText("");
            }
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Filter filter;
        if (TextUtils.isEmpty(charSequence)) {
            ImageView imageView = (ImageView) a(R.id.img_edt_cross);
            if (imageView != null) {
                ExtensionsKt.gone(imageView);
            }
        } else {
            ImageView imageView2 = (ImageView) a(R.id.img_edt_cross);
            if (imageView2 != null) {
                ExtensionsKt.visible(imageView2);
            }
        }
        j jVar = this.f64786e;
        if (jVar != null && (filter = jVar.getFilter()) != null) {
            filter.filter(charSequence);
        }
    }

    public final void a() {
        View a2 = a(R.id.list_empty_layout_container);
        if (a2 != null) {
            ExtensionsKt.visible(a2);
        }
    }

    public final void b() {
        View a2 = a(R.id.list_empty_layout_container);
        if (a2 != null) {
            ExtensionsKt.gone(a2);
        }
    }

    public final void a(CJRPayChannelOptions cJRPayChannelOptions) {
        net.one97.paytm.recharge.presentation.d.c cVar;
        String str;
        k.c(cJRPayChannelOptions, "payChannelOption");
        CJRPaymentModes cJRPaymentModes = this.f64783b;
        if (!(cJRPaymentModes == null || (cVar = f64782f) == null)) {
            if (cJRPaymentModes == null || (str = cJRPaymentModes.getPaymentMode()) == null) {
                str = "";
            }
            cVar.a(str, cJRPayChannelOptions, false);
        }
        dismissAllowingStateLoss();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64787g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
