
HandlerInterceptor 是 Spring 框架中的一个接口，用于拦截请求的处理过程，允许在请求处理前（preHandle）、请求处理后（postHandle）、以及视图渲染后（afterCompletion）执行一些额外的操作。它是 Spring MVC 框架中拦截器的基础接口。

---------------------------
HandlerMethod 是 Spring MVC 框架中的一个类，用于表示处理请求的方法。它实际上是一个包装了方法相关信息的类，包括了处理请求的 Controller 类、处理请求的方法、以及方法的一些属性和注解等信息。


```java
@ConfigurationProperties("xc")
public class AuthConfigure {
    private Map<String, AuthConfigure.Configure> auth;

    public AuthConfigure.Configure getConfigureByClient(String client) {
        return (AuthConfigure.Configure)Optional.ofNullable(this.auth.get(client)).orElseThrow(() -> {
            return new XcServiceException("未找到配置");
        });
    }

    public AuthConfigure() {
    }

    public Map<String, AuthConfigure.Configure> getAuth() {
        return this.auth;
    }

    public void setAuth(Map<String, AuthConfigure.Configure> auth) {
        this.auth = auth;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AuthConfigure)) {
            return false;
        } else {
            AuthConfigure other = (AuthConfigure)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$auth = this.getAuth();
                Object other$auth = other.getAuth();
                if (this$auth == null) {
                    if (other$auth != null) {
                        return false;
                    }
                } else if (!this$auth.equals(other$auth)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof AuthConfigure;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $auth = this.getAuth();
        int result = result * 59 + ($auth == null ? 43 : $auth.hashCode());
        return result;
    }

    public String toString() {
        return "AuthConfigure(auth=" + this.getAuth() + ")";
    }

    public static class Configure {
        private List<String> path = Lists.newArrayList(new String[]{"/**"});
        private Set<String> excludePath;
        private String tokenName;
        private Duration expires;
        private Duration userCacheExpires;
        private int allowedOnline;

        public Configure() {
            this.excludePath = Sets.newHashSet(AuthConstant.BASE_EXCLUDE_PATH);
            this.tokenName = "X-Token";
            this.expires = Duration.ofHours(2L);
            this.userCacheExpires = Duration.ofMinutes(30L);
            this.allowedOnline = 0;
        }

        public List<String> getPath() {
            return this.path;
        }

        public Set<String> getExcludePath() {
            return this.excludePath;
        }

        public String getTokenName() {
            return this.tokenName;
        }

        public Duration getExpires() {
            return this.expires;
        }

        public Duration getUserCacheExpires() {
            return this.userCacheExpires;
        }

        public int getAllowedOnline() {
            return this.allowedOnline;
        }

        public void setPath(List<String> path) {
            this.path = path;
        }

        public void setExcludePath(Set<String> excludePath) {
            this.excludePath = excludePath;
        }

        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }

        public void setExpires(Duration expires) {
            this.expires = expires;
        }

        public void setUserCacheExpires(Duration userCacheExpires) {
            this.userCacheExpires = userCacheExpires;
        }

        public void setAllowedOnline(int allowedOnline) {
            this.allowedOnline = allowedOnline;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof AuthConfigure.Configure)) {
                return false;
            } else {
                AuthConfigure.Configure other = (AuthConfigure.Configure)o;
                if (!other.canEqual(this)) {
                    return false;
                } else if (this.getAllowedOnline() != other.getAllowedOnline()) {
                    return false;
                } else {
                    label73: {
                        Object this$path = this.getPath();
                        Object other$path = other.getPath();
                        if (this$path == null) {
                            if (other$path == null) {
                                break label73;
                            }
                        } else if (this$path.equals(other$path)) {
                            break label73;
                        }

                        return false;
                    }

                    Object this$excludePath = this.getExcludePath();
                    Object other$excludePath = other.getExcludePath();
                    if (this$excludePath == null) {
                        if (other$excludePath != null) {
                            return false;
                        }
                    } else if (!this$excludePath.equals(other$excludePath)) {
                        return false;
                    }

                    label59: {
                        Object this$tokenName = this.getTokenName();
                        Object other$tokenName = other.getTokenName();
                        if (this$tokenName == null) {
                            if (other$tokenName == null) {
                                break label59;
                            }
                        } else if (this$tokenName.equals(other$tokenName)) {
                            break label59;
                        }

                        return false;
                    }

                    Object this$expires = this.getExpires();
                    Object other$expires = other.getExpires();
                    if (this$expires == null) {
                        if (other$expires != null) {
                            return false;
                        }
                    } else if (!this$expires.equals(other$expires)) {
                        return false;
                    }

                    Object this$userCacheExpires = this.getUserCacheExpires();
                    Object other$userCacheExpires = other.getUserCacheExpires();
                    if (this$userCacheExpires == null) {
                        if (other$userCacheExpires != null) {
                            return false;
                        }
                    } else if (!this$userCacheExpires.equals(other$userCacheExpires)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof AuthConfigure.Configure;
        }

        public int hashCode() {
            int PRIME = true;
            int result = 1;
            int result = result * 59 + this.getAllowedOnline();
            Object $path = this.getPath();
            result = result * 59 + ($path == null ? 43 : $path.hashCode());
            Object $excludePath = this.getExcludePath();
            result = result * 59 + ($excludePath == null ? 43 : $excludePath.hashCode());
            Object $tokenName = this.getTokenName();
            result = result * 59 + ($tokenName == null ? 43 : $tokenName.hashCode());
            Object $expires = this.getExpires();
            result = result * 59 + ($expires == null ? 43 : $expires.hashCode());
            Object $userCacheExpires = this.getUserCacheExpires();
            result = result * 59 + ($userCacheExpires == null ? 43 : $userCacheExpires.hashCode());
            return result;
        }

        public String toString() {
            return "AuthConfigure.Configure(path=" + this.getPath() + ", excludePath=" + this.getExcludePath() + ", tokenName=" + this.getTokenName() + ", expires=" + this.getExpires() + ", userCacheExpires=" + this.getUserCacheExpires() + ", allowedOnline=" + this.getAllowedOnline() + ")";
        }
    }
}

```
```java
package fun.fan.xc.plugin.auth;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 用户认证字典
 *
 * @author fan
 */
public class AuthConstant {
    /**
     * 用户缓存前缀
     */
    public static final String USER_PREFIX = "auth:user:%s:%s";
    public static final String TOKEN_PREFIX = "auth:token:";
    public static final String PERMISSION_PREFIX = "auth:permission:%s:%s";
    public static final String DEFAULT_CLIENT = "default";
    /**
     * 基础放行路径
     */
    public static final List<String> BASE_EXCLUDE_PATH = Lists.newArrayList("/error",
            "/swagger-resources/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/doc.html");
}
```
```java
package fun.fan.xc.plugin.auth;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import fun.fan.xc.starter.exception.XcServiceException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author fan
 */
@Data
@ConfigurationProperties("xc")
public class AuthConfigure {
    private Map<String, Configure> auth;

    /**
     * 不同端获取相应的配置
     */
    public Configure getConfigureByClient(String client) {
        return Optional.ofNullable(auth.get(client)).orElseThrow(() -> new XcServiceException("未找到配置"));
    }

    @Data
    public static class Configure {
        /**
         * 需要拦截的请求路径
         */
        private List<String> path = Lists.newArrayList("/**");
        /**
         * 拦截器排除路径
         */
        private Set<String> excludePath = Sets.newHashSet(AuthConstant.BASE_EXCLUDE_PATH);
        /**
         * Token Header名
         */
        private String tokenName = "X-Token";
        /**
         * Token有效期，默认两小时
         */
        private Duration expires = Duration.ofHours(2);
        /**
         * 用户缓存时间，默认30分钟
         */
        private Duration userCacheExpires = Duration.ofMinutes(30);
        /**
         * 同时允许在线用户数, 0为不限制
         */
        private int allowedOnline = 0;
    }
}
```
```java
package fun.fan.xc.plugin.auth;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 管理端认证拦截器
 *
 * @author fan
 */
public interface XcAuthInterface {

    /**
     * 返回客户端名称
     */
    default String client() {
        return AuthConstant.DEFAULT_CLIENT;
    }

    /**
     * 获取token的方法
     *
     * @param request request
     * @return token
     */
    default String getToken(AuthConfigure.Configure configure, HttpServletRequest request) {
        return request.getHeader(configure.getTokenName());
    }

    /**
     * 通过Token换取account
     * @param token Token
     * @return account
     */
    default String getAccount(String token) {
        return null;
    }

    /**
     * 检查用户的有效性和权限
     *
     * @param user 待校验的用户对象
     * @return 校验结果
     */
    default boolean checkUser(XcBaseUser user) {
        return true;
    }

    /**
     * 获取客户端配置
     *
     * @return 配置对象
     */
    default AuthConfigure.Configure getConfigure(AuthConfigure configure) {
        return configure.getConfigureByClient(this.client());
    }

    /**
     * 获取权限列表
     *
     * @param user 当前用户
     * @return 权限列表
     */
    default Set<String> selectPermissions(XcBaseUser user) {
        return null;
    }

    /**
     * 通过accountId查询User对象服务
     *
     * @param account accountId
     * @return user对象
     */
    XcBaseUser select(String account);
}
```
```java
package fun.fan.xc.plugin.auth.interceptor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import fun.fan.xc.plugin.auth.*;
import fun.fan.xc.plugin.auth.annotation.AuthIgnore;
import fun.fan.xc.plugin.auth.annotation.AuthPermission;
import fun.fan.xc.plugin.redis.Redis;
import fun.fan.xc.starter.enums.ReturnCode;
import fun.fan.xc.starter.exception.XcServiceException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 管理端认证拦截器
 *
 * @author fan
 */
@Slf4j
@RequiredArgsConstructor //使用 @RequiredArgsConstructor 注解表示通过构造函数进行依赖注入。
public class BaseAuthInterceptor implements HandlerInterceptor {
    private final Redis redis;
    private final AuthUtil authUtil;
    private final AuthConfigure authConfigure;
    private final XcAuthInterface xcAuthInterface;

    //HandlerInterceptor 接口的 preHandle 方法在处理请求之前被调用。
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod hm = (HandlerMethod) handler;
        // 判断接口是否需要做登录校验
        AuthIgnore authIgnore = hm.getMethodAnnotation(AuthIgnore.class);
        //获取实例，为什么使用静态内部类？
        AuthConfigure.Configure configure = xcAuthInterface.getConfigure(authConfigure);

        //客户端
        String client = xcAuthInterface.client();
        // Token校验
        String token = xcAuthInterface.getToken(configure, request);
        if (StrUtil.isBlank(token)) {
            return checkIgnore(authIgnore);
        }
        //根据token构造key,在缓存中获取用户ID
        String account = redis.get(AuthConstant.TOKEN_PREFIX + token);
        if (StrUtil.isBlank(account)) {
            return checkIgnore(authIgnore);
        }
        try {
            // 获取用户信息
            String key = String.format(AuthConstant.USER_PREFIX, client, account);
            
            XcBaseUser user = redis.getOrLoadEx(key, configure.getUserCacheExpires().getSeconds(), TimeUnit.SECONDS, () -> xcAuthInterface.select(account));
            Assert.isTrue(xcAuthInterface.checkUser(user), "用户异常");
            //在这里将user信息存入ThreadLocal
            AuthLocal.setUser(user);
            //续期token,调用xcRedisTemplate.expire实现
            authUtil.updateToken(token, client);

            // 权限校验
            AuthPermission annotation = hm.getMethodAnnotation(AuthPermission.class);
            if (Objects.isNull(annotation)) {
                return true;
            }
            String[] role = annotation.role();
            if (ArrayUtil.isNotEmpty(role) && !checkRoles(user, role)) {
                throw new XcServiceException(ReturnCode.FORBIDDEN);
            }
            String[] permission = annotation.permission();
            return checkPermissions(user, permission);
        } catch (IllegalArgumentException e) {
            log.error("read user info failed", e);
            return checkIgnore(authIgnore);
        }
    }

    //实现了 HandlerInterceptor 接口的 afterCompletion 方法，该方法在请求完成之后（视图渲染之后）被调用。
    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        AuthLocal.clearUser();
    }

    private boolean checkIgnore(AuthIgnore authIgnore) {
        if (Objects.nonNull(authIgnore)) {
            return true;
        } else {
            throw new XcServiceException(ReturnCode.UNAUTHORIZED);
        }
    }


    /**
     * 角色校验
     *
     * @param user  待校验的用户
     * @param roles 需要判断的角色列表
     * @return 校验结果
     */
    public boolean checkRoles(XcBaseUser user, String... roles) {
        if (Objects.isNull(user) || CollUtil.isEmpty(user.getRoles())) {
            return false;
        }
        if (Objects.isNull(roles) || roles.length == 0) {
            return false;
        }
        Collection<String> c = user.getRoles();
        return Arrays.stream(roles).anyMatch(c::contains);
    }

    /**
     * 校验权限
     *
     * @param user       待校验的用户
     * @param permission 需要判断的权限列表
     * @return 校验结果
     */
    public boolean checkPermissions(XcBaseUser user, String... permission) {
        if (Objects.isNull(permission) || permission.length == 0) {
            return false;
        }
        String client = Optional.ofNullable(user.getClient()).orElse(AuthConstant.DEFAULT_CLIENT);
        // 查询用户权限
        String key = String.format(AuthConstant.PERMISSION_PREFIX, user.getClient(), user.getAccount());
        if (!redis.exists(key)) {
            AuthConfigure.Configure configure = authConfigure.getConfigureByClient(client);
            Set<String> permissions = Optional.ofNullable(xcAuthInterface.selectPermissions(user)).orElse(new HashSet<>());
            redis.sAddEx(key, configure.getExpires().getSeconds(), TimeUnit.SECONDS, permissions.toArray());
        }
        return redis.sIsMember(key, permission);
    }
}
```