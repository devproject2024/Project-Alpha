package com.travel.train.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import java.util.Iterator;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private Intent f27447a;

    /* renamed from: b  reason: collision with root package name */
    public SpeechRecognizer f27448b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f27449c = "VoiceRecognition";

    /* renamed from: d  reason: collision with root package name */
    private RecognitionListener f27450d = new RecognitionListener() {
        public final void onBeginningOfSpeech() {
        }

        public final void onBufferReceived(byte[] bArr) {
        }

        public final void onEndOfSpeech() {
        }

        public final void onError(int i2) {
        }

        public final void onEvent(int i2, Bundle bundle) {
        }

        public final void onPartialResults(Bundle bundle) {
        }

        public final void onReadyForSpeech(Bundle bundle) {
        }

        public final void onRmsChanged(float f2) {
            q.this.a(f2);
        }

        public final void onResults(Bundle bundle) {
            Iterator<String> it2 = bundle.getStringArrayList("results_recognition").iterator();
            if (it2.hasNext()) {
                q.this.a(it2.next());
            }
        }
    };

    public abstract void a(float f2);

    public abstract void a(String str);

    public q(Context context) {
        this.f27448b = SpeechRecognizer.createSpeechRecognizer(context);
        new StringBuilder("isRecognitionAvailable: ").append(SpeechRecognizer.isRecognitionAvailable(context));
        this.f27448b.setRecognitionListener(this.f27450d);
        this.f27447a = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f27447a.putExtra("android.speech.extra.LANGUAGE_PREFERENCE", "en");
        this.f27447a.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        this.f27447a.putExtra("android.speech.extra.MAX_RESULTS", 3);
    }

    public final void a() {
        this.f27448b.startListening(this.f27447a);
    }
}
