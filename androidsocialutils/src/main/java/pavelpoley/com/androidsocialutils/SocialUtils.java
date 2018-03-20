package pavelpoley.com.androidsocialutils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by pavel on 20/03/2018.
 */

public class SocialUtils {

    private static final String TAG = "SocialUtils";

    private static final String GOOGLE_PLAY_URL = "https://play.google.com/store/apps/details?id=";



    public static void shareApp(@NonNull Context context, String text){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        if (text != null){

            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    text
                            +" "
                            +GOOGLE_PLAY_URL
                            +context.getPackageName());

        }else {
            shareApp(context);
            return;
        }

        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }




    public static void shareApp(@NonNull Context context){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out this app at: "
                            + GOOGLE_PLAY_URL
                            + context.getPackageName());

        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }




    public static void rateApp(Context context){

        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + context.getPackageName())));

        } catch (ActivityNotFoundException e){
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }
}
