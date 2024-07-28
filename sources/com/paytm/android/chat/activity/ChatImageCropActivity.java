package com.paytm.android.chat.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FileUtils;
import com.paytm.android.chat.utils.imagecropper.Callbacks;
import com.paytm.android.chat.utils.imagecropper.CropImageView;
import com.paytm.utility.q;
import com.zhihu.matisse.internal.entity.Item;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.activity.PaytmActivity;

public final class ChatImageCropActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f41588a;

    public final View a(int i2) {
        if (this.f41588a == null) {
            this.f41588a = new HashMap();
        }
        View view = (View) this.f41588a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41588a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_image_crop);
        ((FrameLayout) a(R.id.back_button_crop_activity_flt)).setOnClickListener(new c(this));
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("item") : null;
        if (!(obj instanceof Item)) {
            obj = null;
        }
        Item item = (Item) obj;
        if (item != null) {
            ((CropImageView) a(R.id.crop_view_iv)).load(item.f45765c).execute(new b(item, this));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatImageCropActivity f41594a;

        c(ChatImageCropActivity chatImageCropActivity) {
            this.f41594a = chatImageCropActivity;
        }

        public final void onClick(View view) {
            this.f41594a.finish();
        }
    }

    public static final class b implements Callbacks.LoadCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Item f41592a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatImageCropActivity f41593b;

        b(Item item, ChatImageCropActivity chatImageCropActivity) {
            this.f41592a = item;
            this.f41593b = chatImageCropActivity;
        }

        public final void onSuccess() {
            ((FrameLayout) this.f41593b.a(R.id.crop_cta_btn_flt)).setOnClickListener(new a(this.f41593b, this.f41592a));
        }

        public final void onError(Throwable th) {
            Toast.makeText(this.f41593b, "An error occurred. Try again or try cropping with a different image.", 0).show();
            this.f41593b.finish();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatImageCropActivity f41589a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Item f41590b;

        a(ChatImageCropActivity chatImageCropActivity, Item item) {
            this.f41589a = chatImageCropActivity;
            this.f41590b = item;
        }

        public final void onClick(View view) {
            ProgressBar progressBar = (ProgressBar) this.f41589a.a(R.id.crop_progress_bar);
            k.a((Object) progressBar, "crop_progress_bar");
            progressBar.setVisibility(0);
            ((CropImageView) this.f41589a.a(R.id.crop_view_iv)).crop(this.f41590b.f45765c).execute(new Callbacks.CropCallback(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f41591a;

                {
                    this.f41591a = r1;
                }

                public final void onSuccess(Bitmap bitmap) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new C0692a(this, bitmap, (kotlin.d.d) null), 3, (Object) null);
                }

                public final void onError(Throwable th) {
                    Toast.makeText(this.f41591a.f41589a, "An error occurred. Try again or try cropping with a different image.", 0).show();
                    this.f41591a.f41589a.finish();
                }

                @kotlin.d.b.a.f(b = "ChatImageCropActivity.kt", c = {60}, d = "invokeSuspend", e = "com.paytm.android.chat.activity.ChatImageCropActivity$handleCroppedImage$1$1$onSuccess$1")
                /* renamed from: com.paytm.android.chat.activity.ChatImageCropActivity$a$1$a  reason: collision with other inner class name */
                static final class C0692a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                    final /* synthetic */ Bitmap $cropped;
                    Object L$0;
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ AnonymousClass1 this$0;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0692a(AnonymousClass1 r1, Bitmap bitmap, kotlin.d.d dVar) {
                        super(2, dVar);
                        this.this$0 = r1;
                        this.$cropped = bitmap;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        C0692a aVar = new C0692a(this.this$0, this.$cropped, dVar);
                        aVar.p$ = (CoroutineScope) obj;
                        return aVar;
                    }

                    public final Object invoke(Object obj, Object obj2) {
                        return ((C0692a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                        int i2 = this.label;
                        if (i2 == 0) {
                            ResultKt.a(obj);
                            CoroutineScope coroutineScope = this.p$;
                            if (this.$cropped != null) {
                                Item item = this.this$0.f41591a.f41590b;
                                Bitmap bitmap = this.$cropped;
                                this.L$0 = coroutineScope;
                                this.label = 1;
                                if (ChatImageCropActivity.a(item, bitmap, this) == aVar) {
                                    return aVar;
                                }
                            }
                            return x.f47997a;
                        } else if (i2 == 1) {
                            ResultKt.a(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ChatImageCropActivity.b(this.this$0.f41591a.f41589a, this.this$0.f41591a.f41590b);
                        return x.f47997a;
                    }
                }
            });
        }
    }

    static /* synthetic */ Object a(Item item, Bitmap bitmap, kotlin.d.d<? super x> dVar) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new d(bitmap, item, (kotlin.d.d) null), dVar);
        return withContext == kotlin.d.a.a.COROUTINE_SUSPENDED ? withContext : x.f47997a;
    }

    @kotlin.d.b.a.f(b = "ChatImageCropActivity.kt", c = {}, d = "invokeSuspend", e = "com.paytm.android.chat.activity.ChatImageCropActivity$saveImageToStorage$2")
    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Item $item;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Bitmap bitmap, Item item, kotlin.d.d dVar) {
            super(2, dVar);
            this.$bitmap = bitmap;
            this.$item = item;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.$bitmap, this.$item, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                try {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    File file = new File(FileUtils.getAbsCameraPath(), valueOf);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    Bitmap bitmap = this.$bitmap;
                    if (bitmap != null) {
                        Boolean.valueOf(bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream));
                    }
                    this.$item.a();
                    this.$item.a(Uri.fromFile(file));
                    this.$item.a(valueOf);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception unused) {
                    q.a();
                }
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final /* synthetic */ void b(ChatImageCropActivity chatImageCropActivity, Item item) {
        Intent intent = new Intent();
        intent.putExtra("cropped_image", item);
        chatImageCropActivity.setResult(22, intent);
        chatImageCropActivity.finish();
    }
}
