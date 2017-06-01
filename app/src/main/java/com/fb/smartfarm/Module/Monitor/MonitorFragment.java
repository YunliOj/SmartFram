package com.fb.smartfarm.Module.Monitor;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fb.smartfarm.R;
import com.fb.smartfarm.UtilsTools.LogUtil;
import com.fb.smartfarm.view.CustomView.MonitorItem;
import com.fb.smartfarm.view.CustomView.MyBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by echo on 2017/4/29.
 */

public class MonitorFragment extends MyBaseFragment implements MonitorDataManager.MonitorListener{
    private final String TAG = MonitorFragment.class.getSimpleName();
    private ScrollView mScrollView;
    private Context mContext;

    private DisplayMetrics dm;
    private PopupWindow popWindow;
    private SelectAdapter moreAdapter;
    private ListView morelist;
    private Button tv;
    private List<String> mainList;
    private ListView mainlist;
    private Button btnPlay;
    private MonitorDataManager dataManager;

    private MonitorItem mTvAirTp;
    private MonitorItem mTvAirHumidity;
    private MonitorItem mTvSoilTp;
    private MonitorItem mTvSoilHumidity;
    private MonitorItem mTvCo2;
    private MonitorItem mTvWind;
    private MonitorItem mTvRainFall;
    private MonitorItem mTvSunshine;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = new MonitorDataManager();
        dataManager.start();
        dataManager.init(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mScrollView = (ScrollView) inflater.inflate(R.layout.layout_fragment_monitor,container,false);
        return mScrollView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        btnPlay = (Button) getActivity().findViewById(R.id.play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"播放",Toast.LENGTH_SHORT).show();
            }
        });
        mTvAirTp = (MonitorItem) getActivity().findViewById(R.id.air_tp);
        mTvAirHumidity = (MonitorItem) getActivity().findViewById(R.id.air_humidity);
        mTvCo2 = (MonitorItem) getActivity().findViewById(R.id.co2);
        mTvSoilTp = (MonitorItem) getActivity().findViewById(R.id.soil_tp);
        mTvSoilHumidity = (MonitorItem) getActivity().findViewById(R.id.soil_humidity);
        mTvWind = (MonitorItem) getActivity().findViewById(R.id.wind);
        mTvRainFall = (MonitorItem) getActivity().findViewById(R.id.rainfall);
        mTvSunshine = (MonitorItem) getActivity().findViewById(R.id.sunshine);

    }

    @Override
    public void monitorDataChange(List<MonitorDataBean> list) {
        MonitorDataBean bean = list.get(49);
        LogUtil.d(TAG,""+bean);
        mTvSoilTp.setText(bean.getSoilTemp());
        mTvSoilHumidity.setText(bean.getSoilHumidity());
        mTvAirTp.setText(bean.getAirTemp());
        mTvAirHumidity.setText(bean.getAirHumidity());
        mTvCo2.setText(bean.getCo2Concentration());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataManager.relace();
    }
}
