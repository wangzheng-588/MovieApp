package com.wz.movieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wz.movieapp.APPNetApi;
import com.wz.movieapp.R;
import com.wz.movieapp.adapter.holder.ADTypeHolder;
import com.wz.movieapp.adapter.holder.GifTypeHolder;
import com.wz.movieapp.adapter.holder.ImageTypeHolder;
import com.wz.movieapp.adapter.holder.TextTypeHolder;
import com.wz.movieapp.adapter.holder.TypeAbstraceViewHolder;
import com.wz.movieapp.adapter.holder.VideoTypeHolder;
import com.wz.movieapp.bean.NetAllBean;

import java.util.ArrayList;
import java.util.List;


public class NetVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<NetAllBean.ListEntity> mList;
    private Context mContext;
    public NetVideoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = new ArrayList<>();
        mContext = context;
    }


    public void addList(List<NetAllBean.ListEntity> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case APPNetApi.TYPE_VIDEO:
                return new VideoTypeHolder(mContext,mLayoutInflater.inflate(R.layout.all_video_item,parent,false));
            case APPNetApi.TYPE_IMAGE:
                return new ImageTypeHolder(mContext,mLayoutInflater.inflate(R.layout.all_image_item,parent,false));
            case APPNetApi.TYPE_TEXT:
                return new TextTypeHolder(mContext,mLayoutInflater.inflate(R.layout.all_text_item,parent,false));
            case APPNetApi.TYPE_GIF:
                return new GifTypeHolder(mContext,mLayoutInflater.inflate(R.layout.all_gif_item,parent,false));
            case APPNetApi.TYPE_AD:
                return new ADTypeHolder(mLayoutInflater.inflate(R.layout.all_ad_item,parent,false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        ((TypeAbstraceViewHolder)holder).bindHolder(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        String  type = mList.get(position).getType();
        int typeInt ;
        switch (type){
            case "video":
                typeInt = 0;
                break;
            case "image":
                typeInt = 1;
                break;
            case "text":
                typeInt = 2;
                break;
            case "gif":
                typeInt = 3;
                break;
            default:
                typeInt = 4;
                break;
        }
        return typeInt;
    }


}
