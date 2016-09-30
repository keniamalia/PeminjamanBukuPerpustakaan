package id.sch.smktelkom_mlg.tugas01.xiirpl4018.pemijamanbukuperpustakaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel
    EditText etNama;
    EditText etTelepon;
    Button Btnsubmit;
    TextView tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvHasil6, tvHasil7;
    RadioButton rbHr, rbMgg, rbBln;
    CheckBox cbGl, cbPD, cbPG;
    Spinner spBuku, spSubBuku, spTlp;

    String[][] arSubBuku = {{"Matematika", "Bahasa Indonesia", "Bahasa Inggris", "Fisika", "Geografi"},
            {"Hujan", "Surat Kecil Untuk Tuhan", "Sang Pemimpi"},
            {"GAUL", "EKSIS", "GADIS", "BOBO"}};
    ArrayList<String> listBuku = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definisi variabel
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelepon = (EditText) findViewById(R.id.editTextTelepon);
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil6 = (TextView) findViewById(R.id.textViewHasil5);
        tvHasil7 = (TextView) findViewById(R.id.textViewHasil7);
        rbHr = (RadioButton) findViewById(R.id.hr);
        rbMgg = (RadioButton) findViewById(R.id.mgg);
        rbBln = (RadioButton) findViewById(R.id.bln);
        cbGl = (CheckBox) findViewById(R.id.checkBox);
        cbPD = (CheckBox) findViewById(R.id.checkBox2);
        cbPG = (CheckBox) findViewById(R.id.checkBox3);
        spBuku = (Spinner) findViewById(R.id.spinnerBuku);
        spSubBuku = (Spinner) findViewById(R.id.spinnerSubBuku);
        spTlp = (Spinner) findViewById(R.id.spinnerTlp);
        Btnsubmit = (Button) findViewById(R.id.btnsubmit);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listBuku);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSubBuku.setAdapter(adapter);

        spBuku.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listBuku.clear();
                listBuku.addAll(Arrays.asList(arSubBuku[pos]));
                adapter.notifyDataSetChanged();
                spSubBuku.setSelection(0);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //Button Submit
        Btnsubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                doProses();
            }
        });
    }

    //method button submit
    private void doProses() {
        if (isValid()) {
            //edit text
            String nama = etNama.getText().toString();
            String phone = spTlp.getSelectedItem().toString();
            String tlp = etTelepon.getText().toString();
            tvHasil1.setText("\nNama: " + nama);
            tvHasil2.setText("\nNo Telepon: " + phone + " " + tlp);
            }
        String hsl = "\nLainnya: ";
        int startlen = hsl.length();
        if (cbGl.isChecked()) hsl += cbGl.getText() + ", ";
        if (cbPD.isChecked()) hsl += cbPD.getText() + ", ";
        if (cbPG.isChecked()) hsl += cbPG.getText() + ", ";
        if (hsl.length() == startlen) hsl += "Tidak ada pilihan";
        tvHasil6.setText(hsl);
        tvHasil3.setText("\nKategori Buku: " + spBuku.getSelectedItem().toString());
        tvHasil4.setText("\nJudul Buku: " + spSubBuku.getSelectedItem().toString());
        }

    //validasi
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
        }

        if (tlp.isEmpty()) {
            etTelepon.setError("No Telepon harus diisi!");
            valid = false;
        }
        String hasil = null;
        if (rbHr.isChecked()) {
            hasil = rbHr.getText().toString();
            tvHasil7.setText("\nBiaya: Rp. 3000");
        } else if (rbMgg.isChecked()) {
            hasil = rbMgg.getText().toString();
            tvHasil7.setText("\nBiaya: Rp. 5000");
        } else if (rbBln.isChecked()) {
            hasil = rbBln.getText().toString();
            tvHasil7.setText("\nBiaya: Rp. 10000");
        }
        if (hasil == null) {
            tvHasil5.setText("");
        } else {
            tvHasil5.setText("\nLama Pinjam " + hasil);
        }
        return valid;
        }

}
