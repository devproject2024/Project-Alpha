package com.business.merchant_payments.payment.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.business.common_module.b.e;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.g;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import com.business.merchant_payments.model.primary.PrimaryAPIModel;
import com.business.merchant_payments.model.primary.RewardsBalance;
import com.business.merchant_payments.payment.HomePaymentsDataHelper;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class PaymentsViewModel extends c {
    public ObservableBoolean goToTopVisibility;
    public LiveData<ArrayList<Object>> paymentModelList = new y();
    public HomePaymentsDataHelper paymentsDataHelper;
    public ObservableBoolean pushUpdates;
    public int pushUpdatesCount;
    public i<String> pushUpdatesString;
    public y<RewardsBalance> rewardPointsBalance = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsViewModel(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final LiveData<ArrayList<Object>> getPaymentModelList() {
        return this.paymentModelList;
    }

    public final void setPaymentModelList(LiveData<ArrayList<Object>> liveData) {
        k.d(liveData, "<set-?>");
        this.paymentModelList = liveData;
    }

    public final y<RewardsBalance> getRewardPointsBalance() {
        return this.rewardPointsBalance;
    }

    public final void setRewardPointsBalance(y<RewardsBalance> yVar) {
        k.d(yVar, "<set-?>");
        this.rewardPointsBalance = yVar;
    }

    public final ObservableBoolean getPushUpdates() {
        ObservableBoolean observableBoolean = this.pushUpdates;
        if (observableBoolean == null) {
            k.a("pushUpdates");
        }
        return observableBoolean;
    }

    public final void setPushUpdates(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.pushUpdates = observableBoolean;
    }

    public final i<String> getPushUpdatesString() {
        i<String> iVar = this.pushUpdatesString;
        if (iVar == null) {
            k.a("pushUpdatesString");
        }
        return iVar;
    }

    public final void setPushUpdatesString(i<String> iVar) {
        k.d(iVar, "<set-?>");
        this.pushUpdatesString = iVar;
    }

    public final ObservableBoolean getGoToTopVisibility() {
        ObservableBoolean observableBoolean = this.goToTopVisibility;
        if (observableBoolean == null) {
            k.a("goToTopVisibility");
        }
        return observableBoolean;
    }

    public final void setGoToTopVisibility(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.goToTopVisibility = observableBoolean;
    }

    public final void initDefaultParams() {
        this.paymentsDataHelper = new HomePaymentsDataHelper();
        this.pushUpdatesCount = 0;
        this.pushUpdates = new ObservableBoolean(false);
        this.pushUpdatesString = new i<>("");
        this.goToTopVisibility = new ObservableBoolean(false);
    }

    public final void fetchPaymentsData() {
        removePushUpdatesWidget();
        this.paymentsDataHelper = new HomePaymentsDataHelper();
        callPaymentsDataAPI();
    }

    private final void showPushUpdatesWidget(String str) {
        ObservableBoolean observableBoolean = this.pushUpdates;
        if (observableBoolean == null) {
            k.a("pushUpdates");
        }
        observableBoolean.set(true);
        i<String> iVar = this.pushUpdatesString;
        if (iVar == null) {
            k.a("pushUpdatesString");
        }
        iVar.set(str);
    }

    private final void removePushUpdatesWidget() {
        this.pushUpdatesCount = 0;
        ObservableBoolean observableBoolean = this.pushUpdates;
        if (observableBoolean == null) {
            k.a("pushUpdates");
        }
        observableBoolean.set(false);
        i<String> iVar = this.pushUpdatesString;
        if (iVar == null) {
            k.a("pushUpdatesString");
        }
        iVar.set("");
    }

    public final void handlePaymentPushNotification() {
        int i2 = this.pushUpdatesCount + 1;
        this.pushUpdatesCount = i2;
        if (i2 == 1) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            String string = instance.getAppContext().getString(R.string.mp_one_new_payment);
            k.b(string, "PaymentsConfig.getInstan…tring.mp_one_new_payment)");
            showPushUpdatesWidget(string);
        } else {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            String string2 = instance2.getAppContext().getString(R.string.mp_multiple_new_payments, new Object[]{String.valueOf(this.pushUpdatesCount)});
            k.b(string2, "PaymentsConfig.getInstan…hUpdatesCount.toString())");
            showPushUpdatesWidget(string2);
            PaymentsConfig instance3 = PaymentsConfig.getInstance();
            k.b(instance3, "PaymentsConfig.getInstance()");
            instance3.getEventPublisher().a(getContext(), "HomePage", "New Payment Popup Updated", "", String.valueOf(this.pushUpdatesCount - 1) + ";" + String.valueOf(this.pushUpdatesCount));
        }
        PaymentsConfig instance4 = PaymentsConfig.getInstance();
        k.b(instance4, "PaymentsConfig.getInstance()");
        instance4.getEventPublisher().a(getContext(), "HomePage", "New Payment Popup", "", "", "Promo Impression", "");
    }

    public final void handlePaymentPushNotificationClick() {
        fetchPaymentsData();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher().a(getContext(), "HomePage", "New Payment Popup", "", String.valueOf(this.pushUpdatesCount), "Promo Click", "");
    }

    public final void handleShowMoreClick() {
        if (getPaymentsShowMoreModel().getShowMoreButtonState().get()) {
            getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(true);
            HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
            if (homePaymentsDataHelper == null) {
                k.a("paymentsDataHelper");
            }
            if (!homePaymentsDataHelper.hasMorePayments()) {
                LiveData<ArrayList<Object>> liveData = this.paymentModelList;
                if (liveData != null) {
                    y yVar = (y) liveData;
                    HomePaymentsDataHelper homePaymentsDataHelper2 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper2 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar.setValue(homePaymentsDataHelper2.getFinalPaymentList());
                    getPaymentsShowMoreModel().getShowMoreButtonState().set(false);
                    getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(false);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
                }
            } else {
                getMorePaymentsForToday();
            }
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher().a(getContext(), "HomePage", "Payments Show More", "", "", "Promo Click", "");
            return;
        }
        LiveData<ArrayList<Object>> liveData2 = this.paymentModelList;
        if (liveData2 != null) {
            y yVar2 = (y) liveData2;
            HomePaymentsDataHelper homePaymentsDataHelper3 = this.paymentsDataHelper;
            if (homePaymentsDataHelper3 == null) {
                k.a("paymentsDataHelper");
            }
            yVar2.setValue(homePaymentsDataHelper3.getInitialPaymentList());
            getPaymentsShowMoreModel().getShowMoreButtonState().set(true);
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            e eventPublisher = instance2.getEventPublisher();
            Context context = getContext();
            HomePaymentsDataHelper homePaymentsDataHelper4 = this.paymentsDataHelper;
            if (homePaymentsDataHelper4 == null) {
                k.a("paymentsDataHelper");
            }
            eventPublisher.a(context, "HomePage", "Payments Show Less Clicked", "", homePaymentsDataHelper4.getTotalVisibleTransactions());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
    }

    private final void callPaymentsDataAPI() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().i()) {
            callPrimaryPaymentsAPI();
        } else {
            callNonMigratedPaymentsAPI();
        }
    }

    private final void callPrimaryPaymentsAPI() {
        LiveData<ArrayList<Object>> liveData = this.paymentModelList;
        if (liveData != null) {
            y yVar = (y) liveData;
            HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
            if (homePaymentsDataHelper == null) {
                k.a("paymentsDataHelper");
            }
            yVar.setValue(homePaymentsDataHelper.getLoadingStateList());
            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new PaymentsViewModel$callPrimaryPaymentsAPI$1(this, (d) null), 3, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
    }

    /* access modifiers changed from: private */
    public final void handlePrimaryAPIResponse(b<PrimaryAPIModel> bVar) {
        try {
            if (bVar.f7357b == com.business.common_module.utilities.a.e.LOADING) {
                LiveData<ArrayList<Object>> liveData = this.paymentModelList;
                if (liveData != null) {
                    y yVar = (y) liveData;
                    HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
                    if (homePaymentsDataHelper == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar.setValue(homePaymentsDataHelper.getLoadingStateList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
                this.rewardPointsBalance.setValue(((PrimaryAPIModel) bVar.f7358c).getRewardsBalance());
                HomePaymentsDataHelper homePaymentsDataHelper2 = this.paymentsDataHelper;
                if (homePaymentsDataHelper2 == null) {
                    k.a("paymentsDataHelper");
                }
                T t = bVar.f7358c;
                k.b(t, "response.data");
                homePaymentsDataHelper2.setDataFromPrimaryAPI((PrimaryAPIModel) t);
                LiveData<ArrayList<Object>> liveData2 = this.paymentModelList;
                if (liveData2 != null) {
                    y yVar2 = (y) liveData2;
                    HomePaymentsDataHelper homePaymentsDataHelper3 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper3 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar2.setValue(homePaymentsDataHelper3.getInitialPaymentList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.ERROR || bVar.f7357b == com.business.common_module.utilities.a.e.FAILURE) {
                LiveData<ArrayList<Object>> liveData3 = this.paymentModelList;
                if (liveData3 != null) {
                    y yVar3 = (y) liveData3;
                    HomePaymentsDataHelper homePaymentsDataHelper4 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper4 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar3.setValue(homePaymentsDataHelper4.getErrorStateList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.OFFLINE) {
                LiveData<ArrayList<Object>> liveData4 = this.paymentModelList;
                if (liveData4 != null) {
                    y yVar4 = (y) liveData4;
                    HomePaymentsDataHelper homePaymentsDataHelper5 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper5 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar4.setValue(homePaymentsDataHelper5.getErrorStateList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            LiveData<ArrayList<Object>> liveData5 = this.paymentModelList;
            if (liveData5 != null) {
                y yVar5 = (y) liveData5;
                HomePaymentsDataHelper homePaymentsDataHelper6 = this.paymentsDataHelper;
                if (homePaymentsDataHelper6 == null) {
                    k.a("paymentsDataHelper");
                }
                yVar5.setValue(homePaymentsDataHelper6.getErrorStateList());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
        }
    }

    private final void callNonMigratedPaymentsAPI() {
        LiveData<ArrayList<Object>> liveData = this.paymentModelList;
        if (liveData != null) {
            y yVar = (y) liveData;
            HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
            if (homePaymentsDataHelper == null) {
                k.a("paymentsDataHelper");
            }
            yVar.setValue(homePaymentsDataHelper.getLoadingStateList());
            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new PaymentsViewModel$callNonMigratedPaymentsAPI$1(this, DateUtility.getCurrentFormattedDate("dd MMMM yy"), (d) null), 3, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
    }

    /* access modifiers changed from: private */
    public final void handleNonMigratedAPIResponse(b<NonMigratedPaymentsModel> bVar) {
        try {
            if (bVar.f7357b == com.business.common_module.utilities.a.e.LOADING) {
                LiveData<ArrayList<Object>> liveData = this.paymentModelList;
                if (liveData != null) {
                    y yVar = (y) liveData;
                    HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
                    if (homePaymentsDataHelper == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar.setValue(homePaymentsDataHelper.getLoadingStateList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
                HomePaymentsDataHelper homePaymentsDataHelper2 = this.paymentsDataHelper;
                if (homePaymentsDataHelper2 == null) {
                    k.a("paymentsDataHelper");
                }
                T t = bVar.f7358c;
                k.b(t, "response.data");
                homePaymentsDataHelper2.setDataFromNonMigratedPaymentsAPI((NonMigratedPaymentsModel) t);
                LiveData<ArrayList<Object>> liveData2 = this.paymentModelList;
                if (liveData2 != null) {
                    y yVar2 = (y) liveData2;
                    HomePaymentsDataHelper homePaymentsDataHelper3 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper3 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar2.setValue(homePaymentsDataHelper3.getInitialPaymentList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.ERROR || bVar.f7357b == com.business.common_module.utilities.a.e.FAILURE) {
                LiveData<ArrayList<Object>> liveData3 = this.paymentModelList;
                if (liveData3 != null) {
                    y yVar3 = (y) liveData3;
                    HomePaymentsDataHelper homePaymentsDataHelper4 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper4 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar3.setValue(homePaymentsDataHelper4.getErrorStateList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.OFFLINE) {
                LiveData<ArrayList<Object>> liveData4 = this.paymentModelList;
                if (liveData4 != null) {
                    y yVar4 = (y) liveData4;
                    HomePaymentsDataHelper homePaymentsDataHelper5 = this.paymentsDataHelper;
                    if (homePaymentsDataHelper5 == null) {
                        k.a("paymentsDataHelper");
                    }
                    yVar4.setValue(homePaymentsDataHelper5.getErrorStateList());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            LiveData<ArrayList<Object>> liveData5 = this.paymentModelList;
            if (liveData5 != null) {
                y yVar5 = (y) liveData5;
                HomePaymentsDataHelper homePaymentsDataHelper6 = this.paymentsDataHelper;
                if (homePaymentsDataHelper6 == null) {
                    k.a("paymentsDataHelper");
                }
                yVar5.setValue(homePaymentsDataHelper6.getErrorStateList());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
        }
    }

    private final void getMorePaymentsForToday() {
        HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
        if (homePaymentsDataHelper == null) {
            k.a("paymentsDataHelper");
        }
        int pageForAPI = homePaymentsDataHelper.getPageForAPI();
        g gVar = g.f7371a;
        callV2OrderListAPIForDate(g.a("yyyy-MM-dd'T'HH:mm:ss"), pageForAPI);
    }

    private final void callV2OrderListAPIForDate(String str, int i2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new PaymentsViewModel$callV2OrderListAPIForDate$1(this, str, i2, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleOrderListAPIResponse(b<V2OrderListModel> bVar) {
        try {
            if (bVar.f7357b == com.business.common_module.utilities.a.e.LOADING) {
                getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(true);
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
                HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
                if (homePaymentsDataHelper == null) {
                    k.a("paymentsDataHelper");
                }
                List<OrderDetail> orderList = ((V2OrderListModel) bVar.f7358c).getOrderList();
                if (orderList != null) {
                    homePaymentsDataHelper.addMoreTransactions((ArrayList) orderList);
                    LiveData<ArrayList<Object>> liveData = this.paymentModelList;
                    if (liveData != null) {
                        y yVar = (y) liveData;
                        HomePaymentsDataHelper homePaymentsDataHelper2 = this.paymentsDataHelper;
                        if (homePaymentsDataHelper2 == null) {
                            k.a("paymentsDataHelper");
                        }
                        yVar.setValue(homePaymentsDataHelper2.getIntermediatePaymentsList());
                        getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(false);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.business.merchant_payments.payment.model.orderDetail.OrderDetail> /* = java.util.ArrayList<com.business.merchant_payments.payment.model.orderDetail.OrderDetail> */");
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.ERROR || bVar.f7357b == com.business.common_module.utilities.a.e.FAILURE) {
                getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(false);
            } else if (bVar.f7357b == com.business.common_module.utilities.a.e.OFFLINE) {
                getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(false);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            getPaymentsShowMoreModel().getShowMoreButtonProgressState().set(false);
        }
    }

    public final PaymentsShowMoreModel getPaymentsShowMoreModel() {
        HomePaymentsDataHelper homePaymentsDataHelper = this.paymentsDataHelper;
        if (homePaymentsDataHelper == null) {
            k.a("paymentsDataHelper");
        }
        return homePaymentsDataHelper.getShowMoreModel();
    }
}
