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
public class LoadMoreView3 {

    public static final int LOAD_VIEW_SET_COUNT = 6;

    private InfinitePlaceHolderView mLoadMoreView3;
    private ArrayList<dataarticulos> mFeedList3;

    public LoadMoreView3(InfinitePlaceHolderView loadMoreView, ArrayList<dataarticulos> feedList) {
        this.mLoadMoreView3 = loadMoreView;
        this.mFeedList3 = feedList;
    }

    @LoadMore
    private void onLoadMore(){
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
                    int count = mLoadMoreView3.getViewCount();
                    for (int i = count - 1;
                         i < (count - 1 + LoadMoreView3.LOAD_VIEW_SET_COUNT) && mFeedList3.size() > i;
                         i++) {
                        mLoadMoreView3.addView(new ItemView3(mLoadMoreView3.getContext(), mFeedList3.get(i)));
                        if(i == mFeedList3.size() - 1){
                            mLoadMoreView3.noMoreToLoad();
                            break;
                        }
                    }
                    mLoadMoreView3.loadingDone();
                }
            });
        }
    }
}