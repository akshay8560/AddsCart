package com.as2developers.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmPickupActivity extends AppCompatActivity {

    private LinearLayout linearLayout_back_process;
    private EditText ed_note;
    private TextView txt_Cancel,txt_itemPickup,txt_pickUpdate,txt_confirm,scarpItem_txt,change_scrap,chane_Adddress,change_pickup,
    txt_homeAddress,txt_Address,txt_pickupTime,txt_btn_proceed;
    private View fragment_location;
    private ImageButton image_back_process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pickup);
        image_back_process=findViewById(R.id.back_process);
        linearLayout_back_process=findViewById(R.id.layout_back_process);

        txt_Cancel=findViewById(R.id.txt_cancel);
        txt_itemPickup=findViewById(R.id.text_itemPickup);
        txt_pickUpdate=findViewById(R.id.txt_pickupDate);
        txt_confirm=findViewById(R.id.txt_confirm);
        scarpItem_txt=findViewById(R.id.scarpitem_text);
        change_scrap=findViewById(R.id.change_scrapItem);
        change_pickup=findViewById(R.id.change_pickup);
        chane_Adddress=findViewById(R.id.change_address);
        txt_homeAddress=findViewById(R.id.txt_homeAddress);
        txt_Address=findViewById(R.id.txt_Address);
        txt_pickupTime=findViewById(R.id.txt_pichup_time);

        fragment_location=findViewById(R.id.location_fragment);
        ed_note=findViewById(R.id.ed_note);
        txt_btn_proceed=findViewById(R.id.btn_proceed);

    }
}