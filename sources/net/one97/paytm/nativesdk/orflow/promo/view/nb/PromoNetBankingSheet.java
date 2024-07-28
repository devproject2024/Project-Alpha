package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.ConvenienceFeeOrController;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingProviderListner;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;
import net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet;
import net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionViewModel;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;

public final class PromoNetBankingSheet extends BasePromoPayOptionSheet<PromoPayOptionViewModel> implements NetBankingProviderListner {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public ArrayList<PromoPayOptionAdapterParam> mAllBanksList = new ArrayList<>();
    /* access modifiers changed from: private */
    public PromoAllNetBankingAdapter mAllNetBankingAdapter;
    private ArrayList<PromoPayOptionAdapterParam> mTopBanksList = new ArrayList<>();
    private PromoPayOptionAdapterParam prevSelectedItem;
    private PromoPayOptionAdapterParam selectedBank;
    private PromoPayOptionAdapterParam selectedItem;
    private int selectedPosition;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onArrowClicked() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onNetBankingListReceived(NbPayOption nbPayOption) {
    }

    public final void onNetworkUnavailable(Request<?> request) {
    }

    public final void onProccedClick(View view, PayChannelOptions payChannelOptions) {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoNetBankingSheet getInstance(CJPayMethodResponse cJPayMethodResponse) {
            k.c(cJPayMethodResponse, "cjPayMethodResponse");
            PromoHelper.Companion.getInstance().setCjPayMethodResponse(cJPayMethodResponse);
            return new PromoNetBankingSheet();
        }
    }

