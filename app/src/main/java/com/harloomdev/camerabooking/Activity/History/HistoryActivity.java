package com.harloomdev.camerabooking.Activity.History;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Adapter.AdapterHistory.HistoryAdapter;
import com.harloomdev.camerabooking.Activity.Adapter.AdapterHistory.OnHistoryrClickListener;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.Preferences;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements  IHistoryView , OnHistoryrClickListener {
    private HistoryPresenter mPresenter;
    private Preferences preferences;
    private HistoryAdapter adapter;
    private RecyclerView mRecyclerView;

    private List<History> list  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.recy_history);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("History");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        preferences = new Preferences(this);
        mPresenter = new HistoryPresenter(this,this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getDataAPI(preferences.getKeyAPI(),preferences.getIDKTP());
    }

    @Override
    public boolean onSupportNavigateUp() {
       onBackPressed();
       return true;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private  void initRecyview(){
        LinearLayoutManager manager = new LinearLayoutManager(this );
        mRecyclerView.setLayoutManager(manager);
        adapter = new HistoryAdapter(this,list,this);
        mRecyclerView.setAdapter(adapter);



    }

    @Override
    public void OnAPISuccess(List<History> mList) {
        list.addAll(mList);
        initRecyview();

    }

    @Override
    public void OnAPIFailed(ResponOther respon) {
        Toast.makeText(this, "Error : "+respon.getStatusCode() + " "+respon.getMassage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnSystemErrors(String massage) {
        Toast.makeText(this, "ErrorSystem : " + massage, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void foldingTutup(int position, FoldingCell foldingCell) {
        foldingCell.toggle(false);
    }
}
