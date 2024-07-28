package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.widget.u;
import androidx.core.graphics.a;

public final class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final PorterDuff.Mode f1735a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static f f1736b;

    /* renamed from: c  reason: collision with root package name */
    private u f1737c;

    public static synchronized void a() {
        synchronized (f.class) {
            if (f1736b == null) {
                f fVar = new f();
                f1736b = fVar;
                fVar.f1737c = u.a();
                f1736b.f1737c.a((u.e) new u.e() {

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f1738a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f1739b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f1740c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f1741d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f1742e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

                    /* renamed from: f  reason: collision with root package name */
                    private final int[] f1743f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                    private static ColorStateList b(Context context, int i2) {
                        int a2 = y.a(context, R.attr.colorControlHighlight);
                        int c2 = y.c(context, R.attr.colorButtonNormal);
                        return new ColorStateList(new int[][]{y.f1828a, y.f1831d, y.f1829b, y.f1835h}, new int[]{c2, a.a(a2, i2), a.a(a2, i2), i2});
                    }

                    public final Drawable a(u uVar, Context context, int i2) {
                        if (i2 != R.drawable.abc_cab_background_top_material) {
                            return null;
                        }
                        return new LayerDrawable(new Drawable[]{uVar.a(context, R.drawable.abc_cab_background_internal_bg), uVar.a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                    }

                    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
                        if (p.c(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = f.f1735a;
                        }
                        drawable.setColorFilter(f.a(i2, mode));
                    }

                    public final boolean a(Context context, int i2, Drawable drawable) {
                        if (i2 == R.drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(16908288), y.a(context, R.attr.colorControlNormal), f.f1735a);
                            a(layerDrawable.findDrawableByLayerId(16908303), y.a(context, R.attr.colorControlNormal), f.f1735a);
                            a(layerDrawable.findDrawableByLayerId(16908301), y.a(context, R.attr.colorControlActivated), f.f1735a);
                            return true;
                        } else if (i2 != R.drawable.abc_ratingbar_material && i2 != R.drawable.abc_ratingbar_indicator_material && i2 != R.drawable.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            a(layerDrawable2.findDrawableByLayerId(16908288), y.c(context, R.attr.colorControlNormal), f.f1735a);
                            a(layerDrawable2.findDrawableByLayerId(16908303), y.a(context, R.attr.colorControlActivated), f.f1735a);
                            a(layerDrawable2.findDrawableByLayerId(16908301), y.a(context, R.attr.colorControlActivated), f.f1735a);
                            return true;
                        }
                    }

                    private static boolean a(int[] iArr, int i2) {
                        for (int i3 : iArr) {
                            if (i3 == i2) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public final ColorStateList a(Context context, int i2) {
                        if (i2 == R.drawable.abc_edit_text_material) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_edittext);
                        }
                        if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_switch_track);
                        }
                        if (i2 == R.drawable.abc_switch_thumb_material) {
                            int[][] iArr = new int[3][];
                            int[] iArr2 = new int[3];
                            ColorStateList b2 = y.b(context, R.attr.colorSwitchThumbNormal);
                            if (b2 == null || !b2.isStateful()) {
                                iArr[0] = y.f1828a;
                                iArr2[0] = y.c(context, R.attr.colorSwitchThumbNormal);
                                iArr[1] = y.f1832e;
                                iArr2[1] = y.a(context, R.attr.colorControlActivated);
                                iArr[2] = y.f1835h;
                                iArr2[2] = y.a(context, R.attr.colorSwitchThumbNormal);
                            } else {
                                iArr[0] = y.f1828a;
                                iArr2[0] = b2.getColorForState(iArr[0], 0);
                                iArr[1] = y.f1832e;
                                iArr2[1] = y.a(context, R.attr.colorControlActivated);
                                iArr[2] = y.f1835h;
                                iArr2[2] = b2.getDefaultColor();
                            }
                            return new ColorStateList(iArr, iArr2);
                        } else if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                            return b(context, y.a(context, R.attr.colorButtonNormal));
                        } else {
                            if (i2 == R.drawable.abc_btn_borderless_material) {
                                return b(context, 0);
                            }
                            if (i2 == R.drawable.abc_btn_colored_material) {
                                return b(context, y.a(context, R.attr.colorAccent));
                            }
                            if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_spinner);
                            }
                            if (a(this.f1739b, i2)) {
                                return y.b(context, R.attr.colorControlNormal);
                            }
                            if (a(this.f1742e, i2)) {
                                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_default);
                            }
                            if (a(this.f1743f, i2)) {
                                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_btn_checkable);
                            }
                            if (i2 == R.drawable.abc_seekbar_thumb_material) {
                                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_seek_thumb);
                            }
                            return null;
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.f.f1735a
                            int[] r1 = r6.f1738a
                            boolean r1 = a((int[]) r1, (int) r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0017
                            int r2 = androidx.appcompat.R.attr.colorControlNormal
                        L_0x0014:
                            r8 = 1
                            r1 = -1
                            goto L_0x0046
                        L_0x0017:
                            int[] r1 = r6.f1740c
                            boolean r1 = a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x0022
                            int r2 = androidx.appcompat.R.attr.colorControlActivated
                            goto L_0x0014
                        L_0x0022:
                            int[] r1 = r6.f1741d
                            boolean r1 = a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x002d
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L_0x0014
                        L_0x002d:
                            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                            if (r8 != r1) goto L_0x003e
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = r8
                            r8 = 1
                            goto L_0x0046
                        L_0x003e:
                            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                            if (r8 != r1) goto L_0x0043
                            goto L_0x0014
                        L_0x0043:
                            r8 = 0
                            r1 = -1
                            r2 = 0
                        L_0x0046:
                            if (r8 == 0) goto L_0x0063
                            boolean r8 = androidx.appcompat.widget.p.c(r9)
                            if (r8 == 0) goto L_0x0052
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x0052:
                            int r7 = androidx.appcompat.widget.y.a((android.content.Context) r7, (int) r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.f.a((int) r7, (android.graphics.PorterDuff.Mode) r0)
                            r9.setColorFilter(r7)
                            if (r1 == r3) goto L_0x0062
                            r9.setAlpha(r1)
                        L_0x0062:
                            return r5
                        L_0x0063:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f.AnonymousClass1.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    public final PorterDuff.Mode a(int i2) {
                        if (i2 == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f1736b == null) {
                a();
            }
            fVar = f1736b;
        }
        return fVar;
    }

    public final synchronized Drawable a(Context context, int i2) {
        return this.f1737c.a(context, i2);
    }

    /* access modifiers changed from: package-private */
    public final synchronized Drawable b(Context context, int i2) {
        return this.f1737c.a(context, i2, true);
    }

    public final synchronized void a(Context context) {
        this.f1737c.a(context);
    }

    /* access modifiers changed from: package-private */
    public final synchronized ColorStateList c(Context context, int i2) {
        return this.f1737c.b(context, i2);
    }

    static void a(Drawable drawable, aa aaVar, int[] iArr) {
        u.a(drawable, aaVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (f.class) {
            a2 = u.a(i2, mode);
        }
        return a2;
    }
}
