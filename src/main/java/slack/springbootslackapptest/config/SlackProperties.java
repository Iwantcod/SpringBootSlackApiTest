package slack.springbootslackapptest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.slack")
public record SlackProperties(Bot bot, String channel) {
    public record Bot(String token) {}
}
