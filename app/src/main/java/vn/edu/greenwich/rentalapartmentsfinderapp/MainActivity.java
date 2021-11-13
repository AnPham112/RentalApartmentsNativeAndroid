package vn.edu.greenwich.rentalapartmentsfinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String btnCreateName = getResources().getString(R.string.btn_create_name);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setText(btnCreateName);
        btnLogin.setOnClickListener(btnLogin_Click);

        Spinner spinnerPropertyType = findViewById(R.id.spinner_propertyType);
        List<String> propertyTypes = new ArrayList<>();
        propertyTypes.add(0,"Select property type");
        propertyTypes.add(getResources().getString(R.string.type_apartment));
        propertyTypes.add(getResources().getString(R.string.type_house));
        propertyTypes.add(getResources().getString(R.string.type_penthouse));
        propertyTypes.add(getResources().getString(R.string.type_villa));

        ArrayAdapter<String> propertyTypeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, propertyTypes);
        propertyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPropertyType.setAdapter(propertyTypeAdapter);


        Spinner spinnerFurnitureType = findViewById(R.id.spinner_furnitureType);
        List<String> furnitureTypes = new ArrayList<>();
        furnitureTypes.add(0,"Select furniture type");
        furnitureTypes.add(getResources().getString(R.string.type_unfurnished));
        furnitureTypes.add(getResources().getString(R.string.type_halfFurnished));
        furnitureTypes.add(getResources().getString(R.string.type_furnished));

        ArrayAdapter<String> furnitureTypeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, furnitureTypes);
        furnitureTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFurnitureType.setAdapter(furnitureTypeAdapter);
    }

    private View.OnClickListener btnLogin_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean isValid = true;

            TextView tvError = findViewById(R.id.tvError);
            TextView tvPropertyName = findViewById(R.id.tvPropertyName);
            TextView tvPropertyAddress = findViewById(R.id.tvPropertyAddress);
            Spinner spinnerPropertyType = findViewById(R.id.spinner_propertyType);
            Spinner spinnerFurnitureType = findViewById(R.id.spinner_furnitureType);
            TextView tvNOB = findViewById(R.id.tvNOB);
            TextView tvMonthlyPrice = findViewById(R.id.tvMonthlyPrice);
            TextView tvReporter = findViewById(R.id.tvReporter);
            TextView tvNote = findViewById(R.id.tvNote);

            String error = "";
            String propertyName = tvPropertyName.getText().toString();
            String propertyAddress = tvPropertyAddress.getText().toString();
            String propertyType = spinnerPropertyType.getSelectedItem().toString();
            String furnitureType = spinnerFurnitureType.getSelectedItem().toString();
            String NOB = tvNOB.getText().toString();
            String monthlyPrice = tvMonthlyPrice.getText().toString();
            String reporter = tvReporter.getText().toString();
            String note = tvNote.getText().toString();

            String propertyNameRequired = getResources().getString(R.string.propertyName_required);
            String propertyAddressRequired = getResources().getString(R.string.propertyAddress_required);
            String propertyTypeRequired = getResources().getString(R.string.propertyType_required);
            String NOBRequired = getResources().getString(R.string.NOB_required);
            String monthlyPriceRequired = getResources().getString(R.string.monthlyPrice_required);
            String reporterRequired = getResources().getString(R.string.reporter_required);


            if(TextUtils.isEmpty(propertyName)) {
                isValid = false;
                error += propertyNameRequired + "\n";
            }
            if(TextUtils.isEmpty(propertyAddress)) {
                isValid = false;
                error += propertyAddressRequired + "\n";
            }
            if(spinnerPropertyType.getSelectedItem().toString().trim().equals("Select property type")) {
                isValid = false;
                error += propertyTypeRequired + "\n";
            }
            if(TextUtils.isEmpty(NOB)) {
                isValid = false;
                error += NOBRequired + "\n";
            }
            if(TextUtils.isEmpty(monthlyPrice)) {
                isValid = false;
                error += monthlyPriceRequired + "\n";
            }
            if(TextUtils.isEmpty(reporter)) {
                isValid = false;
                error += reporterRequired;
            }

            if(isValid) {
                Bundle accountInfo = new Bundle();

                accountInfo.putString("propertyName", propertyName);
                accountInfo.putString("propertyAddress", propertyAddress);
                accountInfo.putString("propertyType", propertyType);
                accountInfo.putString("furnitureType", furnitureType);
                accountInfo.putString("NOB", NOB);
                accountInfo.putString("monthlyPrice", monthlyPrice);
                accountInfo.putString("reporter", reporter);
                accountInfo.putString("note", note);

                Intent testActivity = new Intent(v.getContext(), TestActivity.class);

                testActivity.putExtras(accountInfo);

                startActivity(testActivity);
                finish();
            } else {
                tvError.setText(error);
            }
        }
    };
}