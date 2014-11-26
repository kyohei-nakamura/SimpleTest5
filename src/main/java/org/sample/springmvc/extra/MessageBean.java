package org.sample.springmvc.extra;

import java.util.stream.Stream;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mb")
@Scope("request")
public class MessageBean {
    @NotEmpty
    @Size(min=5)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public MessageBean() {
//        Exception ex = new Exception();
//        Stream.of(ex.getStackTrace()).forEach(System.out::println);
        System.out.println("Constractor: "+this);
    }
}
