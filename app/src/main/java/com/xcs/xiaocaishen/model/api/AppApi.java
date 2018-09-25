package com.xcs.xiaocaishen.model.api;

import com.xcs.xiaocaishen.config.Const;

/**
 * @author lwang
 * @date 2018/8/1
 * @description 对app联网的api进行设置，返回的结果是一个被观察者
 * 方法注解，@GET、@POST、@PUT、@DELETE、@PATH、@HEAD、@OPTIONS、@HTTP。
 * 标记注解，@FormUrlEncoded、@Multipart、@Streaming。
 * 参数注解，@Query,@QueryMap、@Body、@Field，@FieldMap、@Part，@PartMap。
 * 其他注解，@Path、@Header,@Headers、@Url
 */

public interface AppApi {

    String BASE_URL = Const.BASE_URL;

}
