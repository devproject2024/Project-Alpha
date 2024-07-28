package net.one97.paytm.nativesdk.transcation.viewmodel;

import android.app.Application;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankForm;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankFormItem;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import net.one97.paytm.nativesdk.transcation.listners.NativePlusActionListener;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayViewModel implements NativePlusActionListener {
    private final Application applicationContext;
    private HashMap<String, BankFormItem> directFormItemMap = new HashMap<>();
    private final ProcessTransactionInfo mProcessTransactionInfo;
    private PaymentRepository mRepository = PaymentRepository.Companion.getInstance(this.applicationContext);
    private y<OtpApiResponse> otpCancelResponse = new y<>();
    private y<OtpApiResponse> otpResendResponse = new y<>();
    private y<OtpApiResponse> otpSubmitResponse = new y<>();

    public NativePlusPayViewModel(Application application, ProcessTransactionInfo processTransactionInfo) {
        k.c(application, "applicationContext");
        this.applicationContext = application;
        this.mProcessTransactionInfo = processTransactionInfo;
        initDirectFormItemMap();
    }

    public final HashMap<String, BankFormItem> getDirectFormItemMap() {
        return this.directFormItemMap;
    }

    public final void setDirectFormItemMap(HashMap<String, BankFormItem> hashMap) {
        k.c(hashMap, "<set-?>");
        this.directFormItemMap = hashMap;
    }

    public final y<OtpApiResponse> getOtpSubmitResponse() {
        return this.otpSubmitResponse;
    }

    public final void setOtpSubmitResponse(y<OtpApiResponse> yVar) {
        this.otpSubmitResponse = yVar;
    }

    public final y<OtpApiResponse> getOtpResendResponse() {
        return this.otpResendResponse;
    }

    public final void setOtpResendResponse(y<OtpApiResponse> yVar) {
        this.otpResendResponse = yVar;
    }

    public final y<OtpApiResponse> getOtpCancelResponse() {
        return this.otpCancelResponse;
    }

    public final void setOtpCancelResponse(y<OtpApiResponse> yVar) {
        this.otpCancelResponse = yVar;
    }

    private final void initDirectFormItemMap() {
        Body body;
        BankForm bankForm;
        ArrayList<BankFormItem> directForms;
        ProcessTransactionInfo processTransactionInfo = this.mProcessTransactionInfo;
        if (processTransactionInfo != null && (body = processTransactionInfo.getBody()) != null && (bankForm = body.getBankForm()) != null && (directForms = bankForm.getDirectForms()) != null) {
            Iterator<BankFormItem> it2 = directForms.iterator();
            while (it2.hasNext()) {
                BankFormItem next = it2.next();
                this.directFormItemMap.put(next.getType(), next);
            }
        }
    }

    public final void resendOtp() {
        PaymentRepository paymentRepository = this.mRepository;
        if (paymentRepository != null) {
            paymentRepository.makeOtpResendRequest(this.directFormItemMap.get(DirectFormItemType.RESEND), new NativePlusPayViewModel$resendOtp$1(this));
        }
    }

    public final void paySecurely(String str) {
        k.c(str, "otp");
        PaymentRepository paymentRepository = this.mRepository;
        if (paymentRepository != null) {
            paymentRepository.makeOtpSubmitRequest(str, this.directFormItemMap.get(DirectFormItemType.SUBMIT), new NativePlusPayViewModel$paySecurely$1(this));
        }
    }

    public final void cancelTransaction() {
        PaymentRepository paymentRepository = this.mRepository;
        if (paymentRepository != null) {
            paymentRepository.makeOtpCancelRequest(this.directFormItemMap.get(DirectFormItemType.CANCEL), new NativePlusPayViewModel$cancelTransaction$1(this));
        }
    }
}
