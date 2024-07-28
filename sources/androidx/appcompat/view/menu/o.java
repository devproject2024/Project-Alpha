package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.b.a.a;

public class o extends c implements Menu {

    /* renamed from: d  reason: collision with root package name */
    private final a f1380d;

    public o(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f1380d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return a(this.f1380d.add(charSequence));
    }

    public MenuItem add(int i2) {
        return a(this.f1380d.add(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(this.f1380d.add(i2, i3, i4, charSequence));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(this.f1380d.add(i2, i3, i4, i5));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(this.f1380d.addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i2) {
        return a(this.f1380d.addSubMenu(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return a(this.f1380d.addSubMenu(i2, i3, i4, charSequence));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return a(this.f1380d.addSubMenu(i2, i3, i4, i5));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f1380d.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr2[i6] = a(menuItemArr3[i6]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        this.f1380d.setGroupCheckable(i2, z, z2);
    }

    public void setGroupVisible(int i2, boolean z) {
        this.f1380d.setGroupVisible(i2, z);
    }

    public void setGroupEnabled(int i2, boolean z) {
        this.f1380d.setGroupEnabled(i2, z);
    }

    public boolean hasVisibleItems() {
        return this.f1380d.hasVisibleItems();
    }

    public MenuItem findItem(int i2) {
        return a(this.f1380d.findItem(i2));
    }

    public int size() {
        return this.f1380d.size();
    }

    public MenuItem getItem(int i2) {
        return a(this.f1380d.getItem(i2));
    }

    public void close() {
        this.f1380d.close();
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f1380d.performShortcut(i2, keyEvent, i3);
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f1380d.isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return this.f1380d.performIdentifierAction(i2, i3);
    }

    public void setQwertyMode(boolean z) {
        this.f1380d.setQwertyMode(z);
    }

    public void removeItem(int i2) {
        if (this.f1298b != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f1298b.size()) {
                    break;
                } else if (this.f1298b.b(i3).getItemId() == i2) {
                    this.f1298b.d(i3);
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.f1380d.removeItem(i2);
    }

    public void removeGroup(int i2) {
        if (this.f1298b != null) {
            int i3 = 0;
            while (i3 < this.f1298b.size()) {
                if (this.f1298b.b(i3).getGroupId() == i2) {
                    this.f1298b.d(i3);
                    i3--;
                }
                i3++;
            }
        }
        this.f1380d.removeGroup(i2);
    }

    public void clear() {
        if (this.f1298b != null) {
            this.f1298b.clear();
        }
        if (this.f1299c != null) {
            this.f1299c.clear();
        }
        this.f1380d.clear();
    }
}
