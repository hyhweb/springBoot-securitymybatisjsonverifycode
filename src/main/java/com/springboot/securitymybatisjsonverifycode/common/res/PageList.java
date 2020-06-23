package com.springboot.securitymybatisjsonverifycode.common.res;


import java.util.List;

/**
* Created by hyhong Administrator on 2019/5/14.
*/
public class PageList<T> {
    private List<T> data;
        private Long count;

        public PageList(List<T> data, Long count) {
            this.data = data;
            this.count = count;
            }

            public List<T> getData() {
                return data;
                }

                public void setData(List<T> data) {
                    this.data = data;
                    }

                    public Long getCount() {
                    return count;
                    }

                    public void setCount(Long count) {
                    this.count = count;
                    }

                    @Override
                    public String toString() {
                    return "PageList{" +
                    "data=" + data +
                    ", count=" + count +
                    '}';
     }
}


