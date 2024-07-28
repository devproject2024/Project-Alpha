package com.business.merchant_payments.requestmoney;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.f;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import com.business.common_module.c;
import com.business.common_module.d.a;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.c;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.BaseFragment;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.databinding.MpFragmentRequestMoneyBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.requestpayment.CreateLinkModel;
import com.business.merchant_payments.model.requestpayment.MessageBundle;
import com.business.merchant_payments.model.requestpayment.PaymentLinkData;
import com.business.merchant_payments.requestmoney.LocationPermissionBottomSheet;
import com.business.merchant_payments.requestmoney.RequestMoneyLinkAdapter;
import com.business.merchant_payments.utility.BusinessShareUtility;
import com.business.merchant_payments.utility.LocationLiveData;
import com.business.merchant_payments.utility.NetworkService;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentLinkFragment extends BaseFragment implements a, LocationPermissionBottomSheet.IShowLocationPrompt, RequestMoneyLinkAdapter.RequestMoneyLinkListner {
    public static final String LOCATION_PERMISSION_BOTTOMSHEET = "mp_location_permission_bottomsheet";
    public static final int PAGE_SIZE = 10;
    public static final int REQUEST_CODE_CREATE_LINK = 101;
    public CoordinatorLayout coordinatorLayout;
    public int currentPage = 1;
    public boolean isEndofList = false;
    public boolean isLoading = true;
    public boolean isPagingstarted = false;
    public String linkAmount;
    public String linkDescription;
    public Activity mActivity;
    public RequestMoneyLinkAdapter mAdapter;
    public MpFragmentRequestMoneyBinding mBinding;
    public RecyclerView mRecyclerView;
    public Snackbar networkSnackbar;

    public void initUI() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void switchTabFragment() {
        RequestMoneyLinkAdapter requestMoneyLinkAdapter = this.mAdapter;
        if (requestMoneyLinkAdapter != null && requestMoneyLinkAdapter.getItemCount() > 0) {
            this.mAdapter.notifyItemChanged(0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MpFragmentRequestMoneyBinding mpFragmentRequestMoneyBinding = (MpFragmentRequestMoneyBinding) f.a(layoutInflater, R.layout.mp_fragment_request_money, viewGroup, false);
        this.mBinding = mpFragmentRequestMoneyBinding;
        initView(mpFragmentRequestMoneyBinding.getRoot());
        fetchReceivedList();
        return this.mBinding.getRoot();
    }

    private void initView(View view) {
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.merhcant_link_rv);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setHasFixedSize(true);
        ArrayList arrayList = new ArrayList();
        if (PaymentsConfig.getInstance().getMerchantDataProvider().f()) {
            arrayList.add("HEADER");
        }
        RequestMoneyLinkAdapter requestMoneyLinkAdapter = new RequestMoneyLinkAdapter(getActivity(), arrayList, this);
        this.mAdapter = requestMoneyLinkAdapter;
        this.mRecyclerView.setAdapter(requestMoneyLinkAdapter);
        this.mAdapter.setShowDotProgress(true);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.l() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
            }

            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int childCount = linearLayoutManager.getChildCount();
                int itemCount = linearLayoutManager.getItemCount();
                if (!PaymentLinkFragment.this.isLoading && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition > 0 && !PaymentLinkFragment.this.isEndofList) {
                    PaymentLinkFragment.this.loadMoreItems();
                }
            }
        });
        ((y) this.mRecyclerView.getItemAnimator()).m = false;
        this.coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.request_money_container_cl);
        if (AppUtility.isEdcFlavour().booleanValue()) {
            initLocationManager();
        }
    }

    private void initLocationManager() {
        new c(getContext(), this);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    public void onResume() {
        super.onResume();
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Payment Link/Request Money");
    }

    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }

    private void createMerchantPaymentLink(String str, String str2) {
        String paymentLinkDashboardUrlV1 = GTMDataProviderImpl.Companion.getMInstance().getPaymentLinkDashboardUrlV1();
        HashMap<String, Object> headers = RequestParamUtil.getHeaders(getActivity());
        addLocationHeaderToRequest(headers);
        String createLinkRequestBody = getCreateLinkRequestBody(str, str2);
        showProgressDialog(this.mContext);
        PaymentsConfig.getInstance().getNetworkService().createMerchantPaymentLink(paymentLinkDashboardUrlV1, RequestParamUtil.getRequestBody(createLinkRequestBody), headers).enqueue(new Callback<CreateLinkModel>() {
            public void onResponse(Call<CreateLinkModel> call, Response<CreateLinkModel> response) {
                PaymentLinkFragment.this.removeProgressDialog();
                if (PaymentLinkFragment.this.mActivity != null) {
                    PaymentLinkFragment.this.mActivity.getFragmentManager().executePendingTransactions();
                    if (!PaymentLinkFragment.this.isAdded() || PaymentLinkFragment.this.isStateSaved()) {
                        return;
                    }
                }
                if (!response.isSuccessful() || response.body() == null) {
                    Toast.makeText(PaymentLinkFragment.this.getActivity(), PaymentLinkFragment.this.getString(R.string.mp_oops_something_wrong_msg), 1).show();
                    return;
                }
                CreateLinkModel body = response.body();
                if (!TextUtils.isEmpty(body.getShortUrl())) {
                    PaymentLinkFragment.this.clearTextFields();
                    Intent intent = new Intent(PaymentLinkFragment.this.getActivity(), RequestMoneyQRActivity.class);
                    intent.putExtra(AppConstants.KEY_DATA_PAYMENT_LINK, body);
                    PaymentLinkFragment.this.startActivityForResult(intent, 101);
                    return;
                }
                String string = PaymentLinkFragment.this.getString(R.string.mp_oops_something_wrong_msg);
                if (body.getResultInfo() != null && !TextUtils.isEmpty(body.getResultInfo().getResultMessage())) {
                    string = body.getResultInfo().getResultMessage();
                }
                Toast.makeText(PaymentLinkFragment.this.getActivity(), string, 1).show();
            }

            public void onFailure(Call<CreateLinkModel> call, Throwable th) {
                if (PaymentLinkFragment.this.mActivity != null) {
                    PaymentLinkFragment.this.mActivity.getFragmentManager().executePendingTransactions();
                    if (!PaymentLinkFragment.this.isAdded() || PaymentLinkFragment.this.isStateSaved()) {
                        return;
                    }
                }
                PaymentLinkFragment.this.removeProgressDialog();
                if (i.a(PaymentsConfig.getInstance().getApplication())) {
                    Toast.makeText(PaymentLinkFragment.this.getActivity(), PaymentLinkFragment.this.getString(R.string.mp_oops_something_wrong_msg), 1).show();
                }
            }
        });
    }

    private void addLocationHeaderToRequest(Map<String, Object> map) {
        String longitude = APSharedPreferences.getInstance().getLongitude(this.mContext);
        String latitude = APSharedPreferences.getInstance().getLatitude(this.mContext);
        c.a aVar = com.business.common_module.utilities.c.f7365a;
        String b2 = c.a.b(this.mContext);
        map.put("latitude", latitude);
        map.put("longitude", longitude);
        map.put("deviceIdentifier", b2);
    }

    private String getCreateLinkRequestBody(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String a2 = i.a(getContext());
        String language = APSharedPreferences.getInstance().getLanguage(getContext());
        String longitude = APSharedPreferences.getInstance().getLongitude(PaymentsConfig.getInstance().getAppContext());
        String latitude = APSharedPreferences.getInstance().getLatitude(PaymentsConfig.getInstance().getAppContext());
        try {
            jSONObject.put("mid", APSharedPreferences.getInstance().getMerchantMid());
            jSONObject.put("amount", str);
            jSONObject.put(AppConstants.TAG_LINK_DESCRIPTION, str2);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject.put(AppConstants.TAG_LINK_NAME, sb.toString());
            jSONObject2.put(AppConstants.TAG_CHILD_SITE_ID, "1");
            jSONObject2.put("deviceManufacturer", AppUtility.getDeviceManufacturer());
            jSONObject2.put("client", AppUtility.getClient());
            jSONObject2.put(AppConstants.TAG_LANG_ID, AppUtility.getLangId(language));
            jSONObject2.put("language", language);
            jSONObject2.put("version", AppUtility.getVersion(PaymentsConfig.getInstance().getAppContext()));
            jSONObject2.put("playStore", AppUtility.isPlayStoreInstall(PaymentsConfig.getInstance().getAppContext()));
            jSONObject2.put(AppConstants.TAG_SITE_ID, "1");
            jSONObject2.put("osVersion", AppUtility.getOSVersion());
            jSONObject2.put("longitude", longitude);
            jSONObject2.put("latitude", latitude);
            jSONObject2.put("deviceName", AppUtility.getDeviceName());
            if (a2 != null && a2.trim().length() > 0) {
                jSONObject2.put("networkType", a2);
            }
            c.a aVar = com.business.common_module.utilities.c.f7365a;
            jSONObject2.put("deviceIdentifier", c.a.b(PaymentsConfig.getInstance().getAppContext()));
            jSONObject.put(AppConstants.TAG_GEOLOCATION_PARAMS, jSONObject2);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private void fetchReceivedList() {
        if (!PaymentsConfig.getInstance().getMerchantDataProvider().e()) {
            this.mBinding.noItemContainer.setVisibility(0);
            this.mAdapter.setShowDotProgress(false);
        } else if (!i.a(PaymentsConfig.getInstance().getApplication())) {
            RequestMoneyLinkAdapter requestMoneyLinkAdapter = this.mAdapter;
            if (requestMoneyLinkAdapter != null) {
                requestMoneyLinkAdapter.setShowDotProgress(false);
            }
        } else {
            this.isLoading = true;
            String paymentLinkDashboardUrl = GTMDataProviderImpl.Companion.getMInstance().getPaymentLinkDashboardUrl();
            HashMap<String, Object> headers = RequestParamUtil.getHeaders(getActivity());
            NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();
            HashMap hashMap = new HashMap();
            hashMap.put("pageNumber", Integer.valueOf(this.currentPage));
            hashMap.put("pageSize", 10);
            networkService.getCreatedLinkList(paymentLinkDashboardUrl, headers, hashMap).enqueue(new Callback<List<PaymentLinkData>>() {
                public void onResponse(Call<List<PaymentLinkData>> call, Response<List<PaymentLinkData>> response) {
                    if (PaymentLinkFragment.this.mAdapter != null && !PaymentLinkFragment.this.isPagingstarted) {
                        PaymentLinkFragment.this.mAdapter.setShowDotProgress(false);
                    }
                    if (PaymentLinkFragment.this.isPagingstarted && PaymentLinkFragment.this.mAdapter != null) {
                        PaymentLinkFragment.this.mAdapter.removeLoadingFooter();
                    }
                    if (response.isSuccessful() && response.body() != null) {
                        boolean unused = PaymentLinkFragment.this.isLoading = false;
                        List body = response.body();
                        if (body.size() > 0) {
                            if (body.size() == 1) {
                                PaymentLinkFragment.this.mBinding.noItemContainer.setVisibility(0);
                            }
                            PaymentLinkFragment.this.mBinding.noItemContainer.setVisibility(8);
                            if (PaymentLinkFragment.this.mAdapter != null) {
                                if (!PaymentLinkFragment.this.isPagingstarted) {
                                    PaymentLinkFragment.this.mAdapter.setPaymentReceivedList(body);
                                } else {
                                    PaymentLinkFragment.this.mAdapter.addMoreItems(body);
                                }
                            }
                            if (body.size() < 10) {
                                boolean unused2 = PaymentLinkFragment.this.isEndofList = true;
                                return;
                            }
                            return;
                        }
                        boolean unused3 = PaymentLinkFragment.this.isEndofList = true;
                    }
                }

                public void onFailure(Call<List<PaymentLinkData>> call, Throwable th) {
                    if (PaymentLinkFragment.this.mAdapter != null) {
                        PaymentLinkFragment.this.mAdapter.setShowDotProgress(false);
                        if (PaymentLinkFragment.this.isPagingstarted) {
                            PaymentLinkFragment.this.mAdapter.removeLoadingFooter();
                        }
                    }
                }
            });
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 101 && iArr.length > 0) {
            if (iArr[0] == 0) {
                getAndSaveLocation(this.linkAmount, this.linkDescription);
            } else if (strArr.length > 0 && !shouldShowRequestPermissionRationale(strArr[0])) {
                DialogUtility.showDialog(getContext(), "", getString(R.string.mp_grant_location_permission), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PaymentLinkFragment.this.lambda$onRequestPermissionsResult$0$PaymentLinkFragment(dialogInterface, i2);
                    }
                });
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public /* synthetic */ void lambda$onRequestPermissionsResult$0$PaymentLinkFragment(DialogInterface dialogInterface, int i2) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getActivity().getPackageName(), (String) null));
        startActivity(intent);
    }

    public void showLocationBottomSheet() {
        LocationPermissionBottomSheet locationPermissionBottomSheet = new LocationPermissionBottomSheet();
        locationPermissionBottomSheet.setCancelable(true);
        locationPermissionBottomSheet.show(getChildFragmentManager(), LOCATION_PERMISSION_BOTTOMSHEET);
    }

    private void getAndSaveLocation(String str, String str2) {
        if (!AppUtility.isEdcFlavour().booleanValue()) {
            LocationLiveData locationLiveData = new LocationLiveData(getActivity());
            locationLiveData.observe(this, new z(str, str2, locationLiveData) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ androidx.lifecycle.y f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onChanged(Object obj) {
                    PaymentLinkFragment.this.lambda$getAndSaveLocation$1$PaymentLinkFragment(this.f$1, this.f$2, this.f$3, (b) obj);
                }
            });
        } else if (APSharedPreferences.getInstance().getLatitude(getActivity()) != null && APSharedPreferences.getInstance().getLongitude(getActivity()) != null) {
            createMerchantPaymentLink(str, str2);
        }
    }

    public /* synthetic */ void lambda$getAndSaveLocation$1$PaymentLinkFragment(String str, String str2, androidx.lifecycle.y yVar, b bVar) {
        if (bVar != null) {
            e eVar = bVar.f7357b;
            if (eVar == e.LOADING) {
                showProgressDialog(this.mContext);
            } else if (eVar == e.SUCCESS) {
                removeProgressDialog();
                Location location = (Location) bVar.f7358c;
                if (location.getLatitude() != 0.0d && location.getLongitude() != 0.0d) {
                    APSharedPreferences.getInstance().storeLocationInPref(location.getLatitude(), location.getLongitude());
                    createMerchantPaymentLink(str, str2);
                    yVar.removeObservers(this);
                }
            } else if (eVar == e.ERROR) {
                removeProgressDialog();
                yVar.removeObservers(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void clearTextFields() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            boolean z = false;
            RecyclerView.v findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
            if (findViewHolderForAdapterPosition != null) {
                z = true;
            }
            if (z && (findViewHolderForAdapterPosition instanceof RequestMoneyLinkAdapter.RequestMoneyHeaderViewHolder)) {
                ((RequestMoneyLinkAdapter.RequestMoneyHeaderViewHolder) findViewHolderForAdapterPosition).clearTextFields();
            }
        }
    }

    private void showNetworkSnackBar() {
        Snackbar snackbar = this.networkSnackbar;
        if (snackbar != null) {
            snackbar.d();
        }
        Snackbar a2 = Snackbar.a((View) this.coordinatorLayout, (CharSequence) getString(R.string.no_connection), -2).a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentLinkFragment.this.lambda$showNetworkSnackBar$2$PaymentLinkFragment(view);
            }
        });
        this.networkSnackbar = a2;
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.networkSnackbar.b();
        b2.setBackgroundColor(androidx.core.content.b.c(getActivity(), R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        this.networkSnackbar.a(getString(R.string.no_connection));
        this.networkSnackbar.c();
    }

    public /* synthetic */ void lambda$showNetworkSnackBar$2$PaymentLinkFragment(View view) {
        this.networkSnackbar.d();
        setDefaults();
        fetchReceivedList();
    }

    private void setDefaults() {
        this.currentPage = 1;
        this.isLoading = true;
        this.isPagingstarted = false;
        this.isEndofList = false;
    }

    /* access modifiers changed from: private */
    public void loadMoreItems() {
        if (!i.a(PaymentsConfig.getInstance().getApplication())) {
            showNetworkSnackBar();
            return;
        }
        this.isPagingstarted = true;
        this.isLoading = true;
        this.currentPage++;
        RequestMoneyLinkAdapter requestMoneyLinkAdapter = this.mAdapter;
        if (requestMoneyLinkAdapter != null) {
            requestMoneyLinkAdapter.addLoadingFooter();
        }
        fetchReceivedList();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            setDefaults();
            fetchReceivedList();
        } else if (i2 != 6000) {
        } else {
            if (i3 == -1) {
                getAndSaveLocation(this.linkAmount, this.linkDescription);
            } else {
                removeProgressDialog();
            }
        }
    }

    public void onLinkClicked(PaymentLinkData paymentLinkData) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "Payment Link", "Click Money", "/business-app/Payment Link/Click Link/", "");
        Intent intent = new Intent(getActivity(), RequestMoneyQRActivity.class);
        intent.putExtra(AppConstants.KEY_DATA_PAYMENT_LINK, paymentLinkData);
        intent.putExtra(AppConstants.FROM_SCREEN, AppConstants.REQUEST_MONEY_ITEM);
        startActivity(intent);
    }

    public void onCreateLinkClick(String str, String str2) {
        this.linkAmount = str;
        this.linkDescription = str2;
        if (!(androidx.core.app.a.a((Context) getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0)) {
            showLocationBottomSheet();
            return;
        }
        GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "Payment Link", "Create Payment Link", "/business-app/Payment Link/Create Payment Link", "");
        if (!i.a(PaymentsConfig.getInstance().getApplication())) {
            showNoNetworkSnackBar(str, str2);
        } else {
            getAndSaveLocation(str, str2);
        }
    }

    public void onShareLinkClicked(PaymentLinkData paymentLinkData) {
        String createMessage = AppUtility.createMessage(paymentLinkData.getShortUrl(), paymentLinkData.getAmount(), paymentLinkData.getLinkDescription(), this.mContext);
        if (AppUtility.isEdcFlavour().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AppConstants.EDC_MESSAGE_BUNDLE, new MessageBundle((String) null, createMessage, paymentLinkData.getEdcId(), paymentLinkData.getLinkName()));
            EDCShareOptionBottomSheet newInstance = EDCShareOptionBottomSheet.newInstance(bundle);
            newInstance.setCancelable(true);
            newInstance.show(getParentFragmentManager(), "mp_edc_share_option_bottom_sheet");
            return;
        }
        BusinessShareUtility.shareLink(createMessage, paymentLinkData.getLinkDescription(), this.mContext);
    }

    private void showNoNetworkSnackBar(String str, String str2) {
        Snackbar a2 = Snackbar.a((View) this.coordinatorLayout, (CharSequence) getString(R.string.no_connection), -2).a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener(str, str2) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                PaymentLinkFragment.this.lambda$showNoNetworkSnackBar$3$PaymentLinkFragment(this.f$1, this.f$2, view);
            }
        });
        a2.d(getContext().getResources().getColor(R.color.color_00b9f5));
        View b2 = a2.b();
        b2.setBackgroundColor(androidx.core.content.b.c(getActivity(), R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        a2.a(getString(R.string.no_connection));
        a2.c();
    }

    public /* synthetic */ void lambda$showNoNetworkSnackBar$3$PaymentLinkFragment(String str, String str2, View view) {
        onCreateLinkClick(str, str2);
    }

    public void setLocation(String str, String str2) {
        if (str != null && str2 != null) {
            APSharedPreferences.getInstance().storeLocationInPref(Double.parseDouble(str), Double.parseDouble(str2));
        }
    }

    public void showLocationPrompt() {
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 101);
    }
}
