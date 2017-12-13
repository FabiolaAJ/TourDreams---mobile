package br.com.tourdreams.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by 15251365 on 16/10/2017.
 */

public class DestinosAdapter extends ArrayAdapter<ConhecaSeuDestino>{
    int resource;

    public DestinosAdapter(Context context, int resource, List<ConhecaSeuDestino> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflagem de layout
        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_destino /*resource é o layout do item da lista*/,null);

        }

        ConhecaSeuDestino item = getItem(position);// pegar o item que esta sendo carregado
        Hotel i = getItem(position);

        if(item != null){

            ImageView img_hotel = v.findViewById(R.id.img_hotel);
            TextView txt_nomee_do_hotel = v.findViewById(R.id.txt_nomee_hotel);
            TextView txt_preco_hotel =  v.findViewById(R.id.txt_preco_hotel);
            TextView txt_local_hotel =  v.findViewById(R.id.txt_local_hotel);
            TextView txtcomentario = v.findViewById(R.id.txtcomentario);



            NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txt_preco_hotel.setText( f.format( Double.parseDouble(String.valueOf(item.getPreco())) ));

            // img_hotel.setImageResource(item.getImagem());
            txt_nomee_do_hotel.setText(i.getNome());
            txt_local_hotel.setText(i.getLocal());
            //txt_preco_hotel.setText(Double.toString(i.getPreco()));
            txtcomentario.setText(item.getComentario());

            Picasso.with(getContext())
                    .load(i.getImagem()) // pega a imagem e carrega ela na image view
                    .into(img_hotel); // a imgview q vai carregar a imagem
        }
        return v;
    }
}
