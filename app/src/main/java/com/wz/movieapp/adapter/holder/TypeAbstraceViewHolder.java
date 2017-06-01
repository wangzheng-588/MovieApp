package com.wz.movieapp.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wz.movieapp.R;


public abstract class TypeAbstraceViewHolder<T> extends RecyclerView.ViewHolder {

    protected ImageView iv_headpic,iv_right_more;
    protected TextView tv_name,tv_time_refresh,tv_video_kind_text,tv_shenhe_ding_number,tv_shenhe_cai_number,tv_posts_number;

    public TypeAbstraceViewHolder(View itemView) {
        super(itemView);
        iv_headpic = (ImageView) itemView.findViewById(R.id.iv_headpic);
        iv_right_more = (ImageView) itemView.findViewById(R.id.iv_right_more);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_time_refresh = (TextView) itemView.findViewById(R.id.tv_time_refresh);
        tv_video_kind_text = (TextView) itemView.findViewById(R.id.tv_video_kind_text);
        tv_shenhe_ding_number = (TextView) itemView.findViewById(R.id.tv_shenhe_ding_number);
        tv_shenhe_cai_number = (TextView) itemView.findViewById(R.id.tv_shenhe_cai_number);
        tv_posts_number = (TextView) itemView.findViewById(R.id.tv_posts_number);
    }

    public abstract void bindHolder(T t);

}
