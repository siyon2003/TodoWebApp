//package coding_maverick.todo_webapp.filters;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Component
////@Order(10000000)
//public class SampleLoggingAfterHeader extends OncePerRequestFilter {
//
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        Collections.list(request.getHeaderNames())
////                .forEach(header -> logger.info("Header Name is {} and Header value is {}", header, request.getHeader(header)));
//        // Passing request down the filter
//        logger.info("Sample log after header logging");
//        filterChain.doFilter(request, response);
//    }
//}
