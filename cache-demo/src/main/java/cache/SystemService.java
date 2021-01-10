package cache;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-07-09
 */
public class SystemService {

    public Object getUserInfo(int id) {
        return MockDB.find(id);
    }
}
