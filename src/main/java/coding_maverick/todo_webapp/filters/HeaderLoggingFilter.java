//package coding_maverick.todo_webapp.filters;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Component
//@Order(0)
//public class HeaderLoggingFilter extends OncePerRequestFilter {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        Collections.list(request.getHeaderNames())
//                .forEach(header -> logger.info("Header Name is {} and Header value is {}", header, request.getHeader(header)));
//        // Passing request down the filter
//        filterChain.doFilter(request,response);
//    }
//}
//
// Delegating Filter proxy -> Filter proxy chain -> Security filter chain