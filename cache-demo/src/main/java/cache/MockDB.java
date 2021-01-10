package cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JianhuiChen
 * @description 模拟的数据库
 * @date 2020-07-09
 */
public class MockDB {

    /**
     * 操作最大延迟 100ms
     */
    private static final int MAX_OPER_DELAY = 100;

    /**
     * 最大承载的访问量 超过后拒绝服务
     */
    private static final int MAX_QPS = 300;

    /**
     * 当前访问量
     */
    private static int curReqCnt = 0;

    /**
     * 数据存储
     */
    private static List<Object> db = new ArrayList<Object>();

    /**
     * 存储内容
     *
     * @param anything 数据对象
     * @return 主键ID
     */
    public static int save(Object anything) {
        db.add(anything);
        return db.size();
    }

    /**
     * 查询内容
     *
     * @param id 主键ID
     * @return 数据对象
     */
    public static Object find(int id) {
        waitOperComplete();
        return db.size() > id ? db.get(id) : null;
    }


    /**
     * 等待操作完成
     */
    private static void waitOperComplete() {
        while (curReqCnt > MAX_QPS) {
            // 超载 阻塞 CAS 自旋
        }
        curReqCnt++;
        try {
            int half = MAX_OPER_DELAY / 2;
            Thread.sleep((long) (half + Math.random() * half));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            curReqCnt--;
        }
    }
}
