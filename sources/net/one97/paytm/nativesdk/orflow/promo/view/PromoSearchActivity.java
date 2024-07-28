package net.one97.paytm.nativesdk.orflow.promo.view;

import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoList;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;

public final class PromoSearchActivity extends BaseActivity implements View.OnClickListener, VerifyPromoResultListener, PromoSearchListener {
    private final String TAG;
    private HashMap _$_findViewCache;
    private String applyEventAction = "";
    private int clickedItemPostition = -1;
    /* access modifiers changed from: private */
    public boolean isPromoApplied;
    private ProgressDialog mProgressDialog;
    /* access modifiers changed from: private */
    public List<PromoListItem> mPromoItemList;
    private PromoListAdapter mPromoListAdapter;
    private final boolean shouldKillActivity = true;

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
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final String getChildClassName() {
        return "PromoSearchActivity";
    }

    public PromoSearchActivity() {
        String simpleName = PromoSearchActivity.class.getSimpleName();
        k.a((Object) simpleName, "PromoSearchActivity::class.java.simpleName");
        this.TAG = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_promosearch);
        getWindow().setSoftInputMode(3);
        PromoHelper.Companion.getInstance().addPromoSearchObserver(this);
        PromoHelper.Companion.getInstance().addVerifyPromoObserver(this);
        PromoHelper instance = PromoHelper.Companion.getInstance();
        Application application = getApplication();
        k.a((Object) application, "application");
        instance.getAllPromo(application);
        addEditTextFocusListener();
        View.OnClickListener onClickListener = this;
        ((TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo)).setOnClickListener(onClickListener);
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(onClickListener);
        ((TextView) _$_findCachedViewById(R.id.tvApplyOfferButton)).setOnClickListener(onClickListener);
        ((ImageView) _$_findCachedViewById(R.id.ivEditCross)).setOnClickListener(onClickListener);
        PromoHelper.Companion.getInstance().sendScreenViewEvent(this, "/promocode", PromoHelper.Companion.getInstance().getVerticalName());
    }

    private final void addEditTextFocusListener() {
        ((TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo)).clearFocus();
        ((EditText) _$_findCachedViewById(R.id.etDummy)).requestFocus();
        ((TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo)).addTextChangedListener(new PromoSearchActivity$addEditTextFocusListener$1(this));
        ((TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo)).setOnFocusChangeListener(new PromoSearchActivity$addEditTextFocusListener$2(this));
    }

    private final void addOfferBottomSheet(int i2) {
        PromoListItem promoListItem;
        List<PromoListItem> list = this.mPromoItemList;
        if (list != null && (promoListItem = list.get(i2)) != null) {
            if (SDKUtility.isNetworkAvailable(this) || !TextUtils.isEmpty(promoListItem.getTerms())) {
                OfferDetailBottomSheet offerDetailBottomSheet = new OfferDetailBottomSheet();
                Bundle bundle = new Bundle();
                bundle.putString("promoCode", promoListItem.getCode());
                bundle.putString("offerText", promoListItem.getTerms());
                bundle.putString("tncUrl", promoListItem.getTermsUrl());
                offerDetailBottomSheet.setArguments(bundle);
                j supportFragmentManager = getSupportFragmentManager();
                k.a((Object) supportFragmentManager, "supportFragmentManager");
                offerDetailBottomSheet.show(supportFragmentManager, OfferDetailBottomSheet.class.getSimpleName());
                return;
            }
            showNoInternetDialog((PaytmSDKRequestClient.ApiResponseError) null);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ivClose;
        if (valueOf != null && valueOf.intValue() == i2) {
            finish();
            return;
        }
        int i3 = R.id.ivEditCross;
        if (valueOf != null && valueOf.intValue() == i3) {
            ((TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo)).setText("");
            return;
        }
        int i4 = R.id.tvApplyOfferButton;
        if (valueOf != null && valueOf.intValue() == i4) {
            applyManualPromoCode();
            this.clickedItemPostition = -1;
            hidePromoError();
            this.applyEventAction = Utility.ACTION_APPLY_OFFER_CLICK;
            return;
        }
        int i5 = R.id.tvApplyOffer;
        if (valueOf != null && valueOf.intValue() == i5) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                onPromoSelected(intValue);
                this.clickedItemPostition = intValue;
                hidePromoError();
                this.applyEventAction = Utility.ACTION_APPLY_CLICKED;
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
        int i6 = R.id.tietEnterPromo;
        if (valueOf != null && valueOf.intValue() == i6) {
            Utility.INSTANCE.sendBankOffersEvent(this, Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_PROMOCODE, Utility.ACTION_PROMOCODE_CLICKED, PromoHelper.Companion.getInstance().getVerticalName(), ""));
            return;
        }
        int i7 = R.id.llOfferDetails;
        if (valueOf != null && valueOf.intValue() == i7) {
            Object tag2 = view.getTag();
            if (tag2 != null) {
                addOfferBottomSheet(((Integer) tag2).intValue());
                Utility.INSTANCE.sendBankOffersEvent(this, Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_PROMOCODE, Utility.ACTION_OFFERDETAIL_CLICKED, PromoHelper.Companion.getInstance().getVerticalName(), ""));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0070, code lost:
        r2 = (r2 = r2.getEditText()).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyManualPromoCode() {
        /*
            r5 = this;
            int r0 = net.one97.paytm.nativesdk.R.id.tilEnterPromo
            android.view.View r0 = r5._$_findCachedViewById(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            java.lang.String r1 = "tilEnterPromo"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x0043
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0043
            int r0 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tvPromoError"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r2 = 0
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = net.one97.paytm.nativesdk.R.string.error_no_promocode
            java.lang.String r1 = r5.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            return
        L_0x0043:
            r0 = r5
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.nativesdk.Utils.SDKUtility.hideKeyboard(r0)
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.isNetworkAvailable(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0057
            r5.showNoInternetDialog(r1)
            return
        L_0x0057:
            r5.showVerifyLoader()
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            int r2 = net.one97.paytm.nativesdk.R.id.tilEnterPromo
            android.view.View r2 = r5._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            if (r2 == 0) goto L_0x007b
            android.widget.EditText r2 = r2.getEditText()
            if (r2 == 0) goto L_0x007b
            android.text.Editable r2 = r2.getText()
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = r2.toString()
            goto L_0x007c
        L_0x007b:
            r2 = r1
        L_0x007c:
            r3 = 1
            java.lang.String r4 = ""
            r0.onPromoSelected(r2, r4, r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoSearchActivity.applyManualPromoCode():void");
    }

    public final void onBackPressed() {
        if (((TextInputLayout) _$_findCachedViewById(R.id.tilEnterPromo)).hasFocus()) {
            ((TextInputLayout) _$_findCachedViewById(R.id.tilEnterPromo)).clearFocus();
        }
        super.onBackPressed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r2 = r2.get(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onPromoSelected(int r7) {
        /*
            r6 = this;
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.isNetworkAvailable(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            r6.showNoInternetDialog(r1)
            return
        L_0x000e:
            r6.showVerifyLoader()
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            java.util.List<net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem> r2 = r6.mPromoItemList
            if (r2 == 0) goto L_0x0028
            java.lang.Object r2 = r2.get(r7)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem r2 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem) r2
            if (r2 == 0) goto L_0x0028
            java.lang.String r2 = r2.getCode()
            goto L_0x0029
        L_0x0028:
            r2 = r1
        L_0x0029:
            java.util.List<net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem> r3 = r6.mPromoItemList
            if (r3 == 0) goto L_0x0040
            java.lang.Object r3 = r3.get(r7)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem r3 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem) r3
            if (r3 == 0) goto L_0x0040
            net.one97.paytm.nativesdk.orflow.promo.model.Offer r3 = r3.getOffer()
            if (r3 == 0) goto L_0x0040
            java.lang.String r3 = r3.getTitle()
            goto L_0x0041
        L_0x0040:
            r3 = r1
        L_0x0041:
            r4 = 0
            java.util.List<net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem> r5 = r6.mPromoItemList
            if (r5 == 0) goto L_0x0052
            java.lang.Object r7 = r5.get(r7)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem r7 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem) r7
            if (r7 == 0) goto L_0x0052
            java.lang.Object r1 = r7.getPaymentFilters()
        L_0x0052:
            r0.onPromoSelected(r2, r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoSearchActivity.onPromoSelected(int):void");
    }

    private final void showPromoError(String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPromoError);
        k.a((Object) textView, "tvPromoError");
        boolean z = false;
        textView.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvPromoError);
        k.a((Object) textView2, "tvPromoError");
        textView2.setText(str);
        TextInputEditText textInputEditText = (TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo);
        k.a((Object) textInputEditText, "tietEnterPromo");
        Editable text = textInputEditText.getText();
        if (text != null) {
            if (text.length() > 0) {
                z = true;
            }
            if (z) {
                TextInputEditText textInputEditText2 = (TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo);
                k.a((Object) textInputEditText2, "tietEnterPromo");
                textInputEditText2.setBackground(b.a((Context) this, R.drawable.edit_text_error_line));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void hidePromoError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPromoError);
        k.a((Object) textView, "tvPromoError");
        textView.setVisibility(8);
        if (((TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo)).hasFocus()) {
            TextInputEditText textInputEditText = (TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo);
            k.a((Object) textInputEditText, "tietEnterPromo");
            textInputEditText.setBackground(b.a((Context) this, R.drawable.edit_text_blue_line));
            return;
        }
        TextInputEditText textInputEditText2 = (TextInputEditText) _$_findCachedViewById(R.id.tietEnterPromo);
        k.a((Object) textInputEditText2, "tietEnterPromo");
        textInputEditText2.setBackground(b.a((Context) this, R.drawable.edit_text_grey_line));
    }

    public final void onPromoSearchSuccess(String str) {
        PromoList createPromoList = PromoList.Companion.createPromoList(str);
        Integer num = null;
        this.mPromoItemList = createPromoList != null ? createPromoList.getCodes() : null;
        List<PromoListItem> list = this.mPromoItemList;
        if (list != null) {
            if (list == null) {
                k.a();
            }
            if (!list.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.llOtherOfferSeparator);
                k.a((Object) linearLayout, "llOtherOfferSeparator");
                linearLayout.setVisibility(0);
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.promoListView);
                k.a((Object) recyclerView, "promoListView");
                recyclerView.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvOtherOfferText);
                k.a((Object) textView, "tvOtherOfferText");
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.select_offer_text));
                sb.append(" (");
                List<PromoListItem> list2 = this.mPromoItemList;
                if (list2 != null) {
                    num = Integer.valueOf(list2.size());
                }
                sb.append(num);
                sb.append(")");
                textView.setText(sb.toString());
                Context context = this;
                this.mPromoListAdapter = new PromoListAdapter(context, this.mPromoItemList, this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.promoListView);
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(linearLayoutManager);
                }
                RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.promoListView);
                if (recyclerView3 != null) {
                    recyclerView3.setAdapter(this.mPromoListAdapter);
                }
                ((RecyclerView) _$_findCachedViewById(R.id.promoListView)).addItemDecoration(new ItemDecorator());
                return;
            }
        }
        hidePromoList();
    }

    public final void onPromoSearchError(VolleyError volleyError) {
        hidePromoList();
    }

    private final void hidePromoList() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.llOtherOfferSeparator);
        k.a((Object) linearLayout, "llOtherOfferSeparator");
        linearLayout.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.promoListView);
        k.a((Object) recyclerView, "promoListView");
        recyclerView.setVisibility(4);
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(R.id.llNoPromoLayout);
        k.a((Object) scrollView, "llNoPromoLayout");
        scrollView.setVisibility(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r0 == null) goto L_0x00d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVerifyPromoSuccess(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r5, boolean r6, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.VerifyResponseData r7) {
        /*
            r4 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0008
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r1 = r7.getConvFeeResponse()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r1 == 0) goto L_0x003d
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r1 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r1 = r1.getInstance()
            java.util.ArrayList r1 = r1.getPaymentIntent()
            if (r1 == 0) goto L_0x003d
            net.one97.paytm.nativesdk.ConvenienceFeeOrController$Companion r1 = net.one97.paytm.nativesdk.ConvenienceFeeOrController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeOrController r1 = r1.getInstance()
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r2 = r7.getConvFeeResponse()
            java.lang.String r3 = "data.convFeeResponse"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r3 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r3 = r3.getInstance()
            java.util.ArrayList r3 = r3.getPaymentIntent()
            if (r3 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            java.lang.Object r7 = r7.getVerifyModel()
            r1.setConvFeeResponse((net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.ConvFeeResponse) r2, (java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent>) r3, (java.lang.Object) r7)
            goto L_0x0046
        L_0x003d:
            net.one97.paytm.nativesdk.ConvenienceFeeOrController$Companion r7 = net.one97.paytm.nativesdk.ConvenienceFeeOrController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeOrController r7 = r7.getInstance()
            r7.resetConvenienceFee()
        L_0x0046:
            r4.hideVerifyLoader()
            if (r6 != 0) goto L_0x00e7
            if (r5 != 0) goto L_0x004f
            goto L_0x00e7
        L_0x004f:
            net.one97.paytm.nativesdk.common.model.Body r6 = r5.getBody()
            if (r6 == 0) goto L_0x005a
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r6 = r6.getMerchantPayOption()
            goto L_0x005b
        L_0x005a:
            r6 = r0
        L_0x005b:
            if (r6 == 0) goto L_0x00d9
            java.util.ArrayList r7 = r6.getPaymentModes()
            if (r7 == 0) goto L_0x006d
            java.util.ArrayList r7 = r6.getPaymentModes()
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0096
        L_0x006d:
            java.util.ArrayList r7 = r6.getSavedInstruments()
            if (r7 == 0) goto L_0x007d
            java.util.ArrayList r7 = r6.getSavedInstruments()
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0096
        L_0x007d:
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r6 = r6.getUpiProfile()
            if (r6 == 0) goto L_0x0093
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r6 = r6.getRespDetails()
            if (r6 == 0) goto L_0x0093
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r6 = r6.getProfileDetail()
            if (r6 == 0) goto L_0x0093
            java.util.List r0 = r6.getBankAccounts()
        L_0x0093:
            if (r0 != 0) goto L_0x0096
            goto L_0x00d9
        L_0x0096:
            net.one97.paytm.nativesdk.orflow.Utility r6 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            boolean r6 = r6.shouldShowNBOnlySheet(r5)
            if (r6 == 0) goto L_0x00a7
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet$Companion r6 = net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet.Companion
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r5 = r6.getInstance(r5)
            net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet r5 = (net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet) r5
            goto L_0x00af
        L_0x00a7:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet$Companion r6 = net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet.Companion
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r5 = r6.getInstance(r5)
            net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet r5 = (net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet) r5
        L_0x00af:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoSearchActivity$onVerifyPromoSuccess$1 r6 = new net.one97.paytm.nativesdk.orflow.promo.view.PromoSearchActivity$onVerifyPromoSuccess$1
            r6.<init>(r4)
            net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet$OnDismissListener r6 = (net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet.OnDismissListener) r6
            r5.setDismissListener(r6)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r6 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r6 = r6.getInstance()
            r7 = r4
            net.one97.paytm.nativesdk.app.VerifyPromoResultListener r7 = (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r7
            r6.removeVerifyPromoObserver(r7)
            androidx.fragment.app.j r6 = r4.getSupportFragmentManager()
            java.lang.String r7 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.Class<net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet> r7 = net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet.class
            java.lang.String r7 = r7.getSimpleName()
            r5.show(r6, r7)
            goto L_0x00ed
        L_0x00d9:
            android.content.res.Resources r5 = r4.getResources()
            int r6 = net.one97.paytm.nativesdk.R.string.default_error_blank_payoptions
            java.lang.String r5 = r5.getString(r6)
            r4.onVerifyPromoError(r5)
            return
        L_0x00e7:
            r5 = 1
            r4.isPromoApplied = r5
            r4.finish()
        L_0x00ed:
            net.one97.paytm.nativesdk.orflow.Utility r5 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            r6 = r4
            android.content.Context r6 = (android.content.Context) r6
            net.one97.paytm.nativesdk.orflow.Utility r7 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            java.lang.String r0 = r4.applyEventAction
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r1 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r1 = r1.getInstance()
            java.lang.String r1 = r1.getVerticalName()
            java.lang.String r2 = "promocode"
            java.lang.String r3 = "Successful"
            java.util.Map r7 = r7.getBankOfferEventParams(r2, r0, r1, r3)
            r5.sendBankOffersEvent(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoSearchActivity.onVerifyPromoSuccess(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse, boolean, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData):void");
    }

    public final void onVerifyPromoError(String str) {
        PromoListItem promoListItem;
        hideVerifyLoader();
        int i2 = this.clickedItemPostition;
        if (i2 == -1) {
            showPromoError(str);
        } else {
            List<PromoListItem> list = this.mPromoItemList;
            if (!(list == null || (promoListItem = list.get(i2)) == null)) {
                promoListItem.setPromoErrorMsg(str);
            }
            PromoListAdapter promoListAdapter = this.mPromoListAdapter;
            if (promoListAdapter != null) {
                promoListAdapter.notifyItemChanged(this.clickedItemPostition);
            }
            ((RecyclerView) _$_findCachedViewById(R.id.promoListView)).scrollToPosition(this.clickedItemPostition);
        }
        Utility utility = Utility.INSTANCE;
        Context context = this;
        Utility utility2 = Utility.INSTANCE;
        String str2 = this.applyEventAction;
        String verticalName = PromoHelper.Companion.getInstance().getVerticalName();
        if (str == null) {
            str = "";
        }
        utility.sendBankOffersEvent(context, utility2.getBankOfferEventParams(Utility.EVENT_CATEGORY_PROMOCODE, str2, verticalName, "failed", str, ""));
    }

    public final void onNonPromoError(String str) {
        onVerifyPromoError(str);
    }

    public final void onVerifyPromoNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        String str;
        hideVerifyLoader();
        hidePromoError();
        Context context = this;
        SDKUtility.handleVerticalError(apiResponseError, context);
        Utility utility = Utility.INSTANCE;
        Utility utility2 = Utility.INSTANCE;
        String str2 = this.applyEventAction;
        String verticalName = PromoHelper.Companion.getInstance().getVerticalName();
        if (apiResponseError == null || (str = apiResponseError.getErrorMsg()) == null) {
            str = "";
        }
        utility.sendBankOffersEvent(context, utility2.getBankOfferEventParams(Utility.EVENT_CATEGORY_PROMOCODE, str2, verticalName, "failed", str, "Network Error"));
    }

    private final void showNoInternetDialog(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        String errorMsg;
        String errorTitle;
        Context context = this;
        View inflate = LayoutInflater.from(context).inflate(R.layout.promo_dialog_network_error, (ViewGroup) null, false);
        if (inflate != null) {
            if (!(apiResponseError == null || (errorTitle = apiResponseError.getErrorTitle()) == null)) {
                TextView textView = (TextView) inflate.findViewById(R.id.tvTitle);
                k.a((Object) textView, "dialogView.tvTitle");
                textView.setText(errorTitle);
            }
            if (!(apiResponseError == null || (errorMsg = apiResponseError.getErrorMsg()) == null)) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.tvMsg);
                k.a((Object) textView2, "dialogView.tvMsg");
                textView2.setText(errorMsg);
            }
            AlertDialog create = new AlertDialog.Builder(context).create();
            create.setView(inflate);
            create.setCancelable(false);
            ((TextView) inflate.findViewById(R.id.tvOk)).setOnClickListener(new PromoSearchActivity$showNoInternetDialog$3(create));
            create.show();
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    private final void hideVerifyLoader() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            ProgressDialog progressDialog2 = this.mProgressDialog;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            this.mProgressDialog = null;
        }
    }

    private final void showVerifyLoader() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog == null || progressDialog == null || !progressDialog.isShowing()) {
            this.mProgressDialog = new ProgressDialog(this);
            try {
                ProgressDialog progressDialog2 = this.mProgressDialog;
                if (progressDialog2 != null) {
                    progressDialog2.setIndeterminateDrawable(b.a((Context) this, R.drawable.promo_custom_progress_bar));
                }
                ProgressDialog progressDialog3 = this.mProgressDialog;
                if (progressDialog3 != null) {
                    progressDialog3.setMessage(getString(R.string.please_wait_progress_msg));
                }
                ProgressDialog progressDialog4 = this.mProgressDialog;
                if (progressDialog4 != null) {
                    progressDialog4.setCancelable(false);
                }
                ProgressDialog progressDialog5 = this.mProgressDialog;
                if (progressDialog5 != null) {
                    progressDialog5.setCanceledOnTouchOutside(false);
                }
                ProgressDialog progressDialog6 = this.mProgressDialog;
                if (progressDialog6 != null) {
                    progressDialog6.show();
                }
            } catch (IllegalArgumentException e2) {
                LogUtility.printStackTrace(e2);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean shouldKillActivity() {
        return this.shouldKillActivity;
    }

    public final void saveActivityFromFinish(String str) {
        if (!getChildClassName().equals(str)) {
            finish();
        }
    }

    public final void onDestroy() {
        PromoHelper.Companion.getInstance().removePromoSearchObserver(this);
        PromoHelper.Companion.getInstance().removeVerifyPromoObserver(this);
        PromoHelper.Companion.getInstance().onPromoSearchActivityDestroy(this.isPromoApplied);
        PromoHelper.Companion.getInstance().clearAllListeners();
        super.onDestroy();
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
            List access$getMPromoItemList$p = PromoSearchActivity.this.mPromoItemList;
            if (access$getMPromoItemList$p == null) {
                k.a();
            }
            if (childAdapterPosition == access$getMPromoItemList$p.size() - 1) {
                rect.bottom = (int) (Utility.INSTANCE.getDensity(PromoSearchActivity.this) * 30.0f);
            }
        }
    }
}
