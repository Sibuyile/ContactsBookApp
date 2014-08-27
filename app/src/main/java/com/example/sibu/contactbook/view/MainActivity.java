package com.example.sibu.contactbook.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sibu.contactbook.R;
import com.example.sibu.contactbook.domain.Contact;
import com.example.sibu.contactbook.repository.DataSourceDAO;
import com.example.sibu.contactbook.repository.Impl.DataSourceDAOImpl;


public class MainActivity extends Activity {

    private Button btnSave;
    private DataSourceDAO dao;
    EditText cellNo, lname, fname, email, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        cellNo = (EditText) findViewById(R.id.cellNo);
        lname = (EditText) findViewById(R.id.lname);
        fname = (EditText) findViewById(R.id.fname);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);

        dao = new DataSourceDAOImpl(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Save", cellNo.getText().toString());

                Contact contact = new Contact.Builder(cellNo.getText().toString())
                        .setlastName(lname.getText().toString())
                        .setfirstName(fname.getText().toString())
                        .setemail(email.getText().toString())
                        .setaddress(address.getText().toString())
                        .build();

                dao.createContact(contact);

                int size = dao.getCursor();
                contact = dao.findContactByID(size);

                Intent intent = new Intent(getApplicationContext(), Display.class);
                intent.putExtra("ContactID", contact.getId());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


