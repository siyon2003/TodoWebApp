package coding_maverick.todo_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoWebappApplication.class, args);
    }

//	@Bean
//	FilterRegistrationBean<SampleLoggingAfterHeader> mySampleLoggingFilter(SampleLoggingAfterHeader sampleLoggingAfterHeader) {
//		FilterRegistrationBean<SampleLoggingAfterHeader> sampleLoggingAfterHeaderFilterRegistrationBean = new FilterRegistrationBean<>(sampleLoggingAfterHeader);
//		sampleLoggingAfterHeaderFilterRegistrationBean.setOrder(-1);
//		sampleLoggingAfterHeaderFilterRegistrationBean.setName("batmanBegins");
//		sampleLoggingAfterHeaderFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/abc/*"));
//		return sampleLoggingAfterHeaderFilterRegistrationBean;
//	};

    // Client req -> Tomcat server container -> Filter chain (No of filters) -> Dispatcher servlet -> Controller


}
