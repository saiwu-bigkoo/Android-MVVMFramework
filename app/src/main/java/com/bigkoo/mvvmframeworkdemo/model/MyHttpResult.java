package com.bigkoo.mvvmframeworkdemo.model;

import com.bigkoo.mvvmframework.model.HttpResult;

import java.util.List;

/**
 * Created by Sai on 16/6/4.
 */
public class MyHttpResult<T> extends HttpResult{

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"pageNo":2,"perPageSize":10,"totalRecord":10578,"ticket_list":[{"productId":"923010086","spotName":"蓝水河漂流","spotAliasName":["蓝水河"]},{"productId":"3010639640","spotName":"万福鼎公园","spotAliasName":["万福鼎","玫瑰园","玫瑰园景群"]},{"productId":"2482300975","spotName":"百丈崖","spotAliasName":["百丈崖景区"]},{"productId":"83331249","spotName":"目连山","spotAliasName":["目莲山","目连会","安徽目连山森林公园大峡谷景区"]},{"productId":"2196538808","spotName":"旭和影城","spotAliasName":["温江旭和影城"]},{"productId":"2991264352","spotName":"御庄园温泉度假村","spotAliasName":["御庄园","莆田御庄园温泉度假村"]},{"productId":"65647061","spotName":"南京阅江楼","spotAliasName":["阅江楼景区"]},{"productId":"3827176217","spotName":"绿林寨","spotAliasName":["绿林寨","绿林古兵寨","荆门大洪山绿林寨"]},{"productId":"1097804797","spotName":"苏州海洋馆","spotAliasName":["苏州吴中海洋馆，吴中海洋馆"]},{"productId":"200756750","spotName":"大连槐之乡庄园","spotAliasName":["槐之乡温泉度假村"]}]}
     */

    private int errNum;
    private String errMsg;
    /**
     * pageNo : 2
     * perPageSize : 10
     * totalRecord : 10578
     * ticket_list : [{"productId":"923010086","spotName":"蓝水河漂流","spotAliasName":["蓝水河"]},{"productId":"3010639640","spotName":"万福鼎公园","spotAliasName":["万福鼎","玫瑰园","玫瑰园景群"]},{"productId":"2482300975","spotName":"百丈崖","spotAliasName":["百丈崖景区"]},{"productId":"83331249","spotName":"目连山","spotAliasName":["目莲山","目连会","安徽目连山森林公园大峡谷景区"]},{"productId":"2196538808","spotName":"旭和影城","spotAliasName":["温江旭和影城"]},{"productId":"2991264352","spotName":"御庄园温泉度假村","spotAliasName":["御庄园","莆田御庄园温泉度假村"]},{"productId":"65647061","spotName":"南京阅江楼","spotAliasName":["阅江楼景区"]},{"productId":"3827176217","spotName":"绿林寨","spotAliasName":["绿林寨","绿林古兵寨","荆门大洪山绿林寨"]},{"productId":"1097804797","spotName":"苏州海洋馆","spotAliasName":["苏州吴中海洋馆，吴中海洋馆"]},{"productId":"200756750","spotName":"大连槐之乡庄园","spotAliasName":["槐之乡温泉度假村"]}]
     */

    private RetDataEntity<T> retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public void setRetData(RetDataEntity<T> retData) {
        this.retData = retData;
    }

    public static class RetDataEntity<T> {
        private int totalRecord;

        private T ticketList;

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }


        public T getTicketList() {
            return ticketList;
        }

        public void setTicketList(T ticketList) {
            this.ticketList = ticketList;
        }
    }


    /**
     * ====================  注意  ===========================
     *
     * 由于默认的 HttpResult 和 具体的MyHttpResult 约定返回的数据格式不一致，所以需要重写以下三个函数来进行统一
     *
     * 默认的 status 属性 = 具体的MyHttpResult 的 errNum 属性
     * 默认的 msg 属性 = 具体的MyHttpResult 的 errMsg 属性
     * 默认的 content 属性 :  默认是 content 返回 ====  如果是单个数据则是对应的 json 如果是列表则是对应的 jsonArray ，但 具体的 返回是 retData，列表数据是 retData 中的 ticketList
     *
     * ======================================================
     */


    @Override
    public int getStatus() {
        return errNum;
    }

    @Override
    public String getMsg() {
        return errMsg;
    }

    @Override
    public T getContent() {
        return retData.getTicketList();
    }
}
