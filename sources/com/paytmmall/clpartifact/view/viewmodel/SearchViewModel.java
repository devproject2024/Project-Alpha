package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.gson.f;
import com.google.gson.o;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.extension.StringExtensionKt;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.SearchCostants;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.util.HashMap;

public class SearchViewModel extends BaseViewModel {
    private HashMap<String, String> contextParams;
    private y<String> enteredText = new y<>();
    private w<Integer> searchButtonHandler = new w<>();
    private y<Item> searchData = new y<>();
    private w<Integer> showNoSearchResult = new w<>();

    private void doGAWork(CJRGrid cJRGrid) {
    }

    private void doOrganicGAWork(CJRGrid cJRGrid) {
    }

    public y<String> getEnteredText() {
        return this.enteredText;
    }

    public SearchViewModel(Application application) {
        super(application);
        this.searchButtonHandler.addSource(this.enteredText, new z() {
            public final void onChanged(Object obj) {
                SearchViewModel.this.lambda$new$0$SearchViewModel((String) obj);
            }
        });
        this.showNoSearchResult.addSource(this.enteredText, new z() {
            public final void onChanged(Object obj) {
                SearchViewModel.this.lambda$new$1$SearchViewModel((String) obj);
            }
        });
        this.enteredText.setValue("");
        this.showNoSearchResult.setValue(8);
    }

    public /* synthetic */ void lambda$new$0$SearchViewModel(String str) {
        int i2 = 0;
        boolean z = str == null || TextUtils.isEmpty(str.trim());
        w<Integer> wVar = this.searchButtonHandler;
        if (z) {
            i2 = 8;
        }
        wVar.setValue(Integer.valueOf(i2));
    }

    public /* synthetic */ void lambda$new$1$SearchViewModel(String str) {
        if (this.showNoSearchResult.getValue() != null && this.showNoSearchResult.getValue().intValue() == 0) {
            this.showNoSearchResult.setValue(8);
        }
    }

    public void handleBackPress() {
        redirect(new RedirectorModel(1005, new HashMap()));
    }

    public w<Integer> getSearchButtonHandler() {
        return this.searchButtonHandler;
    }

    public void handleButtonClick(String str) {
        if (getSearchDataValue() == null || StringExtensionKt.isEmptyOrNull(getSearchDataValue().getSeourl())) {
            showNoResultsView((CJRGrid) null);
            return;
        }
        redirect(new RedirectorModel(IuserActions.HIDE_KEYBOARD));
        String trim = str.trim();
        String searchUrl = getSearchUrl(UrlUtils.appendSiteIdToUrl(getApplication(), getSearchDataValue().getSeourl()), trim, getContextParams());
        new CLPRepository().search(searchUrl, getSearchMap(), new CLPRepository.ISuccessResponseListener(trim, searchUrl) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onSuccess(String str, o oVar) {
                SearchViewModel.this.lambda$handleButtonClick$2$SearchViewModel(this.f$1, this.f$2, str, oVar);
            }
        }, new CLPRepository.IErrorResponseListener() {
            public final void onError(String str) {
                SearchViewModel.this.handleErrorResponse(str);
            }
        });
    }

    public /* synthetic */ void lambda$handleButtonClick$2$SearchViewModel(String str, String str2, String str3, o oVar) {
        handleSuccessResponse(str3, str, str2);
    }

    private HashMap<String, String> getContextParams() {
        return this.contextParams;
    }

    private void handleSuccessResponse(String str, final String str2, final String str3) {
        final CJRGrid cJRGrid = (CJRGrid) new f().a(str, CJRGrid.class);
        if (cJRGrid == null) {
            return;
        }
        if (SearchCostants.SEARCH_CURATED.equalsIgnoreCase(cJRGrid.getResultType())) {
            if (cJRGrid.getAppUrl() == null || TextUtils.isEmpty(cJRGrid.getAppUrl())) {
                showNoResultsView(cJRGrid);
                return;
            }
            doGAWork(cJRGrid);
            redirect(new RedirectorModel(1004, new HashMap<String, Object>() {
                {
                    put("deeplink", cJRGrid.getAppUrl());
                }
            }));
        } else if (cJRGrid.getGridLayout() == null || cJRGrid.getGridLayout().size() == 0 || cJRGrid.getResultType() == null) {
            showNoResultsView(cJRGrid);
        } else {
            doOrganicGAWork(cJRGrid);
            redirect(new RedirectorModel(1007, new HashMap<String, Object>() {
                {
                    put(CLPConstants.DEFAULT_GRID_VIEW_TYPE, cJRGrid);
                    put("query", str2);
                    put("url", str3);
                }
            }));
        }
    }

    private void showNoResultsView(CJRGrid cJRGrid) {
        this.showNoSearchResult.setValue(0);
        this.searchButtonHandler.setValue(8);
    }

    /* access modifiers changed from: private */
    public void handleErrorResponse(String str) {
        String string = getApplication().getResources().getString(R.string.sf_network_error_message);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        Toast.makeText(getApplication().getApplicationContext(), str, 0).show();
    }

    private HashMap<String, String> getSearchMap() {
        return new HashMap<String, String>() {
            {
                put(AppConstants.SSO_TOKEN, CLPArtifact.getInstance().getCommunicationListener().getSSOToken(SearchViewModel.this.getApplication()));
            }
        };
    }

    private String getSearchUrl(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                buildUpon.appendQueryParameter(next, String.valueOf(hashMap.get(next)));
            }
        }
        return buildUpon.appendQueryParameter(SearchCostants.SEARCH_URL_SUFFIX, str2).appendQueryParameter("from", "organic").appendQueryParameter(SearchCostants.SEARCH_CAT_TREE, "1").appendQueryParameter(SearchCostants.SEARCH_CURATED, "1").appendQueryParameter("page_count", "1").appendQueryParameter("items_per_page", "16").build().toString();
    }

    public void setContextParams(HashMap<String, String> hashMap) {
        this.contextParams = hashMap;
    }

    public w<Integer> getShowNoSearchResult() {
        return this.showNoSearchResult;
    }

    public Item getSearchDataValue() {
        return this.searchData.getValue();
    }

    public void setSearchDataValue(Item item) {
        this.searchData.setValue(item);
    }
}
