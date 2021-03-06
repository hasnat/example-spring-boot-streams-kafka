package br.com.danielhatanaka.resource.processor;

import br.com.danielhatanaka.mapper.UserMapper;
import br.com.danielhatanaka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessorController {

    @Autowired
    private UserOutput userOutput;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/processor")
    public void processor() {
        User user = User.builder().name("name").lastName("lastName").build();
        userOutput.output().send(MessageBuilder.withPayload(user)
                .build());
    }
}
