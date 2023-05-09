package com.example.my_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class doctors_details extends AppCompatActivity {
    private String [][] PHYSICIAN = {
            {"Name : Dr. Sameer Dhudhadra ","Address : MD Health Center ","Experience : 5 Years ","Fees : Rs. 2500"},
            {"Name : Dr. Nalin Joshi ","Address : Central Park Teaching Hospital ","Experience : 7 Years ","Fees : Rs. 2500"},
            {"Name : Dr. Chetna Chauhan ","Address : MD Health Center ","Experience : 5 Years ","Fees : Rs. 2500"},
            {"Name : Dr. Smit Budhdev ","Address : MD Health Center ","Experience : 3 Years ","Fees : Rs. 2500"},
            {"Name : Dr. Bilkis Virani ","Address : Reactive Physio ","Experience : 5 Years ","Fees : Rs. 1000"},
            {"Name : Miss. Sital Vala ","Address : PhysioFitt Hospital ","Experience : 3 Years ","Fees : Rs. 2000"}
    };
    private String [][] DENTIST= {
            {"Name : Dr. Tisha Patel ","Address : JA Aesthetics Dental Skin and Hair  ","Experience : 2 Years ","Fees : Rs. 2000"},
            {"Name : Dr. Maunil Nayak ","Address : JA Aesthetics Dental Skin and Hair ","Experience : 4 Years ","Fees : Rs. 2000"},
            {"Name : Dr. Tejas Gandhi ","Address : Teeth and Gums - Best Veneers ","Experience : 4 Years ","Fees : Rs. 1000"},
            {"Name : Dr. Viral Shah","Address : Reliance Dental Care ","Experience : 12 Years ","Fees : Rs. 1800"},
            {"Name : Dr. Hiral Patel ","Address : Dental Care Clinic ","Experience : 27 Years ","Fees : Rs. 500"},
            {"Name : Dr. Tapan Shah ","Address : Fatima Bai Hospital ","Experience : 1 Year ","Fees : Rs. 620"}
    };
    private String [][] SURGEON= {
            {"Name : Dr. Dharmik Patel ","Address : Saleem Memorial Trust Hospital ","Experience : 38 Years ","Fees : Rs. 3000"},
            {"Name : Dr. Swapnil Shah","Address : Liaquat National Hospital ","Experience : 7 Years ","Fees : Rs. 1500"},
            {"Name : Dr. Pankaj Dubey","Address : Plasthetics ","Experience : 18 Years ","Fees : Rs. 2000"},
            {"Name : Prof. Dr. Chirag Desai ","Address : Hill Park General Hospita ","Experience : 33 Years ","Fees : Rs. 1000"},
            {"Name : Dr. Tejas Thakkar ","Address : Advanced International Hospital ","Experience : 15 Years ","Fees : Rs. 2000"},
            {"Name : Dr. Dhruv Suthar","Address : Sir Syed Hospital ","Experience : 20 Years ","Fees : Rs. 1000"}
    };
    private String [][] DIETITIAN= {
            {"Name : Ms. Rashmik Shah ","Address : Omar Hospital & Cardiac Centre ","Experience : 13 Years ","Fees : Rs. 2500"},
            {"Name : Ms. Nitin Dubey ","Address : South City Hospital ","Experience : 14 Years ","Fees : Rs. 2500"},
            {"Name : Ms. Mehwish Idrees ","Address : Evon Aesthetic Center ","Experience : 7 Years ","Fees : Rs. 2000"},
            {"Name : Dr. Saira Salman ","Address : Quick Care Clinic ","Experience : 25 Years ","Fees : Rs. 2500"},
            {"Name : Ms. Hemang Zala ","Address : Karachi Medical Complex ","Experience : 2 Years ","Fees : Rs. 2500"},
            {"Name : Dr. Uswa Chaudhry","Address : Beautiholics Clinic ","Experience : 8 Years ","Fees : Rs. 1500"} } ;

    private String [][] CARDIOLOGIST={
            {"Name : Dr. Meenu Shah ","Address : Noor General Hospital ","Experience : 12 Years ","Fees : Rs. 1800"},
            {"Name : Dr. Naina Patel","Address : Capital International Hospital ","Experience : 12 Years ","Fees : Rs. 1500"},
            {"Name : Dr. Tapan Jardosh ","Address : Neuface Skin and Medical Center ","Experience : 7 Years ","Fees : Rs. 1500"},
            {"Name : Dr. Rupa Rupsariya ","Address : HM Diagnostic Center  ","Experience : 25Years ","Fees : Rs. 2000"},
            {"Name : Dr. Pulin Shah ","Address : Smart Medical and Diagnostic ","Experience : 7 Years ","Fees : Rs. 2000"},
            {"Name : Assist. Prof. Dr. Farhan Faisal","Address : Al Safiya Medical and Diagnostic ","Experience : 18 Years ","Fees : Rs. 1500"}
    };

    TextView doctext;
    ListView docdetails;
    Button backtomydoc;
    String [][] doc_details= {};
    ArrayList list;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_details);
        doctext=findViewById(R.id.lab);
        docdetails=findViewById(R.id.cartdetails);
        backtomydoc=findViewById(R.id.backtomain);

        Intent it = getIntent();
        String title= it.getStringExtra("title");
        doctext.setText(title);

        if(title.compareTo("PHYSICIAN") == 0){
            doc_details = PHYSICIAN ;
        }
        if(title.compareTo("DENTIST") == 0){
            doc_details = DENTIST ;
        }
        if(title.compareTo("SURGEON") == 0){
            doc_details = SURGEON ;
        }
        if(title.compareTo("DIETITIAN") == 0){
            doc_details = DIETITIAN ;
        }
        if(title.compareTo("CARDIOLOGIST") == 0){
            doc_details = CARDIOLOGIST ;
        }
        

        backtomydoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctors_details.this,findmydoc.class));
            }
        });
        list = new ArrayList();
        for(int i = 0 ; i < doc_details.length;i++){
            item = new HashMap<String, String>();
            item.put("docname",doc_details[i][0]);
            item.put("docaddress",doc_details[i][1]);
            item.put("docexperience",doc_details[i][2]);
            item.put("docfees",doc_details[i][3]+" only");
            list.add(item);
        }
        SimpleAdapter adap = new SimpleAdapter(
                this,list,
                R.layout.detaildesign,
                new String[]{"docname","docaddress","docexperience","docfees"},
                new int[]{R.id.t_name, R.id.t_price,
                R.id.docexperience, R.id.docfees});
        docdetails.setAdapter(adap);
        docdetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(doctors_details.this,booking.class);
                intent.putExtra("docname",doc_details[i][0]);
                intent.putExtra("docaddress",doc_details[i][1]);
                intent.putExtra("docfees",doc_details[i][3]+" only");

                startActivity(intent);
            }
        });}


}