package com.example.sibu.contactbook.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sibu.contactbook.R;
import com.example.sibu.contactbook.domain.Contact;
import com.example.sibu.contactbook.repository.DataSourceDAO;
import com.example.sibu.contactbook.repository.Impl.DataSourceDAOImpl;
import android.widget.LinearLayout;

/**
 * Created by Sibu on 2014-08-25.
 */
public class Display extends Activity
{


    private DataSourceDAO dao;

    TextView phoneNo,lName, fName, email, address;
    Button btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        dao = new DataSourceDAOImpl(this);
        phoneNo = (TextView) findViewById(R.id.d_cell);
        lName = (TextView) findViewById(R.id.d_lname);
        fName = (TextView) findViewById(R.id.d_fname);
        email = (TextView) findViewById(R.id.d_email);
        address = (TextView) findViewById(R.id.d_address);


        btnShow = (Button) findViewById(R.id.btnView);

        int ContactID = this.getIntent().getExtras().getInt("ContactID");
        Contact contact;

        Log.i("Details view: ", ContactID + "");

        contact = dao.findContactByID(ContactID);

        phoneNo.setText(contact.getCellNo());
        lName.setText(contact.getLastName());
        fName.setText(contact.getFirstName());
        email.setText(contact.getEmail());
        address.setText(contact.getAddress());

        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LinearLayout detail_view = (LinearLayout) findViewById(R.id.detail_view);
                detail_view.setVisibility(View.VISIBLE);
            }
        });



    }
}