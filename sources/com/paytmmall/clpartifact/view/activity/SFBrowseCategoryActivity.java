package com.paytmmall.clpartifact.view.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.ga.ShowMoreGAHandler;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.RecentsManager;
import com.paytmmall.clpartifact.view.actions.ICategoryClickListener;
import com.paytmmall.clpartifact.view.actions.ICategoryGaListener;
import com.paytmmall.clpartifact.view.adapter.SFCategoryAdapter;
import com.paytmmall.clpartifact.view.adapter.SFCategoryItemAdapter;
import com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class SFBrowseCategoryActivity extends PaytmActivity implements ICategoryClickListener, ICategoryGaListener {
    private int INITIAL_POSITION;
    private final String KEY_CATEGORY = "category";
    private final String KEY_URL = "url";
    private HashMap _$_findViewCache;
    private final ArrayList<String> categoriesList = new ArrayList<>();
    private final HashMap<String, List<View>> categoriesMap = new HashMap<>();
    public SFCategoryAdapter categoryAdapter;
    public SFCategoryItemAdapter categoryItemAdapter;
    /* access modifiers changed from: private */
    public ShowMoreGAHandler gaHandler = new ShowMoreGAHandler();
    private String mCurrentLanguage = "";
    private String mSavedLanguage;
    /* access modifiers changed from: private */
    public RequestType networkRequestType;
    public SFBrowseCategoryVM viewModel;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final android.view.View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        android.view.View view = (android.view.View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        android.view.View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final SFBrowseCategoryVM getViewModel() {
        SFBrowseCategoryVM sFBrowseCategoryVM = this.viewModel;
        if (sFBrowseCategoryVM == null) {
            k.a("viewModel");
        }
        return sFBrowseCategoryVM;
    }

    public final void setViewModel(SFBrowseCategoryVM sFBrowseCategoryVM) {
        k.c(sFBrowseCategoryVM, "<set-?>");
        this.viewModel = sFBrowseCategoryVM;
    }

    public final SFCategoryAdapter getCategoryAdapter() {
        SFCategoryAdapter sFCategoryAdapter = this.categoryAdapter;
        if (sFCategoryAdapter == null) {
            k.a("categoryAdapter");
        }
        return sFCategoryAdapter;
    }

    public final void setCategoryAdapter(SFCategoryAdapter sFCategoryAdapter) {
        k.c(sFCategoryAdapter, "<set-?>");
        this.categoryAdapter = sFCategoryAdapter;
    }

    public final SFCategoryItemAdapter getCategoryItemAdapter() {
        SFCategoryItemAdapter sFCategoryItemAdapter = this.categoryItemAdapter;
        if (sFCategoryItemAdapter == null) {
            k.a("categoryItemAdapter");
        }
        return sFCategoryItemAdapter;
    }

    public final void setCategoryItemAdapter(SFCategoryItemAdapter sFCategoryItemAdapter) {
        k.c(sFCategoryItemAdapter, "<set-?>");
        this.categoryItemAdapter = sFCategoryItemAdapter;
    }

    public final void onCreate(Bundle bundle) {
        ICLPCommunicationListener communicationListener;
        String stringExtra;
        super.onCreate(bundle);
        setContentView(R.layout.activity_sfbrowse_category);
        Context context = this;
        setStatusBarColor(b.c(context, R.color.white));
        ai a2 = am.a((FragmentActivity) this).a(SFBrowseCategoryVM.class);
        k.a((Object) a2, "ViewModelProviders.of(th…seCategoryVM::class.java)");
        this.viewModel = (SFBrowseCategoryVM) a2;
        initUI();
        this.mSavedLanguage = getSavedLanguageInShowMore();
        String a3 = n.a(context);
        k.a((Object) a3, "LocaleHelper.getLanguage(this)");
        this.mCurrentLanguage = a3;
        CharSequence charSequence = this.mSavedLanguage;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0) && (!k.a((Object) this.mSavedLanguage, (Object) this.mCurrentLanguage))) {
            RecentsManager.INSTANCE.flushRecentsOnLanguageChange();
            saveLanguageInShowMore();
        }
        CharSequence charSequence2 = this.mSavedLanguage;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            saveLanguageInShowMore();
        }
        if (getIntent().hasExtra(this.KEY_URL) && (stringExtra = getIntent().getStringExtra(this.KEY_URL)) != null) {
            SFBrowseCategoryVM sFBrowseCategoryVM = this.viewModel;
            if (sFBrowseCategoryVM == null) {
                k.a("viewModel");
            }
            sFBrowseCategoryVM.setLoadUrl(stringExtra);
        }
        SFBrowseCategoryVM sFBrowseCategoryVM2 = this.viewModel;
        if (sFBrowseCategoryVM2 == null) {
            k.a("viewModel");
        }
        sFBrowseCategoryVM2.getResponseLiveData().observe(this, new SFBrowseCategoryActivity$onCreate$2(this));
        showHideProgressBar(true);
        CLPArtifact instance = CLPArtifact.getInstance();
        if (instance != null && (communicationListener = instance.getCommunicationListener()) != null) {
            communicationListener.sendOpenScreenWithDeviceInfo(CLPConstants.GTM_SCREEN_NAME_SHOW_MORE, "", getApplicationContext());
        }
    }

    private final void setStatusBarColor(int i2) {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.setSoftInputMode(16);
            android.view.View decorView = window.getDecorView();
            window.addFlags(Integer.MIN_VALUE);
            if (Build.VERSION.SDK_INT >= 23) {
                k.a((Object) decorView, "decor");
                decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
            window.setStatusBarColor(i2);
        }
    }

    private final void saveLanguageInShowMore() {
        a.C0708a aVar = a.f42641a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        a.C0708a.a(applicationContext, a.c.HOME).a(CLPConstants.SHOW_MORE_SAVED_LANGUAGE, n.a(getApplicationContext()), false);
    }

    private final String getSavedLanguageInShowMore() {
        a.C0708a aVar = com.paytm.b.a.a.f42641a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        return a.C0708a.a(applicationContext, a.c.HOME).b(CLPConstants.SHOW_MORE_SAVED_LANGUAGE, "", false);
    }

    private final void initUI() {
        ((TextView) _$_findCachedViewById(R.id.retryNetwork)).setOnClickListener(new SFBrowseCategoryActivity$initUI$1(this));
        this.categoryAdapter = new SFCategoryAdapter(this, this);
        Context context = this;
        this.categoryItemAdapter = new SFCategoryItemAdapter(context, this.gaHandler);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvCategory);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            SFCategoryAdapter sFCategoryAdapter = this.categoryAdapter;
            if (sFCategoryAdapter == null) {
                k.a("categoryAdapter");
            }
            recyclerView.setAdapter(sFCategoryAdapter);
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rvCategoryItems);
        if (recyclerView2 != null) {
            SFCategoryItemAdapter sFCategoryItemAdapter = this.categoryItemAdapter;
            if (sFCategoryItemAdapter == null) {
                k.a("categoryItemAdapter");
            }
            recyclerView2.setAdapter(sFCategoryItemAdapter);
            recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        }
        ((TextView) _$_findCachedViewById(R.id.txv_search_paytm)).setOnClickListener(new SFBrowseCategoryActivity$initUI$4(this));
        ((ImageView) _$_findCachedViewById(R.id.crossBtn)).setOnClickListener(new SFBrowseCategoryActivity$initUI$5(this));
    }

    /* access modifiers changed from: private */
    public final void handleResponse(Resource<List<View>> resource) {
        String stringExtra;
        List list;
        if (resource.getStatus() == Status.FAIL) {
            if (resource.getRequestType() == RequestType.REFRESH || !com.paytm.utility.b.c(getApplicationContext())) {
                android.view.View _$_findCachedViewById = _$_findCachedViewById(R.id.top_bar);
                k.a((Object) _$_findCachedViewById, "top_bar");
                _$_findCachedViewById.setVisibility(8);
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvCategory);
                k.a((Object) recyclerView, "rvCategory");
                recyclerView.setVisibility(8);
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rvCategoryItems);
                k.a((Object) recyclerView2, "rvCategoryItems");
                recyclerView2.setVisibility(8);
                showHideProgressBar(false);
                showHideNoNetworkLayout(true);
            }
        } else if (resource.getStatus() == Status.SUCCESS) {
            android.view.View _$_findCachedViewById2 = _$_findCachedViewById(R.id.top_bar);
            k.a((Object) _$_findCachedViewById2, "top_bar");
            _$_findCachedViewById2.setVisibility(0);
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.rvCategory);
            k.a((Object) recyclerView3, "rvCategory");
            recyclerView3.setVisibility(0);
            RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(R.id.rvCategoryItems);
            k.a((Object) recyclerView4, "rvCategoryItems");
            recyclerView4.setVisibility(0);
            this.categoriesList.clear();
            this.categoriesMap.clear();
            List<View> data = resource.getData();
            k.a((Object) data, "responseData.data");
            int size = data.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((View) resource.getData().get(i2)).getmViewTag() != null) {
                    HashMap<String, List<View>> hashMap = this.categoriesMap;
                    String str = ((View) resource.getData().get(i2)).getmViewTag();
                    k.a((Object) str, "responseData.data[i].getmViewTag()");
                    if (str != null) {
                        String lowerCase = str.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (hashMap.get(lowerCase) == null) {
                            list = new ArrayList();
                            this.categoriesList.add(((View) resource.getData().get(i2)).getmViewTag());
                        } else {
                            HashMap<String, List<View>> hashMap2 = this.categoriesMap;
                            String str2 = ((View) resource.getData().get(i2)).getmViewTag();
                            k.a((Object) str2, "responseData.data[i].getmViewTag()");
                            if (str2 != null) {
                                String lowerCase2 = str2.toLowerCase();
                                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                list = hashMap2.get(lowerCase2);
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        if (list != null) {
                            list.add(resource.getData().get(i2));
                            HashMap<String, List<View>> hashMap3 = this.categoriesMap;
                            String str3 = ((View) resource.getData().get(i2)).getmViewTag();
                            k.a((Object) str3, "responseData.data[i].getmViewTag()");
                            if (str3 != null) {
                                String lowerCase3 = str3.toLowerCase();
                                k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
                                hashMap3.put(lowerCase3, list);
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            continue;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            SFCategoryAdapter sFCategoryAdapter = this.categoryAdapter;
            if (sFCategoryAdapter == null) {
                k.a("categoryAdapter");
            }
            sFCategoryAdapter.updateList(this.categoriesList);
            try {
                if (getIntent().hasExtra(this.KEY_CATEGORY) && (stringExtra = getIntent().getStringExtra(this.KEY_CATEGORY)) != null) {
                    int size2 = this.categoriesList.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        String str4 = this.categoriesList.get(i3);
                        k.a((Object) str4, "categoriesList[i]");
                        String str5 = str4;
                        if (str5 != null) {
                            String lowerCase4 = str5.toLowerCase();
                            k.a((Object) lowerCase4, "(this as java.lang.String).toLowerCase()");
                            if (stringExtra != null) {
                                String lowerCase5 = stringExtra.toLowerCase();
                                k.a((Object) lowerCase5, "(this as java.lang.String).toLowerCase()");
                                if (k.a((Object) lowerCase4, (Object) lowerCase5)) {
                                    this.INITIAL_POSITION = i3;
                                }
                                i3++;
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
            } catch (Exception unused) {
                this.INITIAL_POSITION = 0;
            }
            showHideProgressBar(false);
            showHideNoNetworkLayout(false);
            if (this.INITIAL_POSITION >= 0) {
                SFCategoryAdapter sFCategoryAdapter2 = this.categoryAdapter;
                if (sFCategoryAdapter2 == null) {
                    k.a("categoryAdapter");
                }
                sFCategoryAdapter2.updateSelectedPosition(this.INITIAL_POSITION);
                SFCategoryAdapter sFCategoryAdapter3 = this.categoryAdapter;
                if (sFCategoryAdapter3 == null) {
                    k.a("categoryAdapter");
                }
                sFCategoryAdapter3.updateList(this.categoriesList);
                HashMap<String, List<View>> hashMap4 = this.categoriesMap;
                String str6 = this.categoriesList.get(this.INITIAL_POSITION);
                k.a((Object) str6, "categoriesList[INITIAL_POSITION]");
                String str7 = str6;
                if (str7 != null) {
                    String lowerCase6 = str7.toLowerCase();
                    k.a((Object) lowerCase6, "(this as java.lang.String).toLowerCase()");
                    if (hashMap4.get(lowerCase6) != null) {
                        SFCategoryItemAdapter sFCategoryItemAdapter = this.categoryItemAdapter;
                        if (sFCategoryItemAdapter == null) {
                            k.a("categoryItemAdapter");
                        }
                        HashMap<String, List<View>> hashMap5 = this.categoriesMap;
                        String str8 = this.categoriesList.get(this.INITIAL_POSITION);
                        k.a((Object) str8, "categoriesList[INITIAL_POSITION]");
                        String str9 = str8;
                        if (str9 != null) {
                            String lowerCase7 = str9.toLowerCase();
                            k.a((Object) lowerCase7, "(this as java.lang.String).toLowerCase()");
                            List<View> list2 = hashMap5.get(lowerCase7);
                            if (list2 != null) {
                                sFCategoryItemAdapter.updateList((ArrayList) list2);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View> */");
                        }
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                    SFCategoryItemAdapter sFCategoryItemAdapter2 = this.categoryItemAdapter;
                    if (sFCategoryItemAdapter2 == null) {
                        k.a("categoryItemAdapter");
                    }
                    sFCategoryItemAdapter2.updateList(new ArrayList());
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    private final void showHideNoNetworkLayout(boolean z) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.sfNoNetwork);
        k.a((Object) constraintLayout, "sfNoNetwork");
        constraintLayout.setVisibility(z ? 0 : 8);
    }

    private final void showHideProgressBar(boolean z) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.progressLottie);
        k.a((Object) lottieAnimationView, "progressLottie");
        lottieAnimationView.setVisibility(z ? 0 : 8);
    }

    public final void onCategoryClick(String str, int i2) {
        k.c(str, "category");
        SFCategoryAdapter sFCategoryAdapter = this.categoryAdapter;
        if (sFCategoryAdapter == null) {
            k.a("categoryAdapter");
        }
        sFCategoryAdapter.updateSelectedPosition(i2);
        SFCategoryItemAdapter sFCategoryItemAdapter = this.categoryItemAdapter;
        if (sFCategoryItemAdapter == null) {
            k.a("categoryItemAdapter");
        }
        HashMap<String, List<View>> hashMap = this.categoriesMap;
        String lowerCase = str.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        ArrayList arrayList = (ArrayList) hashMap.get(lowerCase);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        sFCategoryItemAdapter.updateList(arrayList);
        sendGAForCategoryClick(str, i2 + 1);
    }

    private final void sendGAForCategoryClick(String str, int i2) {
        ICLPCommunicationListener communicationListener;
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("event_category", CLPConstants.GTM_KEY_SHOW_MORE_CLICKED);
        map.put("event_action", str);
        map.put("event_label", Integer.valueOf(i2));
        CLPArtifact instance = CLPArtifact.getInstance();
        if (instance != null && (communicationListener = instance.getCommunicationListener()) != null) {
            communicationListener.sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, getApplicationContext());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        r11 = (com.paytmmall.clpartifact.modal.clpCommon.ViewDataSource) kotlin.a.k.a(r11, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fireImpression(com.paytmmall.clpartifact.modal.clpCommon.View r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM r0 = r10.viewModel
            if (r0 != 0) goto L_0x0010
            java.lang.String r1 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0010:
            boolean r0 = r0.isFromCache()
            if (r0 != 0) goto L_0x0044
            com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment$Companion r1 = com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment.Companion
            java.util.List r0 = r11.getItems()
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r3 = r10
            android.content.Context r3 = (android.content.Context) r3
            java.util.ArrayList r11 = r11.getDataSources()
            if (r11 == 0) goto L_0x0038
            java.util.List r11 = (java.util.List) r11
            r0 = 0
            java.lang.Object r11 = kotlin.a.k.a(r11, (int) r0)
            com.paytmmall.clpartifact.modal.clpCommon.ViewDataSource r11 = (com.paytmmall.clpartifact.modal.clpCommon.ViewDataSource) r11
            if (r11 == 0) goto L_0x0038
            java.lang.String r11 = r11.getContainerInstanceId()
            goto L_0x0039
        L_0x0038:
            r11 = 0
        L_0x0039:
            r4 = r11
            r7 = 0
            r8 = 32
            r9 = 0
            java.lang.String r5 = "/-category-icons"
            r6 = r12
            com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment.Companion.sendImpressionEvent$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.activity.SFBrowseCategoryActivity.fireImpression(com.paytmmall.clpartifact.modal.clpCommon.View, int):void");
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        super.attachBaseContext(instance.getCommunicationListener().getBaseContext(context));
    }
}
