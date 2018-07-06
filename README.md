# DConcurrent 分布式并行处理框架
> 模仿 concurrent 多线程处理方式，进行分布式调用的 java 类库。使用该类库您可以轻松的设计分布式应用,比如 高可用异地容错应用、多任务分发应用...
  
# 一、使用场景
### 1.1、 高可用异地容错应用
    举例：有这样的需求，设计一款 高可用多服务健康检查应用，应用需求 多个节点对服务进行健康检查后投票给 leader 统计
    统计完成后将服务糟糕的集群下线。      
    DConcurrent 实现：
    ```
    // new 一个 DConcurrent 的客户端， hostAndPortList 机器列表
    DExecutors client = new DExecutors( hostAndPortList);
    // 启动三个节点
    DFuture haNode1 = client.submit( new healthyCallable(dmetaParam) );
    DFuture haNode2 = client.submit( new healthyCallable(dmetaParam) );
    DFuture haNode3 = client.submit( new healthyCallable(dmetaParam) );
    // 获取票数
    Healthy healthy1 =haNode1.get()；
    Healthy healthy2 =haNode1.get()；
    Healthy healthy3 =haNode1.get()；
    // 统计
    ```
    
### 1.2、 多任务分发应用
    举例：需求设计一款 hbase 平台化增量系统，scan 每个 region 后将 update 数据发到 kafaka,
    由于 scan 出来的数据量大而且 region 数比较多，所以单台机器处理能力有限，所以需要我们进行分布式处理并高可用。      
    DConcurrent 实现：
    ```
    // new 一个 DConcurrent 的客户端， hostAndPortList 机器列表， FailStrategy 采用公平调度
    DExecutors client = new DExecutors( hostAndPortList, new FailStrategy() );
    // 任务列表
    List<ScanTask> taskList = new ArrayList();
    // 分发到其它机器运行
    for(ScanTask task : taskList){
        client.submit( new ScanTaskRunnable(task) );
    }
    ```
    
# 二、框架介绍
```
├── core                                     // rpc 核心包
├── strategy                                 // 负载策略具体实现
├── util                                     // 工具包   
├── BalanceStrategy.java                     // 负载策略接口，通过该策略决定怎么调度    
├── DCallable.java                           // 需要返回结果到必须实现该接口
├── DConcurrentClient.java                   // DConcurrent 到客户端     
├── DConcurrentServer.java                   // DConcurrent 到服务端 
├── DExecutors.java                          // 用户执行接口，用户使用到功能都通过该对象来调用
├── DFuture.java                             // DConcurrent 都 future    
├── DmetaParam.java                          // runable 或 callable 如果需要传递参数，必须使用该类型
├── Status.java                              // 服务状态类型
```
 

# 三、使用 demo
```
public class Server1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 启动服务
        DConcurrentServer.daemonStart(50051);
        // 服务列表
        List<HostAndPort> hostAndPortList = new ArrayList<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("192.168.31.147", 50051);
        HostAndPort hostAndPort2 = new HostAndPort("192.168.31.147", 50052);
        HostAndPort hostAndPort3 = new HostAndPort("192.168.31.147", 50053);
        hostAndPortList.add( hostAndPort1 );
        hostAndPortList.add( hostAndPort2 );
        hostAndPortList.add( hostAndPort3 );
        // DConcurrent 客户端
        DExecutors client = new DExecutors( hostAndPortList, new FailStrategy() );
    
        while (true){
            // 只有 leader 才可以继续往下执行
            if( !client.isLeader() ){
                System.out.println( "is not leader" );
                continue;
            }
            
            // 运行一个 Runnable
            DmetaParamTest dmetaParam = new DmetaParamTest();
            client.submit(new TestRuannable( dmetaParam ) );
            
            // 运行两个 Callable
            DFuture future1 = client.submit( new TestCallable(dmetaParam) );
            dmetaParam.setAge(1110000);
            DFuture<CallResultTest> future2 = client.submit( new TestCallable(dmetaParam) );
            CallResultTest str = (CallResultTest) future1.get();
            CallResultTest str2 = future2.get();
            System.out.println("finish---------------------" + str);
            Thread.sleep(2000);
        }
    }

    public static class TestRuannable implements Runnable {
        // 参数必须是 DmetaParam 类型
        DmetaParamTest dmetaParamTest;
        public TestRuannable(){
            //ignore
        }

        public TestRuannable(DmetaParamTest dmetaParamTest){
            this.dmetaParamTest = (DmetaParamTest) dmetaParamTest;
        }

        @Override
        public void run() {
            System.out.println("drunnable " + this.dmetaParamTest);
        }
    }
}
```
> 这样设计的最大好处是可以让你按照多线程的编写方式来编写分布式程序，倘若不需要设计成分布式可以直接改 Executors 的具体实现保持大部分代码不动

mvn install

