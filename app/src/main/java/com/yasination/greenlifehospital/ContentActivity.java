package com.yasination.greenlifehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContentActivity extends AppCompatActivity {
    public  static String doctorName = "";
    public  static String doctorSubject = "";
    public  static String doctorAppointment = "";

    TextView tvName,tvSubject;
    Button btnAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        tvName = findViewById(R.id.tvName);
        tvSubject = findViewById(R.id.tvSubject);
        btnAppointment = findViewById(R.id.btnAppointment);

        tvName.setText(doctorName);
        tvSubject.setText(doctorSubject);

        btnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = doctorAppointment;


                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));


                if (dialIntent.resolveActivity(getPackageManager()) != null) {
                    // Start the dialer activity
                    startActivity(dialIntent);
                    Toast.makeText(ContentActivity.this, "Connecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ContentActivity.this, "Call: "+phoneNumber, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}