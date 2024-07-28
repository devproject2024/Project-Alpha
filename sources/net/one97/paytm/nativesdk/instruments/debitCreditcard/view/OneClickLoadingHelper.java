package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
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
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;

public final class OneClickLoadingHelper implements TranscationListener {
    public static final String CARD_TYPE = "channel code";
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "OneClickLoadingSheet";
    private final Context context;
    /* access modifiers changed from: private */
    public final HashSet<ProcessingInfo> descriptionTextMap;
    /* access modifiers changed from: private */
    public int flowExitedTime;
    /* access modifiers changed from: private */
    public boolean interrupt;
    /* access modifiers changed from: private */
    public final int messageSwitchTime;
    private final CompletableJob parentJob;
    private OneClickTransactionInfo paytmSdkCallback;
    private Job processJob;
    private final String redirectingText;
    private final int rightImageRes;
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    public final int transactionMaxTime;

    public OneClickLoadingHelper(Context context2, int i2) {
        k.c(context2, "context");
        this.context = context2;
        this.rightImageRes = i2;
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        this.paytmSdkCallback = instance.getOneClickTranscationListener();
        this.parentJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.parentJob));
        Integer num = GTMLoader.getInt(SDKConstants.KEY_SCP_TRANSACTION_MAX_TIME);
        this.transactionMaxTime = num != null ? num.intValue() : 44;
        Integer num2 = GTMLoader.getInt(SDKConstants.KEY_SCP_TRANSACTION_STATE_CHANGE_TIME);
        this.messageSwitchTime = num2 != null ? num2.intValue() : 4;
        this.descriptionTextMap = new HashSet<>();
        this.redirectingText = GTMLoader.getString(SDKConstants.KEY_SCP_PAYMENT_PROCESSING_TEXT_3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OneClickLoadingHelper(Context context2, int i2, int i3, g gVar) {
        this(context2, (i3 & 2) != 0 ? -1 : i2);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getRightImageRes() {
        return this.rightImageRes;
    }

    public final OneClickTransactionInfo getPaytmSdkCallback() {
        return this.paytmSdkCallback;
    }

    public final void setPaytmSdkCallback(OneClickTransactionInfo oneClickTransactionInfo) {
        this.paytmSdkCallback = oneClickTransactionInfo;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void start() {
        initializeVariables();
        initView();
    }

    private final void initializeVariables() {
        String string = this.context.getString(R.string.processing_text_1);
        k.a((Object) string, "context.getString(R.string.processing_text_1)");
        String string2 = this.context.getString(R.string.processing_text_2);
        k.a((Object) string2, "context.getString(R.string.processing_text_2)");
        this.descriptionTextMap.add(new ProcessingInfo(string, this.rightImageRes));
        this.descriptionTextMap.add(new ProcessingInfo(string2, -1));
    }

    public final void initView() {
        this.interrupt = false;
        x.e eVar = new x.e();
        T it2 = this.descriptionTextMap.iterator();
        k.a((Object) it2, "descriptionTextMap.iterator()");
        eVar.element = it2;
        this.processJob = BuildersKt__Builders_commonKt.launch$default(this.scope, getExceptionHandler(), (CoroutineStart) null, new OneClickLoadingHelper$initView$1(this, eVar, (d) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object timer(int i2, d<? super Flow<Integer>> dVar) {
        return FlowKt.flow(new OneClickLoadingHelper$timer$2(i2, (d) null));
    }

    public final void dismissSheet() {
        onDestroy();
    }

    public final void redirect(a<kotlin.x> aVar) {
        k.c(aVar, "suspendFunction");
        this.interrupt = true;
        Job job = this.processJob;
        if (job != null) {
            job.invokeOnCompletion(new OneClickLoadingHelper$redirect$1(this, aVar));
        }
    }

    public final void redirectToBankPage(a<kotlin.x> aVar) {
        k.c(aVar, "suspendFunction");
        String str = this.redirectingText;
        if (str == null || str == null) {
            str = this.context.getString(R.string.redirecting_to_bank);
            k.a((Object) str, "run{ context.getString(R…ing.redirecting_to_bank)}");
        }
        OneClickTransactionInfo oneClickTransactionInfo = this.paytmSdkCallback;
        if (oneClickTransactionInfo != null) {
            oneClickTransactionInfo.oneClickProgressInfo(State.PROCESSING, new ProcessingInfo(str, -1));
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, getExceptionHandler(), (CoroutineStart) null, new OneClickLoadingHelper$redirectToBankPage$1(this, aVar, (d) null), 2, (Object) null);
    }

    public final void onDestroy() {
        try {
            Job.DefaultImpls.cancel$default(this.parentJob, (CancellationException) null, 1, (Object) null);
        } catch (Exception e2) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException("OneClickLoadingHelper", "Coroutine clear exception caught", e2);
            }
        } catch (Throwable th) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException("OneClickLoadingHelper", "Coroutine verify exception caught", th);
            }
        }
        OneClickTransactionInfo oneClickTransactionInfo = this.paytmSdkCallback;
        if (oneClickTransactionInfo != null) {
            oneClickTransactionInfo.oneClickProgressInfo(State.FINISHED, new ProcessingInfo("", -1));
        }
    }

    private final CoroutineExceptionHandler getExceptionHandler() {
        return new OneClickLoadingHelper$exceptionHandler$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    }
}
