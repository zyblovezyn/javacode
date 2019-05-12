

# - Java并发编程与高并发解决方案(完整) 
网址:https://www.bilibili.com/video/av45946533
## 准备工作  
###在pom中加入依赖
`	<dependency>  
		<groupId>org.projectlombok</groupId>    
		<artifactId>lombok</artifactId>  
	</dependency>`  
###添加lombok plugin  
##  atomic包 cas compareAndSwapInt 原理  
##  原子性--锁  
##  synchrinozied：依赖JVM  
 - 修饰代码块 修饰方法 修饰静态方法 修饰类
 - synchronized：不可中断锁，适合竞争不激烈的情况，可读性好  
 - Lock:可中断，多样化同步，竞争激烈时能维持常态
 - Atomic:竞争激烈时能维持常态，性能比Lock好，只能同步一个值    
## Lock:
 - 依赖特殊的CPU指令，代码实现，ReenTrantLock  
  
## 线程安全:
 - 可见性 
 - 原子性
 - 有序性  
## 4. 并发测试工具 
 - postman 
 - ApacheBench 
 - jmeter  
## 5 导致共享变量在内存中不可见的原因  
 - 线程交叉执行  
 - 重排序结合线程交叉执行  
 - 共享变量更新后的值没有在工作内存与主内存同步  
## 6 可见性 -- synchronized
### JMM关于synchronized的两条规定：
 - 线程解锁前，必须把共享变量的最新值刷新到主内存中
 - 线程加锁时，将清空工作内存中共享变量的值，从而使使用共享变量时需要从主内存中重新读取最新的值(注意，加锁和解锁是同一把锁)
## 可见性 -- volatile
 - 通过加入**内存屏障**和**禁止重排序**优化来实现
 - 对volatile变量写操作时，会在写操作后加入一条store屏障指令，将本地内存中的共享变量值刷新到主内存
 - 对volatile变量读操作时，会在读操作前加一条load屏障指令，从主内存中读取共享变量
## 同步操作与规则
- lock unlock 
- read write 
- load store 
- use assign  
## 有序性
- java 内存模型中，允许编译器和处理器对指令进行重排序，但是重排序过程不会影响到单线程，却会影响到多线程
- volatile、synchronized、Lock
## 有序性
- 程序次序规则：一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作
- 锁定原则：一个unlock操作先行发生于后面对于同一个锁的lock操作
- volatile变量规则：对一个变量的写操作先行发生于后面对于这个变量的读操作
- 传递原则：如果操作A先行发生于操作B，操作B先行发生与操作C，则可以得出操作A先行发生于操作C
- 线程启动规则：Thread的start方法先行发生于此线程的每一个动作
- 线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生
- 线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行
- 对象终结规则：一个对象的初始化完成先行发生于他的finalize()方法的开始
## 不可变对象
- 不可变对象需要满足的条件
- 对象创建以后其状态不能改变
- 对象所有的域都是final类型
- 对象是正确创建的(this引用没有溢出)
## final修饰 类 方法 变量
- 修饰类 则类不能继承
- 修饰方法：1、锁定方法不被继承类修改 2、效率
- 修饰变量：基本类型(不能修改)、引用类型(不能指向另一个对象)
- Collections.unmodifiableXXX
# 线程封闭
- Ad-hoc 线程封闭：程序控制实现，最糟糕，忽略
- 堆栈封闭：局部变量，无并发问题
- ThreadLocal 线程封闭：特别好的封闭方法  [https://www.cnblogs.com/dolphin0520/p/3920407.html](https://www.cnblogs.com/dolphin0520/p/3920407.html "ThreadLocal")
### StringBuffer与StringBuilder
- StringBuilder 不安全 速度快
- StringBuffer 安全 速度慢
- 所以JDK提高两个 在不同情况下 根据业务需要选择合适的字符串拼接类
- 先检查在执行是线程不安全的if(condition(a)){handler(a)}
### SimpleDateFormat和JodaDate
- SimpleDateFormatter是线程不安全
- JodaDate线程安全的
## 线程安全容器
- ArrayList->Vector,Stack
- HashMap->HashTable（key value不能为空）
- Collections.synchronizedXXX（List、set、Map）
## 线程安全-并发容器 J.U.C  
- J.U.C java.util.concurrent  
- ArrayList->CopyOnWriteArrayList（读不需要加锁、写需要加锁）
- HashSet、TreeSet->CopyOnWriteArraySet ConcurrentShipListSet
- HashMap、TreeMap -> ConcurrentHashMap、ConcurrentSkipListMap(key有序、并发度高)

## AbstractQueuedSynchronizer  AQS
- 底层由双向列表实现
- 使用Node实现FIFO队列，可以用于构建锁或者其他同步装置的框架
- 利用int表示状态
- 使用方法是继承
- 子类通过继承并通过实现它的方法管理其状态{aquire和release}的方法操纵状态
- 可以同时实现排它锁和共享锁模式
### AQS同步组件
- CountDownLetch 闭锁
- Semaphore 控制并发数目
- CyclicBarrier
- ReentrantLock
- Condition
- FutrueTask
##ReentrantLock 与 锁

	可以指定公平锁和非公平锁
	提供了一个Condition类。可以分组唤醒需要唤醒的线程
	提供中断等待锁的线程的机制，lock.lockInterruptibly()
		
## FutureTask 可以得到返回值

## Fork/Join 框架 双端队列  一端先执行就会从双端队列的尾部窃取一个任务执行

## BlockingQueue 主要用于生产者消费者模式
### ArrayBlockingQueue 有界阻塞队列 FIFO
### DelayQueue 实现delay接口 FIFO
### LinkedBlockingQueue FIFO
### PriorityBlockingQueue 可以插入null 
### SynchronousQueue 只能存放一个元素

# 线程池
## new Thread
	缺点：每次new Thread新建对象 性能差
	线程缺乏统一管理，可能无限制的新建线程，相互竞争，有可能占用过多系统资源导致死机或OOM
	缺少更多功能，如更多执行、定期执行、线程中断

	线程池的有点：重用线程 控制并发数 避免阻塞避免进竞争 提供定时执行 定期执行 单线程 并发数控制等功能
## ThreadPoolExecutor
	execute() : 提交任务交给线程池去执行
	submit() : 提交任务，能够返回结果 execute+Future
	shutdowm() 关闭线程池，等待任务都执行完
	shutdownNow():关闭线程池，不等待任务执行完
	getTaskCount():线程池已执行和未执行的任务总数
	getCompletedTaskCount():已完成的任务数量
	getPoolSize():线程池当前的线程数量
	getActiveCount()：当前线程池中正在执行任务的线程数量
## 线程池 - Executor框架接口
	Executoors.newCachedThreadPool
	Executoors.newFixedThreadPool
	Executoors.newScheduledThreadPool
	Executoors.newSingleThreadPool
## 线程池 - 合理配置
	CPU密集型任务，就需要压榨CPU，参数可以设置为NCPU+1
	IO密集型，参数可以设置为2*NCPU
## 扩容
	垂直扩容(纵向扩容):提高系统部件能力
	水平扩容(横向扩容):增加更多系统成员来完成任务
	










 