    public final PromoPayOptionViewModel getViewModel() {
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        return new PromoPayOptionViewModel(application);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NativeSDKRepository.init(getContext(), true);
        PromoHelper.Companion.getInstance().addVerifyPromoObserver(this);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        merchantInstance.setSsoToken(PromoHelper.Companion.getInstance().getSsoToken());
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        merchantInstance2.setMid(PromoHelper.Companion.getInstance().getMid());
        Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, Utility.ACTION_SAVEDINSTRUMENT_LOADED, "netbanking", PromoHelper.Companion.getInstance().getVerticalName()));
    }

    public final int getLayoutId() {
        return R.layout.promo_nb_only_bottomsheet;
    }

    public final void initView() {
        PromoPayOptionAdapterParam.NetworkCallState networkCallState;
        PromoPayOptionAdapterParam promoPayOptionAdapterParam;
        MerchantPayOption merchantPayOption;
        ArrayList<PaymentModes> paymentModes;
        ArrayList<PromoPayOptionAdapterParam> arrayList;
        View.OnClickListener onClickListener = this;
        ((ImageView) getMView().findViewById(R.id.ivClose)).setOnClickListener(onClickListener);
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setOnClickListener(onClickListener);
        CJPayMethodResponse cjPayMethodResponse = PromoHelper.Companion.getInstance().getCjPayMethodResponse();
        PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = null;
        if ((cjPayMethodResponse != null ? cjPayMethodResponse.getBody() : null) == null) {
            dismiss();
            return;
        }
        CJPayMethodResponse cjPayMethodResponse2 = PromoHelper.Companion.getInstance().getCjPayMethodResponse();
        if (cjPayMethodResponse2 == null) {
            k.a();
        }
        this.mAllBanksList = new ArrayList<>();
        this.mTopBanksList = new ArrayList<>();
        setAllBankListObserver();
        Body body = cjPayMethodResponse2.getBody();
        if (body != null && (merchantPayOption = body.getMerchantPayOption()) != null && (paymentModes = merchantPayOption.getPaymentModes()) != null) {
            Iterator<PaymentModes> it2 = paymentModes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PaymentModes next = it2.next();
                k.a((Object) next, "item");
                if (p.a("NET_BANKING", next.getPaymentMode(), true)) {
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (i2 < next.getPayChannelOptions().size() && (arrayList = this.mTopBanksList) != null) {
                            PromoPayOptionAdapterParam promoPayOptionAdapterParam3 = new PromoPayOptionAdapterParam(1, next.getPayChannelOptions().get(i2));
                            promoPayOptionAdapterParam3.setMode(next.getPaymentMode());
                            arrayList.add(promoPayOptionAdapterParam3);
                        }
                    }
                }
            }
        }
        ArrayList<PromoPayOptionAdapterParam> arrayList2 = this.mTopBanksList;
        if (!(arrayList2 == null || (promoPayOptionAdapterParam = arrayList2.get(0)) == null)) {
            promoPayOptionAdapterParam.setSelected(true);
        }
        ArrayList<PromoPayOptionAdapterParam> arrayList3 = this.mTopBanksList;
        this.selectedBank = arrayList3 != null ? arrayList3.get(0) : null;
        ArrayList<PromoPayOptionAdapterParam> arrayList4 = this.mTopBanksList;
        if (arrayList4 == null || arrayList4.size() != 5) {
            TextView textView = (TextView) getMView().findViewById(R.id.tvSelectOtherBank);
            if (textView != null) {
                textView.setVisibility(8);
            }
            networkCallState = PromoPayOptionAdapterParam.NetworkCallState.Success;
        } else {
            TextView textView2 = (TextView) getMView().findViewById(R.id.tvSelectOtherBank);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            networkCallState = PromoPayOptionAdapterParam.NetworkCallState.Default;
        }
        ArrayList<PromoPayOptionAdapterParam> arrayList5 = this.mAllBanksList;
        if (arrayList5 != null) {
            PromoPayOptionAdapterParam promoPayOptionAdapterParam4 = new PromoPayOptionAdapterParam(7, (BaseDataModel) null);
            promoPayOptionAdapterParam4.setNbTopBankList(this.mTopBanksList);
            promoPayOptionAdapterParam4.setMode("NET_BANKING");
            promoPayOptionAdapterParam4.setSelected(true);
            promoPayOptionAdapterParam4.setNetworkCallState(networkCallState);
            arrayList5.add(promoPayOptionAdapterParam4);
        }
        ArrayList<PromoPayOptionAdapterParam> arrayList6 = this.mAllBanksList;
        if (arrayList6 != null) {
            promoPayOptionAdapterParam2 = arrayList6.get(0);
        }
        this.selectedItem = promoPayOptionAdapterParam2;
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "this.context!!");
        ArrayList<PromoPayOptionAdapterParam> arrayList7 = this.mAllBanksList;
        if (arrayList7 == null) {
            k.a();
        }
        this.mAllNetBankingAdapter = new PromoAllNetBankingAdapter(context, arrayList7, this, onClickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        IndexFastScrollRecyclerView indexFastScrollRecyclerView = (IndexFastScrollRecyclerView) getMView().findViewById(R.id.rv_bank_list);
        if (indexFastScrollRecyclerView != null) {
            indexFastScrollRecyclerView.setLayoutManager(linearLayoutManager);
            indexFastScrollRecyclerView.setIndexTextSize(10);
            indexFastScrollRecyclerView.setIndexBarColor("#FFFFFF");
            indexFastScrollRecyclerView.setIndexBarCornerRadius(0);
            indexFastScrollRecyclerView.setTypeface(Typeface.SANS_SERIF);
            indexFastScrollRecyclerView.setIndexbarMargin(5.0f);
            indexFastScrollRecyclerView.setIndexbarWidth(40.0f);
            indexFastScrollRecyclerView.setIndexbarTopMargin(50.0f);
            indexFastScrollRecyclerView.setCustomIndexbarHeight(20.0f);
            indexFastScrollRecyclerView.setPreviewPadding(0);
            indexFastScrollRecyclerView.setIndexBarTextColor("#444444");
            indexFastScrollRecyclerView.setIndexBarVisibility(true);
            indexFastScrollRecyclerView.setIndexBarHighLateTextVisibility(true);
            indexFastScrollRecyclerView.setAdapter(this.mAllNetBankingAdapter);
            indexFastScrollRecyclerView.addItemDecoration(new ItemDecorator());
        }
        ((EditText) getMView().findViewById(R.id.searchView)).addTextChangedListener(new PromoNetBankingSheet$initView$4(this));
        ((ImageView) getMView().findViewById(R.id.img_edt_cross)).setOnClickListener(new PromoNetBankingSheet$initView$5(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v32 */
    /* JADX WARNING: type inference failed for: r0v33 */
    /* JADX WARNING: type inference failed for: r0v34 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x000c
            int r1 = r9.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = net.one97.paytm.nativesdk.R.id.ivClose
            if (r1 != 0) goto L_0x0012
            goto L_0x001c
        L_0x0012:
            int r3 = r1.intValue()
            if (r3 != r2) goto L_0x001c
            r8.dismiss()
            return
        L_0x001c:
            int r2 = net.one97.paytm.nativesdk.R.id.topBanksContainer
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Int"
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L_0x0026
            goto L_0x00be
        L_0x0026:
            int r6 = r1.intValue()
            if (r6 != r2) goto L_0x00be
            java.lang.Object r9 = r9.getTag()
            if (r9 == 0) goto L_0x00b8
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r1 = r8.mTopBanksList
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r1.get(r9)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r1
            if (r1 == 0) goto L_0x0049
            net.one97.paytm.nativesdk.common.model.BaseDataModel r1 = r1.getData()
            goto L_0x004a
        L_0x0049:
            r1 = r0
        L_0x004a:
            if (r1 == 0) goto L_0x008b
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r1 = r8.mTopBanksList
            if (r1 == 0) goto L_0x0059
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x005a
        L_0x0059:
            r1 = r0
        L_0x005a:
            if (r1 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            int r1 = r1.intValue()
            r2 = 0
        L_0x0064:
            if (r2 >= r1) goto L_0x007d
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r3 = r8.mTopBanksList
            if (r3 == 0) goto L_0x007a
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r3 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r3
            if (r3 == 0) goto L_0x007a
            if (r2 != r9) goto L_0x0076
            r6 = 1
            goto L_0x0077
        L_0x0076:
            r6 = 0
        L_0x0077:
            r3.setSelected(r6)
        L_0x007a:
            int r2 = r2 + 1
            goto L_0x0064
        L_0x007d:
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r1 = r8.mTopBanksList
            if (r1 == 0) goto L_0x0088
            java.lang.Object r9 = r1.get(r9)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r9
            goto L_0x0089
        L_0x0088:
            r9 = r0
        L_0x0089:
            r8.selectedBank = r9
        L_0x008b:
            r8.selectedPosition = r5
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedItem
            r8.prevSelectedItem = r9
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r9 = r8.mAllBanksList
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r9.get(r5)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r9
            goto L_0x009d
        L_0x009c:
            r9 = r0
        L_0x009d:
            r8.selectedItem = r9
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.prevSelectedItem
            if (r9 == 0) goto L_0x00a6
            r9.setPromoErrorMessage(r0)
        L_0x00a6:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.prevSelectedItem
            if (r9 == 0) goto L_0x00ad
            r9.setSelected(r5)
        L_0x00ad:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedItem
            if (r9 == 0) goto L_0x00b4
            r9.setSelected(r4)
        L_0x00b4:
            r8.notifyItemChanged()
            return
        L_0x00b8:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r3)
            throw r9
        L_0x00be:
            int r2 = net.one97.paytm.nativesdk.R.id.nbItemParent
            if (r1 != 0) goto L_0x00c3
            goto L_0x0116
        L_0x00c3:
            int r6 = r1.intValue()
            if (r6 != r2) goto L_0x0116
            java.lang.Object r9 = r9.getTag()
            if (r9 == 0) goto L_0x0110
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r8.selectedPosition = r9
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedItem
            r8.prevSelectedItem = r9
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.prevSelectedItem
            if (r9 == 0) goto L_0x00e2
            r9.setSelected(r5)
        L_0x00e2:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.prevSelectedItem
            if (r9 == 0) goto L_0x00e9
            r9.setPromoErrorMessage(r0)
        L_0x00e9:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r9 = r8.mAllNetBankingAdapter
            if (r9 == 0) goto L_0x00fc
            java.util.ArrayList r9 = r9.getFilteredList()
            if (r9 == 0) goto L_0x00fc
            int r0 = r8.selectedPosition
            java.lang.Object r9 = r9.get(r0)
            r0 = r9
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r0
        L_0x00fc:
            r8.selectedItem = r0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedItem
            if (r9 == 0) goto L_0x0105
            r9.setSelected(r4)
        L_0x0105:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedItem
            r8.selectedBank = r9
            r8.notifyItemChanged()
            r8.scrollRecyclerView()
            return
        L_0x0110:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r3)
            throw r9
        L_0x0116:
            int r2 = net.one97.paytm.nativesdk.R.id.llApplyOffer
            if (r1 != 0) goto L_0x011c
            goto L_0x01e1
        L_0x011c:
            int r3 = r1.intValue()
            if (r3 != r2) goto L_0x01e1
            android.content.Context r9 = r8.getContext()
            boolean r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.isNetworkAvailable(r9)
            if (r9 != 0) goto L_0x0140
            android.content.Context r9 = r8.getContext()
            int r0 = net.one97.paytm.nativesdk.R.string.no_internet
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r0, r5)
            r9.show()
            return
        L_0x0140:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedBank
            if (r9 == 0) goto L_0x0149
            net.one97.paytm.nativesdk.common.model.BaseDataModel r9 = r9.getData()
            goto L_0x014a
        L_0x0149:
            r9 = r0
        L_0x014a:
            boolean r9 = r9 instanceof net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions
            if (r9 == 0) goto L_0x0169
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedBank
            if (r9 == 0) goto L_0x0157
            net.one97.paytm.nativesdk.common.model.BaseDataModel r9 = r9.getData()
            goto L_0x0158
        L_0x0157:
            r9 = r0
        L_0x0158:
            if (r9 == 0) goto L_0x0161
            net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions r9 = (net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions) r9
            java.lang.String r9 = r9.getChannelCode()
            goto L_0x0193
        L_0x0161:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions"
            r9.<init>(r0)
            throw r9
        L_0x0169:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedBank
            if (r9 == 0) goto L_0x0172
            net.one97.paytm.nativesdk.common.model.BaseDataModel r9 = r9.getData()
            goto L_0x0173
        L_0x0172:
            r9 = r0
        L_0x0173:
            boolean r9 = r9 instanceof net.one97.paytm.nativesdk.common.model.PayChannelOptions
            if (r9 == 0) goto L_0x0192
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = r8.selectedBank
            if (r9 == 0) goto L_0x0180
            net.one97.paytm.nativesdk.common.model.BaseDataModel r9 = r9.getData()
            goto L_0x0181
        L_0x0180:
            r9 = r0
        L_0x0181:
            if (r9 == 0) goto L_0x018a
            net.one97.paytm.nativesdk.common.model.PayChannelOptions r9 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) r9
            java.lang.String r9 = r9.getChannelCode()
            goto L_0x0193
        L_0x018a:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PayChannelOptions"
            r9.<init>(r0)
            throw r9
        L_0x0192:
            r9 = r0
        L_0x0193:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.paytm.nativesdk.common.model.PaymentIntent r2 = new net.one97.paytm.nativesdk.common.model.PaymentIntent
            r2.<init>()
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r3 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r3 = r3.getInstance()
            double r3 = r3.getAmount()
            r2.setTxnAmount(r3)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r3 = r8.selectedBank
            if (r3 == 0) goto L_0x01b2
            java.lang.String r0 = r3.getMode()
        L_0x01b2:
            r2.setMode(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.setBanks(r0)
            java.util.ArrayList r0 = r2.getBanks()
            r0.add(r9)
            r1.add(r2)
            r8.scrollRecyclerView()
            r8.showLoadingState()
            r8.disableUiInteraction()
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r9 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r9 = r9.getInstance()
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r8.selectedBank
            if (r0 != 0) goto L_0x01dd
            kotlin.g.b.k.a()
        L_0x01dd:
            r9.onPaymentModeSelected(r1, r0)
            return
        L_0x01e1:
            int r2 = net.one97.paytm.nativesdk.R.id.tvSelectOtherBank
            r3 = 8
            java.lang.String r6 = "mView.nbLoadingView"
            if (r1 != 0) goto L_0x01eb
            goto L_0x0284
        L_0x01eb:
            int r7 = r1.intValue()
            if (r7 != r2) goto L_0x0284
            android.content.Context r1 = r8.getContext()
            boolean r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.isNetworkAvailable(r1)
            if (r1 == 0) goto L_0x0270
            android.view.View r1 = r8.getMView()
            int r2 = net.one97.paytm.nativesdk.R.id.nbLoadingView
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ScrollView r1 = (android.widget.ScrollView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r5)
            android.view.View r1 = r8.getMView()
            int r2 = net.one97.paytm.nativesdk.R.id.search_bar
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            java.lang.String r2 = "mView.search_bar"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.setVisibility(r5)
            r8.getAllBankList()
            r9.setVisibility(r3)
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r9 = r8.mAllBanksList
            if (r9 == 0) goto L_0x0236
            java.lang.Object r9 = r9.get(r5)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r9
            if (r9 == 0) goto L_0x0236
            r9.setPromoErrorMessage(r0)
        L_0x0236:
            java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam> r9 = r8.mAllBanksList
            if (r9 == 0) goto L_0x0247
            java.lang.Object r9 = r9.get(r5)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r9
            if (r9 == 0) goto L_0x0247
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam$NetworkCallState r1 = net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam.NetworkCallState.Processing
            r9.setNetworkCallState(r1)
        L_0x0247:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r9 = new net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam
            r1 = 9
            r9.<init>(r1, r0)
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r0 = r8.mAllNetBankingAdapter
            if (r0 == 0) goto L_0x025b
            java.util.ArrayList r0 = r0.getFilteredList()
            if (r0 == 0) goto L_0x025b
            r0.add(r9)
        L_0x025b:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r0 = r8.mAllNetBankingAdapter
            if (r0 == 0) goto L_0x0268
            java.util.ArrayList r0 = r0.getMasterList()
            if (r0 == 0) goto L_0x0268
            r0.add(r9)
        L_0x0268:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r9 = r8.mAllNetBankingAdapter
            if (r9 == 0) goto L_0x026f
            r9.notifyItemChanged(r5)
        L_0x026f:
            return
        L_0x0270:
            android.content.Context r9 = r8.getContext()
            int r0 = net.one97.paytm.nativesdk.R.string.no_internet
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r0, r5)
            r9.show()
            return
        L_0x0284:
            int r9 = net.one97.paytm.nativesdk.R.id.llRetryOptions
            if (r1 != 0) goto L_0x0289
            return
        L_0x0289:
            int r1 = r1.intValue()
            if (r1 != r9) goto L_0x032f
            android.content.Context r9 = r8.getContext()
            boolean r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.isNetworkAvailable(r9)
            if (r9 == 0) goto L_0x031c
            android.view.View r9 = r8.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.list_empty_layout_container
            android.view.View r9 = r9.findViewById(r1)
            java.lang.String r1 = "mView.list_empty_layout_container"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setVisibility(r3)
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r9 = r8.mAllNetBankingAdapter
            if (r9 == 0) goto L_0x02cc
            java.util.ArrayList r9 = r9.getFilteredList()
            if (r9 == 0) goto L_0x02cc
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r1 = r8.mAllNetBankingAdapter
            if (r1 == 0) goto L_0x02be
            java.util.ArrayList r1 = r1.getFilteredList()
            goto L_0x02bf
        L_0x02be:
            r1 = r0
        L_0x02bf:
            if (r1 != 0) goto L_0x02c4
            kotlin.g.b.k.a()
        L_0x02c4:
            int r1 = r1.size()
            int r1 = r1 - r4
            r9.remove(r1)
        L_0x02cc:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r9 = r8.mAllNetBankingAdapter
            if (r9 == 0) goto L_0x02eb
            java.util.ArrayList r9 = r9.getMasterList()
            if (r9 == 0) goto L_0x02eb
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r1 = r8.mAllNetBankingAdapter
            if (r1 == 0) goto L_0x02de
            java.util.ArrayList r0 = r1.getMasterList()
        L_0x02de:
            if (r0 != 0) goto L_0x02e3
            kotlin.g.b.k.a()
        L_0x02e3:
            int r0 = r0.size()
            int r0 = r0 - r4
            r9.remove(r0)
        L_0x02eb:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r9 = r8.mAllNetBankingAdapter
            if (r9 == 0) goto L_0x02f2
            r9.notifyDataSetChanged()
        L_0x02f2:
            android.view.View r9 = r8.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.pb_progress
            android.view.View r9 = r9.findViewById(r0)
            android.widget.ProgressBar r9 = (android.widget.ProgressBar) r9
            java.lang.String r0 = "mView.pb_progress"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r9.setVisibility(r5)
            android.view.View r9 = r8.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.nbLoadingView
            android.view.View r9 = r9.findViewById(r0)
            android.widget.ScrollView r9 = (android.widget.ScrollView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            r9.setVisibility(r5)
            r8.getAllBankList()
            return
        L_0x031c:
            android.content.Context r9 = r8.getContext()
            int r0 = net.one97.paytm.nativesdk.R.string.no_internet
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r0, r5)
            r9.show()
        L_0x032f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet.onClick(android.view.View):void");
    }

    private final void getAllBankList() {
        ((PromoPayOptionViewModel) getMViewModel()).getAllBanksList();
    }

    private final void setAllBankListObserver() {
        ((PromoPayOptionViewModel) getMViewModel()).getNetBankingResponseObserver().observe(this, new PromoNetBankingSheet$setAllBankListObserver$1(this));
    }

    public final void onVerifyPromoSuccess(CJPayMethodResponse cJPayMethodResponse, boolean z, PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
        applyOffer();
        if ((verifyResponseData != null ? verifyResponseData.getConvFeeResponse() : null) == null || PromoHelper.Companion.getInstance().getPaymentIntent() == null) {
            ConvenienceFeeOrController.Companion.getInstance().resetConvenienceFee();
        } else {
            ConvenienceFeeOrController instance = ConvenienceFeeOrController.Companion.getInstance();
            PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = verifyResponseData.getConvFeeResponse();
            k.a((Object) convFeeResponse, "data.convFeeResponse");
            ArrayList<PaymentIntent> paymentIntent = PromoHelper.Companion.getInstance().getPaymentIntent();
            if (paymentIntent == null) {
                k.a();
            }
            instance.setConvFeeResponse(convFeeResponse, paymentIntent, verifyResponseData.getVerifyModel());
        }
        Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, Utility.ACTION_APPLY_OFFER_CLICK, "NET_BANKING", "", "successful", ""));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r4 == null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVerifyPromoError(java.lang.String r4) {
        /*
            r3 = this;
            r3.hideLoadingState()
            r3.enableUiInteraction()
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r3.selectedItem
            if (r0 == 0) goto L_0x0029
            if (r4 == 0) goto L_0x0020
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            if (r1 != 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            if (r4 != 0) goto L_0x0026
        L_0x0020:
            int r4 = net.one97.paytm.nativesdk.R.string.default_promo_payoption_error_msg
            java.lang.String r4 = r3.getString(r4)
        L_0x0026:
            r0.setPromoErrorMessage(r4)
        L_0x0029:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r4 = r3.mAllNetBankingAdapter
            if (r4 == 0) goto L_0x0032
            int r0 = r3.selectedPosition
            r4.notifyItemChanged(r0)
        L_0x0032:
            r3.scrollRecyclerView()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet.onVerifyPromoError(java.lang.String):void");
    }

    public final void onNonPromoError(String str) {
        onVerifyPromoError(str);
    }

    public final void onVerifyPromoNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        onVerifyPromoError(apiResponseError != null ? apiResponseError.getErrorMsg() : null, apiResponseError != null ? apiResponseError.isClosePgWithoutError() : false);
    }

    private final void onVerifyPromoError(String str, boolean z) {
        if (z) {
            hideLoadingState();
            enableUiInteraction();
            dismissAllowingStateLoss();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        onVerifyPromoError(str);
    }

    public final void showLoadingState() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setBackgroundResource(R.drawable.promo_pay_button_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading");
        lottieAnimationView2.setVisibility(0);
        TextView textView = (TextView) getMView().findViewById(R.id.tvApplyOffer);
        k.a((Object) textView, "mView.tvApplyOffer");
        textView.setVisibility(8);
    }

    public final void hideLoadingState() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setBackgroundResource(R.drawable.promo_pay_button_click);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading");
        lottieAnimationView2.setVisibility(8);
        TextView textView = (TextView) getMView().findViewById(R.id.tvApplyOffer);
        k.a((Object) textView, "mView.tvApplyOffer");
        textView.setVisibility(0);
    }

    private final void notifyItemChanged() {
        PromoAllNetBankingAdapter promoAllNetBankingAdapter = this.mAllNetBankingAdapter;
        if (promoAllNetBankingAdapter != null) {
            promoAllNetBankingAdapter.notifyDataSetChanged();
        }
    }

    public final void enableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        frameLayout2.setClickable(false);
    }

    public final void disableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        frameLayout2.setClickable(true);
    }

    private final void scrollRecyclerView() {
        ((IndexFastScrollRecyclerView) getMView().findViewById(R.id.rv_bank_list)).scrollToPosition(this.selectedPosition);
    }

    public final void onEmptyList() {
        ScrollView scrollView = (ScrollView) getMView().findViewById(R.id.nbLoadingView);
        k.a((Object) scrollView, "mView.nbLoadingView");
        scrollView.setVisibility(0);
        ProgressBar progressBar = (ProgressBar) getMView().findViewById(R.id.pb_progress);
        k.a((Object) progressBar, "mView.pb_progress");
        progressBar.setVisibility(8);
        View findViewById = getMView().findViewById(R.id.list_empty_layout_container);
        k.a((Object) findViewById, "mView.list_empty_layout_container");
        findViewById.setVisibility(0);
    }

    public final void onNonEmptyList() {
        ScrollView scrollView = (ScrollView) getMView().findViewById(R.id.nbLoadingView);
        k.a((Object) scrollView, "mView.nbLoadingView");
        scrollView.setVisibility(4);
    }

    public final class ItemDecorator extends RecyclerView.h {
        public ItemDecorator() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            PromoAllNetBankingAdapter access$getMAllNetBankingAdapter$p = PromoNetBankingSheet.this.mAllNetBankingAdapter;
            ArrayList<PromoPayOptionAdapterParam> arrayList = null;
            ArrayList<PromoPayOptionAdapterParam> filteredList = access$getMAllNetBankingAdapter$p != null ? access$getMAllNetBankingAdapter$p.getFilteredList() : null;
            if (filteredList == null) {
                k.a();
            }
            if (childAdapterPosition == filteredList.size() - 1) {
                PromoAllNetBankingAdapter access$getMAllNetBankingAdapter$p2 = PromoNetBankingSheet.this.mAllNetBankingAdapter;
                if (access$getMAllNetBankingAdapter$p2 != null) {
                    arrayList = access$getMAllNetBankingAdapter$p2.getFilteredList();
                }
                if (arrayList == null) {
                    k.a();
                }
                if (arrayList.size() > 1) {
                    Utility utility = Utility.INSTANCE;
                    FragmentActivity activity = PromoNetBankingSheet.this.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "this@PromoNetBankingSheet.activity!!");
                    rect.bottom = (int) (270.0f * utility.getDensity(activity));
                    return;
                }
                Utility utility2 = Utility.INSTANCE;
                FragmentActivity activity2 = PromoNetBankingSheet.this.getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "this@PromoNetBankingSheet.activity!!");
                rect.bottom = (int) (130.0f * utility2.getDensity(activity2));
            }
        }
    }
}
