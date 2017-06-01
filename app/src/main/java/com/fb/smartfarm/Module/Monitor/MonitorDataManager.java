package com.fb.smartfarm.Module.Monitor;

import android.os.Handler;
import android.os.Message;

import com.fb.smartfarm.UtilsTools.LogUtil;
import com.solidfire.gson.Gson;
import com.solidfire.gson.JsonArray;
import com.solidfire.gson.JsonElement;
import com.solidfire.gson.JsonObject;
import com.solidfire.gson.JsonParser;
import com.solidfire.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by echo on 2017/6/1.
 */

public class MonitorDataManager {

    private final String TAG = MonitorDataManager.class.getSimpleName();
    private final String URL = "http://www.agriculture4.com/resCenter/agrTerminalData/getAgrTerminalDataListJson.do?agrTerminalId=3";
    private List<MonitorDataBean> list;
    private MonitorListener mListener;

    private static final int DELAY_GET_MONITOR_INFO = 2 * 60 * 1000;
    private static final int MSG_GET = 100;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LogUtil.d(TAG, "do get");
            doGet();
            mHandler.sendEmptyMessageDelayed(MSG_GET, DELAY_GET_MONITOR_INFO);
        }
    };


    public void start() {
        mHandler.sendEmptyMessage(MSG_GET);
    }

    private void doGet() {
        OkHttpUtils.get().url(URL).addParams("co2Concentration", "123").build().connTimeOut(10000).execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtil.d(TAG, "get data fail");
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.d(TAG, "get data succ :: " + response.toString());
               parseResponse(response);
            }
        });
    }

    private void parseResponse(String response) {
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(response).getAsJsonObject().getAsJsonObject("result");
        JsonArray array = obj.getAsJsonArray("item");
        LogUtil.d(TAG,""+array.size());
        Gson gson=new Gson();
        list=new ArrayList();
        Type type = (Type) new TypeToken<MonitorDataBean>() {}.getType();
        for(int i = 0;i<array.size();i++){
            JsonElement j=array.get(i);
            MonitorDataBean bean = gson.fromJson(j,type);
            list.add(bean);
        }

        for(int i = 0;i<list.size();i++){
            LogUtil.d(TAG,"i :: "+i+" - "+list.get(i));
        }
        mListener.monitorDataChange(list);
    }

    public List<MonitorDataBean> getMonitorDataList(){
        return list;
    }

    public interface MonitorListener{
         void monitorDataChange(List<MonitorDataBean> list);
    }

    public void init(MonitorListener listener){
        this.mListener = listener;
    }

    public void relace(){
        mListener = null;
    }

}