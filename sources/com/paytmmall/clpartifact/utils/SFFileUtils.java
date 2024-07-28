package com.paytmmall.clpartifact.utils;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class SFFileUtils {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final HashMap<String, String> readFile(Context context, String str, String str2) {
            k.c(context, "context");
            k.c(str, "filenName");
            k.c(str2, "childPath");
            Utils.assertBackgroundThread();
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(context.getDir(str, 0), str2)));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject != null) {
                    return (HashMap) readObject;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
            } catch (IOException e2) {
                e2.printStackTrace();
                return new HashMap<>();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
                return new HashMap<>();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                return new HashMap<>();
            }
        }
    }
}
