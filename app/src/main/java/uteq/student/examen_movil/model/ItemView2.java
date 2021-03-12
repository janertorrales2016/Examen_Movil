package uteq.student.examen_movil.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import uteq.student.examen_movil.R;
import uteq.student.examen_movil.articulo;
import uteq.student.examen_movil.volumenes;

@Layout(R.layout.load_more_item_view)
public class ItemView2 {

    @View(R.id.titleTxt)
    private TextView titleTxt;

    @View(R.id.captionTxt)
    private TextView captionTxt;

    @View(R.id.timeTxt)
    private TextView timeTxt;

    @View(R.id.imageView)
    private ImageView imageView;

    private datavolumen mInfo;
    private Context mContext;

    public ItemView2(Context context, datavolumen info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getTitle());
        captionTxt.setText(mInfo.getDate_published());
        timeTxt.setText(mInfo.getVolume());
        Glide.with(mContext).load(mInfo.getCover()).into(imageView);
    }

    @Click(R.id.root)
    public void onCardClick() {
        Intent intent = new Intent(mContext, articulo.class);
        intent.putExtra("id", mInfo.getIssue_id());
        mContext.startActivity(intent);
    }

}
