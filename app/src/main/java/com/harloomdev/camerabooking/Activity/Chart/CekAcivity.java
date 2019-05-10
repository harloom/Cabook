package com.harloomdev.camerabooking.Activity.Chart;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class CekAcivity extends AppCompatActivity implements OnChartClickListener ,AdapterView.OnItemSelectedListener, ICekView {
    private RecyclerView recyclerView ;
    private ChartAdpater chartAdpater ;
    private IChartPresenter iChartPresenter ;
    private Preferences preferences;
    private Chart chart  ;
    private String id_service = "";

    //UI Decraltion
    private TextView no;
    private TextView txt_totalbayar , txt_ppn;
    private Spinner spinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_acivity);
        iChartPresenter = new ChartPresenter(this,this);
        preferences = new Preferences(this);
        initUI();
//        initRecyview();

        Preferences preferences = new Preferences(this);
        if(preferences.getStatus()){
            iChartPresenter.getChart(preferences.getIDKTP(),preferences.getKeyAPI());

        }else{
            Toast.makeText(this, "Dih ada Hekel", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void initUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recy_chart) ;
        spinner = (Spinner) findViewById(R.id.spiner_service);

        no = findViewById(R.id.no_txt);
        txt_totalbayar =  findViewById(R.id.txt_totalbayar);
        txt_ppn = findViewById(R.id.ppn_txt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);


    }

//    private void getData(){
//        Recordset_ recordset1 = new Recordset_("1232131312312","C0001","Cannon",100000,1,"unit",R.drawable.image1,"Ilham",100000);
//        Recordset_ recordset2 = new Recordset_("1232131312312","C0002","Cannon 1",200000,1,"unit",R.drawable.image1,"Ilham",200000);
//        ArrayList<Recordset_> recordsets = new ArrayList<>();
//        recordsets.add(recordset1);
//        recordsets.add(recordset2);
//         chart = new Chart(null,recordsets,null,null,0,300000);
//
//    }

    private void initRecyview(){
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        chartAdpater = new ChartAdpater(this,chart,this);
        recyclerView.setAdapter(chartAdpater);


    }
    Integer jumlah_awal = 0 ;
    @Override
    public void onButtonPlush(int position) {
        jumlah_awal  = chart.getRecordset().get(position).getJumlahPinjam();
        jumlah_awal += 1;
        chart.getRecordset().get(position).setJumlahPinjam(jumlah_awal);
        chartAdpater.notifyDataSetChanged();
        PutChart data  = new PutChart(preferences.getKeyAPI(),preferences.getIDKTP(),
                chart.getRecordset().get(position).getIdKamera(),chart.getRecordset().get(position).getJumlahPinjam().toString(),
                chart.getRecordset().get(position).getId_service());
            send(data);

    }

    @Override
    public void onButtonMinus(int position) {
        jumlah_awal  = chart.getRecordset().get(position).getJumlahPinjam();
        jumlah_awal -= 1;
        chart.getRecordset().get(position).setJumlahPinjam(jumlah_awal);
        chartAdpater.notifyDataSetChanged();
        PutChart data  = new PutChart(preferences.getKeyAPI(),preferences.getIDKTP(),
                chart.getRecordset().get(position).getIdKamera(),chart.getRecordset().get(position).getJumlahPinjam().toString(),
                chart.getRecordset().get(position).getId_service());
        send(data);
    }
    private void send (final PutChart putChart){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iChartPresenter.putEdit(putChart);
            }
        },500);

    }



    @Override
    public void onGetResourceSuccess(Chart charts) {
        chart  = charts;
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
        Toast.makeText(this, error.getStatusCode() + " : " + error.getMassage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onEditSucces(Chart _chart) {
        chart = _chart;
        initRecyview();
        initDataUI();


    }

    @Override
    public void onEditRequestError(ResponOther responOther) {
        Toast.makeText(this, responOther.getStatusCode() + " : " + responOther.getMassage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSystemError(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetServiceSuccess(List<ServiceChart> serviceChart) {
        ServiceAdapter adapter = new ServiceAdapter(this,serviceChart);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(chart.getRecordset()!=null){
            ServiceChart serviceChart = (ServiceChart) parent.getSelectedItem();
            setDataService(serviceChart.getIdService());
            Toast.makeText(this, serviceChart.getNamaPelayanan(), Toast.LENGTH_SHORT).show();
        }



    }

    private void setDataService(String id_service){
        for(int i  = 0 ;i<chart.getRecordset().size();i++){
            chart.getRecordset().get(i).setId_service(id_service);
            PutChart data =  new PutChart(preferences.getKeyAPI(),preferences.getIDKTP(),
                    chart.getRecordset().get(i).getIdKamera(),chart.getRecordset().get(i).getJumlahPinjam().toString(),
                    chart.getRecordset().get(i).getId_service());
            send(data);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initDataUI(){
        no.setText(preferences.getIDKTP());
        txt_totalbayar.setText("RP. " + chart.getTotalBayar());
        txt_ppn.setText("Rp. " +  chart.getTotalPajak());
    }


}
