package uteq.student.examen_movil.model;


import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import uteq.student.examen_movil.R;
import uteq.student.examen_movil.articulo;

@Layout(R.layout.load_more_item_articulo)
public class ItemView3 {

    @View(R.id.titleTxtar)
    private TextView titleTxt;

    @View(R.id.captionTxtar)
    private TextView captionTxt;

    @View(R.id.timeTxtar)
    private TextView timeTxt;

    @View(R.id.button)
    private Button imageView;

    private dataarticulos mInfo;
    private Context mContext;

    public ItemView3(Context context, dataarticulos info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getTitle());
        captionTxt.setText(mInfo.getAutores());
        timeTxt.setText(mInfo.getAño());
    }
    @Click(R.id.button)
    public void onCardClick() {

    }

}
