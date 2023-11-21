# SpringBoot In Action

## Spring Security
### 1. Spring Security在Servlet身份验证中使用的主要架构组件-Servlet Authentication Architecture
![authenticationArchitecture.jpeg](src%2Fmain%2Fresources%2Freadme%2FauthenticationArchitecture.jpeg)

Servlet身份验证中使用的Spring Security的主要架构组件。如果需要解释这些部件如何结合在一起的具体流程，请查看身份验证机制的特定部分。

+ SecurityContextHolder:
SecurityContextHolder 是 Spring Security 用于存储已经通过身份验证的用户详细信息的地方。它包含了 SecurityContext。
+ SecurityContext:
SecurityContext 从 SecurityContextHolder 获取，其中包含当前经过身份验证的用户的身份验证信息。
+ Authentication:
Authentication 可以是传递给 AuthenticationManager 的输入，用于提供用户提供的身份验证凭据，也可以是从 SecurityContext 获取的当前用户的身份验证信息。
+ GrantedAuthority:
GrantedAuthority 是授予主体的权限，通常是角色、范围等。可以从 Authentication.getAuthorities() 方法获取 GrantedAuthority 实例的集合。
+ AuthenticationManager:
AuthenticationManager 是定义 Spring Security 过滤器执行身份验证的 API。它负责处理身份验证请求，并返回经过身份验证的 Authentication 对象。
+ ProviderManager:
ProviderManager 是 AuthenticationManager 的最常见实现。它委托给一组 AuthenticationProvider 实例，每个提供程序负责执行特定类型的身份验证。
+ AuthenticationProvider:
AuthenticationProvider 由 ProviderManager 使用，用于执行特定类型的身份验证。每个提供程序知道如何执行一种特定类型的身份验证。
+ Request Credentials with AuthenticationEntryPoint:
AuthenticationEntryPoint 用于向客户端发送请求凭据的 HTTP 响应。它在客户端主动包含凭据（如用户名和密码）以请求资源时可能不需要提供请求凭据的情况下使用。
+ AbstractAuthenticationProcessingFilter:
AbstractAuthenticationProcessingFilter 是用于对用户凭据进行身份验证的基本过滤器。在凭据能够得到验证之前，Spring Security通常通过使用 AuthenticationEntryPoint 来请求凭据。AbstractAuthenticationProcessingFilter 可以验证提交给它的任何身份验证请求。
这些组件共同构成了Spring Security身份验证的主要架构，提供了强大的身份验证和授权机制，用于保护应用程序中的资源。


```java
@Configuration
@EnableWebSecurity
public class FilterConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new MyFilter(), AuthorizationFilter.class)
                .authorizeHttpRequests(s -> s.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("wwinter")
                .password("123456")
                .roles("ROOT")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}

@WebFilter("/*")
@Component
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("SecurityContext: " + context.toString());
        Authentication authentication = context.getAuthentication();
        System.out.println("Authentication: " + authentication.toString());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("GrantedAuthority: " + authorities.toString());
        filterChain.doFilter(request, response);
    }
}
```

**未登录时打印请求信息：**

SecurityContext: 
+ SecurityContextImpl [Authentication=AnonymousAuthenticationToken [Principal=anonymousUser, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ROLE_ANONYMOUS]]]

Authentication: 
+ AnonymousAuthenticationToken [Principal=anonymousUser, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ROLE_ANONYMOUS]]

GrantedAuthority: 
+ [ROLE_ANONYMOUS]

**使用username=wwinter，password=123456登陆后打印请求信息：**

SecurityContext:
    - SecurityContextImpl 
+ [Authentication=UsernamePasswordAuthenticationToken [Principal=org.springframework.security.core.userdetails.User [Username=wwinter, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ROLE_ROOT]], Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=198BC0B1D9BC78E53315047F72F8FD17], Granted Authorities=[ROLE_ROOT]]]

Authentication:
    - UsernamePasswordAuthenticationToken 
+ Principal=org.springframework.security.core.userdetails.User [Username=wwinter, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ROLE_ROOT]], 
+ Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=198BC0B1D9BC78E53315047F72F8FD17], 
+ Granted Authorities=[ROLE_ROOT]]

GrantedAuthority:
+ [ROLE_ROOT]