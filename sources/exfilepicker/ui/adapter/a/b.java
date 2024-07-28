package exfilepicker.ui.adapter.a;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytm.android.chat.R;
import exfilepicker.ui.a.a;
import java.io.File;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatTextView f46215b = ((AppCompatTextView) this.itemView.findViewById(R.id.filesize));

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatImageView f46216c = ((AppCompatImageView) this.itemView.findViewById(R.id.thumbnail));

    public b(View view) {
        super(view);
    }

    public final void a(File file, boolean z, boolean z2, a aVar) {
        super.a(file, z, z2, aVar);
        AppCompatTextView appCompatTextView = this.f46215b;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(8);
        }
        this.f46216c.setImageResource(R.drawable.chat_efp__ic_folder);
    }
}
