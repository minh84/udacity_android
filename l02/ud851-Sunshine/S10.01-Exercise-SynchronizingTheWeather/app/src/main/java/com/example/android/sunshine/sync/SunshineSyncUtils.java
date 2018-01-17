package com.example.android.sunshine.sync;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

// Done (9) Create a class called SunshineSyncUtils
    //  Done (10) Create a public static void method called startImmediateSync
    //  Done (11) Within that method, start the SunshineSyncIntentService
public class SunshineSyncUtils {
    public static void startImmediateSync(Context context) {
        // create an intent to start the sync service
        Intent intent = new Intent(context, SunshineSyncIntentService.class);

        // start the service (i.e run the work in other thread)
        context.startService(intent);
    }
}