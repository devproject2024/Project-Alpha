package com.paytmmall.clpartifact.view.fragment;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.databinding.ClpActivitySearchBinding;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.KeyboardUtils;
import com.paytmmall.clpartifact.view.viewmodel.SearchViewModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;

public class SearchActivity extends PaytmActivity {
    private SearchViewModel searchViewModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-7829368);
        }
        createViewModel();
        ClpActivitySearchBinding clpActivitySearchBinding = (ClpActivitySearchBinding) f.a(this, R.layout.clp_activity_search);
        clpActivitySearchBinding.setLifecycleOwner(this);
        clpActivitySearchBinding.setView(getView());
        clpActivitySearchBinding.setViewModel(this.searchViewModel);
        SearchViewModel searchViewModel2 = this.searchViewModel;
        if (searchViewModel2 != null) {
            searchViewModel2.setRedirectorObserver(this, new z() {
                public final void onChanged(Object obj) {
                    SearchActivity.this.handleRedirection((RedirectorModel) obj);
                }
            });
            setSearchDataInVM();
        }
    }

    private void setSearchDataInVM() {
        if (getIntent().getExtras().containsKey(SearchFragment.ARG_SEARCH_DATA) && getIntent().getExtras().get(SearchFragment.ARG_SEARCH_DATA) != null) {
            this.searchViewModel.setSearchDataValue((Item) getIntent().getExtras().get(SearchFragment.ARG_SEARCH_DATA));
        }
    }

    /* access modifiers changed from: protected */
    public void handleRedirection(RedirectorModel redirectorModel) {
        if (redirectorModel == null) {
            return;
        }
        if (redirectorModel.getRequest() == 1005) {
            finish();
        } else if (redirectorModel.getRequest() == 1004) {
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(this, getItem(redirectorModel.getDataMap()));
            finish();
        } else if (redirectorModel.getRequest() == 1007) {
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(this, getDataItem(redirectorModel.getDataMap()));
            finish();
        } else if (redirectorModel.getRequest() == 1011) {
            KeyboardUtils.hideKeyBoard(this);
        }
    }

    private Item getDataItem(Map<String, Object> map) {
        Item item = new Item();
        if (map.containsKey(CLPConstants.DEFAULT_GRID_VIEW_TYPE)) {
            map.get(CLPConstants.DEFAULT_GRID_VIEW_TYPE);
        }
        String str = "";
        String valueOf = map.containsKey("query") ? String.valueOf(map.get("query")) : str;
        if (map.containsKey("url")) {
            str = String.valueOf(map.get("url"));
        }
        item.setUrl(str);
        item.setUrlType(CLPConstants.DEFAULT_GRID_VIEW_TYPE);
        item.setSearchQuery(valueOf);
        return item;
    }

    private Item getItem(Map<String, Object> map) {
        String valueOf = map.containsKey("deeplink") ? String.valueOf(map.get("deeplink")) : "";
        Uri parse = Uri.parse(valueOf);
        Item item = new Item();
        item.setUrlType(parse.getHost());
        item.setUrl(valueOf);
        return item;
    }

    private void createViewModel() {
        this.searchViewModel = (SearchViewModel) am.a((FragmentActivity) this).a(SearchViewModel.class);
        try {
            this.searchViewModel.setContextParams(getIntent().hasExtra(SearchFragment.ARG_CLP_CONTEXT_PARAMS) ? (HashMap) getIntent().getSerializableExtra(SearchFragment.ARG_CLP_CONTEXT_PARAMS) : new HashMap());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private View getView() {
        if (getIntent() == null || !getIntent().hasExtra(SearchFragment.ARG_STORE_DATA)) {
            return null;
        }
        return (View) getIntent().getSerializableExtra(SearchFragment.ARG_STORE_DATA);
    }
}
