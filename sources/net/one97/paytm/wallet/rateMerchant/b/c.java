package net.one97.paytm.wallet.rateMerchant.b;

import androidx.lifecycle.LiveData;
import kotlin.o;
import net.one97.paytm.wallet.rateMerchant.a.a;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;
import net.one97.paytm.wallet.rateMerchant.entity.QnARequestBody;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse;

public interface c {
    LiveData<a<MerchantPPReviewData>> a(String str);

    LiveData<a<o<Float, Boolean>>> a(String str, String str2, String str3, float f2, String str4);

    LiveData<a<Boolean>> a(String str, String str2, String str3, float f2, String str4, String str5);

    LiveData<a<String>> a(String str, boolean z, String str2);

    LiveData<a<ReviewQuestionResponse>> a(QnARequestBody qnARequestBody);

    MerchantPPReviewData a();

    o<String, String> b();
}
