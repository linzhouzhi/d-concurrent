package io.grpc.distribute;

import java.util.List;

/**
 * Created by lzz on 2018/7/5.
 */
public interface BalanceStrategy {
    Object getClient(List list, int balanceKey);
}
