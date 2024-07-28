package com.business.merchant_payments.requestmoney;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.i;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.ISODateUtil;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.BaseModel;
import com.business.merchant_payments.model.paymentlinks.PaymentLinkReceivedListResponse;
import com.business.merchant_payments.model.paymentlinks.PaymentLinkRequest;
import com.business.merchant_payments.model.requestpayment.CreateLinkModel;
import com.business.merchant_payments.model.requestpayment.MessageBundle;
import com.business.merchant_payments.model.requestpayment.PaymentLinkData;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.utility.BusinessShareUtility;
import com.google.android.material.snackbar.Snackbar;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.greenrobot.eventbus.c;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestMoneyQRActivity extends BaseActivity implements View.OnClickListener {
    public static final int PAGE_SIZE = 10;
    public static final String TAG = "RequestMoneyQRActivity";
    public PaymentReceivedListAdapter adapter;
    public RelativeLayout container;
    public int currentPage = 1;
    public BaseModel data;
    public boolean fromLinkItem = false;
    public boolean isLoading = true;
    public boolean isMonthChange = true;
    public boolean isPagingstarted = false;
    public String linkDesc = "";
    public CustomTextView listTitle;
    public String longUrl;
    public Snackbar networkSnackbar;
    public LinearLayout noPaymentReceived;
    public String orderCreatedEndTime;
    public String orderCreatedStartTime;
    public String paymentId;
    public ProgressBar progressBar;
    public RecyclerView receivedList;
    public String shortUrl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mp_payment_link_activity);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(AppConstants.KEY_DATA_PAYMENT_LINK)) {
            this.data = (BaseModel) intent.getSerializableExtra(AppConstants.KEY_DATA_PAYMENT_LINK);
            if (intent.getStringExtra(AppConstants.FROM_SCREEN) != null) {
                this.fromLinkItem = AppConstants.REQUEST_MONEY_ITEM.equalsIgnoreCase(intent.getStringExtra(AppConstants.FROM_SCREEN));
            }
        }
        initViews();
    }

    private void initViews() {
        CustomTextView customTextView = (CustomTextView) findViewById(R.id.amount_txt);
        CustomTextView customTextView2 = (CustomTextView) findViewById(R.id.payment_link_share);
        this.container = (RelativeLayout) findViewById(R.id.payment_link_activity_container);
        if (!PaymentsConfig.getInstance().getMerchantDataProvider().u()) {
            customTextView2.setTextColor(b.c(this, R.color.gray));
            for (Drawable drawable : customTextView2.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(b.c(this, R.color.gray), PorterDuff.Mode.SRC_IN));
                }
            }
        } else {
            customTextView2.setOnClickListener(this);
        }
        CustomTextView customTextView3 = (CustomTextView) findViewById(R.id.payment_link_copy);
        Drawable drawable2 = getResources().getDrawable(R.drawable.mp_ic_content_copy);
        drawable2.setColorFilter(getResources().getColor(R.color.paytm_blue), PorterDuff.Mode.SRC_ATOP);
        customTextView3.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
        customTextView3.setOnClickListener(this);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.listTitle = (CustomTextView) findViewById(R.id.recycler_view_title);
        this.noPaymentReceived = (LinearLayout) findViewById(R.id.tv_no_payment_received);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.payment_list_rv);
        this.receivedList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.receivedList.setHasFixedSize(true);
        BaseModel baseModel = this.data;
        if (baseModel == null) {
            finish();
        } else if (baseModel instanceof PaymentLinkData) {
            PaymentLinkData paymentLinkData = (PaymentLinkData) baseModel;
            this.shortUrl = paymentLinkData.getShortUrl();
            this.linkDesc = paymentLinkData.getLinkDescription();
            this.paymentId = paymentLinkData.getId();
            customTextView.setText(AppUtility.formattedPrice(0.7f, "₹ " + paymentLinkData.getAmount(), b.c(this, R.color.new_text_color), true));
            customTextView.setVisibility(0);
            setDefaults();
            fetchPaymentReceivedList();
            this.longUrl = paymentLinkData.getLongUrl();
        } else if (baseModel instanceof CreateLinkModel) {
            this.progressBar.setVisibility(8);
            CreateLinkModel createLinkModel = (CreateLinkModel) this.data;
            customTextView.setText(AppUtility.formattedPrice(0.7f, "₹ " + createLinkModel.getAmount(), b.c(this, R.color.new_text_color), true));
            this.shortUrl = createLinkModel.getShortUrl();
            this.linkDesc = createLinkModel.getLinkDescription();
            customTextView.setVisibility(0);
            this.noPaymentReceived.setVisibility(0);
            this.longUrl = createLinkModel.getLongUrl();
            if (PaymentsConfig.getInstance().getMerchantDataProvider().u()) {
                shareLink();
            }
        }
        ((CustomTextView) findViewById(R.id.payment_details_title)).setText(this.linkDesc);
        ((CustomTextView) findViewById(R.id.payment_link_txt)).setText(getResources().getString(R.string.mp_get_link_for) + " " + this.shortUrl);
        ((CustomTextView) findViewById(R.id.preview_link_tv)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.back_button_pl)).setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onResume() {
        super.onResume();
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Payment Link/Request Money");
    }

    public void onStop() {
        super.onStop();
        c.a().b(this);
    }

    private void fetchPaymentReceivedList() {
        if (!i.a(PaymentsConfig.getInstance().getApplication())) {
            this.progressBar.setVisibility(8);
            showNetworkSnackBar();
            return;
        }
        this.isLoading = true;
        PaymentsConfig.getInstance().getNetworkService().getPaymentLinkReceived(GTMDataProviderImpl.Companion.getMInstance().getV2OrderList(), new PaymentLinkRequest(this.paymentId, this.orderCreatedEndTime + "+05:30", this.orderCreatedStartTime + "+05:30", this.currentPage, 10), RequestParamUtil.getHeaders(this)).enqueue(new Callback<PaymentLinkReceivedListResponse>() {
            public void onResponse(Call<PaymentLinkReceivedListResponse> call, Response<PaymentLinkReceivedListResponse> response) {
                RequestMoneyQRActivity.this.progressBar.setVisibility(8);
                if (RequestMoneyQRActivity.this.isPagingstarted && RequestMoneyQRActivity.this.adapter != null) {
                    RequestMoneyQRActivity.this.adapter.removeLoadingFooter();
                }
                if (!response.isSuccessful() || response.body() == null) {
                    RequestMoneyQRActivity requestMoneyQRActivity = RequestMoneyQRActivity.this;
                    DialogUtility.showDialog(requestMoneyQRActivity, requestMoneyQRActivity.getString(R.string.mp_error), RequestMoneyQRActivity.this.getString(R.string.mp_something_went_wrong));
                    return;
                }
                boolean z = false;
                boolean unused = RequestMoneyQRActivity.this.isLoading = false;
                PaymentLinkReceivedListResponse body = response.body();
                if (body.getResultInfo() == null || !"SUCCESS".equalsIgnoreCase(body.getResultInfo().getResultCode())) {
                    RequestMoneyQRActivity requestMoneyQRActivity2 = RequestMoneyQRActivity.this;
                    DialogUtility.showDialog(requestMoneyQRActivity2, requestMoneyQRActivity2.getString(R.string.mp_error), RequestMoneyQRActivity.this.getString(R.string.mp_something_went_wrong));
                    return;
                }
                ArrayList arrayList = (ArrayList) body.getOrderList();
                if (arrayList == null || arrayList.size() <= 0) {
                    RequestMoneyQRActivity.this.handleEmptyList();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    OrderDetailV2Model orderDetailV2Model = (OrderDetailV2Model) it2.next();
                    if (orderDetailV2Model.getOrderStatus().contentEquals("SUCCESS")) {
                        arrayList2.add(orderDetailV2Model);
                    }
                }
                RequestMoneyQRActivity requestMoneyQRActivity3 = RequestMoneyQRActivity.this;
                if (arrayList2.size() < 10) {
                    z = true;
                }
                boolean unused2 = requestMoneyQRActivity3.isMonthChange = z;
                if (arrayList2.size() > 0) {
                    if (RequestMoneyQRActivity.this.adapter == null) {
                        RequestMoneyQRActivity.this.initializeRecyclerAndViews(arrayList2);
                    } else {
                        RequestMoneyQRActivity.this.adapter.addMoreItems(arrayList2);
                    }
                    if (RequestMoneyQRActivity.this.isMonthChange && RequestMoneyQRActivity.this.adapter != null && RequestMoneyQRActivity.this.adapter.getItemCount() < 10) {
                        RequestMoneyQRActivity.this.loadMoreItems();
                        return;
                    }
                    return;
                }
                RequestMoneyQRActivity.this.handleEmptyList();
            }

            public void onFailure(Call<PaymentLinkReceivedListResponse> call, Throwable th) {
                RequestMoneyQRActivity.this.progressBar.setVisibility(8);
                if (RequestMoneyQRActivity.this.isPagingstarted && RequestMoneyQRActivity.this.adapter != null) {
                    RequestMoneyQRActivity.this.adapter.removeLoadingFooter();
                }
                RequestMoneyQRActivity requestMoneyQRActivity = RequestMoneyQRActivity.this;
                DialogUtility.showDialog(requestMoneyQRActivity, requestMoneyQRActivity.getString(R.string.mp_error), RequestMoneyQRActivity.this.getString(R.string.mp_something_went_wrong));
            }
        });
    }

    private void setDefaults() {
        this.isLoading = true;
        this.isMonthChange = true;
        this.currentPage = 1;
        this.isPagingstarted = false;
        String createIso8601TimeStamp = ISODateUtil.createIso8601TimeStamp(System.currentTimeMillis());
        this.orderCreatedEndTime = createIso8601TimeStamp;
        this.orderCreatedStartTime = DateUtility.getDateAfter(createIso8601TimeStamp, "yyyy-MM-dd'T'HH:mm:ss", -30, "yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone("GMT+5:30"));
    }

    /* access modifiers changed from: private */
    public void initializeRecyclerAndViews(ArrayList<Object> arrayList) {
        this.listTitle.setVisibility(0);
        this.receivedList.setVisibility(0);
        this.noPaymentReceived.setVisibility(8);
        PaymentReceivedListAdapter paymentReceivedListAdapter = new PaymentReceivedListAdapter(this, arrayList);
        this.adapter = paymentReceivedListAdapter;
        this.receivedList.setAdapter(paymentReceivedListAdapter);
        this.receivedList.addOnScrollListener(new RecyclerView.l() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
            }

            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int childCount = linearLayoutManager.getChildCount();
                int itemCount = linearLayoutManager.getItemCount();
                if (!RequestMoneyQRActivity.this.isLoading && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition > 0) {
                    RequestMoneyQRActivity.this.loadMoreItems();
                }
            }
        });
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
        if (this.isMonthChange) {
            this.currentPage = 1;
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                Date parse = simpleDateFormat.parse(this.orderCreatedStartTime);
                long parseLong = Long.parseLong(((PaymentLinkData) this.data).getCreatedDate());
                String formattedDate = DateUtility.getFormattedDate(parseLong, "yyyy-MM-dd'T'HH:mm:ss");
                Date date = new Date(new Timestamp(parseLong).getTime());
                if (parse.compareTo(date) > 0 && parse.compareTo(DateUtility.getLastSixMonthsDateObject()) > 0) {
                    String str = this.orderCreatedStartTime;
                    this.orderCreatedEndTime = str;
                    String dateAfter = DateUtility.getDateAfter(str, "yyyy-MM-dd'T'HH:mm:ss", -30, "yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone("GMT+5:30"));
                    if (simpleDateFormat.parse(dateAfter).compareTo(date) <= 0) {
                        this.orderCreatedStartTime = formattedDate;
                    } else {
                        this.orderCreatedStartTime = dateAfter;
                    }
                    if (this.adapter != null) {
                        this.adapter.addLoadingFooter();
                    }
                    fetchPaymentReceivedList();
                } else if (this.adapter == null || this.adapter.getItemCount() <= 0) {
                    this.noPaymentReceived.setVisibility(0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            PaymentReceivedListAdapter paymentReceivedListAdapter = this.adapter;
            if (paymentReceivedListAdapter != null) {
                paymentReceivedListAdapter.addLoadingFooter();
            }
            fetchPaymentReceivedList();
        }
    }

    private void showNetworkSnackBar() {
        Snackbar snackbar = this.networkSnackbar;
        if (snackbar != null) {
            snackbar.d();
        }
        Snackbar a2 = Snackbar.a((View) this.container, (CharSequence) getString(R.string.no_connection), -2).a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                RequestMoneyQRActivity.this.lambda$showNetworkSnackBar$0$RequestMoneyQRActivity(view);
            }
        });
        this.networkSnackbar = a2;
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.networkSnackbar.b();
        b2.setBackgroundColor(b.c(this, R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        this.networkSnackbar.a(getString(R.string.no_connection));
        this.networkSnackbar.c();
    }

    public /* synthetic */ void lambda$showNetworkSnackBar$0$RequestMoneyQRActivity(View view) {
        this.networkSnackbar.d();
        setDefaults();
        fetchPaymentReceivedList();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.payment_link_share) {
            GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Payment Link/Share Link");
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Payment Link", "Share Link", "/business-app/Payment Link/Share Link", "");
            shareLink();
        } else if (view.getId() == R.id.back_button_pl) {
            onBackPressed();
        } else if (view.getId() == R.id.payment_link_copy) {
            GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Payment Link/Copy Link");
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Payment Link", "Copy Link", "/business-app/Payment Link/Copy Link", "");
            if (!this.shortUrl.isEmpty()) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                ClipData newPlainText = ClipData.newPlainText("payment link", this.shortUrl);
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(newPlainText);
                }
                Toast.makeText(this, getString(R.string.mp_payment_link_copied), 1).show();
            }
        } else if (view.getId() == R.id.preview_link_tv) {
            GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Payment Link/Click Link");
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Payment Link", "Click Link", "/business-app/Payment Link/Click Link", "");
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.longUrl)));
        }
    }

    private void shareLink() {
        String str;
        if (AppUtility.isEdcFlavour().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AppConstants.EDC_MESSAGE_BUNDLE, new MessageBundle((String) null, createLinkBody(), createLinkId(), createLinkName()));
            EDCShareOptionBottomSheet newInstance = EDCShareOptionBottomSheet.newInstance(bundle);
            newInstance.setCancelable(true);
            newInstance.show(getSupportFragmentManager(), "mp_edc_share_option_bottom_sheet");
        } else if (Build.VERSION.SDK_INT < 23 || b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            String createLinkBody = createLinkBody();
            BaseModel baseModel = this.data;
            if (baseModel instanceof PaymentLinkData) {
                str = ((PaymentLinkData) baseModel).getLinkDescription();
            } else {
                str = baseModel instanceof CreateLinkModel ? ((CreateLinkModel) baseModel).getLinkDescription() : "";
            }
            BusinessShareUtility.shareLink(createLinkBody, str, this);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
            Toast.makeText(this, getString(R.string.mp_permission_not_granted), 1).show();
        }
    }

    private String createLinkName() {
        BaseModel baseModel = this.data;
        if (baseModel instanceof PaymentLinkData) {
            return ((PaymentLinkData) baseModel).getLinkName();
        }
        if (!(baseModel instanceof CreateLinkModel)) {
            return "";
        }
        try {
            String[] split = ((CreateLinkModel) baseModel).getLongUrl().split("/");
            if (split.length >= 5) {
                return split[4];
            }
            return "";
        } catch (Exception e2) {
            LogUtility.e(TAG, e2.toString());
            return "";
        }
    }

    private String createLinkId() {
        BaseModel baseModel = this.data;
        if (baseModel instanceof PaymentLinkData) {
            return ((PaymentLinkData) baseModel).getEdcId();
        }
        return baseModel instanceof CreateLinkModel ? ((CreateLinkModel) baseModel).getEdcId() : "";
    }

    private String createLinkBody() {
        BaseModel baseModel = this.data;
        if (baseModel instanceof PaymentLinkData) {
            return AppUtility.createMessage(((PaymentLinkData) baseModel).getShortUrl(), ((PaymentLinkData) this.data).getAmount(), ((PaymentLinkData) this.data).getLinkDescription(), this);
        }
        return baseModel instanceof CreateLinkModel ? AppUtility.createMessage(((CreateLinkModel) baseModel).getShortUrl(), ((CreateLinkModel) this.data).getAmount(), ((CreateLinkModel) this.data).getLinkDescription(), this) : "";
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 0) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            DialogUtility.showAlert(this, "", getResources().getString(R.string.mp_go_to_settings_storage));
        } else {
            shareLink();
        }
    }

    /* access modifiers changed from: private */
    public void handleEmptyList() {
        this.isMonthChange = true;
        loadMoreItems();
    }
}
