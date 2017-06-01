package com.wz.movieapp.adapter.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CommonViewHolder {

	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	
	CommonViewHolder(Context context, int layoutID, int position, View convertView, ViewGroup parent){
		this.mViews = new SparseArray<View>();
		this.mPosition = position;
		this.mConvertView = LayoutInflater.from(context).inflate(layoutID, parent, false);
		this.mConvertView.setTag(this);
	}
	
	public static CommonViewHolder getViewHolder(Context context, int layoutID, int position, 
			View convertView, ViewGroup parent){
		if(convertView==null) {
			CommonViewHolder viewHolder = new CommonViewHolder(context, layoutID, position, convertView, parent);
			return viewHolder;
		} else {
			CommonViewHolder viewHolder = (CommonViewHolder) convertView.getTag();
			viewHolder.mPosition = position;
			return viewHolder;
		}
	}

	public View getConvertView() {
		return this.mConvertView;
	}
	
	public <T extends View>T getView(int viewID){
		View view = mViews.get(viewID);
		
		if(view==null){
			view = getConvertView().findViewById(viewID);
			mViews.put(viewID, view);
		}
		
		return (T)view;
	}
	
	public CommonViewHolder setTextView(int viewID, String text){
		TextView tv = getView(viewID);
		tv.setText(text);
		return this;
	}
	
	public CommonViewHolder setImageResource(int viewID, int resourceID){
		ImageView iv = getView(viewID);
		iv.setImageResource(resourceID);
		return this;
	}
	
	public CommonViewHolder setImageBitmap(int viewID, Bitmap bitmap){
		ImageView iv = getView(viewID);
		iv.setImageBitmap(bitmap);
		return this;
	}
	
	public CommonViewHolder setImageURI(int viewID, String uri){
		ImageView iv = getView(viewID);
		//采用第三方框架比如Google volley, assync-http, universal-image-loader
		//ImageLoader.getInstance().getImageBitmap(viewID, uri);
		return this;
	}
}