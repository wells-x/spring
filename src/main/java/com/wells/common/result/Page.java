package com.wells.common.result;

import com.wells.common.exception.BizExceptionEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *
 * @author sheng
 * @date 18/3/16.
 */
public class Page<T> extends Success<List<T>> {

    private PageInside page;

    public Page(int pageNum, int total, int pageSize, List<T> data) {
        this.page = new PageInside(pageNum, total, pageSize);
        if (data == null) {
            data = new ArrayList<>();
        }
        this.data = data;
        if (data.size() == 0) {
            this.code = BizExceptionEnum.PAGE_NULL.getCode();
            this.msg = BizExceptionEnum.PAGE_NULL.getMsg();
        } else {
            this.code = BizExceptionEnum.PAGE.getCode();
            this.msg = BizExceptionEnum.PAGE.getMsg();
        }
    }

    private class PageInside {

        //当前页码
        private int pageNo = 1;
        //总页数
        private int countPage;
        //总记录数
        private int total;
        //单页数据量
        private int pageSize;
        //是否有下一页
        private boolean hasNext = true;

        public boolean getHasNext() {
            if (pageNo >= countPage) {
                hasNext = false;
            }
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        PageInside(int pageNo, int total, int pageSize) {
            this.setTotal(total);
            this.setPageSize(pageSize);
            if (pageSize != 0) {
                countPage = total / pageSize;
                if (total % pageSize > 0) {
                    countPage += 1;
                }
            }
            this.setPageNo(pageNo);
        }


        //获取下一页面
        public int getNextPageNo() {
            long nextPageNo = this.pageNo + 1;
            if (nextPageNo <= 1) {
                nextPageNo = 1;
            } else if (nextPageNo >= countPage) {
                nextPageNo = countPage;
            }

            return (int) nextPageNo;
        }

        //获取上一页
        public int getPreviousPageNo() {
            int previousPageNo = this.pageNo - 1;

            if (previousPageNo <= 1) {
                previousPageNo = 1;
            } else if (previousPageNo >= countPage) {
                previousPageNo = countPage;
            }

            return previousPageNo;
        }

        //获取当前页码
        public int getPageNo() {
            return pageNo;
        }

        //设置当前页码
        void setPageNo(int pageNo) {
            if (pageNo <= 1) {
                this.pageNo = 1;
            } else if (pageNo >= countPage) {
                this.pageNo = countPage;
            } else {
                this.pageNo = pageNo;
            }
        }

        //获取总页数
        public long getCountPage() {
            return countPage;
        }

        //设置总页数
        public void setCountPage(int countPage) {
            this.countPage = countPage;
        }

        //获取页面大小
        public int getPageSize() {
            return pageSize;
        }

        //设置页面大小
        void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        //获取总记录数
        public long getTotal() {
            return total;
        }

        //设置总记录数
        void setTotal(int total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "pageNo:" + pageNo + "   pageSize" + pageSize + "   Countpage" + countPage;
        }

    }

    public static <T> Page<T> create(int pageNum, int total, int pageSize, List<T> data) {
        return new Page<>(pageNum, total, pageSize, data);
    }
}
