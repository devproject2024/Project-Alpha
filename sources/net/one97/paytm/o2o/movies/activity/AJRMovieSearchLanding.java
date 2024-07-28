package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.s;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.customui.CustomTabLayout;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSearchCategory;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.CJRHomePageResponse;
import net.one97.paytm.o2o.movies.fragment.c;
import net.one97.paytm.o2o.movies.fragment.h;
import net.one97.paytm.o2o.movies.utils.e;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRMovieSearchLanding extends AppBaseActivity implements TextWatcher, View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f74045a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f74046b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f74047c;

    /* renamed from: d  reason: collision with root package name */
    private AppCompatImageView f74048d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f74049e;

    /* renamed from: f  reason: collision with root package name */
    private AppCompatImageView f74050f;

    /* renamed from: g  reason: collision with root package name */
    private Animation f74051g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f74052h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f74053i;
    private RelativeLayout j;
    private ArrayList<CJRMovieHomeListItem> k;
    /* access modifiers changed from: private */
    public ArrayList<CJRMovieHomeListItem> l;
    /* access modifiers changed from: private */
    public List<CJRCinemas> m;
    /* access modifiers changed from: private */
    public ArrayList<Object> n = new ArrayList<>();
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public String p;
    private s q;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.movie_search_landing);
        this.f74047c = (EditText) findViewById(R.id.search_edit_txt);
        this.f74048d = (AppCompatImageView) findViewById(R.id.search_edit_close);
        this.f74050f = (AppCompatImageView) findViewById(R.id.close_edit_image);
        this.f74047c.setVisibility(0);
        this.f74047c.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
        this.f74047c.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return AJRMovieSearchLanding.this.a(textView, i2, keyEvent);
            }
        });
        try {
            if (Build.VERSION.SDK_INT < 21) {
                getWindow().setSoftInputMode(32);
            }
        } catch (Exception unused) {
        }
        this.o = getIntent().getStringExtra("intent_city_name");
        this.p = getIntent().getStringExtra("intent_virtual_city_name");
        this.f74047c.addTextChangedListener(this);
        this.f74048d.setOnClickListener(this);
        this.f74050f.setOnClickListener(this);
        this.f74053i = (RelativeLayout) findViewById(R.id.movies_search_rel_landing);
        this.j = (RelativeLayout) findViewById(R.id.movies_search_rel_lyt);
        this.f74053i.setVisibility(0);
        this.j.setVisibility(8);
        this.f74052h = (LinearLayout) findViewById(R.id.err_lyt);
        this.f74049e = (RoboTextView) findViewById(R.id.error_text_quote);
        this.f74046b = (RecyclerView) findViewById(R.id.recycler_view);
        this.f74046b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f74045a = (ViewPager) findViewById(R.id.movie_search_viewpager);
        try {
            b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/movies/search", "movies", this);
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/search");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.x);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Screen Loaded");
            if (this.o != null && !this.o.isEmpty()) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75013h, this.o);
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused2) {
        }
        a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.movies_search_tab));
        arrayList.add(getResources().getString(R.string.cinemas_search_tab));
        this.f74045a.setAdapter(new a(getSupportFragmentManager(), arrayList));
        CustomTabLayout customTabLayout = (CustomTabLayout) findViewById(R.id.movie_search_tabs);
        customTabLayout.setupWithViewPager(this.f74045a);
        customTabLayout.setTabGravity(0);
        customTabLayout.setSelectedTabIndicatorWidth(n.a(85, (Context) this));
        customTabLayout.setSelectedTabIndicatorColor(androidx.core.content.b.c(this, R.color.color_00b9f5));
        customTabLayout.setSelectedTabIndicatorHeight((int) (getResources().getDisplayMetrics().density * 2.0f));
        customTabLayout.a((CustomTabLayout.b) new CustomTabLayout.b() {
            public final void b(CustomTabLayout.e eVar) {
            }

            public final void a(CustomTabLayout.e eVar) {
                String str;
                new StringBuilder("----Tab Selected-----").append(eVar.f75077d);
                com.paytm.utility.b.j();
                if (eVar.f75077d == 0) {
                    if (AJRMovieSearchLanding.this.f74045a != null) {
                        AJRMovieSearchLanding.this.f74045a.setCurrentItem(eVar.f75077d);
                    }
                    str = "Movie";
                } else {
                    if (AJRMovieSearchLanding.this.f74045a != null) {
                        AJRMovieSearchLanding.this.f74045a.setCurrentItem(eVar.f75077d);
                    }
                    str = "Cinema";
                }
                AJRMovieSearchLanding aJRMovieSearchLanding = AJRMovieSearchLanding.this;
                AJRMovieSearchLanding.a(aJRMovieSearchLanding, str, aJRMovieSearchLanding.o, com.paytm.utility.b.n((Context) AJRMovieSearchLanding.this));
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 2 && i2 != 6 && i2 != 5 && i2 != 4 && i2 != 3 && keyEvent.getAction() != 66) {
            return false;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f74047c.getWindowToken(), 0);
        return true;
    }

    private void a() {
        ArrayList arrayList;
        i a2 = i.a();
        com.paytm.utility.b.j();
        this.k = a2.f75932b;
        e eVar = e.f75922a;
        this.k = e.a(this.k);
        try {
            b.f75032a.f75033b.sendCustomEvents("mov_home_loaded", this);
        } catch (Exception unused) {
        }
        if (this.k != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<CJRMovieHomeListItem> it2 = this.k.iterator();
            while (it2.hasNext()) {
                CJRMovieHomeListItem next = it2.next();
                CJRHomePageResponse.Language language = new CJRHomePageResponse.Language();
                language.languageToDisplay = next.getLang();
                language.languageForOperation = next.getLang();
                language.sessionCount = next.getTotalSessionCount();
                if (!arrayList2.contains(language)) {
                    arrayList2.add(language);
                } else {
                    ((CJRHomePageResponse.Language) arrayList2.get(arrayList2.indexOf(language))).sessionCount += next.getTotalSessionCount();
                }
                arrayList3.add(next);
            }
            Collections.sort(arrayList2);
            Collections.reverse(arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                String str = ((CJRHomePageResponse.Language) arrayList2.get(i2)).languageToDisplay;
                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                    if (((CJRHomePageResponse.Language) arrayList2.get(i2)).languageToDisplay.equalsIgnoreCase(((CJRMovieHomeListItem) arrayList3.get(i3)).getLang())) {
                        if (!linkedHashMap.containsKey(str)) {
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(arrayList3.get(i3));
                            linkedHashMap.put(str, arrayList4);
                        } else {
                            ((ArrayList) linkedHashMap.get(str)).add(arrayList3.get(i3));
                        }
                    }
                }
            }
            arrayList = new ArrayList(linkedHashMap.keySet());
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str2 = (String) it3.next();
                CJRSearchCategory cJRSearchCategory = new CJRSearchCategory();
                cJRSearchCategory.setmCategoryTitle(str2);
                this.n.add(cJRSearchCategory);
                this.n.addAll((Collection) linkedHashMap.get(str2));
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList5 = arrayList;
        this.m = a2.f75933c;
        this.l = this.k;
        ArrayList<CJRMovieHomeListItem> arrayList6 = this.l;
        List<CJRCinemas> list = this.m;
        if (this.q == null) {
            this.q = new s(this, arrayList6, list, this.f74052h, arrayList5, this.o, this.p, this.f74049e);
            this.f74046b.setAdapter(this.q);
            this.f74046b.addOnScrollListener(new RecyclerView.l() {
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    super.onScrollStateChanged(recyclerView, i2);
                }

                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    super.onScrolled(recyclerView, i2, i3);
                    InputMethodManager inputMethodManager = (InputMethodManager) AJRMovieSearchLanding.this.getSystemService("input_method");
                    if (i3 > 0) {
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(AJRMovieSearchLanding.this.f74047c.getWindowToken(), 0);
                        }
                    } else if (i3 < 0 && inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(AJRMovieSearchLanding.this.f74047c.getWindowToken(), 0);
                    }
                }
            });
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence != null) {
            charSequence = charSequence.toString().trim();
        }
        if (charSequence == null || TextUtils.isEmpty(charSequence)) {
            this.f74050f.setVisibility(8);
            this.f74053i.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            this.f74050f.setVisibility(0);
            this.f74053i.setVisibility(8);
            this.j.setVisibility(0);
        }
        s sVar = this.q;
        if (sVar != null) {
            sVar.getFilter().filter(charSequence);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close_edit_image) {
            this.f74047c.setText("");
        } else if (id == R.id.search_icon_img) {
            this.f74051g = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
            this.f74047c.setVisibility(0);
            this.f74047c.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f74047c, 1);
            }
        } else if (id == R.id.search_edit_close) {
            try {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            } catch (Exception unused) {
            }
            onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f74047c.getWindowToken(), 0);
            }
            finish();
            overridePendingTransition(17432576, R.anim.abc_slide_out_bottom);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public class a extends m {

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<Fragment> f74057b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<String> f74058c;

        a(j jVar, ArrayList<String> arrayList) {
            super(jVar);
            this.f74058c = arrayList;
        }

        public final CharSequence getPageTitle(int i2) {
            return this.f74058c.get(i2);
        }

        public final Fragment getItem(int i2) {
            if (i2 == 0) {
                h hVar = new h();
                String b2 = AJRMovieSearchLanding.this.o;
                ArrayList<Object> d2 = AJRMovieSearchLanding.this.n;
                hVar.f75319a = b2;
                hVar.f75320b = d2;
                this.f74057b.put(i2, hVar);
                return hVar;
            }
            c cVar = new c();
            String b3 = AJRMovieSearchLanding.this.o;
            ArrayList<CJRMovieHomeListItem> e2 = AJRMovieSearchLanding.this.l;
            String g2 = AJRMovieSearchLanding.this.p;
            cVar.f75258a = b3;
            cVar.f75260c = (ArrayList) AJRMovieSearchLanding.this.m;
            cVar.f75261d = e2;
            if (!TextUtils.isEmpty(g2)) {
                cVar.f75259b = g2;
            } else {
                cVar.f75259b = b3;
            }
            this.f74057b.put(i2, cVar);
            return cVar;
        }

        public final int getCount() {
            return this.f74058c.size();
        }
    }

    static /* synthetic */ void a(AJRMovieSearchLanding aJRMovieSearchLanding, String str, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder("-------------GTM TAB SELECTED VALUES----- category---");
            sb.append(str);
            sb.append("------CITY NAME ----");
            sb.append(str2);
            sb.append("------userID-----");
            sb.append(str3);
            com.paytm.utility.b.j();
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/search");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.x);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Search Type -".concat(String.valueOf(str)));
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) aJRMovieSearchLanding)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) aJRMovieSearchLanding));
            }
            b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aJRMovieSearchLanding);
        } catch (Exception unused) {
        }
    }
}
