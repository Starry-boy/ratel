package feign;


/**
 * @author ratel
 * @date 2020/3/26
 */
public class RatelHystrixFeign extends ReflectiveFeign {


    RatelHystrixFeign(ParseHandlersByName targetToHandlersByName, InvocationHandlerFactory factory, QueryMapEncoder queryMapEncoder) {
        super(targetToHandlersByName, factory, queryMapEncoder);
    }
}
