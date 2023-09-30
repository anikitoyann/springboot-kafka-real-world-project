package com.example;
import com.example.entity.Wikimedia;
import com.example.repository.WikimediaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {
    private final WikimediaRepository wikimediaRepository;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessage) {
        log.info(String.format("Message received %s ",eventMessage));
        Wikimedia wikimediaData=new Wikimedia();
        wikimediaData.setEventData(eventMessage);
        wikimediaRepository.save(wikimediaData);
    }
}
