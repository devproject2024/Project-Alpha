package net.one97.paytm.nativesdk.orflow.promo.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.palette.a.b;
import androidx.palette.a.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeOrController;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.listeners.SetOnAlertButtonListeners;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.adapter.MallPromoAdapter;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoDataProvider;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoList;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;
import net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet;
import net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet;

public class MallPromoSearchActivity extends BaseMallPromoActivity implements View.OnClickListener, VerifyPromoResultListener, PromoSearchListener, IFreebieResponseListener, IPromoDataProvider {
    private String TAG = MallPromoSearchActivity.class.getName();
    private TextView btnConfirm;
    /* access modifiers changed from: private */
    public String currentPromo = "";
    /* access modifiers changed from: private */
    public PromoListItem currentPromoItem;
    private int errorIndex = -1;
    private String errorMessage = "";
    /* access modifiers changed from: private */
    public boolean isRemovePromo = false;
    private boolean isSkipCall;
    private List<PromoListItem> mPromoItemList = null;
    /* access modifiers changed from: private */
    public List<CJRPromoData> promoDataList;
    /* access modifiers changed from: private */
    public RecyclerView promoListView;
    private List<CountDownTimer> timerList = new ArrayList();

    public View.OnClickListener getClickListener() {
        return this;
    }

    public void onFreebieErrorResponse(String str) {
    }

    public void onFreebieResponse(String str) {
    }

