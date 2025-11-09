import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalTest {

    private static Executor executorService = Executors.newFixedThreadPool(2);
    private static ThreadLocal<String> tl = new ThreadLocal<>();
    private static ThreadLocal<String> tl1 = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        /*
        Map<WeakReference<Integer>, WeakReference<Integer>> map = new HashMap<>(8);
        // 注意这里~
        WeakReference<Integer> key = new WeakReference<>(666);
        WeakReference<Integer> value = new WeakReference<>(7777);
        map.put(key,value);
        System.out.println("put success");
        Thread.sleep(1000);
        System.out.println("get " + key.get() + ":" + map.get(key)+ ":" + map.get(key).get());
        System.gc();
        System.out.println("get " + key.get() + ":" + map.get(key)+ ":" + map.get(key).get());
        */

        executorService.execute(() -> {
            tl.set("1");
            tl1.set("2");
            Thread thread = Thread.currentThread();
            System.out.println("thread name: " + thread.getName() + " set 1");
            System.out.println("thread name: " + thread.getName() + " set 2");
            System.out.println(tl.get() + ": tl");
            System.out.println(tl1.get() + ": tl1");
        });

        ExecutorService service = Executors.newSingleThreadExecutor();

    }


}
