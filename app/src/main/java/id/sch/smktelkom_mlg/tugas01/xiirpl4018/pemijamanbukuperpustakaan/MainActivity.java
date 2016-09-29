package id.sch.smktelkom_mlg.tugas01.xiirpl4018.pemijamanbukuperpustakaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTelepon;
    Button Btnsubmit;
        TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelepon = (EditText) findViewById(R.id.editTextTelepon);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        Btnsubmit = (Button) findViewById(R.id.btnsubmit);

        Btnsubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                doProses();

            }
        });
    }

    private void doProses() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tlp = Integer.parseInt(etTelepon.getText().toString());
            tvHasil.setText("Nama: " + nama + "\n" + "No Telepon: " + tlp);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        //String tlp = etTelepon.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama harus diisi!");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

}
