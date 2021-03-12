package uteq.student.examen_movil.model;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.infinite.LoadMore;

import java.util.ArrayList;

import uteq.student.examen_movil.R;

@Layout(R.layout.load_more_view)
public class LoadMoreView2 {

    public static final int LOAD_VIEW_SET_COUNT = 6;

    private InfinitePlaceHolderView mLoadMoreView2;
    private ArrayList<datavolumen> mFeedList2;

    public LoadMoreView2(InfinitePlaceHolderView loadMoreView, ArrayList<datavolumen> feedList) {
        this.mLoadMoreView2 = loadMoreView;
        this.mFeedList2 = feedList;
    }

    @LoadMore
    private void onLoadMore(){
        Log.d("DEBUG", "onLoadMore");
        new ForcedWaitedLoading();
    }

    class ForcedWaitedLoading implements Runnable{

        public ForcedWaitedLoading() {
            new Thread(this).start();
        }

        @Override
        public void run() {

            try {
                Thread.currentThread().sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    int count = mLoadMoreView2.getViewCount();
                    Log.d("DEBUG", "count " + count);
                    for (int i = count - 1;
                         i < (count - 1 + LoadMoreView.LOAD_VIEW_SET_COUNT) && mFeedList2.size() > i;
                         i++) {

                        mLoadMoreView2.addView(new ItemView2(mLoadMoreView2.getContext(), mFeedList2.get(i)));

                        if(i == mFeedList2.size() - 1){
                            mLoadMoreView2.noMoreToLoad();
                            break;
                        }
                    }
                    mLoadMoreView2.loadingDone();
                }
            });
        }
    }
}