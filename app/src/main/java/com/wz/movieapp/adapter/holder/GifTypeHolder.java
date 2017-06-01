package com.wz.movieapp.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felipecsl.gifimageview.library.GifImageView;
import com.wz.movieapp.R;
import com.wz.movieapp.bean.NetAllBean;


public class GifTypeHolder extends TypeAbstraceViewHolder<NetAllBean.ListEntity> {

    private TextView tv_context;
    private Context mContext;
    private GifImageView iv_image_gif;

    public GifTypeHolder(Context context,View itemView) {
        super(itemView);
        mContext = context;
        tv_context = (TextView) itemView.findViewById(R.id.tv_context);
        iv_image_gif = (GifImageView) itemView.findViewById(R.id.iv_image_gif);
    }

    @Override
    public void bindHolder(NetAllBean.ListEntity listEntity) {
        tv_context.setText(listEntity.getText());
        Glide.with(mContext).asGif().load(listEntity.getGif().getImages().get(0)).into(iv_image_gif);
        System.out.println("gif图片地址是："+listEntity.getGif().getImages().get(0));
        //Picasso.with(mContext).load(listEntity.getGif().getImages().get(0)).into(iv_image_gif);

    }
}
