package slack.springbootslackapptest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import slack.springbootslackapptest.config.SlackProperties;

@Service
public class SlackServiceImpl implements SlackService {
    private final WebClient webClient;
//    private String slackBotToken;
//    private String slackChannel;
    private final SlackProperties slackProperties;
    @Autowired
    public SlackServiceImpl(SlackProperties slackProperties) {
        this.webClient = WebClient.builder()
                .baseUrl("https://slack.com/api")
                .defaultHeader("Content-Type", "application/json; charset=utf-8")
                .build();
        this.slackProperties = slackProperties;
    }
    @Override
    public void sendMessage(String message) {
        sendMessageToChannel(message);
    }

    public void sendMessageToChannel(String message) {
        String jsonMsg = String.format(
            """
            {
                "channel" : "%s",
                "text" : "%s"
            }
            """,
            slackProperties.channel(),
            message
        );
        // slack은 post 전송이 규칙
        webClient.post()
                .uri("/chat.postMessage")
                .header("Authorization", "Bearer " + slackProperties.bot().token())
                .bodyValue(jsonMsg)
                .retrieve() // 응답 예외 처리 설정
                .bodyToMono(String.class) // 응답을 단일 string 으로 변환
                .doOnSuccess(res -> System.out.println("Slack Response: " + res)) // 성공
                .doOnError(err -> System.out.println("slack Error: " + err.getMessage())) // 실패
                .subscribe();
    }
}
