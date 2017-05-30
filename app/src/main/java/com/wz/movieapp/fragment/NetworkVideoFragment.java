package com.wz.movieapp.fragment;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.wz.movieapp.APPNetApi;
import com.wz.movieapp.R;
import com.wz.movieapp.adapter.NetVideoAdapter;
import com.wz.movieapp.bean.NetAllBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;



public class NetworkVideoFragment extends BaseFragment {

    private ParserTask mParserTask;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private NetVideoAdapter mAdapter;

    @Override
    protected int setLayoutRes() {
        return R.layout.network_video;
    }

    @Override
    protected void init() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getForNetData();
        mAdapter = new NetVideoAdapter(getActivity());
    }


    private void getForNetData() {

        RequestParams params = new RequestParams(APPNetApi.SERVICES_HOST_1);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                executeParserTask(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void executeParserTask(String res) {
        cancelParserTask();
        mParserTask = new ParserTask(res);
        mParserTask.execute();
    }

    private void cancelParserTask() {
        if (mParserTask != null) {
            mParserTask.cancel(true);
            mParserTask = null;
        }
    }

    private class ParserTask extends AsyncTask<Void,Void,String> {
        private String reponseRes;
        private List list;
        public ParserTask(String res) {
            reponseRes = res;
        }

        @Override
        protected String doInBackground(Void... params) {
            list = parseData(reponseRes);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            executeOnLoadDataSuccess(list);
        }
    }

    private void executeOnLoadDataSuccess(List list) {



        if (mAdapter!=null){
            mRecyclerView.setAdapter(mAdapter);
        }

        if (list!=null){
            mAdapter.addList(list);
            mAdapter.notifyDataSetChanged();
        }
    }

    private List parseData(String reponseRes) {
        Gson gson = new Gson();
        NetAllBean netAllBean = gson.fromJson(reponseRes, NetAllBean.class);
        List<NetAllBean.ListEntity> list = netAllBean.getList();
        return list;
    }
}
