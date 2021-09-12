package contacts.commands;

import java.io.IOException;

public interface Command {
    void execute(String action) throws IOException;
}
