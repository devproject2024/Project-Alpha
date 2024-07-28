package com.paytm.android.chat.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.activity.SubSettingsActivity;
import com.paytm.android.chat.bean.SettingItemBean;
import com.paytm.android.chat.c;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import java.util.List;

public final class n extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f41442a;

    /* renamed from: b  reason: collision with root package name */
    List<SettingItemBean> f41443b;

    /* renamed from: c  reason: collision with root package name */
    boolean f41444c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41445d = false;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f41446e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        final SettingItemBean settingItemBean = this.f41443b.get(i2);
        aVar.f41453a.setImageResource(settingItemBean.getDrawableIcon());
        aVar.f41454b.setText(settingItemBean.getTitle());
        aVar.f41455c.setText(settingItemBean.getIntro());
        final int status = settingItemBean.getStatus();
        if (status == 1) {
            aVar.f41456d.setVisibility(8);
            aVar.f41457e.setVisibility(0);
            aVar.f41457e.setChecked(true);
        } else if (status != 2) {
            aVar.f41456d.setVisibility(0);
            aVar.f41457e.setVisibility(8);
            aVar.f41457e.setChecked(true);
        } else {
            aVar.f41456d.setVisibility(8);
            aVar.f41457e.setVisibility(0);
            aVar.f41457e.setChecked(false);
        }
        if (this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_lock_screen).equals(settingItemBean.getTitle())) {
            if (status == 2) {
                this.f41444c = false;
            } else if (status == 1) {
                this.f41444c = true;
            }
        }
        if (this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_lock_screen_preview).equals(settingItemBean.getTitle())) {
            if (this.f41444c) {
                aVar.itemView.setVisibility(0);
            } else {
                aVar.itemView.setVisibility(8);
            }
        }
        if (this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_lock_screen_name).equals(settingItemBean.getTitle())) {
            if (this.f41444c) {
                aVar.itemView.setVisibility(0);
            } else {
                aVar.itemView.setVisibility(8);
            }
        }
        if (status == 0) {
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick()) {
                        Intent intent = new Intent(n.this.f41442a, SubSettingsActivity.class);
                        intent.putExtra(KeyList.IntentExtraKey.SETTINGS_TITLE, settingItemBean.getTitle());
                        intent.putExtra(KeyList.IntentExtraKey.SETTINGS_VALUES, settingItemBean.getValue());
                        ((Activity) n.this.f41442a).startActivityForResult(intent, 102);
                    }
                }
            });
        } else {
            aVar.f41457e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        if (n.this.f41442a == null || ((Activity) n.this.f41442a).isFinishing() || ((Activity) n.this.f41442a).isDestroyed()) {
                            return;
                        }
                    } else if (n.this.f41442a == null || ((Activity) n.this.f41442a).isFinishing()) {
                        return;
                    }
                    n nVar = n.this;
                    nVar.f41445d = true;
                    nVar.f41443b.get(i2).setStatus(status);
                    if (n.this.f41442a.getResources().getString(R.string.chat_module_settings_media_save2camera_roll).equals(settingItemBean.getTitle())) {
                        c.f().settings_media_save2camera_roll = z;
                        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_media_save2camera_roll, z);
                    } else if (n.this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_sound).equals(settingItemBean.getTitle())) {
                        c.f().settings_notifications_sound = z;
                        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_sound, z);
                    } else if (n.this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_vibrate).equals(settingItemBean.getTitle())) {
                        c.f().settings_notifications_vibrate = z;
                        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_vibrate, z);
                    } else if (n.this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_lock_screen).equals(settingItemBean.getTitle())) {
                        n nVar2 = n.this;
                        nVar2.f41444c = z;
                        if (i2 + 1 < nVar2.f41443b.size()) {
                            n.this.notifyItemChanged(i2 + 1);
                        }
                        if (i2 + 2 < n.this.f41443b.size()) {
                            n.this.notifyItemChanged(i2 + 2);
                        }
                        c.f().settings_notifications_lock_screen = z;
                        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen, z);
                    } else if (n.this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_lock_screen_preview).equals(settingItemBean.getTitle())) {
                        c.f().settings_notifications_lock_screen_preview = z;
                        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen_preview, z);
                    } else if (n.this.f41442a.getResources().getString(R.string.chat_module_settings_notifications_lock_screen_name).equals(settingItemBean.getTitle())) {
                        c.f().settings_notifications_lock_screen_name = z;
                        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen_name, z);
                    }
                }
            });
        }
    }

    public n(Context context, List<SettingItemBean> list) {
        this.f41442a = context;
        this.f41443b = list;
        this.f41446e = LayoutInflater.from(context);
    }

    public final int getItemCount() {
        List<SettingItemBean> list = this.f41443b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41453a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41454b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41455c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f41456d;

        /* renamed from: e  reason: collision with root package name */
        Switch f41457e;

        public a(View view) {
            super(view);
            this.f41453a = (ImageView) view.findViewById(R.id.item_settings_iv_title);
            this.f41454b = (TextView) view.findViewById(R.id.item_settings_tv_title);
            this.f41455c = (TextView) view.findViewById(R.id.item_settings_tv_intro);
            this.f41456d = (ImageView) view.findViewById(R.id.item_settings_nav);
            this.f41457e = (Switch) view.findViewById(R.id.item_settings_switch);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.f41445d = false;
        return new a(this.f41446e.inflate(R.layout.chat_item_settings, viewGroup, false));
    }
}
