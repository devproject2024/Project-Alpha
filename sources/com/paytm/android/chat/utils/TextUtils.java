package com.paytm.android.chat.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.paytm.utility.q;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.SendBird;
import com.sendbird.android.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class TextUtils {
    public static String toTitleCase(String str) {
        char c2;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c3 : str.toCharArray()) {
            if (z) {
                c2 = Character.toUpperCase(c3);
            } else {
                c2 = Character.toLowerCase(c3);
            }
            sb.append(c2);
            z = " '-/".indexOf(c2) >= 0;
        }
        return sb.toString();
    }

    public static String getGroupChannelTitle(BaseChannel baseChannel) {
        GroupChannel groupChannel = baseChannel instanceof GroupChannel ? (GroupChannel) baseChannel : null;
        if (groupChannel == null) {
            return "";
        }
        List<Member> members = groupChannel.getMembers();
        if (members.size() < 2 || SendBird.getCurrentUser() == null) {
            return "";
        }
        if (members.size() == 2) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Member next : members) {
                if (!next.getUserId().equals(SendBird.getCurrentUser().getUserId())) {
                    stringBuffer.append(", " + next.getNickname());
                }
            }
            return stringBuffer.delete(0, 2).toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        int i2 = 0;
        for (User next2 : members) {
            if (!next2.getUserId().equals(SendBird.getCurrentUser().getUserId())) {
                i2++;
                stringBuffer2.append(", " + next2.getNickname());
                if (i2 >= 10) {
                    break;
                }
            }
        }
        return stringBuffer2.delete(0, 2).toString();
    }

    public static String generateMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : digest) {
            stringBuffer.append(Integer.toHexString(b2 & 255));
        }
        return stringBuffer.toString();
    }

    public static void copyText(Context context, String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            q.b("copyText  context == null || StringUtil.isNotEmpty(value, true) == false >> return;");
            return;
        }
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", str));
    }
}
