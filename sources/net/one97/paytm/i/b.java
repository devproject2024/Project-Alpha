package net.one97.paytm.i;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.c;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRRechargeProductList;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.t;
import net.one97.paytm.utils.ao;
import net.one97.paytm.utils.j;
import net.one97.paytm.v;
import net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment;
import net.one97.paytm.widget.EditView;

public abstract class b extends h implements com.paytm.network.listener.b, t, EditView.a {
    protected RelativeLayout homepage_loading;
    protected CJRCatalog mCatalog;
    protected CJRFrequentOrderList mFrequentOrderList;
    protected String mFrequentOrderUrl;
    protected ProgressBar mProgessBarItemLoading;
    protected ProgressDialog mProgressDialog;
    protected Dialog mProgressDialog2;
    private v mUserChangeListener;

    public void clearFields() {
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void loadData() {
    }

    public void onActivityResult(int i2, Intent intent) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onFileWriteComplete(String str) {
    }

    public void onRefreshFragment() {
    }

    public abstract void onServerDataLoaded();

    public void setOperatorClickable(boolean z) {
    }

    public void setiReffData(CJRHomePageItem cJRHomePageItem) {
    }

    public abstract void updateData(CJRItem cJRItem);

    /* access modifiers changed from: protected */
    public void userLoggedOut() {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof v) {
            this.mUserChangeListener = (v) activity;
        }
        if (getArguments() != null && getArguments().getSerializable("CACHED_CATALOG_DATA") != null) {
            this.mCatalog = (CJRCatalog) getArguments().getSerializable("CACHED_CATALOG_DATA");
        }
    }

