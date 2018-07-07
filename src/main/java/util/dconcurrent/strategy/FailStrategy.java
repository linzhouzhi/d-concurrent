package util.dconcurrent.strategy;

import com.google.common.collect.Sets;
import util.dconcurrent.BalanceStrategy;

import java.util.*;

/**
 * Created by lzz on 2018/7/5.
 */
public class FailStrategy implements BalanceStrategy {
    private Map<Object, Integer> callCountMap = new HashMap();

    @Override
    public Object getClient(List list, String balanceKey) {
        Set listSet = new HashSet(list);
        Set callCountSet = callCountMap.keySet();
        //如果有新加入的节点，要清空计数器，避免集中调用到刚进来到节点
        Set newNodes = Sets.difference(listSet, callCountSet);
        if( !newNodes.isEmpty() ){
            callCountMap = new HashMap();
        }
        //加入 list 有的对象
        for(Object element : list){
            if( null == callCountMap.get(element) ){
                callCountMap.put(element, 0);
            }
        }
        //删除 list 没有的对象
        Set listNotable = Sets.difference(callCountSet, listSet);
        for(Object element : listNotable){
            callCountMap.remove( element );
        }
        // 获取调用次数最少到节点
        Object res = null;
        Integer minCount = 0;
        for(Map.Entry<Object, Integer> element : callCountMap.entrySet()){
            Object key = element.getKey();
            Integer value = element.getValue();
            if( null == res || value < minCount){
                res = key;
                minCount = value;
            }
        }

        callCountMap.put(res, ++minCount);
        return res;
    }
}
