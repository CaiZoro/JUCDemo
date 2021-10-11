import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全得问题
 * ArrayList
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1;i <= 30;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                //System.out.println(i);
            },String.valueOf(i)).start();
        }

    }

    public static void setNotSafe(String[] args) {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 1;i <= 30;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }

    public static void listNotSafe(String[] args) {
        //List<String> list = new ArrayList<>();

        //解决方法
        //List<String> list = Collections.synchronizedList(new ArrayList<>());


        //解决方案
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1;i <= 30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         * 2 导致原因
         *      并发争抢修改导致，参考花名册签名情况
         *
         * 3 解决方案
         *      3.1 new Vector<>();
         *      3.2 Collections.synchronizedList(new ArrayList<>());
         *      3.3 new CopyOnWriteArrayList<>();
         * 4 优化建议()
         */
    }
}
