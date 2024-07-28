package exfilepicker.ui.adapter.a;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import java.io.File;

public abstract class a extends RecyclerView.v implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public exfilepicker.ui.a.a f46212a;

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatTextView f46213b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatCheckBox f46214c;

    a(View view) {
        super(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        this.f46213b = (AppCompatTextView) view.findViewById(R.id.filename);
        this.f46214c = (AppCompatCheckBox) view.findViewById(R.id.checkbox);
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return getAdapterPosition();
    }

    public void onClick(View view) {
        exfilepicker.ui.a.a aVar = this.f46212a;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public boolean onLongClick(View view) {
        if (this.f46212a == null) {
            return true;
        }
        a();
        return true;
    }

    public void a(File file, boolean z, boolean z2, exfilepicker.ui.a.a aVar) {
        this.f46212a = aVar;
        this.f46213b.setText(file.getName());
        this.f46214c.setVisibility(z ? 0 : 8);
        this.f46214c.setChecked(z2);
    }
}
