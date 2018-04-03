package bestapps.sapientassesment2.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import bestapps.sapientassesment2.R;
import bestapps.sapientassesment2.activities.MainFeedActivity;

/**
 * Created by Anil on 4/3/2018.
 * This class displays alert dialog
 */

public class AlertUtil {

    /****
     * Used to display alert dialog
     * @param context : activity context
     * @param msg : message param which is needed to be shown to user
     */
    public static void alert_Msg(final Context context, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("" + msg);
        builder.setCancelable(true);
        builder.setNegativeButton(
                R.string.go_to_settings,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        ((Activity) context).finish();
                    }
                });
        builder.setPositiveButton(
                R.string.close_app,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent();
                        intent.setClass(context, MainFeedActivity.class);
                        ((Activity) context).finish();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}
