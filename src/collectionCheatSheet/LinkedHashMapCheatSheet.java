package collectionCheatSheet;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapCheatSheet {
  /**
   * It can be easily use to implement LRU cache.
   */

  LinkedHashMap<Integer, Integer> lru;

  public void LruCacheInit(int capacity){
    lru = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true){
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e)
      {
        return this.size() > capacity;
      }
    };
  }


  public Integer lookup(Integer key){
    if (!lru.containsKey(key)) {
      return null;
    }
    return lru.get(key);
  }


  public void insert(Integer key, Integer value) {
      lru.put(key, value);
  }
}
