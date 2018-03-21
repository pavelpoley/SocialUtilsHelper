package pavelpoley.com.socialutilshelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pavelpoley.com.androidsocialutils.SocialUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btShare,btRate,btSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShare = findViewById(R.id.bt_share);
        btRate = findViewById(R.id.bt_rate);
        btSendEmail = findViewById(R.id.bt_send_email);

        btShare.setOnClickListener(this);
        btRate.setOnClickListener(this);
        btSendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_share:
                SocialUtils.shareApp(this);
                break;

            case R.id.bt_rate:
                SocialUtils.rateApp(this);
                break;

            case R.id.bt_send_email:
                SocialUtils.sendEmail(this,"pavelpoley88@gmail.com","Feedback");
                break;
        }
    }
}
