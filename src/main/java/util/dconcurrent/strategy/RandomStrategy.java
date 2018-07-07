package util.dconcurrent.strategy;

import util.dconcurrent.BalanceStrategy;

import java.util.List;
import java.util.Random;

/**
 * Created by lzz on 2018/7/5.
 */
public class RandomStrategy implements BalanceStrategy {
    @Override
    public Object getClient(List list, String balanceKey) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
