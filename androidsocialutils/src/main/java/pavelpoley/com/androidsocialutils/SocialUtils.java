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


    /**
     * Share app
     * @param context the context
     * @param text text to attach to the shared link
     * */

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



    /**
     * Share app
     * @param context the context
     * */

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



    /**
     * Rate app open Google play store, if the store not installed it will be opened in browser
     * @param context the context
     * */

    public static void rateApp(Context context){

        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + context.getPackageName())));

        } catch (ActivityNotFoundException e){
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }


    /**
     * Send Email
     * @param context the context
     * @param mailTo the receiver
     * @param subject subject message that will appear in Email dialog
     * */

    public static void sendEmail(@NonNull Context context,@NonNull String mailTo,@NonNull String subject){

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", mailTo, null));

        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        context.startActivity(Intent.createChooser(intent, "Send email..."));
    }


    /**
     * Send SMS
     * @param context the context
     * @param message message that will intend to be sent as sms body
     * */

    public static void sendSMS(@NonNull Context context,@NonNull String message)
    {
        Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address","");
        smsIntent.putExtra("sms_body",message);
        context.startActivity(smsIntent);
    }

    /**
     * Send SMS
     * @param context the context
     * @param number number of the recipient
     * @param message message that will intend to be sent as sms body
     * */

    public static void sendSMS(@NonNull Context context,@NonNull String number,@NonNull String message)
    {
        Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address",number);
        smsIntent.putExtra("sms_body",message);
        context.startActivity(smsIntent);
    }

    /**
     * Like Facebook page
     * @param context the context
     * @param id facebook page id
     * */

    public static void likeFacebookPage(Context context, String id) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse(id));
        context.startActivity(fbIntent);
    }
}
