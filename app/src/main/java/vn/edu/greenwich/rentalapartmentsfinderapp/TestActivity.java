package vn.edu.greenwich.rentalapartmentsfinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView tvPropertyName = findViewById(R.id.tvPropertyName_Test);
        TextView tvPropertyAddress = findViewById(R.id.tvPropertyAddress_Test);
        TextView tvPropertyType = findViewById(R.id.tvPropertyType_Test);
        TextView tvFunitureType = findViewById(R.id.tvFurnitureType_Test);
        TextView tvNOB = findViewById(R.id.tvNOB_Test);
        TextView tvMonthlyPrice = findViewById(R.id.tvMonthlyPrice_Test);
        TextView tvReporter = findViewById(R.id.tvReporter_Test);
        TextView tvNote = findViewById(R.id.tvNote_Test);

        String propertyName = "", propertyAddress = "", propertyType = "", furnitureType="", NOB="", monthlyPrice="", reporter="", note="";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            propertyName = bundle.getString("propertyName");
            propertyAddress = bundle.getString("propertyAddress");
            propertyType = bundle.getString("propertyType");
            furnitureType = bundle.getString("furnitureType");
            NOB = bundle.getString("NOB");
            monthlyPrice = bundle.getString("monthlyPrice");
            reporter = bundle.getString("reporter");
            note = bundle.getString("note");
        }

        tvPropertyName.setText(propertyName);
        tvPropertyAddress.setText(propertyAddress);
        tvPropertyType.setText(propertyType);
        tvFunitureType.setText(furnitureType);
        tvNOB.setText(NOB);
        tvMonthlyPrice.setText(monthlyPrice);
        tvReporter.setText(reporter);
        tvNote.setText(note);
    }
}