package greedzzz.notetakingapp.ui;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class ShellPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString(">");
    }
}
