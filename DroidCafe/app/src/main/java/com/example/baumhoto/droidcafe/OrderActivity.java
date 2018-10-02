package com.example.baumhoto.droidcafe;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void onRadioButtonClicked(View view) {
        // is the red button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // check which radio buttion was clicked
        switch (view.getId()) {
            case R.id.sameday:
                if(checked)
                    // same day delivery
                    displayToast(getString(R.string.same_day_messenger));
                break;
            case R.id.nextday:
                if(checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if(checked)
                    // pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // do nothing
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
