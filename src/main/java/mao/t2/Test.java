package mao.t2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Project name(项目名称)：java并发编程_LinkedBlockingQueue
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/15
 * Time(创建时间)： 14:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                for (int i = 0; i < 8; i++)
                {
                    try
                    {
                        Integer integer = blockingQueue.take();
                        System.out.println("取得元素：" + integer);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for (int i = 0; i < 20; i++)
        {
            try
            {
                blockingQueue.put(i);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("已添加元素：" + i);
        }
    }
}