    public void loadPage(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (getActivity() == null || isDetached()) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String str9 = str;
            if (str.equalsIgnoreCase("nolink")) {
                return;
            }
        } else {
            String str10 = str;
        }
        ProgressBar progressBar = this.mProgessBarItemLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        j.a(getActivity(), str, iJRDataModel, str2, i2, arrayList, z, str3, str4, str5, str6, str7, str8);
    }

    public void loadPage(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        if (getActivity() != null && !isDetached()) {
            if (!TextUtils.isEmpty(str)) {
                String str4 = str;
                if (str.equalsIgnoreCase("nolink")) {
                    return;
                }
            } else {
                String str5 = str;
            }
            if (this.mProgessBarItemLoading != null && !isLoadedPageFromWallet(str)) {
                this.mProgessBarItemLoading.setVisibility(0);
            }
            j.a((Context) getActivity(), str, iJRDataModel, str2, i2, arrayList, z, str3, (c) null);
        }
    }

    private boolean isLoadedPageFromWallet(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("wallet-pay") || str.equalsIgnoreCase("wallet-lifafa") || str.equalsIgnoreCase("wallet-passbook") || str.equalsIgnoreCase("wallet-addmoney") || str.equalsIgnoreCase("wallet-acceptpayment") || str.equalsIgnoreCase("wallet-nearby") || str.equalsIgnoreCase("wallet-moneytransfer") || str.equalsIgnoreCase("wallet-upi") || str.equalsIgnoreCase("wallet-kyc");
        }
        return false;
    }

    public void loadBrandPdpPage(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (getActivity() == null || isDetached()) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String str9 = str;
            if (str.equalsIgnoreCase("nolink")) {
                return;
            }
        } else {
            String str10 = str;
        }
        ProgressBar progressBar = this.mProgessBarItemLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        j.a(getActivity(), str, iJRDataModel, str2, i2, arrayList, z, str3, str4, str5, str6, str7, str8);
    }

    public void showNetworkDialogNew(a aVar) {
        if (getActivity() != null && !isDetached()) {
            h hVar = new h(getActivity());
            hVar.setTitle(getResources().getString(R.string.no_connection));
            hVar.a(getResources().getString(R.string.no_internet));
            hVar.a(-3, getResources().getString(R.string.network_retry_yes), new View.OnClickListener(hVar, aVar) {
                private final /* synthetic */ h f$1;
                private final /* synthetic */ a f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    b.this.lambda$showNetworkDialogNew$0$b(this.f$1, this.f$2, view);
                }
            });
            hVar.show();
        }
    }

    public /* synthetic */ void lambda$showNetworkDialogNew$0$b(h hVar, a aVar, View view) {
        hVar.cancel();
        if (com.paytm.utility.a.m(getActivity())) {
            aVar.a();
        } else {
            showNetworkDialogNew(aVar);
        }
    }

    public void showNetworkDialog() {
        if (getActivity() != null && !isDetached()) {
            NoInternetAlertDialogFragment newInstance = NoInternetAlertDialogFragment.newInstance(false);
            ao.a(getClass(), "showNetworkDialog");
            newInstance.show(getFragmentManager().a(), "dialog");
        }
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog(Context context, String str) {
        if (getActivity() != null && isAdded()) {
            if (context != null || getActivity().isFinishing()) {
                ProgressDialog progressDialog = this.mProgressDialog;
                if (progressDialog == null || !progressDialog.isShowing()) {
                    this.mProgressDialog = new ProgressDialog(context);
                    try {
                        this.mProgressDialog.setProgressStyle(0);
                        this.mProgressDialog.setMessage(str);
                        this.mProgressDialog.setCancelable(true);
                        this.mProgressDialog.setCanceledOnTouchOutside(true);
                        this.mProgressDialog.show();
                    } catch (IllegalArgumentException e2) {
                        q.b(e2.getMessage());
                    } catch (Exception unused) {
                    }
                } else {
                    this.mProgressDialog.setMessage(str);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeProgressDialog() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                if (this.mProgressDialog != null && this.mProgressDialog.isShowing() && !getActivity().isFinishing()) {
                    this.mProgressDialog.dismiss();
                    this.mProgressDialog = null;
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void showSessionTimeoutAlert(VolleyError volleyError) {
        if (getActivity() != null && !isDetached() && !getActivity().isFinishing()) {
            h hVar = new h(getActivity());
            hVar.setTitle(getResources().getString(R.string.title_401_410));
            hVar.a(getResources().getString(R.string.message_401_410));
            hVar.setCancelable(false);
            hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener(hVar, volleyError) {
                private final /* synthetic */ h f$1;
                private final /* synthetic */ VolleyError f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    b.this.lambda$showSessionTimeoutAlert$1$b(this.f$1, this.f$2, view);
                }
            });
            hVar.show();
        }
    }

    public /* synthetic */ void lambda$showSessionTimeoutAlert$1$b(h hVar, VolleyError volleyError, View view) {
        hVar.cancel();
        sessionTimeoutClick(volleyError);
    }

    private void sessionTimeoutClick(VolleyError volleyError) {
        if (getActivity() != null && !isDetached()) {
            executeSignOutApi(volleyError);
            Intent intent = new Intent(getActivity(), AJRAuthActivity.class);
            intent.putExtra("authError", true);
            intent.putExtra("VERTICAL_NAME", "Recharge");
            startActivityForResult(intent, 3);
        }
    }

    private void executeSignOutApi(VolleyError volleyError) {
        if (getActivity() != null && !isDetached()) {
            try {
                net.one97.paytm.auth.b.b.a(getActivity(), false);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public void hideKeyboard() {
        if (getActivity() != null && !isDetached()) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkRechargeResponseTime(CJRRechargeProductList cJRRechargeProductList) {
        Long serverResponseTime;
        if (cJRRechargeProductList == null || (serverResponseTime = cJRRechargeProductList.getServerResponseTime()) == null || ((new Date().getTime() - serverResponseTime.longValue()) / 1000) / 60 >= 15) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean containsError(CJRRechargeCart cJRRechargeCart) {
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            return false;
        }
        Iterator<CJRCartProduct> it2 = cJRRechargeCart.getCart().getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next.getError() != null) {
                String errorTitle = next.getErrorTitle();
                if (errorTitle == null || errorTitle.trim().length() <= 0) {
                    errorTitle = getString(R.string.unable_to_proceed);
                }
                showAlertDialog(errorTitle, next.getError());
                return true;
            }
        }
        if (cJRRechargeCart.getCart().getError() == null) {
            return false;
        }
        if (cJRRechargeCart.getCart() != null) {
            String errorTitle2 = cJRRechargeCart.getCart().getErrorTitle();
            if (errorTitle2 == null || errorTitle2.trim().length() <= 0) {
                errorTitle2 = getString(R.string.unable_to_proceed);
            }
            showAlertDialog(errorTitle2, cJRRechargeCart.getCart().getError());
        } else {
            showAlertDialog(getString(R.string.network_error_heading), getString(R.string.network_error_message));
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void showAlertDialog(String str, String str2) {
        if (getString(R.string.unable_to_proceed).equals(str) && !TextUtils.isEmpty(str2)) {
            str = "utility_hide_title";
        }
        if (getContext() != null && getActivity() != null && !getActivity().isFinishing()) {
            com.paytm.utility.b.b(getContext(), str, str2);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mUserChangeListener = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mUserChangeListener = null;
    }

    public void KycStatusInstanceCleanup() {
        j.a();
    }
}
