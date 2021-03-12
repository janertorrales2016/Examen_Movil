package uteq.student.examen_movil.model;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
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
        String url= mInfo.getUrl();
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI|
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle(mInfo.getTitle());
        request.setDescription("Descargando File....");

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+System.currentTimeMillis());

        DownloadManager manager = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

}
