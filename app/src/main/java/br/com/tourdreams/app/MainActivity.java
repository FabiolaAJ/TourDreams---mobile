package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.magic.view.MagicButton;


public class MainActivity extends BaseActivity {

    ImageView img_hotel, img_logo;
    Context context;
    MagicButton chat_usuario;
    ViewPager banner_promocao;
    LinearLayout sliderDots;
    private int dotscount;
    private ImageView[] dots;
    ListView lst_main;
    List<base> lstHotel = new ArrayList<>();
    baseAdapter adapter;
    MelhoresDestinosAdapter adapterMelhoresDestinos;
    int  categoria = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        definirConteudo(R.layout.content_main);
        context = this;
        img_hotel = (ImageView) findViewById(R.id.img_hotel);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        //banner_promocao = (ViewPager) findViewById(R.id.banner_promocao);
        //sliderDots = (LinearLayout) findViewById(R.id.sliderDots);
        lst_main = (ListView) findViewById(R.id.lst_main);
       // new promocao().execute();

        LayoutInflater inflate = LayoutInflater.from(context);
        inflate.inflate(R.layout.small_bar,null);
        preencherAdapter();
        CliqueDaLista();

    }
    public void btn_filtro_sheet(View view) {
        //Toast.makeText(this,"bottom sheet",Toast.LENGTH_SHORT).show();
        CustomBottomSheetDialog dialog = new CustomBottomSheetDialog(this);
        dialog.show();
    }

    private void CliqueDaLista() {
        lst_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){
                    case 0:
                        categoria = 1;
                        break;
                    case 1:
                        categoria = 2;
                        break;
                    case 2:
                        categoria = 3;
                        break;
                    case 3:
                        categoria = 4;
                        break;
                }

                Intent intent = new Intent(context,LugaresActivity.class);
                intent.putExtra("idCategoria",categoria);
                startActivity(intent);
                overridePendingTransition(R.anim.botton_in, R.anim.top_out);

            }
        });
    }

    private void preencherAdapter() {

        // adicionando hoteis a lista
        lstHotel.add(new base("PRAIAS", R.drawable.praia));
        lstHotel.add(new base("REGIÕES FRIAS",  R.drawable.frio));
        lstHotel.add(new base("CAMPOS",  R.drawable.campo));
        lstHotel.add(new base("HOTÉIS FAZENDA",  R.drawable.fazenda));

        adapter = new baseAdapter(this, R.layout.main, lstHotel);
        lst_main.setAdapter(adapter);
    }

}
