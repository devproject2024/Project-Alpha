package com.business.merchant_payments.newhome;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.fragment.app.j;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.c;
import com.business.common_module.utilities.i;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.BaseViewHolder;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.MPBaseAdapterDiffCallback;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.MpBwAlreadySettledElementBinding;
import com.business.merchant_payments.databinding.MpBwSettlementDetailNewBinding;
import com.business.merchant_payments.databinding.MpBwSettlementSingleBankElementBinding;
import com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding;
import com.business.merchant_payments.databinding.MpDotProgressBarLytBinding;
import com.business.merchant_payments.databinding.MpNoSettlementsDataViewBinding;
import com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding;
import com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBinding;
import com.business.merchant_payments.databinding.MpPaymentInfoTileBinding;
import com.business.merchant_payments.databinding.MpPaymentSettlementTabsBinding;
import com.business.merchant_payments.databinding.MpPaymentsEmptyLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsHomeHeaderBinding;
import com.business.merchant_payments.databinding.MpPaymentsLoaderLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsPermissionDeniedLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsShowMoreLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsSummaryLayoutBinding;
import com.business.merchant_payments.databinding.MpPaymentsTransactionItemBinding;
import com.business.merchant_payments.databinding.MpPendingSettlementCardItemBinding;
import com.business.merchant_payments.databinding.MpSettlementElementShimmerBinding;
import com.business.merchant_payments.databinding.MpSettlementRangeSummeryBinding;
import com.business.merchant_payments.databinding.MpSettlementSummaryShimmerCardBinding;
import com.business.merchant_payments.databinding.MpSmartGridBinding;
import com.business.merchant_payments.databinding.MpTitleTileBinding;
import com.business.merchant_payments.databinding.MpViewCustomCardBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;
import com.business.merchant_payments.model.kyc.KycBankInfoModel;
import com.business.merchant_payments.newhome.listener.IAcceptPaymentMainActivityListener;
import com.business.merchant_payments.payment.CustomCardViewModel;
import com.business.merchant_payments.payment.model.GenericErrorModel;
import com.business.merchant_payments.payment.model.HomeTabsModel;
import com.business.merchant_payments.payment.model.PaymentsEmptyModel;
import com.business.merchant_payments.payment.model.PaymentsHeaderModel;
import com.business.merchant_payments.payment.model.PaymentsLoaderModel;
import com.business.merchant_payments.payment.model.PaymentsPermissionDeniedModel;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;
import com.business.merchant_payments.payment.model.PaymentsSummaryModel;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.payment.model.QRGridModel;
import com.business.merchant_payments.settlement.SettlementDetail;
import com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.image_target.MpP4bBankImageTarget;
import com.business.merchant_payments.settlement.model.AdditionalInfoModel;
import com.business.merchant_payments.settlement.model.AmountModel;
import com.business.merchant_payments.settlement.model.ApiState;
import com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.M2BOrderListItemModel;
import com.business.merchant_payments.settlement.model.NoSettlementsDataAdapterModel;
import com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel;
import com.business.merchant_payments.settlement.model.PendingSettlementCardModel;
import com.business.merchant_payments.settlement.model.PreviouslyFailedBalanceData;
import com.business.merchant_payments.settlement.model.SettlementBankDetailModel;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;
import com.business.merchant_payments.settlement.model.TitleTileModel;
import com.business.merchant_payments.utility.UIUtilityMPKt;
import com.business.merchant_payments.widget.MpFlowLayout;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class HomeRVAdapter extends RecyclerView.a<RecyclerView.v> {
    public static final String AMOUNT_ERROR_TEXT = "--";
    public static final int BW_BALANCE = 1000;
    public static final Companion Companion = new Companion((g) null);
    public static final int FAILED = 2;
    public static final String INSTANT_SETTLED_TXN = "TRANSACTION_WISE_SETTLEMENT";
    public static final String LOAD_MORE = "loadMore";
    public static final int LOOK_FOR_END = 1;
    public static final int LOOK_FOR_NONE = -1;
    public static final int LOOK_FOR_SETTLEMENT_SUMMARY = 0;
    public static final int NO_SETTLEMENT = 5;
    public static final int PARTIAL_PENDING = 3;
    public static final int PARTIAL_SUCCESS = 4;
    public static final int PENDING = 1;
    public static final String SETTLEMENT_ELEMENT_SHIMMER = "settlementElementShimmer";
    public static final String SETTLEMENT_SUMMARY_SHIMMER = "settlementSummaryShimmer";
    public static final int SUCCESS = 0;
    public static final String TRANSACTION_WISE_SETTLEMENT = "Transaction Wise Settlement";
    public boolean isFirstTransaction = true;
    public final Context mContext;
    public StoreFrontGAHandler mGAListener;
    public final ArrayList<Object> mList;
    public final HomeRVListener mListener;
    public int mPreviousExpandedCardIndex = -1;
    public int mSettlementCardIndex = -1;
    public int mTitleTileIndex = -1;
    public final AcceptPaymentViewModel mViewModel;
    public String merchantSettleStatus = "";

    public final void addSettlements(ArrayList<SettlementBillListItemModel> arrayList) {
        addSettlements$default(this, arrayList, false, false, 6, (Object) null);
    }

    public final void addSettlements(ArrayList<SettlementBillListItemModel> arrayList, boolean z) {
        addSettlements$default(this, arrayList, z, false, 4, (Object) null);
    }

    public final void removeSettlementShimmer() {
        removeSettlementShimmer$default(this, 0, 0, false, false, 15, (Object) null);
    }

    public final void removeSettlementShimmer(int i2) {
        removeSettlementShimmer$default(this, i2, 0, false, false, 14, (Object) null);
    }

    public final void removeSettlementShimmer(int i2, int i3) {
        removeSettlementShimmer$default(this, i2, i3, false, false, 12, (Object) null);
    }

    public final void removeSettlementShimmer(int i2, int i3, boolean z) {
        removeSettlementShimmer$default(this, i2, i3, z, false, 8, (Object) null);
    }

    public HomeRVAdapter(Context context, ArrayList<Object> arrayList, HomeRVListener homeRVListener, AcceptPaymentViewModel acceptPaymentViewModel) {
        k.d(context, "mContext");
        k.d(arrayList, "list");
        k.d(homeRVListener, "mListener");
        k.d(acceptPaymentViewModel, "mViewModel");
        this.mContext = context;
        this.mListener = homeRVListener;
        this.mViewModel = acceptPaymentViewModel;
        this.mList = new ArrayList<>(arrayList);
    }

    public final StoreFrontGAHandler getMGAListener() {
        return this.mGAListener;
    }

    public final void setMGAListener(StoreFrontGAHandler storeFrontGAHandler) {
        this.mGAListener = storeFrontGAHandler;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final boolean isFirstTransaction() {
        return this.isFirstTransaction;
    }

    public final void setFirstTransaction(boolean z) {
        this.isFirstTransaction = z;
    }

    public final boolean isShimmerShowing() {
        return this.mList.contains(SETTLEMENT_ELEMENT_SHIMMER);
    }

    public enum CardType {
        HEADER(0),
        SUMMARY(1),
        TRANSACTION_ITEM(2),
        SHOW_MORE(3),
        TITLE_TILE(4),
        PAYMENT_SETTLEMENT_TABS(5),
        EMPTY_LAYOUT(6),
        LOADER(7),
        PERMISSION_DENIED_LAYOUT(8),
        INDEX_MARKER(9),
        IN_ACTIVE_MERCHANT(10),
        PAYMENTS_DIVIDER(11),
        QR(100),
        ONLINE_SETTLMENT_SUMMARY_CARD(H5ErrorCode.HTTP_NOT_IMPLEMENTED),
        ONLINE_SETTLEMENT_ELEMENT(H5ErrorCode.HTTP_BAD_GATEWAY),
        BW_SETTLEMENT_SUMMARY_CARD(1000),
        BW_SETTLEMENT_ELEMENT(1001),
        SETTLEMENT_RANGE_SUMMARY(1002),
        SETTLEMENT_SUMMARY_SHIMMER_CARD(H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY),
        SETTLEMENT_ELEMENT_SHIMMER_CARD(2001),
        LOAD_MORE_LOADER(2002),
        NO_SETTLEMENTS_DATA_CARD(H5RpcPlugin.RpcRequest.H5_APP_ERROR_CODE),
        GENERIC_ERROR_VIEW(2004),
        CUSTOM_CARD(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
        
        public final int value;

        /* access modifiers changed from: public */
        CardType(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public final int getItemViewType(int i2) {
        HomeRVListener homeRVListener = this.mListener;
        Object obj = this.mList.get(i2);
        k.b(obj, "mList[position]");
        if (homeRVListener.isInactiveMerchantData(obj)) {
            return CardType.IN_ACTIVE_MERCHANT.getValue();
        }
        Object obj2 = this.mList.get(i2);
        if (obj2 instanceof String) {
            Object obj3 = this.mList.get(i2);
            if (obj3 != null) {
                String str = (String) obj3;
                int hashCode = str.hashCode();
                if (hashCode != -1601685500) {
                    if (hashCode != 518845422) {
                        if (hashCode != 1845399899 || !str.equals(LOAD_MORE)) {
                            return 0;
                        }
                        return CardType.LOAD_MORE_LOADER.getValue();
                    } else if (str.equals(SETTLEMENT_ELEMENT_SHIMMER)) {
                        return CardType.SETTLEMENT_ELEMENT_SHIMMER_CARD.getValue();
                    } else {
                        return 0;
                    }
                } else if (str.equals(SETTLEMENT_SUMMARY_SHIMMER)) {
                    return CardType.SETTLEMENT_SUMMARY_SHIMMER_CARD.getValue();
                } else {
                    return 0;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (obj2 instanceof PaymentsLoaderModel) {
            return CardType.LOADER.getValue();
        } else {
            if (obj2 instanceof HomeTabsModel) {
                return CardType.PAYMENT_SETTLEMENT_TABS.getValue();
            }
            if (obj2 instanceof PaymentsHeaderModel) {
                return CardType.HEADER.getValue();
            }
            if (obj2 instanceof PaymentsSummaryModel) {
                return CardType.SUMMARY.getValue();
            }
            if (obj2 instanceof PaymentsTransactionModel) {
                return CardType.TRANSACTION_ITEM.getValue();
            }
            if (obj2 instanceof PaymentsShowMoreModel) {
                return CardType.SHOW_MORE.getValue();
            }
            if (obj2 instanceof PaymentsEmptyModel) {
                return CardType.EMPTY_LAYOUT.getValue();
            }
            if ((obj2 instanceof CustomCardStartMarker) || (obj2 instanceof CustomCardEndMarker) || (obj2 instanceof TabsStartMarker)) {
                return CardType.INDEX_MARKER.getValue();
            }
            if (obj2 instanceof TabsEndMarker) {
                return CardType.PAYMENTS_DIVIDER.getValue();
            }
            if (obj2 instanceof PaymentsPermissionDeniedModel) {
                return CardType.PERMISSION_DENIED_LAYOUT.getValue();
            }
            if (obj2 instanceof TitleTileModel) {
                this.mTitleTileIndex = i2;
                return CardType.TITLE_TILE.getValue();
            } else if (obj2 instanceof OnlineSettlementCardSummaryAdapteerModel) {
                return CardType.ONLINE_SETTLMENT_SUMMARY_CARD.getValue();
            } else {
                if (obj2 instanceof BWSettlementCardSummaryAdapterModel) {
                    return CardType.BW_SETTLEMENT_SUMMARY_CARD.getValue();
                }
                if (obj2 instanceof SettlementBillListItemModel) {
                    Object obj4 = this.mList.get(i2);
                    if (obj4 != null) {
                        SettlementBillListItemModel settlementBillListItemModel = (SettlementBillListItemModel) obj4;
                        if (p.a(settlementBillListItemModel.getSettleMode(), P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT, true) || p.a(settlementBillListItemModel.getSettleMode(), P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT, true)) {
                            return CardType.ONLINE_SETTLEMENT_ELEMENT.getValue();
                        }
                        return CardType.BW_SETTLEMENT_ELEMENT.getValue();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.settlement.model.SettlementBillListItemModel");
                } else if (obj2 instanceof NoSettlementsDataAdapterModel) {
                    return CardType.NO_SETTLEMENTS_DATA_CARD.getValue();
                } else {
                    if (obj2 instanceof View) {
                        WidgetLayoutType.Companion companion = WidgetLayoutType.Companion;
                        Object obj5 = this.mList.get(i2);
                        if (obj5 != null) {
                            return companion.getLayoutTypeIndexfromName((View) obj5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.paytmmall.clpartifact.modal.clpCommon.View");
                    } else if (obj2 instanceof GenericErrorModel) {
                        return CardType.GENERIC_ERROR_VIEW.getValue();
                    } else {
                        if (obj2 instanceof CustomCardUIModel) {
                            return CardType.CUSTOM_CARD.getValue();
                        }
                        if (obj2 instanceof SettlementRangeSummaryModel) {
                            this.mSettlementCardIndex = i2;
                            return CardType.SETTLEMENT_RANGE_SUMMARY.getValue();
                        } else if (obj2 instanceof QRGridModel) {
                            return CardType.QR.getValue();
                        } else {
                            return -2020;
                        }
                    }
                }
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.d(viewGroup, "parent");
        if (i2 == CardType.PAYMENT_SETTLEMENT_TABS.getValue()) {
            MpPaymentSettlementTabsBinding inflate = MpPaymentSettlementTabsBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate, "MpPaymentSettlementTabsB…mContext), parent, false)");
            return new PaymentSettlementTabsViewHolder(this, inflate);
        } else if (i2 == CardType.HEADER.getValue()) {
            MpPaymentsHomeHeaderBinding inflate2 = MpPaymentsHomeHeaderBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate2, "MpPaymentsHomeHeaderBind…mContext), parent, false)");
            return new HeaderLayoutViewHolder(this, inflate2);
        } else if (i2 == CardType.LOADER.getValue()) {
            MpPaymentsLoaderLayoutBinding inflate3 = MpPaymentsLoaderLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate3, "MpPaymentsLoaderLayoutBi…mContext), parent, false)");
            return new LoaderLayoutViewHolder(this, inflate3);
        } else if (i2 == CardType.SUMMARY.getValue()) {
            MpPaymentsSummaryLayoutBinding inflate4 = MpPaymentsSummaryLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate4, "MpPaymentsSummaryLayoutB…mContext), parent, false)");
            return new SummaryLayoutViewHolder(this, inflate4);
        } else if (i2 == CardType.TRANSACTION_ITEM.getValue()) {
            MpPaymentsTransactionItemBinding inflate5 = MpPaymentsTransactionItemBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate5, "MpPaymentsTransactionIte…mContext), parent, false)");
            return new TransactionItemViewHolder(this, inflate5);
        } else if (i2 == CardType.SHOW_MORE.getValue()) {
            MpPaymentsShowMoreLayoutBinding inflate6 = MpPaymentsShowMoreLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate6, "MpPaymentsShowMoreLayout…mContext), parent, false)");
            return new ShowMoreLayoutViewHolder(this, inflate6);
        } else if (i2 == CardType.EMPTY_LAYOUT.getValue()) {
            MpPaymentsEmptyLayoutBinding inflate7 = MpPaymentsEmptyLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate7, "MpPaymentsEmptyLayoutBin…mContext), parent, false)");
            return new EmptyLayoutViewHolder(this, inflate7);
        } else if (i2 == CardType.PERMISSION_DENIED_LAYOUT.getValue()) {
            MpPaymentsPermissionDeniedLayoutBinding inflate8 = MpPaymentsPermissionDeniedLayoutBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate8, "MpPaymentsPermissionDeni…mContext), parent, false)");
            return new PermissionDeniedLayoutViewHolder(this, inflate8);
        } else if (i2 == CardType.TITLE_TILE.getValue()) {
            MpTitleTileBinding inflate9 = MpTitleTileBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate9, "MpTitleTileBinding.infla…mContext), parent, false)");
            return new TitleTileViewHolder(this, inflate9);
        } else if (i2 == CardType.INDEX_MARKER.getValue()) {
            android.view.View inflate10 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp_empty_view, viewGroup, false);
            k.b(inflate10, "emptyView");
            return new EmptyViewHolder(this, inflate10);
        } else if (i2 == CardType.PAYMENTS_DIVIDER.getValue()) {
            android.view.View inflate11 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp_payment_border, viewGroup, false);
            k.b(inflate11, "emptyView");
            return new PaymentsBorderHolder(this, inflate11);
        } else if (i2 == CardType.ONLINE_SETTLMENT_SUMMARY_CARD.getValue()) {
            MpOnlineSettlementSummaryCardBinding inflate12 = MpOnlineSettlementSummaryCardBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate12, "MpOnlineSettlementSummar…mContext), parent, false)");
            return new OnlineSettlementSummaryCardViewHolder(this, inflate12);
        } else if (i2 == CardType.ONLINE_SETTLEMENT_ELEMENT.getValue()) {
            MpOnlineSettlementElementBinding inflate13 = MpOnlineSettlementElementBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate13, "MpOnlineSettlementElemen…mContext), parent, false)");
            return new OnlineSettlementElementViewHolder(this, inflate13);
        } else if (i2 == CardType.BW_SETTLEMENT_SUMMARY_CARD.getValue()) {
            MpBwSettlementSummaryCardBinding inflate14 = MpBwSettlementSummaryCardBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate14, "MpBwSettlementSummaryCar…mContext), parent, false)");
            return new BWSettlementSummaryCardViewHolder(this, inflate14);
        } else if (i2 == CardType.BW_SETTLEMENT_ELEMENT.getValue()) {
            MpBwSettlementSingleBankElementBinding inflate15 = MpBwSettlementSingleBankElementBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate15, "MpBwSettlementSingleBank…mContext), parent, false)");
            return new BWSettlementElementViewHolder(this, inflate15);
        } else if (i2 == CardType.SETTLEMENT_SUMMARY_SHIMMER_CARD.getValue()) {
            MpSettlementSummaryShimmerCardBinding inflate16 = MpSettlementSummaryShimmerCardBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate16, "MpSettlementSummaryShimm…mContext), parent, false)");
            return new SettlementSummaryShimmerViewHolder(this, inflate16);
        } else if (i2 == CardType.SETTLEMENT_ELEMENT_SHIMMER_CARD.getValue()) {
            MpSettlementElementShimmerBinding inflate17 = MpSettlementElementShimmerBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate17, "MpSettlementElementShimm…mContext), parent, false)");
            return new SettlementElementShimmerViewHolder(this, inflate17);
        } else if (i2 == CardType.LOAD_MORE_LOADER.getValue()) {
            MpDotProgressBarLytBinding inflate18 = MpDotProgressBarLytBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate18, "MpDotProgressBarLytBindi…mContext), parent, false)");
            return new AddMoreViewHolder(this, inflate18);
        } else if (i2 == CardType.NO_SETTLEMENTS_DATA_CARD.getValue()) {
            MpNoSettlementsDataViewBinding inflate19 = MpNoSettlementsDataViewBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate19, "MpNoSettlementsDataViewB…mContext), parent, false)");
            return new NoSettlementsDataViewHolder(this, inflate19);
        } else if (i2 == CardType.GENERIC_ERROR_VIEW.getValue()) {
            android.view.View inflate20 = LayoutInflater.from(this.mContext).inflate(R.layout.mp_general_error_lyt, viewGroup, false);
            k.b(inflate20, "noInternetView");
            return new GeneralErrorViewHolder(this, inflate20);
        } else if (i2 == CardType.CUSTOM_CARD.getValue()) {
            MpViewCustomCardBinding inflate21 = MpViewCustomCardBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
            k.b(inflate21, "MpViewCustomCardBinding.…mContext), parent, false)");
            return new CustomCardDataViewHolder(this, inflate21);
        } else if (i2 == CardType.IN_ACTIVE_MERCHANT.getValue()) {
            return this.mListener.getInactivateMerchantViewHolder(viewGroup);
        } else {
            if (i2 == CardType.SETTLEMENT_RANGE_SUMMARY.getValue()) {
                MpSettlementRangeSummeryBinding inflate22 = MpSettlementRangeSummeryBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
                k.b(inflate22, "MpSettlementRangeSummery…mContext), parent, false)");
                return new SettlementRangeSummaryViewHolder(this, inflate22);
            } else if (i2 == CardType.QR.getValue()) {
                MpSmartGridBinding inflate23 = MpSmartGridBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
                k.b(inflate23, "MpSmartGridBinding.infla…mContext), parent, false)");
                return new P4BSmartGridViewHolder(inflate23);
            } else {
                CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.mGAListener);
                k.b(viewHolder, "ViewHolderFactory.getVie…ype)), null, mGAListener)");
                return viewHolder;
            }
        }
    }

    public final int getItemCount() {
        return this.mList.size();
    }

    public static /* synthetic */ void addSettlements$default(HomeRVAdapter homeRVAdapter, ArrayList arrayList, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        homeRVAdapter.addSettlements(arrayList, z, z2);
    }

    public final void addSettlements(ArrayList<SettlementBillListItemModel> arrayList, boolean z, boolean z2) {
        k.d(arrayList, "settlements");
        int size = arrayList.size();
        int indexOf = this.mList.indexOf(SETTLEMENT_ELEMENT_SHIMMER);
        if (indexOf != -1) {
            ArrayList<Object> arrayList2 = this.mList;
            arrayList2.subList(indexOf, arrayList2.size()).clear();
            notifyDataSetChanged();
            if (z) {
                ArrayList<Object> arrayList3 = this.mList;
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                String string = instance.getAppContext().getString(R.string.mp_label_previous_settlements);
                k.b(string, "PaymentsConfig.getInstan…bel_previous_settlements)");
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                String string2 = instance2.getAppContext().getString(R.string.mp_label_view_past_settlements);
                k.b(string2, "PaymentsConfig.getInstan…el_view_past_settlements)");
                arrayList3.add(new TitleTileModel(string, true, string2, z2));
                size++;
            }
            this.mList.addAll(arrayList);
            notifyItemRangeInserted(indexOf, size);
            return;
        }
        int size2 = this.mList.size();
        this.mList.addAll(arrayList);
        notifyItemRangeInserted(size2, size);
    }

    public final void addLoadingFooter() {
        this.mList.add(LOAD_MORE);
        notifyItemInserted(this.mList.size() - 1);
    }

    public final void removeLoadingFooter() {
        int size = this.mList.size() - 1;
        Object obj = this.mList.get(size);
        k.b(obj, "mList[lastIndex]");
        if ((obj instanceof String) && k.a(obj, (Object) LOAD_MORE)) {
            this.mList.remove(size);
            notifyItemRemoved(size);
        }
    }

    public static /* synthetic */ void removeSettlementShimmer$default(HomeRVAdapter homeRVAdapter, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = R.string.mp_label_no_settlemeents_for_30_days_text;
        }
        if ((i4 & 2) != 0) {
            i3 = R.drawable.mp_no_settlements;
        }
        if ((i4 & 4) != 0) {
            z = true;
        }
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        homeRVAdapter.removeSettlementShimmer(i2, i3, z, z2);
    }

    public final void removeSettlementShimmer(int i2, int i3, boolean z, boolean z2) {
        int indexOf = this.mList.indexOf(SETTLEMENT_ELEMENT_SHIMMER);
        if (indexOf != -1) {
            GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
            Context context = this.mContext;
            singleInstance.sendEvent(context, "HomePage", "Settlement Widget", "", "No Settlement;" + this.mViewModel.getMMerchantSettlemntTypeGA());
            ArrayList<Object> arrayList = this.mList;
            arrayList.subList(indexOf, arrayList.size()).clear();
            if (z) {
                ArrayList<Object> arrayList2 = this.mList;
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                String string = instance.getAppContext().getString(R.string.mp_label_previous_settlements);
                k.b(string, "PaymentsConfig.getInstan…bel_previous_settlements)");
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                String string2 = instance2.getAppContext().getString(R.string.mp_label_view_past_settlements);
                k.b(string2, "PaymentsConfig.getInstan…el_view_past_settlements)");
                arrayList2.add(new TitleTileModel(string, false, string2, false));
            }
            this.mList.add(new NoSettlementsDataAdapterModel(i3, i2, 0, z2));
            notifyDataSetChanged();
        }
    }

    private final void setAlternatingViewColor(int i2, android.view.View view) {
        int i3;
        if (i2 % 2 == 0) {
            i3 = b.c(this.mContext, R.color.color_f5f9fe);
        } else {
            i3 = b.c(this.mContext, R.color.white);
        }
        view.setBackgroundColor(i3);
    }

    private final void setAlternatingViewBackground(int i2, android.view.View view) {
        Drawable drawable;
        if (i2 % 2 == 0) {
            drawable = b.a(this.mContext, R.drawable.mp_grey_border_background_rounded_rect);
        } else {
            drawable = b.a(this.mContext, R.drawable.mp_grey_border_rounded_rect);
        }
        view.setBackground(drawable);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.d(vVar, "holder");
        if (vVar instanceof BaseViewHolder) {
            ((BaseViewHolder) vVar).bindData(this.mList.get(i2), i2);
        } else if (vVar instanceof PaymentSettlementTabsViewHolder) {
            if (this.mList.get(i2) instanceof HomeTabsModel) {
                ((PaymentSettlementTabsViewHolder) vVar).bindData(this.mViewModel);
            }
        } else if (vVar instanceof CLPBaseViewHolder) {
            CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
            Object obj = this.mList.get(i2);
            if (obj != null) {
                View view = (View) obj;
                HashMap hashMap = new HashMap();
                hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(i2));
                view.setGaData(hashMap);
                cLPBaseViewHolder.bind(view, (CLPBaseViewHolder.IParentListProvider) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.paytmmall.clpartifact.modal.clpCommon.View");
        }
    }

    public final void updateRVAdapterList(ArrayList<Object> arrayList) {
        k.d(arrayList, "newList");
        h.b a2 = h.a(new MPBaseAdapterDiffCallback(this.mList, arrayList));
        k.b(a2, "DiffUtil.calculateDiff(diffCallback)");
        this.mList.clear();
        this.mList.addAll(arrayList);
        a2.a((RecyclerView.a) this);
    }

    public final void updateMerchantStatus(String str) {
        this.merchantSettleStatus = str;
    }

    public final class PaymentSettlementTabsViewHolder extends RecyclerView.v {
        public final MpPaymentSettlementTabsBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentSettlementTabsViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentSettlementTabsBinding mpPaymentSettlementTabsBinding) {
            super(mpPaymentSettlementTabsBinding.getRoot());
            k.d(mpPaymentSettlementTabsBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpPaymentSettlementTabsBinding;
            TextView textView = mpPaymentSettlementTabsBinding.paymentsTab;
            k.b(textView, "mBinding.paymentsTab");
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            TextView textView2 = this.mBinding.settlementsTab;
            k.b(textView2, "mBinding.settlementsTab");
            textView2.setTypeface(Typeface.SANS_SERIF);
            TextView textView3 = this.mBinding.paymentsTab;
            k.b(textView3, "mBinding.paymentsTab");
            textView3.setSelected(true);
            TextView textView4 = this.mBinding.settlementsTab;
            k.b(textView4, "mBinding.settlementsTab");
            textView4.setSelected(false);
            this.mBinding.paymentsTab.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PaymentSettlementTabsViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    this.this$0.this$0.mListener.onPaymentsTabClick();
                    TextView textView = this.this$0.getMBinding().paymentsTab;
                    k.b(textView, "mBinding.paymentsTab");
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                    TextView textView2 = this.this$0.getMBinding().settlementsTab;
                    k.b(textView2, "mBinding.settlementsTab");
                    textView2.setTypeface(Typeface.SANS_SERIF);
                    TextView textView3 = this.this$0.getMBinding().paymentsTab;
                    k.b(textView3, "mBinding.paymentsTab");
                    textView3.setSelected(true);
                    TextView textView4 = this.this$0.getMBinding().settlementsTab;
                    k.b(textView4, "mBinding.settlementsTab");
                    textView4.setSelected(false);
                }
            });
            this.mBinding.settlementsTab.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PaymentSettlementTabsViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    this.this$0.this$0.mListener.onSettlementTabClick();
                    TextView textView = this.this$0.getMBinding().paymentsTab;
                    k.b(textView, "mBinding.paymentsTab");
                    textView.setTypeface(Typeface.SANS_SERIF);
                    TextView textView2 = this.this$0.getMBinding().settlementsTab;
                    k.b(textView2, "mBinding.settlementsTab");
                    textView2.setTypeface(Typeface.DEFAULT_BOLD);
                    TextView textView3 = this.this$0.getMBinding().paymentsTab;
                    k.b(textView3, "mBinding.paymentsTab");
                    textView3.setSelected(false);
                    TextView textView4 = this.this$0.getMBinding().settlementsTab;
                    k.b(textView4, "mBinding.settlementsTab");
                    textView4.setSelected(true);
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.this$0.mContext, "HomePage", "Settlement Tab Clicked", "", this.this$0.this$0.mViewModel.getMMerchantSettlemntTypeGA(), "");
                }
            });
        }

        public final MpPaymentSettlementTabsBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(AcceptPaymentViewModel acceptPaymentViewModel) {
            k.d(acceptPaymentViewModel, "model");
            this.mBinding.setModel(acceptPaymentViewModel);
        }
    }

    public final class HeaderLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentsHomeHeaderBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderLayoutViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsHomeHeaderBinding mpPaymentsHomeHeaderBinding) {
            super(mpPaymentsHomeHeaderBinding.getRoot());
            k.d(mpPaymentsHomeHeaderBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpPaymentsHomeHeaderBinding;
            mpPaymentsHomeHeaderBinding.date.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ HeaderLayoutViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.this$0.mContext, "HomePage", "View Past Payments Clicked", "", "");
                    this.this$0.this$0.mListener.onViewPastPaymentsClick();
                }
            });
        }

        public final MpPaymentsHomeHeaderBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsHeaderModel) {
                this.mBinding.setModel((PaymentsHeaderModel) obj);
            }
        }
    }

    public final class LoaderLayoutViewHolder extends RecyclerView.v {
        public final MpPaymentsLoaderLayoutBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoaderLayoutViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsLoaderLayoutBinding mpPaymentsLoaderLayoutBinding) {
            super(mpPaymentsLoaderLayoutBinding.getRoot());
            k.d(mpPaymentsLoaderLayoutBinding, "mBinding");
            this.mBinding = mpPaymentsLoaderLayoutBinding;
        }

        public final MpPaymentsLoaderLayoutBinding getMBinding() {
            return this.mBinding;
        }
    }

    public final class EmptyViewHolder extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyViewHolder(HomeRVAdapter homeRVAdapter, android.view.View view) {
            super(view);
            k.d(view, "view");
        }
    }

    public final class PaymentsBorderHolder extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentsBorderHolder(HomeRVAdapter homeRVAdapter, android.view.View view) {
            super(view);
            k.d(view, "view");
        }
    }

    public final class PermissionDeniedLayoutViewHolder extends RecyclerView.v {
        public final MpPaymentsPermissionDeniedLayoutBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PermissionDeniedLayoutViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsPermissionDeniedLayoutBinding mpPaymentsPermissionDeniedLayoutBinding) {
            super(mpPaymentsPermissionDeniedLayoutBinding.getRoot());
            k.d(mpPaymentsPermissionDeniedLayoutBinding, "mBinding");
            this.mBinding = mpPaymentsPermissionDeniedLayoutBinding;
        }

        public final MpPaymentsPermissionDeniedLayoutBinding getMBinding() {
            return this.mBinding;
        }
    }

    public final class SummaryLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentsSummaryLayoutBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SummaryLayoutViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsSummaryLayoutBinding mpPaymentsSummaryLayoutBinding) {
            super(mpPaymentsSummaryLayoutBinding.getRoot());
            k.d(mpPaymentsSummaryLayoutBinding, "mBinding");
            this.mBinding = mpPaymentsSummaryLayoutBinding;
        }

        public final MpPaymentsSummaryLayoutBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsSummaryModel) {
                this.mBinding.setModel((PaymentsSummaryModel) obj);
            }
        }
    }

    public final class TransactionItemViewHolder extends BaseViewHolder {
        public final MpPaymentsTransactionItemBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransactionItemViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsTransactionItemBinding mpPaymentsTransactionItemBinding) {
            super(mpPaymentsTransactionItemBinding.getRoot());
            k.d(mpPaymentsTransactionItemBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpPaymentsTransactionItemBinding;
            mpPaymentsTransactionItemBinding.transactionRoot.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ TransactionItemViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    String str;
                    PaymentsTransactionModel model = this.this$0.getMBinding().getModel();
                    if (model != null) {
                        if (model.getOrderDetail().getMPayMode() != null) {
                            str = model.getOrderDetail().getMPayMode();
                            k.a((Object) str);
                        } else {
                            str = "";
                        }
                        String str2 = (model.getOrderDetail().getBizType() == null || !p.a(model.getOrderDetail().getBizType(), "REFUND", true)) ? "Not Refund" : "Refund";
                        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.this$0.mContext, "HomePage", "Payment Widget", "", String.valueOf(model.getNo()) + ";" + model.getAmount() + ";" + str + ";;" + str2, "Promo Click");
                        this.this$0.this$0.mListener.onTransactionItemClick(model.getOrderDetail());
                    }
                }
            });
        }

        public final MpPaymentsTransactionItemBinding getMBinding() {
            return this.mBinding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            r1 = r1.getOrderDetail();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindData(java.lang.Object r1, int r2) {
            /*
                r0 = this;
                boolean r2 = r1 instanceof com.business.merchant_payments.payment.model.PaymentsTransactionModel
                if (r2 == 0) goto L_0x0028
                com.business.merchant_payments.databinding.MpPaymentsTransactionItemBinding r2 = r0.mBinding
                com.business.merchant_payments.payment.model.PaymentsTransactionModel r1 = (com.business.merchant_payments.payment.model.PaymentsTransactionModel) r1
                r2.setModel(r1)
                boolean r1 = com.business.merchant_payments.utility.MPConstants.isP4BClient()
                if (r1 == 0) goto L_0x0028
                com.business.merchant_payments.databinding.MpPaymentsTransactionItemBinding r1 = r0.mBinding
                com.business.merchant_payments.payment.model.PaymentsTransactionModel r1 = r1.getModel()
                if (r1 == 0) goto L_0x0024
                com.business.merchant_payments.payment.model.orderDetail.OrderDetail r1 = r1.getOrderDetail()
                if (r1 == 0) goto L_0x0024
                java.lang.String r1 = r1.getTxnSettleType()
                goto L_0x0025
            L_0x0024:
                r1 = 0
            L_0x0025:
                r0.handleInstantSettlementMarks(r1)
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.TransactionItemViewHolder.bindData(java.lang.Object, int):void");
        }

        public final void handleInstantSettlementMarks(String str) {
            APSharedPreferences instance = APSharedPreferences.getInstance();
            if (this.this$0.isFirstTransaction() && instance.shouldCheckForInstantSett()) {
                if (instance.wasInstantSettlementActivated() || !p.a(str, HomeRVAdapter.INSTANT_SETTLED_TXN, false)) {
                    if (instance.wasInstantSettlementActivated() && !p.a(str, HomeRVAdapter.INSTANT_SETTLED_TXN, false)) {
                        showSwitchedFromInstantDialog();
                    }
                } else if (instance.getIsAppTutorialComplete(this.this$0.mContext)) {
                    showMarkForInstantSettlement();
                }
                this.this$0.setFirstTransaction(false);
            }
        }

        public final void showSwitchedFromInstantDialog() {
            APSharedPreferences instance = APSharedPreferences.getInstance();
            k.b(instance, "apSharedPreferences");
            if (p.a(instance.getISTrackedMerchantId(), instance.getMerchantMid(), true)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.mContext);
                Context access$getMContext$p = this.this$0.mContext;
                if (access$getMContext$p != null) {
                    android.view.View inflate = ((AppCompatActivity) access$getMContext$p).getLayoutInflater().inflate(R.layout.mp_dialog_shifted_from_instant_settlement, (ViewGroup) null);
                    builder.setView(inflate);
                    builder.setCancelable(true);
                    AlertDialog create = builder.create();
                    k.b(create, "dialog");
                    Window window = create.getWindow();
                    ((TextView) inflate.findViewById(R.id.tv_okay)).setOnClickListener(new HomeRVAdapter$TransactionItemViewHolder$showSwitchedFromInstantDialog$1(create));
                    InsetDrawable insetDrawable = new InsetDrawable(new ColorDrawable(0), AppUtility.convertDpToPixel(49.0f, this.this$0.mContext));
                    if (window != null) {
                        window.setBackgroundDrawable(insetDrawable);
                    }
                    if (window != null) {
                        window.setLayout(-1, -1);
                    }
                    new Handler().postDelayed(new HomeRVAdapter$TransactionItemViewHolder$showSwitchedFromInstantDialog$2(create), 700);
                    instance.setShouldCheckForInstantSett(false);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
        }

        public final void showMarkForInstantSettlement() {
            new Handler().postDelayed(new HomeRVAdapter$TransactionItemViewHolder$showMarkForInstantSettlement$1(this), 2000);
        }
    }

    public final class ShowMoreLayoutViewHolder extends BaseViewHolder {
        public final MpPaymentsShowMoreLayoutBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowMoreLayoutViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsShowMoreLayoutBinding mpPaymentsShowMoreLayoutBinding) {
            super(mpPaymentsShowMoreLayoutBinding.getRoot());
            k.d(mpPaymentsShowMoreLayoutBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpPaymentsShowMoreLayoutBinding;
            mpPaymentsShowMoreLayoutBinding.showMoreBtn.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ ShowMoreLayoutViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    this.this$0.this$0.mListener.onShowMoreClick();
                }
            });
            this.mBinding.showLessBtn.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ ShowMoreLayoutViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    this.this$0.this$0.mListener.onShowMoreClick();
                }
            });
        }

        public final MpPaymentsShowMoreLayoutBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof PaymentsShowMoreModel) {
                this.mBinding.setModel((PaymentsShowMoreModel) obj);
            }
        }
    }

    public final class EmptyLayoutViewHolder extends RecyclerView.v {
        public final MpPaymentsEmptyLayoutBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyLayoutViewHolder(HomeRVAdapter homeRVAdapter, MpPaymentsEmptyLayoutBinding mpPaymentsEmptyLayoutBinding) {
            super(mpPaymentsEmptyLayoutBinding.getRoot());
            k.d(mpPaymentsEmptyLayoutBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpPaymentsEmptyLayoutBinding;
            mpPaymentsEmptyLayoutBinding.viewPastPayments.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ EmptyLayoutViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.this$0.mContext, "HomePage", "View Past Payments Clicked", "", "No Payments Today");
                    this.this$0.this$0.mListener.onViewPastPaymentsClick();
                }
            });
        }

        public final MpPaymentsEmptyLayoutBinding getMBinding() {
            return this.mBinding;
        }
    }

    public final class TitleTileViewHolder extends BaseViewHolder {
        public final MpTitleTileBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TitleTileViewHolder(HomeRVAdapter homeRVAdapter, MpTitleTileBinding mpTitleTileBinding) {
            super(mpTitleTileBinding.getRoot());
            k.d(mpTitleTileBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpTitleTileBinding;
        }

        public final MpTitleTileBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof TitleTileModel) {
                MpRoboTextView mpRoboTextView = this.mBinding.tileTitle;
                k.b(mpRoboTextView, "mBinding.tileTitle");
                TitleTileModel titleTileModel = (TitleTileModel) obj;
                mpRoboTextView.setText(titleTileModel.getLabelTitle());
                LinearLayout linearLayout = this.mBinding.calendarContainer;
                k.b(linearLayout, "mBinding.calendarContainer");
                linearLayout.setVisibility(titleTileModel.getShouldShowDateRange() ? 0 : 8);
                this.mBinding.calendarContainer.setOnClickListener(new HomeRVAdapter$TitleTileViewHolder$bindData$1(this));
                MpRoboTextView mpRoboTextView2 = this.mBinding.dateRangeText;
                k.b(mpRoboTextView2, "mBinding.dateRangeText");
                mpRoboTextView2.setText(titleTileModel.getDateRangeText());
                if (titleTileModel.getShouldShowDateRange() && titleTileModel.getShouldHighlightDateRange()) {
                    c.a aVar = c.f7365a;
                    LinearLayout linearLayout2 = this.mBinding.calendarContainer;
                    k.b(linearLayout2, "mBinding.calendarContainer");
                    c.a.a(linearLayout2, this.this$0.mContext, false);
                }
            }
        }
    }

    public final class OnlineSettlementSummaryCardViewHolder extends BaseViewHolder {
        public final z<com.business.common_module.utilities.a.b<KycBankInfoModel>> mBasicInfoObserver = new HomeRVAdapter$OnlineSettlementSummaryCardViewHolder$mBasicInfoObserver$1(this);
        public com.business.common_module.utilities.a.b<KycBankInfoModel> mBasicInfoResponse;
        public final MpOnlineSettlementSummaryCardBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnlineSettlementSummaryCardViewHolder(HomeRVAdapter homeRVAdapter, MpOnlineSettlementSummaryCardBinding mpOnlineSettlementSummaryCardBinding) {
            super(mpOnlineSettlementSummaryCardBinding.getRoot());
            k.d(mpOnlineSettlementSummaryCardBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpOnlineSettlementSummaryCardBinding;
            if (homeRVAdapter.mContext instanceof IAcceptPaymentMainActivityListener) {
                ((IAcceptPaymentMainActivityListener) homeRVAdapter.mContext).addBasicInfoObserver(this.mBasicInfoObserver);
            }
        }

        public final MpOnlineSettlementSummaryCardBinding getMBinding() {
            return this.mBinding;
        }

        public final void finalize() {
            if (this.this$0.mContext instanceof IAcceptPaymentMainActivityListener) {
                ((IAcceptPaymentMainActivityListener) this.this$0.mContext).removeBasicInfoObserver(this.mBasicInfoObserver);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x008e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindData(java.lang.Object r6, int r7) {
            /*
                r5 = this;
                boolean r7 = r6 instanceof com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel
                if (r7 == 0) goto L_0x009a
                com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel r6 = (com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel) r6
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r7 = r6.getModelData()
                java.util.ArrayList r7 = r7.getSettlementAmountDetails()
                if (r7 == 0) goto L_0x0025
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r7 = r6.getModelData()
                java.util.ArrayList r7 = r7.getSettlementAmountDetails()
                kotlin.g.b.k.a((java.lang.Object) r7)
                int r7 = r7.size()
                if (r7 == 0) goto L_0x0025
                r5.setMultipleElementState()
                goto L_0x0038
            L_0x0025:
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r7 = r6.getModelData()
                java.lang.String r7 = r7.getTotalAmount()
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r0 = r6.getModelData()
                java.lang.String r0 = r0.getTotalPayments()
                r5.setSingleElementState(r7, r0)
            L_0x0038:
                com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBinding r7 = r5.mBinding
                android.widget.LinearLayout r7 = r7.onlineSettlementDynamicData
                java.lang.String r0 = "mBinding.onlineSettlementDynamicData"
                kotlin.g.b.k.b(r7, r0)
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r0 = r6.getModelData()
                java.util.ArrayList r0 = r0.getSettlementAmountDetails()
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r1 = r6.getModelData()
                java.lang.String r1 = r1.getTotalAmount()
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r2 = r6.getModelData()
                java.lang.String r2 = r2.getTotalPayments()
                r5.setLabels(r7, r0, r1, r2)
                com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBinding r7 = r5.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r7 = r7.settlementSummaryCardAmount
                java.lang.String r0 = "mBinding.settlementSummaryCardAmount"
                kotlin.g.b.k.b(r7, r0)
                com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r0 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r1 = r6.getModelData()
                java.lang.String r1 = r1.getTotalAmount()
                r2 = 0
                r3 = 2
                r4 = 0
                java.lang.String r0 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.parseAndGetAmountString$default(r0, r1, r2, r3, r4)
                r7.setText(r0)
                com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBinding r7 = r5.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r7 = r7.onlineSettlementTotalPaymentsText
                java.lang.String r0 = "mBinding.onlineSettlementTotalPaymentsText"
                kotlin.g.b.k.b(r7, r0)
                com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP r0 = com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP.INSTANCE
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r1 = r6.getModelData()
                java.lang.String r1 = r1.getTotalPayments()
                if (r1 != 0) goto L_0x0090
                java.lang.String r1 = "--"
            L_0x0090:
                java.lang.String r0 = r0.getSettlmentPaymentsText(r1)
                r7.setText(r0)
                r5.handleBasicInfoResponse(r6)
            L_0x009a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.OnlineSettlementSummaryCardViewHolder.bindData(java.lang.Object, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
            r5 = (r5 = (r5 = (r5 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r5.f7358c).getResults()).getExtendedInfo()).getSettlementType();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void handleBasicInfoResponse(com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel r5) {
            /*
                r4 = this;
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r5 = r5.getModelData()
                com.business.merchant_payments.settlement.model.ApiState r5 = r5.getApiState()
                com.business.merchant_payments.settlement.model.ApiState r0 = com.business.merchant_payments.settlement.model.ApiState.SUCCESS
                java.lang.String r1 = "mBinding.onlineSettlementByTexts"
                if (r5 != r0) goto L_0x0041
                com.business.common_module.utilities.a.b<com.business.merchant_payments.model.kyc.KycBankInfoModel> r5 = r4.mBasicInfoResponse
                r0 = 0
                if (r5 == 0) goto L_0x0033
                T r5 = r5.f7358c
                com.business.merchant_payments.model.kyc.KycBankInfoModel r5 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r5
                if (r5 == 0) goto L_0x0033
                com.business.merchant_payments.model.kyc.Results r5 = r5.getResults()
                if (r5 == 0) goto L_0x0033
                com.business.merchant_payments.profile.model.kyc.ExtendedInfo r5 = r5.getExtendedInfo()
                if (r5 == 0) goto L_0x0033
                java.lang.String r5 = r5.getSettlementType()
                if (r5 == 0) goto L_0x0033
                r2 = 1
                java.lang.String r3 = "Manual NEFT"
                boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r2)
                goto L_0x0034
            L_0x0033:
                r5 = 0
            L_0x0034:
                if (r5 != 0) goto L_0x0041
                com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBinding r5 = r4.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r5 = r5.onlineSettlementByTexts
                kotlin.g.b.k.b(r5, r1)
                r5.setVisibility(r0)
                return
            L_0x0041:
                com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBinding r5 = r4.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r5 = r5.onlineSettlementByTexts
                kotlin.g.b.k.b(r5, r1)
                r0 = 8
                r5.setVisibility(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.OnlineSettlementSummaryCardViewHolder.handleBasicInfoResponse(com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel):void");
        }

        private final void setMultipleElementState() {
            android.view.View view = this.mBinding.bottomDivider;
            k.b(view, "mBinding.bottomDivider");
            view.setVisibility(0);
            MpRoboTextView mpRoboTextView = this.mBinding.onlineSettlementSummaryTotalAmountText;
            k.b(mpRoboTextView, "mBinding.onlineSettlementSummaryTotalAmountText");
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            mpRoboTextView.setText(instance.getAppContext().getString(R.string.mp_available_balance_lbl));
            android.view.View root = this.mBinding.getRoot();
            k.b(root, "mBinding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            layoutParams.height = -2;
            android.view.View root2 = this.mBinding.getRoot();
            k.b(root2, "mBinding.root");
            root2.setLayoutParams(layoutParams);
        }

        private final void setSingleElementState(String str, String str2) {
            android.view.View view = this.mBinding.bottomDivider;
            k.b(view, "mBinding.bottomDivider");
            view.setVisibility(8);
            android.view.View root = this.mBinding.getRoot();
            k.b(root, "mBinding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(str) || LabelPopulationHelperMP.INSTANCE.isAmountNonZero(str2)) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = 0;
            }
            android.view.View root2 = this.mBinding.getRoot();
            k.b(root2, "mBinding.root");
            root2.setLayoutParams(layoutParams);
        }

        private final void setLabels(LinearLayout linearLayout, ArrayList<LabelModel> arrayList, String str, String str2) {
            LabelPopulationHelperMP.INSTANCE.resetAmountOnHoldMap();
            if (arrayList != null && arrayList.size() > 0) {
                if (LabelPopulationHelperMP.INSTANCE.populateLabelsInEmptyContainer(this.this$0.mContext, linearLayout, arrayList, AppUtility.getValueInDp(this.this$0.mContext, 15), this.this$0.mListener)) {
                    linearLayout.setVisibility(0);
                    setMultipleElementState();
                    return;
                }
            }
            linearLayout.setVisibility(8);
            setSingleElementState(str, str2);
        }
    }

    public final void onAlreadySettledSettlementResponse(ArrayList<M2BOrderListItemModel> arrayList) {
        int size = this.mList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.mList.get(i2);
            k.b(obj, "mList[i]");
            if (obj instanceof BWSettlementCardSummaryAdapterModel) {
                BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel = (BWSettlementCardSummaryAdapterModel) obj;
                bWSettlementCardSummaryAdapterModel.setAlreadySettledData(arrayList);
                bWSettlementCardSummaryAdapterModel.setAlreadySettledExpanded(!bWSettlementCardSummaryAdapterModel.isAlreadySettledExpanded());
                notifyItemChanged(i2);
                return;
            }
        }
    }

    public final void onPendingSettlementResponse(ArrayList<M2BOrderListItemModel> arrayList) {
        int size = this.mList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.mList.get(i2);
            k.b(obj, "mList[i]");
            if (obj instanceof BWSettlementCardSummaryAdapterModel) {
                BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel = (BWSettlementCardSummaryAdapterModel) obj;
                bWSettlementCardSummaryAdapterModel.setPendingToBeSettledData(arrayList);
                bWSettlementCardSummaryAdapterModel.setPendingSettledListExpanded(!bWSettlementCardSummaryAdapterModel.isPendingSettledListExpanded());
                notifyItemChanged(i2);
                return;
            }
        }
    }

    public final void onSettlementBillListItemDetailResponse(int i2, ArrayList<M2BOrderListItemModel> arrayList, ArrayList<LabelModel> arrayList2) {
        if (i2 >= 0 && i2 < this.mList.size()) {
            Object obj = this.mList.get(i2);
            k.b(obj, "mList[position]");
            if (obj instanceof SettlementBillListItemModel) {
                SettlementBillListItemModel settlementBillListItemModel = (SettlementBillListItemModel) obj;
                settlementBillListItemModel.setAmountDetails(arrayList2);
                settlementBillListItemModel.setSettlementBillListDetails(arrayList);
                onToggleCompressState(!settlementBillListItemModel.isExpanded(), i2);
                notifyItemChanged(i2);
            }
        }
    }

    public final void onToggleCompressState(boolean z, int i2) {
        int i3 = this.mPreviousExpandedCardIndex;
        if (i3 >= 0 && i3 < this.mList.size()) {
            Object obj = this.mList.get(this.mPreviousExpandedCardIndex);
            k.b(obj, "mList[mPreviousExpandedCardIndex]");
            if (obj instanceof SettlementBillListItemModel) {
                ((SettlementBillListItemModel) obj).setExpanded(false);
            }
            notifyItemChanged(this.mPreviousExpandedCardIndex);
        }
        if (i2 >= 0 && i2 < this.mList.size()) {
            Object obj2 = this.mList.get(i2);
            k.b(obj2, "mList[position]");
            if (obj2 instanceof SettlementBillListItemModel) {
                ((SettlementBillListItemModel) obj2).setExpanded(z);
            }
            notifyItemChanged(i2);
            this.mPreviousExpandedCardIndex = i2;
        }
    }

    public final class OnlineSettlementElementViewHolder extends BaseViewHolder {
        public final MpOnlineSettlementElementBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnlineSettlementElementViewHolder(HomeRVAdapter homeRVAdapter, MpOnlineSettlementElementBinding mpOnlineSettlementElementBinding) {
            super(mpOnlineSettlementElementBinding.getRoot());
            k.d(mpOnlineSettlementElementBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpOnlineSettlementElementBinding;
        }

        public final MpOnlineSettlementElementBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            HomeRVAdapter homeRVAdapter = this.this$0;
            android.view.View root = this.mBinding.getRoot();
            k.b(root, "mBinding.root");
            homeRVAdapter.setAlternatingColorRelativeToViewPastSettlements(root, i2);
            if (obj instanceof SettlementBillListItemModel) {
                SettlementBillListItemModel settlementBillListItemModel = (SettlementBillListItemModel) obj;
                this.mBinding.onlineSettlementStatusImage.setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.this$0.mContext, settlementBillListItemModel.getSettleStatus()));
                this.mBinding.onlineSettlementStatusImageBottom.setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.this$0.mContext, settlementBillListItemModel.getSettleStatus()));
                this.mBinding.getRoot().setOnClickListener(new HomeRVAdapter$OnlineSettlementElementViewHolder$bindData$1(this, obj, i2));
                if (!settlementBillListItemModel.isExpanded()) {
                    setCompressedState();
                } else {
                    setExpandedState(settlementBillListItemModel, i2);
                }
                setCommonState(settlementBillListItemModel);
            }
        }

        private final void setArrowDirection(boolean z) {
            if (!z) {
                ImageView imageView = this.mBinding.onlineSettlementArrow;
                k.b(imageView, "mBinding.onlineSettlementArrow");
                imageView.setRotation(0.0f);
                return;
            }
            ImageView imageView2 = this.mBinding.onlineSettlementArrow;
            k.b(imageView2, "mBinding.onlineSettlementArrow");
            imageView2.setRotation(180.0f);
        }

        private final void setCommonState(SettlementBillListItemModel settlementBillListItemModel) {
            setArrowDirection(settlementBillListItemModel.isExpanded());
            MpRoboTextView mpRoboTextView = this.mBinding.onlineSettlementDate;
            k.b(mpRoboTextView, "mBinding.onlineSettlementDate");
            mpRoboTextView.setText(DateUtility.getDateFromTimeStamp(settlementBillListItemModel.getSettlementTime()) + ", ");
            MpRoboTextView mpRoboTextView2 = this.mBinding.onlineSettlementAmount;
            k.b(mpRoboTextView2, "mBinding.onlineSettlementAmount");
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount = settlementBillListItemModel.getNetAmount();
            mpRoboTextView2.setText(labelPopulationHelperMP.parseAndGetAmountString(netAmount != null ? netAmount.getValue() : null, true));
            setCommonBankDatabasedOnSettleMode(settlementBillListItemModel);
        }

        private final boolean isBankAccountNumberPresent(SettlementBillListItemModel settlementBillListItemModel) {
            ArrayList<SettlementBankDetailModel> bankDetails = settlementBillListItemModel.getBankDetails();
            if (!(bankDetails == null || bankDetails.isEmpty())) {
                ArrayList<SettlementBankDetailModel> bankDetails2 = settlementBillListItemModel.getBankDetails();
                k.a((Object) bankDetails2);
                String accountNumber = bankDetails2.get(0).getAccountNumber();
                if (!(accountNumber == null || p.a(accountNumber))) {
                    return true;
                }
            }
            return false;
        }

        private final void setCommonBankDatabasedOnSettleMode(SettlementBillListItemModel settlementBillListItemModel) {
            String settleMode = settlementBillListItemModel.getSettleMode();
            if (!p.a(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT, settleMode, true) || !isBankAccountNumberPresent(settlementBillListItemModel) || p.a(P4BSettlementsDataHelperMP.PAYOUT_BANK_INITIATED, settlementBillListItemModel.getSettleStatus(), true)) {
                ImageView imageView = this.mBinding.onlineSettlementBankImage;
                k.b(imageView, "mBinding.onlineSettlementBankImage");
                imageView.setVisibility(8);
                MpRoboTextView mpRoboTextView = this.mBinding.onlineSettlementAccountNumberText;
                k.b(mpRoboTextView, "mBinding.onlineSettlementAccountNumberText");
                mpRoboTextView.setVisibility(8);
                MpRoboTextView mpRoboTextView2 = this.mBinding.onlineSettlementStatusText;
                k.b(mpRoboTextView2, "mBinding.onlineSettlementStatusText");
                mpRoboTextView2.setVisibility(0);
                MpRoboTextView mpRoboTextView3 = this.mBinding.onlineSettlementStatusText;
                k.b(mpRoboTextView3, "mBinding.onlineSettlementStatusText");
                mpRoboTextView3.setText(P4BSettlementsDataHelperMP.INSTANCE.getOnlineSettlementStatusText(settlementBillListItemModel.getSettleStatus(), P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT));
                if (!p.a(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT, settleMode, true) && p.a(P4BSettlementsDataHelperMP.PAYOUT_UNSETTLED, settlementBillListItemModel.getSettleStatus(), true)) {
                    String access$getMerchantSettleStatus$p = this.this$0.merchantSettleStatus;
                    if ((access$getMerchantSettleStatus$p == null || p.a(access$getMerchantSettleStatus$p)) || ((!p.a(this.this$0.merchantSettleStatus, P4BSettlementsDataHelperMP.MERCHANT_STATUS_HOLD, true) && !p.a(this.this$0.merchantSettleStatus, P4BSettlementsDataHelperMP.MERCHANT_STATUS_FREEZE, true)) || !p.a(P4BSettlementsDataHelperMP.PAYOUT_UNSETTLED, settlementBillListItemModel.getSettleStatus(), true))) {
                        RoboTextView roboTextView = this.mBinding.onlineSettlementPendingText;
                        k.b(roboTextView, "mBinding.onlineSettlementPendingText");
                        roboTextView.setVisibility(0);
                        MpFlowLayout mpFlowLayout = this.mBinding.onlinePendingMessageContainer;
                        k.b(mpFlowLayout, "mBinding.onlinePendingMessageContainer");
                        mpFlowLayout.setVisibility(0);
                        this.mBinding.onlineSettlementPendingContactUs.setOnClickListener(new HomeRVAdapter$OnlineSettlementElementViewHolder$setCommonBankDatabasedOnSettleMode$1(this, settlementBillListItemModel));
                        return;
                    }
                    MpRoboTextView mpRoboTextView4 = this.mBinding.onlineSettlementStatusText;
                    k.b(mpRoboTextView4, "mBinding.onlineSettlementStatusText");
                    PaymentsConfig instance = PaymentsConfig.getInstance();
                    k.b(instance, "PaymentsConfig.getInstance()");
                    mpRoboTextView4.setText(instance.getAppContext().getString(R.string.mp_label_pending_single_bank_settlement_detail));
                    MpFlowLayout mpFlowLayout2 = this.mBinding.onlinePendingMessageContainer;
                    k.b(mpFlowLayout2, "mBinding.onlinePendingMessageContainer");
                    mpFlowLayout2.setVisibility(8);
                } else if (p.a(settlementBillListItemModel.getSettleStatus(), P4BSettlementsDataHelperMP.PAYOUT_BANK_INITIATED, false)) {
                    MpRoboTextView mpRoboTextView5 = this.mBinding.onlineSettlementStatusText;
                    k.b(mpRoboTextView5, "mBinding.onlineSettlementStatusText");
                    PaymentsConfig instance2 = PaymentsConfig.getInstance();
                    k.b(instance2, "PaymentsConfig.getInstance()");
                    mpRoboTextView5.setText(instance2.getAppContext().getString(R.string.mp_bank_transfer_initiated));
                    MpFlowLayout mpFlowLayout3 = this.mBinding.onlinePendingMessageContainer;
                    k.b(mpFlowLayout3, "mBinding.onlinePendingMessageContainer");
                    mpFlowLayout3.setVisibility(8);
                } else {
                    RoboTextView roboTextView2 = this.mBinding.onlineSettlementPendingText;
                    k.b(roboTextView2, "mBinding.onlineSettlementPendingText");
                    roboTextView2.setVisibility(8);
                    MpFlowLayout mpFlowLayout4 = this.mBinding.onlinePendingMessageContainer;
                    k.b(mpFlowLayout4, "mBinding.onlinePendingMessageContainer");
                    mpFlowLayout4.setVisibility(8);
                    this.mBinding.onlineSettlementPendingContactUs.setOnClickListener((View.OnClickListener) null);
                }
            } else {
                ImageView imageView2 = this.mBinding.onlineSettlementBankImage;
                k.b(imageView2, "mBinding.onlineSettlementBankImage");
                imageView2.setVisibility(0);
                MpRoboTextView mpRoboTextView6 = this.mBinding.onlineSettlementAccountNumberText;
                k.b(mpRoboTextView6, "mBinding.onlineSettlementAccountNumberText");
                mpRoboTextView6.setVisibility(0);
                MpRoboTextView mpRoboTextView7 = this.mBinding.onlineSettlementStatusText;
                k.b(mpRoboTextView7, "mBinding.onlineSettlementStatusText");
                mpRoboTextView7.setVisibility(8);
                setBankData(settlementBillListItemModel);
            }
        }

        private final void setFlowLayoutElementsVisibility(int i2) {
            MpRoboTextView mpRoboTextView = this.mBinding.onlineSettlementAccountNumberText;
            k.b(mpRoboTextView, "mBinding.onlineSettlementAccountNumberText");
            mpRoboTextView.setVisibility(i2);
            ImageView imageView = this.mBinding.onlineSettlementBankImage;
            k.b(imageView, "mBinding.onlineSettlementBankImage");
            imageView.setVisibility(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00af  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void setBankData(com.business.merchant_payments.settlement.model.SettlementBillListItemModel r10) {
            /*
                r9 = this;
                java.util.ArrayList r0 = r10.getBankDetails()
                java.lang.String r1 = r10.getSettleStatus()
                java.lang.String r2 = ""
                if (r1 != 0) goto L_0x000d
                r1 = r2
            L_0x000d:
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r3 = r9.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.onlineSettlementStatusText
                java.lang.String r4 = "mBinding.onlineSettlementStatusText"
                kotlin.g.b.k.b(r3, r4)
                com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP r4 = com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP.INSTANCE
                java.lang.String r5 = r10.getSettleMode()
                java.lang.String r4 = r4.getOnlineSettlementStatusText(r1, r5, r0)
                r3.setText(r4)
                r3 = 1
                r4 = 8
                r5 = 0
                if (r0 == 0) goto L_0x00a0
                int r6 = r0.size()
                if (r6 <= 0) goto L_0x00a0
                java.lang.Object r6 = r0.get(r5)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r6 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r6
                java.lang.String r6 = r6.getBankName()
                if (r6 == 0) goto L_0x0043
                boolean r6 = kotlin.m.p.a(r6)
                if (r6 != 0) goto L_0x0043
                r6 = 0
                goto L_0x0044
            L_0x0043:
                r6 = 1
            L_0x0044:
                if (r6 != 0) goto L_0x00a0
                java.lang.Object r6 = r0.get(r5)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r6 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r6
                java.lang.String r6 = r6.getAccountNumber()
                if (r6 == 0) goto L_0x005a
                boolean r6 = kotlin.m.p.a(r6)
                if (r6 != 0) goto L_0x005a
                r6 = 0
                goto L_0x005b
            L_0x005a:
                r6 = 1
            L_0x005b:
                if (r6 != 0) goto L_0x00a0
                r9.setFlowLayoutElementsVisibility(r5)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r6 = r9.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r6 = r6.onlineSettlementAccountNumberText
                java.lang.String r7 = "mBinding.onlineSettlementAccountNumberText"
                kotlin.g.b.k.b(r6, r7)
                java.lang.Object r7 = r0.get(r5)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r7 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r7
                java.lang.String r7 = r7.getAccountNumber()
                if (r7 != 0) goto L_0x0076
                r7 = r2
            L_0x0076:
                r6.setText(r7)
                com.business.merchant_payments.settlement.image_target.MpP4bBankImageTarget r6 = new com.business.merchant_payments.settlement.image_target.MpP4bBankImageTarget
                java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r8 = r9.mBinding
                android.widget.ImageView r8 = r8.onlineSettlementBankImage
                r7.<init>(r8)
                r6.<init>(r7)
                com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
                java.lang.Object r0 = r0.get(r5)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r0 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r0
                java.lang.String r0 = r0.getBankIconUrl()
                if (r0 != 0) goto L_0x0098
                r0 = r2
            L_0x0098:
                com.squareup.picasso.aa r0 = r7.a((java.lang.String) r0)
                r0.a((com.squareup.picasso.af) r6)
                goto L_0x00a3
            L_0x00a0:
                r9.setFlowLayoutElementsVisibility(r4)
            L_0x00a3:
                java.lang.String r0 = "PAYOUT_UNSETTLED"
                boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
                java.lang.String r1 = "mBinding.onlineSettlementPendingText"
                java.lang.String r2 = "mBinding.onlinePendingMessageContainer"
                if (r0 == 0) goto L_0x00d0
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r9.mBinding
                com.business.merchant_payments.widget.MpFlowLayout r0 = r0.onlinePendingMessageContainer
                kotlin.g.b.k.b(r0, r2)
                r0.setVisibility(r5)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r9.mBinding
                com.paytm.utility.RoboTextView r0 = r0.onlineSettlementPendingText
                kotlin.g.b.k.b(r0, r1)
                r0.setVisibility(r5)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r9.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.onlineSettlementPendingContactUs
                com.business.merchant_payments.newhome.HomeRVAdapter$OnlineSettlementElementViewHolder$setBankData$1 r1 = new com.business.merchant_payments.newhome.HomeRVAdapter$OnlineSettlementElementViewHolder$setBankData$1
                r1.<init>(r9, r10)
                r0.setOnClickListener(r1)
                return
            L_0x00d0:
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r10 = r9.mBinding
                com.business.merchant_payments.widget.MpFlowLayout r10 = r10.onlinePendingMessageContainer
                kotlin.g.b.k.b(r10, r2)
                r10.setVisibility(r4)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r10 = r9.mBinding
                com.paytm.utility.RoboTextView r10 = r10.onlineSettlementPendingText
                kotlin.g.b.k.b(r10, r1)
                r10.setVisibility(r4)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r10 = r9.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r10 = r10.onlineSettlementPendingContactUs
                r0 = 0
                r10.setOnClickListener(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.OnlineSettlementElementViewHolder.setBankData(com.business.merchant_payments.settlement.model.SettlementBillListItemModel):void");
        }

        private final void setCompressedState() {
            LinearLayout linearLayout = this.mBinding.onlineSettlementDetailContainer;
            k.b(linearLayout, "mBinding.onlineSettlementDetailContainer");
            linearLayout.setVisibility(8);
            ImageView imageView = this.mBinding.onlineSettlementStatusImageBottom;
            k.b(imageView, "mBinding.onlineSettlementStatusImageBottom");
            imageView.setVisibility(8);
            MpRoboTextView mpRoboTextView = this.mBinding.onlineSettlementTimeText;
            k.b(mpRoboTextView, "mBinding.onlineSettlementTimeText");
            mpRoboTextView.setVisibility(8);
            MpRoboTextView mpRoboTextView2 = this.mBinding.onlineSettlementUtrNumber;
            k.b(mpRoboTextView2, "mBinding.onlineSettlementUtrNumber");
            mpRoboTextView2.setVisibility(8);
            MpRoboTextView mpRoboTextView3 = this.mBinding.onlineSettlementBankText;
            k.b(mpRoboTextView3, "mBinding.onlineSettlementBankText");
            mpRoboTextView3.setVisibility(8);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0038, code lost:
            r0 = r0.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void setExpandedState(com.business.merchant_payments.settlement.model.SettlementBillListItemModel r8, int r9) {
            /*
                r7 = this;
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                android.widget.LinearLayout r0 = r0.onlineSettlementDetailContainer
                java.lang.String r1 = "mBinding.onlineSettlementDetailContainer"
                kotlin.g.b.k.b(r0, r1)
                r2 = 0
                r0.setVisibility(r2)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                android.widget.ImageView r0 = r0.onlineSettlementStatusImageBottom
                java.lang.String r3 = "mBinding.onlineSettlementStatusImageBottom"
                kotlin.g.b.k.b(r0, r3)
                r0.setVisibility(r2)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.onlineSettlementTimeText
                java.lang.String r3 = "mBinding.onlineSettlementTimeText"
                kotlin.g.b.k.b(r0, r3)
                r0.setVisibility(r2)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.onlineSettlementUtrNumber
                java.lang.String r3 = "mBinding.onlineSettlementUtrNumber"
                kotlin.g.b.k.b(r0, r3)
                r0.setVisibility(r2)
                java.util.ArrayList r0 = r8.getBankDetails()
                r3 = 0
                if (r0 == 0) goto L_0x0045
                java.lang.Object r0 = r0.get(r2)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r0 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r0
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r0.getBankName()
                goto L_0x0046
            L_0x0045:
                r0 = r3
            L_0x0046:
                r4 = 1
                if (r0 == 0) goto L_0x0051
                boolean r0 = kotlin.m.p.a(r0)
                if (r0 != 0) goto L_0x0051
                r0 = 0
                goto L_0x0052
            L_0x0051:
                r0 = 1
            L_0x0052:
                java.lang.String r5 = "mBinding.onlineSettlementBankText"
                if (r0 == 0) goto L_0x0063
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.onlineSettlementBankText
                kotlin.g.b.k.b(r0, r5)
                r6 = 8
                r0.setVisibility(r6)
                goto L_0x006d
            L_0x0063:
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.onlineSettlementBankText
                kotlin.g.b.k.b(r0, r5)
                r0.setVisibility(r2)
            L_0x006d:
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r0 = r7.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.onlineSettlementBankText
                kotlin.g.b.k.b(r0, r5)
                java.util.ArrayList r5 = r8.getBankDetails()
                if (r5 == 0) goto L_0x0088
                java.lang.Object r2 = r5.get(r2)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r2 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r2
                if (r2 == 0) goto L_0x0088
                java.lang.String r2 = r2.getBankName()
                if (r2 != 0) goto L_0x008a
            L_0x0088:
                java.lang.String r2 = ""
            L_0x008a:
                r0.setText(r2)
                java.util.ArrayList r0 = r8.getUtrNoList()
                com.business.merchant_payments.settlement.model.AmountModel r2 = r8.getNetAmount()
                if (r2 == 0) goto L_0x009b
                java.lang.String r3 = r2.getValue()
            L_0x009b:
                r7.setUtrData(r0, r3)
                r7.setSettlementTime(r8)
                com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r0 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE
                r0.resetAmountOnHoldMap()
                com.business.merchant_payments.newhome.HomeRVAdapter r0 = r7.this$0
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r2 = r7.mBinding
                android.widget.LinearLayout r2 = r2.onlineSettlementDetailContainer
                kotlin.g.b.k.b(r2, r1)
                int r9 = r9 + r4
                r0.setAlternatingBackgroundRelativeToViewPastSettlements(r2, r9)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r9 = r7.mBinding
                android.widget.LinearLayout r9 = r9.onlineSettlementDetailContainer
                kotlin.g.b.k.b(r9, r1)
                r7.populateLabels(r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.OnlineSettlementElementViewHolder.setExpandedState(com.business.merchant_payments.settlement.model.SettlementBillListItemModel, int):void");
        }

        private final void setUtrData(ArrayList<String> arrayList, String str) {
            String str2;
            if (!(arrayList == null || arrayList.size() == 0)) {
                String str3 = arrayList.get(0);
                k.b(str3, "data[0]");
                if (!p.a(str3) && LabelPopulationHelperMP.INSTANCE.isAmountNonZero(str)) {
                    str2 = arrayList.get(0);
                    k.b(str2, "if (data != null && data…  else\n                \"\"");
                    MpRoboTextView mpRoboTextView = this.mBinding.onlineSettlementUtrNumber;
                    k.b(mpRoboTextView, "mBinding.onlineSettlementUtrNumber");
                    PaymentsConfig instance = PaymentsConfig.getInstance();
                    k.b(instance, "PaymentsConfig.getInstance()");
                    String string = instance.getAppContext().getString(R.string.mp_lbl_utr_number);
                    k.b(string, "PaymentsConfig.getInstan…string.mp_lbl_utr_number)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{str2}, 1));
                    k.b(format, "java.lang.String.format(format, *args)");
                    mpRoboTextView.setText(format);
                }
            }
            str2 = "";
            k.b(str2, "if (data != null && data…  else\n                \"\"");
            MpRoboTextView mpRoboTextView2 = this.mBinding.onlineSettlementUtrNumber;
            k.b(mpRoboTextView2, "mBinding.onlineSettlementUtrNumber");
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            String string2 = instance2.getAppContext().getString(R.string.mp_lbl_utr_number);
            k.b(string2, "PaymentsConfig.getInstan…string.mp_lbl_utr_number)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{str2}, 1));
            k.b(format2, "java.lang.String.format(format, *args)");
            mpRoboTextView2.setText(format2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (r1.isAmountNonZero(r6 != null ? r6.getValue() : null) == false) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void setSettlementTime(com.business.merchant_payments.settlement.model.SettlementBillListItemModel r6) {
            /*
                r5 = this;
                java.lang.String r0 = r6.getSettledTime()
                java.lang.String r0 = com.business.merchant_payments.common.utility.DateUtility.getTimeFromTimeStamp(r0)
                java.lang.String r1 = "DateUtility.getTimeFromTimeStamp(data.settledTime)"
                kotlin.g.b.k.b(r0, r1)
                if (r0 == 0) goto L_0x006e
                java.lang.String r0 = r0.toLowerCase()
                java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
                kotlin.g.b.k.b(r0, r1)
                boolean r1 = kotlin.m.p.a(r0)
                java.lang.String r2 = "PaymentsConfig.getInstance()"
                if (r1 != 0) goto L_0x0034
                com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r1 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE
                com.business.merchant_payments.settlement.model.AmountModel r6 = r6.getNetAmount()
                if (r6 == 0) goto L_0x002d
                java.lang.String r6 = r6.getValue()
                goto L_0x002e
            L_0x002d:
                r6 = 0
            L_0x002e:
                boolean r6 = r1.isAmountNonZero(r6)
                if (r6 != 0) goto L_0x0045
            L_0x0034:
                com.business.merchant_payments.PaymentsConfig r6 = com.business.merchant_payments.PaymentsConfig.getInstance()
                kotlin.g.b.k.b(r6, r2)
                android.content.Context r6 = r6.getAppContext()
                int r0 = com.business.merchant_payments.R.string.mp_label_not_available
                java.lang.String r0 = r6.getString(r0)
            L_0x0045:
                java.lang.String r6 = "if (time.isBlank()\n     …else\n                time"
                kotlin.g.b.k.b(r0, r6)
                com.business.merchant_payments.databinding.MpOnlineSettlementElementBinding r6 = r5.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r6 = r6.onlineSettlementTimeText
                java.lang.String r1 = "mBinding.onlineSettlementTimeText"
                kotlin.g.b.k.b(r6, r1)
                com.business.merchant_payments.PaymentsConfig r1 = com.business.merchant_payments.PaymentsConfig.getInstance()
                kotlin.g.b.k.b(r1, r2)
                android.content.Context r1 = r1.getAppContext()
                int r2 = com.business.merchant_payments.R.string.mp_lbl_settled_at_txt
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                r3[r4] = r0
                java.lang.String r0 = r1.getString(r2, r3)
                r6.setText(r0)
                return
            L_0x006e:
                java.lang.NullPointerException r6 = new java.lang.NullPointerException
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.OnlineSettlementElementViewHolder.setSettlementTime(com.business.merchant_payments.settlement.model.SettlementBillListItemModel):void");
        }

        private final void populateLabels(SettlementBillListItemModel settlementBillListItemModel, LinearLayout linearLayout) {
            ArrayList<LabelModel> settlementAmountDetails = settlementBillListItemModel.getSettlementAmountDetails();
            LabelPopulationHelperMP.INSTANCE.resetAmountOnHoldMap();
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            Context access$getMContext$p = this.this$0.mContext;
            ArrayList<LabelModel> settlementAmountDetails2 = settlementBillListItemModel.getSettlementAmountDetails();
            android.view.View view = this.mBinding.onlineSettlementDetailDividerBottom;
            k.b(view, "mBinding.onlineSettlementDetailDividerBottom");
            boolean populateAmountDetailLabels = labelPopulationHelperMP.populateAmountDetailLabels(access$getMContext$p, linearLayout, settlementAmountDetails2, 2, view.getId(), AppUtility.getValueInDp(this.this$0.mContext, 12), this.this$0.mListener);
            if (settlementAmountDetails == null || settlementAmountDetails.size() == 0 || !populateAmountDetailLabels) {
                setCommonVisibilitiesExpanded(8);
            } else {
                setCommonVisibilitiesExpanded(0);
            }
            CustomTextView customTextView = this.mBinding.settlementAmountValue;
            k.b(customTextView, "mBinding.settlementAmountValue");
            LabelPopulationHelperMP labelPopulationHelperMP2 = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount = settlementBillListItemModel.getNetAmount();
            customTextView.setText(labelPopulationHelperMP2.parseAndGetAmountString(netAmount != null ? netAmount.getValue() : null, true));
        }

        private final void setCommonVisibilitiesExpanded(int i2) {
            android.view.View view = this.mBinding.onlineSettlementDetailDividerTop;
            k.b(view, "mBinding.onlineSettlementDetailDividerTop");
            view.setVisibility(i2);
            ImageView imageView = this.mBinding.onlineSettlementStatusImageBottom;
            k.b(imageView, "mBinding.onlineSettlementStatusImageBottom");
            imageView.setVisibility(i2);
            CustomTextView customTextView = this.mBinding.onlineSettlementAmountDetailsText;
            k.b(customTextView, "mBinding.onlineSettlementAmountDetailsText");
            customTextView.setVisibility(i2);
            android.view.View view2 = this.mBinding.onlineSettlementDetailDividerBottom;
            k.b(view2, "mBinding.onlineSettlementDetailDividerBottom");
            view2.setVisibility(i2);
        }

        /* access modifiers changed from: private */
        public final void sendGAEventOnClick(SettlementBillListItemModel settlementBillListItemModel) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String settlementTime = settlementBillListItemModel.getSettlementTime();
            if (settlementTime == null) {
                settlementTime = "";
            }
            String str6 = DateUtility.getTimeDiffForSettlement("yyyy-MM-dd'T'HH:mm:ssZZZZZ", settlementTime).toString();
            String convertDateToDifferentFormat = DateUtility.convertDateToDifferentFormat(settlementBillListItemModel.getSettlementTime(), "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "dd-MM-yyyy");
            if (p.a("PAYOUT_SETTLED", settlementBillListItemModel.getSettleStatus(), true)) {
                LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
                AmountModel pendingAmount = settlementBillListItemModel.getPendingAmount();
                String str7 = null;
                boolean isAmountNonZero = labelPopulationHelperMP.isAmountNonZero(pendingAmount != null ? pendingAmount.getValue() : null);
                String str8 = CommonPayParams.Builder.YES;
                String str9 = isAmountNonZero ? str8 : CommonPayParams.Builder.NO;
                LabelPopulationHelperMP labelPopulationHelperMP2 = LabelPopulationHelperMP.INSTANCE;
                AmountModel failedAmount = settlementBillListItemModel.getFailedAmount();
                if (failedAmount != null) {
                    str7 = failedAmount.getValue();
                }
                if (!labelPopulationHelperMP2.isAmountNonZero(str7)) {
                    str8 = CommonPayParams.Builder.NO;
                }
                GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                Context access$getMContext$p = this.this$0.mContext;
                String str10 = "OS;" + str8 + ';' + str9;
                StringBuilder sb = new StringBuilder();
                sb.append(str6);
                sb.append(';');
                sb.append(convertDateToDifferentFormat);
                sb.append(';');
                AmountModel netAmount = settlementBillListItemModel.getNetAmount();
                if (netAmount == null || (str5 = netAmount.getValue()) == null) {
                    str5 = "";
                }
                sb.append(str5);
                sb.append(";NA");
                singleInstance.sendEvent(access$getMContext$p, "HomePage", "Settlement Tab > Settled Settlement Clicked", "", str10, "", sb.toString());
            } else if (p.a(P4BSettlementsDataHelperMP.PAYOUT_UNSETTLED, settlementBillListItemModel.getSettleStatus(), true)) {
                GAGTMTagAnalytics singleInstance2 = GAGTMTagAnalytics.getSingleInstance();
                Context access$getMContext$p2 = this.this$0.mContext;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str6);
                sb2.append(';');
                sb2.append(convertDateToDifferentFormat);
                sb2.append(';');
                AmountModel netAmount2 = settlementBillListItemModel.getNetAmount();
                if (netAmount2 == null || (str3 = netAmount2.getValue()) == null) {
                    str3 = "";
                }
                sb2.append(str3);
                sb2.append(';');
                AmountModel pendingAmount2 = settlementBillListItemModel.getPendingAmount();
                if (pendingAmount2 == null || (str4 = pendingAmount2.getValue()) == null) {
                    str4 = "";
                }
                sb2.append(str4);
                sb2.append(";NA");
                singleInstance2.sendEvent(access$getMContext$p2, "HomePage", "Settlement Tab > Pending Settlement Clicked", "", "OS;", "", sb2.toString());
            } else {
                GAGTMTagAnalytics singleInstance3 = GAGTMTagAnalytics.getSingleInstance();
                Context access$getMContext$p3 = this.this$0.mContext;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str6);
                sb3.append(';');
                sb3.append(convertDateToDifferentFormat);
                sb3.append(';');
                AmountModel netAmount3 = settlementBillListItemModel.getNetAmount();
                if (netAmount3 == null || (str = netAmount3.getValue()) == null) {
                    str = "";
                }
                sb3.append(str);
                sb3.append(';');
                AmountModel failedAmount2 = settlementBillListItemModel.getFailedAmount();
                if (failedAmount2 == null || (str2 = failedAmount2.getValue()) == null) {
                    str2 = "";
                }
                sb3.append(str2);
                sb3.append(";NA");
                singleInstance3.sendEvent(access$getMContext$p3, "HomePage", "Settlement Tab > Failed Settlement Clicked", "", "OS;", "", sb3.toString());
            }
        }
    }

    public final class BWSettlementSummaryCardViewHolder extends BaseViewHolder {
        public final z<com.business.common_module.utilities.a.b<KycBankInfoModel>> mBasicInfoObserver = new HomeRVAdapter$BWSettlementSummaryCardViewHolder$mBasicInfoObserver$1(this);
        public com.business.common_module.utilities.a.b<KycBankInfoModel> mBasicInfoResponse;
        public final MpBwSettlementSummaryCardBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[e.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[e.SUCCESS.ordinal()] = 1;
                $EnumSwitchMapping$0[e.LOADING.ordinal()] = 2;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BWSettlementSummaryCardViewHolder(HomeRVAdapter homeRVAdapter, MpBwSettlementSummaryCardBinding mpBwSettlementSummaryCardBinding) {
            super(mpBwSettlementSummaryCardBinding.getRoot());
            k.d(mpBwSettlementSummaryCardBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpBwSettlementSummaryCardBinding;
            if (homeRVAdapter.mContext instanceof IAcceptPaymentMainActivityListener) {
                ((IAcceptPaymentMainActivityListener) homeRVAdapter.mContext).addBasicInfoObserver(this.mBasicInfoObserver);
            }
        }

        public final MpBwSettlementSummaryCardBinding getMBinding() {
            return this.mBinding;
        }

        private final boolean isClickableFromAmount(String str) {
            Double d2;
            if (str != null) {
                try {
                    d2 = Double.valueOf(Double.parseDouble(str));
                } catch (Exception unused) {
                }
            } else {
                d2 = null;
            }
            return d2 != null && Double.parseDouble(str) >= 1000.0d;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
            r13 = (r13 = (r13 = r13.getResults()).getBwFrequency()).getResponse();
         */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0238  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0269  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void handleBasicInfoResponse(com.business.common_module.utilities.a.b<com.business.merchant_payments.model.kyc.KycBankInfoModel> r18, com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel r19) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r3 = r19.getModelData()
                java.lang.String r3 = r3.getTotalAmount()
                java.lang.String r4 = "mBinding.bwBankAccountNumberText"
                r5 = 1
                java.lang.String r6 = "PaymentsConfig.getInstance()"
                r7 = 8
                r8 = 0
                if (r3 == 0) goto L_0x00ed
                com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r9 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE
                boolean r9 = r9.isAmountNonZero(r3)
                java.lang.String r10 = "mBinding.bwSettleNowBankImage"
                java.lang.String r11 = "mBinding.bwMinAmtNextSettlementText"
                java.lang.String r12 = "mBinding.bwNextSettlementText"
                if (r9 == 0) goto L_0x0094
                double r13 = java.lang.Double.parseDouble(r3)
                r15 = 4652007308841189376(0x408f400000000000, double:1000.0)
                int r3 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r3 < 0) goto L_0x0094
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwNextSettlementText
                kotlin.g.b.k.b(r3, r12)
                com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP r9 = com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP.INSTANCE
                T r13 = r1.f7358c
                com.business.merchant_payments.model.kyc.KycBankInfoModel r13 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r13
                if (r13 == 0) goto L_0x0059
                com.business.merchant_payments.model.kyc.Results r13 = r13.getResults()
                if (r13 == 0) goto L_0x0059
                com.business.merchant_payments.model.kyc.BwFrequency r13 = r13.getBwFrequency()
                if (r13 == 0) goto L_0x0059
                com.business.merchant_payments.model.kyc.Response r13 = r13.getResponse()
                if (r13 == 0) goto L_0x0059
                int r13 = r13.getTriggerFreq()
                goto L_0x005a
            L_0x0059:
                r13 = 0
            L_0x005a:
                java.lang.String r9 = r9.getSettlementFrequencyText(r13)
                r3.setText(r9)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwMinAmtNextSettlementText
                kotlin.g.b.k.b(r3, r11)
                r3.setVisibility(r7)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwNextSettlementText
                kotlin.g.b.k.b(r3, r12)
                r3.setVisibility(r8)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwNextSettlementText
                kotlin.g.b.k.b(r3, r12)
                r3.setSelected(r5)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                android.widget.ImageView r3 = r3.bwSettleNowBankImage
                kotlin.g.b.k.b(r3, r10)
                r3.setVisibility(r8)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwBankAccountNumberText
                kotlin.g.b.k.b(r3, r4)
                r3.setVisibility(r8)
                goto L_0x00ed
            L_0x0094:
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwMinAmtNextSettlementText
                kotlin.g.b.k.b(r3, r11)
                r3.setVisibility(r8)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwMinAmtNextSettlementText
                kotlin.g.b.k.b(r3, r11)
                com.business.merchant_payments.PaymentsConfig r9 = com.business.merchant_payments.PaymentsConfig.getInstance()
                kotlin.g.b.k.b(r9, r6)
                android.content.Context r9 = r9.getAppContext()
                int r11 = com.business.merchant_payments.R.string.mp_min_amt_for_bank_transfer
                java.lang.String r9 = r9.getString(r11)
                r3.setText(r9)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwNextSettlementText
                kotlin.g.b.k.b(r3, r12)
                r3.setVisibility(r7)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                android.widget.ImageView r3 = r3.bwSettleNowBankImage
                kotlin.g.b.k.b(r3, r10)
                r3.setVisibility(r7)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwBankAccountNumberText
                kotlin.g.b.k.b(r3, r4)
                r3.setVisibility(r7)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r9 = r3.bwMinAmtNextSettlementText
                com.business.merchant_payments.widget.MpRoboTextView r3 = r3.bwNextSettlementText
                kotlin.g.b.k.b(r3, r12)
                android.content.Context r3 = r3.getContext()
                int r10 = com.business.merchant_payments.R.color.color_ff9d00
                int r3 = androidx.core.content.b.c(r3, r10)
                r9.setTextColor(r3)
            L_0x00ed:
                com.business.common_module.utilities.a.e r3 = r1.f7357b
                java.lang.String r9 = "mBinding.bwSettleNowButton"
                if (r3 == 0) goto L_0x0221
                int[] r10 = com.business.merchant_payments.newhome.HomeRVAdapter.BWSettlementSummaryCardViewHolder.WhenMappings.$EnumSwitchMapping$0
                int r3 = r3.ordinal()
                r3 = r10[r3]
                if (r3 == r5) goto L_0x0107
                r1 = 2
                if (r3 == r1) goto L_0x0102
                goto L_0x0221
            L_0x0102:
                r17.handleBankDataLoading()
                goto L_0x0224
            L_0x0107:
                r17.handleWhenNotLoading()
                T r3 = r1.f7358c
                com.business.merchant_payments.model.kyc.KycBankInfoModel r3 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r3
                if (r3 == 0) goto L_0x0121
                com.business.merchant_payments.model.kyc.Results r3 = r3.getResults()
                if (r3 == 0) goto L_0x0121
                java.util.List r3 = r3.getKyc()
                if (r3 == 0) goto L_0x0121
                int r3 = r3.size()
                goto L_0x0122
            L_0x0121:
                r3 = 0
            L_0x0122:
                if (r3 == 0) goto L_0x021d
                T r3 = r1.f7358c
                kotlin.g.b.k.a((java.lang.Object) r3)
                com.business.merchant_payments.model.kyc.KycBankInfoModel r3 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r3
                com.business.merchant_payments.model.kyc.Results r3 = r3.getResults()
                java.util.List r3 = r3.getKyc()
                java.lang.Object r3 = r3.get(r8)
                com.business.merchant_payments.model.kyc.Kyc r3 = (com.business.merchant_payments.model.kyc.Kyc) r3
                r3.getBankName()
                T r3 = r1.f7358c
                kotlin.g.b.k.a((java.lang.Object) r3)
                com.business.merchant_payments.model.kyc.KycBankInfoModel r3 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r3
                com.business.merchant_payments.model.kyc.Results r3 = r3.getResults()
                java.util.List r3 = r3.getKyc()
                java.lang.Object r3 = r3.get(r8)
                com.business.merchant_payments.model.kyc.Kyc r3 = (com.business.merchant_payments.model.kyc.Kyc) r3
                java.lang.String r3 = r3.getBankAccountNumber()
                java.lang.String r10 = ""
                if (r3 != 0) goto L_0x015a
                r3 = r10
            L_0x015a:
                r11 = 6
                r12 = 0
                java.lang.String r3 = com.business.merchant_payments.utility.UIUtilityMPKt.getDisplayBankAccountNumberMP$default(r3, r8, r8, r11, r12)
                T r1 = r1.f7358c
                kotlin.g.b.k.a((java.lang.Object) r1)
                com.business.merchant_payments.model.kyc.KycBankInfoModel r1 = (com.business.merchant_payments.model.kyc.KycBankInfoModel) r1
                com.business.merchant_payments.model.kyc.Results r1 = r1.getResults()
                java.util.List r1 = r1.getKyc()
                java.lang.Object r1 = r1.get(r8)
                com.business.merchant_payments.model.kyc.Kyc r1 = (com.business.merchant_payments.model.kyc.Kyc) r1
                java.lang.String r1 = r1.getBankIconUrl()
                if (r1 != 0) goto L_0x017c
                r1 = r10
            L_0x017c:
                com.squareup.picasso.w r10 = com.squareup.picasso.w.a()
                com.squareup.picasso.aa r1 = r10.a((java.lang.String) r1)
                com.squareup.picasso.aa r1 = r1.b()
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r10 = r0.mBinding
                android.widget.ImageView r10 = r10.bwSettleNowBankImage
                r1.a((android.widget.ImageView) r10)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r1 = r0.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r1 = r1.bwBankAccountNumberText
                kotlin.g.b.k.b(r1, r4)
                r1.setText(r3)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r1 = r0.mBinding
                androidx.constraintlayout.widget.ConstraintLayout r1 = r1.bwSettleNowButton
                kotlin.g.b.k.b(r1, r9)
                com.business.merchant_payments.newhome.HomeRVAdapter r3 = r0.this$0
                com.business.merchant_payments.newhome.AcceptPaymentViewModel r3 = r3.mViewModel
                boolean r3 = r3.isBWSettleNowPermissionAllowed()
                if (r3 == 0) goto L_0x01bb
                com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel r3 = r19.getModelData()
                java.lang.String r3 = r3.getTotalAmount()
                boolean r3 = r0.isClickableFromAmount(r3)
                if (r3 == 0) goto L_0x01bb
                goto L_0x01bc
            L_0x01bb:
                r5 = 0
            L_0x01bc:
                r1.setClickable(r5)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r1 = r0.mBinding
                android.widget.ImageView r1 = r1.icLock
                java.lang.String r3 = "mBinding.icLock"
                kotlin.g.b.k.b(r1, r3)
                com.business.merchant_payments.newhome.HomeRVAdapter r3 = r0.this$0
                com.business.merchant_payments.newhome.AcceptPaymentViewModel r3 = r3.mViewModel
                boolean r3 = r3.isBWSettleNowPermissionAllowed()
                if (r3 == 0) goto L_0x01d7
                r3 = 8
                goto L_0x01d8
            L_0x01d7:
                r3 = 0
            L_0x01d8:
                r1.setVisibility(r3)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r1 = r0.mBinding
                androidx.constraintlayout.widget.ConstraintLayout r1 = r1.clDisableSettleNowInfo
                java.lang.String r3 = "mBinding.clDisableSettleNowInfo"
                kotlin.g.b.k.b(r1, r3)
                com.business.merchant_payments.newhome.HomeRVAdapter r3 = r0.this$0
                com.business.merchant_payments.newhome.AcceptPaymentViewModel r3 = r3.mViewModel
                boolean r3 = r3.isBWSettleNowPermissionAllowed()
                if (r3 != 0) goto L_0x0202
                com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()
                kotlin.g.b.k.b(r3, r6)
                com.business.common_module.b.i r3 = r3.getMerchantDataProvider()
                boolean r3 = r3.s()
                if (r3 == 0) goto L_0x0202
                r7 = 0
            L_0x0202:
                r1.setVisibility(r7)
                boolean r1 = r19.isInstantSettled()
                r0.handleInstantSettlementMerchant(r1)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r1 = r0.mBinding
                androidx.constraintlayout.widget.ConstraintLayout r1 = r1.bwSettleNowButton
                kotlin.g.b.k.b(r1, r9)
                boolean r1 = r1.isClickable()
                if (r1 == 0) goto L_0x0224
                r0.showToolTipIfNeeded(r2)
                goto L_0x0224
            L_0x021d:
                r17.handleBankError()
                goto L_0x0224
            L_0x0221:
                r17.handleOverAllError()
            L_0x0224:
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r1 = r0.mBinding
                androidx.constraintlayout.widget.ConstraintLayout r1 = r1.bwSettleNowButton
                kotlin.g.b.k.b(r1, r9)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                androidx.constraintlayout.widget.ConstraintLayout r3 = r3.bwSettleNowButton
                kotlin.g.b.k.b(r3, r9)
                boolean r3 = r3.isClickable()
                if (r3 == 0) goto L_0x0269
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                android.widget.TextView r3 = r3.tvSettleNow
                com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
                kotlin.g.b.k.b(r4, r6)
                android.content.Context r4 = r4.getAppContext()
                int r5 = com.business.merchant_payments.R.color.white
                int r4 = androidx.core.content.b.c(r4, r5)
                r3.setTextColor(r4)
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r3 = r0.mBinding
                androidx.constraintlayout.widget.ConstraintLayout r3 = r3.bwSettleNowButton
                com.business.merchant_payments.newhome.HomeRVAdapter$BWSettlementSummaryCardViewHolder$handleBasicInfoResponse$2 r4 = new com.business.merchant_payments.newhome.HomeRVAdapter$BWSettlementSummaryCardViewHolder$handleBasicInfoResponse$2
                r4.<init>(r0, r2)
                r3.setOnClickListener(r4)
                com.business.merchant_payments.newhome.HomeRVAdapter r2 = r0.this$0
                android.content.Context r2 = r2.mContext
                int r3 = com.business.merchant_payments.R.drawable.mp_bg_rounded_blue
                android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
                goto L_0x028d
            L_0x0269:
                com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBinding r2 = r0.mBinding
                android.widget.TextView r2 = r2.tvSettleNow
                com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()
                kotlin.g.b.k.b(r3, r6)
                android.content.Context r3 = r3.getAppContext()
                int r4 = com.business.merchant_payments.R.color.mp_color_8ba6c1
                int r3 = androidx.core.content.b.c(r3, r4)
                r2.setTextColor(r3)
                com.business.merchant_payments.newhome.HomeRVAdapter r2 = r0.this$0
                android.content.Context r2 = r2.mContext
                int r3 = com.business.merchant_payments.R.drawable.mp_bg_rounded_grey
                android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            L_0x028d:
                r1.setBackground(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.BWSettlementSummaryCardViewHolder.handleBasicInfoResponse(com.business.common_module.utilities.a.b, com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel):void");
        }

        private final void handleInstantSettlementMerchant(boolean z) {
            if (z) {
                MpBwSettlementSummaryCardBinding mpBwSettlementSummaryCardBinding = this.mBinding;
                ConstraintLayout constraintLayout = mpBwSettlementSummaryCardBinding.bwSettleNowButton;
                k.b(constraintLayout, "bwSettleNowButton");
                constraintLayout.setVisibility(8);
                RoboTextView roboTextView = mpBwSettlementSummaryCardBinding.tagInstantSettlement;
                k.b(roboTextView, "tagInstantSettlement");
                roboTextView.setVisibility(0);
                MpRoboTextView mpRoboTextView = mpBwSettlementSummaryCardBinding.bwNextSettlementText;
                k.b(mpRoboTextView, "bwNextSettlementText");
                mpRoboTextView.setVisibility(0);
                MpRoboTextView mpRoboTextView2 = mpBwSettlementSummaryCardBinding.bwNextSettlementText;
                k.b(mpRoboTextView2, "bwNextSettlementText");
                mpRoboTextView2.setText(this.this$0.mContext.getString(R.string.mp_label_online_settlement_to));
                ImageView imageView = mpBwSettlementSummaryCardBinding.bwSettleNowBankImage;
                k.b(imageView, "bwSettleNowBankImage");
                imageView.setVisibility(0);
                MpRoboTextView mpRoboTextView3 = mpBwSettlementSummaryCardBinding.bwBankAccountNumberText;
                k.b(mpRoboTextView3, "bwBankAccountNumberText");
                mpRoboTextView3.setVisibility(0);
                MpRoboTextView mpRoboTextView4 = mpBwSettlementSummaryCardBinding.bwMinAmtNextSettlementText;
                k.b(mpRoboTextView4, "bwMinAmtNextSettlementText");
                mpRoboTextView4.setVisibility(8);
                ConstraintLayout constraintLayout2 = mpBwSettlementSummaryCardBinding.clDisableSettleNowInfo;
                k.b(constraintLayout2, "clDisableSettleNowInfo");
                constraintLayout2.setVisibility(8);
                RelativeLayout relativeLayout = mpBwSettlementSummaryCardBinding.bwAvailableBalanceContainer;
                k.b(relativeLayout, "bwAvailableBalanceContainer");
                relativeLayout.setVisibility(8);
                android.view.View view = mpBwSettlementSummaryCardBinding.bwSummaryCardDivider2;
                k.b(view, "bwSummaryCardDivider2");
                view.setVisibility(8);
                return;
            }
            MpBwSettlementSummaryCardBinding mpBwSettlementSummaryCardBinding2 = this.mBinding;
            RoboTextView roboTextView2 = mpBwSettlementSummaryCardBinding2.tagInstantSettlement;
            k.b(roboTextView2, "tagInstantSettlement");
            roboTextView2.setVisibility(8);
            ConstraintLayout constraintLayout3 = mpBwSettlementSummaryCardBinding2.bwSettleNowButton;
            k.b(constraintLayout3, "bwSettleNowButton");
            constraintLayout3.setVisibility(0);
            RelativeLayout relativeLayout2 = mpBwSettlementSummaryCardBinding2.bwAvailableBalanceContainer;
            k.b(relativeLayout2, "bwAvailableBalanceContainer");
            relativeLayout2.setVisibility(0);
            android.view.View view2 = mpBwSettlementSummaryCardBinding2.bwSummaryCardDivider2;
            k.b(view2, "bwSummaryCardDivider2");
            view2.setVisibility(0);
        }

        private final void handleWhenNotLoading() {
            ShimmerFrameLayout shimmerFrameLayout = this.mBinding.bwSettlementSumaryBankDetailShimmer;
            k.b(shimmerFrameLayout, "mBinding.bwSettlementSumaryBankDetailShimmer");
            shimmerFrameLayout.setVisibility(8);
            ConstraintLayout constraintLayout = this.mBinding.bwSettleNowContainer;
            k.b(constraintLayout, "mBinding.bwSettleNowContainer");
            constraintLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = this.mBinding.bwSettleNowButton;
            k.b(constraintLayout2, "mBinding.bwSettleNowButton");
            constraintLayout2.setClickable(false);
        }

        private final void handleBankDataLoading() {
            ConstraintLayout constraintLayout = this.mBinding.bwSettleNowButton;
            k.b(constraintLayout, "mBinding.bwSettleNowButton");
            constraintLayout.setClickable(false);
            ShimmerFrameLayout shimmerFrameLayout = this.mBinding.bwSettlementSumaryBankDetailShimmer;
            k.b(shimmerFrameLayout, "mBinding.bwSettlementSumaryBankDetailShimmer");
            shimmerFrameLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = this.mBinding.bwSettleNowContainer;
            k.b(constraintLayout2, "mBinding.bwSettleNowContainer");
            constraintLayout2.setVisibility(8);
            this.mBinding.bwSettlementSumaryBankDetailShimmer.startShimmer();
        }

        private final void handleOverAllError() {
            handleBankError();
            MpRoboTextView mpRoboTextView = this.mBinding.bwNextSettlementText;
            k.b(mpRoboTextView, "mBinding.bwNextSettlementText");
            mpRoboTextView.setText(P4BSettlementsDataHelperMP.INSTANCE.getSettlementFrequencyText(0));
        }

        private final void handleBankError() {
            handleWhenNotLoading();
            MpRoboTextView mpRoboTextView = this.mBinding.bwBankAccountNumberText;
            k.b(mpRoboTextView, "mBinding.bwBankAccountNumberText");
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            mpRoboTextView.setText(instance.getAppContext().getString(R.string.mp_label_unable_to_fetch_bank_details));
            ConstraintLayout constraintLayout = this.mBinding.bwSettleNowButton;
            k.b(constraintLayout, "mBinding.bwSettleNowButton");
            constraintLayout.setClickable(false);
            this.mBinding.bwSettleNowBankImage.setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.this$0.mContext, "FAILURE"));
        }

        public final void finalize() {
            if (this.this$0.mContext instanceof IAcceptPaymentMainActivityListener) {
                ((IAcceptPaymentMainActivityListener) this.this$0.mContext).removeBasicInfoObserver(this.mBasicInfoObserver);
            }
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof BWSettlementCardSummaryAdapterModel) {
                MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementTotalPaymentsToday;
                k.b(mpRoboTextView, "mBinding.bwSettlementTotalPaymentsToday");
                P4BSettlementsDataHelperMP p4BSettlementsDataHelperMP = P4BSettlementsDataHelperMP.INSTANCE;
                BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel = (BWSettlementCardSummaryAdapterModel) obj;
                String totalPayments = bWSettlementCardSummaryAdapterModel.getModelData().getTotalPayments();
                if (totalPayments == null) {
                    totalPayments = "--";
                }
                mpRoboTextView.setText(p4BSettlementsDataHelperMP.getSettlmentPaymentsText(totalPayments));
                this.mBinding.bwAlreadySettledToBankContainer.setOnClickListener(new HomeRVAdapter$BWSettlementSummaryCardViewHolder$bindData$1(this, obj, i2));
                this.mBinding.bwPendingToBankContainer.setOnClickListener(new HomeRVAdapter$BWSettlementSummaryCardViewHolder$bindData$2(this, obj));
                setLabelListData(bWSettlementCardSummaryAdapterModel.getModelData().getSettlementAmountDetails(), bWSettlementCardSummaryAdapterModel.isAlreadySettledExpanded(), bWSettlementCardSummaryAdapterModel.isPendingSettledListExpanded(), bWSettlementCardSummaryAdapterModel.getAlreadySettledData(), bWSettlementCardSummaryAdapterModel.getPendingToBeSettledData(), bWSettlementCardSummaryAdapterModel.getModelData().getTotalAmount(), bWSettlementCardSummaryAdapterModel.getModelData().getTotalPayments());
                MpRoboTextView mpRoboTextView2 = this.mBinding.bwAvailableBalanceValue;
                k.b(mpRoboTextView2, "mBinding.bwAvailableBalanceValue");
                mpRoboTextView2.setText(LabelPopulationHelperMP.parseAndGetAmountString$default(LabelPopulationHelperMP.INSTANCE, bWSettlementCardSummaryAdapterModel.getModelData().getTotalAmount(), false, 2, (Object) null));
                setDisabledSettleNowInfoText();
                com.business.common_module.utilities.a.b<KycBankInfoModel> bVar = this.mBasicInfoResponse;
                if (bVar != null) {
                    k.a((Object) bVar);
                    handleBasicInfoResponse(bVar, bWSettlementCardSummaryAdapterModel);
                    return;
                }
                handleBankDataLoading();
            }
        }

        private final void setDisabledSettleNowInfoText() {
            TextView textView = this.mBinding.tvDisableSettleNowInfo;
            k.b(textView, "mBinding.tvDisableSettleNowInfo");
            SpannableString spannableString = new SpannableString(textView.getText().toString());
            if (spannableString.length() > 69) {
                spannableString.setSpan(new HomeRVAdapter$BWSettlementSummaryCardViewHolder$setDisabledSettleNowInfoText$1(this), 69, spannableString.length(), 33);
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                spannableString.setSpan(new ForegroundColorSpan(b.c(instance.getAppContext(), R.color.paytm_blue)), 69, spannableString.length(), 33);
            }
            TextView textView2 = this.mBinding.tvDisableSettleNowInfo;
            k.b(textView2, "mBinding.tvDisableSettleNowInfo");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = this.mBinding.tvDisableSettleNowInfo;
            k.b(textView3, "mBinding.tvDisableSettleNowInfo");
            textView3.setText(spannableString);
        }

        private final void showToolTipIfNeeded(BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel) {
            if (bWSettlementCardSummaryAdapterModel.getShouldShowSettlementToolTip() && bWSettlementCardSummaryAdapterModel.getModelData().getApiState() == ApiState.SUCCESS) {
                MpRoboTextView mpRoboTextView = this.mBinding.bwMinAmtNextSettlementText;
                k.b(mpRoboTextView, "mBinding.bwMinAmtNextSettlementText");
                if (mpRoboTextView.getVisibility() == 8) {
                    MpRoboTextView mpRoboTextView2 = this.mBinding.bwSettlementToolTip;
                    k.b(mpRoboTextView2, "mBinding.bwSettlementToolTip");
                    mpRoboTextView2.setVisibility(0);
                    return;
                }
            }
            MpRoboTextView mpRoboTextView3 = this.mBinding.bwSettlementToolTip;
            k.b(mpRoboTextView3, "mBinding.bwSettlementToolTip");
            mpRoboTextView3.setVisibility(8);
        }

        private final void setSingleElementState(String str, String str2) {
            android.view.View view = this.mBinding.bwSummaryCardDivider1;
            k.b(view, "mBinding.bwSummaryCardDivider1");
            view.setVisibility(8);
            android.view.View root = this.mBinding.getRoot();
            k.b(root, "mBinding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            layoutParams.height = -2;
            android.view.View root2 = this.mBinding.getRoot();
            k.b(root2, "mBinding.root");
            root2.setLayoutParams(layoutParams);
        }

        private final void setMultipleElementState() {
            MpRoboTextView mpRoboTextView = this.mBinding.bwAvailableBalanceText;
            k.b(mpRoboTextView, "mBinding.bwAvailableBalanceText");
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            mpRoboTextView.setText(instance.getAppContext().getString(R.string.mp_available_balance_lbl));
            android.view.View view = this.mBinding.bwSummaryCardDivider1;
            k.b(view, "mBinding.bwSummaryCardDivider1");
            view.setVisibility(0);
            android.view.View root = this.mBinding.getRoot();
            k.b(root, "mBinding.root");
            root.setVisibility(0);
            android.view.View root2 = this.mBinding.getRoot();
            k.b(root2, "mBinding.root");
            ViewGroup.LayoutParams layoutParams = root2.getLayoutParams();
            layoutParams.height = -2;
            android.view.View root3 = this.mBinding.getRoot();
            k.b(root3, "mBinding.root");
            root3.setLayoutParams(layoutParams);
        }

        private final void setLabelListData(ArrayList<LabelModel> arrayList, boolean z, boolean z2, ArrayList<M2BOrderListItemModel> arrayList2, ArrayList<M2BOrderListItemModel> arrayList3, String str, String str2) {
            if (arrayList == null || arrayList.size() == 0) {
                setSingleElementState(str, str2);
            } else {
                setMultipleElementState();
                String str3 = str;
                String str4 = str2;
            }
            LabelPopulationHelperMP.INSTANCE.resetAmountOnHoldMap();
            android.view.View root = this.mBinding.getRoot();
            if (root != null) {
                populateLabels((LinearLayout) root, arrayList, z, z2, arrayList2, arrayList3, str, str2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }

        private final void setAlradySettledToBankContainer(LabelModel labelModel, boolean z, ArrayList<M2BOrderListItemModel> arrayList) {
            ArrayList<M2BOrderListItemModel> arrayList2 = arrayList;
            if (arrayList2 == null) {
                LabelModel labelModel2 = labelModel;
            } else if (arrayList.size() > 3) {
                MpRoboTextView mpRoboTextView = this.mBinding.tvSettledViewAll;
                k.b(mpRoboTextView, "it");
                mpRoboTextView.setVisibility(0);
                mpRoboTextView.setOnClickListener(new HomeRVAdapter$BWSettlementSummaryCardViewHolder$setAlradySettledToBankContainer$$inlined$let$lambda$1(this, labelModel, arrayList2));
                k.b(mpRoboTextView, "mBinding.tvSettledViewAl…  }\n                    }");
            } else {
                LabelModel labelModel3 = labelModel;
                MpRoboTextView mpRoboTextView2 = this.mBinding.tvSettledViewAll;
                k.b(mpRoboTextView2, "mBinding.tvSettledViewAll");
                mpRoboTextView2.setVisibility(8);
            }
            if (!LabelPopulationHelperMP.INSTANCE.isAmountNonZero(labelModel.getValue())) {
                ConstraintLayout constraintLayout = this.mBinding.bwAlreadySettledToBankContainer;
                k.b(constraintLayout, "mBinding.bwAlreadySettledToBankContainer");
                constraintLayout.setVisibility(8);
                LinearLayout linearLayout = this.mBinding.bwAlreadySettledAmountDetailsContainer;
                k.b(linearLayout, "mBinding.bwAlreadySettledAmountDetailsContainer");
                linearLayout.setVisibility(8);
                RelativeLayout relativeLayout = this.mBinding.rlSummaryHeader;
                k.b(relativeLayout, "mBinding.rlSummaryHeader");
                relativeLayout.setVisibility(8);
                this.mBinding.bwAlreadySettledAmountDetailsContainer.removeAllViews();
                return;
            }
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.mContext, "HomePage", "Settlement Tab> Already Settled to Bank", "", "", "Promo Impression");
            ConstraintLayout constraintLayout2 = this.mBinding.bwAlreadySettledToBankContainer;
            k.b(constraintLayout2, "mBinding.bwAlreadySettledToBankContainer");
            constraintLayout2.setVisibility(0);
            MpRoboTextView mpRoboTextView3 = this.mBinding.bwAlreadySettledAmountValue;
            k.b(mpRoboTextView3, "mBinding.bwAlreadySettledAmountValue");
            mpRoboTextView3.setText(LabelPopulationHelperMP.INSTANCE.getAmountUsingKey(labelModel.getKey(), labelModel.getValue(), false));
            ImageView imageView = this.mBinding.bwSettlementSummaryAlreadySettledArrowImage;
            k.b(imageView, "mBinding.bwSettlementSum…yAlreadySettledArrowImage");
            imageView.setRotation(z ? 180.0f : 0.0f);
            if (arrayList2 == null || !z) {
                LinearLayout linearLayout2 = this.mBinding.bwAlreadySettledAmountDetailsContainer;
                k.b(linearLayout2, "mBinding.bwAlreadySettledAmountDetailsContainer");
                linearLayout2.setVisibility(8);
                RelativeLayout relativeLayout2 = this.mBinding.rlSummaryHeader;
                k.b(relativeLayout2, "mBinding.rlSummaryHeader");
                relativeLayout2.setVisibility(8);
            } else {
                LinearLayout linearLayout3 = this.mBinding.bwAlreadySettledAmountDetailsContainer;
                k.b(linearLayout3, "mBinding.bwAlreadySettledAmountDetailsContainer");
                linearLayout3.setVisibility(0);
                RelativeLayout relativeLayout3 = this.mBinding.rlSummaryHeader;
                k.b(relativeLayout3, "mBinding.rlSummaryHeader");
                relativeLayout3.setVisibility(0);
                populateAlreadySettledData(arrayList2, false);
            }
            if (z) {
                GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.mContext, "HomePage", "Settlement Tab> Already Settled to Bank", "", "Expand", "Promo Click");
            } else {
                GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.mContext, "HomePage", "Settlement Tab> Already Settled to Bank", "", "Closed", "Promo Click");
            }
        }

        /* access modifiers changed from: private */
        public final Intent getIntentForSettlementDetail(LabelModel labelModel, String str, String str2, int i2) {
            Intent intent = new Intent(this.this$0.mContext, SettlementDetail.class);
            intent.putExtra(AppConstants.START_DATE, str2);
            intent.putExtra(AppConstants.NET_AMOUNT, LabelPopulationHelperMP.INSTANCE.getAmountUsingKey(labelModel.getKey(), labelModel.getValue(), true));
            intent.putExtra(AppConstants.SETTLEMENT_TYPE, str);
            intent.putExtra(AppConstants.IS_SETTLED_IN_MULTIPLE_BANK, i2);
            return intent;
        }

        private final void setPendingSettledToBankContainer(LabelModel labelModel, boolean z, ArrayList<M2BOrderListItemModel> arrayList) {
            if (arrayList != null) {
                if (arrayList.size() > 3) {
                    MpRoboTextView mpRoboTextView = this.mBinding.tvPendingViewAll;
                    k.b(mpRoboTextView, "it");
                    mpRoboTextView.setVisibility(0);
                    mpRoboTextView.setOnClickListener(new HomeRVAdapter$BWSettlementSummaryCardViewHolder$setPendingSettledToBankContainer$$inlined$let$lambda$1(this, labelModel, arrayList));
                    k.b(mpRoboTextView, "mBinding.tvPendingViewAl…  }\n                    }");
                } else {
                    MpRoboTextView mpRoboTextView2 = this.mBinding.tvPendingViewAll;
                    k.b(mpRoboTextView2, "mBinding.tvPendingViewAll");
                    mpRoboTextView2.setVisibility(8);
                }
            }
            if (!LabelPopulationHelperMP.INSTANCE.isAmountNonZero(labelModel.getValue())) {
                ConstraintLayout constraintLayout = this.mBinding.bwPendingToBankContainer;
                k.b(constraintLayout, "mBinding.bwPendingToBankContainer");
                constraintLayout.setVisibility(8);
                LinearLayout linearLayout = this.mBinding.bwPendingAmountDetailsContainer;
                k.b(linearLayout, "mBinding.bwPendingAmountDetailsContainer");
                linearLayout.setVisibility(8);
                RelativeLayout relativeLayout = this.mBinding.rlPendingHeader;
                k.b(relativeLayout, "mBinding.rlPendingHeader");
                relativeLayout.setVisibility(8);
                this.mBinding.bwPendingAmountDetailsContainer.removeAllViews();
                return;
            }
            ConstraintLayout constraintLayout2 = this.mBinding.bwPendingToBankContainer;
            k.b(constraintLayout2, "mBinding.bwPendingToBankContainer");
            constraintLayout2.setVisibility(0);
            MpRoboTextView mpRoboTextView3 = this.mBinding.bwPendingAmountValue;
            k.b(mpRoboTextView3, "mBinding.bwPendingAmountValue");
            mpRoboTextView3.setText(LabelPopulationHelperMP.INSTANCE.getAmountUsingKey(labelModel.getKey(), labelModel.getValue(), false));
            ImageView imageView = this.mBinding.bwSettlementSummaryPendingArrowImage;
            k.b(imageView, "mBinding.bwSettlementSummaryPendingArrowImage");
            imageView.setRotation(z ? 180.0f : 0.0f);
            if (arrayList == null || !z) {
                LinearLayout linearLayout2 = this.mBinding.bwPendingAmountDetailsContainer;
                k.b(linearLayout2, "mBinding.bwPendingAmountDetailsContainer");
                linearLayout2.setVisibility(8);
                RelativeLayout relativeLayout2 = this.mBinding.rlPendingHeader;
                k.b(relativeLayout2, "mBinding.rlPendingHeader");
                relativeLayout2.setVisibility(8);
                return;
            }
            LinearLayout linearLayout3 = this.mBinding.bwPendingAmountDetailsContainer;
            k.b(linearLayout3, "mBinding.bwPendingAmountDetailsContainer");
            linearLayout3.setVisibility(0);
            RelativeLayout relativeLayout3 = this.mBinding.rlPendingHeader;
            k.b(relativeLayout3, "mBinding.rlPendingHeader");
            relativeLayout3.setVisibility(0);
            populateAlreadySettledData(arrayList, true);
        }

        private final void populateAlreadySettledData(ArrayList<M2BOrderListItemModel> arrayList, boolean z) {
            ArrayList arrayList2;
            LinearLayout linearLayout = this.mBinding.bwAlreadySettledAmountDetailsContainer;
            k.b(linearLayout, "mBinding.bwAlreadySettledAmountDetailsContainer");
            if (z) {
                linearLayout = this.mBinding.bwPendingAmountDetailsContainer;
                k.b(linearLayout, "mBinding.bwPendingAmountDetailsContainer");
            }
            if (arrayList != null) {
                arrayList2 = new ArrayList();
                int i2 = 0;
                for (T next : arrayList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    if (i2 < 3) {
                        arrayList2.add(next);
                    }
                    i2 = i3;
                }
            } else {
                arrayList2 = null;
            }
            ArrayList arrayList3 = arrayList2;
            int i4 = 0;
            while (i4 < linearLayout.getChildCount()) {
                android.view.View childAt = linearLayout.getChildAt(i4);
                if (i4 < arrayList3.size()) {
                    k.b(childAt, "child");
                    childAt.setVisibility(0);
                    setAlreadySettledChildElement((M2BOrderListItemModel) arrayList3.get(i4), childAt);
                } else {
                    k.b(childAt, "child");
                    childAt.setVisibility(8);
                }
                if (i4 == arrayList3.size() - 1) {
                    android.view.View findViewById = childAt.findViewById(R.id.bwAlreadySettledDivider);
                    k.b(findViewById, "child.findViewById<View>….bwAlreadySettledDivider)");
                    findViewById.setVisibility(8);
                } else {
                    android.view.View findViewById2 = childAt.findViewById(R.id.bwAlreadySettledDivider);
                    k.b(findViewById2, "child.findViewById<View>….bwAlreadySettledDivider)");
                    findViewById2.setVisibility(0);
                }
                i4++;
            }
            while (i4 < arrayList3.size()) {
                MpBwAlreadySettledElementBinding inflate = MpBwAlreadySettledElementBinding.inflate(LayoutInflater.from(this.this$0.mContext));
                k.b(inflate, "MpBwAlreadySettledElemen…tInflater.from(mContext))");
                M2BOrderListItemModel m2BOrderListItemModel = arrayList.get(i4);
                k.b(m2BOrderListItemModel, "settlementList[i]");
                android.view.View root = inflate.getRoot();
                k.b(root, "childBinding.root");
                setAlreadySettledChildElement(m2BOrderListItemModel, root);
                if (i4 == arrayList3.size() - 1) {
                    android.view.View view = inflate.bwAlreadySettledDivider;
                    k.b(view, "childBinding.bwAlreadySettledDivider");
                    view.setVisibility(8);
                } else {
                    android.view.View view2 = inflate.bwAlreadySettledDivider;
                    k.b(view2, "childBinding.bwAlreadySettledDivider");
                    view2.setVisibility(0);
                }
                linearLayout.addView(inflate.getRoot(), i4);
                i4++;
            }
        }

        private final void setAlreadySettledChildElement(M2BOrderListItemModel m2BOrderListItemModel, android.view.View view) {
            String maskedCardNo;
            TextView textView = (TextView) view.findViewById(R.id.bwAlreadySettledTime);
            TextView textView2 = (TextView) view.findViewById(R.id.bwAlreadySettledUTRNumber);
            TextView textView3 = (TextView) view.findViewById(R.id.bwAlreadySettledAmount);
            TextView textView4 = (TextView) view.findViewById(R.id.bwPendingSettlementTime);
            view.findViewById(R.id.bwVerticalSpace);
            ImageView imageView = (ImageView) view.findViewById(R.id.bwAlreadySettledlBankLogoImage);
            TextView textView5 = (TextView) view.findViewById(R.id.bwAlreadySettledBankAccountNumber);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_bank_details);
            k.b(textView2, "utrText");
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            ((ImageView) view.findViewById(R.id.bwAlreadySettledTickImage)).setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.this$0.mContext, m2BOrderListItemModel.getOrderStatus()));
            k.b(textView, "bwAlreadySettledText");
            textView.setText(P4BSettlementsDataHelperMP.INSTANCE.getBWSDetailStatusText(m2BOrderListItemModel.getOrderStatus(), 1, m2BOrderListItemModel.getOrderCreatedTime(), m2BOrderListItemModel.getOrderCompletedTime()));
            k.b(textView3, "settleAmountText");
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            AmountModel payMoneyAmount = m2BOrderListItemModel.getPayMoneyAmount();
            String str = null;
            textView3.setText(labelPopulationHelperMP.parseAndGetAmountString(payMoneyAmount != null ? payMoneyAmount.getValue() : null, true));
            MpP4bBankImageTarget mpP4bBankImageTarget = new MpP4bBankImageTarget(new WeakReference(imageView));
            w a2 = w.a();
            AdditionalInfoModel additionalInfo = m2BOrderListItemModel.getAdditionalInfo();
            a2.a(additionalInfo != null ? additionalInfo.getBankIconUrl() : null).a((af) mpP4bBankImageTarget);
            k.b(textView5, "bankAccountNumber");
            StringBuilder sb = new StringBuilder();
            AdditionalInfoModel additionalInfo2 = m2BOrderListItemModel.getAdditionalInfo();
            sb.append(additionalInfo2 != null ? additionalInfo2.getReceiverBankName() : null);
            sb.append("  ");
            AdditionalInfoModel additionalInfo3 = m2BOrderListItemModel.getAdditionalInfo();
            if (!(additionalInfo3 == null || (maskedCardNo = additionalInfo3.getMaskedCardNo()) == null)) {
                str = UIUtilityMPKt.getDisplayBankAccountNumberMP$default(maskedCardNo, 0, 0, 6, (Object) null);
            }
            sb.append(str);
            textView5.setText(sb.toString());
            if (p.a("SUCCESS", m2BOrderListItemModel.getOrderStatus(), true)) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                textView2.setText(instance.getAppContext().getString(R.string.mp_lbl_utr_number, new Object[]{m2BOrderListItemModel.getReconId()}));
                layoutParams.height = -2;
            } else {
                textView2.setText("");
                layoutParams.height = 0;
                k.b(linearLayout, "llBankDetails");
                linearLayout.setVisibility(8);
                k.b(textView4, "pendingSettlementTime");
                String timeFromTimeStamp = DateUtility.getTimeFromTimeStamp(m2BOrderListItemModel.getOrderCreatedTime());
                k.b(timeFromTimeStamp, "DateUtility.getTimeFromT…mp(item.orderCreatedTime)");
                if (timeFromTimeStamp != null) {
                    String lowerCase = timeFromTimeStamp.toLowerCase();
                    k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                    textView4.setText(lowerCase);
                    textView4.setVisibility(0);
                    textView2.setVisibility(8);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            textView2.setLayoutParams(layoutParams);
        }

        private final void populateLabels(LinearLayout linearLayout, ArrayList<LabelModel> arrayList, boolean z, boolean z2, ArrayList<M2BOrderListItemModel> arrayList2, ArrayList<M2BOrderListItemModel> arrayList3, String str, String str2) {
            LinearLayout linearLayout2 = linearLayout;
            ArrayList<LabelModel> arrayList4 = arrayList;
            boolean z3 = z;
            boolean z4 = z2;
            ArrayList<M2BOrderListItemModel> arrayList5 = arrayList2;
            ArrayList<M2BOrderListItemModel> arrayList6 = arrayList3;
            int i2 = 1;
            int i3 = 0;
            boolean z5 = false;
            boolean z6 = false;
            while (true) {
                android.view.View childAt = linearLayout2.getChildAt(i2);
                k.b(childAt, "layout.getChildAt(i)");
                int id = childAt.getId();
                ConstraintLayout constraintLayout = this.mBinding.bwAlreadySettledToBankContainer;
                k.b(constraintLayout, "mBinding.bwAlreadySettledToBankContainer");
                if (id == constraintLayout.getId()) {
                    break;
                }
                android.view.View childAt2 = linearLayout2.getChildAt(i2);
                if (arrayList4 == null || i3 >= arrayList.size()) {
                    k.b(childAt2, "child");
                    childAt2.setVisibility(8);
                } else {
                    if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(arrayList4.get(i3).getValue())) {
                        z5 = true;
                    }
                    if (LabelPopulationHelperMP.INSTANCE.isKeyAleadySettledToBank(arrayList4.get(i3).getKey())) {
                        LabelModel labelModel = arrayList4.get(i3);
                        k.b(labelModel, "labelList[j]");
                        setAlradySettledToBankContainer(labelModel, z3, arrayList5);
                        i3++;
                        z6 = true;
                    } else {
                        if (!LabelPopulationHelperMP.INSTANCE.isKeyAleadySettledToBank(arrayList4.get(i3).getKey())) {
                            if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(arrayList4.get(i3).getValue())) {
                                k.b(childAt2, "child");
                                LabelModel labelModel2 = arrayList4.get(i3);
                                k.b(labelModel2, "labelList[j]");
                                populateLabelView(childAt2, labelModel2);
                            } else {
                                i3++;
                            }
                        }
                        i3++;
                    }
                }
                i2++;
            }
            boolean z7 = z6;
            boolean z8 = false;
            while (arrayList4 != null && i3 < arrayList.size()) {
                if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(arrayList4.get(i3).getValue())) {
                    z5 = true;
                }
                if (LabelPopulationHelperMP.INSTANCE.isKeyAleadySettledToBank(arrayList4.get(i3).getKey())) {
                    LabelModel labelModel3 = arrayList4.get(i3);
                    k.b(labelModel3, "labelList[j]");
                    setAlradySettledToBankContainer(labelModel3, z3, arrayList5);
                    z7 = true;
                } else if (LabelPopulationHelperMP.INSTANCE.isKeyPendingM2BSum(arrayList4.get(i3).getKey())) {
                    LabelModel labelModel4 = arrayList4.get(i3);
                    k.b(labelModel4, "labelList[j]");
                    setPendingSettledToBankContainer(labelModel4, z4, arrayList6);
                    z8 = true;
                } else if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(arrayList4.get(i3).getValue())) {
                    MpPaymentInfoTileBinding inflate = MpPaymentInfoTileBinding.inflate(LayoutInflater.from(this.this$0.mContext));
                    k.b(inflate, "MpPaymentInfoTileBinding…tInflater.from(mContext))");
                    android.view.View root = inflate.getRoot();
                    k.b(root, "childBinding.root");
                    LabelModel labelModel5 = arrayList4.get(i3);
                    k.b(labelModel5, "labelList[j]");
                    populateLabelView(root, labelModel5);
                    linearLayout2.addView(inflate.getRoot(), i2);
                    android.view.View root2 = inflate.getRoot();
                    k.b(root2, "childBinding.root");
                    ViewGroup.LayoutParams layoutParams = root2.getLayoutParams();
                    if (layoutParams != null) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        Resources resources = this.this$0.mContext.getResources();
                        k.b(resources, "mContext.resources");
                        layoutParams2.setMarginStart((int) (resources.getDisplayMetrics().density * 15.0f));
                        Resources resources2 = this.this$0.mContext.getResources();
                        k.b(resources2, "mContext.resources");
                        layoutParams2.setMarginEnd((int) (resources2.getDisplayMetrics().density * 15.0f));
                        android.view.View root3 = inflate.getRoot();
                        k.b(root3, "childBinding.root");
                        root3.setLayoutParams(layoutParams2);
                        i2++;
                        z5 = true;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                } else {
                    continue;
                }
                i3++;
            }
            if (!z7) {
                setAlradySettledToBankContainer(new LabelModel("", "0", (ArrayList<PreviouslyFailedBalanceData>) null), z3, arrayList5);
            }
            if (!z8) {
                setPendingSettledToBankContainer(new LabelModel("", "0", (ArrayList<PreviouslyFailedBalanceData>) null), z4, arrayList6);
            }
            if (!z5) {
                setSingleElementState(str, str2);
            } else {
                setMultipleElementState();
            }
        }

        private final void populateLabelView(android.view.View view, LabelModel labelModel) {
            LabelPopulationHelperMP.INSTANCE.populateLabelSummaryData(view, labelModel, this.this$0.mContext, this.this$0.mListener);
        }
    }

    public final class BWSettlementElementViewHolder extends BaseViewHolder {
        public final MpBwSettlementSingleBankElementBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BWSettlementElementViewHolder(HomeRVAdapter homeRVAdapter, MpBwSettlementSingleBankElementBinding mpBwSettlementSingleBankElementBinding) {
            super(mpBwSettlementSingleBankElementBinding.getRoot());
            k.d(mpBwSettlementSingleBankElementBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpBwSettlementSingleBankElementBinding;
        }

        public final MpBwSettlementSingleBankElementBinding getMBinding() {
            return this.mBinding;
        }

        private final Drawable getDrawableBasedOnPriority(SettlementBillListItemModel settlementBillListItemModel) {
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            AmountModel failedAmount = settlementBillListItemModel.getFailedAmount();
            String str = null;
            if (labelPopulationHelperMP.isAmountNonZero(failedAmount != null ? failedAmount.getValue() : null)) {
                return b.a(this.this$0.mContext, R.drawable.mp_ic_icon_red_error);
            }
            LabelPopulationHelperMP labelPopulationHelperMP2 = LabelPopulationHelperMP.INSTANCE;
            AmountModel pendingAmount = settlementBillListItemModel.getPendingAmount();
            if (pendingAmount != null) {
                str = pendingAmount.getValue();
            }
            if (labelPopulationHelperMP2.isAmountNonZero(str)) {
                return b.a(this.this$0.mContext, R.drawable.mp_ic_icon_ui_warning);
            }
            return b.a(this.this$0.mContext, R.drawable.mp_ic_green_tick_success_36dp);
        }

        public final void bindData(Object obj, int i2) {
            ArrayList<SettlementBankDetailModel> bankDetails;
            if (obj instanceof SettlementBillListItemModel) {
                SettlementBillListItemModel settlementBillListItemModel = (SettlementBillListItemModel) obj;
                setCommonData(settlementBillListItemModel, i2);
                if (settlementBillListItemModel.getBankDetails() != null && ((bankDetails = settlementBillListItemModel.getBankDetails()) == null || bankDetails.size() != 0)) {
                    ArrayList<SettlementBankDetailModel> bankDetails2 = settlementBillListItemModel.getBankDetails();
                    k.a((Object) bankDetails2);
                    if (bankDetails2.size() <= 1) {
                        handleSingleBankSettlement(settlementBillListItemModel, i2);
                        return;
                    }
                }
                handleMultipleBankSettlements(settlementBillListItemModel, i2);
            }
        }

        private final void setCommonData(SettlementBillListItemModel settlementBillListItemModel, int i2) {
            HomeRVAdapter homeRVAdapter = this.this$0;
            android.view.View root = this.mBinding.getRoot();
            k.b(root, "mBinding.root");
            homeRVAdapter.setAlternatingColorRelativeToViewPastSettlements(root, i2);
            MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementDateHeader;
            k.b(mpRoboTextView, "mBinding.bwSettlementDateHeader");
            mpRoboTextView.setText(DateUtility.getDateFromTimeStamp(settlementBillListItemModel.getSettlementTime()) + ", ");
            LabelPopulationHelperMP.INSTANCE.setSettlementTime(settlementBillListItemModel.getSettlementTime());
            this.mBinding.contactUsClickableText.setOnClickListener(new HomeRVAdapter$BWSettlementElementViewHolder$setCommonData$1(this, settlementBillListItemModel));
            int commonSettlementState = getCommonSettlementState(settlementBillListItemModel);
            this.mBinding.bwSettlementElementRoot.setOnClickListener(new HomeRVAdapter$BWSettlementElementViewHolder$setCommonData$2(this, settlementBillListItemModel, i2));
            MpRoboTextView mpRoboTextView2 = this.mBinding.bwSettlementTotalAmount;
            k.b(mpRoboTextView2, "mBinding.bwSettlementTotalAmount");
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount = settlementBillListItemModel.getNetAmount();
            mpRoboTextView2.setText(labelPopulationHelperMP.parseAndGetAmountString(netAmount != null ? netAmount.getValue() : null, true));
            ImageView imageView = this.mBinding.bwSettlementArrow;
            k.b(imageView, "mBinding.bwSettlementArrow");
            imageView.setRotation(settlementBillListItemModel.isExpanded() ? 180.0f : 0.0f);
            this.mBinding.bwSettlementStatusIcon.setImageDrawable(getDrawableBasedOnPriority(settlementBillListItemModel));
            if (commonSettlementState == 1) {
                MpFlowLayout mpFlowLayout = this.mBinding.bwSettlementElementContactUsPending;
                k.b(mpFlowLayout, "mBinding.bwSettlementElementContactUsPending");
                mpFlowLayout.setVisibility(0);
            } else {
                MpFlowLayout mpFlowLayout2 = this.mBinding.bwSettlementElementContactUsPending;
                k.b(mpFlowLayout2, "mBinding.bwSettlementElementContactUsPending");
                mpFlowLayout2.setVisibility(8);
            }
            handlePendingSettlementCardVisibility(settlementBillListItemModel);
            handleFailedSettlementTextIfAny(settlementBillListItemModel.getFailedAmount(), settlementBillListItemModel.getNetAmount());
            handlePendingSettlementTextIfAny(settlementBillListItemModel.getPendingAmount(), settlementBillListItemModel.getNetAmount());
            handleCommonFlowLayoutUI(settlementBillListItemModel);
        }

        private final void handleCommonFlowLayoutUI(SettlementBillListItemModel settlementBillListItemModel) {
            ArrayList<SettlementBankDetailModel> bankDetails = settlementBillListItemModel.getBankDetails();
            if (bankDetails == null || bankDetails.isEmpty()) {
                MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementToLabel;
                k.b(mpRoboTextView, "mBinding.bwSettlementToLabel");
                mpRoboTextView.setVisibility(0);
            } else {
                MpRoboTextView mpRoboTextView2 = this.mBinding.bwSettlementToLabel;
                k.b(mpRoboTextView2, "mBinding.bwSettlementToLabel");
                mpRoboTextView2.setVisibility(8);
            }
            ArrayList<SettlementBankDetailModel> bankDetails2 = settlementBillListItemModel.getBankDetails();
            if (!(bankDetails2 == null || bankDetails2.isEmpty())) {
                ArrayList<SettlementBankDetailModel> bankDetails3 = settlementBillListItemModel.getBankDetails();
                k.a((Object) bankDetails3);
                if (bankDetails3.size() != 1) {
                    ImageView imageView = this.mBinding.bwSettlementStatusIcon;
                    k.b(imageView, "mBinding.bwSettlementStatusIcon");
                    imageView.setVisibility(8);
                    RoboTextView roboTextView = this.mBinding.bwMultipleAccountText;
                    k.b(roboTextView, "mBinding.bwMultipleAccountText");
                    roboTextView.setVisibility(0);
                    return;
                }
            }
            ImageView imageView2 = this.mBinding.bwSettlementStatusIcon;
            k.b(imageView2, "mBinding.bwSettlementStatusIcon");
            imageView2.setVisibility(0);
            RoboTextView roboTextView2 = this.mBinding.bwMultipleAccountText;
            k.b(roboTextView2, "mBinding.bwMultipleAccountText");
            roboTextView2.setVisibility(8);
        }

        private final void handlePendingSettlementCardVisibility(SettlementBillListItemModel settlementBillListItemModel) {
            if (settlementBillListItemModel.isExpanded() && settlementBillListItemModel.getPendingAmount() != null) {
                AmountModel pendingAmount = settlementBillListItemModel.getPendingAmount();
                k.a((Object) pendingAmount);
                String value = pendingAmount.getValue();
                if (!(value == null || value.length() == 0)) {
                    PendingSettlementCardModel pendingCard = P4BSettlementsDataHelperMP.INSTANCE.getPendingCard(settlementBillListItemModel);
                    if (pendingCard != null) {
                        MpPendingSettlementCardItemBinding mpPendingSettlementCardItemBinding = this.mBinding.pendingSettlementCard;
                        k.b(mpPendingSettlementCardItemBinding, "mBinding.pendingSettlementCard");
                        mpPendingSettlementCardItemBinding.setModel(pendingCard);
                        ConstraintLayout constraintLayout = this.mBinding.pendingSettlementCard.pendingCard;
                        k.b(constraintLayout, "mBinding.pendingSettlementCard.pendingCard");
                        constraintLayout.setVisibility(0);
                        return;
                    }
                    ConstraintLayout constraintLayout2 = this.mBinding.pendingSettlementCard.pendingCard;
                    k.b(constraintLayout2, "mBinding.pendingSettlementCard.pendingCard");
                    constraintLayout2.setVisibility(8);
                    return;
                }
            }
            ConstraintLayout constraintLayout3 = this.mBinding.pendingSettlementCard.pendingCard;
            k.b(constraintLayout3, "mBinding.pendingSettlementCard.pendingCard");
            constraintLayout3.setVisibility(8);
        }

        private final void handleFailedSettlementTextIfAny(AmountModel amountModel, AmountModel amountModel2) {
            String str;
            String str2 = null;
            String parseAndGetAmountString = LabelPopulationHelperMP.INSTANCE.parseAndGetAmountString(amountModel != null ? amountModel.getValue() : null, true);
            String parseAndGetAmountString2 = LabelPopulationHelperMP.INSTANCE.parseAndGetAmountString(amountModel2 != null ? amountModel2.getValue() : null, true);
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Context appContext = instance.getAppContext();
            if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(amountModel != null ? amountModel.getValue() : null)) {
                LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
                if (amountModel2 != null) {
                    str2 = amountModel2.getValue();
                }
                boolean isAmountNonZero = labelPopulationHelperMP.isAmountNonZero(str2);
                RoboTextView roboTextView = this.mBinding.bwFailedSettlementText;
                k.b(roboTextView, "mBinding.bwFailedSettlementText");
                if (isAmountNonZero) {
                    str = appContext.getString(R.string.mp_label_settlement_failed_text_with_total_amount, new Object[]{parseAndGetAmountString, parseAndGetAmountString2});
                } else {
                    str = appContext.getString(R.string.mp_label_settlement_failed_text_no_total_amount, new Object[]{parseAndGetAmountString});
                }
                roboTextView.setText(str);
                RoboTextView roboTextView2 = this.mBinding.bwFailedSettlementText;
                k.b(roboTextView2, "mBinding.bwFailedSettlementText");
                roboTextView2.setVisibility(0);
                return;
            }
            RoboTextView roboTextView3 = this.mBinding.bwFailedSettlementText;
            k.b(roboTextView3, "mBinding.bwFailedSettlementText");
            roboTextView3.setVisibility(8);
        }

        private final void handlePendingSettlementTextIfAny(AmountModel amountModel, AmountModel amountModel2) {
            String str;
            String str2 = null;
            String a2 = p.a(LabelPopulationHelperMP.INSTANCE.parseAndGetAmountString(amountModel != null ? amountModel.getValue() : null, true), ' ');
            String a3 = p.a(LabelPopulationHelperMP.INSTANCE.parseAndGetAmountString(amountModel2 != null ? amountModel2.getValue() : null, true), ' ');
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Context appContext = instance.getAppContext();
            if (LabelPopulationHelperMP.INSTANCE.isAmountNonZero(amountModel != null ? amountModel.getValue() : null)) {
                LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
                if (amountModel2 != null) {
                    str2 = amountModel2.getValue();
                }
                boolean isAmountNonZero = labelPopulationHelperMP.isAmountNonZero(str2);
                RoboTextView roboTextView = this.mBinding.bwPendingSettlementText;
                k.b(roboTextView, "mBinding.bwPendingSettlementText");
                if (isAmountNonZero) {
                    str = appContext.getString(R.string.mp_label_settlement_pending_text_with_total_amount, new Object[]{a2, a3});
                } else {
                    str = appContext.getString(R.string.mp_label_settlement_pending_text_no_total_amount, new Object[]{a2});
                }
                roboTextView.setText(str);
                RoboTextView roboTextView2 = this.mBinding.bwPendingSettlementText;
                k.b(roboTextView2, "mBinding.bwPendingSettlementText");
                roboTextView2.setVisibility(0);
                return;
            }
            RoboTextView roboTextView3 = this.mBinding.bwPendingSettlementText;
            k.b(roboTextView3, "mBinding.bwPendingSettlementText");
            roboTextView3.setVisibility(8);
        }

        private final int getCommonSettlementState(SettlementBillListItemModel settlementBillListItemModel) {
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount = settlementBillListItemModel.getNetAmount();
            String str = null;
            if (!labelPopulationHelperMP.isAmountNonZero(netAmount != null ? netAmount.getValue() : null)) {
                LabelPopulationHelperMP labelPopulationHelperMP2 = LabelPopulationHelperMP.INSTANCE;
                AmountModel pendingAmount = settlementBillListItemModel.getPendingAmount();
                if (!labelPopulationHelperMP2.isAmountNonZero(pendingAmount != null ? pendingAmount.getValue() : null)) {
                    LabelPopulationHelperMP labelPopulationHelperMP3 = LabelPopulationHelperMP.INSTANCE;
                    AmountModel failedAmount = settlementBillListItemModel.getFailedAmount();
                    if (!labelPopulationHelperMP3.isAmountNonZero(failedAmount != null ? failedAmount.getValue() : null)) {
                        return 5;
                    }
                }
            }
            LabelPopulationHelperMP labelPopulationHelperMP4 = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount2 = settlementBillListItemModel.getNetAmount();
            if (labelPopulationHelperMP4.isAmountNonZero(netAmount2 != null ? netAmount2.getValue() : null)) {
                LabelPopulationHelperMP labelPopulationHelperMP5 = LabelPopulationHelperMP.INSTANCE;
                AmountModel pendingAmount2 = settlementBillListItemModel.getPendingAmount();
                if (!labelPopulationHelperMP5.isAmountNonZero(pendingAmount2 != null ? pendingAmount2.getValue() : null)) {
                    LabelPopulationHelperMP labelPopulationHelperMP6 = LabelPopulationHelperMP.INSTANCE;
                    AmountModel failedAmount2 = settlementBillListItemModel.getFailedAmount();
                    if (!labelPopulationHelperMP6.isAmountNonZero(failedAmount2 != null ? failedAmount2.getValue() : null)) {
                        return 0;
                    }
                }
            }
            LabelPopulationHelperMP labelPopulationHelperMP7 = LabelPopulationHelperMP.INSTANCE;
            AmountModel pendingAmount3 = settlementBillListItemModel.getPendingAmount();
            if (labelPopulationHelperMP7.isAmountNonZero(pendingAmount3 != null ? pendingAmount3.getValue() : null)) {
                LabelPopulationHelperMP labelPopulationHelperMP8 = LabelPopulationHelperMP.INSTANCE;
                AmountModel netAmount3 = settlementBillListItemModel.getNetAmount();
                if (!labelPopulationHelperMP8.isAmountNonZero(netAmount3 != null ? netAmount3.getValue() : null)) {
                    LabelPopulationHelperMP labelPopulationHelperMP9 = LabelPopulationHelperMP.INSTANCE;
                    AmountModel failedAmount3 = settlementBillListItemModel.getFailedAmount();
                    if (!labelPopulationHelperMP9.isAmountNonZero(failedAmount3 != null ? failedAmount3.getValue() : null)) {
                        return 1;
                    }
                }
            }
            LabelPopulationHelperMP labelPopulationHelperMP10 = LabelPopulationHelperMP.INSTANCE;
            AmountModel failedAmount4 = settlementBillListItemModel.getFailedAmount();
            if (labelPopulationHelperMP10.isAmountNonZero(failedAmount4 != null ? failedAmount4.getValue() : null)) {
                LabelPopulationHelperMP labelPopulationHelperMP11 = LabelPopulationHelperMP.INSTANCE;
                AmountModel netAmount4 = settlementBillListItemModel.getNetAmount();
                if (!labelPopulationHelperMP11.isAmountNonZero(netAmount4 != null ? netAmount4.getValue() : null)) {
                    LabelPopulationHelperMP labelPopulationHelperMP12 = LabelPopulationHelperMP.INSTANCE;
                    AmountModel pendingAmount4 = settlementBillListItemModel.getPendingAmount();
                    if (!labelPopulationHelperMP12.isAmountNonZero(pendingAmount4 != null ? pendingAmount4.getValue() : null)) {
                        return 2;
                    }
                }
            }
            LabelPopulationHelperMP labelPopulationHelperMP13 = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount5 = settlementBillListItemModel.getNetAmount();
            if (netAmount5 != null) {
                str = netAmount5.getValue();
            }
            return !labelPopulationHelperMP13.isAmountNonZero(str) ? 3 : 4;
        }

        private final void setMultiSingleBankCommonVisibility(int i2) {
            ImageView imageView = this.mBinding.bwSettlementMultiBankLogo;
            k.b(imageView, "mBinding.bwSettlementMultiBankLogo");
            imageView.setVisibility(i2);
            MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementMultiBankAccountNumber;
            k.b(mpRoboTextView, "mBinding.bwSettlementMultiBankAccountNumber");
            mpRoboTextView.setVisibility(i2);
            MpRoboTextView mpRoboTextView2 = this.mBinding.bwSettlementMultiBankName;
            k.b(mpRoboTextView2, "mBinding.bwSettlementMultiBankName");
            mpRoboTextView2.setVisibility(i2);
        }

        private final void handleSingleBankSettlement(SettlementBillListItemModel settlementBillListItemModel, int i2) {
            String str;
            String str2;
            String str3;
            SettlementBankDetailModel settlementBankDetailModel;
            SettlementBankDetailModel settlementBankDetailModel2;
            SettlementBankDetailModel settlementBankDetailModel3;
            MpP4bBankImageTarget mpP4bBankImageTarget = new MpP4bBankImageTarget(new WeakReference(this.mBinding.bwSettlementMultiBankLogo));
            setMultiSingleBankCommonVisibility(0);
            w a2 = w.a();
            ArrayList<SettlementBankDetailModel> bankDetails = settlementBillListItemModel.getBankDetails();
            if (bankDetails == null || (settlementBankDetailModel3 = bankDetails.get(0)) == null || (str = settlementBankDetailModel3.getBankIconUrl()) == null) {
                str = "";
            }
            a2.a(str).a((af) mpP4bBankImageTarget);
            MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementMultiBankName;
            k.b(mpRoboTextView, "mBinding.bwSettlementMultiBankName");
            ArrayList<SettlementBankDetailModel> bankDetails2 = settlementBillListItemModel.getBankDetails();
            if (bankDetails2 == null || (settlementBankDetailModel2 = bankDetails2.get(0)) == null || (str2 = settlementBankDetailModel2.getBankName()) == null) {
                str2 = "";
            }
            mpRoboTextView.setText(str2);
            MpRoboTextView mpRoboTextView2 = this.mBinding.bwSettlementMultiBankAccountNumber;
            k.b(mpRoboTextView2, "mBinding.bwSettlementMultiBankAccountNumber");
            ArrayList<SettlementBankDetailModel> bankDetails3 = settlementBillListItemModel.getBankDetails();
            if (bankDetails3 == null || (settlementBankDetailModel = bankDetails3.get(0)) == null || (str3 = settlementBankDetailModel.getAccountNumber()) == null) {
                str3 = "";
            }
            mpRoboTextView2.setText(str3);
            if (settlementBillListItemModel.isExpanded()) {
                setSingleBankExpandedState(settlementBillListItemModel, i2);
            } else {
                setCompressedState();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0053  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void handleMultipleBankSettlements(com.business.merchant_payments.settlement.model.SettlementBillListItemModel r5, int r6) {
            /*
                r4 = this;
                r0 = 8
                r4.setMultiSingleBankCommonVisibility(r0)
                int r0 = r4.getCommonSettlementState(r5)
                java.util.ArrayList r1 = r5.getBankDetails()
                java.lang.String r2 = "mBinding.bwSettlementToLabel"
                if (r1 == 0) goto L_0x0030
                java.util.ArrayList r1 = r5.getBankDetails()
                kotlin.g.b.k.a((java.lang.Object) r1)
                int r1 = r1.size()
                if (r1 == 0) goto L_0x0030
                com.business.merchant_payments.databinding.MpBwSettlementSingleBankElementBinding r1 = r4.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r1 = r1.bwSettlementToLabel
                kotlin.g.b.k.b(r1, r2)
                com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP r2 = com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP.INSTANCE
                r3 = 0
                java.lang.String r0 = r2.getBWSettlementStatusText(r0, r3)
                r1.setText(r0)
                goto L_0x004d
            L_0x0030:
                com.business.merchant_payments.databinding.MpBwSettlementSingleBankElementBinding r0 = r4.mBinding
                com.business.merchant_payments.widget.MpRoboTextView r0 = r0.bwSettlementToLabel
                kotlin.g.b.k.b(r0, r2)
                com.business.merchant_payments.PaymentsConfig r1 = com.business.merchant_payments.PaymentsConfig.getInstance()
                java.lang.String r2 = "PaymentsConfig.getInstance()"
                kotlin.g.b.k.b(r1, r2)
                android.content.Context r1 = r1.getAppContext()
                int r2 = com.business.merchant_payments.R.string.mp_label_settlement
                java.lang.String r1 = r1.getString(r2)
                r0.setText(r1)
            L_0x004d:
                boolean r0 = r5.isExpanded()
                if (r0 == 0) goto L_0x0057
                r4.setMultipleBankExpandedState(r5, r6)
                return
            L_0x0057:
                r4.setCompressedState()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.BWSettlementElementViewHolder.handleMultipleBankSettlements(com.business.merchant_payments.settlement.model.SettlementBillListItemModel, int):void");
        }

        private final void setCompressedState() {
            ConstraintLayout constraintLayout = this.mBinding.bwSettlementSingleBankListItemDetailContainer;
            k.b(constraintLayout, "mBinding.bwSettlementSin…nkListItemDetailContainer");
            constraintLayout.setVisibility(8);
            LinearLayout linearLayout = this.mBinding.bwSettlementAmountDetailsContainer;
            k.b(linearLayout, "mBinding.bwSettlementAmountDetailsContainer");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.mBinding.bwSettlementDetailContainer;
            k.b(linearLayout2, "mBinding.bwSettlementDetailContainer");
            linearLayout2.setVisibility(8);
            MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementMultiBankName;
            k.b(mpRoboTextView, "mBinding.bwSettlementMultiBankName");
            mpRoboTextView.setVisibility(8);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
            r4 = (r4 = r8.getSettlementBillListDetails()).get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.content.Intent getIntentForSettlementDetail(java.lang.String r6, java.lang.String r7, com.business.merchant_payments.settlement.model.SettlementBillListItemModel r8, int r9) {
            /*
                r5 = this;
                android.content.Intent r0 = new android.content.Intent
                com.business.merchant_payments.newhome.HomeRVAdapter r1 = r5.this$0
                android.content.Context r1 = r1.mContext
                java.lang.Class<com.business.merchant_payments.settlement.SettlementDetail> r2 = com.business.merchant_payments.settlement.SettlementDetail.class
                r0.<init>(r1, r2)
                java.lang.String r1 = com.business.merchant_payments.common.utility.AppConstants.START_DATE
                r2 = 0
                r3 = 0
                if (r8 == 0) goto L_0x0026
                java.util.ArrayList r4 = r8.getSettlementBillListDetails()
                if (r4 == 0) goto L_0x0026
                java.lang.Object r4 = r4.get(r3)
                com.business.merchant_payments.settlement.model.M2BOrderListItemModel r4 = (com.business.merchant_payments.settlement.model.M2BOrderListItemModel) r4
                if (r4 == 0) goto L_0x0026
                java.lang.String r4 = r4.getOrderCreatedTime()
                goto L_0x0027
            L_0x0026:
                r4 = r2
            L_0x0027:
                r0.putExtra(r1, r4)
                java.lang.String r1 = "net_amount"
                r0.putExtra(r1, r6)
                java.lang.String r6 = "settlement_type"
                r0.putExtra(r6, r7)
                java.lang.String r6 = "is_settled_in_multiple_bank"
                r0.putExtra(r6, r9)
                if (r8 == 0) goto L_0x0055
                java.util.ArrayList r6 = r8.getSettlementBillListDetails()
                if (r6 == 0) goto L_0x0055
                java.lang.Object r6 = r6.get(r3)
                com.business.merchant_payments.settlement.model.M2BOrderListItemModel r6 = (com.business.merchant_payments.settlement.model.M2BOrderListItemModel) r6
                if (r6 == 0) goto L_0x0055
                com.business.merchant_payments.settlement.model.AdditionalInfoModel r6 = r6.getAdditionalInfo()
                if (r6 == 0) goto L_0x0055
                java.lang.String r6 = r6.getBankIconUrl()
                goto L_0x0056
            L_0x0055:
                r6 = r2
            L_0x0056:
                if (r6 == 0) goto L_0x0079
                if (r8 == 0) goto L_0x0073
                java.util.ArrayList r6 = r8.getSettlementBillListDetails()
                if (r6 == 0) goto L_0x0073
                java.lang.Object r6 = r6.get(r3)
                com.business.merchant_payments.settlement.model.M2BOrderListItemModel r6 = (com.business.merchant_payments.settlement.model.M2BOrderListItemModel) r6
                if (r6 == 0) goto L_0x0073
                com.business.merchant_payments.settlement.model.AdditionalInfoModel r6 = r6.getAdditionalInfo()
                if (r6 == 0) goto L_0x0073
                java.lang.String r6 = r6.getBankIconUrl()
                goto L_0x0074
            L_0x0073:
                r6 = r2
            L_0x0074:
                java.lang.String r7 = "icon_url"
                r0.putExtra(r7, r6)
            L_0x0079:
                if (r8 == 0) goto L_0x008e
                java.util.ArrayList r6 = r8.getBankDetails()
                if (r6 == 0) goto L_0x008e
                java.lang.Object r6 = r6.get(r3)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r6 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r6
                if (r6 == 0) goto L_0x008e
                java.lang.String r6 = r6.getAccountNumber()
                goto L_0x008f
            L_0x008e:
                r6 = r2
            L_0x008f:
                if (r6 == 0) goto L_0x0099
                int r6 = r6.length()
                if (r6 == 0) goto L_0x0099
                r6 = 0
                goto L_0x009a
            L_0x0099:
                r6 = 1
            L_0x009a:
                if (r6 != 0) goto L_0x00b5
                if (r8 == 0) goto L_0x00b0
                java.util.ArrayList r6 = r8.getBankDetails()
                if (r6 == 0) goto L_0x00b0
                java.lang.Object r6 = r6.get(r3)
                com.business.merchant_payments.settlement.model.SettlementBankDetailModel r6 = (com.business.merchant_payments.settlement.model.SettlementBankDetailModel) r6
                if (r6 == 0) goto L_0x00b0
                java.lang.String r2 = r6.getAccountNumber()
            L_0x00b0:
                java.lang.String r6 = "formatted_bank_account_number"
                r0.putExtra(r6, r2)
            L_0x00b5:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.BWSettlementElementViewHolder.getIntentForSettlementDetail(java.lang.String, java.lang.String, com.business.merchant_payments.settlement.model.SettlementBillListItemModel, int):android.content.Intent");
        }

        private final void populatM2BSettlementDetailListSingleBank(SettlementBillListItemModel settlementBillListItemModel, int i2) {
            ArrayList<M2BOrderListItemModel> settlementBillListDetails = settlementBillListItemModel.getSettlementBillListDetails();
            if (settlementBillListDetails == null || settlementBillListDetails.size() != 1) {
                ConstraintLayout constraintLayout = this.mBinding.bwSettlementSingleBankListItemDetailContainer;
                k.b(constraintLayout, "mBinding.bwSettlementSin…nkListItemDetailContainer");
                constraintLayout.setVisibility(8);
                populatM2BSettlementDetailList(settlementBillListItemModel, 1, i2);
                return;
            }
            LinearLayout linearLayout = this.mBinding.bwSettlementDetailContainer;
            k.b(linearLayout, "mBinding.bwSettlementDetailContainer");
            linearLayout.setVisibility(8);
            ConstraintLayout constraintLayout2 = this.mBinding.bwSettlementSingleBankListItemDetailContainer;
            k.b(constraintLayout2, "mBinding.bwSettlementSin…nkListItemDetailContainer");
            constraintLayout2.setVisibility(0);
            this.mBinding.bwSingleBankSettlementStatusImage.setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.this$0.mContext, settlementBillListDetails.get(0).getOrderStatus()));
            MpRoboTextView mpRoboTextView = this.mBinding.bwSingleBankSettlementTimeText;
            k.b(mpRoboTextView, "mBinding.bwSingleBankSettlementTimeText");
            P4BSettlementsDataHelperMP p4BSettlementsDataHelperMP = P4BSettlementsDataHelperMP.INSTANCE;
            String orderStatus = settlementBillListDetails.get(0).getOrderStatus();
            if (orderStatus == null) {
                orderStatus = "";
            }
            String orderCompletedTime = settlementBillListDetails.get(0).getOrderCompletedTime();
            if (orderCompletedTime == null) {
                orderCompletedTime = "";
            }
            String timeFromTimeStamp = DateUtility.getTimeFromTimeStamp(orderCompletedTime);
            k.b(timeFromTimeStamp, "DateUtility.getTimeFromT…orderCompletedTime ?: \"\")");
            mpRoboTextView.setText(p4BSettlementsDataHelperMP.getSettlmentStringM2BDetail(orderStatus, timeFromTimeStamp));
            String reconId = settlementBillListDetails.get(0).getReconId();
            if (reconId == null || p.a(reconId)) {
                MpRoboTextView mpRoboTextView2 = this.mBinding.bwSingleBankSettlementUTRText;
                k.b(mpRoboTextView2, "mBinding.bwSingleBankSettlementUTRText");
                mpRoboTextView2.setText("");
                return;
            }
            MpRoboTextView mpRoboTextView3 = this.mBinding.bwSingleBankSettlementUTRText;
            k.b(mpRoboTextView3, "mBinding.bwSingleBankSettlementUTRText");
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Context appContext = instance.getAppContext();
            int i3 = R.string.mp_lbl_utr_number;
            Object[] objArr = new Object[1];
            String reconId2 = settlementBillListDetails.get(0).getReconId();
            if (reconId2 == null) {
                reconId2 = "";
            }
            objArr[0] = reconId2;
            mpRoboTextView3.setText(appContext.getString(i3, objArr));
        }

        private final void setSingleBankExpandedState(SettlementBillListItemModel settlementBillListItemModel, int i2) {
            MpRoboTextView mpRoboTextView = this.mBinding.bwSettlementMultiBankName;
            k.b(mpRoboTextView, "mBinding.bwSettlementMultiBankName");
            mpRoboTextView.setVisibility(0);
            MpRoboTextView mpRoboTextView2 = this.mBinding.bwSettlementMultiBankName;
            k.b(mpRoboTextView2, "mBinding.bwSettlementMultiBankName");
            ArrayList<SettlementBankDetailModel> bankDetails = settlementBillListItemModel.getBankDetails();
            k.a((Object) bankDetails);
            String bankName = bankDetails.get(0).getBankName();
            if (bankName == null) {
                bankName = "";
            }
            mpRoboTextView2.setText(bankName);
            LabelPopulationHelperMP.INSTANCE.resetAmountOnHoldMap();
            populateLabels(settlementBillListItemModel, 1, i2);
            populatM2BSettlementDetailListSingleBank(settlementBillListItemModel, i2);
        }

        private final void setMultipleBankExpandedState(SettlementBillListItemModel settlementBillListItemModel, int i2) {
            LabelPopulationHelperMP.INSTANCE.resetAmountOnHoldMap();
            ArrayList<SettlementBankDetailModel> bankDetails = settlementBillListItemModel.getBankDetails();
            if (bankDetails == null || bankDetails.isEmpty()) {
                populateLabels(settlementBillListItemModel, 2, i2);
            } else {
                populateLabels(settlementBillListItemModel, 0, i2);
            }
            populatM2BSettlementDetailList(settlementBillListItemModel, 0, i2);
        }

        private final void populateLabels(SettlementBillListItemModel settlementBillListItemModel, int i2, int i3) {
            ArrayList<M2BOrderListItemModel> settlementBillListDetails = settlementBillListItemModel.getSettlementBillListDetails();
            if (settlementBillListDetails == null) {
                SettlementBillListItemModel settlementBillListItemModel2 = settlementBillListItemModel;
            } else if (settlementBillListDetails.size() > 3) {
                MpRoboTextView mpRoboTextView = this.mBinding.tvViewAll;
                k.b(mpRoboTextView, "it");
                mpRoboTextView.setVisibility(0);
                mpRoboTextView.setOnClickListener(new HomeRVAdapter$BWSettlementElementViewHolder$populateLabels$$inlined$let$lambda$1(this, settlementBillListItemModel, i2));
                k.b(mpRoboTextView, "mBinding.tvViewAll.also …  }\n                    }");
            } else {
                SettlementBillListItemModel settlementBillListItemModel3 = settlementBillListItemModel;
                MpRoboTextView mpRoboTextView2 = this.mBinding.tvViewAll;
                k.b(mpRoboTextView2, "mBinding.tvViewAll");
                mpRoboTextView2.setVisibility(8);
            }
            ArrayList<LabelModel> amountDetails = settlementBillListItemModel.getAmountDetails();
            LabelPopulationHelperMP.INSTANCE.resetAmountOnHoldMap();
            HomeRVAdapter homeRVAdapter = this.this$0;
            LinearLayout linearLayout = this.mBinding.bwSettlementAmountDetailsContainer;
            k.b(linearLayout, "mBinding.bwSettlementAmountDetailsContainer");
            homeRVAdapter.setAlternatingBackgroundRelativeToViewPastSettlements(linearLayout, i3 + 1);
            LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
            Context access$getMContext$p = this.this$0.mContext;
            LinearLayout linearLayout2 = this.mBinding.bwSettlementAmountDetailsContainer;
            k.b(linearLayout2, "mBinding.bwSettlementAmountDetailsContainer");
            android.view.View view = this.mBinding.bwSettlementAmountBottomDivider;
            k.b(view, "mBinding.bwSettlementAmountBottomDivider");
            String str = "mBinding.bwSettlementAmountBottomDivider";
            boolean populateAmountDetailLabels = labelPopulationHelperMP.populateAmountDetailLabels(access$getMContext$p, linearLayout2, amountDetails, 2, view.getId(), AppUtility.getValueInDp(this.this$0.mContext, 12), this.this$0.mListener);
            if (amountDetails == null || amountDetails.size() == 0 || !populateAmountDetailLabels) {
                android.view.View view2 = this.mBinding.bwSettlementAmountBottomDivider;
                k.b(view2, str);
                view2.setVisibility(8);
                android.view.View view3 = this.mBinding.bwSettlementAmountTopDivider;
                k.b(view3, "mBinding.bwSettlementAmountTopDivider");
                view3.setVisibility(8);
            } else {
                android.view.View view4 = this.mBinding.bwSettlementAmountBottomDivider;
                k.b(view4, str);
                view4.setVisibility(0);
                android.view.View view5 = this.mBinding.bwSettlementAmountTopDivider;
                k.b(view5, "mBinding.bwSettlementAmountTopDivider");
                view5.setVisibility(0);
            }
            MpRoboTextView mpRoboTextView3 = this.mBinding.bwSettlementOverAllAmountData;
            k.b(mpRoboTextView3, "mBinding.bwSettlementOverAllAmountData");
            LabelPopulationHelperMP labelPopulationHelperMP2 = LabelPopulationHelperMP.INSTANCE;
            AmountModel netAmount = settlementBillListItemModel.getNetAmount();
            mpRoboTextView3.setText(labelPopulationHelperMP2.parseAndGetAmountString(netAmount != null ? netAmount.getValue() : null, true));
            LinearLayout linearLayout3 = this.mBinding.bwSettlementAmountDetailsContainer;
            k.b(linearLayout3, "mBinding.bwSettlementAmountDetailsContainer");
            linearLayout3.setVisibility(0);
        }

        private final void populatM2BSettlementDetailList(SettlementBillListItemModel settlementBillListItemModel, int i2, int i3) {
            ArrayList arrayList;
            ArrayList<M2BOrderListItemModel> settlementBillListDetails = settlementBillListItemModel.getSettlementBillListDetails();
            if (settlementBillListDetails != null) {
                arrayList = new ArrayList();
                int i4 = 0;
                for (T next : settlementBillListDetails) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        kotlin.a.k.a();
                    }
                    if (i4 < 3) {
                        arrayList.add(next);
                    }
                    i4 = i5;
                }
            } else {
                arrayList = null;
            }
            LinearLayout linearLayout = this.mBinding.bwSettlementDetailContainer;
            k.b(linearLayout, "mBinding.bwSettlementDetailContainer");
            this.this$0.setAlternatingBackgroundRelativeToViewPastSettlements(linearLayout, i3 + 1);
            if (arrayList == null || arrayList.size() <= 0) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            int i6 = 0;
            for (int i7 = 1; i7 < linearLayout.getChildCount(); i7++) {
                android.view.View childAt = linearLayout.getChildAt(i7);
                if (i6 < arrayList.size()) {
                    k.b(childAt, "child");
                    setM2BChildItem(childAt, (M2BOrderListItemModel) arrayList.get(i6), i2);
                    childAt.setVisibility(0);
                    i6++;
                } else {
                    k.b(childAt, "child");
                    childAt.setVisibility(8);
                }
            }
            while (i6 < arrayList.size()) {
                MpBwSettlementDetailNewBinding inflate = MpBwSettlementDetailNewBinding.inflate(LayoutInflater.from(this.this$0.mContext));
                k.b(inflate, "MpBwSettlementDetailNewB…tInflater.from(mContext))");
                android.view.View root = inflate.getRoot();
                k.b(root, "childBinding.root");
                setM2BChildItem(root, (M2BOrderListItemModel) arrayList.get(i6), i2);
                linearLayout.addView(inflate.getRoot());
                i6++;
            }
        }

        private final void setM2BChildItem(android.view.View view, M2BOrderListItemModel m2BOrderListItemModel, int i2) {
            TextView textView;
            TextView textView2;
            boolean z;
            String str;
            String str2;
            android.view.View view2 = view;
            ImageView imageView = (ImageView) view2.findViewById(R.id.bwSettlementDetailItemStatusIcon);
            TextView textView3 = (TextView) view2.findViewById(R.id.bwSettlementDetailItemStatusText);
            TextView textView4 = (TextView) view2.findViewById(R.id.bwSettlementUTRText);
            TextView textView5 = (TextView) view2.findViewById(R.id.bwSettlementUTRText2);
            TextView textView6 = (TextView) view2.findViewById(R.id.bwSettlementDetailAmountText);
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.bwSettlementDetailBankLogoImage);
            TextView textView7 = (TextView) view2.findViewById(R.id.bwSettlementDetailBankNameText);
            TextView textView8 = (TextView) view2.findViewById(R.id.bwSettlementDetailAccountNumberText);
            android.view.View findViewById = view2.findViewById(R.id.bwDetailBankLogoAccNumberContainer);
            if (findViewById != null) {
                android.view.View findViewById2 = view2.findViewById(R.id.bwSettlementDetailBankNameContainer);
                if (findViewById2 != null) {
                    TextView textView9 = (TextView) view2.findViewById(R.id.bwPipe);
                    android.view.View[] viewArr = {findViewById, findViewById2};
                    TextView textView10 = (TextView) view2.findViewById(R.id.view_all_pending_settlement_time);
                    String str3 = "";
                    if (i2 == 0) {
                        textView2 = textView6;
                        setM2BSCommonItemVisibility(viewArr, 0);
                        k.b(textView4, "utrText");
                        textView4.setVisibility(8);
                        textView = textView5;
                    } else {
                        textView2 = textView6;
                        setM2BSCommonItemVisibility(viewArr, 8);
                        k.b(textView4, "utrText");
                        textView4.setVisibility(0);
                        if (p.a("SUCCESS", m2BOrderListItemModel.getOrderStatus(), true)) {
                            textView4.setVisibility(0);
                            PaymentsConfig instance = PaymentsConfig.getInstance();
                            k.b(instance, "PaymentsConfig.getInstance()");
                            Context appContext = instance.getAppContext();
                            int i3 = R.string.mp_lbl_utr_number;
                            textView = textView5;
                            Object[] objArr = new Object[1];
                            String reconId = m2BOrderListItemModel.getReconId();
                            if (reconId == null) {
                                reconId = str3;
                            }
                            objArr[0] = reconId;
                            textView4.setText(appContext.getString(i3, objArr));
                        } else {
                            textView = textView5;
                            textView4.setVisibility(8);
                        }
                    }
                    if (p.a("PENDING", m2BOrderListItemModel.getOrderStatus(), true)) {
                        k.b(textView10, "pendingSettlementTime");
                        textView10.setVisibility(0);
                        String timeFromTimeStamp = DateUtility.getTimeFromTimeStamp(m2BOrderListItemModel.getOrderCreatedTime());
                        k.b(timeFromTimeStamp, "DateUtility.getTimeFromT…mp(data.orderCreatedTime)");
                        if (timeFromTimeStamp != null) {
                            String lowerCase = timeFromTimeStamp.toLowerCase();
                            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                            textView10.setText(lowerCase);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    imageView.setImageDrawable(P4BSettlementsDataHelperMP.INSTANCE.geetM2BStatusDrawable(this.this$0.mContext, m2BOrderListItemModel.getOrderStatus()));
                    k.b(textView3, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT);
                    textView3.setText(P4BSettlementsDataHelperMP.INSTANCE.getBWSDetailStatusText(m2BOrderListItemModel.getOrderStatus(), 1, m2BOrderListItemModel.getOrderCreatedTime(), m2BOrderListItemModel.getOrderCompletedTime()));
                    String str4 = null;
                    if (i2 == 0) {
                        MpP4bBankImageTarget mpP4bBankImageTarget = new MpP4bBankImageTarget(new WeakReference(imageView2));
                        AdditionalInfoModel additionalInfo = m2BOrderListItemModel.getAdditionalInfo();
                        String bankIconUrl = additionalInfo != null ? additionalInfo.getBankIconUrl() : null;
                        if (!(bankIconUrl == null || bankIconUrl.length() == 0)) {
                            w a2 = w.a();
                            AdditionalInfoModel additionalInfo2 = m2BOrderListItemModel.getAdditionalInfo();
                            if (additionalInfo2 == null || (str2 = additionalInfo2.getBankIconUrl()) == null) {
                                str2 = str3;
                            }
                            a2.a(str2).a((af) mpP4bBankImageTarget);
                        }
                        k.b(textView7, "bankNameText");
                        AdditionalInfoModel additionalInfo3 = m2BOrderListItemModel.getAdditionalInfo();
                        textView7.setText(additionalInfo3 != null ? additionalInfo3.getReceiverBankName() : null);
                        k.b(textView8, "bankAccountNumberText");
                        AdditionalInfoModel additionalInfo4 = m2BOrderListItemModel.getAdditionalInfo();
                        if (additionalInfo4 == null || (str = additionalInfo4.getMaskedCardNo()) == null) {
                            str = str3;
                        }
                        textView8.setText(str);
                    }
                    if (p.a("SUCCESS", m2BOrderListItemModel.getOrderStatus(), true)) {
                        k.b(textView9, "pipe");
                        textView9.setText("|");
                        PaymentsConfig instance2 = PaymentsConfig.getInstance();
                        k.b(instance2, "PaymentsConfig.getInstance()");
                        Context appContext2 = instance2.getAppContext();
                        int i4 = R.string.mp_lbl_utr_number;
                        Object[] objArr2 = new Object[1];
                        String reconId2 = m2BOrderListItemModel.getReconId();
                        if (reconId2 != null) {
                            str3 = reconId2;
                        }
                        z = false;
                        objArr2[0] = str3;
                        str3 = appContext2.getString(i4, objArr2);
                    } else {
                        z = false;
                        k.b(textView9, "pipe");
                        textView9.setText(str3);
                    }
                    TextView textView11 = textView;
                    textView11.setText(str3);
                    TextView textView12 = textView2;
                    k.b(textView12, "amountText");
                    LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
                    AmountModel payMoneyAmount = m2BOrderListItemModel.getPayMoneyAmount();
                    if (payMoneyAmount != null) {
                        str4 = payMoneyAmount.getValue();
                    }
                    textView12.setText(labelPopulationHelperMP.parseAndGetAmountString(str4, true));
                    k.b(textView11, "utrText2");
                    CharSequence text = textView11.getText();
                    if (text == null || p.a(text)) {
                        z = true;
                    }
                    if (z) {
                        k.b(textView7, "bankNameText");
                        textView7.setMaxWidth(Integer.MAX_VALUE);
                        return;
                    }
                    Resources resources = this.this$0.mContext.getResources();
                    k.b(textView7, "bankNameText");
                    textView7.setMaxWidth((int) (resources.getDimension(R.dimen.mp_bw_settlement_message_max_width) / resources.getDisplayMetrics().density));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }

        /* access modifiers changed from: private */
        public final void sendGAEventOnClick(SettlementBillListItemModel settlementBillListItemModel) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int commonSettlementState = getCommonSettlementState(settlementBillListItemModel);
            String settlementTime = settlementBillListItemModel.getSettlementTime();
            if (settlementTime == null) {
                settlementTime = "";
            }
            String str6 = DateUtility.getTimeDiffForSettlement("yyyy-MM-dd'T'HH:mm:ssZZZZZ", settlementTime).toString();
            String convertDateToDifferentFormat = DateUtility.convertDateToDifferentFormat(settlementBillListItemModel.getSettlementTime(), "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "dd-MM-yyyy");
            if (commonSettlementState == 1) {
                GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                Context access$getMContext$p = this.this$0.mContext;
                StringBuilder sb = new StringBuilder("BW;");
                sb.append(str6);
                sb.append(';');
                sb.append(convertDateToDifferentFormat);
                sb.append(';');
                AmountModel netAmount = settlementBillListItemModel.getNetAmount();
                if (netAmount == null || (str = netAmount.getValue()) == null) {
                    str = "";
                }
                sb.append(str);
                sb.append(';');
                AmountModel pendingAmount = settlementBillListItemModel.getPendingAmount();
                if (pendingAmount == null || (str2 = pendingAmount.getValue()) == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append(";NA");
                singleInstance.sendEvent(access$getMContext$p, "HomePage", "Settlement Tab > Pending Settlement Clicked", "", sb.toString());
            } else if (commonSettlementState != 2) {
                LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
                AmountModel pendingAmount2 = settlementBillListItemModel.getPendingAmount();
                String str7 = null;
                boolean isAmountNonZero = labelPopulationHelperMP.isAmountNonZero(pendingAmount2 != null ? pendingAmount2.getValue() : null);
                String str8 = CommonPayParams.Builder.YES;
                String str9 = isAmountNonZero ? str8 : CommonPayParams.Builder.NO;
                LabelPopulationHelperMP labelPopulationHelperMP2 = LabelPopulationHelperMP.INSTANCE;
                AmountModel failedAmount = settlementBillListItemModel.getFailedAmount();
                if (failedAmount != null) {
                    str7 = failedAmount.getValue();
                }
                if (!labelPopulationHelperMP2.isAmountNonZero(str7)) {
                    str8 = CommonPayParams.Builder.NO;
                }
                GAGTMTagAnalytics singleInstance2 = GAGTMTagAnalytics.getSingleInstance();
                Context access$getMContext$p2 = this.this$0.mContext;
                StringBuilder sb2 = new StringBuilder("BW;");
                sb2.append(str6);
                sb2.append(';');
                sb2.append(convertDateToDifferentFormat);
                sb2.append(';');
                AmountModel netAmount2 = settlementBillListItemModel.getNetAmount();
                if (netAmount2 == null || (str5 = netAmount2.getValue()) == null) {
                    str5 = "";
                }
                sb2.append(str5);
                sb2.append(";NA;");
                sb2.append(str9);
                sb2.append(';');
                sb2.append(str8);
                singleInstance2.sendEvent(access$getMContext$p2, "HomePage", "Settlement Tab > Settled Settlement Clicked", "", sb2.toString());
            } else {
                GAGTMTagAnalytics singleInstance3 = GAGTMTagAnalytics.getSingleInstance();
                Context access$getMContext$p3 = this.this$0.mContext;
                StringBuilder sb3 = new StringBuilder("BW;");
                sb3.append(str6);
                sb3.append(';');
                sb3.append(convertDateToDifferentFormat);
                sb3.append(';');
                AmountModel netAmount3 = settlementBillListItemModel.getNetAmount();
                if (netAmount3 == null || (str3 = netAmount3.getValue()) == null) {
                    str3 = "";
                }
                sb3.append(str3);
                sb3.append(';');
                AmountModel failedAmount2 = settlementBillListItemModel.getFailedAmount();
                if (failedAmount2 == null || (str4 = failedAmount2.getValue()) == null) {
                    str4 = "";
                }
                sb3.append(str4);
                sb3.append(";NA");
                singleInstance3.sendEvent(access$getMContext$p3, "HomePage", "Settlement Tab > Failed Settlement Clicked", "", sb3.toString());
            }
        }

        private final void setM2BSCommonItemVisibility(android.view.View[] viewArr, int i2) {
            ArrayList arrayList = new ArrayList(viewArr.length);
            for (android.view.View visibility : viewArr) {
                visibility.setVisibility(i2);
                arrayList.add(x.f47997a);
            }
        }
    }

    public final class SettlementSummaryShimmerViewHolder extends BaseViewHolder {
        public final MpSettlementSummaryShimmerCardBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettlementSummaryShimmerViewHolder(HomeRVAdapter homeRVAdapter, MpSettlementSummaryShimmerCardBinding mpSettlementSummaryShimmerCardBinding) {
            super(mpSettlementSummaryShimmerCardBinding.getRoot());
            k.d(mpSettlementSummaryShimmerCardBinding, "mBinding");
            this.mBinding = mpSettlementSummaryShimmerCardBinding;
        }

        public final MpSettlementSummaryShimmerCardBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            ShimmerFrameLayout shimmerFrameLayout = this.mBinding.settlementSummaryCardShimmer;
            k.b(shimmerFrameLayout, "mBinding.settlementSummaryCardShimmer");
            shimmerFrameLayout.startShimmer();
        }
    }

    public final class SettlementElementShimmerViewHolder extends BaseViewHolder {
        public final MpSettlementElementShimmerBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettlementElementShimmerViewHolder(HomeRVAdapter homeRVAdapter, MpSettlementElementShimmerBinding mpSettlementElementShimmerBinding) {
            super(mpSettlementElementShimmerBinding.getRoot());
            k.d(mpSettlementElementShimmerBinding, "mBinding");
            this.mBinding = mpSettlementElementShimmerBinding;
        }

        public final MpSettlementElementShimmerBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            ShimmerFrameLayout shimmerFrameLayout = this.mBinding.settlementElementShimmer;
            k.b(shimmerFrameLayout, "mBinding.settlementElementShimmer");
            shimmerFrameLayout.startShimmer();
        }
    }

    public final class AddMoreViewHolder extends BaseViewHolder {
        public final String jsonFile = "blue_dotted_progress.json";
        public final MpDotProgressBarLytBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddMoreViewHolder(HomeRVAdapter homeRVAdapter, MpDotProgressBarLytBinding mpDotProgressBarLytBinding) {
            super(mpDotProgressBarLytBinding.getRoot());
            k.d(mpDotProgressBarLytBinding, "mBinding");
            this.mBinding = mpDotProgressBarLytBinding;
        }

        public final MpDotProgressBarLytBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            this.mBinding.animationView.setAnimation(this.jsonFile);
            this.mBinding.animationView.loop(true);
            this.mBinding.animationView.playAnimation();
        }
    }

    public final class NoSettlementsDataViewHolder extends BaseViewHolder {
        public final MpNoSettlementsDataViewBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoSettlementsDataViewHolder(HomeRVAdapter homeRVAdapter, MpNoSettlementsDataViewBinding mpNoSettlementsDataViewBinding) {
            super(mpNoSettlementsDataViewBinding.getRoot());
            k.d(mpNoSettlementsDataViewBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpNoSettlementsDataViewBinding;
            mpNoSettlementsDataViewBinding.calendarContainer.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ NoSettlementsDataViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(android.view.View view) {
                    GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                    Context access$getMContext$p = this.this$0.this$0.mContext;
                    singleInstance.sendEvent(access$getMContext$p, "HomePage", "View Past Settlement Clicked", "", "No Settlement;" + this.this$0.this$0.mViewModel.getMMerchantSettlemntTypeGA());
                    this.this$0.this$0.mListener.onSettlmentDateRangeClick();
                }
            });
        }

        public final MpNoSettlementsDataViewBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof NoSettlementsDataAdapterModel) {
                LinearLayout linearLayout = this.mBinding.calendarContainer;
                k.b(linearLayout, "mBinding.calendarContainer");
                NoSettlementsDataAdapterModel noSettlementsDataAdapterModel = (NoSettlementsDataAdapterModel) obj;
                linearLayout.setVisibility(noSettlementsDataAdapterModel.getCalendarViewVisibility());
                MpRoboTextView mpRoboTextView = this.mBinding.noSettlementsDataDesc;
                k.b(mpRoboTextView, "mBinding.noSettlementsDataDesc");
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                mpRoboTextView.setText(instance.getAppContext().getString(noSettlementsDataAdapterModel.getCardTextResourceId()));
                ImageView imageView = this.mBinding.noSettlementsDataImage;
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                imageView.setImageDrawable(b.a(instance2.getAppContext(), noSettlementsDataAdapterModel.getCardImageResourceId()));
                if (noSettlementsDataAdapterModel.getShouldHighLightDateRange()) {
                    c.a aVar = c.f7365a;
                    LinearLayout linearLayout2 = this.mBinding.calendarContainer;
                    k.b(linearLayout2, "mBinding.calendarContainer");
                    c.a.a(linearLayout2, this.this$0.mContext, false);
                }
            }
        }
    }

    public final class GeneralErrorViewHolder extends BaseViewHolder {
        public final MpRoboTextView mErrorDescriptionText;
        public final ImageView mErrorImage;
        public final MpRoboTextView mErrorRetryBtn;
        public final MpRoboTextView mErrorTitle;
        public final /* synthetic */ HomeRVAdapter this$0;
        public final android.view.View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GeneralErrorViewHolder(HomeRVAdapter homeRVAdapter, android.view.View view2) {
            super(view2);
            k.d(view2, "view");
            this.this$0 = homeRVAdapter;
            this.view = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.errorImage);
            k.b(imageView, "view.errorImage");
            this.mErrorImage = imageView;
            MpRoboTextView mpRoboTextView = (MpRoboTextView) this.view.findViewById(R.id.errorTitleText);
            k.b(mpRoboTextView, "view.errorTitleText");
            this.mErrorTitle = mpRoboTextView;
            MpRoboTextView mpRoboTextView2 = (MpRoboTextView) this.view.findViewById(R.id.errorDescriptionText);
            k.b(mpRoboTextView2, "view.errorDescriptionText");
            this.mErrorDescriptionText = mpRoboTextView2;
            MpRoboTextView mpRoboTextView3 = (MpRoboTextView) this.view.findViewById(R.id.errorRetryBtn);
            k.b(mpRoboTextView3, "view.errorRetryBtn");
            this.mErrorRetryBtn = mpRoboTextView3;
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof GenericErrorModel) {
                this.mErrorRetryBtn.setOnClickListener(((GenericErrorModel) obj).getOnClick());
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                if (i.a(instance.getApplication())) {
                    setDataForGeneralError();
                } else {
                    setDataForNoNetwork();
                }
            }
        }

        private final void setDataForNoNetwork() {
            this.mErrorImage.setImageDrawable(b.a(this.this$0.mContext, R.drawable.mp_p4b_no_internet));
            MpRoboTextView mpRoboTextView = this.mErrorTitle;
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            mpRoboTextView.setText(instance.getAppContext().getString(R.string.no_connection));
            MpRoboTextView mpRoboTextView2 = this.mErrorDescriptionText;
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            mpRoboTextView2.setText(instance2.getAppContext().getString(R.string.mp_label_please_check_your_internet_connection_and_try_again));
        }

        private final void setDataForGeneralError() {
            this.mErrorImage.setImageDrawable(b.a(this.this$0.mContext, R.drawable.mp_error_sign));
            MpRoboTextView mpRoboTextView = this.mErrorTitle;
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            mpRoboTextView.setText(instance.getAppContext().getString(R.string.mp_error_something_went_wrong));
            MpRoboTextView mpRoboTextView2 = this.mErrorDescriptionText;
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            mpRoboTextView2.setText(instance2.getAppContext().getString(R.string.mp_please_try_again));
        }
    }

    public final class CustomCardDataViewHolder extends BaseViewHolder {
        public final MpViewCustomCardBinding mBinding;
        public final /* synthetic */ HomeRVAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CustomCardDataViewHolder(HomeRVAdapter homeRVAdapter, MpViewCustomCardBinding mpViewCustomCardBinding) {
            super(mpViewCustomCardBinding.getRoot());
            k.d(mpViewCustomCardBinding, "mBinding");
            this.this$0 = homeRVAdapter;
            this.mBinding = mpViewCustomCardBinding;
        }

        public final MpViewCustomCardBinding getMBinding() {
            return this.mBinding;
        }

        public final void bindData(Object obj, int i2) {
            MpViewCustomCardBinding mpViewCustomCardBinding;
            MpViewCustomCardBinding mpViewCustomCardBinding2;
            CustomCardUIModel model;
            CustomCardUIModel model2;
            CustomCardUIModel model3;
            if (obj instanceof CustomCardUIModel) {
                CustomCardUIModel customCardUIModel = (CustomCardUIModel) obj;
                this.mBinding.setModel(customCardUIModel);
                if (!TextUtils.isEmpty(customCardUIModel.getIconUrl())) {
                    w.a().a(customCardUIModel.getIconUrl()).a(this.mBinding.icCard);
                }
                ConstraintLayout constraintLayout = this.mBinding.cardRoot;
                k.b(constraintLayout, "mBinding.cardRoot");
                Drawable background = constraintLayout.getBackground();
                if (background != null) {
                    ((GradientDrawable) background).setColor(customCardUIModel.getBackgroundColor());
                    MpViewCustomCardBinding mpViewCustomCardBinding3 = this.mBinding;
                    if ((mpViewCustomCardBinding3 == null || (model3 = mpViewCustomCardBinding3.getModel()) == null || model3.getCardId() != CustomCardViewModel.CustomCardId.CARD_ID_9.getValue()) && (((mpViewCustomCardBinding = this.mBinding) == null || (model2 = mpViewCustomCardBinding.getModel()) == null || model2.getCardId() != CustomCardViewModel.CustomCardId.CARD_ID_10.getValue()) && ((mpViewCustomCardBinding2 = this.mBinding) == null || (model = mpViewCustomCardBinding2.getModel()) == null || model.getCardId() != CustomCardViewModel.CustomCardId.CARD_ID_11.getValue()))) {
                        this.mBinding.cardRoot.setOnClickListener(new HomeRVAdapter$CustomCardDataViewHolder$bindData$2(this, i2));
                        this.mBinding.icCloseCard.setOnClickListener(new HomeRVAdapter$CustomCardDataViewHolder$bindData$3(this, i2));
                        return;
                    }
                    this.mBinding.cardCta.setOnClickListener(new HomeRVAdapter$CustomCardDataViewHolder$bindData$1(this, i2));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }
    }

    public final class SettlementRangeSummaryViewHolder extends BaseViewHolder {
        public final MpSettlementRangeSummeryBinding mBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettlementRangeSummaryViewHolder(HomeRVAdapter homeRVAdapter, MpSettlementRangeSummeryBinding mpSettlementRangeSummeryBinding) {
            super(mpSettlementRangeSummeryBinding.getRoot());
            k.d(mpSettlementRangeSummeryBinding, "mBinding");
            this.mBinding = mpSettlementRangeSummeryBinding;
            mpSettlementRangeSummeryBinding.mpSettlementRangeLoader.animationView.setAnimation("blue_dotted_progress.json");
        }

        public final void bindData(Object obj, int i2) {
            if (obj instanceof SettlementRangeSummaryModel) {
                SettlementRangeSummaryModel settlementRangeSummaryModel = (SettlementRangeSummaryModel) obj;
                if (settlementRangeSummaryModel.isLoading()) {
                    MpDotProgressBarLytBinding mpDotProgressBarLytBinding = this.mBinding.mpSettlementRangeLoader;
                    k.b(mpDotProgressBarLytBinding, "mBinding.mpSettlementRangeLoader");
                    android.view.View root = mpDotProgressBarLytBinding.getRoot();
                    k.b(root, "mBinding.mpSettlementRangeLoader.root");
                    root.setVisibility(0);
                    ConstraintLayout constraintLayout = this.mBinding.paymentSummary;
                    k.b(constraintLayout, "mBinding.paymentSummary");
                    constraintLayout.setVisibility(8);
                    TextView textView = this.mBinding.paymentSummeryHeader;
                    k.b(textView, "mBinding.paymentSummeryHeader");
                    textView.setVisibility(8);
                    this.mBinding.mpSettlementRangeLoader.animationView.playAnimation();
                } else {
                    MpDotProgressBarLytBinding mpDotProgressBarLytBinding2 = this.mBinding.mpSettlementRangeLoader;
                    k.b(mpDotProgressBarLytBinding2, "mBinding.mpSettlementRangeLoader");
                    android.view.View root2 = mpDotProgressBarLytBinding2.getRoot();
                    k.b(root2, "mBinding.mpSettlementRangeLoader.root");
                    root2.setVisibility(8);
                    ConstraintLayout constraintLayout2 = this.mBinding.paymentSummary;
                    k.b(constraintLayout2, "mBinding.paymentSummary");
                    constraintLayout2.setVisibility(0);
                    TextView textView2 = this.mBinding.paymentSummeryHeader;
                    k.b(textView2, "mBinding.paymentSummeryHeader");
                    textView2.setVisibility(0);
                    TextView textView3 = this.mBinding.settlementAmount;
                    k.b(textView3, "mBinding.settlementAmount");
                    textView3.setText(settlementRangeSummaryModel.getSettlementAmount());
                }
                android.view.View root3 = this.mBinding.getRoot();
                k.b(root3, "mBinding.root");
                root3.setVisibility(settlementRangeSummaryModel.getSummaryCardVisibility());
                android.view.View root4 = this.mBinding.getRoot();
                k.b(root4, "mBinding.root");
                ViewGroup.LayoutParams layoutParams = root4.getLayoutParams();
                android.view.View root5 = this.mBinding.getRoot();
                k.b(root5, "mBinding.root");
                if (root5.getVisibility() == 8) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                }
                android.view.View root6 = this.mBinding.getRoot();
                k.b(root6, "mBinding.root");
                root6.setLayoutParams(layoutParams);
            }
        }
    }

    public final void updateSettlementSummary(Object obj) {
        k.d(obj, "any");
        int size = this.mList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj2 = this.mList.get(i2);
            k.b(obj2, "mList[i]");
            if ((obj2 instanceof OnlineSettlementCardSummaryAdapteerModel) || (obj2 instanceof BWSettlementCardSummaryAdapterModel) || ((obj2 instanceof String) && k.a(obj2, (Object) SETTLEMENT_SUMMARY_SHIMMER))) {
                this.mList.set(i2, obj);
                notifyItemChanged(i2);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r0 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showErrorUI(int r6, android.view.View.OnClickListener r7) {
        /*
            r5 = this;
            java.lang.String r0 = "onClickListener"
            kotlin.g.b.k.d(r7, r0)
            r0 = 0
            r1 = -1
            if (r6 == r1) goto L_0x0043
            java.util.ArrayList<java.lang.Object> r1 = r5.mList
            int r1 = r1.size()
            r2 = 0
        L_0x0010:
            if (r2 >= r1) goto L_0x0043
            java.util.ArrayList<java.lang.Object> r3 = r5.mList
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r4 = "mList[i]"
            kotlin.g.b.k.b(r3, r4)
            if (r6 != 0) goto L_0x0036
            boolean r4 = r3 instanceof com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel
            if (r4 != 0) goto L_0x0034
            boolean r4 = r3 instanceof com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel
            if (r4 != 0) goto L_0x0034
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L_0x0036
            java.lang.String r4 = "settlementSummaryShimmer"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r0 = r2
            goto L_0x0043
        L_0x0036:
            r3 = 1
            if (r6 != r3) goto L_0x0040
            java.util.ArrayList<java.lang.Object> r6 = r5.mList
            int r0 = r6.size()
            goto L_0x0043
        L_0x0040:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0043:
            java.util.ArrayList<java.lang.Object> r6 = r5.mList
            int r6 = r6.size()
            if (r6 <= r0) goto L_0x0058
            java.util.ArrayList<java.lang.Object> r6 = r5.mList
            int r1 = r6.size()
            java.util.List r6 = r6.subList(r0, r1)
            r6.clear()
        L_0x0058:
            java.util.ArrayList<java.lang.Object> r6 = r5.mList
            com.business.merchant_payments.payment.model.GenericErrorModel r0 = new com.business.merchant_payments.payment.model.GenericErrorModel
            r0.<init>(r7)
            r6.add(r0)
            r5.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.HomeRVAdapter.showErrorUI(int, android.view.View$OnClickListener):void");
    }

    public final void removeItemAtPosition(int i2) {
        if (i2 >= 0 && i2 < this.mList.size()) {
            this.mList.remove(i2);
            notifyItemRemoved(i2);
        }
    }

    public final void resetLastExpandedItemIndex() {
        this.mPreviousExpandedCardIndex = -1;
    }

    /* access modifiers changed from: private */
    public final void setAlternatingColorRelativeToViewPastSettlements(android.view.View view, int i2) {
        int i3 = this.mTitleTileIndex;
        if (i3 == -1) {
            int i4 = this.mSettlementCardIndex;
            i3 = i4 != -1 ? i4 + 1 : -1;
        }
        if (i3 != -1) {
            int i5 = i2 - i3;
            if (i5 < 0) {
                i5 = i3 - i2;
            }
            setAlternatingViewColor(i5, view);
            return;
        }
        setAlternatingViewColor(i2, view);
    }

    /* access modifiers changed from: private */
    public final void setAlternatingBackgroundRelativeToViewPastSettlements(android.view.View view, int i2) {
        int i3 = this.mTitleTileIndex;
        if (i3 == -1) {
            int i4 = this.mSettlementCardIndex;
            i3 = i4 != -1 ? i4 + 1 : -1;
        }
        if (i3 != -1) {
            int i5 = i2 - i3;
            if (i5 < 0) {
                i5 = i3 - i2;
            }
            setAlternatingViewBackground(i5, view);
            return;
        }
        setAlternatingViewBackground(i2, view);
    }

    public final void onSettlementSummaryRangeResponse(SettlementRangeSummaryModel settlementRangeSummaryModel) {
        k.d(settlementRangeSummaryModel, "data");
        int size = this.mList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                if (this.mList.get(i2) instanceof SettlementRangeSummaryModel) {
                    break;
                }
                i2++;
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 != -1) {
            Object obj = this.mList.get(i2);
            if (obj != null) {
                settlementRangeSummaryModel.setSummaryCardVisibility(((SettlementRangeSummaryModel) obj).getSummaryCardVisibility());
                this.mList.set(i2, settlementRangeSummaryModel);
                notifyItemChanged(i2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel");
        }
        this.mList.add(0, settlementRangeSummaryModel);
        notifyItemInserted(0);
    }

    public final void updateSettlementSummaryRangeVisibility(int i2) {
        int size = this.mList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mList.get(i3) instanceof SettlementRangeSummaryModel) {
                Object obj = this.mList.get(i3);
                if (obj != null) {
                    ((SettlementRangeSummaryModel) obj).setSummaryCardVisibility(i2);
                    notifyItemChanged(i3);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel");
            }
        }
    }
}
