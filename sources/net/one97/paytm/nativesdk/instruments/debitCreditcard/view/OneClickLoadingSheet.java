package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;

public final class OneClickLoadingSheet extends BaseBottomSheetDialogFragment implements OneClickTransactionInfo, TranscationListener {
    public static final String CARD_TYPE = "channel code";
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "OneClickLoadingSheet";
    private HashMap _$_findViewCache;
    private int cardType = -1;
    private final CoroutineExceptionHandler exceptionHandler;
    private OneClickLoadingHelper oneClickHelper;
    private final CompletableJob parentJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private Job processJob;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.parentJob));
    /* access modifiers changed from: private */
    public final int transactionMaxTime;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.PROCESSING.ordinal()] = 1;
            $EnumSwitchMapping$0[State.STARTED.ordinal()] = 2;
            $EnumSwitchMapping$0[State.FINISHED.ordinal()] = 3;
        }
    }

    public static final OneClickLoadingSheet getInstance(int i2) {
        return Companion.getInstance(i2);
    }

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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public OneClickLoadingSheet() {
        Integer num = GTMLoader.getInt(SDKConstants.KEY_SCP_TRANSACTION_MAX_TIME);
        this.transactionMaxTime = num != null ? num.intValue() : 44;
        this.exceptionHandler = new OneClickLoadingSheet$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final OneClickLoadingSheet getInstance(int i2) {
            OneClickLoadingSheet oneClickLoadingSheet = new OneClickLoadingSheet();
            Bundle bundle = new Bundle();
            bundle.putInt("channel code", i2);
            oneClickLoadingSheet.setArguments(bundle);
            return oneClickLoadingSheet;
        }
    }

    public final int getLayoutId() {
        return R.layout.one_click_bottom_sheet;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.cardType = bundle.getInt("channel code");
        }
        disableUiInteraction();
        setCancelable(false);
    }

    public final void show(Context context) {
        k.c(context, "context");
        if (context instanceof AppCompatActivity) {
            j supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "context.supportFragmentManager");
            show(supportFragmentManager, "OneClickLoadingSheet");
        } else if (context instanceof FragmentActivity) {
            j supportFragmentManager2 = ((FragmentActivity) context).getSupportFragmentManager();
            k.a((Object) supportFragmentManager2, "context.supportFragmentManager");
            show(supportFragmentManager2, "OneClickLoadingSheet");
        }
    }

    public final void initView() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        instance.setOneClickTranscationListener(this);
        Context appContext = PaytmSDK.getAppContext();
        k.a((Object) appContext, "PaytmSDK.getAppContext()");
        OneClickLoadingHelper oneClickLoadingHelper = new OneClickLoadingHelper(appContext, this.cardType);
        oneClickLoadingHelper.start();
        this.oneClickHelper = oneClickLoadingHelper;
        this.processJob = BuildersKt__Builders_commonKt.launch$default(this.scope, this.exceptionHandler, (CoroutineStart) null, new OneClickLoadingSheet$initView$2(this, (d) null), 2, (Object) null);
    }

    public final void dismissSheet() {
        dismissAllowingStateLoss();
        OneClickLoadingHelper oneClickLoadingHelper = this.oneClickHelper;
        if (oneClickLoadingHelper != null) {
            oneClickLoadingHelper.onDestroy();
        }
    }

    public final void redirect(a<x> aVar) {
        k.c(aVar, "value");
        OneClickLoadingHelper oneClickLoadingHelper = this.oneClickHelper;
        if (oneClickLoadingHelper != null) {
            oneClickLoadingHelper.redirect(new OneClickLoadingSheet$redirect$$inlined$let$lambda$1(aVar));
        } else {
            aVar.invoke();
        }
    }

    public final CoroutineExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object timer(int i2, d<? super Flow<Integer>> dVar) {
        return FlowKt.flow(new OneClickLoadingSheet$timer$2(i2, (d) null));
    }

    public final void onDestroy() {
        super.onDestroy();
        try {
            Job.DefaultImpls.cancel$default(this.parentJob, (CancellationException) null, 1, (Object) null);
        } catch (Exception e2) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException("OneClickLoadingSheet", "Coroutine clear exception caught", e2);
            }
        } catch (Throwable th) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException("OneClickLoadingSheet", "Coroutine verify exception caught", th);
            }
        }
    }

    public final void oneClickProgressInfo(State state, ProcessingInfo processingInfo) {
        k.c(state, "state");
        k.c(processingInfo, "processingInfo");
        int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i2 == 1 || i2 == 2) {
            updateView(processingInfo);
        } else if (i2 == 3) {
            dismissAllowingStateLoss();
        }
    }

    public final void updateView(ProcessingInfo processingInfo) {
        View mView;
        k.c(processingInfo, "processingInfo");
        if (isAdded() && (mView = getMView()) != null) {
            TextView textView = (TextView) mView.findViewById(R.id.info);
            k.a((Object) textView, "info");
            textView.setText(processingInfo.getText());
            Integer valueOf = Integer.valueOf(processingInfo.getRightImageUrl());
            if (!(valueOf.intValue() != -1)) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                AppCompatImageView appCompatImageView = (AppCompatImageView) mView.findViewById(R.id.rightImage);
                k.a((Object) appCompatImageView, "rightImage");
                ExtensionsKt.visible(appCompatImageView);
                ((AppCompatImageView) mView.findViewById(R.id.rightImage)).setImageResource(intValue);
                return;
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) mView.findViewById(R.id.rightImage);
            k.a((Object) appCompatImageView2, "rightImage");
            ExtensionsKt.gone(appCompatImageView2);
        }
    }
}
