package cn.test1;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperDemo {

	private static final int Session_Timeout=3000;
	public static void main(String[] args) {
		try {
			ZooKeeper zooKeeper=new ZooKeeper("192.168.229.130:2181", Session_Timeout, new Watcher(){

				@Override
				public void process(WatchedEvent arg0) {
					System.out.println("事件被触发"+arg0.getType());
					
				}});
			Thread.sleep(3000);
			zooKeeper.create("/node_4", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(zooKeeper.getData("/node_1_1",true, null));
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
