package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.business.merchant_payments.widget.MpFlowLayout;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.one97.paytm.upi.util.UpiConstants;

public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {
    static final d p = (Build.VERSION.SDK_INT < 29 ? new d() : null);
    private final int A;
    private final int B;
    private final CharSequence C;
    private b D;
    private a E;
    private View.OnClickListener F;
    private boolean G;
    private boolean H;
    private CharSequence I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private CharSequence N;
    private CharSequence O;
    private boolean P;
    private int Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, Drawable.ConstantState> T;
    private final View.OnClickListener U;
    private final TextView.OnEditorActionListener V;
    private final AdapterView.OnItemClickListener W;

    /* renamed from: a  reason: collision with root package name */
    final SearchAutoComplete f1596a;
    private final AdapterView.OnItemSelectedListener aa;
    private TextWatcher ab;

    /* renamed from: b  reason: collision with root package name */
    final View f1597b;

    /* renamed from: c  reason: collision with root package name */
    final ImageView f1598c;

    /* renamed from: d  reason: collision with root package name */
    final ImageView f1599d;

    /* renamed from: e  reason: collision with root package name */
    final ImageView f1600e;

    /* renamed from: f  reason: collision with root package name */
    final ImageView f1601f;

    /* renamed from: g  reason: collision with root package name */
    final View f1602g;

    /* renamed from: h  reason: collision with root package name */
    final Intent f1603h;

    /* renamed from: i  reason: collision with root package name */
    final Intent f1604i;
    View.OnFocusChangeListener j;
    c k;
    boolean l;
    androidx.cursoradapter.a.a m;
    SearchableInfo n;
    Bundle o;
    View.OnKeyListener q;
    private final View r;
    private final View s;
    private e t;
    private Rect u;
    private Rect v;
    private int[] w;
    private int[] x;
    private final ImageView y;
    private final Drawable z;

    public interface a {
        boolean a();
    }

    public interface b {
        boolean a(String str);

        boolean b(String str);
    }

    public interface c {
        boolean a();

        boolean b();
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new Rect();
        this.v = new Rect();
        this.w = new int[2];
        this.x = new int[2];
        this.R = new Runnable() {
            public final void run() {
                SearchView.this.d();
            }
        };
        this.S = new Runnable() {
            public final void run() {
                if (SearchView.this.m instanceof x) {
                    SearchView.this.m.a((Cursor) null);
                }
            }
        };
        this.T = new WeakHashMap<>();
        this.U = new View.OnClickListener() {
            public final void onClick(View view) {
                if (view == SearchView.this.f1598c) {
                    SearchView.this.g();
                } else if (view == SearchView.this.f1600e) {
                    SearchView.this.f();
                } else if (view == SearchView.this.f1599d) {
                    SearchView.this.e();
                } else if (view == SearchView.this.f1601f) {
                    SearchView searchView = SearchView.this;
                    if (searchView.n != null) {
                        SearchableInfo searchableInfo = searchView.n;
                        try {
                            String str = null;
                            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                                Intent intent = new Intent(searchView.f1603h);
                                ComponentName searchActivity = searchableInfo.getSearchActivity();
                                if (searchActivity != null) {
                                    str = searchActivity.flattenToShortString();
                                }
                                intent.putExtra("calling_package", str);
                                searchView.getContext().startActivity(intent);
                            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                                Intent intent2 = searchView.f1604i;
                                ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                                Intent intent3 = new Intent("android.intent.action.SEARCH");
                                intent3.setComponent(searchActivity2);
                                PendingIntent activity = PendingIntent.getActivity(searchView.getContext(), 0, intent3, 1073741824);
                                Bundle bundle = new Bundle();
                                if (searchView.o != null) {
                                    bundle.putParcelable("app_data", searchView.o);
                                }
                                Intent intent4 = new Intent(intent2);
                                String str2 = "free_form";
                                int i2 = 1;
                                Resources resources = searchView.getResources();
                                if (searchableInfo.getVoiceLanguageModeId() != 0) {
                                    str2 = resources.getString(searchableInfo.getVoiceLanguageModeId());
                                }
                                String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                                String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                                if (searchableInfo.getVoiceMaxResults() != 0) {
                                    i2 = searchableInfo.getVoiceMaxResults();
                                }
                                intent4.putExtra("android.speech.extra.LANGUAGE_MODEL", str2);
                                intent4.putExtra("android.speech.extra.PROMPT", string);
                                intent4.putExtra("android.speech.extra.LANGUAGE", string2);
                                intent4.putExtra("android.speech.extra.MAX_RESULTS", i2);
                                if (searchActivity2 != null) {
                                    str = searchActivity2.flattenToShortString();
                                }
                                intent4.putExtra("calling_package", str);
                                intent4.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                                intent4.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                                searchView.getContext().startActivity(intent4);
                            }
                        } catch (ActivityNotFoundException unused) {
                        }
                    }
                } else if (view == SearchView.this.f1596a) {
                    SearchView.this.i();
                }
            }
        };
        this.q = new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.n == null) {
                    return false;
                }
                if (!SearchView.this.f1596a.isPopupShowing() || SearchView.this.f1596a.getListSelection() == -1) {
                    if ((TextUtils.getTrimmedLength(SearchView.this.f1596a.getText()) == 0) || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                        return false;
                    }
                    view.cancelLongPress();
                    SearchView searchView = SearchView.this;
                    searchView.a(searchView.f1596a.getText().toString());
                    return true;
                }
                SearchView searchView2 = SearchView.this;
                if (searchView2.n != null && searchView2.m != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                    if (i2 == 66 || i2 == 84 || i2 == 61) {
                        return searchView2.b(searchView2.f1596a.getListSelection());
                    }
                    if (i2 == 21 || i2 == 22) {
                        searchView2.f1596a.setSelection(i2 == 21 ? 0 : searchView2.f1596a.length());
                        searchView2.f1596a.setListSelection(0);
                        searchView2.f1596a.clearListSelection();
                        searchView2.f1596a.a();
                        return true;
                    } else if (i2 == 19) {
                        searchView2.f1596a.getListSelection();
                    }
                }
                return false;
            }
        };
        this.V = new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.e();
                return true;
            }
        };
        this.W = new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.b(i2);
            }
        };
        this.aa = new AdapterView.OnItemSelectedListener() {
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView searchView = SearchView.this;
                if (searchView.k == null || !searchView.k.a()) {
                    Editable text = searchView.f1596a.getText();
                    Cursor a2 = searchView.m.a();
                    if (a2 == null) {
                        return;
                    }
                    if (a2.moveToPosition(i2)) {
                        CharSequence b2 = searchView.m.b(a2);
                        if (b2 != null) {
                            searchView.setQuery(b2);
                        } else {
                            searchView.setQuery(text);
                        }
                    } else {
                        searchView.setQuery(text);
                    }
                }
            }
        };
        this.ab = new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.a(charSequence);
            }
        };
        ac a2 = ac.a(context, attributeSet, R.styleable.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(a2.g(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        this.f1596a = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f1596a.setSearchView(this);
        this.r = findViewById(R.id.search_edit_frame);
        this.f1597b = findViewById(R.id.search_plate);
        this.s = findViewById(R.id.submit_area);
        this.f1598c = (ImageView) findViewById(R.id.search_button);
        this.f1599d = (ImageView) findViewById(R.id.search_go_btn);
        this.f1600e = (ImageView) findViewById(R.id.search_close_btn);
        this.f1601f = (ImageView) findViewById(R.id.search_voice_btn);
        this.y = (ImageView) findViewById(R.id.search_mag_icon);
        u.a(this.f1597b, a2.a(R.styleable.SearchView_queryBackground));
        u.a(this.s, a2.a(R.styleable.SearchView_submitBackground));
        this.f1598c.setImageDrawable(a2.a(R.styleable.SearchView_searchIcon));
        this.f1599d.setImageDrawable(a2.a(R.styleable.SearchView_goIcon));
        this.f1600e.setImageDrawable(a2.a(R.styleable.SearchView_closeIcon));
        this.f1601f.setImageDrawable(a2.a(R.styleable.SearchView_voiceIcon));
        this.y.setImageDrawable(a2.a(R.styleable.SearchView_searchIcon));
        this.z = a2.a(R.styleable.SearchView_searchHintIcon);
        ae.a(this.f1598c, getResources().getString(R.string.abc_searchview_description_search));
        this.A = a2.g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.B = a2.g(R.styleable.SearchView_commitIcon, 0);
        this.f1598c.setOnClickListener(this.U);
        this.f1600e.setOnClickListener(this.U);
        this.f1599d.setOnClickListener(this.U);
        this.f1601f.setOnClickListener(this.U);
        this.f1596a.setOnClickListener(this.U);
        this.f1596a.addTextChangedListener(this.ab);
        this.f1596a.setOnEditorActionListener(this.V);
        this.f1596a.setOnItemClickListener(this.W);
        this.f1596a.setOnItemSelectedListener(this.aa);
        this.f1596a.setOnKeyListener(this.q);
        this.f1596a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (SearchView.this.j != null) {
                    SearchView.this.j.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a2.a(R.styleable.SearchView_iconifiedByDefault, true));
        int e2 = a2.e(R.styleable.SearchView_android_maxWidth, -1);
        if (e2 != -1) {
            setMaxWidth(e2);
        }
        this.C = a2.c(R.styleable.SearchView_defaultQueryHint);
        this.I = a2.c(R.styleable.SearchView_queryHint);
        int a3 = a2.a(R.styleable.SearchView_android_imeOptions, -1);
        if (a3 != -1) {
            setImeOptions(a3);
        }
        int a4 = a2.a(R.styleable.SearchView_android_inputType, -1);
        if (a4 != -1) {
            setInputType(a4);
        }
        setFocusable(a2.a(R.styleable.SearchView_android_focusable, true));
        a2.f1669a.recycle();
        this.f1603h = new Intent("android.speech.action.WEB_SEARCH");
        this.f1603h.addFlags(268435456);
        this.f1603h.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f1604i = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1604i.addFlags(268435456);
        this.f1602g = findViewById(this.f1596a.getDropDownAnchor());
        View view = this.f1602g;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    int i10;
                    SearchView searchView = SearchView.this;
                    if (searchView.f1602g.getWidth() > 1) {
                        Resources resources = searchView.getContext().getResources();
                        int paddingLeft = searchView.f1597b.getPaddingLeft();
                        Rect rect = new Rect();
                        boolean a2 = ai.a(searchView);
                        int dimensionPixelSize = searchView.l ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
                        searchView.f1596a.getDropDownBackground().getPadding(rect);
                        if (a2) {
                            i10 = -rect.left;
                        } else {
                            i10 = paddingLeft - (rect.left + dimensionPixelSize);
                        }
                        searchView.f1596a.setDropDownHorizontalOffset(i10);
                        searchView.f1596a.setDropDownWidth((((searchView.f1602g.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    }
                }
            });
        }
        a(this.l);
        n();
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.B;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.n = searchableInfo;
        SearchableInfo searchableInfo2 = this.n;
        Intent intent = null;
        if (searchableInfo2 != null) {
            this.f1596a.setThreshold(searchableInfo2.getSuggestThreshold());
            this.f1596a.setImeOptions(this.n.getImeOptions());
            int inputType = this.n.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= MpFlowLayout.SPACING_ALIGN;
                if (this.n.getSuggestAuthority() != null) {
                    inputType = inputType | 65536 | 524288;
                }
            }
            this.f1596a.setInputType(inputType);
            androidx.cursoradapter.a.a aVar = this.m;
            if (aVar != null) {
                aVar.a((Cursor) null);
            }
            if (this.n.getSuggestAuthority() != null) {
                this.m = new x(getContext(), this, this.n, this.T);
                this.f1596a.setAdapter(this.m);
                ((x) this.m).f1822a = this.J ? 2 : 1;
            }
            n();
        }
        SearchableInfo searchableInfo3 = this.n;
        boolean z2 = false;
        if (searchableInfo3 != null && searchableInfo3.getVoiceSearchEnabled()) {
            if (this.n.getVoiceSearchLaunchWebSearch()) {
                intent = this.f1603h;
            } else if (this.n.getVoiceSearchLaunchRecognizer()) {
                intent = this.f1604i;
            }
            if (!(intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null)) {
                z2 = true;
            }
        }
        this.M = z2;
        if (this.M) {
            this.f1596a.setPrivateImeOptions("nm");
        }
        a(this.G);
    }

    public void setAppSearchData(Bundle bundle) {
        this.o = bundle;
    }

    public void setImeOptions(int i2) {
        this.f1596a.setImeOptions(i2);
    }

    public int getImeOptions() {
        return this.f1596a.getImeOptions();
    }

    public void setInputType(int i2) {
        this.f1596a.setInputType(i2);
    }

    public int getInputType() {
        return this.f1596a.getInputType();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.K || !isFocusable()) {
            return false;
        }
        if (this.G) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.f1596a.requestFocus(i2, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.K = true;
        super.clearFocus();
        this.f1596a.clearFocus();
        this.f1596a.setImeVisibility(false);
        this.K = false;
    }

    public void setOnQueryTextListener(b bVar) {
        this.D = bVar;
    }

    public void setOnCloseListener(a aVar) {
        this.E = aVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.j = onFocusChangeListener;
    }

    public void setOnSuggestionListener(c cVar) {
        this.k = cVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.F = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1596a.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z2) {
        this.f1596a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1596a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.O = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            e();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.I = charSequence;
        n();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.I;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.n;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.C;
        }
        return getContext().getText(this.n.getHintId());
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.l != z2) {
            this.l = z2;
            a(z2);
            n();
        }
    }

    public void setIconified(boolean z2) {
        if (z2) {
            f();
        } else {
            g();
        }
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.H = z2;
        a(this.G);
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.J = z2;
        androidx.cursoradapter.a.a aVar = this.m;
        if (aVar instanceof x) {
            ((x) aVar).f1822a = z2 ? 2 : 1;
        }
    }

    public void setSuggestionsAdapter(androidx.cursoradapter.a.a aVar) {
        this.m = aVar;
        this.f1596a.setAdapter(this.m);
    }

    public androidx.cursoradapter.a.a getSuggestionsAdapter() {
        return this.m;
    }

    public void setMaxWidth(int i2) {
        this.L = i2;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.L;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            SearchAutoComplete searchAutoComplete = this.f1596a;
            Rect rect = this.u;
            searchAutoComplete.getLocationInWindow(this.w);
            getLocationInWindow(this.x);
            int[] iArr = this.w;
            int i6 = iArr[1];
            int[] iArr2 = this.x;
            int i7 = i6 - iArr2[1];
            int i8 = iArr[0] - iArr2[0];
            rect.set(i8, i7, searchAutoComplete.getWidth() + i8, searchAutoComplete.getHeight() + i7);
            this.v.set(this.u.left, 0, this.u.right, i5 - i3);
            e eVar = this.t;
            if (eVar == null) {
                this.t = new e(this.v, this.u, this.f1596a);
                setTouchDelegate(this.t);
                return;
            }
            eVar.a(this.v, this.u);
        }
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private void a(boolean z2) {
        this.G = z2;
        int i2 = 0;
        int i3 = z2 ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1596a.getText());
        this.f1598c.setVisibility(i3);
        b(z3);
        this.r.setVisibility(z2 ? 8 : 0);
        if (this.y.getDrawable() == null || this.l) {
            i2 = 8;
        }
        this.y.setVisibility(i2);
        l();
        c(!z3);
        k();
    }

    private boolean j() {
        return (this.H || this.M) && !this.G;
    }

    private void b(boolean z2) {
        this.f1599d.setVisibility((!this.H || !j() || !hasFocus() || (!z2 && this.M)) ? 8 : 0);
    }

    private void k() {
        this.s.setVisibility((!j() || !(this.f1599d.getVisibility() == 0 || this.f1601f.getVisibility() == 0)) ? 8 : 0);
    }

    private void l() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1596a.getText());
        int i2 = 0;
        if (!z3 && (!this.l || this.P)) {
            z2 = false;
        }
        ImageView imageView = this.f1600e;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1600e.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m() {
        post(this.R);
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        int[] iArr = this.f1596a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f1597b.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.l || this.z == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1596a.getTextSize()) * 1.25d);
        this.z.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.z), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void n() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1596a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(b(queryHint));
    }

    private void c(boolean z2) {
        int i2;
        if (!this.M || this.G || !z2) {
            i2 = 8;
        } else {
            i2 = 0;
            this.f1599d.setVisibility(8);
        }
        this.f1601f.setVisibility(i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(CharSequence charSequence) {
        Editable text = this.f1596a.getText();
        this.O = text;
        boolean z2 = !TextUtils.isEmpty(text);
        b(z2);
        c(!z2);
        l();
        k();
        if (this.D != null && !TextUtils.equals(charSequence, this.N)) {
            this.D.b(charSequence.toString());
        }
        this.N = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        Editable text = this.f1596a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            b bVar = this.D;
            if (bVar == null || !bVar.a(text.toString())) {
                if (this.n != null) {
                    a(text.toString());
                }
                this.f1596a.setImeVisibility(false);
                this.f1596a.dismissDropDown();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        if (!TextUtils.isEmpty(this.f1596a.getText())) {
            this.f1596a.setText("");
            this.f1596a.requestFocus();
            this.f1596a.setImeVisibility(true);
        } else if (this.l) {
            a aVar = this.E;
            if (aVar != null) {
                aVar.a();
            }
            clearFocus();
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        a(false);
        this.f1596a.requestFocus();
        this.f1596a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.F;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        m();
    }

    public final void b() {
        setQuery("", false);
        clearFocus();
        a(true);
        this.f1596a.setImeOptions(this.Q);
        this.P = false;
    }

    public final void a() {
        if (!this.P) {
            this.P = true;
            this.Q = this.f1596a.getImeOptions();
            this.f1596a.setImeOptions(this.Q | 33554432);
            this.f1596a.setText("");
            setIconified(false);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f1615a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1615a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f1615a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1615a + "}";
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1615a = this.G;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        a(savedState.f1615a);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final boolean b(int i2) {
        Intent a2;
        c cVar = this.k;
        if (cVar != null && cVar.b()) {
            return false;
        }
        Cursor a3 = this.m.a();
        if (!(a3 == null || !a3.moveToPosition(i2) || (a2 = a(a3)) == null)) {
            try {
                getContext().startActivity(a2);
            } catch (RuntimeException unused) {
                new StringBuilder("Failed launch activity: ").append(a2);
            }
        }
        this.f1596a.setImeVisibility(false);
        this.f1596a.dismissDropDown();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setQuery(CharSequence charSequence) {
        this.f1596a.setText(charSequence);
        this.f1596a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.O);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.o;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.n.getSearchActivity());
        return intent;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r6 = r6.getPosition();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r1 = new java.lang.StringBuilder("Search suggestions cursor at row ");
        r1.append(r6);
        r1.append(" returned exception.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent a(android.database.Cursor r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "suggest_intent_action"
            java.lang.String r1 = androidx.appcompat.widget.x.a((android.database.Cursor) r6, (java.lang.String) r1)     // Catch:{ RuntimeException -> 0x0061 }
            if (r1 != 0) goto L_0x0010
            android.app.SearchableInfo r1 = r5.n     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r1.getSuggestIntentAction()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0010:
            if (r1 != 0) goto L_0x0014
            java.lang.String r1 = "android.intent.action.SEARCH"
        L_0x0014:
            java.lang.String r2 = "suggest_intent_data"
            java.lang.String r2 = androidx.appcompat.widget.x.a((android.database.Cursor) r6, (java.lang.String) r2)     // Catch:{ RuntimeException -> 0x0061 }
            if (r2 != 0) goto L_0x0023
            android.app.SearchableInfo r2 = r5.n     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r2 = r2.getSuggestIntentData()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0023:
            if (r2 == 0) goto L_0x0046
            java.lang.String r3 = "suggest_intent_data_id"
            java.lang.String r3 = androidx.appcompat.widget.x.a((android.database.Cursor) r6, (java.lang.String) r3)     // Catch:{ RuntimeException -> 0x0061 }
            if (r3 == 0) goto L_0x0046
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0061 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x0061 }
            r4.append(r2)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r2 = android.net.Uri.encode(r3)     // Catch:{ RuntimeException -> 0x0061 }
            r4.append(r2)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r2 = r4.toString()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0046:
            if (r2 != 0) goto L_0x004a
            r2 = r0
            goto L_0x004e
        L_0x004a:
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ RuntimeException -> 0x0061 }
        L_0x004e:
            java.lang.String r3 = "suggest_intent_query"
            java.lang.String r3 = androidx.appcompat.widget.x.a((android.database.Cursor) r6, (java.lang.String) r3)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r4 = "suggest_intent_extra_data"
            java.lang.String r4 = androidx.appcompat.widget.x.a((android.database.Cursor) r6, (java.lang.String) r4)     // Catch:{ RuntimeException -> 0x0061 }
            android.content.Intent r6 = r5.a(r1, r2, r4, r3)     // Catch:{ RuntimeException -> 0x0061 }
            return r6
        L_0x0061:
            int r6 = r6.getPosition()     // Catch:{ RuntimeException -> 0x0066 }
            goto L_0x0067
        L_0x0066:
            r6 = -1
        L_0x0067:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Search suggestions cursor at row "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = " returned exception."
            r1.append(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.a(android.database.Cursor):android.content.Intent");
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1596a.refreshAutoCompleteResults();
            return;
        }
        p.a(this.f1596a);
        p.b(this.f1596a);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    static class e extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f1624a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f1625b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1626c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f1627d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f1628e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1629f;

        public e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1628e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f1624a = view;
        }

        public final void a(Rect rect, Rect rect2) {
            this.f1625b.set(rect);
            this.f1627d.set(rect);
            Rect rect3 = this.f1627d;
            int i2 = this.f1628e;
            rect3.inset(-i2, -i2);
            this.f1626c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x002e
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003a
            L_0x001b:
                boolean r2 = r7.f1629f
                r7.f1629f = r5
                goto L_0x003b
            L_0x0020:
                boolean r2 = r7.f1629f
                if (r2 == 0) goto L_0x003b
                android.graphics.Rect r6 = r7.f1627d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x003b
                r4 = 0
                goto L_0x003b
            L_0x002e:
                android.graphics.Rect r2 = r7.f1625b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003a
                r7.f1629f = r4
                r2 = 1
                goto L_0x003b
            L_0x003a:
                r2 = 0
            L_0x003b:
                if (r2 == 0) goto L_0x0070
                if (r4 == 0) goto L_0x005b
                android.graphics.Rect r2 = r7.f1626c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005b
                android.view.View r0 = r7.f1624a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1624a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L_0x006a
            L_0x005b:
                android.graphics.Rect r2 = r7.f1626c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r7.f1626c
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L_0x006a:
                android.view.View r0 = r7.f1624a
                boolean r5 = r0.dispatchTouchEvent(r8)
            L_0x0070:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.e.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a  reason: collision with root package name */
        boolean f1616a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f1617b;

        /* renamed from: c  reason: collision with root package name */
        private int f1618c;

        /* renamed from: d  reason: collision with root package name */
        private SearchView f1619d;

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f1617b = new Runnable() {
                public final void run() {
                    SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                    if (searchAutoComplete.f1616a) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.f1616a = false;
                    }
                }
            };
            this.f1618c = getThreshold();
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1619d = searchView;
        }

        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f1618c = i2;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1619d.hasFocus() && getVisibility() == 0) {
                this.f1616a = true;
                if (SearchView.a(getContext())) {
                    a();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.f1619d.h();
        }

        public boolean enoughToFilter() {
            return this.f1618c <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1619d.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
            }
            if (i2 < 600) {
                return (i2 < 640 || i3 < 480) ? 160 : 192;
            }
            return 192;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1616a) {
                removeCallbacks(this.f1617b);
                post(this.f1617b);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f1616a = false;
                removeCallbacks(this.f1617b);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1616a = false;
                removeCallbacks(this.f1617b);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1616a = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.p.c(this);
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private Method f1621a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f1622b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f1623c = null;

        d() {
            a();
            try {
                this.f1621a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1621a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f1622b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1622b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                this.f1623c = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1623c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1621a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1622b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void c(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1623c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }

        private static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.G) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.L;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.L;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.L) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        a(this.G);
        m();
        if (this.f1596a.hasFocus()) {
            i();
        }
    }
}
