import org.springframework.http.converter.ByteArrayHttpMessageConverter
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter
import org.springframework.http.converter.xml.SourceHttpMessageConverter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

// Place your Spring DSL code here
beans = {
//    xmlns task:"http://www.springframework.org/schema/task"
//
//    task.'annotation-driven'


    annotationHandlerAdapter(RequestMappingHandlerAdapter){
        messageConverters = [
                new StringHttpMessageConverter(writeAcceptCharset: false),
                new ByteArrayHttpMessageConverter(),
                new FormHttpMessageConverter(),
                new SourceHttpMessageConverter(),
                new MappingJacksonHttpMessageConverter()
        ]
    }

}
