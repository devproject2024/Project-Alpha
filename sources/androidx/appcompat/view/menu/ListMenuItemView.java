package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ac;
import androidx.core.h.u;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, n.a {

    /* renamed from: a  reason: collision with root package name */
    private i f1270a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f1271b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f1272c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f1273d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f1274e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f1275f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f1276g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f1277h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f1278i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private LayoutInflater p;
    private boolean q;

    public final boolean a() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        ac a2 = ac.a(getContext(), attributeSet, R.styleable.MenuView, i2, 0);
        this.j = a2.a(R.styleable.MenuView_android_itemBackground);
        this.k = a2.g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a2.a(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.f1669a.recycle();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        u.a((View) this, this.j);
        this.f1273d = (TextView) findViewById(R.id.title);
        int i2 = this.k;
        if (i2 != -1) {
            this.f1273d.setTextAppearance(this.l, i2);
        }
        this.f1275f = (TextView) findViewById(R.id.shortcut);
        this.f1276g = (ImageView) findViewById(R.id.submenuarrow);
        ImageView imageView = this.f1276g;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.f1277h = (ImageView) findViewById(R.id.group_divider);
        this.f1278i = (LinearLayout) findViewById(R.id.content);
    }

    public final void a(i iVar) {
        this.f1270a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.a((n.a) this));
        setCheckable(iVar.isCheckable());
        setShortcut(iVar.d(), iVar.c());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.f1278i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1273d.setText(charSequence);
            if (this.f1273d.getVisibility() != 0) {
                this.f1273d.setVisibility(0);
            }
        } else if (this.f1273d.getVisibility() != 8) {
            this.f1273d.setVisibility(8);
        }
    }

    public i getItemData() {
        return this.f1270a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f1272c != null || this.f1274e != null) {
            if (this.f1270a.e()) {
                if (this.f1272c == null) {
                    b();
                }
                compoundButton2 = this.f1272c;
                compoundButton = this.f1274e;
            } else {
                if (this.f1274e == null) {
                    c();
                }
                compoundButton2 = this.f1274e;
                compoundButton = this.f1272c;
            }
            if (z) {
                compoundButton2.setChecked(this.f1270a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f1274e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f1272c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1270a.e()) {
            if (this.f1272c == null) {
                b();
            }
            compoundButton = this.f1272c;
        } else {
            if (this.f1274e == null) {
                c();
            }
            compoundButton = this.f1274e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f1276g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setShortcut(boolean z, char c2) {
        String str;
        int i2 = (!z || !this.f1270a.d()) ? 8 : 0;
        if (i2 == 0) {
            TextView textView = this.f1275f;
            i iVar = this.f1270a;
            char c3 = iVar.c();
            if (c3 == 0) {
                str = "";
            } else {
                Resources resources = iVar.f1351d.f1335a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(iVar.f1351d.f1335a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i3 = iVar.f1351d.c() ? iVar.f1350c : iVar.f1349b;
                i.a(sb, i3, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                i.a(sb, i3, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                i.a(sb, i3, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                i.a(sb, i3, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                i.a(sb, i3, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                i.a(sb, i3, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (c3 == 8) {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (c3 == 10) {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (c3 != ' ') {
                    sb.append(c3);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                str = sb.toString();
            }
            textView.setText(str);
        }
        if (this.f1275f.getVisibility() != i2) {
            this.f1275f.setVisibility(i2);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1270a.f1351d.f1343i || this.q;
        if (!z && !this.m) {
            return;
        }
        if (this.f1271b != null || drawable != null || this.m) {
            if (this.f1271b == null) {
                this.f1271b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
                a(this.f1271b, 0);
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.f1271b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1271b.getVisibility() != 0) {
                    this.f1271b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1271b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f1271b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1271b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    private void b() {
        this.f1272c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        a(this.f1272c, -1);
    }

    private void c() {
        this.f1274e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        a(this.f1274e, -1);
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f1277h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1277h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1277h.getLayoutParams();
            rect.top += this.f1277h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }
}
