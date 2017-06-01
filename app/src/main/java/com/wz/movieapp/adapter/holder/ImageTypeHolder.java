package com.wz.movieapp.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wz.movieapp.PhotoActivity;
import com.wz.movieapp.R;
import com.wz.movieapp.bean.NetAllBean;

import java.util.List;


public class ImageTypeHolder extends TypeAbstraceViewHolder<NetAllBean.ListEntity> {

    private ImageView iv_image_icon;
    private TextView tv_context;
    private Context mContext;
    public ImageTypeHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        iv_image_icon = (ImageView) itemView.findViewById(R.id.iv_image_icon);
        tv_context = (TextView) itemView.findViewById(R.id.tv_context);
    }

    @Override
    public void bindHolder(final NetAllBean.ListEntity listEntity) {
        tv_context.setText(listEntity.getText());
        Glide.with(mContext).load(listEntity.getImage().getThumbnail_small().get(0)).into(iv_image_icon);

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

        iv_image_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoActivity.class);
                intent.putExtra("imageUrl",listEntity.getImage().getThumbnail_small().get(0));
                mContext.startActivity(intent);
            }
        });
    }

}
