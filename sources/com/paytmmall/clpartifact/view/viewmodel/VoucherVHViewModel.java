package com.paytmmall.clpartifact.view.viewmodel;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.repositories.VoucherRepository;
import com.paytmmall.clpartifact.utils.UrlUtils;
import java.util.ArrayList;

public class VoucherVHViewModel extends a {
    private Context context;
    private boolean hasMoreData = true;
    private ObservableBoolean isCollapsed = new ObservableBoolean();
    private boolean isRequesting = false;
    private String mUrl;
    private SingleEventLiveData<Resource<ArrayList<CJRGridProduct>>> mVoucherLiveData = new SingleEventLiveData<>();
    private VoucherRepository mVoucherRepo;
    private ArrayList<CJRGridProduct> mVouchers = new ArrayList<>();
    private int pageNumber = 1;
    private ObservableInt slider = new ObservableInt(8);

    public VoucherVHViewModel(Context context2) {
        this.context = context2;
        this.mVoucherRepo = new VoucherRepository(context2);
        observeLivedata();
    }

    public ObservableBoolean getIsCollapsed() {
        return this.isCollapsed;
    }

    private void observeLivedata() {
        this.mVoucherLiveData.addSource(this.mVoucherRepo.getVoucherLiveData(), new z() {
            public final void onChanged(Object obj) {
                VoucherVHViewModel.this.lambda$observeLivedata$0$VoucherVHViewModel((Resource) obj);
            }
        });
    }

    /* renamed from: com.paytmmall.clpartifact.view.viewmodel.VoucherVHViewModel$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$paytmmall$clpartifact$network$Status = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.paytmmall.clpartifact.network.Status[] r0 = com.paytmmall.clpartifact.network.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$paytmmall$clpartifact$network$Status = r0
                int[] r0 = $SwitchMap$com$paytmmall$clpartifact$network$Status     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.PROGRESS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$paytmmall$clpartifact$network$Status     // Catch:{ NoSuchFieldError -> 0x001f }
                com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$paytmmall$clpartifact$network$Status     // Catch:{ NoSuchFieldError -> 0x002a }
                com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.FAIL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewmodel.VoucherVHViewModel.AnonymousClass1.<clinit>():void");
        }
    }

    public /* synthetic */ void lambda$observeLivedata$0$VoucherVHViewModel(Resource resource) {
        if (resource != null) {
            int i2 = AnonymousClass1.$SwitchMap$com$paytmmall$clpartifact$network$Status[resource.getStatus().ordinal()];
            if (i2 == 1) {
                this.mVoucherLiveData.setValue(Resource.progress(resource.getRequestType()));
            } else if (i2 == 2) {
                this.hasMoreData = ((CJRGrid) resource.getData()).getHasMore();
                setCollapsed(this.hasMoreData);
                this.mVoucherLiveData.setValue(Resource.success(((CJRGrid) resource.getData()).getGridLayout()).setRequestType(resource.getRequestType()));
                this.isRequesting = false;
                incrementPageNumber();
            } else if (i2 == 3) {
                this.mVoucherLiveData.setValue(Resource.error(resource.getError()));
                this.isRequesting = false;
            }
        }
    }

    public void loadVoucher(RequestType requestType) {
        if (!this.isRequesting) {
            if (requestType == RequestType.REFRESH || requestType == RequestType.FRESH) {
                resetPageNumber();
            }
            this.isRequesting = true;
            this.mVoucherLiveData.setValue(Resource.progress(requestType));
            this.mVoucherRepo.loadVoucher(getAbsoluteGridURL(), requestType);
        }
    }

    private String getAbsoluteGridURL() {
        return UrlUtils.appendGridQueryParameter(UrlUtils.appendGridQueryParameter(UrlUtils.appendGridQueryParameter(UrlUtils.appendChildSiteId(CLPArtifact.getInstance().getCommunicationListener().getDefaultParams(this.context.getApplicationContext(), this.mUrl)), AppConstants.TAG_LANG_ID, CLPArtifact.getInstance().getCommunicationListener().getLangId(this.context.getApplicationContext())), "page_count", this.pageNumber), "items_per_page", 16);
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void incrementPageNumber() {
        this.pageNumber++;
    }

    public void resetPageNumber() {
        this.pageNumber = 1;
    }

    public ArrayList<CJRGridProduct> getVouchers() {
        return this.mVouchers;
    }

    public LiveData<Resource<ArrayList<CJRGridProduct>>> getVoucherLiveData() {
        return this.mVoucherLiveData;
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public boolean hasMoreData() {
        return this.hasMoreData;
    }

    public boolean setUrl(String str) {
        String str2 = this.mUrl;
        if (str2 != null && str2.equalsIgnoreCase(str)) {
            return false;
        }
        this.mUrl = str;
        loadVoucher(RequestType.REFRESH);
        return true;
    }

    public void setCollapsed(boolean z) {
        this.isCollapsed.set(z);
        setSlider(z ? 8 : 0);
    }

    private void setSlider(int i2) {
        this.slider.set(i2);
        notifyChange();
    }

    public ObservableInt getSlider() {
        return this.slider;
    }
}
