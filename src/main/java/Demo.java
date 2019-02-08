import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author 李文浩
 * @date 2018/12/28
 */
public class Demo {
    /**
     * CacheLoader
     */
    public void loadingCache() {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("key:" + key);
                        if ("key".equals(key)) {
                            return "key return result";
                        } else {
                            return "get-if-absent-compute";
                        }
                    }
                });
        String resultVal = null;
        try {
            resultVal = graphs.get("key");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(resultVal);
    }

    /**
     * Callable
     */
    public void callablex() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000).build();
        String result = cache.get("key", new Callable<String>() {
            public String call() {
                return "result";
            }
        });
        System.out.println(result);
    }
}
