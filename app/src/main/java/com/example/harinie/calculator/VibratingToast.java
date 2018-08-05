package com.example.harinie.calculator;

import android.content.Context;
import android.os.Vibrator;
import android.widget.Toast;

public class VibratingToast extends Toast {

    public VibratingToast(Context context, CharSequence text, int duration) {
        super(context);
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(150);
        }
        super.makeText(context, text, duration).show();
    }
}
