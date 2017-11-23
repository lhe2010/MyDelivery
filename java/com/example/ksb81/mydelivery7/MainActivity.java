package com.example.ksb81.mydelivery7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adspin;
    boolean initSpinner;
    EditText name,num;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        num = (EditText)findViewById(R.id.num);

        //스피너 생성,strings에 택배사 목록 있음
        spinner = (Spinner)findViewById(R.id.myspinner);
//        spinner.setPrompt("택배사 선택");

        adspin = ArrayAdapter.createFromResource(this, R.array.company,android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
				// 스피너의 초기화 선택지('택배사 선택') 선택 제외
				if (initSpinner == false) {
					initSpinner = true;
					return;
				}
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//        String[] company ={"cj대한통운","한진택배","롯데택배","우체국택배","로젠택배","KGB택배","일양로지스","EMS","DHL","FedEx"};
    }

    public void onButton(View view) {
        String str_company = spinner.getSelectedItem().toString();
        Intent activity1 = new Intent(this, Main1Activity.class);

        activity1.putExtra("postname",name.getText().toString());
        activity1.putExtra("postnum",num.getText().toString());
        activity1.putExtra("postcompany",str_company);
        startActivity(activity1);
    }
}
