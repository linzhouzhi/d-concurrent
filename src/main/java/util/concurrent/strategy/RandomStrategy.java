package util.concurrent.strategy;

import util.concurrent.BalanceStrategy;

import java.util.List;
import java.util.Random;

/**
 * Created by lzz on 2018/7/5.
 */
public class RandomStrategy implements BalanceStrategy {
    @Override
    public Object getClient(List list, int balanceKey) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
