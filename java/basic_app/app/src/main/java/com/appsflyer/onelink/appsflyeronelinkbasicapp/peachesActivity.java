package com.appsflyer.onelink.appsflyeronelinkbasicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

import static com.appsflyer.onelink.appsflyeronelinkbasicapp.AppsflyerBasicApp.LOG_TAG;

public class peachesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peaches);

        Intent intent = getIntent();
        HashMap<String, String> dlAttrMap = (HashMap<String, String>) intent.getSerializableExtra(AppsflyerBasicApp.DL_ATTRS);
        if (dlAttrMap != null) {
            TextView dlAttrsText = findViewById(R.id.peaches_deeplinkparams);
            String dlAttrStrings = "";
            for (String attrName : dlAttrMap.keySet()) {
                String deepLinkAttrStr = attrName + " = " + dlAttrMap.get(attrName) + "\n";
                dlAttrStrings += deepLinkAttrStr;
            }
            dlAttrsText.setText(dlAttrStrings);
        } else {
            TextView dlTitleText = findViewById(R.id.peaches_deeplinktitle);
            dlTitleText.setText("No Deep Linking Happened");
        }

    }
}
