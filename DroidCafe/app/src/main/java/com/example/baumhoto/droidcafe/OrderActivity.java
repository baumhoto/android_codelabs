package com.example.baumhoto.droidcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements OnItemSelectedListener {

    private String spinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        // Create the spinner
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        // is the red button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // check which radio buttion was clicked
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // same day delivery
                    displayToast(getString(R.string.same_day_messenger));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
