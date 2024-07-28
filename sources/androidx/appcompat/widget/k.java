package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.g.f;

final class k {

    /* renamed from: a  reason: collision with root package name */
    TextClassifier f1757a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1758b;

    k(TextView textView) {
        this.f1758b = (TextView) f.a(textView);
    }

    public final TextClassifier a() {
        TextClassifier textClassifier = this.f1757a;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1758b.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
