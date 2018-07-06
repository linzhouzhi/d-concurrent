package io.grpc.distribute.strategy;

import com.google.common.collect.Sets;
import io.grpc.distribute.BalanceStrategy;

import java.util.*;

/**
 * Created by lzz on 2018/7/5.
 */
public class FixStrategy extends RandomStrategy implements BalanceStrategy {
    private Map<Integer, Object> taskTable = new HashMap();

    @Override
    public Object getClient(List list, int balanceKey) {
        if( -1 == balanceKey ){ // 随机取出一个，并不做记录保存
            return super.getClient(list, -1);
        }
        Object client = taskTable.get( balanceKey );
        Set listSet = new HashSet(list);
        Set taskTableSet = new HashSet();
        if( taskTable.values().isEmpty() ){
            taskTableSet = new HashSet();
        }
        if( null ==  client ){
            // 选择 list 有的 taskTable 没有的
            Set taskTableWidhout = Sets.difference( listSet, taskTableSet );
            if( !taskTableWidhout.isEmpty() ){
                taskTable.put( balanceKey, taskTableWidhout.iterator().next() );
            }else{ // 如果 taskTable 包含了所有 list 都有的那么就选择调用次数最少的个节点
                Map<Object, Integer> groupClientCount = new HashMap<Object, Integer>();
                for(Map.Entry<Integer, Object> element : taskTable.entrySet()){
                    Object clientObj = element.getValue();
                    if( null == groupClientCount.get( clientObj ) ){
                        groupClientCount.put(clientObj, 1);
                    }else{
                        int tmp = groupClientCount.get(clientObj);
                        groupClientCount.put( clientObj, ++tmp);
                    }
                }
                // 取出调用最少的 clientObj
                Object res = null;
                Integer minCount = 0;
                for(Map.Entry<Object, Integer> element : groupClientCount.entrySet()){
                    Object key = element.getKey();
                    Integer value = element.getValue();
                    if( null == res || minCount < value ){
                        res = key;
                        minCount = value;
                    }
                }
                taskTable.put(balanceKey, res);
            }
            client = taskTable.get( balanceKey );
        }
        // 删除 taskTable 有 list 没有的
        Set listWidhout = Sets.difference( taskTableSet, listSet );
        for(Object object : listWidhout){
            int removeKey = 0;
            for(Map.Entry<Integer, Object> element : taskTable.entrySet()){
                if( element.getValue() == object ){
                    removeKey = element.getKey();
                    break;
                }
            }
            taskTable.remove( removeKey );
        }
        return client;
    }
}
