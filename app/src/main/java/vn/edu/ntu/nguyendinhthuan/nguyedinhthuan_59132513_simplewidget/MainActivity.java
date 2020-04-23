package vn.edu.ntu.nguyendinhthuan.nguyedinhthuan_59132513_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtKQ;
    EditText editSoA, editSoB;
    RadioGroup radioGroupPhepTinh;
    Button btnKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }
    private void addViews()
    {
        txtKQ = findViewById(R.id.txtKQ);
        editSoA = findViewById(R.id.editSoA);
        editSoB = findViewById(R.id.editSoB);
        radioGroupPhepTinh = findViewById(R.id.radioGroupPhepTinh);
        btnKetQua = findViewById(R.id.btnKetQua);
    }
    private void addEvents()
    {
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan();
            }
        });
    }
    private void tinhToan()
    {
        float soA = Float.parseFloat(editSoA.getText().toString());
        float soB = Float.parseFloat(editSoB.getText().toString());
        float kq;
        switch (radioGroupPhepTinh.getCheckedRadioButtonId())
        {
            case R.id.radioCong:
                 kq = soA + soB;
                txtKQ.setText(new Float(kq).toString());
                break;
            case R.id.radioTru:
                 kq = soA - soB;
                txtKQ.setText(new Float(kq).toString());
                break;
            case R.id.radioNhan:
                 kq = soA * soB;
                txtKQ.setText(new Float(kq).toString());
                break;
            case R.id.radioChia:
                try {
                    kq = soA / soB;
                    txtKQ.setText(new Float(kq).toString());
                }
                catch (Exception ex)
                {
                    txtKQ.setText("Lỗi chia cho 0");
                }
                break;
        }
    }
}
