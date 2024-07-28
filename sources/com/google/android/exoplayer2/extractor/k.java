package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f32142c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f32143a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f32144b = -1;

    private boolean a(String str) {
        Matcher matcher = f32142c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f32143a = parseInt;
            this.f32144b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean a() {
        return (this.f32143a == -1 || this.f32144b == -1) ? false : true;
    }

    public final boolean a(Metadata metadata) {
        for (Metadata.Entry entry : metadata.f32644a) {
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.f32696b) && a(commentFrame.f32697c)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.f32703a) && "iTunSMPB".equals(internalFrame.f32704b) && a(internalFrame.f32705c)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
