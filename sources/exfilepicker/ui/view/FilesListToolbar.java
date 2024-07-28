package exfilepicker.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import com.paytm.android.chat.R;
import exfilepicker.a.d;

public class FilesListToolbar extends Toolbar {

    /* renamed from: a  reason: collision with root package name */
    private boolean f46253a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f46254b;

    public FilesListToolbar(Context context) {
        super(context);
    }

    public FilesListToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilesListToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setQuitButtonEnabled(boolean z) {
        this.f46253a = z;
    }

    public void setMultiChoiceModeEnabled(boolean z) {
        getMenu().clear();
        if (z) {
            inflateMenu(R.menu.chat_files_list_multi_choice);
            this.f46254b = getTitle();
            setTitle((CharSequence) null);
            setNavigationIcon(d.a(getContext(), R.attr.efp__ic_action_cancel));
            return;
        }
        inflateMenu(R.menu.chat_files_list_single_choice);
        if (!TextUtils.isEmpty(this.f46254b)) {
            setTitle(this.f46254b);
        }
        if (this.f46253a) {
            setNavigationIcon(d.a(getContext(), R.attr.efp__ic_action_cancel));
        } else {
            setNavigationIcon((Drawable) null);
        }
    }
}
