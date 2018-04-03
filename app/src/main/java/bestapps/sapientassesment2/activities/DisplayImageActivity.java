package bestapps.sapientassesment2.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import bestapps.sapientassesment2.R;
import bestapps.sapientassesment2.utility.AlertUtil;
import bestapps.sapientassesment2.utility.Utility;

/**
 * Created by Anil on 4/3/2018.
 * this Activity displays the image from the URL extracted from json feed
 */

public class DisplayImageActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_url_activity);
        if (!Utility.CheckInternet(DisplayImageActivity.this)) {
            AlertUtil.alert_Msg(DisplayImageActivity.this, getResources().getString(R.string.network_error));
        }
        Bundle bundle = this.getIntent().getExtras();
        String receive_URL = bundle.getString(getString(R.string.ImageUrl));
        ImageView imageView = (ImageView) findViewById(R.id.image_By_URL);
        try {
            Glide.with(getApplicationContext()).load(receive_URL)
                    .error(R.drawable.placeholder)
                    .placeholder(R.layout.progress_animation)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.exit)
                .setMessage(R.string.exit_confirm_message)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }
}