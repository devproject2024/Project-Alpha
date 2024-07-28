package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.o;
import com.google.gson.q;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.navigator.VariantBottomSheetNavigator;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.repositories.VariantBottomSheetRepository;
import com.paytmmall.clpartifact.threading.Task;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;

public class VariantBottomSheetViewModel extends NavigableViewModel<VariantBottomSheetNavigator> implements VariantBottomSheetRepository.OnSuccessListener {
    private String gridUrl;
    private int lastUpdatedItemIndex = -1;
    private CLPRepository mCLPRepository;
    private CJRGrid mCjrGrid;
    private VariantBottomSheetRepository mRepository;
    private o mResponse;
    private ArrayList<CJRGridProduct> mVariantItems = new ArrayList<>();
    private String parentId;
    private String productId;
    private String renderUrl;
    private String variantLabel;
    private String variantValue;

    public VariantBottomSheetViewModel(Application application) {
        super(application);
        this.mRepository = new VariantBottomSheetRepository(application);
        this.mRepository.setListener(this);
        this.mCLPRepository = new CLPRepository();
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getGridUrl() {
        return this.gridUrl;
    }

    public String getRenderUrl() {
        return this.renderUrl;
    }

    public ArrayList<CJRGridProduct> getVariantItems() {
        return this.mVariantItems;
    }

    public void setNavigator(VariantBottomSheetNavigator variantBottomSheetNavigator) {
        super.setNavigator(variantBottomSheetNavigator);
        this.mRepository.setNavigator(getNavigatorRef());
    }

    public void setLastUpdatedItemIndex(int i2) {
        this.lastUpdatedItemIndex = i2;
    }

    public int getLastUpdatedItemIndex() {
        return this.lastUpdatedItemIndex;
    }

    public void addItemToCart(long j, int i2) {
        this.mCLPRepository.addItemToCart(getApplication(), j, i2);
    }

    public void removeItemFromCart(long j) {
        this.mCLPRepository.removeItemFromCart(getApplication(), j);
    }

    public void updateCart(long j, int i2) {
        this.mCLPRepository.updateCart(getApplication(), j, i2);
    }

    public void loadSheet() {
        this.mRepository.loadSheetData(getAbsUrl(), getGroupId());
    }

    private long getGroupId() {
        if (TextUtils.isEmpty(this.renderUrl) || !this.renderUrl.contains("?")) {
            return Long.parseLong(this.productId);
        }
        String str = this.renderUrl.split("\\?")[1];
        if (TextUtils.isEmpty(str)) {
            return Long.parseLong(this.productId);
        }
        if (CLPConstants.PARENT_ID.equalsIgnoreCase(getGroupKey(str, "products.group_id"))) {
            return Long.parseLong(this.parentId);
        }
        return Long.parseLong(this.productId);
    }

    private String getGroupKey(String str, String str2) {
        int indexOf = str.indexOf(str2) + str2.length() + 1;
        StringBuilder sb = new StringBuilder();
        while (indexOf < str.length() && str.charAt(indexOf) != '&') {
            sb.append(str.charAt(indexOf));
            indexOf++;
        }
        return sb.toString();
    }

    private String getAbsUrl() {
        if (TextUtils.isEmpty(this.renderUrl)) {
            return this.renderUrl;
        }
        if (TextUtils.isEmpty(this.gridUrl) || !this.gridUrl.contains("?")) {
            return this.renderUrl.split("\\?")[0];
        }
        this.renderUrl.split("\\?");
        return this.renderUrl.split("\\?")[0] + "?" + this.gridUrl.split("\\?")[1];
    }

    public void setData(Bundle bundle) {
        if (bundle != null) {
            this.parentId = bundle.getString(CLPConstants.PARENT_ID);
            this.productId = bundle.getString(CLPConstants.PRODUCT_ID);
            this.gridUrl = bundle.getString(CLPConstants.GRID_URL);
            this.renderUrl = bundle.getString(CLPConstants.RENDER_URL);
            this.variantLabel = bundle.getString(CLPConstants.VARIANT_LABEL);
        }
    }

    public void onSuccessVariant(String str) {
        Task.runOnComputation(new Runnable(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                VariantBottomSheetViewModel.this.lambda$onSuccessVariant$1$VariantBottomSheetViewModel(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onSuccessVariant$1$VariantBottomSheetViewModel(String str) {
        this.mCjrGrid = (CJRGrid) new f().a(str, CJRGrid.class);
        setParams(str);
        Task.runOnMainThread(new Runnable() {
            public final void run() {
                VariantBottomSheetViewModel.this.lambda$null$0$VariantBottomSheetViewModel();
            }
        });
    }

    public /* synthetic */ void lambda$null$0$VariantBottomSheetViewModel() {
        if (getNavigator() != null) {
            ((VariantBottomSheetNavigator) getNavigator()).onSuccess(hasVariant() ? this.mCjrGrid.getGridLayout().get(0).getVariant().getItems() : new ArrayList<>());
        }
    }

    private void setParams(String str) {
        try {
            new q();
            this.mResponse = q.a(str).h();
            i d2 = this.mResponse.b("grid_layout").i().a(0).h().e("variants").d("items");
            for (int i2 = 0; i2 < d2.a(); i2++) {
                this.mCjrGrid.getGridLayout().get(0).getVariant().getItems().get(i2).setVariantValue(d2.a(i2).h().e(CLPConstants.ATTRIBUTE).b(this.variantLabel).c());
            }
        } catch (IllegalStateException | IndexOutOfBoundsException | NullPointerException | UnsupportedOperationException unused) {
        }
    }

    public String getProductUrl() {
        try {
            return this.mCjrGrid.getGridLayout().get(0).getUrl();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public String getUrlType() {
        try {
            return this.mCjrGrid.getGridLayout().get(0).getUrlType();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public CJRGridProduct getProduct() {
        try {
            return this.mCjrGrid.getGridLayout().get(0);
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return null;
        }
    }

    public String getVariantLabel() {
        return this.variantLabel;
    }

    private String getParsedLabel() {
        try {
            return this.mCjrGrid.getGridLayout().get(0).getVariant().getDimensions().get(0).getLabel();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public String getProductImage() {
        try {
            return this.mCjrGrid.getGridLayout().get(0).getImageUrl();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public String getProductName() {
        try {
            return this.mCjrGrid.getGridLayout().get(0).getName();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    private boolean hasVariant() {
        try {
            return !this.mCjrGrid.getGridLayout().get(0).getVariant().getItems().isEmpty();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return false;
        }
    }

    public void onAddToCart(int i2) {
        if (i2 < this.mVariantItems.size()) {
            long parseLong = Long.parseLong(this.mVariantItems.get(i2).getProductID());
            if (CartUtils.hasItemWithId(parseLong)) {
                this.mCLPRepository.updateCart(getApplication(), parseLong, CartUtils.itemCountInCart(parseLong) + 1);
            } else {
                this.mCLPRepository.addItemToCart(getApplication(), parseLong, 1);
            }
        }
    }

    public void onRemoveFromCart(int i2) {
        if (i2 < this.mVariantItems.size()) {
            long parseLong = Long.parseLong(this.mVariantItems.get(i2).getProductID());
            if (CartUtils.itemCountInCart(parseLong) > 1) {
                this.mCLPRepository.updateCart(getApplication(), parseLong, CartUtils.itemCountInCart(parseLong) - 1);
            } else {
                this.mCLPRepository.removeItemFromCart(getApplication(), parseLong);
            }
        }
    }

    public boolean isItemInStock() {
        try {
            return this.mCjrGrid.getGridLayout().get(0).isInStock();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return false;
        }
    }
}
