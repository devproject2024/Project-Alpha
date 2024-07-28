package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.m;
import net.one97.paytm.recharge.common.e.j;
import net.one97.paytm.recharge.common.e.o;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class CJRSelectOperatorViewV8 extends LinearLayout implements TextWatcher, View.OnClickListener, j {

    /* renamed from: f  reason: collision with root package name */
    public static final a f61954f = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final int j = 1;
    /* access modifiers changed from: private */
    public static final int k = 2;
    /* access modifiers changed from: private */
    public static final int l = 3;
    /* access modifiers changed from: private */
    public static final int m = 4;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f61955a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f61956b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61957c;

    /* renamed from: d  reason: collision with root package name */
    public m f61958d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61959e;

    /* renamed from: g  reason: collision with root package name */
    private AutoCompleteTextView f61960g;

    /* renamed from: h  reason: collision with root package name */
    private final int f61961h = 3;

    /* renamed from: i  reason: collision with root package name */
    private final b f61962i;
    private HashMap n;

    private View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.c(charSequence, "s");
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.c(charSequence, "s");
    }

    public final b getOptions() {
        return this.f61962i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRSelectOperatorViewV8(Context context, b bVar) {
        super(context);
        List<CJRAggsItem> list;
        List<CJRAggsItem> list2;
        o oVar;
        Integer num;
        RecyclerView.h hVar;
        this.f61962i = bVar;
        b bVar2 = this.f61962i;
        Integer num2 = null;
        if (bVar2 != null) {
            list = bVar2.f61967e;
        } else {
            list = null;
        }
        if (list == null) {
            setVisibility(8);
            return;
        }
        setOrientation(1);
        setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = com.paytm.utility.b.c(5);
        setLayoutParams(layoutParams);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.select_operator_layout, this, true);
        b bVar3 = this.f61962i;
        if (bVar3 != null && bVar3.k) {
            try {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_layout_operator);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.a();
                }
            } catch (Exception unused) {
            }
        }
        View findViewById = inflate.findViewById(R.id.title);
        if (findViewById != null) {
            this.f61959e = (TextView) findViewById;
            b bVar4 = this.f61962i;
            if (bVar4 == null || !bVar4.f61969g) {
                View a2 = a(R.id.search_layout);
                k.a((Object) a2, "search_layout");
                a2.setVisibility(8);
            } else {
                View a3 = a(R.id.search_layout);
                k.a((Object) a3, "search_layout");
                a3.setVisibility(0);
            }
            b bVar5 = this.f61962i;
            if (bVar5 != null && bVar5.f61971i) {
                TextView textView = this.f61959e;
                if (textView == null) {
                    k.a("titleView");
                }
                textView.setText(this.f61962i.f61963a);
                TextView textView2 = this.f61959e;
                if (textView2 == null) {
                    k.a("titleView");
                }
                ai.a(textView2);
            }
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.search_operator);
            this.f61960g = autoCompleteTextView;
            autoCompleteTextView.addTextChangedListener(this);
            View findViewById2 = inflate.findViewById(R.id.img_search);
            if (findViewById2 != null) {
                this.f61955a = (ImageView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.search_hint);
                if (findViewById3 != null) {
                    this.f61956b = (TextView) findViewById3;
                    View findViewById4 = inflate.findViewById(R.id.nomatches_found);
                    k.a((Object) findViewById4, "view.findViewById(R.id.nomatches_found)");
                    this.f61957c = (TextView) findViewById4;
                    ((RelativeLayout) a(R.id.search_header_root)).setOnClickListener(this);
                    RecyclerView recyclerView = (RecyclerView) a(R.id.operator_recycler_view);
                    b bVar6 = this.f61962i;
                    Integer valueOf = bVar6 != null ? Integer.valueOf(bVar6.f61970h) : null;
                    int i2 = k;
                    if (valueOf != null && valueOf.intValue() == i2) {
                        b bVar7 = this.f61962i;
                        bVar7.f61964b = false;
                        bVar7.f61965c = -1;
                        if (bVar7.f61968f == null) {
                            this.f61962i.a((RecyclerView.h) new d());
                        }
                    } else {
                        int i3 = j;
                        if (valueOf != null && valueOf.intValue() == i3) {
                            this.f61962i.f61964b = true;
                            k.a((Object) recyclerView, "mRecyclerView");
                            ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
                            if (layoutParams2 != null) {
                                ((LinearLayout.LayoutParams) layoutParams2).setMargins(com.paytm.utility.b.c(10), 0, com.paytm.utility.b.c(10), 0);
                                if (this.f61962i.f61968f == null) {
                                    this.f61962i.a((RecyclerView.h) new e());
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                        } else {
                            int i4 = m;
                            if (valueOf != null && valueOf.intValue() == i4) {
                                this.f61962i.f61964b = false;
                                k.a((Object) recyclerView, "mRecyclerView");
                                ViewGroup.LayoutParams layoutParams3 = recyclerView.getLayoutParams();
                                if (layoutParams3 != null) {
                                    ((LinearLayout.LayoutParams) layoutParams3).setMargins(com.paytm.utility.b.c(10), 0, com.paytm.utility.b.c(10), 0);
                                    if (this.f61962i.f61968f == null) {
                                        this.f61962i.a((RecyclerView.h) new f());
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                                }
                            }
                        }
                    }
                    Context context2 = getContext();
                    k.a((Object) context2, "context");
                    b bVar8 = this.f61962i;
                    if (bVar8 != null) {
                        list2 = bVar8.f61967e;
                    } else {
                        list2 = null;
                    }
                    b bVar9 = this.f61962i;
                    if (bVar9 != null) {
                        oVar = bVar9.f61966d;
                    } else {
                        oVar = null;
                    }
                    j jVar = this;
                    b bVar10 = this.f61962i;
                    Boolean valueOf2 = bVar10 != null ? Boolean.valueOf(bVar10.f61964b) : null;
                    b bVar11 = this.f61962i;
                    if (bVar11 != null) {
                        num = Integer.valueOf(bVar11.f61965c);
                    } else {
                        num = null;
                    }
                    b bVar12 = this.f61962i;
                    this.f61958d = new m(context2, list2, oVar, jVar, valueOf2, num, bVar12 != null ? Integer.valueOf(bVar12.f61970h) : num2);
                    k.a((Object) recyclerView, "mRecyclerView");
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), this.f61961h));
                    recyclerView.setNestedScrollingEnabled(false);
                    m mVar = this.f61958d;
                    if (mVar == null) {
                        k.a("mSelectOperatorAdapter");
                    }
                    recyclerView.setAdapter(mVar);
                    b bVar13 = this.f61962i;
                    if (bVar13 != null && bVar13.j) {
                        ViewGroup.LayoutParams layoutParams4 = recyclerView.getLayoutParams();
                        if (layoutParams4 != null) {
                            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) layoutParams4;
                            layoutParams5.setMargins(0, com.paytm.utility.b.c(32), com.paytm.utility.b.c(0), com.paytm.utility.b.c(10));
                            recyclerView.setLayoutParams(layoutParams5);
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        }
                    }
                    b bVar14 = this.f61962i;
                    if (bVar14 == null || (hVar = bVar14.f61968f) == null) {
                        recyclerView.addItemDecoration(new g());
                    } else {
                        recyclerView.addItemDecoration(hVar);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
        } else {
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final AutoCompleteTextView getMOperatorSearch() {
        return this.f61960g;
    }

    public final void setMOperatorSearch(AutoCompleteTextView autoCompleteTextView) {
        this.f61960g = autoCompleteTextView;
    }

    public final ImageView getMsearchImage() {
        ImageView imageView = this.f61955a;
        if (imageView == null) {
            k.a("msearchImage");
        }
        return imageView;
    }

    public final void setMsearchImage(ImageView imageView) {
        k.c(imageView, "<set-?>");
        this.f61955a = imageView;
    }

    public final TextView getMSearchHint() {
        TextView textView = this.f61956b;
        if (textView == null) {
            k.a("mSearchHint");
        }
        return textView;
    }

    public final void setMSearchHint(TextView textView) {
        k.c(textView, "<set-?>");
        this.f61956b = textView;
    }

    public final TextView getNomatches_found() {
        TextView textView = this.f61957c;
        if (textView == null) {
            k.a("nomatches_found");
        }
        return textView;
    }

    public final void setNomatches_found(TextView textView) {
        k.c(textView, "<set-?>");
        this.f61957c = textView;
    }

    public final m getMSelectOperatorAdapter() {
        m mVar = this.f61958d;
        if (mVar == null) {
            k.a("mSelectOperatorAdapter");
        }
        return mVar;
    }

    public final void setMSelectOperatorAdapter(m mVar) {
        k.c(mVar, "<set-?>");
        this.f61958d = mVar;
    }

    public final TextView getTitleView() {
        TextView textView = this.f61959e;
        if (textView == null) {
            k.a("titleView");
        }
        return textView;
    }

    public final void setTitleView(TextView textView) {
        k.c(textView, "<set-?>");
        this.f61959e = textView;
    }

    public static final class d extends RecyclerView.h {
        d() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            if ((recyclerView.indexOfChild(view) + 1) % 3 == 0) {
                rect.set(com.paytm.utility.b.c(0), com.paytm.utility.b.c(0), com.paytm.utility.b.c(0), com.paytm.utility.b.c(25));
            } else {
                rect.set(com.paytm.utility.b.c(0), com.paytm.utility.b.c(0), com.paytm.utility.b.c(5), com.paytm.utility.b.c(25));
            }
        }
    }

    public static final class e extends RecyclerView.h {
        e() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            rect.set(com.paytm.utility.b.c(3), com.paytm.utility.b.c(5), com.paytm.utility.b.c(3), com.paytm.utility.b.c(5));
        }
    }

    public static final class f extends RecyclerView.h {
        f() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            rect.set(com.paytm.utility.b.c(3), com.paytm.utility.b.c(5), com.paytm.utility.b.c(3), com.paytm.utility.b.c(5));
        }
    }

    public static final class g extends RecyclerView.h {
        g() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            rect.set(0, com.paytm.utility.b.c(5), com.paytm.utility.b.c(12), 0);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.search_header_root;
        if (valueOf != null && valueOf.intValue() == i2) {
            AutoCompleteTextView autoCompleteTextView = this.f61960g;
            if (autoCompleteTextView != null) {
                autoCompleteTextView.post(new c(this));
                return;
            }
            return;
        }
        int i3 = R.id.search_operator;
        if (valueOf != null) {
            valueOf.intValue();
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRSelectOperatorViewV8 f61972a;

        c(CJRSelectOperatorViewV8 cJRSelectOperatorViewV8) {
            this.f61972a = cJRSelectOperatorViewV8;
        }

        public final void run() {
            try {
                AutoCompleteTextView mOperatorSearch = this.f61972a.getMOperatorSearch();
                if (mOperatorSearch != null) {
                    mOperatorSearch.requestFocusFromTouch();
                }
                Context context = this.f61972a.getContext();
                Object systemService = context != null ? context.getSystemService("input_method") : null;
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput(this.f61972a.getMOperatorSearch(), 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
        k.c(editable, "searchText");
        m mVar = this.f61958d;
        if (mVar == null) {
            k.a("mSelectOperatorAdapter");
        }
        new m.c(mVar).filter(editable.toString());
        if (p.b(editable).length() > 0) {
            ImageView imageView = this.f61955a;
            if (imageView == null) {
                k.a("msearchImage");
            }
            imageView.setVisibility(8);
            TextView textView = this.f61956b;
            if (textView == null) {
                k.a("mSearchHint");
            }
            textView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.f61955a;
        if (imageView2 == null) {
            k.a("msearchImage");
        }
        imageView2.setVisibility(0);
        TextView textView2 = this.f61956b;
        if (textView2 == null) {
            k.a("mSearchHint");
        }
        textView2.setVisibility(0);
    }

    public final void a(boolean z) {
        if (z) {
            TextView textView = this.f61957c;
            if (textView == null) {
                k.a("nomatches_found");
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.f61957c;
        if (textView2 == null) {
            k.a("nomatches_found");
        }
        textView2.setVisibility(8);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f61963a = "";

        /* renamed from: b  reason: collision with root package name */
        public boolean f61964b = true;

        /* renamed from: c  reason: collision with root package name */
        public int f61965c = -1;

        /* renamed from: d  reason: collision with root package name */
        o f61966d;

        /* renamed from: e  reason: collision with root package name */
        List<CJRAggsItem> f61967e;

        /* renamed from: f  reason: collision with root package name */
        RecyclerView.h f61968f;

        /* renamed from: g  reason: collision with root package name */
        boolean f61969g;

        /* renamed from: h  reason: collision with root package name */
        public int f61970h = -1;

        /* renamed from: i  reason: collision with root package name */
        public boolean f61971i;
        public boolean j;
        public boolean k;

        public final b a(o oVar) {
            k.c(oVar, "listener");
            this.f61966d = oVar;
            return this;
        }

        public final b a(RecyclerView.h hVar) {
            k.c(hVar, "decor");
            this.f61968f = hVar;
            return this;
        }

        public final b a(String str) {
            k.c(str, "title");
            this.f61963a = str;
            return this;
        }

        public final b a(List<CJRAggsItem> list) {
            k.c(list, "operators");
            this.f61967e = list;
            return this;
        }
    }
}
