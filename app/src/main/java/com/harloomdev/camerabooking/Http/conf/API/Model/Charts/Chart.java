
package com.harloomdev.camerabooking.Http.conf.API.Model.Charts;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chart  {

    @SerializedName("recordsets")
    @Expose
    private List<List<Recordset>> recordsets = null;
    @SerializedName("recordset")
    @Expose
    private List<Recordset_> recordset = null;
    @SerializedName("output")
    @Expose
    private Output output;
    @SerializedName("rowsAffected")
    @Expose
    private List<Integer> rowsAffected = null;
    @SerializedName("returnValue")
    @Expose
    private Integer returnValue;
    @SerializedName("total_bayar")
    @Expose
    private Integer totalBayar;
    @SerializedName("total_pajak")
    @Expose
    private Integer totalPajak;

    public Chart(List<List<Recordset>> recordsets, List<Recordset_> recordset, Output output, List<Integer> rowsAffected, Integer returnValue, Integer totalBayar, Integer totalPajak) {
        this.recordsets = recordsets;
        this.recordset = recordset;
        this.output = output;
        this.rowsAffected = rowsAffected;
        this.returnValue = returnValue;
        this.totalBayar = totalBayar;
        this.totalPajak = totalPajak;
    }

    public Chart() {
    }


    public List<List<Recordset>> getRecordsets() {
        return recordsets;
    }

    public void setRecordsets(List<List<Recordset>> recordsets) {
        this.recordsets = recordsets;
    }

    public List<Recordset_> getRecordset() {
        return recordset;
    }

    public void setRecordset(List<Recordset_> recordset) {
        this.recordset = recordset;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public List<Integer> getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(List<Integer> rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public Integer getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Integer returnValue) {
        this.returnValue = returnValue;
    }

    public Integer getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Integer totalBayar) {
        this.totalBayar = totalBayar;
    }

    public Integer getTotalPajak() {
        return totalPajak;
    }

    public void setTotalPajak(Integer totalPajak) {
        this.totalPajak = totalPajak;
    }
}
