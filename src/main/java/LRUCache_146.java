import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//TODO 双向链表

public class LRUCache_146 {
    private int capacity;
    private Map<Integer, Integer> cache;
    private Queue<Integer> queue;

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Integer>();
        queue = new LinkedList<Integer>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        queue.remove(key);
        queue.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            queue.remove(key);
        } else if(queue.size() == capacity) {
            Integer removed = queue.poll();
            cache.remove(removed);
        }
        queue.add(key);
        cache.put(key, value);
    }


    public static void main(String[] args) {
        LRUCache_146 lRUCache146 = new LRUCache_146(2);
        System.out.println(lRUCache146.get(2));    // 返回 -1
        lRUCache146.put(2, 6);
        System.out.println(lRUCache146.get(1));    // 返回 -1 (未找到)
        lRUCache146.put(1, 5); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache146.put(1, 2);
        System.out.println(lRUCache146.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache146.get(2));    // 返回 3
    }
}
