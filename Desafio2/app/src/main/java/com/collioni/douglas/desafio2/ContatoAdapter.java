package com.collioni.douglas.desafio2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Douglas.Collioni on 23/03/2015.
 */
public class ContatoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contato> itens;

    public ContatoAdapter(Context context, ArrayList<Contato> itens) {
        super();
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();

            convertView = inflater.inflate(R.layout.contato_list_item, parent, false);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contato c = (Contato)getItem(position);

        if (c != null) {
            viewHolder.ivFoto.setImageResource(c.getFoto());
            viewHolder.tvNome.setText(c.getNome());
        }

        return convertView;
    }

    public static class ViewHolder {
        public final ImageView ivFoto;
        public final TextView tvNome;

        public ViewHolder(View view) {
            this.ivFoto = (ImageView) view.findViewById(R.id.ivFoto);
            this.tvNome = (TextView) view.findViewById(R.id.tvNome);
        }
    }
}
