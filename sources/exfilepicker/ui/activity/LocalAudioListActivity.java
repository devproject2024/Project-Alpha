package exfilepicker.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.a;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.android.chat.R;
import com.paytm.android.chat.c;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.RxViewUtils;
import com.paytm.utility.q;
import exfilepicker.ui.adapter.AudioListAdapter;
import io.reactivex.rxjava3.d.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;

public class LocalAudioListActivity extends PaytmActivity {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f46152b = LocalAudioListActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f46153g = {"_id", "_data", "_size", "_display_name", "title", "date_added", "date_modified", "mime_type", "title_key", AppConstants.DURATION, "bookmark", "artist_id", "artist", "artist_key", "album_id", "album", "album_key", "track", "year", "is_music", "is_podcast", "is_ringtone", "is_alarm", "is_notification"};

    /* renamed from: a  reason: collision with root package name */
    Handler f46154a = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private SearchView.SearchAutoComplete f46155c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public SearchView f46156d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<AudioListAdapter.AudioInfo> f46157e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AudioListAdapter f46158f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View f46159h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f46160i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_local_audio_list);
        this.f46159h = findViewById(R.id.empty_view);
        setSupportActionBar((Toolbar) findViewById(R.id.top_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
        }
        this.f46160i = (RecyclerView) findViewById(R.id.lv_local_audio_list);
        this.f46160i.setLayoutManager(new LinearLayoutManager(this));
        this.f46158f = new AudioListAdapter(this.f46157e, this);
        this.f46160i.setAdapter(this.f46158f);
        AudioListAdapter audioListAdapter = this.f46158f;
        audioListAdapter.f46174c.add(new AudioListAdapter.b() {
            public final void a(ArrayList arrayList) {
                LocalAudioListActivity localAudioListActivity = LocalAudioListActivity.this;
                int i2 = 0;
                boolean z = arrayList.size() > 0;
                View findViewById = localAudioListActivity.findViewById(R.id.button_send);
                if (!z) {
                    i2 = 8;
                }
                findViewById.setVisibility(i2);
            }
        });
        findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra("extra_result_audio_path", LocalAudioListActivity.this.f46158f.f46173b);
                    LocalAudioListActivity.this.setResult(-1, intent);
                    LocalAudioListActivity.this.finish();
                }
            }
        });
        RxViewUtils.setOnClickListeners(this.f46160i, new g<View>() {
            public final /* bridge */ /* synthetic */ void accept(Object obj) throws Throwable {
            }
        });
    }

    public void onStart() {
        super.onStart();
        if (b.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            a.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
            return;
        }
        List<AudioListAdapter.AudioInfo> list = this.f46157e;
        if (!(list == null || this.f46158f == null)) {
            list.clear();
            this.f46158f.notifyDataSetChanged();
        }
        c();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu_home, menu);
        MenuItem findItem = menu.findItem(R.id.action_search);
        findItem.setVisible(false);
        this.f46156d = (SearchView) findItem.getActionView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.top_toolbar);
        this.f46156d.setMaxWidth(toolbar.getWidth() - toolbar.getChildAt(2).getLayoutParams().width);
        ImageView imageView = (ImageView) this.f46156d.findViewById(androidx.appcompat.R.id.search_close_btn);
        imageView.setImageResource(R.drawable.chat_ic_search);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        ((ImageView) this.f46156d.findViewById(androidx.appcompat.R.id.search_button)).setImageResource(R.drawable.chat_ic_toolbar_search);
        this.f46156d.findViewById(androidx.appcompat.R.id.search_edit_frame).setBackgroundResource(R.drawable.chat_search_view);
        this.f46156d.findViewById(androidx.appcompat.R.id.search_plate).setBackgroundColor(0);
        this.f46155c = (SearchView.SearchAutoComplete) this.f46156d.findViewById(androidx.appcompat.R.id.search_src_text);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.f46155c, Integer.valueOf(R.drawable.chat_search_view_cursor));
        } catch (Exception unused) {
        }
        this.f46155c.setTextSize(2, 14.0f);
        this.f46155c.setHint("");
        this.f46156d.setOnQueryTextListener(new SearchView.b() {
            public final boolean a(String str) {
                c(str);
                LocalAudioListActivity.this.f46156d.clearFocus();
                return true;
            }

            public final boolean b(String str) {
                c(str);
                return true;
            }

            private void c(String str) {
                q.a(String.valueOf(str));
                LocalAudioListActivity.this.f46158f.b();
                LocalAudioListActivity.this.f46158f.a(str);
                if (LocalAudioListActivity.this.f46158f.getItemCount() == 0) {
                    LocalAudioListActivity.this.f46160i.setVisibility(8);
                    LocalAudioListActivity.this.f46159h.setVisibility(0);
                    return;
                }
                LocalAudioListActivity.this.f46160i.setVisibility(0);
                LocalAudioListActivity.this.f46159h.setVisibility(8);
            }
        });
        this.f46156d.setOnSearchClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    LocalAudioListActivity localAudioListActivity = LocalAudioListActivity.this;
                    SearchView b2 = localAudioListActivity.f46156d;
                    int width = (b2.getWidth() - ((localAudioListActivity.getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_button_min_width_material) * 1) - (localAudioListActivity.getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_button_min_width_material) / 2))) - localAudioListActivity.getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_button_min_width_overflow_material);
                    int height = b2.getHeight() / 2;
                    b2.setVisibility(0);
                    if (Build.VERSION.SDK_INT >= 21) {
                        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(b2, width, height, 0.0f, (float) width);
                        createCircularReveal.setDuration(220);
                        createCircularReveal.addListener(new AnimatorListenerAdapter(b2) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ boolean f46167a = true;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ View f46168b;

                            {
                                this.f46168b = r2;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                if (!this.f46167a) {
                                    super.onAnimationEnd(animator);
                                    this.f46168b.setVisibility(4);
                                }
                            }
                        });
                        createCircularReveal.start();
                    }
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            boolean z = false;
            if (getCurrentFocus() != null) {
                z = ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
            if (z) {
                this.f46155c.clearFocus();
                return true;
            }
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        c.e();
        super.onPause();
        this.f46158f.f46175d.c();
    }

    public void onDestroy() {
        c.e();
        super.onDestroy();
        this.f46158f.f46175d.b();
    }

    public void onResume() {
        super.onResume();
        c.a(this);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                finish();
            } else {
                c();
                this.f46158f.notifyDataSetChanged();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private void c() {
        new Thread(new Runnable() {
            public final void run() {
                Cursor query = LocalAudioListActivity.this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, LocalAudioListActivity.f46153g, (String) null, (String[]) null, (String) null);
                if (query != null && query.moveToFirst()) {
                    do {
                        AudioListAdapter.AudioInfo audioInfo = new AudioListAdapter.AudioInfo(query, LocalAudioListActivity.this);
                        String unused = LocalAudioListActivity.f46152b;
                        new StringBuilder("audioInfo = ").append(audioInfo.toString());
                        q.b();
                        LocalAudioListActivity.this.f46157e.add(audioInfo);
                    } while (query.moveToNext());
                    query.close();
                }
                LocalAudioListActivity.this.f46154a.post(new Runnable() {
                    public final void run() {
                        if (LocalAudioListActivity.this.f46157e == null || LocalAudioListActivity.this.f46157e.size() <= 0) {
                            LocalAudioListActivity.this.f46159h.setVisibility(0);
                        } else {
                            LocalAudioListActivity.this.f46158f.notifyDataSetChanged();
                        }
                    }
                });
            }
        }).start();
    }
}
