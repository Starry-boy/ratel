package ratel.sso.ribbonRule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * @deprecated 自定义负载均衡
 * @author ratel
 * @date 2020/3/15
 */
public class MyRule implements IRule {
    @Override
    public Server choose(Object o) {
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
