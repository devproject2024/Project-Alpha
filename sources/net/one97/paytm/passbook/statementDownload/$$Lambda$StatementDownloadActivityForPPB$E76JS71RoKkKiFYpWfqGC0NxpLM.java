package net.one97.paytm.passbook.statementDownload;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.passbook.mapping.a.g;

/* renamed from: net.one97.paytm.passbook.statementDownload.-$$Lambda$StatementDownloadActivityForPPB$E76JS71RoKkKiFYpWfqGC0NxpLM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$StatementDownloadActivityForPPB$E76JS71RoKkKiFYpWfqGC0NxpLM implements g {
    public static final /* synthetic */ $$Lambda$StatementDownloadActivityForPPB$E76JS71RoKkKiFYpWfqGC0NxpLM INSTANCE = new $$Lambda$StatementDownloadActivityForPPB$E76JS71RoKkKiFYpWfqGC0NxpLM();

    private /* synthetic */ $$Lambda$StatementDownloadActivityForPPB$E76JS71RoKkKiFYpWfqGC0NxpLM() {
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        StatementDownloadActivityForPPB.a(i2, iJRPaytmDataModel, networkCustomError);
    }
}
