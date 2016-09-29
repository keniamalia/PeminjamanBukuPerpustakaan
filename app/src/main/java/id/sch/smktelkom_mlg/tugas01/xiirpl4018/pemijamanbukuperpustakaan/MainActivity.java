package id.sch.smktelkom_mlg.tugas01.xiirpl4018.pemijamanbukuperpustakaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTelepon;
    Button Btnsubmit;
    TextView tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvHasil6, tvHasil7;
    RadioButton rbPr, rbLK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelepon = (EditText) findViewById(R.id.editTextTelepon);
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil6 = (TextView) findViewById(R.id.textViewHasil5);
        tvHasil7 = (TextView) findViewById(R.id.textViewHasil6);
        rbPr = (RadioButton) findViewById(R.id.pr);
        rbLK = (RadioButton) findViewById(R.id.lk);
        Btnsubmit = (Button) findViewById(R.id.btnsubmit);

        Btnsubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                doProses();
                doClick();

            }
        });
    }

    private void doClick() {
        //radiobutton


    }

    private void doProses() {
        if (isValid()) {
            //edit text
            String nama = etNama.getText().toString();
            int tlp = Integer.parseInt(etTelepon.getText().toString());
            tvHasil1.setText("Nama: " + nama);
            tvHasil2.setText("No Telepon: " + tlp);
        }

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tlp = etTelepon.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama harus diisi!");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter!");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tlp.isEmpty()) {
            etTelepon.setError("No Telepon harus diisi!");
            valid = false;
        } else {
            etTelepon.setError(null);
        }
        String hasil = null;
        if (rbPr.isChecked()) {
            hasil = rbPr.getText().toString();
        } else if (rbLK.isChecked()) {
            hasil = rbLK.getText().toString();
        }
        if (hasil == null) {
            tvHasil3.setText("LKJHGF");
        } else {
            tvHasil3.setText("Jenis Kelamin: " + hasil);
        }

        return valid;
    }

}
