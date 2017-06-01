package com.wz.movieapp.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wz.movieapp.R;
import com.wz.movieapp.bean.NetAllBean;

import java.util.List;

public class TextTypeHolder extends TypeAbstraceViewHolder<NetAllBean.ListEntity> {

    private TextView tv_context;
    private Context mContext;

    public TextTypeHolder(Context context,View itemView) {
        super(itemView);
        mContext = context;
        tv_context = (TextView) itemView.findViewById(R.id.tv_context);
    }

    @Override
    public void bindHolder(NetAllBean.ListEntity listEntity) {
        tv_context.setText(listEntity.getText());


        //设置公共部分
        Glide.with(mContext).load(listEntity.getU().getHeader().get(0)).into(iv_headpic);

        tv_name.setText(listEntity.getU().getName());
        tv_time_refresh.setText(listEntity.getPasstime());
        List<NetAllBean.ListEntity.TagsEntity> tags = listEntity.getTags();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<tags.size();i++){
            sb.append(tags.get(i).getName()+" ");
        }
        tv_video_kind_text.setText(sb.toString());
        tv_shenhe_ding_number.setText(listEntity.getUp());
        tv_shenhe_cai_number.setText(String.valueOf(listEntity.getDown()));
        tv_posts_number.setText(String.valueOf(listEntity.getForward()));
    }
}
