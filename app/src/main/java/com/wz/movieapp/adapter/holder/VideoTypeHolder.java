package com.wz.movieapp.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wz.movieapp.R;
import com.wz.movieapp.Utils;
import com.wz.movieapp.bean.NetAllBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoTypeHolder extends TypeAbstraceViewHolder<NetAllBean.ListEntity> {

   private TextView tv_context,tv_play_nums,tv_video_duration,tv_commant_context;
    private ImageView iv_commant;
    private JCVideoPlayerStandard jcv_videoplayer;
    private final Utils mUtils;
    private Context mContext;


    public VideoTypeHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        tv_context = (TextView) itemView.findViewById(R.id.tv_context);
        tv_play_nums = (TextView) itemView.findViewById(R.id.tv_play_nums);
        tv_video_duration = (TextView) itemView.findViewById(R.id.tv_video_duration);
        tv_commant_context = (TextView) itemView.findViewById(R.id.tv_commant_context);
        iv_commant = (ImageView) itemView.findViewById(R.id.iv_commant);
        jcv_videoplayer = (JCVideoPlayerStandard) itemView.findViewById(R.id.jcv_videoplayer);
        mUtils = new Utils();
    }

    @Override
    public void bindHolder(NetAllBean.ListEntity listEntity) {
        tv_context.setText(listEntity.getText());
        //System.out.println("视频连接是："+listEntity.getVideo().getVideo().get(0));
       // System.out.println("jc:"+jcv_videoplayer);
       //jcv_videoplayer.setUp(listEntity.getVideo().getVideo().get(0),JCVideoPlayer.SCREEN_WINDOW_FULLSCREEN,"");
        jcv_videoplayer.setUp(listEntity.getVideo().getVideo().get(0),JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, "嫂子闭眼睛");
        tv_play_nums.setText(listEntity.getVideo().getPlaycount()+"次播放");
        tv_video_duration.setText(mUtils.stringForTime(listEntity.getVideo().getDuration()*1000));

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
