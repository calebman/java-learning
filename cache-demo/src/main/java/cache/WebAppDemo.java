package cache;

/**
 * @author JianhuiChen
 * @description
 * @date 2020-07-09
 */
public class WebAppDemo {

    public static void main(String[] args) {

        SystemService systemService = new SystemService();

        for (int i = 0; i < 1000; i++) {
            MockDB.save("user" + i);
        }

        for (int i = 0; i < 1000; i++) {
            final int userId = i;
            new Thread(() -> {
                systemService.getUserInfo(userId);
            }).start();
        }
    }
}
