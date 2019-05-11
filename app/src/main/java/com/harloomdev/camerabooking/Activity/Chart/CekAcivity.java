package com.harloomdev.camerabooking.Activity.Chart;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Adapter.ChartAdpater;
import com.harloomdev.camerabooking.Activity.Adapter.OnChartClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.ServiceAdapter;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.Preferences;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CekAcivity extends AppCompatActivity implements OnChartClickListener, AdapterView.OnItemSelectedListener, ICekView {
    private RecyclerView recyclerView;
    private ChartAdpater chartAdpater;
    private IChartPresenter iChartPresenter;
    private Preferences preferences;
    private Chart chart;
    private String id_service = "";

    //UI Decraltion
    private EditText txtLama;
    private TextView no;
    private TextView txt_totalbayar, txt_ppn;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_acivity);
        iChartPresenter = new ChartPresenter(this, this);
        preferences = new Preferences(this);
        initUI();
        Preferences preferences = new Preferences(this);
        if (preferences.getStatus()) {
            iChartPresenter.getChart(preferences.getIDKTP(), preferences.getKeyAPI());

        } else {
            Toast.makeText(this, "Dih ada Hekel", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void initUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recy_chart);
        spinner = (Spinner) findViewById(R.id.spiner_service);
        no = findViewById(R.id.no_txt);
        txt_totalbayar = findViewById(R.id.txt_totalbayar);
        txt_ppn = findViewById(R.id.ppn_txt);
        txtLama = findViewById(R.id.lama);
        txtLama.setText("1");
        txtLama.addTextChangedListener(textWatcher);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);


    }

    private void initRecyview() {
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        chartAdpater = new ChartAdpater(this, chart, this);
        recyclerView.setAdapter(chartAdpater);
        chartAdpater.notifyDataSetChanged();


    }

    Integer jumlah_awal = 0;

    @Override
    public void onButtonPlush(int position) {
        jumlah_awal = chart.getRecordset().get(position).getJumlahPinjam();
        jumlah_awal += 1;
        chart.getRecordset().get(position).setJumlahPinjam(jumlah_awal);
        chartAdpater.notifyDataSetChanged();
//        chartAdpater.notifyItemRemoved(position);
//        chartAdpater.notifyItemRangeChanged(position,chart.getRecordset().size());
        PutChart data = new PutChart(preferences.getKeyAPI(), preferences.getIDKTP(),
                chart.getRecordset().get(position).getIdKamera(), chart.getRecordset().get(position).getJumlahPinjam().toString(),
                chart.getRecordset().get(position).getId_service());

        if (!txtLama.getText().toString().equals("")) {
            send(data, Integer.parseInt(String.valueOf(txtLama.getText())));

        }else{
            send(data,1);
        }

    }

    @Override
    public void onButtonMinus(int position) {
        jumlah_awal = chart.getRecordset().get(position).getJumlahPinjam();
        jumlah_awal -= 1;
        chart.getRecordset().get(position).setJumlahPinjam(jumlah_awal);
        chartAdpater.notifyDataSetChanged();
//        chartAdpater.notifyItemRemoved(position);
//        chartAdpater.notifyItemRangeChanged(position,chart.getRecordset().size());
        PutChart data = new PutChart(preferences.getKeyAPI(), preferences.getIDKTP(),
                chart.getRecordset().get(position).getIdKamera(), chart.getRecordset().get(position).getJumlahPinjam().toString(),
                chart.getRecordset().get(position).getId_service());
        if (!txtLama.getText().toString().equals("")) {
            send(data, Integer.parseInt(String.valueOf(txtLama.getText())));

        }else{
            send(data,1);
        }
    }

    private void send(final PutChart putChart, final int i) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iChartPresenter.putEdit(putChart, i);
            }
        }, 500);

    }


    @Override
    public void onGetResourceSuccess(Chart charts) {
        chart = charts;
        iChartPresenter.getService();
        initRecyview();
        initDataUI();

    }

    @Override
    public void onGetResourceError(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAPIError(ResponOther error) {
        if(error.getStatusCode() == 404){
            finish();
        }
        Toast.makeText(this, error.getStatusCode() + " : " + error.getMassage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onEditSucces(Chart _chart) {
        chart = _chart;
        initRecyview();
        initDataUI();
//        chartAdpater.notifyItemRemoved(chart.getRecordset().size()-1);


    }

    @Override
    public void onEditRequestError(ResponOther responOther) {
        if(responOther.getStatusCode() == 404){
            finish();
        }
        Toast.makeText(this, responOther.getStatusCode() + " : " + responOther.getMassage(), Toast.LENGTH_SHORT).show();
        txtLama.setText("");
    }

    @Override
    public void onSystemError(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
//        Log.d("BUG DELETE" ,massage);
    }

    @Override
    public void onGetServiceSuccess(List<ServiceChart> serviceChart) {
        ServiceAdapter adapter = new ServiceAdapter(this, serviceChart);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (chart.getRecordset() != null) {
            ServiceChart serviceChart = (ServiceChart) parent.getSelectedItem();
            setDataService(serviceChart.getIdService());
            Toast.makeText(this, serviceChart.getNamaPelayanan(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setDataService(String id_service) {
        for (int i = 0; i < chart.getRecordset().size(); i++) {
            chart.getRecordset().get(i).setId_service(id_service);
            PutChart data = new PutChart(preferences.getKeyAPI(), preferences.getIDKTP(),
                    chart.getRecordset().get(i).getIdKamera(), chart.getRecordset().get(i).getJumlahPinjam().toString(),
                    chart.getRecordset().get(i).getId_service());
            send(data, Integer.parseInt(String.valueOf(txtLama.getText())));
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initDataUI() {
        no.setText(preferences.getIDKTP());
        txt_totalbayar.setText("RP. " + chart.getTotalBayar());
        txt_ppn.setText("Rp. " + chart.getTotalPajak());
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            PutChart data = new PutChart(preferences.getKeyAPI(), preferences.getIDKTP(),
                    chart.getRecordset().get(0).getIdKamera(), chart.getRecordset().get(0).getJumlahPinjam().toString(),
                    chart.getRecordset().get(0).getId_service());
            if (!TextUtils.isEmpty(s)) {
                send(data, Integer.parseInt(String.valueOf(s)));
            }


        }
    };
}
