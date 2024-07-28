package com.zhihu.matisse.internal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import c.a.a.c;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.ChatOneButtonDialog;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.view.CircleProgressBar;
import com.paytm.utility.q;
import com.zhihu.matisse.a.a;
import com.zhihu.matisse.internal.c.e;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import java.io.File;
import net.one97.paytm.i.h;

public class b extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.zhihu.matisse.d.b f45835a;

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public static b a(Item item) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("args_item", item);
        bVar.setArguments(bundle);
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.chat_fragment_preview_item, viewGroup, false);
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Item item = (Item) getArguments().getParcelable("args_item");
        ImageViewTouch imageViewTouch = (ImageViewTouch) view.findViewById(R.id.image_view);
        if (item != null) {
            final String str = item.f45768f;
            if (str != null && !str.isEmpty()) {
                final String str2 = item.f45769g;
                final String str3 = item.f45770h;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_group_chat_down_button);
                final CircleProgressBar circleProgressBar = (CircleProgressBar) view.findViewById(R.id.circle_progress);
                final a aVar = new a();
                frameLayout.setVisibility(0);
                final Item item2 = item;
                final ImageViewTouch imageViewTouch2 = imageViewTouch;
                final FrameLayout frameLayout2 = frameLayout;
                frameLayout.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (!b.a(b.this.getContext())) {
                            final ChatOneButtonDialog chatOneButtonDialog = new ChatOneButtonDialog(b.this.getActivity());
                            chatOneButtonDialog.hideTitle();
                            chatOneButtonDialog.setMessage(b.this.getResources().getString(R.string.chat_module_no_internet));
                            chatOneButtonDialog.setButton(-3, b.this.getResources().getString(R.string.chat_module_button_ok), new View.OnClickListener() {
                                public final void onClick(View view) {
                                    chatOneButtonDialog.dismiss();
                                }
                            });
                            chatOneButtonDialog.show();
                        } else if (!FastClickUtil.isFastClick()) {
                        } else {
                            if (aVar.f45720f) {
                                Toast.makeText(b.this.getContext(), b.this.getContext().getResources().getString(R.string.chat_module_downloading), 0).show();
                                return;
                            }
                            aVar.f45720f = true;
                            c a2 = c.a();
                            String str = str;
                            String str2 = str2;
                            a2.a(str, str2, str3 + ".temp", new c.a() {
                                public final void a(final File file) {
                                    q.a("down success====1" + file.getAbsolutePath());
                                    b.this.getActivity().runOnUiThread(new Runnable() {
                                        public final void run() {
                                            Toast.makeText(b.this.getContext(), b.this.getContext().getResources().getString(R.string.chat_module_download_successful), 0).show();
                                        }
                                    });
                                    if (file.exists() && b.this.getContext() != null && b.this.getActivity() != null) {
                                        b.this.getActivity().runOnUiThread(new Runnable() {
                                            public final void run() {
                                                Intent intent;
                                                String absolutePath = file.getAbsolutePath();
                                                String substring = absolutePath.substring(0, absolutePath.length() - 5);
                                                file.renameTo(new File(substring));
                                                item2.f45765c = Uri.fromFile(new File(substring));
                                                item2.f45768f = null;
                                                b.this.a(imageViewTouch2, item2.f45765c, Boolean.valueOf(com.zhihu.matisse.b.isGif(item2.f45764b)));
                                                frameLayout2.setVisibility(8);
                                                if (b.this.getContext() != null) {
                                                    try {
                                                        MediaStore.Images.Media.insertImage(b.this.getContext().getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                                                    } catch (Exception unused) {
                                                        if (Build.VERSION.SDK_INT >= 19) {
                                                            MediaScannerConnection.scanFile(b.this.getContext(), new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                                                            return;
                                                        }
                                                        if (file.isDirectory()) {
                                                            intent = new Intent("android.intent.action.MEDIA_MOUNTED");
                                                            intent.setClassName("com.android.providers.media", "com.android.providers.media.MediaScannerReceiver");
                                                            intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
                                                        } else {
                                                            intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                                            intent.setData(Uri.fromFile(file));
                                                        }
                                                        b.this.getContext().sendBroadcast(intent);
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }

                                public final void a(int i2) {
                                    if (circleProgressBar != null) {
                                        circleProgressBar.setProgress(i2);
                                    }
                                }

                                public final void a() {
                                    String absolutePath = new File(Environment.getExternalStorageDirectory(), str2).getAbsolutePath();
                                    File file = new File(absolutePath, str3 + ".temp");
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    if (b.this.getActivity() != null) {
                                        aVar.f45720f = false;
                                        circleProgressBar.setProgress(0);
                                        b.this.getActivity().runOnUiThread(new Runnable() {
                                            public final void run() {
                                                Toast.makeText(b.this.getContext(), b.this.getContext().getResources().getString(R.string.chat_module_download_failed), 0).show();
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                });
            }
            a(imageViewTouch, item.f45765c, Boolean.valueOf(com.zhihu.matisse.b.isGif(item.f45764b)));
        }
    }

    public final void a(ImageViewTouch imageViewTouch, Uri uri, Boolean bool) {
        imageViewTouch.setDisplayType(ImageViewTouchBase.a.FIT_TO_SCREEN);
        imageViewTouch.setSingleTapListener(new ImageViewTouch.c() {
            public final void a() {
                if (b.this.f45835a != null) {
                    b.this.f45835a.a();
                }
            }
        });
        Point a2 = e.a(uri, (Activity) getActivity());
        if (bool.booleanValue()) {
            c.a.f45787a.p.b(getContext(), a2.x, a2.y, (ImageView) imageViewTouch, uri);
        } else {
            c.a.f45787a.p.a(getContext(), a2.x, a2.y, (ImageView) imageViewTouch, uri);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.zhihu.matisse.d.b) {
            this.f45835a = (com.zhihu.matisse.d.b) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f45835a = null;
    }
}
