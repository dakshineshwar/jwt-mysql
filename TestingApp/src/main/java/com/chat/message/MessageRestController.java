package com.chat.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/message")
public class MessageRestController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{messageId}")
    public Message findOne(@PathVariable Long messageId) {
        return messageRepository.findOne(messageId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Message add(@RequestBody Message message) {
        return messageRepository.save(message);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Message update(@RequestBody Message message) {
        return messageRepository.save(message);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{messageId}")
    public void delete(@PathVariable Long messageId) {
        messageRepository.delete(messageId);
    }
	
}

