package com.paytm.contactsSdk.api.view.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.contactsSdk.R;
import com.paytm.contactsSdk.api.model.ConsentUIMetaInfo;
import com.paytm.contactsSdk.api.util.LinkExtensionKt;
import kotlin.g.b.k;
import kotlin.o;

public final class ConsentDialog extends Dialog {
    private final AppCompatActivity activity;
    private final View.OnClickListener allowClick;
    /* access modifiers changed from: private */
    public final ConsentUIMetaInfo consentMetaMetaInfo;
    private final View.OnClickListener skipClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsentDialog(AppCompatActivity appCompatActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, ConsentUIMetaInfo consentUIMetaInfo) {
        super(appCompatActivity);
        k.c(appCompatActivity, "activity");
        k.c(onClickListener, "allowClick");
        k.c(onClickListener2, "skipClick");
        k.c(consentUIMetaInfo, "consentMetaMetaInfo");
        this.activity = appCompatActivity;
        this.allowClick = onClickListener;
        this.skipClick = onClickListener2;
        this.consentMetaMetaInfo = consentUIMetaInfo;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window == null) {
            k.a();
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        setContentView(R.layout.dialog_consent);
        Button button = (Button) findViewById(R.id.allow_btn);
        button.setText(this.activity.getString(this.consentMetaMetaInfo.getConfirmationButtonText()));
        button.setOnClickListener(this.allowClick);
        TextView textView = (TextView) findViewById(R.id.skip_tv);
        textView.setText(this.activity.getString(this.consentMetaMetaInfo.getDeniedButtonText()));
        textView.setOnClickListener(this.skipClick);
        View findViewById = findViewById(R.id.consent_description);
        k.a((Object) findViewById, "findViewById<TextView>(R.id.consent_description)");
        ((TextView) findViewById).setText(this.activity.getString(this.consentMetaMetaInfo.getDescriptionText()));
        View findViewById2 = findViewById(R.id.header_tv);
        k.a((Object) findViewById2, "findViewById<TextView>(R.id.header_tv)");
        ((TextView) findViewById2).setText(this.activity.getString(this.consentMetaMetaInfo.getHeaderText()));
        View findViewById3 = findViewById(R.id.consent_description);
        k.a((Object) findViewById3, "findViewById<TextView>(R.id.consent_description)");
        LinkExtensionKt.makeLinks((TextView) findViewById3, new o(this.activity.getString(this.consentMetaMetaInfo.getTnCText()), new ConsentDialog$onCreate$3(this)));
    }
}
