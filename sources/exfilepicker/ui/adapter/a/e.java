package exfilepicker.ui.adapter.a;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytm.android.chat.R;

public final class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatTextView f46220b;

    /* renamed from: c  reason: collision with root package name */
    public final AppCompatCheckBox f46221c;

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatTextView f46222d;

    /* renamed from: e  reason: collision with root package name */
    public final AppCompatImageView f46223e;

    /* access modifiers changed from: package-private */
    public final int a() {
        return -1;
    }

    public e(View view) {
        super(view);
        this.f46220b = (AppCompatTextView) view.findViewById(R.id.filename);
        this.f46221c = (AppCompatCheckBox) view.findViewById(R.id.checkbox);
        this.f46222d = (AppCompatTextView) view.findViewById(R.id.filesize);
        this.f46223e = (AppCompatImageView) view.findViewById(R.id.thumbnail);
    }
}
