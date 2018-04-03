package bestapps.sapientassesment2.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import bestapps.sapientassesment2.R;

/**
 * Created by Anil on 4/3/2018.
 * This Class Stores General purpose methods / utilities
 */

public class Utility {

    /**
     * Check the Internet Connection
     * @param context : activity context
     * @return : return current state of internet connection in phone returns true/false
     */
    public static Boolean CheckInternet(final Context context) {
        ConnectivityManager cn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cn.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
