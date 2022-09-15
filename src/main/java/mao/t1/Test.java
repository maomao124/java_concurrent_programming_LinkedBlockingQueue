package mao.t1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Project name(项目名称)：java并发编程_LinkedBlockingQueue
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/15
 * Time(创建时间)： 14:04
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        //BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 5; i++)
        {
            try
            {
                linkedBlockingQueue.put(i);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                try
                {
                    linkedBlockingQueue.put(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true)
        {
            try
            {
                System.out.println(linkedBlockingQueue.take());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
