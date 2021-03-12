package uteq.student.examen_movil.model;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.LongClick;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import uteq.student.examen_movil.R;

@Layout(R.layout.load_more_item_view)
public class ItemView {

    @View(R.id.titleTxt)
    private TextView titleTxt;

    @View(R.id.captionTxt)
    private TextView captionTxt;

    @View(R.id.timeTxt)
    private TextView timeTxt;

    @View(R.id.imageView)
    private ImageView imageView;

    private journal mInfo;
    private Context mContext;

    public ItemView(Context context, journal info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getName());
        captionTxt.setText(mInfo.getAbbreviation());
        timeTxt.setText(mInfo.getJournal_id());
        Glide.with(mContext).load(mInfo.getPortada()).into(imageView);
    }

   


}
