package slack.springbootslackapptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slack.springbootslackapptest.service.SlackService;

@RestController
@RequestMapping("/api/slack")
@RequiredArgsConstructor
public class SlackApiController {
    private final SlackService slackService;

    @GetMapping("/notify")
    public String sendSlackNotification() {
        slackService.sendMessage("spring boot slack api test: 김준하");
        return "success";
    }
}
