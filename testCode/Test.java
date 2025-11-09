import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put("s", null);
        map.put(null, "ss");
        map.forEach((k, v) -> {
            System.out.println("k:" + k + ", v:" + v);
        });
        System.out.println("hello, world!");
        for (String s : map.keySet()) {
            String s1 = map.get(s);
            System.out.println("s:" + s + ", s1" + s1);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {

        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key + " val:" + value);
        }

        fixedThreadPool.execute(() -> {
            threadLocal.set("val11");
            System.out.println(Thread.currentThread().getName() + " set val1");

        });


        fixedThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " get val1:" + threadLocal.get());
        });

    }
}