    public void onNonPromoError(String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_promo_screen);
        if (Build.VERSION.SDK_INT >= 3) {
            getWindow().setSoftInputMode(3);
        }
        initUI();
        PromoHelper.Companion.getInstance().addPromoSearchObserver(this);
        PromoHelper.Companion.getInstance().addVerifyPromoObserver(this);
        PromoHelper.Companion.getInstance().getAllPromo(getApplication());
    }

    private void initUI() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Display defaultDisplay = getWindowManager().getDefaultDisplay();
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.post(new Runnable() {
            public void run() {
                MallPromoSearchActivity.this.setAppBarOffset(appBarLayout, coordinatorLayout, defaultDisplay.getWidth() / 3);
            }
        });
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.header);
        imageView.getLayoutParams().height = defaultDisplay.getWidth();
        b.a(((BitmapDrawable) imageView.getDrawable()).getBitmap()).a((b.c) new b.c() {
            public void onGenerated(b bVar) {
                collapsingToolbarLayout.setContentScrimColor(bVar.a(c.f4011e, MallPromoSearchActivity.this.getResources().getColor(R.color.paytm_dark_blue)));
            }
        });
        this.promoListView = (RecyclerView) findViewById(R.id.promoList);
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
            getSupportActionBar().a(true);
            getSupportActionBar().a((CharSequence) getString(R.string.select_one_offer));
        }
        appBarLayout.a((AppBarLayout.b) new AppBarLayout.b() {
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                MallPromoSearchActivity.this.handleOffsetChange(appBarLayout, i2, toolbar);
            }
        });
        this.currentPromo = getCurrentPromo();
        this.btnConfirm = (TextView) findViewById(R.id.btn_confirm);
        HashMap<String, Object> dataMap = getDataMap();
        if (dataMap != null && dataMap.containsKey("PROMO_DATA")) {
            setPromoDataList(getPromoDataList(dataMap.get("PROMO_DATA")));
            this.btnConfirm.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MallPromoSearchActivity mallPromoSearchActivity = MallPromoSearchActivity.this;
                    mallPromoSearchActivity.handleFreebieOpenGA(mallPromoSearchActivity.currentPromoItem);
                    MallPromoSearchActivity mallPromoSearchActivity2 = MallPromoSearchActivity.this;
                    mallPromoSearchActivity2.handleFeebieCase(mallPromoSearchActivity2.promoDataList);
                }
            });
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    private void setPromoDataList(List<CJRPromoData> list) {
        this.promoDataList = list;
        if (list == null || list.size() <= 0) {
            this.btnConfirm.setVisibility(8);
            findViewById(R.id.txv_cashback_text).setVisibility(0);
            return;
        }
        this.btnConfirm.setVisibility(0);
        findViewById(R.id.txv_cashback_text).setVisibility(8);
    }

    private List<CJRPromoData> getPromoDataList(Object obj) {
        return (List) obj;
    }

    private String getCurrentPromo() {
        HashMap<String, Object> dataMap = getDataMap();
        return dataMap != null ? String.valueOf(dataMap.get(Constants.KEY_CURRENT_PROMO)) : "";
    }

    /* access modifiers changed from: private */
    public void handleOffsetChange(AppBarLayout appBarLayout, int i2, Toolbar toolbar) {
        if (Math.abs(i2) == appBarLayout.getTotalScrollRange()) {
            toolbar.setBackgroundColor(androidx.core.content.b.c(this, R.color.white));
        } else {
            toolbar.setBackgroundColor(androidx.core.content.b.c(this, R.color.transparent));
        }
    }

    /* access modifiers changed from: private */
    public void setAppBarOffset(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, int i2) {
        ((AppBarLayout.Behavior) ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).f2603a).onNestedPreScroll(coordinatorLayout, appBarLayout, (View) null, 0, i2, new int[]{0, 0});
    }

    public void onClick(View view) {
        this.promoListView.getAdapter().notifyDataSetChanged();
        Class<PromoListItem> cls = PromoListItem.class;
        final PromoListItem cast = cls.isInstance(view.getTag()) ? cls.cast(view.getTag()) : null;
        if (TextUtils.isEmpty(this.currentPromo) || (cast != null && !this.currentPromo.equalsIgnoreCase(cast.getCode()))) {
            this.isRemovePromo = false;
            callVerifyPromo(cast, true);
        } else {
            DialogUtility.showTwoButtonDialogNew(this, getString(R.string.remove_promo_native_pg), getString(R.string.are_your_sure, new Object[]{this.currentPromo}), getString(R.string.remove), getString(R.string.cancel), new SetOnAlertButtonListeners() {
                public void onNegativeClicked() {
                }

                public void onPositiveClicked() {
                    boolean unused = MallPromoSearchActivity.this.isRemovePromo = true;
                    MallPromoSearchActivity.this.callVerifyPromo(cast, false);
                }
            });
        }
        handleClickGAEvent(cast);
    }

    private void handleClickGAEvent(PromoListItem promoListItem) {
        final boolean isFlashSale = PromoUtils.isFlashSale(promoListItem);
        final boolean z = promoListItem != null && PromoUtils.isFreebie(promoListItem);
        final String string = getString("NAME");
        final String string2 = getString(Constants.KEY_BRAND);
        final String string3 = getString("PRODUCT_ID");
        final String string4 = getString(Constants.KEY_CATEGORY_MAP);
        final String string5 = getString(Constants.KEY_DISCOVERABILITY);
        final PromoListItem promoListItem2 = promoListItem;
        Utility.INSTANCE.sendBankOffersEvent(this, new HashMap<String, Object>() {
            {
                put("eventName", "apply_promo_selected");
                put("event_action", "apply_promo_selected");
                put("event_category", string5);
                put("event_label2", MallPromoSearchActivity.this.getEventLabel2(string, string2, string3, string4));
                put("user_id", MallPromoSearchActivity.this.getCustomerId());
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/cart");
                put("vertical_name", GAUtil.MARKET_PLACE);
                put("event_label", MallPromoSearchActivity.this.getEventLabel(promoListItem2.getCode(), isFlashSale, z));
            }
        });
    }

    /* access modifiers changed from: private */
    public String getCustomerId() {
        return PromoUtils.getCustomerId();
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> getEventLabel(String str, boolean z, boolean z2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Utility.EVENT_CATEGORY_PROMOCODE, str);
        hashMap.put("isFlash", Boolean.valueOf(z));
        hashMap.put("freebie", Boolean.valueOf(z2));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> getEventLabel2(String str, String str2, String str3, String str4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("product", str);
        hashMap.put("category", str4);
        hashMap.put(CLPConstants.BRAND_PARAMS, str2);
        hashMap.put(com.appsflyer.share.Constants.URL_MEDIA_SOURCE, str3);
        return hashMap;
    }

    private String getString(String str) {
        HashMap<String, Object> dataMap = getDataMap();
        return (dataMap == null || !dataMap.containsKey(str)) ? "" : String.valueOf(dataMap.get(str));
    }

    /* access modifiers changed from: private */
    public void callVerifyPromo(PromoListItem promoListItem, boolean z) {
        if (!SDKUtility.isNetworkAvailable(this)) {
            showNoInternetDialog();
            return;
        }
        hidePromoError();
        showVerifyLoader();
        if (!z || promoListItem.getCode() == null || !Utility.VERTICAL_NAME_MALL.equalsIgnoreCase(PromoHelper.Companion.getInstance().getVerticalName()) || !promoListItem.getCode().equalsIgnoreCase(PromoHelper.Companion.getInstance().getBankOfferPromoCode()) || PromoHelper.Companion.getInstance().getSelectedPaymentInstrument() == null || PromoHelper.Companion.getInstance().getPaymentIntent() == null || PromoHelper.Companion.getInstance().getPaymentIntent().size() <= 0) {
            promoListItem.getPaymentFilters();
            this.currentPromoItem = promoListItem;
            PromoHelper.Companion.getInstance().onPromoSelected(promoListItem.getCode(), promoListItem.getOffer() != null ? promoListItem.getOffer().getTitle() : "", z ? 1 : 0, promoListItem.getPaymentFilters());
            return;
        }
        this.isSkipCall = true;
        PromoHelper.Companion.getInstance().onPaymentModeSelected(PromoHelper.Companion.getInstance().getPaymentIntent(), PromoHelper.Companion.getInstance().getSelectedPaymentInstrument());
    }

    private boolean isBankOffer(PromoListItem promoListItem) {
        return Constants.BANK_OFFER_KEY.equalsIgnoreCase(promoListItem.getCampaignType());
    }

    private void handleBankOffer(CJPayMethodResponse cJPayMethodResponse) {
        BasePromoPayOptionSheet basePromoPayOptionSheet;
        if (cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getMerchantPayOption() == null) {
            showPromoError(getResources().getString(R.string.default_error_blank_payoptions));
            return;
        }
        MerchantPayOption merchantPayOption = cJPayMethodResponse.getBody().getMerchantPayOption();
        if ((merchantPayOption.getPaymentModes() == null || merchantPayOption.getPaymentModes().isEmpty()) && ((merchantPayOption.getSavedInstruments() == null || merchantPayOption.getSavedInstruments().isEmpty()) && (merchantPayOption.getUpiProfile() == null || merchantPayOption.getUpiProfile().getRespDetails() == null || merchantPayOption.getUpiProfile().getRespDetails().getProfileDetail() == null || merchantPayOption.getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts() == null))) {
            showPromoError(getResources().getString(R.string.default_error_blank_payoptions));
            return;
        }
        if (shouldShowNBOnlySheet(cJPayMethodResponse)) {
            basePromoPayOptionSheet = PromoNetBankingSheet.Companion.getInstance(cJPayMethodResponse);
        } else {
            basePromoPayOptionSheet = PromoPayOptionsBottomSheet.Companion.getInstance(cJPayMethodResponse);
        }
        basePromoPayOptionSheet.setDismissListener(new BasePromoPayOptionSheet.OnDismissListener() {
            public void closeActivity() {
                PromoHelper.Companion.getInstance().removeVerifyPromoObserver(MallPromoSearchActivity.this);
                MallPromoSearchActivity.this.finish();
            }

            public void onDismiss(boolean z) {
                if (!z) {
                    PromoHelper.Companion.getInstance().addVerifyPromoObserver(MallPromoSearchActivity.this);
                    MallPromoSearchActivity.this.promoListView.getAdapter().notifyDataSetChanged();
                }
            }
        });
        PromoHelper.Companion.getInstance().removeVerifyPromoObserver(this);
        basePromoPayOptionSheet.show(getSupportFragmentManager(), PromoPayOptionsBottomSheet.class.getSimpleName());
    }

    private boolean shouldShowNBOnlySheet(CJPayMethodResponse cJPayMethodResponse) {
        Body body;
        MerchantPayOption merchantPayOption;
        ArrayList<PaymentModes> paymentModes;
        if (!(cJPayMethodResponse == null || (body = cJPayMethodResponse.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null || (paymentModes = merchantPayOption.getPaymentModes()) == null)) {
            Iterator<PaymentModes> it2 = paymentModes.iterator();
            if (it2.hasNext()) {
                PaymentModes next = it2.next();
                if ("NET_BANKING".equals(next.getPaymentMode()) && next.getPayChannelOptions().size() != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void handleFeebieCase(List<CJRPromoData> list) {
        PromoUtils.startFreebieListActivity((Activity) this, list, getDataMap());
    }

    /* access modifiers changed from: private */
    public void handleFreebieOpenGA(PromoListItem promoListItem) {
        final String string = getString(Constants.KEY_DISCOVERABILITY);
        final String string2 = getString("NAME");
        final String string3 = getString(Constants.KEY_BRAND);
        final String string4 = getString("PRODUCT_ID");
        final String string5 = getString(Constants.KEY_CATEGORY_MAP);
        Utility.INSTANCE.sendBankOffersEvent(this, new HashMap<String, Object>() {
            {
                put("eventName", "select_freebie_clicked");
                put("event_action", "select_freebie_clicked");
                put("event_category", string);
                put("event_label2", new HashMap<String, Object>() {
                    {
                        put(com.appsflyer.share.Constants.URL_MEDIA_SOURCE, string4);
                        put("category", string5);
                        put(CLPConstants.BRAND_PARAMS, string3);
                        put("freebie_offer", MallPromoSearchActivity.this.currentPromo);
                    }
                });
                put("user_id", MallPromoSearchActivity.this.getCustomerId());
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/cart");
                put("vertical_name", GAUtil.MARKET_PLACE);
                put("event_label", new HashMap<String, Object>() {
                    {
                        put("screen_name", "/cart");
                        put("product", string2);
                    }
                });
            }
        });
    }

    public void onVerifyPromoSuccess(CJPayMethodResponse cJPayMethodResponse, boolean z, PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
        PromoListItem promoListItem;
        hideVerifyLoader();
        if (this.isRemovePromo || this.isSkipCall) {
            finish();
            return;
        }
        List<CJRPromoData> freebieItems = PromoHelper.Companion.getInstance().getFreebieItems();
        setPromoDataList(freebieItems);
        if (cJPayMethodResponse != null && (promoListItem = this.currentPromoItem) != null && isBankOffer(promoListItem)) {
            PromoUtils.log("bank offer case");
            handleBankOffer(cJPayMethodResponse);
        } else if (freebieItems == null || freebieItems.size() <= 0) {
            updatePromoData();
            PromoUtils.log("normal promo so -> closing activity");
            finish();
        } else {
            updatePromoData();
            PromoUtils.log("freebie case encountered");
            handleFeebieCase(freebieItems);
        }
        ArrayList<PaymentIntent> paymentIntent = PromoHelper.Companion.getInstance().getPaymentIntent();
        if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null || paymentIntent == null) {
            ConvenienceFeeOrController.getInstance().resetConvenienceFee();
        } else {
            ConvenienceFeeOrController.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), paymentIntent, verifyResponseData.getVerifyModel());
        }
    }

    private void updatePromoData() {
        PromoListItem promoListItem = this.currentPromoItem;
        if (promoListItem != null) {
            this.currentPromo = promoListItem.getCode();
            this.promoListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onVerifyPromoError(String str) {
        hideVerifyLoader();
        this.isSkipCall = false;
        handlePromoErrorGA();
        if (Constants.AUTH_ERROR.equalsIgnoreCase(str)) {
            finish();
        }
        showPromoError(str);
        this.currentPromoItem = null;
    }

    private void handlePromoErrorGA() {
        final String string = getString(Constants.KEY_DISCOVERABILITY);
        Utility.INSTANCE.sendBankOffersEvent(this, new HashMap<String, Object>() {
            {
                put("eventName", "promo_application_failed");
                put("event_action", "promo_application_failed");
                put("event_category", string);
                put("user_id", MallPromoSearchActivity.this.getCustomerId());
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/cart");
                put("vertical_name", GAUtil.MARKET_PLACE);
            }
        });
    }

    public void onVerifyPromoNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        hideVerifyLoader();
        hidePromoError();
        showNoInternetDialog();
    }

    private void showPromoError(String str) {
        int indexOf = this.mPromoItemList.indexOf(this.currentPromoItem);
        if (indexOf != -1) {
            this.errorIndex = indexOf;
            this.errorMessage = str;
            this.promoListView.getAdapter().notifyDataSetChanged();
        }
    }

    private void showNoInternetDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.promo_dialog_network_error, (ViewGroup) null, false);
        if (inflate != null) {
            final AlertDialog create = new AlertDialog.Builder(this).create();
            create.setView(inflate);
            create.setCancelable(false);
            inflate.findViewById(R.id.tvOk).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            create.show();
        }
    }

    private void hidePromoError() {
        if (this.errorIndex != -1 || !TextUtils.isEmpty(this.errorMessage)) {
            this.errorMessage = "";
            this.errorIndex = -1;
            this.promoListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onPromoSearchSuccess(String str) {
        PromoList createPromoList = PromoList.Companion.createPromoList(str);
        this.mPromoItemList = createPromoList != null ? createPromoList.getCodes() : null;
        List<PromoListItem> list = this.mPromoItemList;
        if (list == null || list.isEmpty()) {
            hidePromoList();
            return;
        }
        this.promoListView.setVisibility(0);
        MallPromoAdapter mallPromoAdapter = new MallPromoAdapter(this, this.mPromoItemList, this);
        this.promoListView.setLayoutManager(new LinearLayoutManager(this));
        this.promoListView.setAdapter(mallPromoAdapter);
        findViewById(R.id.no_offers_layout).setVisibility(8);
        scrollToSelectedPromo(this.promoListView, getSelectedPosition(getAppliedPromo(), this.mPromoItemList), this.mPromoItemList);
    }

    private void scrollToSelectedPromo(RecyclerView recyclerView, int i2, List<PromoListItem> list) {
        if (list != null && i2 >= 0 && i2 < list.size()) {
            ((AppBarLayout) findViewById(R.id.appbar)).setExpanded(false, false);
            recyclerView.scrollToPosition(i2);
        }
    }

    private int getSelectedPosition(String str, List<PromoListItem> list) {
        if (list == null) {
            return -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            PromoListItem promoListItem = list.get(i2);
            if (promoListItem != null && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(promoListItem.getCode())) {
                return i2;
            }
        }
        return -1;
    }

    private void hidePromoList() {
        this.promoListView.setVisibility(8);
        findViewById(R.id.no_offers_layout).setVisibility(0);
        if (getSupportActionBar() != null) {
            getSupportActionBar().a((CharSequence) "");
        }
    }

    public void onPromoSearchError(VolleyError volleyError) {
        hidePromoList();
    }

    public void getFreebies(PromoListItem promoListItem) {
        PromoHelper.Companion.getInstance().getFreebies(promoListItem, (IFreebieResponseListener) this);
    }

    public String getAppliedPromo() {
        return this.currentPromo;
    }

    public void getFreebies(Gratification gratification, PromoListItem promoListItem) {
        PromoHelper.Companion.getInstance().getFreebies(gratification, promoListItem, this);
    }

    public HashMap<String, Object> getResponseHeader() {
        return getResponseMap();
    }

    public void registerTimer(CountDownTimer countDownTimer) {
        this.timerList.add(countDownTimer);
    }

    public int getCurrentErrorIndex() {
        return this.errorIndex;
    }

    public String getCurrentError() {
        return this.errorMessage;
    }

    public int getPromoCount() {
        try {
            HashMap<String, Object> dataMap = getDataMap();
            if (dataMap == null || !dataMap.containsKey(Constants.KEY_PROMO_COUNT)) {
                return 0;
            }
            return Integer.parseInt(String.valueOf(getDataMap().get(Constants.KEY_PROMO_COUNT)));
        } catch (NumberFormatException e2) {
            LogUtility.printStackTrace(e2);
            return 0;
        }
    }

    private HashMap<String, Object> getResponseMap() {
        final HashMap<String, Object> dataMap = getDataMap();
        if (dataMap != null) {
            return new HashMap<String, Object>() {
                {
                    put(Constants.RESPONSE_TIME_KEY, dataMap.get(Constants.KEY_CURRENT_TIME));
                }
            };
        }
        return new HashMap<>();
    }

    private HashMap<String, Object> getDataMap() {
        Intent intent = getIntent();
        if (intent != null) {
            return (HashMap) intent.getSerializableExtra(Constants.DATA_MAP);
        }
        return null;
    }

    public void onFreebieResponse(PromoListItem promoListItem, String str) {
        promoListItem.setFreebies(getFilteredList(PromoList.Companion.updateFreebies(str)));
        updateList(promoListItem);
    }

    public void onFreebieResponse(Gratification gratification, PromoListItem promoListItem, String str) {
        gratification.setFreebieList((ArrayList) getFilteredList(PromoList.Companion.updateFreebies(str)));
        updateList(promoListItem);
    }

    private void updateList(PromoListItem promoListItem) {
        RecyclerView recyclerView;
        List<PromoListItem> list = this.mPromoItemList;
        final int indexOf = list != null ? list.indexOf(promoListItem) : -1;
        if (indexOf != -1 && (recyclerView = this.promoListView) != null && recyclerView.getAdapter() != null) {
            this.promoListView.post(new Runnable() {
                public void run() {
                    MallPromoSearchActivity.this.promoListView.getAdapter().notifyItemChanged(indexOf);
                }
            });
        }
    }

    private List<Freebie> getFilteredList(List<Freebie> list) {
        if (list == null) {
            return new ArrayList();
        }
        for (Freebie next : list) {
            if (!next.isStock()) {
                list.remove(next);
            }
        }
        return list;
    }

    public void onDestroy() {
        super.onDestroy();
        List<CountDownTimer> list = this.timerList;
        if (list != null) {
            for (CountDownTimer next : list) {
                if (next != null) {
                    next.cancel();
                }
            }
        }
        PromoHelper.Companion.getInstance().removePromoSearchObserver(this);
        PromoHelper.Companion.getInstance().removeVerifyPromoObserver(this);
        PromoHelper.Companion.getInstance().clearListeners(this, this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001 && i3 == -1) {
            setResult(i3, intent);
            finish();
        }
    }
}
